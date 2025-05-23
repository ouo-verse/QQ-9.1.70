package com.tencent.av.opengl.texture;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.utils.ax;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.util.AssertUtil;
import rv.e;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends e {

    /* renamed from: x, reason: collision with root package name */
    protected Bitmap f74106x;

    /* renamed from: y, reason: collision with root package name */
    private float f74107y = 0.0f;

    /* renamed from: z, reason: collision with root package name */
    private boolean f74108z = false;
    private final float[] A = {0.0f, 0.0f, 0.0f, 0.0f};

    public b(Bitmap bitmap) {
        boolean z16 = false;
        if (bitmap != null && !bitmap.isRecycled()) {
            z16 = true;
        }
        AssertUtil.assertTrue(z16);
        this.f74106x = bitmap;
    }

    @Override // rv.e
    protected Bitmap F() {
        return this.f74106x;
    }

    public void L(boolean z16) {
        if (z16 && ax.c()) {
            this.f74094c = 8;
            this.f74107y = ViewUtils.dpToPx(8.0f);
        } else {
            this.f74094c = 0;
            this.f74107y = 0.0f;
        }
    }

    public boolean M() {
        return this.f74108z;
    }

    public void N(int i3) {
        float[] fArr = this.A;
        fArr[0] = ((i3 >>> 16) & 255) / 255.0f;
        fArr[1] = ((i3 >>> 8) & 255) / 255.0f;
        fArr[2] = (i3 & 255) / 255.0f;
        fArr[3] = ((i3 >>> 24) & 255) / 255.0f;
    }

    public void O(boolean z16) {
        this.f74108z = z16;
    }

    @Override // rv.e, com.tencent.av.opengl.texture.a
    public qv.b[] s(ov.a aVar) {
        TextureProgram i3 = i();
        qv.b[] s16 = super.s(aVar);
        if (i3 instanceof pv.d) {
            GLES20.glUniform1f(s16[5].f429680a, this.f74102k);
            GLES20.glUniform1f(s16[6].f429680a, this.f74103l);
            GLES20.glUniform1f(s16[7].f429680a, this.f74107y);
            if (this.f74108z) {
                int i16 = s16[8].f429680a;
                float[] fArr = this.A;
                GLES20.glUniform4f(i16, fArr[0], fArr[1], fArr[2], fArr[3]);
            } else {
                GLES20.glUniform4f(s16[8].f429680a, 0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
        return s16;
    }

    @Override // rv.e
    protected void E(Bitmap bitmap) {
    }
}
