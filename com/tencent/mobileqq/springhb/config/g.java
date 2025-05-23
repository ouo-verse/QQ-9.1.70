package com.tencent.mobileqq.springhb.config;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.ad;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.entry.model.EntryConfigBean;
import com.tencent.mobileqq.springhb.entry.model.TimeInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g implements Manager, Handler.Callback {
    static IPatchRedirector $redirector_;
    private volatile boolean C;
    private volatile boolean D;
    private volatile boolean E;
    private int F;
    private Handler G;
    private volatile a H;
    private volatile a I;
    private volatile Bundle J;
    private boolean K;

    /* renamed from: d, reason: collision with root package name */
    private long f288998d;

    /* renamed from: e, reason: collision with root package name */
    private final AppInterface f288999e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f289000f;

    /* renamed from: h, reason: collision with root package name */
    private final b f289001h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f289002i;

    /* renamed from: m, reason: collision with root package name */
    private volatile long f289003m;

    public g(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.H = new a();
        this.I = new a();
        this.J = null;
        this.K = false;
        this.f288999e = qQAppInterface;
        this.f289000f = qQAppInterface.getApplication().getApplicationContext();
        this.f289001h = new b();
        this.G = new Handler(ThreadManagerV2.getQQCommonThreadLooper(), this);
    }

    private void A() {
        QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "onReqUnitedConfigTimeOut isRequestingWaitTime:" + this.C + " isRequestingUnitedConfig" + this.f289002i);
        if (!this.C && !this.f289002i) {
            return;
        }
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsStringAsync("102704", "", new py2.a() { // from class: com.tencent.mobileqq.springhb.config.d
            @Override // py2.a
            public final void a(Object obj) {
                g.this.r((String) obj);
            }
        });
    }

    private void B(Integer num, Bundle bundle) {
        QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "onReqWaitTimeFinished retCode:" + num + " isRequestingWaitTime:" + this.C);
        if (!this.C) {
            return;
        }
        if (num.intValue() != 0) {
            bundle = null;
        }
        this.J = bundle;
        this.C = false;
        x();
    }

    private void C(int i3, int i16, int i17, int i18, String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).gameHBConfigReport(i3, i16, 1013, i17, i18, true, str);
        }
    }

    private void D(int i3, String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportGameHBConfigCoverage(1, 0, 1013, 0, i3, true, MD5.toMD5(str));
    }

    private void E(AppInterface appInterface, int i3) {
        long longValue;
        int i16;
        int i17;
        boolean z16;
        try {
            int i18 = i();
            int j3 = j();
            int k3 = k();
            long h16 = h();
            Long a16 = pd0.b.a();
            if (a16 == null) {
                longValue = 0;
            } else {
                longValue = a16.longValue();
            }
            long j16 = longValue;
            if (h16 != j16) {
                i16 = 0;
            } else {
                i16 = j3;
            }
            if (i3 == 3) {
                i17 = 0;
            } else {
                i17 = i18;
            }
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(k3);
            objArr[1] = Integer.valueOf(i17);
            objArr[2] = Integer.valueOf(i16);
            if (h16 != j16) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[3] = Boolean.valueOf(z16);
            objArr[4] = Boolean.FALSE;
            QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, String.format("getEntryConfig localTaskId=%s localVersion=%s localPeakVersion=%s adCodeChanged=%b useDebugAdcode=%b", objArr));
            m(i3, i17, i16, 0, 0, null, null, j16, true);
        } catch (Exception e16) {
            ((ISpringHbReportApi) appInterface.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(301, e16, new String[0]);
            QLog.e("SpringHb_SpringHbEntranceConfigManager", 1, "getEntryConfig fail." + e16.getMessage(), e16);
        }
    }

    private void F(int i3) {
        this.F = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).getConfigVersion("102704");
        QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "reqEntryConfigByUnitedConfig reqOccasion:" + i3 + " reqGameHBUnitedConfigVersion:" + this.F);
        if (i3 == 0) {
            this.f289002i = true;
            H();
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (i3 != 3 && Math.abs(serverTimeMillis - this.f289003m) <= 3600000) {
            this.f289002i = false;
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("102704");
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).fetch(arrayList, true);
        this.f289002i = true;
        H();
    }

    private void G(int i3) {
        long e16 = e();
        this.I.f289013j = e16;
        this.I.f289011h = i3;
        this.C = true;
        com.tencent.mobileqq.springhb.servlet.c.e(e16, new Function2() { // from class: com.tencent.mobileqq.springhb.config.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit s16;
                s16 = g.this.s((Integer) obj, (Bundle) obj2);
                return s16;
            }
        });
    }

    private void H() {
        this.G.removeMessages(1);
        this.G.sendEmptyMessageDelayed(1, 8000L);
    }

    private void I(String str) {
        int hashCode;
        boolean z16;
        String str2;
        boolean z17 = false;
        if (TextUtils.isEmpty(str)) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i3 = i();
        if (hashCode != i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "updateGameHBUnitedConfig newConfigVersion=" + hashCode + " localUsedConfigVersion=" + i3);
        this.I.f289004a = z16;
        this.I.f289006c = hashCode;
        this.I.f289008e = 0;
        a aVar = this.I;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        aVar.f289009f = str2;
        a aVar2 = this.I;
        if (str != null) {
            z17 = true;
        }
        aVar2.f289012i = z17;
        this.I.a();
        int configVersion = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).getConfigVersion("102704");
        if (this.F != configVersion) {
            D(configVersion, this.I.f289009f);
        }
    }

    private long e() {
        Long a16 = pd0.b.a();
        if (a16 == null) {
            return 0L;
        }
        return a16.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(String str) {
        I(str);
        QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "onConfigUpdated end loading local config.");
        f(this.f288999e, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(String str) {
        I(str);
        QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "onReqUnitedConfigFinished end loading local config.");
        this.f289002i = false;
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(String str) {
        I(str);
        this.C = false;
        this.f289002i = false;
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit s(Integer num, Bundle bundle) {
        B(num, bundle);
        return null;
    }

    private String t(a aVar, a aVar2) {
        String str;
        String str2 = null;
        if (aVar == null) {
            str = null;
        } else {
            str = aVar.f289009f;
        }
        if (aVar2 != null) {
            str2 = aVar2.f289009f;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("DragonGooseConfig");
            if (optJSONObject == null) {
                return str2;
            }
            JSONObject jSONObject = new JSONObject(str2);
            jSONObject.put("DragonGooseConfig", optJSONObject);
            return jSONObject.toString();
        } catch (Throwable th5) {
            QLog.e("SpringHb_SpringHbEntranceConfigManager", 1, "moveDragonData error=", th5);
            return "";
        }
    }

    private boolean u(int i3) {
        if (i3 != 3 && i3 != 2 && i3 != 5) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            if (Math.abs(serverTimeMillis - this.f288998d) <= 3600000) {
                return false;
            }
            this.f288998d = serverTimeMillis;
        }
        return true;
    }

    private void v() {
        QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "onConfigUpdated start loading local config.");
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsStringAsync("102704", "", new py2.a() { // from class: com.tencent.mobileqq.springhb.config.e
            @Override // py2.a
            public final void a(Object obj) {
                g.this.p((String) obj);
            }
        });
    }

    private synchronized void w() {
        a aVar;
        b bVar;
        int hashCode;
        boolean z16;
        QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "onGetEntryConfig isRequestingWaitTime=" + this.C + " isRequestingUnitedConfig=" + this.f289002i + " isRequestingManageConfig=" + this.D);
        if (!this.f289002i && !this.C && !this.D) {
            try {
                if (this.E) {
                    aVar = new a(this.I);
                    String t16 = t(this.H, aVar);
                    aVar.f289009f = t16;
                    if (TextUtils.isEmpty(t16)) {
                        hashCode = 0;
                    } else {
                        hashCode = aVar.f289009f.hashCode();
                    }
                    aVar.f289006c = hashCode;
                    if (hashCode != i()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    aVar.f289004a = z16;
                    aVar.b(this, this.J, "extra_wait_time_list");
                } else {
                    aVar = new a(this.H);
                }
                bVar = this.f289001h;
            } catch (Throwable th5) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(302, th5, new String[0]);
                    QLog.e("SpringHb_SpringHbEntranceConfigManager", 1, th5.getMessage(), th5);
                }
            }
            if (bVar == null) {
                QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "onGetEntryConfigByUnitedConfig processor=" + this.f289001h + " config=" + aVar);
                return;
            }
            if (!bVar.t(aVar.f289004a, aVar.f289005b, aVar.f289006c, aVar.f289007d, aVar.f289008e, aVar.f289009f, aVar.f289010g, aVar.f289011h, aVar.f289012i, aVar.f289013j) && this.E) {
                C(2, 4, 0, aVar.f289006c, "");
            }
        }
    }

    private void x() {
        QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "onGetEntryConfigByUnitedConfig isRequestingWaitTime=" + this.C + " isRequestingUnitedConfig=" + this.f289002i);
        if (!this.C && !this.f289002i) {
            this.G.removeMessages(1);
            w();
        }
    }

    public void f(AppInterface appInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appInterface, i3);
            return;
        }
        QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, String.format("getEntryConfig app=%s reqOccasion=%s close=%b", appInterface, Integer.valueOf(i3), Boolean.FALSE));
        if (appInterface == null) {
            return;
        }
        if (!u(i3)) {
            QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "getEntryConfig don't need req");
            return;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102702", true)) {
            this.E = true;
            G(i3);
            F(i3);
        } else {
            this.E = false;
        }
        E(appInterface, i3);
    }

    public void g(QQAppInterface qQAppInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, String.format("getEntryConfigByPush app=%s pushVersion=%s", qQAppInterface, Integer.valueOf(i3)));
        }
        if (qQAppInterface != null && i3 >= 0) {
            try {
                b bVar = this.f289001h;
                if (bVar != null) {
                    int e16 = bVar.e();
                    if (QLog.isColorLevel()) {
                        QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, String.format("getEntryConfigByPush app=%s localVersion=%s", qQAppInterface, Integer.valueOf(e16)));
                    }
                    if (e16 != i3) {
                        f(qQAppInterface, 2);
                    } else {
                        QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "getEntryConfigByPush push version is same as local.");
                    }
                }
            } catch (Exception e17) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(312, e17, i3 + "");
                }
                QLog.e("SpringHb_SpringHbEntranceConfigManager", 1, "getEntryConfigByPush fail." + e17.getMessage(), e17);
            }
        }
    }

    public long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        b bVar = this.f289001h;
        if (bVar != null) {
            return bVar.c();
        }
        return 0L;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 3) {
                v();
                return false;
            }
            return false;
        }
        A();
        return false;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        b bVar = this.f289001h;
        if (bVar != null) {
            return bVar.e();
        }
        return 0;
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        b bVar = this.f289001h;
        if (bVar != null) {
            return bVar.h();
        }
        return 0;
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        b bVar = this.f289001h;
        if (bVar != null) {
            return bVar.n();
        }
        return 0;
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.F;
    }

    public void m(int i3, int i16, int i17, int i18, int i19, byte[] bArr, byte[] bArr2, long j3, boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), bArr, bArr2, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        try {
            QLog.d("SpringHb_SpringHbEntranceConfigManager", 1, String.format("getSpringFestivalConfig fromStart=%b ver=%d peakVer=%d offset=%s taskId=%d adcode=%d reqOccation=%d", Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Long.valueOf(j3), Integer.valueOf(i3)));
            NewIntent newIntent = new NewIntent(this.f289000f, h.class);
            newIntent.putExtra("k_cmd", 1);
            newIntent.putExtra("k_req_occasion", i3);
            newIntent.putExtra("k_offset", i18);
            newIntent.putExtra("k_id", i19);
            newIntent.putExtra("k_version", i16);
            newIntent.putExtra("k_peak_version", i17);
            newIntent.putExtra("key_req_adcode", j3);
            newIntent.putExtra("k_cookie", bArr);
            newIntent.putExtra("k_buff", bArr2);
            if (i18 != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            newIntent.putExtra("k_new_page", z17);
            newIntent.putExtra("k_retry", 0);
            this.f288999e.startServlet(newIntent);
            this.D = true;
        } catch (Exception e16) {
            QLog.e("SpringHb_SpringHbEntranceConfigManager", 1, "getEntryConfig fail." + e16.getMessage(), e16);
        }
    }

    public EntryConfigBean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (EntryConfigBean) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        b bVar = this.f289001h;
        if (bVar == null) {
            if (QLog.isColorLevel()) {
                QLog.i("SpringHb_SpringHbEntranceConfigManager", 2, "getSpringHbEntranceConfBean mEntryConfigProcessor is empty!");
                return null;
            }
            return null;
        }
        return bVar.k();
    }

    public EntryConfigBean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (EntryConfigBean) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        b bVar = this.f289001h;
        if (bVar == null) {
            if (QLog.isColorLevel()) {
                QLog.i("SpringHb_SpringHbEntranceConfigManager", 2, "getSpringHbEntranceConfBeanFromCache mEntryConfigProcessor is empty!");
                return null;
            }
            return null;
        }
        return bVar.l();
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        this.G.removeCallbacksAndMessages(null);
        this.I = new a();
        this.H = new a();
        this.f289002i = false;
        this.f289003m = 0L;
        this.C = false;
        this.D = false;
        this.F = 0;
        this.E = false;
    }

    public boolean y(boolean z16, boolean z17, int i3, int i16, int i17, String str, List<Integer> list, int i18, boolean z18, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str, list, Integer.valueOf(i18), Boolean.valueOf(z18), Long.valueOf(j3))).booleanValue();
        }
        this.H.f289004a = z16;
        this.H.f289005b = z17;
        this.H.f289006c = i3;
        this.H.f289007d = i16;
        this.H.f289008e = i17;
        this.H.f289009f = str;
        this.H.f289010g = list;
        this.H.f289011h = i18;
        this.H.f289012i = z18;
        this.H.f289013j = j3;
        this.D = false;
        w();
        return true;
    }

    public synchronized void z(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "onReqUnitedConfigFinished isSuccess=" + z16 + " isRequestingUnitedConfig:" + this.f289002i);
        this.f289003m = NetConnInfoCenter.getServerTimeMillis();
        if (!this.f289002i) {
            if (this.F == 0) {
                QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "onReqUnitedConfigFinished config updated.");
                this.G.sendEmptyMessageDelayed(3, 1000L);
            }
            return;
        }
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsStringAsync("102704", "", new py2.a() { // from class: com.tencent.mobileqq.springhb.config.f
            @Override // py2.a
            public final void a(Object obj) {
                g.this.q((String) obj);
            }
        });
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f289004a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f289005b;

        /* renamed from: c, reason: collision with root package name */
        public int f289006c;

        /* renamed from: d, reason: collision with root package name */
        public int f289007d;

        /* renamed from: e, reason: collision with root package name */
        public int f289008e;

        /* renamed from: f, reason: collision with root package name */
        public String f289009f;

        /* renamed from: g, reason: collision with root package name */
        public List<Integer> f289010g;

        /* renamed from: h, reason: collision with root package name */
        public int f289011h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f289012i;

        /* renamed from: j, reason: collision with root package name */
        public long f289013j;

        /* renamed from: k, reason: collision with root package name */
        private TimeInfo f289014k;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f289010g = new ArrayList();
                this.f289009f = "";
            }
        }

        private ArrayList<Integer> c(Bundle bundle, String str) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (bundle == null) {
                return arrayList;
            }
            long[] longArray = bundle.getLongArray(str);
            if (longArray == null) {
                return arrayList;
            }
            for (long j3 : longArray) {
                arrayList.add(Integer.valueOf((int) j3));
            }
            return arrayList;
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            this.f289014k = new TimeInfo(0L, 0L);
            if (TextUtils.isEmpty(this.f289009f)) {
                return;
            }
            try {
                JSONObject optJSONObject = new JSONObject(this.f289009f).optJSONObject("Common");
                if (optJSONObject != null) {
                    this.f289014k.begin = ad.d(optJSONObject.optString("BeginTime"));
                    this.f289014k.end = ad.d(optJSONObject.optString("EndTime"));
                }
            } catch (Throwable th5) {
                QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "readConfigTime e:", th5);
            }
        }

        public void b(g gVar, Bundle bundle, String str) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, gVar, bundle, str);
                return;
            }
            ArrayList<Integer> c16 = c(bundle, str);
            int j3 = gVar.j();
            int hashCode = c16.hashCode();
            if (j3 != hashCode) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f289007d = hashCode;
            this.f289005b = z16;
            this.f289010g = c16;
            QLog.i("SpringHb_SpringHbEntranceConfigManager", 1, "readPeakData localPeakVersion:" + j3 + " newPeakVersion:" + hashCode);
        }

        public a(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                return;
            }
            this.f289004a = aVar.f289004a;
            this.f289005b = aVar.f289005b;
            this.f289006c = aVar.f289006c;
            this.f289007d = aVar.f289007d;
            this.f289008e = aVar.f289008e;
            this.f289009f = aVar.f289009f;
            this.f289010g = aVar.f289010g;
            this.f289011h = aVar.f289011h;
            this.f289012i = aVar.f289012i;
            this.f289013j = aVar.f289013j;
        }
    }
}
