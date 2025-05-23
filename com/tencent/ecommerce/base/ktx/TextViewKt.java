package com.tencent.ecommerce.base.ktx;

import android.animation.ValueAnimator;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewKt;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a2\u0010\f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\bH\u0000\u001a:\u0010\u000f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\bH\u0000\u001a\f\u0010\u0010\u001a\u00020\u0001*\u00020\u0006H\u0000\u00a8\u0006\u0011"}, d2 = {"Landroid/widget/TextView;", "", "fontPath", "", "a", "b", "", "price", "", "symbolsTextSize", "intTextSize", "decimalTextSize", "c", "oldPrice", "newPrice", "d", "e", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class TextViewKt {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/ecommerce/base/ktx/TextViewKt$showPriceWithAnimation$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f100734d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f100735e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f100736f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f100737h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f100738i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f100739m;

        a(TextView textView, long j3, long j16, int i3, int i16, int i17) {
            this.f100734d = textView;
            this.f100735e = j3;
            this.f100736f = j16;
            this.f100737h = i3;
            this.f100738i = i16;
            this.f100739m = i17;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                BigDecimal add = new BigDecimal(String.valueOf(this.f100735e)).multiply(new BigDecimal(String.valueOf(((Float) animatedValue).floatValue()))).add(new BigDecimal(String.valueOf(this.f100736f)));
                Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
                TextViewKt.c(this.f100734d, add.longValue(), this.f100737h, this.f100738i, this.f100739m);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final void a(TextView textView, String str) {
        textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), str));
    }

    public static final void b(TextView textView, String str) {
        LifecycleCoroutineScope lifecycleScope;
        LifecycleOwner findViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(textView);
        if (findViewTreeLifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(findViewTreeLifecycleOwner)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new TextViewKt$setFontAsync$1(textView, str, null), 3, null);
    }

    public static final void c(TextView textView, long j3, int i3, int i16, int i17) {
        List split$default;
        Object first;
        String e16 = e(j3);
        split$default = StringsKt__StringsKt.split$default((CharSequence) e16, new String[]{"."}, false, 0, 6, (Object) null);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default);
        String str = (String) first;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("\u00a5" + e16);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(textView.getContext().getResources().getDimensionPixelSize(i3)), 0, 1, 18);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(textView.getContext().getResources().getDimensionPixelSize(i16)), 1, str.length() + 1 + 1, 18);
        spannableStringBuilder.setSpan(new CustomTypefaceSpan(textView.getContext(), "fonts/Qvideo Digit.ttf"), 1, str.length() + 1 + 1, 18);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(textView.getContext().getResources().getDimensionPixelSize(i17)), str.length() + 1 + 1, e16.length() + 1, 18);
        spannableStringBuilder.setSpan(new CustomTypefaceSpan(textView.getContext(), "fonts/Qvideo Digit.ttf"), str.length() + 1 + 1, e16.length() + 1, 18);
        textView.setText(spannableStringBuilder);
    }

    public static final String e(long j3) {
        return new BigDecimal(String.valueOf(j3)).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP).toPlainString();
    }

    public static final void d(TextView textView, long j3, long j16, int i3, int i16, int i17) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new a(textView, j16 - j3, j3, i3, i16, i17));
        ofFloat.start();
    }
}
