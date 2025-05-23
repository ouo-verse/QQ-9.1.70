package com.tencent.avcore.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavABTestHelper {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private static volatile QavABTestHelper sInstance;
    private a mQavABTest;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        b a(String str);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f77542a;

        /* renamed from: b, reason: collision with root package name */
        public String f77543b;

        /* renamed from: c, reason: collision with root package name */
        public String f77544c;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17192);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            TAG = QavABTestHelper.class.getSimpleName();
            sInstance = null;
        }
    }

    QavABTestHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            init();
        }
    }

    private String[] getABTestExp(String str) {
        a aVar = this.mQavABTest;
        if (aVar != null) {
            b a16 = aVar.a(str);
            return new String[]{String.valueOf(a16.f77542a), a16.f77543b, a16.f77544c};
        }
        return null;
    }

    public static QavABTestHelper getInstance() {
        if (sInstance == null) {
            synchronized (QavABTestHelper.class) {
                if (sInstance == null) {
                    sInstance = new QavABTestHelper();
                }
            }
        }
        return sInstance;
    }

    private native void init();

    public void setABTest(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.mQavABTest = aVar;
        }
    }
}
