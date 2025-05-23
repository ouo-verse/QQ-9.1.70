package com.tencent.weiyun.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
class CNativeObject {
    static IPatchRedirector $redirector_;
    protected static final int INVALID_NATIVE_PTR = 0;
    protected long nativePtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public CNativeObject(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
        } else {
            this.nativePtr = j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.nativePtr != 0) {
            return true;
        }
        return false;
    }

    public void releaseNative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long j3 = this.nativePtr;
        if (j3 != 0) {
            this.nativePtr = 0L;
            CBundleReader.deleteBundle(j3);
        }
    }
}
