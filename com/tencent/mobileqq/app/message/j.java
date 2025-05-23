package com.tencent.mobileqq.app.message;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes11.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Random f196015a;

    /* renamed from: b, reason: collision with root package name */
    private static List<a> f196016b;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        private static LinkedList<a> f196017f;

        /* renamed from: a, reason: collision with root package name */
        int f196018a;

        /* renamed from: b, reason: collision with root package name */
        String f196019b;

        /* renamed from: c, reason: collision with root package name */
        long f196020c;

        /* renamed from: d, reason: collision with root package name */
        int f196021d;

        /* renamed from: e, reason: collision with root package name */
        int f196022e;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70338);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f196017f = new LinkedList<>();
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static synchronized a a(int i3, String str, long j3, int i16, int i17) {
            a aVar;
            synchronized (a.class) {
                if (f196017f.size() > 0) {
                    aVar = f196017f.remove(0);
                } else {
                    aVar = new a();
                }
                aVar.f196018a = i3;
                aVar.f196019b = str;
                aVar.f196020c = j3;
                aVar.f196021d = i16;
                aVar.f196022e = i17;
            }
            return aVar;
        }

        public static synchronized void b(List<a> list) {
            synchronized (a.class) {
                if (f196017f.size() >= 100) {
                    return;
                }
                Iterator<a> it = list.iterator();
                while (it.hasNext()) {
                    f196017f.add(it.next());
                    if (f196017f.size() >= 100) {
                        break;
                    }
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70339);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f196015a = new Random();
            f196016b = new ArrayList(32);
        }
    }

    public static void a(MessageRecord messageRecord, AppInterface appInterface) {
        int i3;
        if (!appInterface.getCurrentUin().endsWith("77")) {
            return;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        long j3 = messageRecord.time;
        long j16 = serverTime - j3;
        if (j16 < 30) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        long j17 = qQAppInterface.mLoginTime;
        if (j17 != 0 && j3 < j17) {
            return;
        }
        if (j3 < qQAppInterface.mRegisterPushTime) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        a a16 = a.a(i3, appInterface.getCurrentUin(), j16, messageRecord.msgtype, messageRecord.istroop);
        synchronized (f196016b) {
            f196016b.add(a16);
            if (f196016b.size() >= 32) {
                b();
            }
        }
    }

    public static void b() {
        synchronized (f196016b) {
            for (a aVar : f196016b) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_FailCode", String.valueOf(aVar.f196018a));
                hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
                hashMap.put(QQBrowserActivity.KEY_MSG_TYPE, String.valueOf(aVar.f196021d));
                hashMap.put("uinType", String.valueOf(aVar.f196022e));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(aVar.f196019b, "actBelatedMsg", false, aVar.f196020c, 0L, hashMap, "");
            }
            a.b(f196016b);
            f196016b.clear();
        }
    }

    public static void c(String str, long j3) {
        if (Math.abs(f196015a.nextInt() % 10000) < 10) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, j3, 0L, hashMap, "");
        }
    }

    public static void d(QQAppInterface qQAppInterface, String str, int i3) {
        if (!qQAppInterface.getCurrentUin().endsWith("7")) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        hashMap.put("uinType", String.valueOf(i3));
        hashMap.put("convUin", String.valueOf(str));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actNoCachedLastMsg", true, 0L, 0L, hashMap, "");
    }
}
