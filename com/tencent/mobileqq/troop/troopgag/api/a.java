package com.tencent.mobileqq.troop.troopgag.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.troopgag.api.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C8807a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f300216a;

        /* renamed from: b, reason: collision with root package name */
        public long f300217b;

        public C8807a(String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3));
            } else {
                this.f300216a = str;
                this.f300217b = j3;
            }
        }
    }

    void C(com.tencent.mobileqq.troop.troopgag.data.a aVar);

    void u0(String str, String str2, boolean z16, long j3);
}
