package com.tencent.qfsmonet.process.core;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.utils.a;
import java.util.ArrayList;

/* loaded from: classes22.dex */
public class MonetProcessNativeWrapper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MonetProcessNativeWrapper";
    private MonetProcessNative mMonetProcessNative;

    public MonetProcessNativeWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mMonetProcessNative = null;
            this.mMonetProcessNative = new MonetProcessNative();
        }
    }

    public void deInitProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            this.mMonetProcessNative.deInitProcessor();
        } catch (Throwable th5) {
            a.b(TAG, "deInitProcessor failed, ex=" + th5.toString());
        }
    }

    public boolean initProcessor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        try {
            return this.mMonetProcessNative.initProcessor(str);
        } catch (Throwable th5) {
            a.b(TAG, "initProcessor failed, ex=" + th5.toString());
            return false;
        }
    }

    public MonetProcessData process(ArrayList<MonetProcessData> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MonetProcessData) iPatchRedirector.redirect((short) 5, (Object) this, (Object) arrayList);
        }
        try {
            return this.mMonetProcessNative.processData(arrayList);
        } catch (Throwable th5) {
            a.b(TAG, "process failed, ex=" + th5.toString());
            return null;
        }
    }

    public void setParams(@NonNull MonetProcessParams monetProcessParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) monetProcessParams);
            return;
        }
        try {
            this.mMonetProcessNative.setParameter(monetProcessParams.getOpIdentifier(), monetProcessParams.getParamsKey(), monetProcessParams.getParamsValue());
        } catch (Throwable th5) {
            a.b(TAG, "setParams failed, ex=" + th5.toString());
        }
    }

    public boolean updateProcessProtocol(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        try {
            return this.mMonetProcessNative.updateProcessProtocol(str);
        } catch (Throwable th5) {
            a.b(TAG, "setProcessProtocol failed, ex=" + th5.toString());
            return false;
        }
    }
}
