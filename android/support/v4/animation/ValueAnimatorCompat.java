package android.support.v4.animation;

import android.view.View;

/* compiled from: P */
/* loaded from: classes.dex */
public interface ValueAnimatorCompat {
    void addListener(AnimatorListenerCompat animatorListenerCompat);

    void addUpdateListener(AnimatorUpdateListenerCompat animatorUpdateListenerCompat);

    void cancel();

    float getAnimatedFraction();

    void setDuration(long j3);

    void setTarget(View view);

    void start();
}
