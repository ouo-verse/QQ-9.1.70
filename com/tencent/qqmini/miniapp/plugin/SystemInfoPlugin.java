package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import com.tencent.qqmini.miniapp.util.logmonitor.ILoadLogListener;
import com.tencent.qqmini.miniapp.util.logmonitor.LogBean;
import com.tencent.qqmini.miniapp.util.logmonitor.LogBeanUtil;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

@JsPlugin
/* loaded from: classes23.dex */
public class SystemInfoPlugin extends BaseJsPlugin {
    public static final String TAG = "SystemInfoPlugin";
    private MiniAppProxy mMiniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);

    private DisplayMetrics getDisplayMetrics() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    private String getNavBarSytle(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.mApkgInfo.getAppConfigInfo().getPageInfo(str).windowInfo.navigationBarInfo.style;
        }
        return "default";
    }

    private String getPageUrl() {
        String pageUrl = PageAction.obtain(this.mMiniAppContext).getPageUrl();
        if (StringUtil.isEmpty(pageUrl)) {
            String str = this.mMiniAppInfo.launchParam.entryPath;
            ApkgInfo apkgInfo = this.mApkgInfo;
            String str2 = apkgInfo.mAppConfigInfo.entryPagePath;
            if (!apkgInfo.isUrlFileExist(str)) {
                return str2;
            }
            return str;
        }
        return pageUrl;
    }

    private int getRelHeight(DisplayMetrics displayMetrics, Activity activity) {
        boolean z16;
        boolean z17 = false;
        if (!DisplayUtil.checkNavigationBarShow(this.mContext) && !DisplayUtil.isFlymeOS7NavBarShow()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (activity != null && !activity.isFinishing() && !Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            if ((DisplayUtil.hasNavBar(activity) && DisplayUtil.isNavigationBarExist(activity)) || DisplayUtil.isFlymeOS7NavBarShow()) {
                z17 = true;
            }
            z16 = z17;
        }
        if (QMLog.isColorLevel() && !FastClickUtils.isFastDoubleClick("SystemInfoPlugin", 200L)) {
            QMLog.d("SystemInfoPlugin", " hasNavBar : " + z16 + "; " + Build.BRAND);
        }
        int round = (int) (Math.round(displayMetrics.heightPixels / displayMetrics.density) + 0.5f);
        if (z16) {
            return round - ((int) (DisplayUtil.getNavigationBarHeight(this.mContext) / displayMetrics.density));
        }
        return round;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
    
        if (r8 != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
    
        if (r8 != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getRelWindowHeight(double d16, int i3, int i16) {
        boolean z16;
        int dip2px = (int) ((DisplayUtil.dip2px(this.mContext, 44.0f) / d16) + 0.5d);
        int dip2px2 = (int) ((DisplayUtil.dip2px(this.mContext, 54.0f) / d16) + 0.5d);
        String pageUrl = getPageUrl();
        String navBarSytle = getNavBarSytle(pageUrl);
        ApkgInfo apkgInfo = this.mApkgInfo;
        if (apkgInfo != null && apkgInfo.getAppConfigInfo() != null && this.mApkgInfo.getAppConfigInfo().tabBarInfo != null && this.mApkgInfo.isTabBarPage(pageUrl) && this.mApkgInfo.getAppConfigInfo().tabBarInfo.isShow()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ("default".equals(navBarSytle)) {
            i16 = (i16 - i3) - dip2px;
        }
        return i16 - dip2px2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    @JsEvent({"detectAbnormalLog"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void detectAbnormalLog(final RequestEvent requestEvent) {
        String str;
        JSONObject jSONObject;
        if (this.mContext == null) {
            QMLog.e("SystemInfoPlugin", "detectAbnormalLog error, context is NULL");
            requestEvent.fail("detectAbnormalLog error, context is NULL");
            return;
        }
        String str2 = null;
        try {
            jSONObject = new JSONObject(requestEvent.jsonParams);
            str = jSONObject.optString("logTab", null);
        } catch (JSONException e16) {
            e = e16;
            str = null;
        }
        try {
            str2 = jSONObject.optString("keyErr", null);
        } catch (JSONException e17) {
            e = e17;
            QMLog.e("SystemInfoPlugin", "detectAbnormalLog get a JSONException:", e);
            if (str != null) {
            }
        }
        if (str != null) {
            requestEvent.fail("logTab is null");
        } else {
            LogBeanUtil.loadLogBeanList(str, "E", str2, new ILoadLogListener() { // from class: com.tencent.qqmini.miniapp.plugin.SystemInfoPlugin.1
                @Override // com.tencent.qqmini.miniapp.util.logmonitor.ILoadLogListener
                public void onLoaded(ArrayList<LogBean> arrayList) {
                    if (arrayList != null && arrayList.size() > 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("detectedMsg", arrayList.get(0).f346323msg);
                        } catch (Exception e18) {
                            QMLog.e("SystemInfoPlugin", "loadLogBeanList - onLoaded get a Exception:", e18);
                        }
                        requestEvent.ok(jSONObject2);
                        return;
                    }
                    requestEvent.fail("no errMsg detected");
                }
            });
        }
    }

    @JsEvent({"getSystemInfo", "getSystemInfoSync"})
    public String handleGetSystemInfo(RequestEvent requestEvent) {
        if (this.mContext == null) {
            QMLog.e("SystemInfoPlugin", "getSystemInfo error,context is NULL");
            return requestEvent.fail();
        }
        Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        DisplayMetrics displayMetrics = getDisplayMetrics();
        double d16 = displayMetrics.density;
        int round = (int) (Math.round(DisplayUtil.getStatusBarHeight(this.mContext)) / d16);
        int round2 = (int) (((float) Math.round(displayMetrics.widthPixels / d16)) + 0.5f);
        int relHeight = getRelHeight(displayMetrics, attachActivity);
        int relWindowHeight = getRelWindowHeight(d16, round, relHeight);
        int notchHeight = ImmersiveUtils.getNotchHeight(this.mMiniAppContext.getContext(), attachActivity);
        if (notchHeight == 0) {
            notchHeight = round;
        }
        int i3 = round2 + 0;
        int i16 = relHeight - notchHeight;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("left", 0);
            jSONObject.put("top", notchHeight);
            jSONObject.put("right", round2);
            jSONObject.put("bottom", relHeight);
            jSONObject.put("width", i3);
            jSONObject.put("height", i16);
        } catch (JSONException e16) {
            QMLog.e("SystemInfoPlugin", "getSafeArea", e16);
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("brand", Build.BRAND);
            jSONObject2.put("model", DeviceInfoUtil.getPhoneModel());
            jSONObject2.put("pixelRatio", d16);
            jSONObject2.put("screenWidth", round2);
            jSONObject2.put("screenHeight", relHeight);
            jSONObject2.put("windowWidth", round2);
            jSONObject2.put("windowHeight", relWindowHeight);
            jSONObject2.put("statusBarHeight", round);
            jSONObject2.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, "zh_CN");
            jSONObject2.put("version", this.mMiniAppProxy.getAppVersion());
            jSONObject2.put(TVKPlayerMsg.PLAYER_CHOICE_SYSTEM, "Android " + Build.VERSION.RELEASE);
            jSONObject2.put("platform", "android");
            jSONObject2.put("fontSizeSetting", 16);
            jSONObject2.put("SDKVersion", this.mMiniAppContext.getBaseLibVersion());
            jSONObject2.put("AppPlatform", this.mMiniAppProxy.getAppName());
            jSONObject2.put("safeArea", jSONObject);
            jSONObject2.put("runtimeVersion", "1.83.3.0");
            if (this.mApkgInfo.getAppConfigInfo().darkmode) {
                jSONObject2.put("theme", ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getUserTheme());
            }
            String jSONObject3 = ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject2).toString();
            if ("getSystemInfo".equals(requestEvent.event)) {
                requestEvent.evaluateCallbackJs(jSONObject3);
            }
            if (QMLog.isColorLevel() && !FastClickUtils.isFastDoubleClick("SystemInfoPlugin", 200L)) {
                QMLog.i("SystemInfoPlugin", "getSystemInfo \uff1a " + jSONObject3);
            }
            return jSONObject3;
        } catch (Exception e17) {
            QMLog.e("SystemInfoPlugin", "getSystemInfo exception: " + new Throwable(e17));
            return requestEvent.fail();
        }
    }
}
