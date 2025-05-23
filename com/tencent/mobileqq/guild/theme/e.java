package com.tencent.mobileqq.guild.theme;

import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/theme/e;", "Lcom/tencent/mobileqq/guild/theme/a;", "Landroid/widget/TextView;", "textView", "", "b", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieAnimationView", "", "drawableRes", "e", "lottieResource", "c", "Landroid/view/View;", "view", "f", "d", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e extends a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final e f235301b = new e();

    e() {
        super(f.f235302a, null);
    }

    @Override // com.tencent.mobileqq.guild.theme.a
    public void b(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        textView.setTextColor(-1);
    }

    @Override // com.tencent.mobileqq.guild.theme.a
    public void c(@NotNull LottieAnimationView lottieAnimationView, int lottieResource) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "lottieAnimationView");
        lottieAnimationView.setAnimation(lottieAnimationView.getContext().getString(lottieResource));
    }

    @Override // com.tencent.mobileqq.guild.theme.a
    public void d(@NotNull View view, int drawableRes) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackgroundResource(drawableRes);
    }

    @Override // com.tencent.mobileqq.guild.theme.a
    public void e(@NotNull LottieAnimationView lottieAnimationView, int drawableRes) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "lottieAnimationView");
        lottieAnimationView.setImageResource(drawableRes);
    }

    @Override // com.tencent.mobileqq.guild.theme.a
    public void f(@NotNull View view, int drawableRes) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackgroundResource(drawableRes);
    }
}
