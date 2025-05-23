package oicq.wlogin_sdk.request;

import com.tencent.qphone.base.BaseConstants;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t113;
import oicq.wlogin_sdk.tlv_type.tlv_t178;
import oicq.wlogin_sdk.tlv_type.tlv_t179;
import oicq.wlogin_sdk.tlv_type.tlv_t17d;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class v extends oicq_request {
    public v(u uVar) {
        this.f422914j = 2064;
        this.f422915k = 23;
        this.f422916l = BaseConstants.CMD_WT_LOGIN_AUTH;
        this.f422917m = uVar;
        uVar.f422964k = 0;
    }

    @Override // oicq.wlogin_sdk.request.oicq_request
    public int c(byte[] bArr, int i3, int i16) {
        if (i16 < 5) {
            return -1009;
        }
        async_context b16 = u.b(this.f422917m.f422959f);
        int b17 = b(bArr, i3 + 2);
        int i17 = i3 + 5;
        tlv_t543 tlv_t543Var = new tlv_t543();
        int i18 = tlv_t543Var.get_tlv(bArr, i17, this.f422907c - i17);
        b16._t543 = tlv_t543Var;
        StringBuilder sb5 = new StringBuilder("quickLoginByGateway.request_login_by_gateway");
        sb5.append(",get_response_body ret=");
        sb5.append(b17);
        sb5.append(",ret543=");
        sb5.append(i18);
        if (b17 == 0) {
            tlv_t113 tlv_t113Var = new tlv_t113();
            int i19 = tlv_t113Var.get_tlv(bArr, i17, (this.f422907c - i17) - 1);
            sb5.append(",ret113=");
            sb5.append(i19);
            if (i19 >= 0) {
                this.f422917m.f422957d = tlv_t113Var.get_uin();
                b16._uin = this.f422917m.f422957d;
                b17 = 0;
            }
        }
        tlv_t104 tlv_t104Var = new tlv_t104();
        int i26 = tlv_t104Var.get_tlv(bArr, i17, this.f422907c - i17);
        sb5.append(",ret104=");
        sb5.append(i26);
        if (i26 >= 0) {
            b16.set_t104(tlv_t104Var);
        }
        a(bArr, i17, new tlv_t178(), new tlv_t179(), new tlv_t17d(), b16);
        util.LOGI(sb5.toString(), "");
        return b17;
    }
}
