package com.tencent.mobileqq.nearbypro.utils;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0007H\u0007R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\fR8\u0010\u0013\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000fj\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/utils/p;", "", "", "time", "f", "Landroid/view/View;", "targetView", "", "c", "g", "", "b", "I", "HEAD_WIDTH", "HEAD_HEIGHT", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "SHAR_ANI_ROTA", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f253956a = new p();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int HEAD_WIDTH;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int HEAD_HEIGHT;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, Float> SHAR_ANI_ROTA;

    static {
        int b16 = d.b(58);
        HEAD_WIDTH = b16;
        HEAD_HEIGHT = b16;
        HashMap<Integer, Float> hashMap = new HashMap<>();
        SHAR_ANI_ROTA = hashMap;
        Float valueOf = Float.valueOf(0.0f);
        hashMap.put(0, valueOf);
        hashMap.put(1, Float.valueOf(3.0f));
        hashMap.put(2, Float.valueOf(6.0f));
        hashMap.put(3, Float.valueOf(3.66f));
        hashMap.put(4, Float.valueOf(-2.33f));
        hashMap.put(5, Float.valueOf(-5.0f));
        Float valueOf2 = Float.valueOf(-2.0f);
        hashMap.put(6, valueOf2);
        hashMap.put(7, Float.valueOf(1.0f));
        hashMap.put(8, Float.valueOf(4.0f));
        hashMap.put(9, Float.valueOf(1.67f));
        hashMap.put(10, Float.valueOf(-0.66f));
        hashMap.put(11, Float.valueOf(-3.0f));
        hashMap.put(12, valueOf2);
        hashMap.put(13, Float.valueOf(-1.0f));
        hashMap.put(14, valueOf);
    }

    p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final View targetView) {
        float f16;
        float f17;
        Intrinsics.checkNotNullParameter(targetView, "$targetView");
        int measuredWidth = targetView.getMeasuredWidth() / 2;
        int measuredHeight = targetView.getMeasuredHeight();
        if (measuredWidth == 0) {
            f16 = HEAD_WIDTH / 2;
        } else {
            f16 = measuredWidth;
        }
        targetView.setPivotX(f16);
        if (measuredHeight == 0) {
            f17 = HEAD_HEIGHT;
        } else {
            f17 = measuredHeight;
        }
        targetView.setPivotY(f17);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 500.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.nearbypro.utils.o
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                p.e(targetView, valueAnimator);
            }
        });
        ofFloat.start();
        f253956a.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(View targetView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(targetView, "$targetView");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        targetView.setRotation(f253956a.f(((Float) animatedValue).floatValue()));
    }

    private final float f(float time) {
        Float f16 = SHAR_ANI_ROTA.get(Integer.valueOf(Math.min((int) (time / 33.333332f), 14)));
        if (f16 == null) {
            return 0.0f;
        }
        return f16.floatValue();
    }

    public final void c(@NotNull final View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        targetView.post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.utils.n
            @Override // java.lang.Runnable
            public final void run() {
                p.d(targetView);
            }
        });
    }

    @SuppressLint({"MissingPermission"})
    public final void g() {
        VibrationEffect createWaveform;
        try {
            Object systemService = MobileQQ.sMobileQQ.getApplicationContext().getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            Vibrator vibrator = (Vibrator) systemService;
            if (Build.VERSION.SDK_INT >= 26) {
                createWaveform = VibrationEffect.createWaveform(new long[]{20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20}, new int[]{0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255, 0, 255}, -1);
                vibrator.vibrate(createWaveform);
            } else {
                vibrator.vibrate(new long[]{20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20}, -1);
            }
        } catch (Exception unused) {
        }
    }
}
