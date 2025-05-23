package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class LogJsPlugin extends BaseJsPlugin {
    public static final String API_SET_ENABLE_DEBUG = "setEnableDebug";
    public static final String TAG = "LogJsPlugin";
    private static final String TAG_MINI_LOG = "miniAppLog";

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin
    public boolean onInterceptJsEvent(RequestEvent requestEvent) {
        if (!this.mIsMiniGame && "setEnableDebug".equals(requestEvent)) {
            this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 3));
            return true;
        }
        return super.onInterceptJsEvent(requestEvent);
    }

    @JsEvent({"setEnableDebug"})
    public String setEnableDebug(RequestEvent requestEvent) {
        try {
            final boolean optBoolean = new JSONObject(requestEvent.jsonParams).optBoolean("enableDebug");
            if (optBoolean != DebugUtil.getDebugEnabled(this.mMiniAppContext.getMiniAppInfo())) {
                this.mMiniAppContext.getAttachActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.LogJsPlugin.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DialogUtil.createCustomDialog(((BaseJsPlugin) LogJsPlugin.this).mMiniAppContext.getAttachActivity(), 230, "\u91cd\u542f\u540e\u751f\u6548", (String) null, R.string.mini_sdk_cancel, R.string.mini_sdk_ok, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.plugins.LogJsPlugin.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                DebugUtil.setDebugEnabled(((BaseJsPlugin) LogJsPlugin.this).mMiniAppInfo.appId, optBoolean, true);
                                ProcessUtil.exitProcess(((BaseJsPlugin) LogJsPlugin.this).mMiniAppContext);
                            }
                        }, (DialogInterface.OnClickListener) null).show();
                    }
                });
            } else {
                requestEvent.ok();
            }
            return "";
        } catch (JSONException unused) {
            requestEvent.fail();
            return "";
        }
    }
}
