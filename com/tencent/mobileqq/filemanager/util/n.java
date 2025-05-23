package com.tencent.mobileqq.filemanager.util;

import android.view.View;
import android.view.animation.Animation;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class n implements Animation.AnimationListener {
    public static int C;

    /* renamed from: m, reason: collision with root package name */
    public static int f209390m;

    /* renamed from: e, reason: collision with root package name */
    List<a> f209392e;

    /* renamed from: f, reason: collision with root package name */
    View f209393f;

    /* renamed from: i, reason: collision with root package name */
    a f209395i;

    /* renamed from: d, reason: collision with root package name */
    int[] f209391d = new int[1];

    /* renamed from: h, reason: collision with root package name */
    boolean f209394h = false;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Object f209396a;

        /* renamed from: b, reason: collision with root package name */
        public int f209397b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f209398c;

        /* renamed from: d, reason: collision with root package name */
        public int f209399d;
    }

    public n(View view) {
        this.f209393f = view;
    }

    private void b(a aVar) {
        this.f209395i = aVar;
        Animation animation = (Animation) aVar.f209396a;
        animation.setDuration(aVar.f209399d);
        animation.setAnimationListener(this);
    }

    public void a(a aVar) {
        if (this.f209392e == null) {
            this.f209392e = new ArrayList();
        }
        synchronized (this.f209391d) {
            this.f209392e.add(aVar);
        }
        b(aVar);
    }

    public void c() {
        synchronized (this.f209391d) {
            this.f209392e.clear();
        }
        this.f209393f.clearAnimation();
    }

    public void d() {
        a aVar;
        if (this.f209394h || this.f209392e.size() == 0) {
            return;
        }
        synchronized (this.f209391d) {
            aVar = this.f209392e.get(0);
            this.f209392e.remove(0);
        }
        if (aVar == null) {
            return;
        }
        if (aVar.f209398c && this.f209393f.getVisibility() == 0) {
            return;
        }
        if (!aVar.f209398c && (this.f209393f.getVisibility() == 8 || this.f209393f.getVisibility() == 4)) {
            return;
        }
        this.f209393f.setAnimation((Animation) aVar.f209396a);
        this.f209393f.startAnimation((Animation) aVar.f209396a);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.f209395i.f209398c) {
            this.f209393f.setVisibility(0);
        } else {
            this.f209393f.setVisibility(8);
        }
        this.f209394h = false;
        d();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f209394h = true;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
