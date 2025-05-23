package oicq.wlogin_sdk.request;

import com.tencent.mobileqq.qsec.qsecurity.QSec;
import java.util.List;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t109;
import oicq.wlogin_sdk.tlv_type.tlv_t10a;
import oicq.wlogin_sdk.tlv_type.tlv_t112;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t124;
import oicq.wlogin_sdk.tlv_type.tlv_t128;
import oicq.wlogin_sdk.tlv_type.tlv_t141;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t143;
import oicq.wlogin_sdk.tlv_type.tlv_t144;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t147;
import oicq.wlogin_sdk.tlv_type.tlv_t154;
import oicq.wlogin_sdk.tlv_type.tlv_t16e;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tlv_type.tlv_t177;
import oicq.wlogin_sdk.tlv_type.tlv_t18;
import oicq.wlogin_sdk.tlv_type.tlv_t187;
import oicq.wlogin_sdk.tlv_type.tlv_t188;
import oicq.wlogin_sdk.tlv_type.tlv_t194;
import oicq.wlogin_sdk.tlv_type.tlv_t201;
import oicq.wlogin_sdk.tlv_type.tlv_t202;
import oicq.wlogin_sdk.tlv_type.tlv_t511;
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tlv_type.tlv_t553;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class l extends oicq_request {
    public l(u uVar) {
        this.f422914j = 2064;
        this.f422915k = 10;
        this.f422916l = "wtlogin.exchange_emp";
        this.f422917m = uVar;
        uVar.f422964k = 0;
        this.f422905a = uVar.g();
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x05cd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x058f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(long j3, long j16, long j17, int i3, byte[] bArr, int i16, int i17, long[] jArr, byte[] bArr2, WUserSigInfo wUserSigInfo) {
        List<String> list;
        int i18;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        byte[] bArr7;
        byte[] bArr8;
        byte[] bArr9;
        byte[] bArr10;
        byte[] bArr11;
        byte[] bArr12;
        byte[] bArr13;
        byte[] bArr14;
        int i19;
        byte[] bArr15;
        byte[] bArr16;
        byte[] bArr17;
        byte[] bArr18;
        byte[] bArr19;
        byte[] bArr20;
        byte[] bArr21;
        String str;
        byte[] bArr22;
        boolean z16;
        byte[] bArr23;
        int i26;
        int i27;
        int a16;
        String str2;
        l lVar = this;
        WUserSigInfo wUserSigInfo2 = wUserSigInfo;
        StringBuilder sb5 = new StringBuilder();
        String str3 = "";
        sb5.append("");
        sb5.append(j3);
        util.LOGI("start request_change_sig", sb5.toString());
        int i28 = u.f422953z;
        int i29 = i3 & (-33554433);
        u.b(lVar.f422917m.f422959f)._main_sigmap = i29;
        int i36 = 0;
        while (true) {
            int i37 = lVar.f422914j;
            int i38 = lVar.f422910f;
            byte[] bArr24 = u.f422924a0;
            List<String> list2 = wUserSigInfo2._domains;
            int i39 = lVar.f422915k;
            tlv_t100 tlv_t100Var = new tlv_t100();
            tlv_t10a tlv_t10aVar = new tlv_t10a();
            tlv_t116 tlv_t116Var = new tlv_t116();
            String str4 = str3;
            tlv_t108 tlv_t108Var = new tlv_t108();
            tlv_t109 tlv_t109Var = new tlv_t109();
            tlv_t52d tlv_t52dVar = new tlv_t52d();
            tlv_t124 tlv_t124Var = new tlv_t124();
            tlv_t128 tlv_t128Var = new tlv_t128();
            tlv_t143 tlv_t143Var = new tlv_t143();
            tlv_t112 tlv_t112Var = new tlv_t112();
            tlv_t144 tlv_t144Var = new tlv_t144();
            int i46 = i36;
            tlv_t145 tlv_t145Var = new tlv_t145();
            tlv_t147 tlv_t147Var = new tlv_t147();
            tlv_t142 tlv_t142Var = new tlv_t142();
            tlv_t154 tlv_t154Var = new tlv_t154();
            tlv_t18 tlv_t18Var = new tlv_t18();
            tlv_t141 tlv_t141Var = new tlv_t141();
            tlv_t8 tlv_t8Var = new tlv_t8();
            tlv_t511 tlv_t511Var = new tlv_t511();
            tlv_t16e tlv_t16eVar = new tlv_t16e();
            tlv_t172 tlv_t172Var = new tlv_t172();
            tlv_t177 tlv_t177Var = new tlv_t177();
            tlv_t187 tlv_t187Var = new tlv_t187();
            tlv_t188 tlv_t188Var = new tlv_t188();
            tlv_t194 tlv_t194Var = new tlv_t194();
            tlv_t201 tlv_t201Var = new tlv_t201();
            tlv_t202 tlv_t202Var = new tlv_t202();
            tlv_t544 tlv_t544Var = new tlv_t544();
            tlv_t553 tlv_t553Var = new tlv_t553();
            byte[] bArr25 = tlv_t100Var.get_tlv_100(j16, j17, i28, i29);
            byte[] bArr26 = tlv_t10aVar.get_tlv_10a(bArr);
            byte[] bArr27 = tlv_t116Var.get_tlv_116(i16, i17, jArr);
            byte[] bArr28 = tlv_t145Var.get_tlv_145(u.D);
            byte[] bArr29 = tlv_t142Var.get_tlv_142(u.G);
            byte[] bArr30 = tlv_t154Var.get_tlv_154(lVar.f422917m.f422960g);
            int i47 = i29;
            byte[] bArr31 = tlv_t18Var.get_tlv_18(j16, i28, j3, 0);
            byte[] bArr32 = tlv_t141Var.get_tlv_141(oicq.wlogin_sdk.utils.b.d(lVar.f422905a), u.F, u.H);
            byte[] bArr33 = tlv_t8Var.get_tlv_8(0, u.f422951x, 0);
            byte[] bArr34 = tlv_t147Var.get_tlv_147(j16, u.I, u.J);
            byte[] bArr35 = tlv_t177Var.get_tlv_177(util.BUILD_TIME, util.SDK_VERSION);
            byte[] bArr36 = new byte[0];
            byte[] bArr37 = new byte[0];
            byte[] bArr38 = new byte[0];
            byte[] bArr39 = new byte[0];
            byte[] bArr40 = new byte[0];
            byte[] bArr41 = new byte[0];
            byte[] bArr42 = new byte[0];
            byte[] bArr43 = new byte[0];
            byte[] bArr44 = new byte[0];
            byte[] bArr45 = new byte[0];
            if (bArr24 == null || bArr24.length <= 0) {
                list = list2;
                i18 = 10;
            } else {
                bArr45 = tlv_t108Var.get_tlv_108(bArr24);
                list = list2;
                i18 = 11;
            }
            if (list == null || list.size() <= 0) {
                bArr3 = bArr38;
            } else {
                bArr3 = tlv_t511Var.get_tlv_511(list);
                i18++;
            }
            byte[] bArr46 = lVar.f422917m.f422968o;
            if (bArr46 == null || bArr46.length <= 0) {
                bArr4 = bArr39;
            } else {
                bArr4 = tlv_t172Var.get_tlv_172(bArr46);
                i18++;
            }
            byte[] bArr47 = u.N;
            if (bArr47 == null || bArr47.length <= 0) {
                bArr5 = bArr40;
            } else {
                bArr5 = tlv_t187Var.get_tlv_187(bArr47);
                i18++;
            }
            if (oicq.wlogin_sdk.utils.a.a(u.f422949w) == null || oicq.wlogin_sdk.utils.a.a(u.f422949w).length <= 0) {
                bArr6 = bArr5;
                bArr7 = bArr41;
            } else {
                bArr6 = bArr5;
                bArr7 = tlv_t188Var.get_tlv_188(oicq.wlogin_sdk.utils.a.a(u.f422949w));
                i18++;
            }
            byte[] bArr48 = u.M;
            byte[] bArr49 = bArr7;
            if (bArr48 == null || bArr48.length <= 0) {
                bArr8 = bArr42;
            } else {
                bArr8 = tlv_t194Var.get_tlv_194(bArr48);
                i18++;
            }
            byte[] bArr50 = j.f422897w;
            if (bArr50 != null) {
                bArr12 = bArr8;
                if (bArr50.length > 0) {
                    bArr10 = bArr4;
                    bArr9 = bArr34;
                    bArr11 = bArr3;
                    bArr13 = tlv_t201Var.get_tlv_201(bArr50, j.f422898x, "qq".getBytes(), j.f422899y);
                    i18++;
                    bArr14 = u.Q;
                    if (bArr14 != null || bArr14.length <= 0) {
                        i19 = i18;
                        bArr15 = bArr44;
                    } else {
                        bArr15 = tlv_t202Var.get_tlv_202(bArr14, u.R);
                        i19 = i18 + 1;
                    }
                    byte[] bArr51 = tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.utils.a.a(u.f422949w));
                    byte[] bArr52 = tlv_t52dVar.get_tlv_52d(lVar.f422905a);
                    bArr16 = bArr15;
                    byte[] bArr53 = tlv_t124Var.get_tlv_124(util.get_os_type(), util.get_os_version(), u.F, oicq.wlogin_sdk.utils.b.d(lVar.f422905a), new byte[0], u.H);
                    byte[] b16 = oicq.wlogin_sdk.utils.b.b(u.f422949w);
                    bArr17 = tlv_t144Var.get_tlv_144(bArr51, bArr52, bArr53, tlv_t128Var.get_tlv_128(u.S, u.T, u.U, u.X, b16, u.D, u.O), tlv_t16eVar.get_tlv_16e(b16), lVar.f422917m.f422954a);
                    byte[] bytes = util.SDK_VERSION.getBytes();
                    byte[] bArr54 = new byte[u.D.length + 10 + 2 + bytes.length + 4];
                    bArr18 = bArr13;
                    bArr19 = bArr45;
                    util.int64_to_buf(bArr54, 0, (int) j3);
                    util.int16_to_buf(bArr54, 4, u.D.length);
                    byte[] bArr55 = u.D;
                    System.arraycopy(bArr55, 0, bArr54, 6, bArr55.length);
                    int length = u.D.length + 6;
                    util.int16_to_buf(bArr54, length, bytes.length);
                    int i48 = length + 2;
                    System.arraycopy(bytes, 0, bArr54, i48, bytes.length);
                    util.int32_to_buf(bArr54, i48 + bytes.length, lVar.f422915k);
                    bArr20 = tlv_t544Var.get_tlv_544(String.valueOf(j3), "810_a", bArr54);
                    bArr21 = tlv_t553Var.get_tlv_t553(QSec.getInstance().getFeKitAttach(lVar.f422905a, String.valueOf(j3), "0x810", "0xa"));
                    if (bArr2 != null || bArr2.length <= 0) {
                        byte[] bArr56 = bArr12;
                        byte[] bArr57 = bArr6;
                        byte[] bArr58 = bArr9;
                        byte[] bArr59 = bArr11;
                        byte[] bArr60 = bArr10;
                        int i49 = i19 + 2;
                        str = this.f422917m.f422958e;
                        if (str != null || util.check_uin_account(str).booleanValue()) {
                            bArr22 = bArr37;
                        } else {
                            bArr22 = tlv_t112Var.get_tlv_112(this.f422917m.f422958e.getBytes());
                            i49++;
                        }
                        byte[] bArr61 = bArr22;
                        int length2 = bArr25.length + bArr26.length + bArr27.length + bArr19.length + bArr17.length + 0 + bArr22.length + bArr28.length + bArr29.length + bArr30.length + bArr31.length + bArr32.length + bArr33.length + bArr59.length + bArr58.length + bArr60.length + bArr35.length + bArr57.length + bArr49.length + bArr56.length + bArr18.length + bArr16.length;
                        if (bArr20 != null) {
                            length2 += bArr20.length;
                            i49++;
                        }
                        if (bArr21 != null) {
                            length2 += bArr21.length;
                            i49++;
                        }
                        byte[] bArr62 = new byte[length2];
                        int i56 = i49;
                        z16 = false;
                        System.arraycopy(bArr25, 0, bArr62, 0, bArr25.length);
                        int length3 = bArr25.length + 0;
                        System.arraycopy(bArr26, 0, bArr62, length3, bArr26.length);
                        int length4 = length3 + bArr26.length;
                        System.arraycopy(bArr27, 0, bArr62, length4, bArr27.length);
                        int length5 = length4 + bArr27.length;
                        System.arraycopy(bArr19, 0, bArr62, length5, bArr19.length);
                        int length6 = length5 + bArr19.length;
                        System.arraycopy(bArr17, 0, bArr62, length6, bArr17.length);
                        int length7 = length6 + bArr17.length;
                        System.arraycopy(bArr36, 0, bArr62, length7, 0);
                        int i57 = length7 + 0;
                        System.arraycopy(bArr61, 0, bArr62, i57, bArr61.length);
                        int length8 = i57 + bArr61.length;
                        System.arraycopy(bArr28, 0, bArr62, length8, bArr28.length);
                        int length9 = length8 + bArr28.length;
                        System.arraycopy(bArr29, 0, bArr62, length9, bArr29.length);
                        int length10 = length9 + bArr29.length;
                        System.arraycopy(bArr30, 0, bArr62, length10, bArr30.length);
                        int length11 = length10 + bArr30.length;
                        System.arraycopy(bArr31, 0, bArr62, length11, bArr31.length);
                        int length12 = length11 + bArr31.length;
                        System.arraycopy(bArr32, 0, bArr62, length12, bArr32.length);
                        int length13 = length12 + bArr32.length;
                        System.arraycopy(bArr33, 0, bArr62, length13, bArr33.length);
                        int length14 = length13 + bArr33.length;
                        System.arraycopy(bArr59, 0, bArr62, length14, bArr59.length);
                        int length15 = length14 + bArr59.length;
                        System.arraycopy(bArr58, 0, bArr62, length15, bArr58.length);
                        int length16 = length15 + bArr58.length;
                        System.arraycopy(bArr60, 0, bArr62, length16, bArr60.length);
                        int length17 = length16 + bArr60.length;
                        System.arraycopy(bArr35, 0, bArr62, length17, bArr35.length);
                        int length18 = length17 + bArr35.length;
                        System.arraycopy(bArr57, 0, bArr62, length18, bArr57.length);
                        int length19 = length18 + bArr57.length;
                        System.arraycopy(bArr49, 0, bArr62, length19, bArr49.length);
                        int length20 = length19 + bArr49.length;
                        System.arraycopy(bArr56, 0, bArr62, length20, bArr56.length);
                        int length21 = length20 + bArr56.length;
                        System.arraycopy(bArr18, 0, bArr62, length21, bArr18.length);
                        int length22 = length21 + bArr18.length;
                        System.arraycopy(bArr16, 0, bArr62, length22, bArr16.length);
                        int length23 = length22 + bArr16.length;
                        if (bArr20 != null) {
                            System.arraycopy(bArr20, 0, bArr62, length23, bArr20.length);
                            length23 += bArr20.length;
                        }
                        if (bArr21 != null) {
                            System.arraycopy(bArr21, 0, bArr62, length23, bArr21.length);
                        }
                        lVar = this;
                        bArr23 = bArr62;
                        i26 = i56;
                        i27 = i39;
                    } else {
                        byte[] bArr63 = tlv_t143Var.get_tlv_143(bArr2);
                        int i58 = i19 + 1 + 1;
                        int length24 = bArr25.length + bArr26.length + bArr27.length + bArr19.length + bArr17.length + bArr63.length + bArr29.length + bArr30.length + bArr31.length + bArr32.length + bArr33.length + bArr11.length + bArr9.length + bArr10.length + bArr35.length + bArr6.length + bArr49.length + bArr12.length + bArr18.length + bArr16.length;
                        if (bArr20 != null) {
                            length24 += bArr20.length;
                            i58++;
                        }
                        if (bArr21 != null) {
                            length24 += bArr21.length;
                            i58++;
                        }
                        bArr23 = new byte[length24];
                        int i59 = i58;
                        System.arraycopy(bArr25, 0, bArr23, 0, bArr25.length);
                        int length25 = bArr25.length + 0;
                        System.arraycopy(bArr26, 0, bArr23, length25, bArr26.length);
                        int length26 = length25 + bArr26.length;
                        System.arraycopy(bArr27, 0, bArr23, length26, bArr27.length);
                        int length27 = length26 + bArr27.length;
                        System.arraycopy(bArr19, 0, bArr23, length27, bArr19.length);
                        int length28 = length27 + bArr19.length;
                        System.arraycopy(bArr17, 0, bArr23, length28, bArr17.length);
                        int length29 = length28 + bArr17.length;
                        System.arraycopy(bArr63, 0, bArr23, length29, bArr63.length);
                        int length30 = length29 + bArr63.length;
                        System.arraycopy(bArr29, 0, bArr23, length30, bArr29.length);
                        int length31 = length30 + bArr29.length;
                        System.arraycopy(bArr30, 0, bArr23, length31, bArr30.length);
                        int length32 = length31 + bArr30.length;
                        System.arraycopy(bArr31, 0, bArr23, length32, bArr31.length);
                        int length33 = length32 + bArr31.length;
                        System.arraycopy(bArr32, 0, bArr23, length33, bArr32.length);
                        int length34 = length33 + bArr32.length;
                        System.arraycopy(bArr33, 0, bArr23, length34, bArr33.length);
                        int length35 = length34 + bArr33.length;
                        byte[] bArr64 = bArr11;
                        System.arraycopy(bArr64, 0, bArr23, length35, bArr64.length);
                        int length36 = length35 + bArr64.length;
                        byte[] bArr65 = bArr9;
                        System.arraycopy(bArr65, 0, bArr23, length36, bArr65.length);
                        int length37 = length36 + bArr65.length;
                        byte[] bArr66 = bArr10;
                        System.arraycopy(bArr66, 0, bArr23, length37, bArr66.length);
                        int length38 = length37 + bArr66.length;
                        System.arraycopy(bArr35, 0, bArr23, length38, bArr35.length);
                        int length39 = length38 + bArr35.length;
                        byte[] bArr67 = bArr6;
                        System.arraycopy(bArr67, 0, bArr23, length39, bArr67.length);
                        int length40 = length39 + bArr67.length;
                        System.arraycopy(bArr49, 0, bArr23, length40, bArr49.length);
                        int length41 = length40 + bArr49.length;
                        byte[] bArr68 = bArr12;
                        System.arraycopy(bArr68, 0, bArr23, length41, bArr68.length);
                        int length42 = length41 + bArr68.length;
                        System.arraycopy(bArr18, 0, bArr23, length42, bArr18.length);
                        int length43 = length42 + bArr18.length;
                        System.arraycopy(bArr16, 0, bArr23, length43, bArr16.length);
                        int length44 = length43 + bArr16.length;
                        if (bArr20 != null) {
                            System.arraycopy(bArr20, 0, bArr23, length44, bArr20.length);
                            length44 += bArr20.length;
                        }
                        if (bArr21 != null) {
                            System.arraycopy(bArr21, 0, bArr23, length44, bArr21.length);
                        }
                        z16 = false;
                        lVar = this;
                        i26 = i59;
                        i27 = 11;
                    }
                    a(8001, i37, i38, j3, 0, 2, i28, 0, lVar.a(bArr23, i27, i26));
                    a16 = lVar.a(String.valueOf(lVar.f422917m.f422957d), z16, wUserSigInfo);
                    if (a16 == 0) {
                        str2 = str4;
                        break;
                    }
                    a16 = d();
                    StringBuilder sb6 = new StringBuilder();
                    str2 = str4;
                    sb6.append(str2);
                    sb6.append(j3);
                    util.LOGI("retry num:" + i46 + " ret:" + a16, sb6.toString());
                    if (a16 != 180) {
                        break;
                    }
                    int i65 = i46 + 1;
                    if (i46 >= 1) {
                        break;
                    }
                    wUserSigInfo2 = wUserSigInfo;
                    i36 = i65;
                    str3 = str2;
                    i29 = i47;
                } else {
                    bArr9 = bArr34;
                    bArr10 = bArr4;
                    bArr11 = bArr3;
                }
            } else {
                bArr9 = bArr34;
                bArr10 = bArr4;
                bArr11 = bArr3;
                bArr12 = bArr8;
            }
            bArr13 = bArr43;
            bArr14 = u.Q;
            if (bArr14 != null) {
            }
            i19 = i18;
            bArr15 = bArr44;
            byte[] bArr512 = tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.utils.a.a(u.f422949w));
            byte[] bArr522 = tlv_t52dVar.get_tlv_52d(lVar.f422905a);
            bArr16 = bArr15;
            byte[] bArr532 = tlv_t124Var.get_tlv_124(util.get_os_type(), util.get_os_version(), u.F, oicq.wlogin_sdk.utils.b.d(lVar.f422905a), new byte[0], u.H);
            byte[] b162 = oicq.wlogin_sdk.utils.b.b(u.f422949w);
            bArr17 = tlv_t144Var.get_tlv_144(bArr512, bArr522, bArr532, tlv_t128Var.get_tlv_128(u.S, u.T, u.U, u.X, b162, u.D, u.O), tlv_t16eVar.get_tlv_16e(b162), lVar.f422917m.f422954a);
            byte[] bytes2 = util.SDK_VERSION.getBytes();
            byte[] bArr542 = new byte[u.D.length + 10 + 2 + bytes2.length + 4];
            bArr18 = bArr13;
            bArr19 = bArr45;
            util.int64_to_buf(bArr542, 0, (int) j3);
            util.int16_to_buf(bArr542, 4, u.D.length);
            byte[] bArr552 = u.D;
            System.arraycopy(bArr552, 0, bArr542, 6, bArr552.length);
            int length45 = u.D.length + 6;
            util.int16_to_buf(bArr542, length45, bytes2.length);
            int i482 = length45 + 2;
            System.arraycopy(bytes2, 0, bArr542, i482, bytes2.length);
            util.int32_to_buf(bArr542, i482 + bytes2.length, lVar.f422915k);
            bArr20 = tlv_t544Var.get_tlv_544(String.valueOf(j3), "810_a", bArr542);
            bArr21 = tlv_t553Var.get_tlv_t553(QSec.getInstance().getFeKitAttach(lVar.f422905a, String.valueOf(j3), "0x810", "0xa"));
            if (bArr2 != null) {
            }
            byte[] bArr562 = bArr12;
            byte[] bArr572 = bArr6;
            byte[] bArr582 = bArr9;
            byte[] bArr592 = bArr11;
            byte[] bArr602 = bArr10;
            int i492 = i19 + 2;
            str = this.f422917m.f422958e;
            if (str != null) {
            }
            bArr22 = bArr37;
            byte[] bArr612 = bArr22;
            int length210 = bArr25.length + bArr26.length + bArr27.length + bArr19.length + bArr17.length + 0 + bArr22.length + bArr28.length + bArr29.length + bArr30.length + bArr31.length + bArr32.length + bArr33.length + bArr592.length + bArr582.length + bArr602.length + bArr35.length + bArr572.length + bArr49.length + bArr562.length + bArr18.length + bArr16.length;
            if (bArr20 != null) {
            }
            if (bArr21 != null) {
            }
            byte[] bArr622 = new byte[length210];
            int i562 = i492;
            z16 = false;
            System.arraycopy(bArr25, 0, bArr622, 0, bArr25.length);
            int length310 = bArr25.length + 0;
            System.arraycopy(bArr26, 0, bArr622, length310, bArr26.length);
            int length46 = length310 + bArr26.length;
            System.arraycopy(bArr27, 0, bArr622, length46, bArr27.length);
            int length52 = length46 + bArr27.length;
            System.arraycopy(bArr19, 0, bArr622, length52, bArr19.length);
            int length62 = length52 + bArr19.length;
            System.arraycopy(bArr17, 0, bArr622, length62, bArr17.length);
            int length72 = length62 + bArr17.length;
            System.arraycopy(bArr36, 0, bArr622, length72, 0);
            int i572 = length72 + 0;
            System.arraycopy(bArr612, 0, bArr622, i572, bArr612.length);
            int length82 = i572 + bArr612.length;
            System.arraycopy(bArr28, 0, bArr622, length82, bArr28.length);
            int length92 = length82 + bArr28.length;
            System.arraycopy(bArr29, 0, bArr622, length92, bArr29.length);
            int length102 = length92 + bArr29.length;
            System.arraycopy(bArr30, 0, bArr622, length102, bArr30.length);
            int length112 = length102 + bArr30.length;
            System.arraycopy(bArr31, 0, bArr622, length112, bArr31.length);
            int length122 = length112 + bArr31.length;
            System.arraycopy(bArr32, 0, bArr622, length122, bArr32.length);
            int length132 = length122 + bArr32.length;
            System.arraycopy(bArr33, 0, bArr622, length132, bArr33.length);
            int length142 = length132 + bArr33.length;
            System.arraycopy(bArr592, 0, bArr622, length142, bArr592.length);
            int length152 = length142 + bArr592.length;
            System.arraycopy(bArr582, 0, bArr622, length152, bArr582.length);
            int length162 = length152 + bArr582.length;
            System.arraycopy(bArr602, 0, bArr622, length162, bArr602.length);
            int length172 = length162 + bArr602.length;
            System.arraycopy(bArr35, 0, bArr622, length172, bArr35.length);
            int length182 = length172 + bArr35.length;
            System.arraycopy(bArr572, 0, bArr622, length182, bArr572.length);
            int length192 = length182 + bArr572.length;
            System.arraycopy(bArr49, 0, bArr622, length192, bArr49.length);
            int length202 = length192 + bArr49.length;
            System.arraycopy(bArr562, 0, bArr622, length202, bArr562.length);
            int length212 = length202 + bArr562.length;
            System.arraycopy(bArr18, 0, bArr622, length212, bArr18.length);
            int length222 = length212 + bArr18.length;
            System.arraycopy(bArr16, 0, bArr622, length222, bArr16.length);
            int length232 = length222 + bArr16.length;
            if (bArr20 != null) {
            }
            if (bArr21 != null) {
            }
            lVar = this;
            bArr23 = bArr622;
            i26 = i562;
            i27 = i39;
            a(8001, i37, i38, j3, 0, 2, i28, 0, lVar.a(bArr23, i27, i26));
            a16 = lVar.a(String.valueOf(lVar.f422917m.f422957d), z16, wUserSigInfo);
            if (a16 == 0) {
            }
        }
        util.LOGI("end request_change_sig for user ret " + a16, str2 + j3);
        return a16;
    }
}
