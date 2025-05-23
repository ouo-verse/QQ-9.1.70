package oicq.wlogin_sdk.devicelock;

/* compiled from: P */
/* loaded from: classes28.dex */
public class f extends d {
    public f() {
        this._type = 2;
    }

    public byte[] a(long j3, long j16, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        if (bArr != null && bArr2 != null && bArr3 != null && bArr4 != null && bArr5 != null && bArr6 != null) {
            int length = bArr.length + 10 + 2 + bArr2.length + 2 + bArr3.length + 2 + bArr4.length + 2 + bArr5.length + 2 + bArr6.length;
            int i3 = this._head_len;
            fill_head();
            fill_body(new byte[length], length);
            put_block(bArr6, put_block(bArr5, put_block(bArr4, put_block(bArr3, put_block(bArr2, put_block(bArr, put_int32((int) j16, put_int32((int) j3, i3))))))));
            return get_buf();
        }
        return new byte[0];
    }
}
