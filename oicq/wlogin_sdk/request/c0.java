package oicq.wlogin_sdk.request;

import android.content.Context;
import android.util.Log;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.loginsecsdk.ProtocolDet;
import com.tencent.mobileqq.qsec.qsecurity.QSec;
import java.util.Iterator;
import java.util.List;
import oicq.wlogin_sdk.report.a;
import oicq.wlogin_sdk.request.oicq_request;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t1;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t106;
import oicq.wlogin_sdk.tlv_type.tlv_t107;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t109;
import oicq.wlogin_sdk.tlv_type.tlv_t112;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t124;
import oicq.wlogin_sdk.tlv_type.tlv_t128;
import oicq.wlogin_sdk.tlv_type.tlv_t141;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t144;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t147;
import oicq.wlogin_sdk.tlv_type.tlv_t154;
import oicq.wlogin_sdk.tlv_type.tlv_t166;
import oicq.wlogin_sdk.tlv_type.tlv_t16a;
import oicq.wlogin_sdk.tlv_type.tlv_t16e;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tlv_type.tlv_t177;
import oicq.wlogin_sdk.tlv_type.tlv_t18;
import oicq.wlogin_sdk.tlv_type.tlv_t187;
import oicq.wlogin_sdk.tlv_type.tlv_t188;
import oicq.wlogin_sdk.tlv_type.tlv_t194;
import oicq.wlogin_sdk.tlv_type.tlv_t201;
import oicq.wlogin_sdk.tlv_type.tlv_t202;
import oicq.wlogin_sdk.tlv_type.tlv_t400;
import oicq.wlogin_sdk.tlv_type.tlv_t511;
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tlv_type.tlv_t545;
import oicq.wlogin_sdk.tlv_type.tlv_t553;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c0 extends oicq_request {
    public c0(u uVar, Context context) {
        this.f422914j = 2064;
        this.f422915k = 15;
        this.f422916l = "wtlogin.exchange_emp";
        this.f422917m = uVar;
        uVar.f422964k = 0;
        this.f422918n = oicq_request.EncryptionMethod.EM_ST;
        this.f422905a = context;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(56:6|(1:16)|17|(1:182)(1:21)|22|(1:24)(1:181)|25|(1:180)(1:29)|30|(1:179)(1:34)|35|(1:178)(1:39)|40|(1:177)(1:44)|45|(1:176)(1:49)|50|(1:175)(1:54)|55|(1:174)(1:59)|60|(1:173)(1:64)|65|(1:172)(1:69)|(1:171)(1:73)|(3:75|(2:77|(1:168)(2:81|(1:165)(29:87|88|89|90|91|92|(1:157)(4:96|97|98|99)|100|101|102|103|104|(1:106)|107|(1:111)|(1:113)|(1:115)|116|(2:117|(1:119)(1:120))|121|(1:123)|(1:125)|(1:127)|(1:131)|132|(2:135|133)|136|137|(1:148)(2:139|(1:147)(2:141|(1:144)(1:143))))))(1:169)|166)(1:170)|167|88|89|90|91|92|(1:94)|157|100|101|102|103|104|(0)|107|(2:109|111)|(0)|(0)|116|(3:117|(0)(0)|119)|121|(0)|(0)|(0)|(2:129|131)|132|(1:133)|136|137|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0690, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0691, code lost:
    
        r20 = r11;
        r11 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x069a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x069b, code lost:
    
        r11 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x06a1, code lost:
    
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x069e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x069f, code lost:
    
        r11 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0734  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x073c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0743  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0749  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0770 A[LOOP:1: B:117:0x0765->B:119:0x0770, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x07b1 A[EDGE_INSN: B:120:0x07b1->B:121:0x07b1 BREAK  A[LOOP:1: B:117:0x0765->B:119:0x0770], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0886  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0890  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x089a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x08a4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x08d7 A[LOOP:2: B:133:0x08d1->B:135:0x08d7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x094a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0987 A[EDGE_INSN: B:148:0x0987->B:145:0x0987 BREAK  A[LOOP:0: B:6:0x0034->B:143:0x09ac], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(long j3, long j16, int i3, byte[] bArr, byte[] bArr2, byte[] bArr3, int i16, int i17, long[] jArr, int i18, long j17, int i19, int i26, int i27, int i28, byte[] bArr4, long j18, WUserSigInfo wUserSigInfo) {
        int i29;
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
        byte[] bArr15;
        byte[] bArr16;
        byte[] bArr17;
        byte[] bArr18;
        String str;
        byte[] bArr19;
        List<String> list;
        byte[] bArr20;
        byte[] bArr21;
        byte[] bArr22;
        byte[] bArr23;
        String str2;
        byte[] bArr24;
        byte[] bArr25;
        byte[] bArr26;
        byte[] bArr27;
        byte[] bArr28;
        byte[] bArr29;
        byte[] bArr30;
        byte[] bArr31;
        byte[] bArr32;
        byte[] bArr33;
        byte[] bArr34;
        String str3;
        byte[] bArr35;
        byte[] bArr36;
        byte[] bArr37;
        byte[] bArr38;
        byte[] bArr39;
        byte[] bArr40;
        byte[] bArr41;
        byte[] bArr42;
        byte[] bArr43;
        byte[] bArr44;
        byte[] bArr45;
        byte[] bArr46;
        int i36;
        byte[] bArr47;
        byte[] bArr48;
        byte[] bArr49;
        byte[] bArr50;
        byte[] bArr51;
        byte[] bArr52;
        byte[] bArr53;
        byte[] bArr54;
        long j19;
        int length;
        byte[] bArr55;
        byte[] bArr56;
        WUserSigInfo wUserSigInfo2;
        Iterator<Integer> it;
        int i37;
        int i38;
        byte[] bArr57;
        byte[] bArr58;
        int length2;
        int a16;
        byte[] loginExtraData;
        byte[] bArr59;
        byte[] bArr60;
        byte[] bArr61;
        byte[] bArr62;
        c0 c0Var = this;
        long j26 = j16;
        int i39 = i16;
        long j27 = j18;
        WUserSigInfo wUserSigInfo3 = wUserSigInfo;
        StringBuilder sb5 = new StringBuilder();
        String str4 = "";
        sb5.append("");
        sb5.append(j26);
        util.LOGI("start request_tgtgt_nopicsig", sb5.toString());
        int i46 = u.f422953z;
        byte[] a17 = c0Var.a(bArr2);
        if (a17 == null) {
            return -1014;
        }
        int i47 = 0;
        while (true) {
            if (c0Var.f422918n == oicq_request.EncryptionMethod.EM_ST && ((bArr61 = c0Var.f422921q) == null || bArr61.length == 0 || (bArr62 = c0Var.f422920p) == null || bArr62.length == 0)) {
                c0Var.f422918n = oicq_request.EncryptionMethod.EM_ECDH;
                u.f422936m0.attr_api(2413503);
                util.LOGI("using wt st encrypt body but no st key", str4 + j26);
            }
            byte[] bArr63 = u.G;
            List<String> list2 = wUserSigInfo3._domains;
            int i48 = wUserSigInfo3._source_type;
            tlv_t18 tlv_t18Var = new tlv_t18();
            tlv_t1 tlv_t1Var = new tlv_t1();
            tlv_t106 tlv_t106Var = new tlv_t106();
            tlv_t116 tlv_t116Var = new tlv_t116();
            tlv_t100 tlv_t100Var = new tlv_t100();
            tlv_t107 tlv_t107Var = new tlv_t107();
            tlv_t108 tlv_t108Var = new tlv_t108();
            tlv_t109 tlv_t109Var = new tlv_t109();
            tlv_t52d tlv_t52dVar = new tlv_t52d();
            tlv_t124 tlv_t124Var = new tlv_t124();
            tlv_t128 tlv_t128Var = new tlv_t128();
            tlv_t142 tlv_t142Var = new tlv_t142();
            tlv_t112 tlv_t112Var = new tlv_t112();
            tlv_t144 tlv_t144Var = new tlv_t144();
            tlv_t145 tlv_t145Var = new tlv_t145();
            tlv_t147 tlv_t147Var = new tlv_t147();
            tlv_t166 tlv_t166Var = new tlv_t166();
            tlv_t16a tlv_t16aVar = new tlv_t16a();
            tlv_t141 tlv_t141Var = new tlv_t141();
            tlv_t8 tlv_t8Var = new tlv_t8();
            tlv_t154 tlv_t154Var = new tlv_t154();
            tlv_t511 tlv_t511Var = new tlv_t511();
            tlv_t16e tlv_t16eVar = new tlv_t16e();
            tlv_t172 tlv_t172Var = new tlv_t172();
            tlv_t177 tlv_t177Var = new tlv_t177();
            tlv_t400 tlv_t400Var = new tlv_t400();
            tlv_t187 tlv_t187Var = new tlv_t187();
            tlv_t188 tlv_t188Var = new tlv_t188();
            tlv_t194 tlv_t194Var = new tlv_t194();
            tlv_t201 tlv_t201Var = new tlv_t201();
            tlv_t202 tlv_t202Var = new tlv_t202();
            tlv_t tlv_tVar = new tlv_t(gdt_analysis_event.EVENT_MOTIVE_CLOSE);
            tlv_t tlv_tVar2 = new tlv_t(1313);
            int i49 = i47;
            tlv_t tlv_tVar3 = new tlv_t(1317);
            tlv_t545 tlv_t545Var = new tlv_t545();
            tlv_t544 tlv_t544Var = new tlv_t544();
            tlv_t553 tlv_t553Var = new tlv_t553();
            long currentTimeMillis = System.currentTimeMillis();
            WloginSigInfo d16 = c0Var.f422917m.d(j26, j27);
            String str5 = str4;
            byte[] bArr64 = a17;
            byte[] bArr65 = tlv_t18Var.get_tlv_18(j3, i46, j16, i3);
            byte[] bArr66 = tlv_t1Var.get_tlv_1(j26, bArr);
            tlv_t106Var.set_data(bArr64, bArr64.length);
            byte[] bArr67 = tlv_t106Var.get_buf();
            util.LOGD("req2 a1:", util.buf_to_string(bArr67));
            byte[] bArr68 = tlv_t100Var.get_tlv_100(j3, j17, i46, i18);
            byte[] bArr69 = tlv_t107Var.get_tlv_107(i19, i26, i27, i28);
            byte[] bArr70 = tlv_t116Var.get_tlv_116(i39, i17, jArr);
            byte[] bArr71 = tlv_t145Var.get_tlv_145(u.D);
            byte[] bArr72 = tlv_t154Var.get_tlv_154(c0Var.f422917m.f422960g);
            byte[] bArr73 = tlv_t141Var.get_tlv_141(oicq.wlogin_sdk.utils.b.d(c0Var.f422905a), u.F, u.H);
            byte[] bArr74 = tlv_t8Var.get_tlv_8(0, u.f422951x, 0);
            byte[] bArr75 = tlv_t147Var.get_tlv_147(j18, u.I, u.J);
            byte[] bArr76 = tlv_t177Var.get_tlv_177(util.BUILD_TIME, util.SDK_VERSION);
            byte[] bArr77 = new byte[0];
            byte[] bArr78 = new byte[0];
            byte[] bArr79 = new byte[0];
            byte[] bArr80 = new byte[0];
            byte[] bArr81 = new byte[0];
            byte[] bArr82 = new byte[0];
            byte[] bArr83 = new byte[0];
            byte[] bArr84 = new byte[0];
            byte[] bArr85 = new byte[0];
            byte[] bArr86 = new byte[0];
            byte[] bArr87 = new byte[0];
            byte[] bArr88 = new byte[0];
            byte[] bArr89 = new byte[0];
            if (bArr4 == null || bArr4.length <= 0) {
                i29 = 12;
                bArr5 = bArr77;
            } else {
                bArr5 = tlv_t108Var.get_tlv_108(bArr4);
                i29 = 13;
            }
            if ((i39 & 128) != 0) {
                bArr6 = bArr5;
                bArr7 = tlv_t166Var.get_tlv_166(u.A);
                i29++;
            } else {
                bArr6 = bArr5;
                bArr7 = bArr79;
            }
            byte[] bArr90 = c0Var.f422917m.f422968o;
            byte[] bArr91 = bArr7;
            if (bArr90 == null || bArr90.length <= 0) {
                bArr8 = bArr82;
            } else {
                bArr8 = tlv_t172Var.get_tlv_172(bArr90);
                i29++;
            }
            byte[] bArr92 = u.N;
            byte[] bArr93 = bArr8;
            if (bArr92 == null || bArr92.length <= 0) {
                bArr9 = bArr84;
            } else {
                bArr9 = tlv_t187Var.get_tlv_187(bArr92);
                i29++;
            }
            if (oicq.wlogin_sdk.utils.a.a(u.f422949w) == null || oicq.wlogin_sdk.utils.a.a(u.f422949w).length <= 0) {
                bArr10 = bArr9;
                bArr11 = bArr85;
            } else {
                bArr10 = bArr9;
                bArr11 = tlv_t188Var.get_tlv_188(oicq.wlogin_sdk.utils.a.a(u.f422949w));
                i29++;
            }
            byte[] bArr94 = u.M;
            byte[] bArr95 = bArr11;
            if (bArr94 == null || bArr94.length <= 0) {
                bArr12 = bArr86;
            } else {
                bArr12 = tlv_t194Var.get_tlv_194(bArr94);
                i29++;
            }
            byte[] bArr96 = j.f422897w;
            byte[] bArr97 = bArr12;
            if (bArr96 == null || bArr96.length <= 0) {
                bArr13 = bArr73;
                bArr14 = bArr75;
                bArr15 = bArr68;
                bArr16 = bArr87;
            } else {
                bArr13 = bArr73;
                bArr14 = bArr75;
                bArr15 = bArr68;
                i29++;
                bArr16 = tlv_t201Var.get_tlv_201(bArr96, j.f422898x, "qq".getBytes(), j.f422899y);
            }
            byte[] bArr98 = u.Q;
            if (bArr98 == null || bArr98.length <= 0) {
                bArr17 = bArr88;
            } else {
                i29++;
                bArr17 = tlv_t202Var.get_tlv_202(bArr98, u.R);
            }
            byte[] c16 = oicq.wlogin_sdk.utils.b.c(u.f422949w);
            if (c16 == null || c16.length <= 0) {
                bArr18 = bArr89;
            } else {
                i29++;
                bArr18 = tlv_t545Var.get_tlv_545(c16);
            }
            byte[] bArr99 = tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.utils.a.a(u.f422949w));
            byte[] bArr100 = tlv_t52dVar.get_tlv_52d(c0Var.f422905a);
            byte[] bArr101 = tlv_t124Var.get_tlv_124(util.get_os_type(), util.get_os_version(), u.F, oicq.wlogin_sdk.utils.b.d(c0Var.f422905a), new byte[0], u.H);
            byte[] b16 = oicq.wlogin_sdk.utils.b.b(u.f422949w);
            byte[] bArr102 = tlv_t128Var.get_tlv_128(u.S, u.T, u.U, u.X, b16, u.D, u.O);
            byte[] bArr103 = tlv_t16eVar.get_tlv_16e(b16);
            util.LOGI("nopicsig tlv16e", str5);
            byte[] bArr104 = bArr17;
            byte[] bArr105 = bArr18;
            byte[] bArr106 = tlv_t144Var.get_tlv_144(bArr99, bArr100, bArr101, bArr102, bArr103, u.b(c0Var.f422917m.f422959f)._tgtgt_key);
            byte[] bArr107 = tlv_t142Var.get_tlv_142(bArr63);
            int i56 = i29 + 1 + 1;
            String str6 = c0Var.f422917m.f422958e;
            if (str6 == null || util.check_uin_account(str6).booleanValue()) {
                str = util.SDK_VERSION;
                bArr19 = bArr78;
            } else {
                byte[] bArr108 = tlv_t112Var.get_tlv_112(c0Var.f422917m.f422958e.getBytes());
                i56++;
                util.LOGI("nopicsig tlv112", str5);
                bArr19 = bArr108;
                str = util.SDK_VERSION;
            }
            String str7 = str;
            if (bArr3 == null || bArr3.length <= 0) {
                list = list2;
                bArr20 = bArr80;
            } else {
                byte[] bArr109 = tlv_t16aVar.get_tlv_16a(bArr3);
                i56++;
                util.LOGI("nopicsig tlv16a", str5);
                bArr20 = bArr109;
                list = list2;
            }
            if (list == null || list.size() <= 0) {
                bArr21 = bArr107;
                bArr22 = bArr81;
            } else {
                bArr21 = bArr107;
                byte[] bArr110 = tlv_t511Var.get_tlv_511(list);
                i56++;
                util.LOGI("nopicsig tlv511", str5);
                bArr22 = bArr110;
            }
            if (d16 != null) {
                byte[] bArr111 = d16._G;
                if (bArr111 != null) {
                    byte[] bArr112 = bArr22;
                    if (bArr111.length <= 0 || (bArr59 = d16._dpwd) == null) {
                        bArr24 = bArr106;
                        bArr25 = bArr19;
                        bArr26 = bArr16;
                        bArr27 = bArr76;
                        bArr28 = bArr67;
                        bArr29 = bArr69;
                        bArr30 = bArr66;
                        bArr31 = bArr70;
                        bArr32 = bArr71;
                        bArr33 = bArr72;
                        bArr34 = bArr74;
                        str3 = str7;
                        bArr35 = bArr6;
                        bArr36 = bArr104;
                        bArr37 = bArr105;
                        bArr38 = bArr21;
                        bArr23 = bArr112;
                    } else if (bArr59.length <= 0 || (bArr60 = d16._randseed) == null || bArr60.length <= 0) {
                        bArr25 = bArr19;
                        bArr26 = bArr16;
                        bArr27 = bArr76;
                        bArr28 = bArr67;
                        bArr29 = bArr69;
                        bArr30 = bArr66;
                        bArr31 = bArr70;
                        bArr32 = bArr71;
                        bArr33 = bArr72;
                        bArr34 = bArr74;
                        str3 = str7;
                        bArr35 = bArr6;
                        bArr36 = bArr104;
                        bArr37 = bArr105;
                        bArr38 = bArr21;
                        bArr23 = bArr112;
                        bArr24 = bArr106;
                    } else {
                        bArr38 = bArr21;
                        bArr23 = bArr112;
                        bArr32 = bArr71;
                        bArr33 = bArr72;
                        bArr34 = bArr74;
                        bArr35 = bArr6;
                        bArr39 = bArr91;
                        bArr40 = bArr93;
                        bArr41 = bArr10;
                        bArr42 = bArr95;
                        bArr43 = bArr97;
                        bArr31 = bArr70;
                        bArr25 = bArr19;
                        bArr36 = bArr104;
                        bArr37 = bArr105;
                        bArr24 = bArr106;
                        bArr44 = bArr13;
                        bArr45 = bArr14;
                        bArr26 = bArr16;
                        bArr46 = bArr15;
                        bArr48 = bArr64;
                        bArr28 = bArr67;
                        i36 = 0;
                        bArr47 = bArr65;
                        bArr27 = bArr76;
                        bArr29 = bArr69;
                        bArr30 = bArr66;
                        str3 = str7;
                        bArr49 = tlv_t400Var.get_tlv_400(bArr111, j16, u.D, bArr59, j18, 1L, bArr60);
                        i56++;
                        str2 = str5;
                        util.LOGI("nopicsig tlv400", str2);
                        byte[] bArr113 = new byte[4];
                        util.int32_to_buf(bArr113, i36, i48);
                        tlv_tVar.set_data(bArr113, 4);
                        byte[] bArr114 = tlv_tVar.get_buf();
                        util.LOGI("nopicsig tlv516", str2);
                        byte[] bArr115 = new byte[6];
                        util.int32_to_buf(bArr115, i36, u.f422942s0);
                        util.int16_to_buf(bArr115, 4, i36);
                        tlv_tVar2.set_data(bArr115, 6);
                        bArr50 = tlv_tVar2.get_buf();
                        int i57 = i56 + 1 + 1;
                        util.LOGI("nopicsig tlv521", str2);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        byte[] bytes = str3.getBytes();
                        byte[] bArr116 = new byte[u.D.length + 10 + 2 + bytes.length + 4];
                        util.int64_to_buf(bArr116, i36, (int) j26);
                        util.int16_to_buf(bArr116, 4, u.D.length);
                        byte[] bArr117 = u.D;
                        System.arraycopy(bArr117, i36, bArr116, 6, bArr117.length);
                        int length3 = u.D.length + 6;
                        util.int16_to_buf(bArr116, length3, bytes.length);
                        int i58 = length3 + 2;
                        System.arraycopy(bytes, i36, bArr116, i58, bytes.length);
                        util.int32_to_buf(bArr116, i58 + bytes.length, c0Var.f422915k);
                        bArr51 = tlv_t544Var.get_tlv_544(String.valueOf(j16), "810_f", bArr116);
                        bArr52 = tlv_t553Var.get_tlv_t553(QSec.getInstance().getFeKitAttach(c0Var.f422905a, String.valueOf(j16), "0x810", "0xf"));
                        long currentTimeMillis3 = System.currentTimeMillis();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("nopicsig tlv544 cost:");
                        long j28 = currentTimeMillis3 - currentTimeMillis2;
                        sb6.append(j28);
                        util.LOGI(sb6.toString(), str2);
                        long j29 = System.currentTimeMillis();
                        tlv_t tlv_tVar4 = new tlv_t(1334);
                        loginExtraData = ProtocolDet.getLoginExtraData(c0Var.f422905a);
                        if (loginExtraData != null || loginExtraData.length <= 0) {
                            bArr53 = null;
                        } else {
                            tlv_tVar4.set_data(loginExtraData, loginExtraData.length);
                            byte[] bArr118 = tlv_tVar4.get_buf();
                            int length4 = bArr118.length + 2;
                            byte[] bArr119 = new byte[length4];
                            util.int16_to_buf(bArr119, i36, 1);
                            System.arraycopy(bArr118, i36, bArr119, 2, bArr118.length);
                            tlv_tVar3.set_data(bArr119, length4);
                            bArr53 = tlv_tVar3.get_buf();
                            i57++;
                            try {
                                util.LOGI("nopicsig tlv536 " + loginExtraData.length, str2 + c0Var.f422917m.f422957d);
                            } catch (Throwable th5) {
                                th = th5;
                                long j36 = j29;
                                long j37 = 0;
                                util.LOGI("request_tgtgt_nopicsig tlv536 error" + Log.getStackTraceString(th), str2);
                                j29 = j36;
                                bArr54 = bArr47;
                                j19 = j37;
                                byte[] bArr120 = bArr30;
                                byte[] bArr121 = bArr28;
                                byte[] bArr122 = bArr31;
                                byte[] bArr123 = bArr46;
                                long j38 = j19;
                                byte[] bArr124 = bArr29;
                                byte[] bArr125 = bArr20;
                                byte[] bArr126 = bArr27;
                                byte[] bArr127 = bArr49;
                                int length5 = bArr54.length + bArr120.length + bArr121.length + bArr122.length + bArr123.length + bArr124.length + bArr35.length + bArr24.length + bArr38.length + bArr25.length + bArr32.length + bArr39.length + bArr125.length + bArr33.length + bArr44.length + bArr34.length + bArr23.length + bArr45.length + bArr40.length + bArr126.length + bArr49.length + bArr41.length + bArr42.length + bArr43.length + bArr26.length;
                                byte[] bArr128 = bArr36;
                                length = length5 + bArr128.length + bArr114.length + bArr50.length;
                                if (bArr53 != null) {
                                }
                                bArr55 = bArr37;
                                bArr56 = bArr53;
                                if (bArr55 != null) {
                                }
                                if (bArr51 != null) {
                                }
                                if (bArr52 != null) {
                                }
                                wUserSigInfo2 = wUserSigInfo;
                                int i59 = length;
                                it = wUserSigInfo2.extraLoginTLVMap.keySet().iterator();
                                i37 = i59;
                                i38 = i57;
                                while (true) {
                                    bArr57 = bArr51;
                                    if (!it.hasNext()) {
                                    }
                                    Iterator<Integer> it5 = it;
                                    Integer next = it.next();
                                    byte[] bArr129 = bArr50;
                                    byte[] bArr130 = wUserSigInfo2.extraLoginTLVMap.get(next).get_buf();
                                    i37 += bArr130.length;
                                    i38++;
                                    util.LOGI("Extra Tlv from user\uff1a0x" + next + " body_len:" + bArr130.length, str2);
                                    wUserSigInfo2 = wUserSigInfo;
                                    bArr50 = bArr129;
                                    bArr51 = bArr57;
                                    it = it5;
                                }
                                byte[] bArr131 = bArr50;
                                bArr58 = new byte[i37];
                                System.arraycopy(bArr54, 0, bArr58, 0, bArr54.length);
                                int length6 = bArr54.length + 0;
                                System.arraycopy(bArr120, 0, bArr58, length6, bArr120.length);
                                int length7 = length6 + bArr120.length;
                                System.arraycopy(bArr121, 0, bArr58, length7, bArr121.length);
                                int length8 = length7 + bArr121.length;
                                System.arraycopy(bArr122, 0, bArr58, length8, bArr122.length);
                                int length9 = length8 + bArr122.length;
                                System.arraycopy(bArr123, 0, bArr58, length9, bArr123.length);
                                int length10 = length9 + bArr123.length;
                                System.arraycopy(bArr124, 0, bArr58, length10, bArr124.length);
                                int length11 = length10 + bArr124.length;
                                byte[] bArr132 = bArr35;
                                System.arraycopy(bArr132, 0, bArr58, length11, bArr132.length);
                                int length12 = length11 + bArr132.length;
                                byte[] bArr133 = bArr24;
                                System.arraycopy(bArr133, 0, bArr58, length12, bArr133.length);
                                int length13 = length12 + bArr133.length;
                                byte[] bArr134 = bArr38;
                                System.arraycopy(bArr134, 0, bArr58, length13, bArr134.length);
                                int length14 = length13 + bArr134.length;
                                byte[] bArr135 = bArr25;
                                System.arraycopy(bArr135, 0, bArr58, length14, bArr135.length);
                                int length15 = length14 + bArr135.length;
                                byte[] bArr136 = bArr32;
                                System.arraycopy(bArr136, 0, bArr58, length15, bArr136.length);
                                int length16 = length15 + bArr136.length;
                                byte[] bArr137 = bArr39;
                                System.arraycopy(bArr137, 0, bArr58, length16, bArr137.length);
                                int length17 = length16 + bArr137.length;
                                System.arraycopy(bArr125, 0, bArr58, length17, bArr125.length);
                                int length18 = length17 + bArr125.length;
                                byte[] bArr138 = bArr33;
                                System.arraycopy(bArr138, 0, bArr58, length18, bArr138.length);
                                int length19 = length18 + bArr138.length;
                                byte[] bArr139 = bArr44;
                                System.arraycopy(bArr139, 0, bArr58, length19, bArr139.length);
                                int length20 = length19 + bArr139.length;
                                byte[] bArr140 = bArr34;
                                System.arraycopy(bArr140, 0, bArr58, length20, bArr140.length);
                                int length21 = length20 + bArr140.length;
                                byte[] bArr141 = bArr23;
                                System.arraycopy(bArr141, 0, bArr58, length21, bArr141.length);
                                int length22 = length21 + bArr141.length;
                                byte[] bArr142 = bArr45;
                                System.arraycopy(bArr142, 0, bArr58, length22, bArr142.length);
                                int length23 = length22 + bArr142.length;
                                byte[] bArr143 = bArr40;
                                System.arraycopy(bArr143, 0, bArr58, length23, bArr143.length);
                                int length24 = length23 + bArr143.length;
                                System.arraycopy(bArr126, 0, bArr58, length24, bArr126.length);
                                int length25 = length24 + bArr126.length;
                                System.arraycopy(bArr127, 0, bArr58, length25, bArr127.length);
                                int length26 = length25 + bArr127.length;
                                byte[] bArr144 = bArr41;
                                System.arraycopy(bArr144, 0, bArr58, length26, bArr144.length);
                                int length27 = length26 + bArr144.length;
                                byte[] bArr145 = bArr42;
                                System.arraycopy(bArr145, 0, bArr58, length27, bArr145.length);
                                int length28 = length27 + bArr145.length;
                                byte[] bArr146 = bArr43;
                                System.arraycopy(bArr146, 0, bArr58, length28, bArr146.length);
                                int length29 = length28 + bArr146.length;
                                byte[] bArr147 = bArr26;
                                System.arraycopy(bArr147, 0, bArr58, length29, bArr147.length);
                                int length30 = length29 + bArr147.length;
                                System.arraycopy(bArr128, 0, bArr58, length30, bArr128.length);
                                int length31 = length30 + bArr128.length;
                                System.arraycopy(bArr114, 0, bArr58, length31, bArr114.length);
                                int length32 = length31 + bArr114.length;
                                System.arraycopy(bArr131, 0, bArr58, length32, bArr131.length);
                                length2 = length32 + bArr131.length;
                                if (bArr56 != null) {
                                }
                                if (bArr57 != null) {
                                }
                                if (bArr52 != null) {
                                }
                                if (bArr55 != null) {
                                }
                                while (r4.hasNext()) {
                                }
                                a.b.f422849a.a(2, System.currentTimeMillis() - currentTimeMillis, j28, j38 - j29);
                                byte[] bArr148 = new byte[i37 + 4];
                                util.int16_to_buf(bArr148, 0, this.f422915k);
                                util.int16_to_buf(bArr148, 2, i38);
                                System.arraycopy(bArr58, 0, bArr148, 4, i37);
                                a(j16, a(bArr148, this.f422918n, this.f422920p, this.f422921q), this.f422918n);
                                a16 = a(String.valueOf(this.f422917m.f422957d), false, wUserSigInfo);
                                if (a16 != 0) {
                                }
                                util.LOGI("end request_tgtgt_nopicsig ret " + a16, str2 + j16);
                                return a16;
                            }
                        }
                        j19 = System.currentTimeMillis();
                        util.LOGI("nopicsig tlv536 cost:" + (j19 - j29), str2);
                        bArr54 = bArr47;
                        byte[] bArr1202 = bArr30;
                        byte[] bArr1212 = bArr28;
                        byte[] bArr1222 = bArr31;
                        byte[] bArr1232 = bArr46;
                        long j382 = j19;
                        byte[] bArr1242 = bArr29;
                        byte[] bArr1252 = bArr20;
                        byte[] bArr1262 = bArr27;
                        byte[] bArr1272 = bArr49;
                        int length52 = bArr54.length + bArr1202.length + bArr1212.length + bArr1222.length + bArr1232.length + bArr1242.length + bArr35.length + bArr24.length + bArr38.length + bArr25.length + bArr32.length + bArr39.length + bArr1252.length + bArr33.length + bArr44.length + bArr34.length + bArr23.length + bArr45.length + bArr40.length + bArr1262.length + bArr49.length + bArr41.length + bArr42.length + bArr43.length + bArr26.length;
                        byte[] bArr1282 = bArr36;
                        length = length52 + bArr1282.length + bArr114.length + bArr50.length;
                        if (bArr53 != null) {
                            length += bArr53.length;
                        }
                        bArr55 = bArr37;
                        bArr56 = bArr53;
                        if (bArr55 != null && bArr55.length > 0) {
                            length += bArr55.length;
                        }
                        if (bArr51 != null) {
                            length += bArr51.length;
                            i57++;
                        }
                        if (bArr52 != null) {
                            length += bArr52.length;
                            i57++;
                        }
                        wUserSigInfo2 = wUserSigInfo;
                        int i592 = length;
                        it = wUserSigInfo2.extraLoginTLVMap.keySet().iterator();
                        i37 = i592;
                        i38 = i57;
                        while (true) {
                            bArr57 = bArr51;
                            if (!it.hasNext()) {
                                break;
                            }
                            Iterator<Integer> it52 = it;
                            Integer next2 = it.next();
                            byte[] bArr1292 = bArr50;
                            byte[] bArr1302 = wUserSigInfo2.extraLoginTLVMap.get(next2).get_buf();
                            i37 += bArr1302.length;
                            i38++;
                            util.LOGI("Extra Tlv from user\uff1a0x" + next2 + " body_len:" + bArr1302.length, str2);
                            wUserSigInfo2 = wUserSigInfo;
                            bArr50 = bArr1292;
                            bArr51 = bArr57;
                            it = it52;
                        }
                        byte[] bArr1312 = bArr50;
                        bArr58 = new byte[i37];
                        System.arraycopy(bArr54, 0, bArr58, 0, bArr54.length);
                        int length62 = bArr54.length + 0;
                        System.arraycopy(bArr1202, 0, bArr58, length62, bArr1202.length);
                        int length72 = length62 + bArr1202.length;
                        System.arraycopy(bArr1212, 0, bArr58, length72, bArr1212.length);
                        int length82 = length72 + bArr1212.length;
                        System.arraycopy(bArr1222, 0, bArr58, length82, bArr1222.length);
                        int length92 = length82 + bArr1222.length;
                        System.arraycopy(bArr1232, 0, bArr58, length92, bArr1232.length);
                        int length102 = length92 + bArr1232.length;
                        System.arraycopy(bArr1242, 0, bArr58, length102, bArr1242.length);
                        int length112 = length102 + bArr1242.length;
                        byte[] bArr1322 = bArr35;
                        System.arraycopy(bArr1322, 0, bArr58, length112, bArr1322.length);
                        int length122 = length112 + bArr1322.length;
                        byte[] bArr1332 = bArr24;
                        System.arraycopy(bArr1332, 0, bArr58, length122, bArr1332.length);
                        int length132 = length122 + bArr1332.length;
                        byte[] bArr1342 = bArr38;
                        System.arraycopy(bArr1342, 0, bArr58, length132, bArr1342.length);
                        int length142 = length132 + bArr1342.length;
                        byte[] bArr1352 = bArr25;
                        System.arraycopy(bArr1352, 0, bArr58, length142, bArr1352.length);
                        int length152 = length142 + bArr1352.length;
                        byte[] bArr1362 = bArr32;
                        System.arraycopy(bArr1362, 0, bArr58, length152, bArr1362.length);
                        int length162 = length152 + bArr1362.length;
                        byte[] bArr1372 = bArr39;
                        System.arraycopy(bArr1372, 0, bArr58, length162, bArr1372.length);
                        int length172 = length162 + bArr1372.length;
                        System.arraycopy(bArr1252, 0, bArr58, length172, bArr1252.length);
                        int length182 = length172 + bArr1252.length;
                        byte[] bArr1382 = bArr33;
                        System.arraycopy(bArr1382, 0, bArr58, length182, bArr1382.length);
                        int length192 = length182 + bArr1382.length;
                        byte[] bArr1392 = bArr44;
                        System.arraycopy(bArr1392, 0, bArr58, length192, bArr1392.length);
                        int length202 = length192 + bArr1392.length;
                        byte[] bArr1402 = bArr34;
                        System.arraycopy(bArr1402, 0, bArr58, length202, bArr1402.length);
                        int length212 = length202 + bArr1402.length;
                        byte[] bArr1412 = bArr23;
                        System.arraycopy(bArr1412, 0, bArr58, length212, bArr1412.length);
                        int length222 = length212 + bArr1412.length;
                        byte[] bArr1422 = bArr45;
                        System.arraycopy(bArr1422, 0, bArr58, length222, bArr1422.length);
                        int length232 = length222 + bArr1422.length;
                        byte[] bArr1432 = bArr40;
                        System.arraycopy(bArr1432, 0, bArr58, length232, bArr1432.length);
                        int length242 = length232 + bArr1432.length;
                        System.arraycopy(bArr1262, 0, bArr58, length242, bArr1262.length);
                        int length252 = length242 + bArr1262.length;
                        System.arraycopy(bArr1272, 0, bArr58, length252, bArr1272.length);
                        int length262 = length252 + bArr1272.length;
                        byte[] bArr1442 = bArr41;
                        System.arraycopy(bArr1442, 0, bArr58, length262, bArr1442.length);
                        int length272 = length262 + bArr1442.length;
                        byte[] bArr1452 = bArr42;
                        System.arraycopy(bArr1452, 0, bArr58, length272, bArr1452.length);
                        int length282 = length272 + bArr1452.length;
                        byte[] bArr1462 = bArr43;
                        System.arraycopy(bArr1462, 0, bArr58, length282, bArr1462.length);
                        int length292 = length282 + bArr1462.length;
                        byte[] bArr1472 = bArr26;
                        System.arraycopy(bArr1472, 0, bArr58, length292, bArr1472.length);
                        int length302 = length292 + bArr1472.length;
                        System.arraycopy(bArr1282, 0, bArr58, length302, bArr1282.length);
                        int length312 = length302 + bArr1282.length;
                        System.arraycopy(bArr114, 0, bArr58, length312, bArr114.length);
                        int length322 = length312 + bArr114.length;
                        System.arraycopy(bArr1312, 0, bArr58, length322, bArr1312.length);
                        length2 = length322 + bArr1312.length;
                        if (bArr56 != null) {
                            System.arraycopy(bArr56, 0, bArr58, length2, bArr56.length);
                            length2 += bArr56.length;
                        }
                        if (bArr57 != null) {
                            System.arraycopy(bArr57, 0, bArr58, length2, bArr57.length);
                            length2 += bArr57.length;
                        }
                        if (bArr52 != null) {
                            System.arraycopy(bArr52, 0, bArr58, length2, bArr52.length);
                            length2 += bArr52.length;
                        }
                        if (bArr55 != null && bArr55.length > 0) {
                            System.arraycopy(bArr55, 0, bArr58, length2, bArr55.length);
                            length2 += bArr55.length;
                            util.LOGI("nopicsig qimei len:" + bArr55.length, str2);
                        }
                        for (Integer num : wUserSigInfo.extraLoginTLVMap.keySet()) {
                            byte[] bArr149 = wUserSigInfo.extraLoginTLVMap.get(num).get_buf();
                            System.arraycopy(bArr149, 0, bArr58, length2, bArr149.length);
                            length2 += bArr149.length;
                            util.LOGI("Extra Tlv from user\uff1a0x" + num);
                        }
                        a.b.f422849a.a(2, System.currentTimeMillis() - currentTimeMillis, j28, j382 - j29);
                        byte[] bArr1482 = new byte[i37 + 4];
                        util.int16_to_buf(bArr1482, 0, this.f422915k);
                        util.int16_to_buf(bArr1482, 2, i38);
                        System.arraycopy(bArr58, 0, bArr1482, 4, i37);
                        a(j16, a(bArr1482, this.f422918n, this.f422920p, this.f422921q), this.f422918n);
                        a16 = a(String.valueOf(this.f422917m.f422957d), false, wUserSigInfo);
                        if (a16 != 0) {
                            break;
                        }
                        a16 = d();
                        util.LOGI("retry num:" + i49 + " ret:" + a16, str2 + j16);
                        if (a16 != 180) {
                            break;
                        }
                        i47 = i49 + 1;
                        if (i49 >= 1) {
                            break;
                        }
                        i39 = i16;
                        j27 = j18;
                        wUserSigInfo3 = wUserSigInfo;
                        c0Var = this;
                        j26 = j16;
                        a17 = bArr48;
                        str4 = str2;
                    }
                } else {
                    bArr23 = bArr22;
                    bArr24 = bArr106;
                    bArr25 = bArr19;
                    bArr26 = bArr16;
                    bArr27 = bArr76;
                    bArr28 = bArr67;
                    bArr29 = bArr69;
                    bArr30 = bArr66;
                    bArr31 = bArr70;
                    bArr32 = bArr71;
                    bArr33 = bArr72;
                    bArr34 = bArr74;
                    str3 = str7;
                    bArr35 = bArr6;
                    bArr36 = bArr104;
                    bArr37 = bArr105;
                    bArr38 = bArr21;
                }
                str2 = str5;
            } else {
                bArr23 = bArr22;
                str2 = str5;
                bArr24 = bArr106;
                bArr25 = bArr19;
                bArr26 = bArr16;
                bArr27 = bArr76;
                bArr28 = bArr67;
                bArr29 = bArr69;
                bArr30 = bArr66;
                bArr31 = bArr70;
                bArr32 = bArr71;
                bArr33 = bArr72;
                bArr34 = bArr74;
                str3 = str7;
                bArr35 = bArr6;
                bArr36 = bArr104;
                bArr37 = bArr105;
                bArr38 = bArr21;
            }
            bArr39 = bArr91;
            bArr40 = bArr93;
            bArr41 = bArr10;
            bArr42 = bArr95;
            bArr43 = bArr97;
            bArr44 = bArr13;
            bArr45 = bArr14;
            bArr46 = bArr15;
            i36 = 0;
            bArr47 = bArr65;
            bArr48 = bArr64;
            util.LOGI("request_tgtgt_nopicsig req without DA1", str2 + j26);
            bArr49 = bArr83;
            byte[] bArr1132 = new byte[4];
            util.int32_to_buf(bArr1132, i36, i48);
            tlv_tVar.set_data(bArr1132, 4);
            byte[] bArr1142 = tlv_tVar.get_buf();
            util.LOGI("nopicsig tlv516", str2);
            byte[] bArr1152 = new byte[6];
            util.int32_to_buf(bArr1152, i36, u.f422942s0);
            util.int16_to_buf(bArr1152, 4, i36);
            tlv_tVar2.set_data(bArr1152, 6);
            bArr50 = tlv_tVar2.get_buf();
            int i572 = i56 + 1 + 1;
            util.LOGI("nopicsig tlv521", str2);
            long currentTimeMillis22 = System.currentTimeMillis();
            byte[] bytes2 = str3.getBytes();
            byte[] bArr1162 = new byte[u.D.length + 10 + 2 + bytes2.length + 4];
            util.int64_to_buf(bArr1162, i36, (int) j26);
            util.int16_to_buf(bArr1162, 4, u.D.length);
            byte[] bArr1172 = u.D;
            System.arraycopy(bArr1172, i36, bArr1162, 6, bArr1172.length);
            int length33 = u.D.length + 6;
            util.int16_to_buf(bArr1162, length33, bytes2.length);
            int i582 = length33 + 2;
            System.arraycopy(bytes2, i36, bArr1162, i582, bytes2.length);
            util.int32_to_buf(bArr1162, i582 + bytes2.length, c0Var.f422915k);
            bArr51 = tlv_t544Var.get_tlv_544(String.valueOf(j16), "810_f", bArr1162);
            bArr52 = tlv_t553Var.get_tlv_t553(QSec.getInstance().getFeKitAttach(c0Var.f422905a, String.valueOf(j16), "0x810", "0xf"));
            long currentTimeMillis32 = System.currentTimeMillis();
            StringBuilder sb62 = new StringBuilder();
            sb62.append("nopicsig tlv544 cost:");
            long j282 = currentTimeMillis32 - currentTimeMillis22;
            sb62.append(j282);
            util.LOGI(sb62.toString(), str2);
            long j292 = System.currentTimeMillis();
            tlv_t tlv_tVar42 = new tlv_t(1334);
            loginExtraData = ProtocolDet.getLoginExtraData(c0Var.f422905a);
            if (loginExtraData != null) {
            }
            bArr53 = null;
            j19 = System.currentTimeMillis();
            util.LOGI("nopicsig tlv536 cost:" + (j19 - j292), str2);
            bArr54 = bArr47;
            byte[] bArr12022 = bArr30;
            byte[] bArr12122 = bArr28;
            byte[] bArr12222 = bArr31;
            byte[] bArr12322 = bArr46;
            long j3822 = j19;
            byte[] bArr12422 = bArr29;
            byte[] bArr12522 = bArr20;
            byte[] bArr12622 = bArr27;
            byte[] bArr12722 = bArr49;
            int length522 = bArr54.length + bArr12022.length + bArr12122.length + bArr12222.length + bArr12322.length + bArr12422.length + bArr35.length + bArr24.length + bArr38.length + bArr25.length + bArr32.length + bArr39.length + bArr12522.length + bArr33.length + bArr44.length + bArr34.length + bArr23.length + bArr45.length + bArr40.length + bArr12622.length + bArr49.length + bArr41.length + bArr42.length + bArr43.length + bArr26.length;
            byte[] bArr12822 = bArr36;
            length = length522 + bArr12822.length + bArr1142.length + bArr50.length;
            if (bArr53 != null) {
            }
            bArr55 = bArr37;
            bArr56 = bArr53;
            if (bArr55 != null) {
                length += bArr55.length;
            }
            if (bArr51 != null) {
            }
            if (bArr52 != null) {
            }
            wUserSigInfo2 = wUserSigInfo;
            int i5922 = length;
            it = wUserSigInfo2.extraLoginTLVMap.keySet().iterator();
            i37 = i5922;
            i38 = i572;
            while (true) {
                bArr57 = bArr51;
                if (!it.hasNext()) {
                }
                Iterator<Integer> it522 = it;
                Integer next22 = it.next();
                byte[] bArr12922 = bArr50;
                byte[] bArr13022 = wUserSigInfo2.extraLoginTLVMap.get(next22).get_buf();
                i37 += bArr13022.length;
                i38++;
                util.LOGI("Extra Tlv from user\uff1a0x" + next22 + " body_len:" + bArr13022.length, str2);
                wUserSigInfo2 = wUserSigInfo;
                bArr50 = bArr12922;
                bArr51 = bArr57;
                it = it522;
            }
            byte[] bArr13122 = bArr50;
            bArr58 = new byte[i37];
            System.arraycopy(bArr54, 0, bArr58, 0, bArr54.length);
            int length622 = bArr54.length + 0;
            System.arraycopy(bArr12022, 0, bArr58, length622, bArr12022.length);
            int length722 = length622 + bArr12022.length;
            System.arraycopy(bArr12122, 0, bArr58, length722, bArr12122.length);
            int length822 = length722 + bArr12122.length;
            System.arraycopy(bArr12222, 0, bArr58, length822, bArr12222.length);
            int length922 = length822 + bArr12222.length;
            System.arraycopy(bArr12322, 0, bArr58, length922, bArr12322.length);
            int length1022 = length922 + bArr12322.length;
            System.arraycopy(bArr12422, 0, bArr58, length1022, bArr12422.length);
            int length1122 = length1022 + bArr12422.length;
            byte[] bArr13222 = bArr35;
            System.arraycopy(bArr13222, 0, bArr58, length1122, bArr13222.length);
            int length1222 = length1122 + bArr13222.length;
            byte[] bArr13322 = bArr24;
            System.arraycopy(bArr13322, 0, bArr58, length1222, bArr13322.length);
            int length1322 = length1222 + bArr13322.length;
            byte[] bArr13422 = bArr38;
            System.arraycopy(bArr13422, 0, bArr58, length1322, bArr13422.length);
            int length1422 = length1322 + bArr13422.length;
            byte[] bArr13522 = bArr25;
            System.arraycopy(bArr13522, 0, bArr58, length1422, bArr13522.length);
            int length1522 = length1422 + bArr13522.length;
            byte[] bArr13622 = bArr32;
            System.arraycopy(bArr13622, 0, bArr58, length1522, bArr13622.length);
            int length1622 = length1522 + bArr13622.length;
            byte[] bArr13722 = bArr39;
            System.arraycopy(bArr13722, 0, bArr58, length1622, bArr13722.length);
            int length1722 = length1622 + bArr13722.length;
            System.arraycopy(bArr12522, 0, bArr58, length1722, bArr12522.length);
            int length1822 = length1722 + bArr12522.length;
            byte[] bArr13822 = bArr33;
            System.arraycopy(bArr13822, 0, bArr58, length1822, bArr13822.length);
            int length1922 = length1822 + bArr13822.length;
            byte[] bArr13922 = bArr44;
            System.arraycopy(bArr13922, 0, bArr58, length1922, bArr13922.length);
            int length2022 = length1922 + bArr13922.length;
            byte[] bArr14022 = bArr34;
            System.arraycopy(bArr14022, 0, bArr58, length2022, bArr14022.length);
            int length2122 = length2022 + bArr14022.length;
            byte[] bArr14122 = bArr23;
            System.arraycopy(bArr14122, 0, bArr58, length2122, bArr14122.length);
            int length2222 = length2122 + bArr14122.length;
            byte[] bArr14222 = bArr45;
            System.arraycopy(bArr14222, 0, bArr58, length2222, bArr14222.length);
            int length2322 = length2222 + bArr14222.length;
            byte[] bArr14322 = bArr40;
            System.arraycopy(bArr14322, 0, bArr58, length2322, bArr14322.length);
            int length2422 = length2322 + bArr14322.length;
            System.arraycopy(bArr12622, 0, bArr58, length2422, bArr12622.length);
            int length2522 = length2422 + bArr12622.length;
            System.arraycopy(bArr12722, 0, bArr58, length2522, bArr12722.length);
            int length2622 = length2522 + bArr12722.length;
            byte[] bArr14422 = bArr41;
            System.arraycopy(bArr14422, 0, bArr58, length2622, bArr14422.length);
            int length2722 = length2622 + bArr14422.length;
            byte[] bArr14522 = bArr42;
            System.arraycopy(bArr14522, 0, bArr58, length2722, bArr14522.length);
            int length2822 = length2722 + bArr14522.length;
            byte[] bArr14622 = bArr43;
            System.arraycopy(bArr14622, 0, bArr58, length2822, bArr14622.length);
            int length2922 = length2822 + bArr14622.length;
            byte[] bArr14722 = bArr26;
            System.arraycopy(bArr14722, 0, bArr58, length2922, bArr14722.length);
            int length3022 = length2922 + bArr14722.length;
            System.arraycopy(bArr12822, 0, bArr58, length3022, bArr12822.length);
            int length3122 = length3022 + bArr12822.length;
            System.arraycopy(bArr1142, 0, bArr58, length3122, bArr1142.length);
            int length3222 = length3122 + bArr1142.length;
            System.arraycopy(bArr13122, 0, bArr58, length3222, bArr13122.length);
            length2 = length3222 + bArr13122.length;
            if (bArr56 != null) {
            }
            if (bArr57 != null) {
            }
            if (bArr52 != null) {
            }
            if (bArr55 != null) {
                System.arraycopy(bArr55, 0, bArr58, length2, bArr55.length);
                length2 += bArr55.length;
                util.LOGI("nopicsig qimei len:" + bArr55.length, str2);
            }
            while (r4.hasNext()) {
            }
            a.b.f422849a.a(2, System.currentTimeMillis() - currentTimeMillis, j282, j3822 - j292);
            byte[] bArr14822 = new byte[i37 + 4];
            util.int16_to_buf(bArr14822, 0, this.f422915k);
            util.int16_to_buf(bArr14822, 2, i38);
            System.arraycopy(bArr58, 0, bArr14822, 4, i37);
            a(j16, a(bArr14822, this.f422918n, this.f422920p, this.f422921q), this.f422918n);
            a16 = a(String.valueOf(this.f422917m.f422957d), false, wUserSigInfo);
            if (a16 != 0) {
            }
        }
        util.LOGI("end request_tgtgt_nopicsig ret " + a16, str2 + j16);
        return a16;
    }
}
