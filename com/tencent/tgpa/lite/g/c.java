package com.tencent.tgpa.lite.g;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        public static final a f375972b;

        /* renamed from: c, reason: collision with root package name */
        public static final a f375973c;

        /* renamed from: d, reason: collision with root package name */
        public static final a f375974d;

        /* renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f375975e;

        /* renamed from: a, reason: collision with root package name */
        private String f375976a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15613);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            a aVar = new a("PATTERN1", 0, "yyyy_MM_dd_HH_mm_ss");
            f375972b = aVar;
            a aVar2 = new a("PATTERN2", 1, "yyyy-MM-dd HH:mm:ss");
            f375973c = aVar2;
            a aVar3 = new a("PATTERN3", 2, "yyyy-MM-dd HH:mm:ss.SSS");
            f375974d = aVar3;
            f375975e = new a[]{aVar, aVar2, aVar3};
        }

        a(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
            } else {
                this.f375976a = str2;
            }
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f375975e.clone();
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f375976a;
        }
    }

    public static String a() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String a(String str) {
        return new SimpleDateFormat(str, Locale.CHINA).format(new Date());
    }
}
