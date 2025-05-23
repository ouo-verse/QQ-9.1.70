package com.tencent.qqmini.sdk.plugins;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.luggage.wxa.jg.s;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.widget.MiniToast;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class ClipboardJsPlugin extends BaseJsPlugin {
    /* JADX INFO: Access modifiers changed from: private */
    public void showClipboardWarningToast() {
        MiniAppInfo miniAppInfo = getMiniAppInfo();
        Context context = this.mContext;
        if (context != null && miniAppInfo != null) {
            MiniToast.makeText(this.mContext, context.getString(R.string.mini_sdk_read_clipboard_warning, miniAppInfo.name), 0).show();
        }
    }

    @JsEvent({"getClipboardData"})
    public String getClipboardData(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.ClipboardJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                ClipboardManager clipboardManager = (ClipboardManager) ((BaseJsPlugin) ClipboardJsPlugin.this).mContext.getSystemService("clipboard");
                JSONObject jSONObject = new JSONObject();
                try {
                    if (ClipboardMonitor.hasPrimaryClip(clipboardManager)) {
                        ClipData primaryClip = ClipboardMonitor.getPrimaryClip(clipboardManager);
                        if (primaryClip != null) {
                            ClipData.Item itemAt = primaryClip.getItemAt(0);
                            if (itemAt != null) {
                                jSONObject.put("data", itemAt.getText());
                            } else {
                                jSONObject.put("data", "");
                            }
                        } else {
                            jSONObject.put("data", "");
                        }
                    } else {
                        jSONObject.put("data", "");
                    }
                    requestEvent.ok(jSONObject);
                    ClipboardJsPlugin.this.showClipboardWarningToast();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    requestEvent.fail();
                }
            }
        });
        return "";
    }

    @JsEvent({s.NAME})
    public String setClipboardData(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.ClipboardJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject;
                try {
                    jSONObject = new JSONObject(requestEvent.jsonParams);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    jSONObject = new JSONObject();
                }
                try {
                    ClipboardMonitor.setPrimaryClip((ClipboardManager) ((BaseJsPlugin) ClipboardJsPlugin.this).mContext.getSystemService("clipboard"), ClipData.newPlainText(null, jSONObject.optString("data")));
                    requestEvent.ok();
                } catch (Exception e16) {
                    requestEvent.fail(e16.getMessage());
                }
            }
        });
        return "";
    }
}
