package com.huawei.hms.health;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.huawei.hms.hihealth.HuaweiHiHealth;
import com.huawei.hms.hihealth.SettingController;
import com.huawei.hms.hihealth.result.HealthKitAuthResult;
import com.huawei.hms.support.account.result.AuthAccount;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aabg extends ReportAndroidXFragment {
    private View aab;
    private WebView aaba;
    private TextView aabb;
    private String aabc;
    private AuthAccount aabd;
    private SettingController aabe;
    private Activity aabf;
    private int aabg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aab implements View.OnClickListener {
        aab() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            aabg.this.aabf.onBackPressed();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class aaba extends OnBackPressedCallback {
        aaba(boolean z16) {
            super(z16);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            aabg.this.aab(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aabb extends WebChromeClient {
        aabb() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            super.onProgressChanged(webView, i3);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (str != null && ("healthkit_vue".equals(str) || str.contains(aabg.this.aabc))) {
                return;
            }
            aabg.this.aabb.setText(str);
            aabg.this.aabb.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aabc {
        /* synthetic */ aabc(aab aabVar) {
        }

        @JavascriptInterface
        public void invoke() throws Exception {
            try {
                aabz.aabb("HealthKitWebView", "AuthorizationtoJs invoke is Called");
                if (aabg.this.aabg == 1) {
                    aabg.this.aabf.setResult(-2, null);
                    aabg.this.aabf.finish();
                }
                if (aabg.this.aabe.openAuthFromCloud()) {
                    aabg.this.aab(-1);
                } else {
                    aabg.this.aab(1);
                }
            } catch (Throwable unused) {
                aabz.aab("HealthKitWebView", "WebAuthorizationtoJs has exception");
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        requireActivity().getOnBackPressedDispatcher().addCallback(new aaba(true));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        try {
            FragmentActivity activity = getActivity();
            this.aabf = activity;
            this.aabe = HuaweiHiHealth.getSettingController((Activity) activity);
            if (this.aab == null) {
                this.aab = layoutInflater.inflate(R.layout.e_9, viewGroup, false);
            }
            aab();
            aaba();
            view = this.aab;
        } catch (Throwable unused) {
            aabz.aab("HealthKitWebView", "webView onCreateView has exception");
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    private void aab() {
        this.aaba = (WebView) this.aab.findViewById(R.id.x9d);
        TextView textView = (TextView) this.aab.findViewById(R.id.x9b);
        this.aabb = textView;
        textView.setVisibility(8);
        ((ImageView) this.aab.findViewById(R.id.x9a)).setOnClickListener(new aab());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aaba() {
        Bundle arguments;
        String str;
        String str2 = "";
        this.aaba.getSettings().setJavaScriptEnabled(true);
        this.aaba.getSettings().setAllowFileAccess(false);
        this.aaba.getSettings().setAllowFileAccessFromFileURLs(false);
        this.aaba.getSettings().setGeolocationEnabled(false);
        this.aaba.getSettings().setAllowContentAccess(false);
        this.aaba.getSettings().setUseWideViewPort(true);
        this.aaba.getSettings().setSupportZoom(true);
        this.aaba.getSettings().setLoadWithOverviewMode(true);
        this.aaba.getSettings().setBuiltInZoomControls(true);
        this.aaba.getSettings().setDisplayZoomControls(false);
        this.aaba.addJavascriptInterface(new aabc(null), "NativeBridgeHMS");
        this.aaba.setWebChromeClient(new aabb());
        Locale locale = Locale.getDefault();
        String str3 = locale.getLanguage() + "-" + locale.getCountry();
        try {
            arguments = getArguments();
        } catch (Exception unused) {
            aabz.aab("HealthKitWebView", "buildHealthAuthUrl Exception");
        }
        if (arguments != null && ((!TextUtils.isEmpty(arguments.getString("HEALTHKIT_AUTH_RESULT")) || arguments.getInt("flag", 0) != 0) && !TextUtils.isEmpty(arguments.getString("authUrl")))) {
            this.aabg = arguments.getInt("flag", 0);
            HealthKitAuthResult fromJson = new HealthKitAuthResult().fromJson(arguments.getString("HEALTHKIT_AUTH_RESULT"));
            if (fromJson.getAuthAccount() != null) {
                this.aabd = fromJson.getAuthAccount();
            }
            String string = arguments.getString("authUrl");
            this.aabc = string;
            if (TextUtils.isEmpty(string)) {
                aabz.aabb("HealthKitWebView", "buildHealthAuthUrl get access token fail");
            } else if (aab(this.aabc)) {
                str2 = this.aabc + "?state=" + str3;
            } else {
                str = "auth url is illegal";
                aabz.aabc("HealthKitWebView", str);
            }
            if (TextUtils.isEmpty(str2)) {
                this.aaba.loadUrl(str2);
                return;
            } else {
                aab(1);
                return;
            }
        }
        str = "buildHealthAuthUrl intent param is wrong";
        aabz.aabc("HealthKitWebView", str);
        if (TextUtils.isEmpty(str2)) {
        }
    }

    private boolean aab(String str) {
        String str2;
        String str3;
        if (!URLUtil.isNetworkUrl(str)) {
            return false;
        }
        try {
            str2 = new URL(str.replaceAll("[\\\\#]", "/")).getHost();
        } catch (MalformedURLException unused) {
            aabz.aab("HealthKitWebView", "getHostByURI error  MalformedURLException");
            str2 = "";
        }
        String[] strArr = {"dbankcdn.cn", "dbankcdn.com", "hwcloudtest.cn"};
        for (int i3 = 0; i3 < 3; i3++) {
            String str4 = strArr[i3];
            if (str2.endsWith(str4)) {
                try {
                    String substring = str2.substring(0, str2.length() - str4.length());
                    if (substring.endsWith(".")) {
                        return substring.matches("^[A-Za-z0-9.-]+$");
                    }
                    return false;
                } catch (IndexOutOfBoundsException unused2) {
                    str3 = "catch IndexOutOfBoundsException";
                    aabz.aab("HealthKitWebView", str3);
                    return false;
                } catch (Throwable unused3) {
                    str3 = "catch exception";
                    aabz.aab("HealthKitWebView", str3);
                    return false;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab(int i3) {
        Activity activity;
        AuthAccount authAccount;
        int i16;
        try {
            if (i3 == -1) {
                activity = this.aabf;
                authAccount = this.aabd;
                i16 = 0;
            } else {
                activity = this.aabf;
                authAccount = this.aabd;
                i16 = HiHealthStatusCodes.HEALTH_APP_NOT_AUTHORISED;
            }
            activity.setResult(-1, aacu.aab(i16, authAccount));
            this.aabf.finish();
        } catch (Throwable unused) {
            aabz.aab("HealthKitWebView", "setHealthAuthResult has exception");
        }
    }
}
