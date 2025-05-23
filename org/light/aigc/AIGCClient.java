package org.light.aigc;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import org.light.aigc.bean.AIGCContentOutput;
import org.light.aigc.bean.AIGCRequest;
import org.light.aigc.bean.ErrorCode;
import org.light.aigc.config.AIGCConfig;
import org.light.aigc.config.EnvConfig;
import org.light.aigc.net.IGenerateCallback;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AIGCClient {
    private static final String TAG = "AIGCClient";
    private String sdkVersion;
    private long nativeContext = 0;
    private AIGCConfig aigcConfig = null;
    private EnvConfig envConfig = null;
    private Handler handler = new Handler(Looper.getMainLooper());

    static {
        try {
            nativeInit();
        } catch (Error e16) {
            LightLogUtil.e(TAG, e16.toString());
        }
    }

    private boolean isRequestValid(AIGCRequest aIGCRequest) {
        if (aIGCRequest != null && aIGCRequest.bussId != null) {
            return true;
        }
        return false;
    }

    public static AIGCClient make(AIGCConfig aIGCConfig, EnvConfig envConfig) {
        if (TextUtils.isEmpty(aIGCConfig.appID) || TextUtils.isEmpty(aIGCConfig.appEntry) || envConfig == null) {
            return null;
        }
        AIGCClient makeClient = makeClient(aIGCConfig, envConfig);
        makeClient.aigcConfig = aIGCConfig;
        makeClient.envConfig = envConfig;
        LightLogUtil.e(TAG, String.format("AIGCClient:%x init success", Integer.valueOf(System.identityHashCode(makeClient))));
        return makeClient;
    }

    private static native AIGCClient makeClient(AIGCConfig aIGCConfig, EnvConfig envConfig);

    private native void nativeFinalize();

    private native void nativeGenerateContent(AIGCRequest aIGCRequest, IGenerateCallback iGenerateCallback);

    private static native void nativeInit();

    private native void nativeRelease();

    private static native String nativeVersion();

    private static String version() {
        try {
            return nativeVersion();
        } catch (UnsatisfiedLinkError e16) {
            LightLogUtil.e(TAG, "nativeVersion exception:\n" + e16);
            return "";
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.nativeContext != 0) {
            nativeFinalize();
        }
    }

    public void generateAIGCContent(AIGCRequest aIGCRequest, final IGenerateCallback iGenerateCallback) {
        if (!isRequestValid(aIGCRequest)) {
            if (iGenerateCallback != null) {
                iGenerateCallback.onError(ErrorCode.ERROR_BAD_REQUEST, "bad request");
            }
            LightLogUtil.e(TAG, "generateAIGCContent Request InValid");
            return;
        }
        nativeGenerateContent(aIGCRequest, new IGenerateCallback() { // from class: org.light.aigc.AIGCClient.1
            @Override // org.light.aigc.net.IGenerateCallback
            public void onError(final long j3, final String str) {
                AIGCClient.this.handler.post(new Runnable() { // from class: org.light.aigc.AIGCClient.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        iGenerateCallback.onError(j3, str);
                    }
                });
            }

            @Override // org.light.aigc.net.IGenerateCallback
            public void onSuccess(final AIGCContentOutput aIGCContentOutput) {
                AIGCClient.this.handler.post(new Runnable() { // from class: org.light.aigc.AIGCClient.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        iGenerateCallback.onSuccess(aIGCContentOutput);
                    }
                });
            }
        });
    }

    public String getVersion() {
        if (this.sdkVersion == null) {
            this.sdkVersion = version();
        }
        return this.sdkVersion;
    }

    public final void release() {
        nativeRelease();
    }
}
