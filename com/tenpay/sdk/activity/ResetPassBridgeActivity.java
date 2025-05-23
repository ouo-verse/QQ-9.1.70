package com.tenpay.sdk.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqlive.module.videoreport.inject.webview.webclient.ReportX5CoreWebChromeClient;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.api.QFuncProxy;
import com.tenpay.bank.BindBankModule;
import com.tenpay.idverify.IdVerifyModule;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.net.core.comm.CftSKeyCacheUtils;
import com.tenpay.sdk.util.WalletGateData;
import cooperation.qwallet.plugin.FakeUrl;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class ResetPassBridgeActivity extends NetBaseActivity implements com.tencent.mobileqq.webview.swift.af, com.tencent.mobileqq.webview.swift.y {
    private View backBtn;
    private CustomWebView mWebView;
    private RelativeLayout root;
    private LinearLayout titleBar;
    private TextView titleView;
    private final String TAG = "ResetPassBridgeActivity";
    private Intent mIntent = null;
    public ArrayList<WebViewPlugin> mPluginList = null;
    private boolean isErrorLoadUrl = false;

    private void initViews(View view) {
        this.root = (RelativeLayout) view.findViewById(R.id.root);
        this.backBtn = view.findViewById(R.id.ivTitleBtnLeft);
        this.titleBar = (LinearLayout) view.findViewById(R.id.jo9);
        this.titleView = (TextView) view.findViewById(R.id.ivTitleName);
    }

    private void sendQueryUserInfo() {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("uin", this.mUin);
            hashMap.put("reset_pwd_flag", "1");
            StringBuffer stringBuffer = new StringBuffer();
            int i3 = 0;
            while (true) {
                byte[] bArr = this.mGuid;
                if (i3 >= bArr.length) {
                    break;
                }
                String hexString = Integer.toHexString(bArr[i3] & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString.toUpperCase());
                i3++;
            }
            hashMap.put("qq_guid", stringBuffer.toString());
            hashMap.put("qq_appid", this.mAppid);
            hashMap.put("qq_appname", "com.tencent.mobileqq");
        } catch (Exception e16) {
            QLog.e("ResetPassBridgeActivity", 1, "", e16);
        }
        httpRequest(Cgi.URI_QUERY_USER, hashMap);
    }

    private void sendQueryWalletGate() {
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        httpRequestNoLoading(Cgi.URL_WALLET_GATE, hashMap);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        WebViewPluginEngine pluginEngine;
        WebViewPlugin l3;
        super.onActivityResult(i3, i16, intent);
        setResult(i16, intent);
        int i17 = i3 & 255;
        int i18 = (i3 >> 8) & 255;
        if (i18 > 0) {
            CustomWebView customWebView = this.mWebView;
            if (customWebView != null && (pluginEngine = customWebView.getPluginEngine()) != null && (l3 = pluginEngine.l(i18, true)) != null) {
                l3.onActivityResult(intent, (byte) i17, i16);
                return;
            } else if (QLog.isColorLevel()) {
                QLog.w("ResetPassBridgeActivity", 2, "Caution! activity result not handled!");
            }
        }
        finish();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        if (!QWalletFakeUrl.hasQWalletFakeProtocal(jSONObject)) {
            final int optInt = jSONObject.optInt("retcode");
            final String optString = jSONObject.optString("retmsg");
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.ResetPassBridgeActivity.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    if (28027203 == optInt) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(Cgi.RETURN_MSG_JSON_ERROR_KEY, optString);
                        } catch (JSONException e16) {
                            QLog.e("ResetPassBridgeActivity", 1, "", e16);
                        }
                        ResetPassBridgeActivity.this.setRetCodeMsgAndGetBundle(ErrorCode.ERR_ACCOUNT_DONGJIE, jSONObject2.toString());
                    }
                    WalletGateData.getInstance().clear();
                    ResetPassBridgeActivity.this.finish();
                }
            };
            Context context = getContext();
            if (context != null && !isFinishing()) {
                QUIProxy.createCustomDialog(context, 230, null, optString, context.getString(R.string.e5j), null, null, onClickListener);
            }
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, cooperation.qwallet.plugin.FakeUrl.FakeListener
    public boolean onBlHandleFakeurl(FakeUrl.FakeInfo fakeInfo, int i3) {
        super.onBlHandleFakeurl(fakeInfo, i3);
        WalletGateData.getInstance().clear();
        finish();
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ag_, viewGroup, false);
        initViews(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        WalletGateData.getInstance().clear();
        finish();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        if (isFinishing()) {
            return;
        }
        boolean z16 = false;
        if (Cgi.URI_QUERY_USER.equals(str)) {
            this.mCardType = jSONObject.optString("creditcard_type");
            this.mCardID = jSONObject.optString("creditcard_id");
            this.mTrueName = jSONObject.optString("purchaser_true_name");
            if (jSONObject.optInt("allow_reset_pwd") == 1) {
                int optInt = jSONObject.optInt("reset_type", 2);
                if (optInt == 2) {
                    BindBankModule.INSTANCE.startVerifyForResult(this, this.mIntent, 20);
                    return;
                }
                if (optInt == 1) {
                    this.mIntent.putExtra("from_resetpass_bridge", true);
                    IdVerifyModule.startFromForgetPwd(this, this.mIntent, 30);
                    return;
                }
                if (optInt == 3) {
                    String optString = jSONObject.optString("reset_url", "");
                    if (TextUtils.isEmpty(optString)) {
                        BindBankModule.INSTANCE.startVerifyForResult(this, this.mIntent, 20);
                        return;
                    }
                    if (this.mPluginList == null) {
                        this.mPluginList = new ArrayList<>();
                    }
                    QFuncProxy.webProxy(this.mPluginList);
                    this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ResetPassBridgeActivity.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            ResetPassBridgeActivity.this.finish();
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    });
                    CustomWebView customWebView = new CustomWebView(getOutActivity());
                    this.mWebView = customWebView;
                    customWebView.setWillNotCacheDrawing(false);
                    this.mWebView.setDrawingCacheEnabled(true);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(3, R.id.jo9);
                    this.mWebView.setLayoutParams(layoutParams);
                    this.mWebView.setHorizontalScrollBarEnabled(false);
                    this.root.addView(this.mWebView);
                    WebViewPluginEngine createWebViewPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(MobileQQ.sMobileQQ.peekAppRuntime().getAppRuntime("qwallet_plugin.apk"), getActivity(), this.mWebView, this.mPluginList);
                    createWebViewPluginEngine.b(this);
                    this.mWebView.setPluginEngine(createWebViewPluginEngine);
                    WebSettings settings = this.mWebView.getSettings();
                    settings.setJavaScriptEnabled(true);
                    settings.setPluginState(WebSettings.PluginState.ON);
                    settings.setPluginsEnabled(true);
                    String userAgentString = settings.getUserAgentString();
                    if (this.mWebView.getX5WebViewExtension() != null) {
                        z16 = true;
                    }
                    settings.setUserAgentString(QFuncProxy.getWebViewUAForQQ(userAgentString, "", z16));
                    this.mWebView.setWebChromeClient(new ReportX5CoreWebChromeClient());
                    this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.tenpay.sdk.activity.ResetPassBridgeActivity.2
                        private boolean isMainFrame = true;

                        @Override // com.tencent.smtt.sdk.WebViewClient
                        public void onPageFinished(WebView webView, String str2) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ResetPassBridgeActivity", 2, "onPageFinished-----url = " + str2);
                            }
                            if (!ResetPassBridgeActivity.this.isErrorLoadUrl) {
                                String title = webView.getTitle();
                                if (!TextUtils.isEmpty(title)) {
                                    ResetPassBridgeActivity.this.titleView.setText(title);
                                }
                                ResetPassBridgeActivity.this.root.setVisibility(0);
                                return;
                            }
                            ResetPassBridgeActivity.this.root.setVisibility(8);
                            BindBankModule bindBankModule = BindBankModule.INSTANCE;
                            ResetPassBridgeActivity resetPassBridgeActivity = ResetPassBridgeActivity.this;
                            bindBankModule.startVerifyForResult(resetPassBridgeActivity, resetPassBridgeActivity.mIntent, 20);
                        }

                        @Override // com.tencent.smtt.sdk.WebViewClient
                        public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                            JsInjector.getInstance().onPageStarted(webView);
                            if (QLog.isColorLevel()) {
                                QLog.d("ResetPassBridgeActivity", 2, "onPageStarted-----url = " + str2);
                            }
                        }

                        @Override // com.tencent.smtt.sdk.WebViewClient
                        public void onReceivedError(WebView webView, int i3, String str2, String str3) {
                            if (QLog.isColorLevel()) {
                                QLog.e("ResetPassBridgeActivity", 1, "onReceivedError:errorCode=" + i3 + ", desc=" + str2 + ", url=" + str3);
                            }
                            ResetPassBridgeActivity.this.isErrorLoadUrl = true;
                            ResetPassBridgeActivity.this.root.setVisibility(8);
                            BindBankModule bindBankModule = BindBankModule.INSTANCE;
                            ResetPassBridgeActivity resetPassBridgeActivity = ResetPassBridgeActivity.this;
                            bindBankModule.startVerifyForResult(resetPassBridgeActivity, resetPassBridgeActivity.mIntent, 20);
                        }

                        @Override // com.tencent.smtt.sdk.WebViewClient
                        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                            this.isMainFrame = webResourceRequest.isForMainFrame();
                            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
                            this.isMainFrame = true;
                            return shouldOverrideUrlLoading;
                        }

                        @Override // com.tencent.smtt.sdk.WebViewClient
                        public boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ResetPassBridgeActivity", 2, "shouldOverrideUrlLoading " + str2);
                            }
                            if (!TextUtils.isEmpty(str2) && !"about:blank;".equals(str2) && !"about:blank".equals(str2)) {
                                try {
                                    WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                                    if ((pluginEngine != null && pluginEngine.S(str2, this.isMainFrame)) || shouldOverrideUrlLoading(webView, str2)) {
                                        return true;
                                    }
                                    if (str2.startsWith("file://") || str2.startsWith("data:") || str2.startsWith("http://") || str2.startsWith("https://")) {
                                        if (pluginEngine != null) {
                                            if (pluginEngine.s(str2, 16L, null)) {
                                                return true;
                                            }
                                        }
                                        return false;
                                    }
                                } catch (RuntimeException e16) {
                                    String stackTraceString = QLog.getStackTraceString(e16);
                                    if (QLog.isColorLevel()) {
                                        QLog.e("ResetPassBridgeActivity", 2, stackTraceString);
                                    }
                                }
                            }
                            return true;
                        }
                    });
                    this.mWebView.loadUrl(optString);
                    return;
                }
                return;
            }
            String optString2 = jSONObject.optString("reset_pwd_info");
            if ("".equals(optString2)) {
                optString2 = getString(R.string.e39);
            }
            QUIProxy.createCustomDialog(getContext(), 230, null, optString2, getString(R.string.e3_), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.ResetPassBridgeActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    WalletGateData.getInstance().clear();
                    ResetPassBridgeActivity.this.finish();
                }
            });
            return;
        }
        if (str.equals(Cgi.URL_WALLET_GATE)) {
            this.mTimestamp = Long.parseLong(jSONObject.optString("time_stamp")) - (System.currentTimeMillis() / 1000);
            this.mBargainorName = jSONObject.optString("bargainor_true_name");
            this.mGoodsName = jSONObject.optString("desc");
            this.mTotalFee = jSONObject.optString("total_fee");
            this.mCardType = jSONObject.optString("creditcard_type");
            this.mCardID = jSONObject.optString("creditcard_id");
            this.mTrueName = jSONObject.optString("purchaser_true_name");
            this.mUserAttr = jSONObject.optInt("user_attr");
            int intExtra = this.mIntent.getIntExtra("user_attr", 0);
            int i3 = this.mUserAttr;
            if (intExtra != i3) {
                this.mIntent.putExtra("user_attr", i3);
            }
            this.mCacheVer = jSONObject.optString("interf_cache_ver");
            this.mUserCertType = jSONObject.optInt("cert_user");
            this.mPassFlag = jSONObject.optString("pass_flag");
            String optString3 = jSONObject.optString("domain_name");
            if (!TextUtils.isEmpty(optString3)) {
                setServerAddr(optString3);
            }
            sendQueryUserInfo();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Intent intent = getIntent();
        this.mIntent = intent;
        if (intent != null && intent.getExtras() != null) {
            QwLog.e("intent get in ResetPassBridgetActivity is " + this.mIntent.getExtras().toString());
        }
        if (CftSKeyCacheUtils.hasCftSKey(this.mUin) && this.mUserAttr != 0) {
            sendQueryUserInfo();
        } else {
            sendQueryWalletGate();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.af
    public int pluginStartActivityForResult(WebViewPlugin webViewPlugin, Intent intent, byte b16) {
        int switchRequestCode = switchRequestCode(webViewPlugin, b16);
        if (switchRequestCode == -1) {
            if (QLog.isColorLevel()) {
                QLog.d("ResetPassBridgeActivity", 2, "pluginStartActivityForResult not handled");
            }
        } else {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.startActivityForResult(intent, switchRequestCode);
            }
        }
        return switchRequestCode;
    }

    @Override // com.tencent.mobileqq.webview.swift.af
    public int switchRequestCode(WebViewPlugin webViewPlugin, byte b16) {
        CustomWebView e16 = webViewPlugin.mRuntime.e();
        if (e16 == null || e16.getPluginEngine() == null) {
            return -1;
        }
        int a16 = com.tencent.mobileqq.webview.swift.ao.a(webViewPlugin);
        if (a16 == -1) {
            if (QLog.isColorLevel()) {
                QLog.d("ResetPassBridgeActivity", 2, "switchRequestCode failed: webview index=0, pluginIndex=" + a16);
            }
            return -1;
        }
        return ((a16 << 8) & 65280) | 0 | (b16 & 255);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
