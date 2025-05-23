package com.tencent.mobileqq.ar.arengine;

import android.content.Context;
import com.tencent.mobileqq.ar.NeonControl;
import com.tencent.mobileqq.ar.arcloud.ARCloudImageFilter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {

    /* renamed from: t, reason: collision with root package name */
    public static int f197965t = 0;

    /* renamed from: u, reason: collision with root package name */
    public static int f197966u = 1;

    /* renamed from: b, reason: collision with root package name */
    private int f197968b;

    /* renamed from: j, reason: collision with root package name */
    private int f197976j;

    /* renamed from: k, reason: collision with root package name */
    private int f197977k;

    /* renamed from: a, reason: collision with root package name */
    Context f197967a = null;

    /* renamed from: c, reason: collision with root package name */
    private int f197969c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f197970d = 0;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f197971e = null;

    /* renamed from: f, reason: collision with root package name */
    private int f197972f = 0;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f197973g = null;

    /* renamed from: h, reason: collision with root package name */
    private int f197974h = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f197975i = false;

    /* renamed from: l, reason: collision with root package name */
    private int f197978l = 640;

    /* renamed from: m, reason: collision with root package name */
    private int f197979m = 480;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f197980n = null;

    /* renamed from: o, reason: collision with root package name */
    private int f197981o = 0;

    /* renamed from: p, reason: collision with root package name */
    private byte[] f197982p = null;

    /* renamed from: q, reason: collision with root package name */
    private boolean f197983q = false;

    /* renamed from: r, reason: collision with root package name */
    public int f197984r = Integer.MIN_VALUE;

    /* renamed from: s, reason: collision with root package name */
    public int f197985s = Integer.MIN_VALUE;

    public a(int i3) {
        this.f197976j = 10;
        this.f197977k = 170;
        this.f197968b = i3;
        if (i3 == f197965t && com.tencent.mobileqq.ocr.data.b.a() != null) {
            this.f197976j = com.tencent.mobileqq.ocr.data.b.a().f254752h;
            this.f197977k = com.tencent.mobileqq.ocr.data.b.a().f254753i;
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARCloudImageSelect", 2, "init args ocr bestImgThreshold:" + this.f197976j + ",sameSceneDiff:" + this.f197977k);
            }
        }
    }

    public byte[] a() {
        return this.f197973g;
    }

    public void b(Context context) {
        this.f197967a = context;
    }

    public boolean c(byte[] bArr) {
        boolean nativeIsSameScene;
        if (!this.f197983q) {
            return false;
        }
        if (this.f197968b == f197965t) {
            System.arraycopy(bArr, 0, this.f197971e, 0, this.f197972f);
        } else {
            int i3 = this.f197969c;
            int i16 = this.f197978l;
            if (i3 == i16 && this.f197970d == this.f197979m) {
                System.arraycopy(bArr, 0, this.f197980n, 0, this.f197981o);
            } else {
                int i17 = (i3 - i16) / 2;
                int i18 = (this.f197970d - this.f197979m) / 2;
                for (int i19 = 0; i19 < this.f197979m; i19++) {
                    int i26 = ((i19 + i18) * this.f197969c) + i17;
                    byte[] bArr2 = this.f197980n;
                    int i27 = this.f197978l;
                    System.arraycopy(bArr, i26, bArr2, i19 * i27, i27);
                }
            }
        }
        try {
            if (this.f197968b == f197965t) {
                nativeIsSameScene = ARCloudImageFilter.nativeIsSameScene(this.f197971e, this.f197982p);
            } else {
                nativeIsSameScene = ARCloudImageFilter.nativeIsSameScene(this.f197980n, this.f197982p);
            }
            return nativeIsSameScene;
        } catch (Exception e16) {
            QLog.i("AREngine_ARCloudImageSelect", 1, "ARCloudImageFilter.nativeIsSameScene()" + e16.getMessage());
            return false;
        }
    }

    public boolean d(byte[] bArr, int i3, int i16) {
        long j3;
        try {
            if (this.f197969c == 0 || this.f197970d == 0) {
                QLog.i("AREngine_ARCloudImageSelect", 1, "selectImage mImgWidth .");
                this.f197969c = i3;
                this.f197970d = i16;
                int i17 = i3 * i16;
                this.f197972f = i17;
                int i18 = ((i3 * i16) * 3) / 2;
                this.f197974h = i18;
                this.f197971e = new byte[i17];
                this.f197973g = new byte[i18];
                this.f197982p = new byte[i17];
                if (i3 > i16) {
                    if (i3 >= 480 && i16 >= 480) {
                        this.f197978l = 480;
                        this.f197979m = 480;
                    } else {
                        this.f197978l = i3;
                        this.f197979m = i16;
                    }
                } else if (i3 >= 480 && i16 >= 480) {
                    this.f197978l = 480;
                    this.f197979m = 480;
                } else {
                    this.f197978l = i3;
                    this.f197979m = i16;
                }
                int i19 = this.f197978l * this.f197979m;
                this.f197981o = i19;
                this.f197980n = new byte[i19];
            }
            if (this.f197969c != i3 || this.f197970d != i16) {
                this.f197969c = i3;
                this.f197970d = i16;
                int i26 = i3 * i16;
                this.f197972f = i26;
                int i27 = ((i3 * i16) * 3) / 2;
                this.f197974h = i27;
                this.f197971e = new byte[i26];
                this.f197973g = new byte[i27];
                this.f197982p = new byte[i26];
                if (i3 > i16) {
                    if (i3 >= 480 && i16 >= 480) {
                        this.f197978l = 480;
                        this.f197979m = 480;
                    } else {
                        this.f197978l = i3;
                        this.f197979m = i16;
                    }
                } else if (i3 >= 480 && i16 >= 480) {
                    this.f197978l = 480;
                    this.f197979m = 480;
                } else {
                    this.f197978l = i3;
                    this.f197979m = i16;
                }
                int i28 = this.f197978l * this.f197979m;
                this.f197981o = i28;
                this.f197980n = new byte[i28];
                if (this.f197975i) {
                    try {
                        ARCloudImageFilter.nativeUninit();
                    } catch (Exception e16) {
                        QLog.i("AREngine_ARCloudImageSelect", 1, "ARCloudImageFilter.nativeUninit()" + e16.getMessage());
                    }
                    this.f197975i = false;
                }
            }
            if (!this.f197975i) {
                boolean e17 = NeonControl.d().e();
                try {
                    if (this.f197968b == f197965t) {
                        ARCloudImageFilter.nativeInitOcr(this.f197969c, this.f197970d, this.f197976j, this.f197977k, this.f197974h);
                    } else {
                        ARCloudImageFilter.nativeInit(this.f197978l, this.f197979m, this.f197976j, this.f197977k, this.f197974h);
                    }
                    if (e17) {
                        this.f197984r = ARCloudImageFilter.nativeSetNeonOpen(e17 ? 1 : 0);
                    } else {
                        this.f197984r = 0;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("AREngine_ARCloudImageSelect", 2, String.format("ARCloudImageFilter.nativeInit suc useLocalSo:%d neonOpened:%d", 0, Integer.valueOf(this.f197984r)));
                    }
                } catch (Exception e18) {
                    QLog.i("AREngine_ARCloudImageSelect", 1, "ARCloudImageFilter.nativeInit()" + e18.getMessage());
                }
                this.f197975i = true;
            }
            if (this.f197968b == f197965t) {
                System.arraycopy(bArr, 0, this.f197971e, 0, this.f197972f);
            } else {
                int i29 = this.f197969c;
                int i36 = this.f197978l;
                if (i29 == i36 && this.f197970d == this.f197979m) {
                    System.arraycopy(bArr, 0, this.f197980n, 0, this.f197981o);
                } else {
                    int i37 = (i29 - i36) / 2;
                    int i38 = (this.f197970d - this.f197979m) / 2;
                    for (int i39 = 0; i39 < this.f197979m; i39++) {
                        int i46 = ((i39 + i38) * this.f197969c) + i37;
                        byte[] bArr2 = this.f197980n;
                        int i47 = this.f197978l;
                        System.arraycopy(bArr, i46, bArr2, i39 * i47, i47);
                    }
                }
            }
            System.arraycopy(bArr, 0, this.f197973g, 0, this.f197974h);
            try {
                if (NeonControl.f197457e) {
                    j3 = System.currentTimeMillis();
                } else {
                    j3 = 0;
                }
                if (this.f197968b == f197965t) {
                    boolean nativeFilter = ARCloudImageFilter.nativeFilter(this.f197971e, this.f197973g);
                    this.f197983q = nativeFilter;
                    if (nativeFilter) {
                        System.arraycopy(this.f197971e, 0, this.f197982p, 0, this.f197972f);
                    }
                } else {
                    boolean nativeFilter2 = ARCloudImageFilter.nativeFilter(this.f197980n, this.f197973g);
                    this.f197983q = nativeFilter2;
                    if (nativeFilter2) {
                        System.arraycopy(this.f197980n, 0, this.f197982p, 0, this.f197981o);
                    }
                }
                if (NeonControl.f197457e) {
                    NeonControl.d().b(System.currentTimeMillis() - j3, this.f197984r);
                }
            } catch (Exception e19) {
                QLog.i("AREngine_ARCloudImageSelect", 1, "ARCloudImageFilter.nativeFilter()" + e19.getMessage());
            }
            return this.f197983q;
        } catch (OutOfMemoryError e26) {
            QLog.i("AREngine_ARCloudImageSelect", 1, "selectImage OutOfMemoryError msg:" + e26.getMessage());
            this.f197971e = null;
            this.f197973g = null;
            this.f197980n = null;
            this.f197969c = 0;
            this.f197970d = 0;
            this.f197982p = null;
            System.gc();
            return false;
        }
    }

    public void e() {
        if (this.f197975i) {
            ARCloudImageFilter.nativeUninit();
            this.f197975i = false;
        }
        this.f197969c = 0;
        this.f197970d = 0;
        this.f197976j = 10;
        this.f197977k = 170;
        this.f197971e = null;
        this.f197972f = 0;
        this.f197973g = null;
        this.f197974h = 0;
        this.f197978l = 0;
        this.f197979m = 0;
        this.f197980n = null;
        this.f197981o = 0;
        this.f197982p = null;
        this.f197983q = false;
    }
}
