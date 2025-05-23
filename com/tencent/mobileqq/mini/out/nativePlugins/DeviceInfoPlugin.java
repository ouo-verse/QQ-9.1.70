package com.tencent.mobileqq.mini.out.nativePlugins;

import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class DeviceInfoPlugin implements NativePlugin {
    public static final String API_GET_GUID = "getGUID";
    private static final String TAG = "DeviceInfoPlugin";

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onInvoke(JSONObject jSONObject, final JSContext jSContext) {
        QLog.d(TAG, 1, "onInvoke getGUID");
        QIPCClientHelper.getInstance().callServer("DeviceProtectQIPCModule", "ACTION_GET_GUID_INFO", null, new EIPCResultCallback() { // from class: com.tencent.mobileqq.mini.out.nativePlugins.DeviceInfoPlugin.1
            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                QLog.d(DeviceInfoPlugin.TAG, 1, "ACTION_GET_GUID_INFO onCallback");
                if (eIPCResult == null) {
                    QLog.e(DeviceInfoPlugin.TAG, 1, "ACTION_GET_GUID_INFO error, result is null");
                    return;
                }
                if (eIPCResult.code == 0) {
                    String string = eIPCResult.data.getString("guid", "");
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("guid", string);
                        jSContext.evaluateCallback(true, jSONObject2, "");
                        return;
                    } catch (JSONException e16) {
                        jSContext.evaluateCallback(false, null, e16.getMessage());
                        QLog.e(DeviceInfoPlugin.TAG, 1, "evaluateCallback error : ", e16.getMessage());
                        return;
                    }
                }
                jSContext.evaluateCallback(false, null, String.valueOf(-102));
                QLog.e(DeviceInfoPlugin.TAG, 1, "ACTION_GET_GUID_INFO failed, code return error");
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onDestroy() {
    }
}
