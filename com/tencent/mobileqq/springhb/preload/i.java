package com.tencent.mobileqq.springhb.preload;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.portal.FormalView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.springhb.entry.model.DragonCardConfigData;
import com.tencent.mobileqq.springhb.entry.model.DragonCardData;
import com.tencent.mobileqq.springhb.entry.model.EntryConfigBean;
import com.tencent.mobileqq.springhb.entry.model.MsgTabBannerData;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final AppRuntime f289511a;

    /* renamed from: b, reason: collision with root package name */
    private volatile h f289512b;

    /* renamed from: c, reason: collision with root package name */
    private int f289513c;

    public i(AppRuntime appRuntime, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, i3);
            return;
        }
        this.f289511a = appRuntime;
        this.f289513c = i3;
        this.f289512b = g(true);
        if (this.f289512b != null) {
            QLog.i("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "SpringHbPreloadConfigProcessor configVersion=" + this.f289512b.f289507a);
            return;
        }
        QLog.i("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "SpringHbPreloadConfigProcessor configVersion=" + j.d(appRuntime, this.f289513c));
    }

    private boolean a() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("video");
        String str = File.separator;
        sb5.append(str);
        sb5.append("0.mp4");
        String[] strArr = {sb5.toString(), "video" + str + "1.mp4", QCircleDaTongConstant.ElementParamValue.GIFT + str + "appear", QCircleDaTongConstant.ElementParamValue.GIFT + str + "fall", "star" + str + "appear", "star" + str + "fall"};
        String o16 = s.a("spring_shua_animation.zip").o();
        if (TextUtils.isEmpty(o16)) {
            return false;
        }
        for (int i3 = 0; i3 < 6; i3++) {
            String str2 = o16 + File.separator + strArr[i3];
            if (!new File(str2).exists()) {
                QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "checkAnimationResource file doesn't exist:", str2);
                return false;
            }
        }
        return true;
    }

    private boolean b() {
        SpringRes a16;
        String l3;
        if (this.f289512b != null && this.f289512b.f289509c != null && this.f289512b.f289509c.size() > 0) {
            for (SpringHbZipMappingBean springHbZipMappingBean : this.f289512b.f289509c) {
                if (springHbZipMappingBean != null && springHbZipMappingBean.resName != null && !n(springHbZipMappingBean.url) && !l(springHbZipMappingBean.url) && !m(springHbZipMappingBean.url) && (a16 = s.a(springHbZipMappingBean.resName)) != null && (l3 = a16.l()) != null && !new File(l3).exists()) {
                    QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "checkConfigFiles file doesn't exist:", springHbZipMappingBean.resName);
                    return false;
                }
            }
            return true;
        }
        QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "checkConfigFiles preload config is empty");
        return false;
    }

    private void c() {
        kl2.a moduleByName;
        try {
            IPreloadService iPreloadService = (IPreloadService) this.f289511a.getRuntimeService(IPreloadService.class, "");
            if (this.f289513c == 2) {
                moduleByName = iPreloadService.getModuleByName("2025_preload_res");
            } else {
                moduleByName = iPreloadService.getModuleByName("2024_preload_res");
            }
            if (moduleByName != null && !moduleByName.resDownloaded()) {
                QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "checkPreloadResDownloaded startCheckConfig");
                iPreloadService.startCheckConfig(false);
            }
        } catch (Exception e16) {
            QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "checkPreloadResDownloaded error: " + e16);
        }
    }

    private static h e(AppRuntime appRuntime) {
        if (appRuntime != null) {
            QLog.i("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "[getCombinedConfig]");
            Manager manager = appRuntime.getManager(QQManagerFactory.SPRING_HB_PRELOAD_MANAGER);
            if (manager instanceof SpringHbPreloadManager) {
                return ((SpringHbPreloadManager) manager).g();
            }
            return null;
        }
        return null;
    }

    private static h j(AppRuntime appRuntime) {
        if (appRuntime != null) {
            QLog.i("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "[getCombinedConfig]");
            Manager manager = appRuntime.getManager(QQManagerFactory.SPRING_HB_PRELOAD_MANAGER);
            if (manager instanceof SpringHbPreloadManager) {
                return ((SpringHbPreloadManager) manager).l();
            }
            return null;
        }
        return null;
    }

    private boolean l(String str) {
        String str2;
        DragonCardConfigData dragonCardConfigFromCache = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).getDragonCardConfigFromCache(MobileQQ.sMobileQQ.peekAppRuntime());
        if (str != null && dragonCardConfigFromCache != null && dragonCardConfigFromCache.animationItems != null) {
            Iterator it = new ArrayList(dragonCardConfigFromCache.animationItems.keySet()).iterator();
            while (it.hasNext()) {
                DragonCardData dragonCardData = dragonCardConfigFromCache.animationItems.get((String) it.next());
                if (dragonCardData != null && (str2 = dragonCardData.pagResUrl) != null && str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean m(String str) {
        List<MsgTabBannerData> list;
        String str2;
        EntryConfigBean J = ((SpringFestivalEntryManager) this.f289511a.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).J();
        if (J != null && (list = J.msgTabBanners) != null) {
            for (MsgTabBannerData msgTabBannerData : list) {
                if (msgTabBannerData != null && (str2 = msgTabBannerData.bgUrl) != null && str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean n(String str) {
        if (str != null && str.endsWith(".zip")) {
            return true;
        }
        return false;
    }

    private static void p(AppRuntime appRuntime, int i3) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        if (i3 != 0 && i3 != 1) {
            h j3 = j(appRuntime);
            if (j3 != null && (jSONArray2 = j3.f289508b) != null && jSONArray2.length() >= 1) {
                IPreloadService iPreloadService = (IPreloadService) appRuntime.getRuntimeService(IPreloadService.class, "");
                iPreloadService.replaceConfig(j3.f289508b, 5);
                iPreloadService.savePreloadConfig();
                iPreloadService.startCheckConfig(true);
                kl2.a moduleByName = iPreloadService.getModuleByName("2025_preload_res");
                if (moduleByName != null && moduleByName.getResApiList() != null) {
                    r.f289531a.m(moduleByName.getResApiList(), j3.f289509c);
                } else {
                    r.f289531a.m(null, null);
                }
                q(appRuntime, j3, i3);
                return;
            }
            QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "preloadConfig invalid");
            return;
        }
        QLog.i("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "[onUpdate], type:" + i3);
        h e16 = e(appRuntime);
        if (e16 != null && (jSONArray = e16.f289508b) != null && jSONArray.length() >= 1) {
            IPreloadService iPreloadService2 = (IPreloadService) appRuntime.getRuntimeService(IPreloadService.class, "");
            iPreloadService2.replaceConfig(e16.f289508b, 2);
            iPreloadService2.savePreloadConfig();
            iPreloadService2.startCheckConfig(true);
            kl2.a moduleByName2 = iPreloadService2.getModuleByName("2024_preload_res");
            if (moduleByName2 != null && moduleByName2.getResApiList() != null) {
                r.f289531a.l(moduleByName2.getResApiList(), e16.f289509c);
            } else {
                r.f289531a.l(null, null);
            }
            q(appRuntime, e16, i3);
            return;
        }
        QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "mPreloadConfig invalid");
    }

    private static void q(AppRuntime appRuntime, h hVar, int i3) {
        String str;
        int i16;
        try {
            str = MD5.toMD5(hVar.f289508b.toString());
        } catch (Throwable th5) {
            QLog.w("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "fail to get ConfigMd5, th:", th5);
            str = "";
        }
        String str2 = str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            if (i3 == 2) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).checkResCover(i16);
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportResourceConfigCover(1, 0, 0, 1, hVar.f289507a, true, str2, "resource", i16);
        }
    }

    public static void r(AppRuntime appRuntime, h hVar) {
        try {
            if (hVar == null) {
                QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "preloadConfig invalid");
                return;
            }
            kl2.a moduleByName = ((IPreloadService) appRuntime.getRuntimeService(IPreloadService.class, "")).getModuleByName("2024_preload_res");
            if (moduleByName != null && moduleByName.getResApiList() != null) {
                r.f289531a.l(moduleByName.getResApiList(), hVar.f289509c);
            } else {
                r.f289531a.l(null, null);
            }
        } catch (Throwable th5) {
            QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "[updateGameCenterResList], th:", th5);
        }
    }

    public static void s(AppRuntime appRuntime, h hVar) {
        try {
            if (hVar == null) {
                QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "preloadConfig invalid");
                return;
            }
            kl2.a moduleByName = ((IPreloadService) appRuntime.getRuntimeService(IPreloadService.class, "")).getModuleByName("2025_preload_res");
            if (moduleByName != null && moduleByName.getResApiList() != null) {
                r.f289531a.m(moduleByName.getResApiList(), hVar.f289509c);
            } else {
                r.f289531a.m(null, null);
            }
        } catch (Throwable th5) {
            QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "[updateSpringHbResList], th:", th5);
        }
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        try {
            if (!FormalView.z()) {
                QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "checkShuaYiShuaComboNumberFiles failed");
                return false;
            }
            if (!a()) {
                QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "checkAnimationResource false");
                return false;
            }
            if (b()) {
                return true;
            }
            QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "checkConfigFiles false");
            return false;
        } catch (Throwable th5) {
            QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "checkShuaYiShuaResource e:", th5);
            return false;
        }
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        g(true);
        if (this.f289512b != null) {
            return this.f289512b.f289507a;
        }
        return j.d(this.f289511a, this.f289513c);
    }

    public h g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (h) iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
        if (this.f289512b == null && z16) {
            try {
                h f16 = j.f(this.f289511a, this.f289513c);
                if (f16 != null) {
                    this.f289512b = f16;
                }
            } catch (Exception e16) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(314, e16, new String[0]);
                }
                QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "getLocalEntryConfig fail.", e16);
            }
        }
        return this.f289512b;
    }

    public kl2.a h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (kl2.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        IPreloadService iPreloadService = (IPreloadService) this.f289511a.getRuntimeService(IPreloadService.class, "");
        if (this.f289513c == 2) {
            return iPreloadService.getModuleByName("2025_preload_res");
        }
        return iPreloadService.getModuleByName("2024_preload_res");
    }

    public List<IPreloadResource> i() {
        kl2.a moduleByName;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        IPreloadService iPreloadService = (IPreloadService) this.f289511a.getRuntimeService(IPreloadService.class, "");
        if (this.f289513c == 2) {
            moduleByName = iPreloadService.getModuleByName("2025_preload_res");
        } else {
            moduleByName = iPreloadService.getModuleByName("2024_preload_res");
        }
        return moduleByName.getResApiList();
    }

    public List<SpringHbZipMappingBean> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f289512b != null) {
            return this.f289512b.f289509c;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b7 A[Catch: all -> 0x010a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000c, B:11:0x0011, B:44:0x0034, B:15:0x0038, B:17:0x003e, B:22:0x00b7, B:23:0x00e1, B:25:0x00e7, B:27:0x00eb, B:30:0x00c1, B:32:0x00c9, B:35:0x00d0, B:37:0x00de, B:38:0x005d, B:40:0x0063, B:42:0x0074, B:46:0x007e, B:48:0x0086, B:49:0x0098), top: B:2:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1 A[Catch: all -> 0x010a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000c, B:11:0x0011, B:44:0x0034, B:15:0x0038, B:17:0x003e, B:22:0x00b7, B:23:0x00e1, B:25:0x00e7, B:27:0x00eb, B:30:0x00c1, B:32:0x00c9, B:35:0x00d0, B:37:0x00de, B:38:0x005d, B:40:0x0063, B:42:0x0074, B:46:0x007e, B:48:0x0086, B:49:0x0098), top: B:2:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void o(int i3, String str) {
        int i16;
        boolean z16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) str);
            return;
        }
        QLog.i("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "[onGetPreloadConfig], actType:" + this.f289513c);
        h g16 = g(true);
        if (g16 != null) {
            try {
                i16 = g16.f289507a;
            } catch (Exception e16) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(313, e16, new String[0]);
                }
                QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "onGetEntryConfig fail." + e16.getMessage(), e16);
            }
        } else {
            i16 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_Preload_SpringHbPreloadConfigProcessor", 2, String.format("onGetPreloadConfig preVersion=%s, remoteVersion=%s", Integer.valueOf(i16), Integer.valueOf(i3)));
        }
        if (g16 == null || i16 != i3) {
            g16 = h.a(i3, str);
            if (g16 == null) {
                QLog.e("SpringHb_Preload_SpringHbPreloadConfigProcessor", 1, "onGetPreloadConfig parse config fail.");
                j.b(this.f289511a, this.f289513c);
            } else {
                j.h(this.f289511a, g16, this.f289513c);
            }
            z16 = true;
            if (!z16) {
                this.f289512b = g16;
                p(this.f289511a, this.f289513c);
            } else {
                AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime2 != null) {
                    if (this.f289513c == 2) {
                        i17 = 2;
                    } else {
                        i17 = 1;
                    }
                    ((ISpringHbReportApi) peekAppRuntime2.getRuntimeService(ISpringHbReportApi.class, "all")).checkResCover(i17);
                }
                c();
            }
            if (QLog.isColorLevel() && this.f289512b != null) {
                QLog.i("SpringHb_Preload_SpringHbPreloadConfigProcessor", 2, String.format("onGetPreloadConfig change=%s, config=%s", Boolean.valueOf(z16), ToStringExtKt.a(this.f289512b, true)));
            }
        }
        z16 = false;
        if (!z16) {
        }
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_Preload_SpringHbPreloadConfigProcessor", 2, String.format("onGetPreloadConfig change=%s, config=%s", Boolean.valueOf(z16), ToStringExtKt.a(this.f289512b, true)));
        }
    }
}
