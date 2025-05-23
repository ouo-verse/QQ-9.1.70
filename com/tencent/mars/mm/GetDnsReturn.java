package com.tencent.mars.mm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class GetDnsReturn {
    static IPatchRedirector $redirector_;
    public String[] aryIps;
    public int length;
    public int type;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class ResolveHostFlag {
        static IPatchRedirector $redirector_ = null;
        public static final int FLAGS_ALLINONE = 7;
        public static final int FLAGS_NEWDNS_DEFAULT = 5;
        public static final int FLAGS_SIMPLEDNS_DEFAULT = 6;
        public static final int FLAG_TRY_LOCALDNS = 4;
        public static final int FLAG_TRY_NEWDNS = 1;
        public static final int FLAG_TRY_SIMPLEDNS = 2;

        public ResolveHostFlag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class ResolveHostPriority {
        static IPatchRedirector $redirector_ = null;
        public static final int PRIORITY_NEWDNS_FIRST = 0;
        public static final int PRIORITY_SIMPLEDNS_FIRST = 1;

        public ResolveHostPriority() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class ResolvedType {
        static IPatchRedirector $redirector_ = null;
        public static final int DEBUGIP = 3;
        public static final int LITERAL = 5;
        public static final int LOCALDNS = 2;
        public static final int NEWDNS = 1;
        public static final int NONE = 0;
        public static final int SIMPLEDNS = 4;

        public ResolvedType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public GetDnsReturn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.type = 0;
            this.aryIps = new String[50];
        }
    }
}
