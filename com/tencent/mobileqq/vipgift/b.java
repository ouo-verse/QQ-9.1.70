package com.tencent.mobileqq.vipgift;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.h;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.servlet.s;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final String f313126d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.vipgift.a f313127e;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f313128f;

    /* renamed from: h, reason: collision with root package name */
    private String f313129h;

    /* renamed from: i, reason: collision with root package name */
    public long f313130i;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements com.tencent.biz.common.offline.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vipgift.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C8960b implements com.tencent.biz.common.offline.a {
        static IPatchRedirector $redirector_;

        C8960b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements com.tencent.biz.common.offline.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f313133d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f313134e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f313135f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f313136h;

        c(long j3, String str, long j16, String str2) {
            this.f313133d = j3;
            this.f313134e = str;
            this.f313135f = j16;
            this.f313136h = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, Long.valueOf(j3), str, Long.valueOf(j16), str2);
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VipGiftManager", 2, "checkUpAndNotifyByBid loaded,code:" + i3 + ",cost:" + (System.currentTimeMillis() - this.f313133d));
            }
            if (this.f313134e.equalsIgnoreCase("280")) {
                b.this.k("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
            }
            if (i3 != 0 && 8 != i3 && 5 != i3) {
                if (b.this.j(5L, this.f313135f) && (str2 = this.f313136h) != null) {
                    b.this.g(str2, this.f313135f);
                    return;
                }
                return;
            }
            if (b.this.j(2L, this.f313135f)) {
                b.this.g(this.f313134e, this.f313135f);
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else if (QLog.isColorLevel()) {
                QLog.d("VipGiftManager", 2, "checkUpAndNotifyByBid progress:" + i3);
            }
        }
    }

    public b(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f313126d = "VipGiftManager";
        this.f313127e = new com.tencent.mobileqq.vipgift.a();
        this.f313130i = 10000L;
        this.f313128f = qQAppInterface;
        this.f313129h = c();
        h();
    }

    private String e() {
        if (this.f313127e != null) {
            return this.f313127e.f313116a + "|" + this.f313127e.f313117b + "|" + this.f313127e.f313119d + "|" + this.f313127e.f313120e + "|" + this.f313127e.f313121f + "|" + this.f313127e.f313118c + "|" + this.f313127e.f313122g + "|" + this.f313127e.f313123h + "|" + this.f313127e.f313124i + "|" + this.f313127e.f313125j;
        }
        return null;
    }

    public void a(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, str2, Long.valueOf(j3));
        } else {
            HtmlOffline.j(str, this.f313128f, true, new c(System.currentTimeMillis(), str, j3, str2));
        }
    }

    public void b(long j3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
            return;
        }
        this.f313127e.f313124i = NetConnInfoCenter.getServerTimeMillis();
        j(1L, j3);
        try {
            Uri parse = Uri.parse(this.f313127e.f313123h);
            if (parse != null && parse.isHierarchical()) {
                str = parse.getQueryParameter("_bid");
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
                long currentTimeMillis = System.currentTimeMillis();
                boolean p16 = p(str);
                if (QLog.isColorLevel()) {
                    QLog.d("VipGiftManager", 2, "OfflineSecurity.verify bid:" + str + ",cost:" + (System.currentTimeMillis() - currentTimeMillis) + ",bigFlag:" + p16);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                boolean p17 = p("280");
                if (QLog.isColorLevel()) {
                    QLog.d("VipGiftManager", 2, "OfflineSecurity.verify smalbid:280,cost:" + (System.currentTimeMillis() - currentTimeMillis2) + ",smallFlag:" + p17);
                }
                if (systemNetwork == 0) {
                    if (p16) {
                        if (j(2L, j3)) {
                            g(str, j3);
                            return;
                        }
                        return;
                    } else {
                        if (p17 && j(2L, j3)) {
                            k("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
                            g("280", j3);
                            return;
                        }
                        return;
                    }
                }
                if (n(systemNetwork, p17, p16)) {
                    if (p17) {
                        if (j(2L, j3)) {
                            k("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
                            g("280", j3);
                        }
                        HtmlOffline.j("280", this.f313128f, true, new a());
                        return;
                    }
                    a("280", null, j3);
                    return;
                }
                if (p16) {
                    if (j(2L, j3)) {
                        g(str, j3);
                    }
                    HtmlOffline.j(str, this.f313128f, true, new C8960b());
                    return;
                }
                a(str, "280", j3);
                return;
            }
            j(5L, j3);
        } catch (Exception unused) {
            j(5L, j3);
        }
    }

    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "{\"model\":\"" + DeviceInfoMonitor.getModel() + "\",\"systemName\":\"android\",\"systemVersion\":\"" + Build.VERSION.RELEASE + "\"}";
    }

    public com.tencent.mobileqq.vipgift.a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.vipgift.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f313127e;
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.f313127e == null) {
            this.f313127e = new com.tencent.mobileqq.vipgift.a();
        }
        com.tencent.mobileqq.vipgift.a aVar = this.f313127e;
        if (aVar != null && aVar.f313121f == 1) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() - this.f313127e.f313124i;
            if (serverTimeMillis > this.f313130i || serverTimeMillis <= 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void g(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, Long.valueOf(j3));
            return;
        }
        NewIntent newIntent = new NewIntent(this.f313128f.getApplication(), s.class);
        newIntent.setAction("gif_ui_show");
        newIntent.putExtra("gif_ui_show_bid", Integer.parseInt(str));
        newIntent.putExtra("gif_ui_show_seq", j3);
        this.f313128f.startServlet(newIntent);
    }

    public void h() {
        String[] split;
        com.tencent.mobileqq.vipgift.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        String string = VasMMKV.getOldVipGift(this.f313128f.getAccount()).getString("Gif_Download_info_key_" + this.f313128f.getCurrentAccountUin(), null);
        if (string != null && this.f313127e != null && (split = string.split("\\|")) != null && split.length == 10 && (aVar = this.f313127e) != null) {
            aVar.f313116a = split[0];
            aVar.f313117b = split[1];
            aVar.f313119d = Long.parseLong(split[2]);
            this.f313127e.f313120e = Long.parseLong(split[3]);
            this.f313127e.f313121f = Long.parseLong(split[4]);
            this.f313127e.f313118c = Long.parseLong(split[5]);
            com.tencent.mobileqq.vipgift.a aVar2 = this.f313127e;
            aVar2.f313122g = split[6];
            aVar2.f313123h = split[7];
            aVar2.f313124i = Long.parseLong(split[8]);
            this.f313127e.f313125j = Long.parseLong(split[9]);
        }
    }

    public void i(String str, String str2, String str3, String str4) {
        String str5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, str3, str4);
            return;
        }
        if (str4 == null) {
            str5 = this.f313127e.f313122g;
        } else {
            str5 = str4;
        }
        ff.T(this.f313128f, "Vip_Gift", str, str, 0, 0, str2, str3, str5, this.f313129h);
    }

    public synchronized boolean j(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), Long.valueOf(j16))).booleanValue();
        }
        com.tencent.mobileqq.vipgift.a aVar = this.f313127e;
        if (j16 != aVar.f313118c) {
            return false;
        }
        if (j3 == 2 && aVar.f313121f == 6) {
            return false;
        }
        aVar.f313121f = j3;
        return q();
    }

    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.f313127e.f313122g = str;
            q();
        }
    }

    public boolean l(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, j3)).booleanValue();
        }
        com.tencent.mobileqq.vipgift.a aVar = this.f313127e;
        if (aVar != null) {
            aVar.f313125j = j3;
            return q();
        }
        return false;
    }

    public void m(com.tencent.mobileqq.vipgift.a aVar, BaseActivity baseActivity) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) aVar, (Object) baseActivity);
            return;
        }
        j(3L, aVar.f313118c);
        try {
            Uri parse = Uri.parse(aVar.f313122g);
            if (parse != null && parse.isHierarchical()) {
                str = parse.getQueryParameter("_bid");
                if (TextUtils.isEmpty(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("VipGiftManager", 2, "TextUtils.isEmpty(bid) false");
                    }
                    j(5L, aVar.f313118c);
                    return;
                }
            } else {
                str = null;
            }
            if (p(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("VipGiftManager", 2, "showGifAnnimate.veryfyBid(" + str + ") true,url:" + aVar.f313122g);
                }
                if (str.equalsIgnoreCase("280")) {
                    k("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
                }
                i("0X8004B41", "2", "1", aVar.f313122g);
                Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQTranslucentBrowserActivity.class);
                intent.putExtra("url", aVar.f313122g);
                intent.putExtra("Gif_msg_uniseq_key", aVar.f313118c);
                baseActivity.startActivity(intent);
                return;
            }
            if (p("280")) {
                if (QLog.isColorLevel()) {
                    QLog.d("VipGiftManager", 2, "showGifAnnimate.veryfyBid(" + str + ") false,url:" + aVar.f313122g);
                }
                k("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
                i("0X8004B41", "2", "1", aVar.f313122g);
                Intent intent2 = new Intent(BaseApplication.getContext(), (Class<?>) QQTranslucentBrowserActivity.class);
                intent2.putExtra("url", aVar.f313122g);
                intent2.putExtra("Gif_msg_uniseq_key", aVar.f313118c);
                baseActivity.startActivity(intent2);
                return;
            }
            j(5L, aVar.f313118c);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("VipGiftManager", 2, "exception bid");
            }
            j(5L, aVar.f313118c);
        }
    }

    public boolean n(int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        if (!z17 && i3 == 2) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean o(MessageForStructing messageForStructing) {
        AbsStructMsg absStructMsg;
        long j3;
        com.tencent.mobileqq.vipgift.a aVar;
        String queryParameter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageForStructing)).booleanValue();
        }
        if (messageForStructing == null || (absStructMsg = messageForStructing.structingMsg) == null) {
            return false;
        }
        i("0X8004B41", "1", "0", absStructMsg.mResid);
        if (this.f313127e == null) {
            this.f313127e = new com.tencent.mobileqq.vipgift.a();
        }
        try {
            Uri parse = Uri.parse(messageForStructing.structingMsg.mResid);
            if (parse != null && parse.isHierarchical()) {
                if (TextUtils.isEmpty(parse.getQueryParameter("_bid"))) {
                    return false;
                }
                try {
                    queryParameter = parse.getQueryParameter("_gv");
                } catch (Exception unused) {
                }
                if (!TextUtils.isEmpty(queryParameter)) {
                    j3 = Long.parseLong(queryParameter);
                    aVar = this.f313127e;
                    if (aVar.f313125j <= j3) {
                    }
                } else {
                    j3 = 0;
                    aVar = this.f313127e;
                    if (aVar.f313125j <= j3) {
                        i("0X8004B41", "2", "3", messageForStructing.structingMsg.mResid);
                        return false;
                    }
                    if (aVar != null && messageForStructing.structingMsg != null) {
                        long j16 = aVar.f313121f;
                        if ((j16 != 0 || messageForStructing.time >= aVar.f313119d) && j16 != 4 && j16 != 999 && j16 != 5 && j16 != 6 && !f()) {
                            i("0X8004B41", "2", "2", messageForStructing.structingMsg.mResid);
                        } else {
                            com.tencent.mobileqq.vipgift.a aVar2 = this.f313127e;
                            aVar2.f313116a = messageForStructing.selfuin;
                            aVar2.f313117b = messageForStructing.senderuin;
                            aVar2.f313119d = messageForStructing.time;
                            aVar2.f313120e = 0L;
                            aVar2.f313121f = 0L;
                            aVar2.f313118c = messageForStructing.uniseq;
                            String str = messageForStructing.structingMsg.mResid;
                            aVar2.f313123h = str;
                            aVar2.f313122g = str;
                            aVar2.f313124i = 0L;
                            try {
                                long parseLong = Long.parseLong(parse.getQueryParameter("_to").trim());
                                if (parseLong > 0) {
                                    this.f313130i = parseLong;
                                }
                            } catch (Exception unused2) {
                            }
                            return q();
                        }
                    }
                }
            }
        } catch (Exception unused3) {
        }
        return false;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    public boolean p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str) || HtmlOffline.z(str) == null) {
            return false;
        }
        String str2 = com.tencent.biz.common.offline.c.c(str) + str;
        boolean k3 = h.k(str2, str);
        if (!k3) {
            HtmlOffline.o(str2, str);
        }
        return k3;
    }

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        SharedPreferences.Editor edit = VasMMKV.getOldVipGift(this.f313128f.getAccount()).edit();
        edit.putString("Gif_Download_info_key_" + this.f313128f.getCurrentAccountUin(), e());
        if (QLog.isColorLevel()) {
            QLog.d("VipGiftManager", 2, "writeToSp:" + e());
        }
        return edit.commit();
    }
}
