package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class AvatarPendantUiPlugin extends VasWebviewUiPlugin {
    public static final String KEY_UPDATE_FLAG = "key_update_flag";
    private static final String LOG_TAG = "AvatarPendantUiPlugin";
    public static final int REQUEST_CODE_TAKE_PHOTO = 1;
    public static String sCallbackId;
    public static AvatarPendantJsPlugin sJsHandler;
    public static Uri sUploadPhotoUri;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void OnActivityResume() {
        super.OnActivityResume();
        this.activity.setTitle(HardCodeUtil.qqStr(R.string.juv));
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public String decodeUrl(String str) {
        String str2;
        if (QLog.isColorLevel()) {
            QLog.i(LOG_TAG, 2, "Decode pendant market url: " + str);
        }
        if (str == null) {
            return null;
        }
        String replace = str.replace("[client]", "androidQQ").replace("[version]", AppSetting.f99554n).replace("[system]", Build.VERSION.RELEASE).replace("[device]", Build.DEVICE);
        Intent infoIntent = super.getInfoIntent();
        if (infoIntent.getBooleanExtra(KEY_UPDATE_FLAG, false)) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        String replace2 = replace.replace("[updateFlag]", str2).replace("[updateId]", "" + infoIntent.getIntExtra(VasWebviewConstants.KEY_UPDATE_ID, 0));
        if (QLog.isColorLevel()) {
            QLog.i(LOG_TAG, 2, "After decode pendant market url: " + replace2);
        }
        return replace2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 512L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 35L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        sCallbackId = null;
        sUploadPhotoUri = null;
        sJsHandler = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 32 && !TextUtils.isEmpty(str)) {
            if (str.contains("_bid=160")) {
                ReportController.o(null, "CliOper", "", "", "PendantMarket", "StartLoad", 0, 0, "", "", "", "");
            }
        }
        return super.handleEvent(str, j3, map);
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public boolean onActivityResult(int i3, int i16, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i(LOG_TAG, 2, "onActivityResult, requestCode=" + i3 + ", resultCode=" + i16 + ", data=" + intent);
        }
        if (i3 != 1) {
            if (i3 != 4 || i16 != -1 || intent == null || sJsHandler == null) {
                return false;
            }
            intent.getStringExtra("callbackSn");
            String stringExtra = intent.getStringExtra("result");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", stringExtra);
                super.callJs(sCallbackId + "(" + jSONObject.toString() + ");");
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(LOG_TAG, 2, "Open service failed: " + e16.getMessage());
                }
            }
            return true;
        }
        if (i16 == -1) {
            Uri uri = sUploadPhotoUri;
            if (uri == null) {
                return false;
            }
            String realPathFromContentURI = BaseImageUtil.getRealPathFromContentURI(this.activity, uri);
            int min = Math.min(482, ProfileCardUtil.A(this.activity));
            Intent intent2 = new Intent();
            intent2.putExtra(AvatarPendantJsPlugin.KEY_FORM_PENDANT_PHOTO, true);
            intent2.putExtra("Business_Origin", 100);
            PhotoUtils.startPhotoEdit(intent2, this.activity, QQBrowserActivity.class.getName(), min, min, 1080, 1080, realPathFromContentURI, FaceUtil.getUploadAvatarTempPath());
            sUploadPhotoUri = null;
            return true;
        }
        if (i16 != 0 || sJsHandler == null || sCallbackId == null) {
            return false;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("result", 2);
            super.callJs(sCallbackId + "(" + jSONObject2.toString() + ");");
        } catch (JSONException e17) {
            if (QLog.isColorLevel()) {
                QLog.e(LOG_TAG, 2, "cancel select photo: " + e17.getMessage());
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    protected boolean excuteEvent(String str, long j3, Map<String, Object> map) {
        Intent intent;
        String stringExtra;
        if (j3 != 8589934605L || map == null || (intent = (Intent) map.get("intent")) == null || (stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH")) == null || sJsHandler == null || sCallbackId == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("path", stringExtra);
        Bundle a16 = com.tencent.mobileqq.emosm.a.a("changeAvatar", sCallbackId, sJsHandler.getIPCResponseKey(), bundle);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", 0);
            super.callJs(sCallbackId + "(" + jSONObject.toString() + ");");
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(LOG_TAG, 2, "Failed to notify starting upload avatar:" + e16.getMessage());
            }
        }
        sJsHandler.sendRemoteReq(a16, false, false);
        return true;
    }
}
