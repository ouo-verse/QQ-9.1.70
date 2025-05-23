package com.tencent.karaoke.decodesdk;

import sz0.a;

/* compiled from: P */
/* loaded from: classes7.dex */
public class M4aDecoder extends a {
    private static boolean IS_LOAD = false;
    private static final String TAG = "M4aDecoder";
    private int fileNum;
    private int mFrameSize = -1;
    private M4AInformation mInformation;
    private long nativeHandle;
    private long nativeHandle2;

    static {
        try {
            System.loadLibrary("m4adec");
            IS_LOAD = true;
        } catch (Exception | UnsatisfiedLinkError unused) {
        }
    }

    private native int native_decode(int i3, byte[] bArr);

    private native int native_decode(int i3, byte[] bArr, int i16, byte[] bArr2);

    private native int native_decodeSnapShot(int i3, byte[] bArr, int i16);

    private native M4AInformation native_getAudioInformation();

    private native int native_getCurrentTime();

    private native int native_getDecodePosition();

    private native int native_getDuration();

    private native int native_init(String str, String str2, boolean z16);

    private native int native_init(String str, boolean z16);

    private native int native_release();

    private native int native_seekTo(int i3);

    @Override // sz0.a
    public int decode(int i3, byte[] bArr) {
        if (IS_LOAD) {
            return native_decode(i3, bArr);
        }
        return -1001;
    }

    @Override // sz0.a
    public int decodeSnapShot(int i3, byte[] bArr, int i16) {
        if (!IS_LOAD) {
            return -1001;
        }
        return native_decodeSnapShot(i3, bArr, i16);
    }

    @Override // sz0.a
    public M4AInformation getAudioInformation() {
        if (!IS_LOAD) {
            return null;
        }
        M4AInformation native_getAudioInformation = native_getAudioInformation();
        this.mInformation = native_getAudioInformation;
        if (native_getAudioInformation != null && native_getAudioInformation.getFrameSize() != 0) {
            this.mFrameSize = this.mInformation.getFrameSize();
        }
        return this.mInformation;
    }

    @Override // sz0.a
    public int getCurrentTime() {
        if (!IS_LOAD) {
            return -1001;
        }
        return native_getCurrentTime();
    }

    @Override // sz0.a
    public int getDecodePosition() {
        if (!IS_LOAD) {
            return -1001;
        }
        return native_getDecodePosition();
    }

    @Override // sz0.a
    public int getDuration() {
        if (!IS_LOAD) {
            return -1001;
        }
        return native_getDuration();
    }

    @Override // sz0.a
    public int getFrameSize() {
        return this.mFrameSize;
    }

    @Override // sz0.a
    public int init(String str) {
        return init(str, false);
    }

    @Override // sz0.a
    public int release() {
        if (!IS_LOAD) {
            return -1001;
        }
        return native_release();
    }

    @Override // sz0.a
    public int seekTo(int i3) {
        if (!IS_LOAD) {
            return -1001;
        }
        return native_seekTo(i3);
    }

    @Override // sz0.a
    public int init(String str, String str2) {
        return init(str, str2, false);
    }

    @Override // sz0.a
    public int decode(int i3, byte[] bArr, int i16, byte[] bArr2) {
        if (IS_LOAD) {
            return native_decode(i3, bArr, i16, bArr2);
        }
        return -1001;
    }

    @Override // sz0.a
    public int init(String str, boolean z16) {
        if (!IS_LOAD) {
            return -1001;
        }
        this.fileNum = 1;
        return native_init(str, z16);
    }

    @Override // sz0.a
    public int init(String str, String str2, boolean z16) {
        if (!IS_LOAD) {
            return -1001;
        }
        this.fileNum = 2;
        return native_init(str, str2, z16);
    }
}
