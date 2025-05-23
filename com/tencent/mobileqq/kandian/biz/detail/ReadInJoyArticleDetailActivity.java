package com.tencent.mobileqq.kandian.biz.detail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.y;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emosm.t;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.ECWebSchemeUserDataMap;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.webviewplugin.q;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.sdk.WebView;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ReadInJoyArticleDetailActivity extends QQBrowserActivity {

    /* renamed from: d0, reason: collision with root package name */
    protected String f239332d0;

    /* renamed from: e0, reason: collision with root package name */
    protected String f239333e0;

    /* renamed from: f0, reason: collision with root package name */
    protected String f239334f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f239335g0;

    /* renamed from: h0, reason: collision with root package name */
    protected long f239336h0;

    /* renamed from: i0, reason: collision with root package name */
    protected long f239337i0;

    /* renamed from: j0, reason: collision with root package name */
    protected String f239338j0;

    /* renamed from: k0, reason: collision with root package name */
    protected int f239339k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f239340l0;

    /* renamed from: m0, reason: collision with root package name */
    private long f239341m0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f239343o0;

    /* renamed from: q0, reason: collision with root package name */
    public volatile AppInterface f239345q0;

    /* renamed from: r0, reason: collision with root package name */
    public BrowserAppInterface f239346r0;

    /* renamed from: t0, reason: collision with root package name */
    boolean f239348t0;

    /* renamed from: a0, reason: collision with root package name */
    private long f239329a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    private long f239330b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    protected String f239331c0 = null;

    /* renamed from: n0, reason: collision with root package name */
    com.tencent.biz.troop.b f239342n0 = null;

    /* renamed from: p0, reason: collision with root package name */
    public Object f239344p0 = new Object();

    /* renamed from: s0, reason: collision with root package name */
    private boolean f239347s0 = true;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f239349u0 = false;

    /* renamed from: v0, reason: collision with root package name */
    boolean f239350v0 = false;

    /* renamed from: w0, reason: collision with root package name */
    ECWebSchemeUserDataMap f239351w0 = null;

    /* renamed from: x0, reason: collision with root package name */
    private int f239352x0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    private byte[] f239353y0 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements ITroopMemberApiClientApi.a {
        a() {
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            synchronized (ReadInJoyArticleDetailActivity.this.f239344p0) {
                ReadInJoyArticleDetailActivity.this.f239353y0 = bundle.getByteArray("decryptResult");
                if (QLog.isColorLevel()) {
                    QLog.d("ReadInJoyArticleDetail", 2, "\u8bf7\u6c42\u8fd4\u56de\u65f6\u95f4" + System.currentTimeMillis());
                }
                if (ReadInJoyArticleDetailActivity.this.f239353y0 == null) {
                    ReadInJoyArticleDetailActivity.this.f239331c0 = null;
                }
                ReadInJoyArticleDetailActivity.this.f239344p0.notifyAll();
            }
        }
    }

    public ReadInJoyArticleDetailActivity() {
        this.mFragmentClass = ReadInJoyArticleDetailFragment.class;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2() {
        if (getIntent() == null || getIntent().getBooleanExtra("from_native", false)) {
            getMainLooper();
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity.2
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
                        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doBindService(BaseApplicationImpl.getApplication());
                        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(new a());
                    } else {
                        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_kandian_hb_close_guid", "onPageStarted", 0, new Bundle()));
                    }
                    return false;
                }

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity$2$a */
                /* loaded from: classes33.dex */
                class a extends t {
                    a() {
                    }

                    @Override // com.tencent.mobileqq.emosm.t
                    public void onBindedToClient() {
                        ReadInJoyArticleDetailActivity.this.K2();
                    }

                    @Override // com.tencent.mobileqq.emosm.t
                    public void onDisconnectWithService() {
                    }

                    @Override // com.tencent.mobileqq.emosm.t
                    public void onPushMsg(Bundle bundle) {
                    }

                    @Override // com.tencent.mobileqq.emosm.t
                    public void onResponse(Bundle bundle) {
                    }
                }
            });
        }
    }

    public void J2() {
        if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyArticleDetail", 2, "\u8bf7\u6c42\u5f00\u59cb\u65f6\u95f4" + System.currentTimeMillis());
        }
        this.f239342n0.D(this.f239331c0, new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        boolean doOnCreate = super.doOnCreate(bundle);
        this.f239345q0 = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        if (this.f239345q0 != null && (this.f239345q0 instanceof BrowserAppInterface)) {
            this.f239346r0 = (BrowserAppInterface) this.f239345q0;
        }
        return doOnCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        ECWebSchemeUserDataMap eCWebSchemeUserDataMap;
        super.doOnDestroy();
        com.tencent.biz.troop.b bVar = this.f239342n0;
        if (bVar != null) {
            bVar.q();
        }
        if (!this.f239350v0 || (eCWebSchemeUserDataMap = this.f239351w0) == null || eCWebSchemeUserDataMap.getMap() == null || "1".equals(this.f239351w0.getMap().get("from_customer_service"))) {
            return;
        }
        Map<String, String> map = this.f239351w0.getMap();
        map.put("duration", String.valueOf(this.f239352x0));
        QLog.d("ReadInJoyArticleDetail", 1, "reportSaasPageDuration userData= " + map);
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).reportSaasPageDuration(map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        long currentTimeMillis = System.currentTimeMillis();
        this.f239330b0 = currentTimeMillis;
        this.f239352x0 = (int) (this.f239352x0 + (currentTimeMillis - this.f239329a0));
        com.tencent.biz.troop.b bVar = this.f239342n0;
        if (bVar != null) {
            bVar.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        this.f239329a0 = System.currentTimeMillis();
        K2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        this.f239332d0 = extras.getString("url");
        this.f239343o0 = extras.getBoolean("ip_connect", false);
        this.f239331c0 = extras.getString("read_in_joy_from_cache");
        String q16 = PreloadManager.q(this.f239332d0);
        this.f239333e0 = extras.getString("preload_iamge_url");
        this.f239350v0 = extras.getBoolean("ecommerce_web");
        this.f239351w0 = (ECWebSchemeUserDataMap) extras.getSerializable("ecommerce_user_data");
        QLog.d("ReadInJoyArticleDetail", 1, "onCreate,url=" + this.f239332d0);
        if (this.f239348t0) {
            this.f239347s0 = false;
        }
        if (this.f239342n0 == null) {
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            this.f239342n0 = A;
            A.p();
        }
        if (!TextUtils.isEmpty(this.f239331c0) && !TextUtils.isEmpty(q16) && q16.equals(this.f239331c0)) {
            if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyArticleDetail", 2, "\u5728onCreate\u4e2d\u6267\u884c\u64cd\u4f5c\u7684\u65f6\u95f4\u65f6" + System.currentTimeMillis());
            }
            J2();
        }
        intent.putExtra(QQWinkConstants.WEB_COLOR_NOTE_TYPE, 1);
        super.onCreate(bundle);
        if (this.f239332d0 == null) {
            QLog.d("ReadInJoyArticleDetail", 2, "initModel url empty");
            return;
        }
        String string = extras.getString("subscribename");
        this.f239334f0 = string;
        if (string == null) {
            this.f239334f0 = "";
        }
        String valueOf = String.valueOf(53);
        String string2 = extras.getString("from");
        if (string2 != null) {
            valueOf = string2;
        }
        this.f239335g0 = Integer.valueOf(valueOf).intValue();
        this.f239337i0 = extras.getLong(IPublicAccountImageCollectionMainActivity.ARTICLE_ID, -1L);
        this.f239338j0 = extras.getString("row_key", "");
        this.f239339k0 = extras.getInt("channelid", -1);
        this.f239340l0 = extras.getInt("strategyid", -1);
        this.f239341m0 = extras.getLong("algorithmid", -1L);
        this.f239336h0 = extras.getLong("recommendSeq", -1L);
        if (intent.hasExtra("big_brother_source_key")) {
            return;
        }
        intent.putExtra("big_brother_source_key", p62.a.a(this.f239339k0));
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class ReadInJoyArticleDetailFragment extends WebViewFragment {
        public static final String P = "ReadInJoyArticleDetailFragment";
        public boolean C;
        private String L;
        public ImageView D = null;
        public long E = 0;
        public long F = 0;
        public long G = 0;
        public long H = 0;
        public long I = 0;
        public String J = "-1";
        public boolean K = false;
        private String M = null;
        private boolean N = false;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$3, reason: invalid class name */
        /* loaded from: classes33.dex */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ ReadInJoyArticleDetailFragment this$0;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$3$a */
            /* loaded from: classes33.dex */
            class a extends AnimatorListenerAdapter {
                a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AnonymousClass3.this.this$0.D.setVisibility(8);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                if (IPluginAdapterProxy.getProxy().isNightMode() && this.this$0.getUIStyleHandler().S != null) {
                    this.this$0.getUIStyleHandler().S.setBackgroundColor(-1);
                }
                ImageView imageView = this.this$0.D;
                if (imageView != null) {
                    imageView.animate().alpha(0.0f).setDuration(200L).setListener(new a());
                    this.this$0.D.animate().start();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes33.dex */
        public class b extends com.tencent.mobileqq.webview.swift.proxy.b {
            b(q qVar) {
                super(qVar);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.b, com.tencent.mobileqq.webviewplugin.q
            public void jg(String str, String str2, String str3, boolean z16, int i3, int i16, View.OnClickListener onClickListener, com.tencent.mobileqq.webview.nativeapi.a aVar) {
                ReadInJoyArticleDetailFragment.this.getSwiftTitleUI().G(str, str2, str3, z16, i3, i16, null, onClickListener, aVar);
                if (ReadInJoyArticleDetailFragment.this.getSwiftTitleUI().f314054i != null && ReadInJoyArticleDetailFragment.this.getSwiftTitleUI().E != null && ReadInJoyArticleDetailFragment.this.getSwiftTitleUI().M != null && !z16 && i3 == 4) {
                    if (ReadInJoyArticleDetailFragment.this.getUIStyleHandler().f314512m.f314619b || ReadInJoyArticleDetailFragment.this.getUIStyle().f314641x) {
                        ReadInJoyArticleDetailFragment.this.Eh(true);
                        ReadInJoyArticleDetailFragment.this.getSwiftTitleUI().z(-1);
                    } else {
                        ReadInJoyArticleDetailFragment.this.Eh(false);
                        ReadInJoyArticleDetailFragment.this.getSwiftTitleUI().z(-16777216);
                    }
                }
                ((SwiftBrowserShareMenuHandler) ReadInJoyArticleDetailFragment.this.mComponentsProvider.a(4)).D();
                ReadInJoyArticleDetailFragment.this.getUIStyleHandler().f0();
            }
        }

        /* compiled from: P */
        /* loaded from: classes33.dex */
        class c extends com.tencent.mobileqq.webview.swift.proxy.a {
            c(com.tencent.mobileqq.webview.swift.utils.t tVar) {
                super(tVar);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public boolean afterWebViewEngineHandleOverrideUrl(WebView webView, String str) {
                QLog.d(ReadInJoyArticleDetailFragment.P, 1, "afterWebViewEngineHandleOverrideUrl url: " + str);
                ReadInJoyArticleDetailFragment.this.yh(webView, str);
                return super.afterWebViewEngineHandleOverrideUrl(webView, str);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public boolean beforeWebViewEngineHandleOverrideUrl(WebView webView, String str) {
                QLog.d(ReadInJoyArticleDetailFragment.P, 1, "beforeWebViewEngineHandleOverrideUrl url: " + str);
                ReadInJoyArticleDetailFragment.this.yh(webView, str);
                return super.beforeWebViewEngineHandleOverrideUrl(webView, str);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public Object handlerMiscCallback(String str, Bundle bundle) {
                if (TextUtils.equals("netTimeConsumingReport", str) && bundle != null && bundle.containsKey("firstbyte")) {
                    String string = bundle.getString("firstword");
                    try {
                        if (!TextUtils.isEmpty(string)) {
                            ReadInJoyArticleDetailFragment.this.I = Long.parseLong(string);
                        }
                    } catch (NumberFormatException e16) {
                        QLog.e(ReadInJoyArticleDetailFragment.P, 1, "[handlerMiscCallback] e = " + e16);
                    }
                }
                return super.handlerMiscCallback(str, bundle);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public boolean interceptStartLoadUrl() {
                ReadInJoyArticleDetailFragment.this.F = System.currentTimeMillis();
                super.interceptStartLoadUrl();
                return true;
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onInitTitleBar(Bundle bundle) {
                super.onInitTitleBar(bundle);
                ReadInJoyArticleDetailFragment.this.zh(bundle);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onInitUIContent(Bundle bundle) {
                super.onInitUIContent(bundle);
                ReadInJoyArticleDetailFragment.this.xh();
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public void onPageFinished(WebView webView, String str) {
                ReadInJoyArticleDetailFragment.this.onPageFinished(webView, str);
                super.onPageFinished(webView, str);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                ReadInJoyArticleDetailFragment.this.Ah(str);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public void onReceivedError(WebView webView, int i3, String str, String str2) {
                ReadInJoyArticleDetailFragment.this.Bh(i3, str, str2);
                super.onReceivedError(webView, i3, str, str2);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onShowPreview(Bundle bundle) {
                ReadInJoyArticleDetailFragment.this.Ch(bundle, this.webViewKernelCallBack);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onWebViewInit(Bundle bundle, TouchWebView touchWebView) {
                super.onWebViewInit(bundle, touchWebView);
                ReadInJoyArticleDetailFragment.this.Dh();
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                QLog.d(ReadInJoyArticleDetailFragment.P, 1, "shouldOverrideUrlLoading url: " + str);
                ReadInJoyArticleDetailFragment.this.yh(webView, str);
                return ReadInJoyArticleDetailFragment.this.uh(str) || super.shouldOverrideUrlLoading(webView, str);
            }
        }

        /* compiled from: P */
        /* loaded from: classes33.dex */
        class d extends v {
            d() {
            }

            @Override // com.tencent.mobileqq.webview.swift.component.v
            public void D() {
                super.D();
                if (this.f314441d.getWebView() != null) {
                    ReadInJoyArticleDetailFragment readInJoyArticleDetailFragment = ReadInJoyArticleDetailFragment.this;
                    if (!readInJoyArticleDetailFragment.C || ((WebViewFragment) readInJoyArticleDetailFragment).webView == null || this.S == null) {
                        return;
                    }
                    ReadInJoyArticleDetailFragment.this.D = new ImageView(ReadInJoyArticleDetailFragment.super.getQBaseActivity());
                    ReadInJoyArticleDetailFragment.this.D.setImageResource(R.drawable.f161226br4);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    ReadInJoyArticleDetailFragment.this.D.setLayoutParams(layoutParams);
                    this.S.addView(ReadInJoyArticleDetailFragment.this.D);
                    if (IPluginAdapterProxy.getProxy().isNightMode()) {
                        this.S.setBackgroundColor(DownloadCardView.COLOR_APP_VERSION);
                        ReadInJoyArticleDetailFragment.this.D.setImageResource(R.drawable.br5);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Eh(boolean z16) {
            Map<String, String> vh5 = vh();
            if (vh5 != null && "1".equals(vh5.get("from_customer_service"))) {
                getSwiftTitleUI().E.setVisibility(8);
                return;
            }
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.gl_, null);
            if (z16) {
                drawable = BaseImageUtil.maskDrawableByColor(drawable, -1);
            }
            getSwiftTitleUI().E.setImageDrawable(drawable);
            getSwiftTitleUI().E.setVisibility(0);
        }

        private void initData() {
            Intent intent = this.intent;
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            Bundle extras = this.intent.getExtras();
            this.L = extras.getString("row_key", "");
            String string = extras.getString("url");
            if (((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isKandianNeedAddSkinParamsUrl(string)) {
                extras.putString("url", string);
                this.intent.putExtra("url", string);
            }
            QLog.i(P, 1, "[initData] url = " + this.M);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean uh(String str) {
            UrlOverrideInfo a16;
            Map<String, String> vh5 = vh();
            if (vh5 == null || !"1".equals(vh5.get("from_customer_service")) || (a16 = com.tencent.mobileqq.kandian.biz.detail.a.a(str, vh5)) == null) {
                return false;
            }
            String b16 = com.tencent.mobileqq.kandian.biz.detail.a.b(str, a16);
            if (b16.isEmpty()) {
                return false;
            }
            ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleScheme(b16, null);
            return true;
        }

        @Nullable
        private Map<String, String> vh() {
            if (!(getActivity() instanceof ReadInJoyArticleDetailActivity)) {
                return null;
            }
            ECWebSchemeUserDataMap eCWebSchemeUserDataMap = ((ReadInJoyArticleDetailActivity) getActivity()).f239351w0;
            if (!((ReadInJoyArticleDetailActivity) getActivity()).f239350v0 || eCWebSchemeUserDataMap == null) {
                return null;
            }
            return eCWebSchemeUserDataMap.getMap();
        }

        private void wh() {
            AppInterface appInterface;
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime == null || (appInterface = (AppInterface) runtime.getAppRuntime("modular_web")) == null) {
                return;
            }
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + appInterface.getCurrentAccountUin(), 4);
            if (sharedPreferences != null) {
                this.C = sharedPreferences.getBoolean("readInJoy_loading_img", false);
                if (QLog.isColorLevel()) {
                    QLog.i(P, 2, "showGif" + this.C);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xh() {
            if (TextUtils.isEmpty(this.L) || getUIStyleHandler().T == null) {
                return;
            }
            getUIStyleHandler().T.setVisibility(8);
        }

        public void Ah(String str) {
            QLog.d(P, 1, "onPageStarted");
            if (getStatistics().f314380x0) {
                this.G = System.currentTimeMillis();
            }
            xh();
        }

        public void Bh(int i3, String str, String str2) {
            QLog.i(P, 1, " onReceivedError switch states : " + this.N);
            if (this.N) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("url", str2);
                hashMap.put("result_code", String.valueOf(i3));
                hashMap.put("result_msg", str);
                com.tencent.mobileqq.kandian.biz.detail.b.f239363a.a("ec_quality_openurl_report", hashMap, String.valueOf(com.tencent.mobileqq.kandian.base.utils.b.d()));
            }
        }

        public void Ch(Bundle bundle, com.tencent.mobileqq.webview.swift.utils.t tVar) {
            if (getUIStyleHandler().R) {
                return;
            }
            tVar.onShowPreview(bundle);
            if (getSwiftTitleUI() != null && getSwiftTitleUI().f314054i != null && getSwiftTitleUI().E != null && getSwiftTitleUI().M != null) {
                Eh(false);
                if (!getUIStyleHandler().f314512m.f314619b && !getUIStyle().f314641x) {
                    getSwiftTitleUI().M.setBackgroundResource(0);
                    getSwiftTitleUI().M.setBackgroundColor(-1);
                    if (getUIStyleHandler().T != null) {
                        getUIStyleHandler().T.setCustomColor(-1);
                    }
                    if (getWebTitleBarInterface().a3() != null) {
                        getWebTitleBarInterface().a3().setBackgroundColor(-1);
                        getUIStyle().f314637t = true;
                    }
                    getSwiftTitleUI().W(-16777216);
                    getSwiftTitleUI().S(-16777216);
                }
            }
            if (this.mNightMode) {
                View view = new View(getQBaseActivity());
                view.setBackgroundColor(1996488704);
                getQBaseActivity().addContentView(view, new ViewGroup.LayoutParams(-1, -1));
            }
        }

        public void Dh() {
            TouchWebView touchWebView = this.webView;
            if (touchWebView != null) {
                touchWebView.setMask(false);
            }
            boolean z16 = this.intent.getExtras().getBoolean("ip_connect", false);
            TouchWebView touchWebView2 = this.webView;
            if (touchWebView2 != null && z16) {
                IX5WebSettingsExtension settingsExtension = touchWebView2.getSettingsExtension();
                int tbsCoreVersion = WebView.getTbsCoreVersion(BaseApplication.getContext());
                if (QLog.isColorLevel()) {
                    QLog.d(P, 2, "tbsCoreVersion: " + tbsCoreVersion);
                }
                if (settingsExtension == null || tbsCoreVersion < 36855) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(P, 2, "rij webview use ip connect");
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_POST);
                arrayList.add("*.qpic.cn");
                settingsExtension.setHttpDnsDomains(arrayList);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(P, 2, "ipConnect: " + z16);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public com.tencent.mobileqq.webview.swift.component.b createComponentsProvider() {
            return new com.tencent.mobileqq.webview.swift.component.b(this, 1023, new a());
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public boolean doOnCreate(Bundle bundle) {
            y yVar;
            this.E = System.currentTimeMillis();
            initData();
            Bundle extras = this.intent.getExtras();
            boolean z16 = false;
            this.N = extras.getBoolean("ecommerce_web", false);
            QLog.i(P, 1, " get bundle " + this.N);
            try {
                z16 = super.doOnCreate(bundle);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            String string = extras.getString("preload_iamge_url");
            TouchWebView touchWebView = this.webView;
            if (touchWebView != null && touchWebView.getPluginEngine() != null && (yVar = (y) this.webView.getPluginEngine().m("pubAccountPreload")) != null && !TextUtils.isEmpty(string)) {
                yVar.p(string, true);
            }
            wh();
            return z16;
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
        public q getWebTitleBarInterface() {
            return new b(this.webViewSurface);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
        public com.tencent.mobileqq.webview.swift.utils.t getWebViewKernelCallBack() {
            return new c(this.webViewSurface);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
        public void onDestroy() {
            super.onDestroy();
        }

        public void onPageFinished(WebView webView, String str) {
            boolean z16 = getStatistics().f314381y0;
            yh(webView, str);
            if (z16) {
                this.H = System.currentTimeMillis();
                this.K = true;
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle bundle) {
            super.onViewCreated(view, bundle);
        }

        public void yh(WebView webView, String str) {
            QLog.i(P, 1, "loadECommerceUrlForMonitor switch states : isEcommercePage : " + this.N);
            if (this.N) {
                webView.addJavascriptInterface(new com.tencent.mobileqq.kandian.biz.detail.c(str), "local_obj");
                webView.loadUrl("javascript:window.local_obj.getSource(document.body.outerHTML);");
            }
        }

        public void zh(Bundle bundle) {
            QLog.d(P, 1, "ReadInJoyArticleDetailActivity onInitTitleBar");
            if (getSwiftTitleUI().f314054i == null || getSwiftTitleUI().E == null || getSwiftTitleUI().M == null) {
                return;
            }
            if (!getUIStyleHandler().f314512m.f314619b && !getUIStyle().f314641x) {
                Eh(false);
                getSwiftTitleUI().z(-16777216);
            } else {
                Eh(true);
                getSwiftTitleUI().z(-1);
            }
        }

        /* compiled from: P */
        /* loaded from: classes33.dex */
        class a implements b.d {
            a() {
            }

            @Override // com.tencent.mobileqq.webview.swift.component.b.d
            public Object a(int i3) {
                if (i3 != 2) {
                    return null;
                }
                return new d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        if (i16 == -1) {
            if (i3 == 2) {
                ReportController.o(null, "CliOper", "", "", "0X8005438", "0X8005438", 0, 0, "", "", "", "");
                QfavBuilder.l0(this, intent);
                return;
            }
        } else if (i16 == 1) {
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
    }
}
