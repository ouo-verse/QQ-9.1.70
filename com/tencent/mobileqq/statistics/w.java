package com.tencent.mobileqq.statistics;

import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.util.IUtilApi;
import com.tencent.util.UtilApi;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class w {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static LinkedList<a> f290169a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Class f290170a;

        /* renamed from: b, reason: collision with root package name */
        public long f290171b;

        /* renamed from: c, reason: collision with root package name */
        public long f290172c;

        /* renamed from: d, reason: collision with root package name */
        public String f290173d;

        /* renamed from: e, reason: collision with root package name */
        public int f290174e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36460);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f290169a = new LinkedList<>();
        }
    }

    public static void a(Class<?> cls, int i3, int i16, String str) {
        String str2;
        if (cls != null && str != null) {
            if (str.contains("/qunactivity/")) {
                str2 = "0X8004EC8";
            } else {
                str2 = null;
            }
            if (str.contains("/hotchat/")) {
                str2 = "0X8004410";
                i16 = 2;
            }
            if (str2 != null) {
                b(null, cls, i3, str2, i16);
            }
        }
    }

    public static void b(AppInterface appInterface, Class cls, int i3, String str, int i16) {
        c(appInterface, cls, i3, str, i16, "");
    }

    public static void c(AppInterface appInterface, Class cls, int i3, String str, int i16, String str2) {
        if (cls == null) {
            return;
        }
        int size = f290169a.size();
        if (size > 0) {
            for (int i17 = size - 1; i17 >= 0; i17--) {
                a aVar = f290169a.get(i17);
                if (aVar.f290170a == cls) {
                    if (appInterface instanceof BaseQQAppInterface) {
                        String str3 = aVar.f290173d;
                        ReportController.o((BaseQQAppInterface) appInterface, "CliOper", "", "", str3, str3, aVar.f290174e, 0, str2, Long.toString(SystemClock.elapsedRealtime() - aVar.f290172c), "", "");
                    } else if (appInterface != null) {
                        IUtilApi iUtilApi = UtilApi.util;
                        String str4 = aVar.f290173d;
                        iUtilApi.dispatchReport(appInterface, "CliOper", "", "", str4, str4, aVar.f290174e, 0, str2, Long.toString(SystemClock.elapsedRealtime() - aVar.f290172c), "", "");
                    } else {
                        String str5 = aVar.f290173d;
                        ReportController.o(null, "CliOper", "", "", str5, str5, aVar.f290174e, 0, str2, Long.toString(SystemClock.elapsedRealtime() - aVar.f290172c), "", "");
                    }
                    f290169a.remove(i17);
                }
            }
        }
        a aVar2 = new a();
        aVar2.f290170a = cls;
        aVar2.f290171b = i3;
        aVar2.f290172c = SystemClock.elapsedRealtime();
        aVar2.f290173d = str;
        aVar2.f290174e = i16;
        f290169a.add(aVar2);
    }

    public static a d(Class cls, int i3) {
        if (cls == null) {
            return null;
        }
        for (int size = f290169a.size() - 1; size >= 0; size--) {
            a aVar = f290169a.get(size);
            if (cls == aVar.f290170a && i3 == aVar.f290171b) {
                f290169a.remove(size);
                return aVar;
            }
        }
        return null;
    }

    public static void e(long j3) {
        Iterator<a> it = f290169a.iterator();
        while (it.hasNext()) {
            it.next().f290172c += j3;
        }
    }
}
