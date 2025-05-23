package oicq.wlogin_sdk.request;

import com.tencent.mobileqq.qsec.qsecurity.QSec;
import com.tencent.qphone.base.BaseConstants;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.ArrayList;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t113;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t174;
import oicq.wlogin_sdk.tlv_type.tlv_t17c;
import oicq.wlogin_sdk.tlv_type.tlv_t184;
import oicq.wlogin_sdk.tlv_type.tlv_t401;
import oicq.wlogin_sdk.tlv_type.tlv_t402;
import oicq.wlogin_sdk.tlv_type.tlv_t403;
import oicq.wlogin_sdk.tlv_type.tlv_t542;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tlv_type.tlv_t553;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class o extends oicq_request {

    /* renamed from: v, reason: collision with root package name */
    public int f422901v = 0;

    public o(u uVar) {
        this.f422914j = 2064;
        this.f422915k = 7;
        this.f422916l = BaseConstants.CMD_WT_LOGIN_AUTH;
        this.f422917m = uVar;
        uVar.f422964k = 0;
    }

    public int a(byte[] bArr, int i3, int i16, long[] jArr, WUserSigInfo wUserSigInfo, byte[] bArr2) {
        int a16;
        byte[] bArr3;
        int i17;
        byte[] bArr4;
        byte[] bArr5;
        int i18;
        int i19 = u.f422953z;
        async_context b16 = u.b(this.f422917m.f422959f);
        tlv_t104 tlv_t104Var = b16.get_t104();
        if (tlv_t104Var == null) {
            tlv_t104Var = new tlv_t104();
        }
        tlv_t104 tlv_t104Var2 = tlv_t104Var;
        tlv_t174 tlv_t174Var = b16._t174;
        if (tlv_t174Var == null) {
            tlv_t174Var = new tlv_t174();
        }
        tlv_t174 tlv_t174Var2 = tlv_t174Var;
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
        int i26 = 0;
        while (true) {
            byte[] bArr6 = tlv_t104Var2.get_data();
            byte[] bArr7 = tlv_t174Var2.get_data();
            byte[] bArr8 = b16._G;
            int[] iArr = {8, 260, 278, com.tencent.luggage.wxa.se.b.CTRL_INDEX, LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT, 1025, 408, 1346, 1348, tlv_t553.CMD_553};
            ArrayList arrayList = new ArrayList();
            StringBuffer stringBuffer = new StringBuffer("request_checksms");
            stringBuffer.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
            int i27 = 0;
            int i28 = 0;
            for (int i29 = 10; i27 < i29; i29 = 10) {
                int i36 = iArr[i27];
                if (i36 != 8) {
                    if (i36 != 260) {
                        if (i36 != 278) {
                            if (i36 != 372) {
                                if (i36 != 380) {
                                    if (i36 != 408) {
                                        if (i36 != 1025) {
                                            if (i36 != 1346) {
                                                if (i36 != 1348) {
                                                    if (i36 != 1363) {
                                                        bArr5 = null;
                                                        bArr4 = bArr6;
                                                        bArr3 = bArr7;
                                                        i17 = i19;
                                                    } else {
                                                        i17 = i19;
                                                        bArr5 = new tlv_t553().get_tlv_t553(QSec.getInstance().getFeKitAttach(this.f422905a, String.valueOf(this.f422917m.f422957d), "0x810", "0x7"));
                                                    }
                                                } else {
                                                    i17 = i19;
                                                    bArr5 = new tlv_t544().get_tlv_544(this.f422917m.f422957d, "810_7", this.f422915k);
                                                }
                                            } else {
                                                i17 = i19;
                                                bArr5 = new tlv_t542().get_tlv_542(bArr2);
                                                StringBuilder sb5 = new StringBuilder();
                                                sb5.append("checksms tlv542:");
                                                if (bArr5 != null) {
                                                    i18 = bArr5.length;
                                                } else {
                                                    i18 = 0;
                                                }
                                                sb5.append(i18);
                                                util.LOGI(sb5.toString(), "");
                                            }
                                        } else {
                                            i17 = i19;
                                            bArr5 = new tlv_t401().get_tlv_401(bArr8);
                                        }
                                    } else {
                                        i17 = i19;
                                        tlv_t tlv_tVar = new tlv_t(408);
                                        tlv_tVar.set_data(new byte[]{(byte) r.f422923v}, 1);
                                        bArr5 = tlv_tVar.get_buf();
                                    }
                                } else {
                                    i17 = i19;
                                    bArr5 = new tlv_t17c().get_tlv_17c(bArr);
                                }
                            } else {
                                i17 = i19;
                                bArr5 = new tlv_t174().get_tlv_174(bArr7);
                            }
                            bArr4 = bArr6;
                            bArr3 = bArr7;
                        } else {
                            i17 = i19;
                            bArr3 = bArr7;
                            bArr5 = new tlv_t116().get_tlv_116(i3, i16, jArr);
                        }
                    } else {
                        bArr3 = bArr7;
                        i17 = i19;
                        bArr5 = new tlv_t104().get_tlv_104(bArr6);
                    }
                    bArr4 = bArr6;
                } else {
                    bArr3 = bArr7;
                    i17 = i19;
                    bArr4 = bArr6;
                    bArr5 = new tlv_t8().get_tlv_8(0, u.f422951x, 0);
                }
                if (bArr5 != null) {
                    arrayList.add(bArr5);
                    i28 += bArr5.length;
                }
                i27++;
                bArr7 = bArr3;
                i19 = i17;
                bArr6 = bArr4;
            }
            int i37 = i19;
            stringBuffer.append(",_msalt=");
            stringBuffer.append(Long.toHexString(b16._msalt));
            if (b16._msalt > 0) {
                stringBuffer.append(",_mpasswd=");
                stringBuffer.append(b16._mpasswd);
                byte[] bArr9 = new tlv_t184().get_tlv_184(b16._msalt, b16._mpasswd);
                arrayList.add(bArr9);
                i28 += bArr9.length;
            }
            int i38 = i28;
            for (Integer num : wUserSigInfo.extraLoginTLVMap.keySet()) {
                byte[] bArr10 = wUserSigInfo.extraLoginTLVMap.get(num).get_buf();
                arrayList.add(bArr10);
                i38 += bArr10.length;
                util.LOGI("Extra Tlv from user\uff1a0x" + num);
            }
            int size = arrayList.size();
            byte[] bArr11 = new byte[i38];
            int i39 = 0;
            for (int i46 = 0; i46 < size; i46++) {
                byte[] bArr12 = (byte[]) arrayList.get(i46);
                System.arraycopy(bArr12, 0, bArr11, i39, bArr12.length);
                i39 += bArr12.length;
            }
            util.LOGI(stringBuffer.toString(), "");
            int i47 = i26;
            async_context async_contextVar = b16;
            a(8001, this.f422914j, this.f422910f, this.f422917m.f422957d, 0, 2, i37, 0, a(bArr11, this.f422915k, size));
            a16 = a(String.valueOf(this.f422917m.f422957d), false, wUserSigInfo);
            if (a16 != 0) {
                break;
            }
            a16 = d();
            util.LOGI("retry num:" + i47 + " ret:" + a16, "" + this.f422917m.f422957d);
            if (a16 != 180) {
                break;
            }
            i26 = i47 + 1;
            if (i47 >= 1) {
                break;
            }
            b16 = async_contextVar;
            i19 = i37;
        }
        return a16;
    }

    @Override // oicq.wlogin_sdk.request.oicq_request
    public int c(byte[] bArr, int i3, int i16) {
        String str;
        if (this.f422901v == 2) {
            StringBuffer stringBuffer = new StringBuffer("request_checksms");
            stringBuffer.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
            stringBuffer.append("get_response_body");
            if (i16 < 5) {
                stringBuffer.append(",len < 5");
                util.LOGI(stringBuffer.toString(), "");
                return -1009;
            }
            async_context b16 = u.b(this.f422917m.f422959f);
            int b17 = b(bArr, i3 + 2);
            stringBuffer.append(",ret=");
            stringBuffer.append(b17);
            int i17 = i3 + 5;
            tlv_t113 tlv_t113Var = new tlv_t113();
            int i18 = tlv_t113Var.get_tlv(bArr, i17, (this.f422907c - i17) - 1);
            stringBuffer.append(",ret113=");
            stringBuffer.append(i18);
            if (i18 >= 0) {
                this.f422917m.f422957d = tlv_t113Var.get_uin();
                b16._uin = this.f422917m.f422957d;
                stringBuffer.append(",ret113 uin=");
                stringBuffer.append(this.f422917m.f422957d);
            }
            tlv_t104 tlv_t104Var = new tlv_t104();
            int i19 = tlv_t104Var.get_tlv(bArr, i17, (this.f422907c - i17) - 1);
            stringBuffer.append(",ret104=");
            stringBuffer.append(i19);
            if (i19 >= 0) {
                b16.set_t104(tlv_t104Var);
            }
            if (b17 != 0) {
                b(bArr, i17, (this.f422907c - i17) - 1);
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
            }
            util.LOGI(stringBuffer.toString(), "");
            return b17;
        }
        util.LOGI("request_checksms" + util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV + " super get_response_body", "");
        return super.c(bArr, i3, i16);
    }
}
