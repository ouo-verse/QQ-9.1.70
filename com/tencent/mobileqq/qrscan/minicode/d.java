package com.tencent.mobileqq.qrscan.minicode;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.minicode.RecogProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f276748a;

    /* renamed from: b, reason: collision with root package name */
    private int f276749b;

    /* renamed from: c, reason: collision with root package name */
    private TextureRender f276750c;

    /* renamed from: d, reason: collision with root package name */
    private long f276751d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f276752e;

    /* renamed from: f, reason: collision with root package name */
    private RenderBuffer f276753f;

    /* renamed from: g, reason: collision with root package name */
    private f f276754g;

    /* renamed from: h, reason: collision with root package name */
    private float f276755h;

    /* renamed from: i, reason: collision with root package name */
    private float[] f276756i;

    /* renamed from: j, reason: collision with root package name */
    private final Object f276757j;

    public d(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
            return;
        }
        this.f276748a = "MiniRecog.recog";
        this.f276749b = -1;
        this.f276751d = 0L;
        this.f276752e = false;
        this.f276757j = new Object();
        this.f276754g = fVar;
        this.f276756i = new float[16];
        this.f276750c = new TextureRender();
        this.f276749b = a.c(fVar.f276766c, fVar.f276765b);
        this.f276753f = new RenderBuffer(fVar.f276766c, fVar.f276765b);
        e.l(false);
        try {
            f fVar2 = this.f276754g;
            long QCodeInit = RecogProxy.QCodeInit(fVar2.f276764a, fVar2.f276765b, fVar2.f276766c, fVar2.f276767d, fVar2.f276768e, fVar2.f276769f, fVar2.f276770g, 0.35f);
            this.f276751d = QCodeInit;
            QLog.i("MiniRecog.recog", 1, String.format("RecogProxy.QCodeInit native_handler=0x%x", Long.valueOf(QCodeInit)));
            if (this.f276751d != 0) {
                e.a(false);
            }
        } catch (UnsatisfiedLinkError e16) {
            QLog.e("MiniRecog.recog", 1, "RecogProxy.QCodeInit error : " + e16);
        }
        this.f276752e = true;
    }

    private Rect c(int i3, int i16, float[] fArr) {
        int i17;
        if (i3 > i16) {
            i17 = 0;
        } else {
            i17 = 1;
        }
        float f16 = fArr[i17] - 0.5f;
        float f17 = this.f276755h;
        fArr[i17] = (f16 / f17) + 0.5f;
        int i18 = i17 + 2;
        fArr[i18] = ((fArr[i18] - 0.5f) / f17) + 0.5f;
        float f18 = fArr[0] - 0.02f;
        float f19 = fArr[1] - 0.02f;
        float f26 = fArr[2] + 0.02f;
        float f27 = fArr[3] + 0.02f;
        fArr[0] = 1.0f - (f18 * 2.0f);
        fArr[1] = (f19 * 2.0f) - 1.0f;
        fArr[2] = 1.0f - (f26 * 2.0f);
        fArr[3] = (f27 * 2.0f) - 1.0f;
        for (int i19 = 0; i19 < 4; i19++) {
            float f28 = fArr[i19];
            if (f28 > 1.0f) {
                fArr[i19] = 1.0f;
            } else if (f28 < -1.0f) {
                fArr[i19] = -1.0f;
            }
        }
        float f29 = i16;
        int i26 = (int) (fArr[0] * 0.5f * f29);
        int i27 = (int) (fArr[2] * 0.5f * f29);
        float f36 = i3;
        int i28 = (int) (fArr[1] * 0.5f * f36);
        int i29 = (int) (fArr[3] * 0.5f * f36);
        int abs = Math.abs(i29 - i28);
        int abs2 = Math.abs(i27 - i26);
        if (i28 >= i29) {
            i28 = i29;
        }
        if (i26 <= i27) {
            i26 = i27;
        }
        int i36 = (int) (i28 + (f36 * 0.5f));
        int i37 = (int) ((f29 * 0.5f) - i26);
        Rect rect = new Rect();
        rect.left = i36;
        rect.top = i37;
        rect.right = i36 + abs;
        rect.bottom = i37 + abs2;
        return rect;
    }

    public List<com.tencent.mobileqq.qrscan.a> a(int i3, int i16, int i17, long j3, boolean z16) {
        char c16;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 5;
        char c17 = 2;
        char c18 = 1;
        char c19 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3), Boolean.valueOf(z16));
        }
        if (!this.f276752e) {
            return null;
        }
        Matrix.setIdentityM(this.f276756i, 0);
        if (i16 > i17) {
            float f16 = i17 / i16;
            this.f276755h = f16;
            Matrix.scaleM(this.f276756i, 0, f16, 1.0f, 1.0f);
        } else {
            float f17 = i16 / i17;
            this.f276755h = f17;
            Matrix.scaleM(this.f276756i, 0, 1.0f, f17, 1.0f);
        }
        Matrix.rotateM(this.f276756i, 0, 180.0f, 1.0f, 0.0f, 0.0f);
        Matrix.rotateM(this.f276756i, 0, -90.0f, 0.0f, 0.0f, 1.0f);
        this.f276753f.setUserTextureId(this.f276749b);
        this.f276753f.bind();
        float f18 = 0.0f;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.f276750c.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, this.f276756i);
        this.f276753f.unbind();
        GLES20.glFlush();
        ArrayList arrayList = new ArrayList();
        synchronized (this.f276757j) {
            long j16 = this.f276751d;
            if (j16 != 0) {
                RecogProxy.QCodeProcess(j16, this.f276749b, 0);
                int boxCnt = RecogProxy.getBoxCnt(this.f276751d);
                if (boxCnt >= 4) {
                    boxCnt = 4;
                }
                int i26 = 0;
                while (i26 < boxCnt) {
                    float[] fArr = new float[i19];
                    fArr[0] = f18;
                    fArr[c18] = f18;
                    fArr[c17] = f18;
                    fArr[3] = f18;
                    fArr[c19] = f18;
                    int box = RecogProxy.getBox(this.f276751d, i26, fArr);
                    int boxType = RecogProxy.getBoxType(this.f276751d, i26);
                    if (box >= 0 && boxType >= 0) {
                        if (QLog.isDevelopLevel()) {
                            i18 = 5;
                            QLog.i("MiniRecog.recog", 2, String.format("debug_minicode_point=[%f,%f,%f,%f,%f,%d]", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), Float.valueOf(fArr[2]), Float.valueOf(fArr[3]), Float.valueOf(fArr[4]), Integer.valueOf(boxType)));
                        } else {
                            i18 = 5;
                        }
                        Rect c26 = c(i16, i17, fArr);
                        com.tencent.mobileqq.qrscan.a aVar = new com.tencent.mobileqq.qrscan.a();
                        aVar.f276532b.set(c26);
                        aVar.f276531a = boxType;
                        c16 = 4;
                        aVar.f276533c = fArr[4];
                        arrayList.add(aVar);
                        i26++;
                        c19 = c16;
                        i19 = i18;
                        f18 = 0.0f;
                        c17 = 2;
                        c18 = 1;
                    }
                    c16 = c19;
                    i18 = 5;
                    i26++;
                    c19 = c16;
                    i19 = i18;
                    f18 = 0.0f;
                    c17 = 2;
                    c18 = 1;
                }
            }
        }
        if (z16) {
            Matrix.setIdentityM(this.f276756i, 0);
            if (i16 > i17) {
                Matrix.scaleM(this.f276756i, 0, this.f276755h, 1.0f, 1.0f);
            } else {
                Matrix.scaleM(this.f276756i, 0, 1.0f, this.f276755h, 1.0f);
            }
            this.f276753f.setUserTextureId(this.f276749b);
            this.f276753f.bind();
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            this.f276750c.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, this.f276756i);
            this.f276753f.unbind();
            GLES20.glFlush();
            try {
                int i27 = this.f276749b;
                f fVar = this.f276754g;
                Bitmap b16 = a.b(i27, fVar.f276766c, fVar.f276765b);
                String str = j3 + "-" + new SimpleDateFormat("MM-dd HH:mm:ss", BaseApplication.getContext().getResources().getConfiguration().locale).format(new Date(j3));
                e.n(b16, str);
                if (QLog.isColorLevel()) {
                    QLog.i("MiniRecog.recog", 2, String.format("debug_minicode_validBmpData %s", str));
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        TextureRender textureRender = this.f276750c;
        if (textureRender != null) {
            textureRender.release();
        }
        int i3 = this.f276749b;
        if (i3 >= 0) {
            b.c(i3);
            this.f276749b = -1;
        }
        RenderBuffer renderBuffer = this.f276753f;
        if (renderBuffer != null) {
            renderBuffer.destroy();
        }
        synchronized (d.class) {
            long j3 = this.f276751d;
            if (j3 != 0) {
                QLog.i("MiniRecog.recog", 1, String.format("RecogProxy.QCodeDestroy native_handler=0x%x", Long.valueOf(j3)));
                RecogProxy.QCodeDestroy(this.f276751d);
                this.f276751d = 0L;
            }
        }
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f276751d != 0) {
            return true;
        }
        return false;
    }
}
