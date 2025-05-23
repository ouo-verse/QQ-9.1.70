package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t128 extends tlv_t {
    public int _t128_body_len = 0;

    public tlv_t128() {
        this._cmd = 296;
    }

    public byte[] get_tlv_128(int i3, int i16, int i17, int i18, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        if (bArr == null) {
            bArr4 = new byte[0];
        } else {
            bArr4 = bArr;
        }
        if (bArr2 == null) {
            bArr5 = new byte[0];
        } else {
            bArr5 = bArr2;
        }
        if (bArr3 == null) {
            bArr6 = new byte[0];
        } else {
            bArr6 = bArr3;
        }
        int limit_len = limit_len(bArr4, 32);
        int limit_len2 = limit_len(bArr5, 16);
        int limit_len3 = limit_len(bArr6, 16);
        int i19 = limit_len + 11;
        int i26 = i19 + 2;
        int i27 = i26 + limit_len2;
        int i28 = i27 + 2;
        int i29 = i28 + limit_len3;
        this._t128_body_len = i29;
        byte[] bArr7 = new byte[i29];
        util.int16_to_buf(bArr7, 0, 0);
        util.int8_to_buf(bArr7, 2, i3);
        util.int8_to_buf(bArr7, 3, i16);
        util.int8_to_buf(bArr7, 4, i17);
        util.int32_to_buf(bArr7, 5, i18);
        util.int16_to_buf(bArr7, 9, limit_len);
        System.arraycopy(bArr4, 0, bArr7, 11, limit_len);
        util.int16_to_buf(bArr7, i19, limit_len2);
        System.arraycopy(bArr5, 0, bArr7, i26, limit_len2);
        util.int16_to_buf(bArr7, i27, limit_len3);
        System.arraycopy(bArr6, 0, bArr7, i28, limit_len3);
        fill_head(this._cmd);
        fill_body(bArr7, this._t128_body_len);
        set_length();
        return get_buf();
    }
}
