package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes2.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private Animator f33670a;

    public void a() {
        Animator animator = this.f33670a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b() {
        this.f33670a = null;
    }

    public void c(Animator animator) {
        a();
        this.f33670a = animator;
    }
}
