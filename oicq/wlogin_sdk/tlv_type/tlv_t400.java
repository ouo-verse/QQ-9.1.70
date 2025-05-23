package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t400 extends tlv_t {
    public int _version = 1;
    public int _t400_body_len = 0;

    public tlv_t400() {
        this._cmd = 1024;
    }

    public byte[] get_tlv_400(byte[] bArr, long j3, byte[] bArr2, byte[] bArr3, long j16, long j17, byte[] bArr4) {
        if (bArr == null) {
            bArr = new byte[16];
        }
        if (bArr2 == null) {
            bArr2 = new byte[16];
        }
        if (bArr3 == null) {
            bArr3 = new byte[16];
        }
        if (bArr4 == null) {
            bArr4 = new byte[8];
        }
        int length = bArr2.length + 10 + bArr3.length + 4 + 4 + 4 + bArr4.length;
        this._t400_body_len = length;
        byte[] bArr5 = new byte[length];
        util.int16_to_buf(bArr5, 0, this._version);
        util.int64_to_buf(bArr5, 2, j3);
        System.arraycopy(bArr2, 0, bArr5, 10, bArr2.length);
        int length2 = bArr2.length + 10;
        System.arraycopy(bArr3, 0, bArr5, length2, bArr3.length);
        int length3 = length2 + bArr3.length;
        util.int32_to_buf(bArr5, length3, (int) j16);
        int i3 = length3 + 4;
        util.int32_to_buf(bArr5, i3, (int) j17);
        int i16 = i3 + 4;
        util.int64_to_buf32(bArr5, i16, util.get_server_cur_time());
        System.arraycopy(bArr4, 0, bArr5, i16 + 4, bArr4.length);
        byte[] encrypt = cryptor.encrypt(bArr5, 0, length, bArr);
        this._t400_body_len = encrypt.length;
        fill_head(this._cmd);
        fill_body(encrypt, encrypt.length);
        set_length();
        return get_buf();
    }
}
