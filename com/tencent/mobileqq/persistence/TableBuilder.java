package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.imcore.proxy.db.OGEntityDaoManagerProxy;
import com.tencent.mobileqq.imcore.proxy.db.TableBuilderProxy;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class TableBuilder {
    private static final Map<Class<? extends Entity>, List<Field>> ALL_FIELD_CACHE;
    private static final Map<String, String> CREATE_TABLE_CACHE;
    private static final Map<Class<? extends Entity>, List<Field>> FIELD_CACHE;
    public static final String PRIMARY_KEY = "_id";
    private static final Map<Class<? extends Entity>, Entity> TABLE_CACHE;
    public static final Map<Class<?>, String> TYPES;
    private static Class[] sNeedPrivateFieldsClass;

    static {
        HashMap hashMap = new HashMap();
        TYPES = hashMap;
        FIELD_CACHE = new ConcurrentHashMap();
        ALL_FIELD_CACHE = new ConcurrentHashMap();
        CREATE_TABLE_CACHE = new ConcurrentHashMap();
        TABLE_CACHE = new ConcurrentHashMap();
        hashMap.put(Byte.TYPE, "INTEGER");
        hashMap.put(Boolean.TYPE, "INTEGER");
        hashMap.put(Short.TYPE, "INTEGER");
        hashMap.put(Integer.TYPE, "INTEGER");
        hashMap.put(Long.TYPE, "INTEGER");
        hashMap.put(String.class, "TEXT");
        hashMap.put(byte[].class, "BLOB");
        hashMap.put(Float.TYPE, "REAL");
        hashMap.put(Double.TYPE, "REAL");
        sNeedPrivateFieldsClass = new Class[0];
    }

    public static String addColumn(String str, String str2, String str3, boolean z16) {
        return addColumn(str, str2, str3, z16, 0);
    }

    public static String createIndexSQLStatement(Entity entity) {
        return TableBuilderProxy.createIndexSQLStatement(entity);
    }

    public static String createSQLStatement(Entity entity) {
        String createTableSql;
        String tableName = entity.getTableName();
        Map<String, String> map = CREATE_TABLE_CACHE;
        if (map.containsKey(tableName)) {
            return map.get(tableName);
        }
        OGAbstractDao entityDao = OGEntityDaoManagerProxy.getEntityDao(entity.getClass());
        if (entityDao != null && (createTableSql = entityDao.getCreateTableSql(tableName)) != null) {
            map.put(tableName, createTableSql);
            entityDao.useIndex = true;
            return createTableSql;
        }
        StringBuilder sb5 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb5.append(tableName);
        sb5.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT");
        Class<? extends Entity> classForTable = entity.getClassForTable();
        List<Field> validField = getValidField(classForTable);
        int size = validField.size();
        for (int i3 = 0; i3 < size; i3++) {
            Field field = validField.get(i3);
            String name = field.getName();
            String str = TYPES.get(field.getType());
            if (str != null) {
                sb5.append(',');
                sb5.append(name + " " + str);
                if (field.isAnnotationPresent(unique.class)) {
                    sb5.append(" UNIQUE");
                } else if (field.isAnnotationPresent(defaultzero.class)) {
                    sb5.append(" default 0");
                } else if (field.isAnnotationPresent(defaultValue.class)) {
                    sb5.append(" default " + ((defaultValue) field.getAnnotation(defaultValue.class)).defaultInteger());
                }
            }
        }
        if (classForTable.isAnnotationPresent(uniqueConstraints.class)) {
            uniqueConstraints uniqueconstraints = (uniqueConstraints) classForTable.getAnnotation(uniqueConstraints.class);
            sb5.append(",UNIQUE(" + uniqueconstraints.columnNames() + ")");
            sb5.append(" ON CONFLICT " + uniqueconstraints.clause().toString());
        }
        sb5.append(')');
        String sb6 = sb5.toString();
        CREATE_TABLE_CACHE.put(tableName, sb6);
        return sb6;
    }

    public static String dropSQLStatement(String str) {
        return "DROP TABLE IF EXISTS " + str;
    }

    public static List<Field> getAllField(Entity entity) {
        Class<? extends Entity> classForTable = entity.getClassForTable();
        List<Field> list = ALL_FIELD_CACHE.get(classForTable);
        if (list == null) {
            Field[] fields = classForTable.getFields();
            ArrayList arrayList = new ArrayList(fields.length);
            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    arrayList.add(field);
                }
            }
            ALL_FIELD_CACHE.put(classForTable, arrayList);
            return arrayList;
        }
        return list;
    }

    public static Entity getTableConfig(Class<? extends Entity> cls) throws InstantiationException, IllegalAccessException {
        Map<Class<? extends Entity>, Entity> map = TABLE_CACHE;
        Entity entity = map.get(cls);
        if (entity == null) {
            Entity newInstance = cls.newInstance();
            map.put(cls, newInstance);
            return newInstance;
        }
        return entity;
    }

    public static String getTableName(Class<? extends Entity> cls) throws InstantiationException, IllegalAccessException {
        return getTableConfig(cls).getTableName();
    }

    public static String getTableNameSafe(Class<? extends Entity> cls) {
        try {
            return getTableName(cls);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            return null;
        } catch (InstantiationException e17) {
            e17.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<Field> getValidField(Class<? extends Entity> cls) {
        Class<? extends Entity> cls2;
        List<Field> list;
        try {
            cls2 = getTableConfig(cls).getClassForTable();
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            cls2 = null;
            list = FIELD_CACHE.get(cls2);
            if (list != null) {
            }
        } catch (InstantiationException e17) {
            e17.printStackTrace();
            cls2 = null;
            list = FIELD_CACHE.get(cls2);
            if (list != null) {
            }
        }
        list = FIELD_CACHE.get(cls2);
        if (list != null) {
            return list;
        }
        Field[] fields = cls2.getFields();
        ArrayList arrayList = new ArrayList(fields.length);
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(notColumn.class)) {
                arrayList.add(field);
            }
        }
        handlePrivateColumnFields(cls2, arrayList);
        FIELD_CACHE.put(cls2, arrayList);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005c A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void handlePrivateColumnFields(Class<? extends Entity> cls, List<Field> list) {
        boolean z16;
        if (sNeedPrivateFieldsClass.length == 0) {
            sNeedPrivateFieldsClass = TableBuilderProxy.getNeedPrivateFieldsClass();
        }
        Class<? extends Entity>[] clsArr = sNeedPrivateFieldsClass;
        if (clsArr.length != 0) {
            for (Class<? extends Entity> cls2 : clsArr) {
                if (cls2 != cls) {
                }
            }
            z16 = false;
            if (!z16) {
                for (Field field : cls.getDeclaredFields()) {
                    if (!Modifier.isStatic(field.getModifiers()) && field.isAnnotationPresent(forceColumn.class)) {
                        QLog.i(QZoneAppCtrlUploadFileLogic.DB_PATH, 1, "add forceColumn field " + field);
                        list.add(field);
                    }
                }
                return;
            }
            return;
        }
        z16 = true;
        if (!z16) {
        }
    }

    public static String addColumn(String str, String str2, String str3, boolean z16, int i3) {
        if (z16) {
            return "alter table " + str + " add " + str2 + " " + str3 + " default " + i3;
        }
        return "alter table " + str + " add " + str2 + " " + str3;
    }

    public static List<Field> getValidField(Entity entity) {
        Class<? extends Entity> classForTable = entity.getClassForTable();
        List<Field> list = FIELD_CACHE.get(classForTable);
        if (list != null) {
            return list;
        }
        Field[] fields = classForTable.getFields();
        ArrayList arrayList = new ArrayList(fields.length);
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(notColumn.class)) {
                arrayList.add(field);
            }
        }
        handlePrivateColumnFields(classForTable, arrayList);
        FIELD_CACHE.put(classForTable, arrayList);
        return arrayList;
    }
}
