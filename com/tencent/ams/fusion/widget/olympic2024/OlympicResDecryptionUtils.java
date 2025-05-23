package com.tencent.ams.fusion.widget.olympic2024;

import android.graphics.Bitmap;
import com.tencent.ams.fusion.widget.utils.FileDecryptionUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OlympicResDecryptionUtils {
    static IPatchRedirector $redirector_;
    private static final FileDecryptionUtils utils;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18794);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            utils = new FileDecryptionUtils("5iWh5ztQ5on27Wg4");
        }
    }

    public OlympicResDecryptionUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Bitmap decryptBitmapByAES(String str) {
        return utils.decryptBitmapByAES(str);
    }

    public static Bitmap decryptBitmapByBase64(String str) {
        return utils.decryptBitmapByBase64(str);
    }

    public static boolean decryptFileByAES(String str, String str2) {
        return utils.decryptFileByAES(str, str2);
    }

    public static boolean decryptFileByBase64(String str, String str2) {
        return utils.decryptFileByBase64(str, str2);
    }

    public static String decryptUrlByAES(String str) {
        return utils.decryptUrlByAES(str);
    }

    public static String decryptUrlByBase64(String str) {
        return utils.decryptUrlByBase64(str);
    }

    public static boolean decryptFileByAES(String str, String str2, FileDecryptionUtils.DecryptionListener decryptionListener) {
        return utils.decryptFileByAES(str, str2, decryptionListener);
    }
}
