package com.tencent.gamematrix;

import org.tencchromium.base.annotations.CalledByNative;
import org.tencchromium.base.annotations.NativeClassQualifiedName;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CgQuicClient {
    private static Object lock = new Object();
    private static boolean mIsLoadLibrary;
    private Callback mCallback;
    private long mCgQuicAdapter;
    private int mType;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static abstract class Callback {
        public abstract void onClose(int i3, String str) throws Exception;

        public abstract void onConnect(String str) throws Exception;

        public abstract void onData(int i3, int i16, byte[] bArr) throws Exception;
    }

    public CgQuicClient(Callback callback, int i3) {
        this.mCallback = callback;
        this.mType = i3;
    }

    public static boolean initialize(boolean z16) {
        synchronized (lock) {
            if (mIsLoadLibrary) {
                return true;
            }
            if (!z16) {
                try {
                    System.loadLibrary("rawquic_jni");
                } catch (UnsatisfiedLinkError unused) {
                    mIsLoadLibrary = false;
                    return false;
                }
            }
            mIsLoadLibrary = true;
            return true;
        }
    }

    @NativeClassQualifiedName("CgQuicAdapter")
    private native void nativeClose(long j3);

    @NativeClassQualifiedName("CgQuicAdapter")
    private native void nativeConnect(long j3, String str, int i3);

    private native long nativeCreateCgQuicAdapter(CgConfig cgConfig);

    @NativeClassQualifiedName("CgQuicAdapter")
    private native boolean nativeInitLogger(long j3, int i3, String str);

    @NativeClassQualifiedName("CgQuicAdapter")
    private native void nativeMigrate(long j3, String str);

    @NativeClassQualifiedName("CgQuicAdapter")
    private native boolean nativeSend(long j3, byte[] bArr, int i3);

    @NativeClassQualifiedName("CgQuicAdapter")
    private native boolean nativeSendArray(long j3, byte[] bArr, int i3, int i16);

    @CalledByNative
    private void onClose(int i3, String str) {
        try {
            this.mCallback.onClose(i3, str);
        } catch (Exception unused) {
        }
    }

    @CalledByNative
    private void onConnect(String str) {
        try {
            this.mCallback.onConnect(str);
        } catch (Exception unused) {
        }
    }

    @CalledByNative
    private void onData(int i3, int i16, byte[] bArr) {
        try {
            this.mCallback.onData(i3, i16, bArr);
        } catch (Exception unused) {
        }
    }

    public void close() {
        nativeClose(this.mCgQuicAdapter);
        this.mCallback = null;
    }

    public void connect(String str, int i3) {
        nativeConnect(this.mCgQuicAdapter, str, i3);
    }

    public boolean getIsLoadLibrary() {
        boolean z16;
        synchronized (lock) {
            z16 = mIsLoadLibrary;
        }
        return z16;
    }

    public boolean initLogger(int i3, String str) {
        return nativeInitLogger(this.mCgQuicAdapter, i3, str);
    }

    public void migrate(String str) {
        nativeMigrate(this.mCgQuicAdapter, str);
    }

    public boolean send(byte[] bArr, int i3) {
        return nativeSend(this.mCgQuicAdapter, bArr, i3);
    }

    public boolean sendArray(byte[] bArr, int i3, int i16) {
        return nativeSendArray(this.mCgQuicAdapter, bArr, i3, i16);
    }

    public void initialize(CgConfig cgConfig) {
        if (initialize(false)) {
            try {
                this.mCgQuicAdapter = nativeCreateCgQuicAdapter(cgConfig);
            } catch (RuntimeException e16) {
                throw e16;
            }
        }
    }
}
