package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.text.TextUtils;
import com.qzone.report.QZonePerfReporter;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.af;
import com.tencent.mobileqq.webview.swift.l;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QzoneStringMatcher;
import cooperation.qzone.webviewplugin.famous.QzoneFamousShareJsPlugin;
import cooperation.qzone.webviewplugin.famous.QzoneHomePageJsPlugin;
import cooperation.qzone.webviewplugin.sound.QzoneSoundPlugin;
import cooperation.qzone.webviewplugin.ugcsetting.QzoneUgcSettingJsPlugin;
import java.util.Map;
import org.json.JSONObject;
import s4.c;

/* loaded from: classes38.dex */
public class QZoneWebViewPlugin extends WebViewPlugin implements l {
    public static final int RESULT_OK = -1;
    private static final String TAG = "QZoneWebViewPlugin";
    private QzoneInternalWebViewPlugin[] insidePlugins;
    private boolean needClearHistory;

    public static int generateRequestCode(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, int i3) {
        y d16 = bVar.d(bVar.a());
        return d16 instanceof af ? ((af) d16).switchRequestCode(webViewPlugin, (byte) i3) : i3;
    }

    private void initInsidePlugins() {
        QzoneInternalWebViewPlugin[] qzoneInternalWebViewPluginArr = this.insidePlugins;
        if (qzoneInternalWebViewPluginArr == null || qzoneInternalWebViewPluginArr.length == 0) {
            QzoneInternalWebViewPlugin[] qzoneInternalWebViewPluginArr2 = {new QZonePublishSecretShuoShuoH5Plugin(), new QzoneUgcSettingJsPlugin(), new QzoneVipPaymentJsPlugin(), new QzoneBlogJsPlugin(), new QzonePersonalizeJsPlugin(), new QzoneMoodPlugin(), new QzoneDeviceTagJsPlugin(), new QZoneFeedActionJsPlugin(), new QzoneDynamicAlbumPlugin(), new QzonePhotoWallPlugin(), new QZoneGiftFullScreenJsPlugin(), new QZonePassivePraiseJsPlugin(), new QzoneQunFeedJsPlugin(), new QzoneAlbumSelectJSPlugin(), new QzoneAlbumJsPlugin(), new QzoneReactMessageDeliverPlugin(), new QZoneLiveJsPlugin(), new QzoneVideoTabJsPlugin(), new QzoneFamousShareJsPlugin(), new QZoneEventTagJsPlugin(), new QzoneSettingJsPlugin(), new QzoneBasicJsPlugin(), new QzoneInterActiveVideoPlugin(), new QzoneUiJsPlugin(), new QZoneDNSAnalyzeJsPlugin(), new QzoneSoundPlugin(), new QZoneSharePictureJsPlugin(), new QzoneCommonJsPlugin(), new QzoneBannerJsPlugin(), new QZonePublishVoiceShuoShuoH5Plugin(), new QzoneWanbaJsPlugin(), new QzoneHomePageJsPlugin(), new QzoneRecommedPhotoJsPlugin(), new QzoneUserHomePageJsPlugin(), new QZoneCategoryAlbumPlugin(), new QZoneECLiveJsPlugin(), new AdvFloatVideoJsPlugin(), new QZoneMediaWebPlugin(), new QZoneIntimateSpaceJsPlugin()};
            this.insidePlugins = qzoneInternalWebViewPluginArr2;
            for (QzoneInternalWebViewPlugin qzoneInternalWebViewPlugin : qzoneInternalWebViewPluginArr2) {
                qzoneInternalWebViewPlugin.initRuntime(this);
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void callJs(String str, String... strArr) {
        super.callJs(str, strArr);
    }

    @Override // com.tencent.mobileqq.webview.swift.l
    public String[] getMultiNameSpace() {
        return new String[]{"Qzone", "qzDynamicAlbum", QZoneJsConstants.PKGNAME_IMAGEPICKER, QZoneJsConstants.PKGNAME_QZONE_INTERACTIVE_VIDEO, QZoneJsConstants.PKGNAME_QZONE_EC_LIVE, QZoneJsConstants.PKGNAME_QZUI, QZoneJsConstants.PKGNAME_QZONE_AUDIO_RECORD, "Qzone", QZoneJsConstants.PKGNAME_QZONE_CHECKIN};
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        if ("Qzone".equals(str) || "qzDynamicAlbum".equals(str) || QZoneJsConstants.PKGNAME_IMAGEPICKER.equals(str) || QZoneJsConstants.PKGNAME_QZONE_CHECKIN.equals(str) || QZoneJsConstants.PKGNAME_QZONE_INTERACTIVE_VIDEO.equals(str)) {
            return 8589934591L;
        }
        if ("gdtReportPlugin".equals(str)) {
            return 2L;
        }
        return super.getWebViewEventByNameSpace(str);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        if ("Qzone".equals(str) || "qzDynamicAlbum".equals(str) || QZoneJsConstants.PKGNAME_IMAGEPICKER.equals(str) || QZoneJsConstants.PKGNAME_QZONE_CHECKIN.equals(str) || QZoneJsConstants.PKGNAME_QZONE_INTERACTIVE_VIDEO.equals(str)) {
            return 4294967295L;
        }
        return super.getWebViewSchemaByNameSpace(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 8589934601L && !TextUtils.isEmpty(str) && (str.startsWith("https://qzs.qzone.qq.com/qzone/hybrid/module/sendGift/index.html") || str.startsWith("https://qzs.qzone.qq.com/qzone/hybrid/module/gift/mall.html"))) {
            this.mRuntime.a().setResult(0, new Intent());
            this.mRuntime.a().finish();
            return true;
        }
        initInsidePlugins();
        for (QzoneInternalWebViewPlugin qzoneInternalWebViewPlugin : this.insidePlugins) {
            if (qzoneInternalWebViewPlugin.handleEvent(str, j3, map)) {
                return true;
            }
        }
        if (j3 == 8589934594L && this.needClearHistory) {
            WebViewPlugin.b bVar = this.mRuntime;
            CustomWebView e16 = bVar != null ? bVar.e() : null;
            if (e16 != null) {
                e16.clearHistory();
            }
            this.needClearHistory = false;
        }
        return 1024 == j3 && handleBanUrlOrScheme(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!str2.equals("Qzone") && !str2.equals("qzDynamicAlbum") && !str2.equals(QZoneJsConstants.PKGNAME_IMAGEPICKER) && !str2.equals(QZoneJsConstants.PKGNAME_QZONE_INTERACTIVE_VIDEO) && !str2.equals(QZoneJsConstants.PKGNAME_QZUI) && !str2.equals(QZoneJsConstants.PKGNAME_QZONE_AUDIO_RECORD) && !str2.equals(QZoneJsConstants.PKGNAME_QZONE_EC_LIVE) && !str2.equals(QZoneJsConstants.PKGNAME_QZONE_CHECKIN) && !str2.equals(QZoneJsConstants.PKGNAME_QZONE_INTIMATE_SPACE)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest pkgName: " + str2 + ",method: " + str3);
        }
        initInsidePlugins();
        for (QzoneInternalWebViewPlugin qzoneInternalWebViewPlugin : this.insidePlugins) {
            if (qzoneInternalWebViewPlugin.handleJsRequest(jsBridgeListener, str, str2, str3, strArr)) {
                QZonePerfReporter.f59697a.j("js_bridge", "[JsBridge]" + str2 + "#" + str3);
                return true;
            }
        }
        return QZoneWebViewJsHandleLogic.disPatchMethod(this, this.mRuntime, str3, strArr);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        initInsidePlugins();
        for (QzoneInternalWebViewPlugin qzoneInternalWebViewPlugin : this.insidePlugins) {
            qzoneInternalWebViewPlugin.onActivityResult(intent, b16, i3);
        }
        if (b16 == 1) {
            if (i3 == -1) {
                this.mRuntime.a().finish();
                return;
            }
            return;
        }
        if (b16 == 2) {
            if (intent == null || !intent.getBooleanExtra("needJump", false) || this.mRuntime.a() == null) {
                return;
            }
            this.mRuntime.a().finish();
            return;
        }
        if (b16 == 3 && i3 == -1) {
            try {
                String stringExtra = intent.getStringExtra("uin");
                String stringExtra2 = intent.getStringExtra(c.CELLID);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", stringExtra2);
                jSONObject.put("uin", stringExtra);
                dispatchJsEvent("deleteMessageSuccess", jSONObject, new JSONObject());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        initInsidePlugins();
        for (QzoneInternalWebViewPlugin qzoneInternalWebViewPlugin : this.insidePlugins) {
            qzoneInternalWebViewPlugin.onDestroy();
        }
    }

    private boolean handleBanUrlOrScheme(String str) {
        boolean z16;
        CustomWebView e16;
        try {
            Intent intent = this.mRuntime.a().getIntent();
            z16 = intent != null && intent.getBooleanExtra("fromQZone", false);
            e16 = this.mRuntime.e();
        } catch (Exception e17) {
            QLog.e(TAG, 1, "handleBanUrlOrScheme error", e17);
        }
        return QzoneStringMatcher.needIgoreUrl(e16 != null ? e16.getUrl() : null, str, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public Object handleEvent(String str, long j3) {
        initInsidePlugins();
        for (QzoneInternalWebViewPlugin qzoneInternalWebViewPlugin : this.insidePlugins) {
            Object handleEvent = qzoneInternalWebViewPlugin.handleEvent(str, j3);
            if (handleEvent != null) {
                return handleEvent;
            }
        }
        return null;
    }
}
