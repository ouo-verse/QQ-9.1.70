package oicq.wlogin_sdk.tlv_type;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t193 extends tlv_t {
    public tlv_t193() {
        this._cmd = 403;
    }

    public byte[] get_tlv_193(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        fill_head(this._cmd);
        fill_body(bArr, bArr.length);
        set_length();
        return get_buf();
    }
}
