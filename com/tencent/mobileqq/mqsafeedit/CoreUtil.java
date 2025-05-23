package com.tencent.mobileqq.mqsafeedit;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;

/* compiled from: P */
/* loaded from: classes15.dex */
public class CoreUtil {
    static IPatchRedirector $redirector_;

    public CoreUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getTxLib(Context context) {
        return String.valueOf(context.getFilesDir().getParent()) + SoLoadCore.PATH_TX_LIB;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean loadLibrary(String str, Context context) {
        boolean z16;
        if (context == null) {
            return false;
        }
        File file = new File(String.valueOf(getTxLib(context)) + RFixConstants.SO_PATH + str + ".so");
        if (!file.exists()) {
            file = new File(String.valueOf(context.getFilesDir().getParent()) + "/lib/lib" + str + ".so");
        }
        if (file.exists()) {
            try {
                System.load(file.getAbsolutePath());
                z16 = true;
            } catch (UnsatisfiedLinkError unused) {
            }
            if (z16) {
                try {
                    System.loadLibrary(str);
                    return true;
                } catch (UnsatisfiedLinkError unused2) {
                    return false;
                }
            }
            return z16;
        }
        z16 = false;
        if (z16) {
        }
    }
}
