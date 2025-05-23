package com.tencent.av.opengl.texture;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.YUVTextureProgram;
import com.tencent.av.utils.af;
import com.tencent.av.utils.ax;
import com.tencent.av.utils.e;
import com.tencent.avcore.jni.NtrtcVideoRenderTexture;
import com.tencent.avcore.jni.render.GLRenderListener;
import com.tencent.avcore.jni.render.IGLRenderTexture;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class YUVTexture extends a implements IGLRenderTexture {
    public static float[] M = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, -0.3441f, 1.772f, 0.0f, 1.402f, -0.7141f, 0.0f, 0.0f, -0.7015f, 0.5291f, -0.885f, 1.0f};
    private final NtrtcVideoRenderTexture A;
    boolean B;
    volatile boolean C;
    protected int D;
    protected int E;
    private boolean F;
    private long G;
    private long H;
    private long I;
    private long J;
    private long K;
    public int L;

    /* renamed from: q, reason: collision with root package name */
    Context f74080q;

    /* renamed from: r, reason: collision with root package name */
    boolean f74081r;

    /* renamed from: s, reason: collision with root package name */
    protected float[] f74082s;

    /* renamed from: t, reason: collision with root package name */
    private final String f74083t;

    /* renamed from: u, reason: collision with root package name */
    public float f74084u;

    /* renamed from: v, reason: collision with root package name */
    public float f74085v;

    /* renamed from: w, reason: collision with root package name */
    private float f74086w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f74087x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f74088y;

    /* renamed from: z, reason: collision with root package name */
    private GLRenderListener f74089z;

    public YUVTexture(Context context, String str, long j3) {
        super(null, 0);
        StringBuilder sb5;
        long nativeContext;
        this.f74081r = false;
        this.f74082s = new float[]{1.0f, 1.0f, 1.0f, 0.0f, 0.0f, -0.3441f, 1.772f, 0.0f, 1.402f, -0.7141f, 0.0f, 0.0f, -0.7015f, 0.5291f, -0.885f, 1.0f};
        this.f74084u = 1.2f;
        this.f74085v = 1.93f;
        this.f74086w = 0.0f;
        this.f74087x = false;
        this.f74088y = false;
        this.B = true;
        this.C = true;
        this.D = -1;
        this.E = 0;
        this.F = true;
        this.G = 0L;
        this.H = 0L;
        this.I = 0L;
        this.J = 0L;
        this.K = 0L;
        this.L = -1;
        this.f74080q = context;
        this.B = af.G();
        if (e.e(22) == 1) {
            this.B = true;
        } else if (e.e(22) == 0) {
            this.B = false;
        }
        this.f74094c = 1;
        NtrtcVideoRenderTexture ntrtcVideoRenderTexture = new NtrtcVideoRenderTexture(this);
        this.A = ntrtcVideoRenderTexture;
        try {
            try {
                ntrtcVideoRenderTexture.init(tv.c.c(context), new WeakReference(ntrtcVideoRenderTexture), j3);
                sb5 = new StringBuilder();
                sb5.append(getClass().getSimpleName());
                sb5.append("_");
                sb5.append(str);
                sb5.append("_0x");
                nativeContext = ntrtcVideoRenderTexture.getNativeContext();
            } catch (Error e16) {
                e16.printStackTrace();
                sb5 = new StringBuilder();
                sb5.append(getClass().getSimpleName());
                sb5.append("_");
                sb5.append(str);
                sb5.append("_0x");
                nativeContext = this.A.getNativeContext();
                sb5.append(Long.toHexString(nativeContext));
                this.f74083t = sb5.toString();
            } catch (Exception e17) {
                e17.printStackTrace();
                sb5 = new StringBuilder();
                sb5.append(getClass().getSimpleName());
                sb5.append("_");
                sb5.append(str);
                sb5.append("_0x");
                nativeContext = this.A.getNativeContext();
                sb5.append(Long.toHexString(nativeContext));
                this.f74083t = sb5.toString();
            }
            sb5.append(Long.toHexString(nativeContext));
            this.f74083t = sb5.toString();
        } catch (Throwable th5) {
            this.f74083t = getClass().getSimpleName() + "_" + str + "_0x" + Long.toHexString(this.A.getNativeContext());
            throw th5;
        }
    }

    private void W() {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f74093b[0]);
    }

    public boolean C() {
        return this.A.canRender();
    }

    public void D(boolean z16) {
        this.A.flush(z16);
    }

    public int E() {
        return this.A.getCameraFrameDes();
    }

    public int F() {
        return this.A.getCaptureFrameHeight();
    }

    public byte[] G() {
        return this.A.getCaptureFrameTexture();
    }

    public int H() {
        return this.A.getCaptureFrameWidth();
    }

    public String I() {
        long j3;
        long j16;
        long j17;
        long j18;
        long j19;
        long currentTimeMillis = System.currentTimeMillis();
        long j26 = this.G;
        if (j26 != 0) {
            j3 = currentTimeMillis - j26;
        } else {
            j3 = -1;
        }
        long j27 = this.H;
        if (j27 != 0) {
            j16 = currentTimeMillis - j27;
        } else {
            j16 = -1;
        }
        long j28 = this.I;
        if (j28 != 0) {
            j17 = currentTimeMillis - j28;
        } else {
            j17 = -1;
        }
        long j29 = this.J;
        if (j29 != 0) {
            j18 = currentTimeMillis - j29;
        } else {
            j18 = -1;
        }
        long j36 = this.K;
        if (j36 != 0) {
            j19 = currentTimeMillis - j36;
        } else {
            j19 = -1;
        }
        return "TAG[" + this.f74083t + "], onBindTime[" + j3 + "], MSG_SHOW[" + j16 + "], MSG_RENDER[" + j18 + "], MSG_RESET[" + j17 + "], MSG_FLUSH[" + j19 + "], isBind[" + U() + "], Source[" + f() + ", " + e() + "], ImgAngle[" + L() + "]";
    }

    public byte[] J() {
        return this.A.getFaceFeature();
    }

    public int K() {
        return this.A.getImgAngle();
    }

    public int L() {
        if (this.F) {
            try {
                this.E = K();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return this.E;
    }

    public int M() {
        return this.A.getImgHeight();
    }

    public int N() {
        return this.A.getImgWidth();
    }

    public int O() {
        return this.D;
    }

    public byte[] P() {
        return G();
    }

    public int Q() {
        return F();
    }

    public int R() {
        return H();
    }

    public NtrtcVideoRenderTexture S() {
        return this.A;
    }

    public int T(int i3, int i16) {
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i16);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 10497.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 10497.0f);
        InputStream openRawResource = this.f74080q.getResources().openRawResource(i3);
        try {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(openRawResource);
                try {
                    openRawResource.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                if (decodeStream == null) {
                    return -1;
                }
                GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, decodeStream, 0);
                decodeStream.recycle();
                return i16;
            } catch (OutOfMemoryError unused) {
                openRawResource.close();
                return -1;
            } catch (Throwable th5) {
                try {
                    openRawResource.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
                throw th5;
            }
        } catch (IOException e18) {
            e18.printStackTrace();
            return -1;
        }
    }

    public boolean U() {
        return this.F;
    }

    public boolean V() {
        if (this.f74086w > 0.0f && (!this.f74087x || !this.f74088y)) {
            return true;
        }
        return false;
    }

    public void X() {
        onFaceFeatureUpdate(J());
    }

    public void Y(float f16) {
        this.f74086w = Math.max(f16, 0.0f);
    }

    public void Z(boolean z16) {
        this.f74087x = z16;
    }

    public void a0(GLRenderListener gLRenderListener) {
        this.f74089z = gLRenderListener;
    }

    public void b0(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f74083t, 2, "setIsBind, old[%s], new[%s]", Boolean.valueOf(this.F), Boolean.valueOf(z16));
        }
        this.F = z16;
    }

    public void c0(boolean z16) {
        this.f74088y = z16;
    }

    public boolean d0() {
        return this.A.updateCurFrame();
    }

    public int e0(int[] iArr) {
        return this.A.uploadContent(iArr);
    }

    @Override // com.tencent.av.opengl.texture.a
    public int g() {
        return GLSLRender.GL_TEXTURE_2D;
    }

    @Override // com.tencent.avcore.jni.render.IGLRenderTexture
    public void markForPerf(int i3) {
        if (i3 == 0) {
            if (e.f77110b) {
                this.I = System.currentTimeMillis();
            }
        } else if (i3 == 2) {
            if (e.f77110b) {
                this.J = System.currentTimeMillis();
            }
        } else if (i3 == 1) {
            if (e.f77110b) {
                this.K = System.currentTimeMillis();
            }
        } else if (i3 == 3 && e.f77110b) {
            this.H = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.avcore.jni.render.IGLRenderTexture
    public void nativeFrameDataUpdate() {
        this.C = true;
    }

    @Override // com.tencent.avcore.jni.render.GLRenderListener
    public void onFaceFeatureUpdate(byte[] bArr) {
        GLRenderListener gLRenderListener = this.f74089z;
        if (gLRenderListener != null && bArr != null && bArr.length > 0) {
            gLRenderListener.onFaceFeatureUpdate(bArr);
        }
    }

    @Override // com.tencent.avcore.jni.render.GLRenderListener
    public void onRenderFlush() {
        GLRenderListener gLRenderListener = this.f74089z;
        if (gLRenderListener != null) {
            gLRenderListener.onRenderFlush();
        }
    }

    @Override // com.tencent.avcore.jni.render.GLRenderListener
    public void onRenderFrame() {
        GLRenderListener gLRenderListener = this.f74089z;
        if (gLRenderListener != null) {
            gLRenderListener.onRenderFrame();
        }
    }

    @Override // com.tencent.avcore.jni.render.GLRenderListener
    public void onRenderInfoNotify(int i3, int i16, int i17, int i18) {
        GLRenderListener gLRenderListener = this.f74089z;
        if (gLRenderListener != null) {
            gLRenderListener.onRenderInfoNotify(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.avcore.jni.render.GLRenderListener
    public void onRenderReset() {
        GLRenderListener gLRenderListener = this.f74089z;
        if (gLRenderListener != null) {
            gLRenderListener.onRenderReset();
        }
    }

    @Override // com.tencent.av.opengl.texture.a
    public boolean q() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005a  */
    @Override // com.tencent.av.opengl.texture.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean r(ov.a aVar) {
        boolean z16;
        int i3;
        boolean z17;
        if (e.f77110b) {
            this.G = System.currentTimeMillis();
        }
        if (!p()) {
            if (this.f74092a == null) {
                this.f74092a = new int[3];
            }
            int i16 = 0;
            while (true) {
                int[] iArr = this.f74092a;
                if (i16 >= iArr.length) {
                    break;
                }
                iArr[i16] = aVar.i().b();
                i16++;
            }
            z16 = true;
        } else {
            z16 = false;
        }
        TextureProgram i17 = i();
        if (this.F) {
            if (this.B) {
                if (this.C) {
                    this.C = false;
                } else {
                    z17 = false;
                    if (!z17 || z16) {
                        if (this.f74104m) {
                            X();
                            i3 = e0(this.f74092a);
                            if (i3 != -1) {
                                this.D = i3;
                            }
                            if (this.D != -1 && !this.f74104m) {
                                GLES20.glUniform1i(i17.c()[10].f429680a, this.D);
                            }
                            this.f74095d = 1;
                            if (this.f74081r && this.L == -1) {
                                int b16 = aVar.i().b();
                                this.L = b16;
                                this.L = T(R.drawable.cok, b16);
                            }
                            if (this.D == -1) {
                                return true;
                            }
                            return false;
                        }
                        if (this.f74093b == null) {
                            this.f74093b = r0;
                            int[] iArr2 = {aVar.i().b()};
                        }
                        W();
                        this.D = 0;
                    }
                }
            }
            z17 = true;
            if (!z17) {
            }
            if (this.f74104m) {
            }
        }
        i3 = -1;
        if (i3 != -1) {
        }
        if (this.D != -1) {
            GLES20.glUniform1i(i17.c()[10].f429680a, this.D);
        }
        this.f74095d = 1;
        if (this.f74081r) {
            int b162 = aVar.i().b();
            this.L = b162;
            this.L = T(R.drawable.cok, b162);
        }
        if (this.D == -1) {
        }
    }

    @Override // com.tencent.av.opengl.texture.a
    public qv.b[] s(ov.a aVar) {
        TextureProgram i3 = i();
        qv.b[] s16 = super.s(aVar);
        if (!this.f74104m) {
            try {
                if ((i3 instanceof YUVTextureProgram) && ax.c()) {
                    GLES20.glUniform1f(i3.c()[7].f429680a, this.f74102k);
                    GLES20.glUniform1f(i3.c()[8].f429680a, this.f74103l);
                    if (this.f74088y && this.f74087x) {
                        GLES20.glUniform1f(i3.c()[19].f429680a, 0.0f);
                    } else {
                        GLES20.glUniform1f(i3.c()[19].f429680a, this.f74086w);
                    }
                } else {
                    GLES20.glUniform1f(i3.c()[7].f429680a, N());
                    GLES20.glUniform1f(i3.c()[8].f429680a, M());
                }
                GLES20.glUniformMatrix4fv(i3.c()[9].f429680a, 1, false, this.f74082s, 0);
                if (this.f74081r && this.L != -1) {
                    GLES20.glEnable(3042);
                    GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
                    GLES20.glActiveTexture(33987);
                    tv.c.a();
                    GLES20.glBindTexture(g(), this.L);
                    tv.c.a();
                    GLES20.glUniform1i(i3.c()[11].f429680a, 3);
                    tv.c.a();
                    GLES20.glUniform1i(i3.c()[12].f429680a, 1);
                    tv.c.a();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return s16;
    }
}
