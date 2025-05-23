package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f289994a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f289995b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f289996c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75418);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f289994a = false;
        f289995b = false;
        f289996c = false;
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a() {
    }

    public static void b() {
    }

    public static void c(MessageRecord messageRecord) {
    }

    public static void d(AbsStructMsg absStructMsg) {
    }
}
