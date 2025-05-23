package com.tencent.mobileqq.springhb;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.entry.model.TimeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Comparator<com.tencent.mobileqq.springhb.entry.model.a> f288967a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Comparator<com.tencent.mobileqq.springhb.entry.model.a> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.springhb.entry.model.a aVar, com.tencent.mobileqq.springhb.entry.model.a aVar2) {
            long j3;
            long j16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) aVar2)).intValue();
            }
            if (aVar.getConfigTime().begin == aVar2.getConfigTime().begin) {
                j3 = aVar.getConfigTime().end;
                j16 = aVar2.getConfigTime().end;
            } else {
                j3 = aVar.getConfigTime().begin;
                j16 = aVar2.getConfigTime().begin;
            }
            return b.b(j3, j16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75246);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f288967a = new a();
        }
    }

    public static String a(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return "";
            }
            return "ON_GRAB";
        }
        return "PRE_GRAB";
    }

    public static int b(long j3, long j16) {
        if (j3 == j16) {
            return 0;
        }
        if (j3 > j16) {
            return 1;
        }
        return -1;
    }

    public static boolean c(TimeInfo timeInfo, long j3) {
        if (timeInfo == null) {
            QLog.w("SpringHb_", 1, "isInTime --> timeInfo is null");
            return false;
        }
        if (!e(timeInfo)) {
            return false;
        }
        if (timeInfo.begin <= j3 && j3 <= timeInfo.end) {
            return true;
        }
        return false;
    }

    public static boolean d(TimeInfo timeInfo, long j3) {
        if (timeInfo == null) {
            QLog.w("SpringHb_", 1, "isInTimeButNotEnd --> timeInfo is null");
            return false;
        }
        if (!e(timeInfo)) {
            return false;
        }
        if (timeInfo.begin <= j3 && j3 < timeInfo.end) {
            return true;
        }
        return false;
    }

    public static boolean e(TimeInfo timeInfo) {
        long j3 = timeInfo.begin;
        if (j3 > 0 && timeInfo.end > j3) {
            return true;
        }
        return false;
    }

    public static TimeInfo f(TimeInfo timeInfo, TimeInfo timeInfo2) {
        return timeInfo2;
    }
}
