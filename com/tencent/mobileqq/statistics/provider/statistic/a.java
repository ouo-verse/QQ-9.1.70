package com.tencent.mobileqq.statistics.provider.statistic;

import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.LocalMultiProcConfig;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements Provider<aa1.a> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.statistics.provider.statistic.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class C8618a implements aa1.a {
        static IPatchRedirector $redirector_;

        C8618a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // aa1.a
        public int getInt(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3)).intValue();
            }
            return LocalMultiProcConfig.getInt(str, i3);
        }

        @Override // aa1.a
        public void putInt(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            } else {
                LocalMultiProcConfig.putInt(str, i3);
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public aa1.a get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (aa1.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new C8618a();
    }
}
