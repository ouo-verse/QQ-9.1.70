package com.tencent.gamecenter.wadl.sdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlParamsExt;
import com.tencent.gamecenter.wadl.biz.entity.WadlParamsPageInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTaskV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlGameCenterDBHelper extends WadlBaseDBHelper {
    public static final String TAG = "Wadl_WadlGameCenterDBHelper";

    public WadlGameCenterDBHelper(Context context, String str) {
        super(context, str);
    }

    private String createExtJsonByWadlParams(WadlParams wadlParams) {
        if (wadlParams == null) {
            return "";
        }
        WadlParamsExt wadlParamsExt = wadlParams.wadlParamsExt;
        WadlParamsPageInfo wadlParamsPageInfo = wadlParams.wadlParamsPageInfo;
        JSONObject jSONObject = new JSONObject();
        if (wadlParamsExt != null) {
            try {
                jSONObject.put("appointment_time", wadlParamsExt.f106733d);
                if (!TextUtils.isEmpty(wadlParamsExt.f106734e)) {
                    jSONObject.put("notificationExpId", wadlParamsExt.f106734e);
                }
                if (!TextUtils.isEmpty(wadlParamsExt.f106735f)) {
                    jSONObject.put("notificationExpValue", wadlParamsExt.f106735f);
                }
                if (!TextUtils.isEmpty(wadlParamsExt.f106736h)) {
                    jSONObject.put(WadlProxyConsts.SCENE_ID, wadlParamsExt.f106736h);
                }
                if (!TextUtils.isEmpty(wadlParamsExt.E)) {
                    jSONObject.put("extParam1", wadlParamsExt.E);
                }
                if (!TextUtils.isEmpty(wadlParamsExt.F)) {
                    jSONObject.put("extParam2", wadlParamsExt.F);
                }
                if (!TextUtils.isEmpty(wadlParamsExt.G)) {
                    jSONObject.put("extParam3", wadlParamsExt.G);
                }
                if (!TextUtils.isEmpty(wadlParamsExt.H)) {
                    jSONObject.put("extParam4", wadlParamsExt.H);
                }
                if (!TextUtils.isEmpty(wadlParamsExt.I)) {
                    jSONObject.put("extParam5", wadlParamsExt.I);
                }
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "createExtJsonByWadlParams exception", e16);
                return "";
            }
        }
        if (wadlParamsPageInfo != null) {
            if (!TextUtils.isEmpty(wadlParamsPageInfo.f106739d)) {
                jSONObject.put("page_id", wadlParamsPageInfo.f106739d);
            }
            if (!TextUtils.isEmpty(wadlParamsPageInfo.f106740e)) {
                jSONObject.put("page_name", wadlParamsPageInfo.f106740e);
            }
            if (!TextUtils.isEmpty(wadlParamsPageInfo.f106741f)) {
                jSONObject.put("module_id", wadlParamsPageInfo.f106741f);
            }
            if (!TextUtils.isEmpty(wadlParamsPageInfo.f106742h)) {
                jSONObject.put("module_name", wadlParamsPageInfo.f106742h);
            }
            if (!TextUtils.isEmpty(wadlParamsPageInfo.f106743i)) {
                jSONObject.put("sub_module_id", wadlParamsPageInfo.f106743i);
            }
            if (!TextUtils.isEmpty(wadlParamsPageInfo.f106744m)) {
                jSONObject.put("sub_module_name", wadlParamsPageInfo.f106744m);
            }
            if (!TextUtils.isEmpty(wadlParamsPageInfo.C)) {
                jSONObject.put("element_name", wadlParamsPageInfo.C);
            }
            if (!TextUtils.isEmpty(wadlParamsPageInfo.D)) {
                jSONObject.put("element_level", wadlParamsPageInfo.D);
            }
            if (!TextUtils.isEmpty(wadlParamsPageInfo.E)) {
                jSONObject.put("pre_page_name", wadlParamsPageInfo.E);
            }
        }
        return jSONObject.toString();
    }

    private WadlTask getWadlTask(String str) {
        List<WadlTask> execQuerySQL = execQuerySQL(str);
        if (execQuerySQL.size() == 0) {
            QLog.w(TAG, 1, "getWadlTask not find task appId:" + str);
            return null;
        }
        return execQuerySQL.get(0);
    }

    private boolean isCmdShouldBeProcessed(int i3) {
        if (i3 >= 1002 && i3 <= 1010) {
            return true;
        }
        return false;
    }

    private WadlParams parseCursorToWadlParams(Cursor cursor) {
        WadlParams wadlParams = new WadlParams();
        int columnIndex = cursor.getColumnIndex("downloadType");
        if (columnIndex > -1) {
            wadlParams.downloadType = cursor.getInt(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex("appId");
        if (columnIndex2 > -1) {
            wadlParams.appId = cursor.getString(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("packageName");
        if (columnIndex3 > -1) {
            wadlParams.packageName = cursor.getString(columnIndex3);
        }
        int columnIndex4 = cursor.getColumnIndex("downloadUrl");
        if (columnIndex4 > -1) {
            wadlParams.apkUrl = cursor.getString(columnIndex4);
        }
        int columnIndex5 = cursor.getColumnIndex(WadlProxyConsts.APKSIGN);
        if (columnIndex5 > -1) {
            wadlParams.apkSign = cursor.getString(columnIndex5);
        }
        int columnIndex6 = cursor.getColumnIndex("versionCode");
        if (columnIndex6 > -1) {
            wadlParams.versionCode = cursor.getInt(columnIndex6);
        }
        int columnIndex7 = cursor.getColumnIndex("name");
        if (columnIndex7 > -1) {
            wadlParams.appName = cursor.getString(columnIndex7);
        }
        int columnIndex8 = cursor.getColumnIndex("iconUrl");
        if (columnIndex8 > -1) {
            wadlParams.iconUrl = cursor.getString(columnIndex8);
        }
        int columnIndex9 = cursor.getColumnIndex(WadlProxyConsts.CHANNEL);
        if (columnIndex9 > -1) {
            wadlParams.apkChannel = cursor.getString(columnIndex9);
        }
        int columnIndex10 = cursor.getColumnIndex("via");
        if (columnIndex10 > -1) {
            wadlParams.via = cursor.getString(columnIndex10);
        }
        int columnIndex11 = cursor.getColumnIndex(WadlProxyConsts.FLAGS);
        if (columnIndex11 > -1) {
            wadlParams.flags = cursor.getInt(columnIndex11);
        }
        int columnIndex12 = cursor.getColumnIndex(WadlProxyConsts.FROM_URL);
        if (columnIndex12 > -1) {
            wadlParams.fromWebUrl = cursor.getString(columnIndex12);
        }
        int columnIndex13 = cursor.getColumnIndex("actionFrom");
        if (columnIndex13 > -1) {
            wadlParams.from = cursor.getInt(columnIndex13);
        }
        int columnIndex14 = cursor.getColumnIndex("adtag");
        if (columnIndex14 > -1) {
            wadlParams.adtag = cursor.getString(columnIndex14);
        }
        int columnIndex15 = cursor.getColumnIndex(WadlProxyConsts.EXTRA_DATA);
        if (columnIndex15 > -1) {
            wadlParams.extraData = cursor.getString(columnIndex15);
        }
        int columnIndex16 = cursor.getColumnIndex(WadlProxyConsts.NOTICE_COUNT);
        if (columnIndex16 > -1) {
            wadlParams.noticeCount = cursor.getInt(columnIndex16);
        }
        if (cursor.getColumnIndex("mieActId") > -1) {
            wadlParams.mieActId = cursor.getInt(r1);
        }
        return wadlParams;
    }

    private WadlTaskV2 parseCursorToWadlTask(Cursor cursor, WadlParams wadlParams) {
        WadlTaskV2 wadlTaskV2 = new WadlTaskV2(1, wadlParams);
        wadlTaskV2.businessId = 1;
        wadlTaskV2.appId = wadlParams.appId;
        wadlTaskV2.pkgName = wadlParams.packageName;
        int columnIndex = cursor.getColumnIndex("totalSize");
        if (columnIndex > -1) {
            wadlTaskV2.fileSize = cursor.getLong(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex("downloadSize");
        if (columnIndex2 > -1) {
            wadlTaskV2.downloadFileSize = cursor.getLong(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("savePath");
        if (columnIndex3 > -1) {
            wadlTaskV2.downloadFilePath = cursor.getString(columnIndex3);
        }
        int columnIndex4 = cursor.getColumnIndex("status");
        if (columnIndex4 > -1) {
            wadlTaskV2.taskStatus = cursor.getInt(columnIndex4);
        }
        int columnIndex5 = cursor.getColumnIndex(WadlProxyConsts.CREATE_TIME);
        if (columnIndex5 > -1) {
            wadlTaskV2.createTime = cursor.getLong(columnIndex5);
        }
        wadlTaskV2.initProgress();
        return wadlTaskV2;
    }

    public int execDelSQL(String str) {
        return execDelSQL("appId=?", new String[]{str});
    }

    public List<WadlTask> execQuerySQL(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        return execQuerySQL("appId=?", new String[]{str});
    }

    public int execUpdSQL(String str, ContentValues contentValues) {
        return execUpdSQL("appId=?", new String[]{str}, contentValues);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.db.WadlBaseDBHelper
    public ContentValues getContentValue(WadlResult wadlResult, int i3) {
        WadlParams wadlParams;
        if (wadlResult != null && (wadlParams = wadlResult.wadlParams) != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("via", wadlParams.via);
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
            contentValues.put(WadlProxyConsts.NOTICE_COUNT, Integer.valueOf(wadlParams.noticeCount));
            contentValues.put("mieActId", Long.valueOf(wadlParams.mieActId));
            if (i3 == 0) {
                contentValues.put("appId", wadlParams.appId);
                contentValues.put("packageName", wadlParams.packageName);
                contentValues.put("versionCode", Integer.valueOf(wadlParams.versionCode));
                contentValues.put("iconUrl", wadlParams.iconUrl);
                contentValues.put("downloadUrl", wadlParams.apkUrl);
                contentValues.put("name", wadlParams.appName);
                contentValues.put("downloadType", Integer.valueOf(wadlParams.downloadType));
                contentValues.put(WadlProxyConsts.EXT_JSON, createExtJsonByWadlParams(wadlParams));
            }
            return contentValues;
        }
        return null;
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a
    public String getCreateTableFields() {
        return WadlProxyConsts.GAMECENTER_TABLE_FIELDS;
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a
    public String getTableKey() {
        return "appId";
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a, android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        super.onUpgrade(sQLiteDatabase, i3, i16);
        QLog.i(TAG, 1, "onUpgrade oldVersion=" + i3 + ",newVersion=" + i16);
        try {
            sQLiteDatabase.beginTransaction();
            if (i3 < 36) {
                sQLiteDatabase.execSQL("ALTER TABLE " + ((WadlBaseDBHelper) this).tableName + " ADD downloadType INTEGER");
            }
            if (i3 < 35) {
                sQLiteDatabase.execSQL("ALTER TABLE " + ((WadlBaseDBHelper) this).tableName + " ADD mieActId LONG");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.db.WadlBaseDBHelper
    WadlTask parseCursorToTask(Cursor cursor) {
        if (cursor != null) {
            WadlParams parseCursorToWadlParams = parseCursorToWadlParams(cursor);
            int columnIndex = cursor.getColumnIndex(WadlProxyConsts.EXT_JSON);
            if (columnIndex > -1) {
                try {
                    JSONObject jSONObject = new JSONObject(cursor.getString(columnIndex));
                    parseCursorToWadlParams.wadlParamsExt.b(jSONObject);
                    parseCursorToWadlParams.wadlParamsPageInfo.b(jSONObject);
                } catch (JSONException e16) {
                    QLog.e(TAG, 1, "parseExtJsonToWadlParams exception", e16);
                }
            }
            return parseCursorToWadlTask(cursor, parseCursorToWadlParams);
        }
        return null;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        WadlResult wadlResult = (WadlResult) obj;
        if (wadlResult != null && wadlResult.wadlParams != null) {
            if (!isCmdShouldBeProcessed(wadlResult.event)) {
                return;
            }
            WadlParams wadlParams = wadlResult.wadlParams;
            int i3 = wadlResult.event;
            if (i3 == 1007) {
                execDelSQL(wadlParams.appId);
                return;
            }
            if (i3 == 1003) {
                if (getWadlTask(wadlParams.appId) == null) {
                    addWadlTask(wadlResult);
                    return;
                } else {
                    updateWadlTask(wadlResult);
                    return;
                }
            }
            updateWadlTask(wadlResult);
            return;
        }
        QLog.w(TAG, 1, "update WadlResult to db error wadlResult is null");
    }

    public void updateWadlTask(WadlResult wadlResult) {
        ContentValues contentValue = getContentValue(wadlResult, 1);
        if (contentValue != null) {
            int execUpdSQL = execUpdSQL(wadlResult.wadlParams.appId, contentValue);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "updateWadlTask wadlResult=" + wadlResult + ",ret=" + execUpdSQL);
                return;
            }
            return;
        }
        QLog.w(TAG, 1, "updateWadlTask error! ContentValues is null, wadlResult=" + wadlResult);
    }
}
