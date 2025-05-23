package org.light.aigc.net;

import org.light.aigc.bean.AIGCContentOutput;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DefaultOutputCallback implements IGenerateCallback {
    private static final String TAG = "DefaultOutputCallback";
    private long nativeContext = 0;

    static {
        try {
            nativeInit();
        } catch (Error e16) {
            LightLogUtil.e(TAG, e16.toString());
        }
    }

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeOnError(long j3, String str);

    private native void nativeOnSuccess(AIGCContentOutput aIGCContentOutput);

    private native void nativeRelease();

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.nativeContext != 0) {
            nativeFinalize();
        }
    }

    @Override // org.light.aigc.net.IGenerateCallback
    public void onError(long j3, String str) {
        nativeOnError(j3, str);
    }

    @Override // org.light.aigc.net.IGenerateCallback
    public void onSuccess(AIGCContentOutput aIGCContentOutput) {
        nativeOnSuccess(aIGCContentOutput);
    }

    public final void release() {
        nativeRelease();
    }
}
