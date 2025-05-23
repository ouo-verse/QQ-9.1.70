package oicq.wlogin_sdk.tlv_type;

import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t188 extends tlv_t {
    public int _t188_body_len = 0;

    public tlv_t188() {
        this._cmd = QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE;
    }

    public byte[] get_tlv_188(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[16];
        }
        int length = bArr.length;
        this._t188_body_len = length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        fill_head(this._cmd);
        fill_body(bArr2, this._t188_body_len);
        set_length();
        return get_buf();
    }
}
