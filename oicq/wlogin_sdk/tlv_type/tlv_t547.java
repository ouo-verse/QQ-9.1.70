package oicq.wlogin_sdk.tlv_type;

import com.tencent.ad.tangram.protocol.gdt_analysis_event;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t547 extends tlv_t {
    public tlv_t547() {
        this._cmd = gdt_analysis_event.EVENT_MOTIVE_HIPPY_WEB_VIEW_START_ACTIVITY;
    }

    public byte[] get_tlv_547(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        fill_head(this._cmd);
        fill_body(bArr2, length);
        set_length();
        return get_buf();
    }
}
