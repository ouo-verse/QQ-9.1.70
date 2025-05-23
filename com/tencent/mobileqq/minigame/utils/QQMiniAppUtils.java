package com.tencent.mobileqq.minigame.utils;

import android.app.Activity;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.at;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class QQMiniAppUtils {
    private static final String DEBUG_TRITON_SO_PATH = "/data/local/tmp/minigame";
    private static final String TAG = "QQMiniAppUtils";
    private static final String TRITON_SO_NAME = "libtriton.so";
    private static String sDebugJsLibPath;
    private static String sTritonDebugSoPath;

    public static int getColorNoteType(Activity activity) {
        IColorNoteController g16;
        if (activity instanceof GameActivity1) {
            IColorNoteController colorNoteController = ((GameActivity1) activity).getColorNoteController();
            if (colorNoteController != null) {
                return getColorNoteType(colorNoteController);
            }
            return 0;
        }
        PageGestureProxy pageGestureProxy = (PageGestureProxy) AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
        if (!(pageGestureProxy instanceof at) || (g16 = ((at) pageGestureProxy).g()) == null) {
            return 0;
        }
        return getColorNoteType(g16);
    }

    public static cu3.a getConfig() {
        cu3.a aVar = (cu3.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100863");
        return aVar == null ? new cu3.a() : aVar;
    }

    public static String getDebugJsLibPath() {
        File file;
        File[] listFiles;
        String str = sDebugJsLibPath;
        if (str != null) {
            return str;
        }
        try {
            file = new File("/data/local/tmp/jslibs");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getDebugJsLibPath failed.", e16);
        }
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            File file2 = null;
            for (File file3 : listFiles) {
                if (file3.getName().startsWith("minigame_")) {
                    if (file2 != null && file2.lastModified() >= file3.lastModified()) {
                    }
                    file2 = file3;
                }
            }
            if (file2 != null) {
                sDebugJsLibPath = file2.getAbsolutePath();
                QLog.i(TAG, 1, "getDebugJsLibPath=" + sDebugJsLibPath);
                return sDebugJsLibPath;
            }
            return null;
        }
        return null;
    }

    public static String getDebugTritonPath() {
        String str = sTritonDebugSoPath;
        if (str != null) {
            return str;
        }
        try {
            File file = new File(DEBUG_TRITON_SO_PATH, TRITON_SO_NAME);
            if (!file.exists()) {
                return null;
            }
            File cacheDir = MobileQQ.sMobileQQ.getCacheDir();
            File file2 = new File(cacheDir, TRITON_SO_NAME);
            if (file2.exists()) {
                file2.delete();
            }
            com.tencent.mobileqq.utils.FileUtils.copyFile(file, file2);
            sTritonDebugSoPath = cacheDir.getAbsolutePath();
            QLog.i(TAG, 1, "getDebugTritonPath=" + sTritonDebugSoPath);
            return sTritonDebugSoPath;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getDebugTritonPath failed.", e16);
            return null;
        }
    }

    public static int getColorNoteType(IColorNoteController iColorNoteController) {
        if (iColorNoteController.shouldDisplayColorNote()) {
            return iColorNoteController.isColorNoteExist() ? 2 : 1;
        }
        return 0;
    }
}
