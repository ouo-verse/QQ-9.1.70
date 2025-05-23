package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f258697a;

    /* renamed from: b, reason: collision with root package name */
    public long f258698b;

    /* renamed from: c, reason: collision with root package name */
    private long f258699c;

    /* renamed from: d, reason: collision with root package name */
    private long f258700d;

    /* renamed from: e, reason: collision with root package name */
    private long f258701e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f258702f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f258703g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f258704h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f258705i;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f258699c = -1L;
        this.f258700d = -1L;
        this.f258701e = -1L;
        c();
    }

    private void c() {
        this.f258697a = a.b("gifWifiPreDownloadLimit", 1000L) * 1024 * 1024;
        this.f258698b = a.b("gifXgPreDownloadLimit", 32L) * 1024 * 1024;
        if (QLog.isColorLevel()) {
            QLog.d("GIFPreDownloadLimit", 2, "initConfig, gifWifiPreDownloadLimit=", Long.valueOf(this.f258697a), " gifXgPreDownloadLimit=", Long.valueOf(this.f258698b));
        }
    }

    public static boolean d(MessageForPic messageForPic) {
        if (messageForPic == null) {
            return false;
        }
        int i3 = messageForPic.mNotPredownloadReason;
        if (i3 != -11 && i3 != 2) {
            return false;
        }
        return true;
    }

    public static boolean e(MessageForPic messageForPic, boolean z16, int i3) {
        if (messageForPic == null) {
            if (z16 && i3 == 6) {
                return true;
            }
            return false;
        }
        if (com.tencent.mobileqq.v.c(messageForPic.imageType) && i3 == 6) {
            return true;
        }
        return false;
    }

    public static boolean f(long j3, long j16) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16);
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
            return true;
        }
        return false;
    }

    private void g(boolean z16, boolean z17, long j3) {
        int i3;
        int i16;
        String str;
        String str2;
        String str3;
        String str4;
        int i17 = 1;
        if (z16) {
            if (!this.f258704h) {
                this.f258704h = true;
                i3 = 4;
            } else {
                i3 = -1;
            }
            if (z17 && !this.f258702f) {
                this.f258702f = true;
                i17 = 2;
                i16 = i17;
            }
            i16 = -1;
        } else {
            if (!this.f258705i) {
                this.f258705i = true;
                i3 = 3;
            } else {
                i3 = -1;
            }
            if (z17 && !this.f258703g) {
                this.f258703g = true;
                i16 = i17;
            }
            i16 = -1;
        }
        int i18 = i3;
        if (i18 > 0) {
            if (z16) {
                str4 = "gifWifiFirstFlag";
            } else {
                str4 = "gifXgFirstFlag";
            }
            a.e(str4, 1L);
            ReportController.o(null, "dc00898", "", "", "0X800B3BA", "0X800B3BA", i18, 0, "", "", "", "");
        }
        if (i16 > 0) {
            if (z16) {
                str3 = "gifWifiOverFlag";
            } else {
                str3 = "gifXgOverFlag";
            }
            a.e(str3, 1L);
            ReportController.o(null, "dc00898", "", "", "0X800B3BA", "0X800B3BA", i16, 0, "", "", "", "");
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (z16) {
            str = com.tencent.mobileqq.msf.core.x.q.f250391w;
        } else {
            str = "XG";
        }
        hashMap.put("NetworkType", str);
        if (z17) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("OverLimit", str2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AioGifPreDownload", true, -1L, j3, hashMap, null);
    }

    public void a(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Long.valueOf(j3));
            return;
        }
        if (z16) {
            this.f258699c += j3;
        } else {
            this.f258700d += j3;
        }
        a.e("gifWifiPreDownloadFlow", this.f258699c);
        a.e("gifXgPreDownloadFlow", this.f258700d);
        a.e("gifPreDownloadTimestamp", this.f258701e);
    }

    public boolean b(boolean z16, long j3) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z27 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3))).booleanValue();
        }
        if (this.f258699c < 0 || this.f258700d < 0 || this.f258701e < 0) {
            this.f258699c = a.b("gifWifiPreDownloadFlow", 0L);
            this.f258700d = a.b("gifXgPreDownloadFlow", 0L);
            long b16 = a.b("gifPreDownloadTimestamp", 0L);
            this.f258701e = b16;
            if (b16 == 0) {
                this.f258701e = System.currentTimeMillis();
            }
            if (a.b("gifWifiOverFlag", 0L) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f258702f = z17;
            if (a.b("gifXgOverFlag", 0L) == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            this.f258703g = z18;
            if (a.b("gifWifiFirstFlag", 0L) == 1) {
                z19 = true;
            } else {
                z19 = false;
            }
            this.f258704h = z19;
            if (a.b("gifXgFirstFlag", 0L) == 1) {
                z26 = true;
            } else {
                z26 = false;
            }
            this.f258705i = z26;
        }
        if (!f(this.f258701e, System.currentTimeMillis())) {
            this.f258699c = 0L;
            this.f258700d = 0L;
            this.f258701e = System.currentTimeMillis();
            this.f258702f = false;
            this.f258703g = false;
            this.f258704h = false;
            this.f258705i = false;
        }
        if (!z16 ? this.f258700d <= this.f258698b : this.f258699c <= this.f258697a) {
            z27 = false;
        }
        if (!z27) {
            a(z16, j3);
        }
        g(z16, z27, j3);
        return z27;
    }
}
