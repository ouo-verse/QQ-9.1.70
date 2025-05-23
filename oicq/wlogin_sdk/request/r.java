package oicq.wlogin_sdk.request;

import com.tencent.qphone.base.BaseConstants;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t161;
import oicq.wlogin_sdk.tlv_type.tlv_t17b;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class r extends oicq_request {

    /* renamed from: v, reason: collision with root package name */
    public static int f422923v;

    public r(u uVar) {
        this.f422914j = 2064;
        this.f422915k = 8;
        this.f422916l = BaseConstants.CMD_WT_LOGIN_AUTH;
        this.f422917m = uVar;
        uVar.f422964k = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0082, code lost:
    
        if (r5 != 239) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ec  */
    @Override // oicq.wlogin_sdk.request.oicq_request
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c(byte[] bArr, int i3, int i16) {
        String str;
        tlv_t104 tlv_t104Var = new tlv_t104();
        tlv_t17b tlv_t17bVar = new tlv_t17b();
        tlv_t161 tlv_t161Var = new tlv_t161();
        tlv_t543 tlv_t543Var = new tlv_t543();
        async_context b16 = u.b(this.f422917m.f422959f);
        StringBuffer stringBuffer = new StringBuffer("request_flushsms");
        stringBuffer.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
        int b17 = b(bArr, i3 + 2);
        stringBuffer.append(",type=");
        stringBuffer.append(b17);
        int i17 = i3 + 5;
        int i18 = tlv_t543Var.get_tlv(bArr, i17, this.f422907c - i17);
        b16._t543 = tlv_t543Var;
        stringBuffer.append(",tlv 543 ret=");
        stringBuffer.append(i18);
        tlv_t183 tlv_t183Var = new tlv_t183();
        int i19 = tlv_t183Var.get_tlv(bArr, i17, this.f422907c - i17);
        if (i19 >= 0) {
            b16._msalt = tlv_t183Var.getMsalt();
            stringBuffer.append(",tlv 183 ret=");
            stringBuffer.append(i19);
            stringBuffer.append(",_msalt=");
            stringBuffer.append(Long.toHexString(b16._msalt));
        }
        if (b17 != 160) {
            if (b17 == 180) {
                int i26 = tlv_t161Var.get_tlv(bArr, i17, (this.f422907c - i17) - 1);
                if (i26 < 0) {
                    b17 = i26;
                    if (b16._last_err_msg != null) {
                        stringBuffer.append(",err type=");
                        stringBuffer.append(b16._last_err_msg.getType());
                        stringBuffer.append(",err title=");
                        stringBuffer.append(b16._last_err_msg.getTitle());
                        stringBuffer.append(",err msg=");
                        str = b16._last_err_msg.getMessage();
                    } else {
                        str = ",err = null";
                    }
                    stringBuffer.append(str);
                    util.LOGI(stringBuffer.toString(), "");
                    return b17;
                }
                a(tlv_t161Var);
            }
            b(bArr, i17, (this.f422907c - i17) - 1);
            if (b16._last_err_msg != null) {
            }
            stringBuffer.append(str);
            util.LOGI(stringBuffer.toString(), "");
            return b17;
        }
        int i27 = tlv_t104Var.get_tlv(bArr, i17, this.f422907c - i17);
        if (i27 < 0) {
            b17 = i27;
        } else {
            b16.set_t104(tlv_t104Var);
            int i28 = tlv_t17bVar.get_tlv(bArr, i17, this.f422907c - i17);
            if (i28 < 0) {
                b17 = i28;
            } else {
                b16._t17b = tlv_t17bVar;
                a((ErrMsg) null);
            }
        }
        if (b16._last_err_msg != null) {
        }
        stringBuffer.append(str);
        util.LOGI(stringBuffer.toString(), "");
        return b17;
    }
}
