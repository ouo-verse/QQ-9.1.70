package com.tencent.mobileqq.qmcf.bighead;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;

/* compiled from: P */
/* loaded from: classes16.dex */
public class BigHeadTest {
    static IPatchRedirector $redirector_ = null;
    private static final String bigHeadPath = "/sdcard/bigHead/";
    private static final String commonPrefix = "/sdcard/bigHead/output/";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13383);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        try {
            System.loadLibrary("Native");
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
    }

    public BigHeadTest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getCommonPrefix() {
        return commonPrefix;
    }

    public static String getModelPath() {
        return "/sdcard/bigHead/Android_net256.txt";
    }

    public static String getParamPath() {
        return "/sdcard/bigHead/change_4.3.bin";
    }

    public static void testInit() {
        File file = new File(commonPrefix);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
