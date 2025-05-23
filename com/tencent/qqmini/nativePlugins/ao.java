package com.tencent.qqmini.nativePlugins;

import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class ao extends BaseJsPlugin {
    @JsEvent({"freeTrafficCardModel"})
    public void freeTrafficCardModel(RequestEvent requestEvent) {
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optJSONObject("data").optString("from", "MiniApp");
            IVasFTManager vasFtManager = VasUtil.getService().getVasFtManager();
            JSONObject json = vasFtManager.obtainCardInfo(optString).toJson();
            json.put("cardStates", vasFtManager.obtainCardState(optString));
            requestEvent.ok(json);
        } catch (Exception e16) {
            requestEvent.fail(e16.getMessage());
            QLog.d("TreasureCardMiniJsPlugin", 2, e16.getMessage());
        }
    }
}
