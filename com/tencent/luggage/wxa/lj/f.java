package com.tencent.luggage.wxa.lj;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f implements j {
    public final Animator a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f, 1.0f);
        ofFloat.setDuration(2000L);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        return ofFloat;
    }

    public abstract void a(Drawable drawable);

    public abstract void a(Runnable runnable);

    public abstract void a(boolean z16);

    public abstract void b(int i3, boolean z16);

    public abstract void b(CharSequence charSequence);

    public abstract void b(Map map);

    public abstract Context c();
}
