package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.imcore.proxy.basic.StatisticCollectorProxy;
import com.tencent.mobileqq.imcore.proxy.msg.b;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.FindTransaction;
import com.tencent.mobileqq.persistence.transaction.QueryTransaction;
import com.tencent.mobileqq.persistence.transaction.RawQueryTransaction;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.inject.MqqInjectorManager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class EntityManager {
    private static final String CLOSE_EXCEPTION_MSG = "The EntityManager has been already closed";
    public static final String EVENT_MONITOR_MR_WRITE = "mr_write_monitor_event";
    public static final String KEY_FRIEND_UIN = "friend_uin";
    public static final String KEY_IS_TROOP = "is_troop";
    public static final String KEY_OPERATE_TYPE = "operate_type";
    public static final String KEY_STACK = "stack";
    public static final String KEY_TABLE_NAME = "table_name";
    public static final int QUERY_CACHE_TYPE_MULTI_CONTDITION = 1;
    public static final int QUERY_CACHE_TYPE_SELECT_ALL = 2;
    public static final int QUERY_CACHE_TYPE_SELECT_WHEHRE_SELECTION = 3;
    static final String SQL = "EntityManager";
    private static final int STACK_MAX_LEVEL = 20;
    private static final Map<String, Boolean> createTableCache = new ConcurrentHashMap();
    private static final Set<String> droppedTable = Collections.synchronizedSet(new HashSet());

    /* renamed from: db, reason: collision with root package name */
    private SQLiteDatabase f258304db;
    SQLiteOpenHelper dbHelper;
    private String mName;
    private ConcurrentHashMap<String, String> mQueryAllCache = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, ConcurrentHashMap<String, String>> mTableMap = new ConcurrentHashMap<>();
    private EntityTransaction transaction;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EntityManager(SQLiteOpenHelper sQLiteOpenHelper, String str) {
        this.dbHelper = sQLiteOpenHelper;
        this.mName = str;
    }

    private void assignCursorValueByField(Cursor cursor, Entity entity, Field field, Class cls, int i3) throws IllegalAccessException {
        boolean z16 = true;
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        if (cls == Long.TYPE) {
            field.set(entity, Long.valueOf(cursor.getLong(i3)));
            return;
        }
        if (cls == Integer.TYPE) {
            field.set(entity, Integer.valueOf(cursor.getInt(i3)));
            return;
        }
        if (cls == String.class) {
            field.set(entity, cursor.getString(i3));
            return;
        }
        if (cls == Byte.TYPE) {
            field.set(entity, Byte.valueOf((byte) cursor.getShort(i3)));
            return;
        }
        if (cls == byte[].class) {
            field.set(entity, cursor.getBlob(i3));
            return;
        }
        if (cls == Short.TYPE) {
            field.set(entity, Short.valueOf(cursor.getShort(i3)));
            return;
        }
        if (cls == Boolean.TYPE) {
            if (cursor.getInt(i3) == 0) {
                z16 = false;
            }
            field.set(entity, Boolean.valueOf(z16));
        } else if (cls == Float.TYPE) {
            field.set(entity, Float.valueOf(cursor.getFloat(i3)));
        } else if (cls == Double.TYPE) {
            field.set(entity, Double.valueOf(cursor.getDouble(i3)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void assignEntityFieldsValue(Cursor cursor, NoColumnErrorHandler noColumnErrorHandler, Entity entity) throws IllegalAccessException {
        Entity cursor2Entity;
        List<Field> validField = TableBuilder.getValidField(entity);
        int size = validField.size();
        for (int i3 = 0; i3 < size; i3++) {
            Field field = validField.get(i3);
            Class<?> type = field.getType();
            if (Entity.class.isAssignableFrom(type) && (cursor2Entity = cursor2Entity(type, cursor)) != null) {
                cursor2Entity._status = 1002;
                field.set(entity, cursor2Entity);
            }
            String name = field.getName();
            int columnIndex = cursor.getColumnIndex(name);
            if (columnIndex != -1) {
                assignCursorValueByField(cursor, entity, field, type, columnIndex);
            } else if (noColumnErrorHandler != null) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError(name, type));
            }
        }
    }

    private String createStackString(Throwable th5) {
        StringBuilder sb5 = new StringBuilder();
        StackTraceElement[] stackTrace = th5.getStackTrace();
        int min = Math.min(20, stackTrace.length);
        for (int i3 = 0; i3 < min; i3++) {
            sb5.append(stackTrace[i3]);
            sb5.append("\n");
        }
        return sb5.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean createTable(String str, Entity entity, boolean z16) {
        boolean z17;
        String cacheKeyFromTableName = getCacheKeyFromTableName(str);
        if (!z16) {
            Map<String, Boolean> map = createTableCache;
            if (map.containsKey(cacheKeyFromTableName)) {
                z17 = map.get(cacheKeyFromTableName).booleanValue();
                if (!z17) {
                    if (this.f258304db == null) {
                        this.f258304db = this.dbHelper.getWritableDatabase();
                    }
                    if (this.f258304db == null && MqqInjectorManager.instance().isPublicVersion()) {
                        return false;
                    }
                    z17 = this.f258304db.execSQL(TableBuilder.createSQLStatement(entity));
                    String createIndexSQLStatement = TableBuilder.createIndexSQLStatement(entity);
                    if (createIndexSQLStatement != null) {
                        this.f258304db.execSQL(createIndexSQLStatement);
                    }
                    createTableCache.put(cacheKeyFromTableName, Boolean.valueOf(z17));
                    if (z17) {
                        this.f258304db.addToTableCache(str);
                    }
                }
                return z17;
            }
        }
        z17 = false;
        if (!z17) {
        }
        return z17;
    }

    private String getCacheKeyFromTableName(String str) {
        if (this.mName != null) {
            return this.mName + "_" + str;
        }
        return str;
    }

    private long getEntityId(Cursor cursor) {
        try {
            int columnIndex = cursor.getColumnIndex("_id");
            if (columnIndex < 0) {
                return -1L;
            }
            return cursor.getLong(columnIndex);
        } catch (Exception e16) {
            QLog.d(SQL, 1, e16, new Object[0]);
            return -1L;
        }
    }

    private void monitorDeprecatedTableWrite(Entity entity, String str) {
        String currentUin;
        b.a a16 = com.tencent.mobileqq.imcore.proxy.msg.b.a(entity);
        if (a16 == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            currentUin = "";
        } else {
            currentUin = peekAppRuntime.getCurrentUin();
        }
        String str2 = currentUin;
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_TABLE_NAME, entity.getTableName());
        hashMap.put("is_troop", String.valueOf(a16.f238039a));
        hashMap.put("friend_uin", a16.f238040b);
        hashMap.put("stack", createStackString(new Throwable()));
        hashMap.put(KEY_OPERATE_TYPE, str);
        StatisticCollectorProxy.collectPerformance(str2, EVENT_MONITOR_MR_WRITE, false, 0L, 0L, hashMap, "");
        if (QLog.isColorLevel()) {
            QLog.d(SQL, 2, "monitorDeprecatedTableWrite report info :" + hashMap);
        }
    }

    private Cursor queryInner(boolean z16, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, int i3) {
        try {
            if (tabbleIsExist(str)) {
                return this.dbHelper.getReadableDatabase().query(str, strArr, str2, strArr2, str5, str6);
            }
            return null;
        } catch (Exception e16) {
            QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e16));
            return null;
        }
    }

    public int count(Class<? extends Entity> cls, String str, String[] strArr) {
        try {
            String tableName = TableBuilder.getTableName(cls);
            if (tabbleIsExist(tableName)) {
                return this.dbHelper.getReadableDatabase().count(tableName, str, strArr);
            }
            return 0;
        } catch (Exception e16) {
            QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e16));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ContentValues createContentValue(Entity entity) throws IllegalArgumentException, IllegalAccessException {
        ContentValues createContentValues = entity.createContentValues();
        if (createContentValues != null) {
            return createContentValues;
        }
        List<Field> validField = TableBuilder.getValidField(entity.getClassForTable());
        int size = validField.size();
        ContentValues contentValues = new ContentValues(size);
        for (int i3 = 0; i3 < size; i3++) {
            Field field = validField.get(i3);
            String name = field.getName();
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj = field.get(entity);
            filterContentValueLoopInnerLog(entity, name, obj);
            if (obj instanceof Integer) {
                contentValues.put(name, (Integer) obj);
            } else if (obj instanceof Long) {
                contentValues.put(name, (Long) obj);
            } else if (obj instanceof String) {
                contentValues.put(name, (String) obj);
            } else if (obj instanceof byte[]) {
                contentValues.put(name, (byte[]) obj);
            } else if (obj instanceof Short) {
                contentValues.put(name, (Short) obj);
            } else {
                boolean z16 = obj instanceof Boolean;
                if (z16) {
                    contentValues.put(name, (Boolean) obj);
                } else if (obj instanceof Double) {
                    contentValues.put(name, (Double) obj);
                } else if (obj instanceof Float) {
                    contentValues.put(name, (Float) obj);
                } else if (obj instanceof Byte) {
                    contentValues.put(name, (Byte) obj);
                } else if (z16) {
                    contentValues.put(name, (Boolean) obj);
                }
            }
        }
        filterContentValueLoopOuterLog(entity);
        return contentValues;
    }

    public Entity cursor2Entity(Class<? extends Entity> cls, Cursor cursor) {
        try {
            return cursor2Entity(cls, TableBuilder.getTableName(cls), cursor);
        } catch (Exception unused) {
            return null;
        }
    }

    public List<? extends Entity> cursor2List(Class<? extends Entity> cls, String str, Cursor cursor) {
        return cursor2List(cls, str, cursor, null);
    }

    public int delete(String str, String str2, String[] strArr) {
        return this.dbHelper.getWritableDatabase().delete(str, str2, strArr);
    }

    public Entity doFindOperateByTransaction(FindTransaction findTransaction) {
        Entity entity;
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        try {
            try {
                entity = findTransaction.doFindOperate(this);
                try {
                    transaction.commit();
                } catch (Exception e16) {
                    e = e16;
                    QLog.e(SQL, 1, "doFindOperateByTransaction error: ", e);
                    return entity;
                }
            } catch (Exception e17) {
                e = e17;
                entity = null;
            }
            return entity;
        } finally {
            transaction.end();
        }
    }

    public boolean doMultiDBOperateByTransaction(List<BaseTransaction> list) {
        EntityTransaction transaction = getTransaction();
        try {
            try {
                transaction.begin();
                Iterator<BaseTransaction> it = list.iterator();
                while (it.hasNext()) {
                    it.next().doDBOperate(this);
                }
                transaction.commit();
                return true;
            } catch (Exception e16) {
                QLog.e(SQL, 1, "doMultiDBOperateByTransaction error: ", e16);
                transaction.end();
                return false;
            }
        } finally {
            transaction.end();
        }
    }

    public Cursor doQueryCursorOperateByTransaction(QueryTransaction queryTransaction) {
        Cursor cursor;
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        try {
            try {
                cursor = queryTransaction.doQueryCursorOperate(this);
                try {
                    transaction.commit();
                } catch (Exception e16) {
                    e = e16;
                    QLog.e(SQL, 1, "doQueryCursorOperateByTransaction error: ", e);
                    return cursor;
                }
            } catch (Exception e17) {
                e = e17;
                cursor = null;
            }
            return cursor;
        } finally {
            transaction.end();
        }
    }

    public List<? extends Entity> doQueryEntityListOperateByTransaction(QueryTransaction queryTransaction) {
        List<? extends Entity> arrayList = new ArrayList<>();
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        try {
            try {
                arrayList = queryTransaction.doQueryEntityListOperate(this);
                transaction.commit();
            } catch (Exception e16) {
                QLog.e(SQL, 1, "doQueryEntityListOperateByTransaction error: ", e16);
            }
            return arrayList;
        } finally {
            transaction.end();
        }
    }

    public List<? extends Entity> doRawQueryOperateByTransaction(RawQueryTransaction rawQueryTransaction) {
        List<? extends Entity> arrayList = new ArrayList<>();
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        try {
            try {
                arrayList = rawQueryTransaction.doRawQueryOperate(this);
                transaction.commit();
            } catch (Exception e16) {
                QLog.e(SQL, 1, "doRawQueryOperateByTransaction error: ", e16);
            }
            return arrayList;
        } finally {
            transaction.end();
        }
    }

    public boolean drop(Class<? extends Entity> cls) {
        if (this.f258304db == null) {
            this.f258304db = this.dbHelper.getWritableDatabase();
        }
        try {
            String tableName = TableBuilder.getTableName(cls);
            this.f258304db.execSQL("DROP TABLE IF EXISTS " + tableName);
            if (droppedTable.add(tableName)) {
                QLog.d(SQL, 1, "dropTable, tableName=" + tableName);
            }
            createTableCache.remove(getCacheKeyFromTableName(tableName));
            this.f258304db.removeFromTableCache(tableName);
            return true;
        } catch (Exception e16) {
            QLog.e(SQL, 1, "drop table error: ", e16);
            return false;
        }
    }

    public boolean execSQL(String str) {
        try {
            this.dbHelper.getReadableDatabase().execSQL(str);
            return true;
        } catch (Exception e16) {
            QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e16));
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Entity find(Class<? extends Entity> cls, String str) {
        List<? extends Entity> list;
        List<Field> validField = TableBuilder.getValidField(cls);
        int size = validField.size();
        for (int i3 = 0; i3 < size; i3++) {
            Field field = validField.get(i3);
            if (field.isAnnotationPresent(unique.class)) {
                try {
                    list = queryInner(cls, TableBuilder.getTableName(cls), false, field.getName() + "=?", new String[]{str}, null, null, null, null, null, 3);
                } catch (IllegalAccessException e16) {
                    e16.printStackTrace();
                    list = null;
                    return list != null ? null : null;
                } catch (InstantiationException e17) {
                    e17.printStackTrace();
                    list = null;
                    if (list != null) {
                    }
                }
                if (list != null && list.size() > 0) {
                    return list.get(0);
                }
            }
        }
        return null;
    }

    public EntityTransaction getTransaction() {
        if (this.transaction == null) {
            this.transaction = new EntityTransaction(this.dbHelper);
        }
        return this.transaction;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Entity innerCreateEntity(d dVar, String str, Cursor cursor, NoColumnErrorHandler noColumnErrorHandler) {
        if (cursor.isBeforeFirst()) {
            cursor.moveToFirst();
        }
        long entityId = getEntityId(cursor);
        try {
            Entity a16 = dVar.a(cursor);
            if (a16 != null) {
                a16._id = entityId;
                if (!a16.entityByCursor(cursor)) {
                    assignEntityFieldsValue(cursor, noColumnErrorHandler, a16);
                }
                if (entityId != -1 && str != null) {
                    a16._status = 1001;
                } else {
                    a16._status = 1002;
                }
                a16.postRead();
            }
            return a16;
        } catch (Exception e16) {
            QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e16));
            return null;
        } catch (OutOfMemoryError e17) {
            QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e17));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void insertOrReplace(Entity entity, boolean z16) {
        long insert;
        if (this.f258304db == null) {
            this.f258304db = this.dbHelper.getWritableDatabase();
        }
        if (entity._status == 1000) {
            monitorDeprecatedTableWrite(entity, "insertOrReplace");
            String tableName = entity.getTableName();
            createTable(tableName, entity, false);
            entity.prewrite();
            try {
                ContentValues createContentValue = createContentValue(entity);
                if (z16) {
                    insert = this.f258304db.replace(tableName, null, createContentValue);
                } else {
                    insert = this.f258304db.insert(tableName, null, createContentValue);
                }
                if (insert == -1 && createTable(tableName, entity, true)) {
                    if (z16) {
                        insert = this.f258304db.replace(tableName, null, createContentValue);
                    } else {
                        insert = this.f258304db.insert(tableName, null, createContentValue);
                    }
                }
                if (insert != -1) {
                    entity._id = insert;
                    entity._status = 1001;
                } else {
                    QLog.e(SQL, 1, "replace or insert error with -1 " + z16);
                }
            } catch (Exception e16) {
                QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e16));
            }
            entity.postwrite();
        }
    }

    public boolean isOpen() {
        return true;
    }

    public void keepOnlyOne(Entity entity) {
        if (this.f258304db == null) {
            this.f258304db = this.dbHelper.getWritableDatabase();
        }
        String tableName = entity.getTableName();
        createTable(tableName, entity, false);
        entity.prewrite();
        try {
            ContentValues createContentValue = createContentValue(entity);
            this.f258304db.execSQL("delete from " + tableName);
            long insert = this.f258304db.insert(tableName, null, createContentValue);
            if (insert == -1 && createTable(tableName, entity, true)) {
                insert = this.f258304db.insert(tableName, null, createContentValue);
            }
            if (insert != -1) {
                entity._id = insert;
                entity._status = 1001;
            }
        } catch (Exception e16) {
            QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e16));
        }
        entity.postwrite();
    }

    public void persist(Entity entity) {
        if (MqqInjectorManager.instance().isPublicVersion()) {
            try {
                insertOrReplace(entity, false);
                return;
            } catch (Throwable th5) {
                QLog.e(SQL, 1, "persist error", th5);
                return;
            }
        }
        insertOrReplace(entity, false);
    }

    public void persistOrReplace(Entity entity) {
        if (MqqInjectorManager.instance().isPublicVersion()) {
            try {
                insertOrReplace(entity, true);
                return;
            } catch (Throwable th5) {
                QLog.e(SQL, 1, "persistOrReplace error", th5);
                return;
            }
        }
        insertOrReplace(entity, true);
    }

    public Cursor query(boolean z16, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        try {
            if (tabbleIsExist(str)) {
                return this.dbHelper.getReadableDatabase().query(str, strArr, str2, strArr2, str5, str6);
            }
            return null;
        } catch (Exception e16) {
            QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e16));
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        if (r6 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001a, code lost:
    
        if (r6 != null) goto L12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<? extends Entity> rawQuery(Class<? extends Entity> cls, String str, String[] strArr) {
        Cursor cursor;
        ?? r26 = 0;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        List<? extends Entity> list = null;
        try {
            try {
                cursor = this.dbHelper.getReadableDatabase().rawQuery(str, strArr);
                if (cursor != null) {
                    try {
                        list = cursor2List(cls, null, cursor);
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e));
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return list;
                    }
                }
            } catch (Exception e18) {
                e = e18;
                cursor = null;
            } catch (OutOfMemoryError e19) {
                e = e19;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (r26 != 0) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            r26 = str;
            if (r26 != 0) {
                r26.close();
            }
            throw th;
        }
    }

    public boolean remove(Entity entity) {
        if (this.f258304db == null) {
            this.f258304db = this.dbHelper.getWritableDatabase();
        }
        entity.prewrite();
        if (entity._status == 1001) {
            r2 = this.f258304db.delete(entity.getTableName(), "_id=?", new String[]{String.valueOf(entity._id)}) > 0;
            entity._status = 1003;
        }
        entity.postwrite();
        return r2;
    }

    public boolean tabbleIsExist(String str) {
        if (str == null) {
            return false;
        }
        if ("Sqlite_master".equalsIgnoreCase(str)) {
            return true;
        }
        SQLiteDatabase readableDatabase = this.dbHelper.getReadableDatabase();
        if (readableDatabase == null) {
            return false;
        }
        boolean containsTable = readableDatabase.containsTable(str);
        if (QLog.isDevelopLevel() && !containsTable) {
            QLog.d(SQL, 2, " TABLECACHE tabbleIsExist : tableName:", str, " isExist:", Boolean.valueOf(containsTable));
        }
        return containsTable;
    }

    public boolean update(Entity entity) {
        if (this.f258304db == null) {
            this.f258304db = this.dbHelper.getWritableDatabase();
        }
        entity.prewrite();
        try {
            int i3 = entity._status;
            if (i3 == 1001 || i3 == 1002) {
                ContentValues createContentValue = createContentValue(entity);
                filterExtensionInfoLog(entity, createContentValue);
                monitorDeprecatedTableWrite(entity, "update_entity");
                return this.f258304db.update(entity.getTableName(), createContentValue, "_id=?", new String[]{String.valueOf(entity._id)}) > 0;
            }
        } catch (Exception e16) {
            QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e16));
        }
        entity.postwrite();
        return false;
    }

    public Entity cursor2Entity(Class<? extends Entity> cls, String str, Cursor cursor) {
        return cursor2Entity(cls, str, cursor, null);
    }

    public List<? extends Entity> cursor2List(Class<? extends Entity> cls, String str, Cursor cursor, NoColumnErrorHandler noColumnErrorHandler) {
        ArrayList arrayList = null;
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    int count = cursor.getCount();
                    do {
                        Entity cursor2Entity = cursor2Entity(cls, str, cursor, noColumnErrorHandler);
                        if (cursor2Entity != null) {
                            if (arrayList == null) {
                                try {
                                    arrayList = new ArrayList(count);
                                } catch (Throwable unused) {
                                }
                            }
                            arrayList.add(cursor2Entity);
                        }
                    } while (cursor.moveToNext());
                }
            } catch (Exception e16) {
                QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e16));
            }
        }
        return arrayList;
    }

    public Entity cursor2Entity(Class<? extends Entity> cls, String str, Cursor cursor, NoColumnErrorHandler noColumnErrorHandler) {
        return innerCreateEntity(new e(cls), str, cursor, noColumnErrorHandler);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0034, code lost:
    
        if (r1 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0036, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004e, code lost:
    
        return r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<? extends Entity> queryInner(Class<? extends Entity> cls, String str, boolean z16, String str2, String[] strArr, String str3, String str4, String str5, String str6, NoColumnErrorHandler noColumnErrorHandler, int i3) {
        Cursor cursor;
        Cursor cursor2 = null;
        r11 = null;
        r11 = null;
        List<? extends Entity> list = null;
        try {
            cursor = query(z16, str, (String[]) null, str2, strArr, str3, str4, str5, str6);
            if (cursor != null) {
                try {
                    CursorOpt cursorOpt = new CursorOpt(cursor);
                    try {
                        list = cursor2List(cls, str, cursorOpt, noColumnErrorHandler);
                        cursor = cursorOpt;
                    } catch (Exception e16) {
                        e = e16;
                        cursor = cursorOpt;
                        try {
                            QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e));
                        } catch (Throwable th5) {
                            th = th5;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        cursor2 = cursorOpt;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                } catch (Throwable th7) {
                    th = th7;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e18) {
            e = e18;
            cursor = null;
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public List<? extends Entity> query(Class<? extends Entity> cls) {
        try {
            return queryInner(cls, TableBuilder.getTableName(cls), false, null, null, null, null, null, null, null, 2);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            return null;
        } catch (InstantiationException e17) {
            e17.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r4 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
    
        if (r4 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<? extends Entity> rawQuery(Class<? extends Entity> cls, String str, String str2, String str3, String[] strArr) {
        Cursor cursor;
        ?? r06 = 0;
        r0 = null;
        r0 = null;
        List<? extends Entity> list = null;
        try {
            try {
                cursor = this.dbHelper.getReadableDatabase().rawQuery(str, str2, str3, strArr);
                if (cursor != null) {
                    try {
                        list = cursor2List(cls, null, cursor);
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e));
                    }
                }
            } catch (Exception e17) {
                e = e17;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (r06 != 0) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            r06 = str;
            if (r06 != 0) {
                r06.close();
            }
            throw th;
        }
    }

    public boolean drop(String str) {
        if (this.f258304db == null) {
            this.f258304db = this.dbHelper.getWritableDatabase();
        }
        try {
            this.f258304db.execSQL("DROP TABLE IF EXISTS " + str);
            if (droppedTable.add(str)) {
                QLog.d(SQL, 1, "dropTable, tableName=" + str);
            }
            createTableCache.remove(getCacheKeyFromTableName(str));
            this.f258304db.removeFromTableCache(str);
            return true;
        } catch (SQLException e16) {
            QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e16));
            return false;
        }
    }

    public List<? extends Entity> query(Class<? extends Entity> cls, String str, boolean z16, String str2, String[] strArr, String str3, String str4, String str5, String str6) {
        return query(cls, str, z16, str2, strArr, str3, str4, str5, str6, null);
    }

    public boolean remove(Entity entity, String str, String[] strArr) {
        if (this.f258304db == null) {
            this.f258304db = this.dbHelper.getWritableDatabase();
        }
        entity.prewrite();
        if (entity._status == 1001) {
            r2 = this.f258304db.delete(entity.getTableName(), str, strArr) > 0;
            entity._status = 1003;
        }
        entity.postwrite();
        return r2;
    }

    public List<? extends Entity> query(Class<? extends Entity> cls, String str, boolean z16, String str2, String[] strArr, String str3, String str4, String str5, String str6, NoColumnErrorHandler noColumnErrorHandler) {
        return queryInner(cls, str, z16, str2, strArr, str3, str4, str5, str6, noColumnErrorHandler, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Entity find(Class<? extends Entity> cls, String... strArr) {
        List<? extends Entity> list;
        if (cls.isAnnotationPresent(uniqueConstraints.class)) {
            try {
                String[] split = ((uniqueConstraints) cls.getAnnotation(uniqueConstraints.class)).columnNames().split(",");
                StringBuffer stringBuffer = new StringBuffer();
                for (int i3 = 0; i3 < split.length; i3++) {
                    stringBuffer.append(split[i3]);
                    if (i3 == split.length - 1) {
                        stringBuffer.append("=?");
                    } else {
                        stringBuffer.append("=? and ");
                    }
                }
                try {
                    list = queryInner(cls, TableBuilder.getTableName(cls), false, stringBuffer.toString(), strArr, null, null, null, null, null, 3);
                } catch (IllegalAccessException e16) {
                    e16.printStackTrace();
                    list = null;
                    if (list != null) {
                    }
                } catch (InstantiationException e17) {
                    e17.printStackTrace();
                    list = null;
                    if (list != null) {
                    }
                }
                if (list != null) {
                    return list.get(0);
                }
                return null;
            } catch (IncompatibleClassChangeError e18) {
                e18.printStackTrace();
                return null;
            }
        }
        throw new IllegalStateException("No uniqueConstraints annotation in the Entity " + cls.getSimpleName());
    }

    public List<? extends Entity> query(Class<? extends Entity> cls, boolean z16, String str, String[] strArr, String str2, String str3, String str4, String str5) {
        try {
            return query(cls, TableBuilder.getTableName(cls), z16, str, strArr, str2, str3, str4, str5);
        } catch (Exception e16) {
            QLog.e(SQL, 1, "query Exception, table : " + cls);
            QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e16));
            return null;
        }
    }

    public boolean update(String str, ContentValues contentValues, String str2, String[] strArr) {
        try {
            this.f258304db = this.dbHelper.getWritableDatabase();
            if (UpgradeUtil.isDeprecatedTable(str)) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                String currentUin = peekAppRuntime == null ? "" : peekAppRuntime.getCurrentUin();
                HashMap hashMap = new HashMap();
                hashMap.put(KEY_TABLE_NAME, str);
                hashMap.put("stack", createStackString(new Throwable()));
                hashMap.put(KEY_OPERATE_TYPE, "update_table");
                StatisticCollectorProxy.collectPerformance(currentUin, EVENT_MONITOR_MR_WRITE, false, 0L, 0L, hashMap, "");
                if (QLog.isColorLevel()) {
                    QLog.d(SQL, 2, "monitorDeprecatedTableWrite report info :" + hashMap);
                }
            }
            return this.f258304db.update(str, contentValues, str2, strArr) > 0;
        } catch (Exception e16) {
            QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e16));
            return false;
        }
    }

    public void close() {
    }

    public boolean update(String str) {
        return update(str, null);
    }

    private void filterContentValueLoopOuterLog(Entity entity) {
    }

    public boolean update(String str, Object[] objArr) {
        try {
            SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
            this.f258304db = writableDatabase;
            if (objArr == null) {
                writableDatabase.execSQL(str);
            } else {
                writableDatabase.execSQL(str, objArr);
            }
            return false;
        } catch (Exception e16) {
            QLog.e(SQL, 1, MsfSdkUtils.getStackTraceString(e16));
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0034 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Entity find(Class<? extends Entity> cls, long j3) {
        List<? extends Entity> list;
        try {
            list = queryInner(cls, TableBuilder.getTableName(cls), false, "_id=?", new String[]{String.valueOf(j3)}, null, null, null, null, null, 3);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            list = null;
            if (list != null) {
            }
        } catch (InstantiationException e17) {
            e17.printStackTrace();
            list = null;
            if (list != null) {
            }
        }
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    public Entity find(Class<? extends Entity> cls, String str, String[] strArr) {
        List<? extends Entity> query = query(cls, true, str, strArr, null, null, null, "1");
        if (query != null) {
            return query.get(0);
        }
        return null;
    }

    private void filterExtensionInfoLog(Entity entity, ContentValues contentValues) {
    }

    private void filterContentValueLoopInnerLog(Entity entity, String str, Object obj) {
    }
}
