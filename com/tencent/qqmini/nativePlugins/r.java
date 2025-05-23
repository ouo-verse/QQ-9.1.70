package com.tencent.qqmini.nativePlugins;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class r extends BaseJsPlugin {
    @JsEvent({"launchApp"})
    public void launchApp(RequestEvent requestEvent) {
        try {
            JSONObject optJSONObject = new JSONObject(requestEvent.jsonParams).optJSONObject("data");
            String optString = optJSONObject.optString("gameAppID");
            String optString2 = optJSONObject.optString("packageName");
            String optString3 = optJSONObject.optString(WadlProxyConsts.FLAGS);
            String optString4 = optJSONObject.optString("paramsStr");
            eq2.a aVar = new eq2.a();
            try {
                int parseInt = Integer.parseInt(optString3);
                r11 = (parseInt & 67108864) == 67108864 ? 335544320 : 268435456;
                if ((parseInt & 536870912) == 536870912) {
                    r11 |= 536870912;
                }
                if ((parseInt & 4194304) == 4194304) {
                    r11 |= 4194304;
                }
            } catch (Throwable th5) {
                QLog.e("LaunchAppPlugin", 1, "doAction error: " + th5.getMessage());
            }
            aVar.d(((BaseActivity) this.mMiniAppContext.getAttachActivity()).getAppInterface(), this.mContext, optString, optString4, optString2, r11);
        } catch (Throwable th6) {
            QLog.e("LaunchAppPlugin", 1, th6.getMessage());
        }
    }
}
