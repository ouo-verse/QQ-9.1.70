package com.tencent.liteav.videobase.c;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class e extends com.tencent.liteav.videobase.a.a {

    /* renamed from: i, reason: collision with root package name */
    protected final GLConstants.ColorSpace f119274i;

    /* renamed from: j, reason: collision with root package name */
    protected final GLConstants.ColorRange f119275j;

    /* renamed from: k, reason: collision with root package name */
    private int f119276k;

    /* renamed from: l, reason: collision with root package name */
    private final int[] f119277l;

    /* renamed from: m, reason: collision with root package name */
    private int f119278m;

    /* renamed from: n, reason: collision with root package name */
    private int f119279n;

    public e(String str, String str2, GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        super(str, str2);
        int[] iArr = new int[2];
        this.f119277l = iArr;
        this.f119278m = 0;
        this.f119279n = 0;
        Arrays.fill(iArr, -1);
        this.f119274i = colorSpace == GLConstants.ColorSpace.UNKNOWN ? GLConstants.ColorSpace.BT601 : colorSpace;
        this.f119275j = colorRange == GLConstants.ColorRange.UNKNOWN ? GLConstants.ColorRange.VIDEO_RANGE : colorRange;
    }

    private void f() {
        int i3 = 0;
        while (true) {
            int[] iArr = this.f119277l;
            if (i3 < iArr.length) {
                OpenGlUtils.deleteTexture(iArr[i3]);
                this.f119277l[i3] = -1;
                i3++;
            } else {
                return;
            }
        }
    }

    public final void a(ByteBuffer byteBuffer, int i3, int i16) {
        if (this.f119278m != i3 || this.f119279n != i16) {
            f();
            this.f119278m = i3;
            this.f119279n = i16;
        }
        OpenGlUtils.loadYuv420DataToTextures(byteBuffer, e(), i3, i16, this.f119277l);
    }

    @Override // com.tencent.liteav.videobase.a.a
    public final void d() {
        f();
        super.d();
    }

    protected abstract int e();

    @Override // com.tencent.liteav.videobase.a.a
    public void a(com.tencent.liteav.videobase.frame.e eVar) {
        super.a(eVar);
        this.f119276k = GLES20.glGetUniformLocation(this.f119210g, "uvTexture");
    }

    public e(String str, String str2) {
        this(str, str2, GLConstants.ColorRange.VIDEO_RANGE, GLConstants.ColorSpace.BT601);
    }

    @Override // com.tencent.liteav.videobase.a.a
    public final void a(int i3, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.a(this.f119277l[0], dVar, floatBuffer, floatBuffer2);
    }

    @Override // com.tencent.liteav.videobase.a.a
    public final void a(int i3) {
        super.a(i3);
        GLES20.glActiveTexture(33985);
        OpenGlUtils.bindTexture(b(), this.f119277l[1]);
        GLES20.glUniform1i(this.f119276k, 1);
    }
}
