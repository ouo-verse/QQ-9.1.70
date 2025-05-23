package com.tencent.mobileqq.qqecommerce.biz.kuikly.container;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 Z2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001[B\u0007\u00a2\u0006\u0004\bX\u0010YJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\"\u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\b\u0010(\u001a\u00020\u0006H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J\"\u0010/\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001c2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020-H\u0016J\b\u00100\u001a\u00020\u001cH\u0016J\b\u00101\u001a\u00020\u0006H\u0016J\u000e\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u000202J\u0010\u00107\u001a\u00020\u00062\b\u00106\u001a\u0004\u0018\u000105J\b\u00108\u001a\u00020\u000eH\u0016J\u0010\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u000209H\u0016J\n\u0010=\u001a\u0004\u0018\u00010<H\u0016J\n\u0010?\u001a\u0004\u0018\u00010>H\u0016J\b\u0010@\u001a\u00020\u001cH\u0016J\b\u0010A\u001a\u00020\u0006H\u0016R\u0018\u0010D\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\"\u0010O\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010F\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001d\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020T0S8F\u00a2\u0006\u0006\u001a\u0004\bU\u0010V\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/f;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/h;", "Lcom/tencent/mobileqq/pad/f;", "", "xh", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "rh", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/g;", "qh", "th", "yh", "", "getBusinessDescription", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "needImmersive", "onBackEvent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "isAllowLandscape", "showErrorView", "hideErrorView", "showLoadingView", "hideLoadingView", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "isWrapContent", "onPostThemeChanged", "", "width", "vh", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;", "newKuiklyView", "uh", "c2", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/content/Context;", "Q3", "Landroid/app/Activity;", "eh", "qOnBackPressed", "qOnNewIntent", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/g;", "pageController", "D", "Z", "isAsyncLoad", "E", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "topGestureLayout", UserInfo.SEX_FEMALE, "Ljava/lang/Float;", "enableFlingGestureWidth", "G", "isEmbedScene", "()Z", "wh", "(Z)V", "", "", "sh", "()Ljava/util/Map;", ISchemeApi.KEY_PAGE_DATA, "<init>", "()V", "H", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyFragment extends QPublicBaseFragment implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.f, h, com.tencent.mobileqq.pad.f {

    /* renamed from: C, reason: from kotlin metadata */
    private g pageController;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isAsyncLoad;

    /* renamed from: E, reason: from kotlin metadata */
    private TopGestureLayout topGestureLayout;

    /* renamed from: F, reason: from kotlin metadata */
    private Float enableFlingGestureWidth;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isEmbedScene;

    private final g qh() {
        Bundle bundle;
        Bundle arguments = getArguments();
        String string = (arguments == null || (bundle = arguments.getBundle("launchKuiklyParams")) == null) ? null : bundle.getString("kr_async_loader_id", "");
        String str = string != null ? string : "";
        if (str.length() == 0) {
            return th();
        }
        g b16 = g.INSTANCE.b(str);
        if (b16 == null) {
            return th();
        }
        b16.K(this);
        this.pageController = b16;
        this.isAsyncLoad = true;
        return b16;
    }

    private final TopGestureLayout rh() {
        Window window;
        View decorView;
        TopGestureLayout topGestureLayout = this.topGestureLayout;
        if (topGestureLayout != null) {
            return topGestureLayout;
        }
        Activity eh5 = eh();
        if (eh5 != null && (window = eh5.getWindow()) != null && (decorView = window.getDecorView()) != null && (decorView instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                boolean z16 = childAt instanceof DragFrameLayout;
                if (z16) {
                    DragFrameLayout dragFrameLayout = z16 ? (DragFrameLayout) childAt : null;
                    childAt = dragFrameLayout != null ? dragFrameLayout.getChildAt(0) : null;
                }
                if (childAt instanceof TopGestureLayout) {
                    TopGestureLayout topGestureLayout2 = (TopGestureLayout) childAt;
                    this.topGestureLayout = topGestureLayout2;
                    return topGestureLayout2;
                }
            }
        }
        return null;
    }

    private final g th() {
        return new g(getArguments(), this.isEmbedScene, this, null, 8, null);
    }

    private final void xh() {
        TopGestureLayout rh5 = rh();
        if (rh5 != null) {
            rh5.setInterceptTouchEventListener(new b());
        }
    }

    private final void yh() {
        Bundle bundle;
        Bundle arguments = getArguments();
        if (arguments == null || (bundle = arguments.getBundle("launchKuiklyParams")) == null || !KuiklyLaunchParams.INSTANCE.h(bundle)) {
            return;
        }
        WeakReference<SplashActivity> weakReference = SplashActivity.sWeakInstance;
        SplashActivity splashActivity = weakReference != null ? weakReference.get() : null;
        if (splashActivity == null) {
            QLog.i("QQKuiklyFragment", 1, "splash activity is null.");
            return;
        }
        com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
        int h16 = bVar.h(splashActivity);
        if (h16 > 0) {
            FragmentActivity activity = getActivity();
            bVar.l(activity != null ? activity.getWindow() : null);
            bundle.putInt(KuiklyLaunchParams.PARAM_BOTTOM_NAV_BAR_HEIGHT, h16);
            QLog.i("QQKuiklyFragment", 1, "nav immersive bottom: " + h16);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.container.h
    public Context Q3() {
        return getContext();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.f
    public String c2() {
        String h16;
        g gVar = this.pageController;
        return (gVar == null || (h16 = gVar.h()) == null) ? "{}" : h16;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.container.h
    public Activity eh() {
        return getActivity();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public String getBusinessDescription() {
        g gVar = this.pageController;
        return "QQKuiklyFragment_" + (gVar != null ? gVar.getPagerName() : null);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.q();
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.r();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean isAllowLandscape() {
        Bundle bundle;
        Bundle arguments = getArguments();
        if (arguments == null || (bundle = arguments.getBundle("launchKuiklyParams")) == null) {
            return false;
        }
        return bundle.containsKey("autorotate");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.v(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        g gVar = this.pageController;
        boolean z16 = false;
        if (gVar != null && gVar.w()) {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        QLog.d("QQKuiklyFragment", 1, "onConfigurationChanged");
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.J();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        yh();
        g qh5 = qh();
        this.pageController = qh5;
        if (!this.isAsyncLoad && qh5 != null) {
            qh5.x(savedInstanceState);
        }
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        g gVar = this.pageController;
        if (gVar == null) {
            return null;
        }
        if (this.isAsyncLoad) {
            QLog.i("QQKuiklyFragment", 1, "isAsyncLoad, " + hashCode());
            gVar.G(this);
            gVar.I();
            return gVar.getRootContainer();
        }
        return g.z(gVar, this, savedInstanceState, null, 4, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.A();
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, ErrorReason errorReason, KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        QLog.d("QQKuiklyFragment", 1, "onPageLoadComplete, isSucceed:" + isSucceed);
        g gVar = this.pageController;
        if (gVar != null) {
            g.C(gVar, isSucceed, errorReason, executeMode, false, 8, null);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.D();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.E();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.F();
        }
        xh();
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        g gVar = this.pageController;
        return gVar != null && gVar.w();
    }

    public final Map<String, Object> sh() {
        Map<String, Object> emptyMap;
        Map<String, Object> k3;
        g gVar = this.pageController;
        if (gVar != null && (k3 = gVar.k()) != null) {
            return k3;
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.L(true);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.O();
        }
    }

    public final void uh(QQKuiklyRenderView newKuiklyView) {
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.H(newKuiklyView);
        }
    }

    public final void vh(float width) {
        this.enableFlingGestureWidth = Float.valueOf(width);
    }

    public final void wh(boolean z16) {
        this.isEmbedScene = z16;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyFragment$b", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout$InterceptTouchEventListener;", "Landroid/view/MotionEvent;", "ev", "", "OnDispatchTouchEvent", "event", "", "OnInterceptTouchEvent", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements TopGestureLayout.InterceptTouchEventListener {
        b() {
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener
        public boolean OnInterceptTouchEvent(MotionEvent event) {
            Float f16 = QQKuiklyFragment.this.enableFlingGestureWidth;
            if (f16 == null || f16.floatValue() < 0.0f) {
                return false;
            }
            return !(event != null && event.getAction() == 0) || event.getX() <= f16.floatValue();
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener
        public void OnDispatchTouchEvent(MotionEvent ev5) {
        }
    }
}
