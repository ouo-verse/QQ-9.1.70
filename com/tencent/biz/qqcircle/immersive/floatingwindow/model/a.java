package com.tencent.biz.qqcircle.immersive.floatingwindow.model;

import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.mobileqq.app.FrameFragment;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<FrameFragment> f86400a;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<QCircleBaseFragment> f86402c;

    /* renamed from: d, reason: collision with root package name */
    private String f86403d;

    /* renamed from: b, reason: collision with root package name */
    private int f86401b = -1;

    /* renamed from: e, reason: collision with root package name */
    private int f86404e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f86405f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f86406g = false;

    public int a() {
        return this.f86404e;
    }

    public String b() {
        return this.f86403d;
    }

    public QCircleBaseFragment c() {
        WeakReference<QCircleBaseFragment> weakReference = this.f86402c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public FrameFragment d() {
        WeakReference<FrameFragment> weakReference = this.f86400a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int e() {
        return this.f86401b;
    }

    public boolean f() {
        return this.f86406g;
    }

    public boolean g() {
        return this.f86405f;
    }

    public void h(int i3) {
        this.f86404e = i3;
    }

    public void i(boolean z16) {
        this.f86406g = z16;
    }

    public void j(String str) {
        this.f86403d = str;
    }

    public void k(QCircleBaseFragment qCircleBaseFragment) {
        WeakReference<QCircleBaseFragment> weakReference;
        if (qCircleBaseFragment == null && (weakReference = this.f86402c) != null) {
            weakReference.clear();
        } else {
            this.f86402c = new WeakReference<>(qCircleBaseFragment);
        }
    }

    public void l(FrameFragment frameFragment) {
        WeakReference<FrameFragment> weakReference;
        if (frameFragment == null && (weakReference = this.f86400a) != null) {
            weakReference.clear();
        } else {
            this.f86400a = new WeakReference<>(frameFragment);
        }
    }

    public void m(int i3) {
        this.f86401b = i3;
    }

    public void n(boolean z16) {
        this.f86405f = z16;
    }
}
