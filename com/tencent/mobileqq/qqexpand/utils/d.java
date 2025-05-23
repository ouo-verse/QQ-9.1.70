package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d {
    static {
        d();
    }

    public static String a(BaseQQAppInterface baseQQAppInterface) {
        com.tencent.mobileqq.qqexpand.manager.e eVar = (com.tencent.mobileqq.qqexpand.manager.e) baseQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        if (eVar == null) {
            QLog.e("ExpandReportUtils", 1, "getDefaultReportParams but manager is null");
            return "";
        }
        return b(eVar);
    }

    private static String b(com.tencent.mobileqq.qqexpand.manager.e eVar) {
        String str;
        ExpandConfig e16 = eVar.e();
        if (e16 != null) {
            str = e16.getTestId();
        } else {
            str = "";
        }
        return "homepage_new_boxlist-" + str;
    }

    public static void d() {
        UserAction.registerTunnel(new TunnelInfo(IExpandReportUtils.EXPAND_APP_KEY));
        QLog.i("ExpandReportUtils", 1, "init expand tunnel");
    }

    public static void e(String str, boolean z16, long j3, long j16, Map<String, String> map, boolean z17, boolean z18) {
        Map<String, String> hashMap = map == null ? new HashMap<>() : map;
        com.tencent.mobileqq.qqexpand.manager.e eVar = (com.tencent.mobileqq.qqexpand.manager.e) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        if (eVar == null) {
            QLog.e("ExpandReportUtils", 1, "report but manager is null");
            return;
        }
        hashMap.put("entry", eVar.h() + "");
        if (!hashMap.containsKey(IExpandReportUtils.REPORT_KEY_MANAGER_TEST_PLAN)) {
            hashMap.put(IExpandReportUtils.REPORT_KEY_MANAGER_TEST_PLAN, b(eVar));
        }
        if (!hashMap.containsKey("TAB_test_plan")) {
            hashMap.put("TAB_test_plan", eVar.K());
        }
        hashMap.put("uid", c(BaseApplicationImpl.getApplication().getRuntime()));
        com.tencent.mobileqq.statistics.m.a(IExpandReportUtils.EXPAND_APP_KEY, str, z16, j3, j16, hashMap, z17, z18);
        if (QLog.isDevelopLevel()) {
            QLog.d("ExpandReportUtils", 4, "report " + str + " params:" + hashMap);
        }
    }

    public static void h(String str, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("frompage", str);
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        f("click#all_page#entrance", true, hashMap2);
    }

    public static void i(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("frompage", str);
        f("app_launch#app_launch#none", true, hashMap);
    }

    public static void g(String str) {
        h(str, null);
    }

    private static String c(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return "";
        }
        return appRuntime.getAccount();
    }

    public static void f(String str, boolean z16, Map<String, String> map) {
        e(str, z16, -1L, -1L, map, true, true);
    }
}
