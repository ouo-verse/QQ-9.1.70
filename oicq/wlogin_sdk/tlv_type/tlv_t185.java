package oicq.wlogin_sdk.tlv_type;

import com.tencent.luggage.wxa.yf.e0;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t185 extends tlv_t {
    public tlv_t185() {
        this._cmd = e0.CTRL_INDEX;
    }

    public byte[] get_tlv_185(int i3) {
        byte[] bArr = new byte[2];
        util.int8_to_buf(bArr, 0, 1);
        util.int8_to_buf(bArr, 1, i3);
        fill_head(this._cmd);
        fill_body(bArr, 2);
        set_length();
        return get_buf();
    }
}
