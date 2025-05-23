package oicq.wlogin_sdk.tlv_type;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t130 extends tlv_t {
    public tlv_t130() {
        this._cmd = 304;
    }

    public byte[] get_ipaddr() {
        byte[] bArr = new byte[4];
        System.arraycopy(this._buf, this._head_len + 2 + 4, bArr, 0, 4);
        return bArr;
    }

    public byte[] get_time() {
        byte[] bArr = new byte[4];
        System.arraycopy(this._buf, this._head_len + 2, bArr, 0, 4);
        return bArr;
    }

    public void get_tlv_130(byte[] bArr, int i3) {
        set_buf(bArr, i3);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 14) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
