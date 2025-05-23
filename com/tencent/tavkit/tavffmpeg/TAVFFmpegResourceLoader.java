package com.tencent.tavkit.tavffmpeg;

import com.tencent.tav.ResourceLoadUtil;
import com.tencent.tav.decoder.logger.Logger;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVFFmpegResourceLoader {
    private static final String TAG = "ResourceLoadUtils";
    private static boolean soLoaded = false;

    public static boolean isSoLoaded() {
        return soLoaded;
    }

    public static void loadLibrary(String str) {
        if (!soLoaded) {
            try {
                soLoaded = true;
                System.load(str);
                return;
            } catch (Throwable th5) {
                Logger.e(TAG, "loadLibrary: ", th5);
                soLoaded = false;
                return;
            }
        }
        Logger.e(TAG, "loadLibrary: mSoLoaded = true");
    }

    public static boolean loadSo() {
        boolean loadLibrary = ResourceLoadUtil.loadLibrary("tavffmpeg");
        soLoaded = loadLibrary;
        return loadLibrary;
    }
}
