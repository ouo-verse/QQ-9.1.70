package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes7.dex */
public class KaraMediaCrypto {
    private static final String TAG = "KaraMediaCrypto";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private ByteBuffer mDecryptBuffer;
    private ByteBuffer mEncryptBuffer;
    public boolean mIsValid = false;
    private long nativeHandle;

    private native int decrypt(int i3, ByteBuffer byteBuffer, int i16);

    private native int encrypt(int i3, ByteBuffer byteBuffer, int i16);

    private native int init();

    public static boolean isValid() {
        return mIsLoaded;
    }

    private native void release();

    public synchronized int decrypt(int i3, byte[] bArr, int i16) {
        if (!this.mIsValid) {
            LogUtil.w(TAG, "mIsValid == false");
            return -1;
        }
        if (this.mDecryptBuffer == null) {
            this.mDecryptBuffer = ByteBuffer.allocateDirect(i16);
        }
        int i17 = i16;
        while (i17 > 0) {
            this.mDecryptBuffer.clear();
            int min = Math.min(Math.min(i16, this.mDecryptBuffer.limit()), i17);
            int i18 = i16 - i17;
            this.mDecryptBuffer.put(bArr, i18, min);
            int decrypt = decrypt((i3 + i16) - i17, this.mDecryptBuffer, min);
            if (decrypt < 0) {
                return decrypt;
            }
            this.mDecryptBuffer.flip();
            this.mDecryptBuffer.get(bArr, i18, min);
            i17 -= min;
        }
        return i16;
    }

    public synchronized int encrypt(int i3, byte[] bArr, int i16) {
        if (!this.mIsValid) {
            LogUtil.w(TAG, "mIsValid == false");
            return -1;
        }
        if (this.mEncryptBuffer == null) {
            this.mEncryptBuffer = ByteBuffer.allocateDirect(i16);
        }
        int i17 = i16;
        while (i17 > 0) {
            this.mEncryptBuffer.clear();
            int min = Math.min(Math.min(i16, this.mEncryptBuffer.limit()), i17);
            int i18 = i16 - i17;
            this.mEncryptBuffer.put(bArr, i18, min);
            int encrypt = encrypt((i3 + i16) - i17, this.mEncryptBuffer, min);
            if (encrypt < 0) {
                return encrypt;
            }
            this.mEncryptBuffer.flip();
            this.mEncryptBuffer.get(bArr, i18, min);
            i17 -= min;
        }
        return i16;
    }

    public synchronized int encryptByteBuffer(int i3, ByteBuffer byteBuffer, int i16) {
        if (!this.mIsValid) {
            LogUtil.w(TAG, "mIsValid == false");
            return -1;
        }
        return encrypt(i3, byteBuffer, i16);
    }

    public int java_init() {
        boolean z16;
        if (!mIsLoaded) {
            return -1;
        }
        int init = init();
        if (init == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsValid = z16;
        return init;
    }

    public void java_release() {
        if (!this.mIsValid) {
            return;
        }
        release();
        this.mIsValid = false;
    }

    public synchronized int decrypt(int i3, byte[] bArr, int i16, int i17) {
        if (!this.mIsValid) {
            LogUtil.w(TAG, "mIsValid == false");
            return -1;
        }
        if (this.mDecryptBuffer == null) {
            this.mDecryptBuffer = ByteBuffer.allocateDirect(i17);
        }
        int i18 = i17;
        while (i18 > 0) {
            this.mDecryptBuffer.clear();
            int min = Math.min(Math.min(i17, this.mDecryptBuffer.limit()), i18);
            int i19 = (i17 + i16) - i18;
            this.mDecryptBuffer.put(bArr, i19, min);
            int decrypt = decrypt((i3 + i17) - i18, this.mDecryptBuffer, min);
            if (decrypt < 0) {
                return decrypt;
            }
            this.mDecryptBuffer.flip();
            this.mDecryptBuffer.get(bArr, i19, min);
            i18 -= min;
        }
        return i17;
    }
}
