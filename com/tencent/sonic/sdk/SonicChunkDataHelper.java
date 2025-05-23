package com.tencent.sonic.sdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
class SonicChunkDataHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS SessionChunkData ( id  integer PRIMARY KEY autoincrement , sessionId text not null , eTag text not null , chunkKey text not null , chunkSha1 text not null ); ";
    public static final String SESSION_CHUNK_COLUMN_CHUNK_KEY = "chunkKey";
    public static final String SESSION_CHUNK_COLUMN_CHUNK_SHA1 = "chunkSha1";
    public static final String SESSION_CHUNK_COLUMN_SESSION_ETAG = "eTag";
    public static final String SESSION_CHUNK_COLUMN_SESSION_ID = "sessionId";
    static final String SESSION_CHUNK_KEY_END = "}";
    static final String SESSION_CHUNK_KEY_PATTERN = "\\{chunk_([0-9a-zA-Z-_])+\\}";
    static final String SESSION_CHUNK_KEY_START = "{chunk_";
    public static final int SESSION_CHUNK_SEND_HASH_BITS = 12;
    public static final String SESSION_CHUNK_TABLE_NAME = "SessionChunkData";
    private static final String TAG = "SonicSdk_SonicChunkDataHelper";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class ChunkData {
        static IPatchRedirector $redirector_;
        String chunkKey;
        String chunkSha1;
        String eTag;
        String sessionId;

        ChunkData() {
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
            this.sessionId = "";
            this.eTag = "";
            this.chunkKey = "";
            this.chunkSha1 = "";
        }

        public String toHeader() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder(128);
            sb5.append(this.chunkKey);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            String str = this.chunkSha1;
            if (!TextUtils.isEmpty(str) && str.length() > 12) {
                str = str.substring(0, 12);
            }
            sb5.append(str);
            SonicUtils.log(SonicChunkDataHelper.TAG, 4, String.format("Session (%s) send sonic chunk toHeader, key=(%s), X-sonic-chunk=(%s)", this.sessionId, this.chunkKey, str));
            return sb5.toString();
        }
    }

    SonicChunkDataHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void clear() {
        synchronized (SonicChunkDataHelper.class) {
            SonicUtils.log(TAG, 4, "Session clear all ChunkData!");
            try {
                SonicDBHelper.getInstance().getWritableDatabase().delete(SESSION_CHUNK_TABLE_NAME, null, null);
            } catch (Throwable th5) {
                SonicUtils.log(TAG, 6, "clear encounter error!" + th5.getMessage());
            }
        }
    }

    static String[] getAllSessionChunkDataColumn() {
        return new String[]{"sessionId", "eTag", SESSION_CHUNK_COLUMN_CHUNK_KEY, SESSION_CHUNK_COLUMN_CHUNK_SHA1};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0035, code lost:
    
        r0.add(querySessionData(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        if (r10.moveToNext() != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
    
        if (r10.moveToFirst() != false) goto L8;
     */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<ChunkData> getChunkDataList(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                Cursor query = SonicDBHelper.getInstance().getWritableDatabase().query(SESSION_CHUNK_TABLE_NAME, getAllSessionChunkDataColumn(), "sessionId=? and eTag=?", new String[]{str, str2}, null, null, null);
                if (query != null) {
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th5) {
                SonicUtils.log(TAG, 6, "getWritableDatabase encounter error." + th5.getMessage());
            }
        }
        return arrayList;
    }

    @NonNull
    private static ContentValues getContentValues(String str, ChunkData chunkData) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sessionId", str);
        contentValues.put("eTag", chunkData.eTag);
        contentValues.put(SESSION_CHUNK_COLUMN_CHUNK_KEY, chunkData.chunkKey);
        contentValues.put(SESSION_CHUNK_COLUMN_CHUNK_SHA1, chunkData.chunkSha1);
        return contentValues;
    }

    private static ChunkData querySessionData(Cursor cursor) {
        ChunkData chunkData = new ChunkData();
        chunkData.sessionId = cursor.getString(cursor.getColumnIndex("sessionId"));
        chunkData.eTag = cursor.getString(cursor.getColumnIndex("eTag"));
        chunkData.chunkKey = cursor.getString(cursor.getColumnIndex(SESSION_CHUNK_COLUMN_CHUNK_KEY));
        chunkData.chunkSha1 = cursor.getString(cursor.getColumnIndex(SESSION_CHUNK_COLUMN_CHUNK_SHA1));
        return chunkData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeChunkData(String str) {
        if (!TextUtils.isEmpty(str)) {
            SonicUtils.log(TAG, 4, String.format("Session (%s) removeChunkData", str));
            try {
                SonicDBHelper.getInstance().getWritableDatabase().delete(SESSION_CHUNK_TABLE_NAME, "sessionId=?", new String[]{str});
            } catch (Throwable th5) {
                SonicUtils.log(TAG, 6, "getWritableDatabase encounter error." + th5.getMessage());
            }
        }
    }

    private static void saveChunkData(String str, List<ChunkData> list) {
        removeChunkData(str);
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = SonicDBHelper.getInstance().getWritableDatabase();
            for (ChunkData chunkData : list) {
                writableDatabase.insert(SESSION_CHUNK_TABLE_NAME, null, getContentValues(str, chunkData));
                SonicUtils.log(TAG, 4, String.format("Session (%s) saveChunkData, key=(%s), X-sonic-chunk=(%s)", str, chunkData.chunkKey, chunkData.chunkSha1));
            }
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "getWritableDatabase encounter error." + th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void saveChunkData(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (jSONObject.has("data") && jSONObject.has("html-sha1") && jSONObject.has(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG)) {
                jSONObject = jSONObject.optJSONObject("data");
            }
            if (jSONObject == null || TextUtils.isEmpty(str2)) {
                return;
            }
            Iterator keys = jSONObject.keys();
            Pattern compile = Pattern.compile(SESSION_CHUNK_KEY_PATTERN);
            ArrayList arrayList = new ArrayList();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                String optString = jSONObject.optString(obj);
                if (!TextUtils.isEmpty(obj) && obj.startsWith(SESSION_CHUNK_KEY_START) && !TextUtils.isEmpty(optString) && compile.matcher(obj).find()) {
                    ChunkData chunkData = new ChunkData();
                    chunkData.sessionId = str;
                    chunkData.chunkKey = obj;
                    chunkData.chunkSha1 = SonicUtils.getSHA1(optString);
                    chunkData.eTag = str2;
                    arrayList.add(chunkData);
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("saveChunkData error, key is  ");
                    sb5.append(obj);
                    sb5.append(", data isn't empty: ");
                    sb5.append(!TextUtils.isEmpty(optString));
                    SonicUtils.log(TAG, 5, sb5.toString());
                }
            }
            if (arrayList.size() > 0) {
                saveChunkData(str, arrayList);
            }
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "saveChunkData error:" + th5.getMessage());
        }
    }
}
