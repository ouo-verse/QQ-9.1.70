package oicq.wlogin_sdk.tlv_type;

import cooperation.qzone.report.lp.LpReportInfoConfig;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t17c extends tlv_t {
    public int _t17c_body_len = 0;

    public tlv_t17c() {
        this._cmd = LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT;
    }

    public byte[] get_tlv_17c(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length + 2;
        this._t17c_body_len = length;
        byte[] bArr2 = new byte[length];
        util.int16_to_buf(bArr2, 0, bArr.length);
        System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        fill_head(this._cmd);
        fill_body(bArr2, this._t17c_body_len);
        set_length();
        return get_buf();
    }
}
