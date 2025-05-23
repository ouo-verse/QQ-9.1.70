package com.tencent.aelight.camera.ae.gif.preview;

import com.tencent.aekit.openrender.internal.Frame;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f65441a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f65442b = 0;

    /* renamed from: c, reason: collision with root package name */
    private qq.a f65443c = new qq.a();

    /* renamed from: d, reason: collision with root package name */
    private Frame f65444d = new Frame();

    /* renamed from: e, reason: collision with root package name */
    private boolean f65445e = true;

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.gif.preview.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public interface InterfaceC0565a {
    }

    public void a() {
        this.f65443c.clearGLSL();
        this.f65444d.clear();
    }

    public void b() {
        this.f65443c.apply();
    }

    public void c(int i3, int i16) {
        this.f65441a = i3;
        this.f65442b = i16;
    }

    public Frame d(Frame frame, int i3, int i16) {
        if (!this.f65445e) {
            return frame;
        }
        this.f65443c.a(frame, i3, i16, this.f65444d);
        return this.f65444d;
    }

    public void f(boolean z16) {
        this.f65445e = z16;
    }

    public void e(InterfaceC0565a interfaceC0565a) {
    }
}
