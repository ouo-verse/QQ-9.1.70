package oicq.wlogin_sdk.tlv_type;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t16e extends tlv_t {
    public int _t16e_body_len = 0;

    public tlv_t16e() {
        this._cmd = 366;
    }

    public byte[] get_tlv_16e(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        int i3 = 64;
        if (bArr.length < 64) {
            i3 = bArr.length;
        }
        this._t16e_body_len = i3;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        fill_head(this._cmd);
        fill_body(bArr2, this._t16e_body_len);
        set_length();
        return get_buf();
    }
}
