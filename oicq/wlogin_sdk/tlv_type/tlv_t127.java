package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t127 extends tlv_t {
    public int _t127_body_len = 0;
    public int _version = 0;

    public tlv_t127() {
        this._cmd = 295;
    }

    public byte[] get_tlv_127(byte[] bArr, byte[] bArr2) {
        int length = bArr.length + 4 + 2 + bArr2.length;
        this._t127_body_len = length;
        byte[] bArr3 = new byte[length];
        util.int16_to_buf(bArr3, 0, this._version);
        util.int16_to_buf(bArr3, 2, bArr.length);
        System.arraycopy(bArr, 0, bArr3, 4, bArr.length);
        int length2 = bArr.length + 4;
        util.int16_to_buf(bArr3, length2, bArr2.length);
        System.arraycopy(bArr2, 0, bArr3, length2 + 2, bArr2.length);
        fill_head(this._cmd);
        fill_body(bArr3, length);
        set_length();
        return get_buf();
    }
}
