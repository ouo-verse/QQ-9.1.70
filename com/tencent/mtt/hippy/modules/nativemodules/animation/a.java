package com.tencent.mtt.hippy.modules.nativemodules.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class a implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    protected final int f337445a;

    /* renamed from: b, reason: collision with root package name */
    protected CopyOnWriteArrayList<Integer> f337446b;

    /* renamed from: c, reason: collision with root package name */
    protected CopyOnWriteArrayList<InterfaceC9228a> f337447c;

    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.modules.nativemodules.animation.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC9228a {
        void onAnimationCancel(a aVar);

        void onAnimationEnd(a aVar);

        void onAnimationRepeat(a aVar);

        void onAnimationStart(a aVar);

        void onAnimationUpdate(a aVar);
    }

    public a(int i3) {
        this.f337445a = i3;
    }

    public abstract Animator a();

    public void a(int i3) {
        if (this.f337446b == null) {
            this.f337446b = new CopyOnWriteArrayList<>();
        }
        if (this.f337446b.contains(Integer.valueOf(i3))) {
            return;
        }
        this.f337446b.add(Integer.valueOf(i3));
    }

    public abstract void b();

    public void b(int i3) {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = this.f337446b;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(Integer.valueOf(i3));
        }
    }

    public abstract void c();

    public int d() {
        return this.f337445a;
    }

    public CopyOnWriteArrayList<Integer> e() {
        return this.f337446b;
    }

    public abstract Object f();

    public abstract Object g();

    public abstract void h();

    public abstract void i();

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        CopyOnWriteArrayList<InterfaceC9228a> copyOnWriteArrayList = this.f337447c;
        if (copyOnWriteArrayList == null) {
            return;
        }
        Iterator<InterfaceC9228a> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        CopyOnWriteArrayList<InterfaceC9228a> copyOnWriteArrayList = this.f337447c;
        if (copyOnWriteArrayList == null) {
            return;
        }
        Iterator<InterfaceC9228a> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().onAnimationEnd(this);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        CopyOnWriteArrayList<InterfaceC9228a> copyOnWriteArrayList = this.f337447c;
        if (copyOnWriteArrayList == null) {
            return;
        }
        Iterator<InterfaceC9228a> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        CopyOnWriteArrayList<InterfaceC9228a> copyOnWriteArrayList = this.f337447c;
        if (copyOnWriteArrayList == null) {
            return;
        }
        Iterator<InterfaceC9228a> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().onAnimationStart(this);
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        CopyOnWriteArrayList<InterfaceC9228a> copyOnWriteArrayList = this.f337447c;
        if (copyOnWriteArrayList == null) {
            return;
        }
        Iterator<InterfaceC9228a> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    public void a(InterfaceC9228a interfaceC9228a) {
        if (this.f337447c == null) {
            this.f337447c = new CopyOnWriteArrayList<>();
        }
        this.f337447c.add(interfaceC9228a);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z16) {
        onAnimationEnd(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z16) {
        onAnimationStart(animator);
    }
}
