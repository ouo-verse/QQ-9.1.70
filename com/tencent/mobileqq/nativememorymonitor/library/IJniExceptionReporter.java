package com.tencent.mobileqq.nativememorymonitor.library;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IJniExceptionReporter {

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class JniException {
        static IPatchRedirector $redirector_;
        String JNI_ARGS_EXCEPTION;
        String JNI_GLOBAL_REF_OVERFLOW_EXCEPTION;
        String JNI_LOCAL_REF_OVERFLOW_EXCEPTION;
        String JNI_PINNED_REF_OVERFLOW_EXCEPTION;
        String JNI_WEAK_GLOBAL_REF_OVERFLOW_EXCEPTION;

        public JniException() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.JNI_ARGS_EXCEPTION = "CheckJNIArgsException";
            this.JNI_WEAK_GLOBAL_REF_OVERFLOW_EXCEPTION = "WeakGlobalRefOverFlowCatchedException";
            this.JNI_GLOBAL_REF_OVERFLOW_EXCEPTION = "GlobalRefOverFlowCatchedException";
            this.JNI_LOCAL_REF_OVERFLOW_EXCEPTION = "LocalRefOverflowCatchedException";
            this.JNI_PINNED_REF_OVERFLOW_EXCEPTION = "PinnedRefTableOverflowCatchedException";
        }
    }

    void reportJniException(String str, String str2);
}
