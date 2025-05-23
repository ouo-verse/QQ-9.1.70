package com.tencent.gamecenter.wadl.biz.jsplugin;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameInterruptService;
import com.tencent.gamecenter.wadl.base.GameCenterInterruptFragment;
import com.tencent.gamecenter.wadl.biz.entity.ApkInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.g;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameShareLinkReporter;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.Pair;
import java.net.URL;
import java.util.Random;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;

/* loaded from: classes6.dex */
public class GameCenterInterruptPlugin extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private Random f106840d = new Random();

    public GameCenterInterruptPlugin() {
        QLog.d("Wadl_GameCenterInterruptPlugin", 1, "init");
        QRoute.api(IQQGameConfigService.class);
        if (MobileQQ.sProcessId == 7) {
            ((IQQGameInterruptService) QRoute.api(IQQGameInterruptService.class)).checkConfigUpdate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(final String str) {
        DialogUtil.createCustomDialog(this.mRuntime.a(), 230, "", HardCodeUtil.qqStr(R.string.zzy), HardCodeUtil.qqStr(R.string.f213085p9), HardCodeUtil.qqStr(R.string.zzz), new DialogInterface.OnClickListener() { // from class: com.tencent.gamecenter.wadl.biz.jsplugin.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameCenterInterruptPlugin.this.y(str, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.gamecenter.wadl.biz.jsplugin.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameCenterInterruptPlugin.z(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit B(CustomWebView customWebView, String str, Integer num) {
        customWebView.loadUrl(str);
        return null;
    }

    private void E(Activity activity, CustomWebView customWebView, ApkInfo apkInfo, String str, String str2) {
        QLog.i("Wadl_GameCenterInterruptPlugin", 1, "doMatcherDownload apkInfo=" + apkInfo);
        Intent intent = activity.getIntent();
        String url = customWebView.getUrl();
        if (TextUtils.isEmpty(url)) {
            url = customWebView.getOriginalUrl();
        }
        WadlParams wadlParams = new WadlParams(apkInfo.appId, apkInfo.pkgName);
        wadlParams.actionCode = 2;
        wadlParams.downloadType = 5;
        wadlParams.isRes = false;
        wadlParams.apkChannel = apkInfo.channel;
        wadlParams.appName = apkInfo.appName;
        wadlParams.apkUrl = apkInfo.defUrl;
        wadlParams.via = str2;
        wadlParams.from = 6;
        wadlParams.fromWebUrl = url;
        Intent intent2 = new Intent(WadlProxyConsts.ACTION_GAME_CENTER_MAIN_PROCESS_ACTION);
        intent2.setPackage(MobileQQ.sMobileQQ.getPackageName());
        intent2.putExtra("key_event_id", 9);
        intent2.putExtra(GameCenterReceiver.KEY_WADL_PARAMS, wadlParams);
        MobileQQ.sMobileQQ.sendBroadcast(intent2);
        t(str2, apkInfo, customWebView, intent);
        if (!GameCenterUtil.isHippyScheme(str)) {
            customWebView.loadUrl(str);
        } else {
            activity.startActivity(GameCenterUtil.createHippyIntent(str));
            activity.finish();
        }
    }

    private void t(String str, ApkInfo apkInfo, WebView webView, Intent intent) {
        String str2;
        Pair<Integer, String> sessionInfo = GameCenterUtil.getSessionInfo(intent);
        if (webView != null) {
            str2 = webView.getUrl();
            if (TextUtils.isEmpty(str2)) {
                str2 = webView.getOriginalUrl();
            }
        } else {
            str2 = "";
        }
        QLog.i("Wadl_GameCenterInterruptPlugin", 1, "doInterceptDownloadReport refer=" + str2);
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId(WadlProxyConsts.OPER_ID_URL_INTERRUPT).setGameAppId(apkInfo.appId).setExt(2, String.valueOf(sessionInfo.first)).setExt(3, sessionInfo.second).setExt(4, apkInfo.channel).setExt(5, apkInfo.defUrl).setExt(6, str2).setExt(7, str).report();
    }

    private void u(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.jsplugin.GameCenterInterruptPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                ((IGameShareLinkReporter) QRoute.api(IGameShareLinkReporter.class)).reportGameShareLink(str);
            }
        }, 16, null, false);
    }

    private boolean v(Activity activity, CustomWebView customWebView, ApkInfo apkInfo, String str, String str2) {
        Intent intent = activity.getIntent();
        if ("1".equals(intent.getStringExtra("wadl_intercept"))) {
            return false;
        }
        QLog.i("Wadl_GameCenterInterruptPlugin", 1, "doInterruptDownload apkInfo=" + apkInfo);
        if (apkInfo.jumpType == 0) {
            E(activity, customWebView, apkInfo, str2, WadlProxyConsts.VIA_INTERRUPT_JOINT);
        } else {
            w(WadlProxyConsts.VIA_INTERRUPT_JOINT, activity, customWebView, intent, apkInfo, str);
        }
        return true;
    }

    private boolean w(String str, Activity activity, WebView webView, Intent intent, ApkInfo apkInfo, String str2) {
        if (activity != null && !activity.isFinishing()) {
            t(str, apkInfo, webView, intent);
            Intent intent2 = new Intent();
            intent2.putExtra("game_appid", apkInfo.appId);
            intent2.putExtra("orign_appid", str2);
            intent2.putExtra(CrashRtInfoHolder.BeaconKey.GAME_NAME, apkInfo.appName);
            QPublicFragmentActivityForTool.start(activity, intent2, GameCenterInterruptFragment.class);
            activity.finish();
            return true;
        }
        return false;
    }

    private boolean x(final String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.contains("filter_refer=gamecenter") || !str2.toLowerCase().endsWith(".apk")) {
            return false;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.jsplugin.b
            @Override // java.lang.Runnable
            public final void run() {
                GameCenterInterruptPlugin.this.A(str);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(String str, DialogInterface dialogInterface, int i3) {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) this.mRuntime.a().getSystemService("clipboard");
            if (clipboardManager == null) {
                return;
            }
            ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText(null, str));
            QQToast.makeText(this.mRuntime.a(), R.string.f13490000, 0).show();
        } catch (Throwable th5) {
            QLog.e("Wadl_GameCenterInterruptPlugin", 1, "[handleIntercept], th:", th5);
        }
    }

    protected void C(int i3, String str, String str2, String str3) {
        QLog.i("Wadl_GameCenterInterruptPlugin", 1, "reportMatchUrl ext41=" + str3 + JefsClass.INDEX_URL + str + ", rate=" + i3);
        if (i3 > 0 && i3 <= 100 && new Random().nextInt(100) < i3) {
            WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
            wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperType("20").setOperId(WadlProxyConsts.OPER_ID_INTERRUPT_MATCH).setExt(41, str3).setExt(42, str).setExt(43, str2);
            wadlReportBuilder.report();
        }
    }

    protected void D(String str, String str2, String str3) {
        if (GameCenterUtil.isContainsUnMatchUrl(str)) {
            return;
        }
        GameCenterUtil.putUnMatchUrl(str);
        QLog.i("Wadl_GameCenterInterruptPlugin", 1, "reportUnMatchUrl ext41=" + str3 + JefsClass.INDEX_URL + str);
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperType("20").setOperId(WadlProxyConsts.OPER_ID_INTERRUPT_UNMATCH).setExt(41, str3).setExt(42, str).setExt(43, str2);
        wadlReportBuilder.report();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "gameCenter";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        return 3L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c3 A[Catch: all -> 0x01a3, TryCatch #0 {all -> 0x01a3, blocks: (B:3:0x0005, B:7:0x001f, B:9:0x002b, B:14:0x0037, B:16:0x0041, B:17:0x0056, B:20:0x005d, B:22:0x0075, B:23:0x007d, B:25:0x0084, B:29:0x0095, B:30:0x009c, B:32:0x00a2, B:34:0x00a8, B:37:0x00b0, B:39:0x00c3, B:41:0x00cf, B:43:0x00d6, B:46:0x00db, B:48:0x00df, B:50:0x00ed, B:54:0x00fd, B:56:0x0101, B:60:0x0112, B:62:0x0138, B:64:0x0180, B:67:0x0190), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d6 A[Catch: all -> 0x01a3, TryCatch #0 {all -> 0x01a3, blocks: (B:3:0x0005, B:7:0x001f, B:9:0x002b, B:14:0x0037, B:16:0x0041, B:17:0x0056, B:20:0x005d, B:22:0x0075, B:23:0x007d, B:25:0x0084, B:29:0x0095, B:30:0x009c, B:32:0x00a2, B:34:0x00a8, B:37:0x00b0, B:39:0x00c3, B:41:0x00cf, B:43:0x00d6, B:46:0x00db, B:48:0x00df, B:50:0x00ed, B:54:0x00fd, B:56:0x0101, B:60:0x0112, B:62:0x0138, B:64:0x0180, B:67:0x0190), top: B:2:0x0005 }] */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleSchemaRequest(final String str, String str2) {
        WebViewPlugin.b bVar;
        String str3;
        g gVar;
        ApkInfo apkInfo;
        try {
            QLog.d("Wadl_GameCenterInterruptPlugin", 1, "[handleSchemaRequest] url" + str);
            bVar = this.mRuntime;
        } catch (Throwable th5) {
            QLog.e("Wadl_GameCenterInterruptPlugin", 1, "handleSchemaRequest error =" + th5.toString());
        }
        if (bVar == null) {
            return false;
        }
        Activity a16 = bVar.a();
        final CustomWebView e16 = this.mRuntime.e();
        if (a16 != null && !a16.isFinishing() && e16 != null && str != null) {
            String cookieUrl = e16.getCookieUrl();
            if (QLog.isDevelopLevel()) {
                QLog.d("Wadl_GameCenterInterruptPlugin", 1, "cookieUrl:" + cookieUrl);
            }
            if (x(cookieUrl, str)) {
                return true;
            }
            URL url = new URL(str);
            String host = url.getHost();
            String path = url.getPath();
            u(str);
            com.tencent.gamecenter.wadl.biz.a aVar = com.tencent.gamecenter.wadl.biz.a.f106712d;
            if (aVar.f(str)) {
                aVar.a(str, new Function1() { // from class: com.tencent.gamecenter.wadl.biz.jsplugin.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit B;
                        B = GameCenterInterruptPlugin.B(CustomWebView.this, str, (Integer) obj);
                        return B;
                    }
                });
            }
            ApkInfo apkInfo2 = null;
            if (!TextUtils.isEmpty(path)) {
                int lastIndexOf = path.lastIndexOf("/");
                int length = path.length();
                if (lastIndexOf >= 0 && length > 0 && length > lastIndexOf) {
                    str3 = path.substring(lastIndexOf + 1, length);
                    if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(path) && !TextUtils.isEmpty(str3)) {
                        gVar = (g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
                        if (gVar != null) {
                            if (this.f106840d.nextInt(10) == 8) {
                                D(str, host, "-2");
                            }
                            return false;
                        }
                        if (!gVar.f106795h) {
                            return false;
                        }
                        if (gVar.f106798k) {
                            apkInfo2 = ((IQQGameInterruptService) QRoute.api(IQQGameInterruptService.class)).matchByJointRegex(host, path, str);
                        }
                        if (apkInfo2 == null && str3.toLowerCase().lastIndexOf(".apk") < 0) {
                            return false;
                        }
                        if (apkInfo2 == null && gVar.f106796i) {
                            apkInfo = gVar.d(str);
                        } else {
                            apkInfo = apkInfo2;
                        }
                        if (apkInfo == null) {
                            new com.tencent.gamecenter.wadl.biz.entity.d().o("2000943").h("interrupt_4").q("page_auto_update_check").j(3, str).j(4, host).b();
                            D(str, host, "1");
                            return false;
                        }
                        new com.tencent.gamecenter.wadl.biz.entity.d().k(apkInfo.appId).o("2000946").h("interrupt_1").q("page_auto_update_check").r(apkInfo.pkgName).l(apkInfo.appName).j(3, apkInfo.defUrl).j(4, apkInfo.channel).j(11, String.valueOf(apkInfo.versionCode)).b();
                        int i3 = apkInfo.from;
                        if (i3 == 1) {
                            C(gVar.C, str, host, "1");
                            return v(a16, e16, apkInfo, str, gVar.f106791d);
                        }
                        if (i3 == 0) {
                            C(gVar.C, str, host, "3");
                            E(a16, e16, apkInfo, gVar.f106790c, WadlProxyConsts.VIA_INTERRUPT_BY_REGEX);
                            return true;
                        }
                        return false;
                    }
                }
            }
            str3 = null;
            if (!TextUtils.isEmpty(host)) {
                gVar = (g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
                if (gVar != null) {
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        com.tencent.gamecenter.wadl.biz.a.f106712d.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(DialogInterface dialogInterface, int i3) {
    }
}
