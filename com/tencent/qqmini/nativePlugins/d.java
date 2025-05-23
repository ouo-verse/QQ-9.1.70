package com.tencent.qqmini.nativePlugins;

import com.tencent.mobileqq.mini.out.nativePlugins.DeviceInfoPlugin;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class d extends BaseJsPlugin {

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RequestEvent f347033d;

        a(RequestEvent requestEvent) {
            this.f347033d = requestEvent;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            QLog.d("DeviceInfoPlugin", 1, "ACTION_GET_GUID_INFO onCallback");
            if (eIPCResult == null) {
                QLog.e("DeviceInfoPlugin", 1, "ACTION_GET_GUID_INFO error, result is null");
                return;
            }
            if (eIPCResult.code == 0) {
                String string = eIPCResult.data.getString("guid", "");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("guid", string);
                    this.f347033d.ok(jSONObject);
                    return;
                } catch (JSONException e16) {
                    this.f347033d.fail(e16.getMessage());
                    QLog.e("DeviceInfoPlugin", 1, "evaluateCallback error : ", e16.getMessage());
                    return;
                }
            }
            this.f347033d.fail(String.valueOf(-102));
            QLog.e("DeviceInfoPlugin", 1, "ACTION_GET_GUID_INFO failed, code return error");
        }
    }

    @JsEvent({DeviceInfoPlugin.API_GET_GUID})
    public void checkGameBuddyType(RequestEvent requestEvent) {
        QLog.d("DeviceInfoPlugin", 1, "checkGameBuddyType getGUID");
        QIPCClientHelper.getInstance().callServer("DeviceProtectQIPCModule", "ACTION_GET_GUID_INFO", null, new a(requestEvent));
    }
}
