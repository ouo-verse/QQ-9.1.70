package oicq.wlogin_sdk.request;

import com.tencent.qphone.base.BaseConstants;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t113;
import oicq.wlogin_sdk.tlv_type.tlv_t508;
import oicq.wlogin_sdk.tlv_type.tlv_t541;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class x extends oicq_request {
    public x(u uVar) {
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
        tlv_t104 tlv_t104Var = new tlv_t104();
        tlv_t113 tlv_t113Var = new tlv_t113();
        tlv_t tlv_tVar = new tlv_t(1344);
        tlv_t541 tlv_t541Var = new tlv_t541();
        async_context b16 = u.b(this.f422917m.f422959f);
        int b17 = b(bArr, i3 + 2);
        int i18 = i3 + 5;
        this.f422917m.f422956c = null;
        if (b17 != 0) {
            i17 = 230;
            if (b17 != 230) {
                b(bArr, i18, (this.f422907c - i18) - 1);
                i17 = b17;
            } else {
                tlv_t543 tlv_t543Var = new tlv_t543();
                int i19 = tlv_t543Var.get_tlv(bArr, i18, this.f422907c - i18);
                if (i19 > 0) {
                    b16._t543 = tlv_t543Var;
                    int i26 = tlv_tVar.get_tlv(bArr, i18, this.f422907c - i18);
                    if (i26 > 0) {
                        b16.tlv540 = tlv_tVar;
                    } else {
                        util.LOGI("request_login_by_wechat ret oxe6 t540 is null subCmd= 0x17", "" + this.f422917m.f422957d);
                        i17 = i26;
                    }
                } else {
                    util.LOGI("request_login_by_wechat ret oxe6 t543 is null subCmd= 0x17", "" + this.f422917m.f422957d);
                    i17 = i19;
                }
            }
        } else {
            int i27 = tlv_t104Var.get_tlv(bArr, i18, this.f422907c - i18);
            if (i27 < 0) {
                i17 = i27;
            } else {
                b16.set_t104(tlv_t104Var);
                if (tlv_tVar.get_tlv(bArr, i18, this.f422907c - i18) > 0) {
                    b16.tlv540 = tlv_tVar;
                    if (tlv_t541Var.get_tlv(bArr, i18, (this.f422907c - i18) - 1) >= 0) {
                        b16._weixinUserFlags = tlv_t541Var.get_flags();
                    }
                    if (tlv_t113Var.get_tlv(bArr, i18, (this.f422907c - i18) - 1) >= 0) {
                        this.f422917m.f422957d = tlv_t113Var.get_uin();
                        b16._uin = this.f422917m.f422957d;
                        util.LOGI("request_login_by_wechat get_response_body subCmd= 0x17 success", "" + this.f422917m.f422957d);
                        i17 = 0;
                    } else {
                        i17 = -2003;
                    }
                } else {
                    i17 = -2002;
                }
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("request_login_by_wechat type:");
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
        if (i17 == 10 || i17 == 161 || i17 == 162 || i17 == 164 || i17 == 165 || i17 == 166 || i17 == 154) {
            return -1000;
        }
        if (i17 >= 128 && i17 <= 143) {
            return -1000;
        }
        return i17;
    }
}
