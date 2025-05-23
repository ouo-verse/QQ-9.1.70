package com.tencent.mobileqq.troop.fans.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<C8682a> f295403a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.fans.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C8682a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f295404a;

        /* renamed from: b, reason: collision with root package name */
        public String f295405b;

        /* renamed from: c, reason: collision with root package name */
        public String f295406c;

        /* renamed from: d, reason: collision with root package name */
        public String f295407d;

        /* renamed from: e, reason: collision with root package name */
        public long f295408e;

        /* renamed from: f, reason: collision with root package name */
        public long f295409f;

        public C8682a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f295404a = 0;
            this.f295405b = "";
            this.f295406c = "";
            this.f295407d = "";
            this.f295408e = 0L;
            this.f295409f = 0L;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "idolid:" + this.f295404a + " name:" + this.f295405b + " avatar:" + this.f295406c + " pic:" + this.f295407d + " rank:" + this.f295408e + " qScore:" + this.f295409f + " ";
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f295403a = new ArrayList<>();
        }
    }
}
