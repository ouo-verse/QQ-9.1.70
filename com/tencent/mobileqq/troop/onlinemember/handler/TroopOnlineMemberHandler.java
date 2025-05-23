package com.tencent.mobileqq.troop.onlinemember.handler;

import android.app.Activity;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService;
import com.tencent.mobileqq.troop.onlinemember.api.b;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.qqnt.troop.TroopExtDBInfoRepo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a$GPS;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a$LBSInfo;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a$ReqBody;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a$RspBody;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a$UserInfo;
import tencent.im.oidb.cmd0xd71.oidb_0xd71$ReqBody;
import tencent.im.oidb.cmd0xd71.oidb_0xd71$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopOnlineMemberHandler extends TroopBaseHandler implements com.tencent.mobileqq.troop.onlinemember.api.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f298050e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends LbsManagerServiceOnLocationChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f298053a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f298054b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, long j3, String str2) {
            super(str);
            this.f298053a = j3;
            this.f298054b = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopOnlineMemberHandler.this, str, Long.valueOf(j3), str2);
            }
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            if (QLog.isColorLevel()) {
                QLog.i("TroopOnlineMemberHandler", 2, "onLocationFinish, time=" + (uptimeMillis - this.f298053a) + "ms");
            }
            if (i3 != 0) {
                QLog.i("TroopOnlineMemberHandler", 1, "getDetailOnlineMemberList, startLocation, errorCode=" + i3);
            }
            TroopOnlineMemberHandler.this.P2(this.f298054b, sosoLbsInfo);
        }
    }

    public TroopOnlineMemberHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        oidb_0xa2a$RspBody oidb_0xa2a_rspbody = new oidb_0xa2a$RspBody();
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_sso_oidbssopkg, oidb_0xa2a_rspbody);
        int i3 = oidb_sso_oidbssopkg.uint32_service_type.get();
        String string = toServiceMsg.extraData.getString("troopUin");
        if (QLog.isColorLevel()) {
            QLog.i("TroopOnlineMemberHandler", 2, "handleGetAllGameOnlineMemberList, retCode=" + parseOIDBPkg + ",troopUin=" + string + " serviceType = " + i3);
        }
        if (parseOIDBPkg == 0) {
            List<oidb_0xa2a$UserInfo> list = oidb_0xa2a_rspbody.infos.get();
            ArrayList arrayList = new ArrayList();
            Iterator<oidb_0xa2a$UserInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(it.next().uin.get()));
            }
            int i16 = oidb_0xa2a_rspbody.cache_time.get();
            AppInterface appInterface = this.appRuntime;
            if (appInterface != null) {
                ((ITroopOnlineMemberService) appInterface.getRuntimeService(ITroopOnlineMemberService.class, "")).updateAllGameOnlineList(string, arrayList, i16);
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopOnlineMemberHandler", 2, "handleGetAllGameOnlineMemberList, size=" + arrayList.size() + " cacheTime = " + i16);
            }
            notifyUI(b.f298036m, true, new Object[]{string, arrayList});
            return;
        }
        QLog.i("TroopOnlineMemberHandler", 1, "handleGetAllGameOnlineMemberList, retCode=" + parseOIDBPkg);
        notifyUI(b.f298036m, false, new Object[]{string, null});
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        oidb_0xa2a$RspBody oidb_0xa2a_rspbody = new oidb_0xa2a$RspBody();
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_sso_oidbssopkg, oidb_0xa2a_rspbody);
        int i3 = oidb_sso_oidbssopkg.uint32_service_type.get();
        String string = toServiceMsg.extraData.getString("troopUin");
        if (QLog.isColorLevel()) {
            QLog.i("TroopOnlineMemberHandler", 2, "handleGetAllOnlineMemberList, retCode=" + parseOIDBPkg + ",troopUin=" + string + " serviceType = " + i3);
        }
        if (parseOIDBPkg == 0) {
            List<oidb_0xa2a$UserInfo> list = oidb_0xa2a_rspbody.infos.get();
            if (i3 == 4) {
                notifyUI(b.D, true, new Object[]{string, list});
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<oidb_0xa2a$UserInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(it.next().uin.get()));
            }
            int i16 = oidb_0xa2a_rspbody.cache_time.get();
            AppInterface appInterface = this.appRuntime;
            if (appInterface != null) {
                ((ITroopOnlineMemberService) appInterface.getRuntimeService(ITroopOnlineMemberService.class, "")).updateAllOnlineList(string, arrayList, i16);
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopOnlineMemberHandler", 2, "handleGetAllOnlineMemberList, size=" + arrayList.size() + " cacheTime = " + i16);
            }
            notifyUI(b.f298035i, true, new Object[]{string, arrayList});
            return;
        }
        QLog.i("TroopOnlineMemberHandler", 1, "handleGetAllOnlineMemberList, retCode=" + parseOIDBPkg);
        if (i3 == 4) {
            notifyUI(b.D, false, new Object[]{string, null});
        } else {
            notifyUI(b.f298035i, false, new Object[]{string, null});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2(String str, SosoLbsInfo sosoLbsInfo) {
        ITroopInfoService iTroopInfoService = (ITroopInfoService) this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
        oidb_0xa2a$ReqBody oidb_0xa2a_reqbody = new oidb_0xa2a$ReqBody();
        oidb_0xa2a_reqbody.group_id.set(Long.valueOf(str).longValue());
        oidb_0xa2a_reqbody.is_private.set(iTroopInfoService.isQidianPrivateTroop(str));
        if (sosoLbsInfo != null) {
            oidb_0xa2a$LBSInfo oidb_0xa2a_lbsinfo = new oidb_0xa2a$LBSInfo();
            oidb_0xa2a$GPS oidb_0xa2a_gps = new oidb_0xa2a$GPS();
            SosoLocation sosoLocation = sosoLbsInfo.mLocation;
            if (sosoLocation != null) {
                oidb_0xa2a_gps.int64_longitude.set((long) (sosoLocation.mLon84 * 1000000.0d));
                oidb_0xa2a_gps.int64_latitude.set((long) (sosoLbsInfo.mLocation.mLat84 * 1000000.0d));
                oidb_0xa2a_gps.uint32_gps_type.set(1);
            }
            oidb_0xa2a_lbsinfo.msg_gpsdw.set(oidb_0xa2a_gps);
            oidb_0xa2a_reqbody.lbs_info.set(oidb_0xa2a_lbsinfo);
        }
        TroopInfo troopInfo = iTroopInfoService.getTroopInfo(String.valueOf(str));
        if (troopInfo != null) {
            oidb_0xa2a_reqbody.hok_appid.set((int) troopInfo.hlGuildAppid);
            oidb_0xa2a_reqbody.hok_type.set((int) troopInfo.hlGuildSubType);
        }
        int requestListServiceType = ((ITroopOnlineMemberService) this.appRuntime.getRuntimeService(ITroopOnlineMemberService.class, "")).getRequestListServiceType(str);
        if (requestListServiceType != 3 && requestListServiceType != 5) {
            requestListServiceType = 0;
        }
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvcTrpcTcp.0xa2a_0", JsonGrayBusiId.QWALLET_GRAY_TIP_ID, requestListServiceType, oidb_0xa2a_reqbody.toByteArray());
        makeOIDBPkg.extraData.putString("troopUin", str);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100733", false);
        if (isSwitchOn) {
            makeOIDBPkg.addAttribute(BaseConstants.ATTRIBUTE_KEY_NT_KERNEL_FLAG, 32);
        }
        sendPbReq(makeOIDBPkg);
        if (QLog.isColorLevel()) {
            QLog.i("TroopOnlineMemberHandler", 2, "sendGetDetailOnlineMemberListReq, troopUin=" + str + " serviceType = " + requestListServiceType + " isLongClickEffect:" + isSwitchOn);
        }
    }

    private boolean Q2(int i3, int i16, String str) {
        AppInterface appInterface = this.appRuntime;
        boolean z16 = false;
        boolean z17 = true;
        if (appInterface == null) {
            QLog.i("TroopOnlineMemberHandler", 1, "setGameSwitchStatus, app is null");
            return false;
        }
        TroopInfo troopInfo = ((ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(String.valueOf(str));
        if (troopInfo == null) {
            QLog.i("TroopOnlineMemberHandler", 1, "setGameSwitchStatus, troopInfo is null");
            return false;
        }
        TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
        if (i3 != troopExtDBInfo.showGameSwitchStatus) {
            z16 = true;
        }
        if (i16 == troopExtDBInfo.gameSwitchStatus) {
            z17 = z16;
        }
        TroopExtDBInfoRepo.INSTANCE.updateGameSwitchStatus(str, i3, i16);
        if (QLog.isColorLevel()) {
            QLog.i("TroopOnlineMemberHandler", 2, "setGameSwitchStatus, showStatus=" + troopInfo.extDBInfo.showGameSwitchStatus + ",status=" + troopInfo.extDBInfo.gameSwitchStatus);
        }
        return z17;
    }

    private void R2(ITroopOnlineMemberService iTroopOnlineMemberService, String str) {
        iTroopOnlineMemberService.setLastReqLocationTime(NetConnInfoCenter.getServerTimeMillis());
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new a("troop_handler", SystemClock.uptimeMillis(), str));
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.a
    public void E1(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            oidb_0xd71$ReqBody oidb_0xd71_reqbody = new oidb_0xd71$ReqBody();
            oidb_0xd71_reqbody.group_id.set(Long.valueOf(str).longValue());
            if (i3 == 1) {
                oidb_0xd71_reqbody.game_switch_status.set(i16);
            }
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xd71", 3441, i3, oidb_0xd71_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("troopUin", str);
            sendPbReq(makeOIDBPkg);
            if (QLog.isColorLevel()) {
                QLog.i("TroopOnlineMemberHandler", 2, "updateGameOnlineSwitchStatus, troopUin=" + str + " , serviceType = " + i3 + " , status = " + i16);
            }
        } catch (Exception e16) {
            QLog.i("TroopOnlineMemberHandler", 1, "updateGameOnlineSwitchStatus, e=" + e16.toString());
        }
    }

    public void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        oidb_0xd71$RspBody oidb_0xd71_rspbody = new oidb_0xd71$RspBody();
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_sso_oidbssopkg, oidb_0xd71_rspbody);
        int i3 = oidb_sso_oidbssopkg.uint32_service_type.get();
        String string = toServiceMsg.extraData.getString("troopUin");
        if (QLog.isColorLevel()) {
            QLog.i("TroopOnlineMemberHandler", 2, "handleGameOnlineSwitchStatus, retCode=" + parseOIDBPkg + ",troopUin=" + string + " serviceType = " + i3);
        }
        if (parseOIDBPkg != 0) {
            QLog.i("TroopOnlineMemberHandler", 1, "handleGameOnlineSwitchStatus error, retCode:" + parseOIDBPkg);
            notifyUI(b.f298034h, false, new Object[]{string, Boolean.FALSE});
            return;
        }
        if (oidb_0xd71_rspbody.show_game_switch_status.has() && oidb_0xd71_rspbody.game_switch_status.has()) {
            z16 = Q2(oidb_0xd71_rspbody.show_game_switch_status.get(), oidb_0xd71_rspbody.game_switch_status.get(), string);
        } else {
            z16 = false;
        }
        notifyUI(b.f298034h, true, new Object[]{string, Boolean.valueOf(z16)});
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.a
    public void M1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        AppInterface appInterface = this.appRuntime;
        if (appInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopOnlineMemberHandler", 2, "getOnlineMemTips, app == null");
                return;
            }
            return;
        }
        ITroopOnlineMemberService iTroopOnlineMemberService = (ITroopOnlineMemberService) appInterface.getRuntimeService(ITroopOnlineMemberService.class, "");
        if (NetConnInfoCenter.getServerTime() < iTroopOnlineMemberService.getAIOTipsNextReqTime(str)) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopOnlineMemberHandler", 2, "getOnlineMemTips, too frequency");
            }
            notifyUI(b.C, true, new Object[]{str, iTroopOnlineMemberService.getOnlineTip(str)});
            return;
        }
        try {
            ITroopInfoService iTroopInfoService = (ITroopInfoService) this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
            oidb_0xa2a$ReqBody oidb_0xa2a_reqbody = new oidb_0xa2a$ReqBody();
            oidb_0xa2a_reqbody.group_id.set(Long.valueOf(str).longValue());
            oidb_0xa2a_reqbody.is_private.set(iTroopInfoService.isQidianPrivateTroop(str));
            TroopInfo troopInfo = iTroopInfoService.getTroopInfo(String.valueOf(str));
            if (troopInfo != null) {
                oidb_0xa2a_reqbody.hok_appid.set((int) troopInfo.hlGuildAppid);
                oidb_0xa2a_reqbody.hok_type.set((int) troopInfo.hlGuildSubType);
            }
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xa2a_2", JsonGrayBusiId.QWALLET_GRAY_TIP_ID, 2, oidb_0xa2a_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("troopUin", str);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            QLog.i("TroopOnlineMemberHandler", 1, "getOnlineMemTips, e=" + e16.toString());
        }
    }

    public void N2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        oidb_0xa2a$RspBody oidb_0xa2a_rspbody = new oidb_0xa2a$RspBody();
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_sso_oidbssopkg, oidb_0xa2a_rspbody);
        int i16 = oidb_sso_oidbssopkg.uint32_service_type.get();
        String string = toServiceMsg.extraData.getString("troopUin");
        if (QLog.isColorLevel()) {
            QLog.i("TroopOnlineMemberHandler", 2, "handleGetDetailOnlineMemberList, retCode=" + parseOIDBPkg + ",troopUin=" + string + " serviceType = " + i16);
        }
        if (parseOIDBPkg == 0) {
            String str = oidb_0xa2a_rspbody.online_info.get();
            if (oidb_0xa2a_rspbody.online_num.has()) {
                i3 = oidb_0xa2a_rspbody.online_num.get();
            } else {
                i3 = 0;
            }
            List<oidb_0xa2a$UserInfo> list = oidb_0xa2a_rspbody.infos.get();
            ArrayList arrayList = new ArrayList();
            for (oidb_0xa2a$UserInfo oidb_0xa2a_userinfo : list) {
                com.tencent.mobileqq.troop.onlinemember.data.b bVar = new com.tencent.mobileqq.troop.onlinemember.data.b();
                bVar.f298044b = String.valueOf(oidb_0xa2a_userinfo.uin.get());
                bVar.f298047e = oidb_0xa2a_userinfo.nick.get();
                bVar.f298045c = oidb_0xa2a_userinfo.tag.get();
                bVar.f298046d = oidb_0xa2a_userinfo.tag_color.get();
                bVar.f298049g = oidb_0xa2a_userinfo.uid.get();
                if (i16 == 3) {
                    bVar.f298043a = 2;
                } else {
                    bVar.f298043a = 1;
                }
                if (oidb_0xa2a_userinfo.score.has()) {
                    bVar.f298048f = oidb_0xa2a_userinfo.score.get();
                }
                arrayList.add(bVar);
            }
            int i17 = oidb_0xa2a_rspbody.cache_time.get();
            if (QLog.isColorLevel()) {
                QLog.i("TroopOnlineMemberHandler", 2, "handleGetDetailOnlineMemberList, onlineTip=" + str + ",size=" + list.size() + ",cacheTime=" + i17 + ",onlineCount=" + i3);
            }
            AppInterface appInterface = this.appRuntime;
            if (appInterface != null) {
                ((ITroopOnlineMemberService) appInterface.getRuntimeService(ITroopOnlineMemberService.class, "")).updateDetailOnlineListCache(string, arrayList, i17, str, i3);
                if (oidb_0xa2a_rspbody.show_game_switch_status.has() && oidb_0xa2a_rspbody.game_switch_status.has()) {
                    Q2(oidb_0xa2a_rspbody.show_game_switch_status.get(), oidb_0xa2a_rspbody.game_switch_status.get(), string);
                }
                if (QLog.isColorLevel()) {
                    for (int i18 = 0; i18 < 3 && i18 < arrayList.size(); i18++) {
                        QLog.i("TroopOnlineMemberHandler", 2, "handleGetDetailOnlineMemberList, uin=" + ((com.tencent.mobileqq.troop.onlinemember.data.b) arrayList.get(i18)).f298044b + ",name=" + ((com.tencent.mobileqq.troop.onlinemember.data.b) arrayList.get(i18)).f298047e + ",tag=" + ((com.tencent.mobileqq.troop.onlinemember.data.b) arrayList.get(i18)).f298045c);
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.i("TroopOnlineMemberHandler", 2, "getDetailOnlineMemberList, app == null");
            }
            notifyUI(b.f298032e, true, new Object[]{string, str});
            return;
        }
        QLog.i("TroopOnlineMemberHandler", 1, "handleGetDetailOnlineMemberList error, retCode=" + parseOIDBPkg);
        notifyUI(b.f298032e, false, new Object[]{string, ""});
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.a
    public void O(String str, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) activity);
            return;
        }
        AppInterface appInterface = this.appRuntime;
        if (appInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopOnlineMemberHandler", 2, "getDetailOnlineMemberList, app == null");
                return;
            }
            return;
        }
        ITroopOnlineMemberService iTroopOnlineMemberService = (ITroopOnlineMemberService) appInterface.getRuntimeService(ITroopOnlineMemberService.class, "");
        boolean z16 = false;
        if (iTroopOnlineMemberService.getRequestListServiceType(str) != 3 && NetConnInfoCenter.getServerTime() < iTroopOnlineMemberService.getDetailNextReqTime(str)) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopOnlineMemberHandler", 2, "getDetailOnlineMemberList, too frequency");
            }
            notifyUI(b.f298032e, true, new Object[]{str, iTroopOnlineMemberService.getOnlineTip(str)});
            return;
        }
        try {
            SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("troop_handler");
            if (cachedLbsInfo != null) {
                P2(str, cachedLbsInfo);
                return;
            }
            if (NetConnInfoCenter.getServerTimeMillis() - iTroopOnlineMemberService.getLastReqLocationTime() > MiniBoxNoticeInfo.MIN_5) {
                QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_LOCATION, QQPermissionConstants.Business.SCENE.SHARE_LOCATION));
                if (qQPermission != null && qQPermission.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    z16 = true;
                }
                if (!z16) {
                    P2(str, null);
                    return;
                } else {
                    R2(iTroopOnlineMemberService, str);
                    return;
                }
            }
            P2(str, null);
            if (QLog.isColorLevel()) {
                QLog.i("TroopOnlineMemberHandler", 2, "location too frequency");
            }
        } catch (Exception e16) {
            QLog.i("TroopOnlineMemberHandler", 1, "getDetailOnlineMemberList, e=" + e16.toString());
        }
    }

    public void O2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        oidb_0xa2a$RspBody oidb_0xa2a_rspbody = new oidb_0xa2a$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xa2a_rspbody);
        String string = toServiceMsg.extraData.getString("troopUin");
        if (QLog.isColorLevel()) {
            QLog.i("TroopOnlineMemberHandler", 2, "handleGetOnlineMemberTips, retCode=" + parseOIDBPkg + ",troopUin=" + string);
        }
        if (parseOIDBPkg == 0) {
            int i17 = oidb_0xa2a_rspbody.cache_time.get();
            String str = oidb_0xa2a_rspbody.online_info.get();
            if (oidb_0xa2a_rspbody.online_num.has()) {
                i3 = oidb_0xa2a_rspbody.online_num.get();
            } else {
                i3 = 0;
            }
            if (oidb_0xa2a_rspbody.list_type.has()) {
                i16 = oidb_0xa2a_rspbody.list_type.get();
            } else {
                i16 = -1;
            }
            int i18 = i16;
            if (QLog.isColorLevel()) {
                QLog.i("TroopOnlineMemberHandler", 2, "handleGetOnlineMemberTips, cacheTime=" + i17 + ", onlineTip:" + str + " ,onlineCount:" + i3 + " , listType:" + i18);
            }
            AppInterface appInterface = this.appRuntime;
            if (appInterface != null) {
                ITroopOnlineMemberService iTroopOnlineMemberService = (ITroopOnlineMemberService) appInterface.getRuntimeService(ITroopOnlineMemberService.class, "");
                if (i18 == 5 && i3 != iTroopOnlineMemberService.getOnlineCount(string)) {
                    notifyUI(b.f298033f, true, new Object[]{string, Boolean.TRUE});
                    iTroopOnlineMemberService.removeDetailOnlineList(string);
                }
                iTroopOnlineMemberService.updateAIOTipsCache(string, i17, str, i18, i3);
                if (oidb_0xa2a_rspbody.show_game_switch_status.has() && oidb_0xa2a_rspbody.game_switch_status.has()) {
                    Q2(oidb_0xa2a_rspbody.show_game_switch_status.get(), oidb_0xa2a_rspbody.game_switch_status.get(), string);
                }
            }
            notifyUI(b.C, true, new Object[]{string, str});
            return;
        }
        QLog.i("TroopOnlineMemberHandler", 1, "handleGetOnlineMemberTips, retCode=" + parseOIDBPkg);
        notifyUI(b.C, false, new Object[]{string, null});
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f298050e == null) {
            HashSet hashSet = new HashSet();
            this.f298050e = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0xa2a_0");
            this.f298050e.add("OidbSvc.0xa2a_1");
            this.f298050e.add("OidbSvc.0xa2a_2");
            this.f298050e.add("OidbSvc.0xa2a_6");
            this.f298050e.add("OidbSvc.0xd71");
        }
        return this.f298050e;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopOnlineMemberHandler";
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.a
    public void i0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            if (this.appRuntime == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopOnlineMemberHandler", 2, "getAllOnlineMemberList, app == null");
                    return;
                }
                return;
            }
            ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.mobileqq.troop.onlinemember.handler.TroopOnlineMemberHandler.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f298051d;

                {
                    this.f298051d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopOnlineMemberHandler.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ITroopOnlineMemberService iTroopOnlineMemberService = (ITroopOnlineMemberService) ((BaseBusinessHandler) TroopOnlineMemberHandler.this).appRuntime.getRuntimeService(ITroopOnlineMemberService.class, "");
                    if (iTroopOnlineMemberService.getRequestListServiceType(this.f298051d) != 3 && NetConnInfoCenter.getServerTime() < iTroopOnlineMemberService.getAllNextReqTime(this.f298051d)) {
                        if (QLog.isColorLevel()) {
                            QLog.i("TroopOnlineMemberHandler", 2, "getAllOnlineMemberList, too frequency");
                        }
                        TroopOnlineMemberHandler.this.notifyUI(b.f298035i, true, new Object[]{this.f298051d, iTroopOnlineMemberService.getAllOnlineList(this.f298051d)});
                        return;
                    }
                    try {
                        ITroopInfoService iTroopInfoService = (ITroopInfoService) ((BaseBusinessHandler) TroopOnlineMemberHandler.this).appRuntime.getRuntimeService(ITroopInfoService.class, "");
                        if (iTroopOnlineMemberService.getRequestListServiceType(this.f298051d) == 3) {
                            i3 = 4;
                        } else {
                            i3 = 1;
                        }
                        oidb_0xa2a$ReqBody oidb_0xa2a_reqbody = new oidb_0xa2a$ReqBody();
                        oidb_0xa2a_reqbody.group_id.set(Long.valueOf(this.f298051d).longValue());
                        oidb_0xa2a_reqbody.is_private.set(iTroopInfoService.isQidianPrivateTroop(this.f298051d));
                        ToServiceMsg makeOIDBPkg = TroopOnlineMemberHandler.this.makeOIDBPkg("OidbSvc.0xa2a_1", JsonGrayBusiId.QWALLET_GRAY_TIP_ID, i3, oidb_0xa2a_reqbody.toByteArray());
                        makeOIDBPkg.extraData.putString("troopUin", this.f298051d);
                        TroopOnlineMemberHandler.this.sendPbReq(makeOIDBPkg);
                    } catch (Exception e16) {
                        QLog.i("TroopOnlineMemberHandler", 1, "getAllOnlineMemberList, e=" + e16.toString());
                    }
                }
            }, 8, null, true);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopOnlineMemberHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopOnlineMemberHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvcTrpcTcp.0xa2a_0".equals(fromServiceMsg.getServiceCmd())) {
                N2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("OidbSvc.0xa2a_1".equals(fromServiceMsg.getServiceCmd())) {
                M2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("OidbSvc.0xa2a_2".equals(fromServiceMsg.getServiceCmd())) {
                O2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else if ("OidbSvc.0xa2a_6".equals(fromServiceMsg.getServiceCmd())) {
                L2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("OidbSvc.0xd71".equals(fromServiceMsg.getServiceCmd())) {
                    K2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopOnlineMemberHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.a
    public void x0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            if (this.appRuntime == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopOnlineMemberHandler", 2, "getAllGameOnlineMemberList, app == null");
                    return;
                }
                return;
            }
            ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.mobileqq.troop.onlinemember.handler.TroopOnlineMemberHandler.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f298052d;

                {
                    this.f298052d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopOnlineMemberHandler.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ITroopOnlineMemberService iTroopOnlineMemberService = (ITroopOnlineMemberService) ((BaseBusinessHandler) TroopOnlineMemberHandler.this).appRuntime.getRuntimeService(ITroopOnlineMemberService.class, "");
                    if (NetConnInfoCenter.getServerTime() < iTroopOnlineMemberService.getAllGameOnlineNextReqTime(this.f298052d)) {
                        if (QLog.isColorLevel()) {
                            QLog.i("TroopOnlineMemberHandler", 2, "getAllGameOnlineMemberList, too frequency");
                        }
                        TroopOnlineMemberHandler.this.notifyUI(b.f298036m, true, new Object[]{this.f298052d, iTroopOnlineMemberService.getAllGameOnlineList(this.f298052d)});
                        return;
                    }
                    try {
                        ITroopInfoService iTroopInfoService = (ITroopInfoService) ((BaseBusinessHandler) TroopOnlineMemberHandler.this).appRuntime.getRuntimeService(ITroopInfoService.class, "");
                        oidb_0xa2a$ReqBody oidb_0xa2a_reqbody = new oidb_0xa2a$ReqBody();
                        oidb_0xa2a_reqbody.group_id.set(Long.valueOf(this.f298052d).longValue());
                        oidb_0xa2a_reqbody.is_private.set(iTroopInfoService.isQidianPrivateTroop(this.f298052d));
                        TroopInfo troopInfo = iTroopInfoService.getTroopInfo(this.f298052d);
                        if (troopInfo != null) {
                            oidb_0xa2a_reqbody.hok_appid.set((int) troopInfo.hlGuildAppid);
                            oidb_0xa2a_reqbody.hok_type.set((int) troopInfo.hlGuildSubType);
                        }
                        ToServiceMsg makeOIDBPkg = TroopOnlineMemberHandler.this.makeOIDBPkg("OidbSvc.0xa2a_6", JsonGrayBusiId.QWALLET_GRAY_TIP_ID, 6, oidb_0xa2a_reqbody.toByteArray());
                        makeOIDBPkg.extraData.putString("troopUin", this.f298052d);
                        TroopOnlineMemberHandler.this.sendPbReq(makeOIDBPkg);
                    } catch (Exception e16) {
                        QLog.i("TroopOnlineMemberHandler", 1, "getAllGameOnlineMemberList, e=" + e16.toString());
                    }
                }
            }, 8, null, true);
        }
    }
}
