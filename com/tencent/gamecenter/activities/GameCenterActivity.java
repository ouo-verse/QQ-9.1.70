package com.tencent.gamecenter.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.common.util.ScreenshotManager;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.i;
import com.tencent.mobileqq.gamecenter.api.impl.GameCenterCommonApiImpl;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.data.PadFaceManager;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.gamecenter.media.c;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;
import java.io.IOException;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;

/* compiled from: P */
@RoutePage(desc = "\u624b\u6e38\u4e2d\u5fc3Activity", path = RouterConstants.UI_ROUTE_GAME_CENTER_ACTIVITY)
/* loaded from: classes6.dex */
public class GameCenterActivity extends QQBrowserActivity implements Handler.Callback, SDKInitListener {
    public static final int ERROR_STEP_1 = 1201;
    public static final int ERROR_STEP_11 = 1211;
    public static final int ERROR_STEP_12 = 1212;
    public static final int ERROR_STEP_2 = 1202;
    public static final int ERROR_STEP_Detected = 1213;
    public static final int FEATURE_ID = 123;
    public static final int GAMECENTER_WV = 5127;
    public static final int MSG_HIDE_TITLE_LOADING = 2004;
    public static final int MSG_SHOW_TITLE_LOADING = 2003;
    public static final int MSG_SHOW_TOAST = 2006;
    public static final int RECENT_PLAY_WV = 3;
    public static final int SPAN_ID = 1;
    public static final String TAG = "GameCenterActivity";
    private static int sActivityNum;

    /* renamed from: ad, reason: collision with root package name */
    private Drawable f106483ad;
    public Handler gcHandler = null;
    private boolean isFinish = false;
    private i mActConfigCallback = new i() { // from class: com.tencent.gamecenter.activities.a
        @Override // com.tencent.mobileqq.gamecenter.api.i
        public final void a(String str) {
            GameCenterActivity.this.lambda$new$1(str);
        }
    };
    private boolean mIsNeedMiniMsg;
    private boolean mIsNeedMiniMsgParsed;
    private TouchWebView.OnScrollChangedListener mListener;
    private RelativeLayout mLoadingView;
    private Drawable[] mOldDrawables;
    private int mOldPadding;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class GameCenterFragment extends WebViewFragment {
        public static int M;
        public static long N;
        public static long P;
        protected String D;
        private DisplayMetrics E;
        private long F;
        private AppInterface I;
        protected boolean C = false;
        private String G = "";
        private String H = "";
        private boolean J = false;
        public long K = 0;
        public boolean L = true;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes6.dex */
        public class a implements ScreenshotManager.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ WebView f106484a;

            a(WebView webView) {
                this.f106484a = webView;
            }

            @Override // com.tencent.gamecenter.common.util.ScreenshotManager.b
            public void a(int i3, String str) {
                QLog.i("GameCenterFragment", 1, "addShot res code=" + i3);
                if (i3 == 304) {
                    ScreenshotManager.m().f(this.f106484a);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class b extends com.tencent.mobileqq.webview.swift.proxy.a {

            /* compiled from: P */
            /* loaded from: classes6.dex */
            class a implements ScreenshotManager.b {
                a() {
                }

                @Override // com.tencent.gamecenter.common.util.ScreenshotManager.b
                public void a(int i3, String str) {
                    QLog.i("GameCenterFragment", 1, "removeShotMask code=" + i3);
                }
            }

            b(t tVar) {
                super(tVar);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public String getUAMark() {
                return "gamecenter";
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public boolean interceptStartLoadUrl() {
                return GameCenterFragment.this.xh(this.webViewKernelCallBack);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                GameCenterFragment gameCenterFragment = GameCenterFragment.this;
                if (gameCenterFragment.L && !gameCenterFragment.isDestroyed()) {
                    if (((WebViewFragment) GameCenterFragment.this).webView != null && ((WebViewFragment) GameCenterFragment.this).webView.canGoBack() && GameCenterFragment.this.getSwiftTitleUI().f314054i != null) {
                        GameCenterFragment.this.getSwiftTitleUI().f314054i.setText(R.string.f170549u3);
                    } else {
                        GameCenterFragment.this.getSwiftTitleUI().D(((WebViewFragment) GameCenterFragment.this).intent);
                    }
                    GameCenterFragment.this.Ah(str);
                    GameCenterFragment.this.L = false;
                }
                if (!TextUtils.isEmpty(str) && GameCenterFragment.this.yh(str) && ScreenshotManager.m().n()) {
                    ScreenshotManager.m().s(webView, new a());
                    ScreenshotManager.m().k();
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (!GameCenterFragment.this.J && !TextUtils.isEmpty(str) && GameCenterFragment.this.yh(str)) {
                    GameCenterFragment.P = System.currentTimeMillis();
                    GameCenterFragment.this.Bh(webView);
                }
                super.onPageStarted(webView, str, bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Bh(WebView webView) {
            String str;
            if (!GameCenterSpUtils.readBoolFromSp("gamecenter_shot_switch")) {
                return;
            }
            QLog.i("GameCenterFragment", 1, "startMaskOpt murl=" + this.G);
            try {
                str = Uri.parse(this.G).getQueryParameter("preMask");
            } catch (Exception e16) {
                QLog.e("GameCenterFragment", 1, "GAMECENTER_MASK_KEY error=" + e16.toString());
                str = null;
            }
            ScreenshotManager.m().g(webView, str, new a(webView));
        }

        private void vh() {
            String str = null;
            if (getAppRuntime() == null) {
                this.mApp = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
            }
            if (this.I == null) {
                this.I = (AppInterface) getAppRuntime();
            }
            AppInterface appInterface = this.I;
            if (appInterface != null) {
                this.D = appInterface.getCurrentAccountUin();
            } else if (QLog.isColorLevel()) {
                QLog.i("GameCenterFragment", 2, "GameCenterActivity..gcRuntime is null");
            }
            if (!TextUtils.isEmpty(this.D) && !TextUtils.isEmpty(this.mUrl) && yh(this.mUrl)) {
                try {
                    str = Uri.parse(this.mUrl).getQueryParameter("uin");
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                if (str == null) {
                    String b16 = HtmlOffline.b(this.mUrl, "uin=" + this.D);
                    this.mUrl = b16;
                    this.intent.putExtra("url", b16);
                }
            }
        }

        private String wh() {
            String str = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393&plat=qq&_wv=5127";
            if (!TextUtils.isEmpty(this.H)) {
                str = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393&plat=qq&_wv=5127" + ContainerUtils.FIELD_DELIMITER + this.H;
            }
            return str + "&st=" + this.F;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean yh(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                str2 = Uri.parse(str).getQueryParameter("status");
            } catch (Exception e16) {
                e16.printStackTrace();
                str2 = null;
            }
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0041 A[Catch: all -> 0x0063, TryCatch #0 {, blocks: (B:3:0x0001, B:19:0x0009, B:6:0x001c, B:8:0x0022, B:9:0x003b, B:11:0x0041, B:13:0x0049, B:22:0x0018), top: B:2:0x0001, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022 A[Catch: all -> 0x0063, TryCatch #0 {, blocks: (B:3:0x0001, B:19:0x0009, B:6:0x001c, B:8:0x0022, B:9:0x003b, B:11:0x0041, B:13:0x0049, B:22:0x0018), top: B:2:0x0001, inners: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private synchronized void zh(String str) {
            String queryParameter;
            if (!TextUtils.isEmpty(this.G)) {
                try {
                    queryParameter = Uri.parse(this.G).getQueryParameter("status");
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                if (QLog.isColorLevel()) {
                    QLog.i("GameCenterFragment", 2, "parseExtraParamToReport , status" + queryParameter);
                }
                if (!TextUtils.isEmpty(queryParameter)) {
                    TextUtils.isEmpty(str);
                    if (this.E == null) {
                        this.E = new DisplayMetrics();
                        super.getQBaseActivity().getWindowManager().getDefaultDisplay().getMetrics(this.E);
                    }
                }
            }
            queryParameter = null;
            if (QLog.isColorLevel()) {
            }
            if (!TextUtils.isEmpty(queryParameter)) {
            }
        }

        public void Ah(String str) {
            WebViewPluginEngine pluginEngine;
            TouchWebView touchWebView = this.webView;
            if (touchWebView == null) {
                pluginEngine = null;
            } else {
                pluginEngine = touchWebView.getPluginEngine();
            }
            if (!this.J && !str.startsWith("data") && pluginEngine != null) {
                WebViewPlugin m3 = pluginEngine.m("offline");
                if (m3 != null && (m3 instanceof OfflinePlugin)) {
                    if (((OfflinePlugin) m3).G == 0) {
                        zh("0");
                        return;
                    } else {
                        zh(HtmlOffline.z(GameCenterActivity.getBid(str)));
                        return;
                    }
                }
                return;
            }
            this.J = false;
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public boolean doOnCreate(Bundle bundle) {
            String str;
            if (QLog.isColorLevel()) {
                QLog.d("GameCenterFragment", 2, "game center fragment doOnCreate");
            }
            if (this.intent == null) {
                QQToast.makeText(super.getQBaseActivity().getApplicationContext(), R.string.a4p, 0).show();
                super.getQBaseActivity().finish();
                return false;
            }
            M++;
            this.F = System.currentTimeMillis();
            this.G = this.intent.getStringExtra("url");
            this.H = this.intent.getStringExtra("redTouch");
            if (TextUtils.isEmpty(this.G)) {
                String wh5 = wh();
                this.G = wh5;
                this.intent.putExtra("url", wh5);
            }
            if (!TextUtils.isEmpty(this.G) && yh(this.G)) {
                long longExtra = this.intent.getLongExtra("plugin_start_time", 0L);
                N = longExtra;
                if (longExtra == 0) {
                    try {
                        str = Uri.parse(this.G).getQueryParameter("st");
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        N = Long.valueOf(str).longValue();
                    }
                }
            }
            boolean doOnCreate = super.doOnCreate(bundle);
            this.C = false;
            return doOnCreate;
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
        public t getWebViewKernelCallBack() {
            return new b(this.webViewSurface);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
        public void onDestroy() {
            this.C = true;
            int i3 = M - 1;
            M = i3;
            if (i3 == 0) {
                this.K = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d("GameCenterFragment", 2, "enterGameCenterTime = " + N + " , startLoadGameCenterTime = " + P + " , exitGameCenterTime = " + this.K);
                }
                ff.T(null, "vip", "0X8004BFB", "0X8004BFB", 0, 0, String.valueOf(N), String.valueOf(P), String.valueOf(this.K));
            }
            super.onDestroy();
            c.b().c();
            System.gc();
            ScreenshotManager.m().l();
        }

        public boolean xh(t tVar) {
            if (AuthorizeConfig.y().l(this.mUrl)) {
                vh();
            }
            if (yh(this.G)) {
                IX5WebViewExtension x5WebViewExtension = getWebView().getX5WebViewExtension();
                boolean z16 = false;
                if (x5WebViewExtension != null) {
                    PadFaceManager.b m3 = PadFaceManager.m((AppInterface) getAppRuntime());
                    long j3 = m3.f211984b;
                    if (j3 != 0 && m3.f211983a != j3) {
                        if (!TextUtils.isEmpty(m3.f211985c)) {
                            x5WebViewExtension.updateServiceWorkerBackground(this.G);
                            String b16 = HtmlOffline.b(m3.f211985c, "jump_url=" + this.mUrl);
                            this.mUrl = b16;
                            this.G = b16;
                            this.intent.putExtra("url", b16);
                            QLog.e("GameCenterFragment", 1, "doCreateLoopStep_InitWebView: replace url with: ", this.mUrl);
                        }
                        PadFaceManager.t((AppInterface) getAppRuntime(), m3.f211984b);
                    }
                }
                PadFaceAd p16 = PadFaceManager.p(getQBaseActivity().getIntent());
                if (p16 != null) {
                    if (p16.isValid() || p16.redPointId > 0) {
                        z16 = true;
                    }
                    if (z16) {
                        QQGamePadFaceFragment.xh(getQBaseActivity(), p16);
                    }
                }
            }
            return tVar.interceptStartLoadUrl();
        }
    }

    public GameCenterActivity() {
        this.mFragmentClass = GameCenterFragment.class;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getBid(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Uri.parse(str).getQueryParameter("_bid");
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private void handleActPage() {
        Intent intent = getIntent();
        if (intent == null || !"1".equals(intent.getStringExtra(GameCenterCommonApiImpl.KEY_ACT_FLAG))) {
            return;
        }
        String stringExtra = intent.getStringExtra("url");
        String stringExtra2 = intent.getStringExtra(GameCenterCommonApiImpl.KEY_ACT_ID);
        QLog.i("GameActWeb.GameCenterActivity", 1, "[handleActPage], actId:" + stringExtra2);
        ((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).checkNewConfiguredUrl(stringExtra, stringExtra2, this.mActConfigCallback);
    }

    private void handlePushReport() {
        Intent intent = getIntent();
        if (intent != null && intent.getIntExtra(AppConstants.Key.KEY_GAME_MSG_ENTER_FROM, 0) == 1) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handlePushReport() called");
            }
            intent.removeExtra(AppConstants.Key.KEY_GAME_MSG_ENTER_FROM);
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).report(10004, 2);
        }
    }

    private void hideLoadingView() {
        RelativeLayout relativeLayout = this.mLoadingView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public static String httpRequest(Context context, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("appids", str2);
        String str4 = "uin=" + str3;
        Bundle bundle2 = new Bundle();
        bundle2.putString("Cookie", str4);
        try {
            String openUrl = HttpUtil.openUrl(context, str, "POST", bundle, bundle2);
            if (QLog.isColorLevel()) {
                QLog.i("GameCenter", 2, "httpRequest: result:" + openUrl);
            }
            return openUrl;
        } catch (ClientProtocolException unused) {
            if (QLog.isColorLevel()) {
                QLog.i("GameCenter", 2, "httpRequest:ClientProtocolException");
                return "{'ret': -104, 'data' : 'httpRequest:ClientProtocolException'}";
            }
            return "{'ret': -104, 'data' : 'httpRequest:ClientProtocolException'}";
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("GameCenter", 2, "httpRequest:" + e16.getMessage());
                return "{'ret': -105, 'data' : 'httpRequest::Http no response.'}";
            }
            return "{'ret': -105, 'data' : 'httpRequest::Http no response.'}";
        }
    }

    public static boolean isContainsGameUrl(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(String str) {
        if (getHostWebView() != null) {
            getHostWebView().loadUrl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(final String str) {
        QLog.i("GameActWeb.GameCenterActivity", 1, "[onUrlObtainedCallback],url:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gamecenter.activities.b
            @Override // java.lang.Runnable
            public final void run() {
                GameCenterActivity.this.lambda$new$0(str);
            }
        });
    }

    public static void parseTraceUrl() {
        String str;
        SharedPreferences sharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("game_center_sp_mutiprocess", 4);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null || runtime.getLongAccountUin() == 0) {
            str = "";
        } else {
            str = runtime.getAccount();
        }
        String string = sharedPreferences.getString("trace_url_keyword" + str, "");
        SwiftBrowserStatistics.b.f314407h = new ArrayList();
        QLog.d(TAG, 1, "parseTraceUrl:" + string);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                SwiftBrowserStatistics.b.f314407h.add((String) jSONArray.opt(i3));
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parseTraceUrl:", e16);
        }
    }

    public static void reportDetectedBlankScreen(String str, int i3) {
        int indexOf = str.indexOf(63);
        if (indexOf <= 0) {
            indexOf = str.length();
        }
        isContainsGameUrl(str.substring(0, indexOf));
    }

    public static void reportStep(String str, int i3, boolean z16, boolean z17) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        isContainsGameUrl(str);
    }

    private void showLoadingView() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if (!TextUtils.isEmpty(HtmlOffline.z(getBid(intent.getStringExtra("url"))))) {
            QLog.i("GameActWeb.GameCenterActivity", 1, "[showLoadingView], have offline data, return.");
            return;
        }
        if (this.mLoadingView == null) {
            this.mLoadingView = new RelativeLayout(this);
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setId(R.id.d_5);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.me9));
            ImageView imageView2 = new ImageView(this);
            imageView2.setId(R.id.d_6);
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView2.setImageDrawable(getResources().getDrawable(R.drawable.me_));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Utils.n(50.0f, getResources()), Utils.n(30.0f, getResources()));
            layoutParams.addRule(13);
            this.mLoadingView.addView(imageView, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(Utils.n(60.0f, getResources()), Utils.n(15.0f, getResources()));
            layoutParams2.addRule(13);
            layoutParams2.addRule(3, imageView.getId());
            this.mLoadingView.addView(imageView2, layoutParams2);
            TextView textView = new TextView(this);
            textView.setText("\u52a0\u8f7d\u4e2d...");
            textView.setTextSize(12.0f);
            textView.setTextColor(Color.parseColor("#adadad"));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            layoutParams3.addRule(3, imageView2.getId());
            this.mLoadingView.addView(textView, layoutParams3);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
            this.mLoadingView.setVisibility(8);
            getRootView().addView(this.mLoadingView, layoutParams4);
        }
        this.mLoadingView.setVisibility(0);
    }

    private boolean startTitleProgress() {
        TextView textView;
        WebViewFragment currentWebViewFragment = getCurrentWebViewFragment();
        if (currentWebViewFragment == null || (textView = currentWebViewFragment.getSwiftTitleUI().f314059m) == null || this.f106483ad != null) {
            return false;
        }
        this.f106483ad = super.getResources().getDrawable(R.drawable.common_loading5);
        this.mOldDrawables = textView.getCompoundDrawables();
        this.mOldPadding = textView.getCompoundDrawablePadding();
        textView.setCompoundDrawablePadding(10);
        Drawable drawable = this.f106483ad;
        Drawable[] drawableArr = this.mOldDrawables;
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawableArr[1], drawableArr[2], drawableArr[3]);
        ((Animatable) this.f106483ad).start();
        return true;
    }

    private boolean stopTitleProgress() {
        TextView textView;
        Object obj;
        WebViewFragment currentWebViewFragment = getCurrentWebViewFragment();
        if (currentWebViewFragment == null || (textView = currentWebViewFragment.getSwiftTitleUI().f314059m) == null || (obj = this.f106483ad) == null) {
            return false;
        }
        ((Animatable) obj).stop();
        this.f106483ad = null;
        textView.setCompoundDrawablePadding(this.mOldPadding);
        Drawable[] drawableArr = this.mOldDrawables;
        textView.setCompoundDrawablesWithIntrinsicBounds(drawableArr[0], drawableArr[1], drawableArr[2], drawableArr[3]);
        return true;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        sActivityNum++;
        handleActPage();
        handlePushReport();
        QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getApplication(), this);
        return super.doOnCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        this.isFinish = true;
        Handler handler = this.gcHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.gcHandler = null;
        }
        VideoPlaySDKManager.getInstance().removeSDKInstalledListener(this);
        super.doOnDestroy();
        int i3 = sActivityNum - 1;
        sActivityNum = i3;
        if (i3 <= 0) {
            MiniMsgIPCClient.getInstance().clearBusiness(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        super.doOnStart();
        showLoadingView();
    }

    protected MiniMsgUserParam getMiniMsgUserParam() {
        MiniMsgUserParam miniMsgUserParam = new MiniMsgUserParam();
        miniMsgUserParam.businessName = 8;
        miniMsgUserParam.accessType = 0;
        miniMsgUserParam.entryType = 0;
        miniMsgUserParam.positionX = -1;
        miniMsgUserParam.positionY = -1;
        miniMsgUserParam.colorType = 0;
        miniMsgUserParam.filterMsgType = 0;
        return miniMsgUserParam;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.isFinish) {
            return true;
        }
        int i3 = message.what;
        if (i3 != 2003) {
            if (i3 != 2004) {
                if (i3 != 2006) {
                    return true;
                }
                QQToast.makeText(BaseApplicationImpl.getApplication(), (String) message.obj, 0).show();
                return true;
            }
            stopTitleProgress();
            return true;
        }
        startTitleProgress();
        this.gcHandler.sendEmptyMessageDelayed(2004, 45000L);
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isNeedMiniMsg() {
        Uri parse;
        if (!this.mIsNeedMiniMsgParsed) {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    parse = Uri.parse(intent.getStringExtra("url"));
                } catch (Exception unused) {
                }
            } else {
                parse = null;
            }
            if (parse != null) {
                this.mIsNeedMiniMsg = "1".equals(parse.getQueryParameter("gc_mini_floating"));
            }
            this.mIsNeedMiniMsgParsed = true;
        }
        return this.mIsNeedMiniMsg;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        GameCenterVideoViewController a16 = c.b().a();
        if (a16 != null && a16.isFullScreenMode()) {
            a16.exitFullScreen();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (webView instanceof TouchWebView) {
            ((TouchWebView) webView).setOnScrollChangedListener(this.mListener);
        }
        hideLoadingView();
    }

    @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
    public void onSDKInited(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "QQVideo Inited:" + z16);
        }
    }

    public void setOnScrollChangedListener(TouchWebView.OnScrollChangedListener onScrollChangedListener) {
        this.mListener = onScrollChangedListener;
    }
}
