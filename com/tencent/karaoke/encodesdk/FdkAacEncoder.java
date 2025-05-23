package com.tencent.karaoke.encodesdk;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FdkAacEncoder extends a {
    private static boolean IS_LOAD = false;
    private static final String TAG = "FdkAacEncoder";
    private long nativeHandle;

    static {
        try {
            System.loadLibrary("aacEnc");
            IS_LOAD = true;
        } catch (Exception e16) {
            Log.d(TAG, e16.getMessage());
        } catch (UnsatisfiedLinkError e17) {
            Log.d(TAG, e17.getMessage());
        }
    }

    private native int native_aacEncode(byte[] bArr, int i3);

    private native int native_init(int i3, int i16, int i17, int i18, int i19, int i26);

    private native int native_release();

    private int onAacDataRecv(byte[] bArr, int i3) {
        return -1;
    }

    @Override // com.tencent.karaoke.encodesdk.a
    public int aacEncode(byte[] bArr, int i3) {
        if (IS_LOAD) {
            return native_aacEncode(bArr, i3);
        }
        return -1001;
    }

    @Override // com.tencent.karaoke.encodesdk.a
    public int init(int i3, int i16, int i17, int i18, int i19, int i26) {
        if (IS_LOAD) {
            return native_init(i3, i16, i17, i18, i19, i26);
        }
        return -1001;
    }

    @Override // com.tencent.karaoke.encodesdk.a
    public int release() {
        if (IS_LOAD) {
            return native_release();
        }
        return -1001;
    }

    @Override // com.tencent.karaoke.encodesdk.a
    public int init(int i3, int i16, int i17, int i18, int i19) {
        if (IS_LOAD) {
            return native_init(i3, i16, i17, i18, i19, 0);
        }
        return -1001;
    }
}
