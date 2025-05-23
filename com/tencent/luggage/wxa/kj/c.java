package com.tencent.luggage.wxa.kj;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.kl.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandActionBarNavButtonContainerLayout;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements b.c {

    /* renamed from: e, reason: collision with root package name */
    public static final a f132082e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final v f132083b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f132084c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f132085d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(v pageView) {
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        this.f132083b = pageView;
    }

    @Override // com.tencent.luggage.wxa.kl.b.c
    public int a() {
        return R.dimen.c1k;
    }

    public final boolean b() {
        return this.f132084c || !this.f132085d;
    }

    @Override // com.tencent.luggage.wxa.kl.b.c
    public /* synthetic */ boolean a(View view) {
        return c31.j.b(this, view);
    }

    @Override // com.tencent.luggage.wxa.kl.b.c
    public boolean b(View view) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandActionBarHomeButtonStyle", "pageView click close button");
        if (this.f132083b.W().m()) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandActionBarHomeButtonStyle", "pageView click close button, but nav area is hidden");
        } else {
            p Y = this.f132083b.getRuntime().Y();
            if (Y != null) {
                Y.h();
            }
        }
        return c31.j.c(this, view);
    }

    @Override // com.tencent.luggage.wxa.kl.b.c
    public void a(com.tencent.luggage.wxa.kl.b actionBarThis, com.tencent.luggage.wxa.so.c navButtonGetter, com.tencent.luggage.wxa.so.c homeBtnGetter, View view) {
        Intrinsics.checkNotNullParameter(actionBarThis, "actionBarThis");
        Intrinsics.checkNotNullParameter(navButtonGetter, "navButtonGetter");
        Intrinsics.checkNotNullParameter(homeBtnGetter, "homeBtnGetter");
        this.f132085d = true;
        if (actionBarThis.k() || actionBarThis.m()) {
            return;
        }
        Context context = actionBarThis.getContext();
        if (this.f132083b.getRuntime().Y().getPageCount() == 1) {
            ImageView imageView = (ImageView) navButtonGetter.d();
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) homeBtnGetter.b();
            if (imageView2 != null) {
                ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandActionBarNavButtonContainerLayout.LayoutParams");
                AppBrandActionBarNavButtonContainerLayout.a aVar = (AppBrandActionBarNavButtonContainerLayout.a) layoutParams;
                int dimensionPixelOffset = imageView2.getContext().getResources().getDimensionPixelOffset(R.dimen.c1m);
                ((LinearLayout.LayoutParams) aVar).height = dimensionPixelOffset;
                ((LinearLayout.LayoutParams) aVar).width = dimensionPixelOffset;
                ((LinearLayout.LayoutParams) aVar).gravity = 17;
                ((LinearLayout.LayoutParams) aVar).leftMargin = context.getResources().getDimensionPixelOffset(a());
                ((LinearLayout.LayoutParams) aVar).rightMargin = context.getResources().getDimensionPixelOffset(R.dimen.c1l);
                imageView2.setLayoutParams(aVar);
                imageView2.clearColorFilter();
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView2.getContext(), R.drawable.m8b));
                imageView2.setColorFilter(this.f132083b.W().getForegroundColor(), PorterDuff.Mode.SRC_ATOP);
                return;
            }
            return;
        }
        ImageView imageView3 = (ImageView) navButtonGetter.b();
        if (imageView3 != null) {
            imageView3.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = imageView3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandActionBarNavButtonContainerLayout.LayoutParams");
            AppBrandActionBarNavButtonContainerLayout.a aVar2 = (AppBrandActionBarNavButtonContainerLayout.a) layoutParams2;
            ((LinearLayout.LayoutParams) aVar2).leftMargin = context.getResources().getDimensionPixelOffset(a());
            ((LinearLayout.LayoutParams) aVar2).rightMargin = imageView3.getContext().getResources().getDimensionPixelSize(R.dimen.bdn);
            ((LinearLayout.LayoutParams) aVar2).gravity = 17;
            imageView3.setLayoutParams(aVar2);
        }
    }
}
