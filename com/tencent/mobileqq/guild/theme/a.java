package com.tencent.mobileqq.guild.theme;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH&J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\bH&J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\t\u001a\u00020\bH&J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\t\u001a\u00020\bH&R\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\u0082\u0001\u0001\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/theme/a;", "", "Landroid/widget/TextView;", "textView", "", "b", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieAnimationView", "", "drawableRes", "e", "lottieResource", "c", "Landroid/view/View;", "view", "f", "d", "Lcom/tencent/mobileqq/guild/theme/b;", "a", "Lcom/tencent/mobileqq/guild/theme/b;", "()Lcom/tencent/mobileqq/guild/theme/b;", "channelIconStyleProvider", "<init>", "(Lcom/tencent/mobileqq/guild/theme/b;)V", "Lcom/tencent/mobileqq/guild/theme/e;", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b channelIconStyleProvider;

    public /* synthetic */ a(b bVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final b getChannelIconStyleProvider() {
        return this.channelIconStyleProvider;
    }

    public abstract void b(@NotNull TextView textView);

    public abstract void c(@NotNull LottieAnimationView lottieAnimationView, @StringRes int lottieResource);

    public abstract void d(@NotNull View view, @DrawableRes int drawableRes);

    public abstract void e(@NotNull LottieAnimationView lottieAnimationView, @DrawableRes int drawableRes);

    public abstract void f(@NotNull View view, @DrawableRes int drawableRes);

    a(b bVar) {
        this.channelIconStyleProvider = bVar;
    }
}
