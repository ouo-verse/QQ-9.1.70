package com.tencent.util;

import android.os.Debug;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ImageTestUtil {
    static IPatchRedirector $redirector_;
    private static boolean hasRecord;
    private static String[] uins;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42373);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            uins = new String[]{"35872667", "354653668", "270749863", "279242625", "1849510872"};
            hasRecord = false;
        }
    }

    public ImageTestUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void dumpFile(String str) {
        if (hasRecord) {
            return;
        }
        for (String str2 : uins) {
            if (str2.equals(str)) {
                try {
                    Debug.dumpHprofData((AppConstants.SDCARD_IMG_SAVE + "dump_") + str + System.currentTimeMillis());
                    hasRecord = true;
                    return;
                } catch (IOException unused) {
                    return;
                }
            }
        }
    }
}
