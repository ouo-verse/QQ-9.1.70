package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t184 extends tlv_t {
    public static final int CMD_184 = 388;
    public byte[] _mS2 = new byte[0];

    public tlv_t184() {
        this._cmd = 388;
    }

    public byte[] getMS2() {
        return this._mS2;
    }

    public byte[] get_tlv_184(long j3, String str) {
        byte[] mD5Byte = MD5.toMD5Byte(str);
        int length = mD5Byte.length;
        byte[] bArr = new byte[length + 8];
        System.arraycopy(mD5Byte, 0, bArr, 0, length);
        util.int64_to_buf(bArr, length + 0, j3);
        byte[] mD5Byte2 = MD5.toMD5Byte(bArr);
        fill_head(this._cmd);
        fill_body(mD5Byte2, mD5Byte2.length);
        set_length();
        return get_buf();
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 16) {
            return Boolean.FALSE;
        }
        byte[] bArr = new byte[16];
        this._mS2 = bArr;
        System.arraycopy(this._buf, this._head_len, bArr, 0, 16);
        return Boolean.TRUE;
    }
}
