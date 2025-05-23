package com.tencent.mobileqq.app;

import NearbyGroup.LBSInfo;
import NeighborComm.LocalInfoType;
import NeighborSvc.GPS;
import NeighborSvc.ReqGetPoint;
import NeighborSvc.ReqHeader;
import NeighborSvc.ReqUserInfo;
import NeighborSvc.RespGetPoint;
import NeighborSvc.UserDetailLocalInfo;
import QQService.ReqFavorite;
import QQService.ReqHead;
import QQService.RespFavorite;
import android.os.Bundle;
import appoint.define.appoint_define$InterestTag;
import com.qq.jce.wup.UniPacket;
import com.qzone.personalize.floatobject.business.model.FloatCacheData;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearby.api.ILbsUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.interestTag.IInterestTagUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x682$ChatInfo;
import tencent.im.oidb.cmd0x682$RspBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686$CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686$NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686$NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686$NearbyRankConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686$RspBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bz {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends LbsManagerServiceOnLocationChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ToServiceMsg f195415a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, ToServiceMsg toServiceMsg) {
            super(str);
            this.f195415a = toServiceMsg;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) toServiceMsg);
            }
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
                return;
            }
            synchronized (this.f195415a) {
                this.f195415a.notify();
            }
        }
    }

    public static void a(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        RespFavorite respFavorite = (RespFavorite) c(fromServiceMsg.getWupBuffer(), "RespFavorite", new RespFavorite());
        fromServiceMsg.getAttributes().put("result", respFavorite);
        if (respFavorite.stHeader.iReplyCode != 0) {
            fromServiceMsg.setMsgFail();
        } else {
            fromServiceMsg.setMsgSuccess();
        }
    }

    public static Object b(BaseProtocolCoder baseProtocolCoder, FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        RespGetPoint respGetPoint;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.NEARBY, 2, "LBSService --> decodeGetPointInfo(), isSuccess: " + fromServiceMsg.isSuccess());
        }
        if (fromServiceMsg.isSuccess() && (respGetPoint = (RespGetPoint) baseProtocolCoder.decodePacket(fromServiceMsg.getWupBuffer(), "RespGetPoint", new RespGetPoint())) != null) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.NEARBY, 2, "LBSService --> decodeGetPointInfo(), url: " + new String(respGetPoint.stUDLinfo.SOSOUrl) + " , cityId = " + respGetPoint.stUDLinfo.cityId);
            }
            return respGetPoint;
        }
        return null;
    }

    public static final <T> T c(byte[] bArr, String str, T t16) {
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(bArr);
            return (T) uniPacket.getByClass(str, t16);
        } catch (RuntimeException | Exception unused) {
            return null;
        }
    }

    public static void d(BusinessHandler businessHandler, boolean z16, boolean z17, int i3, int i16) {
        if (!z16 && !z17) {
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", businessHandler.getCurrentAccountUin(), "NeighborSvc.ReqGetPoint");
        if (i3 != 0 && i16 != 0) {
            toServiceMsg.extraData.putInt(QCircleSchemeAttr.Polymerize.LAT, i3);
            toServiceMsg.extraData.putInt("lon", i16);
        }
        if (z16) {
            toServiceMsg.extraData.putBoolean("req_street_view", true);
        } else {
            toServiceMsg.extraData.putBoolean("req_current_loc", true);
        }
        businessHandler.send(toServiceMsg);
    }

    public static void e(BusinessHandler businessHandler, int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16 = toServiceMsg.extraData.getBoolean("req_street_view");
        boolean z17 = toServiceMsg.extraData.getBoolean("req_current_loc");
        String[] strArr = null;
        if (obj != null && fromServiceMsg.isSuccess()) {
            RespGetPoint respGetPoint = (RespGetPoint) obj;
            UserDetailLocalInfo userDetailLocalInfo = respGetPoint.stUDLinfo;
            if (z16) {
                if (userDetailLocalInfo != null) {
                    byte[] bArr = userDetailLocalInfo.SOSOUrl;
                    if (bArr.length > 0) {
                        businessHandler.notifyUI(i3, true, bArr);
                        return;
                    }
                    return;
                }
                return;
            }
            if (z17) {
                byte[] bArr2 = userDetailLocalInfo.cityId;
                if (bArr2 != null && bArr2.length == 16) {
                    ByteBuffer wrap = ByteBuffer.wrap(bArr2);
                    strArr = new String[]{ConditionSearchManager.n(wrap.getInt()), ConditionSearchManager.n(wrap.getInt()), ConditionSearchManager.n(wrap.getInt()), "0"};
                }
                businessHandler.notifyUI(i3, true, new Object[]{"", userDetailLocalInfo.strProvince, userDetailLocalInfo.strCity, userDetailLocalInfo.strDistrict, userDetailLocalInfo.strTown, "", userDetailLocalInfo.strRoad, "", Integer.valueOf(respGetPoint.stGps.iLat), Integer.valueOf(respGetPoint.stGps.iLon), Integer.valueOf(respGetPoint.stGps.iAlt), strArr});
                return;
            }
            return;
        }
        if (z16) {
            businessHandler.notifyUI(i3, false, null);
        } else if (z17) {
            businessHandler.notifyUI(i3, false, null);
        }
    }

    public static boolean f(BaseProtocolCoder baseProtocolCoder, ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        boolean z16 = toServiceMsg.extraData.getBoolean("req_street_view");
        boolean z17 = toServiceMsg.extraData.getBoolean("req_current_loc");
        int i3 = toServiceMsg.extraData.getInt(QCircleSchemeAttr.Polymerize.LAT);
        int i16 = toServiceMsg.extraData.getInt("lon");
        if ((!z16 || i3 == 0 || i16 == 0) && !z17) {
            return false;
        }
        ReqHeader reqHeader = new ReqHeader();
        reqHeader.shVersion = (short) 2;
        reqHeader.lMID = BaseProtocolCoder.createUserId(Long.parseLong(toServiceMsg.getUin()));
        reqHeader.iAppID = AppSetting.f();
        reqHeader.eBusiType = 0;
        reqHeader.eMqqSysType = 2;
        ReqUserInfo reqUserInfo = new ReqUserInfo();
        reqUserInfo.strAuthName = QQAppInterface.AUTHORIZATION_NAME;
        reqUserInfo.strAuthPassword = QQAppInterface.AUTHORIZATION_PASSWORD;
        reqUserInfo.eListType = 0;
        if (z16) {
            reqUserInfo.vCells = new ArrayList<>(1);
            reqUserInfo.vMacs = new ArrayList<>(1);
            reqUserInfo.stGps = new GPS(i3, i16, 0, 1);
        } else if (z17 && i3 != 0 && i16 != 0) {
            reqUserInfo.vCells = new ArrayList<>(1);
            reqUserInfo.vMacs = new ArrayList<>(1);
            reqUserInfo.stGps = new GPS(i3, i16, 0, 1);
        } else {
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new a("LBSService.Point", toServiceMsg));
            synchronized (toServiceMsg) {
                try {
                    LockMethodProxy.wait(toServiceMsg);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
            LBSInfo createLbsInfo = ((ILbsUtils) QRoute.api(ILbsUtils.class)).createLbsInfo(true, ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("LBSService.Point"));
            if (createLbsInfo == null) {
                return false;
            }
            NearbyGroup.GPS gps = createLbsInfo.stGps;
            if (gps != null) {
                reqUserInfo.stGps = new GPS(gps.iLat, gps.iLon, gps.iAlt, gps.eType);
            }
        }
        reqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
        ReqGetPoint reqGetPoint = new ReqGetPoint(reqUserInfo, z16 ? (byte) 1 : (byte) 0, z17 ? (byte) 1 : (byte) 0);
        uniPacket.setServantName("NeighborObj");
        uniPacket.setFuncName("CMD_GET_POINT");
        uniPacket.put("ReqHeader", reqHeader);
        uniPacket.put("ReqGetPoint", reqGetPoint);
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.setServiceCmd("NeighborSvc.ReqGetPoint");
        return true;
    }

    public static void g(BusinessHandler businessHandler, int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        cmd0x682$RspBody cmd0x682_rspbody = new cmd0x682$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x682_rspbody);
        com.tencent.mobileqq.dating.f.j("getShowLove", "handleGetShowLoveLimit result = " + parseOIDBPkg);
        if (parseOIDBPkg == 0 && cmd0x682_rspbody.rpt_msg_chatinfo.has() && cmd0x682_rspbody.rpt_msg_chatinfo.size() > 0) {
            cmd0x682$ChatInfo cmd0x682_chatinfo = cmd0x682_rspbody.rpt_msg_chatinfo.get(0);
            long j3 = cmd0x682_chatinfo.uint64_touin.get();
            int i16 = cmd0x682_chatinfo.uint32_chatflag.get();
            int i17 = cmd0x682_chatinfo.uint32_goldflag.get();
            int i18 = cmd0x682_chatinfo.uint32_totalexpcount.get();
            int i19 = cmd0x682_chatinfo.uint32_curexpcount.get();
            int i26 = cmd0x682_chatinfo.uint32_totalFlag.get();
            int i27 = cmd0x682_chatinfo.uint32_curdayFlag.get();
            String stringUtf8 = cmd0x682_chatinfo.express_tips_msg.get().toStringUtf8();
            String stringUtf82 = cmd0x682_chatinfo.express_msg.get().toStringUtf8();
            byte[] byteArray = toServiceMsg.extraData.getByteArray("showlove_chat_sig");
            if ((i16 & 2) != 2 && i17 != 2) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (i17 == 1 && i26 == 0 && i27 == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (businessHandler instanceof l92.a) {
                businessHandler.notifyUI(9, true, new Object[]{Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), byteArray, stringUtf8, stringUtf82});
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_DATING_TOP_LIST_SAY_HELLO, 2, "toUin:" + j3 + ",chatFlag:" + i16 + ",godFlag:" + i17 + ",totalCount:" + i18 + ",curCount" + i19 + ",totalFlag:" + i26 + ",curdayFlag:" + i27 + ",canChat:" + z16 + ",canShowLove:" + z17 + ",wordStr:" + stringUtf8 + "showloveStr: " + stringUtf82);
            }
            if (i27 == 1) {
                com.tencent.mobileqq.utils.g.a(businessHandler.appRuntime, "CliOper", "", "", "0X8005290", "0X8005290", 0, 0, "", "", "", "");
            } else if (i26 == 1) {
                com.tencent.mobileqq.utils.g.a(businessHandler.appRuntime, "CliOper", "", "", "0X8005291", "0X8005291", 0, 0, "", "", "", "");
            }
        } else {
            businessHandler.notifyUI(i3, false, null);
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.NEARBY_RANK, 2, "handleGetShowLoveLimit,result\uff1a" + parseOIDBPkg);
        }
    }

    public static boolean h(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long j3 = toServiceMsg.extraData.getLong("selfUin");
        long j16 = toServiceMsg.extraData.getLong(IProfileProtocolConst.PARAM_TARGET_UIN);
        byte[] byteArray = toServiceMsg.extraData.getByteArray("vCookies");
        ReqFavorite reqFavorite = new ReqFavorite(new ReqHead(j3, (short) 1, uniPacket.getRequestId(), (byte) 1, (byte) 0, byteArray), j16, 0, toServiceMsg.extraData.getInt("favoriteSource"), toServiceMsg.extraData.getInt(FloatCacheData.ICOUNT), toServiceMsg.extraData.getInt("iHasZplanAvatar", 0));
        uniPacket.setServantName("VisitorSvc");
        uniPacket.setFuncName("ReqFavorite");
        uniPacket.put("ReqFavorite", reqFavorite);
        toServiceMsg.setTimeout(10000L);
        toServiceMsg.setServiceCmd("VisitorSvc.ReqFavorite");
        return true;
    }

    public static void i(BusinessHandler businessHandler, int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i16;
        String str;
        String str2;
        List<appoint_define$InterestTag> list;
        int i17 = -1;
        if (toServiceMsg != null && fromServiceMsg != null) {
            Bundle bundle = toServiceMsg.extraData;
            if (bundle == null) {
                i16 = -1;
            } else {
                i16 = bundle.getInt("set_mode");
            }
            Bundle bundle2 = toServiceMsg.extraData;
            if (bundle2 != null) {
                i17 = bundle2.getInt("test_mode");
            }
            cmd0x9c7$RspBody cmd0x9c7_rspbody = new cmd0x9c7$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x9c7_rspbody);
            if (parseOIDBPkg == 0) {
                if (!cmd0x9c7_rspbody.str_test_result_url.has()) {
                    str2 = "";
                } else {
                    str2 = cmd0x9c7_rspbody.str_test_result_url.get();
                }
                if (cmd0x9c7_rspbody.rpt_msg_tags.has()) {
                    list = cmd0x9c7_rspbody.rpt_msg_tags.get();
                } else {
                    list = null;
                }
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    for (int i18 = 0; i18 < list.size(); i18++) {
                        m92.a aVar = (m92.a) ((IInterestTagUtils) QRoute.api(IInterestTagUtils.class)).convertFrom(list.get(i18));
                        if (aVar != null) {
                            arrayList.add(aVar);
                        }
                    }
                }
                if (arrayList.size() <= 0) {
                    businessHandler.notifyUI(4, false, new Object[]{"", null, HardCodeUtil.qqStr(R.string.oey), Integer.valueOf(i16), Integer.valueOf(i17)});
                    com.tencent.mobileqq.nearby.l.c(LogTag.NEARBY_PEOPLE_CARD, "handle_oidb_0x9c7_0", Integer.valueOf(parseOIDBPkg), Boolean.TRUE, null, str2);
                    return;
                }
                Object obj2 = businessHandler.appRuntime;
                if (obj2 instanceof INearbyAppInterface) {
                    ((INearbyAppInterface) obj2).getNearbyProcManager().a(cmd0x9c7_rspbody);
                } else if (obj2 != null && (obj2 instanceof QQAppInterface)) {
                    com.tencent.mobileqq.nearby.h.b((QQAppInterface) obj2).a(cmd0x9c7_rspbody);
                }
                businessHandler.notifyUI(i3, true, new Object[]{str2, arrayList, "", Integer.valueOf(i16), Integer.valueOf(i17)});
                com.tencent.mobileqq.nearby.l.c(LogTag.NEARBY_PEOPLE_CARD, "handle_oidb_0x9c7_0", Integer.valueOf(parseOIDBPkg), Boolean.TRUE, arrayList, str2);
                return;
            }
            if (!cmd0x9c7_rspbody.str_error.has()) {
                str = "";
            } else {
                str = cmd0x9c7_rspbody.str_error.get();
            }
            businessHandler.notifyUI(i3, false, new Object[]{"", null, str, Integer.valueOf(i16), Integer.valueOf(i17)});
            return;
        }
        businessHandler.notifyUI(i3, false, new Object[]{"", null, HardCodeUtil.qqStr(R.string.oex), -1, -1});
    }

    private static void j(BusinessHandler businessHandler, int i3, Oidb_0x686$CharmEvent oidb_0x686$CharmEvent) {
        String str;
        int i16 = oidb_0x686$CharmEvent.uint32_old_charm.get();
        int i17 = oidb_0x686$CharmEvent.uint32_old_charm_level.get();
        int i18 = oidb_0x686$CharmEvent.uint32_new_charm.get();
        int i19 = oidb_0x686$CharmEvent.uint32_new_charm_level.get();
        int i26 = oidb_0x686$CharmEvent.uint32_cur_level_threshold.get();
        int i27 = oidb_0x686$CharmEvent.uint32_next_level_threshold.get();
        String str2 = oidb_0x686$CharmEvent.str_tips_content.get();
        Object[] objArr = new Object[8];
        objArr[0] = Boolean.FALSE;
        objArr[1] = Integer.valueOf(i16);
        objArr[2] = Integer.valueOf(i17);
        objArr[3] = Integer.valueOf(i18);
        objArr[4] = Integer.valueOf(i19);
        objArr[5] = Integer.valueOf(i26);
        objArr[6] = Integer.valueOf(i27);
        if (str2 == null) {
            str2 = "";
        }
        objArr[7] = str2;
        businessHandler.notifyUI(i3, true, objArr);
        if (i18 - i16 < 0) {
            str = "0X80052B2";
        } else {
            str = "0X80052B1";
        }
        String str3 = str;
        AppInterface appInterface = businessHandler.appRuntime;
        if (appInterface instanceof AppInterface) {
            com.tencent.mobileqq.utils.g.a(appInterface, "CliOper", "", "", str3, str3, 0, 0, "", "", "", "");
        }
    }

    private static void k(BusinessHandler businessHandler, int i3, Oidb_0x686$NearbyCharmNotify oidb_0x686$NearbyCharmNotify) {
        String str;
        int i16 = oidb_0x686$NearbyCharmNotify.uint32_old_charm.get();
        int i17 = oidb_0x686$NearbyCharmNotify.uint32_old_charm_level.get();
        int i18 = oidb_0x686$NearbyCharmNotify.uint32_new_charm.get();
        int i19 = oidb_0x686$NearbyCharmNotify.uint32_new_charm_level.get();
        int i26 = oidb_0x686$NearbyCharmNotify.uint32_cur_level_threshold.get();
        int i27 = oidb_0x686$NearbyCharmNotify.uint32_next_level_threshold.get();
        int i28 = oidb_0x686$NearbyCharmNotify.uint32_old_prof_percent.get();
        int i29 = oidb_0x686$NearbyCharmNotify.uint32_new_prof_percent.get();
        String str2 = oidb_0x686$NearbyCharmNotify.str_tips_content.get();
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(i16);
        objArr[1] = Integer.valueOf(i17);
        objArr[2] = Integer.valueOf(i18);
        objArr[3] = Integer.valueOf(i19);
        objArr[4] = Integer.valueOf(i26);
        objArr[5] = Integer.valueOf(i27);
        objArr[6] = Integer.valueOf(i28);
        objArr[7] = Integer.valueOf(i29);
        if (str2 == null) {
            str2 = "";
        }
        objArr[8] = str2;
        businessHandler.notifyUI(i3, true, objArr);
        if (i18 - i16 < 0) {
            str = "0X80052AF";
        } else {
            str = "0X80052AE";
        }
        String str3 = str;
        AppInterface appInterface = businessHandler.appRuntime;
        if (appInterface instanceof AppInterface) {
            com.tencent.mobileqq.utils.g.a(appInterface, "CliOper", "", "", str3, str3, 0, 0, "", "", "", "");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0115, code lost:
    
        if (r2.uint32_pop_flag.get() != 1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0117, code lost:
    
        j(r11, r12, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void l(BusinessHandler businessHandler, int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        Oidb_0x686$NearbyRankConfig oidb_0x686$NearbyRankConfig;
        Oidb_0x686$NearbyFeedConfig oidb_0x686$NearbyFeedConfig;
        Oidb_0x686$NearbyCharmNotify oidb_0x686$NearbyCharmNotify;
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            int i16 = oidb_sso_oidbssopkg.uint32_result.get();
            if (i16 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.NEARBY, 2, "rspNearbyCharmEvent,result code\uff1a" + i16 + ",isSuccess:" + z16);
            }
            if (z16) {
                Oidb_0x686$RspBody oidb_0x686$RspBody = new Oidb_0x686$RspBody();
                int i17 = oidb_sso_oidbssopkg.uint32_service_type.get();
                oidb_0x686$RspBody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                if (oidb_0x686$RspBody.uint32_config_seq.has()) {
                    ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(businessHandler.appRuntime.getAccount(), INearbySPUtil.TOPLIST_SP_HIDE_BOYGOD_SEQ, Integer.valueOf(oidb_0x686$RspBody.uint32_config_seq.get()));
                }
                if (oidb_0x686$RspBody.uint32_config_time.has()) {
                    ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(businessHandler.appRuntime.getAccount(), INearbySPUtil.KEY_LAST_CONFIG_TIME, Integer.valueOf(oidb_0x686$RspBody.uint32_config_time.get()));
                }
                Oidb_0x686$CharmEvent oidb_0x686$CharmEvent = null;
                if (oidb_0x686$RspBody.msg_rank_config.has()) {
                    oidb_0x686$NearbyRankConfig = oidb_0x686$RspBody.msg_rank_config.get();
                } else {
                    oidb_0x686$NearbyRankConfig = null;
                }
                if (oidb_0x686$RspBody.msg_feed_config.has()) {
                    oidb_0x686$NearbyFeedConfig = oidb_0x686$RspBody.msg_feed_config.get();
                } else {
                    oidb_0x686$NearbyFeedConfig = null;
                }
                if (i17 == 2 && oidb_0x686$RspBody.msg_charm_event.has()) {
                    oidb_0x686$CharmEvent = oidb_0x686$RspBody.msg_charm_event.get();
                    oidb_0x686$NearbyCharmNotify = null;
                } else if (i17 == 1 && oidb_0x686$RspBody.msg_notify_event.has()) {
                    oidb_0x686$NearbyCharmNotify = oidb_0x686$RspBody.msg_notify_event.get();
                } else {
                    oidb_0x686$NearbyCharmNotify = null;
                }
                AppInterface appInterface = businessHandler.appRuntime;
                if (!(appInterface instanceof INearbyAppInterface) && (appInterface instanceof QQAppInterface)) {
                    com.tencent.mobileqq.nearby.h.b((QQAppInterface) appInterface).c(toServiceMsg.getUin(), oidb_0x686$NearbyRankConfig, oidb_0x686$NearbyFeedConfig, oidb_0x686$CharmEvent, oidb_0x686$NearbyCharmNotify);
                }
                if (oidb_0x686$NearbyCharmNotify != null && oidb_0x686$NearbyCharmNotify.uint32_pop_flag.get() == 1) {
                    k(businessHandler, i3, oidb_0x686$NearbyCharmNotify);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void m(BusinessHandler businessHandler, byte b16) {
        try {
            byte[] bArr = new byte[13];
            PkgTools.dWord2Byte(bArr, 0, Long.parseLong(businessHandler.getCurrentAccountUin()));
            bArr[4] = 0;
            PkgTools.word2Byte(bArr, 5, (short) 1);
            PkgTools.dWordTo2Bytes(bArr, 7, 40493);
            PkgTools.word2Byte(bArr, 9, (short) 2);
            PkgTools.word2Byte(bArr, 11, b16);
            ToServiceMsg makeOIDBPkg = businessHandler.makeOIDBPkg(ProfileContants.CMD_SET_DETAIL_INFO, 1279, 9, bArr);
            makeOIDBPkg.extraData.putByte("session_switch_value", b16);
            makeOIDBPkg.extraData.putBoolean("reqFromDatingHandler", true);
            businessHandler.sendPbReq(makeOIDBPkg);
            com.tencent.mobileqq.dating.f.j("send_oidb_0x4ff_9", Byte.valueOf(b16));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w(LogTag.DATING, 2, "send_oidb_0x4ff_9 error", e16);
            }
        }
    }
}
