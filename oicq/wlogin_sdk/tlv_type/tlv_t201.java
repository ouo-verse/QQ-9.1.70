package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t201 extends tlv_t {
    public tlv_t201() {
        this._cmd = 513;
    }

    public byte[] get_tlv_201(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        if (bArr4 == null) {
            bArr4 = new byte[0];
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length + 2 + 2 + bArr2.length + 2 + bArr3.length + 2 + bArr4.length;
        byte[] bArr5 = new byte[length];
        util.int16_to_buf(bArr5, 0, bArr.length);
        System.arraycopy(bArr, 0, bArr5, 2, bArr.length);
        int length2 = bArr.length + 2;
        util.int16_to_buf(bArr5, length2, bArr2.length);
        int i3 = length2 + 2;
        System.arraycopy(bArr2, 0, bArr5, i3, bArr2.length);
        int length3 = i3 + bArr2.length;
        util.int16_to_buf(bArr5, length3, bArr3.length);
        int i16 = length3 + 2;
        System.arraycopy(bArr3, 0, bArr5, i16, bArr3.length);
        int length4 = i16 + bArr3.length;
        util.int16_to_buf(bArr5, length4, bArr4.length);
        System.arraycopy(bArr4, 0, bArr5, length4 + 2, bArr4.length);
        fill_head(this._cmd);
        fill_body(bArr5, length);
        set_length();
        return get_buf();
    }
}
