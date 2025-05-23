package com.tencent.mobileqq.qfix.redirect.utils;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

/* compiled from: P */
@Keep
/* loaded from: classes16.dex */
public class InvokeSuperRecorder {
    private static final ThreadLocal<Boolean> INVOKE_SUPER = new ThreadLocal<Boolean>() { // from class: com.tencent.mobileqq.qfix.redirect.utils.InvokeSuperRecorder.1
        @Override // java.lang.ThreadLocal
        @NonNull
        protected /* bridge */ /* synthetic */ Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    @Keep
    public static void callFromInvokeSuper() {
        INVOKE_SUPER.set(Boolean.TRUE);
    }

    @Keep
    public static boolean isCallFromInvokeSuper() {
        return INVOKE_SUPER.get().booleanValue();
    }

    @Keep
    public static void reset() {
        INVOKE_SUPER.set(Boolean.FALSE);
    }
}
