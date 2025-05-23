package com.tencent.mobileqq.qqgift.updatasystem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGiftResDownloadReportHelper {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public @interface CacheType {
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f265006a;

        /* renamed from: b, reason: collision with root package name */
        public long f265007b;

        /* renamed from: c, reason: collision with root package name */
        @CacheType
        public int f265008c;

        /* renamed from: d, reason: collision with root package name */
        public long f265009d;

        /* renamed from: e, reason: collision with root package name */
        public String f265010e;

        public a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            this.f265007b = 0L;
            this.f265008c = -1;
            this.f265009d = 0L;
            this.f265010e = "";
            this.f265006a = str;
        }

        public a(String str, long j3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), str2);
                return;
            }
            this.f265007b = 0L;
            this.f265006a = str;
            this.f265008c = 0;
            this.f265009d = j3;
            this.f265010e = str2;
        }
    }

    public static void a(a aVar) {
    }
}
