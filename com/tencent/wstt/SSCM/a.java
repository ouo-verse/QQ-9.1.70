package com.tencent.wstt.SSCM;

import android.content.Context;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f384865a;

    /* renamed from: b, reason: collision with root package name */
    public int f384866b;

    /* renamed from: c, reason: collision with root package name */
    protected float f384867c;

    /* renamed from: d, reason: collision with root package name */
    protected int f384868d;

    /* renamed from: e, reason: collision with root package name */
    protected double f384869e;

    /* renamed from: f, reason: collision with root package name */
    protected long f384870f;

    /* renamed from: g, reason: collision with root package name */
    protected long f384871g;

    /* renamed from: h, reason: collision with root package name */
    protected int f384872h;

    /* renamed from: i, reason: collision with root package name */
    protected int f384873i;

    /* renamed from: j, reason: collision with root package name */
    protected int f384874j;

    /* renamed from: k, reason: collision with root package name */
    private float f384875k;

    /* renamed from: l, reason: collision with root package name */
    private float f384876l;

    /* renamed from: m, reason: collision with root package name */
    private float f384877m;

    /* renamed from: n, reason: collision with root package name */
    private float f384878n;

    /* renamed from: o, reason: collision with root package name */
    private float f384879o;

    /* renamed from: p, reason: collision with root package name */
    private float f384880p;

    /* renamed from: q, reason: collision with root package name */
    private int f384881q;

    /* renamed from: r, reason: collision with root package name */
    private int f384882r;

    /* renamed from: s, reason: collision with root package name */
    private int f384883s;

    /* renamed from: t, reason: collision with root package name */
    private int f384884t;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f384885u;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f384885u = false;
            e();
        }
    }

    private long b() {
        return new Date().getTime();
    }

    private long c() {
        return new Date().getTime();
    }

    public int a(Context context, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, context, Long.valueOf(j3))).intValue();
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        this.f384868d = systemNetwork;
        if (!this.f384885u) {
            if (systemNetwork != 1) {
                if (systemNetwork != 2) {
                    if (systemNetwork != 3) {
                        this.f384872h = 4096;
                    } else {
                        this.f384872h = 16384;
                    }
                } else {
                    this.f384872h = 8192;
                }
            } else {
                this.f384872h = 32768;
            }
        }
        if (j3 < FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE) {
            this.f384872h *= 4;
        }
        if (j3 - this.f384872h <= r7 / 2) {
            this.f384872h = (int) j3;
        }
        return this.f384872h;
    }

    public int d(Context context, long j3, long j16, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, context, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3))).intValue();
        }
        this.f384870f = c();
        if (j3 < FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE) {
            this.f384883s = 1;
        } else {
            this.f384883s = 2;
        }
        if (true == this.f384865a) {
            e();
            int a16 = a(context, j3);
            this.f384873i = a16;
            this.f384865a = false;
            return a16;
        }
        int i17 = this.f384873i;
        float f16 = (float) (i17 / this.f384869e);
        this.f384876l = f16;
        float f17 = this.f384878n;
        if (0.0f == f17) {
            this.f384878n = f16;
        } else {
            this.f384878n = (float) ((f16 * 0.8d) + (f17 * 0.19999999999999996d));
        }
        int i18 = this.f384866b;
        if (i18 != 2) {
            int i19 = this.f384884t + 1;
            this.f384884t = i19;
            if (this.f384877m == 0.0f) {
                this.f384867c = 1.0f;
                if (i19 == this.f384883s) {
                    this.f384875k = this.f384878n;
                }
            } else if (i19 == this.f384883s) {
                this.f384867c = (float) (((this.f384878n - r9) / this.f384875k) / ((i17 - this.f384874j) / (this.f384872h + 0.0d)));
            }
        }
        if (i18 != 0) {
            if (i18 != 1) {
                if (i18 == 2) {
                    if (Math.abs(this.f384878n - this.f384879o) > this.f384879o * 0.2d) {
                        this.f384881q++;
                    } else {
                        this.f384881q = 0;
                    }
                    if (this.f384881q < this.f384882r) {
                        this.f384866b = 2;
                    } else {
                        this.f384881q = 0;
                        this.f384866b = 0;
                        this.f384873i = this.f384872h;
                        this.f384877m = 0.0f;
                        this.f384874j = 0;
                        this.f384878n = 0.0f;
                        this.f384884t = 0;
                    }
                }
            } else if (this.f384884t == this.f384883s) {
                if (this.f384867c < 0.09d) {
                    this.f384866b = 2;
                    float f18 = this.f384878n;
                    this.f384879o = f18;
                    this.f384877m = 0.0f;
                    this.f384874j = 0;
                    this.f384880p = f18;
                } else {
                    this.f384866b = 1;
                    this.f384874j = i17;
                    this.f384873i = (int) (i17 * 1.05d);
                    float f19 = this.f384878n;
                    this.f384877m = f19;
                    this.f384880p = f19;
                    this.f384878n = 0.0f;
                    this.f384884t = 0;
                }
            }
        } else if (this.f384884t == this.f384883s) {
            if (this.f384867c < 0.09d) {
                this.f384866b = 1;
                this.f384873i = (int) (this.f384874j * 1.05d);
            } else {
                this.f384866b = 0;
                this.f384874j = i17;
                this.f384873i = i17 * 2;
                this.f384877m = this.f384878n;
            }
            this.f384878n = 0.0f;
            this.f384884t = 0;
        }
        long j17 = j3 - j16;
        if (j17 - this.f384873i <= r6 / 2) {
            this.f384873i = (int) j17;
        }
        if (i3 > 0 && ((i16 = this.f384873i) < 0 || i16 > i3)) {
            this.f384873i = i3;
        } else if (this.f384873i < 0) {
            this.f384881q = 0;
            this.f384866b = 0;
            this.f384873i = this.f384872h;
            this.f384877m = 0.0f;
            this.f384874j = 0;
            this.f384878n = 0.0f;
            this.f384884t = 0;
        }
        return this.f384873i;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f384865a = true;
        this.f384866b = 0;
        this.f384872h = 0;
        this.f384873i = 0;
        this.f384874j = 0;
        this.f384875k = 0.0f;
        this.f384876l = 0.0f;
        this.f384877m = 0.0f;
        this.f384878n = 0.0f;
        this.f384869e = 0.0d;
        this.f384870f = 0L;
        this.f384871g = 0L;
        this.f384867c = 0.0f;
        this.f384880p = 0.0f;
        this.f384881q = 0;
        this.f384884t = 0;
        this.f384882r = 3;
        this.f384883s = 2;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f384871g = b();
        this.f384869e = (r0 - this.f384870f) / 1000.0d;
        QLog.d(JobDbManager.TBL_UPLOAD, 2, "sendFilePakage time:" + this.f384869e);
    }
}
