package com.tencent.hippy.qq.update;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.api.PackageUpdateListener;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.hippy.qq.update.sign.HippySign;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQUpdateManager implements ReqCallBack {
    private PackageUpdateListener mUpdateListener;

    public static String getGuid() {
        String str;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            str = "0";
        } else {
            str = waitAppRuntime.getAccount();
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = 32;
        if (!TextUtils.isEmpty(str)) {
            i3 = 32 - str.length();
            stringBuffer.append(str);
        }
        for (int i16 = 0; i16 < i3; i16++) {
            stringBuffer.append("0");
        }
        return stringBuffer.toString();
    }

    public void checkUpdate(String str, PackageUpdateListener packageUpdateListener) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.mUpdateListener = packageUpdateListener;
                int moduleVersion = UpdateSetting.getInstance().getModuleVersion(str);
                if (moduleVersion < 0) {
                    moduleVersion = 0;
                }
                sendUpdateRequest(str, moduleVersion, this);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            if (packageUpdateListener != null) {
                packageUpdateListener.onUpdateComplete(1, "", null);
            }
        }
    }

    public void loadOnlineBundle(final String str, final String str2, final PackageUpdateListener packageUpdateListener) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.update.HippyQQUpdateManager.2
            @Override // java.lang.Runnable
            public void run() {
                HippyQQFileUtil.downLoad(str, HippyQQFileUtil.getZipFile(str2, 2147483646), new HippyQQFileUtil.DownLoadCallBack() { // from class: com.tencent.hippy.qq.update.HippyQQUpdateManager.2.1
                    @Override // com.tencent.hippy.qq.update.HippyQQFileUtil.DownLoadCallBack
                    public void onDownloadResult(int i3, File file) {
                        if (QLog.isColorLevel()) {
                            QLog.d(HippyQQConstants.HIPPY_TAG, 2, "loadOnlineBundle onUpdateComplete result:", Integer.valueOf(i3));
                        }
                        if (i3 == 0) {
                            try {
                                String absolutePath = HippyQQFileUtil.getModuleFile(str2, 2147483646).getAbsolutePath();
                                FileUtils.uncompressZip(file.getAbsolutePath(), absolutePath, false);
                                UpdateBase.checkAndResetLocalVersion(str2, 2147483646);
                                PackageUpdateListener packageUpdateListener2 = packageUpdateListener;
                                if (packageUpdateListener2 != null) {
                                    packageUpdateListener2.onUpdateComplete(0, "", absolutePath);
                                }
                            } catch (Exception e16) {
                                QLog.e(HippyQQConstants.HIPPY_TAG, 1, e16, new Object[0]);
                            }
                        }
                    }
                });
            }
        }, 128, null, true);
    }

    @Override // com.tencent.hippy.qq.update.ReqCallBack
    public void onResponse(String str) {
        PackageUpdateListener packageUpdateListener;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i3 = jSONObject.getInt("iResult");
            if (QLog.isColorLevel()) {
                QLog.d(HippyQQConstants.HIPPY_TAG, 2, "Hippy: onResponse iResult=" + i3);
            }
            if (i3 == 0) {
                JSONArray jSONArray = jSONObject.getJSONArray("vstModules");
                if (jSONArray.length() == 0 && (packageUpdateListener = this.mUpdateListener) != null) {
                    packageUpdateListener.onUpdateComplete(1, "", null);
                }
                for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i16);
                    jSONObject2.getInt("iUpdateType");
                    int i17 = jSONObject2.getInt("iVersionCode");
                    jSONObject2.getString("sMaxAppVer");
                    jSONObject2.getString("sMinAppVer");
                    jSONObject2.getString("sMaxSdkVer");
                    jSONObject2.getString("sMinSdkVer");
                    String string = jSONObject2.getString("sModuleName");
                    jSONObject2.getString("sVersionName");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("stTotalPkg");
                    String string2 = jSONObject3.getString("sUrl");
                    int i18 = jSONObject3.getInt("iSize");
                    if (QLog.isColorLevel()) {
                        QLog.d(HippyQQConstants.HIPPY_TAG, 2, "Hippy: onResponse moduleName=" + string + ", version=" + i17 + ", size=" + i18);
                    }
                    new UpdateTotal(string2, jSONObject3.getString("sMd5"), null, string, i17, this.mUpdateListener).startDownload();
                }
                return;
            }
            if (this.mUpdateListener != null) {
                this.mUpdateListener.onUpdateComplete(-5, "check update result: " + i3, null);
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(HippyQQConstants.HIPPY_TAG, 2, "Hippy: onResponse JSONException msg=" + e16.getMessage());
            }
        }
    }

    void sendUpdateRequest(String str, int i3, final ReqCallBack reqCallBack) throws JSONException {
        final JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("iPlatform", 0);
        jSONObject2.put("sAppKey", "mqq");
        jSONObject2.put("sAppVer", AppSetting.f99554n);
        jSONObject2.put("sSdkVer", "3.0");
        jSONObject2.put("sChannel", HippyQQConstants.HIPPY_CHANNEL);
        jSONObject2.put("sGuid", getGuid());
        jSONObject.put("stAppInfo", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("eType", 1);
        jSONObject3.put("iVersionCode", i3);
        jSONObject3.put("sModuleName", str);
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(jSONObject3);
        jSONObject.put("vstModuleInfos", jSONArray);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.hippy.qq.update.HippyQQUpdateManager.1
            @Override // java.lang.Runnable
            public void run() {
                String sign = HippySign.getSign("mqq", HippyQQConstants.APP_SECRET);
                QLog.i("MyUpdate", 1, "sign:" + sign);
                QLog.i("MyUpdate", 1, "req:" + jSONObject.toString());
                String doPost = HttpClient.doPost(HippyQQConstants.SERVER, jSONObject.toString(), sign, HippyQQUpdateManager.this.mUpdateListener);
                ReqCallBack reqCallBack2 = reqCallBack;
                if (reqCallBack2 != null) {
                    reqCallBack2.onResponse(doPost);
                }
            }
        }, 8, null, true);
    }
}
