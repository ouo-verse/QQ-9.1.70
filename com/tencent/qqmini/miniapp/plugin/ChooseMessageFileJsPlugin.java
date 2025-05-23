package com.tencent.qqmini.miniapp.plugin;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class ChooseMessageFileJsPlugin extends BaseJsPlugin {
    private static final String TAG = "ChooseMessageFileJsPlugin";
    private ArrayList<String> validType = new ArrayList<>(Arrays.asList("all", QAdVrReportParams.ParamKey.MEDIA, "image", "file"));

    private IActivityResultListener getActivityResultListener(final RequestEvent requestEvent) {
        return new IActivityResultListener() { // from class: com.tencent.qqmini.miniapp.plugin.ChooseMessageFileJsPlugin.1
            @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
            public boolean doOnActivityResult(int i3, int i16, Intent intent) {
                QMLog.d(ChooseMessageFileJsPlugin.TAG, "doOnActivityResult requestCode" + i3 + " resultCode:" + i16);
                if (i3 == 6001) {
                    ChooseMessageFileJsPlugin.this.hanldeActivityResult(intent, requestEvent, i16);
                    ActivityResultManager.g().removeActivityResultListener(this);
                    return true;
                }
                return false;
            }
        };
    }

    private String getRetName(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("/");
            if (split.length > 0) {
                return split[split.length - 1];
            }
            return str;
        }
        return str;
    }

    private JSONArray getTempFileJsonArray(Intent intent) throws JSONException {
        if (QUAUtil.isQQMainApp()) {
            return ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getChooseMessageTempFilesArray(intent);
        }
        return new JSONArray(intent.getStringExtra("tempFiles"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hanldeActivityResult(Intent intent, RequestEvent requestEvent, int i3) {
        if (i3 == -1) {
            try {
                MiniAppFileManager miniAppFileManager = (MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class);
                if (miniAppFileManager == null) {
                    requestEvent.fail("fileManager error");
                    return;
                }
                JSONArray tempFileJsonArray = getTempFileJsonArray(intent);
                if (tempFileJsonArray != null && tempFileJsonArray.length() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    for (int i16 = 0; i16 < tempFileJsonArray.length(); i16++) {
                        JSONObject jSONObject2 = (JSONObject) tempFileJsonArray.get(i16);
                        if (jSONObject2.has("path")) {
                            String string = jSONObject2.getString("path");
                            String wxFilePathByExistLocalPath = miniAppFileManager.getWxFilePathByExistLocalPath(string);
                            QMLog.i(TAG, "path : " + string + "; wxPath : " + wxFilePathByExistLocalPath);
                            jSONObject2.put("path", wxFilePathByExistLocalPath);
                            jSONObject2.put("name", getRetName(string));
                        }
                    }
                    jSONObject.put("tempFiles", tempFileJsonArray);
                    requestEvent.ok(jSONObject);
                    return;
                }
                requestEvent.fail("tempFilesArray length error.");
                QMLog.e(TAG, "hanldeActivityResult tempFilesArray length error");
                return;
            } catch (Throwable th5) {
                QMLog.e(TAG, "hanldeActivityResult error,", th5);
                requestEvent.fail("result ok exception");
                return;
            }
        }
        QMLog.e(TAG, "hanldeActivityResult cancel, resultCode is " + i3);
        requestEvent.fail("cancel");
    }

    private boolean validateChooseMessageFileParams(int i3, String str) {
        if (i3 > 0 && i3 <= 100 && !TextUtils.isEmpty(str) && this.validType.contains(str)) {
            return true;
        }
        QMLog.e(TAG, "validateChooseMessageFileParams count : " + i3 + "; type : " + str);
        return false;
    }

    @JsEvent({"chooseMessageFile"})
    public String chooseMessageFile(RequestEvent requestEvent) {
        try {
            if (!TextUtils.isEmpty(requestEvent.jsonParams)) {
                JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                int optInt = jSONObject.optInt("count", -1);
                String optString = jSONObject.optString("type", "");
                if (!validateChooseMessageFileParams(optInt, optString)) {
                    requestEvent.fail("parameter error");
                    return "";
                }
                IActivityResultListener activityResultListener = getActivityResultListener(requestEvent);
                ActivityResultManager.g().addActivityResultListener(activityResultListener);
                if (!((ChannelProxy) ProxyManager.get(ChannelProxy.class)).startChooseMessageFileActivityForResult(this.mMiniAppContext.getAttachActivity(), optInt, optString, 6001)) {
                    QMLog.e(TAG, "chooseMessageFile not support");
                    requestEvent.fail("not support");
                    ActivityResultManager.g().removeActivityResultListener(activityResultListener);
                }
            } else {
                QMLog.e(TAG, "chooseMessageFile jsonParams is null.");
                requestEvent.fail("parameter error");
            }
        } catch (Throwable th5) {
            requestEvent.fail("exception");
            QMLog.e(TAG, "chooseMessageFile exception.", th5);
        }
        return "";
    }
}
