package com.tencent.luggage.wxa.kj;

import android.content.Context;
import android.content.res.Configuration;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.kl.b;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class v0 implements com.tencent.luggage.wxa.mj.a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f132517c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final v f132518a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f132519b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public v0(v page) {
        Intrinsics.checkNotNullParameter(page, "page");
        this.f132518a = page;
    }

    public final void a() {
        com.tencent.luggage.wxa.kl.b W = this.f132518a.W();
        Intrinsics.checkNotNullExpressionValue(W, "page.actionBar");
        a(W);
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onBackground() {
        this.f132519b = false;
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (!this.f132519b) {
            return;
        }
        com.tencent.luggage.wxa.kl.b W = this.f132518a.W();
        Intrinsics.checkNotNullExpressionValue(W, "page.actionBar");
        a(W);
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onDestroy() {
        this.f132519b = false;
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onForeground() {
        this.f132519b = true;
        com.tencent.luggage.wxa.kl.b W = this.f132518a.W();
        Intrinsics.checkNotNullExpressionValue(W, "page.actionBar");
        a(W);
    }

    public final void a(com.tencent.luggage.wxa.kl.b bVar) {
        int dimensionPixelSize;
        Context context = bVar.getContext();
        AppBrandCapsuleBarPlaceHolderView capsuleView = bVar.getCapsuleView();
        if (capsuleView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams layoutParams = capsuleView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (this.f132518a.D().getOrientationHandler().a() == e.b.PORTRAIT) {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.c1f);
            } else {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.c1g);
            }
            if (marginLayoutParams.rightMargin != dimensionPixelSize || marginLayoutParams.getMarginEnd() != dimensionPixelSize) {
                marginLayoutParams.rightMargin = dimensionPixelSize;
                marginLayoutParams.setMarginEnd(dimensionPixelSize);
                com.tencent.luggage.wxa.tn.w.d("MPPageViewActionBarExtensionImpl", "[applyActionBarSizeProperty] reset capsule rightMargin:" + dimensionPixelSize);
                capsuleView.requestLayout();
            }
        } else if (com.tencent.luggage.wxa.tn.e.f141565g || com.tencent.luggage.wxa.tn.e.f141559a) {
            throw new RuntimeException("it is not MarginLayoutParams");
        }
        b.c navResetStyleListener = bVar.getNavResetStyleListener();
        int a16 = navResetStyleListener != null ? navResetStyleListener.a() : b.c.f132628a;
        bVar.q();
        bVar.setNavContainerMinimumWidth(context.getResources().getDimensionPixelOffset(a16));
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.c1h);
        bVar.setActionBarHeight(dimensionPixelOffset);
        com.tencent.luggage.wxa.tn.w.d("MPPageViewActionBarExtensionImpl", "[applyActionBarSizeProperty] ActionBar height=" + dimensionPixelOffset + "  density=" + context.getResources().getDisplayMetrics().density);
    }
}
