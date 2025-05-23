package oicq.wlogin_sdk.tlv_type;

import com.tencent.luggage.wxa.rf.d;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t166 extends tlv_t {
    public tlv_t166() {
        this._cmd = d.CTRL_INDEX;
    }

    public byte[] get_tlv_166(int i3) {
        byte[] bArr = new byte[1];
        util.int8_to_buf(bArr, 0, i3);
        fill_head(this._cmd);
        fill_body(bArr, 1);
        set_length();
        return get_buf();
    }
}
