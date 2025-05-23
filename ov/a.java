package ov;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface a {
    void a();

    void b(float f16, float f17, float f18, float f19, e eVar);

    void c(com.tencent.av.opengl.texture.a aVar, Bitmap bitmap);

    boolean d(com.tencent.av.opengl.texture.a aVar);

    void e(float f16, float f17, float f18);

    void f(int i3);

    void g(com.tencent.av.opengl.texture.a aVar, int i3, int i16, int i17, int i18);

    float getAlpha();

    int getHeight();

    int getWidth();

    void h();

    d i();

    void j(com.tencent.av.opengl.texture.a aVar, int i3, int i16, Bitmap bitmap, int i17, int i18);

    void k(float f16, float f17);

    void l(float f16, float f17, float f18, float f19, int i3);

    void m(float f16, float f17, float f18);

    void n(com.tencent.av.opengl.texture.a aVar);

    void o(com.tencent.av.opengl.texture.a aVar, int i3, int i16);

    void p(float f16, float f17, float f18, float f19);

    void restore();

    void save();

    void setAlpha(float f16);

    void setSize(int i3, int i16);
}
