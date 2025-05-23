package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.ModuleUpdateInterface;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LibLoadUtil {
    private static ModuleUpdateInterface moduleUpdateInterface;

    private static boolean load(Context context, String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e16) {
            VsLog.error("load " + str + " failed!", new Object[0]);
            e16.printStackTrace();
            if (context == null) {
                return false;
            }
            try {
                File file = new File(context.getDir(RFixConstants.SO_PATH, 0), System.mapLibraryName(str));
                if (file.exists()) {
                    System.load(file.getAbsolutePath());
                    return true;
                }
            } catch (Exception e17) {
                VsLog.error("load " + str + " failed!", new Object[0]);
                e17.printStackTrace();
            }
            return false;
        }
    }

    public static boolean loadso(Context context, String str) {
        boolean z16;
        ModuleUpdateInterface moduleUpdateInterface2 = moduleUpdateInterface;
        if (moduleUpdateInterface2 != null) {
            z16 = moduleUpdateInterface2.loadLibrary(str);
        } else {
            z16 = false;
        }
        if (!z16) {
            return load(context, str);
        }
        return z16;
    }

    public static void setModuleLoadInterface(ModuleUpdateInterface moduleUpdateInterface2) {
        moduleUpdateInterface = moduleUpdateInterface2;
    }
}
