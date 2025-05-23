package com.tencent.ams.xsad.rewarded.loader;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface c {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(b bVar);

        void b(b bVar, File file);

        void c(b bVar, String str);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f71831a;

        /* renamed from: b, reason: collision with root package name */
        public String f71832b;

        /* renamed from: c, reason: collision with root package name */
        public String f71833c;

        b(int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2);
                return;
            }
            this.f71831a = i3;
            this.f71832b = str;
            this.f71833c = str2;
        }

        public static b a(String str) {
            return b(str, null);
        }

        public static b b(String str, String str2) {
            return new b(0, str, str2);
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return String.format(Locale.getDefault(), "(type:%d, url:%s, md5:%s)", Integer.valueOf(this.f71831a), this.f71832b, this.f71833c);
        }
    }

    void a(b bVar, a aVar);

    void b(b bVar, a aVar);
}
