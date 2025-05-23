package com.tencent.qqnt.emotion.stickerrecommended;

import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.temp.report.StatisticCollector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes24.dex */
public class v {
    static IPatchRedirector $redirector_;

    private static boolean a() {
        if (System.currentTimeMillis() % 1000 < 10) {
            return true;
        }
        return false;
    }

    public static void b(HashMap<String, String> hashMap) {
        if (!a()) {
            return;
        }
        StatisticCollector.d(BaseApplication.getContext()).b("00000BXKOY3QZQ1E", MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "click", true, 0L, 0L, hashMap, null);
    }

    public static void c(HashMap<String, String> hashMap) {
        if (!a()) {
            return;
        }
        StatisticCollector.d(BaseApplication.getContext()).b("00000BXKOY3QZQ1E", MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "expo", true, 0L, 0L, hashMap, null);
    }

    public static void d(boolean z16, String str, int i3, String str2, g gVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("keyword", str);
        hashMap.put("pic_md5", gVar.getImgMd5());
        hashMap.put("pic_url", gVar.getImgUrl());
        hashMap.put("aio_type", com.tencent.qqnt.emotion.utils.d.d(i3));
        if (gVar instanceof o) {
            o oVar = (o) gVar;
            String h16 = oVar.h();
            if (h16 != null) {
                hashMap.put("algo_info", h16);
            }
            String t16 = oVar.t();
            if (t16 != null) {
                hashMap.put("recom_transfer", t16);
            }
        }
        String reportEventPrefix = gVar.getReportEventPrefix();
        if (reportEventPrefix != null && reportEventPrefix.length() > 1 && reportEventPrefix.endsWith("-")) {
            hashMap.put("source", reportEventPrefix.substring(0, 1));
        }
        if (str2 != null) {
            hashMap.put("target_qq", str2);
        }
        hashMap.put(SegmentKeeper.KEY_DURATION, gVar.exposedTime() + "");
        String account = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        if (!StringUtil.isValideUin(account)) {
            account = MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
        }
        hashMap.put("report_qq", account);
        if (z16) {
            c(hashMap);
        } else {
            b(hashMap);
        }
    }
}
