package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d extends MagicfaceDecoder {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    protected DecoderUtil f243439g;

    /* renamed from: h, reason: collision with root package name */
    protected byte[] f243440h;

    /* renamed from: i, reason: collision with root package name */
    protected byte[] f243441i;

    /* renamed from: j, reason: collision with root package name */
    protected byte[] f243442j;

    /* renamed from: k, reason: collision with root package name */
    protected int f243443k;

    /* renamed from: l, reason: collision with root package name */
    protected int f243444l;

    /* renamed from: m, reason: collision with root package name */
    protected int f243445m;

    /* renamed from: n, reason: collision with root package name */
    protected int f243446n;

    /* renamed from: o, reason: collision with root package name */
    protected byte[] f243447o;

    /* renamed from: p, reason: collision with root package name */
    protected byte[] f243448p;

    /* renamed from: q, reason: collision with root package name */
    protected byte[] f243449q;

    /* renamed from: r, reason: collision with root package name */
    protected int f243450r;

    /* renamed from: s, reason: collision with root package name */
    protected int f243451s;

    /* renamed from: t, reason: collision with root package name */
    protected int f243452t;

    /* renamed from: u, reason: collision with root package name */
    protected int f243453u;

    /* renamed from: v, reason: collision with root package name */
    protected int[] f243454v;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f243440h = null;
        this.f243441i = new byte[51200];
        this.f243442j = null;
        this.f243444l = 0;
        this.f243445m = -1;
        this.f243446n = -1;
        this.f243447o = null;
        this.f243448p = new byte[51200];
        this.f243451s = 0;
        this.f243452t = -1;
        this.f243453u = -1;
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder begins");
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder ends");
        }
    }

    @Override // com.tencent.mobileqq.magicface.model.MagicfaceDecoder
    protected void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f243395f = false;
        }
    }

    @Override // com.tencent.mobileqq.magicface.model.MagicfaceDecoder
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceFFMepgDecoder", 2, "func maigcfaceDecoder begins:,isStartDecodr:" + this.f243395f);
        }
        try {
            try {
                try {
                    DecoderUtil decoderUtil = new DecoderUtil();
                    this.f243439g = decoderUtil;
                    decoderUtil.createVideoDecoder();
                    this.f243439g.createAlphaDecoder();
                    c cVar = this.f243390a;
                    byte[] bArr = cVar.f243438d;
                    this.f243440h = bArr;
                    if (bArr == null) {
                        DecoderUtil decoderUtil2 = this.f243439g;
                        if (decoderUtil2 != null) {
                            try {
                                decoderUtil2.releaseAlphaDecoder();
                                this.f243439g.releaseVideoDecoder();
                                return;
                            } catch (UnsatisfiedLinkError e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("MagicfaceFFMepgDecoder", 2, e16.getMessage());
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    byte[] bArr2 = cVar.f243437c;
                    this.f243447o = bArr2;
                    if (bArr2 == null) {
                        DecoderUtil decoderUtil3 = this.f243439g;
                        if (decoderUtil3 != null) {
                            try {
                                decoderUtil3.releaseAlphaDecoder();
                                this.f243439g.releaseVideoDecoder();
                                return;
                            } catch (UnsatisfiedLinkError e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("MagicfaceFFMepgDecoder", 2, e17.getMessage());
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        this.f243442j = new byte[480000];
                        this.f243449q = new byte[480000];
                    } catch (OutOfMemoryError e18) {
                        e18.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.e("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder ends, OOM.");
                        }
                    }
                    if (this.f243442j == null) {
                        DecoderUtil decoderUtil4 = this.f243439g;
                        if (decoderUtil4 != null) {
                            try {
                                decoderUtil4.releaseAlphaDecoder();
                                this.f243439g.releaseVideoDecoder();
                                return;
                            } catch (UnsatisfiedLinkError e19) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("MagicfaceFFMepgDecoder", 2, e19.getMessage());
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    boolean z16 = true;
                    long j3 = 0;
                    while (this.f243395f) {
                        long currentTimeMillis = System.currentTimeMillis();
                        int n3 = n(this.f243440h, this.f243444l);
                        int i3 = this.f243444l;
                        int i16 = n3 - i3;
                        this.f243443k = i16;
                        if (i16 <= 0) {
                            break;
                        }
                        l(i16, i3, this.f243440h);
                        this.f243444l = n3;
                        long currentTimeMillis2 = System.currentTimeMillis();
                        this.f243439g.decodeVideoDecoder(this.f243441i, this.f243443k, this.f243442j);
                        if (QLog.isColorLevel()) {
                            QLog.d("MagicfaceFFMepgDecoder", 2, "decodeVideoDecoder==usetime=" + (System.currentTimeMillis() - currentTimeMillis2) + "==videoFrameLength==" + this.f243443k);
                        }
                        try {
                            if (this.f243445m == -1) {
                                this.f243445m = this.f243439g.getWidthVideoDecoder();
                                int heightVideoDecoder = this.f243439g.getHeightVideoDecoder();
                                this.f243446n = heightVideoDecoder;
                                int i17 = this.f243445m;
                                if (i17 <= 500 && heightVideoDecoder <= 500) {
                                    this.f243454v = new int[heightVideoDecoder * i17];
                                }
                                this.f243445m = -1;
                                DecoderUtil decoderUtil5 = this.f243439g;
                                if (decoderUtil5 != null) {
                                    try {
                                        decoderUtil5.releaseAlphaDecoder();
                                        this.f243439g.releaseVideoDecoder();
                                        return;
                                    } catch (UnsatisfiedLinkError e26) {
                                        if (QLog.isColorLevel()) {
                                            QLog.e("MagicfaceFFMepgDecoder", 2, e26.getMessage());
                                            return;
                                        }
                                        return;
                                    }
                                }
                                return;
                            }
                            int n16 = n(this.f243447o, this.f243451s);
                            int i18 = this.f243451s;
                            int i19 = n16 - i18;
                            this.f243450r = i19;
                            m(i19, i18, this.f243447o);
                            this.f243451s = n16;
                            long currentTimeMillis3 = System.currentTimeMillis();
                            this.f243439g.decodeAlphaDecoder(this.f243448p, this.f243450r, this.f243449q);
                            if (QLog.isColorLevel()) {
                                QLog.d("MagicfaceFFMepgDecoder", 2, "decodeAlphaDecoder==usetime=" + (System.currentTimeMillis() - currentTimeMillis3) + "==alphaFrameLength==" + this.f243450r);
                            }
                            long currentTimeMillis4 = System.currentTimeMillis();
                            int[] k3 = k(this.f243442j, this.f243449q);
                            if (QLog.isColorLevel()) {
                                QLog.d("MagicfaceFFMepgDecoder", 2, "convertByteToColor==usetime=" + (System.currentTimeMillis() - currentTimeMillis4));
                            }
                            MagicfaceDecoder.b bVar = this.f243392c;
                            if (bVar != null) {
                                bVar.c(k3, this.f243445m, this.f243446n);
                            }
                            long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                            if (QLog.isColorLevel()) {
                                QLog.d("MagicfaceFFMepgDecoder", 2, "==============frameTime=============" + currentTimeMillis5);
                            }
                            int i26 = this.f243394e;
                            if (currentTimeMillis5 < i26) {
                                if (j3 > 0) {
                                    long j16 = i26 - currentTimeMillis5;
                                    if (j16 > j3) {
                                        LockMethodProxy.sleep(j16 - j3);
                                    } else {
                                        j3 -= j16;
                                    }
                                } else {
                                    LockMethodProxy.sleep(i26 - currentTimeMillis5);
                                }
                            } else if (!z16) {
                                j3 += currentTimeMillis5 - i26;
                            }
                            z16 = false;
                        } catch (OutOfMemoryError unused) {
                            if (QLog.isColorLevel()) {
                                QLog.i("MagicfaceFFMepgDecoder", 2, "magicfaceffMepgDecoder outofMemoryError");
                            }
                            this.f243445m = -1;
                            System.gc();
                            DecoderUtil decoderUtil6 = this.f243439g;
                            if (decoderUtil6 != null) {
                                try {
                                    decoderUtil6.releaseAlphaDecoder();
                                    this.f243439g.releaseVideoDecoder();
                                    return;
                                } catch (UnsatisfiedLinkError e27) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("MagicfaceFFMepgDecoder", 2, e27.getMessage());
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    DecoderUtil decoderUtil7 = this.f243439g;
                    if (decoderUtil7 != null) {
                        try {
                            decoderUtil7.releaseAlphaDecoder();
                            this.f243439g.releaseVideoDecoder();
                        } catch (UnsatisfiedLinkError e28) {
                            e = e28;
                            if (!QLog.isColorLevel()) {
                                return;
                            }
                            QLog.e("MagicfaceFFMepgDecoder", 2, e.getMessage());
                        }
                    }
                } catch (OutOfMemoryError e29) {
                    e29.printStackTrace();
                    DecoderUtil decoderUtil8 = this.f243439g;
                    if (decoderUtil8 != null) {
                        try {
                            decoderUtil8.releaseAlphaDecoder();
                            this.f243439g.releaseVideoDecoder();
                        } catch (UnsatisfiedLinkError e36) {
                            e = e36;
                            if (!QLog.isColorLevel()) {
                                return;
                            }
                            QLog.e("MagicfaceFFMepgDecoder", 2, e.getMessage());
                        }
                    }
                }
            } catch (Throwable th5) {
                DecoderUtil decoderUtil9 = this.f243439g;
                if (decoderUtil9 != null) {
                    try {
                        decoderUtil9.releaseAlphaDecoder();
                        this.f243439g.releaseVideoDecoder();
                    } catch (UnsatisfiedLinkError e37) {
                        if (QLog.isColorLevel()) {
                            QLog.e("MagicfaceFFMepgDecoder", 2, e37.getMessage());
                        }
                    }
                }
                throw th5;
            }
        } catch (Exception e38) {
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceFFMepgDecoder", 2, "===MagicfaceDecoder=Exception==" + e38.getMessage());
            }
            DecoderUtil decoderUtil10 = this.f243439g;
            if (decoderUtil10 != null) {
                try {
                    decoderUtil10.releaseAlphaDecoder();
                    this.f243439g.releaseVideoDecoder();
                } catch (UnsatisfiedLinkError e39) {
                    e = e39;
                    if (!QLog.isColorLevel()) {
                        return;
                    }
                    QLog.e("MagicfaceFFMepgDecoder", 2, e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.magicface.model.MagicfaceDecoder
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.c();
        this.f243444l = 0;
        this.f243451s = 0;
    }

    @Override // com.tencent.mobileqq.magicface.model.MagicfaceDecoder
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.d();
        this.f243441i = null;
        this.f243448p = null;
        this.f243449q = null;
        this.f243442j = null;
        this.f243454v = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] k(byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (int[]) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr, (Object) bArr2);
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.f243454v;
            if (i3 < iArr.length) {
                int i16 = i3 * 3;
                int i17 = bArr2[i16] & 255;
                if (i17 <= 50) {
                    i17 = 0;
                } else if (i17 >= 235) {
                    i17 = 255;
                }
                iArr[i3] = (bArr[i16] & 255) | ((i17 << 24) & (-16777216)) | ((bArr[i16 + 2] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((bArr[i16 + 1] << 8) & 65280);
                i3++;
            } else {
                return iArr;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(int i3, int i16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), bArr);
            return;
        }
        if (this.f243441i.length < i3) {
            this.f243441i = new byte[i3];
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceFFMepgDecoder", 2, "videoFrame.length = " + this.f243441i.length + "new framelength = " + i3);
            }
        }
        System.arraycopy(bArr, i16, this.f243441i, 0, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(int i3, int i16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), bArr);
            return;
        }
        if (this.f243448p.length < i3) {
            this.f243448p = new byte[i3];
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceFFMepgDecoder", 2, "alphaFrame.length = " + this.f243448p.length + " new fillFrameAlpha = " + i3);
            }
        }
        System.arraycopy(bArr, i16, this.f243448p, 0, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int n(byte[] bArr, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr, i3)).intValue();
        }
        if (i3 == bArr.length) {
            return -1;
        }
        int i16 = i3 + 1;
        byte b16 = (byte) (bArr[i3 + 4] & RegisterType.DOUBLE_HI);
        if (b16 != 7 && b16 != 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        while (i16 < bArr.length - 4) {
            if (bArr[i16] == 0) {
                int i17 = i16 + 1;
                if (bArr[i17] == 0 && bArr[i16 + 2] == 0 && bArr[i16 + 3] == 1) {
                    byte b17 = (byte) (bArr[i16 + 4] & RegisterType.DOUBLE_HI);
                    if (b17 != 7 && b17 != 8) {
                        if (z16) {
                            break;
                        }
                        z16 = true;
                    }
                    i16 = i17;
                }
            }
            i16++;
        }
        if (i16 == bArr.length - 4) {
            return bArr.length;
        }
        return i16;
    }
}
