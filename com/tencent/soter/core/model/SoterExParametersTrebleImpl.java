package com.tencent.soter.core.model;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes25.dex */
public class SoterExParametersTrebleImpl implements ISoterExParameters {
    static IPatchRedirector $redirector_;
    private static int[] fingerprintPosition;
    private static int fingerprintType;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16657);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            fingerprintType = 0;
            fingerprintPosition = null;
        }
    }

    public SoterExParametersTrebleImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void setParam(@NonNull String str, Object obj) {
        synchronized (SoterExParametersTrebleImpl.class) {
            if (ISoterExParameters.FINGERPRINT_TYPE.equals(str)) {
                fingerprintType = ((Integer) obj).intValue();
            } else if (ISoterExParameters.FINGERPRINT_HARDWARE_POSITION.equals(str)) {
                fingerprintPosition = (int[]) obj;
            }
        }
    }

    @Override // com.tencent.soter.core.model.ISoterExParameters
    public Object getParam(@NonNull String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, obj);
        }
        synchronized (SoterExParametersTrebleImpl.class) {
            if (ISoterExParameters.FINGERPRINT_TYPE.equals(str)) {
                int i3 = fingerprintType;
                if (i3 != 0) {
                    obj = Integer.valueOf(i3);
                }
                return obj;
            }
            if (ISoterExParameters.FINGERPRINT_HARDWARE_POSITION.equals(str)) {
                int[] iArr = fingerprintPosition;
                if (iArr != null) {
                    obj = iArr;
                }
                return obj;
            }
            return null;
        }
    }
}
