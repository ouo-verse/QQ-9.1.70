package oicq.wlogin_sdk.request;

import com.tencent.mobileqq.qsec.qsecurity.QSec;
import com.tencent.qphone.base.BaseConstants;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t401;
import oicq.wlogin_sdk.tlv_type.tlv_t402;
import oicq.wlogin_sdk.tlv_type.tlv_t403;
import oicq.wlogin_sdk.tlv_type.tlv_t553;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class p extends oicq_request {
    public p(u uVar) {
        this.f422914j = 2064;
        this.f422915k = 20;
        this.f422916l = BaseConstants.CMD_WT_LOGIN_AUTH;
        this.f422917m = uVar;
        uVar.f422964k = 0;
    }

    public int a(int i3, int i16, long[] jArr, WUserSigInfo wUserSigInfo) {
        int a16;
        int i17 = u.f422953z;
        async_context b16 = u.b(this.f422917m.f422959f);
        tlv_t104 tlv_t104Var = b16.get_t104();
        if (tlv_t104Var == null) {
            tlv_t104Var = new tlv_t104();
        }
        tlv_t104 tlv_t104Var2 = tlv_t104Var;
        tlv_t402 tlv_t402Var = b16._t402;
        if (tlv_t402Var == null) {
            tlv_t402Var = new tlv_t402();
        }
        tlv_t403 tlv_t403Var = b16._t403;
        if (tlv_t403Var == null) {
            tlv_t403Var = new tlv_t403();
        }
        byte[] bytes = util.get_mpasswd().getBytes();
        b16._dpwd = bytes;
        b16._G = a(u.D, bytes, tlv_t402Var.get_data());
        if (tlv_t402Var.get_data_len() > 0 && tlv_t403Var.get_data_len() > 0) {
            b16._sec_guid_flag = true;
        }
        int i18 = 0;
        int i19 = 0;
        while (true) {
            byte[] bArr = tlv_t104Var2.get_data();
            byte[] bArr2 = b16._G;
            tlv_t8 tlv_t8Var = new tlv_t8();
            tlv_t104 tlv_t104Var3 = new tlv_t104();
            tlv_t116 tlv_t116Var = new tlv_t116();
            tlv_t401 tlv_t401Var = new tlv_t401();
            tlv_t553 tlv_t553Var = new tlv_t553();
            byte[] bArr3 = tlv_t8Var.get_tlv_8(i18, u.f422951x, i18);
            byte[] bArr4 = tlv_t104Var3.get_tlv_104(bArr);
            byte[] bArr5 = tlv_t116Var.get_tlv_116(i3, i16, jArr);
            byte[] bArr6 = tlv_t401Var.get_tlv_401(bArr2);
            byte[] bArr7 = tlv_t553Var.get_tlv_t553(QSec.getInstance().getFeKitAttach(this.f422905a, String.valueOf(this.f422917m.f422957d), "0x810", "0x14"));
            byte[] bArr8 = new byte[bArr3.length + bArr4.length + bArr5.length + bArr6.length + bArr7.length];
            System.arraycopy(bArr3, 0, bArr8, 0, bArr3.length);
            int length = bArr3.length + 0;
            System.arraycopy(bArr4, 0, bArr8, length, bArr4.length);
            int length2 = length + bArr4.length;
            System.arraycopy(bArr5, 0, bArr8, length2, bArr5.length);
            int length3 = length2 + bArr5.length;
            System.arraycopy(bArr6, 0, bArr8, length3, bArr6.length);
            System.arraycopy(bArr7, 0, bArr8, length3 + bArr6.length, bArr7.length);
            int i26 = i19;
            int i27 = i17;
            a(8001, this.f422914j, this.f422910f, this.f422917m.f422957d, 0, 2, i17, 0, a(bArr8, this.f422915k, 5));
            a16 = a(String.valueOf(this.f422917m.f422957d), false, wUserSigInfo);
            if (a16 != 0) {
                break;
            }
            a16 = d();
            util.LOGI("retry num:" + i26 + " ret:" + a16, "" + this.f422917m.f422957d);
            if (a16 != 180) {
                break;
            }
            i19 = i26 + 1;
            if (i26 >= 1) {
                break;
            }
            i18 = 0;
            i17 = i27;
        }
        return a16;
    }
}
