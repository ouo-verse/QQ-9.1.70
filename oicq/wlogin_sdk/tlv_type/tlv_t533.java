package oicq.wlogin_sdk.tlv_type;

import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t533 extends tlv_t {
    public tlv_t533() {
        this._cmd = gdt_analysis_event.CONFIG_REPORT_FOR_MSG;
    }

    public byte[] get_tlv_533(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        int length = bArr.length + 4 + bArr2.length;
        byte[] bArr3 = new byte[length];
        util.int16_to_buf(bArr3, 0, bArr.length);
        System.arraycopy(bArr, 0, bArr3, 2, bArr.length);
        int length2 = bArr.length + 2;
        util.int16_to_buf(bArr3, length2, bArr2.length);
        System.arraycopy(bArr2, 0, bArr3, length2 + 2, bArr2.length);
        fill_head(this._cmd);
        fill_body(bArr3, length);
        set_length();
        return get_buf();
    }
}
