package com.tencent.gamecenter.wadl.sdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.sdk.dlcom.WadlUtils;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTaskV2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlTgpaDBHelper extends WadlBaseDBHelper {
    private static final String RES_DETAIL_TABLE_NAME = "res_detail";
    private static final String RES_SUMMARY_TABLE_NAME = "app_summary";
    private static final String SQL_DELETE_DETAIL_TABLE = "DROP TABLE IF EXISTS res_detail";
    private static final String SQL_DELETE_SUMMARY_TABLE = "DROP TABLE IF EXISTS app_summary";
    private static final String TAG = "Wadl_WadlTgpaDBHelper";

    public WadlTgpaDBHelper(Context context, String str) {
        super(context, str);
    }

    private int deleteTasksByResId(String str) {
        return execDelSQL("resId=?", new String[]{str});
    }

    private WadlTask getTasksByResId(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<WadlTask> execQuerySQL = execQuerySQL("resId=?", new String[]{str});
        if (execQuerySQL.size() <= 0) {
            return null;
        }
        return execQuerySQL.get(0);
    }

    private boolean validEvent(int i3) {
        if (i3 != 5002 && i3 != 5003 && i3 != 5004 && i3 != 5005 && i3 != 5006 && i3 != 5007 && i3 != 5008) {
            return false;
        }
        return true;
    }

    public Map<String, WadlTask> getAllWadlTasks() {
        HashMap hashMap = new HashMap();
        List<WadlTask> execQueryAllSQL = execQueryAllSQL();
        if (execQueryAllSQL != null) {
            for (WadlTask wadlTask : execQueryAllSQL) {
                hashMap.put(wadlTask.mWadlParams.getResId(), wadlTask);
            }
        }
        return hashMap;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.db.WadlBaseDBHelper
    public ContentValues getContentValue(WadlResult wadlResult, int i3) {
        WadlParams wadlParams;
        if (wadlResult != null && (wadlParams = wadlResult.wadlParams) != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("resId", wadlParams.getResId());
            contentValues.put("appId", wadlParams.appId);
            contentValues.put("downloadUrl", wadlParams.apkUrl);
            contentValues.put("via", wadlParams.via);
            contentValues.put("name", wadlParams.appName);
            contentValues.put("packageName", wadlParams.packageName);
            contentValues.put("versionCode", Integer.valueOf(wadlParams.versionCode));
            contentValues.put("totalSize", Long.valueOf(wadlResult.fileSize));
            contentValues.put("downloadSize", Long.valueOf(wadlResult.downloadFileSize));
            contentValues.put("status", Integer.valueOf(wadlResult.taskStatus));
            contentValues.put("savePath", wadlResult.downloadFilePath);
            contentValues.put(WadlProxyConsts.FROM_URL, wadlParams.fromWebUrl);
            contentValues.put("adtag", wadlParams.adtag);
            contentValues.put(WadlProxyConsts.APKSIGN, wadlParams.apkSign);
            contentValues.put(WadlProxyConsts.CREATE_TIME, Long.valueOf(wadlResult.createTime));
            contentValues.put(WadlProxyConsts.CHANNEL, wadlParams.apkChannel);
            contentValues.put(WadlProxyConsts.FLAGS, Integer.valueOf(wadlParams.flags));
            contentValues.put("actionFrom", Integer.valueOf(wadlParams.from));
            contentValues.put(WadlProxyConsts.EXTRA_DATA, wadlParams.extraData);
            contentValues.put("resType", Integer.valueOf(wadlParams.resType));
            contentValues.put(WadlProxyConsts.RES_INDEX, Integer.valueOf(wadlParams.resIndex));
            contentValues.put(WadlProxyConsts.RES_MD5, wadlParams.resMD5);
            contentValues.put("resName", wadlParams.resName);
            contentValues.put(WadlProxyConsts.RES_URL, wadlParams.apkUrl);
            contentValues.put("resVersionName", wadlParams.resVersionName);
            contentValues.put(WadlProxyConsts.LAST_UPDATE_TIME, Long.valueOf(wadlResult.lastUpdateTime));
            return contentValues;
        }
        return null;
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a
    public String getCreateTableFields() {
        return WadlProxyConsts.RES_TABLE_FIELDS;
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a
    public String getTableKey() {
        return "resId";
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a, android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        super.onUpgrade(sQLiteDatabase, i3, i16);
        try {
            sQLiteDatabase.execSQL(SQL_DELETE_SUMMARY_TABLE);
            sQLiteDatabase.execSQL(SQL_DELETE_DETAIL_TABLE);
        } catch (Throwable unused) {
            QLog.e(TAG, 1, "onUpgrade exception oldVersion=" + i3 + ",newVersion=" + i16);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.db.WadlBaseDBHelper
    WadlTask parseCursorToTask(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        WadlParams wadlParams = new WadlParams();
        wadlParams.isRes = true;
        int columnIndex = cursor.getColumnIndex("appId");
        int columnIndex2 = cursor.getColumnIndex("packageName");
        int columnIndex3 = cursor.getColumnIndex("downloadUrl");
        int columnIndex4 = cursor.getColumnIndex(WadlProxyConsts.APKSIGN);
        int columnIndex5 = cursor.getColumnIndex("versionCode");
        int columnIndex6 = cursor.getColumnIndex("name");
        int columnIndex7 = cursor.getColumnIndex(WadlProxyConsts.CHANNEL);
        int columnIndex8 = cursor.getColumnIndex("via");
        int columnIndex9 = cursor.getColumnIndex(WadlProxyConsts.FLAGS);
        int columnIndex10 = cursor.getColumnIndex(WadlProxyConsts.FROM_URL);
        int columnIndex11 = cursor.getColumnIndex("actionFrom");
        int columnIndex12 = cursor.getColumnIndex("adtag");
        int columnIndex13 = cursor.getColumnIndex(WadlProxyConsts.EXTRA_DATA);
        if (columnIndex < 0 || columnIndex2 < 0 || columnIndex3 < 0 || columnIndex4 < 0 || columnIndex5 < 0 || columnIndex6 < 0 || columnIndex7 < 0 || columnIndex8 < 0 || columnIndex9 < 0 || columnIndex10 < 0 || columnIndex11 < 0 || columnIndex12 < 0 || columnIndex13 < 0) {
            return null;
        }
        wadlParams.appId = cursor.getString(columnIndex);
        wadlParams.packageName = cursor.getString(columnIndex2);
        wadlParams.apkUrl = cursor.getString(columnIndex3);
        wadlParams.apkSign = cursor.getString(columnIndex4);
        wadlParams.versionCode = cursor.getInt(columnIndex5);
        wadlParams.appName = cursor.getString(columnIndex6);
        wadlParams.apkChannel = cursor.getString(columnIndex7);
        wadlParams.via = cursor.getString(columnIndex8);
        wadlParams.flags = cursor.getInt(columnIndex9);
        wadlParams.fromWebUrl = cursor.getString(columnIndex10);
        wadlParams.from = cursor.getInt(columnIndex11);
        wadlParams.adtag = cursor.getString(columnIndex12);
        wadlParams.extraData = cursor.getString(columnIndex13);
        int columnIndex14 = cursor.getColumnIndex("resType");
        int columnIndex15 = cursor.getColumnIndex(WadlProxyConsts.RES_INDEX);
        int columnIndex16 = cursor.getColumnIndex(WadlProxyConsts.RES_MD5);
        int columnIndex17 = cursor.getColumnIndex("resName");
        int columnIndex18 = cursor.getColumnIndex(WadlProxyConsts.RES_URL);
        int columnIndex19 = cursor.getColumnIndex("resVersionName");
        if (columnIndex14 < 0 || columnIndex15 < 0 || columnIndex16 < 0 || columnIndex17 < 0 || columnIndex18 < 0 || columnIndex19 < 0) {
            return null;
        }
        wadlParams.resType = cursor.getInt(columnIndex14);
        wadlParams.resIndex = cursor.getInt(columnIndex15);
        wadlParams.resMD5 = cursor.getString(columnIndex16);
        wadlParams.resName = cursor.getString(columnIndex17);
        wadlParams.apkUrl = cursor.getString(columnIndex18);
        wadlParams.resVersionName = cursor.getString(columnIndex19);
        int columnIndex20 = cursor.getColumnIndex(WadlProxyConsts.LAST_UPDATE_TIME);
        int columnIndex21 = cursor.getColumnIndex("totalSize");
        int columnIndex22 = cursor.getColumnIndex("downloadSize");
        int columnIndex23 = cursor.getColumnIndex("savePath");
        int columnIndex24 = cursor.getColumnIndex("status");
        int columnIndex25 = cursor.getColumnIndex(WadlProxyConsts.CREATE_TIME);
        if (columnIndex20 < 0 || columnIndex21 < 0 || columnIndex22 < 0 || columnIndex23 < 0 || columnIndex24 < 0 || columnIndex25 < 0) {
            return null;
        }
        WadlTaskV2 wadlTaskV2 = new WadlTaskV2(2, wadlParams);
        wadlTaskV2.appId = wadlParams.appId;
        wadlTaskV2.pkgName = wadlParams.packageName;
        wadlTaskV2.lastUpdateTime = cursor.getLong(columnIndex20);
        wadlTaskV2.fileSize = cursor.getLong(columnIndex21);
        wadlTaskV2.downloadFileSize = cursor.getLong(columnIndex22);
        wadlTaskV2.downloadFilePath = cursor.getString(columnIndex23);
        wadlTaskV2.taskStatus = cursor.getInt(columnIndex24);
        wadlTaskV2.createTime = cursor.getLong(columnIndex25);
        return wadlTaskV2;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        WadlResult wadlResult = (WadlResult) obj;
        if (wadlResult != null && wadlResult.wadlParams != null) {
            if (!validEvent(wadlResult.event)) {
                return;
            }
            String resId = wadlResult.wadlParams.getResId();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "update resId=" + resId + ",status=" + wadlResult.taskStatus + ",wadlResult.event=" + wadlResult.event);
            }
            int i3 = wadlResult.event;
            if (i3 == 5007) {
                deleteTasksByResId(resId);
            } else if (i3 == 5003) {
                if (getTasksByResId(resId) == null) {
                    addWadlTask(wadlResult);
                }
            } else {
                updateTask(wadlResult);
            }
            if (wadlResult.event == 5008) {
                String calcMd5 = WadlUtils.calcMd5(wadlResult.downloadFilePath);
                if (!calcMd5.equalsIgnoreCase(wadlResult.wadlParams.resMD5)) {
                    WadlUtils.deleteFile(wadlResult.downloadFilePath);
                    QLog.w(TAG, 1, "wadl res md5 is error deleteFile=" + wadlResult.downloadFilePath + " filemd5=" + calcMd5 + " tgpa md5=" + wadlResult.wadlParams.resMD5);
                    return;
                }
                return;
            }
            return;
        }
        QLog.w(TAG, 1, "update WadlResult to db error wadlResult is null");
    }

    public int updateTask(WadlResult wadlResult) {
        return execUpdSQL("resId=?", new String[]{wadlResult.wadlParams.getResId()}, getContentValue(wadlResult, 1));
    }
}
