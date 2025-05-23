package j13;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.handler.d;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.e;
import com.tencent.mobileqq.c2cshortcutbar.g;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.api.IVasLiangNum;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tenpay.sdk.download.HttpOp;
import gxh_message.Dialogue;
import hx3.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f409128a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.apollo.handler.b f409129b;

    /* compiled from: P */
    /* renamed from: j13.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C10564a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Intent f409130d;

        C10564a(Intent intent) {
            this.f409130d = intent;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            a.this.j(this.f409130d, z16, (byte[]) obj);
        }
    }

    public static boolean A(int[] iArr, oidb_0x5eb$ReqBody oidb_0x5eb_reqbody, boolean z16, int i3) {
        switch (iArr[i3]) {
            case ProfileContants.FIELD_THEME_FONT_TYPE /* 27373 */:
                oidb_0x5eb_reqbody.uint32_req_theme_font_id.set(1);
                return z16;
            case 27375:
                oidb_0x5eb_reqbody.uint32_req_vip_ext_id.set(1);
                return z16;
            case ProfileContants.FIELD_QQ_LEVEL_ICON_TYPE /* 42334 */:
                oidb_0x5eb_reqbody.uint32_req_qq_level_icon_type_id.set(1);
                return z16;
            case 42417:
                oidb_0x5eb_reqbody.uint32_c2c_aio_shortcut_switch.set(1);
                return z16;
            case 42489:
                oidb_0x5eb_reqbody.uint32_file_assist_top.set(1);
                return z16;
            case HttpOp.HTTP_READTIMEOUT /* 45000 */:
                oidb_0x5eb_reqbody.uint32_bubble_unread_switch.set(1);
                return z16;
            case 45033:
                oidb_0x5eb_reqbody.uint32_req_listen_together_player_id.set(1);
                return true;
            default:
                return z16;
        }
    }

    private static void B(int[] iArr, oidb_0x5eb$ReqBody oidb_0x5eb_reqbody, int i3) {
        switch (iArr[i3]) {
            case 27235:
                oidb_0x5eb_reqbody.uint32_req_vas_pendant_diy_id.set(1);
                return;
            case 27236:
                oidb_0x5eb_reqbody.uint32_req_suspend_effect_id.set(1);
                return;
            case 27238:
                oidb_0x5eb_reqbody.uint32_req_vas_face_id.set(1);
                return;
            case ProfileContants.FIELD_VIP_DIY_FONT_TIMESTAMP /* 27241 */:
                oidb_0x5eb_reqbody.uint32_req_vas_diy_font_timestamp_flag.set(1);
                return;
            case ProfileContants.FIELD_VIP_FONT_EFFECT /* 27254 */:
                oidb_0x5eb_reqbody.uint32_req_font_effect_id.set(1);
                return;
            case ProfileContants.FIELD_KING_GAME_DAN_DISPLAY_SWITCH /* 42121 */:
                oidb_0x5eb_reqbody.uint32_plate_of_king_dan_display_switch.set(1);
                return;
            case ProfileContants.FIELD_KING_GAME_DAN /* 42122 */:
                oidb_0x5eb_reqbody.uint32_plate_of_king_dan.set(1);
                return;
            case ProfileContants.FIELD_HAOMA_NAMEPLATE /* 47218 */:
                oidb_0x5eb_reqbody.uint32_haoma_nameplate.set(1);
                break;
            case ProfileContants.FILED_KID_MODE_URL_FILTER_SWITCH /* 47222 */:
                break;
            default:
                return;
        }
        oidb_0x5eb_reqbody.uint32_flag_kid_mode_can_filter_url.set(1);
    }

    public static void c(QQAppInterface qQAppInterface, String[] strArr, int[] iArr, int i3) {
        if (qQAppInterface == null) {
            return;
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        ArrayList arrayList = new ArrayList();
        boolean z16 = false;
        for (String str : strArr) {
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        String[] strArr2 = (String[]) arrayList.toArray(new String[1]);
        for (String str2 : strArr2) {
            try {
                oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(str2)));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        int i16 = 0;
        boolean z17 = false;
        while (true) {
            if (i16 >= iArr.length) {
                break;
            }
            if (iArr[i16] == 42255) {
                oidb_0x5eb_reqbody.roam_flag_qq_7day.set(1);
                oidb_0x5eb_reqbody.roam_flag_vip_30day.set(1);
                oidb_0x5eb_reqbody.roam_flag_svip_2year.set(1);
                oidb_0x5eb_reqbody.roam_flag_svip_5year.set(1);
                oidb_0x5eb_reqbody.roam_flag_svip_forever.set(1);
                z16 = true;
                break;
            }
            z(iArr, oidb_0x5eb_reqbody, i16);
            z17 = A(iArr, oidb_0x5eb_reqbody, z17, i16);
            i16++;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GetStrangerVasInfoHandler", 2, "batchGetStrangerVasInfo, uins: " + Arrays.toString(strArr2) + " fields: " + Arrays.toString(iArr));
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1515);
        oidb_sso_oidbssopkg.uint32_service_type.set(i3);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x5eb_reqbody.toByteArray()));
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), com.tencent.mobileqq.apollo.utils.a.b());
        newIntent.putExtra("cmd", "OidbSvc.0x5eb_99");
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.putExtra("req_roam_type", z16);
        newIntent.putExtra("req_music_type", z17);
        newIntent.putExtra("uins", strArr2);
        qQAppInterface.startServlet(newIntent);
    }

    private void d(int i3, int i16, boolean z16) {
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d(FontManagerConstants.TAG, 2, "0x5eb self has diy timestamp fontid = " + i3 + " timestamp = " + i16);
            }
            NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f409128a.getCurrentAccountUin()), "GetStrangerVasInfoHandler");
            IFontManagerService iFontManagerService = (IFontManagerService) this.f409128a.getRuntimeService(IFontManagerService.class, "");
            QQAppInterface qQAppInterface = this.f409128a;
            iFontManagerService.checkUpdateDIYConfig(qQAppInterface, qQAppInterface.getCurrentAccountUin(), vasSimpleInfoWithUid, i3, i16);
        }
    }

    private void e(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        try {
            if (oidb_0x5eb_udcuindata.uint32_bubble_id.has()) {
                ((ISVIPHandler) this.f409128a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).setSelfBubbleId(oidb_0x5eb_udcuindata.uint32_bubble_id.get());
            }
        } catch (Exception e16) {
            QLog.e("GetStrangerVasInfoHandler", 1, "" + e16.getMessage());
        }
    }

    private void f(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        boolean z16;
        if (oidb_0x5eb_udcuindata.uint32_bubble_unread_switch.has()) {
            int i3 = oidb_0x5eb_udcuindata.uint32_bubble_unread_switch.get();
            BubbleManager bubbleManager = (BubbleManager) this.f409128a.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
            if (bubbleManager != null) {
                e eVar = bubbleManager.H;
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                eVar.b(z16);
            }
            if (QLog.isColorLevel()) {
                QLog.d("GetStrangerVasInfoHandler", 1, "uint32_bubble_unread_switch : " + i3);
            }
        }
    }

    private void g(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        if (oidb_0x5eb_udcuindata.uint32_c2c_aio_shortcut_switch.has()) {
            boolean z16 = true;
            if (oidb_0x5eb_udcuindata.uint32_c2c_aio_shortcut_switch.get() != 1) {
                z16 = false;
            }
            g.i(this.f409128a, z16);
        }
    }

    private boolean h(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata, boolean z16, NTVasSimpleInfo nTVasSimpleInfo, NTVasSimpleInfo nTVasSimpleInfo2) {
        if (oidb_0x5eb_udcuindata.uint64_face_addon_id.has()) {
            long j3 = oidb_0x5eb_udcuindata.uint64_face_addon_id.get();
            if (nTVasSimpleInfo.pendantId != j3) {
                nTVasSimpleInfo.pendantId = j3;
                nTVasSimpleInfo.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String = NetConnInfoCenter.getServerTime();
            }
        }
        if (oidb_0x5eb_udcuindata.uint64_face_addon_id.has()) {
            long j16 = oidb_0x5eb_udcuindata.uint64_face_addon_id.get();
            if (nTVasSimpleInfo2.pendantId != j16) {
                nTVasSimpleInfo2.pendantId = j16;
                nTVasSimpleInfo2.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String = NetConnInfoCenter.getServerTime();
                return true;
            }
            return z16;
        }
        return z16;
    }

    private boolean i(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata, boolean z16, String str, NTVasSimpleInfo nTVasSimpleInfo, NTVasSimpleInfo nTVasSimpleInfo2) {
        StringBuilder sb5 = new StringBuilder();
        if (oidb_0x5eb_udcuindata.uint32_req_font_effect_id.has()) {
            int i3 = oidb_0x5eb_udcuindata.uint32_req_font_effect_id.get();
            if (QLog.isColorLevel()) {
                sb5.append("handleGetStrangerVasInfo uin = ");
                sb5.append(str);
                sb5.append(" fontEffect = ");
                sb5.append(i3);
                sb5.append(" extInfo.fontEffect = ");
                sb5.append(nTVasSimpleInfo.fontEffect);
                sb5.append("\n");
            }
            if (i3 != nTVasSimpleInfo.fontEffect) {
                nTVasSimpleInfo.fontEffect = i3;
                nTVasSimpleInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
            }
            if (i3 != nTVasSimpleInfo.fontEffect) {
                nTVasSimpleInfo2.fontEffect = i3;
                nTVasSimpleInfo2.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                sb5.append("handleGetStrangerVasInfo uin = ");
                sb5.append(str);
                sb5.append(" extInfo.fontEffect = ");
                sb5.append(nTVasSimpleInfo.fontEffect);
                sb5.append(" extInfo.fontEffectLastUpdateTime = ");
                sb5.append(nTVasSimpleInfo.fontEffectLastUpdateTime);
                sb5.append("\n");
            }
        }
        if (sb5.length() > 0) {
            QLog.d("GetStrangerVasInfoHandler", 2, sb5.toString());
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Intent intent, boolean z16, byte[] bArr) {
        int i3;
        if (QLog.isDebugVersion()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleGetStrangerVasInfo ");
            sb5.append(z16);
            sb5.append(", ");
            if (bArr != null) {
                i3 = bArr.length;
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            QLog.d("GetStrangerVasInfoHandler", 2, sb5.toString());
        }
        if (bArr != null && z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom(bArr);
                if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    n(intent, oidb_sso_oidbssopkg);
                } else {
                    w(62, false, null);
                }
                return;
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("GetStrangerVasInfoHandler", 2, "", th5);
                    return;
                }
                return;
            }
        }
        w(62, false, null);
    }

    private void k(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata, String str) {
        if (oidb_0x5eb_udcuindata.uint32_haoma_nameplate.has()) {
            ((IVasLiangNum) QRoute.api(IVasLiangNum.class)).saveLiangNumId(str, oidb_0x5eb_udcuindata.uint32_haoma_nameplate.get());
        }
    }

    private void l(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata, String str) {
        if (oidb_0x5eb_udcuindata.uint32_rsp_qq_level_icon_type.has()) {
            int i3 = oidb_0x5eb_udcuindata.uint32_rsp_qq_level_icon_type.get();
            FriendsManager friendsManager = (FriendsManager) this.f409128a.getManager(QQManagerFactory.FRIENDS_MANAGER);
            Card r16 = friendsManager.r(str + "");
            if (r16 != null && r16.mQQLevelType != i3) {
                r16.mQQLevelType = i3;
                friendsManager.p0(r16);
                this.f409128a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, r16);
            }
        }
    }

    private void n(Intent intent, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) throws InvalidProtocolBufferMicroException {
        NTVasSimpleInfo nTVasSimpleInfo;
        NTVasSimpleInfo nTVasSimpleInfo2;
        int i3;
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi;
        int i16;
        boolean z16;
        int i17;
        String str;
        int i18;
        boolean z17;
        oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata;
        oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
        oidb_0x5eb_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
        int size = oidb_0x5eb_rspbody.rpt_msg_uin_data.size();
        HashSet hashSet = new HashSet(size);
        ArrayList<NTVasSimpleInfo> arrayList = new ArrayList<>(size);
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi2 = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
        ArrayList<String> arrayList2 = new ArrayList<>();
        VasFaceManager vasFaceManager = ((ao) this.f409128a.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308429f;
        String str2 = "GetStrangerVasInfoHandler";
        boolean z18 = true;
        QLog.i("GetStrangerVasInfoHandler", 1, "response.rpt_msg_uin_data.size():" + size);
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        while (i26 < size) {
            oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata2 = oidb_0x5eb_rspbody.rpt_msg_uin_data.get(i26);
            String valueOf = String.valueOf(oidb_0x5eb_udcuindata2.uint64_uin.get());
            String uidFromUin = iRelationNTUinAndUidApi2.getUidFromUin(valueOf);
            NTVasSimpleInfo vasSimpleInfoWithUid = iVasInfoService.getVasSimpleInfoWithUid(uidFromUin, str2);
            int i28 = i26;
            if (vasSimpleInfoWithUid == null) {
                nTVasSimpleInfo = new NTVasSimpleInfo();
                nTVasSimpleInfo.e(uidFromUin);
                nTVasSimpleInfo.f(valueOf);
            } else {
                nTVasSimpleInfo = vasSimpleInfoWithUid;
            }
            oidb_0x5eb$RspBody oidb_0x5eb_rspbody2 = oidb_0x5eb_rspbody;
            NTVasSimpleInfo nTVasSimpleInfo3 = new NTVasSimpleInfo(uidFromUin, valueOf);
            nTVasSimpleInfo3.c();
            if (oidb_0x5eb_udcuindata2.uint32_vas_font_id.has()) {
                long j3 = oidb_0x5eb_udcuindata2.uint32_vas_font_id.get();
                nTVasSimpleInfo2 = nTVasSimpleInfo;
                int i29 = i27;
                if (valueOf.equals(this.f409128a.getCurrentAccountUin())) {
                    i19 = (int) FontManagerConstants.parseFontId(j3);
                    VasShieldFont.f32672e = i19;
                    if (QLog.isColorLevel()) {
                        i18 = i19;
                        QLog.d("VasShieldFont", 2, "handleGetStrangerVasInfo: " + VasShieldFont.f32672e);
                        i16 = i28;
                        i3 = i29;
                        i17 = size;
                        iRelationNTUinAndUidApi = iRelationNTUinAndUidApi2;
                        z16 = true;
                        str = valueOf;
                        z17 = v(false, nTVasSimpleInfo3, j3, nTVasSimpleInfo2);
                        oidb_0x5eb_udcuindata = oidb_0x5eb_udcuindata2;
                    }
                }
                i18 = i19;
                i16 = i28;
                i3 = i29;
                i17 = size;
                iRelationNTUinAndUidApi = iRelationNTUinAndUidApi2;
                z16 = true;
                str = valueOf;
                z17 = v(false, nTVasSimpleInfo3, j3, nTVasSimpleInfo2);
                oidb_0x5eb_udcuindata = oidb_0x5eb_udcuindata2;
            } else {
                nTVasSimpleInfo2 = nTVasSimpleInfo;
                i3 = i27;
                iRelationNTUinAndUidApi = iRelationNTUinAndUidApi2;
                i16 = i28;
                z16 = true;
                i17 = size;
                str = valueOf;
                i18 = i19;
                z17 = false;
                oidb_0x5eb_udcuindata = oidb_0x5eb_udcuindata2;
            }
            e(oidb_0x5eb_udcuindata);
            if (oidb_0x5eb_udcuindata.uint32_vas_diy_font_timestamp.has() && str.equals(this.f409128a.getCurrentAccountUin())) {
                i3 = oidb_0x5eb_udcuindata.uint32_vas_diy_font_timestamp.get();
            }
            oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata3 = oidb_0x5eb_udcuindata;
            String str3 = str2;
            boolean h16 = h(oidb_0x5eb_udcuindata3, i(oidb_0x5eb_udcuindata3, q(arrayList2, oidb_0x5eb_udcuindata, z17, str, nTVasSimpleInfo3, nTVasSimpleInfo2), str, nTVasSimpleInfo3, nTVasSimpleInfo2), nTVasSimpleInfo3, nTVasSimpleInfo2);
            k(oidb_0x5eb_udcuindata3, str);
            g(oidb_0x5eb_udcuindata3);
            r(oidb_0x5eb_udcuindata3, str);
            o(oidb_0x5eb_udcuindata3, str);
            f(oidb_0x5eb_udcuindata3);
            l(oidb_0x5eb_udcuindata3, str);
            p(oidb_0x5eb_udcuindata3);
            s(intent, oidb_0x5eb_udcuindata3, str);
            if (h16) {
                nTVasSimpleInfo3.timestamp = System.currentTimeMillis();
                hashSet.add(str);
                arrayList.add(nTVasSimpleInfo3);
            }
            i26 = i16 + 1;
            z18 = z16;
            oidb_0x5eb_rspbody = oidb_0x5eb_rspbody2;
            size = i17;
            i19 = i18;
            i27 = i3;
            str2 = str3;
            iRelationNTUinAndUidApi2 = iRelationNTUinAndUidApi;
        }
        boolean z19 = z18;
        d(i19, i27, z19);
        iVasInfoService.accurateUpdateVasSimpleInfo(arrayList, str2, (c<NTVasSimpleInfo>) null);
        vasFaceManager.s(arrayList2);
        vasFaceManager.k(arrayList);
        w(62, z19, hashSet);
    }

    private void o(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata, String str) {
        if (oidb_0x5eb_udcuindata.uint32_suspend_effect_id.has()) {
            int i3 = oidb_0x5eb_udcuindata.uint32_suspend_effect_id.get();
            if (i3 >= 0 && String.valueOf(str).equals(this.f409128a.getCurrentAccountUin())) {
                ((ISVIPHandler) this.f409128a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).setColorScreenId(str, i3);
            }
            if (QLog.isColorLevel()) {
                QLog.d("GetStrangerVasInfoHandler", 2, "uint32_suspend_effect_id = " + i3);
            }
        }
    }

    private void p(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        if (oidb_0x5eb_udcuindata.uint32_rsp_theme_font_id.has()) {
            ThemeFontAdapter.B(oidb_0x5eb_udcuindata.uint32_rsp_theme_font_id.get());
        }
    }

    private boolean q(ArrayList<String> arrayList, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata, boolean z16, String str, NTVasSimpleInfo nTVasSimpleInfo, NTVasSimpleInfo nTVasSimpleInfo2) {
        int i3;
        boolean u16 = u(oidb_0x5eb_udcuindata, z16, str, nTVasSimpleInfo, nTVasSimpleInfo2);
        if (oidb_0x5eb_udcuindata.uint32_vas_voicebubble_id.has() && (i3 = oidb_0x5eb_udcuindata.uint32_vas_voicebubble_id.get()) > 0 && String.valueOf(str).equals(this.f409128a.getCurrentAccountUin())) {
            VipMMKV.getCommon(this.f409128a.getCurrentAccountUin()).encodeInt(AppConstants.Preferences.SVIP_BUBBLE_VOICE_PRINT_ID, i3);
            if (QLog.isColorLevel()) {
                QLog.d("GetStrangerVasInfoHandler", 2, "handleGetStrangerVasInfo uin= " + str + "voice print bubble id = " + i3);
            }
        }
        if (oidb_0x5eb_udcuindata.uint32_vas_face_id.has()) {
            int i16 = nTVasSimpleInfo2.faceId;
            int i17 = nTVasSimpleInfo.faceId;
            int i18 = oidb_0x5eb_udcuindata.uint32_vas_face_id.get();
            if (nTVasSimpleInfo.faceIdUpdateTime == 0 || i17 != i18) {
                nTVasSimpleInfo.faceId = i18;
                nTVasSimpleInfo.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
            }
            if (nTVasSimpleInfo.faceIdUpdateTime == 0 || i16 != i18) {
                u16 = true;
            }
            if (i16 != i18) {
                arrayList.add(str);
                if (QLog.isColorLevel()) {
                    QLog.d("GetStrangerVasInfoHandler", 1, "uint32_vas_face_id uin: " + str + " oldId: " + i17 + " newId: " + i18 + " originId:" + i16);
                }
            }
        }
        return y(oidb_0x5eb_udcuindata, u16, str, nTVasSimpleInfo, nTVasSimpleInfo2);
    }

    private void r(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata, String str) throws InvalidProtocolBufferMicroException {
        int i3;
        if (oidb_0x5eb_udcuindata.bytes_req_vip_ext_id.has()) {
            Dialogue dialogue = new Dialogue();
            dialogue.mergeFrom(oidb_0x5eb_udcuindata.bytes_req_vip_ext_id.get().toByteArray());
            if (QLog.isColorLevel()) {
                QLog.d("GetStrangerVasInfoHandler", 2, "vip_card_extension id by refresh=" + dialogue.nameplate_pendant_itemid);
            }
            NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), str);
            nTVasSimpleInfo.c();
            if (dialogue.nameplate_pendant_itemid.has()) {
                i3 = dialogue.nameplate_pendant_itemid.get();
            } else {
                i3 = 0;
            }
            nTVasSimpleInfo.bigClubExtTemplateId = i3;
            nTVasSimpleInfo.diyFontId = dialogue.diyfontid.get();
            nTVasSimpleInfo.gameCardId = dialogue.game_nameplate.get();
            ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "GetStrangerVasInfoHandler", (c<NTVasSimpleInfo>) null);
        }
    }

    private void s(Intent intent, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata, String str) {
        if (oidb_0x5eb_udcuindata.uint64_game_appid.has() && oidb_0x5eb_udcuindata.uint64_game_last_login_time.has() && oidb_0x5eb_udcuindata.uint32_plate_of_king_dan.has() && oidb_0x5eb_udcuindata.uint32_plate_of_king_dan_display_switch.has()) {
            m(str, oidb_0x5eb_udcuindata.uint64_game_appid.get(), oidb_0x5eb_udcuindata.uint64_game_last_login_time.get(), oidb_0x5eb_udcuindata.uint32_plate_of_king_dan.get(), oidb_0x5eb_udcuindata.uint32_plate_of_king_dan_display_switch.get());
        }
        if (intent.getBooleanExtra("req_roam_type", false)) {
            x(str, oidb_0x5eb_udcuindata);
        }
        if (intent.getBooleanExtra("req_music_type", false)) {
            w(36, true, Integer.valueOf(oidb_0x5eb_udcuindata.uint32_rsp_listen_together_player_id.get()));
        }
    }

    private boolean t(PBUInt32Field pBUInt32Field) {
        if (pBUInt32Field.has() && pBUInt32Field.get() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean u(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata, boolean z16, String str, NTVasSimpleInfo nTVasSimpleInfo, NTVasSimpleInfo nTVasSimpleInfo2) {
        long j3;
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        boolean z17 = true;
        if (oidb_0x5eb_udcuindata.uint32_vas_magicfont_flag.has()) {
            int i3 = oidb_0x5eb_udcuindata.uint32_vas_magicfont_flag.get();
            if (i3 != nTVasSimpleInfo.magicFont) {
                nTVasSimpleInfo.magicFont = i3;
                nTVasSimpleInfo.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String = NetConnInfoCenter.getServerTime();
            }
            if (i3 != nTVasSimpleInfo2.magicFont) {
                nTVasSimpleInfo2.magicFont = i3;
                nTVasSimpleInfo2.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String = NetConnInfoCenter.getServerTime();
                z16 = true;
            }
        }
        IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
        com.tencent.qqnt.ntrelation.otherinfo.bean.c otherSimpleInfoWithUid = iOtherInfoService.getOtherSimpleInfoWithUid(uidFromUin, "GetStrangerVasInfoHandler");
        com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.c(uidFromUin, str);
        cVar.m();
        if (oidb_0x5eb_udcuindata.uint32_vas_colorring_id.has()) {
            int i16 = oidb_0x5eb_udcuindata.uint32_vas_colorring_id.get();
            if (otherSimpleInfoWithUid != null) {
                long j16 = i16;
                if (otherSimpleInfoWithUid.b() != j16) {
                    otherSimpleInfoWithUid.o(j16);
                    j3 = i16;
                    if (cVar.b() != j3) {
                        cVar.o(j3);
                    }
                    iOtherInfoService.accurateUpdateNTOtherSimpleInfo(cVar, "GetStrangerVasInfoHandler", (c<com.tencent.qqnt.ntrelation.otherinfo.bean.c>) null);
                    z16 = z17;
                }
            }
            z17 = z16;
            j3 = i16;
            if (cVar.b() != j3) {
            }
            iOtherInfoService.accurateUpdateNTOtherSimpleInfo(cVar, "GetStrangerVasInfoHandler", (c<com.tencent.qqnt.ntrelation.otherinfo.bean.c>) null);
            z16 = z17;
        }
        if (oidb_0x5eb_udcuindata.uint32_vas_praise_id.has()) {
            int i17 = oidb_0x5eb_udcuindata.uint32_vas_praise_id.get();
            if (i17 > 0 && String.valueOf(str).equals(this.f409128a.getCurrentAccountUin())) {
                PraiseManager.i(this.f409128a, i17);
            }
            if (QLog.isColorLevel()) {
                QLog.d("GetStrangerVasInfoHandler", 2, "handleGetStrangerVasInfo uin= " + str + "praise id = " + i17);
            }
        }
        return z16;
    }

    private boolean v(boolean z16, NTVasSimpleInfo nTVasSimpleInfo, long j3, NTVasSimpleInfo nTVasSimpleInfo2) {
        if (FontManagerConstants.parseFontId(j3) != nTVasSimpleInfo.uVipFont || FontManagerConstants.parseFontType(j3) != nTVasSimpleInfo.vipFontType) {
            nTVasSimpleInfo.uVipFont = FontManagerConstants.parseFontId(j3);
            nTVasSimpleInfo.vipFontType = FontManagerConstants.parseFontType(j3);
            nTVasSimpleInfo.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String = NetConnInfoCenter.getServerTime();
        }
        if (FontManagerConstants.parseFontId(j3) != nTVasSimpleInfo2.uVipFont || FontManagerConstants.parseFontType(j3) != nTVasSimpleInfo2.vipFontType) {
            nTVasSimpleInfo2.uVipFont = FontManagerConstants.parseFontId(j3);
            nTVasSimpleInfo2.vipFontType = FontManagerConstants.parseFontType(j3);
            nTVasSimpleInfo2.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String = NetConnInfoCenter.getServerTime();
            return true;
        }
        return z16;
    }

    private void w(int i3, boolean z16, Object obj) {
        Object obj2 = this.f409129b;
        if (obj2 instanceof BusinessHandler) {
            ((BusinessHandler) obj2).notifyUI(i3, z16, obj);
        }
    }

    private boolean y(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata, boolean z16, String str, NTVasSimpleInfo nTVasSimpleInfo, NTVasSimpleInfo nTVasSimpleInfo2) {
        int i3;
        if (oidb_0x5eb_udcuindata.uint32_vas_pendant_diy_id.has() && nTVasSimpleInfo2.pendantDiyId != (i3 = oidb_0x5eb_udcuindata.uint32_vas_pendant_diy_id.get())) {
            nTVasSimpleInfo.pendantDiyId = i3;
            nTVasSimpleInfo.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String = NetConnInfoCenter.getServerTime();
            nTVasSimpleInfo2.pendantDiyId = i3;
            if (str.equals(this.f409128a.getCurrentAccountUin())) {
                ((ISVIPHandler) this.f409128a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).setSelfPendantDiyId(i3, false);
            }
            if (QLog.isColorLevel()) {
                QLog.d("GetStrangerVasInfoHandler", 2, "handleGetStrangerVasInfo, uin=" + str + ", pendant=" + nTVasSimpleInfo.pendantId + ",font=" + nTVasSimpleInfo.uVipFont + ", fontType = " + nTVasSimpleInfo.vipFontType + ", magicFont = " + nTVasSimpleInfo.magicFont + ", pendantDiyId = " + nTVasSimpleInfo.pendantDiyId);
            }
            return true;
        }
        return z16;
    }

    public static void z(int[] iArr, oidb_0x5eb$ReqBody oidb_0x5eb_reqbody, int i3) {
        int i16 = iArr[i3];
        if (i16 != 20059) {
            if (i16 != 27025) {
                if (i16 != 27041) {
                    if (i16 != 27201) {
                        if (i16 != 27217) {
                            if (i16 != 27234) {
                                if (i16 != 40530) {
                                    if (i16 != 47218) {
                                        if (i16 != 47222) {
                                            if (i16 != 27224) {
                                                if (i16 == 27225) {
                                                    oidb_0x5eb_reqbody.uint32_game_appid.set(1);
                                                }
                                            } else {
                                                oidb_0x5eb_reqbody.uint32_game_last_login_time.set(1);
                                            }
                                        } else {
                                            oidb_0x5eb_reqbody.uint32_flag_kid_mode_can_filter_url.set(1);
                                        }
                                    } else {
                                        oidb_0x5eb_reqbody.uint32_haoma_nameplate.set(1);
                                    }
                                } else {
                                    oidb_0x5eb_reqbody.uint32_req_vas_magicfont_flag.set(1);
                                }
                            } else {
                                oidb_0x5eb_reqbody.uint32_req_vas_voicebubble_id.set(1);
                            }
                        } else {
                            oidb_0x5eb_reqbody.uint32_req_vas_praise_flag.set(1);
                        }
                    } else {
                        oidb_0x5eb_reqbody.uint32_req_vas_font_id_flag.set(1);
                    }
                } else {
                    oidb_0x5eb_reqbody.uint32_req_vas_colorring_flag.set(1);
                }
            } else {
                oidb_0x5eb_reqbody.uint32_req_face_addon_id.set(1);
            }
        } else {
            oidb_0x5eb_reqbody.uint32_req_bubble_id.set(1);
        }
        B(iArr, oidb_0x5eb_reqbody, i3);
    }

    @Deprecated
    public void C(AppRuntime appRuntime, String[] strArr, int[] iArr, int i3) {
        if (!(appRuntime instanceof QQAppInterface)) {
            return;
        }
        this.f409128a = (QQAppInterface) appRuntime;
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        ArrayList arrayList = new ArrayList();
        boolean z16 = false;
        for (String str : strArr) {
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        String[] strArr2 = (String[]) arrayList.toArray(new String[1]);
        for (String str2 : strArr2) {
            try {
                oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(str2)));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        int i16 = 0;
        boolean z17 = false;
        while (true) {
            if (i16 >= iArr.length) {
                break;
            }
            if (iArr[i16] == 42255) {
                oidb_0x5eb_reqbody.roam_flag_qq_7day.set(1);
                oidb_0x5eb_reqbody.roam_flag_vip_30day.set(1);
                oidb_0x5eb_reqbody.roam_flag_svip_2year.set(1);
                oidb_0x5eb_reqbody.roam_flag_svip_5year.set(1);
                oidb_0x5eb_reqbody.roam_flag_svip_forever.set(1);
                z16 = true;
                break;
            }
            z(iArr, oidb_0x5eb_reqbody, i16);
            z17 = A(iArr, oidb_0x5eb_reqbody, z17, i16);
            i16++;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GetStrangerVasInfoHandler", 2, "vipPatchGetStrangerVasInfo, uins: " + Arrays.toString(strArr2) + " fields: " + Arrays.toString(iArr));
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1515);
        oidb_sso_oidbssopkg.uint32_service_type.set(i3);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x5eb_reqbody.toByteArray()));
        Intent intent = new Intent();
        intent.putExtra("req_roam_type", z16);
        intent.putExtra("req_music_type", z17);
        VasUtil.getService(appRuntime).getPbRequest().request("OidbSvc.0x5eb_99", oidb_sso_oidbssopkg.toByteArray(), new C10564a(intent));
    }

    @Override // com.tencent.mobileqq.apollo.handler.d
    public void a(com.tencent.mobileqq.apollo.handler.b bVar, Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        if (bVar != null && bVar.getApp() != null) {
            try {
                this.f409129b = bVar;
                AppInterface app = bVar.getApp();
                if (app instanceof QQAppInterface) {
                    this.f409128a = (QQAppInterface) app;
                } else {
                    QLog.e("GetStrangerVasInfoHandler", 1, "[handler] app interface is not instance of QQAppInterface!");
                }
                j(intent, fromServiceMsg.isSuccess(), bArr);
            } finally {
                this.f409128a = null;
                this.f409129b = null;
            }
        }
    }

    public void m(String str, long j3, long j16, int i3, int i16) {
        boolean z16;
        boolean z17;
        if (QLog.isColorLevel()) {
            QLog.d("GetStrangerVasInfoHandler", 2, "handleNamePlateOfKingInfo : uin = " + str + ", gameId = " + j3 + ", gameLoginTime = " + j16 + ", dan = " + i3 + ", dansSwitch = " + i16);
        }
        Card r16 = ((FriendsManager) this.f409128a.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(str);
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "GetStrangerVasInfoHandler");
        boolean z18 = false;
        if (!TextUtils.isEmpty(str) && this.f409128a.getCurrentUin().equals(str)) {
            SharedPreferences.Editor edit = this.f409128a.getApp().getSharedPreferences(ProfileContants.SP_PLATE_OF_KING, 0).edit();
            String str2 = "plate_of_king_display_switch_" + this.f409128a.getCurrentUin();
            if (i16 == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            edit.putBoolean(str2, z17).apply();
        }
        if (r16 != null) {
            r16.namePlateOfKingGameId = j3;
            r16.namePlateOfKingLoginTime = j16;
            r16.namePlateOfKingDan = i3;
            if (i16 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            r16.namePlateOfKingDanDisplatSwitch = z16;
            this.f409128a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, r16);
        }
        if (vasSimpleInfoWithUid != null) {
            vasSimpleInfoWithUid.namePlateOfKingGameId = j3;
            vasSimpleInfoWithUid.namePlateOfKingLoginTime = j16;
            vasSimpleInfoWithUid.namePlateOfKingDan = i3;
            if (i16 == 1) {
                z18 = true;
            }
            vasSimpleInfoWithUid.namePlateOfKingDanDisplatSwitch = Boolean.valueOf(z18);
            this.f409128a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, str);
        }
    }

    protected void x(String str, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        int i3;
        if (t(oidb_0x5eb_udcuindata.roam_flag_svip_5year)) {
            i3 = 5;
        } else if (!t(oidb_0x5eb_udcuindata.roam_flag_svip_2year) && !t(oidb_0x5eb_udcuindata.roam_flag_svip_forever)) {
            if (t(oidb_0x5eb_udcuindata.roam_flag_vip_30day)) {
                i3 = 3;
            } else if (t(oidb_0x5eb_udcuindata.roam_flag_qq_7day)) {
                i3 = 2;
            } else {
                i3 = 1;
            }
        } else {
            i3 = 4;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GetStrangerVasInfoHandler", 2, "onGetRoamType: " + i3);
        }
        this.f409128a.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putInt("message_roam_flag" + str, i3).commit();
        this.f409128a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER).notifyUI(114, true, new Object[]{str, Integer.valueOf(i3)});
    }
}
