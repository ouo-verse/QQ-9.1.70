package com.tencent.mm.libwxaudio;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class WxAudioNative {
    public static int INIT_ERROR = -1002;
    public static int NEW_WXAUDIO_ERROR = -1000;
    public static int REPEAT_WXAUDIO_ERROR = -1001;
    public static String TAG = "MicroMsg.WebAudio.WxAudioNative";
    private boolean initCallBackFlag = false;
    volatile long mNativeInst;

    /* compiled from: P */
    @Keep
    /* loaded from: classes9.dex */
    public interface NativeAudioPcmCallback {
        @Keep
        void onPcmCallback(String str, byte[] bArr, int i3, int i16, int i17, int i18);
    }

    /* compiled from: P */
    @Keep
    /* loaded from: classes9.dex */
    public interface NativeCallBackInterface {
        public static final String KEY_GET_FILE_PATH_CACHE_DIR = "CACHE_DIR";

        @Keep
        String getFilePath(String str);

        @Keep
        void onCallBack(long j3, String str);
    }

    @Keep
    public WxAudioNative(long j3, long j16, long j17) {
        this.mNativeInst = 0L;
        Log.i(TAG, "WxAudioNative isolate_ptr:" + j3 + ",context_ptr:" + j16 + ",uvloop_ptr:" + j17);
        this.mNativeInst = initBindingWxAudio(j3, j16, j17);
    }

    private native void destroyBindingWxAudio(long j3);

    public static native void forcePauseAllPlayer(long j3, boolean z16);

    public static native void forceResumeAllPlayer(long j3, boolean z16);

    public static native void initAndroidAssetMgr(AssetManager assetManager);

    private native long initBindingWxAudio(long j3, long j16, long j17);

    private native int initCallBack(long j3, NativeCallBackInterface nativeCallBackInterface);

    public static native void registerAudioPcmCallback(long j3, NativeAudioPcmCallback nativeAudioPcmCallback);

    private native void setJsAsyncCall(long j3, long j16);

    public static native void setMute(long j3, boolean z16);

    private native void testBindingWxAudio(long j3);

    public static native void unregisterAudioPcmCallback(long j3);

    private native void updateNativeInterface(long j3, long j16);

    @Keep
    public int InitCallBack(final NativeCallBackInterface nativeCallBackInterface) {
        if (this.mNativeInst == -1) {
            return NEW_WXAUDIO_ERROR;
        }
        if (!this.initCallBackFlag) {
            int initCallBack = initCallBack(this.mNativeInst, new NativeCallBackInterface() { // from class: com.tencent.mm.libwxaudio.WxAudioNative.1
                @Override // com.tencent.mm.libwxaudio.WxAudioNative.NativeCallBackInterface
                public String getFilePath(String str) {
                    return nativeCallBackInterface.getFilePath(str);
                }

                @Override // com.tencent.mm.libwxaudio.WxAudioNative.NativeCallBackInterface
                @Keep
                public void onCallBack(long j3, String str) {
                    nativeCallBackInterface.onCallBack(j3, str);
                }
            });
            if (initCallBack == 0) {
                this.initCallBackFlag = true;
                return initCallBack;
            }
            return INIT_ERROR;
        }
        return REPEAT_WXAUDIO_ERROR;
    }

    @Keep
    public void destroyWebAudioContext() {
        if (this.mNativeInst != -1 && this.initCallBackFlag) {
            this.initCallBackFlag = false;
            destroyBindingWxAudio(this.mNativeInst);
            this.mNativeInst = -1L;
        }
    }

    @Keep
    public void forcePauseAllPlayer(boolean z16) {
        if (this.mNativeInst == -1) {
            Log.i(TAG, "forcePauseAllPlayer, mNativeInst is invalid");
        } else {
            forcePauseAllPlayer(this.mNativeInst, z16);
        }
    }

    @Keep
    public void forceResumeAllPlayer(boolean z16) {
        if (this.mNativeInst == -1) {
            Log.i(TAG, "forceResumeAllPlayer, mNativeInst is invalid");
        } else {
            forceResumeAllPlayer(this.mNativeInst, z16);
        }
    }

    @Keep
    public void registerAudioPcmCallback(NativeAudioPcmCallback nativeAudioPcmCallback) {
        if (this.mNativeInst == -1) {
            Log.i(TAG, "registerAudioPcmCallback, mNativeInst is invali");
        } else {
            registerAudioPcmCallback(this.mNativeInst, nativeAudioPcmCallback);
        }
    }

    @Keep
    public int setJsAsyncCall(long j3) {
        if (this.mNativeInst == -1) {
            return NEW_WXAUDIO_ERROR;
        }
        setJsAsyncCall(this.mNativeInst, j3);
        return 0;
    }

    @Keep
    public void setMute(boolean z16) {
        if (this.mNativeInst == -1) {
            Log.i(TAG, "setMute, mNativeInst is invalid, mute: " + z16);
            return;
        }
        setMute(this.mNativeInst, z16);
    }

    public void testBind() {
        if (this.mNativeInst == -1) {
            return;
        }
        testBindingWxAudio(this.mNativeInst);
    }

    @Keep
    public void unregisterAudioPcmCallback() {
        if (this.mNativeInst == -1) {
            Log.i(TAG, "unregisterAudioPcmCallback, mNativeInst is invali");
        } else {
            unregisterAudioPcmCallback(this.mNativeInst);
        }
    }

    @Keep
    public void update(long j3) {
        if (this.mNativeInst == -1) {
            return;
        }
        updateNativeInterface(this.mNativeInst, j3);
    }

    @Keep
    public void forcePauseAllPlayer() {
        forcePauseAllPlayer(true);
    }
}
