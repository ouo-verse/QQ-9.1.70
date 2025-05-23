package com.tencent.karaoke.audiobasesdk.LyricScor;

import android.text.TextUtils;
import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;

/* compiled from: P */
/* loaded from: classes7.dex */
public class KaraAudioLyricScore {
    private static final String TAG = "KaraAudioLyricScore";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    private native int native_calculate(String str, String str2);

    private native int native_init(String str);

    private native void native_uninit();

    public synchronized int calculate(String str, String str2) {
        if (this.mIsValid) {
            try {
                String str3 = new String(str.getBytes("utf-8"));
                String str4 = new String(str2.getBytes("utf-8"));
                if (TextUtils.isEmpty(str)) {
                    return -12;
                }
                if (TextUtils.isEmpty(str2)) {
                    return -13;
                }
                return native_calculate(str3, str4);
            } catch (Exception e16) {
                LogUtil.e(TAG, "params data error: ", e16);
                return -11;
            }
        }
        LogUtil.i(TAG, "calculate: isValid is false");
        return -1;
    }

    public synchronized int init(String str) {
        boolean z16;
        if (!mIsLoaded) {
            return -1;
        }
        LogUtil.i(TAG, "init: ");
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int native_init = native_init(str);
        if (native_init == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsValid = z16;
        if (!z16) {
            LogUtil.w(TAG, "KaraAudioLyricScore init failed: " + native_init);
        }
        return native_init;
    }

    public synchronized void release() {
        if (this.mIsValid) {
            native_uninit();
            this.mIsValid = false;
        }
    }
}
