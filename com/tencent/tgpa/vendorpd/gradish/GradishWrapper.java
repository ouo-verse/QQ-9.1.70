package com.tencent.tgpa.vendorpd.gradish;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.tgpa.vendorpd.GamePredownloader;
import com.tencent.tgpa.vendorpd.b.a;
import com.tencent.tgpa.vendorpd.b.f;

/* compiled from: P */
/* loaded from: classes26.dex */
public class GradishWrapper {
    static IPatchRedirector $redirector_;
    private static boolean sIsSupportGradishWrapper;
    private static String xid;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12626);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sIsSupportGradishWrapper = false;
        }
    }

    public GradishWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static native synchronized String dbg();

    public static String getAESIVParameter() {
        if (tryLoadLibrary()) {
            return getIVParameter();
        }
        return null;
    }

    public static String getAESKey() {
        if (tryLoadLibrary()) {
            return getKey();
        }
        return null;
    }

    private static native synchronized String getIVParameter();

    private static native synchronized String getKey();

    private static String getL2ID() {
        if (tryLoadLibrary()) {
            if (a.a() == null) {
                return "-10";
            }
            String zkf = zkf(a.a());
            if (zkf == null) {
                return "-11";
            }
            if (zkf.length() != 66) {
                return "-12";
            }
            String substring = zkf.substring(2);
            xid = substring;
            return substring;
        }
        return "-9";
    }

    public static String getLibraryName() {
        return SoLoadConstants.SONAME_GRADISH_WRAPPER;
    }

    public static String getOAID(Context context, int i3) {
        return goa(context, i3);
    }

    public static String getXID() {
        String str = xid;
        if (str != null) {
            return str;
        }
        return getL2ID();
    }

    private static native synchronized String goa(Context context, int i3);

    public static void tryLoadLibrary(GamePredownloader.LibLoader libLoader) {
        if (libLoader == null || !libLoader.loadLibrary(getLibraryName())) {
            tryLoadLibrary();
        } else {
            sIsSupportGradishWrapper = true;
            f.a("load tgpa gradishwrapper lib success by loader.");
        }
    }

    private static native synchronized String yje(Context context);

    private static native synchronized String zkf(Context context);

    private static boolean tryLoadLibrary() {
        if (sIsSupportGradishWrapper) {
            return true;
        }
        if (!LibraryLoaderHelper.loadLibrary(a.a(), getLibraryName())) {
            f.d("load tgpa gradishwrapper lib failed by default!!!");
            return false;
        }
        sIsSupportGradishWrapper = true;
        f.a("load tgpa gradishwrapper lib success by default.");
        return true;
    }
}
