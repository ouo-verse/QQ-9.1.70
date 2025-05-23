package oicq.wlogin_sdk.tlv_type;

import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t119 extends tlv_t {
    public tlv_t119() {
        this._cmd = FilterEnum.MIC_PTU_TRANS_KONGCHENG;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        return Boolean.TRUE;
    }
}
