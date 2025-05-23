package com.tencent.mobileqq.shortvideo.gesture;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DownloadInfo extends ConfigInfo {
    public static final String spKey_Config = "config";
    public static final String spKey_Ver = "ver";
    static final String spKey_gamemodel_zip_md5 = "gamemodel_zip_md5";
    static final String spKey_model_zip_md5 = "model_zip_md5";
    static final String spKey_so_zip_md5 = "so_zip_md5";
    public static final String spName = "config_qq.android.qavgesture";
    String MD5_so;
    String MD5_zip_gamemodel;
    String MD5_zip_model;
    String MD5_zip_so;
    public boolean enable = false;
    public boolean gameEnable = false;
    String gamemodel_fullname;
    String model_fullname;
    public String so_fullname;
    String so_name;
    double time;
    String url_zip_gamemodel;
    String url_zip_model;
    String url_zip_so;

    public static DownloadInfo get() {
        String string = getSP().getString(spKey_Config, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        DownloadInfo downloadInfo = new DownloadInfo();
        if (!downloadInfo.tryParse("QavGesture", string)) {
            return null;
        }
        return downloadInfo;
    }

    public static SharedPreferences getSP() {
        return BaseApplication.getContext().getSharedPreferences(spName, 4);
    }

    @Override // com.tencent.mobileqq.utils.confighandler.ConfigInfo
    protected boolean parse(JSONObject jSONObject) {
        try {
            this.time = jSONObject.getDouble("time");
            this.enable = jSONObject.getBoolean("enable");
            this.url_zip_so = jSONObject.getString("url_zip_so");
            this.MD5_zip_so = jSONObject.getString("MD5_zip_so");
            this.url_zip_model = jSONObject.getString("url_zip_model");
            this.MD5_zip_model = jSONObject.getString("MD5_zip_model");
            this.MD5_so = jSONObject.getString("MD5_so");
            this.so_fullname = jSONObject.getString("so_fullname");
            this.so_name = jSONObject.getString(NativeMonitorConfigHelper.SUB_KEY_SYMBOL);
            this.model_fullname = jSONObject.getString("model_fullname");
            this.gameEnable = jSONObject.optBoolean("gameenable");
            this.url_zip_gamemodel = jSONObject.optString("url_zip_gamemodel");
            this.MD5_zip_gamemodel = jSONObject.optString("MD5_zip_gamemodel");
            this.gamemodel_fullname = jSONObject.optString("gamemodel_fullname");
            return true;
        } catch (Exception e16) {
            QLog.d("QavGesture", 1, String.format("parseJson, Exception\n%s", e16));
            return false;
        }
    }

    public String toString() {
        return String.format("task_id[%s], time[%s], enable[%s], url_zip_so[%s], MD5_zip_so[%s], url_zip_model[%s], MD5_zip_model[%s], MD5_so[%s]", Integer.valueOf(this.taskId), Double.valueOf(this.time), Boolean.valueOf(this.enable), this.url_zip_so, this.MD5_zip_so, this.url_zip_model, this.MD5_zip_model, this.MD5_so);
    }
}
