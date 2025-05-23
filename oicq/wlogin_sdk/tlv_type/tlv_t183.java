package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t183 extends tlv_t {
    public static final int CMD_183 = 387;
    public long _msalt = 0;

    public tlv_t183() {
        this._cmd = CMD_183;
    }

    public long getMsalt() {
        return this._msalt;
    }

    public byte[] get_tlv_183(long j3) {
        byte[] bArr = new byte[8];
        util.int64_to_buf(bArr, 0, j3);
        fill_head(this._cmd);
        fill_body(bArr, 8);
        set_length();
        return get_buf();
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 8) {
            return Boolean.FALSE;
        }
        this._msalt = util.buf_to_int64(this._buf, this._head_len);
        return Boolean.TRUE;
    }
}
