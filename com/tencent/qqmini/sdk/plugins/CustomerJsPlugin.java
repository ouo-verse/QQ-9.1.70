package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class CustomerJsPlugin extends BaseJsPlugin {
    private static final String TAG = "CustomerJsPlugin";
    private ChannelProxy mChannelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);

    @JsEvent({com.tencent.luggage.wxa.p2.a.NAME, "openCustomerServiceConversation"})
    public void openCustomerServiceConversation(final RequestEvent requestEvent) {
        this.mChannelProxy.getRobotUin(this.mApkgInfo.appId, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.CustomerJsPlugin.1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (z16 && jSONObject != null) {
                    Object opt = jSONObject.opt("robotUin");
                    if (opt instanceof String) {
                        String str = (String) opt;
                        if (!TextUtils.isEmpty(str)) {
                            if (!((ChannelProxy) ProxyManager.get(ChannelProxy.class)).openRobotProfileCard(((BaseJsPlugin) CustomerJsPlugin.this).mMiniAppContext.getAttachActivity(), null, str)) {
                                MiniToast.makeText(((BaseJsPlugin) CustomerJsPlugin.this).mContext, 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(((BaseJsPlugin) CustomerJsPlugin.this).mContext) + "\u4e2d\u4e0b\u8f7d\u5e94\u7528", 1);
                                requestEvent.fail("app not implement");
                                return;
                            }
                            requestEvent.ok(jSONObject);
                            return;
                        }
                    }
                    requestEvent.fail("batchGetContact failed.");
                    return;
                }
                QMLog.e(CustomerJsPlugin.TAG, "getRobotUin failed: ");
                requestEvent.fail("batchGetContact failed.");
            }
        });
    }
}
