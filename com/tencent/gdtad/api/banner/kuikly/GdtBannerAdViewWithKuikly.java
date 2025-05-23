package com.tencent.gdtad.api.banner.kuikly;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.api.banner.GdtBannerParams;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.qphone.base.util.QLog;
import i01.b;
import i01.c;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00012\u0018\u0000 :2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002;<B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\"\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u000e\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006="}, d2 = {"Lcom/tencent/gdtad/api/banner/kuikly/GdtBannerAdViewWithKuikly;", "Landroid/widget/FrameLayout;", "Lcom/tencent/gdtad/api/banner/GdtBannerView;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Li01/c;", "", "width", "height", "", "g", "", "d", "i", "j", "Landroid/view/View;", "getView", "Landroid/content/Context;", "context", "pause", "resume", "destroy", "Lcom/tencent/ad/tangram/statistics/AdAntiSpamForClick;", "getAntiSpamForClick", "getOptionsView", "setSize", "", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "Lcom/tencent/gdtad/api/banner/kuikly/GdtBannerAdViewWithKuikly$a;", "adStateListener", "setAdCloseListener", "Landroid/widget/FrameLayout;", "mContainer", "Lcom/tencent/gdtad/aditem/GdtHandler$Params;", "e", "Lcom/tencent/gdtad/aditem/GdtHandler$Params;", "mAdParams", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "f", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "mKuiklyRenderView", h.F, "Ljava/lang/String;", "mAdTraceId", "Z", "mHasRegisterBroadcastReceiver", "com/tencent/gdtad/api/banner/kuikly/GdtBannerAdViewWithKuikly$mKuiklyReceiver$1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/gdtad/api/banner/kuikly/GdtBannerAdViewWithKuikly$mKuiklyReceiver$1;", "mKuiklyReceiver", "Lcom/tencent/gdtad/api/banner/GdtBannerParams;", "gdtBannerParams", "<init>", "(Landroid/content/Context;Lcom/tencent/gdtad/api/banner/GdtBannerParams;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GdtBannerAdViewWithKuikly extends FrameLayout implements GdtBannerView, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h, c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtHandler.Params mAdParams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g mKuiklyRenderView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mAdTraceId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mHasRegisterBroadcastReceiver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GdtBannerAdViewWithKuikly$mKuiklyReceiver$1 mKuiklyReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/gdtad/api/banner/kuikly/GdtBannerAdViewWithKuikly$a;", "", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public interface a {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.tencent.gdtad.api.banner.kuikly.GdtBannerAdViewWithKuikly$mKuiklyReceiver$1] */
    public GdtBannerAdViewWithKuikly(@NotNull Context context, @NotNull GdtBannerParams gdtBannerParams) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtBannerParams, "gdtBannerParams");
        this.mAdTraceId = "";
        this.mKuiklyReceiver = new BroadcastReceiver() { // from class: com.tencent.gdtad.api.banner.kuikly.GdtBannerAdViewWithKuikly$mKuiklyReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context2, @NotNull Intent intent) {
                String str;
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String a16 = l.a(intent);
                String optString = l.b(intent).optString("ad_trace_id");
                QLog.d("GdtBannerAdViewWithKuikly", 2, "onReceive:", a16, ", traceId:", optString);
                if (TextUtils.equals(a16, "event_close_ad")) {
                    str = GdtBannerAdViewWithKuikly.this.mAdTraceId;
                    if (TextUtils.equals(optString, str)) {
                        QLog.d("GdtBannerAdViewWithKuikly", 1, "onReceive hide ad");
                        GdtBannerAdViewWithKuikly.a(GdtBannerAdViewWithKuikly.this);
                        GdtBannerAdViewWithKuikly.this.destroy(context2);
                    }
                }
            }
        };
        this.mAdParams = gdtBannerParams.clickParams;
        g(gdtBannerParams.width, gdtBannerParams.height);
    }

    public static final /* synthetic */ a a(GdtBannerAdViewWithKuikly gdtBannerAdViewWithKuikly) {
        gdtBannerAdViewWithKuikly.getClass();
        return null;
    }

    private final String d() {
        String str;
        GdtAd gdtAd;
        GdtHandler.Params params = this.mAdParams;
        if (params != null && (gdtAd = params.f108486ad) != null) {
            str = gdtAd.toString();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void g(int width, int height) {
        ViewGroup.LayoutParams layoutParams;
        String str;
        GdtAd gdtAd;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gx9, (ViewGroup) this, true);
        if (inflate == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.xo_);
        this.mContainer = frameLayout;
        if (frameLayout != null) {
            layoutParams = frameLayout.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.width = width;
        }
        if (layoutParams != null) {
            layoutParams.height = height;
        }
        HashMap hashMap = new HashMap();
        GdtHandler.Params params = this.mAdParams;
        if (params != null && (gdtAd = params.f108486ad) != null) {
            str = gdtAd.getTraceId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.mAdTraceId = str;
        hashMap.put("bundle_name", "mini_game_ad");
        hashMap.put(QAdVrReport.ElementID.AD_INFO, d());
        IQQKuiklyFactory iQQKuiklyFactory = (IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        g createKuiklyRenderView = iQQKuiklyFactory.createKuiklyRenderView(context, this);
        addView((View) createKuiklyRenderView, new FrameLayout.LayoutParams(-1, -1));
        createKuiklyRenderView.b("mini_game_banner_ad", hashMap, null);
        createKuiklyRenderView.onResume();
        ((View) createKuiklyRenderView).setBackgroundColor(0);
        this.mKuiklyRenderView = createKuiklyRenderView;
    }

    private final void i() {
        if (!this.mHasRegisterBroadcastReceiver) {
            try {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                l.c(context, this.mKuiklyReceiver);
                this.mHasRegisterBroadcastReceiver = true;
            } catch (Exception e16) {
                QLog.e("GdtBannerAdViewWithKuikly", 1, "registerKuiklyBroadcastReceiver error:", e16);
            }
        }
    }

    private final void j() {
        if (this.mHasRegisterBroadcastReceiver) {
            try {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                l.f(context, this.mKuiklyReceiver);
                this.mHasRegisterBroadcastReceiver = false;
            } catch (Exception e16) {
                QLog.e("GdtBannerAdViewWithKuikly", 1, "unregisterKuiklyBroadcastReceiver error:", e16);
            }
        }
    }

    @Override // i01.c
    @UiThread
    public boolean b(@NotNull String str, @NotNull Object obj) {
        return c.a.p(this, str, obj);
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public void destroy(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d("GdtBannerAdViewWithKuikly", 1, "destroy");
        try {
            g gVar = this.mKuiklyRenderView;
            if (gVar != null) {
                gVar.onDetach();
            }
        } catch (Exception e16) {
            QLog.e("GdtBannerAdViewWithKuikly", 1, "mKuiklyRenderView onDetach error:", e16);
        }
        j();
        setVisibility(8);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // com.tencent.gdtad.api.banner.GdtBannerView
    @Nullable
    public AdAntiSpamForClick getAntiSpamForClick() {
        return null;
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // com.tencent.gdtad.api.banner.GdtBannerView
    @Nullable
    public View getOptionsView() {
        return null;
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        h.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        h.a.b(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        String str;
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        Object[] objArr = new Object[2];
        objArr[0] = "onPageLoadComplete isSucceed=" + isSucceed + ",errorReason=";
        if (errorReason != null) {
            str = errorReason.name();
        } else {
            str = null;
        }
        objArr[1] = str;
        QLog.d("GdtBannerAdViewWithKuikly", 1, objArr);
        if (!isSucceed) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            destroy(context);
        }
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public void pause(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        g gVar = this.mKuiklyRenderView;
        if (gVar != null) {
            gVar.onPause();
        }
        j();
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public void resume(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        g gVar = this.mKuiklyRenderView;
        if (gVar != null) {
            gVar.onResume();
        }
        i();
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    public final void setAdCloseListener(@NotNull a adStateListener) {
        Intrinsics.checkNotNullParameter(adStateListener, "adStateListener");
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull b bVar) {
        c.a.q(this, bVar);
    }

    @Override // com.tencent.gdtad.api.banner.GdtBannerView
    public void setSize(int width, int height) {
        ViewGroup.LayoutParams layoutParams;
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout != null) {
            layoutParams = frameLayout.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.width = width;
        }
        if (layoutParams != null) {
            layoutParams.height = height;
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        h.a.c(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        h.a.d(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable String str2, @Nullable Function1<Object, Unit> function1) {
        return c.a.b(this, str, str2, function1);
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    @NotNull
    public View getView() {
        return this;
    }
}
