package oicq.wlogin_sdk.tlv_type;

import com.tencent.mobileqq.cardcontainer.api.impl.CardContainerDataServiceImpl;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t548 extends tlv_t {
    public tlv_t548() {
        this._cmd = CardContainerDataServiceImpl.CARD_CONTAINER_POS_ID;
    }

    public byte[] get_tlv_548(byte[] bArr) {
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
