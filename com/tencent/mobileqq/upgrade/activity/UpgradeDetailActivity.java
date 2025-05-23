package com.tencent.mobileqq.upgrade.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.jsbridge.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.download.c;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import protocol.KQQConfig.UpgradeInfo;

/* compiled from: P */
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes20.dex */
public class UpgradeDetailActivity extends IphoneTitleBarActivity implements Handler.Callback, c.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    WebView f306240a0;

    /* renamed from: b0, reason: collision with root package name */
    ProgressBar f306241b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f306242c0;

    /* renamed from: d0, reason: collision with root package name */
    MqqWeakReferenceHandler f306243d0;

    /* renamed from: e0, reason: collision with root package name */
    boolean f306244e0;

    /* renamed from: f0, reason: collision with root package name */
    private UpgradeDetailWrapper f306245f0;

    /* renamed from: g0, reason: collision with root package name */
    private long f306246g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f306247h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f306248i0;

    /* renamed from: j0, reason: collision with root package name */
    private com.tencent.mobileqq.jsbridge.a f306249j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f306250k0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class JsCover extends a.b {
        static IPatchRedirector $redirector_;

        protected JsCover() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UpgradeDetailActivity.this);
            }
        }

        public String getApkName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return UpgradeDetailActivity.this.f306248i0;
            }
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        public long getApkSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return UpgradeDetailActivity.this.f306246g0;
            }
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }

        public String getApkVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return UpgradeDetailActivity.this.f306247h0;
            }
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        public int getDownloadState() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return com.tencent.mobileqq.upgrade.k.i().k();
        }

        public long getUpgradeTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return UpgradeDetailActivity.this.f306245f0.f306170d.iNewTimeStamp;
        }

        public int installApk() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            QLog.d("preLoad_configServlet", 1, "install apk from web, mark it.");
            com.tencent.mobileqq.upgrade.k.m().h();
            return 0;
        }

        public void pauseDownload() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            } else {
                QLog.d("preLoad_configServlet", 1, "pause download from web, mark it.");
                com.tencent.mobileqq.upgrade.k.m().j();
            }
        }

        public void resumeDownload() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            } else {
                QLog.d("preLoad_configServlet", 1, "resume download from web, mark it.");
                com.tencent.mobileqq.upgrade.k.m().m();
            }
        }

        public void startDownload() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                QLog.d("preLoad_configServlet", 1, "start download from web, mark it.");
                UpgradeDetailActivity.this.P2(true);
            }
        }

        public void stopDownload() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
            } else {
                QLog.d("preLoad_configServlet", 1, "stop download from web, mark it.");
                com.tencent.mobileqq.upgrade.k.m().s();
            }
        }

        public int tipsLoadComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            QLog.d("Hyim", 2, "loadTipsComplete");
            UpgradeDetailActivity.this.f306244e0 = true;
            UpgradeDetailActivity.this.onStateChanged(getDownloadState());
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends WebChromeClient {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UpgradeDetailActivity.this);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) geolocationPermissionsCallback);
            } else {
                super.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
                geolocationPermissionsCallback.invoke(str, true, false);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) webView, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("UpgradeController_DetailActivity", 2, "onProgressChanged: " + i3 + "%");
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) webView, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("UpgradeController_DetailActivity", 2, "onReceivedTitle:" + str);
            }
            UpgradeDetailActivity.this.setTitle(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b extends WebViewClient {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UpgradeDetailActivity.this);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) webView, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("UpgradeController_DetailActivity", 2, "onPageFinished: " + str);
            }
            UpgradeDetailActivity.this.f306241b0.setVisibility(8);
            super.onPageFinished(webView, str);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, webView, str, bitmap);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("UpgradeController_DetailActivity", 2, "onPageStarted: " + str);
            }
            UpgradeDetailActivity.this.f306241b0.setVisibility(0);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, webView, Integer.valueOf(i3), str, str2);
                return;
            }
            UpgradeDetailActivity.this.f306240a0.clearView();
            UpgradeDetailActivity.this.f306241b0.setVisibility(8);
            UpgradeDetailActivity.this.f306242c0.setVisibility(0);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) webView, (Object) str)).booleanValue();
            }
            if (str == null || str.isEmpty() || "about:blank;".equals(str) || "about:blank".equals(str) || UpgradeDetailActivity.this.f306249j0.a(webView, str)) {
                return true;
            }
            QLog.d("UpgradeController_DetailActivity", 1, "[shouldOverrideUrlLoading-loadUrl] url: ", str);
            UpgradeDetailActivity.this.V2(str);
            return true;
        }
    }

    public UpgradeDetailActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2(boolean z16) {
        String str;
        String string;
        UpgradeDetailWrapper upgradeDetailWrapper = this.f306245f0;
        UpgradeInfo upgradeInfo = upgradeDetailWrapper.f306170d;
        if (upgradeInfo != null && upgradeInfo.iIncrementUpgrade != 1) {
            final int Z2 = Z2(upgradeDetailWrapper.E);
            if (QLog.isColorLevel()) {
                QLog.d("UpgradeController_DetailActivity", 2, "checkAndStartDownload market supportMarketID:" + Z2);
            }
            if (Z2 != 0) {
                if (z16) {
                    this.f306243d0.obtainMessage(100, 0, 0).sendToTarget();
                }
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.upgrade.activity.p
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        UpgradeDetailActivity.this.U2(Z2, dialogInterface, i3);
                    }
                };
                if (Z2 != 1) {
                    if (Z2 != 2) {
                        if (Z2 != 3) {
                            if (Z2 != 4) {
                                string = "";
                            } else {
                                string = getString(R.string.vze);
                            }
                        } else {
                            string = getString(R.string.vzg);
                        }
                    } else {
                        string = getString(R.string.vzj);
                    }
                } else {
                    string = getString(R.string.vzi);
                }
                String string2 = getString(R.string.vzf, string);
                String string3 = getString(R.string.vzd, string);
                createCustomDialog.setMessage(string2);
                createCustomDialog.setTitle(R.string.vzh);
                createCustomDialog.setNegativeButton(R.string.vzc, onClickListener);
                createCustomDialog.setPositiveButton(string3, getResources().getColor(R.color.f156818c9), onClickListener);
                createCustomDialog.show();
                W2(Z2, 1);
                return;
            }
            com.tencent.mobileqq.upgrade.k.m().r(false);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("checkAndStartDownload");
            if (this.f306245f0.f306170d == null) {
                str = "null";
            } else {
                str = "iIncrementUpgrade==1";
            }
            sb5.append(str);
            QLog.d("UpgradeController_DetailActivity", 2, sb5.toString());
        }
        com.tencent.mobileqq.upgrade.k.m().r(false);
    }

    private boolean Q2() {
        if (!this.f306240a0.canGoBack()) {
            return false;
        }
        if (this.f306242c0.getVisibility() == 0) {
            this.f306242c0.setVisibility(8);
        }
        try {
            this.f306240a0.stopLoading();
        } catch (Exception e16) {
            QLog.e("UpgradeController_DetailActivity", 1, e16, new Object[0]);
        }
        this.f306240a0.goBack();
        return true;
    }

    private void R2(String str) {
        TextView textView;
        if (!getIntent().getBooleanExtra("need_left_back", true) && (textView = this.leftView) != null) {
            textView.setVisibility(4);
        }
        setTitle(str);
        removeWebViewLayerType();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009b, code lost:
    
        if (r9.enabled != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ad, code lost:
    
        if (r12.enabled != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void T2(Context context, int i3) {
        String str = "com.heytap.market";
        String str2 = "com.oppo.market";
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("hiapplink://com.huawei.appmarket?appId=C9319&accessID=%2F687abcc2447f49059f0c8873390a1686&caller=com.tencent.mobileqq"));
                        intent.setPackage("com.huawei.appmarket");
                        intent.setFlags(335544320);
                        intent.putExtra("big_brother_source_key", "biz_src_jc_appstore");
                        context.startActivity(intent);
                        if (QLog.isColorLevel()) {
                            QLog.i("UpgradeController_DetailActivity", 2, "jumpToPhoneMarketDetailUpdate huawei");
                            return;
                        }
                        return;
                    }
                    return;
                }
                Intent intent2 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("market://details?id=com.tencent.mobileqq&caller=com.tencent.mobileqq&token=273b98f0a5b2c20d&atd=true&style=0"));
                PackageManager packageManager = context.getPackageManager();
                String str3 = "";
                try {
                    try {
                        PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, "com.oppo.market", 0);
                        if (packageInfo != null && (r9 = packageInfo.applicationInfo) != null) {
                        }
                        str2 = "";
                        str3 = str2;
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    PackageInfo packageInfo2 = InstalledAppListMonitor.getPackageInfo(packageManager, "com.heytap.market", 0);
                    if (packageInfo2 != null && (r12 = packageInfo2.applicationInfo) != null) {
                    }
                    str = "";
                    str3 = str;
                }
                if (!TextUtils.isEmpty(str3)) {
                    intent2.setPackage(str3);
                    intent2.setFlags(270532608);
                    intent2.putExtra("big_brother_source_key", "biz_src_jc_appstore");
                    context.startActivity(intent2);
                }
                if (QLog.isColorLevel()) {
                    QLog.i("UpgradeController_DetailActivity", 2, "jumpToPhoneMarketDetailUpdate oppo,oppopkg:" + str3);
                    return;
                }
                return;
            }
            Intent intent3 = new Intent();
            intent3.setData(Uri.parse("mimarket://details?id=com.tencent.mobileqq&ref=com.tencent.mobileqq_selfupdate&startDownload=true"));
            intent3.setPackage("com.xiaomi.market");
            intent3.setFlags(335544320);
            intent3.putExtra("big_brother_source_key", "biz_src_jc_appstore");
            context.startActivity(intent3);
            if (QLog.isColorLevel()) {
                QLog.i("UpgradeController_DetailActivity", 2, "jumpToPhoneMarketDetailUpdate xiaomi");
                return;
            }
            return;
        }
        Intent intent4 = new Intent();
        intent4.setData(Uri.parse("vivomarket://details?id=com.tencent.mobileqq&th_name=self_update"));
        intent4.setPackage("com.bbk.appstore");
        intent4.setFlags(335544320);
        intent4.putExtra("big_brother_source_key", "biz_src_jc_appstore");
        context.startActivity(intent4);
        if (QLog.isColorLevel()) {
            QLog.i("UpgradeController_DetailActivity", 2, "jumpToPhoneMarketDetailUpdate vivo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U2(int i3, DialogInterface dialogInterface, int i16) {
        if (i16 != 0) {
            if (i16 == 1) {
                T2(this, i3);
                dialogInterface.dismiss();
                W2(i3, 2);
                return;
            }
            return;
        }
        com.tencent.mobileqq.upgrade.k.m().r(false);
        dialogInterface.dismiss();
        W2(i3, 3);
    }

    private void W2(int i3, int i16) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        if (i16 == 1) {
                            q.e("0X800AB96");
                            return;
                        } else if (i16 == 2) {
                            q.e("0X800AB97");
                            return;
                        } else {
                            if (i16 == 3) {
                                q.e("0X800AB98");
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (i16 == 1) {
                    q.e("0X800AB99");
                    return;
                } else if (i16 == 2) {
                    q.e("0X800AB9A");
                    return;
                } else {
                    if (i16 == 3) {
                        q.e("0X800AB9B");
                        return;
                    }
                    return;
                }
            }
            if (i16 == 1) {
                q.e("0X800AB9F");
                return;
            } else if (i16 == 2) {
                q.e("0X800ABA0");
                return;
            } else {
                if (i16 == 3) {
                    q.e("0X800ABA1");
                    return;
                }
                return;
            }
        }
        if (i16 == 1) {
            q.e("0X800AB9C");
        } else if (i16 == 2) {
            q.e("0X800AB9D");
        } else if (i16 == 3) {
            q.e("0X800AB9E");
        }
    }

    public static void Y2(Activity activity, UpgradeDetailWrapper upgradeDetailWrapper, boolean z16, boolean z17, boolean z18) {
        Intent intent = new Intent();
        intent.setClass(activity, UpgradeDetailActivity.class);
        intent.putExtra("detail_wrapper", upgradeDetailWrapper);
        intent.putExtra("is_anim", z16);
        intent.putExtra("download_right_now", z17);
        intent.putExtra("need_left_back", z18);
        activity.startActivity(intent);
        if (z16) {
            activity.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d3, code lost:
    
        if (r0 > 6300) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d5, code lost:
    
        r7 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0107, code lost:
    
        if (r0.enabled != false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int Z2(String str) {
        ApplicationInfo applicationInfo;
        int i3 = 0;
        if (!TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.i("UpgradeController_DetailActivity", 2, "supportGoMarketPhoneID,jumpMarketSupportPhone," + str + ",manufacture:" + Build.MANUFACTURER);
            }
            try {
                PackageManager packageManager = getPackageManager();
                if (str.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO) && Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
                    int i16 = InstalledAppListMonitor.getPackageInfo(packageManager, "com.bbk.appstore", 0).versionCode;
                    if (QLog.isColorLevel()) {
                        QLog.i("UpgradeController_DetailActivity", 2, "supportGoMarketPhoneID versioncode:" + i16);
                    }
                    if (i16 >= 3100) {
                        i3 = 1;
                    }
                } else if (str.contains("xiaomi") && Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
                    if (InstalledAppListMonitor.getPackageInfo(packageManager, "com.xiaomi.market", 0) != null) {
                        i3 = 2;
                    }
                } else if (str.contains("oppo") && Build.MANUFACTURER.equalsIgnoreCase("oppo")) {
                    try {
                        PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, "com.oppo.market", 0);
                        if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null && applicationInfo.enabled) {
                            int i17 = packageInfo.versionCode;
                            if (QLog.isColorLevel()) {
                                QLog.i("UpgradeController_DetailActivity", 2, "supportGoMarketPhoneID oppo market versioncode:" + i17);
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            PackageInfo packageInfo2 = InstalledAppListMonitor.getPackageInfo(packageManager, "com.heytap.market", 0);
                            if (QLog.isColorLevel()) {
                                QLog.i("UpgradeController_DetailActivity", 2, "oppo.market exception:" + th5.getMessage());
                            }
                            if (packageInfo2 != null && (r0 = packageInfo2.applicationInfo) != null) {
                            }
                        } catch (Throwable th6) {
                            if (QLog.isColorLevel()) {
                                QLog.i("UpgradeController_DetailActivity", 2, "heytap.market exception:" + th6.getMessage());
                            }
                        }
                    }
                } else if (str.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI) && Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI)) {
                    int i18 = InstalledAppListMonitor.getPackageInfo(packageManager, "com.huawei.appmarket", 0).versionCode;
                    if (QLog.isColorLevel()) {
                        QLog.i("UpgradeController_DetailActivity", 2, "supportGoMarketPhoneID versioncode:" + i18);
                    }
                    if (i18 >= 80003300) {
                        i3 = 4;
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("UpgradeController_DetailActivity", 2, "supportGoMarketPhoneID exception:" + e16.getMessage());
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("UpgradeController_DetailActivity", 2, "supportGoMarketPhoneID return id:" + i3);
        }
        return i3;
    }

    private void initUI() {
        View findViewById = findViewById(R.id.k16);
        this.f306242c0 = findViewById;
        findViewById.setVisibility(8);
        WebView webView = (WebView) findViewById(R.id.k18);
        this.f306240a0 = webView;
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + " " + QZoneHelper.getQUA());
        settings.setJavaScriptEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setCacheMode(2);
        this.f306240a0.setWebViewClient(new b());
        this.f306240a0.setWebChromeClient(new a());
        com.tencent.mobileqq.jsbridge.a aVar = new com.tencent.mobileqq.jsbridge.a();
        this.f306249j0 = aVar;
        aVar.c(new JsCover(), "qqupgrade");
        this.f306241b0 = (ProgressBar) findViewById(R.id.k19);
    }

    void S2(int i3) {
        if (this.f306240a0 == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController_DetailActivity", 2, "invokeDownloadStateToWebView: " + i3);
        }
        this.f306240a0.loadUrl("javascript:onDownloadStateChanged(" + i3 + ")");
    }

    void V2(String str) {
        try {
            this.f306240a0.stopLoading();
        } catch (Exception e16) {
            QLog.e("UpgradeController_DetailActivity", 1, e16, new Object[0]);
        }
        this.f306240a0.loadUrl(str);
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController_DetailActivity", 2, "loadUrl: " + str);
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController", 2, "UpgradeDetailActivity.finish start");
        }
        super.finish();
        if (this.f306244e0) {
            this.f306244e0 = false;
            MqqWeakReferenceHandler mqqWeakReferenceHandler = this.f306243d0;
            if (mqqWeakReferenceHandler != null) {
                mqqWeakReferenceHandler.removeMessages(100);
                this.f306243d0.removeMessages(101);
            }
            WebView webView = this.f306240a0;
            if (webView != null) {
                try {
                    webView.loadUrl("javascript:onDestroy()");
                } catch (Exception e16) {
                    QLog.e("UpgradeController_DetailActivity", 1, e16, new Object[0]);
                }
            }
        }
        if (this.f306250k0) {
            overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController", 2, "UpgradeDetailActivity.finish stop");
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 100) {
            S2(message.arg1);
            return true;
        }
        if (i3 == 101) {
            P2(false);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (Q2()) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        UpgradeInfo upgradeInfo;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        UpgradeDetailWrapper j3 = com.tencent.mobileqq.upgrade.k.i().j();
        if (j3 != null && (upgradeInfo = j3.f306170d) != null && upgradeInfo.iUpgradeType > 0) {
            super.setContentView(R.layout.c28);
            removeWebViewLayerType();
            Intent intent = getIntent();
            this.f306245f0 = (UpgradeDetailWrapper) intent.getParcelableExtra("detail_wrapper");
            this.f306250k0 = intent.getBooleanExtra("is_anim", true);
            com.tencent.mobileqq.upgrade.k.m().a(this);
            UpgradeDetailWrapper upgradeDetailWrapper = this.f306245f0;
            UpgradeDetailWrapper.b bVar = upgradeDetailWrapper.f306173h;
            if (bVar != null) {
                this.f306247h0 = bVar.f306178c;
                this.f306248i0 = bVar.f306176a;
                this.f306246g0 = bVar.f306177b;
            }
            ApkUpdateDetail apkUpdateDetail = upgradeDetailWrapper.f306172f;
            if (apkUpdateDetail != null && apkUpdateDetail.updatemethod == 4) {
                this.f306246g0 = Math.min(this.f306246g0, apkUpdateDetail.patchsize);
            }
            String qqStr = HardCodeUtil.qqStr(R.string.uus);
            UpgradeInfo upgradeInfo2 = this.f306245f0.f306170d;
            if (upgradeInfo2 != null) {
                String str2 = upgradeInfo2.strNewUpgradeDescURL;
                String str3 = "fontSetting=" + FontSettingManager.getFontLevel();
                if (str2.endsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    str = str2 + str3;
                } else if (str2.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    str = str2 + ContainerUtils.FIELD_DELIMITER + str3;
                } else {
                    str = str2 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str3;
                }
            } else {
                str = null;
            }
            this.f306243d0 = new MqqWeakReferenceHandler(this);
            if (intent.getBooleanExtra("download_right_now", false)) {
                this.f306243d0.sendEmptyMessageAtTime(101, 1500L);
            }
            R2(qqStr);
            initUI();
            QLog.d("UpgradeController_DetailActivity", 1, "[onCreate-loadUrl] url: ", str);
            if (str != null) {
                V2(str);
            }
            this.f306241b0.setVisibility(0);
            return;
        }
        finish();
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f306244e0) {
            this.f306244e0 = false;
            MqqWeakReferenceHandler mqqWeakReferenceHandler = this.f306243d0;
            if (mqqWeakReferenceHandler != null) {
                mqqWeakReferenceHandler.removeMessages(100);
                this.f306243d0.removeMessages(101);
            }
            WebView webView = this.f306240a0;
            if (webView != null) {
                try {
                    webView.loadUrl("javascript:onDestroy()");
                } catch (Exception e16) {
                    QLog.e("UpgradeController_DetailActivity", 1, e16, new Object[0]);
                }
            }
        }
        com.tencent.mobileqq.upgrade.k.m().k(this);
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        this.f306249j0.d("qqupgrade");
        try {
            this.f306240a0.stopLoading();
            this.f306240a0.clearView();
        } catch (Exception e16) {
            QLog.e("UpgradeController_DetailActivity", 1, e16, new Object[0]);
        }
        try {
            this.f306240a0.destroy();
        } catch (Exception e17) {
            QLog.e("UpgradeController_DetailActivity", 1, e17, new Object[0]);
        }
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (4 == i3 && Q2()) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        MyAppApi.z().T(this);
        try {
            if (this.f306244e0) {
                S2(com.tencent.mobileqq.upgrade.k.i().k());
            }
        } catch (Exception e16) {
            QLog.e("UpgradeController_DetailActivity", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.upgrade.download.c.b
    public void onStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else if (this.f306244e0) {
            this.f306243d0.obtainMessage(100, i3, 0).sendToTarget();
        }
    }
}
