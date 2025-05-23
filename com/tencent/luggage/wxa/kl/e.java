package com.tencent.luggage.wxa.kl;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public int f132635a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f132636b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap f132637c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f132638d;

    /* renamed from: e, reason: collision with root package name */
    public Function1 f132639e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            float coerceIn;
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            e eVar = e.this;
            coerceIn = RangesKt___RangesKt.coerceIn(floatValue, 0.0f, 1.0f);
            eVar.setAlpha(coerceIn);
        }
    }

    public e(Context context) {
        super(context);
    }

    public ValueAnimator a() {
        return a(1.0f, 0.0f);
    }

    public final void b() {
        setAlpha(0.0f);
        a(0.0f, 1.0f).start();
    }

    @NotNull
    public final ImageView getIcon() {
        ImageView imageView = this.f132638d;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("icon");
        return null;
    }

    @Nullable
    public final Bitmap getMDmBitmap() {
        return this.f132636b;
    }

    @Nullable
    public final Bitmap getMLmBitmap() {
        return this.f132637c;
    }

    @NotNull
    public final Function1<e, Unit> getMOnViewCreated() {
        Function1<e, Unit> function1 = this.f132639e;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mOnViewCreated");
        return null;
    }

    public final int getMStyleColor() {
        return this.f132635a;
    }

    public void setColor(@ColorInt int i3) {
        if (this.f132635a == i3) {
            return;
        }
        a(i3);
        this.f132635a = i3;
    }

    public final void setIcon(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.f132638d = imageView;
    }

    public final void setMDmBitmap(@Nullable Bitmap bitmap) {
        this.f132636b = bitmap;
    }

    public final void setMLmBitmap(@Nullable Bitmap bitmap) {
        this.f132637c = bitmap;
    }

    public final void setMOnViewCreated(@NotNull Function1<? super e, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.f132639e = function1;
    }

    public final void setMStyleColor(int i3) {
        this.f132635a = i3;
    }

    public final void a(String url, boolean z16) {
        Intrinsics.checkNotNullParameter(url, "url");
        AppBrandSimpleImageLoader.instance().load(new b(z16, this), url, (AppBrandSimpleImageLoader.j) null);
    }

    public final ValueAnimator a(float f16, float f17) {
        ValueAnimator animator = ValueAnimator.ofFloat(f16, f17);
        animator.setDuration(250L);
        animator.addUpdateListener(new a());
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        return animator;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements AppBrandSimpleImageLoader.m {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f132641a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f132642b;

        public b(boolean z16, e eVar) {
            this.f132641a = z16;
            this.f132642b = eVar;
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a(Bitmap bitmap) {
            if (this.f132641a) {
                this.f132642b.setMDmBitmap(bitmap);
            } else {
                this.f132642b.setMLmBitmap(bitmap);
            }
            e eVar = this.f132642b;
            eVar.a(eVar.getMStyleColor());
            if (com.tencent.luggage.wxa.h6.d.a(this.f132642b.getMDmBitmap()) && com.tencent.luggage.wxa.h6.d.a(this.f132642b.getMLmBitmap())) {
                this.f132642b.getMOnViewCreated().invoke(this.f132642b);
            }
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m, com.tencent.luggage.wxa.pb.a
        public String b() {
            return "AppBrandTradeOptionView";
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a() {
            this.f132642b.getMOnViewCreated().invoke(null);
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void c() {
        }
    }

    public final void a(int i3) {
        if (i3 == -1) {
            Bitmap bitmap = this.f132636b;
            if (bitmap != null) {
                getIcon().setImageBitmap(bitmap);
                return;
            }
            return;
        }
        Bitmap bitmap2 = this.f132637c;
        if (bitmap2 != null) {
            getIcon().setImageBitmap(bitmap2);
        }
    }
}
