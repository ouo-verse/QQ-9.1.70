package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import android.view.Window;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class SecureWindowJsPlugin extends BaseJsPlugin {
    @JsEvent({"toggleSecureWindow"})
    public void toggleSecureWindow(final RequestEvent requestEvent) {
        try {
            final boolean z16 = new JSONObject(requestEvent.jsonParams).getBoolean("status");
            Activity attachedActivity = this.mMiniAppContext.getAttachedActivity();
            if (attachedActivity == null) {
                QMLog.e("SecureWindowJsPlugin", "toggleSecureWindow: Attached activity is null!");
                requestEvent.fail();
                return;
            }
            final Window window = attachedActivity.getWindow();
            if (window == null) {
                QMLog.e("SecureWindowJsPlugin", "toggleSecureWindow: Attached activity is invisible.");
                requestEvent.fail();
            } else {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.SecureWindowJsPlugin.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z16) {
                            window.addFlags(8192);
                        } else {
                            window.clearFlags(8192);
                        }
                        requestEvent.ok();
                    }
                });
            }
        } catch (JSONException e16) {
            QMLog.e("SecureWindowJsPlugin", "toggleSecureWindow: parse event jsonParams error with ", e16);
            requestEvent.fail();
        }
    }
}
