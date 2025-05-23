package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class ImmersiveJsPlugin extends BaseJsPlugin {
    public static final String API_SET_MEUN_STYLE = "setMenuStyle";
    public static final String API_SET_STATUS_BAR_STYLE = "setStatusBarStyle";
    private static final String STATUS_BAR_STYLE_BLACK = "black";
    private static final String STATUS_BAR_STYLE_WHITE = "white";
    private static final String STYLE_TAG = "style";
    private static final String TAG = "ImmersivePlugin";

    /* JADX INFO: Access modifiers changed from: private */
    public static void setStatusBarTextColor(Activity activity, boolean z16) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.getDecorView().setSystemUiVisibility(1282);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        if (z16) {
            window.getDecorView().setSystemUiVisibility(9218);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin
    public boolean onInterceptJsEvent(RequestEvent requestEvent) {
        if (!this.mIsMiniGame) {
            requestEvent.fail();
            return true;
        }
        return super.onInterceptJsEvent(requestEvent);
    }

    @JsEvent({"setMenuStyle"})
    public String setMenuStyle(RequestEvent requestEvent) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(requestEvent.jsonParams);
        } catch (Throwable unused) {
            jSONObject = new JSONObject();
        }
        if (this.mMiniAppContext.getAttachActivity() == null) {
            return ApiUtil.wrapCallbackFail(requestEvent.event, null, "activity not exist").toString();
        }
        String optString = jSONObject.optString("style", null);
        if (!TextUtils.isEmpty(optString) && (MiniAppConst.MENU_STYLE_LIGHT.equals(optString) || MiniAppConst.MENU_STYLE_DARK.equals(optString))) {
            MiniAppEnv.g().setMenuStyle(optString);
            return requestEvent.ok();
        }
        return requestEvent.fail("invalid style " + optString);
    }

    @JsEvent({API_SET_STATUS_BAR_STYLE})
    public String setStatusBarStyle(RequestEvent requestEvent) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(requestEvent.jsonParams);
        } catch (Throwable unused) {
            jSONObject = new JSONObject();
        }
        final Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        if (attachActivity == null) {
            return ApiUtil.wrapCallbackFail(requestEvent.event, null, "activity not exist").toString();
        }
        final String optString = jSONObject.optString("style", null);
        if (!TextUtils.isEmpty(optString) && ("white".equals(optString) || "black".equals(optString))) {
            attachActivity.runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.ImmersiveJsPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    ImmersiveJsPlugin.setStatusBarTextColor(attachActivity, "black".equals(optString));
                }
            });
            return requestEvent.ok();
        }
        return requestEvent.fail("invalid style " + optString);
    }
}
