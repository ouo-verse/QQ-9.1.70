package com.tencent.mobileqq.springhb.main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.api.ISpringLoongCardApi;
import com.tencent.mobileqq.springhb.main.BrowserViewModel;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.smtt.sdk.WebView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/springhb/main/SpringHbTranslucentWebViewFragment;", "Lcom/tencent/mobileqq/activity/QQTranslucentBrowserActivity$QQTranslucentBrowserFragment;", "", "isVisible", "", "Bh", "(Ljava/lang/Boolean;)V", "", "subModule", "url", "Ah", "onBackEvent", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "Lcom/tencent/mobileqq/webview/swift/utils/t;", "getWebViewKernelCallBack", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;", "mBrowserViewModel", "D", "Landroid/view/View;", "mLoadingView", "E", "Z", "mHasShowNetDialog", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "wh", "()Z", "canReport", "<init>", "()V", "G", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SpringHbTranslucentWebViewFragment extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private BrowserViewModel mBrowserViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private View mLoadingView;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mHasShowNetDialog;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy canReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/SpringHbTranslucentWebViewFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.main.SpringHbTranslucentWebViewFragment$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J.\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\u0013\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/springhb/main/SpringHbTranslucentWebViewFragment$b", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "onInitUIContent", "onFinalState", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "onPageFinished", "", "errorCode", "description", "failingUrl", "onReceivedError", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends com.tencent.mobileqq.webview.swift.proxy.a {
        static IPatchRedirector $redirector_;

        b(ak akVar) {
            super(akVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringHbTranslucentWebViewFragment.this, (Object) akVar);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(@Nullable Bundle extraData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) extraData);
            } else {
                SpringHbTranslucentWebViewFragment.this.onFinalState(extraData, this.webViewKernelCallBack);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(@Nullable Bundle extraData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) extraData);
            } else {
                SpringHbTranslucentWebViewFragment.this.onInitUIContent(extraData, this.webViewKernelCallBack);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(@Nullable WebView view, @Nullable String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) url);
                return;
            }
            super.onPageFinished(view, url);
            BrowserViewModel browserViewModel = SpringHbTranslucentWebViewFragment.this.mBrowserViewModel;
            BrowserViewModel browserViewModel2 = null;
            if (browserViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBrowserViewModel");
                browserViewModel = null;
            }
            if (Intrinsics.areEqual(browserViewModel.M1(), url)) {
                QLog.d("SpringHbTranslucentWebViewFragment", 1, "onPageFinished url: " + url);
                BrowserViewModel browserViewModel3 = SpringHbTranslucentWebViewFragment.this.mBrowserViewModel;
                if (browserViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBrowserViewModel");
                } else {
                    browserViewModel2 = browserViewModel3;
                }
                browserViewModel2.Z1();
                SpringHbTranslucentWebViewFragment.this.Ah("pagefinished", url);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageStarted(@Nullable WebView view, @Nullable String url, @Nullable Bitmap favicon) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, view, url, favicon);
                return;
            }
            super.onPageStarted(view, url, favicon);
            if (url != null) {
                SpringHbTranslucentWebViewFragment springHbTranslucentWebViewFragment = SpringHbTranslucentWebViewFragment.this;
                QLog.d("SpringHbTranslucentWebViewFragment", 1, "onPageStarted url: " + url);
                BrowserViewModel browserViewModel = springHbTranslucentWebViewFragment.mBrowserViewModel;
                if (browserViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBrowserViewModel");
                    browserViewModel = null;
                }
                browserViewModel.a2(url);
                springHbTranslucentWebViewFragment.Ah("pagestarted", url);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onReceivedError(@Nullable WebView view, int errorCode, @Nullable String description, @Nullable String failingUrl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, view, Integer.valueOf(errorCode), description, failingUrl);
                return;
            }
            super.onReceivedError(view, errorCode, description, failingUrl);
            QLog.e("SpringHbTranslucentWebViewFragment", 1, "onReceivedError code: " + errorCode + " des: " + description + " url: " + failingUrl);
            BrowserViewModel browserViewModel = SpringHbTranslucentWebViewFragment.this.mBrowserViewModel;
            BrowserViewModel browserViewModel2 = null;
            if (browserViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBrowserViewModel");
                browserViewModel = null;
            }
            if (Intrinsics.areEqual(browserViewModel.M1(), failingUrl)) {
                BrowserViewModel browserViewModel3 = SpringHbTranslucentWebViewFragment.this.mBrowserViewModel;
                if (browserViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBrowserViewModel");
                } else {
                    browserViewModel2 = browserViewModel3;
                }
                browserViewModel2.g2(true);
                SpringHbTranslucentWebViewFragment.this.Ah("receivederror", failingUrl);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60939);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SpringHbTranslucentWebViewFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(SpringHbTranslucentWebViewFragment$canReport$2.INSTANCE);
            this.canReport = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ah(String subModule, String url) {
        AppRuntime peekAppRuntime;
        ISpringHbReportApi iSpringHbReportApi;
        try {
            if (!wh()) {
                return;
            }
            String valueOf = String.valueOf(hashCode());
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("buss_id", "webview");
                jSONObject.put("module_id", "hbmainpage");
                jSONObject.put("submodule_id", subModule);
                jSONObject.put(WadlReportBuilder.TableElem.OPER_ID, "exp");
                jSONObject.put(TVKDataBinder.KEY_REPORT_TYPE, 1);
                JSONObject jSONObject2 = new JSONObject();
                if (url == null) {
                    url = "";
                }
                jSONObject2.put("ext1", url);
                jSONObject2.put("ext2", valueOf);
                Unit unit = Unit.INSTANCE;
                jSONObject.put("params", jSONObject2);
                iSpringHbReportApi.webReport(jSONObject, 1);
            }
        } catch (Throwable th5) {
            QLog.e("SpringHbTranslucentWebViewFragment", 1, "reportInfo e:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh(Boolean isVisible) {
        if (Intrinsics.areEqual(isVisible, Boolean.TRUE)) {
            this.contentView.setBackgroundColor(-1);
            this.contentView.setVisibility(0);
        } else {
            this.contentView.setVisibility(4);
        }
        QLog.i("SpringHbTranslucentWebViewFragment", 1, "setWebViewVisible visible = " + isVisible);
    }

    private final boolean wh() {
        return ((Boolean) this.canReport.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @NotNull
    public com.tencent.mobileqq.webview.swift.utils.t getWebViewKernelCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.webview.swift.utils.t) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new b(this.webViewSurface);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        MobileQQ.sMobileQQ.sendBroadcast(new Intent("action_spring_close_tool_loading"));
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        Intent intent = this.intent;
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        ViewModel viewModel = new ViewModelProvider(this, new BrowserViewModel.b(intent)).get(BrowserViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026serViewModel::class.java)");
        BrowserViewModel browserViewModel = (BrowserViewModel) viewModel;
        getLifecycle().addObserver(browserViewModel);
        this.mBrowserViewModel = browserViewModel;
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String str;
        View view;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            view = (View) iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
            FragmentActivity activity = getActivity();
            View view2 = null;
            if (activity != null && (intent = activity.getIntent()) != null) {
                str = intent.getStringExtra("url");
            } else {
                str = null;
            }
            Ah("createview", str);
            Intrinsics.checkNotNull(onCreateView);
            Context context = onCreateView.getContext();
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            View loadingView = ((ISpringLoongCardApi) QRoute.api(ISpringLoongCardApi.class)).getLoadingView(context);
            Intrinsics.checkNotNullExpressionValue(loadingView, "api(ISpringLoongCardApi:\u2026).getLoadingView(context)");
            this.mLoadingView = loadingView;
            if (loadingView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
                loadingView = null;
            }
            loadingView.setVisibility(8);
            frameLayout.addView(onCreateView);
            View view3 = this.mLoadingView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
            } else {
                view2 = view3;
            }
            frameLayout.addView(view2, new ViewGroup.LayoutParams(-1, -1));
            view = frameLayout;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        Lifecycle lifecycle = getLifecycle();
        BrowserViewModel browserViewModel = this.mBrowserViewModel;
        if (browserViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrowserViewModel");
            browserViewModel = null;
        }
        lifecycle.removeObserver(browserViewModel);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        if (!NetworkUtil.isNetworkAvailable() && !this.mHasShowNetDialog) {
            DialogUtil.createCustomDialog(getContext(), 230, (String) null, "\u7f51\u7edc\u65e0\u6cd5\u8fde\u63a5", (String) null, "\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.springhb.main.r
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    SpringHbTranslucentWebViewFragment.xh(dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null).show();
            this.mHasShowNetDialog = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        BrowserViewModel browserViewModel = this.mBrowserViewModel;
        BrowserViewModel browserViewModel2 = null;
        if (browserViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrowserViewModel");
            browserViewModel = null;
        }
        LiveData<Boolean> O1 = browserViewModel.O1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.springhb.main.SpringHbTranslucentWebViewFragment$onViewCreated$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SpringHbTranslucentWebViewFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean visible) {
                View view2;
                Intent intent;
                Intent intent2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) visible);
                    return;
                }
                QLog.d("SpringHbTranslucentWebViewFragment", 1, "Observer: showLoadingView = " + visible);
                view2 = SpringHbTranslucentWebViewFragment.this.mLoadingView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
                    view2 = null;
                }
                Intrinsics.checkNotNullExpressionValue(visible, "visible");
                view2.setVisibility(visible.booleanValue() ? 0 : 8);
                if (visible.booleanValue()) {
                    return;
                }
                FragmentActivity activity = SpringHbTranslucentWebViewFragment.this.getActivity();
                if (activity != null && (intent2 = activity.getIntent()) != null) {
                    intent2.putExtra("spring_need_show_loading", false);
                }
                FragmentActivity activity2 = SpringHbTranslucentWebViewFragment.this.getActivity();
                if (activity2 == null || (intent = activity2.getIntent()) == null) {
                    return;
                }
                intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
            }
        };
        O1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.springhb.main.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SpringHbTranslucentWebViewFragment.yh(Function1.this, obj);
            }
        });
        BrowserViewModel browserViewModel3 = this.mBrowserViewModel;
        if (browserViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrowserViewModel");
        } else {
            browserViewModel2 = browserViewModel3;
        }
        LiveData<Boolean> S1 = browserViewModel2.S1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.springhb.main.SpringHbTranslucentWebViewFragment$onViewCreated$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SpringHbTranslucentWebViewFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                QLog.d("SpringHbTranslucentWebViewFragment", 1, "Observer: showWebView = " + bool);
                SpringHbTranslucentWebViewFragment.this.Bh(bool);
            }
        };
        S1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.springhb.main.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SpringHbTranslucentWebViewFragment.zh(Function1.this, obj);
            }
        });
    }
}
