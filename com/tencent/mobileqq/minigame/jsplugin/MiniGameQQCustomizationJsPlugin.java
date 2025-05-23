package com.tencent.mobileqq.minigame.jsplugin;

import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.ui.MiniGameQCircleShareHelper;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

/* loaded from: classes33.dex */
public class MiniGameQQCustomizationJsPlugin extends BaseJsPlugin {
    public static final String EVENT_CALLBACK_QQ_CIRCLE = "onShareQQCircleResult";
    public static final String EVENT_SHARE_QQ_CIRCLE = "shareQQCircle";
    private static final String TAG = "MiniGameQQCustomizationJsPlugin";
    private MiniGameQCircleShareHelper miniGameQCircleShareHelper;

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onResume() {
        super.onResume();
    }

    @JsEvent({EVENT_SHARE_QQ_CIRCLE})
    public void shareQQCircle(final RequestEvent requestEvent) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.jsplugin.MiniGameQQCustomizationJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                Activity attachActivity = ((BaseJsPlugin) MiniGameQQCustomizationJsPlugin.this).mMiniAppContext.getAttachActivity();
                if (attachActivity == null) {
                    QMLog.e(MiniGameQQCustomizationJsPlugin.TAG, "activity null error.");
                } else {
                    MiniGameQCircleShareHelper.showShareToQCircleDialog(attachActivity, ((BaseJsPlugin) MiniGameQQCustomizationJsPlugin.this).mMiniAppContext, requestEvent.jsonParams, new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.jsplugin.MiniGameQQCustomizationJsPlugin.1.1
                        @Override // eipc.EIPCResultCallback
                        public void onCallback(EIPCResult eIPCResult) {
                            if (eIPCResult.code == 0) {
                                requestEvent.ok();
                            } else {
                                requestEvent.fail();
                            }
                        }
                    });
                }
            }
        });
    }
}
