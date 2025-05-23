package com.tencent.mobileqq.armap.utils;

import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f199816a;

    /* renamed from: b, reason: collision with root package name */
    public static String f199817b;

    /* renamed from: c, reason: collision with root package name */
    public static String f199818c;

    static {
        boolean z16;
        File cacheDir;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70899);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f199816a = "";
        f199817b = "";
        f199818c = "";
        try {
            z16 = "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable unused) {
            z16 = false;
        }
        if (z16) {
            cacheDir = new File(AppConstants.SDCARD_PATH);
        } else {
            cacheDir = BaseApplicationImpl.getApplication().getCacheDir();
        }
        f199817b = new File(cacheDir, "AR_MAP").getAbsolutePath();
        f199816a = new File(cacheDir, "res_precover").getAbsolutePath();
        f199818c = new File(f199817b, "preload_map").getAbsolutePath();
    }

    public static String a() {
        return f199817b;
    }
}
