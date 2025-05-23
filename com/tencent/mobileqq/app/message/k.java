package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f196023a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f196024b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70340);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f196023a = false;
            f196024b = false;
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a(QQAppInterface qQAppInterface, String str, int i3) {
        if (i3 == 1008) {
            return com.tencent.qqnt.contact.friends.b.f355778a.c(str, "MsgInvalidTypeErr");
        }
        return false;
    }

    public static void b(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb5 = new StringBuilder(512);
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb5.append(stackTraceElement.toString());
            sb5.append("\n");
        }
        QLog.i(str, 1, sb5.toString());
    }

    public static void c(MessageRecord messageRecord) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        hashMap.put("param_FailCode", String.valueOf(messageRecord.istroop));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actInvalidMessageRecord", false, 0L, 0L, hashMap, "");
    }

    public static void d(String str) {
        if (!f196024b) {
            f196024b = true;
            b("reportInvalidRefredshLastMsg");
            com.tencent.qqperf.monitor.crash.catchedexception.a.c(new RuntimeException(), str);
        }
    }
}
