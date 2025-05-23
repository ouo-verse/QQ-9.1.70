package com.tencent.mobileqq.msf.core.net.patch;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

/* loaded from: classes15.dex */
public class PatchCommonUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG_PATCH_LOG = "PatchLogTag";

    public PatchCommonUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getPatchDirPath(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (TextUtils.isEmpty(absolutePath)) {
            return "/data/data/com.tencent.mobileqq/files/hotpatch";
        }
        return absolutePath + File.separator + "hotpatch";
    }

    public static String getPatchPath(String str) {
        String patchDirPath = getPatchDirPath(BaseApplication.getContext());
        if (TextUtils.isEmpty(str)) {
            return patchDirPath;
        }
        return patchDirPath + File.separator + str;
    }

    public static boolean isArtGeN() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    public static boolean isArtGeO() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    public static boolean isArtLM() {
        if (Build.VERSION.SDK_INT <= 23) {
            return true;
        }
        return false;
    }

    public static boolean isDalvik() {
        return false;
    }
}
