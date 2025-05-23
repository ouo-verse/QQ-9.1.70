package com.tencent.gcloud.plugin;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes6.dex */
public class PluginUtils extends com.gcore.gcloud.plugin.PluginUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String LOG_TAG = "GCloudCoreUtils";

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f108394a = 0;
    private static boolean hasGCloudCoreUtilsLoaded;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20513);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            hasGCloudCoreUtilsLoaded = false;
        }
    }

    public PluginUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void loadLibrary(String str) {
        if (!hasGCloudCoreUtilsLoaded) {
            Log.i(LOG_TAG, "try to load libgcloudcore.so for the first time");
            System.loadLibrary("gcloudcore");
            hasGCloudCoreUtilsLoaded = true;
        }
        Log.i(LOG_TAG, "GCloudUtils.loadLibrary:lib" + str + ".so");
        System.loadLibrary(str);
    }
}
