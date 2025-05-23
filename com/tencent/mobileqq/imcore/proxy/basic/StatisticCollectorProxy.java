package com.tencent.mobileqq.imcore.proxy.basic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* loaded from: classes15.dex */
public class StatisticCollectorProxy {
    static IPatchRedirector $redirector_ = null;
    public static final String DB_OP_RESULT = "DatabaseOperatorResult_";
    private static Proxy proxy;

    /* loaded from: classes15.dex */
    public interface Proxy {
        void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3);

        void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3, boolean z17);
    }

    /* loaded from: classes15.dex */
    public static class ReportTag {
        static IPatchRedirector $redirector_ = null;
        public static final String TAG_FAIL_CODE = "param_FailCode";

        public ReportTag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public StatisticCollectorProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3) {
        Proxy proxy2 = proxy;
        if (proxy2 != null) {
            proxy2.collectPerformance(str, str2, z16, j3, j16, hashMap, str3);
        }
    }

    public static void registerProxy(Proxy proxy2) {
        proxy = proxy2;
    }

    public static void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3, boolean z17) {
        Proxy proxy2 = proxy;
        if (proxy2 != null) {
            proxy2.collectPerformance(str, str2, z16, j3, j16, hashMap, str3, z17);
        }
    }
}
