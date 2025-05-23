package com.tencent.mtt.hippy.modules.nativemodules.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.tencent.mtt.hippy.modules.nativemodules.animation.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends a {

    /* renamed from: d, reason: collision with root package name */
    private final AnimatorSet f337452d;

    /* renamed from: e, reason: collision with root package name */
    private AnimatorSet.Builder f337453e;

    /* renamed from: f, reason: collision with root package name */
    private a f337454f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<Integer> f337455g;

    /* renamed from: h, reason: collision with root package name */
    private a f337456h;

    /* renamed from: i, reason: collision with root package name */
    private int f337457i;

    /* renamed from: j, reason: collision with root package name */
    private int f337458j;

    /* renamed from: k, reason: collision with root package name */
    private int f337459k;

    /* renamed from: l, reason: collision with root package name */
    private final a.InterfaceC9228a f337460l;

    public c(int i3) {
        super(i3);
        this.f337456h = null;
        this.f337457i = 0;
        this.f337458j = 0;
        this.f337459k = -1;
        this.f337460l = new a.InterfaceC9228a() { // from class: com.tencent.mtt.hippy.modules.nativemodules.animation.c.1
            @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a.InterfaceC9228a
            public void onAnimationUpdate(a aVar) {
                c.this.f337456h = aVar;
                CopyOnWriteArrayList<a.InterfaceC9228a> copyOnWriteArrayList = c.this.f337447c;
                if (copyOnWriteArrayList == null) {
                    return;
                }
                Iterator<a.InterfaceC9228a> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    it.next().onAnimationUpdate(c.this);
                }
            }

            @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a.InterfaceC9228a
            public void onAnimationCancel(a aVar) {
            }

            @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a.InterfaceC9228a
            public void onAnimationEnd(a aVar) {
            }

            @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a.InterfaceC9228a
            public void onAnimationRepeat(a aVar) {
            }

            @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a.InterfaceC9228a
            public void onAnimationStart(a aVar) {
            }
        };
        AnimatorSet animatorSet = new AnimatorSet();
        this.f337452d = animatorSet;
        animatorSet.addListener(this);
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a
    public Animator a() {
        return this.f337452d;
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a
    public void b() {
        int i3 = this.f337459k;
        if (i3 == -1 || i3 == 2) {
            this.f337458j = 0;
            this.f337459k = 0;
            this.f337452d.start();
        }
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a
    public void c() {
        int i3 = this.f337459k;
        this.f337459k = 2;
        if (!this.f337452d.isStarted() && i3 == 1) {
            onAnimationEnd(this.f337452d);
        }
        this.f337452d.cancel();
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a
    public Object f() {
        a aVar = this.f337456h;
        if (aVar != null) {
            return aVar.f();
        }
        return 0;
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a
    public Object g() {
        a aVar = this.f337456h;
        if (aVar != null) {
            return aVar.g();
        }
        return 0;
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a
    public void h() {
        AnimatorSet animatorSet = this.f337452d;
        if (animatorSet != null) {
            animatorSet.resume();
        }
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a
    public void i() {
        AnimatorSet animatorSet = this.f337452d;
        if (animatorSet != null) {
            animatorSet.pause();
        }
    }

    public ArrayList<Integer> j() {
        return this.f337455g;
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f337459k == 2) {
            super.onAnimationEnd(animator);
            return;
        }
        int i3 = this.f337457i;
        if (i3 != -1 && (i3 <= 0 || this.f337458j >= i3 - 1)) {
            this.f337459k = 2;
            super.onAnimationEnd(animator);
        } else {
            this.f337459k = 1;
            this.f337458j++;
            this.f337452d.start();
        }
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (this.f337459k < 1) {
            super.onAnimationStart(animator);
        } else {
            onAnimationRepeat(animator);
        }
    }

    public void c(int i3) {
        this.f337457i = i3;
        this.f337458j = 0;
    }

    public void a(a aVar, boolean z16) {
        AnimatorSet.Builder after;
        if (aVar == null || aVar.a() == null) {
            return;
        }
        aVar.a(this.f337460l);
        if (this.f337456h == null) {
            this.f337456h = aVar;
        }
        if (this.f337455g == null) {
            this.f337455g = new ArrayList<>();
        }
        this.f337455g.add(Integer.valueOf(aVar.d()));
        if (this.f337454f == null) {
            after = this.f337452d.play(aVar.a());
        } else {
            if (!z16) {
                this.f337453e.with(aVar.a());
                return;
            }
            after = this.f337452d.play(aVar.a()).after(this.f337454f.a());
        }
        this.f337453e = after;
        this.f337454f = aVar;
    }
}
