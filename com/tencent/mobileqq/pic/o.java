package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f258739a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17670);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f258739a = "PicReporter";
        }
    }

    public static void a(int i3, long j3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_network", String.valueOf(i3));
        hashMap.put("param_limit", String.valueOf(j3));
        f.b(f258739a, "reportOverFlow", "param_network:" + i3 + ",param_limit:" + j3);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPicPreDownOverFlow", false, 0L, 0L, hashMap, "");
    }

    public static void b(String str, HashMap<String, String> hashMap) {
        if (hashMap == null) {
            f.b(f258739a, "reportPicDownAutoLearn", "reportInfo == null");
        } else if (hashMap.get(IPicPreDownload.KEY_XG_PRE_DOWN_COUNT) == null) {
            f.b(f258739a, "reportPicDownAutoLearn", "no xg report data");
        } else {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "actPicDownAutoLearn", false, 0L, 0L, hashMap, "");
            f.b(f258739a, "reportPicDownAutoLearn", "");
        }
    }
}
