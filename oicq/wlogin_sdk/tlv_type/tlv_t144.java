package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t144 extends tlv_t {
    public int _t144_body_len = 0;

    public tlv_t144() {
        this._cmd = 324;
    }

    public byte[] get_tlv_144(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        int i3;
        int i16;
        if (bArr == null || bArr.length <= 0) {
            i3 = 0;
            i16 = 0;
        } else {
            i3 = bArr.length + 0;
            i16 = 1;
        }
        if (bArr2 != null && bArr2.length > 0) {
            i3 += bArr2.length;
            i16++;
        }
        if (bArr3 != null && bArr3.length > 0) {
            i3 += bArr3.length;
            i16++;
        }
        if (bArr4 != null && bArr4.length > 0) {
            i3 += bArr4.length;
            i16++;
        }
        if (bArr5 != null && bArr5.length > 0) {
            i3 += bArr5.length;
            i16++;
        }
        int i17 = 2;
        int i18 = i3 + 2;
        byte[] bArr7 = new byte[i18];
        util.int16_to_buf(bArr7, 0, i16);
        if (bArr != null && bArr.length > 0) {
            System.arraycopy(bArr, 0, bArr7, 2, bArr.length);
            i17 = 2 + bArr.length;
        }
        if (bArr2 != null && bArr2.length > 0) {
            System.arraycopy(bArr2, 0, bArr7, i17, bArr2.length);
            i17 += bArr2.length;
        }
        if (bArr3 != null && bArr3.length > 0) {
            System.arraycopy(bArr3, 0, bArr7, i17, bArr3.length);
            i17 += bArr3.length;
        }
        if (bArr4 != null && bArr4.length > 0) {
            System.arraycopy(bArr4, 0, bArr7, i17, bArr4.length);
            i17 += bArr4.length;
        }
        if (bArr5 != null && bArr5.length > 0) {
            System.arraycopy(bArr5, 0, bArr7, i17, bArr5.length);
        }
        byte[] encrypt = cryptor.encrypt(bArr7, 0, i18, bArr6);
        this._t144_body_len = encrypt.length;
        fill_head(this._cmd);
        fill_body(encrypt, encrypt.length);
        set_length();
        return get_buf();
    }

    public byte[] get_tlv_144(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9) {
        int i3;
        int i16;
        if (bArr == null || bArr.length <= 0) {
            i3 = 0;
            i16 = 0;
        } else {
            i3 = bArr.length + 0;
            i16 = 1;
        }
        if (bArr2 != null && bArr2.length > 0) {
            i3 += bArr2.length;
            i16++;
        }
        if (bArr3 != null && bArr3.length > 0) {
            i3 += bArr3.length;
            i16++;
        }
        if (bArr4 != null && bArr4.length > 0) {
            i3 += bArr4.length;
            i16++;
        }
        if (bArr5 != null && bArr5.length > 0) {
            i3 += bArr5.length;
            i16++;
        }
        if (bArr6 != null && bArr6.length > 0) {
            i3 += bArr6.length;
            i16++;
        }
        if (bArr7 != null && bArr7.length > 0) {
            i3 += bArr7.length;
            i16++;
        }
        if (bArr8 != null && bArr8.length > 0) {
            i3 += bArr8.length;
            i16++;
        }
        int i17 = 2;
        int i18 = i3 + 2;
        byte[] bArr10 = new byte[i18];
        util.int16_to_buf(bArr10, 0, i16);
        if (bArr != null && bArr.length > 0) {
            System.arraycopy(bArr, 0, bArr10, 2, bArr.length);
            i17 = 2 + bArr.length;
        }
        if (bArr2 != null && bArr2.length > 0) {
            System.arraycopy(bArr2, 0, bArr10, i17, bArr2.length);
            i17 += bArr2.length;
        }
        if (bArr3 != null && bArr3.length > 0) {
            System.arraycopy(bArr3, 0, bArr10, i17, bArr3.length);
            i17 += bArr3.length;
        }
        if (bArr4 != null && bArr4.length > 0) {
            System.arraycopy(bArr4, 0, bArr10, i17, bArr4.length);
            i17 += bArr4.length;
        }
        if (bArr5 != null && bArr5.length > 0) {
            System.arraycopy(bArr5, 0, bArr10, i17, bArr5.length);
            i17 += bArr5.length;
        }
        if (bArr6 != null && bArr6.length > 0) {
            System.arraycopy(bArr6, 0, bArr10, i17, bArr6.length);
            i17 += bArr6.length;
        }
        if (bArr7 != null && bArr7.length > 0) {
            System.arraycopy(bArr7, 0, bArr10, i17, bArr7.length);
            i17 += bArr7.length;
        }
        if (bArr8 != null && bArr8.length > 0) {
            System.arraycopy(bArr8, 0, bArr10, i17, bArr8.length);
        }
        byte[] encrypt = cryptor.encrypt(bArr10, 0, i18, bArr9);
        this._t144_body_len = encrypt.length;
        fill_head(this._cmd);
        fill_body(encrypt, encrypt.length);
        set_length();
        return get_buf();
    }
}
