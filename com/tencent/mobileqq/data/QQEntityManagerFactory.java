package com.tencent.mobileqq.data;

import android.annotation.TargetApi;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.entitymanager.FindTableNameInterceptorChain;
import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.data.entitymanager.OnDBTableVerifyFailListener;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.data.entitymanager.QQDBErrorHandler;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.data.entitymanager.upgrade.IAfterDBUpgradeListener;
import com.tencent.mobileqq.data.entitymanager.upgrade.IOnDBUpgradeListener;
import com.tencent.mobileqq.imcore.proxy.basic.StatisticCollectorProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.inject.MqqInjectorManager;

/* compiled from: P */
@TargetApi(11)
/* loaded from: classes10.dex */
public class QQEntityManagerFactory extends EntityManagerFactory {
    public static final String CORRUPT_DATABASE_PATH = "/tencent/msflogs/corruptInfo";
    private static final String FIELD_CACHED_LEVEL_MAP = "mCachedLevelMap";
    private static final String FIELD_CACHED_NEW_LEVEL_MAP = "mCachedNewLevelMap";
    private static final String FILE_COMMON = "common_mmkv_configurations";
    private static final String KEY_DEBUG_DBVERSION = "debug_dbversion";
    private static final String KEY_DEBUG_LOCAL_CLASS_STRING = "debug_local_class_string";
    private static final String KEY_DEBUG_LOCAL_HASH = "debug_local_hash";
    private static final String KEY_ERR_CLASS = "err_class";
    private static final String KEY_EVENT_CODE = "DBUpgradeError";
    private static final String KEY_STACK = "stack";
    private static final String LOCAL_HASH_TABLE_PREFIX = "local_hash_table_";
    private static final int MAX_STACK_LEVEL = 20;
    public static final String PACKAGE_NAME = "com.tencent.mobileqq.data";
    private static final int SAMPLING_RATE = 200;
    private static final String STAG = "QQEntityManagerFactory";
    private IAfterDBUpgradeListener mAfterDBUpgradeListener;
    private List<Interceptor<Void>> mCorruptionInterceptorList;
    private List<DBUpgradeEntity> mDBUpgradeEntityList;
    private OnDBTableVerifyFailListener mOnDBTableVerifyFailListener;
    private IOnDBUpgradeListener mOnDBUpgradeListener;
    private List<Interceptor<Class>> mTableColumnCheckInterceptorList;
    private List<Entity> mTableEntityProvider;
    private List<Class<? extends Entity>> mVerifyClassList;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class Builder {
        IAfterDBUpgradeListener mAfterDBUpgradeListener;
        List<Interceptor<Void>> mCorruptionInterceptorList;
        List<DBUpgradeEntity> mDBUpgradeEntityList;
        Provider<Integer> mDBVersionProvider;
        String mName;
        OnDBTableVerifyFailListener mOnDBTableVerifyFailListener;
        IOnDBUpgradeListener mOnDBUpgradeListener;
        List<Interceptor<Class>> mTableColumnCheckInterceptorList;
        List<Entity> mTableEntityList;
        List<Class<? extends Entity>> mVerifyClassList;

        public Builder(String str, Provider<Integer> provider) {
            this.mName = str;
            this.mDBVersionProvider = provider;
        }

        public Builder afterDBUpgradeListener(IAfterDBUpgradeListener iAfterDBUpgradeListener) {
            this.mAfterDBUpgradeListener = iAfterDBUpgradeListener;
            return this;
        }

        public QQEntityManagerFactory build() {
            return new QQEntityManagerFactory(this);
        }

        public Builder corruptionInterceptors(List<Interceptor<Void>> list) {
            this.mCorruptionInterceptorList = list;
            return this;
        }

        public Builder dbUpgradeEntityList(List<DBUpgradeEntity> list) {
            this.mDBUpgradeEntityList = list;
            return this;
        }

        public Builder onDBTableVerifyFailListener(OnDBTableVerifyFailListener onDBTableVerifyFailListener) {
            this.mOnDBTableVerifyFailListener = onDBTableVerifyFailListener;
            return this;
        }

        public Builder onDBUpgradeListener(IOnDBUpgradeListener iOnDBUpgradeListener) {
            this.mOnDBUpgradeListener = iOnDBUpgradeListener;
            return this;
        }

        public Builder tableColumnCheckInterceptors(List<Interceptor<Class>> list) {
            this.mTableColumnCheckInterceptorList = list;
            return this;
        }

        public Builder tableEntityList(List<Entity> list) {
            this.mTableEntityList = list;
            return this;
        }

        public Builder verifyClassList(List<Class<? extends Entity>> list) {
            this.mVerifyClassList = list;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QQEntityManagerFactory(String str, int i3) {
        super(str, i3);
    }

    private void checkColumnChange(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        List<Interceptor<Class>> list = this.mTableColumnCheckInterceptorList;
        if (list != null && list.size() > 0) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
            ArrayList arrayList = new ArrayList();
            if (rawQuery != null) {
                FindTableNameInterceptorChain findTableNameInterceptorChain = new FindTableNameInterceptorChain(0, "", list, i3, i16, sQLiteDatabase);
                while (rawQuery.moveToNext()) {
                    String decode = SecurityUtile.decode(rawQuery.getString(0));
                    Cursor rawQuery2 = sQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[]{"table", decode});
                    if (rawQuery2 != null) {
                        Class proceed = findTableNameInterceptorChain.proceed(decode);
                        if (proceed != null) {
                            try {
                                OGEntityManager.extractedStatementByReflect(arrayList, decode, rawQuery2, proceed);
                            } catch (Throwable th5) {
                                QLog.d(this.tag, 1, "db upgrade error:", th5);
                                handleUpdateError(th5, proceed);
                            }
                        }
                        rawQuery2.close();
                    }
                }
                rawQuery.close();
            }
            updateColumnChange(sQLiteDatabase, arrayList);
        }
    }

    private String createKey(Class cls) {
        return LOCAL_HASH_TABLE_PREFIX + cls.getName();
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

    private boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    private void executeUpgradeDBSql(SQLiteDatabase sQLiteDatabase, int i3) {
        List<DBUpgradeEntity> list = this.mDBUpgradeEntityList;
        if (list != null && list.size() > 0) {
            for (DBUpgradeEntity dBUpgradeEntity : this.mDBUpgradeEntityList) {
                if (dBUpgradeEntity != null && i3 < dBUpgradeEntity.maxVersion()) {
                    for (String str : dBUpgradeEntity.sqlStatement()) {
                        sQLiteDatabase.execSQL(str);
                    }
                }
            }
        }
    }

    private String getChangeTableName(Map<String, Integer> map, MMKVOptionEntity mMKVOptionEntity) {
        for (Class cls : getVerifyClassList()) {
            String createKey = createKey(cls);
            int decodeInt = mMKVOptionEntity.decodeInt(createKey, 0);
            Integer num = map.get(createKey);
            if (num != null && num.intValue() != decodeInt) {
                String name = cls.getName();
                String substring = name.substring(name.lastIndexOf(".") + 1);
                QLog.e(this.tag, 1, "getChangeTableName : " + substring + ", current hash : " + num + ", origin hash : " + decodeInt);
                return substring;
            }
        }
        return "";
    }

    private Class[] getVerifyClassList() {
        List<Class<? extends Entity>> list = this.mVerifyClassList;
        if (list != null && list.size() > 0) {
            Class[] clsArr = new Class[this.mVerifyClassList.size()];
            for (int i3 = 0; i3 < this.mVerifyClassList.size(); i3++) {
                clsArr[i3] = this.mVerifyClassList.get(i3);
            }
            return clsArr;
        }
        return new Class[0];
    }

    private String getVerifyTableFieldString(Class[] clsArr, Map<String, Integer> map) {
        StringBuilder sb5 = new StringBuilder();
        for (Class cls : clsArr) {
            Field[] fields = cls.getFields();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(cls.getName());
            sb6.append("[");
            for (Field field : fields) {
                if (!FIELD_CACHED_LEVEL_MAP.equals(field.getName()) && !FIELD_CACHED_NEW_LEVEL_MAP.equals(field.getName())) {
                    if (!Modifier.isStatic(field.getModifiers()) && field.getAnnotation(notColumn.class) == null && Modifier.isPublic(field.getModifiers())) {
                        sb6.append(field.getName());
                        sb6.append("_");
                        sb6.append(field.getType());
                        sb6.append(ContainerUtils.FIELD_DELIMITER);
                    }
                } else {
                    QLog.e(this.tag, 1, "getFields return class: ", cls.getName(), "not public field: ", field.getName(), ", isPublic: ", Boolean.valueOf(Modifier.isPublic(field.getModifiers())));
                }
            }
            sb6.append("]");
            String sb7 = sb6.toString();
            saveTableHashToMap(sb7, map, cls);
            sb5.append(sb7);
        }
        return sb5.toString();
    }

    private void handleDBTableHash(Map<String, Integer> map, int i3, MMKVOptionEntity mMKVOptionEntity, int i16, int i17, String str, String str2) {
        if (i3 != i16 && i17 >= this.mDBVersion) {
            String changeTableName = getChangeTableName(map, mMKVOptionEntity);
            QLog.e(this.tag, 1, "db version config error for table " + changeTableName + " changed, hash : " + i3 + ", localHash : " + i16 + ", localVersion : " + i17 + ", DB_VERSION: " + this.mDBVersion);
            QLog.e(this.tag, 1, "localClassString = ", str2, ", verifyClassString = ", str);
            OnDBTableVerifyFailListener onDBTableVerifyFailListener = this.mOnDBTableVerifyFailListener;
            if (onDBTableVerifyFailListener != null) {
                onDBTableVerifyFailListener.onDBTableVerifyFailed(changeTableName);
                return;
            }
            return;
        }
        mMKVOptionEntity.encodeInt(KEY_DEBUG_LOCAL_HASH, i3).commitAsync();
        mMKVOptionEntity.encodeInt(KEY_DEBUG_DBVERSION, this.mDBVersion).commitAsync();
        mMKVOptionEntity.encodeString(KEY_DEBUG_LOCAL_CLASS_STRING, str).commitAsync();
        saveTableHashToSp(map, mMKVOptionEntity);
    }

    private void handleUpdateError(Throwable th5, Class cls) {
        boolean z16;
        String currentUin;
        if (!MqqInjectorManager.instance().isPublicVersion() && !MqqInjectorManager.instance().isGrayVersion()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            Toast.makeText(MobileQQ.sMobileQQ, "\u6570\u636e\u5e93\u5347\u7ea7\u5f02\u5e38\uff1a\u51fa\u9519class -> " + cls.getName(), 1).show();
            return;
        }
        if (new Random().nextInt(200) > 1) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            currentUin = "";
        } else {
            currentUin = peekAppRuntime.getCurrentUin();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_ERR_CLASS, cls.getName());
        hashMap.put("stack", createStackString(th5));
        StatisticCollectorProxy.collectPerformance(currentUin, KEY_EVENT_CODE, false, 0L, 0L, hashMap, "");
    }

    private void saveTableHashToMap(String str, Map<String, Integer> map, Class cls) {
        map.put(createKey(cls), Integer.valueOf(str.hashCode()));
    }

    private void saveTableHashToSp(Map<String, Integer> map, MMKVOptionEntity mMKVOptionEntity) {
        for (Class cls : getVerifyClassList()) {
            String createKey = createKey(cls);
            Integer num = map.get(createKey);
            if (num != null) {
                mMKVOptionEntity.encodeInt(createKey, num.intValue()).commitAsync();
            }
        }
    }

    private void updateColumnChange(SQLiteDatabase sQLiteDatabase, List<String> list) {
        com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
        sQLiteDatabase.beginTransaction();
        try {
            for (String str : list) {
                long uptimeMillis = SystemClock.uptimeMillis();
                sQLiteDatabase.execSQL(str);
                QLog.d(this.tag, 1, "updateColumnChange execSQL:" + str + ", cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
            com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        }
    }

    private void verifyDBVersion() {
        int i3;
        int i16;
        if (MqqInjectorManager.instance().isPublicVersion()) {
            return;
        }
        Class[] verifyClassList = getVerifyClassList();
        if (verifyClassList.length <= 0) {
            return;
        }
        HashMap hashMap = new HashMap(verifyClassList.length);
        String verifyTableFieldString = getVerifyTableFieldString(verifyClassList, hashMap);
        int hashCode = verifyTableFieldString.hashCode();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        boolean z16 = false;
        int decodeInt = from.decodeInt(KEY_DEBUG_LOCAL_HASH, 0);
        int decodeInt2 = from.decodeInt(KEY_DEBUG_DBVERSION, 0);
        String decodeString = from.decodeString(KEY_DEBUG_LOCAL_CLASS_STRING, "none");
        if (decodeInt != 0 && !decodeString.contains(FIELD_CACHED_LEVEL_MAP) && !decodeString.contains(FIELD_CACHED_NEW_LEVEL_MAP)) {
            i16 = decodeInt;
            i3 = decodeInt2;
        } else {
            String str = this.tag;
            Object[] objArr = new Object[2];
            objArr[0] = "localHash == 0: ";
            if (decodeInt == 0) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            QLog.e(str, 1, objArr);
            i3 = this.mDBVersion;
            i16 = hashCode;
        }
        handleDBTableHash(hashMap, hashCode, from, i16, i3, verifyTableFieldString, decodeString);
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public SQLiteOpenHelper build(String str) {
        verifyDBVersion();
        if (this.dbHelper == null) {
            if (this.mCorruptionInterceptorList != null) {
                this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, str + DBBackupServiceImpl.DB_FILE_SUFFIX, this.mDBVersion, new QQDBErrorHandler(this.mCorruptionInterceptorList));
            } else {
                this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, str + DBBackupServiceImpl.DB_FILE_SUFFIX, this.mDBVersion);
            }
            QLog.d(this.tag, 1, "walFlag: " + SQLiteOpenHelper.WAL_ENABLE);
            SQLiteOpenHelper sQLiteOpenHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
            this.dbHelper = sQLiteOpenHelper;
            QLog.d(this.tag, 1, "new SQLiteOpenHelper = : ", sQLiteOpenHelper);
        }
        return this.dbHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void cleanOverDueCorruptDatabase() {
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/corruptInfo");
        if (file.exists() && System.currentTimeMillis() - file.lastModified() > 604800000) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void createDatabase(SQLiteDatabase sQLiteDatabase) {
        List<Entity> list = this.mTableEntityProvider;
        if (list != null && list.size() > 0) {
            for (Entity entity : this.mTableEntityProvider) {
                if (entity != null) {
                    sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(entity));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void doAfterUpgradeDatabase(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IAfterDBUpgradeListener iAfterDBUpgradeListener = this.mAfterDBUpgradeListener;
        if (iAfterDBUpgradeListener != null) {
            iAfterDBUpgradeListener.afterDBUpgrade(sQLiteDatabase, i3, i16);
        }
    }

    public IOnDBUpgradeListener getOnDBUpgradeListener() {
        return this.mOnDBUpgradeListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public String getPackageName() {
        return PACKAGE_NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initBuilder(Builder builder) {
        this.name = builder.mName;
        this.mDBVersion = builder.mDBVersionProvider.get().intValue();
        this.mTableEntityProvider = builder.mTableEntityList;
        this.mVerifyClassList = builder.mVerifyClassList;
        this.mTableColumnCheckInterceptorList = builder.mTableColumnCheckInterceptorList;
        this.mDBUpgradeEntityList = builder.mDBUpgradeEntityList;
        this.mCorruptionInterceptorList = builder.mCorruptionInterceptorList;
        this.mOnDBTableVerifyFailListener = builder.mOnDBTableVerifyFailListener;
        this.mAfterDBUpgradeListener = builder.mAfterDBUpgradeListener;
        this.mOnDBUpgradeListener = builder.mOnDBUpgradeListener;
        this.dbHelper = build(this.name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void upgradeDatabase(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        if (i3 < 20) {
            this.mInnerDbHelper.dropAllTable();
            return;
        }
        IOnDBUpgradeListener iOnDBUpgradeListener = this.mOnDBUpgradeListener;
        if (iOnDBUpgradeListener != null) {
            iOnDBUpgradeListener.onDBUpgrade(sQLiteDatabase, i3, i16);
        }
        RecentMigrate.doMigrateRecentTable(sQLiteDatabase, i3);
        long uptimeMillis = SystemClock.uptimeMillis();
        executeUpgradeDBSql(sQLiteDatabase, i3);
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        long uptimeMillis3 = SystemClock.uptimeMillis();
        checkColumnChange(sQLiteDatabase, i3, i16);
        long uptimeMillis4 = SystemClock.uptimeMillis() - uptimeMillis3;
        QLog.d(this.tag, 1, "upgradeDatabase checkColumnChange executeUpgradeDBSqlCost:" + uptimeMillis2 + ", checkColumnChangeCost: " + uptimeMillis4);
    }

    QQEntityManagerFactory(Builder builder) {
        this(builder.mName, builder.mDBVersionProvider.get().intValue());
        initBuilder(builder);
        this.tag = STAG;
    }
}
