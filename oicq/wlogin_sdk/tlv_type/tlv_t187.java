package oicq.wlogin_sdk.tlv_type;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t187 extends tlv_t {
    public int _t187_body_len = 0;

    public tlv_t187() {
        this._cmd = 391;
    }

    public byte[] get_tlv_187(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[16];
        }
        int length = bArr.length;
        this._t187_body_len = length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        fill_head(this._cmd);
        fill_body(bArr2, this._t187_body_len);
        set_length();
        return get_buf();
    }
}
