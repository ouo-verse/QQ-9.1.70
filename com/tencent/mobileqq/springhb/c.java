package com.tencent.mobileqq.springhb;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static List<String> f288968a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        public static String a(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return "";
                }
                return "exception";
            }
            return "cover";
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static String f288969a;

        /* renamed from: b, reason: collision with root package name */
        public static String f288970b;

        /* renamed from: c, reason: collision with root package name */
        public static String f288971c;

        /* renamed from: d, reason: collision with root package name */
        public static String f288972d;

        /* renamed from: e, reason: collision with root package name */
        public static String f288973e;

        /* renamed from: f, reason: collision with root package name */
        public static String f288974f;

        /* renamed from: g, reason: collision with root package name */
        public static String f288975g;

        /* renamed from: h, reason: collision with root package name */
        public static String f288976h;

        /* renamed from: i, reason: collision with root package name */
        public static String f288977i;

        /* renamed from: j, reason: collision with root package name */
        public static String f288978j;

        /* renamed from: k, reason: collision with root package name */
        public static String f288979k;

        /* renamed from: l, reason: collision with root package name */
        public static String f288980l;

        /* renamed from: m, reason: collision with root package name */
        public static String f288981m;

        /* renamed from: n, reason: collision with root package name */
        public static String f288982n;

        /* renamed from: o, reason: collision with root package name */
        public static String f288983o;

        /* renamed from: p, reason: collision with root package name */
        public static String f288984p;

        /* renamed from: q, reason: collision with root package name */
        public static String f288985q;

        /* renamed from: r, reason: collision with root package name */
        public static String f288986r;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24096);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f288969a = "resource";
            f288970b = DownloadInfo.spKey_Config;
            f288971c = "OfflinePreload";
            f288972d = "adcode";
            f288973e = "ActivityException";
            f288974f = "ResHit";
            f288975g = "EntryMiniAppBanner";
            f288976h = "ShareShuaResult";
            f288977i = "pendant_entry";
            f288978j = "event_huxideng";
            f288979k = "shuayishua_cf";
            f288980l = "shuayishua_main";
            f288981m = "event_banner";
            f288982n = "shua1shua_share";
            f288983o = "shuayishua_pendant";
            f288984p = "shuayishua_choujiang";
            f288985q = ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE;
            f288986r = "ExCatch";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24132);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f288968a = Arrays.asList("log_type", WinkDaTongReportConstant.ElementParamKey.PG_ID, "dev_id", "web_version", "item_id", QCircleQualityReporter.KEY_OBJ_ID, "oper_res", "card_id", "changci_id", "ext1", "ext2", "ext3", "ext4", "ext5", "ext6", "ext7", "ext8", "ext9", "ext10", "ext11", "ext12", "ext13", "ext14", "ext15");
        }
    }
}
