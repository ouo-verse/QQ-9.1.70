package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t106 extends tlv_t {
    public int _TGTGTVer = 4;
    public int _SSoVer = 22;
    public int _t106_body_len = 98;

    public tlv_t106() {
        this._cmd = 262;
    }

    public byte[] get_tlv_106(long j3, long j16, int i3, long j17, byte[] bArr, byte[] bArr2, int i16, byte[] bArr3, long j18, byte[] bArr4, byte[] bArr5, int i17, byte[] bArr6, int i18) {
        int length;
        byte[] bArr7 = bArr == null ? new byte[0] : bArr;
        byte[] bArr8 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArr9 = bArr3 == null ? new byte[0] : bArr3;
        byte[] bArr10 = bArr5 == null ? new byte[0] : bArr5;
        byte[] bArr11 = bArr6 == null ? new byte[0] : bArr6;
        byte[] bArr12 = bArr4 == null ? new byte[0] : bArr4;
        int length2 = this._t106_body_len + bArr12.length + 2;
        this._t106_body_len = length2;
        byte[] bArr13 = new byte[length2];
        util.int16_to_buf(bArr13, 0, this._TGTGTVer);
        util.int32_to_buf(bArr13, 2, util.get_rand_32());
        util.int32_to_buf(bArr13, 6, this._SSoVer);
        util.int32_to_buf(bArr13, 10, (int) j3);
        util.int32_to_buf(bArr13, 14, i3);
        util.int64_to_buf(bArr13, 18, j17 == 0 ? j18 : j17);
        System.arraycopy(bArr7, 0, bArr13, 26, bArr7.length);
        int length3 = bArr7.length + 26;
        System.arraycopy(bArr8, 0, bArr13, length3, bArr8.length);
        int length4 = length3 + bArr8.length;
        util.int8_to_buf(bArr13, length4, i16);
        int i19 = length4 + 1;
        System.arraycopy(bArr9, 0, bArr13, i19, bArr9.length);
        int length5 = i19 + bArr9.length;
        System.arraycopy(bArr10, 0, bArr13, length5, bArr10.length);
        int length6 = length5 + bArr10.length;
        util.int32_to_buf(bArr13, length6, 0);
        int i26 = length6 + 4;
        util.int8_to_buf(bArr13, i26, i17);
        int i27 = i26 + 1;
        if (bArr11.length == 0) {
            byte[] bArr14 = new byte[16];
            util.int32_to_buf(bArr14, 0, util.get_rand_32());
            util.int32_to_buf(bArr14, 4, util.get_rand_32());
            util.int32_to_buf(bArr14, 8, util.get_rand_32());
            util.int32_to_buf(bArr14, 12, util.get_rand_32());
            length = i27 + 16;
        } else {
            System.arraycopy(bArr11, 0, bArr13, i27, bArr11.length);
            length = i27 + bArr11.length;
        }
        util.int64_to_buf32(bArr13, length, j16);
        int i28 = length + 4;
        util.int32_to_buf(bArr13, i28, i18);
        int i29 = i28 + 4;
        util.int16_to_buf(bArr13, i29, bArr12.length);
        System.arraycopy(bArr12, 0, bArr13, i29 + 2, bArr12.length);
        byte[] bArr15 = new byte[24];
        System.arraycopy(bArr9, 0, bArr15, 0, bArr9.length);
        if (j18 == 0) {
            util.int64_to_buf(bArr15, 16, j17);
        } else {
            util.int64_to_buf(bArr15, 16, j18);
        }
        byte[] encrypt = cryptor.encrypt(bArr13, 0, length2, MD5.toMD5Byte(bArr15));
        this._t106_body_len = encrypt.length;
        fill_head(this._cmd);
        fill_body(encrypt, this._t106_body_len);
        set_length();
        return get_buf();
    }
}
