package com.tencent.ttpic.voicechanger.common.audio;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.qq.wx.voice.recognizer.VoiceRecognizerListener;
import com.qq.wx.voice.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.recognizer.VoiceRecordState;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.baseutils.log.LogUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VoiceTextRecognizer {
    private static final int STATE_CREATED = 0;
    private static final int STATE_DESTROYED = 3;
    private static final int STATE_ERROR = 4;
    private static final int STATE_INITED = 1;
    private static final int STATE_STARTED = 2;
    private static final String TAG = "VoiceTextRecognizer";
    private static String WX_VOICE_RECOGNIZER_APPID = "WXARS1340SNG1518003481_56355";
    private static final VoiceTextRecognizer sInstance = new VoiceTextRecognizer();
    protected HandlerThread handlerThread;
    private Handler mHandler;
    private VRListener mListener = new VRListener();
    private int mState = 0;
    private VRErrorListener mVRErrorListener;
    private VTChangeListener mVTListener;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    enum ErrorCode {
        SO_NOT_LOAD(-1000);

        public final int value;

        ErrorCode(int i3) {
            this.value = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface VRErrorListener {
        void onError(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface VTChangeListener {
        void onError(int i3);

        void onVTChanged(String str);
    }

    public static synchronized VoiceTextRecognizer getInstance() {
        VoiceTextRecognizer voiceTextRecognizer;
        synchronized (VoiceTextRecognizer.class) {
            voiceTextRecognizer = sInstance;
        }
        return voiceTextRecognizer;
    }

    public static void setWxVoiceRecognizerAppid(String str) {
        WX_VOICE_RECOGNIZER_APPID = str;
    }

    public void destroy() {
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer.3
            @Override // java.lang.Runnable
            public void run() {
                VoiceRecognizer.shareInstance().destroy();
                VoiceTextRecognizer.this.mState = 3;
            }
        });
    }

    public void init(final Context context, final boolean z16) {
        int i3 = this.mState;
        if (i3 != 1 && i3 != 2) {
            if (this.mHandler == null) {
                if (this.handlerThread == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("VIDEO_TEXT_RECOGNIZER_" + System.currentTimeMillis());
                    this.handlerThread = baseHandlerThread;
                    baseHandlerThread.start();
                }
                if (this.handlerThread.getLooper() != null) {
                    this.mHandler = new Handler(this.handlerThread.getLooper());
                }
            }
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i16;
                        VoiceRecognizer.shareInstance().setListener(VoiceTextRecognizer.this.mListener);
                        VoiceRecognizer.shareInstance().setSilentTime(500);
                        VoiceRecognizer.shareInstance().setContRes(true);
                        VoiceRecognizer.shareInstance().setContReco(true);
                        VoiceRecognizer.shareInstance().setResultType(1);
                        if (z16) {
                            i16 = VoiceRecognizer.shareInstance().init(context, VoiceTextRecognizer.WX_VOICE_RECOGNIZER_APPID);
                        } else {
                            try {
                                i16 = VoiceRecognizer.shareInstance().initNoLoadSo(context, VoiceTextRecognizer.WX_VOICE_RECOGNIZER_APPID);
                            } catch (UnsatisfiedLinkError unused) {
                                i16 = ErrorCode.SO_NOT_LOAD.value;
                            }
                        }
                        if (i16 >= 0) {
                            VoiceTextRecognizer.this.mState = 1;
                            return;
                        }
                        LogUtils.e(VoiceTextRecognizer.TAG, "\u521d\u59cb\u5316\u8bed\u97f3\u8bc6\u522b\u5931\u8d25");
                        if (VoiceTextRecognizer.this.mVRErrorListener != null) {
                            VoiceTextRecognizer.this.mVRErrorListener.onError(i16);
                        }
                    }
                });
                return;
            }
            return;
        }
        LogUtils.e(TAG, "mState == STATE_INITED || mState == STATE_STARTED");
    }

    public void recognizeFromPCMBuffer(byte[] bArr, int i3) {
        if (this.mState != 2) {
            return;
        }
        VoiceRecognizer.shareInstance().appendData(bArr, 0, i3, false);
    }

    public void setVRErrorListener(VRErrorListener vRErrorListener) {
        this.mVRErrorListener = vRErrorListener;
    }

    public void setVoiceTextListener(VTChangeListener vTChangeListener) {
        this.mVTListener = vTChangeListener;
    }

    public void start() {
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VoiceTextRecognizer.this.mState != 1) {
                    return;
                }
                if (VoiceRecognizer.shareInstance().startReceiving() >= 0) {
                    VoiceTextRecognizer.this.mState = 2;
                } else {
                    LogUtils.e(VoiceTextRecognizer.TAG, "\u542f\u52a8\u8bed\u97f3\u8bc6\u522b\u5931\u8d25");
                }
            }
        });
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class VRListener implements VoiceRecognizerListener {
        public VRListener() {
        }

        @Override // com.qq.wx.voice.recognizer.VoiceRecognizerListener
        public void onGetError(int i3) {
            LogUtils.e(VoiceTextRecognizer.TAG, "onGetError, errorCode = " + i3);
            if (VoiceTextRecognizer.this.mVTListener != null) {
                VoiceTextRecognizer.this.mVTListener.onError(i3);
            }
            if (VoiceTextRecognizer.this.mVRErrorListener != null) {
                VoiceTextRecognizer.this.mVRErrorListener.onError(i3);
            }
            VoiceTextRecognizer.this.mState = 4;
        }

        @Override // com.qq.wx.voice.recognizer.VoiceRecognizerListener
        public void onGetResult(VoiceRecognizerResult voiceRecognizerResult) {
            LogUtils.e(VoiceTextRecognizer.TAG, "onGetResult, text = " + voiceRecognizerResult.text);
            if (VoiceTextRecognizer.this.mVTListener != null) {
                VoiceTextRecognizer.this.mVTListener.onVTChanged(voiceRecognizerResult.text);
                if (voiceRecognizerResult.isEnd) {
                    VoiceTextRecognizer.this.mVTListener.onVTChanged("");
                }
            }
        }

        @Override // com.qq.wx.voice.recognizer.VoiceRecognizerListener
        public void onGetVoiceRecordState(VoiceRecordState voiceRecordState) {
        }

        @Override // com.qq.wx.voice.recognizer.VoiceRecognizerListener
        public void onVolumeChanged(int i3) {
        }

        @Override // com.qq.wx.voice.recognizer.VoiceRecognizerListener
        public void onGetVoicePackage(byte[] bArr, String str) {
        }
    }
}
