package n91;

import android.os.Bundle;
import com.tencent.ark.open.security.ArkBaseUrlChecker;
import com.tencent.biz.common.util.k;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ark.api.IArkSecureReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private ArkBaseUrlChecker f419501d = null;

    /* renamed from: e, reason: collision with root package name */
    private String f419502e = null;

    /* renamed from: f, reason: collision with root package name */
    private String f419503f = "";

    /* renamed from: h, reason: collision with root package name */
    private boolean f419504h = true;

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "ArkSecurity";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        return 3L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public int getWebViewSchemaListIndex() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(String str, String str2) {
        boolean z16;
        int i3;
        if ("https://qzonestyle.gtimg.cn/qzone/hybrid/page/safeTips/index.html".equals(str)) {
            QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, "ArkSafe now jump url=", str);
            return false;
        }
        ArkBaseUrlChecker arkBaseUrlChecker = this.f419501d;
        if (arkBaseUrlChecker != null) {
            int checkURLLoose = arkBaseUrlChecker.checkURLLoose(str);
            z16 = checkURLLoose == 0;
            if (z16) {
                i3 = 0;
            } else if (this.f419504h) {
                i3 = 1;
            } else {
                QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, "ArkSafe.UrlCheck.setDisable.web.set isPermitted=true,url=", k.f(str, new String[0]));
                i3 = 2;
                z16 = true;
            }
            ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportNavigateURLAccess(this.f419502e, str, checkURLLoose, i3, this.f419503f);
            if (!z16) {
                QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, "ArkSafe.handleSchemaRequest,isPermitted=", Boolean.valueOf(z16), ", url=", k.f(str, new String[0]));
                p();
            }
        } else {
            z16 = true;
        }
        return !z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityReady() {
        super.onActivityReady();
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.a() != null) {
            Bundle extras = this.mRuntime.a().getIntent().getExtras();
            if (extras == null || extras.getParcelable(AppConstants.Key.H5_ARK_URL_WEB_CHECKER) == null) {
                return;
            }
            try {
                extras.setClassLoader(a.class.getClassLoader());
                this.f419501d = (ArkBaseUrlChecker) extras.getParcelable(AppConstants.Key.H5_ARK_URL_WEB_CHECKER);
                this.f419502e = extras.getString(AppConstants.Key.H5_ARK_APP_NAME, null);
                this.f419503f = extras.getString(AppConstants.Key.H5_ARK_URL_WEB_SENDER_UIN, "");
                this.f419504h = extras.getBoolean(AppConstants.Key.H5_ARK_URL_WEB_CHECKER_ENABLE, true);
            } catch (Exception e16) {
                QLog.e("ArkApp.ArkSecurityWebViewPlugin", 1, "ArkSafe.ArkSecurityWebViewPlugin init exception:", e16);
            }
            Object[] objArr = new Object[8];
            objArr[0] = "ArkSafe.ArkSecurityWebViewPlugin init appname = ";
            objArr[1] = this.f419502e;
            objArr[2] = ",mEnableUrlCheck = ";
            objArr[3] = Boolean.valueOf(this.f419504h);
            objArr[4] = ", senderUin=";
            objArr[5] = this.f419503f;
            objArr[6] = ", mUrlChecker=";
            ArkBaseUrlChecker arkBaseUrlChecker = this.f419501d;
            objArr[7] = arkBaseUrlChecker != null ? arkBaseUrlChecker.toString() : null;
            QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, objArr);
            return;
        }
        QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, "ArkSecurityWebViewPlugin#onActivityReady runtime or activity is null!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
    }

    protected void p() {
        CustomWebView e16;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || (e16 = bVar.e()) == null) {
            return;
        }
        QLog.i("ArkApp.ArkSecurityWebViewPlugin", 1, "now jump url=" + k.f("https://qzonestyle.gtimg.cn/qzone/hybrid/page/safeTips/index.html", new String[0]));
        e16.loadUrl("https://qzonestyle.gtimg.cn/qzone/hybrid/page/safeTips/index.html");
    }
}
