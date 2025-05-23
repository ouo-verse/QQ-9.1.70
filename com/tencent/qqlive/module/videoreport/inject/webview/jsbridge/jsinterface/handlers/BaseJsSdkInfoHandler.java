package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.BuildConfig;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.entity.JsSdkVersionEntity;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.IJsHandler;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseJsSdkInfoHandler extends BaseJsHandler implements IJsHandler {
    public BaseJsSdkInfoHandler(WeakReference<Object> weakReference) {
        super(weakReference);
    }

    private int getSdkVersion() {
        return BuildConfig.VERSION_CODE;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.IJsHandler
    public void handle(String str, JSONObject jSONObject) {
        JsSdkVersionEntity jsSdkVersionEntity = new JsSdkVersionEntity(getSdkVersion());
        String callbackId = BaseJsHandler.getCallbackId(jSONObject);
        if (!TextUtils.isEmpty(callbackId)) {
            callback(callbackId, "0", "success", jsSdkVersionEntity);
        }
    }
}
