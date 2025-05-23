package com.tencent.gamecenter.wadl.sdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTaskV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlVMDBHelper extends WadlBaseDBHelper {
    public static final String TAG = "VM_WadlVMDBHelper";

    public WadlVMDBHelper(Context context, String str) {
        super(context, str);
    }

    private WadlTask getWadlTask(String str) {
        List<WadlTask> execQuerySQL = execQuerySQL(str);
        if (execQuerySQL.size() == 0) {
            QLog.w(TAG, 1, "getWadlTask not find task packageName:" + str);
            return null;
        }
        return execQuerySQL.get(0);
    }

    private boolean isCmdShouldBeProcessed(int i3) {
        if (i3 >= 1002 && i3 <= 1008) {
            return true;
        }
        return false;
    }

    public int execDelSQL(String str) {
        return execDelSQL("packageName=?", new String[]{str});
    }

    public List<WadlTask> execQuerySQL(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        return execQuerySQL("packageName=?", new String[]{str});
    }

    public int execUpdSQL(String str, ContentValues contentValues) {
        return execUpdSQL("packageName=?", new String[]{str}, contentValues);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.db.WadlBaseDBHelper
    public ContentValues getContentValue(WadlResult wadlResult, int i3) {
        WadlParams wadlParams;
        if (wadlResult != null && (wadlParams = wadlResult.wadlParams) != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("packageName", wadlParams.packageName);
            contentValues.put("appId", wadlParams.appId);
            contentValues.put("iconUrl", wadlParams.iconUrl);
            contentValues.put("downloadUrl", wadlParams.apkUrl);
            contentValues.put("via", wadlParams.via);
            contentValues.put("name", wadlParams.appName);
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
            return contentValues;
        }
        return null;
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a
    public String getCreateTableFields() {
        return WadlProxyConsts.VM_TABLE_FIELDS;
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a
    public String getTableKey() {
        return "packageName";
    }

    @Override // com.tencent.gamecenter.wadl.sdk.db.WadlBaseDBHelper
    WadlTask parseCursorToTask(Cursor cursor) {
        if (cursor != null) {
            WadlParams wadlParams = new WadlParams();
            int columnIndex = cursor.getColumnIndex("appId");
            int columnIndex2 = cursor.getColumnIndex("packageName");
            int columnIndex3 = cursor.getColumnIndex("downloadUrl");
            int columnIndex4 = cursor.getColumnIndex(WadlProxyConsts.APKSIGN);
            int columnIndex5 = cursor.getColumnIndex("versionCode");
            int columnIndex6 = cursor.getColumnIndex("name");
            int columnIndex7 = cursor.getColumnIndex("iconUrl");
            int columnIndex8 = cursor.getColumnIndex(WadlProxyConsts.CHANNEL);
            int columnIndex9 = cursor.getColumnIndex("via");
            int columnIndex10 = cursor.getColumnIndex(WadlProxyConsts.FLAGS);
            int columnIndex11 = cursor.getColumnIndex(WadlProxyConsts.FROM_URL);
            int columnIndex12 = cursor.getColumnIndex("actionFrom");
            int columnIndex13 = cursor.getColumnIndex("adtag");
            int columnIndex14 = cursor.getColumnIndex(WadlProxyConsts.EXTRA_DATA);
            if (columnIndex >= 0 && columnIndex2 >= 0 && columnIndex3 >= 0 && columnIndex4 >= 0 && columnIndex5 >= 0 && columnIndex6 >= 0 && columnIndex7 >= 0 && columnIndex8 >= 0 && columnIndex9 >= 0 && columnIndex10 >= 0 && columnIndex11 >= 0 && columnIndex12 >= 0 && columnIndex13 >= 0 && columnIndex14 >= 0) {
                wadlParams.appId = cursor.getString(columnIndex);
                wadlParams.packageName = cursor.getString(columnIndex2);
                wadlParams.apkUrl = cursor.getString(columnIndex3);
                wadlParams.apkSign = cursor.getString(columnIndex4);
                wadlParams.versionCode = cursor.getInt(columnIndex5);
                wadlParams.appName = cursor.getString(columnIndex6);
                wadlParams.iconUrl = cursor.getString(columnIndex7);
                wadlParams.apkChannel = cursor.getString(columnIndex8);
                wadlParams.via = cursor.getString(columnIndex9);
                wadlParams.flags = cursor.getInt(columnIndex10);
                wadlParams.fromWebUrl = cursor.getString(columnIndex11);
                wadlParams.from = cursor.getInt(columnIndex12);
                wadlParams.adtag = cursor.getString(columnIndex13);
                wadlParams.extraData = cursor.getString(columnIndex14);
                int columnIndex15 = cursor.getColumnIndex("totalSize");
                int columnIndex16 = cursor.getColumnIndex("downloadSize");
                int columnIndex17 = cursor.getColumnIndex("savePath");
                int columnIndex18 = cursor.getColumnIndex("status");
                int columnIndex19 = cursor.getColumnIndex(WadlProxyConsts.CREATE_TIME);
                if (columnIndex15 >= 0 && columnIndex16 >= 0 && columnIndex17 >= 0 && columnIndex18 >= 0 && columnIndex19 >= 0) {
                    WadlTaskV2 wadlTaskV2 = new WadlTaskV2(3, wadlParams);
                    wadlTaskV2.businessId = 3;
                    wadlTaskV2.appId = wadlParams.appId;
                    wadlTaskV2.pkgName = wadlParams.packageName;
                    wadlTaskV2.fileSize = cursor.getLong(columnIndex15);
                    wadlTaskV2.downloadFileSize = cursor.getLong(columnIndex16);
                    wadlTaskV2.downloadFilePath = cursor.getString(columnIndex17);
                    wadlTaskV2.taskStatus = cursor.getInt(columnIndex18);
                    wadlTaskV2.createTime = cursor.getLong(columnIndex19);
                    return wadlTaskV2;
                }
                return null;
            }
            return null;
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
                execDelSQL(wadlParams.packageName);
                return;
            } else {
                if (i3 == 1003) {
                    if (getWadlTask(wadlParams.packageName) == null) {
                        addWadlTask(wadlResult);
                        return;
                    }
                    return;
                }
                updateWadlTask(wadlResult);
                return;
            }
        }
        QLog.w(TAG, 1, "update WadlResult to db error wadlResult is null");
    }

    public void updateWadlTask(WadlResult wadlResult) {
        ContentValues contentValue = getContentValue(wadlResult, 1);
        if (contentValue != null) {
            int execUpdSQL = execUpdSQL(wadlResult.wadlParams.packageName, contentValue);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "updateWadlTask wadlResult=" + wadlResult + ",ret=" + execUpdSQL);
                return;
            }
            return;
        }
        QLog.w(TAG, 1, "updateWadlTask error! wadlResult=" + wadlResult);
    }
}
