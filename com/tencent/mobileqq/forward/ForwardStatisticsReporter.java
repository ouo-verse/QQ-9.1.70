package com.tencent.mobileqq.forward;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.api.IArkVipReport;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardStatisticsReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Long> f210902a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72238);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            b();
            f210902a = new HashMap();
        }
    }

    public static synchronized void a() {
        synchronized (ForwardStatisticsReporter.class) {
            f210902a.clear();
        }
    }

    static void b() {
        com.tencent.mobileqq.ark.vipreport.d dVar = new com.tencent.mobileqq.ark.vipreport.d();
        dVar.f199684a = IArkVipReport.SCENE_OPEN_SHARE;
        dVar.f199685b = "KEY_STAGE_1_TOTAL";
        dVar.f199686c = "KEY_STAGE_2_TOTAL";
        dVar.f199687d = 30000L;
        dVar.f199688e = new HashSet<String>() { // from class: com.tencent.mobileqq.forward.ForwardStatisticsReporter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                add("KEY_STAGE_1_TOTAL");
                add("KEY_STAGE_1_GET_SHARE_INFO");
                add("KEY_STAGE_1_UPLOAD_IMAGE");
                add("KEY_STAGE_1_GET_RICH_INFO");
                add("KEY_STAGE_1_CHANGE_IMG_URL");
                add("KEY_STAGE_1_D55");
                add("KEY_STAGE_1_SAVE_IMAGE");
                add("KEY_STAGE_2_TOTAL");
                add("KEY_STAGE_2_UPLOAD_IMAGE");
                add("KEY_STAGE_2_IMAGE_B77");
                add("KEY_STAGE_2_NORMAL_B77");
                add("KEY_STAGE_2_SEND_MSG_BY_SERVER");
                add("KEY_STAGE_2_NORMAL_DC2");
                add("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
                add("KEY_STAGE_2_IMAGE_DC2");
                add("compress_local_image");
                add("query_image");
                add("upload_local_thumb_image");
                add("reuse_image_for_aio");
                add("key_stage_2_change_img_url");
                add("batch_url_exchange");
                add("KEY_GET_APP_INFO");
                add("KEY_SSO_GET_TICKET_NO_PASSWD");
            }
        };
        ((IArkVipReport) QRoute.api(IArkVipReport.class)).initScene(IArkVipReport.SCENE_OPEN_SHARE, dVar);
        com.tencent.mobileqq.ark.vipreport.d dVar2 = new com.tencent.mobileqq.ark.vipreport.d();
        dVar2.f199684a = IArkVipReport.SCENE_OPEN_LOGIN;
        dVar2.f199685b = "KEY_LOGIN_STAGE_1_TOTAL";
        dVar2.f199686c = "KEY_AUTHORITY_TOTAL";
        dVar2.f199687d = 30000L;
        dVar2.f199688e = new HashSet<String>() { // from class: com.tencent.mobileqq.forward.ForwardStatisticsReporter.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                add("KEY_LOGIN_STAGE_1_TOTAL");
                add("KEY_LOGIN_STAGE_2_OLD_TOTAL");
                add("KEY_LOGIN_STAGE_2_NEW_TOTAL");
                add("KEY_LOGIN_STAGE_2_1_NEW_TOTAL");
                add("KEY_LOGIN_STAGE_2_2_NEW_TOTAL");
                add("KEY_LOGIN_STAGE_3_TOTAL");
                add("KEY_AUTHORITY_TOTAL");
                add("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
                add("KEY_GET_AUTH_API_LIST_REQUEST");
                add("KEY_AUTHORIZE_REQUEST");
                add("KEY_GET_APP_INFO_REQUEST");
                add("KEY_GET_APP_ICON");
                add("KEY_GET_VIRTUAL_LIST_D24");
                add("KEY_DELETE_VIRTUAL_D18");
                add("KEY_CREATE_VIRTUAL_D17");
                add("KEY_PRE_AUTH");
                add("use_third_pkg_name");
                add("login_pkg_name_empty");
            }
        };
        ((IArkVipReport) QRoute.api(IArkVipReport.class)).initScene(IArkVipReport.SCENE_OPEN_LOGIN, dVar2);
    }

    public static synchronized void c(String str) {
        synchronized (ForwardStatisticsReporter.class) {
            k(str, true);
        }
    }

    public static synchronized void d(String str, long j3) {
        synchronized (ForwardStatisticsReporter.class) {
            AppInterface appInterface = (AppInterface) BaseApplicationImpl.sApplication.getRuntime();
            if (appInterface == null) {
                QLog.d("ForwardStatisticsReporter", 1, "report == null key" + str);
                return;
            }
            String currentAccountUin = appInterface.getCurrentAccountUin();
            QLog.d("ForwardStatisticsReporter", 1, str, ContainerUtils.KEY_VALUE_DELIMITER, Long.valueOf(j3), ", uin=", com.tencent.open.agent.util.g.C(currentAccountUin));
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(currentAccountUin, str, true, j3, 0L, (HashMap<String, String>) null, "", false);
            ((IArkVipReport) QRoute.api(IArkVipReport.class)).addEventToScene(str, true, j3, null);
        }
    }

    public static synchronized void e(String str, com.tencent.open.model.a aVar) {
        synchronized (ForwardStatisticsReporter.class) {
            g(str, aVar, true);
        }
    }

    public static void f(String str, com.tencent.open.model.a aVar, HashMap<String, String> hashMap, boolean z16) {
        String str2;
        if (aVar == null) {
            str2 = "";
        } else {
            str2 = aVar.f341678a;
        }
        i(str, str2, hashMap, z16);
    }

    public static synchronized void g(String str, com.tencent.open.model.a aVar, boolean z16) {
        synchronized (ForwardStatisticsReporter.class) {
            f(str, aVar, null, z16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00f9 A[Catch: all -> 0x0100, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0011, B:10:0x0022, B:12:0x0032, B:15:0x0039, B:16:0x0046, B:18:0x004c, B:20:0x0071, B:21:0x00c6, B:23:0x00f9, B:26:0x00a6), top: B:3:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void h(String str, String str2, long j3, HashMap<String, String> hashMap, boolean z16) {
        synchronized (ForwardStatisticsReporter.class) {
            Long l3 = f210902a.get(str);
            if (l3 == null) {
                QLog.e("ForwardStatisticsReporter", 1, "report invalid key =", str);
                return;
            }
            f210902a.remove(str);
            long longValue = j3 - l3.longValue();
            if (hashMap != null && !hashMap.isEmpty()) {
                StringBuilder sb5 = new StringBuilder();
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    sb5.append(entry.getKey());
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(entry.getValue());
                    sb5.append(" ");
                }
                QLog.d("ForwardStatisticsReporter", 1, str, ContainerUtils.KEY_VALUE_DELIMITER, Long.valueOf(longValue), ", uin=", com.tencent.open.agent.util.g.C(str2), ", params[", sb5.toString(), "]");
                StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(str2, str, z16, longValue, 0L, hashMap, "", false);
                ((IArkVipReport) QRoute.api(IArkVipReport.class)).addEventToScene(str, z16, longValue, hashMap);
                if ("KEY_STAGE_2_TOTAL".equals(str)) {
                    f210902a.clear();
                }
            }
            QLog.d("ForwardStatisticsReporter", 1, str, ContainerUtils.KEY_VALUE_DELIMITER, Long.valueOf(longValue), ", uin=", com.tencent.open.agent.util.g.C(str2));
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(str2, str, z16, longValue, 0L, hashMap, "", false);
            ((IArkVipReport) QRoute.api(IArkVipReport.class)).addEventToScene(str, z16, longValue, hashMap);
            if ("KEY_STAGE_2_TOTAL".equals(str)) {
            }
        }
    }

    public static synchronized void i(String str, String str2, HashMap<String, String> hashMap, boolean z16) {
        synchronized (ForwardStatisticsReporter.class) {
            h(str, str2, System.currentTimeMillis(), hashMap, z16);
        }
    }

    public static synchronized void j(String str, String str2, boolean z16) {
        synchronized (ForwardStatisticsReporter.class) {
            i(str, str2, null, z16);
        }
    }

    public static synchronized void k(String str, boolean z16) {
        synchronized (ForwardStatisticsReporter.class) {
            j(str, ((AppInterface) BaseApplicationImpl.sApplication.getRuntime()).getCurrentAccountUin(), z16);
        }
    }

    public static void l(String str, long j3, HashMap<String, String> hashMap, boolean z16) {
        String currentAccountUin = ((AppInterface) BaseApplicationImpl.sApplication.getRuntime()).getCurrentAccountUin();
        QLog.d("ForwardStatisticsReporter", 1, "reportSaveImage key=", str, ",duration=", Long.valueOf(j3), ", uin=", com.tencent.open.agent.util.g.C(currentAccountUin));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(currentAccountUin, str, z16, j3, 0L, hashMap, "", false);
        ((IArkVipReport) QRoute.api(IArkVipReport.class)).addEventToScene(str, true, j3, hashMap);
    }

    public static synchronized void m(String str) {
        synchronized (ForwardStatisticsReporter.class) {
            long currentTimeMillis = System.currentTimeMillis();
            f210902a.put(str, Long.valueOf(currentTimeMillis));
            ((IArkVipReport) QRoute.api(IArkVipReport.class)).startSceneByEvent(str, currentTimeMillis);
        }
    }
}
