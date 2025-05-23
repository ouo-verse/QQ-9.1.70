package com.tencent.liteav.videobase.frame;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static final float[] f119354a = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: b, reason: collision with root package name */
    private static final float[] f119355b = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: c, reason: collision with root package name */
    private static final float[] f119356c = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: d, reason: collision with root package name */
    private static final float[] f119357d = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: e, reason: collision with root package name */
    private int f119358e;

    /* renamed from: f, reason: collision with root package name */
    private int f119359f;

    /* renamed from: g, reason: collision with root package name */
    private final FloatBuffer f119360g;

    /* renamed from: h, reason: collision with root package name */
    private final FloatBuffer f119361h;

    /* renamed from: j, reason: collision with root package name */
    private GLConstants.GLScaleType f119363j;

    /* renamed from: n, reason: collision with root package name */
    private c f119367n;

    /* renamed from: i, reason: collision with root package name */
    private final com.tencent.liteav.videobase.a.a[] f119362i = new com.tencent.liteav.videobase.a.a[GLConstants.PixelFormatType.values().length];

    /* renamed from: k, reason: collision with root package name */
    private PixelFrame f119364k = null;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.liteav.videobase.b.a f119365l = null;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.liteav.videobase.a.a f119366m = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.liteav.videobase.frame.h$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119368a;

        static {
            int[] iArr = new int[k.values().length];
            f119368a = iArr;
            try {
                iArr[k.ROTATION_90.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119368a[k.ROTATION_180.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f119368a[k.ROTATION_270.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f119368a[k.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public h(int i3, int i16) {
        this.f119358e = i3;
        this.f119359f = i16;
        float[] fArr = GLConstants.f119222d;
        this.f119360g = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        this.f119361h = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);
    }

    private static float a(float f16) {
        return f16 == 0.0f ? 1.0f : 0.0f;
    }

    private void b() {
        boolean z16;
        float f16;
        float f17;
        PixelFrame pixelFrame = this.f119364k;
        if (pixelFrame == null) {
            return;
        }
        if (pixelFrame.getRotation() != k.ROTATION_90 && this.f119364k.getRotation() != k.ROTATION_270) {
            z16 = false;
        } else {
            z16 = true;
        }
        float max = Math.max((this.f119358e * 1.0f) / this.f119364k.getWidth(), (this.f119359f * 1.0f) / this.f119364k.getHeight());
        float round = (Math.round(r2 * max) * 1.0f) / this.f119358e;
        float round2 = (Math.round(r5 * max) * 1.0f) / this.f119359f;
        float[] fArr = GLConstants.f119222d;
        float[] fArr2 = new float[8];
        if (this.f119364k.getPixelBufferType() == GLConstants.a.TEXTURE_OES) {
            a(fArr2, this.f119364k.getRotation(), this.f119364k.isMirrorHorizontal(), this.f119364k.isMirrorVertical());
        } else {
            OpenGlUtils.initTextureCoordsBuffer(fArr2, this.f119364k.getRotation(), this.f119364k.isMirrorHorizontal(), this.f119364k.isMirrorVertical());
        }
        GLConstants.GLScaleType gLScaleType = this.f119363j;
        if (gLScaleType == GLConstants.GLScaleType.CENTER_CROP) {
            if (z16) {
                f16 = 1.0f / round2;
            } else {
                f16 = 1.0f / round;
            }
            float f18 = (1.0f - f16) / 2.0f;
            if (z16) {
                f17 = 1.0f / round;
            } else {
                f17 = 1.0f / round2;
            }
            float f19 = (1.0f - f17) / 2.0f;
            fArr2[0] = a(fArr2[0], f18);
            fArr2[1] = a(fArr2[1], f19);
            fArr2[2] = a(fArr2[2], f18);
            fArr2[3] = a(fArr2[3], f19);
            fArr2[4] = a(fArr2[4], f18);
            fArr2[5] = a(fArr2[5], f19);
            fArr2[6] = a(fArr2[6], f18);
            fArr2[7] = a(fArr2[7], f19);
        } else if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
            fArr = new float[]{fArr[0] / round2, fArr[1] / round, fArr[2] / round2, fArr[3] / round, fArr[4] / round2, fArr[5] / round, fArr[6] / round2, fArr[7] / round};
        }
        this.f119360g.clear();
        this.f119360g.put(fArr).position(0);
        this.f119361h.clear();
        this.f119361h.put(fArr2).position(0);
    }

    private void c() {
        if (this.f119366m != null) {
            return;
        }
        com.tencent.liteav.videobase.a.a aVar = new com.tencent.liteav.videobase.a.a();
        this.f119366m = aVar;
        aVar.a();
    }

    private void d() {
        com.tencent.liteav.videobase.b.a aVar = this.f119365l;
        if (aVar != null) {
            aVar.c();
            this.f119365l = null;
        }
        com.tencent.liteav.videobase.a.a aVar2 = this.f119366m;
        if (aVar2 != null) {
            aVar2.c();
            this.f119366m = null;
        }
        c cVar = this.f119367n;
        if (cVar != null) {
            cVar.d();
            this.f119367n = null;
        }
        int i3 = 0;
        while (true) {
            com.tencent.liteav.videobase.a.a[] aVarArr = this.f119362i;
            if (i3 < aVarArr.length) {
                com.tencent.liteav.videobase.a.a aVar3 = aVarArr[i3];
                if (aVar3 != null) {
                    aVar3.c();
                    this.f119362i[i3] = null;
                }
                i3++;
            } else {
                LiteavLog.i("PixelFrameRenderer", "uninitialize GL components");
                return;
            }
        }
    }

    private static float a(float f16, float f17) {
        return f16 == 0.0f ? f17 : 1.0f - f17;
    }

    public final void a(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType, d dVar) {
        if (pixelFrame != null && pixelFrame.isFrameDataValid()) {
            if (this.f119364k == null || a(pixelFrame, gLScaleType)) {
                this.f119363j = gLScaleType;
                this.f119364k = new PixelFrame(pixelFrame);
                d();
                b();
            }
            if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
                a(dVar);
            }
            if (this.f119364k.getPixelBufferType() == GLConstants.a.BYTE_BUFFER) {
                if (this.f119364k.getPixelFormatType() != GLConstants.PixelFormatType.RGBA) {
                    a(this.f119364k.getPixelFormatType(), dVar, pixelFrame.getBuffer(), pixelFrame.getColorRange(), pixelFrame.getColorSpace());
                    return;
                } else {
                    a(dVar, pixelFrame.getBuffer());
                    return;
                }
            }
            if (this.f119364k.getPixelBufferType() == GLConstants.a.BYTE_ARRAY) {
                if (this.f119364k.getPixelFormatType() != GLConstants.PixelFormatType.RGBA) {
                    a(this.f119364k.getPixelFormatType(), dVar, ByteBuffer.wrap(pixelFrame.getData()), pixelFrame.getColorRange(), pixelFrame.getColorSpace());
                    return;
                } else {
                    a(dVar, ByteBuffer.wrap(pixelFrame.getData()));
                    return;
                }
            }
            if (this.f119364k.getPixelBufferType() == GLConstants.a.TEXTURE_OES) {
                a(dVar, pixelFrame.getTextureId(), pixelFrame.getMatrix());
                return;
            } else {
                if (this.f119364k.getPixelBufferType() == GLConstants.a.TEXTURE_2D) {
                    a(dVar, pixelFrame.getTextureId());
                    return;
                }
                return;
            }
        }
        LiteavLog.w("PixelFrameRenderer", "renderFrame: pixelFrame is not valid");
    }

    public final void a() {
        this.f119364k = null;
        d();
    }

    private boolean a(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType) {
        return (gLScaleType == this.f119363j && pixelFrame.getWidth() == this.f119364k.getWidth() && pixelFrame.getHeight() == this.f119364k.getHeight() && pixelFrame.getPixelBufferType() == this.f119364k.getPixelBufferType() && pixelFrame.getPixelFormatType() == this.f119364k.getPixelFormatType() && pixelFrame.isMirrorHorizontal() == this.f119364k.isMirrorHorizontal() && pixelFrame.isMirrorVertical() == this.f119364k.isMirrorVertical() && pixelFrame.getRotation() == this.f119364k.getRotation()) ? false : true;
    }

    private void a(d dVar, Buffer buffer) {
        int ordinal = GLConstants.PixelFormatType.RGBA.ordinal();
        com.tencent.liteav.videobase.a.a[] aVarArr = this.f119362i;
        if (aVarArr[ordinal] == null) {
            aVarArr[ordinal] = new com.tencent.liteav.videobase.b.b();
            this.f119362i[ordinal].a();
        }
        com.tencent.liteav.videobase.b.b bVar = (com.tencent.liteav.videobase.b.b) this.f119362i[ordinal];
        bVar.a(this.f119358e, this.f119359f);
        OpenGlUtils.glViewport(0, 0, this.f119358e, this.f119359f);
        if (this.f119364k.getRotation() != k.ROTATION_90 && this.f119364k.getRotation() != k.ROTATION_270) {
            bVar.a(buffer, this.f119364k.getWidth(), this.f119364k.getHeight());
        } else {
            bVar.a(buffer, this.f119364k.getHeight(), this.f119364k.getWidth());
        }
        bVar.a(-1, dVar, this.f119360g, this.f119361h);
    }

    private void a(GLConstants.PixelFormatType pixelFormatType, d dVar, ByteBuffer byteBuffer, GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        int ordinal = pixelFormatType.ordinal();
        com.tencent.liteav.videobase.a.a[] aVarArr = this.f119362i;
        if (aVarArr[ordinal] == null) {
            if (pixelFormatType == GLConstants.PixelFormatType.I420) {
                aVarArr[ordinal] = new com.tencent.liteav.videobase.c.a(colorRange, colorSpace);
            } else if (pixelFormatType == GLConstants.PixelFormatType.NV21) {
                aVarArr[ordinal] = new com.tencent.liteav.videobase.c.d();
            } else {
                aVarArr[ordinal] = new com.tencent.liteav.videobase.c.c();
            }
            this.f119362i[ordinal].a();
        }
        com.tencent.liteav.videobase.c.e eVar = (com.tencent.liteav.videobase.c.e) this.f119362i[ordinal];
        eVar.a(this.f119358e, this.f119359f);
        OpenGlUtils.glViewport(0, 0, this.f119358e, this.f119359f);
        if (this.f119364k.getRotation() != k.ROTATION_90 && this.f119364k.getRotation() != k.ROTATION_270) {
            eVar.a(byteBuffer, this.f119364k.getWidth(), this.f119364k.getHeight());
        } else {
            eVar.a(byteBuffer, this.f119364k.getHeight(), this.f119364k.getWidth());
        }
        eVar.a(-1, dVar, this.f119360g, this.f119361h);
    }

    private void a(d dVar, int i3, float[] fArr) {
        if (this.f119365l == null) {
            com.tencent.liteav.videobase.b.a aVar = new com.tencent.liteav.videobase.b.a();
            this.f119365l = aVar;
            aVar.a();
        }
        OpenGlUtils.glViewport(0, 0, this.f119358e, this.f119359f);
        com.tencent.liteav.videobase.b.a aVar2 = this.f119365l;
        aVar2.f119211h = fArr;
        aVar2.a(this.f119358e, this.f119359f);
        this.f119365l.a(i3, dVar, this.f119360g, this.f119361h);
    }

    private void a(d dVar, int i3) {
        c();
        OpenGlUtils.glViewport(0, 0, this.f119358e, this.f119359f);
        this.f119366m.a(this.f119358e, this.f119359f);
        this.f119366m.a(i3, dVar, this.f119360g, this.f119361h);
    }

    private void a(d dVar) {
        if (this.f119367n == null) {
            c cVar = new c();
            this.f119367n = cVar;
            cVar.a();
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        if (dVar == null) {
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glClear(16640);
            return;
        }
        this.f119367n.a(dVar.a());
        this.f119367n.b();
        GLES20.glClear(16640);
        OpenGlUtils.bindFramebuffer(36160, 0);
        this.f119367n.c();
    }

    private static void a(float[] fArr, k kVar, boolean z16, boolean z17) {
        float[] fArr2 = f119354a;
        if (kVar != null) {
            int i3 = AnonymousClass1.f119368a[kVar.ordinal()];
            if (i3 == 1) {
                fArr2 = f119355b;
            } else if (i3 == 2) {
                fArr2 = f119357d;
            } else if (i3 == 3) {
                fArr2 = f119356c;
            }
        }
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
        if (z16) {
            fArr[0] = a(fArr[0]);
            fArr[2] = a(fArr[2]);
            fArr[4] = a(fArr[4]);
            fArr[6] = a(fArr[6]);
        }
        if (z17) {
            fArr[1] = a(fArr[1]);
            fArr[3] = a(fArr[3]);
            fArr[5] = a(fArr[5]);
            fArr[7] = a(fArr[7]);
        }
    }
}
