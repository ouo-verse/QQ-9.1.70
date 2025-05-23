package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import com.tencent.qqmini.minigame.helper.PreloadSystemInfoHelper;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

@JsPlugin
@Deprecated
/* loaded from: classes23.dex */
public class GameSystemInfoPlugin extends BaseJsPlugin {
    private static final String DISPLAY_NOTCH_STATUS = "display_notch_status";
    public static final String TAG = "SystemInfoPlugin";
    private MiniAppProxy mMiniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);

    private JSONObject getGameSystemInfo(Context context, MiniAppProxy miniAppProxy, DisplayMetrics displayMetrics, int i3, int i16, boolean z16) {
        boolean z17;
        int i17;
        int i18;
        int i19;
        boolean z18;
        int i26;
        int i27;
        if (context != null && displayMetrics != null) {
            if (miniAppProxy.getDeviceType() == MiniAppProxy.DeviceType.FOLD) {
                if (!z16 && context.getResources().getConfiguration().orientation != 2) {
                    z17 = false;
                } else {
                    z17 = true;
                }
            } else {
                z17 = z16;
            }
            Activity attachActivity = this.mMiniAppContext.getAttachActivity();
            JSONObject jSONObject = new JSONObject();
            try {
                double d16 = displayMetrics.density;
                int statusBarHeight = DisplayUtil.getStatusBarHeight(context);
                jSONObject.put("brand", Build.BRAND);
                jSONObject.put("model", DeviceInfoUtil.getPhoneModel());
                jSONObject.put("pixelRatio", d16);
                jSONObject.put("devicePixelRatio", d16);
                Pair<Integer, Integer> a16 = com.tencent.qqmini.minigame.utils.b.a(context, displayMetrics, z16, i3, i16);
                int intValue = ((Integer) a16.first).intValue();
                int intValue2 = ((Integer) a16.second).intValue();
                int i28 = (int) (statusBarHeight / d16);
                int safeAreaTop = getSafeAreaTop(attachActivity, d16, i28);
                if (z17) {
                    if (((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation() == 3) {
                        i18 = intValue - safeAreaTop;
                        i27 = 0;
                    } else {
                        i27 = safeAreaTop;
                        i18 = intValue;
                    }
                    i19 = i27;
                    i17 = 0;
                } else {
                    i17 = safeAreaTop;
                    i18 = intValue;
                    i19 = 0;
                }
                int i29 = i18 - i19;
                int i36 = intValue2 - i17;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("left", i19);
                    jSONObject2.put("top", i17);
                    jSONObject2.put("right", i18);
                    jSONObject2.put("bottom", intValue2);
                    jSONObject2.put("width", i29);
                    jSONObject2.put("height", i36);
                } catch (JSONException e16) {
                    QMLog.e("SystemInfoPlugin", "getSafeArea", e16);
                }
                jSONObject.put("screenWidth", intValue);
                jSONObject.put("screenHeight", intValue2);
                jSONObject.put("windowWidth", intValue);
                jSONObject.put("windowHeight", intValue2);
                jSONObject.put("statusBarHeight", i28);
                jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, "zh_CN");
                jSONObject.put(TVKPlayerMsg.PLAYER_CHOICE_SYSTEM, "Android " + Build.VERSION.RELEASE);
                jSONObject.put("platform", "android");
                jSONObject.put("fontSizeSetting", 16);
                jSONObject.put("benchmarkLevel", PreloadSystemInfoHelper.a());
                jSONObject.put("safeArea", jSONObject2);
                jSONObject.put("version", miniAppProxy.getAppVersion());
                jSONObject.put("AppPlatform", "qq");
                if (!QUAUtil.isQQMainApp()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                jSONObject.put("isMobileSDK", z18);
                JSONObject jSONObject3 = new JSONObject();
                int dip2px = DisplayUtil.dip2px(context, 9.0f);
                if (LiuHaiUtils.isLiuHaiUseValid() && !z17) {
                    i26 = statusBarHeight;
                } else {
                    i26 = 0;
                }
                jSONObject3.put(NodeProps.MARGIN_TOP, dip2px + i26);
                jSONObject3.put("navbarHeight", DisplayUtil.dip2px(context, 30.0f));
                jSONObject3.put(NodeProps.MARGIN_RIGHT, DisplayUtil.dip2px(context, 12.5f));
                jSONObject3.put("navbarWidth", DisplayUtil.dip2px(context, 80.0f));
                jSONObject.put("navbarPosition", jSONObject3);
                if (isCustomMiniGame()) {
                    jSONObject.put("isDeviceLandscape", z17);
                }
                QMLog.i("SystemInfoPlugin", "minigame getSystemInfo : " + jSONObject.toString());
            } catch (Exception e17) {
                QMLog.e("SystemInfoPlugin", "getSystemInfo error " + e17.getMessage());
            }
            return jSONObject;
        }
        return null;
    }

    private int getSafeAreaTop(Activity activity, double d16, int i3) {
        int b16 = (int) (PreloadSystemInfoHelper.b(activity) / d16);
        if (b16 == 0 && !TextUtils.isEmpty(this.mApkgInfo.mConfigStr)) {
            try {
                if (!new JSONObject(this.mApkgInfo.mConfigStr).optBoolean("showStatusBar", false)) {
                    i3 = b16;
                }
                return i3;
            } catch (JSONException e16) {
                QMLog.e("SystemInfoPlugin", "safeAreaTop JSONException:", e16);
                return b16;
            }
        }
        return b16;
    }

    private boolean isCustomMiniGame() {
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy == null) {
            return false;
        }
        return qQCustomizedProxy.isCustomMiniGame(this.mMiniAppInfo);
    }

    @JsEvent({"getSystemInfo", "getSystemInfoSync"})
    public String handleGetSystemInfo(RequestEvent requestEvent) {
        JSONObject jSONObject;
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getContext() != null) {
            DisplayMetrics displayMetrics = DisplayUtil.getDisplayMetrics(this.mContext);
            if (displayMetrics != null) {
                jSONObject = getGameSystemInfo(this.mMiniAppContext.getContext(), this.mMiniAppProxy, displayMetrics, PageAction.obtain(this.mMiniAppContext).getSurfaceViewWidth(), PageAction.obtain(this.mMiniAppContext).getSurfaceViewHeight(), this.mMiniAppContext.isOrientationLandscape());
            } else {
                jSONObject = null;
            }
            if (jSONObject == null) {
                return requestEvent.fail();
            }
            String jSONObject2 = jSONObject.toString();
            if ("getSystemInfo".equals(requestEvent.event)) {
                requestEvent.evaluateCallbackJs(jSONObject2);
                return jSONObject2;
            }
            return jSONObject.toString();
        }
        QMLog.e("SystemInfoPlugin", "getSystemInfo error,context is NULL");
        return requestEvent.fail();
    }
}
