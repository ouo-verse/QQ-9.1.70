package oicq.wlogin_sdk.tlv_type;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t192 extends tlv_t {
    public byte[] _url = new byte[0];

    public tlv_t192() {
        this._cmd = 402;
    }

    public String getUrl() {
        return new String(this._url);
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        int i3 = this._body_len;
        byte[] bArr = new byte[i3];
        this._url = bArr;
        System.arraycopy(this._buf, this._head_len, bArr, 0, i3);
        return Boolean.TRUE;
    }
}
