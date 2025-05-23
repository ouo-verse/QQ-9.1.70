package com.tencent.mobileqq.springhb;

import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.springhb.api.ISpringHbPreloadResApi;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.springhb.c;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A() {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringHbMonitorReporter", true, "[checkGameCenterResCover] start");
        BaseQQAppInterface qQAppInterface = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getQQAppInterface();
        if (qQAppInterface == null) {
            return;
        }
        kl2.a moduleByName = ((IPreloadService) qQAppInterface.getRuntimeService(IPreloadService.class, "")).getModuleByName("2024_preload_res");
        if (moduleByName != null) {
            List<IPreloadResource> resApiList = moduleByName.getResApiList();
            if (resApiList.size() > 0) {
                Iterator<IPreloadResource> it = resApiList.iterator();
                boolean z16 = true;
                int i3 = 0;
                while (it.hasNext()) {
                    if (!it.next().isResFileExist(moduleByName)) {
                        z16 = false;
                    } else {
                        i3++;
                    }
                }
                J(z16, i3, 1);
            }
        }
        com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringHbMonitorReporter", true, "[checkGameCenterResCover] finished cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B() {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringHbMonitorReporter", true, "[checkSpringHbResCover] start");
        BaseQQAppInterface qQAppInterface = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getQQAppInterface();
        if (qQAppInterface == null) {
            return;
        }
        kl2.a moduleByName = ((IPreloadService) qQAppInterface.getRuntimeService(IPreloadService.class, "")).getModuleByName("2025_preload_res");
        if (moduleByName != null) {
            List<IPreloadResource> resApiList = moduleByName.getResApiList();
            if (resApiList.size() > 0) {
                boolean z16 = true;
                int i3 = 0;
                for (IPreloadResource iPreloadResource : resApiList) {
                    if (!iPreloadResource.isResFileExist(moduleByName)) {
                        z16 = false;
                    } else {
                        i3++;
                        if (iPreloadResource.getType() == 6) {
                            ((ISpringHbPreloadResApi) QRoute.api(ISpringHbPreloadResApi.class)).copyKuiklyFontFile(iPreloadResource.getUrl());
                        } else if (iPreloadResource.getType() == 7) {
                            ((ISpringHbPreloadResApi) QRoute.api(ISpringHbPreloadResApi.class)).copyKuiklyPagFile(qQAppInterface.getApplicationContext(), iPreloadResource.getUrl());
                        }
                    }
                }
                if (z16) {
                    J(true, i3, 2);
                }
            }
        }
        com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringHbMonitorReporter", true, "[checkSpringHbResCover] finished cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(int i3) {
        if (i3 == 1) {
            f();
        } else {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D(String str, String str2, int i3) {
        Object obj;
        Object obj2;
        Object obj3;
        boolean z16;
        Object obj4;
        boolean z17;
        Object obj5;
        if (!y(str)) {
            obj = "result";
            obj2 = "exception";
            obj3 = WadlReportBuilder.TableElem.OPER_ID;
        } else {
            int reportConstantRes = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getReportConstantRes(str2);
            String encodeUrl = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getEncodeUrl(str);
            obj = "result";
            StringBuilder sb5 = new StringBuilder();
            obj2 = "exception";
            sb5.append(t(1));
            sb5.append("");
            String sb6 = sb5.toString();
            if (!TextUtils.isEmpty(encodeUrl)) {
                HashMap hashMap = new HashMap();
                hashMap.put("buss_id", c.b.f288969a);
                hashMap.put("module_id", "download");
                hashMap.put(WadlReportBuilder.TableElem.OPER_ID, reportConstantRes + "");
                if (i3 != 404) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                obj3 = WadlReportBuilder.TableElem.OPER_ID;
                if (z17) {
                    obj5 = obj;
                } else {
                    obj5 = obj2;
                }
                hashMap.put("submodule_id", obj5);
                hashMap.put("ext1", encodeUrl);
                hashMap.put("ext3", sb6);
                hashMap.put("ext4", i3 + "");
                SpringReporter.c(hashMap, z17 ^ true, 1);
            } else {
                obj3 = WadlReportBuilder.TableElem.OPER_ID;
            }
            if (reportConstantRes == 0) {
                e();
            }
        }
        if (z(str)) {
            int reportConstantRes2 = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getReportConstantRes(str2);
            if (reportConstantRes2 == 0) {
                g();
                return;
            }
            String encodeUrl2 = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getEncodeUrl(str);
            String str3 = t(2) + "";
            if (!TextUtils.isEmpty(encodeUrl2)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("buss_id", c.b.f288969a);
                hashMap2.put("module_id", "download");
                hashMap2.put(obj3, reportConstantRes2 + "");
                if (i3 != 404) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    obj4 = obj;
                } else {
                    obj4 = obj2;
                }
                hashMap2.put("submodule_id", obj4);
                hashMap2.put("ext1", encodeUrl2);
                hashMap2.put("ext3", str3);
                hashMap2.put("ext4", i3 + "");
                SpringReporter.c(hashMap2, z16 ^ true, 2);
            }
        }
    }

    public static void E(int i3, int i16, int i17, int i18, int i19, boolean z16, String str, String str2, int i26) {
        try {
            String o16 = o(i26);
            String j3 = j(i17, i19, str, i16);
            com.tencent.mobileqq.springhb.util.b bVar = com.tencent.mobileqq.springhb.util.b.f289632a;
            bVar.f("Springhb_report.SpringHbMonitorReporter", true, "[reportConfigCoverageDaily] currentCfgTags == " + j3 + " cfgTags: " + o16);
            if (x(o16, j3)) {
                bVar.f("Springhb_report.SpringHbMonitorReporter", true, "[reportConfigCoverageDaily] no need to report " + i17);
                return;
            }
            String a16 = c.a.a(i3);
            HashMap hashMap = new HashMap();
            hashMap.put("buss_id", c.b.f288970b);
            hashMap.put("module_id", str2);
            hashMap.put("submodule_id", a16);
            hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "" + i16);
            hashMap.put("ext1", "" + i17);
            hashMap.put("ext2", "" + i18);
            hashMap.put("ext3", "" + i19);
            hashMap.put("ext4", "" + i16);
            SpringReporter.c(hashMap, z16, i26);
            if (!StringUtil.isEmpty(o16)) {
                j3 = o16 + "|" + j3;
            }
            O(j3, i26);
        } catch (Exception e16) {
            com.tencent.mobileqq.springhb.util.b.f289632a.e("Springhb_report.SpringHbMonitorReporter", false, "[reportConfigCoverageDaily] fail.", e16);
        }
    }

    public static void F(int i3, Throwable th5, String... strArr) {
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            boolean needReportFullTask = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).needReportFullTask();
            int entryConfigVersion = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).getEntryConfigVersion(peekAppRuntime);
            int entryConfigTaskId = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).getEntryConfigTaskId(peekAppRuntime);
            com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringHbMonitorReporter", false, "[reportExCatch] pos=" + i3 + " ver= " + entryConfigVersion + " taskId=" + entryConfigTaskId + " e.msg=" + th5.getMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("buss_id", c.b.f288986r);
            hashMap.put("module_id", "excp");
            hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "1");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            sb5.append(i3);
            hashMap.put("ext1", sb5.toString());
            hashMap.put("ext2", "" + entryConfigTaskId);
            hashMap.put("ext3", "" + entryConfigVersion);
            if (needReportFullTask) {
                hashMap.put("ext4", QLog.getStackTraceString(th5));
            } else {
                hashMap.put("ext4", th5.getMessage());
            }
            if (strArr != null && strArr.length > 0) {
                StringBuilder sb6 = new StringBuilder();
                for (String str : strArr) {
                    sb6.append(str);
                    sb6.append(";");
                }
                hashMap.put("ext5", "" + ((Object) sb6));
            }
            SpringReporter.c(hashMap, false, 3);
        } catch (Exception e16) {
            com.tencent.mobileqq.springhb.util.b.f289632a.e("Springhb_report.SpringHbMonitorReporter", false, "[reportExCatch] fail.", e16);
        }
    }

    public static void G(int i3, int i16, int i17, int i18, int i19, boolean z16, String str) {
        E(i3, i16, i17, i18, i19, z16, str, QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 1);
    }

    public static void H(int i3, long j3, String str) {
        int i16;
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", c.b.f288985q);
        hashMap.put("module_id", "perform");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "1");
        hashMap.put("ext1", i3 + "");
        hashMap.put("ext2", j3 + "");
        hashMap.put("ext3", str + "");
        BaseQQAppInterface qQAppInterface = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getQQAppInterface();
        if (qQAppInterface == null) {
            return;
        }
        if (((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).isGameCenterActivity(qQAppInterface)) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        String s16 = s(i16);
        String k3 = k(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).getConfigVersion("spring_common_config"));
        if (TextUtils.equals(s16, k3)) {
            return;
        }
        SpringReporter.c(hashMap, false, i16);
        S(k3, i16);
    }

    private static void I(boolean z16, final int i3) {
        if (!((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).activityConfigLoaded()) {
            com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringHbMonitorReporter", false, "reportRes config not loaded");
            return;
        }
        com.tencent.mobileqq.springhb.util.b bVar = com.tencent.mobileqq.springhb.util.b.f289632a;
        bVar.f("Springhb_report.SpringHbMonitorReporter", false, "reportRes isFromHitReport=" + z16);
        if (z16) {
            bVar.f("Springhb_report.SpringHbMonitorReporter", true, "[checkResHit] begin");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.springhb.j
                @Override // java.lang.Runnable
                public final void run() {
                    n.C(i3);
                }
            }, 64, null, false);
            return;
        }
        String u16 = u(i3);
        String l3 = l();
        if (TextUtils.equals(u16, l3)) {
            bVar.f("Springhb_report.SpringHbMonitorReporter", true, "[reportRes] no need to report: " + String.format("[reportRes] lastTag=%s curTag=%s", u16, l3));
            return;
        }
        if (i3 == 1) {
            e();
        } else {
            g();
        }
        T(l3, i3);
    }

    public static void J(boolean z16, int i3, int i16) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", c.b.f288969a);
        hashMap.put("module_id", "preload");
        hashMap.put("submodule_id", "cover");
        if (z16) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, str);
        hashMap.put("ext1", i3 + "");
        hashMap.put("ext3", t(i16) + "");
        String w3 = w(i16);
        String m3 = m(z16, t(i16));
        long v3 = v(i16);
        long serverTime = NetConnInfoCenter.getServerTime();
        long j3 = serverTime - v3;
        long reportConfigDelayTime = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).getReportConfigDelayTime(i16);
        if (reportConfigDelayTime <= 0) {
            reportConfigDelayTime = 7200;
        }
        com.tencent.mobileqq.springhb.util.b bVar = com.tencent.mobileqq.springhb.util.b.f289632a;
        bVar.f("Springhb_report.SpringHbMonitorReporter", true, String.format("[reportResCover] lastTag=%s curTag=%s", w3, m3));
        if (TextUtils.equals(w3, m3) && (z16 || j3 < reportConfigDelayTime)) {
            bVar.f("Springhb_report.SpringHbMonitorReporter", true, "[reportResCover] no need to report.");
            return;
        }
        SpringReporter.b(hashMap, i16);
        U(m3, i16);
        V(serverTime, i16);
    }

    private static void K(boolean z16, int i3, int i16) {
        String str;
        String r16 = r(i16);
        String n3 = n(z16, t(i16));
        if (TextUtils.equals(r16, n3)) {
            com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringHbMonitorReporter", false, "[reportResHitInner] no need to report: " + String.format("[reportResHitInner] lastTag=%s curTag=%s", r16, n3));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", c.b.f288969a);
        hashMap.put("module_id", "preload");
        hashMap.put("submodule_id", "hit");
        if (z16) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, str);
        hashMap.put("ext1", i3 + "");
        hashMap.put("ext3", t(i16) + "");
        SpringReporter.b(hashMap, i16);
        R(n3, i16);
    }

    public static void L(kl2.a aVar, String str, String str2, int i3) {
        Object obj;
        String str3;
        Object obj2;
        Object obj3;
        boolean z16;
        Object obj4;
        boolean z17;
        Object obj5;
        if (aVar != null && !TextUtils.isEmpty(aVar.getName())) {
            if (str.equals("RESULT_RES_PRELOAD_SUCC")) {
                if (aVar.getName().equals("2024_preload_res")) {
                    e();
                    return;
                } else {
                    if (aVar.getName().equals("2025_preload_res")) {
                        g();
                        return;
                    }
                    return;
                }
            }
            int reportConstantRes = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getReportConstantRes(str);
            if (!aVar.getName().equals("2024_preload_res")) {
                obj = "ext3";
                str3 = "Springhb_report.SpringHbMonitorReporter";
                obj2 = "module_id";
                obj3 = "ext4";
            } else {
                com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringHbMonitorReporter", true, "[report2024ResPreload] result=" + str + JefsClass.INDEX_URL + str2);
                String encodeUrl = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getEncodeUrl(str2);
                StringBuilder sb5 = new StringBuilder();
                str3 = "Springhb_report.SpringHbMonitorReporter";
                sb5.append(t(1));
                sb5.append("");
                String sb6 = sb5.toString();
                if (TextUtils.isEmpty(encodeUrl)) {
                    obj2 = "module_id";
                    obj3 = "ext4";
                    obj = "ext3";
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("buss_id", c.b.f288969a);
                    hashMap.put("module_id", "preload");
                    if (i3 != 404) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    obj2 = "module_id";
                    if (z17) {
                        obj5 = "result";
                    } else {
                        obj5 = "exception";
                    }
                    hashMap.put("submodule_id", obj5);
                    hashMap.put(WadlReportBuilder.TableElem.OPER_ID, reportConstantRes + "");
                    hashMap.put("ext1", encodeUrl);
                    obj = "ext3";
                    hashMap.put(obj, sb6);
                    obj3 = "ext4";
                    hashMap.put(obj3, i3 + "");
                    SpringReporter.c(hashMap, z17 ^ true, 1);
                }
            }
            if (aVar.getName().equals("2025_preload_res")) {
                com.tencent.mobileqq.springhb.util.b.f289632a.f(str3, true, "[report2025ResPreload] result=" + str + JefsClass.INDEX_URL + str2);
                String encodeUrl2 = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getEncodeUrl(str2);
                StringBuilder sb7 = new StringBuilder();
                sb7.append(t(2));
                sb7.append("");
                String sb8 = sb7.toString();
                if (!TextUtils.isEmpty(encodeUrl2)) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("buss_id", c.b.f288969a);
                    hashMap2.put(obj2, "preload");
                    if (i3 != 404) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        obj4 = "result";
                    } else {
                        obj4 = "exception";
                    }
                    hashMap2.put("submodule_id", obj4);
                    hashMap2.put(WadlReportBuilder.TableElem.OPER_ID, reportConstantRes + "");
                    hashMap2.put("ext1", encodeUrl2);
                    hashMap2.put(obj, sb8);
                    hashMap2.put(obj3, i3 + "");
                    SpringReporter.c(hashMap2, z16 ^ true, 2);
                }
            }
        }
    }

    public static void M(final String str, final String str2, final int i3) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.springhb.m
            @Override // java.lang.Runnable
            public final void run() {
                n.D(str2, str, i3);
            }
        }, 16, null, false);
    }

    public static void N(int i3, int i16, int i17, int i18, int i19, boolean z16, String str) {
        E(i3, i16, i17, i18, i19, z16, str, QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 2);
    }

    private static void O(String str, int i3) {
        com.tencent.mobileqq.springhb.util.a.f289630a.p("cfg_cover_tag", str, a.a(i3), false, null);
    }

    public static void P(int i3, String str) {
        com.tencent.mobileqq.springhb.util.a.f289630a.p("conf_content_md5" + i3, str, "2024_spring_hb_report_", false, null);
    }

    public static void Q(int i3, int i16) {
        com.tencent.mobileqq.springhb.util.a.f289630a.k("conf_taskid" + i3, i16, "2024_spring_hb_report_", false, null);
    }

    private static void R(String str, int i3) {
        com.tencent.mobileqq.springhb.util.a.f289630a.p("res_hit_tag", str, a.a(i3), false, null);
    }

    private static void S(String str, int i3) {
        com.tencent.mobileqq.springhb.util.a.f289630a.p("performance_tag", str, a.a(i3), false, null);
    }

    private static void T(String str, int i3) {
        com.tencent.mobileqq.springhb.util.a.f289630a.p("res_cover_check_tag", str, a.a(i3), false, null);
    }

    private static void U(String str, int i3) {
        com.tencent.mobileqq.springhb.util.a.f289630a.p("res_cover_tag", str, a.a(i3), false, null);
    }

    private static void V(long j3, int i3) {
        com.tencent.mobileqq.springhb.util.a.f289630a.m("res_cover_time", j3, a.a(i3), false, null);
    }

    public static void W(boolean z16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        int i3 = 1;
        if (MobileQQ.sProcessId != 1) {
            com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringHbMonitorReporter", false, "not PROCESS_QQ");
        } else {
            if (peekAppRuntime == null) {
                com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringHbMonitorReporter", false, "tryReportResState app == null");
                return;
            }
            if (!((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).isGameCenterActivity(peekAppRuntime)) {
                i3 = 2;
            }
            I(z16, i3);
        }
    }

    public static void e() {
        if (!((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).activityConfigLoaded()) {
            com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringHbMonitorReporter", false, "checkGameCenterResCover configLoaded not loaded");
        } else {
            com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringHbMonitorReporter", true, "[checkGameCenterResCover] begin");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.springhb.l
                @Override // java.lang.Runnable
                public final void run() {
                    n.A();
                }
            }, 64, null, false);
        }
    }

    private static void f() {
        com.tencent.mobileqq.springhb.util.b bVar = com.tencent.mobileqq.springhb.util.b.f289632a;
        bVar.f("Springhb_report.SpringHbMonitorReporter", true, "[checkResHit] start");
        BaseQQAppInterface qQAppInterface = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getQQAppInterface();
        if (qQAppInterface == null) {
            bVar.f("Springhb_report.SpringHbMonitorReporter", false, "[checkResHit] app == null");
            return;
        }
        kl2.a moduleByName = ((IPreloadService) qQAppInterface.getRuntimeService(IPreloadService.class, "")).getModuleByName("2024_preload_res");
        if (moduleByName == null) {
            bVar.f("Springhb_report.SpringHbMonitorReporter", false, "[checkResHit] module == null");
            return;
        }
        List<IPreloadResource> resApiList = moduleByName.getResApiList();
        if (resApiList.isEmpty()) {
            bVar.f("Springhb_report.SpringHbMonitorReporter", false, "[checkResHit] resources empty");
            return;
        }
        Iterator<IPreloadResource> it = resApiList.iterator();
        boolean z16 = true;
        int i3 = 0;
        while (it.hasNext()) {
            if (!it.next().isResFileExist(moduleByName)) {
                z16 = false;
            } else {
                i3++;
            }
        }
        K(z16, i3, 1);
    }

    public static void g() {
        com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringHbMonitorReporter", true, "[checkSpringHbResCover] begin");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.springhb.k
            @Override // java.lang.Runnable
            public final void run() {
                n.B();
            }
        }, 64, null, false);
    }

    private static void h() {
        com.tencent.mobileqq.springhb.util.b bVar = com.tencent.mobileqq.springhb.util.b.f289632a;
        boolean z16 = true;
        bVar.f("Springhb_report.SpringHbMonitorReporter", true, "[checkResHit] start");
        BaseQQAppInterface qQAppInterface = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getQQAppInterface();
        if (qQAppInterface == null) {
            bVar.f("Springhb_report.SpringHbMonitorReporter", false, "[checkResHit] app == null");
            return;
        }
        kl2.a moduleByName = ((IPreloadService) qQAppInterface.getRuntimeService(IPreloadService.class, "")).getModuleByName("2025_preload_res");
        if (moduleByName == null) {
            bVar.f("Springhb_report.SpringHbMonitorReporter", false, "[checkResHit] module == null");
            return;
        }
        List<IPreloadResource> resApiList = moduleByName.getResApiList();
        if (resApiList.isEmpty()) {
            bVar.f("Springhb_report.SpringHbMonitorReporter", false, "[checkResHit] resources empty");
            return;
        }
        Iterator<IPreloadResource> it = resApiList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (!it.next().isResFileExist(moduleByName)) {
                z16 = false;
            } else {
                i3++;
            }
        }
        K(z16, i3, 2);
    }

    public static void i(int i3, int i16, int i17, int i18, int i19, int i26, boolean z16, String... strArr) {
        String str;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("buss_id", c.b.f288970b);
            if (i18 != 1013) {
                str = "";
            } else {
                str = QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE;
            }
            String a16 = c.a.a(i16);
            hashMap.put("module_id", str);
            hashMap.put("submodule_id", a16);
            hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "" + i17);
            hashMap.put("ext1", "" + i18);
            hashMap.put("ext2", "" + i19);
            hashMap.put("ext3", "" + i26);
            if (strArr != null && strArr.length > 0) {
                hashMap.put("ext4", "" + strArr[0]);
            }
            SpringReporter.c(hashMap, z16, i3);
        } catch (Throwable th5) {
            com.tencent.mobileqq.springhb.util.b.f289632a.d("Springhb_report.SpringHbMonitorReporter", false, "configReport: " + th5);
        }
    }

    private static String j(int i3, int i16, String str, int i17) {
        return String.format("%s_%s_%s_%s_%s", "Springhb_report", Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17));
    }

    private static String k(int i3) {
        return String.format("%s_%s", "Springhb_report", Integer.valueOf(i3));
    }

    private static String l() {
        return String.format("%s", new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.getDefault()).format(new Date(NetConnInfoCenter.getServerTimeMillis())));
    }

    private static String m(boolean z16, int i3) {
        return String.format("%s_%s_%s", "Springhb_report", Boolean.valueOf(z16), Integer.valueOf(i3));
    }

    private static String n(boolean z16, int i3) {
        return String.format("%s_%s_%s", new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.getDefault()).format(new Date(NetConnInfoCenter.getServerTimeMillis())), Boolean.valueOf(z16), Integer.valueOf(i3));
    }

    private static String o(int i3) {
        return com.tencent.mobileqq.springhb.util.a.f289630a.h("cfg_cover_tag", "", a.a(i3), false, null);
    }

    public static String p(int i3) {
        return com.tencent.mobileqq.springhb.util.a.f289630a.h("conf_content_md5" + i3, "", "2024_spring_hb_report_", false, null);
    }

    public static int q(int i3) {
        return com.tencent.mobileqq.springhb.util.a.f289630a.c("conf_taskid" + i3, 0, "2024_spring_hb_report_", false, null);
    }

    private static String r(int i3) {
        return com.tencent.mobileqq.springhb.util.a.f289630a.h("res_hit_tag", "", a.a(i3), false, null);
    }

    private static String s(int i3) {
        return com.tencent.mobileqq.springhb.util.a.f289630a.h("performance_tag", "", a.a(i3), false, null);
    }

    private static int t(int i3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            if (i3 == 1) {
                return ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).getGameCenterPreloadConfVersion(peekAppRuntime);
            }
            return ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).getSpringHbPreloadConfVersion(peekAppRuntime);
        }
        return 0;
    }

    private static String u(int i3) {
        return com.tencent.mobileqq.springhb.util.a.f289630a.h("res_cover_check_tag", "", a.a(i3), false, null);
    }

    private static long v(int i3) {
        return com.tencent.mobileqq.springhb.util.a.f289630a.e("res_cover_time", -1L, a.a(i3), false, null);
    }

    private static String w(int i3) {
        return com.tencent.mobileqq.springhb.util.a.f289630a.h("res_cover_tag", "", a.a(i3), false, null);
    }

    private static boolean x(String str, String str2) {
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        for (String str3 : str.split("\\|")) {
            if (str3.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean y(String str) {
        BaseQQAppInterface qQAppInterface;
        kl2.a moduleByName;
        if (!TextUtils.isEmpty(str) && (qQAppInterface = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getQQAppInterface()) != null && (moduleByName = ((IPreloadService) qQAppInterface.getRuntimeService(IPreloadService.class, "")).getModuleByName("2024_preload_res")) != null) {
            Iterator<IPreloadResource> it = moduleByName.getResApiList().iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getResDownloadUrl(moduleByName), str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean z(String str) {
        BaseQQAppInterface qQAppInterface;
        kl2.a moduleByName;
        if (!TextUtils.isEmpty(str) && (qQAppInterface = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getQQAppInterface()) != null && (moduleByName = ((IPreloadService) qQAppInterface.getRuntimeService(IPreloadService.class, "")).getModuleByName("2025_preload_res")) != null) {
            Iterator<IPreloadResource> it = moduleByName.getResApiList().iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getResDownloadUrl(moduleByName), str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
