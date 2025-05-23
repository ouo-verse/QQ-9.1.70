package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class SetAvatarNativePlugin implements NativePlugin {
    public static final String PARAM_ACTION = "param_action";
    public static final String PARAM_AVATAR_PATH = "param_avatar_path";
    public static final String TAG = "SetAvatarNativePlugin";

    /* loaded from: classes33.dex */
    private class AvatarResultCallback implements EIPCResultCallback {
        JSContext mJsContext;

        AvatarResultCallback(JSContext jSContext) {
            this.mJsContext = jSContext;
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
                if (this.mJsContext != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(FaceConstant.HeadParams.PARAM_RESULT_CODE, i3);
                        jSONObject.put(FaceConstant.HeadParams.PARAM_RESULT_DESC, string2);
                    } catch (Exception unused) {
                    }
                    this.mJsContext.evaluateCallback(i3 == 0, jSONObject, string2);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onInvoke(JSONObject jSONObject, JSContext jSContext) {
        QLog.i(TAG, 1, "onInvoke, param=" + jSONObject);
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                jSContext.evaluateCallback(false, new JSONObject("empty data"), "empty data");
                return;
            }
            String absolutePath = MiniAppFileManager.getInstance().getAbsolutePath(optJSONObject.optString("path", null));
            QLog.d(TAG, 1, absolutePath);
            Bundle bundle = new Bundle();
            bundle.putString("param_avatar_path", absolutePath);
            QIPCClientHelper.getInstance().getClient().callServer("CommonModule", "set_avatar", bundle, new AvatarResultCallback(jSContext));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "setAvatar err", th5);
        }
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onDestroy() {
    }
}
