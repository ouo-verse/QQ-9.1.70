package com.tencent.soter.core.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.SoterCore;

/* loaded from: classes25.dex */
public class SoterExParameters {
    static IPatchRedirector $redirector_ = null;
    private static final String SOTEREX_PROVIDER_CLASS_NAME = "com.tencent.soter.core.model.SoterExParameterProvider";
    private static final String TAG = "SoterExParameters";
    private static SoterExParameters instance;
    private ISoterExParameters impl;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16653);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            instance = null;
        }
    }

    SoterExParameters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.impl = null;
        try {
            this.impl = (ISoterExParameters) Class.forName(SOTEREX_PROVIDER_CLASS_NAME).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            SLogger.i(TAG, "soter: get system SoterExParameterProvider class success", new Object[0]);
        } catch (Exception unused) {
            SLogger.i(TAG, "soter: get system SoterExParameterProvider class fail", new Object[0]);
            if (SoterCore.getSoterCoreType() == 1) {
                this.impl = new SoterExParametersTrebleImpl();
                if (SoterCore.getImpl() != null) {
                    SoterCore.getImpl().updateExtraParam();
                    return;
                } else {
                    SLogger.e(TAG, "soter: SoterExParameters updateExtraParam fail, SoterCore.getImpl is null", new Object[0]);
                    return;
                }
            }
            SLogger.e(TAG, "soter: SoterExParameters updateExtraParam fail, SoterCoreType is not TREBLE", new Object[0]);
        }
    }

    public static SoterExParameters getInstance() {
        SoterExParameters soterExParameters;
        SoterExParameters soterExParameters2 = instance;
        if (soterExParameters2 == null) {
            synchronized (SoterExParameters.class) {
                if (instance == null) {
                    instance = new SoterExParameters();
                }
                soterExParameters = instance;
            }
            return soterExParameters;
        }
        return soterExParameters2;
    }

    public int[] getFingerprintHardwarePosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Object param = getParam(ISoterExParameters.FINGERPRINT_HARDWARE_POSITION, null);
        if (!(param instanceof int[])) {
            return null;
        }
        return (int[]) param;
    }

    public int getFingerprintType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        Object param = getParam(ISoterExParameters.FINGERPRINT_TYPE, 0);
        if (!(param instanceof Integer)) {
            return 0;
        }
        return ((Integer) param).intValue();
    }

    public Object getParam(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, obj);
        }
        ISoterExParameters iSoterExParameters = this.impl;
        if (iSoterExParameters != null) {
            return iSoterExParameters.getParam(str, obj);
        }
        return null;
    }
}
