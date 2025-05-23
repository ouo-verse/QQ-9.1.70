package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;

/* loaded from: classes7.dex */
public class KaraPracticeEvaluator {
    public static final int PRACTICE_EVALUATE_ALL_DATA_GOT = 2;
    public static final int PRACTICE_EVALUATE_BUFFER_DATA_ENOUGH = 1;
    public static final int PRACTICE_EVALUATE_LAST_RESULT_VALID = 2;
    public static final int PRACTICE_EVLAUATE_LYRIC_ERROR = -29988;
    public static final int PRACTICE_EVLAUATE_LYRIC_NOTE_MATCH_ERROR = -29986;
    public static final int PRACTICE_EVLAUATE_NOTE_ERROR = -29987;
    private static final String TAG = "KaraPracticeEvaluator";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private long nativeHandle;
    private boolean mIsValid = false;
    private boolean mIsSessionCreated = false;
    private boolean mIsSessionStarted = false;

    private native int native_createSession(byte[] bArr, byte[] bArr2);

    private native int native_destorySession();

    private native int native_getLastResult();

    private native int native_getResult(KaraPracticeResult karaPracticeResult);

    private native int native_init(String str, int i3);

    private native int native_putBuffer(byte[] bArr, int i3);

    private native int native_release();

    private native int native_setChannels(int i3);

    private native int native_startSession(int i3, int i16);

    private native int native_stopSession();

    public synchronized int createSession(byte[] bArr, byte[] bArr2) {
        boolean z16;
        if (this.mIsValid) {
            destorySession();
            if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
                int native_createSession = native_createSession(bArr, bArr2);
                if (native_createSession == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.mIsSessionCreated = z16;
                LogUtil.d(TAG, "createSession -> mIsSessionCreated" + this.mIsSessionCreated + ", ret:" + native_createSession);
                return native_createSession;
            }
            LogUtil.d(TAG, "createSession -> note or qrc is null");
            return -1;
        }
        LogUtil.w(TAG, "KaraPracticeEvaluator invalid");
        return -2;
    }

    public synchronized int destorySession() {
        boolean z16;
        if (this.mIsSessionCreated) {
            int native_destorySession = native_destorySession();
            if (native_destorySession != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsSessionCreated = z16;
            return native_destorySession;
        }
        LogUtil.w(TAG, "KaraPracticeEvaluator session not created");
        return -1;
    }

    public synchronized int getLastResult() {
        LogUtil.d(TAG, "getLastResult");
        if (this.mIsSessionStarted) {
            return native_getLastResult();
        }
        LogUtil.w(TAG, "KaraPracticeEvaluator session not started");
        return -1;
    }

    public synchronized int getResult(KaraPracticeResult karaPracticeResult) {
        if (this.mIsSessionStarted) {
            return native_getResult(karaPracticeResult);
        }
        LogUtil.w(TAG, "KaraPracticeEvaluator session not started");
        return -1;
    }

    public synchronized int init(String str, int i3) {
        boolean z16;
        if (mIsLoaded) {
            int native_init = native_init(str, i3);
            if (native_init == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsValid = z16;
            LogUtil.d(TAG, "init -> mIsValid:" + this.mIsValid);
            return native_init;
        }
        LogUtil.w(TAG, "KaraPracticeEvaluator invalid");
        return -1;
    }

    public synchronized boolean isInited() {
        return this.mIsValid;
    }

    public synchronized int putVoiceBuffer(byte[] bArr, int i3) {
        if (this.mIsSessionStarted) {
            return native_putBuffer(bArr, i3);
        }
        return -1;
    }

    public synchronized int release() {
        LogUtil.d(TAG, "release");
        if (this.mIsValid) {
            this.mIsValid = false;
            return native_release();
        }
        LogUtil.w(TAG, "KaraPracticeEvaluator invalid");
        return -1;
    }

    public synchronized int setChannels(int i3) {
        if (this.mIsSessionCreated) {
            return native_setChannels(i3);
        }
        LogUtil.w(TAG, "KaraPracticeEvaluator session not created");
        return -1;
    }

    public synchronized int startSession(int i3, int i16) {
        boolean z16 = false;
        if (this.mIsSessionCreated) {
            LogUtil.d(TAG, "startSession -> beginTime:" + i3 + ", endTime:" + i16);
            int native_startSession = native_startSession(i3, i16);
            if (native_startSession == 0) {
                z16 = true;
            }
            this.mIsSessionStarted = z16;
            LogUtil.w(TAG, "startSession -> mIsSessionStarted:" + this.mIsSessionStarted + ", ret:" + native_startSession);
            return native_startSession;
        }
        this.mIsSessionStarted = false;
        LogUtil.w(TAG, "KaraPracticeEvaluator session not created");
        return -1;
    }

    public synchronized int stopSession() {
        LogUtil.d(TAG, "stopSession");
        boolean z16 = false;
        if (this.mIsSessionStarted) {
            int native_stopSession = native_stopSession();
            if (native_stopSession != 0) {
                z16 = true;
            }
            this.mIsSessionStarted = z16;
            return native_stopSession;
        }
        this.mIsSessionStarted = false;
        LogUtil.w(TAG, "KaraPracticeEvaluator session not started");
        return -1;
    }
}
