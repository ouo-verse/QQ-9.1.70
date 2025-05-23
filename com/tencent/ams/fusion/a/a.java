package com.tencent.ams.fusion.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f70230a;

    /* compiled from: P */
    /* renamed from: com.tencent.ams.fusion.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0671a extends ThreadLocal<SimpleDateFormat> {
        static IPatchRedirector $redirector_;

        C0671a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SimpleDateFormat) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.ENGLISH);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55770);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f70230a = new C0671a();
        }
    }

    public static String a(int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, i3);
        return b().format(calendar.getTime());
    }

    public static SimpleDateFormat b() {
        return f70230a.get();
    }

    public static String c() {
        return b().format(new Date());
    }
}
