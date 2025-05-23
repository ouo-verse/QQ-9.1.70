package com.qzone.reborn.feedx.part.detail;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.feed.business.service.QZoneFeedUpdateService;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.misc.web.webview.QzoneWebViewPluginManager;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.feedx.viewmodel.QZoneBlogDetailViewModel;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.utils.m;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.bx;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebView;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Map;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c extends com.qzone.reborn.base.k {
    private RefreshView C;
    private WebViewProgressBar D;
    private bx E;
    private View F;
    private QZoneBlogDetailViewModel G;

    /* renamed from: d, reason: collision with root package name */
    private String f55158d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f55159e;

    /* renamed from: f, reason: collision with root package name */
    private TouchWebView f55160f;

    /* renamed from: h, reason: collision with root package name */
    private s7.b f55161h;

    /* renamed from: i, reason: collision with root package name */
    private BusinessFeedData f55162i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.pubaccount.h f55163m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class b implements m.a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<c> f55166a;

        b(c cVar) {
            this.f55166a = new WeakReference<>(cVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.utils.m.a
        public void a() {
            c cVar = this.f55166a.get();
            if (cVar != null) {
                cVar.T9();
            }
        }
    }

    private String L9(String str) {
        return "javascript:mqq.dispatchEvent(\"DELETE_BLOG\",{\"cellid\":\"" + str + "\"})";
    }

    private String M9() {
        return QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_BLOG_DETAIL, "https://h5.qzone.qq.com/ugc/share?_wv=1&appid=2&res_uin={uin}&cellid={cellid}").replace("{uin}", this.G.r2() + "").replace("{cellid}", this.G.U1() + "");
    }

    private String N9() {
        String str = "";
        if (TextUtils.isEmpty(this.G.U1())) {
            return "";
        }
        try {
            String[] split = this.G.U1().split("_");
            if (split.length > 2) {
                this.G.L2(split[2]);
            }
            str = M9();
            return str + "&from=fav";
        } catch (Exception e16) {
            QZLog.e("get favor blog acturl error", e16.toString());
            return str;
        }
    }

    private String O9() {
        BusinessFeedData W2 = this.G.W2();
        if (W2 != null && W2.getFeedCommInfo() != null) {
            String str = W2.getFeedCommInfo().actionurl;
            if (!TextUtils.isEmpty(str)) {
                if (!this.G.W2().isForwardFeed()) {
                    return str;
                }
                return str + "&_proxyByURL=1";
            }
        }
        return "";
    }

    private void P9() {
        if (!W9()) {
            View view = this.F;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        if (getActivity().getIntent() != null) {
            getActivity().getIntent().removeExtra(BusinessFeedData.STORE_KEY);
        }
        if (this.f55159e) {
            return;
        }
        if (!com.tencent.mobileqq.webview.swift.utils.m.e() && !com.qzone.reborn.configx.g.f53821a.b().r0()) {
            com.tencent.mobileqq.webview.swift.utils.m.h(new b(this));
        } else {
            T9();
        }
    }

    private void Q9(String str) {
        this.f55162i = t6.a.g(str);
        UIStateData<BusinessFeedData> obtainSuccess = UIStateData.obtainSuccess(false);
        obtainSuccess.setDataList(this.f55162i);
        obtainSuccess.setFinish(true);
        this.G.f55901m.setValue(obtainSuccess);
        if (this.G.b2() != null) {
            this.G.b2().A0(this.f55162i, "");
        }
        if (this.f55162i.isNewHandBlogFeed()) {
            LpReportInfo_pf00064.allReport(302, 27, 9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R9(WebView webView, String str, boolean z16) {
        if (webView != null && getActivity() != null && !getActivity().isFinishing()) {
            if (!TextUtils.isEmpty(str) && !str.startsWith("about:blank")) {
                String aa5 = aa(str);
                String k3 = com.tencent.mobileqq.webview.swift.utils.i.k(aa5);
                if (aa5.contains("setBlogData")) {
                    Q9(aa5);
                    return true;
                }
                WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                if (pluginEngine != null && pluginEngine.S(aa5, z16)) {
                    return true;
                }
                if ("http".equals(k3) || "https".equals(k3) || "data".equals(k3) || "file".equals(k3)) {
                    return pluginEngine != null && pluginEngine.s(aa5, 16L, null);
                }
                return true;
            }
            StringBuilder sb5 = new StringBuilder("shouldOverrideUrlLoading fail , url=[");
            sb5.append(str);
            sb5.append("].");
            QZLog.e("QZoneBlogDetailWebViewPart", 1, sb5);
            return true;
        }
        QZLog.e("QZoneBlogDetailWebViewPart", 1, "call shouldOverrideUrlLoading after destroy.");
        return true;
    }

    private void S9() {
        if (V9()) {
            this.f55158d = O9();
        } else if (this.G.u2()) {
            this.f55158d = N9();
        } else {
            this.f55158d = M9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T9() {
        if (!this.f55159e) {
            this.f55160f = new TouchWebView(getActivity());
            s7.c cVar = new s7.c(getActivity(), getActivity(), getIntent(), QzoneWebViewPluginManager.getInstance().getRuntime(), true);
            this.f55161h = cVar;
            cVar.setWebView(this.f55160f);
            this.f55160f.getSettings().setMediaPlaybackRequiresUserGesture(false);
            this.f55159e = true;
        }
        Z9();
    }

    private boolean U9() {
        return (this.G.W2() == null || !this.G.W2().isForwardFeed() || this.G.W2().getFeedCommInfo() == null || this.G.W2().getFeedCommInfo().actiontype == 50 || this.G.W2().getFeedCommInfo().actiontype == 51) ? false : true;
    }

    private boolean V9() {
        BusinessFeedData W2 = this.G.W2();
        return (W2 == null || W2.getFeedCommInfo() == null || (W2.getFeedCommInfo().actiontype != 51 && W2.getFeedCommInfo().actiontype != 50)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean X9(View view, int i3, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i3 != 4 || !this.f55160f.canGoBack()) {
            return false;
        }
        this.f55160f.goBack();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y9(DialogInterface dialogInterface, int i3) {
        K9();
    }

    private void Z9() {
        new com.tencent.mobileqq.webview.m(this.f55161h).a(null, QzoneWebViewPluginManager.getInstance().getRuntime(), null);
        WebViewPluginEngine pluginEngine = this.f55160f.getPluginEngine();
        ba();
        if (pluginEngine != null) {
            this.f55160f.loadUrl(this.f55158d);
            ca();
        }
    }

    private String aa(String str) {
        if (str.startsWith("https://jsbridge/")) {
            return str.replace("https://jsbridge/", "jsbridge://");
        }
        return str.startsWith("http://jsbridge/") ? str.replace("http://jsbridge/", "jsbridge://") : str;
    }

    private void ba() {
        RefreshView refreshView = this.C;
        if (refreshView != null) {
            refreshView.setVisibility(0);
            this.C.setDelayBeforeScrollBack(800L);
            this.f55160f.setOnOverScrollHandler(this.C);
            this.C.addView(this.f55160f, 0, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    private void ca() {
        if (this.f55163m == null) {
            this.f55163m = new com.tencent.biz.pubaccount.h();
        }
        this.f55160f.setWebChromeClient(this.f55163m);
        TouchWebView touchWebView = this.f55160f;
        touchWebView.setWebViewClient(new a(touchWebView.getPluginEngine()));
        RefreshView refreshView = this.C;
        if (refreshView != null) {
            refreshView.setOnKeyListener(new View.OnKeyListener() { // from class: com.qzone.reborn.feedx.part.detail.b
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                    boolean X9;
                    X9 = c.this.X9(view, i3, keyEvent);
                    return X9;
                }
            });
        }
    }

    private void da() {
        if (getActivity() == null || getActivity().isFinishing() || this.f55162i == null) {
            return;
        }
        new com.qzone.component.e().e(getActivity(), 230, getActivity().getString(R.string.gdp), QZoneFeedUtil.C(this.f55162i, false), getActivity().getString(R.string.f170822ak3), getActivity().getResources().getColor(R.color.f157028hz), getActivity().getString(R.string.f170647xd), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.feedx.part.detail.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c.this.Y9(dialogInterface, i3);
            }
        }, null);
    }

    private Intent getIntent() {
        if (getActivity() != null) {
            return getActivity().getIntent();
        }
        return null;
    }

    private void initView() {
        this.C = (RefreshView) getPartRootView().findViewById(R.id.f162770mj3);
        this.D = (WebViewProgressBar) getPartRootView().findViewById(R.id.miz);
        bx bxVar = new bx();
        this.E = bxVar;
        this.D.setController(bxVar);
        this.E.k(this.D);
        this.F = getPartRootView().findViewById(R.id.kar);
    }

    public boolean W9() {
        return this.G.u2() || (this.G.T1() == 2 && !U9());
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneBlogDetailWebViewPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String str, Object obj) {
        if (TextUtils.equals("BLOG_DETAIL_GET_WEBVIEW", str)) {
            return this.f55160f;
        }
        return super.getMessage(str, obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("DELETE_BLOG".equals(str)) {
            da();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        String stringExtra;
        TouchWebView touchWebView;
        super.onActivityResult(i3, i16, intent);
        if (i3 != 2 || intent == null) {
            return;
        }
        if (com.qzone.reborn.configx.g.f53821a.b().w0()) {
            Parcelable parcelableExtra = intent.getParcelableExtra("comment_panel_result_bean");
            if (parcelableExtra instanceof QZoneCommentPanelResultBean) {
                stringExtra = ((QZoneCommentPanelResultBean) parcelableExtra).getInputContent();
            } else {
                stringExtra = "";
            }
        } else {
            stringExtra = intent.getStringExtra("contentIntentKey");
        }
        if (TextUtils.isEmpty(stringExtra) || (touchWebView = this.f55160f) == null || touchWebView.getPluginEngine() == null) {
            return;
        }
        int i17 = i3 & 255;
        WebViewPlugin m3 = this.f55160f.getPluginEngine().m("Qzone");
        if (m3 != null) {
            m3.onActivityResult(intent, (byte) i17, i16);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        TouchWebView touchWebView = this.f55160f;
        if (touchWebView != null && touchWebView.canGoBack()) {
            this.f55160f.goBack();
            return true;
        }
        ArrayList arrayList = new ArrayList();
        QZoneBlogDetailViewModel qZoneBlogDetailViewModel = this.G;
        if (qZoneBlogDetailViewModel != null && qZoneBlogDetailViewModel.X1() != null) {
            arrayList.add(this.G.X1());
            QZoneFeedUpdateService.c().b(arrayList);
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.G = (QZoneBlogDetailViewModel) getViewModel(QZoneBlogDetailViewModel.class);
        initView();
        S9();
        P9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        s7.b bVar = this.f55161h;
        if (bVar != null) {
            bVar.onDestroy();
        }
        TouchWebView touchWebView = this.f55160f;
        if (touchWebView != null) {
            ViewParent parent = touchWebView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeAllViewsInLayout();
            }
            this.f55160f = null;
            if (com.qzone.reborn.configx.g.f53821a.b().W1()) {
                AuthorizeConfig.y().t0();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        s7.b bVar = this.f55161h;
        if (bVar != null) {
            bVar.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        s7.b bVar = this.f55161h;
        if (bVar != null) {
            bVar.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends com.tencent.biz.ui.b {

        /* renamed from: d, reason: collision with root package name */
        private boolean f55164d;

        a(WebViewPluginEngine webViewPluginEngine) {
            super(webViewPluginEngine);
            this.f55164d = true;
        }

        @Override // com.tencent.biz.ui.b, com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (c.this.E == null || c.this.E.c() == 2) {
                return;
            }
            c.this.E.a((byte) 2);
            if (c.this.F != null) {
                c.this.F.setVisibility(8);
            }
        }

        @Override // com.tencent.biz.ui.b, com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (c.this.f55160f != null) {
                if (!TextUtils.isEmpty(str) && (str.contains("yinxiang") || str.contains("evernote"))) {
                    c.this.f55160f.setOnOverScrollHandler(null);
                } else {
                    c.this.f55160f.setOnOverScrollHandler(c.this.C);
                }
            }
            super.onPageStarted(webView, str, bitmap);
            if (c.this.E == null || c.this.E.c() == 0) {
                return;
            }
            c.this.E.a((byte) 0);
            if (c.this.F != null) {
                c.this.F.setVisibility(8);
            }
        }

        @Override // com.tencent.biz.ui.b, com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            this.f55164d = webResourceRequest.isForMainFrame();
            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
            this.f55164d = true;
            return shouldOverrideUrlLoading;
        }

        @Override // com.tencent.biz.ui.b, com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                return c.this.R9(webView, str, this.f55164d);
            } catch (Exception e16) {
                QZLog.e("QZoneBlogDetailWebViewPart", 1, e16, new Object[0]);
                return true;
            }
        }
    }

    private void K9() {
        Map<Integer, String> map = this.f55162i.getOperationInfo().busiParam;
        String str = this.f55162i.getFeedCommInfo().ugckey;
        String str2 = this.f55162i.getFeedCommInfo().feedskey;
        int i3 = this.f55162i.getFeedCommInfo().appid;
        QZoneWriteOperationService.v0().X(this.G.g2(), str, str2, this.f55162i.getFeedCommInfo().clientkey, i3, this.G.r2(), this.G.U1(), "", 0, map, 25, this.G.j2());
        String L9 = L9(this.G.U1());
        Intent intent = new Intent();
        intent.putExtra("DELETE_BLOG", L9);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }
}
