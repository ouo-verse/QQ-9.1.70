package oicq.wlogin_sdk.tlv_type;

import com.tencent.mobileqq.vas.qid.QidPagView;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t177 extends tlv_t {
    public int _t177_body_len = 0;

    public tlv_t177() {
        this._cmd = QidPagView.DESIGN_PAG_WIDTH;
    }

    public byte[] get_tlv_177(long j3, String str) {
        byte[] bArr = new byte[0];
        if (str != null) {
            bArr = str.getBytes();
        }
        int length = bArr.length + 7;
        this._t177_body_len = length;
        byte[] bArr2 = new byte[length];
        util.int8_to_buf(bArr2, 0, 1);
        util.int64_to_buf32(bArr2, 1, j3);
        util.int16_to_buf(bArr2, 5, bArr.length);
        System.arraycopy(bArr, 0, bArr2, 7, bArr.length);
        fill_head(this._cmd);
        fill_body(bArr2, this._t177_body_len);
        set_length();
        return get_buf();
    }
}
