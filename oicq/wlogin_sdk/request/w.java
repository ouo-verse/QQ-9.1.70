package oicq.wlogin_sdk.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import oicq.wlogin_sdk.pb.ThirdPartLogin$RspBody;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t178;
import oicq.wlogin_sdk.tlv_type.tlv_t179;
import oicq.wlogin_sdk.tlv_type.tlv_t17d;
import oicq.wlogin_sdk.tlv_type.tlv_t508;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class w extends oicq_request {
    public w(u uVar) {
        this.f422914j = 2064;
        this.f422915k = 23;
        this.f422916l = BaseConstants.CMD_WT_LOGIN_AUTH;
        this.f422917m = uVar;
        uVar.f422964k = 0;
    }

    @Override // oicq.wlogin_sdk.request.oicq_request
    public int c(byte[] bArr, int i3, int i16) {
        int i17;
        Object valueOf;
        if (i16 < 5) {
            return -1009;
        }
        async_context b16 = u.b(this.f422917m.f422959f);
        int b17 = b(bArr, i3 + 2);
        int i18 = i3 + 5;
        this.f422917m.f422956c = null;
        tlv_t104 tlv_t104Var = new tlv_t104();
        if (tlv_t104Var.get_tlv(bArr, i18, this.f422907c - i18) >= 0) {
            b16.set_t104(tlv_t104Var);
        }
        tlv_t543 tlv_t543Var = new tlv_t543();
        int i19 = tlv_t543Var.get_tlv(bArr, i18, this.f422907c - i18);
        if (i19 > 0) {
            b16._t543 = tlv_t543Var;
        }
        if (b17 != 0) {
            b(bArr, i18, (this.f422907c - i18) - 1);
            i17 = b17;
        } else {
            int i26 = -2003;
            if (i19 > 0) {
                byte[] bArr2 = tlv_t543Var.get_data();
                ThirdPartLogin$RspBody thirdPartLogin$RspBody = new ThirdPartLogin$RspBody();
                try {
                    thirdPartLogin$RspBody.mergeFrom(bArr2);
                    if (thirdPartLogin$RspBody.has() && thirdPartLogin$RspBody.msg_rsp_third_login.has()) {
                        this.f422917m.f422957d = thirdPartLogin$RspBody.msg_rsp_third_login.get().uint64_qq_uin.get();
                        u uVar = this.f422917m;
                        uVar.f422958e = String.valueOf(uVar.f422957d);
                        b16._uin = this.f422917m.f422957d;
                    }
                    util.LOGI("request_login_by_third_platform get_response_body subCmd= 0x17 success", "" + this.f422917m.f422957d);
                    i26 = 0;
                } catch (InvalidProtocolBufferMicroException e16) {
                    util.printException(e16, "");
                }
            }
            i17 = i26;
        }
        a(bArr, i18, new tlv_t178(), new tlv_t179(), new tlv_t17d(), b16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("request_login_by_third_platform type:");
        sb5.append(b17);
        sb5.append(" ret:");
        if (i17 > 0) {
            valueOf = RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(i17);
        } else {
            valueOf = Integer.valueOf(i17);
        }
        sb5.append(valueOf);
        util.LOGI(sb5.toString(), "" + this.f422917m.f422957d);
        if (i17 == 0) {
            a((ErrMsg) null);
        } else {
            new tlv_t508().get_tlv(bArr, i18, (this.f422907c - i18) - 1);
            if (tlv_t508.doFetch) {
                ErrMsg errMsg = new ErrMsg();
                int b18 = new g(this.f422917m, this.f422914j, this.f422915k, errMsg).b(i17);
                if (b18 != -1000) {
                    a(errMsg);
                    i17 = b18;
                }
            }
        }
        if (util.isTimeOutRet(i17)) {
            return -1000;
        }
        return i17;
    }
}
