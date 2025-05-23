package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MagicFaceSuperBigDecoder extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: w, reason: collision with root package name */
    private Runnable f243389w;

    public MagicFaceSuperBigDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f243389w = new Runnable() { // from class: com.tencent.mobileqq.magicface.model.MagicFaceSuperBigDecoder.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MagicFaceSuperBigDecoder.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run begins, isStartDecodr:" + MagicFaceSuperBigDecoder.this.f243395f);
                    }
                    boolean z16 = true;
                    long j3 = 0;
                    while (MagicFaceSuperBigDecoder.this.f243395f) {
                        long currentTimeMillis = System.currentTimeMillis();
                        MagicFaceSuperBigDecoder magicFaceSuperBigDecoder = MagicFaceSuperBigDecoder.this;
                        int n3 = magicFaceSuperBigDecoder.n(magicFaceSuperBigDecoder.f243440h, magicFaceSuperBigDecoder.f243444l);
                        MagicFaceSuperBigDecoder magicFaceSuperBigDecoder2 = MagicFaceSuperBigDecoder.this;
                        int i3 = magicFaceSuperBigDecoder2.f243444l;
                        int i16 = n3 - i3;
                        magicFaceSuperBigDecoder2.f243443k = i16;
                        if (i16 <= 0) {
                            if (QLog.isColorLevel()) {
                                QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run ends, \u3010condition\u3011 frame len <= 0, videoFrameLength:" + MagicFaceSuperBigDecoder.this.f243443k);
                                return;
                            }
                            return;
                        }
                        magicFaceSuperBigDecoder2.l(i16, i3, magicFaceSuperBigDecoder2.f243440h);
                        MagicFaceSuperBigDecoder magicFaceSuperBigDecoder3 = MagicFaceSuperBigDecoder.this;
                        magicFaceSuperBigDecoder3.f243444l = n3;
                        magicFaceSuperBigDecoder3.f243439g.decodeVideoDecoderReturnYUV(magicFaceSuperBigDecoder3.f243441i, magicFaceSuperBigDecoder3.f243443k, magicFaceSuperBigDecoder3.f243442j);
                        MagicFaceSuperBigDecoder magicFaceSuperBigDecoder4 = MagicFaceSuperBigDecoder.this;
                        if (magicFaceSuperBigDecoder4.f243445m == -1) {
                            magicFaceSuperBigDecoder4.f243445m = magicFaceSuperBigDecoder4.f243439g.getWidthVideoDecoder();
                            MagicFaceSuperBigDecoder magicFaceSuperBigDecoder5 = MagicFaceSuperBigDecoder.this;
                            magicFaceSuperBigDecoder5.f243446n = magicFaceSuperBigDecoder5.f243439g.getHeightVideoDecoder();
                        }
                        MagicFaceSuperBigDecoder magicFaceSuperBigDecoder6 = MagicFaceSuperBigDecoder.this;
                        int n16 = magicFaceSuperBigDecoder6.n(magicFaceSuperBigDecoder6.f243447o, magicFaceSuperBigDecoder6.f243451s);
                        MagicFaceSuperBigDecoder magicFaceSuperBigDecoder7 = MagicFaceSuperBigDecoder.this;
                        int i17 = magicFaceSuperBigDecoder7.f243451s;
                        int i18 = n16 - i17;
                        magicFaceSuperBigDecoder7.f243450r = i18;
                        magicFaceSuperBigDecoder7.m(i18, i17, magicFaceSuperBigDecoder7.f243447o);
                        MagicFaceSuperBigDecoder magicFaceSuperBigDecoder8 = MagicFaceSuperBigDecoder.this;
                        int i19 = magicFaceSuperBigDecoder8.f243450r;
                        if (i19 <= 0) {
                            if (QLog.isColorLevel()) {
                                QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run ends, \u3010condition\u3011 frame len <= 0, alphaFrameLength:" + MagicFaceSuperBigDecoder.this.f243450r);
                                return;
                            }
                            return;
                        }
                        magicFaceSuperBigDecoder8.f243451s = n16;
                        magicFaceSuperBigDecoder8.f243439g.decodeAlphaDecoderReturnYUV(magicFaceSuperBigDecoder8.f243448p, i19, magicFaceSuperBigDecoder8.f243449q);
                        MagicFaceSuperBigDecoder magicFaceSuperBigDecoder9 = MagicFaceSuperBigDecoder.this;
                        if (magicFaceSuperBigDecoder9.f243452t == -1) {
                            magicFaceSuperBigDecoder9.f243452t = magicFaceSuperBigDecoder9.f243439g.getWidthAlphaDecoder();
                            MagicFaceSuperBigDecoder magicFaceSuperBigDecoder10 = MagicFaceSuperBigDecoder.this;
                            magicFaceSuperBigDecoder10.f243453u = magicFaceSuperBigDecoder10.f243439g.getHeightAlphaDecoder();
                        }
                        MagicFaceSuperBigDecoder magicFaceSuperBigDecoder11 = MagicFaceSuperBigDecoder.this;
                        MagicfaceDecoder.b bVar = magicFaceSuperBigDecoder11.f243392c;
                        if (bVar != null) {
                            bVar.b(magicFaceSuperBigDecoder11.f243442j, magicFaceSuperBigDecoder11.f243449q, magicFaceSuperBigDecoder11.f243445m, magicFaceSuperBigDecoder11.f243446n, 0.0f);
                        }
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (QLog.isColorLevel()) {
                            QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run, \u3010useFrameTime\u3011 " + currentTimeMillis2);
                        }
                        int i26 = MagicFaceSuperBigDecoder.this.f243394e;
                        if (currentTimeMillis2 < i26) {
                            if (j3 > 0) {
                                long j16 = i26 - currentTimeMillis2;
                                if (j16 > j3) {
                                    LockMethodProxy.sleep(j16 - j3);
                                } else {
                                    j3 -= j16;
                                }
                            } else {
                                LockMethodProxy.sleep(i26 - currentTimeMillis2);
                            }
                        } else if (!z16) {
                            j3 += currentTimeMillis2 - i26;
                        }
                        z16 = false;
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run ends, error is catched.msg:" + e16.getMessage());
                    }
                } catch (OutOfMemoryError e17) {
                    e17.printStackTrace();
                }
            }
        };
        if (QLog.isColorLevel()) {
            QLog.d("MagicFaceSuperBigDecoder", 2, "func MagicFaceSuperBigDecoder [Constructor] begins");
        }
        DecoderUtil decoderUtil = new DecoderUtil();
        this.f243439g = decoderUtil;
        int createVideoDecoder = decoderUtil.createVideoDecoder();
        int createAlphaDecoder = this.f243439g.createAlphaDecoder();
        if (QLog.isColorLevel()) {
            QLog.d("MagicFaceSuperBigDecoder", 2, "func MagicFaceSuperBigDecoder [Constructor] ends, videoRet:" + createVideoDecoder + ",alphaRet:" + createAlphaDecoder);
        }
    }

    @Override // com.tencent.mobileqq.magicface.model.d, com.tencent.mobileqq.magicface.model.MagicfaceDecoder
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicFaceSuperBigDecoder", 2, "func maigcfaceDecoder begins");
        }
        c cVar = this.f243390a;
        byte[] bArr = cVar.f243438d;
        this.f243440h = bArr;
        if (bArr == null) {
            return;
        }
        byte[] bArr2 = cVar.f243437c;
        this.f243447o = bArr2;
        if (bArr2 == null) {
            return;
        }
        o();
        if (VasToggle.BUG_108571707.isEnable(true)) {
            synchronized (MagicFaceSuperBigDecoder.class) {
                this.f243389w.run();
            }
        } else {
            this.f243389w.run();
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicFaceSuperBigDecoder", 2, "func maigcfaceDecoder ends");
        }
    }

    @Override // com.tencent.mobileqq.magicface.model.d, com.tencent.mobileqq.magicface.model.MagicfaceDecoder
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (MagicFaceSuperBigDecoder.class) {
            if (QLog.isColorLevel()) {
                QLog.d("MagicFaceSuperBigDecoder", 2, "func release begins.");
            }
            DecoderUtil decoderUtil = this.f243439g;
            if (decoderUtil != null) {
                try {
                    decoderUtil.releaseAlphaDecoder();
                    this.f243439g.releaseVideoDecoder();
                } catch (UnsatisfiedLinkError unused) {
                }
            }
            this.f243439g = null;
            super.d();
            if (QLog.isColorLevel()) {
                QLog.d("MagicFaceSuperBigDecoder", 2, "func release ends.");
            }
        }
    }

    protected void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicFaceSuperBigDecoder", 2, "func initXbig begins");
        }
        try {
            this.f243442j = new byte[817920];
            this.f243449q = new byte[817920];
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicFaceSuperBigDecoder", 2, "func initXbig ends");
        }
    }
}
