package com.qzone.misc.network.qboss.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QBossDBData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<QBossDBData> DB_CREATOR = new a();
    public static final String JSON_STRING = "jString";
    public static final String QBOSS_ID = "qbossId";
    public static final String TYPE_JSON_STRING = "TEXT";
    public static final String TYPE_QBOSS_ID = "INTEGER";
    public static final String TYPE_WRITE_IN_TIME = "TEXT";
    public static final String WRITE_IN_TIME = "writeInTime";

    @NeedParcel
    public String jString;

    @NeedParcel
    public int qbossId;

    @NeedParcel
    public long writeInTime;

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(QBOSS_ID, Integer.valueOf(this.qbossId));
        contentValues.put(WRITE_IN_TIME, Long.valueOf(this.writeInTime));
        contentValues.put(JSON_STRING, this.jString);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.b<QBossDBData> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QBossDBData createFromCursor(Cursor cursor) {
            QBossDBData qBossDBData = new QBossDBData();
            qBossDBData.qbossId = cursor.getInt(cursor.getColumnIndex(QBossDBData.QBOSS_ID));
            qBossDBData.writeInTime = cursor.getLong(cursor.getColumnIndex(QBossDBData.WRITE_IN_TIME));
            qBossDBData.jString = cursor.getString(cursor.getColumnIndex(QBossDBData.JSON_STRING));
            return qBossDBData;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public String indexRawSql(String str) {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(QBossDBData.QBOSS_ID, "INTEGER"), new IDBCacheDataWrapper.c(QBossDBData.WRITE_IN_TIME, "TEXT"), new IDBCacheDataWrapper.c(QBossDBData.JSON_STRING, "TEXT")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 0;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public int delRawSql(SQLiteDatabase sQLiteDatabase, String str, String str2) {
            String[] split;
            if (sQLiteDatabase == null) {
                return 0;
            }
            if (!TextUtils.isEmpty(str2) && str2.contains(ContainerUtils.KEY_VALUE_DELIMITER) && !str2.contains(" and ") && !str2.contains(" AND ") && !str2.contains(" or ") && !str2.contains(" OR ") && (split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && split.length > 1 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                String trim = split[0].trim();
                String replace = split[1].trim().replace("'", "");
                if (!TextUtils.isEmpty(trim) && !TextUtils.isEmpty(replace)) {
                    return sQLiteDatabase.delete(str, trim + "=? ", new String[]{replace});
                }
            }
            return sQLiteDatabase.delete(str, str2, null);
        }
    }
}
