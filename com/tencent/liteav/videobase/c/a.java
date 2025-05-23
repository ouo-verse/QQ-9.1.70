package com.tencent.liteav.videobase.c;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends e {

    /* renamed from: k, reason: collision with root package name */
    private static final float[] f119264k = {1.1644f, 1.1644f, 1.1644f, 0.0f, -0.3918f, 2.0172f, 1.596f, -0.813f, 0.0f};

    /* renamed from: l, reason: collision with root package name */
    private static final float[] f119265l = {1.0f, 1.0f, 1.0f, 0.0f, -0.3441f, 1.772f, 1.402f, -0.7141f, 0.0f};

    /* renamed from: m, reason: collision with root package name */
    private static final float[] f119266m = {1.1644f, 1.1644f, 1.1644f, 0.0f, -0.2132f, 2.1124f, 1.7927f, -0.5329f, 0.0f};

    /* renamed from: n, reason: collision with root package name */
    private static final float[] f119267n = {1.0f, 1.0f, 1.0f, 0.0f, -0.1873f, 1.8556f, 1.5748f, -0.4681f, 0.0f};

    /* renamed from: o, reason: collision with root package name */
    private static final float[] f119268o = {-0.0627451f, -0.5019608f, -0.5019608f};

    /* renamed from: p, reason: collision with root package name */
    private static final float[] f119269p = {0.0f, -0.5019608f, -0.5019608f};

    /* renamed from: q, reason: collision with root package name */
    private int f119270q;

    /* renamed from: r, reason: collision with root package name */
    private int f119271r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.liteav.videobase.c.a$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119272a;

        static {
            int[] iArr = new int[GLConstants.ColorRange.values().length];
            f119272a = iArr;
            try {
                iArr[GLConstants.ColorRange.FULL_RANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119272a[GLConstants.ColorRange.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f119272a[GLConstants.ColorRange.VIDEO_RANGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public a(GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform mat4 textureTransform;\nvarying highp vec2 textureCoordinate;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D uvTexture;\nuniform mat3 convertMatrix;\nuniform vec3 offset;\n\nvoid main()\n{\n    highp vec3 yuvColor;\n    highp vec3 rgbColor;\n\n    // Get the YUV values\n    yuvColor.x = texture2D(inputImageTexture, textureCoordinate).r;\n    yuvColor.y = texture2D(uvTexture, vec2(textureCoordinate.x, textureCoordinate.y * 0.5)).r;\n    yuvColor.z = texture2D(uvTexture, vec2(textureCoordinate.x, textureCoordinate.y * 0.5 + 0.5)).r;\n\n    // Do the color transform\n    yuvColor += offset;\n    rgbColor = convertMatrix * yuvColor;\n\n    gl_FragColor = vec4(rgbColor, 1.0);\n}", colorRange, colorSpace);
    }

    @Override // com.tencent.liteav.videobase.c.e, com.tencent.liteav.videobase.a.a
    public final void a(com.tencent.liteav.videobase.frame.e eVar) {
        super.a(eVar);
        this.f119270q = GLES20.glGetUniformLocation(this.f119210g, "convertMatrix");
        this.f119271r = GLES20.glGetUniformLocation(this.f119210g, "offset");
        Runnable a16 = b.a(this);
        com.tencent.liteav.videobase.utils.a aVar = this.f119204a;
        synchronized (aVar.f119370a) {
            aVar.f119370a.add(a16);
        }
    }

    @Override // com.tencent.liteav.videobase.c.e
    protected final int e() {
        return MonetPacketDescriptor.MonetDataFormat.R8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar) {
        float[] fArr;
        float[] fArr2;
        GLES20.glUseProgram(aVar.f119210g);
        int i3 = aVar.f119271r;
        if (AnonymousClass1.f119272a[aVar.f119275j.ordinal()] != 1) {
            fArr = f119268o;
        } else {
            fArr = f119269p;
        }
        GLES20.glUniform3fv(i3, 1, fArr, 0);
        int i16 = aVar.f119270q;
        GLConstants.ColorSpace colorSpace = aVar.f119274i;
        if (colorSpace == null || colorSpace == GLConstants.ColorSpace.UNKNOWN) {
            colorSpace = GLConstants.ColorSpace.BT601;
        }
        GLConstants.ColorRange colorRange = aVar.f119275j;
        if (colorRange == null || colorRange == GLConstants.ColorRange.UNKNOWN) {
            colorRange = GLConstants.ColorRange.VIDEO_RANGE;
        }
        if (colorSpace == GLConstants.ColorSpace.BT601) {
            if (colorRange != GLConstants.ColorRange.VIDEO_RANGE && colorRange == GLConstants.ColorRange.FULL_RANGE) {
                fArr2 = f119265l;
            }
            fArr2 = f119264k;
        } else {
            if (colorSpace == GLConstants.ColorSpace.BT709) {
                if (colorRange == GLConstants.ColorRange.VIDEO_RANGE) {
                    fArr2 = f119266m;
                } else if (colorRange == GLConstants.ColorRange.FULL_RANGE) {
                    fArr2 = f119267n;
                }
            }
            fArr2 = f119264k;
        }
        GLES20.glUniformMatrix3fv(i16, 1, false, fArr2, 0);
    }
}
