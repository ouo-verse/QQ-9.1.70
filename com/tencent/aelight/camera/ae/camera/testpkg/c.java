package com.tencent.aelight.camera.ae.camera.testpkg;

import android.graphics.SurfaceTexture;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends SurfaceTexture {

    /* renamed from: a, reason: collision with root package name */
    private int f62310a;

    /* renamed from: b, reason: collision with root package name */
    private SurfaceTexture.OnFrameAvailableListener f62311b;

    /* renamed from: c, reason: collision with root package name */
    private a f62312c;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void endRecord();

        void startRecord();
    }

    public c(int i3) {
        super(i3);
        this.f62310a = i3;
    }

    public SurfaceTexture.OnFrameAvailableListener a() {
        return this.f62311b;
    }

    public void b() {
        a aVar = this.f62312c;
        if (aVar != null) {
            aVar.endRecord();
        }
    }

    public void c() {
        a aVar = this.f62312c;
        if (aVar != null) {
            aVar.startRecord();
        }
    }

    public void d(a aVar) {
        this.f62312c = aVar;
    }

    @Override // android.graphics.SurfaceTexture
    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        super.setOnFrameAvailableListener(onFrameAvailableListener);
        this.f62311b = onFrameAvailableListener;
    }

    @Override // android.graphics.SurfaceTexture
    public void updateTexImage() {
        super.updateTexImage();
    }
}
