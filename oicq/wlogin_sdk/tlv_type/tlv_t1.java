package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t1 extends tlv_t {
    public int _ip_len = 4;
    public int _ip_pos = 14;
    public int _ip_ver = 1;
    public int _t1_body_len = 20;
    public byte[] IP_KEY = new byte[2];

    public tlv_t1() {
        this._cmd = 1;
    }

    public byte[] get_ip() {
        int i3 = this._ip_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._ip_pos, bArr, 0, i3);
        return bArr;
    }

    public byte[] get_tlv_1(long j3, byte[] bArr) {
        byte[] bArr2 = new byte[this._t1_body_len];
        util.int16_to_buf(bArr2, 0, this._ip_ver);
        util.int32_to_buf(bArr2, 2, util.get_rand_32());
        util.int32_to_buf(bArr2, 6, (int) j3);
        util.int64_to_buf32(bArr2, 10, util.get_server_cur_time());
        System.arraycopy(bArr, 0, bArr2, 14, bArr.length);
        util.int16_to_buf(bArr2, bArr.length + 14, 0);
        fill_head(this._cmd);
        fill_body(bArr2, this._t1_body_len);
        set_length();
        return get_buf();
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 20) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
