package fe0;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLES31;
import android.util.Log;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.biz.qui.quipolarlight.a;
import com.tencent.filter.GLSLRender;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    private static final String f398351i = "a";

    /* renamed from: a, reason: collision with root package name */
    private int f398352a;

    /* renamed from: b, reason: collision with root package name */
    private int f398353b;

    /* renamed from: c, reason: collision with root package name */
    private final int f398354c;

    /* renamed from: d, reason: collision with root package name */
    private int f398355d;

    /* renamed from: e, reason: collision with root package name */
    private IntBuffer f398356e;

    /* renamed from: f, reason: collision with root package name */
    private int f398357f;

    /* renamed from: g, reason: collision with root package name */
    private float[] f398358g = new float[5];

    /* renamed from: h, reason: collision with root package name */
    String f398359h = "#version 310 es\n\n// NUM_X * NUM_Y * NUM_Z threads per work group.\nlayout(local_size_x = 16, local_size_y = 16, local_size_z = 1) in;\n\nlayout(std430) buffer; // Sets the default layout for SSBOs.\nlayout(binding = 0) buffer SSBO {\n    int histogram[]; // This array can now be tightly packed.\n};\n\nuniform sampler2D sTexture;\nuniform float sTime;\nuniform int sColors[10];  // \u4e1a\u52a1\u4f20\u5165\u7684\u989c\u8272\u503c\uff0c\u6700\u591a\u652f\u6301\u5341\u4e2a\u989c\u8272\nuniform float sFrequency; // \u4e1a\u52a1\u4f20\u5165\u7684\u9897\u7c92\u5ea6\uff0c\u566a\u97f3\u56fe\u7684\u8fdc\u8fd1\nuniform float sGradient[5]; // \u4e1a\u52a1\u4f20\u5165\u7684\u900f\u660e\u5ea6\u6e10\u53d8\u53c2\u6570\n\nconst int PRIME_X = 501125321;\nconst int PRIME_Y = 1136930381;\nconst int PRIME_Z = 1720413743;\nconst int SEED_XZ = 1337;\n\nconst float GRADIENTS_3D[256] = float[256]\n(\n0.f, 1.f, 1.f, 0.f,  0.f,-1.f, 1.f, 0.f,  0.f, 1.f,-1.f, 0.f,  0.f,-1.f,-1.f, 0.f,\n1.f, 0.f, 1.f, 0.f, -1.f, 0.f, 1.f, 0.f,  1.f, 0.f,-1.f, 0.f, -1.f, 0.f,-1.f, 0.f,\n1.f, 1.f, 0.f, 0.f, -1.f, 1.f, 0.f, 0.f,  1.f,-1.f, 0.f, 0.f, -1.f,-1.f, 0.f, 0.f,\n0.f, 1.f, 1.f, 0.f,  0.f,-1.f, 1.f, 0.f,  0.f, 1.f,-1.f, 0.f,  0.f,-1.f,-1.f, 0.f,\n1.f, 0.f, 1.f, 0.f, -1.f, 0.f, 1.f, 0.f,  1.f, 0.f,-1.f, 0.f, -1.f, 0.f,-1.f, 0.f,\n1.f, 1.f, 0.f, 0.f, -1.f, 1.f, 0.f, 0.f,  1.f,-1.f, 0.f, 0.f, -1.f,-1.f, 0.f, 0.f,\n0.f, 1.f, 1.f, 0.f,  0.f,-1.f, 1.f, 0.f,  0.f, 1.f,-1.f, 0.f,  0.f,-1.f,-1.f, 0.f,\n1.f, 0.f, 1.f, 0.f, -1.f, 0.f, 1.f, 0.f,  1.f, 0.f,-1.f, 0.f, -1.f, 0.f,-1.f, 0.f,\n1.f, 1.f, 0.f, 0.f, -1.f, 1.f, 0.f, 0.f,  1.f,-1.f, 0.f, 0.f, -1.f,-1.f, 0.f, 0.f,\n0.f, 1.f, 1.f, 0.f,  0.f,-1.f, 1.f, 0.f,  0.f, 1.f,-1.f, 0.f,  0.f,-1.f,-1.f, 0.f,\n1.f, 0.f, 1.f, 0.f, -1.f, 0.f, 1.f, 0.f,  1.f, 0.f,-1.f, 0.f, -1.f, 0.f,-1.f, 0.f,\n1.f, 1.f, 0.f, 0.f, -1.f, 1.f, 0.f, 0.f,  1.f,-1.f, 0.f, 0.f, -1.f,-1.f, 0.f, 0.f,\n0.f, 1.f, 1.f, 0.f,  0.f,-1.f, 1.f, 0.f,  0.f, 1.f,-1.f, 0.f,  0.f,-1.f,-1.f, 0.f,\n1.f, 0.f, 1.f, 0.f, -1.f, 0.f, 1.f, 0.f,  1.f, 0.f,-1.f, 0.f, -1.f, 0.f,-1.f, 0.f,\n1.f, 1.f, 0.f, 0.f, -1.f, 1.f, 0.f, 0.f,  1.f,-1.f, 0.f, 0.f, -1.f,-1.f, 0.f, 0.f,\n1.f, 1.f, 0.f, 0.f,  0.f,-1.f, 1.f, 0.f, -1.f, 1.f, 0.f, 0.f,  0.f,-1.f,-1.f, 0.f\n);\n\n\nconst float GRADIENT[5] = float[5](0.5, 0.5, 0.5, 0.3, 0.0);\nint fnlFastFloor(float f) { return int(floor(f)); }\nfloat fnlInterpQuintic(float t) { return t * t * t * (t * (t * 6.f - 15.f) + 10.f); }\nfloat fnlLerp(float a, float b, float t) { return mix(a, b, t); }\nint fnlHash3D(int seed, int xPrimed, int yPrimed, int zPrimed)\n{\n    int hash = seed ^ xPrimed ^ yPrimed ^ zPrimed;\n    hash *= 0x27d4eb2d;\n    return hash;\n}\nfloat fnlGradCoord3D(int seed, int xPrimed, int yPrimed, int zPrimed, float xd, float yd, float zd)\n{\n    int hash = fnlHash3D(seed, xPrimed, yPrimed, zPrimed);\n    hash ^= hash >> 15;\n    hash &= 63 << 2;\n    return xd * GRADIENTS_3D[hash] + yd * GRADIENTS_3D[hash | 1] + zd * GRADIENTS_3D[hash | 2];\n}\nfloat fnlSinglePerlin3D(int seed, float x, float y, float z)\n{\n    int x0 = fnlFastFloor(x);\n    int y0 = fnlFastFloor(y);\n    int z0 = fnlFastFloor(z);\n\n    float xd0 = x - float(x0);\n    float yd0 = y - float(y0);\n    float zd0 = z - float(z0);\n    float xd1 = xd0 - 1.f;\n    float yd1 = yd0 - 1.f;\n    float zd1 = zd0 - 1.f;\n\n    float xs = fnlInterpQuintic(xd0);\n    float ys = fnlInterpQuintic(yd0);\n    float zs = fnlInterpQuintic(zd0);\n\n    x0 *= PRIME_X;\n    y0 *= PRIME_Y;\n    z0 *= PRIME_Z;\n    int x1 = x0 + PRIME_X;\n    int y1 = y0 + PRIME_Y;\n    int z1 = z0 + PRIME_Z;\n\n    float xf00 = fnlLerp(fnlGradCoord3D(seed, x0, y0, z0, xd0, yd0, zd0),                         fnlGradCoord3D(seed, x1, y0, z0, xd1, yd0, zd0), xs);\n    float xf10 = fnlLerp(fnlGradCoord3D(seed, x0, y1, z0, xd0, yd1, zd0),                         fnlGradCoord3D(seed, x1, y1, z0, xd1, yd1, zd0), xs);\n    float xf01 = fnlLerp(fnlGradCoord3D(seed, x0, y0, z1, xd0, yd0, zd1),                          fnlGradCoord3D(seed, x1, y0, z1, xd1, yd0, zd1), xs);\n    float xf11 = fnlLerp(fnlGradCoord3D(seed, x0, y1, z1, xd0, yd1, zd1),                         fnlGradCoord3D(seed, x1, y1, z1, xd1, yd1, zd1), xs);\n\n    float yf0 = fnlLerp(xf00, xf10, ys);\n    float yf1 = fnlLerp(xf01, xf11, ys);\n\n    return fnlLerp(yf0, yf1, zs) * 0.964921414852142333984375;\n}\n\nfloat getNoise(float x, float y, float z)\n{\n    x *= sFrequency;\n    y *= sFrequency;\n    z *= sFrequency;\n    float xy = x + y;\n    float s2 = xy * - float(0.211324865405187);\n    z *= float(0.577350269189626);\n    x += s2 - z;\n    y = y + s2 - z;\n    z += xy * float(0.577350269189626);\n    return fnlSinglePerlin3D(SEED_XZ, x, y, z);\n}\n\nint getVisibleColors() {\n    int count = 0;\n    int index = 0;\n\n    do {\n        if (sColors[index]!= 0)\n        count++;\n        index++;\n    } while (sColors[index - 1]!= 0); // \u5982\u679c\u4e0a\u4e00\u4e2a\u5143\u7d20\u4e0d\u4e3a0\uff0c\u5219\u7ee7\u7eed\u5faa\u73af\n\n    return count;\n}\n\nint getGreen(int color) {\n    return (color >> 8) & 0xFF;\n}\n\nint getBlue(int color) {\n    return color & 0xFF;\n}\n\nint getRed(int color) {\n    return (color >> 16) & 0xFF;\n}\n\n// \u66f2\u7ebf\u53d8\u5316\uff0c\u589e\u52a0\u68af\u5ea6\u8fc7\u5ea6\u4f18\u5316\nfloat gradientTransfer(float value) {\n    return (exp(-2.0f * value) - 1.0f) / (exp(-2.0f) - 1.0f);\n}\nint reverseBytes(int i) {\n    return ((i >> 24) & 0xFF) |\n           ((i >> 8) & 0xFF00) |\n           ((i << 8) & 0xFF0000) |\n           ((i << 24) & 0xFF000000);\n}int getColor(float noise, ivec2 texelCoords, ivec2 texSize) {\n    int colorCount = getVisibleColors();\n    float scale = (noise + 1.0) / 2.0;\n\n    scale = scale * float(colorCount - 1);\n    int r = getRed(sColors[colorCount - 1]);\n    int g = getGreen(sColors[colorCount - 1]);\n    int b = getBlue(sColors[colorCount - 1]);\n\n    for(int i = 0; i < (colorCount - 1); i ++) {\n        if(scale <= float(i + 1)) {\n            r = int(float(getRed(sColors[i])) + float((getRed(sColors[i + 1])                      - getRed(sColors[i]))) * (scale - float(i)));\n            if(r > 255){\n                r = 255;\n            } else if (r < 0) {\n                r = 0;\n            }\n\n            g = int(float(getGreen(sColors[i])) + float((getGreen(sColors[i + 1])                     - getGreen(sColors[i]))) * (scale - float(i)));\n            if(g > 255){\n                g = 255;\n            } else if (r < 0) {\n                g = 0;\n            }\n\n            b = int(float(getBlue(sColors[i])) + float((getBlue(sColors[i + 1])                      - getBlue(sColors[i]))) * (scale - float(i)));\n            if(b > 255){\n                b = 255;\n            } else if (r < 0) {\n                b = 0;\n            }\n            break;\n        }\n    }\n\n    if (sGradient[0] == 0.0) {\n        int little = 0xff000000 | (r << 16) | (g << 8) | b;\n        return reverseBytes(little);    }\n\n    float distanceX = ((sGradient[1] * float(texSize.x) - float(texelCoords.x))                          * (sGradient[1] * float(texSize.x) - float(texelCoords.x)));\n    float distanceY =  (sGradient[2] * float(texSize.y) - float(texelCoords.y))                          * (sGradient[2] * float(texSize.y) - float(texelCoords.y));\n    float distanceZ = (sGradient[0] * float(texSize.x) * sGradient[0] * float(texSize.x));\n\n    // \u9700\u8981\u5904\u7406Alpha\u901a\u9053\n    float alphaRatio = (distanceX + distanceY) / distanceZ;\n\n    alphaRatio = (1.0 - sGradient[3]) + (sGradient[3] - sGradient[4]) * gradientTransfer(alphaRatio);\n\n    // \u8fdc\u4e8e\u534a\u5f84\u7684\u503c\u90fd\u8bbe\u7f6e\u4e3a\u767d\u8272\n    if (alphaRatio > 1.0) {\n        alphaRatio = 1.0;\n    }\n\n    int alpha = int((1.0 - alphaRatio) * 255.0);\n\n    int little = (alpha << 24) | (r << 16) | (g << 8) | b;\n    return reverseBytes(little);}\n\n\nvoid main()\n{\n    ivec2 texelCoords = ivec2(gl_GlobalInvocationID.xy);\n    ivec2 texSize = textureSize(sTexture, 0);\n    if (texelCoords.x<texSize.x && texelCoords.y<texSize.y)\n    {\n        float noise = getNoise(float(texelCoords.x), float(texelCoords.y), sTime);\n        int color = getColor(noise, texelCoords, texSize);\n        histogram[texelCoords.y * texSize.x + texelCoords.x] = color;\n    }\n}";

    public a(int i3, int i16) {
        this.f398352a = (int) Math.ceil(i3 / 16.0d);
        this.f398353b = (int) Math.ceil(i16 / 16.0d);
        d(i3, i16);
        c();
        this.f398354c = f(i3, i16);
    }

    private void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        Log.e("MyGLRenderer", str + ": glError " + glGetError);
        throw new IllegalStateException(str + ": glError " + glGetError);
    }

    private void c() {
        int a16 = b.a(f398351i, this.f398359h, 37305);
        int glCreateProgram = GLES20.glCreateProgram();
        this.f398357f = glCreateProgram;
        GLES20.glAttachShader(glCreateProgram, a16);
        GLES20.glLinkProgram(this.f398357f);
    }

    private void d(int i3, int i16) {
        int[] iArr = new int[1];
        GLES20.glGenBuffers(1, iArr, 0);
        GLES20.glBindBuffer(37074, iArr[0]);
        GLES20.glBufferData(37074, i3 * 4 * i16, null, 35044);
        this.f398355d = iArr[0];
        this.f398356e = ((ByteBuffer) GLES30.glMapBufferRange(37074, 0, i16 * 4 * i3, 1)).asIntBuffer();
        GLES30.glUnmapBuffer(37074);
    }

    private int f(int i3, int i16) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        return iArr[0];
    }

    public void b() {
        GLES20.glDeleteBuffers(1, new int[]{this.f398355d}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.f398354c}, 0);
        GLES20.glDeleteProgram(this.f398357f);
    }

    @SuppressLint({"LongLogTag"})
    public void e(float f16, int[] iArr, float f17, com.tencent.biz.qui.quipolarlight.a aVar) {
        if (aVar instanceof a.b) {
            a.b bVar = (a.b) aVar;
            this.f398358g[0] = bVar.getRadius();
            this.f398358g[1] = bVar.getCenterX();
            this.f398358g[2] = bVar.getCenterY();
            this.f398358g[3] = bVar.getStartAlpha();
            this.f398358g[4] = bVar.getEndAlpha();
        }
        a("before clear");
        GLES20.glClear(16640);
        a("after clear");
        GLES30.glBindBufferBase(37074, 0, this.f398355d);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f398354c);
        GLES20.glUseProgram(this.f398357f);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f398357f, "sTime"), f16);
        a("glUniform1f");
        GLES20.glUniform1iv(GLES20.glGetUniformLocation(this.f398357f, "sColors"), iArr.length, iArr, 0);
        a("glUniform1iv sColorLocation");
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f398357f, "sFrequency"), f17);
        a("glUniform1f sFrequency");
        GLES20.glUniform1fv(GLES20.glGetUniformLocation(this.f398357f, "sGradient"), 5, this.f398358g, 0);
        a("glUniform1f sGradient");
        GLES31.glDispatchCompute(this.f398352a, this.f398353b, 1);
        GLES31.glMemoryBarrier(8192);
        GLES20.glFinish();
        GLES20.glUseProgram(0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
    }
}
