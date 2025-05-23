package com.tencent.mobileqq.colornote.anim;

import android.animation.Animator;
import android.view.View;
import com.tencent.mobileqq.colornote.anim.a;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class d {
    public static Animator a(View view, int i3, int i16, float f16, float f17) {
        return b(view, i3, i16, f16, f17, 2);
    }

    public static Animator b(View view, int i3, int i16, float f16, float f17, int i17) {
        a c16 = a.c(view, i3, i16, f16, f17);
        if (i17 != view.getLayerType()) {
            c16.addListener(new a.b(view, i17));
        }
        return c16;
    }
}
