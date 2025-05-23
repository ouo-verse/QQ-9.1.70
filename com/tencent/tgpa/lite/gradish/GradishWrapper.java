package com.tencent.tgpa.lite.gradish;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tgpa.lite.a.b;
import com.tencent.tgpa.lite.g.a;
import com.tencent.tgpa.lite.g.h;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public class GradishWrapper {
    static IPatchRedirector $redirector_ = null;
    private static boolean sIsSupportGradishWrapper = false;
    private static String uniqueID;
    private static String uniqueIDL2;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15733);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public GradishWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static native String dbg();

    private static synchronized String getCommonUniqueID(Context context) {
        String str;
        synchronized (GradishWrapper.class) {
            if (uniqueID == null) {
                uniqueID = yje(context);
            }
            str = uniqueID;
        }
        return str;
    }

    public static String getCommonUniqueID2WithFlag() {
        return "-1";
    }

    public static String getCommonUniqueID2WithoutFlag() {
        return "-1";
    }

    private static synchronized String getCommonUniqueIDL2(Context context) {
        String str;
        synchronized (GradishWrapper.class) {
            if (uniqueIDL2 == null) {
                uniqueIDL2 = zkf(context);
            }
            str = uniqueIDL2;
        }
        return str;
    }

    public static String getCommonUniqueIDWithFlag() {
        return "-1";
    }

    public static String getCommonUniqueIDWithoutFlag() {
        return "-1";
    }

    public static synchronized String getDebugID() {
        synchronized (GradishWrapper.class) {
        }
        return "-1";
    }

    private static int getFlag(Context context) {
        return 0;
    }

    public static String getL1IDFlag1() {
        return "-1";
    }

    public static String getL1IDFlag2() {
        return "-1";
    }

    public static String getL2IDFlag() {
        return "-1";
    }

    public static String getOAID(int i3) {
        if (!tryLoadLibrary()) {
            return "-9";
        }
        if (!isOAIDEnable()) {
            return "-13";
        }
        if (a.a() == null) {
            return "-10";
        }
        String goa = goa(a.a(), i3);
        if (goa == null) {
            return "-11";
        }
        return goa;
    }

    private static native String goa(Context context, int i3);

    public static boolean isGradishDebugIDEnable() {
        return b.a().f375868a.f375877d;
    }

    public static boolean isGradishEnable() {
        return b.a().f375868a.f375879f;
    }

    public static boolean isGradishL1Enable() {
        return b.a().f375868a.f375878e;
    }

    public static boolean isOAIDEnable() {
        return b.a().f375868a.f375880g;
    }

    private static boolean tryLoadLibrary() {
        if (sIsSupportGradishWrapper) {
            return true;
        }
        boolean loadLibrary = LibraryLoaderHelper.loadLibrary(a.a(), "tgpalite");
        sIsSupportGradishWrapper = loadLibrary;
        if (loadLibrary) {
            h.c("load tgpalite lib success!!!", new Object[0]);
        } else {
            h.b("load tgpalite lib failed!!!", new Object[0]);
        }
        return sIsSupportGradishWrapper;
    }

    private static native String yje(Context context);

    private static native String yjeByFlag(Context context, int i3);

    private static native String zkf(Context context);

    private static native String zkfByFlag(Context context, int i3);

    public static boolean tryLoadLibrary(String str) {
        if (sIsSupportGradishWrapper) {
            return true;
        }
        boolean loadLibrary = LibraryLoaderHelper.loadLibrary(new File(str));
        sIsSupportGradishWrapper = loadLibrary;
        if (loadLibrary) {
            h.c("load tgpalite lib by absolute path success!!!", new Object[0]);
        } else {
            h.b("load tgpalite lib by absolute failed!!!", new Object[0]);
        }
        return sIsSupportGradishWrapper;
    }
}
