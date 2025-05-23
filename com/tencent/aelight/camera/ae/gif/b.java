package com.tencent.aelight.camera.ae.gif;

import com.tencent.aekit.openrender.internal.Frame;
import qq.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    public static final Integer f65334d = 480;

    /* renamed from: a, reason: collision with root package name */
    private e f65335a = new e();

    /* renamed from: b, reason: collision with root package name */
    private Frame f65336b = new Frame();

    /* renamed from: c, reason: collision with root package name */
    private boolean f65337c = true;

    public void a() {
        this.f65335a.clearGLSL();
        this.f65336b.clear();
    }

    public void b() {
        this.f65335a.apply();
    }

    public Frame c(Frame frame) {
        if (!this.f65337c) {
            return frame;
        }
        this.f65335a.a(frame, this.f65336b);
        return this.f65336b;
    }
}
