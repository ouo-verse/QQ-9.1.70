package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t124 extends tlv_t {
    public int _t124_body_len = 0;

    public tlv_t124() {
        this._cmd = 292;
    }

    public byte[] get_tlv_124(byte[] bArr, byte[] bArr2, int i3, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        byte[] bArr6;
        byte[] bArr7;
        byte[] bArr8;
        byte[] bArr9;
        byte[] bArr10;
        if (bArr == null) {
            bArr6 = new byte[0];
        } else {
            bArr6 = bArr;
        }
        if (bArr2 == null) {
            bArr7 = new byte[0];
        } else {
            bArr7 = bArr2;
        }
        if (bArr3 == null) {
            bArr8 = new byte[0];
        } else {
            bArr8 = bArr3;
        }
        if (bArr4 == null) {
            bArr9 = new byte[0];
        } else {
            bArr9 = bArr4;
        }
        if (bArr5 == null) {
            bArr10 = new byte[0];
        } else {
            bArr10 = bArr5;
        }
        int limit_len = limit_len(bArr6, 16);
        int limit_len2 = limit_len(bArr7, 16);
        int limit_len3 = limit_len(bArr8, 16);
        int limit_len4 = limit_len(bArr9, 32);
        int limit_len5 = limit_len(bArr10, 16);
        int i16 = limit_len + 2;
        int i17 = i16 + 2;
        int i18 = i17 + limit_len2;
        int i19 = i18 + 2;
        int i26 = i19 + 2;
        byte[] bArr11 = bArr10;
        int i27 = i26 + limit_len3;
        byte[] bArr12 = bArr9;
        int i28 = i27 + 2;
        int i29 = i28 + limit_len4;
        int i36 = i29 + 2;
        int i37 = i36 + limit_len5;
        this._t124_body_len = i37;
        byte[] bArr13 = new byte[i37];
        util.int16_to_buf(bArr13, 0, limit_len);
        System.arraycopy(bArr6, 0, bArr13, 2, limit_len);
        util.int16_to_buf(bArr13, i16, limit_len2);
        System.arraycopy(bArr7, 0, bArr13, i17, limit_len2);
        util.int16_to_buf(bArr13, i18, i3);
        util.int16_to_buf(bArr13, i19, limit_len3);
        System.arraycopy(bArr8, 0, bArr13, i26, limit_len3);
        util.int16_to_buf(bArr13, i27, limit_len4);
        System.arraycopy(bArr12, 0, bArr13, i28, limit_len4);
        util.int16_to_buf(bArr13, i29, limit_len5);
        System.arraycopy(bArr11, 0, bArr13, i36, limit_len5);
        fill_head(this._cmd);
        fill_body(bArr13, this._t124_body_len);
        set_length();
        return get_buf();
    }
}
