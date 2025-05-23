package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class tlv_t541 extends tlv_t {
    public int _flags = 0;

    public tlv_t541() {
        this._cmd = 1345;
    }

    public int get_flags() {
        return this._flags;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        int i3 = this._body_len;
        if (i3 >= 1) {
            byte[] bArr = new byte[i3];
            System.arraycopy(this._buf, this._head_len, bArr, 0, i3);
            this._flags = util.buf_to_int8(bArr, 0);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
