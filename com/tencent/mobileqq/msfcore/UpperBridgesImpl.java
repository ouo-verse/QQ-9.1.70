package com.tencent.mobileqq.msfcore;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class UpperBridgesImpl implements UpperBridges {
    static IPatchRedirector $redirector_;
    private final BeaconBridge beaconBridge;
    private final ILogger logger;
    private final IMSFCallbackBridge msfCallbackBridge;
    private final ISoLoader soLoader;

    public UpperBridgesImpl(IMSFCallbackBridge iMSFCallbackBridge, ISoLoader iSoLoader, BeaconBridge beaconBridge, ILogger iLogger) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iMSFCallbackBridge, iSoLoader, beaconBridge, iLogger);
            return;
        }
        this.msfCallbackBridge = iMSFCallbackBridge;
        this.soLoader = iSoLoader;
        this.beaconBridge = beaconBridge;
        this.logger = iLogger;
    }

    @Override // com.tencent.mobileqq.msfcore.UpperBridges
    @Nullable
    public BeaconBridge getBeaconBridge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BeaconBridge) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.beaconBridge;
    }

    @Override // com.tencent.mobileqq.msfcore.UpperBridges
    @Nullable
    public ILogger getLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ILogger) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.logger;
    }

    @Override // com.tencent.mobileqq.msfcore.UpperBridges
    @Nullable
    public IMSFCallbackBridge getMSFCallbackBridge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IMSFCallbackBridge) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.msfCallbackBridge;
    }

    @Nullable
    public ISoLoader getSoLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ISoLoader) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.soLoader;
    }
}
