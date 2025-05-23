package com.qzone.reborn.feedpro.part.detail;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.misc.web.webview.QzoneWebViewPluginManager;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellTitle;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedUpdateManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.utils.m;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.bx;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.util.QZLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 T2\u00020\u0001:\u0002UVB\u0007\u00a2\u0006\u0004\bR\u0010SJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J$\u0010&\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\u000f2\u0006\u0010%\u001a\u00020\u0017H\u0002J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0002J\b\u0010(\u001a\u00020\u0006H\u0002R\u0018\u0010+\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u0004\u0018\u00010\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bO\u0010P\u00a8\u0006W"}, d2 = {"Lcom/qzone/reborn/feedpro/part/detail/QzoneFeedProBlogDetailWebViewPart;", "Lcom/qzone/reborn/base/k;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "onPartResume", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "getLogTag", "onPartPause", "onPartDestroy", "action", "", "args", "getMessage", "", "onBackEvent", "initView", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feed", "W9", "M9", "N9", "Q9", "T9", "U9", "Lcom/tencent/smtt/sdk/WebView;", "webView", "url", "isMainFrame", "O9", "S9", "P9", "d", "Ljava/lang/String;", "mBlogUrl", "e", "Z", "mIsWebViewInited", "Lcom/tencent/biz/ui/TouchWebView;", "f", "Lcom/tencent/biz/ui/TouchWebView;", "mWebView", "Ls7/b;", tl.h.F, "Ls7/b;", "mWebViewBuilder", "Lcom/tencent/biz/pubaccount/h;", "i", "Lcom/tencent/biz/pubaccount/h;", "mChromeClient", "Lcom/tencent/biz/ui/RefreshView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/ui/RefreshView;", "mRefreshView", "Lcom/tencent/mobileqq/widget/WebViewProgressBar;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/WebViewProgressBar;", "mProgressBar", "Lcom/tencent/mobileqq/widget/bx;", "D", "Lcom/tencent/mobileqq/widget/bx;", "mProgressBarControl", "Landroid/view/View;", "E", "Landroid/view/View;", "mLoadingView", "Lcom/qzone/reborn/feedpro/viewmodel/d;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedpro/viewmodel/d;", "mBlogViewModel", "getIntent", "()Landroid/content/Intent;", "intent", "<init>", "()V", "G", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProBlogDetailWebViewPart extends com.qzone.reborn.base.k {

    /* renamed from: C, reason: from kotlin metadata */
    private WebViewProgressBar mProgressBar;

    /* renamed from: D, reason: from kotlin metadata */
    private bx mProgressBarControl;

    /* renamed from: E, reason: from kotlin metadata */
    private View mLoadingView;

    /* renamed from: F, reason: from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.d mBlogViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String mBlogUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsWebViewInited;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TouchWebView mWebView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private s7.b mWebViewBuilder;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.biz.pubaccount.h mChromeClient;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RefreshView mRefreshView;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/feedpro/part/detail/QzoneFeedProBlogDetailWebViewPart$b;", "Lcom/tencent/mobileqq/webview/swift/utils/m$a;", "", "a", "Lmqq/util/WeakReference;", "Lcom/qzone/reborn/feedpro/part/detail/QzoneFeedProBlogDetailWebViewPart;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "reference", "<init>", "(Lcom/qzone/reborn/feedpro/part/detail/QzoneFeedProBlogDetailWebViewPart;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements m.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QzoneFeedProBlogDetailWebViewPart> reference;

        public b(QzoneFeedProBlogDetailWebViewPart reference) {
            Intrinsics.checkNotNullParameter(reference, "reference");
            this.reference = new WeakReference<>(reference);
        }

        @Override // com.tencent.mobileqq.webview.swift.utils.m.a
        public void a() {
            QzoneFeedProBlogDetailWebViewPart qzoneFeedProBlogDetailWebViewPart = this.reference.get();
            if (qzoneFeedProBlogDetailWebViewPart != null) {
                qzoneFeedProBlogDetailWebViewPart.P9();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean O9(WebView webView, String url, boolean isMainFrame) {
        boolean startsWith$default;
        if (webView != null && getActivity() != null && !getActivity().isFinishing() && url != null) {
            if (!TextUtils.isEmpty(url)) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "about:blank", false, 2, null);
                if (!(startsWith$default)) {
                    String S9 = S9(url);
                    String k3 = com.tencent.mobileqq.webview.swift.utils.i.k(S9);
                    WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                    if (pluginEngine != null && pluginEngine.S(S9, isMainFrame)) {
                        return true;
                    }
                    if (Intrinsics.areEqual("http", k3) || Intrinsics.areEqual("https", k3) || Intrinsics.areEqual("data", k3) || Intrinsics.areEqual("file", k3)) {
                        return pluginEngine != null && pluginEngine.s(S9, 16L, null);
                    }
                    return true;
                }
            }
            StringBuilder sb5 = new StringBuilder("shouldOverrideUrlLoading fail , url=[");
            sb5.append(url);
            sb5.append("].");
            QZLog.e("QzoneFeedProBlogDetailWebViewPart", 1, sb5);
            return true;
        }
        QZLog.e("QzoneFeedProBlogDetailWebViewPart", 1, "call shouldOverrideUrlLoading after destroy.");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9() {
        QLog.d("QzoneFeedProBlogDetailWebViewPart", 1, "initWebView: start");
        if (!this.mIsWebViewInited) {
            this.mWebView = new TouchWebView(getActivity());
            s7.c cVar = new s7.c(getActivity(), getActivity(), getIntent(), QzoneWebViewPluginManager.getInstance().getRuntime(), true);
            this.mWebViewBuilder = cVar;
            cVar.setWebView(this.mWebView);
            TouchWebView touchWebView = this.mWebView;
            WebSettings settings = touchWebView != null ? touchWebView.getSettings() : null;
            if (settings != null) {
                settings.setMediaPlaybackRequiresUserGesture(false);
            }
            this.mIsWebViewInited = true;
        }
        Q9();
    }

    private final void Q9() {
        new com.tencent.mobileqq.webview.m(this.mWebViewBuilder).a(null, QzoneWebViewPluginManager.getInstance().getRuntime(), null);
        TouchWebView touchWebView = this.mWebView;
        WebViewPluginEngine pluginEngine = touchWebView != null ? touchWebView.getPluginEngine() : null;
        T9();
        if (pluginEngine != null) {
            QLog.d("QzoneFeedProBlogDetailWebViewPart", 1, "loadUrl: start");
            TouchWebView touchWebView2 = this.mWebView;
            if (touchWebView2 != null) {
                touchWebView2.loadUrl(this.mBlogUrl);
            }
            U9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final String S9(String url) {
        boolean startsWith$default;
        boolean startsWith$default2;
        String replace$default;
        String replace$default2;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "https://jsbridge/", false, 2, null);
        if (startsWith$default) {
            replace$default2 = StringsKt__StringsJVMKt.replace$default(url, "https://jsbridge/", "jsbridge://", false, 4, (Object) null);
            return replace$default2;
        }
        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "http://jsbridge/", false, 2, null);
        if (!startsWith$default2) {
            return url;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(url, "http://jsbridge/", "jsbridge://", false, 4, (Object) null);
        return replace$default;
    }

    private final void T9() {
        RefreshView refreshView = this.mRefreshView;
        if (refreshView != null) {
            if (refreshView != null) {
                refreshView.setVisibility(0);
            }
            RefreshView refreshView2 = this.mRefreshView;
            if (refreshView2 != null) {
                refreshView2.setDelayBeforeScrollBack(800L);
            }
            TouchWebView touchWebView = this.mWebView;
            if (touchWebView != null) {
                touchWebView.setOnOverScrollHandler(this.mRefreshView);
            }
            RefreshView refreshView3 = this.mRefreshView;
            if (refreshView3 != null) {
                refreshView3.addView(this.mWebView, 0, new ViewGroup.LayoutParams(-1, -1));
            }
        }
    }

    private final void U9() {
        if (this.mChromeClient == null) {
            this.mChromeClient = new com.tencent.biz.pubaccount.h();
        }
        TouchWebView touchWebView = this.mWebView;
        if (touchWebView != null) {
            touchWebView.setWebChromeClient(this.mChromeClient);
        }
        TouchWebView touchWebView2 = this.mWebView;
        if (touchWebView2 != null) {
            touchWebView2.setWebViewClient(new c(touchWebView2 != null ? touchWebView2.getPluginEngine() : null));
        }
        RefreshView refreshView = this.mRefreshView;
        if (refreshView == null || refreshView == null) {
            return;
        }
        refreshView.setOnKeyListener(new View.OnKeyListener() { // from class: com.qzone.reborn.feedpro.part.detail.j
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                boolean V9;
                V9 = QzoneFeedProBlogDetailWebViewPart.V9(QzoneFeedProBlogDetailWebViewPart.this, view, i3, keyEvent);
                return V9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean V9(QzoneFeedProBlogDetailWebViewPart this$0, View view, int i3, KeyEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 0 && i3 == 4) {
            TouchWebView touchWebView = this$0.mWebView;
            if (touchWebView != null && touchWebView.canGoBack()) {
                TouchWebView touchWebView2 = this$0.mWebView;
                if (touchWebView2 != null) {
                    touchWebView2.goBack();
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void W9(CommonFeed feed) {
        boolean z16;
        CommonCellTitle cellTitle;
        String titleUrl;
        boolean z17;
        CommonUser user;
        String uin;
        String cellId;
        CommonCellCommon cellCommon = feed.getCellCommon();
        boolean z18 = false;
        if (cellCommon != null && (cellId = cellCommon.getCellId()) != null) {
            if (cellId.length() > 0) {
                z16 = true;
                if (z16) {
                    CommonCellUserInfo cellUserInfo = feed.getCellUserInfo();
                    if (cellUserInfo != null && (user = cellUserInfo.getUser()) != null && (uin = user.getUin()) != null) {
                        if (uin.length() > 0) {
                            z17 = true;
                            if (z17) {
                                this.mBlogUrl = M9();
                                QLog.d("QzoneFeedProBlogDetailWebViewPart", 1, "updateBlogUrl: " + this.mBlogUrl);
                            }
                        }
                    }
                    z17 = false;
                    if (z17) {
                    }
                }
                cellTitle = feed.getCellTitle();
                if (cellTitle != null && (titleUrl = cellTitle.getTitleUrl()) != null) {
                    if (titleUrl.length() <= 0) {
                        z18 = true;
                    }
                }
                if (z18) {
                    CommonCellTitle cellTitle2 = feed.getCellTitle();
                    this.mBlogUrl = cellTitle2 != null ? cellTitle2.getTitleUrl() : null;
                }
                QLog.d("QzoneFeedProBlogDetailWebViewPart", 1, "updateBlogUrl: " + this.mBlogUrl);
            }
        }
        z16 = false;
        if (z16) {
        }
        cellTitle = feed.getCellTitle();
        if (cellTitle != null) {
            if (titleUrl.length() <= 0) {
            }
        }
        if (z18) {
        }
        QLog.d("QzoneFeedProBlogDetailWebViewPart", 1, "updateBlogUrl: " + this.mBlogUrl);
    }

    private final Intent getIntent() {
        if (getActivity() != null) {
            return getActivity().getIntent();
        }
        return null;
    }

    private final void initView() {
        View findViewById = getPartRootView().findViewById(R.id.f162770mj3);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.biz.ui.RefreshView");
        this.mRefreshView = (RefreshView) findViewById;
        View findViewById2 = getPartRootView().findViewById(R.id.miz);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type com.tencent.mobileqq.widget.WebViewProgressBar");
        this.mProgressBar = (WebViewProgressBar) findViewById2;
        bx bxVar = new bx();
        this.mProgressBarControl = bxVar;
        WebViewProgressBar webViewProgressBar = this.mProgressBar;
        if (webViewProgressBar != null) {
            webViewProgressBar.setController(bxVar);
        }
        bx bxVar2 = this.mProgressBarControl;
        if (bxVar2 != null) {
            bxVar2.k(this.mProgressBar);
        }
        this.mLoadingView = getPartRootView().findViewById(R.id.kar);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProBlogDetailWebViewPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String action, Object args) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(args, "args");
        if (TextUtils.equals("BLOG_DETAIL_GET_WEBVIEW", action)) {
            return this.mWebView;
        }
        return super.getMessage(action, args);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String stringExtra;
        TouchWebView touchWebView;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 2 || data == null) {
            return;
        }
        if (com.qzone.reborn.configx.g.f53821a.b().w0()) {
            Parcelable parcelableExtra = data.getParcelableExtra("comment_panel_result_bean");
            if (parcelableExtra instanceof QZoneCommentPanelResultBean) {
                stringExtra = ((QZoneCommentPanelResultBean) parcelableExtra).getInputContent();
            } else {
                stringExtra = "";
            }
        } else {
            stringExtra = data.getStringExtra("contentIntentKey");
        }
        if (TextUtils.isEmpty(stringExtra) || (touchWebView = this.mWebView) == null) {
            return;
        }
        Intrinsics.checkNotNull(touchWebView);
        if (touchWebView.getPluginEngine() == null) {
            return;
        }
        int i3 = requestCode & 255;
        TouchWebView touchWebView2 = this.mWebView;
        WebViewPluginEngine pluginEngine = touchWebView2 != null ? touchWebView2.getPluginEngine() : null;
        WebViewPlugin m3 = pluginEngine != null ? pluginEngine.m("Qzone") : null;
        if (m3 != null) {
            m3.onActivityResult(data, (byte) i3, resultCode);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        MutableLiveData<UIStateData<CommonFeed>> N1;
        UIStateData<CommonFeed> value;
        TouchWebView touchWebView = this.mWebView;
        if (touchWebView != null) {
            Intrinsics.checkNotNull(touchWebView);
            if (touchWebView.canGoBack()) {
                TouchWebView touchWebView2 = this.mWebView;
                Intrinsics.checkNotNull(touchWebView2);
                touchWebView2.goBack();
                return true;
            }
        }
        com.qzone.reborn.feedpro.viewmodel.d dVar = this.mBlogViewModel;
        CommonFeed data = (dVar == null || (N1 = dVar.N1()) == null || (value = N1.getValue()) == null) ? null : value.getData();
        if (data != null) {
            QzoneFeedUpdateManager qzoneFeedUpdateManager = new QzoneFeedUpdateManager();
            CommonCellCommon cellCommon = data.getCellCommon();
            qzoneFeedUpdateManager.fetchUpdateFeed(cellCommon != null ? cellCommon.getUnionId() : null);
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        MutableLiveData<UIStateData<CommonFeed>> N1;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        this.mBlogViewModel = (com.qzone.reborn.feedpro.viewmodel.d) getViewModel(com.qzone.reborn.feedpro.viewmodel.d.class);
        initView();
        com.qzone.reborn.feedpro.viewmodel.d dVar = this.mBlogViewModel;
        if (dVar == null || (N1 = dVar.N1()) == null) {
            return;
        }
        Fragment hostFragment = getHostFragment();
        final Function1<UIStateData<CommonFeed>, Unit> function1 = new Function1<UIStateData<CommonFeed>, Unit>() { // from class: com.qzone.reborn.feedpro.part.detail.QzoneFeedProBlogDetailWebViewPart$onPartCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<CommonFeed> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<CommonFeed> uIStateData) {
                CommonFeed data = uIStateData != null ? uIStateData.getData() : null;
                if (data != null) {
                    QzoneFeedProBlogDetailWebViewPart qzoneFeedProBlogDetailWebViewPart = QzoneFeedProBlogDetailWebViewPart.this;
                    qzoneFeedProBlogDetailWebViewPart.W9(data);
                    qzoneFeedProBlogDetailWebViewPart.N9();
                }
            }
        };
        N1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.feedpro.part.detail.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProBlogDetailWebViewPart.R9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        s7.b bVar = this.mWebViewBuilder;
        if (bVar != null && bVar != null) {
            bVar.onDestroy();
        }
        TouchWebView touchWebView = this.mWebView;
        if (touchWebView != null) {
            ViewParent parent = touchWebView != null ? touchWebView.getParent() : null;
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeAllViewsInLayout();
            }
            this.mWebView = null;
            if (com.qzone.reborn.configx.g.f53821a.b().W1()) {
                AuthorizeConfig.y().t0();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        s7.b bVar = this.mWebViewBuilder;
        if (bVar == null || bVar == null) {
            return;
        }
        bVar.onPause();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        s7.b bVar = this.mWebViewBuilder;
        if (bVar == null || bVar == null) {
            return;
        }
        bVar.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9() {
        QLog.d("QzoneFeedProBlogDetailWebViewPart", 1, "handleBlog: start");
        if (this.mIsWebViewInited) {
            return;
        }
        if (!com.tencent.mobileqq.webview.swift.utils.m.e() && !com.qzone.reborn.configx.g.f53821a.b().r0()) {
            com.tencent.mobileqq.webview.swift.utils.m.h(new b(this));
        } else {
            P9();
        }
    }

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u0011\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"com/qzone/reborn/feedpro/part/detail/QzoneFeedProBlogDetailWebViewPart$c", "Lcom/tencent/biz/ui/b;", "Lcom/tencent/smtt/sdk/WebView;", "webView", "Lcom/tencent/smtt/export/external/interfaces/WebResourceRequest;", "webResourceRequest", "", "shouldOverrideUrlLoading", "", "url", "var1", "var2", "", "onPageFinished", "view", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "d", "Z", "isMainFrame", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends com.tencent.biz.ui.b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isMainFrame;

        c(WebViewPluginEngine webViewPluginEngine) {
            super(webViewPluginEngine);
            this.isMainFrame = true;
        }

        @Override // com.tencent.biz.ui.b, com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView var1, String var2) {
            View view;
            super.onPageFinished(var1, var2);
            if (QzoneFeedProBlogDetailWebViewPart.this.mProgressBarControl != null) {
                bx bxVar = QzoneFeedProBlogDetailWebViewPart.this.mProgressBarControl;
                boolean z16 = false;
                if (bxVar != null && bxVar.c() == 2) {
                    z16 = true;
                }
                if (z16) {
                    return;
                }
                bx bxVar2 = QzoneFeedProBlogDetailWebViewPart.this.mProgressBarControl;
                if (bxVar2 != null) {
                    bxVar2.a((byte) 2);
                }
                if (QzoneFeedProBlogDetailWebViewPart.this.mLoadingView == null || (view = QzoneFeedProBlogDetailWebViewPart.this.mLoadingView) == null) {
                    return;
                }
                view.setVisibility(8);
            }
        }

        @Override // com.tencent.biz.ui.b, com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            View view2;
            TouchWebView touchWebView;
            if (QzoneFeedProBlogDetailWebViewPart.this.mWebView != null && (touchWebView = QzoneFeedProBlogDetailWebViewPart.this.mWebView) != null) {
                touchWebView.setOnOverScrollHandler(QzoneFeedProBlogDetailWebViewPart.this.mRefreshView);
            }
            super.onPageStarted(view, url, favicon);
            if (QzoneFeedProBlogDetailWebViewPart.this.mProgressBarControl != null) {
                bx bxVar = QzoneFeedProBlogDetailWebViewPart.this.mProgressBarControl;
                if (bxVar != null && bxVar.c() == 0) {
                    return;
                }
                bx bxVar2 = QzoneFeedProBlogDetailWebViewPart.this.mProgressBarControl;
                if (bxVar2 != null) {
                    bxVar2.a((byte) 0);
                }
                if (QzoneFeedProBlogDetailWebViewPart.this.mLoadingView == null || (view2 = QzoneFeedProBlogDetailWebViewPart.this.mLoadingView) == null) {
                    return;
                }
                view2.setVisibility(8);
            }
        }

        @Override // com.tencent.biz.ui.b, com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            boolean z16 = false;
            if (webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                z16 = true;
            }
            this.isMainFrame = z16;
            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
            this.isMainFrame = true;
            return shouldOverrideUrlLoading;
        }

        @Override // com.tencent.biz.ui.b, com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            try {
                return QzoneFeedProBlogDetailWebViewPart.this.O9(webView, url, this.isMainFrame);
            } catch (Exception e16) {
                QZLog.e("QzoneFeedProBlogDetailWebViewPart", 1, e16, new Object[0]);
                return true;
            }
        }
    }

    private final String M9() {
        String url;
        String url2;
        CommonCellCommon cellCommon;
        String cellId;
        CommonCellUserInfo cellUserInfo;
        CommonUser user;
        String uin;
        MutableLiveData<UIStateData<CommonFeed>> N1;
        UIStateData<CommonFeed> value;
        com.qzone.reborn.feedpro.viewmodel.d dVar = this.mBlogViewModel;
        CommonFeed data = (dVar == null || (N1 = dVar.N1()) == null || (value = N1.getValue()) == null) ? null : value.getData();
        String url3 = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_BLOG_DETAIL, "https://h5.qzone.qq.com/ugc/share?_wv=1&appid=2&res_uin={uin}&cellid={cellid}");
        Intrinsics.checkNotNullExpressionValue(url3, "url");
        url = StringsKt__StringsJVMKt.replace$default(url3, "{uin}", (data == null || (cellUserInfo = data.getCellUserInfo()) == null || (user = cellUserInfo.getUser()) == null || (uin = user.getUin()) == null) ? "" : uin, false, 4, (Object) null);
        Intrinsics.checkNotNullExpressionValue(url, "url");
        url2 = StringsKt__StringsJVMKt.replace$default(url, "{cellid}", (data == null || (cellCommon = data.getCellCommon()) == null || (cellId = cellCommon.getCellId()) == null) ? "" : cellId, false, 4, (Object) null);
        Intrinsics.checkNotNullExpressionValue(url2, "url");
        return url2;
    }
}
