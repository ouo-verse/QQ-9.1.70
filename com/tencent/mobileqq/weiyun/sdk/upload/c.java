package com.tencent.mobileqq.weiyun.sdk.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface c {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f315268a;

        /* renamed from: b, reason: collision with root package name */
        public long f315269b;

        /* renamed from: c, reason: collision with root package name */
        public Throwable f315270c;

        /* renamed from: d, reason: collision with root package name */
        public String f315271d;

        /* renamed from: e, reason: collision with root package name */
        public long f315272e;

        /* renamed from: f, reason: collision with root package name */
        public long f315273f;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f315270c = null;
            }
        }
    }

    int a();
}
