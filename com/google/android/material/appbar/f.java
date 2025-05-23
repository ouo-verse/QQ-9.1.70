package com.google.android.material.appbar;

import android.R;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.internal.o;

/* compiled from: P */
@RequiresApi(21)
/* loaded from: classes2.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f33250a = {R.attr.stateListAnimator};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(@NonNull View view, float f16) {
        int integer = view.getResources().getInteger(com.tencent.mobileqq.R.integer.f127046);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j3 = integer;
        stateListAnimator.addState(new int[]{R.attr.state_enabled, com.tencent.mobileqq.R.attr.bcp, -2130971407}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j3));
        stateListAnimator.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(view, "elevation", f16).setDuration(j3));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(@NonNull View view, AttributeSet attributeSet, int i3, int i16) {
        Context context = view.getContext();
        TypedArray h16 = o.h(context, attributeSet, f33250a, i3, i16, new int[0]);
        try {
            if (h16.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, h16.getResourceId(0, 0)));
            }
        } finally {
            h16.recycle();
        }
    }
}
