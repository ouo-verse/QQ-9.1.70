package oicq.wlogin_sdk.request;

import android.content.Context;
import com.tencent.qphone.base.BaseConstants;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t165;
import oicq.wlogin_sdk.tlv_type.tlv_t192;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tlv_type.tlv_t546;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class s extends oicq_request {
    public s(u uVar, Context context) {
        this.f422914j = 2064;
        this.f422915k = 24;
        this.f422916l = BaseConstants.CMD_WT_LOGIN_AUTH;
        this.f422917m = uVar;
        uVar.f422964k = 0;
        this.f422905a = context;
    }

    @Override // oicq.wlogin_sdk.request.oicq_request
    public int c(byte[] bArr, int i3, int i16) {
        ErrMsg errMsg;
        if (i16 < 5) {
            return -1009;
        }
        async_context b16 = u.b(this.f422917m.f422959f);
        int b17 = b(bArr, i3 + 2);
        int i17 = i3 + 5;
        tlv_t543 tlv_t543Var = new tlv_t543();
        if (tlv_t543Var.get_tlv(bArr, i17, this.f422907c - i17) > 0) {
            b16._t543 = tlv_t543Var;
        }
        tlv_t104 tlv_t104Var = new tlv_t104();
        if (tlv_t104Var.get_tlv(bArr, i17, this.f422907c - i17) >= 0) {
            b16.set_t104(tlv_t104Var);
        }
        if (b17 == 0) {
            return b17;
        }
        if (b17 == 2) {
            if (tlv_t104Var.get_tlv(bArr, i17, (this.f422907c - i17) - 1) < 0) {
                return -1000;
            }
            b16.set_t104(tlv_t104Var);
            tlv_t192 tlv_t192Var = new tlv_t192();
            int i18 = tlv_t192Var.get_tlv(bArr, i17, (this.f422907c - i17) - 1);
            tlv_t546 tlv_t546Var = new tlv_t546();
            tlv_t105 tlv_t105Var = new tlv_t105();
            tlv_t165 tlv_t165Var = new tlv_t165();
            if (i18 >= 0) {
                util.LOGI("return 0x192", "");
                int i19 = tlv_t546Var.get_tlv(bArr, i17, (this.f422907c - i17) - 1);
                if (i19 >= 0) {
                    util.LOGI("get tlv546 success len:" + tlv_t546Var.get_data_len(), "");
                    b16._t546 = tlv_t546Var;
                } else {
                    util.LOGI("get tlv546 fail ret:" + i19, "");
                    b16._t546 = new tlv_t546();
                }
                oicq.wlogin_sdk.pow.b.a(tlv_t546Var.get_data());
                errMsg = new ErrMsg(0, b17, "", "", tlv_t192Var.getUrl());
            } else {
                if (tlv_t105Var.get_tlv(bArr, i17, (this.f422907c - i17) - 1) < 0) {
                    return -1000;
                }
                b16._t105 = tlv_t105Var;
                if (tlv_t165Var.get_tlv(bArr, i17, (this.f422907c - i17) - 1) >= 0) {
                    b16._t165 = tlv_t165Var;
                } else {
                    b16._t165 = new tlv_t165();
                }
                int i26 = tlv_t546Var.get_tlv(bArr, i17, (this.f422907c - i17) - 1);
                if (i26 >= 0) {
                    util.LOGI("get tlv546 success len:" + tlv_t546Var.get_data_len(), "");
                    b16._t546 = tlv_t546Var;
                } else {
                    util.LOGI("get tlv546 fail ret:" + i26, "");
                    b16._t546 = new tlv_t546();
                }
                oicq.wlogin_sdk.pow.b.a(tlv_t546Var.get_data());
                errMsg = null;
            }
            a(errMsg);
        } else {
            b(bArr, i17, (this.f422907c - i17) - 1);
        }
        return b17;
    }
}
