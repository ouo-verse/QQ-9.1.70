package com.tencent.mobileqq.zootopia.ue;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import b94.e;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.lua.ZPlanPortalStoreLuaPlugin;
import com.tencent.mobileqq.zootopia.webview.ZPlanModH5MediaStatusManager;
import com.tencent.mobileqq.zplan.web.impl.ZplanTransparentStyleWebFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeRetainStyle;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeViewInitData;
import com.tencent.sqshow.zootopia.nativeui.data.OrientationMode;
import com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper;
import com.tencent.sqshow.zootopia.nativeui.dialog.views.k;
import com.tencent.sqshow.zootopia.nativeui.view.panel.PortalStoreControllerView;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.zplan.world.model.FirstFrameResult;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t74.u;
import uv4.bd;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u00101\u001a\u00020-\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J$\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0007H\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J \u0010\u001a\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u001a\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020\u0002H\u0016J\b\u0010%\u001a\u00020\u0002H\u0016J\u001e\u0010*\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\b\u0010+\u001a\u00020\u0002H\u0016J\u001a\u0010,\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0016R\u0017\u00101\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0017\u0010@\u001a\u00020;8\u0006\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00103R\u0018\u0010C\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010B\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "Lcom/tencent/mobileqq/zootopia/ue/b;", "", "t", "r", "", "id", "", "needInitMini", "Landroid/widget/FrameLayout;", "p", "o", "", "url", "needFinishFromJs", "needSilentLoad", "u", "sceneParams", "openSource", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreControllerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "controllerView", "f", "Landroid/view/ViewGroup;", "getRootView", ReportConstant.COSTREPORT_PREFIX, "a", "methodName", "Lorg/json/JSONObject;", "params", "g", "i", "Landroid/content/res/Configuration;", "newConfig", "w", "y", DomainData.DOMAIN_NAME, "j", "gender", "", "Luv4/bd;", "list", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, tl.h.F, "Landroidx/fragment/app/FragmentActivity;", "Landroidx/fragment/app/FragmentActivity;", "k", "()Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "b", "Landroid/widget/FrameLayout;", "webContainer", "c", "nativeViewContainer", "Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/k;", "d", "Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/k;", "shoppingCartViewHelper", "Lcom/tencent/mobileqq/zootopia/webview/ZPlanModH5MediaStatusManager;", "e", "Lcom/tencent/mobileqq/zootopia/webview/ZPlanModH5MediaStatusManager;", "l", "()Lcom/tencent/mobileqq/zootopia/webview/ZPlanModH5MediaStatusManager;", "h5MediaStatusManager", "portalStoreContainer", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreControllerView;", "selfControllerView", "sameStyleControllerView", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class UEActivityViewManager implements com.tencent.mobileqq.zootopia.ue.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final FragmentActivity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private FrameLayout webContainer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private FrameLayout nativeViewContainer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private k shoppingCartViewHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ZPlanModH5MediaStatusManager h5MediaStatusManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout portalStoreContainer;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private PortalStoreControllerView selfControllerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private PortalStoreControllerView sameStyleControllerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zootopia/ue/UEActivityViewManager$b", "Lb94/c;", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements b94.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PortalStoreControllerView f329332a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PortalStoreControllerView f329333b;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zootopia/ue/UEActivityViewManager$b$a", "Lkotlin/Function0;", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements Function0<Unit> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ PortalStoreControllerView f329334d;

            a(PortalStoreControllerView portalStoreControllerView) {
                this.f329334d = portalStoreControllerView;
            }

            public void a() {
                this.f329334d.setVisibility(8);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        b(PortalStoreControllerView portalStoreControllerView, PortalStoreControllerView portalStoreControllerView2) {
            this.f329332a = portalStoreControllerView;
            this.f329333b = portalStoreControllerView2;
        }

        @Override // b94.c
        public boolean a() {
            if (!this.f329332a.getMMainPanelIsShow()) {
                return false;
            }
            e.a.b(this.f329332a, true, null, new a(this.f329333b), 2, null);
            return true;
        }
    }

    public UEActivityViewManager(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.h5MediaStatusManager = new ZPlanModH5MediaStatusManager(this);
    }

    private final void f(PortalStoreControllerView controllerView) {
        FrameLayout frameLayout;
        if (this.portalStoreContainer == null) {
            this.portalStoreContainer = new FrameLayout(this.activity);
            FrameLayout frameLayout2 = this.nativeViewContainer;
            if (frameLayout2 != null) {
                frameLayout2.addView(new View(this.activity), new FrameLayout.LayoutParams(-1, -1));
                frameLayout2.addView(this.portalStoreContainer, new FrameLayout.LayoutParams(-1, -1));
            }
        }
        FrameLayout frameLayout3 = this.nativeViewContainer;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(0);
        }
        FrameLayout frameLayout4 = this.portalStoreContainer;
        if (frameLayout4 != null) {
            frameLayout4.removeAllViews();
        }
        if (controllerView == null || (frameLayout = this.portalStoreContainer) == null) {
            return;
        }
        frameLayout.addView(controllerView.getView(), new FrameLayout.LayoutParams(-1, -1));
    }

    private final FrameLayout p(int id5, boolean needInitMini) {
        ViewGroup viewGroup;
        FrameLayout.LayoutParams layoutParams;
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity instanceof ZootopiaUEActivity) {
            viewGroup = ((ZootopiaUEActivity) fragmentActivity).getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String();
        } else {
            View decorView = fragmentActivity.getWindow().getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            viewGroup = (ViewGroup) decorView;
        }
        if (viewGroup == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.activity);
        if (needInitMini) {
            layoutParams = new FrameLayout.LayoutParams(1, 1);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        frameLayout.setLayoutParams(layoutParams);
        if (!(this.activity instanceof ZootopiaUEActivity)) {
            frameLayout.setElevation(10.0f);
        }
        viewGroup.addView(frameLayout);
        frameLayout.setId(id5);
        frameLayout.setVisibility(8);
        return frameLayout;
    }

    private final void u(String url, boolean needFinishFromJs, boolean needSilentLoad) {
        if (this.activity.getSupportFragmentManager().findFragmentByTag("UE_WEBVIEW_CONTAINER_VIEW") != null) {
            QLog.d("UEActivityViewManager", 1, "webViewFragment added~ " + url);
            return;
        }
        QLog.d("UEActivityViewManager", 1, "initWebView WebView: " + url);
        FrameLayout frameLayout = this.webContainer;
        if (frameLayout != null) {
            ZplanTransparentStyleWebFragment a16 = ZplanTransparentStyleWebFragment.INSTANCE.a(url, needFinishFromJs, needSilentLoad);
            a16.Eh(frameLayout);
            FragmentTransaction beginTransaction = this.activity.getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "activity.supportFragmentManager.beginTransaction()");
            beginTransaction.add(frameLayout.getId(), a16, "UE_WEBVIEW_CONTAINER_VIEW");
            beginTransaction.commitAllowingStateLoss();
        }
    }

    private final PortalStoreControllerView z(String sceneParams, String openSource) {
        Context context;
        ViewGroup rootView = getRootView();
        if (rootView == null || (context = rootView.getContext()) == null) {
            return null;
        }
        PortalStoreControllerView portalStoreControllerView = new PortalStoreControllerView(context, null, 0, 6, null);
        com.tencent.sqshow.zootopia.nativeui.data.h hVar = new com.tencent.sqshow.zootopia.nativeui.data.h();
        hVar.k(false);
        hVar.i(false);
        hVar.j(false);
        hVar.g(false);
        hVar.h(false);
        com.tencent.sqshow.zootopia.nativeui.data.f fVar = new com.tencent.sqshow.zootopia.nativeui.data.f();
        fVar.d(AvatarNativeRetainStyle.DIALOG);
        fVar.c(OrientationMode.UNSPECIFIED);
        com.tencent.sqshow.zootopia.nativeui.data.g gVar = new com.tencent.sqshow.zootopia.nativeui.data.g();
        gVar.c("2");
        gVar.d(openSource);
        FragmentActivity fragmentActivity = this.activity;
        AvatarNativeViewInitData avatarNativeViewInitData = new AvatarNativeViewInitData(fragmentActivity, fragmentActivity, null, null, 0, null, sceneParams, null, false, 0, null, false, dj3.a.f394006d, null, null, null, hVar, fVar, gVar, 61372, null);
        avatarNativeViewInitData.A(2);
        avatarNativeViewInitData.C(ZootopiaSource.INSTANCE.a(Source.XiaoWoDress));
        avatarNativeViewInitData.t(new b(portalStoreControllerView, portalStoreControllerView));
        portalStoreControllerView.Cf(avatarNativeViewInitData);
        portalStoreControllerView.onFirstFrame(new FirstFrameResult(7, "{}"));
        portalStoreControllerView.serviceConnected(true);
        return portalStoreControllerView;
    }

    @Override // com.tencent.mobileqq.zootopia.ue.b
    public void a(String url, boolean needFinishFromJs, boolean needSilentLoad) {
        Intrinsics.checkNotNullParameter(url, "url");
        QLog.i("UEActivityViewManager", 1, "open WebView " + url);
        FrameLayout frameLayout = this.webContainer;
        if (frameLayout != null) {
            Fragment findFragmentByTag = this.activity.getSupportFragmentManager().findFragmentByTag("UE_WEBVIEW_CONTAINER_VIEW");
            if (findFragmentByTag != null) {
                ZplanTransparentStyleWebFragment zplanTransparentStyleWebFragment = (ZplanTransparentStyleWebFragment) findFragmentByTag;
                CustomWebView webView = zplanTransparentStyleWebFragment.getWebView();
                String url2 = webView != null ? webView.getUrl() : null;
                CustomWebView webView2 = zplanTransparentStyleWebFragment.getWebView();
                boolean z16 = webView2 != null && webView2.getVisibility() == 0;
                if (com.tencent.mobileqq.zplan.video.api.bean.a.f335855a.c(url2, url) || !z16) {
                    zplanTransparentStyleWebFragment.Dh(url, needFinishFromJs);
                }
                QLog.d("UEActivityViewManager", 1, "loadUrl had exist " + Intrinsics.areEqual(url2, url));
            } else {
                u(url, needFinishFromJs, needSilentLoad);
            }
            frameLayout.setVisibility(0);
        }
    }

    public void g(String methodName, JSONObject params) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Fragment findFragmentByTag = this.activity.getSupportFragmentManager().findFragmentByTag("UE_WEBVIEW_CONTAINER_VIEW");
        ZplanTransparentStyleWebFragment zplanTransparentStyleWebFragment = findFragmentByTag instanceof ZplanTransparentStyleWebFragment ? (ZplanTransparentStyleWebFragment) findFragmentByTag : null;
        if (zplanTransparentStyleWebFragment != null) {
            zplanTransparentStyleWebFragment.yh(methodName, params);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.ue.b
    public ViewGroup getRootView() {
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity instanceof ZootopiaUEActivity) {
            return ((ZootopiaUEActivity) fragmentActivity).getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String();
        }
        View decorView = fragmentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) decorView;
    }

    public PortalStoreControllerView h(String sceneParams, String openSource) {
        PortalStoreControllerView portalStoreControllerView;
        Intrinsics.checkNotNullParameter(sceneParams, "sceneParams");
        Intrinsics.checkNotNullParameter(openSource, "openSource");
        if (sceneParams.length() > 0) {
            PortalStoreControllerView portalStoreControllerView2 = this.sameStyleControllerView;
            if (portalStoreControllerView2 != null) {
                portalStoreControllerView2.destroy();
            }
            portalStoreControllerView = z(sceneParams, openSource);
            this.sameStyleControllerView = portalStoreControllerView;
        } else {
            if (this.selfControllerView == null) {
                this.selfControllerView = z("", openSource);
            }
            portalStoreControllerView = this.selfControllerView;
        }
        f(portalStoreControllerView);
        return portalStoreControllerView;
    }

    public void i() {
        this.h5MediaStatusManager.b();
        j();
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityViewManager$destoryView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
            
                if (r3 != false) goto L16;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                PortalStoreControllerView portalStoreControllerView;
                PortalStoreControllerView portalStoreControllerView2;
                PortalStoreControllerView portalStoreControllerView3;
                PortalStoreControllerView portalStoreControllerView4;
                try {
                    portalStoreControllerView = UEActivityViewManager.this.selfControllerView;
                    boolean z16 = false;
                    if (!(portalStoreControllerView != null && portalStoreControllerView.getMMainPanelIsShow())) {
                        portalStoreControllerView4 = UEActivityViewManager.this.sameStyleControllerView;
                        if (portalStoreControllerView4 != null && portalStoreControllerView4.getMMainPanelIsShow()) {
                            z16 = true;
                        }
                    }
                    ZPlanPortalStoreLuaPlugin.INSTANCE.d();
                    portalStoreControllerView2 = UEActivityViewManager.this.selfControllerView;
                    if (portalStoreControllerView2 != null) {
                        portalStoreControllerView2.destroy();
                    }
                    portalStoreControllerView3 = UEActivityViewManager.this.sameStyleControllerView;
                    if (portalStoreControllerView3 != null) {
                        portalStoreControllerView3.destroy();
                    }
                    UEActivityViewManager.this.selfControllerView = null;
                    UEActivityViewManager.this.sameStyleControllerView = null;
                } catch (Throwable th5) {
                    QLog.e("UEActivityViewManager", 1, "destroy controllerView", th5);
                    UEActivityViewManager.this.selfControllerView = null;
                    UEActivityViewManager.this.sameStyleControllerView = null;
                }
            }
        });
    }

    public void j() {
        Fragment findFragmentByTag = this.activity.getSupportFragmentManager().findFragmentByTag("UE_WEBVIEW_CONTAINER_VIEW");
        if (findFragmentByTag != null) {
            try {
                QLog.d("UEActivityViewManager", 1, "destroyWebView");
                FragmentTransaction beginTransaction = this.activity.getSupportFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "activity.supportFragmentManager.beginTransaction()");
                beginTransaction.remove(findFragmentByTag);
                beginTransaction.commitNowAllowingStateLoss();
            } catch (Exception e16) {
                QLog.e("UEActivityViewManager", 1, "error happy " + e16);
            }
        }
    }

    /* renamed from: k, reason: from getter */
    public final FragmentActivity getActivity() {
        return this.activity;
    }

    /* renamed from: l, reason: from getter */
    public final ZPlanModH5MediaStatusManager getH5MediaStatusManager() {
        return this.h5MediaStatusManager;
    }

    public void m() {
        k kVar = this.shoppingCartViewHelper;
        if (kVar != null) {
            kVar.f();
        }
    }

    public void s() {
        t();
        r();
        o();
    }

    public void w(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        k kVar = this.shoppingCartViewHelper;
        if (kVar != null) {
            kVar.k(newConfig.orientation == 2);
        }
        PortalStoreControllerView portalStoreControllerView = this.selfControllerView;
        if (portalStoreControllerView != null) {
            portalStoreControllerView.onOrientationChanged(newConfig.orientation);
        }
        PortalStoreControllerView portalStoreControllerView2 = this.sameStyleControllerView;
        if (portalStoreControllerView2 != null) {
            portalStoreControllerView2.onOrientationChanged(newConfig.orientation);
        }
        if (ZPlanPortalStoreLuaPlugin.INSTANCE.a()) {
            ((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).hidePayPanel();
            AvatarCommonOperateHelper.f371049a.m();
        }
    }

    public void x(int gender, List<bd> list) {
        Map<String, Object> linkedHashMap;
        Intrinsics.checkNotNullParameter(list, "list");
        QLog.d("UEActivityViewManager", 1, "nativeContainerView added:  " + list);
        FrameLayout frameLayout = this.nativeViewContainer;
        if (frameLayout != null) {
            if (this.shoppingCartViewHelper == null) {
                FragmentActivity fragmentActivity = this.activity;
                if (fragmentActivity instanceof ZootopiaUEActivity) {
                    linkedHashMap = ((ZootopiaUEActivity) fragmentActivity).i3();
                } else {
                    linkedHashMap = new LinkedHashMap<>();
                }
                this.shoppingCartViewHelper = new k(frameLayout, this.activity, linkedHashMap);
            }
            k kVar = this.shoppingCartViewHelper;
            if (kVar != null) {
                kVar.g(u.INSTANCE.f(this.activity));
                kVar.j(gender, list);
            }
            frameLayout.setVisibility(0);
        }
    }

    public void y(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        QLog.d("UEActivityViewManager", 1, "preload WebView: " + url);
        v(this, url, false, false, 6, null);
    }

    public void n() {
        QLog.d("UEActivityViewManager", 1, "hide webview");
        FrameLayout frameLayout = this.webContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    private final void t() {
        this.webContainer = p(R.id.r_0, true);
    }

    static /* synthetic */ FrameLayout q(UEActivityViewManager uEActivityViewManager, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        return uEActivityViewManager.p(i3, z16);
    }

    private final void r() {
        this.nativeViewContainer = q(this, R.id.r6v, false, 2, null);
    }

    static /* synthetic */ void v(UEActivityViewManager uEActivityViewManager, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        uEActivityViewManager.u(str, z16, z17);
    }

    private final void o() {
    }
}
