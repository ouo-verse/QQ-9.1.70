package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.out.nativePlugins.SetAvatarNativePlugin;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class ak extends BaseJsPlugin {

    /* compiled from: P */
    /* loaded from: classes34.dex */
    private class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        private RequestEvent f347007d;

        a(RequestEvent requestEvent) {
            this.f347007d = requestEvent;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (QLog.isColorLevel()) {
                QLog.d(SetAvatarNativePlugin.TAG, 2, "onCallback, result=" + eIPCResult);
            }
            if (eIPCResult == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(SetAvatarNativePlugin.TAG, 2, "onCallback, result.isSuccess=" + eIPCResult.isSuccess());
            }
            Bundle bundle = eIPCResult.data;
            if (bundle == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(SetAvatarNativePlugin.TAG, 2, "onCallback, data is null");
                    return;
                }
                return;
            }
            String string = bundle.getString("param_action");
            if (QLog.isColorLevel()) {
                QLog.d(SetAvatarNativePlugin.TAG, 2, "onCallback, action=" + string);
            }
            if ("set_avatar".equals(string)) {
                int i3 = bundle.getInt(FaceConstant.HeadParams.PARAM_RESULT_CODE, -1);
                String string2 = bundle.getString(FaceConstant.HeadParams.PARAM_RESULT_DESC, "null");
                if (QLog.isColorLevel()) {
                    QLog.d(SetAvatarNativePlugin.TAG, 2, "onCallback, errCode=" + i3 + ", errDesc=" + string2);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(FaceConstant.HeadParams.PARAM_RESULT_CODE, i3);
                    jSONObject.put(FaceConstant.HeadParams.PARAM_RESULT_DESC, string2);
                } catch (Exception unused) {
                }
                if (i3 == 0) {
                    this.f347007d.ok(jSONObject);
                } else {
                    this.f347007d.fail(jSONObject, string2);
                }
            }
        }
    }

    private JSONObject b(RequestEvent requestEvent) {
        try {
            return new JSONObject(requestEvent.jsonParams);
        } catch (JSONException unused) {
            QLog.e(SetAvatarNativePlugin.TAG, 1, "Failed to parse jsonParams=" + requestEvent.jsonParams);
            return null;
        }
    }

    @JsEvent({"uploadAvatar"})
    public void uploadAvatar(RequestEvent requestEvent) {
        try {
            JSONObject b16 = b(requestEvent);
            QLog.i(SetAvatarNativePlugin.TAG, 1, "onInvoke, param=" + b16);
            JSONObject optJSONObject = b16.optJSONObject("data");
            if (optJSONObject == null) {
                requestEvent.fail(new JSONObject("empty data"), "empty data");
                return;
            }
            String absolutePath = ((IMiniAppFileManager) this.mMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(optJSONObject.optString("path", null));
            QLog.d(SetAvatarNativePlugin.TAG, 1, absolutePath);
            Bundle bundle = new Bundle();
            bundle.putString("param_avatar_path", absolutePath);
            QIPCClientHelper.getInstance().getClient().callServer("CommonModule", "set_avatar", bundle, new a(requestEvent));
        } catch (Throwable th5) {
            QLog.e(SetAvatarNativePlugin.TAG, 1, "setAvatar err", th5);
        }
    }
}
