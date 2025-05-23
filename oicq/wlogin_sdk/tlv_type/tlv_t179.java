package oicq.wlogin_sdk.tlv_type;

import com.tencent.commonsdk.util.notification.NotificationUtil;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t179 extends tlv_t {
    public int _verify_url_len = 0;

    public tlv_t179() {
        this._cmd = NotificationUtil.Constants.NOTIFY_ID_UNIFORM_DOWNLOAD_END;
    }

    public byte[] get_verify_url() {
        int i3 = this._verify_url_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len + 2, bArr, 0, i3);
        return bArr;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        if (this._body_len < 2) {
            return Boolean.FALSE;
        }
        int buf_to_int16 = util.buf_to_int16(this._buf, this._head_len);
        if (this._body_len < buf_to_int16 + 2) {
            return Boolean.FALSE;
        }
        this._verify_url_len = buf_to_int16;
        return Boolean.TRUE;
    }
}
