package com.tencent.av.opengl.effects;

import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class z {

    /* renamed from: c, reason: collision with root package name */
    protected FloatBuffer f74062c;

    /* renamed from: d, reason: collision with root package name */
    protected FloatBuffer f74063d;

    /* renamed from: e, reason: collision with root package name */
    protected int f74064e;

    /* renamed from: f, reason: collision with root package name */
    protected int f74065f;

    /* renamed from: i, reason: collision with root package name */
    protected int f74068i;

    /* renamed from: j, reason: collision with root package name */
    protected int f74069j;

    /* renamed from: k, reason: collision with root package name */
    protected int f74070k;

    /* renamed from: l, reason: collision with root package name */
    protected int f74071l;

    /* renamed from: m, reason: collision with root package name */
    protected int f74072m;

    /* renamed from: n, reason: collision with root package name */
    protected int f74073n;

    /* renamed from: o, reason: collision with root package name */
    private int f74074o;

    /* renamed from: p, reason: collision with root package name */
    private int f74075p;

    /* renamed from: a, reason: collision with root package name */
    private float[] f74060a = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: b, reason: collision with root package name */
    private float[] f74061b = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: g, reason: collision with root package name */
    private String f74066g = "attribute vec4 aVertexCo;\nattribute vec2 aTextureCo;\n\nuniform mat4 uVertexMatrix;\nuniform mat4 uTextureMatrix;\n\nvarying vec2 vTextureCo;\n\nvoid main(){\n    gl_Position = uVertexMatrix*aVertexCo;\n    vTextureCo = (uTextureMatrix*vec4(aTextureCo,0,1)).xy;\n}";

    /* renamed from: h, reason: collision with root package name */
    private String f74067h = "precision highp float;\nprecision highp int;\n\nvarying vec2 vTextureCo;\nuniform sampler2D uTexture;\n\nuniform float uWidth;\nuniform float uHeight;\n\nfloat cY(float x,float y){\n    vec4 c=texture2D(uTexture,vec2(x,y));\n    return c.r*0.2990+c.g*0.5870+c.b*0.1140;\n}\n\nvec4 cC(float x,float y,float dx,float dy){\n    vec4 c0=texture2D(uTexture,vec2(x,y));\n    vec4 c1=texture2D(uTexture,vec2(x+dx,y));\n    vec4 c2=texture2D(uTexture,vec2(x,y+dy));\n    vec4 c3=texture2D(uTexture,vec2(x+dx,y+dy));\n    return (c0+c1+c2+c3)/4.;\n}\n\nfloat cU(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return -0.1687*c.r -0.3313*c.g + 0.5*c.b+0.5;\n}\n\nfloat cV(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return 0.5*c.r - 0.4187*c.g - 0.0813*c.b+0.5000;\n}\n\nvec2 cPos(float t,float shiftx,float gy){\n    vec2 pos=vec2(floor(uWidth*vTextureCo.x),floor(uHeight*gy));\n    return vec2(mod(pos.x*shiftx,uWidth),(pos.y*shiftx+floor(pos.x*shiftx/uWidth))*t);\n}\n\nvec4 calculateY(){\n    vec2 pos=cPos(1.,4.,vTextureCo.y);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cY(pos.x/uWidth,textureYPos);\n    oColor[1]=cY((pos.x+1.)/uWidth,textureYPos);\n    oColor[2]=cY((pos.x+2.)/uWidth,textureYPos);\n    oColor[3]=cY((pos.x+3.)/uWidth,textureYPos);\n    return oColor;\n}\nvec4 calculateU(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateV(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]=cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]=cV((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]=cV((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateUV(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateVU(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvoid main() {\n    if(vTextureCo.y<0.2500){\n        gl_FragColor=calculateY();\n    }else if(vTextureCo.y<0.3125){\n        gl_FragColor=calculateU(0.2500,1./uWidth,1./uHeight);\n    }else if(vTextureCo.y<0.3750){\n        gl_FragColor=calculateV(0.3125,1./uWidth,1./uHeight);\n    }else{\n        gl_FragColor=vec4(0,0,0,0);\n    }\n}";

    public z() {
        e();
    }

    public static int a(String str, String str2) {
        int f16;
        int f17 = f(35633, str);
        if (f17 == 0 || (f16 = f(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, f17);
            GLES20.glAttachShader(glCreateProgram, f16);
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                d(1, "Could not link program:" + GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    private static void d(int i3, Object obj) {
        QLog.e("RGBToI420Filter", 1, "glError:" + i3 + "---" + obj);
    }

    public static int f(int i3, String str) {
        if (str == null) {
            d(1, "Shader source ==null : shaderType =" + i3);
            return 0;
        }
        int glCreateShader = GLES20.glCreateShader(i3);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                d(1, "Could not compile shader:" + i3);
                d(1, "GLES20 Error:" + GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
        }
        return glCreateShader;
    }

    public void b() {
        GLES20.glDeleteProgram(this.f74068i);
    }

    public void c(int i3) {
        h();
        l();
        k();
        g(i3);
        j();
    }

    protected void e() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(32);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.f74062c = asFloatBuffer;
        asFloatBuffer.put(new float[]{-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f});
        this.f74062c.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(32);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        this.f74063d = asFloatBuffer2;
        asFloatBuffer2.put(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f});
        this.f74063d.position(0);
    }

    protected void g(int i3) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        GLES20.glUniform1i(this.f74073n, 0);
    }

    protected void h() {
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glClear(16640);
    }

    public void i() {
        int a16 = a(this.f74066g, this.f74067h);
        this.f74068i = a16;
        this.f74069j = GLES20.glGetAttribLocation(a16, "aVertexCo");
        this.f74070k = GLES20.glGetAttribLocation(this.f74068i, "aTextureCo");
        this.f74071l = GLES20.glGetUniformLocation(this.f74068i, "uVertexMatrix");
        this.f74072m = GLES20.glGetUniformLocation(this.f74068i, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        this.f74073n = GLES20.glGetUniformLocation(this.f74068i, "uTexture");
        this.f74074o = GLES20.glGetUniformLocation(this.f74068i, "uWidth");
        this.f74075p = GLES20.glGetUniformLocation(this.f74068i, "uHeight");
    }

    protected void j() {
        GLES20.glEnableVertexAttribArray(this.f74069j);
        GLES20.glVertexAttribPointer(this.f74069j, 2, 5126, false, 0, (Buffer) this.f74062c);
        GLES20.glEnableVertexAttribArray(this.f74070k);
        GLES20.glVertexAttribPointer(this.f74070k, 2, 5126, false, 0, (Buffer) this.f74063d);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f74069j);
        GLES20.glDisableVertexAttribArray(this.f74070k);
    }

    protected void k() {
        GLES20.glUniformMatrix4fv(this.f74071l, 1, false, this.f74060a, 0);
        GLES20.glUniformMatrix4fv(this.f74072m, 1, false, this.f74061b, 0);
        GLES20.glUniform1f(this.f74074o, this.f74064e);
        GLES20.glUniform1f(this.f74075p, this.f74065f);
    }

    protected void l() {
        GLES20.glUseProgram(this.f74068i);
    }

    public void m(int i3, int i16) {
        this.f74064e = i3;
        this.f74065f = i16;
    }
}
