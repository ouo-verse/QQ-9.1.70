package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecommon.processor.QZoneSwitchProcessor;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.s;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneSettingJsPlugin extends QzoneInternalWebViewPlugin {
    public static final int ALWAYS_BIG = 1;
    public static final int ALWAYS_SMALL = 2;
    public static final int AUTO = 0;
    public static final String NAMESPACE = "Qzone";
    public static final String TAG = "QzoneSettingJsPlugin";
    private static boolean gIsInitSupportPerformance = false;
    private static boolean gIsSupportPerformanceDevice = false;

    private void handleGetInteractSoundMode(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        String str;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return;
        }
        try {
            str = new JSONObject(strArr[0]).getString("callback");
        } catch (JSONException e16) {
            QZLog.w(TAG, 4, "handleGetInteractSoundMode: json error " + strArr[0], e16);
            str = null;
        }
        if (str == null) {
            return;
        }
        webViewPlugin.callJs("window." + str + "({new_value:0})");
        QLog.i(TAG, 4, "handleGetInteractSoundMode: false");
    }

    private void handleGetWaterMark(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        String str;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return;
        }
        String str2 = null;
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            str2 = jSONObject.getString("callback");
            str = jSONObject.getString("type");
        } catch (JSONException e16) {
            QZLog.w("QZoneWatermark", 1, "handleGetWaterMark: json error " + strArr[0], e16);
            str = "";
        }
        if (str2 == null) {
            return;
        }
        long longAccountUin = webViewPlugin.mRuntime.b().getLongAccountUin();
        String str3 = "window." + str2 + oo.b.h(str);
        webViewPlugin.callJs(str3);
        QLog.i("QZoneWatermark", 1, "handleGetWaterMark,content:" + str3 + " uin:" + longAccountUin);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
    
        if (r4.getInt("value") != 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleSetWaterMark(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        boolean z16;
        String str;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return;
        }
        z16 = false;
        str = null;
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            str = jSONObject.getString("type");
        } catch (JSONException e16) {
            QZLog.w("QZoneWatermark", 1, "handleSetWaterMark: json error " + strArr[0], e16);
        }
        z16 = true;
        long longAccountUin = webViewPlugin.mRuntime.b().getLongAccountUin();
        oo.b.n(str, z16);
        QLog.i("QZoneWatermark", 1, "handleSetWaterMark,type:" + str + ",status:" + z16 + " uin:" + longAccountUin);
    }

    private boolean handleUpdateFontList(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16 = webViewPlugin.mRuntime.a();
        if (a16 == null || a16.isFinishing()) {
            return false;
        }
        RemoteHandleManager.getInstance().getSender().handleUpdateFontList();
        QLog.i(TAG, 4, "---handleUpdateFontList-:");
        return true;
    }

    public static boolean isSupportPerformanceDevice() {
        if (!gIsSupportPerformanceDevice) {
            gIsInitSupportPerformance = ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(1, 1);
            gIsSupportPerformanceDevice = true;
        }
        return gIsInitSupportPerformance;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (str2.equals("Qzone") && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if (str3.equalsIgnoreCase("setShowRemindfeed")) {
                handleWriteReceiveNotifyPush(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("setVideoPlayMode")) {
                handleVideoPlayModeSetting(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("setGifPlayMode")) {
                handleGifPlayModeSetting(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("setPictureMode")) {
                handlePictureModeSetting(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("setShowFont")) {
                handleShowFontSetting(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("getPictureMode")) {
                handlePictureModeGet(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("getShowRemindfeed")) {
                handleReadReceiveNotifyPush(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("getVideoPlayMode")) {
                handleVideoPlayModeGet(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("getGifPlayMode")) {
                handleGifPlayModeGet(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("getShowFont")) {
                handleShowFontGet(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("setShowSparkleFont")) {
                handleShowSparkleFontSetting(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("getShowSparkleFont")) {
                handleShowSparkleFontGet(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("setShowCommentBubble")) {
                handleShowCommentBubbleSetting(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("getShowCommentBubble")) {
                handleShowCommentBubbleGet(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("setPassivePraiseSwitch")) {
                handlePassivePraiseSet(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("getPassivePraiseSwitch")) {
                handlePassivePraiseGet(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("isSupportParticleEffect")) {
                handleIsSupportParticleEffect(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.METHOD_UPDATE_CUSTOM_PRAISE)) {
                handleUpdateCustomPraise(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(IndividuationPlugin.Method_setRightButton)) {
                handleSetRightButton(jsBridgeListener, this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("setFeedSkinSwitch")) {
                handleFeedSkinSet(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("getFeedSkinSwitch")) {
                handleFeedSkinGet(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase(QZoneJsConstants.METHOD_UPDATE_PLOYMORPHIC_PRAISE)) {
                handleUpdatePloymorphicPraise(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("updateFontList")) {
                handleUpdateFontList(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("getCustomBrowseInfoSwitch")) {
                handleGetCustomBrowseInfoSwitch(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("enableCustomBrowseInfo")) {
                handleCustomBrowseInfoSwitchSetting(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("setInteractSoundMode")) {
                handleSetInteractSoundMode(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("getInteractSoundMode")) {
                handleGetInteractSoundMode(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("getWaterMark")) {
                handleGetWaterMark(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("setWaterMark")) {
                handleSetWaterMark(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("setAllowLocalPhotosScanSwitch")) {
                handleLocalPhotoScanSet(this.parentPlugin, strArr);
                return true;
            }
            if (str3.equalsIgnoreCase("getAllowLocalPhotosScanSwitch")) {
                handleLocalPhotoScanGet(this.parentPlugin, strArr);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (new org.json.JSONObject(r4[0]).getInt("enable") == 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean handleCustomBrowseInfoSwitchSetting(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        boolean z16 = false;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        z16 = true;
        RemoteHandleManager.getInstance().getSender().notifyCustomBrowserChanged(z16);
        QLog.i(TAG, 4, "---notifyCustomBrowserChanged-:" + z16);
        return true;
    }

    private boolean handleFeedSkinGet(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        String str;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            str = new JSONObject(strArr[0]).getString("callback");
        } catch (JSONException e16) {
            e16.printStackTrace();
            str = "";
        }
        boolean bool = LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_FEED_SKIN_ENABLE, true);
        webViewPlugin.callJs("window." + str + "({isOpen:" + (bool ? 1 : 0) + "})");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("---handleFeedSkinGet-:");
        sb5.append(bool);
        QLog.i(TAG, 4, sb5.toString());
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (new org.json.JSONObject(r4[0]).getInt("value") == 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean handleFeedSkinSet(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        boolean z16 = false;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        z16 = true;
        LocalMultiProcConfig.putBool(LocalMultiProcConfig.QZONE_FEED_SKIN_ENABLE, z16);
        RemoteHandleManager.getInstance().getSender().notifyFeedSkinSwitchChagned();
        QLog.i(TAG, 4, "---handlefeedSkinEnable-:" + z16);
        return true;
    }

    private boolean handleGetCustomBrowseInfoSwitch(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        String str;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            str = new JSONObject(strArr[0]).getString("callback");
        } catch (JSONException e16) {
            e16.printStackTrace();
            str = "";
        }
        boolean bool = LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_FEED_CUSTOM_BROWSER_DECO_SWITCH, true);
        webViewPlugin.callJs("window." + str + "({enable:" + (bool ? 1 : 0) + "})");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("---customBrowserInfoSwitch-:");
        sb5.append(bool);
        QLog.i(TAG, 4, sb5.toString());
        return true;
    }

    private boolean handleGifPlayModeGet(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        String str;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            str = new JSONObject(strArr[0]).getString("callback");
        } catch (JSONException e16) {
            e16.printStackTrace();
            str = "";
        }
        boolean bool = LocalMultiProcConfig.getBool(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, LocalMultiProcConfig.QZONE_SET_PLAYMODE, true);
        webViewPlugin.callJs("window." + str + "({new_value:" + (bool ? 1 : 0) + "})");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("---handleGifPlayModeGet-:");
        sb5.append(bool);
        QLog.i(TAG, 4, sb5.toString());
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (new org.json.JSONObject(r6[0]).getInt("new_value") == 0) goto L19;
     */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean handleGifPlayModeSetting(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        boolean z16 = false;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        z16 = true;
        QLog.i(TAG, 4, "---handleGifPlayModeSetting-:" + z16);
        LocalMultiProcConfig.putBool(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, LocalMultiProcConfig.QZONE_SET_PLAYMODE, z16);
        a16.sendBroadcast(new Intent("com.tencent.qq.GifPlaySetting"));
        return true;
    }

    private boolean handleIsSupportParticleEffect(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        String str;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            str = new JSONObject(strArr[0]).getString("callback");
        } catch (JSONException e16) {
            e16.printStackTrace();
            str = "";
        }
        boolean isSupportPerformanceDevice = isSupportPerformanceDevice();
        webViewPlugin.callJs("window." + str + "({enable:" + (isSupportPerformanceDevice ? 1 : 0) + "})");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("---handleIsSupportParticleEffect-:");
        sb5.append(isSupportPerformanceDevice ? 1 : 0);
        QLog.i(TAG, 4, sb5.toString());
        return true;
    }

    private boolean handleLocalPhotoScanGet(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        String str;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            str = new JSONObject(strArr[0]).getString("callback");
        } catch (JSONException e16) {
            e16.printStackTrace();
            str = "";
        }
        long longAccountUin = webViewPlugin.mRuntime.b().getLongAccountUin();
        int int4Uin = LocalMultiProcConfig.getInt4Uin(LocalMultiProcConfig.QZONE_LOCAL_PHOTO_SCAN_ENABLED, 0, longAccountUin);
        webViewPlugin.callJs("window." + str + "({isON:" + int4Uin + "})");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("---handleLocalPhotoScanGet-:");
        sb5.append(int4Uin);
        sb5.append(",uin=");
        sb5.append(longAccountUin);
        QLog.i(TAG, 4, sb5.toString());
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    private boolean handleLocalPhotoScanSet(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        ?? r06 = 0;
        r06 = 0;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            if (new JSONObject(strArr[0]).getInt("isON") != 0) {
                r06 = 1;
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        long longAccountUin = webViewPlugin.mRuntime.b().getLongAccountUin();
        LocalMultiProcConfig.putInt4Uin(LocalMultiProcConfig.QZONE_LOCAL_PHOTO_SCAN_ENABLED, r06, longAccountUin);
        QLog.i(TAG, 4, "---handleLocalPhotoScanSet-:" + ((boolean) r06) + ",uin=" + longAccountUin);
        LpReportInfo_pf00064.allReport(1200, 5, r06 != 0 ? 1 : 2);
        LpReportInfo_pf00064.allReport(146, 4, r06 != 0 ? 1 : 2);
        return true;
    }

    private boolean handlePassivePraiseGet(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        String str;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            str = new JSONObject(strArr[0]).getString("callback");
        } catch (JSONException e16) {
            e16.printStackTrace();
            str = "";
        }
        boolean bool = LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_PASSIVE_PRAISE_ENABLED, true);
        webViewPlugin.callJs("window." + str + "({isOpen:" + (bool ? 1 : 0) + "})");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("---handlePassivePraiseGet-:");
        sb5.append(bool);
        QLog.i(TAG, 4, sb5.toString());
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (new org.json.JSONObject(r4[0]).getInt("value") == 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean handlePassivePraiseSet(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        boolean z16 = false;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        z16 = true;
        LocalMultiProcConfig.putBool(LocalMultiProcConfig.QZONE_PASSIVE_PRAISE_ENABLED, z16);
        QLog.i(TAG, 4, "---handleShowSparkleFontSetting-:" + z16);
        return true;
    }

    private boolean handlePictureModeGet(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        String str;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            str = new JSONObject(strArr[0]).getString("callback");
        } catch (JSONException e16) {
            e16.printStackTrace();
            str = "";
        }
        int i3 = LocalMultiProcConfig.getInt(a16.getResources().getString(R.string.f173080h51), 0);
        webViewPlugin.callJs("window." + str + "({new_value:" + i3 + "})");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("---handlePictureModeGet-:");
        sb5.append(i3);
        QLog.i(TAG, 4, sb5.toString());
        return true;
    }

    private boolean handlePictureModeSetting(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        int i3 = 0;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            i3 = new JSONObject(strArr[0]).getInt("new_value");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        a16.sendBroadcast(new Intent("com.tencent.qq.syncNoPhotoSetting"));
        QLog.i(TAG, 4, "---handlePictureModeSetting-:" + i3);
        LocalMultiProcConfig.putInt(a16.getResources().getString(R.string.f173080h51), i3);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v3 */
    private boolean handleReadReceiveNotifyPush(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        String str;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        long longAccountUin = webViewPlugin.mRuntime.b().getLongAccountUin();
        try {
            str = new JSONObject(strArr[0]).getString("callback");
        } catch (JSONException e16) {
            e16.printStackTrace();
            str = "";
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(QZoneSwitchProcessor.f260939a);
        sb5.append("_");
        sb5.append(longAccountUin);
        ?? r06 = from.decodeInt(sb5.toString(), 0) == 0 ? 1 : 0;
        this.parentPlugin.callJs("window." + str + "({new_value:" + ((int) r06) + "})");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("---handleGetReceiveNotifyPushRelatedToMe-:");
        sb6.append((boolean) r06);
        QLog.i(TAG, 4, sb6.toString());
        return true;
    }

    private boolean handleSetRightButton(JsBridgeListener jsBridgeListener, WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            int optInt = jSONObject.optInt("iconID");
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("callback");
            boolean optBoolean = jSONObject.optBoolean("hidden");
            jSONObject.optBoolean("disable");
            s g16 = webViewPlugin.mRuntime.g();
            if (g16 != null && g16.getWebTitleBarInterface() != null) {
                g16.getWebTitleBarInterface().jg(optString2, optString, null, optBoolean, optInt + 1000, 0, null, null);
            }
        } catch (JSONException unused) {
        }
        return true;
    }

    private boolean handleShowCommentBubbleGet(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        String str;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            str = new JSONObject(strArr[0]).getString("callback");
        } catch (JSONException e16) {
            e16.printStackTrace();
            str = "";
        }
        boolean bool = LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_BARRAGE_EFFECT_ENABLED, true);
        webViewPlugin.callJs("window." + str + "({new_value:" + (bool ? 1 : 0) + "})");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("---handleShowCommentBubbleGet-:");
        sb5.append(bool);
        QLog.i(TAG, 4, sb5.toString());
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (new org.json.JSONObject(r4[0]).getInt("new_value") == 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean handleShowCommentBubbleSetting(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        boolean z16 = false;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        z16 = true;
        RemoteHandleManager.getInstance().getSender().notifyBarrageEffectChanged(z16);
        QLog.i(TAG, 4, "---handleShowCommentBubbleSetting-:" + z16);
        return true;
    }

    private boolean handleShowFontGet(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        String str;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            str = new JSONObject(strArr[0]).getString("callback");
        } catch (JSONException e16) {
            e16.printStackTrace();
            str = "";
        }
        boolean bool = LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_FONT_ENABLED, true);
        webViewPlugin.callJs("window." + str + "({new_value:" + (bool ? 1 : 0) + "})");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("---handleShowFontGet-:");
        sb5.append(bool);
        QLog.i(TAG, 4, sb5.toString());
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (new org.json.JSONObject(r4[0]).getInt("new_value") == 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean handleShowFontSetting(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        boolean z16 = false;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        z16 = true;
        RemoteHandleManager.getInstance().getSender().notifyFontChanged(z16);
        QLog.i(TAG, 4, "---handleShowFontSetting-:" + z16);
        return true;
    }

    private boolean handleShowSparkleFontGet(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        String str;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            str = new JSONObject(strArr[0]).getString("callback");
        } catch (JSONException e16) {
            e16.printStackTrace();
            str = "";
        }
        boolean bool = LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_SUPER_FONT_ENABLED, true);
        webViewPlugin.callJs("window." + str + "({new_value:" + (bool ? 1 : 0) + "})");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("---handleShowSparkleFontGet-:");
        sb5.append(bool);
        QLog.i(TAG, 4, sb5.toString());
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (new org.json.JSONObject(r4[0]).getInt("new_value") == 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean handleShowSparkleFontSetting(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        boolean z16 = false;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        z16 = true;
        RemoteHandleManager.getInstance().getSender().notifySuperFontChanged(z16);
        QLog.i(TAG, 4, "---handleShowSparkleFontSetting-:" + z16);
        return true;
    }

    private boolean handleUpdateCustomPraise(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        RemoteHandleManager.getInstance().getSender().updateCustomPraise(strArr[0]);
        QLog.i(TAG, 4, "---handleUpdateCustomPraise-:" + strArr[0]);
        return true;
    }

    private boolean handleUpdatePloymorphicPraise(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        RemoteHandleManager.getInstance().getSender().UpdatePloymorphicPraise(strArr[0]);
        QLog.i(TAG, 4, "---handleUpdatePloymorphicPraise-:" + strArr[0]);
        return true;
    }

    private boolean handleVideoPlayModeGet(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        String str;
        int i3;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            str = new JSONObject(strArr[0]).getString("callback");
        } catch (JSONException e16) {
            e16.printStackTrace();
            str = "";
        }
        if (!LocalMultiProcConfig.getBool(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, LocalMultiProcConfig.QZONE_SET_VIDEOPLAYMODE, true)) {
            LocalMultiProcConfig.putBool(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, LocalMultiProcConfig.QZONE_SET_VIDEOPLAYMODE, true);
            i3 = 2;
        } else {
            i3 = LocalMultiProcConfig.getInt(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, LocalMultiProcConfig.QZONE_SET_PLAYMODE, 0);
        }
        webViewPlugin.callJs("window." + str + "({new_value:" + i3 + "})");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("---handleVideoPlayModeGet-:");
        sb5.append(i3);
        QLog.i(TAG, 4, sb5.toString());
        return true;
    }

    private boolean handleVideoPlayModeSetting(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        int i3 = 0;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            i3 = new JSONObject(strArr[0]).getInt("new_value");
            reportConfigInfo(i3);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        QLog.i(TAG, 4, "---handleVideoPlayModeSetting-:" + i3);
        LocalMultiProcConfig.putInt(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, LocalMultiProcConfig.QZONE_SET_PLAYMODE, i3);
        a16.sendBroadcast(new Intent("com.tencent.qq.VideoPlaySetting"));
        return true;
    }

    private boolean handleWriteReceiveNotifyPush(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        boolean z16 = false;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        webViewPlugin.mRuntime.b().getLongAccountUin();
        try {
            if (new JSONObject(strArr[0]).getInt("new_value") != 0) {
                z16 = true;
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        QLog.i(TAG, 4, "---handleReceiveNotifyPushRelatedToMeSetting-:" + z16);
        QZoneSwitchProcessor.c(webViewPlugin.mRuntime.b(), z16);
        return true;
    }

    private void reportConfigInfo(int i3) {
        int i16 = i3 != 0 ? i3 != 1 ? i3 != 2 ? -1 : 9 : 7 : 8;
        if (i16 != -1) {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_COMMON_SETTING, 2, i16);
        }
    }

    private void handleSetInteractSoundMode(WebViewPlugin webViewPlugin, String[] strArr) {
    }
}
