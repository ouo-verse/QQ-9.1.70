package com.tencent.qfsmonet.process.core;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.process.common.MonetNativeLibraryLoader;
import com.tencent.qfsmonet.utils.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes22.dex */
public class MonetProcessNative {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MonetProcessNative";
    private static boolean mMonetLoadSuccess;

    @Keep
    private long mNativeMonetCallback;

    @Keep
    private long mNativeMonetContext;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26378);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        mMonetLoadSuccess = false;
        try {
            MonetNativeLibraryLoader.loadLibIfNeeded();
            mMonetLoadSuccess = true;
        } catch (UnsupportedOperationException e16) {
            a.b(TAG, "load monet failed, ex=" + e16.toString());
            mMonetLoadSuccess = false;
        }
    }

    public MonetProcessNative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.mNativeMonetContext = 0L;
        this.mNativeMonetCallback = 0L;
        a.c(TAG, "MonetProcessNative!");
    }

    @Keep
    public native void deInitMonetProcessor();

    public void deInitProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        try {
            if (!mMonetLoadSuccess) {
                a.b(TAG, "deInitProcess failed, so not load!");
            } else {
                deInitMonetProcessor();
            }
        } catch (Throwable th5) {
            a.b(TAG, "deInitMonetProcess failed" + th5.toString());
        }
    }

    @Keep
    public native boolean initMonetProcessor(Object obj, String str);

    public boolean initProcessor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        a.c(TAG, "initProcessor!");
        try {
            if (!mMonetLoadSuccess) {
                a.b(TAG, "initProcessor failed, so not load!");
                return false;
            }
            return initMonetProcessor(new WeakReference(this), str);
        } catch (Throwable th5) {
            a.b(TAG, "initMonetProcessor failed" + th5.toString());
            return false;
        }
    }

    @Keep
    public native MonetProcessData processData(ArrayList<MonetProcessData> arrayList);

    @Keep
    public native void setParameter(String str, String str2, String str3);

    @Keep
    public native boolean updateProcessProtocol(String str);
}
