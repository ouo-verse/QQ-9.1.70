package com.tencent.nativecpp.tedgecpp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.jnishare.TEdgeRSSharedBase;

/* loaded from: classes21.dex */
public class CPPAlgorithmServer extends TEdgeRSSharedBase {
    static IPatchRedirector $redirector_;
    ICPPAlgorithmServerCallback mServerCallback;
    protected String mServerID;

    public CPPAlgorithmServer(String str, ICPPAlgorithmServerCallback iCPPAlgorithmServerCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) iCPPAlgorithmServerCallback);
            return;
        }
        this.mServerID = str;
        this.mServerCallback = iCPPAlgorithmServerCallback;
        init(str, iCPPAlgorithmServerCallback);
    }

    public static native boolean canUseSo(int i3);

    public native CPPActionsFeature getCPPActionsFeature();

    public native CPPActionsFeatureProvider getCPPActionsFeatureProvider();

    public native CPPCollaborativeInference getCPPCollaborativeInference();

    public native CPPCollaborativeTraining getCPPCollaborativeTraining();

    public native CPPPolicyManager getCPPPolicyManager();

    public native CPPTriggerManager getCPPTriggerManager();

    public native CPPConvertFeedBackProvider getConvertFeedBackProvider();

    public native void init(String str, ICPPAlgorithmServerCallback iCPPAlgorithmServerCallback);
}
