package oicq.wlogin_sdk.request;

import android.content.Context;
import com.tencent.loginsecsdk.ProtocolDet;
import com.tencent.mobileqq.cardcontainer.api.impl.CardContainerDataServiceImpl;
import com.tencent.mobileqq.qsec.qsecurity.QSec;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.qphone.base.BaseConstants;
import java.util.ArrayList;
import java.util.HashMap;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t109;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t124;
import oicq.wlogin_sdk.tlv_type.tlv_t128;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t147;
import oicq.wlogin_sdk.tlv_type.tlv_t154;
import oicq.wlogin_sdk.tlv_type.tlv_t16e;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tlv_type.tlv_t177;
import oicq.wlogin_sdk.tlv_type.tlv_t18;
import oicq.wlogin_sdk.tlv_type.tlv_t202;
import oicq.wlogin_sdk.tlv_type.tlv_t400;
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tlv_type.tlv_t545;
import oicq.wlogin_sdk.tlv_type.tlv_t548;
import oicq.wlogin_sdk.tlv_type.tlv_t553;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class m extends oicq_request {
    public m(u uVar, Context context) {
        this.f422914j = 2064;
        this.f422915k = 25;
        this.f422916l = BaseConstants.CMD_WT_LOGIN_AUTH;
        this.f422917m = uVar;
        uVar.f422964k = 0;
        this.f422905a = context;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0044. Please report as an issue. */
    public int a(WUserSigInfo wUserSigInfo, long j3, long j16, int i3, int i16, long[] jArr) {
        int a16;
        StringBuilder sb5;
        ArrayList arrayList;
        int[] iArr;
        int i17;
        byte[] bArr;
        async_context async_contextVar;
        int i18;
        int i19;
        int i26;
        tlv_t tlv_tVar;
        byte[] loginExtraData;
        byte[] bArr2;
        async_context async_contextVar2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        ArrayList arrayList2;
        byte[] bArr6;
        byte[] bArr7;
        WUserSigInfo wUserSigInfo2 = wUserSigInfo;
        long j17 = j3;
        int i27 = 0;
        int i28 = 0;
        while (true) {
            byte[] bArr8 = u.f422924a0;
            int i29 = 26;
            int[] iArr2 = {256, 264, 292, 296, 1325, 278, 340, 8, 283, 1313, CardContainerDataServiceImpl.CARD_CONTAINER_POS_ID, 1348, QidPagView.DESIGN_PAG_WIDTH, 322, 327, 325, 514, 1024, 1349, 1317, 370, 24, 265, 366, 260, tlv_t553.CMD_553};
            ArrayList arrayList3 = new ArrayList();
            StringBuilder sb6 = new StringBuilder("request_checkA1List");
            sb6.append(" getRequestBody");
            async_context b16 = u.b(this.f422917m.f422959f);
            int i36 = i27;
            int i37 = i36;
            int i38 = i37;
            while (i36 < i29) {
                byte[] bArr9 = new byte[i27];
                async_context async_contextVar3 = b16;
                int i39 = i36;
                switch (iArr2[i36]) {
                    case 8:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        i19 = i27;
                        async_contextVar = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr = bArr8;
                        bArr2 = new tlv_t8().get_tlv_8(i19, u.f422951x, i19);
                        bArr9 = bArr2;
                        break;
                    case 24:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        i19 = i27;
                        async_contextVar = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr = bArr8;
                        bArr2 = new tlv_t18().get_tlv_18(j3, u.f422953z, 0L, 0);
                        bArr9 = bArr2;
                        break;
                    case 256:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        i19 = i27;
                        i18 = i39;
                        i26 = 26;
                        bArr = bArr8;
                        async_contextVar = async_contextVar3;
                        bArr2 = new tlv_t100().get_tlv_100(async_contextVar3._appid, async_contextVar3._sub_appid, 0, async_contextVar3._main_sigmap);
                        bArr9 = bArr2;
                        break;
                    case 260:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        i19 = i27;
                        async_contextVar2 = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr = bArr8;
                        bArr3 = new tlv_t104().get_tlv_104(async_contextVar2.get_t104().get_data());
                        bArr9 = bArr3;
                        async_contextVar = async_contextVar2;
                        break;
                    case 264:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        i19 = i27;
                        async_contextVar2 = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr = bArr8;
                        bArr3 = new tlv_t108().get_tlv_108(bArr);
                        bArr9 = bArr3;
                        async_contextVar = async_contextVar2;
                        break;
                    case 265:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        bArr4 = bArr8;
                        i19 = i27;
                        async_contextVar2 = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr5 = new tlv_t109().get_tlv_109(oicq.wlogin_sdk.utils.a.a(u.f422949w));
                        bArr9 = bArr5;
                        bArr = bArr4;
                        async_contextVar = async_contextVar2;
                        break;
                    case 278:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        bArr4 = bArr8;
                        i19 = i27;
                        async_contextVar2 = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr5 = new tlv_t116().get_tlv_116(i3, i16, jArr);
                        bArr9 = bArr5;
                        bArr = bArr4;
                        async_contextVar = async_contextVar2;
                        break;
                    case 283:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        bArr4 = bArr8;
                        i19 = i27;
                        async_contextVar2 = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        tlv_t tlv_tVar2 = new tlv_t(283);
                        byte[] bArr10 = new byte[1];
                        bArr10[i19] = 2;
                        tlv_tVar2.set_data(bArr10, 1);
                        bArr5 = tlv_tVar2.get_buf();
                        bArr9 = bArr5;
                        bArr = bArr4;
                        async_contextVar = async_contextVar2;
                        break;
                    case 292:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        bArr4 = bArr8;
                        i19 = i27;
                        async_contextVar2 = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr5 = new tlv_t124().get_tlv_124(util.get_os_type(), util.get_os_version(), u.F, oicq.wlogin_sdk.utils.b.d(this.f422905a), new byte[i19], u.H);
                        bArr9 = bArr5;
                        bArr = bArr4;
                        async_contextVar = async_contextVar2;
                        break;
                    case 296:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        bArr4 = bArr8;
                        i19 = i27;
                        async_contextVar2 = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr5 = new tlv_t128().get_tlv_128(u.S, u.T, u.U, u.X, oicq.wlogin_sdk.utils.b.b(u.f422949w), u.D, u.O);
                        bArr9 = bArr5;
                        bArr = bArr4;
                        async_contextVar = async_contextVar2;
                        break;
                    case 322:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        bArr4 = bArr8;
                        i19 = i27;
                        async_contextVar2 = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr5 = new tlv_t142().get_tlv_142(u.G);
                        bArr9 = bArr5;
                        bArr = bArr4;
                        async_contextVar = async_contextVar2;
                        break;
                    case 325:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        bArr4 = bArr8;
                        i19 = i27;
                        async_contextVar2 = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr5 = new tlv_t145().get_tlv_145(u.D);
                        bArr9 = bArr5;
                        bArr = bArr4;
                        async_contextVar = async_contextVar2;
                        break;
                    case 327:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        bArr4 = bArr8;
                        i19 = i27;
                        async_contextVar2 = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr5 = new tlv_t147().get_tlv_147(j17, u.I, u.J);
                        bArr9 = bArr5;
                        bArr = bArr4;
                        async_contextVar = async_contextVar2;
                        break;
                    case 340:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        bArr4 = bArr8;
                        i19 = i27;
                        async_contextVar2 = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr5 = new tlv_t154().get_tlv_154(this.f422917m.f422960g);
                        bArr9 = bArr5;
                        bArr = bArr4;
                        async_contextVar = async_contextVar2;
                        break;
                    case 366:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        bArr4 = bArr8;
                        i19 = i27;
                        async_contextVar2 = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr5 = new tlv_t16e().get_tlv_16e(oicq.wlogin_sdk.utils.b.b(u.f422949w));
                        bArr9 = bArr5;
                        bArr = bArr4;
                        async_contextVar = async_contextVar2;
                        break;
                    case 370:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        bArr4 = bArr8;
                        i19 = i27;
                        async_contextVar2 = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        byte[] bArr11 = this.f422917m.f422968o;
                        if (bArr11 != null && bArr11.length != 0) {
                            bArr5 = new tlv_t172().get_tlv_172(this.f422917m.f422968o);
                            bArr9 = bArr5;
                            bArr = bArr4;
                            async_contextVar = async_contextVar2;
                            break;
                        }
                        bArr = bArr4;
                        async_contextVar = async_contextVar2;
                        break;
                    case QidPagView.DESIGN_PAG_WIDTH /* 375 */:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        bArr4 = bArr8;
                        i19 = i27;
                        async_contextVar2 = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr5 = new tlv_t177().get_tlv_177(util.BUILD_TIME, util.SDK_VERSION);
                        bArr9 = bArr5;
                        bArr = bArr4;
                        async_contextVar = async_contextVar2;
                        break;
                    case 514:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        bArr4 = bArr8;
                        i19 = i27;
                        async_contextVar2 = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        byte[] bArr12 = u.Q;
                        if (bArr12 != null && bArr12.length != 0) {
                            bArr5 = new tlv_t202().get_tlv_202(u.Q, u.R);
                            bArr9 = bArr5;
                            bArr = bArr4;
                            async_contextVar = async_contextVar2;
                            break;
                        }
                        bArr = bArr4;
                        async_contextVar = async_contextVar2;
                        break;
                    case 1024:
                        j17 = j3;
                        WloginSigInfo d16 = this.f422917m.d(0L, j17);
                        if (d16 != null && (bArr6 = d16._G) != null) {
                            if (bArr6.length != 0) {
                                byte[] bArr13 = d16._dpwd;
                                if (bArr13 != null) {
                                    if (bArr13.length != 0) {
                                        byte[] bArr14 = d16._randseed;
                                        if (bArr14 != null) {
                                            if (bArr14.length != 0) {
                                                async_contextVar2 = async_contextVar3;
                                                i18 = i39;
                                                sb5 = sb6;
                                                arrayList = arrayList3;
                                                iArr = iArr2;
                                                i26 = 26;
                                                i17 = i28;
                                                bArr4 = bArr8;
                                                i19 = i27;
                                                bArr5 = new tlv_t400().get_tlv_400(d16._G, 0L, u.D, d16._dpwd, j3, j16, d16._randseed);
                                                bArr9 = bArr5;
                                                bArr = bArr4;
                                                async_contextVar = async_contextVar2;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            sb5 = sb6;
                            arrayList = arrayList3;
                            iArr = iArr2;
                            i17 = i28;
                            i19 = i27;
                            async_contextVar = async_contextVar3;
                            i18 = i39;
                            i26 = 26;
                            bArr = bArr8;
                            break;
                        }
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        i19 = i27;
                        i18 = i39;
                        i26 = 26;
                        bArr = bArr8;
                        async_contextVar = async_contextVar3;
                        break;
                    case 1313:
                        tlv_t tlv_tVar3 = new tlv_t(1313);
                        byte[] bArr15 = new byte[6];
                        i27 = 0;
                        util.int32_to_buf(bArr15, 0, u.f422942s0);
                        util.int16_to_buf(bArr15, 4, 0);
                        tlv_tVar3.set_data(bArr15, 6);
                        bArr7 = tlv_tVar3.get_buf();
                        j17 = j3;
                        bArr9 = bArr7;
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        i19 = i27;
                        async_contextVar = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr = bArr8;
                        break;
                    case 1317:
                        try {
                            tlv_tVar = new tlv_t(1334);
                            loginExtraData = ProtocolDet.getLoginExtraData(this.f422905a);
                        } catch (Exception e16) {
                            util.printException(e16, "");
                        }
                        if (loginExtraData == null || loginExtraData.length <= 0) {
                            util.LOGI("TGTGT 0x536:null", "0");
                            j17 = j3;
                            sb5 = sb6;
                            arrayList = arrayList3;
                            iArr = iArr2;
                            i17 = i28;
                            bArr = bArr8;
                            async_contextVar = async_contextVar3;
                            i18 = i39;
                            i19 = 0;
                            i26 = 26;
                            break;
                        } else {
                            util.LOGI("TGTGT 0x536:" + loginExtraData.length + ":" + util.buf_to_string(loginExtraData), "0");
                            tlv_tVar.set_data(loginExtraData, loginExtraData.length);
                            byte[] bArr16 = tlv_tVar.get_buf();
                            tlv_t tlv_tVar4 = new tlv_t(1317);
                            int length = bArr16.length + 2;
                            byte[] bArr17 = new byte[length];
                            util.int16_to_buf(bArr17, 0, 1);
                            System.arraycopy(bArr16, 0, bArr17, 2, bArr16.length);
                            tlv_tVar4.set_data(bArr17, length);
                            j17 = j3;
                            bArr9 = tlv_tVar4.get_buf();
                            sb5 = sb6;
                            arrayList = arrayList3;
                            iArr = iArr2;
                            i17 = i28;
                            bArr = bArr8;
                            async_contextVar = async_contextVar3;
                            i18 = i39;
                            i19 = 0;
                            i26 = 26;
                        }
                        break;
                    case 1325:
                        bArr7 = new tlv_t52d().get_tlv_52d(this.f422905a);
                        bArr9 = bArr7;
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        i19 = i27;
                        async_contextVar = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr = bArr8;
                        break;
                    case 1348:
                        byte[] bytes = util.SDK_VERSION.getBytes();
                        byte[] bArr18 = new byte[u.D.length + 10 + 2 + bytes.length + 4];
                        util.int64_to_buf(bArr18, i27, (int) 0);
                        util.int16_to_buf(bArr18, 8, u.D.length);
                        byte[] bArr19 = u.D;
                        System.arraycopy(bArr19, i27, bArr18, 10, bArr19.length);
                        int length2 = u.D.length + 10;
                        util.int16_to_buf(bArr18, length2, bytes.length);
                        int i46 = length2 + 2;
                        System.arraycopy(bytes, i27, bArr18, i46, bytes.length);
                        util.int32_to_buf(bArr18, i46 + bytes.length, this.f422915k);
                        bArr7 = new tlv_t544().get_tlv_544(String.valueOf(0L), "810_25", bArr18);
                        bArr9 = bArr7;
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        i19 = i27;
                        async_contextVar = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr = bArr8;
                        break;
                    case 1349:
                        bArr7 = new tlv_t545().get_tlv_545(oicq.wlogin_sdk.utils.b.c(u.f422949w));
                        bArr9 = bArr7;
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        i19 = i27;
                        async_contextVar = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr = bArr8;
                        break;
                    case CardContainerDataServiceImpl.CARD_CONTAINER_POS_ID /* 1352 */:
                        tlv_t548 tlv_t548Var = new tlv_t548();
                        bArr9 = new byte[i27];
                        byte[] bArr20 = u.f422933j0;
                        if (bArr20 != null && bArr20.length > 0) {
                            bArr7 = tlv_t548Var.get_tlv_548(bArr20);
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("t548 len:");
                            sb7.append(bArr7 == null ? i27 : bArr7.length);
                            util.LOGI(sb7.toString(), "");
                            bArr9 = bArr7;
                        }
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        i19 = i27;
                        async_contextVar = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr = bArr8;
                        break;
                    case tlv_t553.CMD_553 /* 1363 */:
                        bArr7 = new tlv_t553().get_tlv_t553(QSec.getInstance().getFeKitAttach(this.f422905a, String.valueOf(0L), "0x810", "0x19"));
                        bArr9 = bArr7;
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        i19 = i27;
                        async_contextVar = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr = bArr8;
                        break;
                    default:
                        sb5 = sb6;
                        arrayList = arrayList3;
                        iArr = iArr2;
                        i17 = i28;
                        i19 = i27;
                        async_contextVar = async_contextVar3;
                        i18 = i39;
                        i26 = 26;
                        bArr = bArr8;
                        break;
                }
                if (bArr9.length > 4) {
                    i38++;
                    i37 += bArr9.length;
                    arrayList2 = arrayList;
                    arrayList2.add(bArr9);
                } else {
                    arrayList2 = arrayList;
                }
                i36 = i18 + 1;
                arrayList3 = arrayList2;
                bArr8 = bArr;
                b16 = async_contextVar;
                iArr2 = iArr;
                i29 = i26;
                sb6 = sb5;
                i28 = i17;
                i27 = i19;
                wUserSigInfo2 = wUserSigInfo;
            }
            WUserSigInfo wUserSigInfo3 = wUserSigInfo2;
            StringBuilder sb8 = sb6;
            ArrayList arrayList4 = arrayList3;
            int i47 = i28;
            boolean z16 = i27;
            HashMap<Integer, tlv_t> hashMap = wUserSigInfo3.extraLoginTLVMap;
            if (hashMap != null) {
                for (Integer num : hashMap.keySet()) {
                    tlv_t tlv_tVar5 = wUserSigInfo3.extraLoginTLVMap.get(num);
                    if (tlv_tVar5 != null) {
                        byte[] bArr21 = tlv_tVar5.get_buf();
                        i38++;
                        arrayList4.add(bArr21);
                        i37 += bArr21.length;
                        sb8.append(",key=");
                        sb8.append(num);
                        sb8.append(",Buff=");
                        sb8.append(bArr21.length);
                    }
                }
            }
            int i48 = i38;
            byte[] bArr22 = new byte[i37];
            int i49 = z16 ? 1 : 0;
            int i56 = i49;
            while (i56 < i48) {
                byte[] bArr23 = (byte[]) arrayList4.get(i56);
                System.arraycopy(bArr23, z16 ? 1 : 0, bArr22, i49, bArr23.length);
                i49 += bArr23.length;
                i56++;
                arrayList4 = arrayList4;
            }
            sb8.append(",tlvCnt=");
            sb8.append(i48);
            util.LOGI(sb8.toString(), "");
            a(this.f422917m.f422957d, a(bArr22, this.f422915k, i48), this.f422918n);
            a16 = a(String.valueOf(this.f422917m.f422957d), z16, wUserSigInfo3);
            if (a16 == 0) {
                a16 = d();
                util.LOGI("request_checkA1List,retry num:" + i47 + ",ret:" + a16, "" + this.f422917m.f422957d);
                if (a16 == 180) {
                    int i57 = i47 + 1;
                    if (i47 < 1) {
                        i27 = z16 ? 1 : 0;
                        i28 = i57;
                        wUserSigInfo2 = wUserSigInfo3;
                    }
                }
            }
        }
        return a16;
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
        if (tlv_t543Var.get_tlv(bArr, i17, this.f422907c - i17) > 0) {
            b16._t543 = tlv_t543Var;
        }
        tlv_t104 tlv_t104Var = new tlv_t104();
        if (tlv_t104Var.get_tlv(bArr, i17, this.f422907c - i17) >= 0) {
            b16.set_t104(tlv_t104Var);
        }
        if (b17 == 0) {
            return b17;
        }
        b(bArr, i17, (this.f422907c - i17) - 1);
        return b17;
    }
}
