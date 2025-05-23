package com.tencent.mobileqq.nativememorymonitor.library;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ClassToFindJniOffset {
    static IPatchRedirector $redirector_;
    public static long mark2ArtMethod;
    public static long markArtMethod;

    public ClassToFindJniOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void initFromJava() {
        if (Build.VERSION.SDK_INT >= 30 && markArtMethod == 0) {
            markArtMethod = Utils.getArtMethod(ClassToFindJniOffset.class, "mark", new Class[0]);
            mark2ArtMethod = Utils.getArtMethod(ClassToFindJniOffset.class, "mark2", new Class[0]);
        }
    }

    public static native void mark();

    public static void mark2() {
    }
}
