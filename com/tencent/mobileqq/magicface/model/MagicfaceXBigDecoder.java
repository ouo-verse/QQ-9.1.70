package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MagicfaceXBigDecoder extends d {
    static IPatchRedirector $redirector_;
    Runnable A;

    /* renamed from: w, reason: collision with root package name */
    Object f243396w;

    /* renamed from: x, reason: collision with root package name */
    Object f243397x;

    /* renamed from: y, reason: collision with root package name */
    volatile boolean f243398y;

    /* renamed from: z, reason: collision with root package name */
    Runnable f243399z;

    public MagicfaceXBigDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f243396w = new Object();
        this.f243397x = new Object();
        this.f243398y = false;
        this.f243399z = new Runnable() { // from class: com.tencent.mobileqq.magicface.model.MagicfaceXBigDecoder.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MagicfaceXBigDecoder.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                boolean z16 = true;
                long j3 = 0;
                while (MagicfaceXBigDecoder.this.f243395f) {
                    try {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            MagicfaceXBigDecoder magicfaceXBigDecoder = MagicfaceXBigDecoder.this;
                            int n3 = magicfaceXBigDecoder.n(magicfaceXBigDecoder.f243440h, magicfaceXBigDecoder.f243444l);
                            MagicfaceXBigDecoder magicfaceXBigDecoder2 = MagicfaceXBigDecoder.this;
                            int i3 = magicfaceXBigDecoder2.f243444l;
                            int i16 = n3 - i3;
                            magicfaceXBigDecoder2.f243443k = i16;
                            if (i16 > 0) {
                                magicfaceXBigDecoder2.l(i16, i3, magicfaceXBigDecoder2.f243440h);
                                MagicfaceXBigDecoder.this.f243444l = n3;
                                long currentTimeMillis2 = System.currentTimeMillis();
                                MagicfaceXBigDecoder magicfaceXBigDecoder3 = MagicfaceXBigDecoder.this;
                                magicfaceXBigDecoder3.f243439g.decodeVideoDecoder(magicfaceXBigDecoder3.f243441i, magicfaceXBigDecoder3.f243443k, magicfaceXBigDecoder3.f243442j);
                                if (QLog.isColorLevel()) {
                                    QLog.d("MagicfaceXBigDecoder", 2, "decodeVideoDecoder==usetime=" + (System.currentTimeMillis() - currentTimeMillis2) + "==videoFrameLength==" + MagicfaceXBigDecoder.this.f243443k);
                                }
                                MagicfaceXBigDecoder magicfaceXBigDecoder4 = MagicfaceXBigDecoder.this;
                                if (magicfaceXBigDecoder4.f243445m == -1) {
                                    magicfaceXBigDecoder4.f243445m = magicfaceXBigDecoder4.f243439g.getWidthVideoDecoder();
                                    MagicfaceXBigDecoder magicfaceXBigDecoder5 = MagicfaceXBigDecoder.this;
                                    magicfaceXBigDecoder5.f243446n = magicfaceXBigDecoder5.f243439g.getHeightVideoDecoder();
                                    MagicfaceXBigDecoder magicfaceXBigDecoder6 = MagicfaceXBigDecoder.this;
                                    magicfaceXBigDecoder6.f243454v = new int[magicfaceXBigDecoder6.f243446n * magicfaceXBigDecoder6.f243445m];
                                }
                                synchronized (MagicfaceXBigDecoder.this.f243396w) {
                                    if (!MagicfaceXBigDecoder.this.f243398y) {
                                        try {
                                            LockMethodProxy.wait(MagicfaceXBigDecoder.this.f243396w);
                                        } catch (Exception unused) {
                                        }
                                    }
                                }
                                MagicfaceXBigDecoder magicfaceXBigDecoder7 = MagicfaceXBigDecoder.this;
                                int[] k3 = magicfaceXBigDecoder7.k(magicfaceXBigDecoder7.f243442j, magicfaceXBigDecoder7.f243449q);
                                MagicfaceXBigDecoder magicfaceXBigDecoder8 = MagicfaceXBigDecoder.this;
                                MagicfaceDecoder.b bVar = magicfaceXBigDecoder8.f243392c;
                                if (bVar != null) {
                                    bVar.c(k3, magicfaceXBigDecoder8.f243445m, magicfaceXBigDecoder8.f243446n);
                                }
                                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                                if (QLog.isColorLevel()) {
                                    QLog.d("MagicfaceXBigDecoder", 2, "==============frameTime=============" + currentTimeMillis3);
                                }
                                int i17 = MagicfaceXBigDecoder.this.f243394e;
                                if (currentTimeMillis3 < i17) {
                                    if (j3 > 0) {
                                        long j16 = i17 - currentTimeMillis3;
                                        if (j16 > j3) {
                                            LockMethodProxy.sleep(j16 - j3);
                                        } else {
                                            j3 -= j16;
                                        }
                                    } else {
                                        LockMethodProxy.sleep(i17 - currentTimeMillis3);
                                    }
                                } else if (!z16) {
                                    j3 += currentTimeMillis3 - i17;
                                }
                                try {
                                    synchronized (MagicfaceXBigDecoder.this.f243397x) {
                                        MagicfaceXBigDecoder.this.f243397x.notify();
                                    }
                                } catch (Exception unused2) {
                                }
                                z16 = false;
                            } else {
                                return;
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    } catch (OutOfMemoryError e17) {
                        e17.printStackTrace();
                        return;
                    }
                }
            }
        };
        this.A = new Runnable() { // from class: com.tencent.mobileqq.magicface.model.MagicfaceXBigDecoder.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MagicfaceXBigDecoder.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                while (MagicfaceXBigDecoder.this.f243395f) {
                    try {
                        MagicfaceXBigDecoder.this.f243398y = false;
                        MagicfaceXBigDecoder magicfaceXBigDecoder = MagicfaceXBigDecoder.this;
                        int n3 = magicfaceXBigDecoder.n(magicfaceXBigDecoder.f243447o, magicfaceXBigDecoder.f243451s);
                        MagicfaceXBigDecoder magicfaceXBigDecoder2 = MagicfaceXBigDecoder.this;
                        int i3 = magicfaceXBigDecoder2.f243451s;
                        int i16 = n3 - i3;
                        magicfaceXBigDecoder2.f243450r = i16;
                        if (i16 >= 0) {
                            magicfaceXBigDecoder2.m(i16, i3, magicfaceXBigDecoder2.f243447o);
                            MagicfaceXBigDecoder magicfaceXBigDecoder3 = MagicfaceXBigDecoder.this;
                            magicfaceXBigDecoder3.f243451s = n3;
                            magicfaceXBigDecoder3.f243439g.decodeAlphaDecoder(magicfaceXBigDecoder3.f243448p, magicfaceXBigDecoder3.f243450r, magicfaceXBigDecoder3.f243449q);
                            MagicfaceXBigDecoder.this.f243398y = true;
                            try {
                                synchronized (MagicfaceXBigDecoder.this.f243396w) {
                                    MagicfaceXBigDecoder.this.f243396w.notify();
                                }
                            } catch (Exception unused) {
                            }
                            try {
                                synchronized (MagicfaceXBigDecoder.this.f243397x) {
                                    LockMethodProxy.wait(MagicfaceXBigDecoder.this.f243397x);
                                }
                            } catch (Exception unused2) {
                            }
                        } else {
                            return;
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
            }
        };
        if (QLog.isColorLevel()) {
            QLog.i("MagicfaceXBigDecoder", 2, "==MagicfaceXBigDecoder init=");
        }
        DecoderUtil decoderUtil = new DecoderUtil();
        this.f243439g = decoderUtil;
        decoderUtil.createVideoDecoder();
        this.f243439g.createAlphaDecoder();
    }

    @Override // com.tencent.mobileqq.magicface.model.d, com.tencent.mobileqq.magicface.model.MagicfaceDecoder
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
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
            if (this.f243442j != null && this.f243449q != null) {
                new BaseThread(this.A).start();
                this.f243399z.run();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.i("MagicfaceXBigDecoder", 2, "Exception=" + e16.toString());
            }
        }
    }

    @Override // com.tencent.mobileqq.magicface.model.d, com.tencent.mobileqq.magicface.model.MagicfaceDecoder
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MagicfaceXBigDecoder", 2, "==MagicfaceXBigDecoder release=");
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
    }

    void o() {
        try {
            this.f243442j = new byte[921600];
            this.f243449q = new byte[921600];
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        }
    }
}
