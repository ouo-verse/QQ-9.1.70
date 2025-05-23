package oicq.wlogin_sdk.request;

import android.content.Context;
import android.util.Log;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.loginsecsdk.ProtocolDet;
import com.tencent.luggage.wxa.yf.e0;
import com.tencent.mobileqq.cardcontainer.api.impl.CardContainerDataServiceImpl;
import com.tencent.mobileqq.qsec.qsecurity.QSec;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.qphone.base.BaseConstants;
import java.util.ArrayList;
import java.util.List;
import oicq.wlogin_sdk.report.a;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t1;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
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
import oicq.wlogin_sdk.tlv_type.tlv_t185;
import oicq.wlogin_sdk.tlv_type.tlv_t187;
import oicq.wlogin_sdk.tlv_type.tlv_t188;
import oicq.wlogin_sdk.tlv_type.tlv_t191;
import oicq.wlogin_sdk.tlv_type.tlv_t194;
import oicq.wlogin_sdk.tlv_type.tlv_t201;
import oicq.wlogin_sdk.tlv_type.tlv_t202;
import oicq.wlogin_sdk.tlv_type.tlv_t400;
import oicq.wlogin_sdk.tlv_type.tlv_t511;
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tlv_type.tlv_t545;
import oicq.wlogin_sdk.tlv_type.tlv_t548;
import oicq.wlogin_sdk.tlv_type.tlv_t553;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class j extends oicq_request {

    /* renamed from: v, reason: collision with root package name */
    public static int f422896v = 130;

    /* renamed from: w, reason: collision with root package name */
    public static byte[] f422897w = new byte[0];

    /* renamed from: x, reason: collision with root package name */
    public static byte[] f422898x = new byte[0];

    /* renamed from: y, reason: collision with root package name */
    public static byte[] f422899y = new byte[0];

    public j(u uVar, Context context) {
        this.f422914j = 2064;
        this.f422915k = 9;
        this.f422916l = BaseConstants.CMD_WT_LOGIN_AUTH;
        this.f422917m = uVar;
        uVar.f422964k = 0;
        this.f422905a = context;
    }

    public int a(long j3, long j16, long j17, int i3, byte[] bArr, byte[] bArr2, byte[] bArr3, int i16, int i17, long[] jArr, int i18, long j18, int i19, int i26, int i27, int i28, byte[] bArr4, WUserSigInfo wUserSigInfo, boolean z16) {
        int a16;
        WUserSigInfo wUserSigInfo2 = wUserSigInfo;
        int i29 = u.f422953z;
        tlv_t104 tlv_t104Var = u.b(this.f422917m.f422959f).get_t104();
        if (tlv_t104Var == null) {
            tlv_t104Var = new tlv_t104();
        }
        tlv_t104 tlv_t104Var2 = tlv_t104Var;
        byte[] bArr5 = bArr2;
        if (z16 && (bArr5 = a(bArr5)) == null) {
            return -1014;
        }
        byte[] bArr6 = bArr5;
        int i36 = 0;
        while (true) {
            int i37 = i36;
            a(8001, this.f422914j, this.f422910f, j17, 0, 2, i29, 0, a(j3, j16, i29, j17, i3, bArr, null, null, null, 0, bArr6, bArr3, i16, i17, jArr, i18, j18, i19, i26, i27, i28, bArr4, tlv_t104Var2.get_data(), u.G, wUserSigInfo2._domains, wUserSigInfo));
            a16 = a(String.valueOf(this.f422917m.f422957d), false, wUserSigInfo);
            if (a16 != 0) {
                break;
            }
            a16 = d();
            util.LOGI("retry num:" + i37 + " ret:" + a16, "" + j17);
            if (a16 != 180) {
                break;
            }
            i36 = i37 + 1;
            if (i37 >= 1) {
                break;
            }
            wUserSigInfo2 = wUserSigInfo;
        }
        return a16;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0061. Please report as an issue. */
    public byte[] a(long j3, long j16, int i3, long j17, int i16, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i17, byte[] bArr5, byte[] bArr6, int i18, int i19, long[] jArr, int i26, long j18, int i27, int i28, int i29, int i36, byte[] bArr7, byte[] bArr8, byte[] bArr9, List<String> list, WUserSigInfo wUserSigInfo) {
        String str;
        async_context async_contextVar;
        byte[] bArr10;
        int i37;
        StringBuilder sb5;
        ArrayList arrayList;
        int[] iArr;
        int i38;
        long j19;
        byte[] bArr11;
        byte[] bArr12;
        int i39;
        boolean z16;
        int i46;
        async_context async_contextVar2;
        String str2;
        byte[] bArr13;
        byte[] bArr14;
        async_context async_contextVar3;
        String str3;
        byte[] bArr15;
        byte[] bArr16;
        byte[] bArr17;
        byte[] bArr18;
        long j26 = j3;
        long j27 = j17;
        byte[] bArr19 = bArr6;
        int i47 = i18;
        byte[] bArr20 = bArr7;
        byte[] bArr21 = bArr8;
        WUserSigInfo wUserSigInfo2 = wUserSigInfo;
        int[] iArr2 = {24, 1, 262, 278, 256, 263, 264, 260, 322, 274, 324, 325, 327, com.tencent.luggage.wxa.rf.d.CTRL_INDEX, 362, 340, 321, 8, 1297, 370, e0.CTRL_INDEX, 1024, 391, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE, 404, 401, 513, 514, QidPagView.DESIGN_PAG_WIDTH, gdt_analysis_event.EVENT_MOTIVE_CLOSE, 1313, 1317, gdt_analysis_event.EVENT_OPEN_SPAM_CLICK_OPEN, com.tencent.luggage.wxa.uf.l.CTRL_INDEX, 1348, 1349, CardContainerDataServiceImpl.CARD_CONTAINER_POS_ID, tlv_t553.CMD_553};
        async_context b16 = u.b(this.f422917m.f422959f);
        ArrayList arrayList2 = new ArrayList();
        String str4 = "";
        util.LOGI("tgtgt getRequestBody start", "");
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb6 = new StringBuilder("tgtgt getRequestBody");
        sb6.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
        StringBuilder sb7 = sb6;
        long j28 = 0;
        long j29 = 0;
        long j36 = 0;
        long j37 = 0;
        int i48 = 0;
        int i49 = 0;
        ArrayList arrayList3 = arrayList2;
        int i56 = 38;
        while (i48 < i56) {
            int[] iArr3 = iArr2;
            byte[] bArr22 = null;
            switch (iArr2[i48]) {
                case 1:
                    str = str4;
                    async_contextVar = b16;
                    bArr10 = bArr21;
                    i37 = i48;
                    sb5 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    j19 = j17;
                    bArr11 = new tlv_t1().get_tlv_1(j19, bArr);
                    bArr22 = bArr11;
                    bArr13 = bArr22;
                    break;
                case 8:
                    str = str4;
                    async_contextVar = b16;
                    bArr10 = bArr21;
                    i37 = i48;
                    sb5 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    bArr11 = new tlv_t8().get_tlv_8(0, u.f422951x, 0);
                    j19 = j17;
                    bArr22 = bArr11;
                    bArr13 = bArr22;
                    break;
                case 24:
                    str = str4;
                    async_contextVar = b16;
                    bArr10 = bArr21;
                    i37 = i48;
                    sb5 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    bArr12 = new tlv_t18().get_tlv_18(j3, i3, j17, i16);
                    j19 = j17;
                    bArr22 = bArr12;
                    bArr13 = bArr22;
                    break;
                case 256:
                    str = str4;
                    async_contextVar = b16;
                    bArr10 = bArr21;
                    i37 = i48;
                    sb5 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    bArr12 = new tlv_t100().get_tlv_100(j3, j18, i3, i26);
                    j19 = j17;
                    bArr22 = bArr12;
                    bArr13 = bArr22;
                    break;
                case 260:
                    str = str4;
                    async_contextVar = b16;
                    bArr10 = bArr21;
                    i37 = i48;
                    sb5 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    if (bArr10 == null || bArr10.length == 0) {
                        j19 = j17;
                        bArr13 = bArr22;
                        break;
                    } else {
                        bArr12 = new tlv_t104().get_tlv_104(bArr10);
                        j19 = j17;
                        bArr22 = bArr12;
                        bArr13 = bArr22;
                    }
                    break;
                case 262:
                    str = str4;
                    StringBuilder sb8 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_context async_contextVar4 = b16;
                    tlv_t106 tlv_t106Var = new tlv_t106();
                    if (bArr5 == null || bArr5.length <= 0) {
                        async_contextVar = async_contextVar4;
                        i37 = i39;
                        sb5 = sb8;
                        bArr12 = tlv_t106Var.get_tlv_106(j3, j16, i3, j17, bArr2, bArr, 1, bArr3, async_contextVar4._msalt, this.f422917m.f422958e.getBytes(), bArr4, u.T, u.D, i17);
                        j19 = j17;
                        bArr10 = bArr8;
                        bArr22 = bArr12;
                        bArr13 = bArr22;
                        break;
                    } else {
                        tlv_t106Var.set_data(bArr5, bArr5.length);
                        j19 = j17;
                        bArr10 = bArr8;
                        bArr22 = tlv_t106Var.get_buf();
                        sb5 = sb8;
                        async_contextVar = async_contextVar4;
                        i37 = i39;
                        bArr13 = bArr22;
                    }
                    break;
                case 263:
                    str = str4;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    bArr10 = bArr8;
                    bArr22 = new tlv_t107().get_tlv_107(i27, i28, i29, i36);
                    sb5 = sb7;
                    async_contextVar = b16;
                    i37 = i48;
                    j19 = j17;
                    bArr13 = bArr22;
                    break;
                case 264:
                    str = str4;
                    byte[] bArr23 = bArr20;
                    StringBuilder sb9 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    int i57 = i48;
                    async_context async_contextVar5 = b16;
                    if (bArr23 == null || bArr23.length == 0) {
                        bArr10 = bArr8;
                        sb5 = sb9;
                        j19 = j27;
                        async_contextVar = async_contextVar5;
                        i37 = i57;
                    } else {
                        bArr10 = bArr8;
                        bArr22 = new tlv_t108().get_tlv_108(bArr23);
                        sb5 = sb9;
                        j19 = j27;
                        async_contextVar = async_contextVar5;
                        i37 = i57;
                    }
                    bArr13 = bArr22;
                    break;
                case 274:
                    arrayList = arrayList3;
                    iArr = iArr3;
                    z16 = false;
                    i38 = 38;
                    i46 = i48;
                    async_contextVar2 = b16;
                    str2 = str4;
                    String str5 = this.f422917m.f422958e;
                    if (str5 != null && !util.check_uin_account(str5).booleanValue()) {
                        byte[] bArr24 = new tlv_t112().get_tlv_112(this.f422917m.f422958e.getBytes());
                        StringBuilder sb10 = sb7;
                        sb10.append(",0x404 = ");
                        sb10.append(this.f422917m.f422958e);
                        bArr10 = bArr8;
                        sb5 = sb10;
                        j19 = j27;
                        str = str2;
                        async_contextVar = async_contextVar2;
                        i37 = i46;
                        bArr13 = bArr24;
                        break;
                    } else {
                        bArr10 = bArr8;
                        j19 = j27;
                        str = str2;
                        async_contextVar = async_contextVar2;
                        sb5 = sb7;
                        i37 = i46;
                        bArr13 = bArr22;
                        break;
                    }
                    break;
                case 278:
                    arrayList = arrayList3;
                    iArr = iArr3;
                    z16 = false;
                    i38 = 38;
                    i46 = i48;
                    async_contextVar2 = b16;
                    str2 = str4;
                    bArr14 = new tlv_t116().get_tlv_116(i47, i19, jArr);
                    bArr10 = bArr8;
                    bArr22 = bArr14;
                    j19 = j27;
                    str = str2;
                    async_contextVar = async_contextVar2;
                    sb5 = sb7;
                    i37 = i46;
                    bArr13 = bArr22;
                    break;
                case 321:
                    arrayList = arrayList3;
                    iArr = iArr3;
                    z16 = false;
                    i38 = 38;
                    i46 = i48;
                    async_contextVar2 = b16;
                    str2 = str4;
                    bArr14 = new tlv_t141().get_tlv_141(oicq.wlogin_sdk.utils.b.d(this.f422905a), u.F, u.H);
                    bArr10 = bArr8;
                    bArr22 = bArr14;
                    j19 = j27;
                    str = str2;
                    async_contextVar = async_contextVar2;
                    sb5 = sb7;
                    i37 = i46;
                    bArr13 = bArr22;
                    break;
                case 322:
                    arrayList = arrayList3;
                    iArr = iArr3;
                    z16 = false;
                    i38 = 38;
                    i46 = i48;
                    async_contextVar2 = b16;
                    str2 = str4;
                    bArr14 = new tlv_t142().get_tlv_142(bArr9);
                    bArr10 = bArr8;
                    bArr22 = bArr14;
                    j19 = j27;
                    str = str2;
                    async_contextVar = async_contextVar2;
                    sb5 = sb7;
                    i37 = i46;
                    bArr13 = bArr22;
                    break;
                case 324:
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i46 = i48;
                    async_contextVar2 = b16;
                    str2 = str4;
                    byte[] b17 = oicq.wlogin_sdk.utils.b.b(u.f422949w);
                    z16 = false;
                    bArr14 = new tlv_t144().get_tlv_144(new tlv_t109().get_tlv_109(oicq.wlogin_sdk.utils.a.a(u.f422949w)), new tlv_t52d().get_tlv_52d(this.f422905a), new tlv_t124().get_tlv_124(util.get_os_type(), util.get_os_version(), u.F, oicq.wlogin_sdk.utils.b.d(this.f422905a), new byte[0], u.H), new tlv_t128().get_tlv_128(u.S, u.T, u.U, u.X, b17, u.D, u.O), new tlv_t16e().get_tlv_16e(b17), async_contextVar2._tgtgt_key);
                    bArr10 = bArr8;
                    bArr22 = bArr14;
                    j19 = j27;
                    str = str2;
                    async_contextVar = async_contextVar2;
                    sb5 = sb7;
                    i37 = i46;
                    bArr13 = bArr22;
                    break;
                case 325:
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_contextVar3 = b16;
                    str3 = str4;
                    bArr15 = new tlv_t145().get_tlv_145(u.D);
                    bArr10 = bArr8;
                    bArr22 = bArr15;
                    j19 = j27;
                    str = str3;
                    async_contextVar = async_contextVar3;
                    sb5 = sb7;
                    i37 = i39;
                    bArr13 = bArr22;
                    break;
                case 327:
                    str3 = str4;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_contextVar3 = b16;
                    bArr15 = new tlv_t147().get_tlv_147(j3, u.I, u.J);
                    bArr10 = bArr8;
                    bArr22 = bArr15;
                    j19 = j27;
                    str = str3;
                    async_contextVar = async_contextVar3;
                    sb5 = sb7;
                    i37 = i39;
                    bArr13 = bArr22;
                    break;
                case 340:
                    str3 = str4;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_contextVar3 = b16;
                    bArr15 = new tlv_t154().get_tlv_154(this.f422917m.f422960g);
                    bArr10 = bArr8;
                    bArr22 = bArr15;
                    j19 = j27;
                    str = str3;
                    async_contextVar = async_contextVar3;
                    sb5 = sb7;
                    i37 = i39;
                    bArr13 = bArr22;
                    break;
                case com.tencent.luggage.wxa.rf.d.CTRL_INDEX /* 358 */:
                    str3 = str4;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_contextVar3 = b16;
                    if ((i18 & 128) != 0) {
                        bArr15 = new tlv_t166().get_tlv_166(u.A);
                        bArr10 = bArr8;
                        bArr22 = bArr15;
                        j19 = j27;
                        str = str3;
                        async_contextVar = async_contextVar3;
                        sb5 = sb7;
                        i37 = i39;
                        bArr13 = bArr22;
                        break;
                    }
                    bArr10 = bArr8;
                    j19 = j27;
                    str = str3;
                    async_contextVar = async_contextVar3;
                    sb5 = sb7;
                    i37 = i39;
                    bArr13 = bArr22;
                case 362:
                    str3 = str4;
                    byte[] bArr25 = bArr19;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_contextVar3 = b16;
                    if (bArr25 != null && bArr25.length != 0) {
                        bArr15 = new tlv_t16a().get_tlv_16a(bArr25);
                        bArr10 = bArr8;
                        bArr22 = bArr15;
                        j19 = j27;
                        str = str3;
                        async_contextVar = async_contextVar3;
                        sb5 = sb7;
                        i37 = i39;
                        bArr13 = bArr22;
                        break;
                    }
                    bArr10 = bArr8;
                    j19 = j27;
                    str = str3;
                    async_contextVar = async_contextVar3;
                    sb5 = sb7;
                    i37 = i39;
                    bArr13 = bArr22;
                    break;
                case 370:
                    str3 = str4;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_contextVar3 = b16;
                    byte[] bArr26 = this.f422917m.f422968o;
                    if (bArr26 != null && bArr26.length != 0) {
                        bArr15 = new tlv_t172().get_tlv_172(this.f422917m.f422968o);
                        bArr10 = bArr8;
                        bArr22 = bArr15;
                        j19 = j27;
                        str = str3;
                        async_contextVar = async_contextVar3;
                        sb5 = sb7;
                        i37 = i39;
                        bArr13 = bArr22;
                        break;
                    }
                    bArr10 = bArr8;
                    j19 = j27;
                    str = str3;
                    async_contextVar = async_contextVar3;
                    sb5 = sb7;
                    i37 = i39;
                    bArr13 = bArr22;
                    break;
                case QidPagView.DESIGN_PAG_WIDTH /* 375 */:
                    str3 = str4;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_contextVar3 = b16;
                    bArr15 = new tlv_t177().get_tlv_177(util.BUILD_TIME, util.SDK_VERSION);
                    bArr10 = bArr8;
                    bArr22 = bArr15;
                    j19 = j27;
                    str = str3;
                    async_contextVar = async_contextVar3;
                    sb5 = sb7;
                    i37 = i39;
                    bArr13 = bArr22;
                    break;
                case e0.CTRL_INDEX /* 389 */:
                    str3 = str4;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_contextVar3 = b16;
                    if (i17 == 3) {
                        bArr15 = new tlv_t185().get_tlv_185(1);
                        bArr10 = bArr8;
                        bArr22 = bArr15;
                        j19 = j27;
                        str = str3;
                        async_contextVar = async_contextVar3;
                        sb5 = sb7;
                        i37 = i39;
                        bArr13 = bArr22;
                        break;
                    }
                    bArr10 = bArr8;
                    j19 = j27;
                    str = str3;
                    async_contextVar = async_contextVar3;
                    sb5 = sb7;
                    i37 = i39;
                    bArr13 = bArr22;
                case 391:
                    str3 = str4;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_contextVar3 = b16;
                    byte[] bArr27 = u.N;
                    if (bArr27 != null && bArr27.length != 0) {
                        bArr15 = new tlv_t187().get_tlv_187(u.N);
                        bArr10 = bArr8;
                        bArr22 = bArr15;
                        j19 = j27;
                        str = str3;
                        async_contextVar = async_contextVar3;
                        sb5 = sb7;
                        i37 = i39;
                        bArr13 = bArr22;
                        break;
                    }
                    bArr10 = bArr8;
                    j19 = j27;
                    str = str3;
                    async_contextVar = async_contextVar3;
                    sb5 = sb7;
                    i37 = i39;
                    bArr13 = bArr22;
                    break;
                case QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE /* 392 */:
                    str3 = str4;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_contextVar3 = b16;
                    if (oicq.wlogin_sdk.utils.a.a(u.f422949w) != null && oicq.wlogin_sdk.utils.a.a(u.f422949w).length != 0) {
                        bArr15 = new tlv_t188().get_tlv_188(oicq.wlogin_sdk.utils.a.a(u.f422949w));
                        bArr10 = bArr8;
                        bArr22 = bArr15;
                        j19 = j27;
                        str = str3;
                        async_contextVar = async_contextVar3;
                        sb5 = sb7;
                        i37 = i39;
                        bArr13 = bArr22;
                        break;
                    }
                    bArr10 = bArr8;
                    j19 = j27;
                    str = str3;
                    async_contextVar = async_contextVar3;
                    sb5 = sb7;
                    i37 = i39;
                    bArr13 = bArr22;
                    break;
                case 401:
                    str3 = str4;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_contextVar3 = b16;
                    bArr16 = new tlv_t191().get_tlv_191(f422896v);
                    util.LOGI("request_TGTGT canWebVerify" + f422896v, str3);
                    bArr10 = bArr8;
                    j19 = j27;
                    str = str3;
                    async_contextVar = async_contextVar3;
                    sb5 = sb7;
                    i37 = i39;
                    bArr13 = bArr16;
                    break;
                case 404:
                    str3 = str4;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_contextVar3 = b16;
                    byte[] bArr28 = u.M;
                    if (bArr28 != null && bArr28.length != 0) {
                        bArr15 = new tlv_t194().get_tlv_194(u.M);
                        bArr10 = bArr8;
                        bArr22 = bArr15;
                        j19 = j27;
                        str = str3;
                        async_contextVar = async_contextVar3;
                        sb5 = sb7;
                        i37 = i39;
                        bArr13 = bArr22;
                        break;
                    }
                    bArr10 = bArr8;
                    j19 = j27;
                    str = str3;
                    async_contextVar = async_contextVar3;
                    sb5 = sb7;
                    i37 = i39;
                    bArr13 = bArr22;
                    break;
                case 513:
                    str3 = str4;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_contextVar3 = b16;
                    byte[] bArr29 = f422897w;
                    if (bArr29 != null && bArr29.length != 0) {
                        bArr15 = new tlv_t201().get_tlv_201(f422897w, f422898x, "qq".getBytes(), f422899y);
                        bArr10 = bArr8;
                        bArr22 = bArr15;
                        j19 = j27;
                        str = str3;
                        async_contextVar = async_contextVar3;
                        sb5 = sb7;
                        i37 = i39;
                        bArr13 = bArr22;
                        break;
                    }
                    bArr10 = bArr8;
                    j19 = j27;
                    str = str3;
                    async_contextVar = async_contextVar3;
                    sb5 = sb7;
                    i37 = i39;
                    bArr13 = bArr22;
                    break;
                case 514:
                    str3 = str4;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_contextVar3 = b16;
                    byte[] bArr30 = u.Q;
                    if (bArr30 != null && bArr30.length != 0) {
                        bArr15 = new tlv_t202().get_tlv_202(u.Q, u.R);
                        bArr10 = bArr8;
                        bArr22 = bArr15;
                        j19 = j27;
                        str = str3;
                        async_contextVar = async_contextVar3;
                        sb5 = sb7;
                        i37 = i39;
                        bArr13 = bArr22;
                        break;
                    }
                    bArr10 = bArr8;
                    j19 = j27;
                    str = str3;
                    async_contextVar = async_contextVar3;
                    sb5 = sb7;
                    i37 = i39;
                    bArr13 = bArr22;
                    break;
                case com.tencent.luggage.wxa.uf.l.CTRL_INDEX /* 792 */:
                    str3 = str4;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    i39 = i48;
                    async_contextVar3 = b16;
                    byte[] bArr31 = async_contextVar3.tgtQR;
                    if (bArr31 != null && bArr31.length != 0) {
                        tlv_t tlv_tVar = new tlv_t(com.tencent.luggage.wxa.uf.l.CTRL_INDEX);
                        byte[] bArr32 = async_contextVar3.tgtQR;
                        tlv_tVar.set_data(bArr32, bArr32.length);
                        bArr16 = tlv_tVar.get_buf();
                        String str6 = "tgtQR len " + async_contextVar3.tgtQR.length;
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append(str3);
                        j27 = j17;
                        sb11.append(j27);
                        util.LOGI(str6, sb11.toString());
                        bArr10 = bArr8;
                        j19 = j27;
                        str = str3;
                        async_contextVar = async_contextVar3;
                        sb5 = sb7;
                        i37 = i39;
                        bArr13 = bArr16;
                        break;
                    } else {
                        j19 = j17;
                        bArr10 = bArr8;
                        str = str3;
                        async_contextVar = async_contextVar3;
                        sb5 = sb7;
                        i37 = i39;
                        bArr13 = bArr22;
                        break;
                    }
                case 1024:
                    async_contextVar = b16;
                    WloginSigInfo d16 = this.f422917m.d(j27, j26);
                    if (d16 != null && (bArr17 = d16._G) != null) {
                        if (bArr17.length != 0) {
                            byte[] bArr33 = d16._dpwd;
                            if (bArr33 != null) {
                                if (bArr33.length != 0) {
                                    byte[] bArr34 = d16._randseed;
                                    if (bArr34 != null) {
                                        if (bArr34.length != 0) {
                                            iArr = iArr3;
                                            arrayList = arrayList3;
                                            i38 = 38;
                                            j19 = j17;
                                            i39 = i48;
                                            bArr10 = bArr8;
                                            bArr22 = new tlv_t400().get_tlv_400(d16._G, j19, u.D, d16._dpwd, j3, j16, d16._randseed);
                                            str = str4;
                                            sb5 = sb7;
                                            i37 = i39;
                                            bArr13 = bArr22;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        bArr10 = bArr8;
                        str = str4;
                        j19 = j27;
                        i37 = i48;
                        sb5 = sb7;
                        arrayList = arrayList3;
                        iArr = iArr3;
                        i38 = 38;
                        bArr13 = bArr22;
                    }
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    j19 = j17;
                    bArr10 = bArr8;
                    str = str4;
                    i37 = i48;
                    sb5 = sb7;
                    bArr13 = bArr22;
                    break;
                case 1297:
                    async_contextVar = b16;
                    if (list != null && list.size() != 0) {
                        bArr18 = new tlv_t511().get_tlv_511(list);
                        bArr10 = bArr8;
                        bArr22 = bArr18;
                        str = str4;
                        j19 = j27;
                        i37 = i48;
                        sb5 = sb7;
                        arrayList = arrayList3;
                        iArr = iArr3;
                        i38 = 38;
                        bArr13 = bArr22;
                        break;
                    }
                    bArr10 = bArr8;
                    str = str4;
                    j19 = j27;
                    i37 = i48;
                    sb5 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    bArr13 = bArr22;
                    break;
                case gdt_analysis_event.EVENT_MOTIVE_CLOSE /* 1302 */:
                    async_contextVar = b16;
                    tlv_t tlv_tVar2 = new tlv_t(gdt_analysis_event.EVENT_MOTIVE_CLOSE);
                    byte[] bArr35 = new byte[4];
                    util.int32_to_buf(bArr35, 0, wUserSigInfo._source_type);
                    tlv_tVar2.set_data(bArr35, 4);
                    bArr18 = tlv_tVar2.get_buf();
                    bArr10 = bArr8;
                    bArr22 = bArr18;
                    str = str4;
                    j19 = j27;
                    i37 = i48;
                    sb5 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    bArr13 = bArr22;
                    break;
                case 1313:
                    async_contextVar = b16;
                    tlv_t tlv_tVar3 = new tlv_t(1313);
                    byte[] bArr36 = new byte[6];
                    util.int32_to_buf(bArr36, 0, u.f422942s0);
                    util.int16_to_buf(bArr36, 4, 0);
                    tlv_tVar3.set_data(bArr36, 6);
                    bArr10 = bArr8;
                    bArr22 = tlv_tVar3.get_buf();
                    str = str4;
                    j19 = j27;
                    i37 = i48;
                    sb5 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    bArr13 = bArr22;
                    break;
                case 1317:
                    async_contextVar = b16;
                    try {
                        j36 = System.currentTimeMillis();
                        tlv_t tlv_tVar4 = new tlv_t(1334);
                        byte[] loginExtraData = ProtocolDet.getLoginExtraData(this.f422905a);
                        if (loginExtraData == null || loginExtraData.length <= 0) {
                            util.LOGI("TGTGT 0x536:null", j27 + str4);
                        } else {
                            util.LOGI("TGTGT 0x536:" + loginExtraData.length + ":" + util.buf_to_string(loginExtraData), j27 + str4);
                            tlv_tVar4.set_data(loginExtraData, loginExtraData.length);
                            byte[] bArr37 = tlv_tVar4.get_buf();
                            tlv_t tlv_tVar5 = new tlv_t(1317);
                            int length = bArr37.length + 2;
                            byte[] bArr38 = new byte[length];
                            util.int16_to_buf(bArr38, 0, 1);
                            System.arraycopy(bArr37, 0, bArr38, 2, bArr37.length);
                            tlv_tVar5.set_data(bArr38, length);
                            bArr22 = tlv_tVar5.get_buf();
                        }
                        j37 = System.currentTimeMillis();
                        util.LOGI("TGTGT 0x536 cost:" + (j37 - j36), str4);
                    } catch (Throwable th5) {
                        util.LOGI("TGTGT tlv536 error " + Log.getStackTraceString(th5), j27 + str4);
                    }
                    bArr10 = bArr8;
                    str = str4;
                    j19 = j27;
                    i37 = i48;
                    sb5 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    bArr13 = bArr22;
                    i38 = 38;
                    break;
                case 1348:
                    async_contextVar = b16;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    byte[] bytes = util.SDK_VERSION.getBytes();
                    byte[] bArr39 = new byte[u.D.length + 10 + 2 + bytes.length + 4];
                    util.int64_to_buf(bArr39, 0, (int) j27);
                    util.int16_to_buf(bArr39, 4, u.D.length);
                    byte[] bArr40 = u.D;
                    System.arraycopy(bArr40, 0, bArr39, 6, bArr40.length);
                    int length2 = u.D.length + 6;
                    util.int16_to_buf(bArr39, length2, bytes.length);
                    int i58 = length2 + 2;
                    System.arraycopy(bytes, 0, bArr39, i58, bytes.length);
                    util.int32_to_buf(bArr39, i58 + bytes.length, this.f422915k);
                    bArr22 = new tlv_t544().get_tlv_544(String.valueOf(j17), "810_9", bArr39);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    util.LOGI("tgt 0x544 cost:" + (currentTimeMillis3 - currentTimeMillis2), str4 + j27);
                    bArr10 = bArr8;
                    str = str4;
                    j29 = currentTimeMillis3;
                    j28 = currentTimeMillis2;
                    j19 = j27;
                    i37 = i48;
                    sb5 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    bArr13 = bArr22;
                    i38 = 38;
                    break;
                case 1349:
                    async_contextVar = b16;
                    bArr18 = new tlv_t545().get_tlv_545(oicq.wlogin_sdk.utils.b.c(u.f422949w));
                    bArr10 = bArr8;
                    bArr22 = bArr18;
                    str = str4;
                    j19 = j27;
                    i37 = i48;
                    sb5 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    bArr13 = bArr22;
                    break;
                case CardContainerDataServiceImpl.CARD_CONTAINER_POS_ID /* 1352 */:
                    async_contextVar = b16;
                    byte[] bArr41 = u.f422933j0;
                    if (bArr41 != null && bArr41.length > 0) {
                        byte[] bArr42 = new tlv_t548().get_tlv_548(u.f422933j0);
                        if (bArr42 != null && bArr42.length > 0) {
                            bArr22 = bArr42;
                        }
                        StringBuilder sb12 = new StringBuilder();
                        sb12.append("t548_data ");
                        sb12.append(bArr42 == null ? 0 : bArr42.length);
                        util.LOGI(sb12.toString(), str4);
                        bArr10 = bArr8;
                        str = str4;
                        j19 = j27;
                        i37 = i48;
                        sb5 = sb7;
                        arrayList = arrayList3;
                        iArr = iArr3;
                        bArr13 = bArr22;
                        i38 = 38;
                        break;
                    }
                    bArr10 = bArr8;
                    str = str4;
                    j19 = j27;
                    i37 = i48;
                    sb5 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    bArr13 = bArr22;
                    break;
                case tlv_t553.CMD_553 /* 1363 */:
                    async_contextVar = b16;
                    bArr18 = new tlv_t553().get_tlv_t553(QSec.getInstance().getFeKitAttach(this.f422905a, String.valueOf(j17), "0x810", "0x9"));
                    bArr10 = bArr8;
                    bArr22 = bArr18;
                    str = str4;
                    j19 = j27;
                    i37 = i48;
                    sb5 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    bArr13 = bArr22;
                    break;
                default:
                    str = str4;
                    async_contextVar = b16;
                    bArr10 = bArr21;
                    j19 = j27;
                    i37 = i48;
                    sb5 = sb7;
                    arrayList = arrayList3;
                    iArr = iArr3;
                    i38 = 38;
                    bArr13 = bArr22;
                    break;
            }
            ArrayList arrayList4 = arrayList;
            if (bArr13 != null) {
                arrayList4.add(bArr13);
                i49 += bArr13.length;
            }
            i48 = i37 + 1;
            j26 = j3;
            bArr19 = bArr6;
            i47 = i18;
            j27 = j19;
            arrayList3 = arrayList4;
            bArr21 = bArr10;
            str4 = str;
            iArr2 = iArr;
            i56 = i38;
            b16 = async_contextVar;
            sb7 = sb5;
            bArr20 = bArr7;
            wUserSigInfo2 = wUserSigInfo;
        }
        WUserSigInfo wUserSigInfo3 = wUserSigInfo2;
        StringBuilder sb13 = sb7;
        ArrayList arrayList5 = arrayList3;
        int i59 = i49;
        for (Integer num : wUserSigInfo3.extraLoginTLVMap.keySet()) {
            byte[] bArr43 = wUserSigInfo3.extraLoginTLVMap.get(num).get_buf();
            arrayList5.add(bArr43);
            i59 += bArr43.length;
            sb13.append("Extra Tlv from user\uff1a0x" + num + " len:" + bArr43.length);
        }
        util.LOGI(sb13.toString());
        byte[] bArr44 = new byte[i59];
        int size = arrayList5.size();
        int i65 = 0;
        for (int i66 = 0; i66 < size; i66++) {
            byte[] bArr45 = (byte[]) arrayList5.get(i66);
            System.arraycopy(bArr45, 0, bArr44, i65, bArr45.length);
            i65 += bArr45.length;
        }
        a.b.f422849a.a(1, System.currentTimeMillis() - currentTimeMillis, j29 - j28, j37 - j36);
        return a(bArr44, this.f422915k, size);
    }

    public int a(long j3, long j16, long j17, int i3, byte[] bArr, byte[] bArr2, byte[] bArr3, int i16, int i17, int i18, long[] jArr, int i19, long j18, int i26, int i27, int i28, int i29, byte[] bArr4, WUserSigInfo wUserSigInfo) {
        int a16;
        String str;
        String str2;
        WUserSigInfo wUserSigInfo2 = wUserSigInfo;
        String str3 = "";
        int i36 = u.f422953z;
        async_context b16 = u.b(this.f422917m.f422959f);
        byte[] bArr5 = util.get_rand_16byte(u.E);
        b16._tgtgt_key = bArr5;
        tlv_t104 tlv_t104Var = b16.get_t104();
        if (tlv_t104Var == null) {
            tlv_t104Var = new tlv_t104();
        }
        tlv_t104 tlv_t104Var2 = tlv_t104Var;
        String str4 = "0x07";
        tlv_t544.report("0x07", "0");
        try {
            oicq.wlogin_sdk.persistence.d dVar = (oicq.wlogin_sdk.persistence.d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(this.f422905a, "wlogin_a1_empty")).edit();
            dVar.putString("uin", "");
            dVar.putLong("appid", 0L);
            dVar.putLong("timestamp", 0L);
            dVar.f422793b.commit();
        } catch (Exception e16) {
            util.printException(e16);
        }
        int i37 = 0;
        while (true) {
            String str5 = str4;
            int i38 = i37;
            byte[] bArr6 = bArr5;
            String str6 = str3;
            a(j17, a(j3, j16, i36, j17, i3, bArr, bArr2, bArr3, bArr6, i16, null, null, i17, i18, jArr, i19, j18, i26, i27, i28, i29, bArr4, tlv_t104Var2.get_data(), u.G, wUserSigInfo2._domains, wUserSigInfo), this.f422918n);
            a16 = a(String.valueOf(this.f422917m.f422957d), false, wUserSigInfo);
            if (a16 != 0) {
                str = "2";
                str2 = str5;
                break;
            }
            str2 = str5;
            a16 = d();
            StringBuilder sb5 = new StringBuilder();
            str3 = str6;
            sb5.append(str3);
            sb5.append(j17);
            util.LOGI("retry num:" + i38 + " ret:" + a16, sb5.toString());
            if (a16 != 180) {
                str = "3";
                break;
            }
            int i39 = i38 + 1;
            if (i38 >= 1) {
                break;
            }
            wUserSigInfo2 = wUserSigInfo;
            i37 = i39;
            bArr5 = bArr6;
            str4 = str2;
        }
        tlv_t544.report(str2, str);
        tlv_t544.report(str2, "1");
        return a16;
    }
}
