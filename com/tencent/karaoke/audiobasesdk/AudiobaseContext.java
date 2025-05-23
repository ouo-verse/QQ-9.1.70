package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AudiobaseContext {
    private static final String TAG = "AudiobaseContext";
    private static volatile boolean mHuaWeiIsLoaded = false;
    private static volatile boolean mIsLoaded = false;

    static {
        loadLibrary();
    }

    public static boolean loadHuaweiLib() {
        if (!mHuaWeiIsLoaded) {
            try {
                System.loadLibrary("huawei_jni");
                mHuaWeiIsLoaded = true;
            } catch (Exception e16) {
                LogUtil.e(TAG, "System.loadLibrary failed", e16);
            } catch (UnsatisfiedLinkError e17) {
                LogUtil.e(TAG, "System.loadLibrary failed", e17);
            }
        }
        return mHuaWeiIsLoaded;
    }

    public static boolean loadLibrary() {
        if (!mIsLoaded) {
            try {
                System.loadLibrary("audiobase");
                mIsLoaded = true;
            } catch (Exception e16) {
                LogUtil.e(TAG, "System.loadLibrary failed", e16);
            } catch (UnsatisfiedLinkError e17) {
                LogUtil.e(TAG, "System.loadLibrary failed", e17);
            }
        }
        return mIsLoaded;
    }
}
