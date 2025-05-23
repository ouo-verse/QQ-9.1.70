package com.tencent.mobileqq.guild.component.animator;

import android.view.animation.Interpolator;
import com.tencent.mobileqq.guild.component.animator.CircleWaveView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0018\u0012\b\b\u0002\u0010%\u001a\u00020\u001f\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010+\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/component/animator/d;", "", "", "currentTimeMillis", "", "b", "", "g", "f", "a", "d", "c", "", "toString", "", "hashCode", "other", "equals", "J", "getStartTimeMillis", "()J", "j", "(J)V", "startTimeMillis", "Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView$c;", "Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView$c;", "getWavParam", "()Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView$c;", "k", "(Lcom/tencent/mobileqq/guild/component/animator/CircleWaveView$c;)V", "wavParam", "Landroid/view/animation/Interpolator;", "Landroid/view/animation/Interpolator;", "getInterpolator", "()Landroid/view/animation/Interpolator;", "i", "(Landroid/view/animation/Interpolator;)V", "interpolator", "Z", "e", "()Z", tl.h.F, "(Z)V", "isAnimating", "<init>", "(JLcom/tencent/mobileqq/guild/component/animator/CircleWaveView$c;Landroid/view/animation/Interpolator;)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.component.animator.d, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class Circle {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long startTimeMillis;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private CircleWaveView.WaveParam wavParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private Interpolator interpolator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimating;

    public Circle(long j3, @NotNull CircleWaveView.WaveParam wavParam, @NotNull Interpolator interpolator) {
        Intrinsics.checkNotNullParameter(wavParam, "wavParam");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        this.startTimeMillis = j3;
        this.wavParam = wavParam;
        this.interpolator = interpolator;
    }

    private final float b(long currentTimeMillis) {
        return this.interpolator.getInterpolation((((float) (currentTimeMillis - this.startTimeMillis)) * 1.0f) / ((float) this.wavParam.getDuration()));
    }

    public final float a(long currentTimeMillis) {
        return this.wavParam.getStartAlphaRate() + ((this.wavParam.getEndAlphaRate() - this.wavParam.getStartAlphaRate()) * b(currentTimeMillis));
    }

    public final float c(long currentTimeMillis) {
        return this.wavParam.getStartSizeRate() + (((this.wavParam.getEndSizeRate() * this.wavParam.getEndSizeTime()) - this.wavParam.getStartSizeRate()) * b(currentTimeMillis));
    }

    public final float d(long currentTimeMillis) {
        return this.wavParam.getStartStrokeRate() + ((this.wavParam.getEndStrokeRate() - this.wavParam.getStartStrokeRate()) * b(currentTimeMillis));
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsAnimating() {
        return this.isAnimating;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Circle)) {
            return false;
        }
        Circle circle = (Circle) other;
        if (this.startTimeMillis == circle.startTimeMillis && Intrinsics.areEqual(this.wavParam, circle.wavParam) && Intrinsics.areEqual(this.interpolator, circle.interpolator)) {
            return true;
        }
        return false;
    }

    public final boolean f(long currentTimeMillis) {
        if (currentTimeMillis - this.startTimeMillis >= this.wavParam.getDuration()) {
            return true;
        }
        return false;
    }

    public final boolean g(long currentTimeMillis) {
        if (currentTimeMillis >= this.startTimeMillis) {
            return true;
        }
        return false;
    }

    public final void h(boolean z16) {
        this.isAnimating = z16;
    }

    public int hashCode() {
        return (((androidx.fragment.app.a.a(this.startTimeMillis) * 31) + this.wavParam.hashCode()) * 31) + this.interpolator.hashCode();
    }

    public final void i(@NotNull Interpolator interpolator) {
        Intrinsics.checkNotNullParameter(interpolator, "<set-?>");
        this.interpolator = interpolator;
    }

    public final void j(long j3) {
        this.startTimeMillis = j3;
    }

    public final void k(@NotNull CircleWaveView.WaveParam waveParam) {
        Intrinsics.checkNotNullParameter(waveParam, "<set-?>");
        this.wavParam = waveParam;
    }

    @NotNull
    public String toString() {
        return "Circle(startTimeMillis=" + this.startTimeMillis + ", wavParam=" + this.wavParam + ", interpolator=" + this.interpolator + ")";
    }
}
