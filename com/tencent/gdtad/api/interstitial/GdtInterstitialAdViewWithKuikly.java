package com.tencent.gdtad.api.interstitial;

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
import com.tencent.gdtad.api.GdtAdView;
import com.tencent.gdtad.api.interstitial.GdtInterstitialAdViewWithKuikly;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.qphone.base.util.QLog;
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
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u000b*\u0001+\u0018\u0000 22\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u000234B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010/\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017R\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010'R\u0016\u0010*\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001aR\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00065"}, d2 = {"Lcom/tencent/gdtad/api/interstitial/GdtInterstitialAdViewWithKuikly;", "Landroid/widget/FrameLayout;", "Lcom/tencent/gdtad/api/GdtAdView;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Li01/c;", "", "d", "i", "j", "Landroid/view/View;", "getView", "Landroid/content/Context;", "context", "pause", "resume", "destroy", "", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "Lcom/tencent/gdtad/api/interstitial/GdtInterstitialAdViewWithKuikly$a;", "adStateListener", "setAdCloseListener", "Z", "mHasRegisterBroadcastReceiver", "e", "Landroid/widget/FrameLayout;", "mContainer", "", "f", "Ljava/lang/String;", "mAdStr", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", h.F, "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "mKuiklyRenderView", "Lcom/tencent/gdtad/api/interstitial/GdtInterstitialAdViewWithKuikly$a;", "mAdStateListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mIsLoadSuccess", "com/tencent/gdtad/api/interstitial/GdtInterstitialAdViewWithKuikly$mKuiklyReceiver$1", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/gdtad/api/interstitial/GdtInterstitialAdViewWithKuikly$mKuiklyReceiver$1;", "mKuiklyReceiver", "adInfo", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "D", "a", "b", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GdtInterstitialAdViewWithKuikly extends FrameLayout implements GdtAdView, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h, i01.c {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GdtInterstitialAdViewWithKuikly$mKuiklyReceiver$1 mKuiklyReceiver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mHasRegisterBroadcastReceiver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mAdStr;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g mKuiklyRenderView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a mAdStateListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLoadSuccess;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/gdtad/api/interstitial/GdtInterstitialAdViewWithKuikly$a;", "", "", "a", "onAdClose", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void onAdClose();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.gdtad.api.interstitial.GdtInterstitialAdViewWithKuikly$mKuiklyReceiver$1] */
    public GdtInterstitialAdViewWithKuikly(@NotNull Context context, @Nullable String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAdStr = str;
        this.mKuiklyReceiver = new BroadcastReceiver() { // from class: com.tencent.gdtad.api.interstitial.GdtInterstitialAdViewWithKuikly$mKuiklyReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context2, @NotNull Intent intent) {
                GdtInterstitialAdViewWithKuikly.a aVar;
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String a16 = l.a(intent);
                QLog.d("GdtInterstitialAdViewWithKuikly", 2, "onReceive:", a16);
                if (TextUtils.equals(a16, "event_close_ad")) {
                    QLog.d("GdtInterstitialAdViewWithKuikly", 1, "onReceive hide ad");
                    aVar = GdtInterstitialAdViewWithKuikly.this.mAdStateListener;
                    if (aVar != null) {
                        aVar.onAdClose();
                    }
                    GdtInterstitialAdViewWithKuikly.this.destroy(context2);
                }
            }
        };
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void d() {
        String str;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gx9, (ViewGroup) this, true);
        if (inflate == null) {
            return;
        }
        this.mContainer = (FrameLayout) inflate.findViewById(R.id.xo_);
        HashMap hashMap = new HashMap();
        String str2 = this.mAdStr;
        if (str2 != null) {
            hashMap.put(QAdVrReport.ElementID.AD_INFO, str2);
        }
        hashMap.put("bundle_name", "mini_game_ad");
        if (getContext().getResources().getConfiguration().orientation == 2) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("screen_orientation", str);
        IQQKuiklyFactory iQQKuiklyFactory = (IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        g createKuiklyRenderView = iQQKuiklyFactory.createKuiklyRenderView(context, this);
        addView((View) createKuiklyRenderView, new FrameLayout.LayoutParams(-1, -1));
        createKuiklyRenderView.b("mini_game_interstitial_ad", hashMap, null);
        createKuiklyRenderView.onResume();
        ((View) createKuiklyRenderView).setBackgroundColor(0);
        this.mKuiklyRenderView = createKuiklyRenderView;
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.d
            @Override // java.lang.Runnable
            public final void run() {
                GdtInterstitialAdViewWithKuikly.g(GdtInterstitialAdViewWithKuikly.this);
            }
        }, 16, null, false, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(GdtInterstitialAdViewWithKuikly this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.mIsLoadSuccess) {
            a aVar = this$0.mAdStateListener;
            if (aVar != null) {
                aVar.onAdClose();
            }
            QLog.d("GdtInterstitialAdViewWithKuikly", 1, "auto close by not success");
        }
    }

    private final void i() {
        if (!this.mHasRegisterBroadcastReceiver) {
            try {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                l.c(context, this.mKuiklyReceiver);
                this.mHasRegisterBroadcastReceiver = true;
            } catch (Exception e16) {
                QLog.e("GdtInterstitialAdViewWithKuikly", 1, "registerKuiklyBroadcastReceiver error:", e16);
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
                QLog.e("GdtInterstitialAdViewWithKuikly", 1, "unregisterKuiklyBroadcastReceiver error:", e16);
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
    public void destroy(@Nullable Context context) {
        try {
            g gVar = this.mKuiklyRenderView;
            if (gVar != null) {
                gVar.onDetach();
            }
        } catch (Exception e16) {
            QLog.e("GdtInterstitialAdViewWithKuikly", 1, "mKuiklyRenderView onDetach error:", e16);
        }
        j();
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

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
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
        QLog.d("GdtInterstitialAdViewWithKuikly", 1, objArr);
        this.mIsLoadSuccess = isSucceed;
        if (isSucceed) {
            a aVar = this.mAdStateListener;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        destroy(getContext());
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public void pause(@Nullable Context context) {
        g gVar = this.mKuiklyRenderView;
        if (gVar != null) {
            gVar.onPause();
        }
        j();
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public void resume(@Nullable Context context) {
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
        this.mAdStateListener = adStateListener;
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        c.a.q(this, bVar);
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
    @Nullable
    public View getView() {
        return this;
    }
}
