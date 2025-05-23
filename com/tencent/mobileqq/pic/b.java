package com.tencent.mobileqq.pic;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.TimeZone;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f258636h;

    /* renamed from: i, reason: collision with root package name */
    public static long f258637i;

    /* renamed from: j, reason: collision with root package name */
    public static a f258638j;

    /* renamed from: a, reason: collision with root package name */
    protected AppInterface f258639a;

    /* renamed from: b, reason: collision with root package name */
    protected long f258640b;

    /* renamed from: c, reason: collision with root package name */
    protected long f258641c;

    /* renamed from: d, reason: collision with root package name */
    protected long f258642d;

    /* renamed from: e, reason: collision with root package name */
    protected long f258643e;

    /* renamed from: f, reason: collision with root package name */
    protected long f258644f;

    /* renamed from: g, reason: collision with root package name */
    protected long f258645g;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f258646a;

        /* renamed from: b, reason: collision with root package name */
        private long f258647b;

        /* renamed from: c, reason: collision with root package name */
        private long f258648c;

        /* renamed from: d, reason: collision with root package name */
        public long f258649d;

        /* renamed from: e, reason: collision with root package name */
        public long f258650e;

        /* renamed from: f, reason: collision with root package name */
        public long f258651f;

        /* renamed from: g, reason: collision with root package name */
        public long f258652g;

        /* renamed from: h, reason: collision with root package name */
        private SharedPreferences f258653h;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f258646a = 0L;
            this.f258647b = 0L;
            this.f258648c = 0L;
            this.f258649d = 0L;
            this.f258650e = 0L;
            this.f258651f = 0L;
            this.f258652g = 0L;
            d();
        }

        public synchronized boolean a(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, j3)).booleanValue();
            }
            if (this.f258647b == 0) {
                long offset = TimeZone.getDefault().getOffset(this.f258646a);
                long j16 = (this.f258646a + offset) / 86400000;
                Long.signum(j16);
                long j17 = (j16 * 86400000) - offset;
                this.f258648c = j17;
                this.f258647b = j17 + 86400000;
            }
            if (j3 <= this.f258647b && j3 >= this.f258648c) {
                return true;
            }
            this.f258647b = 0L;
            this.f258648c = 0L;
            this.f258652g = 0L;
            this.f258651f = 0L;
            this.f258650e = 0L;
            this.f258649d = 0L;
            this.f258646a = j3;
            return false;
        }

        public synchronized void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            SharedPreferences.Editor edit = this.f258653h.edit();
            edit.putLong("key_update_time", this.f258646a);
            edit.putLong("key_xg_c2c", this.f258649d);
            edit.putLong("key_xg_grp", this.f258650e);
            edit.putLong("key_wifi_c2c", this.f258651f);
            edit.putLong("key_wifi_grp", this.f258652g);
            edit.commit();
        }

        public synchronized long[] c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (long[]) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            a(System.currentTimeMillis());
            return new long[]{this.f258649d, this.f258650e, this.f258651f, this.f258652g};
        }

        void d() {
            SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("sp_pic_predown", 0);
            this.f258653h = sharedPreferences;
            this.f258646a = sharedPreferences.getLong("key_update_time", System.currentTimeMillis());
            this.f258649d = this.f258653h.getLong("key_xg_c2c", 0L);
            this.f258650e = this.f258653h.getLong("key_xg_grp", 0L);
            this.f258651f = this.f258653h.getLong("key_wifi_c2c", 0L);
            this.f258652g = this.f258653h.getLong("key_wifi_grp", 0L);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17461);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f258636h = true;
        f258637i = 0L;
        f258638j = null;
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f258642d = QZoneHelper.Constants.SUPPORT_MIX_MUSIC_DEFAULT;
        this.f258643e = GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV;
        this.f258644f = GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV;
        this.f258645g = GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV;
    }

    public static final void g() {
        if (f258638j == null) {
            synchronized (a.class) {
                if (f258638j == null) {
                    f258638j = new a();
                }
            }
        }
    }

    public static final void h() {
        g();
        f258638j.b();
    }

    public int c(long j3, int i3, int i16, boolean z16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17))).intValue();
        }
        i();
        boolean l3 = l();
        if (QLog.isColorLevel()) {
            f.b("PIC_TAG_PRELOAD", "isOverLimit", "isInDPCWhiteList:" + l3);
        }
        if (i16 != 0 && (!l3 || i16 == 3)) {
            if (i16 == 1) {
                long j16 = this.f258640b;
                long j17 = this.f258643e;
                if (j16 >= j17) {
                    o.a(i16, j17);
                    f.b("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + i16 + ",picTrafficFlowXG:" + this.f258640b + ",PreDownMax4GFlow:" + this.f258643e);
                    return -8;
                }
            } else if (i16 == 2) {
                long j18 = this.f258640b;
                long j19 = this.f258644f;
                if (j18 >= j19) {
                    o.a(i16, j19);
                    f.b("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + i16 + ",picTrafficFlowXG:" + this.f258640b + ",PreDownMax3GFlow:" + this.f258644f);
                    return -8;
                }
            } else if (i16 == 3) {
                long j26 = this.f258640b;
                long j27 = this.f258645g;
                if (j26 >= j27) {
                    o.a(i16, j27);
                    f.b("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + i16 + ",picTrafficFlowXG:" + this.f258640b + ",PreDownMax2GFlow:" + this.f258645g);
                    return -8;
                }
            }
        } else {
            long j28 = this.f258641c;
            long j29 = this.f258642d;
            if (j28 >= j29) {
                o.a(i16, j29);
                f.b("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + i16 + ",picTrafficFlowWIFI:" + this.f258641c);
                return -8;
            }
        }
        return 0;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        g();
        long[] c16 = f258638j.c();
        this.f258640b = c16[0] + c16[1];
        this.f258641c = c16[2] + c16[3];
        if (QLog.isColorLevel()) {
            f.c("PIC_TAG_PRELOAD", "", "updateTrafficData ", "picTrafficFlowXG:" + this.f258640b + ",C2CPicDownFlowXG:" + c16[0] + ",Group/DiscussPicDownFlowXG:" + c16[1] + ",picTrafficFlowWIFI:" + this.f258641c + ",C2CPicDownFlowWIFI:" + c16[2] + ",Group/DiscussPicDownFlowWIFI:" + c16[3]);
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        f258636h = com.tencent.mobileqq.pic.a.c("PicPreDownSwitchNew", Boolean.TRUE).booleanValue();
        f258637i = com.tencent.mobileqq.pic.a.b("PicAuDownTimePoint", 0L);
        this.f258642d = com.tencent.mobileqq.pic.a.b("MaxWifiFlow", QZoneHelper.Constants.SUPPORT_MIX_MUSIC_DEFAULT);
        this.f258643e = com.tencent.mobileqq.pic.a.b("Max4GFlow", GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV);
        this.f258644f = com.tencent.mobileqq.pic.a.b("Max3GFlow", GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV);
        this.f258645g = com.tencent.mobileqq.pic.a.b("Max2GFlow", GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV);
        if (QLog.isColorLevel()) {
            QLog.d("PIC_TAG_PRELOAD.BaseStrategy", 2, "initConfig(): PreDownUseLocalFlowSet=" + f258636h + " PicAuDownTimePoint=" + f258637i + " PreDownMaxWifiFlow=" + this.f258642d + " PreDownMax4GFlow=" + this.f258643e + " PreDownMax3GFlow=" + this.f258644f + " PreDownMax2GFlow=" + this.f258645g);
        }
    }

    public void k(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
        } else {
            this.f258639a = appInterface;
            j();
        }
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return ((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name());
    }
}
