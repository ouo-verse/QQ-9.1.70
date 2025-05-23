package oicq.wlogin_sdk.request;

import com.tencent.qphone.base.BaseConstants;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t161;
import oicq.wlogin_sdk.tlv_type.tlv_t165;
import oicq.wlogin_sdk.tlv_type.tlv_t546;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class q extends oicq_request {
    public q(u uVar) {
        this.f422914j = 2064;
        this.f422915k = 3;
        this.f422916l = BaseConstants.CMD_WT_LOGIN_AUTH;
        this.f422917m = uVar;
        uVar.f422964k = 0;
    }

    @Override // oicq.wlogin_sdk.request.oicq_request
    public int c(byte[] bArr, int i3, int i16) {
        int i17;
        tlv_t104 tlv_t104Var = new tlv_t104();
        tlv_t105 tlv_t105Var = new tlv_t105();
        tlv_t165 tlv_t165Var = new tlv_t165();
        tlv_t161 tlv_t161Var = new tlv_t161();
        tlv_t546 tlv_t546Var = new tlv_t546();
        async_context b16 = u.b(this.f422917m.f422959f);
        int b17 = b(bArr, i3 + 2);
        util.LOGD(q.class.getName(), "type=" + b17);
        int i18 = i3 + 5;
        if (b17 != 2) {
            if (b17 == 180) {
                i17 = tlv_t161Var.get_tlv(bArr, i18, (this.f422907c - i18) - 1);
                if (i17 >= 0) {
                    a(tlv_t161Var);
                }
            }
            b(bArr, i18, (this.f422907c - i18) - 1);
            return b17;
        }
        int i19 = tlv_t104Var.get_tlv(bArr, i18, this.f422907c - i18);
        if (i19 < 0) {
            return i19;
        }
        b16.set_t104(tlv_t104Var);
        i17 = tlv_t105Var.get_tlv(bArr, i18, this.f422907c - i18);
        if (i17 >= 0) {
            b16._t105 = tlv_t105Var;
            if (tlv_t165Var.get_tlv(bArr, i18, this.f422907c - i18) >= 0) {
                b16._t165 = tlv_t165Var;
            } else {
                b16._t165 = new tlv_t165();
            }
            int i26 = tlv_t546Var.get_tlv(bArr, i18, this.f422907c - i18);
            if (i26 >= 0) {
                util.LOGI("flush get tlv546 success len:" + tlv_t546Var.get_data_len(), "");
                b16._t546 = tlv_t546Var;
            } else {
                util.LOGI("flush get tlv546 fail ret:" + i26, "");
                b16._t546 = new tlv_t546();
            }
            oicq.wlogin_sdk.pow.b.a(tlv_t546Var.get_data());
            a((ErrMsg) null);
            return b17;
        }
        return i17;
    }
}
