package ov;

import android.opengl.GLES20;
import javax.microedition.khronos.opengles.GL11;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c implements d {
    @Override // ov.d
    public void a(GL11 gl11, int i3, int[] iArr, int i16) {
        GLES20.glDeleteTextures(i3, iArr, i16);
        tv.c.a();
    }

    @Override // ov.d
    public int b() {
        int[] iArr = {0};
        GLES20.glGenTextures(1, iArr, 0);
        tv.c.a();
        return iArr[0];
    }

    @Override // ov.d
    public void c(int i3, int[] iArr, int i16) {
        GLES20.glGenBuffers(i3, iArr, i16);
        tv.c.a();
    }

    @Override // ov.d
    public void d(GL11 gl11, int i3, int[] iArr, int i16) {
        GLES20.glDeleteBuffers(i3, iArr, i16);
        tv.c.a();
    }
}
