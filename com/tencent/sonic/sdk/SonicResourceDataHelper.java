package com.tencent.sonic.sdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SonicResourceDataHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS ResourceData ( id  integer PRIMARY KEY autoincrement , resourceID text not null , resourceSha1 text not null , resourceSize integer default 0 , resourceUpdateTime integer default 0 , cacheExpiredTime integer default 0 ); ";
    private static final String RESOURCE_DATA_COLUMN_CACHE_EXPIRED_TIME = "cacheExpiredTime";
    private static final String RESOURCE_DATA_COLUMN_LAST_UPDATE_TIME = "resourceUpdateTime";
    private static final String RESOURCE_DATA_COLUMN_RESOURCE_ID = "resourceID";
    private static final String RESOURCE_DATA_COLUMN_RESOURCE_SHA1 = "resourceSha1";
    private static final String RESOURCE_DATA_COLUMN_RESOURCE_SIZE = "resourceSize";
    private static final String Sonic_RESOURCE_TABLE_NAME = "ResourceData";
    private static final String TAG = "SonicSdk_SonicResourceDataHelper";

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class ResourceData {
        static IPatchRedirector $redirector_;
        public long expiredTime;
        long lastUpdateTime;
        String resourceId;
        public String resourceSha1;
        public long resourceSize;

        public ResourceData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void reset() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.resourceSha1 = "";
            this.resourceSize = 0L;
            this.lastUpdateTime = 0L;
            this.expiredTime = 0L;
        }
    }

    public SonicResourceDataHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static synchronized void clear() {
        synchronized (SonicResourceDataHelper.class) {
            try {
                SonicDBHelper.getInstance().getWritableDatabase().delete(Sonic_RESOURCE_TABLE_NAME, null, null);
            } catch (Throwable th5) {
                SonicUtils.log(TAG, 6, "getWritableDatabase encounter error." + th5.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<ResourceData> getAllResourceData() {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = SonicDBHelper.getInstance().getWritableDatabase().query(Sonic_RESOURCE_TABLE_NAME, getAllResourceDataColumn(), null, null, null, null, "");
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "getWritableDatabase encounter error." + th5.getMessage());
            cursor = null;
        }
        while (cursor != null && cursor.moveToNext()) {
            arrayList.add(queryResourceData(cursor));
        }
        return arrayList;
    }

    public static String[] getAllResourceDataColumn() {
        return new String[]{RESOURCE_DATA_COLUMN_RESOURCE_ID, RESOURCE_DATA_COLUMN_RESOURCE_SHA1, RESOURCE_DATA_COLUMN_RESOURCE_SIZE, RESOURCE_DATA_COLUMN_LAST_UPDATE_TIME, RESOURCE_DATA_COLUMN_CACHE_EXPIRED_TIME};
    }

    @NonNull
    private static ContentValues getContentValues(String str, ResourceData resourceData) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(RESOURCE_DATA_COLUMN_RESOURCE_ID, str);
        contentValues.put(RESOURCE_DATA_COLUMN_RESOURCE_SHA1, resourceData.resourceSha1);
        contentValues.put(RESOURCE_DATA_COLUMN_RESOURCE_SIZE, Long.valueOf(resourceData.resourceSize));
        contentValues.put(RESOURCE_DATA_COLUMN_LAST_UPDATE_TIME, Long.valueOf(resourceData.lastUpdateTime));
        contentValues.put(RESOURCE_DATA_COLUMN_CACHE_EXPIRED_TIME, Long.valueOf(resourceData.expiredTime));
        return contentValues;
    }

    @NonNull
    public static ResourceData getResourceData(String str) {
        ResourceData resourceData;
        try {
            resourceData = getResourceData(SonicDBHelper.getInstance().getWritableDatabase(), str);
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "getWritableDatabase encounter error." + th5.getMessage());
            resourceData = null;
        }
        return resourceData == null ? new ResourceData() : resourceData;
    }

    private static void insertResourceData(SQLiteDatabase sQLiteDatabase, String str, ResourceData resourceData) {
        sQLiteDatabase.insert(Sonic_RESOURCE_TABLE_NAME, null, getContentValues(str, resourceData));
    }

    private static ResourceData queryResourceData(Cursor cursor) {
        ResourceData resourceData = new ResourceData();
        resourceData.resourceId = cursor.getString(cursor.getColumnIndex(RESOURCE_DATA_COLUMN_RESOURCE_ID));
        resourceData.resourceSha1 = cursor.getString(cursor.getColumnIndex(RESOURCE_DATA_COLUMN_RESOURCE_SHA1));
        resourceData.resourceSize = cursor.getLong(cursor.getColumnIndex(RESOURCE_DATA_COLUMN_RESOURCE_SIZE));
        resourceData.lastUpdateTime = cursor.getLong(cursor.getColumnIndex(RESOURCE_DATA_COLUMN_LAST_UPDATE_TIME));
        resourceData.expiredTime = cursor.getLong(cursor.getColumnIndex(RESOURCE_DATA_COLUMN_CACHE_EXPIRED_TIME));
        return resourceData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeResourceData(String str) {
        try {
            SonicDBHelper.getInstance().getWritableDatabase().delete(Sonic_RESOURCE_TABLE_NAME, "resourceID=?", new String[]{str});
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "getWritableDatabase encounter error." + th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void saveResourceData(String str, ResourceData resourceData) {
        try {
            saveResourceData(SonicDBHelper.getInstance().getWritableDatabase(), str, resourceData);
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "getWritableDatabase encounter error." + th5.getMessage());
        }
    }

    private static void updateResourceData(SQLiteDatabase sQLiteDatabase, String str, ResourceData resourceData) {
        sQLiteDatabase.update(Sonic_RESOURCE_TABLE_NAME, getContentValues(str, resourceData), "resourceID=?", new String[]{str});
    }

    private static void saveResourceData(SQLiteDatabase sQLiteDatabase, String str, ResourceData resourceData) {
        resourceData.resourceId = str;
        if (getResourceData(sQLiteDatabase, str) != null) {
            updateResourceData(sQLiteDatabase, str, resourceData);
        } else {
            insertResourceData(sQLiteDatabase, str, resourceData);
        }
    }

    private static ResourceData getResourceData(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor query = sQLiteDatabase.query(Sonic_RESOURCE_TABLE_NAME, getAllResourceDataColumn(), "resourceID=?", new String[]{str}, null, null, null);
        ResourceData queryResourceData = (query == null || !query.moveToFirst()) ? null : queryResourceData(query);
        if (query != null) {
            query.close();
        }
        return queryResourceData;
    }
}
