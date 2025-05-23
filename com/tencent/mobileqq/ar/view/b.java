package com.tencent.mobileqq.ar.view;

import android.animation.Animator;
import android.util.SparseArray;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f198801a;

    /* renamed from: b, reason: collision with root package name */
    private SparseArray<com.tencent.mobileqq.ar.view.a> f198802b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private Animator.AnimatorListener f198803c = new a();

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC7409b f198804d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.view.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC7409b {
        void onAnimationEnd();
    }

    public b() {
        this.f198801a = 2;
        this.f198801a = 2;
    }

    private void d(int i3, int i16) {
        com.tencent.mobileqq.ar.view.a aVar = this.f198802b.get(i3);
        com.tencent.mobileqq.ar.view.a aVar2 = this.f198802b.get(i16);
        aVar.f(false, null);
        aVar2.f(true, this.f198803c);
    }

    private void e(int i3) {
        if (this.f198802b.get(i3) != null) {
            this.f198802b.get(i3).stop();
        }
    }

    public void b(int i3, com.tencent.mobileqq.ar.view.a aVar) {
        this.f198802b.put(i3, aVar);
    }

    public void c() {
        g();
        this.f198802b.clear();
        this.f198804d = null;
    }

    public void f(int i3, InterfaceC7409b interfaceC7409b) {
        int i16 = this.f198801a;
        if (i16 == i3) {
            return;
        }
        this.f198804d = interfaceC7409b;
        d(i16, i3);
        this.f198801a = i3;
    }

    public void g() {
        for (int i3 = 1; i3 <= 3; i3++) {
            e(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends com.tencent.mobileqq.widget.f {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (b.this.f198804d != null) {
                b.this.f198804d.onAnimationEnd();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
