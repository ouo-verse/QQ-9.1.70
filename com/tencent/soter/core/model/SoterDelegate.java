package com.tencent.soter.core.model;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SoterDelegate {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Soter.SoterDelegate";

    @NonNull
    private static volatile ISoterDelegate sSoterDelegateImp;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface ISoterDelegate {
        boolean isTriggeredOOM();

        void onTriggeredOOM();

        void reset();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16639);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sSoterDelegateImp = new ISoterDelegate() { // from class: com.tencent.soter.core.model.SoterDelegate.1
                static IPatchRedirector $redirector_;
                private boolean isTriggeredOOM;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    } else {
                        this.isTriggeredOOM = false;
                    }
                }

                @Override // com.tencent.soter.core.model.SoterDelegate.ISoterDelegate
                public boolean isTriggeredOOM() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
                    }
                    return this.isTriggeredOOM;
                }

                @Override // com.tencent.soter.core.model.SoterDelegate.ISoterDelegate
                public void onTriggeredOOM() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        SLogger.e(SoterDelegate.TAG, "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
                        this.isTriggeredOOM = true;
                    }
                }

                @Override // com.tencent.soter.core.model.SoterDelegate.ISoterDelegate
                public void reset() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this);
                    } else {
                        this.isTriggeredOOM = false;
                    }
                }
            };
        }
    }

    public SoterDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isTriggeredOOM() {
        return sSoterDelegateImp.isTriggeredOOM();
    }

    public static void onTriggerOOM() {
        sSoterDelegateImp.onTriggeredOOM();
    }

    public static void reset() {
        sSoterDelegateImp.reset();
    }

    public static void setImplement(@NonNull ISoterDelegate iSoterDelegate) {
        sSoterDelegateImp = iSoterDelegate;
    }
}
