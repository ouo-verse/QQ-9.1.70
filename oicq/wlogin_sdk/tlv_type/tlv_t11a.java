package oicq.wlogin_sdk.tlv_type;

import com.tencent.view.FilterEnum;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t11a extends tlv_t {
    public int _nick_len = 0;

    public tlv_t11a() {
        this._cmd = FilterEnum.MIC_PTU_BAIXI;
    }

    public byte[] get_age() {
        byte[] bArr = new byte[1];
        System.arraycopy(this._buf, this._head_len + 2, bArr, 0, 1);
        return bArr;
    }

    public byte[] get_face() {
        byte[] bArr = new byte[2];
        System.arraycopy(this._buf, this._head_len, bArr, 0, 2);
        return bArr;
    }

    public byte[] get_gender() {
        byte[] bArr = new byte[1];
        System.arraycopy(this._buf, this._head_len + 2 + 1, bArr, 0, 1);
        return bArr;
    }

    public byte[] get_nick() {
        int i3 = this._nick_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 2 + 1 + 1 + 1, bArr, 0, i3);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 5) {
            return Boolean.FALSE;
        }
        int buf_to_int8 = util.buf_to_int8(this._buf, this._head_len + 2 + 1 + 1);
        if (this._body_len < buf_to_int8 + 5) {
            return Boolean.FALSE;
        }
        this._nick_len = buf_to_int8;
        return Boolean.TRUE;
    }
}
