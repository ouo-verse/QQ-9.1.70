package com.tencent.luggage.wxa.l1;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(byte[] bArr, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.l1.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6416d {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e {
        void a();

        void a(Bitmap bitmap);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface f {
        void a(boolean z16);
    }

    int a();

    void a(float f16);

    void a(int i3);

    void a(int i3, int i16, int i17, int i18, int i19);

    void a(a aVar);

    void a(b bVar);

    void a(c cVar);

    void a(e eVar, boolean z16);

    void a(f fVar);

    void a(String str);

    void a(ByteBuffer byteBuffer, InterfaceC6416d interfaceC6416d);

    boolean a(boolean z16);

    void b();

    void b(int i3);

    void b(boolean z16);

    void c(int i3);

    void c(boolean z16);

    float[] c();

    View d();

    void d(int i3);

    void d(boolean z16);

    Point e();

    void f();

    void g();

    Bitmap h();

    void handlePluginTouch(MotionEvent motionEvent);

    String i();

    void j();

    void release();

    void setDisplayScreenSize(Size size);
}
