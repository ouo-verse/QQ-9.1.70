package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class y extends i {
    public y(u uVar) {
        this.f422895a = uVar;
    }

    public byte[] a(long j3, byte[] bArr, byte[] bArr2, byte[] bArr3, long j16) {
        if (bArr2 == null || bArr2.length == 0) {
            byte[] encrypt = cryptor.encrypt(bArr, 0, bArr.length, "x'Z8mSi,V(Wu~.v:".getBytes());
            byte[] bArr4 = new byte[encrypt.length + 10];
            util.int32_to_buf(bArr4, 0, (int) j3);
            util.int32_to_buf(bArr4, 4, (int) j16);
            util.int16_to_buf(bArr4, 8, 0);
            System.arraycopy(encrypt, 0, bArr4, 10, encrypt.length);
            return bArr4;
        }
        byte[] encrypt2 = cryptor.encrypt(bArr, 0, bArr.length, bArr3);
        byte[] bArr5 = new byte[bArr2.length + 10 + encrypt2.length];
        util.int32_to_buf(bArr5, 0, (int) j3);
        util.int32_to_buf(bArr5, 4, (int) j16);
        util.int16_to_buf(bArr5, 8, bArr2.length);
        System.arraycopy(bArr2, 0, bArr5, 10, bArr2.length);
        System.arraycopy(encrypt2, 0, bArr5, bArr2.length + 10, encrypt2.length);
        return bArr5;
    }

    public byte[] a(byte[] bArr, long j3, long j16, long j17, int i3) {
        int length = bArr.length + 33;
        byte[] bArr2 = new byte[length];
        util.int32_to_buf(bArr2, 0, 1737040709);
        util.int32_to_buf(bArr2, 4, 0);
        util.int32_to_buf(bArr2, 8, length);
        util.int64_to_buf32(bArr2, 12, j3);
        util.int64_to_buf32(bArr2, 16, j16);
        util.int64_to_buf32(bArr2, 20, j17 / 1000);
        util.int8_to_buf(bArr2, 24, i3);
        System.arraycopy(bArr, 0, bArr2, 33, bArr.length);
        return bArr2;
    }
}
