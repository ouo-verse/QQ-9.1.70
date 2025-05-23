package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class h<T extends Animator> {

    /* renamed from: a, reason: collision with root package name */
    protected i f33985a;

    /* renamed from: b, reason: collision with root package name */
    protected final float[] f33986b;

    /* renamed from: c, reason: collision with root package name */
    protected final int[] f33987c;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(int i3) {
        this.f33986b = new float[i3 * 2];
        this.f33987c = new int[i3];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public float b(int i3, int i16, int i17) {
        return (i3 - i16) / i17;
    }

    public abstract void c();

    public abstract void d(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(@NonNull i iVar) {
        this.f33985a = iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void g();

    public abstract void h();
}
