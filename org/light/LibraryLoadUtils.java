package org.light;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import org.light.internal.relinker.ReLinker;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LibraryLoadUtils {
    public static final String TAG = "LibraryLoadUtils";
    private static Context appContext;

    public static Context getAppContext() {
        return appContext;
    }

    private static boolean load(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable th5) {
            Log.e(TAG, "loadLibrary " + str + " fail! Error: " + th5.getMessage());
            return false;
        }
    }

    public static boolean loadLibrary(String str) {
        try {
            appContext = ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return loadLibrary(appContext, str);
    }

    private static boolean relinker(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                ReLinker.loadLibrary(context, str);
                return true;
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return false;
    }

    private static boolean load(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.load((context.getApplicationInfo().dataDir + "/lib") + File.separator + RFixConstants.SO_PATH + str + ".so");
            return true;
        } catch (Throwable th5) {
            Log.i(TAG, "load  fail! Error: " + th5.getMessage());
            return false;
        }
    }

    private static boolean loadLibrary(Context context, String str) {
        if (load(str) || load(context, str)) {
            return true;
        }
        return relinker(context, str);
    }
}
