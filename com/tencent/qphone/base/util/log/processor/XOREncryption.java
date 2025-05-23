package com.tencent.qphone.base.util.log.processor;

import android.annotation.TargetApi;
import android.util.Log;
import com.tencent.qphone.base.util.log.encrypt.XorKey;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes22.dex */
public class XOREncryption implements IByteProcessor {
    private static final String TAG = "XOREncryption";
    public static final Charset charset;
    private static byte[] keyBytes;
    private static String xorKey;
    private final boolean enable;
    private int keyIndex = 0;

    static {
        Charset forName = Charset.forName("UTF-8");
        charset = forName;
        try {
            String genRandomKey = XorKey.genRandomKey();
            xorKey = genRandomKey;
            keyBytes = genRandomKey.getBytes(forName);
        } catch (Throwable th5) {
            Log.e(TAG, "init error. ", th5);
        }
    }

    public XOREncryption(boolean z16) {
        this.enable = z16;
    }

    public static String getXorKey() {
        return xorKey;
    }

    @Override // com.tencent.qphone.base.util.log.processor.IByteProcessor
    @TargetApi(19)
    public ProcessByteData handleData(ProcessByteData processByteData) {
        if (this.enable) {
            for (int i3 = processByteData.offset; i3 < processByteData.offset + processByteData.length; i3++) {
                int i16 = this.keyIndex;
                byte[] bArr = keyBytes;
                if (i16 == bArr.length) {
                    this.keyIndex = 0;
                }
                byte[] bArr2 = processByteData.bytes;
                byte b16 = bArr2[i3];
                int i17 = this.keyIndex;
                this.keyIndex = i17 + 1;
                bArr2[i3] = (byte) (bArr[i17] ^ b16);
            }
        }
        return processByteData;
    }

    @Override // com.tencent.qphone.base.util.log.processor.IByteProcessor
    public void reset() {
        this.keyIndex = 0;
    }

    @Override // com.tencent.qphone.base.util.log.processor.IByteProcessor
    public void close() {
    }
}
