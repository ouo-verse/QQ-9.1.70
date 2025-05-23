package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoViewController;
import com.tencent.luggage.wxa.jg.l;
import com.tencent.luggage.wxa.jg.t;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin(lazyLoad = false)
/* loaded from: classes23.dex */
public class ScreenJsPlugin extends BaseJsPlugin {
    private static final String TAG = "ScreenJsPlugin";

    public static float getScreenBrightness(Activity activity) {
        Window window = activity != null ? activity.getWindow() : null;
        if (window == null) {
            return -1.0f;
        }
        float f16 = 0.0f;
        try {
            float f17 = window.getAttributes().screenBrightness;
            if (f17 < 0.0f || f17 > 1.0f) {
                try {
                    f17 = Settings.System.getInt(activity.getContentResolver(), "screen_brightness") / 255.0f;
                } catch (Exception e16) {
                    e = e16;
                    f16 = f17;
                    QMLog.e(TAG, e.getMessage(), e);
                    return f16;
                }
            }
            float f18 = f17 <= 1.0f ? f17 : 1.0f;
            if (f18 < 0.0f) {
                return 0.0f;
            }
            return f18;
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static boolean keepScreenOn(Activity activity, boolean z16) {
        Window window;
        if (activity != null) {
            window = activity.getWindow();
        } else {
            window = null;
        }
        if (window == null) {
            return false;
        }
        if (z16) {
            window.addFlags(128);
            window.clearFlags(1);
        } else {
            window.clearFlags(128);
            window.addFlags(1);
        }
        return true;
    }

    public static void setScreenBrightness(Activity activity, float f16) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f16;
        window.setAttributes(attributes);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
    }

    @JsEvent({t.NAME})
    public String setKeepScreenOn(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.ScreenJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (new JSONObject(requestEvent.jsonParams).optBoolean(GameCenterVideoViewController.PropName.KEEP_SCREEN_ON)) {
                        ScreenJsPlugin.keepScreenOn(((BaseJsPlugin) ScreenJsPlugin.this).mMiniAppContext.getAttachedActivity(), true);
                    } else {
                        ScreenJsPlugin.keepScreenOn(((BaseJsPlugin) ScreenJsPlugin.this).mMiniAppContext.getAttachedActivity(), false);
                    }
                    requestEvent.ok();
                } catch (Throwable th5) {
                    QMLog.e(ScreenJsPlugin.TAG, th5.getMessage(), th5);
                }
            }
        });
        return "";
    }

    @JsEvent({"setScreenBrightness"})
    public String setScreenBrightness(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.ScreenJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    if (jSONObject.has("value")) {
                        ScreenJsPlugin.setScreenBrightness(((BaseJsPlugin) ScreenJsPlugin.this).mMiniAppContext.getAttachedActivity(), (float) jSONObject.optDouble("value"));
                        requestEvent.ok();
                    }
                } catch (Throwable th5) {
                    QMLog.e(ScreenJsPlugin.TAG, th5.getMessage(), th5);
                }
            }
        });
        return "";
    }

    @JsEvent({l.NAME})
    public String getScreenBrightness(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", getScreenBrightness(this.mMiniAppContext.getAttachedActivity()));
            requestEvent.ok(jSONObject);
            return "";
        } catch (Throwable th5) {
            QMLog.e(TAG, th5.getMessage(), th5);
            return "";
        }
    }
}
