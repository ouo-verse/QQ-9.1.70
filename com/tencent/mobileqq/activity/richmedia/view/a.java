package com.tencent.mobileqq.activity.richmedia.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.portal.l;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
@TargetApi(9)
/* loaded from: classes10.dex */
public class a {

    /* renamed from: q, reason: collision with root package name */
    public static final float[] f186085q;

    /* renamed from: r, reason: collision with root package name */
    public static final float[] f186086r;

    /* renamed from: s, reason: collision with root package name */
    private static final int f186087s;

    /* renamed from: t, reason: collision with root package name */
    private static final FloatBuffer f186088t;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f186089u;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f186090v;

    /* renamed from: d, reason: collision with root package name */
    private int f186094d;

    /* renamed from: e, reason: collision with root package name */
    private int f186095e;

    /* renamed from: f, reason: collision with root package name */
    private int f186096f;

    /* renamed from: g, reason: collision with root package name */
    private int f186097g;

    /* renamed from: h, reason: collision with root package name */
    private int f186098h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f186099i;

    /* renamed from: j, reason: collision with root package name */
    public l f186100j;

    /* renamed from: k, reason: collision with root package name */
    private Context f186101k;

    /* renamed from: l, reason: collision with root package name */
    int f186102l;

    /* renamed from: a, reason: collision with root package name */
    private int[] f186091a = new int[3];

    /* renamed from: b, reason: collision with root package name */
    private int[] f186092b = new int[1];

    /* renamed from: c, reason: collision with root package name */
    public int f186093c = 0;

    /* renamed from: m, reason: collision with root package name */
    public ByteBuffer f186103m = null;

    /* renamed from: n, reason: collision with root package name */
    public ByteBuffer f186104n = null;

    /* renamed from: o, reason: collision with root package name */
    public ByteBuffer f186105o = null;

    /* renamed from: p, reason: collision with root package name */
    public boolean f186106p = false;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.richmedia.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C7206a {
        public static ByteBuffer a(int i3, int i16) {
            ByteBuffer byteBuffer = null;
            try {
                if (a.f186090v) {
                    ByteBuffer allocate = CameraGLSurfaceView.allocate(i3, i16);
                    a.f186089u = true;
                    byteBuffer = allocate;
                }
            } catch (UnsatisfiedLinkError unused) {
            }
            if (byteBuffer == null) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i16);
                a.f186089u = false;
                return allocateDirect;
            }
            return byteBuffer;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static int[] f186107a = new int[1];

        private static int a(int i3, String str) {
            int glCreateShader = GLES20.glCreateShader(i3);
            if (glCreateShader == 0) {
                a.a("glCreateShader:shader==0 type=" + d(i3));
                return 0;
            }
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderiv(glCreateShader, 35713, f186107a, 0);
            if (f186107a[0] == 0) {
                String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
                GLES20.glDeleteShader(glCreateShader);
                a.a("glGetShaderiv:GL_COMPILE_STATUS error  loginfo=" + glGetShaderInfoLog);
                return 0;
            }
            return glCreateShader;
        }

        public static int b() {
            return c("precision highp float;\nattribute vec4 position;\nattribute vec2 textureCoordinateIn;\nvarying   vec2 texturecoordinateOut;\nvoid main()\n{\ntexturecoordinateOut = textureCoordinateIn;\ngl_Position = position;\n}\n", "precision mediump float;varying   vec2 texturecoordinateOut;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nvoid main()\n{\nvec3 yuv;\nvec3 rgb;\nvec4 rgba;\nyuv.x = texture2D(SamplerY, texturecoordinateOut).r;\nyuv.y = texture2D(SamplerU, texturecoordinateOut).r-0.5;\nyuv.z = texture2D(SamplerV, texturecoordinateOut).r-0.5;\nrgb = mat3(      1,       1,      1,\n0,         -.34414, 1.772,\n1.402,     -.71414, 0) * yuv;\nrgba = vec4(rgb, 1);\ngl_FragColor = rgba;\n}\n");
        }

        public static int c(String str, String str2) {
            int a16 = a(35633, str);
            int a17 = a(35632, str2);
            if (a16 != 0 && a17 != 0) {
                int e16 = e(a16, a17);
                if (e16 == 0) {
                    GLES20.glDeleteShader(a16);
                    GLES20.glDeleteShader(a17);
                    return 0;
                }
                return e16;
            }
            a.a("compileShader:vertext or fragment == 0");
            return 0;
        }

        private static String d(int i3) {
            if (i3 == 35633) {
                return "GL_VERTEX_SHADER";
            }
            if (i3 == 35632) {
                return "GL_FRAGMENT_SHADER";
            }
            return "unKnown";
        }

        private static int e(int i3, int i16) {
            int glCreateProgram = GLES20.glCreateProgram();
            if (glCreateProgram == 0) {
                a.a("glCreateProgram:program == 0");
                return 0;
            }
            GLES20.glAttachShader(glCreateProgram, i3);
            GLES20.glAttachShader(glCreateProgram, i16);
            GLES20.glLinkProgram(glCreateProgram);
            GLES20.glGetProgramiv(glCreateProgram, 35714, f186107a, 0);
            if (f186107a[0] == 0) {
                String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
                GLES20.glDeleteProgram(glCreateProgram);
                a.a("linkProgram:GL_COMPILE_STATUS errorinfo =" + glGetProgramInfoLog);
                return 0;
            }
            return glCreateProgram;
        }
    }

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};
        f186085q = fArr;
        float[] fArr2 = {0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};
        f186086r = fArr2;
        int length = (fArr.length * 4) + (fArr2.length * 4);
        f186087s = length;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(length * 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        f186088t = asFloatBuffer;
        asFloatBuffer.limit(asFloatBuffer.capacity());
        asFloatBuffer.position(0);
        asFloatBuffer.put(fArr);
        asFloatBuffer.put(fArr2);
        f186089u = false;
        f186090v = false;
    }

    public static void a(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("GLSurfaceUtil", 2, str);
        }
    }

    public static void e(int[] iArr, int i3, int i16) {
        FloatBuffer floatBuffer = f186088t;
        floatBuffer.position(0);
        GLES20.glGenBuffers(1, iArr, 0);
        GLES20.glBindBuffer(34962, iArr[0]);
        GLES20.glBufferData(34962, f186087s, floatBuffer, 35044);
        GLES20.glVertexAttribPointer(i3, 2, 5126, false, 0, 0);
        GLES20.glEnableVertexAttribArray(i3);
        GLES20.glVertexAttribPointer(i16, 2, 5126, false, 0, f186085q.length * 4);
        GLES20.glEnableVertexAttribArray(i16);
    }

    public static String i(int i3) {
        if (i3 != 0) {
            if (i3 != 1285) {
                if (i3 != 1286) {
                    switch (i3) {
                        case 1280:
                            return "GL_INVALID_ENUM";
                        case 1281:
                            return "GL_INVALID_VALUE";
                        case 1282:
                            return "GL_INVALID_OPERATION";
                        default:
                            return "Unknow error";
                    }
                }
                return "GL_INVALID_FRAMEBUFFER_OPERATION";
            }
            return "GL_OUT_OF_MEMORY";
        }
        return "GL_NO_ERROR";
    }

    private void j() {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f186091a[0]);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        GLES20.glPixelStorei(3317, 1);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f186091a[1]);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        GLES20.glPixelStorei(3317, 1);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f186091a[2]);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        GLES20.glPixelStorei(3317, 1);
    }

    private void k() {
        Bitmap bitmap;
        GLES20.glUseProgram(this.f186093c);
        this.f186094d = GLES20.glGetUniformLocation(this.f186093c, "SamplerY");
        this.f186095e = GLES20.glGetUniformLocation(this.f186093c, "SamplerU");
        this.f186096f = GLES20.glGetUniformLocation(this.f186093c, "SamplerV");
        this.f186097g = GLES20.glGetAttribLocation(this.f186093c, "position");
        this.f186098h = GLES20.glGetAttribLocation(this.f186093c, "textureCoordinateIn");
        if (this.f186099i) {
            this.f186100j.f259387d.put("percent1", Integer.valueOf(GLES20.glGetUniformLocation(this.f186093c, "percent1")));
            this.f186100j.f259387d.put("percent2", Integer.valueOf(GLES20.glGetUniformLocation(this.f186093c, "percent2")));
            this.f186100j.f259387d.put("percent3", Integer.valueOf(GLES20.glGetUniformLocation(this.f186093c, "percent3")));
            this.f186100j.f259387d.put("percent4", Integer.valueOf(GLES20.glGetUniformLocation(this.f186093c, "percent4")));
            this.f186100j.f259387d.put("percent5", Integer.valueOf(GLES20.glGetUniformLocation(this.f186093c, "percent5")));
            this.f186100j.f259387d.put("percent6", Integer.valueOf(GLES20.glGetUniformLocation(this.f186093c, "percent6")));
            this.f186100j.f259387d.put("percent7", Integer.valueOf(GLES20.glGetUniformLocation(this.f186093c, "percent7")));
            this.f186100j.f259387d.put(CustomImageProps.QUALITY, Integer.valueOf(GLES20.glGetUniformLocation(this.f186093c, CustomImageProps.QUALITY)));
            this.f186100j.f259387d.put("add_red", Integer.valueOf(GLES20.glGetUniformLocation(this.f186093c, "add_red")));
            this.f186100j.f259387d.put("red_m", Integer.valueOf(GLES20.glGetUniformLocation(this.f186093c, "red_m")));
            this.f186100j.f259387d.put("green_m", Integer.valueOf(GLES20.glGetUniformLocation(this.f186093c, "green_m")));
            this.f186100j.f259387d.put("blue_m", Integer.valueOf(GLES20.glGetUniformLocation(this.f186093c, "blue_m")));
            this.f186100j.f259387d.put("inputImageTexture2", Integer.valueOf(GLES20.glGetUniformLocation(this.f186093c, "inputImageTexture2")));
            try {
                bitmap = BitmapFactory.decodeResource(this.f186101k.getResources(), R.drawable.eu_);
            } catch (OutOfMemoryError unused) {
                QLog.i("GLSurfaceUtil", 2, "decode hongbao filter mask oom!");
                bitmap = null;
            }
            if (bitmap != null) {
                int[] iArr = new int[1];
                GLES20.glGenTextures(1, iArr, 0);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
                GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
                this.f186102l = iArr[0];
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
            }
        }
    }

    public boolean b(Context context) {
        this.f186101k = context;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        if (this.f186099i) {
            this.f186100j = new l();
            this.f186093c = b.c("precision highp float;\nattribute vec4 position;\nattribute vec2 textureCoordinateIn;\nvarying   vec2 texturecoordinateOut;\nvoid main()\n{\ntexturecoordinateOut = textureCoordinateIn;\ngl_Position = position;\n}\n", "precision mediump float;\nvarying   vec2 texturecoordinateOut;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nuniform float percent1;\nuniform float percent2;\nuniform float percent3;\nuniform float percent4;\nuniform float percent5;\nuniform float percent6;\nuniform float percent7;\nuniform sampler2D inputImageTexture2;\nuniform float quality;\nuniform float add_red;\nuniform float red_m;\nuniform float green_m;\nuniform float blue_m;\nfloat percent_value(float min_percent, float percent)\n{\nfloat result_percent = 0.0;\nif(percent > 0.0)\nresult_percent = min(min_percent, percent);\nelse\nresult_percent = max(min_percent - 1.0, percent);\nreturn result_percent;\n}\nvoid main()\n{\nvec3 yuv;\nvec3 rgb;\nvec4 rgba;\nyuv.x = texture2D(SamplerY, texturecoordinateOut).r;\nyuv.y = texture2D(SamplerU, texturecoordinateOut).r-0.5;\nyuv.z = texture2D(SamplerV, texturecoordinateOut).r-0.5;\nrgb = mat3(      1,       1,      1,\n0,         -.34414, 1.772,\n1.402,     -.71414, 0) * yuv;\nfloat r = rgb.r;\nfloat g = rgb.g;\nfloat b = rgb.b;\nfloat max_c = max(r, max(g, b));\nfloat min_c = min(r, min(g, b));\nfloat median = r + g + b - max_c - min_c;\nfloat amount = max_c - median;\nfloat amount2 = median - min_c;\nfloat min_percent_r = 1.0 - r;\nfloat min_percent_g = 1.0 - g;\nfloat min_percent_b = 1.0 - b;\nfloat p;\nfloat gray = dot(rgb, vec3(0.299, 0.587, 0.114));\nfloat tmp_r = r;\nfloat tmp_g = g;\nfloat tmp_b = b;\nif(tmp_r == max_c) //red\n{\nfloat tmp_percent7 = percent7 * (1.0 - gray);\np = percent_value(min_percent_r, percent1 + tmp_percent7);\nr = r + amount * p;\np = percent_value(min_percent_g, percent4 + tmp_percent7);\ng = g + amount * p;\np = percent_value(min_percent_b, percent6 + tmp_percent7);\nb = b + amount * p;\n}\nif(tmp_b == max_c) //blue\n{\np = percent_value(min_percent_r, percent3);\nr = r + amount * p;\n}\nif(tmp_b == min_c) //yellow\n{\np = percent_value(min_percent_b, percent2);\nb = b + amount2 * p;\np = percent_value(min_percent_g, percent5);\ng = g + amount2 * p;\n}\nlowp vec4 color;\ncolor = vec4(r, g, b, 1.0);\ncolor *= quality;\nlowp vec4 newColor;\nnewColor = color;\nif(newColor.r > newColor.g && newColor.r > newColor.b)\n{\nnewColor.r *= 1.0 - red_m * add_red;\nnewColor.g *= 1.0 - green_m * add_red;\nnewColor.b *= 1.0 - blue_m * add_red;\n}\nnewColor.r = texture2D(inputImageTexture2, vec2(newColor.r,0.5)).r;\nnewColor.g = texture2D(inputImageTexture2, vec2(newColor.g,0.5)).g;\nnewColor.b = texture2D(inputImageTexture2, vec2(newColor.b,0.5)).b;\nnewColor.a = 1.0;\ngl_FragColor = newColor;\n}\n");
        } else {
            this.f186093c = b.b();
        }
        if (this.f186093c == 0) {
            CameraGLSurfaceView.e("GLVideoHelper.createShaderProgram: mGLProgram=" + this.f186093c);
            return false;
        }
        k();
        e(this.f186092b, this.f186097g, this.f186098h);
        int[] iArr = this.f186091a;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        j();
        return true;
    }

    public void c(int i3, int i16) {
        int i17 = i3 * i16;
        ByteBuffer byteBuffer = this.f186103m;
        if (byteBuffer == null || byteBuffer.capacity() < i17) {
            this.f186103m = C7206a.a(0, i17);
        }
        int i18 = 0 + i17;
        int i19 = (i3 / 2) * (i16 / 2);
        ByteBuffer byteBuffer2 = this.f186104n;
        if (byteBuffer2 == null || byteBuffer2.capacity() < i19) {
            this.f186104n = C7206a.a(i18, i19);
        }
        int i26 = i18 + i19;
        ByteBuffer byteBuffer3 = this.f186105o;
        if (byteBuffer3 == null || byteBuffer3.capacity() < i19) {
            this.f186105o = C7206a.a(i26, i19);
        }
    }

    public int d(int i3, int i16, int i17, int i18, int i19, int i26, byte[] bArr) {
        int i27;
        int f16;
        boolean z16;
        try {
            f16 = f(i3, i18, i19);
            if (bArr != null && bArr.length > f16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && bArr.length == g(i18, i19)) {
                z16 = false;
            }
        } catch (UnsatisfiedLinkError unused) {
            i27 = 0;
        }
        if (z16) {
            a("handleMessage:byteBufferProcessFrame:[data length error]dataLenErr=" + z16 + " mPreviewWidth=" + i18 + " mPreviewWidth" + i18 + " mVideoFormat=" + i3);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleMessage:byteBufferProcessFrame:[data length error]dataLenErr=");
            sb5.append(z16);
            sb5.append(" totalSize=");
            sb5.append(f16);
            sb5.append(" data.length=");
            sb5.append(bArr.length);
            a(sb5.toString());
            return -1;
        }
        if (this.f186103m == null || !this.f186106p) {
            f186090v = false;
            try {
                CameraGLSurfaceView.initTotalBufferSize(i18, i19, i3);
                f186090v = true;
            } catch (UnsatisfiedLinkError unused2) {
                f186090v = false;
            }
            this.f186103m = null;
            this.f186104n = null;
            this.f186105o = null;
            c(i16, i17);
            this.f186106p = true;
        }
        i27 = CameraGLSurfaceView.processVideoFrame(bArr, i18, i19, i3, i26, false, this.f186103m, this.f186104n, this.f186105o, f186089u);
        ByteBuffer byteBuffer = this.f186103m;
        if (byteBuffer != null) {
            byteBuffer.position(0);
            this.f186104n.position(0);
            this.f186105o.position(0);
        } else {
            a("handleMessage:byteBufferProcessFrame:panelY=" + this.f186103m);
        }
        return i27;
    }

    public int f(int i3, int i16, int i17) {
        int bitsPerPixel = ImageFormat.getBitsPerPixel(i3);
        float f16 = (bitsPerPixel * 1.0f) / 8.0f;
        a("handleMessage:byteBufferProcessFrame:[getBufferSize]bitpixel=" + bitsPerPixel + " byteNum=" + f16);
        return (int) (i16 * i17 * f16);
    }

    public int g(int i3, int i16) {
        return ((i3 * i16) * 3) / 2;
    }

    public boolean h(boolean z16, int i3, int i16, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) {
        GLES20.glActiveTexture(33984);
        if (!z16) {
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.R8, i3, i16, 0, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        }
        GLES20.glTexSubImage2D(GLSLRender.GL_TEXTURE_2D, 0, 0, 0, i3, i16, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, byteBuffer);
        GLES20.glUniform1i(this.f186094d, 0);
        GLES20.glActiveTexture(33985);
        if (!z16) {
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.R8, i3 / 2, i16 / 2, 0, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        }
        int i17 = i3 / 2;
        int i18 = i16 / 2;
        GLES20.glTexSubImage2D(GLSLRender.GL_TEXTURE_2D, 0, 0, 0, i17, i18, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, byteBuffer2);
        boolean z17 = true;
        GLES20.glUniform1i(this.f186095e, 1);
        GLES20.glActiveTexture(33986);
        if (!z16) {
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.R8, i17, i18, 0, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        } else {
            z17 = z16;
        }
        GLES20.glTexSubImage2D(GLSLRender.GL_TEXTURE_2D, 0, 0, 0, i17, i18, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, byteBuffer3);
        GLES20.glUniform1i(this.f186096f, 2);
        if (this.f186099i) {
            this.f186100j.d(l.f259383h);
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f186102l);
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f186093c, "inputImageTexture2"), 3);
        }
        GLES20.glDrawArrays(6, 0, 4);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            a("glDrawFrame:err=" + glGetError + " errname=" + i(glGetError));
        }
        return z17;
    }
}
