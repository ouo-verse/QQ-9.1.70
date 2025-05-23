package oicq.wlogin_sdk.tlv_type;

import com.tencent.luggage.wxa.se.b;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t174 extends tlv_t {
    public int _t174_body_len = 0;

    public tlv_t174() {
        this._cmd = b.CTRL_INDEX;
    }

    public byte[] get_tlv_174(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        this._t174_body_len = length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        fill_head(this._cmd);
        fill_body(bArr2, this._t174_body_len);
        set_length();
        return get_buf();
    }
}
