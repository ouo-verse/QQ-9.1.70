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
class SonicDataHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS SessionData ( id  integer PRIMARY KEY autoincrement , sessionID text not null , eTag text not null , templateTag text , htmlSha1 text not null , UnavailableTime integer default 0 , htmlSize integer default 0 , templateUpdateTime integer default 0 , cacheExpiredTime integer default 0 , cacheHitCount integer default 0 , isRedPointPreload integer default 0 ); ";
    protected static final String SESSION_DATA_COLUMN_CACHE_EXPIRED_TIME = "cacheExpiredTime";
    protected static final String SESSION_DATA_COLUMN_CACHE_HIT_COUNT = "cacheHitCount";
    protected static final String SESSION_DATA_COLUMN_ETAG = "eTag";
    protected static final String SESSION_DATA_COLUMN_HTML_SHA1 = "htmlSha1";
    protected static final String SESSION_DATA_COLUMN_HTML_SIZE = "htmlSize";
    protected static final String SESSION_DATA_COLUMN_IS_RED_POINT_PRELOAD = "isRedPointPreload";
    protected static final String SESSION_DATA_COLUMN_SESSION_ID = "sessionID";
    protected static final String SESSION_DATA_COLUMN_TEMPLATE_EAG = "templateTag";
    protected static final String SESSION_DATA_COLUMN_TEMPLATE_UPDATE_TIME = "templateUpdateTime";
    protected static final String SESSION_DATA_COLUMN_UNAVAILABLE_TIME = "UnavailableTime";
    protected static final String Sonic_SESSION_TABLE_NAME = "SessionData";
    private static final String TAG = "SonicSdk_SonicDataHelper";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class SessionData {
        static IPatchRedirector $redirector_;
        int cacheHitCount;
        String eTag;
        long expiredTime;
        String htmlSha1;
        long htmlSize;
        int isRedPointPreload;
        String sessionId;
        String templateTag;
        long templateUpdateTime;
        long unAvailableTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SessionData() {
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
            this.eTag = "";
            this.templateTag = "";
            this.htmlSha1 = "";
            this.htmlSize = 0L;
            this.templateUpdateTime = 0L;
            this.expiredTime = 0L;
            this.cacheHitCount = 0;
            this.unAvailableTime = 0L;
            this.isRedPointPreload = 0;
        }
    }

    SonicDataHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void clear() {
        synchronized (SonicDataHelper.class) {
            try {
                SonicDBHelper.getInstance().getWritableDatabase().delete(Sonic_SESSION_TABLE_NAME, null, null);
            } catch (Throwable th5) {
                SonicUtils.log(TAG, 6, "getWritableDatabase encounter error." + th5.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<SessionData> getAllSessionByHitCount() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor query = SonicDBHelper.getInstance().getWritableDatabase().query(Sonic_SESSION_TABLE_NAME, getAllSessionDataColumn(), null, null, null, null, "cacheHitCount ASC");
            while (query != null) {
                if (!query.moveToNext()) {
                    break;
                }
                arrayList.add(querySessionData(query));
            }
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "getWritableDatabase encounter error." + th5.getMessage());
        }
        return arrayList;
    }

    static String[] getAllSessionDataColumn() {
        return new String[]{SESSION_DATA_COLUMN_SESSION_ID, "eTag", SESSION_DATA_COLUMN_TEMPLATE_EAG, SESSION_DATA_COLUMN_HTML_SHA1, SESSION_DATA_COLUMN_UNAVAILABLE_TIME, SESSION_DATA_COLUMN_HTML_SIZE, SESSION_DATA_COLUMN_TEMPLATE_UPDATE_TIME, SESSION_DATA_COLUMN_CACHE_EXPIRED_TIME, SESSION_DATA_COLUMN_CACHE_HIT_COUNT, SESSION_DATA_COLUMN_IS_RED_POINT_PRELOAD};
    }

    @NonNull
    private static ContentValues getContentValues(String str, SessionData sessionData) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SESSION_DATA_COLUMN_SESSION_ID, str);
        contentValues.put("eTag", sessionData.eTag);
        contentValues.put(SESSION_DATA_COLUMN_HTML_SHA1, sessionData.htmlSha1);
        contentValues.put(SESSION_DATA_COLUMN_HTML_SIZE, Long.valueOf(sessionData.htmlSize));
        contentValues.put(SESSION_DATA_COLUMN_TEMPLATE_EAG, sessionData.templateTag);
        contentValues.put(SESSION_DATA_COLUMN_TEMPLATE_UPDATE_TIME, Long.valueOf(sessionData.templateUpdateTime));
        contentValues.put(SESSION_DATA_COLUMN_CACHE_EXPIRED_TIME, Long.valueOf(sessionData.expiredTime));
        contentValues.put(SESSION_DATA_COLUMN_UNAVAILABLE_TIME, Long.valueOf(sessionData.unAvailableTime));
        contentValues.put(SESSION_DATA_COLUMN_CACHE_HIT_COUNT, Integer.valueOf(sessionData.cacheHitCount));
        contentValues.put(SESSION_DATA_COLUMN_IS_RED_POINT_PRELOAD, Integer.valueOf(sessionData.isRedPointPreload));
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLastSonicUnavailableTime(String str) {
        return getSessionData(str).unAvailableTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static SessionData getSessionData(String str) {
        SessionData sessionData;
        try {
            sessionData = getSessionData(SonicDBHelper.getInstance().getWritableDatabase(), str);
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "getWritableDatabase encounter error." + th5.getMessage());
            sessionData = null;
        }
        return sessionData == null ? new SessionData() : sessionData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getTemplateUpdateTime(String str) {
        return getSessionData(str).templateUpdateTime;
    }

    private static void insertSessionData(SQLiteDatabase sQLiteDatabase, String str, SessionData sessionData) {
        sQLiteDatabase.insert(Sonic_SESSION_TABLE_NAME, null, getContentValues(str, sessionData));
    }

    private static SessionData querySessionData(Cursor cursor) {
        SessionData sessionData = new SessionData();
        sessionData.sessionId = cursor.getString(cursor.getColumnIndex(SESSION_DATA_COLUMN_SESSION_ID));
        sessionData.eTag = cursor.getString(cursor.getColumnIndex("eTag"));
        sessionData.htmlSha1 = cursor.getString(cursor.getColumnIndex(SESSION_DATA_COLUMN_HTML_SHA1));
        sessionData.htmlSize = cursor.getLong(cursor.getColumnIndex(SESSION_DATA_COLUMN_HTML_SIZE));
        sessionData.templateTag = cursor.getString(cursor.getColumnIndex(SESSION_DATA_COLUMN_TEMPLATE_EAG));
        sessionData.templateUpdateTime = cursor.getLong(cursor.getColumnIndex(SESSION_DATA_COLUMN_TEMPLATE_UPDATE_TIME));
        sessionData.expiredTime = cursor.getLong(cursor.getColumnIndex(SESSION_DATA_COLUMN_CACHE_EXPIRED_TIME));
        sessionData.unAvailableTime = cursor.getLong(cursor.getColumnIndex(SESSION_DATA_COLUMN_UNAVAILABLE_TIME));
        sessionData.cacheHitCount = cursor.getInt(cursor.getColumnIndex(SESSION_DATA_COLUMN_CACHE_HIT_COUNT));
        sessionData.isRedPointPreload = cursor.getInt(cursor.getColumnIndex(SESSION_DATA_COLUMN_IS_RED_POINT_PRELOAD));
        return sessionData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeSessionData(String str) {
        try {
            SonicDBHelper.getInstance().getWritableDatabase().delete(Sonic_SESSION_TABLE_NAME, "sessionID=?", new String[]{str});
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "removeSessionData encounter error." + th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void saveSessionData(String str, SessionData sessionData) {
        try {
            saveSessionData(SonicDBHelper.getInstance().getWritableDatabase(), str, sessionData);
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "getWritableDatabase encounter error." + th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean setSonicUnavailableTime(String str, long j3) {
        SQLiteDatabase sQLiteDatabase;
        SessionData sessionData = null;
        try {
            sQLiteDatabase = SonicDBHelper.getInstance().getWritableDatabase();
            try {
                sessionData = getSessionData(sQLiteDatabase, str);
            } catch (Throwable th5) {
                th = th5;
                SonicUtils.log(TAG, 6, "getWritableDatabase encounter error." + th.getMessage());
                if (sQLiteDatabase != null) {
                }
            }
        } catch (Throwable th6) {
            th = th6;
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase != null) {
            return false;
        }
        if (sessionData != null) {
            sessionData.unAvailableTime = j3;
            updateSessionData(sQLiteDatabase, str, sessionData);
            return true;
        }
        SessionData sessionData2 = new SessionData();
        sessionData2.sessionId = str;
        sessionData2.eTag = "Unknown";
        sessionData2.htmlSha1 = "Unknown";
        sessionData2.unAvailableTime = j3;
        insertSessionData(sQLiteDatabase, str, sessionData2);
        return true;
    }

    private static void updateSessionData(SQLiteDatabase sQLiteDatabase, String str, SessionData sessionData) {
        sQLiteDatabase.update(Sonic_SESSION_TABLE_NAME, getContentValues(str, sessionData), "sessionID=?", new String[]{str});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void updateSonicCacheHitCount(String str) {
        try {
            updateSonicCacheHitCount(SonicDBHelper.getInstance().getWritableDatabase(), str);
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "getWritableDatabase encounter error." + th5.getMessage());
        }
    }

    private static void saveSessionData(SQLiteDatabase sQLiteDatabase, String str, SessionData sessionData) {
        sessionData.sessionId = str;
        SessionData sessionData2 = getSessionData(sQLiteDatabase, str);
        if (sessionData2 != null) {
            sessionData.cacheHitCount = sessionData2.cacheHitCount;
            updateSessionData(sQLiteDatabase, str, sessionData);
        } else {
            insertSessionData(sQLiteDatabase, str, sessionData);
        }
    }

    private static void updateSonicCacheHitCount(SQLiteDatabase sQLiteDatabase, String str) {
        SessionData sessionData = getSessionData(sQLiteDatabase, str);
        if (sessionData != null) {
            sessionData.cacheHitCount++;
            updateSessionData(sQLiteDatabase, str, sessionData);
        }
    }

    private static SessionData getSessionData(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor query = sQLiteDatabase.query(Sonic_SESSION_TABLE_NAME, getAllSessionDataColumn(), "sessionID=?", new String[]{str}, null, null, null);
        SessionData querySessionData = (query == null || !query.moveToFirst()) ? null : querySessionData(query);
        if (query != null) {
            query.close();
        }
        return querySessionData;
    }
}
