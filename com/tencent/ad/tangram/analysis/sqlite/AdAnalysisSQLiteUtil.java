package com.tencent.ad.tangram.analysis.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdAnalysisSQLiteUtil {
    private static final String TAG = "AdAnalysisSQLiteUtil";

    public static boolean delete(Context context, @Nullable List<AdAnalysisSQLiteEntry> list) {
        if (list != null && !list.isEmpty()) {
            String str = "";
            for (AdAnalysisSQLiteEntry adAnalysisSQLiteEntry : list) {
                if (adAnalysisSQLiteEntry != null && adAnalysisSQLiteEntry.isValid()) {
                    if (!TextUtils.isEmpty(str)) {
                        str = str + ",";
                    }
                    str = str + String.format("'%s'", adAnalysisSQLiteEntry.uuid);
                } else {
                    AdLog.e(TAG, "delete error");
                }
            }
            if (TextUtils.isEmpty(str)) {
                AdLog.e(TAG, "delete error");
                return false;
            }
            try {
                AdAnalysisSQLiteOpenHelper adAnalysisSQLiteOpenHelper = AdAnalysisSQLiteOpenHelper.getInstance(context);
                if (adAnalysisSQLiteOpenHelper == null) {
                    AdLog.e(TAG, "delete error, helper is null");
                    return false;
                }
                SQLiteDatabase writableDatabase = adAnalysisSQLiteOpenHelper.getWritableDatabase();
                if (writableDatabase == null) {
                    AdLog.e(TAG, "delete error, db is null");
                    return false;
                }
                writableDatabase.execSQL(String.format("DELETE FROM %s WHERE %s IN (%s)", AdAnalysisSQLiteColumns.TABLE_NAME, "uuid", str));
                return true;
            } catch (Throwable th5) {
                AdLog.e(TAG, "delete error", th5);
                return false;
            }
        }
        AdLog.e(TAG, "delete error");
        return false;
    }

    public static void insert(Context context, @Nullable AdAnalysisSQLiteEntry adAnalysisSQLiteEntry) {
        if (adAnalysisSQLiteEntry != null && adAnalysisSQLiteEntry.isValid()) {
            try {
                AdAnalysisSQLiteOpenHelper adAnalysisSQLiteOpenHelper = AdAnalysisSQLiteOpenHelper.getInstance(context);
                if (adAnalysisSQLiteOpenHelper == null) {
                    AdLog.e(TAG, "insert error, helper is null");
                    return;
                }
                SQLiteDatabase writableDatabase = adAnalysisSQLiteOpenHelper.getWritableDatabase();
                if (writableDatabase == null) {
                    AdLog.e(TAG, "insert error, db is null");
                    return;
                } else {
                    if (writableDatabase.insertOrThrow(AdAnalysisSQLiteColumns.TABLE_NAME, null, adAnalysisSQLiteEntry.getContentValues()) == -1) {
                        AdLog.e(TAG, "insert error, rowId is -1");
                        return;
                    }
                    return;
                }
            } catch (Throwable unused) {
                AdLog.e(TAG, "insert error");
                return;
            }
        }
        AdLog.e(TAG, "insert error");
    }

    @Nullable
    public static List<AdAnalysisSQLiteEntry> query(Context context, int i3) {
        Cursor cursor;
        try {
            if (i3 <= 0) {
                AdLog.e(TAG, "query error about limit");
                return null;
            }
            AdAnalysisSQLiteOpenHelper adAnalysisSQLiteOpenHelper = AdAnalysisSQLiteOpenHelper.getInstance(context);
            if (adAnalysisSQLiteOpenHelper == null) {
                AdLog.e(TAG, "query error, helper is null");
                return null;
            }
            SQLiteDatabase readableDatabase = adAnalysisSQLiteOpenHelper.getReadableDatabase();
            if (readableDatabase == null) {
                AdLog.e(TAG, "query error, db is null");
                return null;
            }
            Cursor rawQuery = readableDatabase.rawQuery(String.format("SELECT * FROM %s order by %s ASC limit %d", AdAnalysisSQLiteColumns.TABLE_NAME, AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, Integer.valueOf(i3)), null);
            try {
                if (rawQuery == null) {
                    AdLog.e(TAG, "query error");
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return null;
                }
                if (!rawQuery.moveToFirst()) {
                    rawQuery.close();
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                do {
                    AdAnalysisSQLiteEntry adAnalysisSQLiteEntry = new AdAnalysisSQLiteEntry();
                    adAnalysisSQLiteEntry.uuid = rawQuery.getString(rawQuery.getColumnIndexOrThrow("uuid"));
                    adAnalysisSQLiteEntry.timeMillis = rawQuery.getLong(rawQuery.getColumnIndexOrThrow(AdAnalysisSQLiteColumns.COLUMN_NAME_TIME_MILLIS));
                    adAnalysisSQLiteEntry.strategy = rawQuery.getInt(rawQuery.getColumnIndexOrThrow(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY));
                    adAnalysisSQLiteEntry.eventString = rawQuery.getString(rawQuery.getColumnIndexOrThrow("event"));
                    arrayList.add(adAnalysisSQLiteEntry);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                return arrayList;
            } catch (Throwable th5) {
                cursor = rawQuery;
                th = th5;
                try {
                    AdLog.e(TAG, "query", th);
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }
}
