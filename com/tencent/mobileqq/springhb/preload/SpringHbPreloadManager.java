package com.tencent.mobileqq.springhb.preload;

import android.os.Bundle;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.ad;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.springhb.config.SpringHbCommonConfProcessor;
import com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.springhb.entry.model.BaseActivityData;
import com.tencent.mobileqq.springhb.entry.model.DragonCardConfigData;
import com.tencent.mobileqq.springhb.entry.model.DragonCardData;
import com.tencent.mobileqq.springhb.entry.model.EntryConfigBean;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import tencent.im.spring_hb.Preload$NYCommonInfo;
import tencent.im.spring_hb.Preload$SsoNYGetPreloadReq;
import tencent.im.spring_hb.Preload$SsoNYGetPreloadRsp;

/* loaded from: classes18.dex */
public class SpringHbPreloadManager implements Manager, BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final QQAppInterface f289476d;

    /* renamed from: e, reason: collision with root package name */
    private i f289477e;

    /* renamed from: f, reason: collision with root package name */
    private i f289478f;

    /* renamed from: h, reason: collision with root package name */
    private i f289479h;

    public SpringHbPreloadManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f289476d = qQAppInterface;
            o();
        }
    }

    private boolean b() {
        Manager manager = this.f289476d.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
        if (manager instanceof SpringFestivalEntryManager) {
            return ((SpringFestivalEntryManager) manager).s();
        }
        return false;
    }

    private void c(int i3) {
        j.b(this.f289476d, i3);
        kl2.a h16 = j(i3).h();
        if (h16 != null) {
            h16.deleteResFromLocal();
        }
    }

    private NewIntent d(byte[] bArr, int i3) {
        NewIntent newIntent = new NewIntent(this.f289476d.getApp(), k.class);
        byte[] b16 = fh.b(bArr);
        QLog.i("SpringHb_Preload_SpringHbPreloadManager", 1, "actType:" + i3);
        newIntent.putExtra("act_type", i3);
        newIntent.putExtra("data", b16);
        return newIntent;
    }

    private Preload$NYCommonInfo e() {
        Preload$NYCommonInfo preload$NYCommonInfo = new Preload$NYCommonInfo();
        preload$NYCommonInfo.platform.set(1);
        preload$NYCommonInfo.qqVersion.set(AppSetting.f99551k);
        preload$NYCommonInfo.model.set(ah.F());
        preload$NYCommonInfo.brand.set(ah.C());
        preload$NYCommonInfo.ver.set(ah.t());
        preload$NYCommonInfo.appid.set(AppSetting.f());
        preload$NYCommonInfo.net.set(ad.c());
        return preload$NYCommonInfo;
    }

    private String f() {
        Manager manager = this.f289476d.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
        if (manager instanceof SpringFestivalEntryManager) {
            return ((SpringFestivalEntryManager) manager).E();
        }
        return "";
    }

    private int k() {
        Manager manager = this.f289476d.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
        if (manager instanceof SpringFestivalEntryManager) {
            if (((SpringFestivalEntryManager) manager).X()) {
                return 0;
            }
            return 1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i3, boolean z16, Bundle bundle) {
        byte[] byteArray = bundle.getByteArray("data");
        int i16 = bundle.getInt("act_type", 0);
        if (QLog.isColorLevel()) {
            QLog.e("SpringHb_Preload_SpringHbPreloadManager", 1, String.format("handleOnReceive type=%s isSuccess=%s actType=%s", Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16)));
        }
        if (byteArray != null && z16) {
            Preload$SsoNYGetPreloadRsp preload$SsoNYGetPreloadRsp = new Preload$SsoNYGetPreloadRsp();
            try {
                preload$SsoNYGetPreloadRsp.mergeFrom(byteArray);
                String str = preload$SsoNYGetPreloadRsp.conf.get();
                int i17 = preload$SsoNYGetPreloadRsp.interval.get();
                int i18 = preload$SsoNYGetPreloadRsp.newestVer.get();
                if (preload$SsoNYGetPreloadRsp.retCode.get() == 0) {
                    s(str, i17, i18, i16);
                } else {
                    QLog.e("SpringHb_Preload_SpringHbPreloadManager", 1, "request preload with error Code " + preload$SsoNYGetPreloadRsp.retCode.get());
                    if (preload$SsoNYGetPreloadRsp.retCode.get() == 8) {
                        j.b(this.f289476d, i16);
                    }
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("SpringHb_Preload_SpringHbPreloadManager", 1, "parse proto error " + e16);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(313, e16, new String[0]);
                }
                t(i16);
            }
        }
        if (!z16) {
            t(i16);
        }
    }

    private void o() {
        this.f289477e = new i(this.f289476d, 0);
        this.f289478f = new i(this.f289476d, 1);
        this.f289479h = new i(this.f289476d, 2);
        i.r(this.f289476d, g());
        i.s(this.f289476d, this.f289479h.g(true));
    }

    private boolean r(com.tencent.mobileqq.springhb.config.a aVar) {
        if (aVar == null || aVar.d(1, "PreloadResClearEnable", 0) == 0) {
            return false;
        }
        return true;
    }

    private void s(String str, int i3, int i16, int i17) {
        String str2;
        long j3 = i3 * 1000;
        if (QLog.isColorLevel()) {
            QLog.d("SpringHb_Preload_SpringHbPreloadManager", 2, String.format("onReceiveConfig interval=%s version=%s actType=%s", Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17)));
        }
        j(i17).o(i16, str);
        if (i17 == 1) {
            str2 = "spring_2024_hb_preload_config_easter_inteval";
        } else if (i17 == 0) {
            str2 = "spring_2024_hb_preload_config_sys_inteval";
        } else {
            str2 = "spring_2025_hb_preload_config_2025_inteval";
        }
        j.i(this.f289476d, str2, j3);
    }

    private void t(int i3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            int i16 = 2;
            if (i3 != 2) {
                i16 = 1;
            }
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportResourceConfigCover(1, 1, 0, 1, 0, true, "", "resource", i16);
        }
    }

    private void w(int i3, boolean z16) {
        String str;
        String str2;
        QLog.i("SpringHb_Preload_SpringHbPreloadManager", 1, "[startRequest], type:" + i3);
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (i3 == 1) {
            str2 = "spring_2024_hb_preload_config_last_request_time_easter";
            str = "spring_2024_hb_preload_config_easter_inteval";
        } else if (i3 == 0) {
            str = "spring_2024_hb_preload_config_sys_inteval";
            str2 = "spring_2024_hb_preload_config_last_request_time_sys";
        } else {
            str = "spring_2025_hb_preload_config_2025_inteval";
            str2 = "spring_2025_hb_preload_config_last_request_time_2025";
        }
        long e16 = j.e(this.f289476d, str, 600000L);
        long abs = Math.abs(serverTimeMillis - j.e(this.f289476d, str2, 0L));
        if (abs <= e16 && !z16) {
            QLog.i("SpringHb_Preload_SpringHbPreloadManager", 1, String.format("requestPreloadConfig force=%s interval=%s reqInterval=%s", Boolean.valueOf(z16), Long.valueOf(e16), Long.valueOf(abs)));
            return;
        }
        j.i(this.f289476d, str2, serverTimeMillis);
        Preload$SsoNYGetPreloadReq preload$SsoNYGetPreloadReq = new Preload$SsoNYGetPreloadReq();
        preload$SsoNYGetPreloadReq.commonInfo.set(e());
        preload$SsoNYGetPreloadReq.scene.set(k());
        preload$SsoNYGetPreloadReq.ver.set(h(i3));
        NewIntent d16 = d(preload$SsoNYGetPreloadReq.toByteArray(), i3);
        QLog.d("SpringHb_Preload_SpringHbPreloadManager", 1, String.format("requestPreloadConfig req={%s}", ToStringExtKt.c(preload$SsoNYGetPreloadReq)));
        d16.setObserver(this);
        this.f289476d.startServlet(d16);
    }

    public h g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (h) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            h g16 = this.f289477e.g(true);
            h g17 = this.f289478f.g(true);
            if (g16 == null) {
                QLog.i("SpringHb_Preload_SpringHbPreloadManager", 1, "only has easter config bean.");
                return g17;
            }
            if (g17 == null) {
                QLog.i("SpringHb_Preload_SpringHbPreloadManager", 1, "only has sys config bean.");
                return g16;
            }
            h hVar = new h();
            for (int i3 = 0; i3 < g16.f289508b.length(); i3++) {
                hVar.f289508b.mo162put(g16.f289508b.get(i3));
            }
            JSONArray optJSONArray = hVar.f289508b.getJSONObject(0).optJSONArray(DKConfiguration.Directory.RESOURCES);
            JSONArray optJSONArray2 = hVar.f289508b.getJSONObject(0).optJSONArray("zip_resources");
            JSONArray optJSONArray3 = g17.f289508b.getJSONObject(0).optJSONArray(DKConfiguration.Directory.RESOURCES);
            JSONArray optJSONArray4 = g17.f289508b.getJSONObject(0).optJSONArray("zip_resources");
            QLog.i("SpringHb_Preload_SpringHbPreloadManager", 1, "[before] combinedRes.size:" + optJSONArray.length() + ",combinedZips.size:" + optJSONArray2.length());
            for (int i16 = 0; i16 < optJSONArray3.length(); i16++) {
                optJSONArray.mo162put(optJSONArray3.getJSONObject(i16));
            }
            for (int i17 = 0; i17 < optJSONArray4.length(); i17++) {
                optJSONArray2.mo162put(optJSONArray4.getJSONObject(i17));
            }
            QLog.i("SpringHb_Preload_SpringHbPreloadManager", 1, "[after] combinedRes.size:" + optJSONArray.length() + ",combinedZips.size:" + optJSONArray2.length());
            hVar.f289509c.addAll(g16.f289509c);
            hVar.f289509c.addAll(g17.f289509c);
            QLog.i("SpringHb_Preload_SpringHbPreloadManager", 1, " Both sys config bean and easter config bean exist. zipMap size:" + hVar.f289509c.size());
            return hVar;
        } catch (Throwable th5) {
            QLog.e("SpringHb_Preload_SpringHbPreloadManager", 1, "[getCombinedPreloadBean], th:", th5);
            return null;
        }
    }

    public int h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
        }
        return j(i3).f();
    }

    public i i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (i) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f289477e;
    }

    public i j(int i3) {
        i iVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (i) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        if (i3 == 0) {
            iVar = this.f289477e;
        } else if (i3 == 1) {
            iVar = this.f289478f;
        } else {
            iVar = this.f289479h;
        }
        if (iVar == null) {
            return new i(this.f289476d, 0);
        }
        return iVar;
    }

    public h l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (h) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        try {
            h g16 = this.f289479h.g(true);
            QLog.i("SpringHb_Preload_SpringHbPreloadManager", 1, "only has easter config bean.");
            return g16;
        } catch (Throwable th5) {
            QLog.e("SpringHb_Preload_SpringHbPreloadManager", 1, "[getCombinedPreloadBean], th:", th5);
            return null;
        }
    }

    public i m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (i) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f289479h;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
        } else {
            ThreadManagerV2.excute(new Runnable(i3, z16, bundle) { // from class: com.tencent.mobileqq.springhb.preload.SpringHbPreloadManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f289480d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f289481e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bundle f289482f;

                {
                    this.f289480d = i3;
                    this.f289481e = z16;
                    this.f289482f = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SpringHbPreloadManager.this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        SpringHbPreloadManager.this.n(this.f289480d, this.f289481e, this.f289482f);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 64, null, false);
        }
    }

    public boolean p() {
        Map<String, DragonCardData> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        DragonCardConfigData dragonCardConfigFromCache = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).getDragonCardConfigFromCache(MobileQQ.sMobileQQ.peekAppRuntime());
        if (dragonCardConfigFromCache != null && (map = dragonCardConfigFromCache.animationItems) != null && map.size() != 0) {
            QLog.i("SpringHb_Preload_SpringHbPreloadManager", 1, "Has easter config.");
            return true;
        }
        QLog.i("SpringHb_Preload_SpringHbPreloadManager", 1, "NOT has easter config.");
        return false;
    }

    public boolean q(AppRuntime appRuntime) {
        com.tencent.mobileqq.springhb.config.g gVar;
        EntryConfigBean o16;
        List<BaseActivityData> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime)).booleanValue();
        }
        String f16 = f();
        if (!"gamecenter".equals(f16)) {
            QLog.i("SpringHb_Preload_SpringHbPreloadManager", 1, "actType is NOT game_center, actType:" + f16);
            return false;
        }
        if (appRuntime == null || (gVar = (com.tencent.mobileqq.springhb.config.g) appRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)) == null || (o16 = gVar.o()) == null || (list = o16.activities) == null || list.size() <= 0) {
            return false;
        }
        QLog.i("SpringHb_Preload_SpringHbPreloadManager", 1, "Has sys config.");
        return true;
    }

    public void u(boolean z16, int i3) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        com.tencent.mobileqq.springhb.config.a d16 = SpringHbCommonConfProcessor.d();
        if (r(d16)) {
            QLog.i("SpringHb_Preload_SpringHbPreloadManager", 1, "clearPreloadConfigAndRes");
            c(0);
            c(1);
            return;
        }
        if (d16 != null && d16.d(1, "PreloadRequestDisabled", 0) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean b16 = b();
        QLog.d("SpringHb_Preload_SpringHbPreloadManager", 2, String.format("requestGameCenterPreloadConfig isActivityTypeValid=%s gameCenterRequestDisable=%s force=%s from=%s", Boolean.valueOf(b16), Boolean.valueOf(z17), Boolean.valueOf(z16), Integer.valueOf(i3)));
        if (!z16 && (z17 || !b16)) {
            return;
        }
        if (p()) {
            w(1, z16);
        }
        if (q(this.f289476d)) {
            w(0, z16);
        }
    }

    public void v(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            u(z16, i3);
        }
    }
}
