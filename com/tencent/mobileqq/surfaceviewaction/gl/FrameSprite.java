package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FrameSprite extends e {
    static IPatchRedirector $redirector_;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f291219a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f291220b0;

    /* renamed from: c0, reason: collision with root package name */
    private Texture[] f291221c0;

    /* renamed from: d0, reason: collision with root package name */
    private String[] f291222d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f291223e0;

    /* renamed from: f0, reason: collision with root package name */
    private long f291224f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f291225g0;

    /* renamed from: h0, reason: collision with root package name */
    private LinkedList<Texture> f291226h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f291227i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f291228j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f291229k0;

    /* renamed from: l0, reason: collision with root package name */
    public a f291230l0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a();
    }

    public FrameSprite(SpriteGLView spriteGLView, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) spriteGLView, (Object) strArr);
            return;
        }
        this.Z = 0;
        this.f291219a0 = false;
        this.f291220b0 = 10;
        this.f291225g0 = -1;
        this.f291226h0 = new LinkedList<>();
        this.f291227i0 = false;
        this.f291228j0 = false;
        this.f291229k0 = false;
        this.P = spriteGLView;
        this.f291222d0 = strArr;
        this.f291221c0 = new Texture[strArr.length];
        d0(10);
    }

    private void W() {
        synchronized (this) {
            if (this.f291226h0 != null) {
                for (int i3 = 0; i3 < this.f291226h0.size(); i3++) {
                    this.f291226h0.get(i3).e();
                }
                this.f291226h0.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i3) {
        Texture[] textureArr;
        Texture texture;
        synchronized (this) {
            LinkedList<Texture> linkedList = this.f291226h0;
            if (linkedList != null && (textureArr = this.f291221c0) != null && textureArr.length > i3 && (texture = textureArr[i3]) != null) {
                linkedList.add(texture);
                this.f291221c0[i3].b();
            }
        }
    }

    private Texture b0(int i3) {
        synchronized (this) {
            LinkedList<Texture> linkedList = this.f291226h0;
            if (linkedList != null) {
                linkedList.remove(this.f291221c0[i3]);
                return this.f291221c0[i3];
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(int i3, Texture texture) {
        Texture[] textureArr = this.f291221c0;
        if (textureArr != null && textureArr.length > i3) {
            textureArr[i3] = texture;
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.gl.e, com.tencent.mobileqq.surfaceviewaction.gl.d
    public void A(int i3, int i16, int i17, int i18, int i19, int i26, int i27, float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), fArr);
        } else if (this.f291222d0 != null) {
            a0(i3, i16, i17, i18, i19, i26, i27, fArr);
        } else if (this.f291221c0 != null) {
            Z(i3, i16, i17, i18, i19, i26, i27, fArr);
        }
    }

    public void X(Context context, SpriteGLView spriteGLView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) spriteGLView);
        } else {
            ThreadManagerV2.post(new Runnable(context, spriteGLView) { // from class: com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f291231d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ SpriteGLView f291232e;

                {
                    this.f291231d = context;
                    this.f291232e = spriteGLView;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FrameSprite.this, context, spriteGLView);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        for (int i16 = 0; i16 < FrameSprite.this.f291222d0.length && !FrameSprite.this.f291228j0; i16++) {
                            FrameSprite.this.c0(i16, new Texture(this.f291231d, this.f291232e, FrameSprite.this.f291222d0[i16]));
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("FrameSprite", 2, "FrameSprite: read time = " + (System.currentTimeMillis() - currentTimeMillis));
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        for (int i17 = 0; i17 < FrameSprite.this.f291222d0.length && !FrameSprite.this.f291228j0; i17++) {
                            if (!FrameSprite.this.f291229k0 || i17 % 2 == 0) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("FrameSprite", 2, "FrameSprite: deode:" + i17);
                                }
                                FrameSprite frameSprite = FrameSprite.this;
                                if (frameSprite.f291229k0) {
                                    i3 = i17 / 2;
                                } else {
                                    i3 = i17;
                                }
                                frameSprite.Y(i3);
                                if (!FrameSprite.this.f291223e0) {
                                    FrameSprite frameSprite2 = FrameSprite.this;
                                    if (i17 == frameSprite2.Z - 1 || i17 == frameSprite2.f291222d0.length - 1) {
                                        if (FrameSprite.this.f291220b0 == 20) {
                                            int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis2);
                                            FrameSprite frameSprite3 = FrameSprite.this;
                                            if (currentTimeMillis3 / frameSprite3.Z > 50) {
                                                frameSprite3.d0(10);
                                                FrameSprite.this.f291229k0 = true;
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("FrameSprite", 2, "mIsHalf = true");
                                                }
                                                this.f291232e.t(new Runnable() { // from class: com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.1.1
                                                    static IPatchRedirector $redirector_;

                                                    {
                                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                                        }
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                                            return;
                                                        }
                                                        synchronized (FrameSprite.this) {
                                                            Texture[] textureArr = FrameSprite.this.f291221c0;
                                                            if (textureArr != null && !FrameSprite.this.f291228j0) {
                                                                FrameSprite frameSprite4 = FrameSprite.this;
                                                                frameSprite4.f291221c0 = new Texture[frameSprite4.f291222d0.length / 2];
                                                                int i18 = 0;
                                                                for (int i19 = 0; i19 < FrameSprite.this.f291222d0.length; i19++) {
                                                                    if (i19 % 2 == 0) {
                                                                        FrameSprite.this.c0(i18, textureArr[i19]);
                                                                        i18++;
                                                                    } else {
                                                                        FrameSprite.this.f291226h0.remove(textureArr[i19]);
                                                                        textureArr[i19].e();
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                });
                                            }
                                        }
                                        FrameSprite.this.f0();
                                    }
                                }
                                while (FrameSprite.this.f291226h0 != null && FrameSprite.this.f291226h0.size() >= FrameSprite.this.Z) {
                                    try {
                                        LockMethodProxy.sleep(16L);
                                    } catch (InterruptedException unused) {
                                    }
                                }
                            }
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("FrameSprite", 2, "FrameSprite: " + QLog.getStackTraceString(e16));
                        }
                    }
                }
            }, 8, null, true);
        }
    }

    protected void Z(int i3, int i16, int i17, int i18, int i19, int i26, int i27, float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), fArr);
            return;
        }
        if (this.f291223e0) {
            int currentTimeMillis = (int) (((float) (System.currentTimeMillis() - this.f291224f0)) / (1000.0f / this.f291220b0));
            Texture[] textureArr = this.f291221c0;
            if (currentTimeMillis < textureArr.length) {
                this.Q = textureArr[currentTimeMillis];
            } else if (this.f291219a0) {
                this.f291224f0 = System.currentTimeMillis();
                this.Q = this.f291221c0[0];
            } else if (this.f291227i0) {
                this.Q = textureArr[textureArr.length - 1];
            } else {
                this.Q = null;
                a aVar = this.f291230l0;
                if (aVar != null) {
                    aVar.a();
                    this.f291230l0 = null;
                }
            }
            super.A(i3, i16, i17, i18, i19, i26, i27, fArr);
        }
    }

    protected void a0(int i3, int i16, int i17, int i18, int i19, int i26, int i27, float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), fArr);
            return;
        }
        if (this.f291223e0 && this.f291221c0 != null) {
            int currentTimeMillis = (int) (((float) (System.currentTimeMillis() - this.f291224f0)) / (1000.0f / this.f291220b0));
            int i28 = this.f291225g0;
            if (currentTimeMillis > i28) {
                if (currentTimeMillis > i28 + 1) {
                    this.f291225g0 = i28 + 1;
                } else {
                    this.f291225g0 = currentTimeMillis;
                }
                int i29 = this.f291225g0;
                Texture[] textureArr = this.f291221c0;
                if (i29 < textureArr.length) {
                    Texture texture = textureArr[i29];
                    if (texture != null && texture.f291256c) {
                        Texture texture2 = this.Q;
                        if (texture2 != null) {
                            texture2.e();
                        }
                        this.Q = b0(this.f291225g0);
                        if (QLog.isColorLevel()) {
                            QLog.d("FrameSprite", 2, "FrameSprite: mTexture = " + this.Q);
                        }
                        G();
                        super.A(i3, i16, i17, i18, i19, i26, i27, fArr);
                        if (QLog.isColorLevel()) {
                            QLog.d("FrameSprite", 2, "FrameSprite: draw1:" + this.f291225g0);
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("FrameSprite", 2, "FrameSprite: mTexture = null:" + this.f291225g0);
                    }
                    W();
                    return;
                }
                if (this.f291227i0) {
                    super.A(i3, i16, i17, i18, i19, i26, i27, fArr);
                    if (QLog.isColorLevel()) {
                        QLog.d("FrameSprite", 2, "FrameSprite: draw3:" + this.f291225g0);
                    }
                } else {
                    this.f291223e0 = false;
                    Texture texture3 = this.Q;
                    if (texture3 != null) {
                        texture3.e();
                    }
                }
                a aVar = this.f291230l0;
                if (aVar != null) {
                    aVar.a();
                    this.f291230l0 = null;
                    return;
                }
                return;
            }
            super.A(i3, i16, i17, i18, i19, i26, i27, fArr);
            if (QLog.isColorLevel()) {
                QLog.d("FrameSprite", 2, "FrameSprite: draw2:" + this.f291225g0);
            }
        }
    }

    public void d0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f291220b0 = i3;
            this.Z = (int) (i3 * 0.8d);
        }
    }

    public void e0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.f291227i0 = z16;
        }
    }

    public void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f291223e0 = true;
            this.f291224f0 = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.gl.e, com.tencent.mobileqq.surfaceviewaction.a
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.f291221c0 != null) {
            int i3 = 0;
            while (true) {
                Texture[] textureArr = this.f291221c0;
                if (i3 >= textureArr.length) {
                    break;
                }
                Texture texture = textureArr[i3];
                if (texture != null) {
                    texture.e();
                    this.f291221c0[i3] = null;
                }
                i3++;
            }
        }
        synchronized (this) {
            LinkedList<Texture> linkedList = this.f291226h0;
            if (linkedList != null) {
                linkedList.clear();
            }
            this.f291226h0 = null;
            this.f291221c0 = null;
            this.f291228j0 = true;
        }
        this.f291230l0 = null;
        super.m();
    }
}
