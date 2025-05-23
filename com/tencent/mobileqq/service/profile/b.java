package com.tencent.mobileqq.service.profile;

import AvatarInfo.QQHeadUrlReq;
import AvatarInfo.QQHeadUrlResp;
import KQQ.ChangeFriendNameReq;
import KQQ.ChangeFriendNameRes;
import KQQ.CheckUpdateReq;
import KQQ.CheckUpdateResp;
import KQQ.GetRichSigReq;
import KQQ.GetRichSigRes;
import KQQ.GroupMngReq;
import KQQ.ProfGroupInfoReq;
import KQQ.ProfGroupInfoRes;
import KQQ.ProfIncInfoReq;
import KQQ.ProfSmpInfoRes;
import KQQ.ProfUsrQryReq;
import KQQ.ProfVipqqInfoReq;
import KQQ.ProfVipqqInfoRes;
import KQQ.ReqItem;
import KQQ.ReqRichInfo;
import KQQ.SetRichSigReq;
import KQQ.SetRichSigRes;
import KQQ.SyncRes;
import KQQ.WeatherInfoReq;
import QQService.SvcReqBindUin;
import QQService.SvcReqDelLoginInfo;
import QQService.SvcReqGetDevLoginInfo;
import QQService.SvcReqKikOut;
import QQService.SvcRespKikOut;
import QQService.SvcRspBindUin;
import QQService.SvcRspDelLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import ResPackage.ReqResOrder;
import ResPackage.ReqResUpdate;
import ResPackage.RspResOrder;
import ResPackage.RspResUpdate;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.e;
import com.tencent.mobileqq.troop.service.api.IBizTroopServiceApi;
import com.tencent.mobileqq.troop.service.api.impl.BizTroopServiceApiImpl;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.state.data.SquareJSConst;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends BaseProtocolCoder {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f286374m;

    /* renamed from: d, reason: collision with root package name */
    private int f286375d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<AppInterface> f286376e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.service.troop.c f286377f;

    /* renamed from: h, reason: collision with root package name */
    private e f286378h;

    /* renamed from: i, reason: collision with root package name */
    private IBizTroopServiceApi f286379i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74995);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f286374m = new String[]{"ProfileService", "StatSvc", "AvatarInfoSvr", "NickQuerySvc", "GetAvatarInfo", "ChatAvatar"};
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f286375d = 0;
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.f286376e = new WeakReference<>(appInterface);
        this.f286379i = (IBizTroopServiceApi) QRoute.api(IBizTroopServiceApi.class);
        this.requestHandles.put(ProfileContants.CMD_GETWEATHERINFO, 1);
        this.requestHandles.put(ProfileContants.CMD_GETSIMPLEINFO, 2);
        this.requestHandles.put(ProfileContants.CMD_GETSIGNATURE, 3);
        this.requestHandles.put(ProfileContants.CMD_SETSIGNATURE, 7);
        this.requestHandles.put(ProfileContants.CMD_SETCOMMENT, 8);
        this.requestHandles.put(ProfileContants.CMD_GETPROFINCINFO, 11);
        this.requestHandles.put(ProfileContants.CMD_PROFVIPQQINFO, 12);
        this.requestHandles.put(FaceConstant.AvatarHandlerCmd.CMD_GETQQHEAD, 13);
        this.requestHandles.put(ProfileContants.CMD_GETGROUPINFOREQ, 15);
        this.requestHandles.put(ProfileContants.CMD_GROUPMNGREQ, 17);
        this.requestHandles.put(ProfileContants.CMD_CHECK_UPDATE_REQ, 23);
        this.requestHandles.put(ProfileContants.CMD_REQ_RES_ORDER, 24);
        this.requestHandles.put(ProfileContants.CMD_REQ_RES_UPDATE, 25);
        this.requestHandles.put(ProfileContants.CMD_REQ_RES_GET_DEVLOGININFO, 26);
        this.requestHandles.put(ProfileContants.CMD_REQ_RES_DEL_DEVLOGININFO, 27);
        this.requestHandles.put(ProfileContants.CMD_REQ_KICKOUT_DEV, 28);
        this.requestHandles.put(ProfileContants.CMD_REQ_BINDUIN_STATE, 29);
        this.requestHandles.put(IOnlineStatusService.CMD_SET_ONLINE_STATUS, 31);
        this.f286377f = new com.tencent.mobileqq.service.troop.c(appInterface);
        this.f286378h = new e(appInterface);
    }

    private boolean A(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long a16 = a(toServiceMsg.extraData.getString("uin"));
        GroupMngReq groupMngReq = new GroupMngReq();
        groupMngReq.reqtype = 0;
        groupMngReq.uin = a16;
        groupMngReq.cIsSupportAuthQuestionJoin = (byte) 1;
        long a17 = a(toServiceMsg.extraData.getString("troop_uin"));
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) a17);
        groupMngReq.vecBody = allocate.array();
        groupMngReq.wSourceID = toServiceMsg.extraData.getInt(ProfileContants.CMD_PARAM_STAT_OPTION);
        groupMngReq.cIfGetAuthInfo = toServiceMsg.extraData.getByte("cIfGetAuthInfo");
        uniPacket.setEncodeName("utf-8");
        uniPacket.setServantName(BizTroopServiceApiImpl.WUP_PROFILE_SERVANTNAME);
        uniPacket.setFuncName("GroupMngReq");
        uniPacket.put("GroupMngReq", groupMngReq);
        return true;
    }

    private boolean B(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long a16 = a(toServiceMsg.extraData.getString("uin"));
        if (a16 == 0) {
            I(toServiceMsg);
            return false;
        }
        ChangeFriendNameReq changeFriendNameReq = new ChangeFriendNameReq(a16, toServiceMsg.extraData.getString(ProfileContants.CMD_PARAM_COM_VALUE));
        uniPacket.setServantName(BizTroopServiceApiImpl.WUP_PROFILE_SERVANTNAME);
        uniPacket.setFuncName("ChangeFriendName");
        uniPacket.put("req", changeFriendNameReq);
        return true;
    }

    private boolean C(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        SetRichSigReq setRichSigReq = new SetRichSigReq(toServiceMsg.extraData.getByteArray(ProfileContants.CMD_PARAM_SIG_VALUE), toServiceMsg.extraData.getInt("key"));
        uniPacket.setServantName(BizTroopServiceApiImpl.WUP_PROFILE_SERVANTNAME);
        uniPacket.setFuncName("SetRichSig");
        uniPacket.put("SetRichSigReq", setRichSigReq);
        return true;
    }

    private boolean D(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        String string = toServiceMsg.extraData.getString("uin");
        String string2 = toServiceMsg.extraData.getString("troop_uin");
        if (a(string) == 0) {
            I(toServiceMsg);
            return false;
        }
        ProfGroupInfoReq profGroupInfoReq = new ProfGroupInfoReq();
        profGroupInfoReq.uGroupCode = a(string2);
        profGroupInfoReq.dwTimeStamp = toServiceMsg.extraData.getLong(ProfileContants.CMD_PARAM_GROUPABLM_TIMESTAMP);
        profGroupInfoReq.cIsGetGroupAlbum = toServiceMsg.extraData.getByte(ProfileContants.CMD_PARAM_GET_GROUPABLM);
        profGroupInfoReq.wSourceID = toServiceMsg.extraData.getInt(ProfileContants.CMD_PARAM_CSTATOPTION, 0);
        profGroupInfoReq.cIfGetAuthInfo = toServiceMsg.extraData.getByte("cIfGetAuthInfo");
        uniPacket.setServantName(BizTroopServiceApiImpl.WUP_PROFILE_SERVANTNAME);
        uniPacket.setFuncName("GroupInfoReq");
        uniPacket.put("req", profGroupInfoReq);
        return true;
    }

    private boolean E(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("StatSvc");
        uniPacket.setFuncName("SvcReqBindUin");
        SvcReqBindUin svcReqBindUin = new SvcReqBindUin();
        svcReqBindUin.cCmd = toServiceMsg.extraData.getByte("cCmd");
        svcReqBindUin.vecBindUin = (ArrayList) toServiceMsg.getAttribute("vecBindUin");
        toServiceMsg.addAttribute("vecBindUin", null);
        uniPacket.put("SvcReqBindUin", svcReqBindUin);
        return true;
    }

    private boolean F(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("StatSvc");
        uniPacket.setFuncName("SvcReqDelLoginInfo");
        SvcReqDelLoginInfo svcReqDelLoginInfo = new SvcReqDelLoginInfo();
        svcReqDelLoginInfo.strAppName = toServiceMsg.extraData.getString("strAppName");
        svcReqDelLoginInfo.vecDeviceItemDes = (ArrayList) toServiceMsg.getAttribute("vecDeviceItemDes");
        toServiceMsg.addAttribute("vecDeviceItemDes", null);
        svcReqDelLoginInfo.vecGuid = toServiceMsg.extraData.getByteArray("vecGuid");
        svcReqDelLoginInfo.iDelType = toServiceMsg.extraData.getInt("iDelType");
        svcReqDelLoginInfo.iDelMe = toServiceMsg.extraData.getInt("iDelMe");
        svcReqDelLoginInfo.iAppId = toServiceMsg.extraData.getLong("iAppId");
        uniPacket.put("SvcReqDelLoginInfo", svcReqDelLoginInfo);
        return true;
    }

    private boolean G(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("StatSvc");
        uniPacket.setFuncName("SvcReqGetDevLoginInfo");
        SvcReqGetDevLoginInfo svcReqGetDevLoginInfo = new SvcReqGetDevLoginInfo();
        svcReqGetDevLoginInfo.iLoginType = toServiceMsg.extraData.getLong("iLoginType");
        svcReqGetDevLoginInfo.iNextItemIndex = toServiceMsg.extraData.getLong("iNextItemIndex");
        svcReqGetDevLoginInfo.iRequireMax = toServiceMsg.extraData.getLong("iRequireMax");
        svcReqGetDevLoginInfo.iTimeStamp = toServiceMsg.extraData.getLong("iTimeStamp");
        svcReqGetDevLoginInfo.strAppName = toServiceMsg.extraData.getString("strAppName");
        svcReqGetDevLoginInfo.vecGuid = toServiceMsg.extraData.getByteArray("vecGuid");
        svcReqGetDevLoginInfo.iGetDevListType = toServiceMsg.extraData.getLong("iGetDevListType");
        uniPacket.put("SvcReqGetDevLoginInfo", svcReqGetDevLoginInfo);
        return true;
    }

    private boolean H(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("StatSvc");
        uniPacket.setFuncName("SvcReqKikOut");
        SvcReqKikOut svcReqKikOut = new SvcReqKikOut();
        svcReqKikOut.appid = toServiceMsg.extraData.getLong("appid");
        svcReqKikOut.cKeyType = toServiceMsg.extraData.getByte("cKeyType");
        svcReqKikOut.lUin = toServiceMsg.extraData.getLong("lUin");
        svcReqKikOut.sKey = toServiceMsg.extraData.getByteArray(IPublicAccountDetailReportUtil.KEY_SEARCH);
        uniPacket.put("req", svcReqKikOut);
        return true;
    }

    private long a(String str) {
        long parseLong;
        if (str == null) {
            return 0L;
        }
        if (str.length() > 0) {
            try {
                parseLong = Long.parseLong(str);
                if (parseLong < 10000) {
                    return 0L;
                }
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return parseLong;
    }

    private boolean b(ToServiceMsg toServiceMsg, ArrayList<Long> arrayList, UniPacket uniPacket) {
        uniPacket.setServantName(BizTroopServiceApiImpl.WUP_PROFILE_SERVANTNAME);
        uniPacket.setFuncName("GetSimpleInfo");
        boolean z16 = toServiceMsg.extraData.getBoolean("reqSelfLevel", false);
        boolean z17 = toServiceMsg.extraData.getBoolean("reqXMan", false);
        boolean z18 = toServiceMsg.extraData.getBoolean("reqDateNick", false);
        uniPacket.put("req", new ProfUsrQryReq(0, "", arrayList, 1, 1, (byte) 0, z16 ? 1 : 0, z17 ? 1 : 0, (byte) 1, z18 ? (byte) 1 : (byte) 0, (byte) 1, toServiceMsg.extraData.getInt("getXManInfoScene", 1)));
        return true;
    }

    private boolean c(String str, UniPacket uniPacket) {
        uniPacket.setEncodeName("utf-8");
        uniPacket.setServantName(BizTroopServiceApiImpl.WUP_PROFILE_SERVANTNAME);
        uniPacket.setFuncName("GetWeatherInfo");
        int i3 = this.f286375d;
        this.f286375d = i3 + 1;
        uniPacket.put("req", new WeatherInfoReq(i3, "", str));
        return true;
    }

    private Object e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (ProfGroupInfoRes) decodePacket(fromServiceMsg.getWupBuffer(), "res", new ProfGroupInfoRes());
    }

    private Object f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (QQHeadUrlResp) decodePacket(fromServiceMsg.getWupBuffer(), "QQHeadUrlResp", new QQHeadUrlResp());
    }

    private Object g(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return decodePacket(fromServiceMsg.getWupBuffer(), "GetRichSigRes", new GetRichSigRes());
    }

    private AppInterface getApp() {
        WeakReference<AppInterface> weakReference = this.f286376e;
        if (weakReference == null || weakReference.get() == null) {
            this.f286376e = new WeakReference<>((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null));
        }
        return this.f286376e.get();
    }

    private Object h(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ProfSmpInfoRes());
            ArrayList arrayList2 = (ArrayList) uniPacket.getByClass("res", arrayList);
            if (QLog.isColorLevel()) {
                if (arrayList2 != null && arrayList2.size() > 0) {
                    QLog.e("BusinessCard_Manager", 2, "businessCardFlag: " + ((int) ((ProfSmpInfoRes) arrayList2.get(0)).cBusiCardFlag));
                } else {
                    QLog.e("BusinessCard_Manager", 2, "businessCardFlag: empty");
                }
            }
            return arrayList2;
        } catch (RuntimeException | Exception unused) {
            return null;
        }
    }

    private Object i(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (ProfVipqqInfoRes) decodePacket(fromServiceMsg.getWupBuffer(), "res", new ProfVipqqInfoRes());
    }

    private Object j(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (SyncRes) decodePacket(fromServiceMsg.getWupBuffer(), "SyncRes", new SyncRes());
    }

    private Object k(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (SvcRspBindUin) decodePacket(fromServiceMsg.getWupBuffer(), "SvcRspBindUin", new SvcRspBindUin());
    }

    private Object l(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (SvcRespKikOut) decodePacket(fromServiceMsg.getWupBuffer(), "resp", new SvcRespKikOut());
    }

    private Object m(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (ChangeFriendNameRes) decodePacket(fromServiceMsg.getWupBuffer(), "res", new ChangeFriendNameRes());
    }

    private Object n(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return decodePacket(fromServiceMsg.getWupBuffer(), "SetRichSigRes", new SetRichSigRes());
    }

    private Object o(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (SvcRspDelLoginInfo) decodePacket(fromServiceMsg.getWupBuffer(), "SvcRspDelLoginInfo", new SvcRspDelLoginInfo());
    }

    private Object p(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (SvcRspGetDevLoginInfo) decodePacket(fromServiceMsg.getWupBuffer(), "SvcRspGetDevLoginInfo", new SvcRspGetDevLoginInfo());
    }

    private Object q(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (RspResOrder) decodePacket(fromServiceMsg.getWupBuffer(), "RspResOrder", new RspResOrder());
    }

    private Object r(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (RspResUpdate) decodePacket(fromServiceMsg.getWupBuffer(), "RspResUpdate", new RspResUpdate());
    }

    private boolean s(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        ReqItem d26;
        ReqItem d27;
        CheckUpdateReq checkUpdateReq = new CheckUpdateReq();
        checkUpdateReq.isSupportSubPack = true;
        checkUpdateReq.vecReqPkg = new ArrayList<>();
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("isFirstTime", Boolean.TRUE)).booleanValue();
        int intValue = ((Integer) toServiceMsg.getAttribute("CheckUpdateType", 0)).intValue();
        if (booleanValue) {
            for (Map.Entry<Integer, a> entry : ((QQAppInterface) getApp()).mAutomator.E2().entrySet()) {
                entry.getKey();
                a value = entry.getValue();
                if ((value.w0() & intValue) != 0 && (d27 = value.d2(intValue)) != null) {
                    checkUpdateReq.vecReqPkg.add(d27);
                }
            }
        } else {
            a aVar = ((QQAppInterface) getApp()).mAutomator.E2().get(101);
            if ((aVar.w0() & intValue) != 0 && (d26 = aVar.d2(intValue)) != null) {
                checkUpdateReq.vecReqPkg.add(d26);
            }
        }
        uniPacket.setServantName(BizTroopServiceApiImpl.WUP_PROFILE_SERVANTNAME);
        uniPacket.setFuncName("CheckUpdateReq");
        uniPacket.put("CheckUpdateReq", checkUpdateReq);
        return true;
    }

    private boolean t(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long a16 = a(toServiceMsg.extraData.getString("uin"));
        if (a16 == 0) {
            I(toServiceMsg);
            return false;
        }
        ProfIncInfoReq profIncInfoReq = new ProfIncInfoReq();
        profIncInfoReq.iUin = a16;
        profIncInfoReq.iRetIncomPlete = 1;
        profIncInfoReq.iReloadFlag = 1;
        uniPacket.setServantName(BizTroopServiceApiImpl.WUP_PROFILE_SERVANTNAME);
        uniPacket.setFuncName("GetProfIncInfo");
        uniPacket.put("req", profIncInfoReq);
        return true;
    }

    private boolean u(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        QQHeadUrlReq qQHeadUrlReq = new QQHeadUrlReq();
        JceInputStream jceInputStream = new JceInputStream(toServiceMsg.extraData.getByteArray("QQHeadUrlReq"));
        jceInputStream.setServerEncoding("UTF-8");
        qQHeadUrlReq.readFrom(jceInputStream);
        if (qQHeadUrlReq.dstUsrType < 0 && QLog.isColorLevel()) {
            QLog.e("", 2, "==============================handleGetQQHead error! ");
        }
        uniPacket.setServantName("GetAvatarInfo");
        uniPacket.setFuncName("QQHeadUrlReq");
        uniPacket.put("QQHeadUrlReq", qQHeadUrlReq);
        toServiceMsg.setServiceCmd(FaceConstant.AvatarHandlerCmd.CMD_GETQQHEAD);
        return true;
    }

    private boolean v(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long j3;
        String[] stringArray = toServiceMsg.extraData.getStringArray("sendArray");
        boolean z16 = false;
        if (stringArray == null || stringArray.length == 0) {
            return false;
        }
        int i3 = toServiceMsg.extraData.getInt("reqType", 0);
        boolean z17 = toServiceMsg.extraData.getBoolean("showDateNickname");
        ArrayList arrayList = new ArrayList();
        for (String str : stringArray) {
            try {
                long parseLong = Long.parseLong(str);
                if (i3 != 1) {
                    d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ProfileService");
                    if (friendsSimpleInfoWithUid != null) {
                        j3 = friendsSimpleInfoWithUid.t();
                    } else {
                        j3 = 0;
                    }
                    arrayList.add(new ReqRichInfo(parseLong, j3));
                }
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        if (i3 == 1) {
            z16 = true;
        }
        GetRichSigReq getRichSigReq = new GetRichSigReq(arrayList, z16, z17, true);
        uniPacket.setServantName(BizTroopServiceApiImpl.WUP_PROFILE_SERVANTNAME);
        uniPacket.setFuncName("GetRichSig");
        uniPacket.put("GetRichSigReq", getRichSigReq);
        return true;
    }

    private boolean w(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        if (a(toServiceMsg.extraData.getString("uin")) == 0) {
            I(toServiceMsg);
            return false;
        }
        if (toServiceMsg.extraData.getInt(ProfileContants.CMD_GROUPMNGER_PARAM_REQTYPE) != 0) {
            I(toServiceMsg);
            return false;
        }
        return A(toServiceMsg, uniPacket);
    }

    private boolean x(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long a16 = a(toServiceMsg.extraData.getString("uin"));
        if (a16 == 0) {
            I(toServiceMsg);
            return false;
        }
        ProfVipqqInfoReq profVipqqInfoReq = new ProfVipqqInfoReq();
        profVipqqInfoReq.iUin = a16;
        profVipqqInfoReq.iRetIncomPlete = 1;
        profVipqqInfoReq.iReloadFlag = 1;
        uniPacket.setServantName(BizTroopServiceApiImpl.WUP_PROFILE_SERVANTNAME);
        uniPacket.setFuncName("ProfVipqqInfo");
        uniPacket.put("req", profVipqqInfoReq);
        return true;
    }

    private boolean y(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("MQQ.ChatAvatarServer.ChatAvatarObj");
        uniPacket.setFuncName("ReqResOrder");
        ReqResOrder reqResOrder = new ReqResOrder();
        reqResOrder.ResID = 1;
        reqResOrder.Path = Integer.toString(toServiceMsg.extraData.getInt(ProfileContants.CMD_REQ_RES_ORDER_PKGID, 0));
        uniPacket.put("ReqResOrder", reqResOrder);
        return true;
    }

    private boolean z(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("MQQ.ChatAvatarServer.ChatAvatarObj");
        uniPacket.setFuncName("ReqResUpdate");
        ReqResUpdate reqResUpdate = new ReqResUpdate();
        reqResUpdate.SeqID = toServiceMsg.extraData.getInt("seq_id", 0);
        reqResUpdate.ResID = toServiceMsg.extraData.getInt("ResID", 2);
        uniPacket.put("ReqResUpdate", reqResUpdate);
        return true;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return f286374m;
    }

    public Object d(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        if (QLog.isColorLevel()) {
            QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, "decodeCheckUpdateReq() ");
        }
        return (CheckUpdateResp) decodePacket(fromServiceMsg.getWupBuffer(), "CheckUpdateResp", new CheckUpdateResp());
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        Object handleDecode = this.f286379i.handleDecode(toServiceMsg, fromServiceMsg);
        if (handleDecode != null) {
            return handleDecode;
        }
        Integer num = this.requestHandles.get(fromServiceMsg.getServiceCmd());
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = -1;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 7) {
                    if (i3 != 8) {
                        if (i3 != 12) {
                            if (i3 != 13) {
                                if (i3 != 15) {
                                    switch (i3) {
                                        case 22:
                                            return j(toServiceMsg, fromServiceMsg);
                                        case 23:
                                            return d(toServiceMsg, fromServiceMsg);
                                        case 24:
                                            return q(toServiceMsg, fromServiceMsg);
                                        case 25:
                                            return r(toServiceMsg, fromServiceMsg);
                                        case 26:
                                            return p(toServiceMsg, fromServiceMsg);
                                        case 27:
                                            return o(toServiceMsg, fromServiceMsg);
                                        case 28:
                                            return l(toServiceMsg, fromServiceMsg);
                                        case 29:
                                            return k(toServiceMsg, fromServiceMsg);
                                        case 30:
                                            return this.f286377f.decode(toServiceMsg, fromServiceMsg);
                                        case 31:
                                            return this.f286378h.decode(toServiceMsg, fromServiceMsg);
                                        default:
                                            return null;
                                    }
                                }
                                return e(toServiceMsg, fromServiceMsg);
                            }
                            return f(toServiceMsg, fromServiceMsg);
                        }
                        i(toServiceMsg, fromServiceMsg);
                        return null;
                    }
                    return m(toServiceMsg, fromServiceMsg);
                }
                return n(toServiceMsg, fromServiceMsg);
            }
            return g(toServiceMsg, fromServiceMsg);
        }
        return h(toServiceMsg, fromServiceMsg);
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        return handleRequest(toServiceMsg, uniPacket);
    }

    public boolean handleRequest(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        if (this.f286379i.handleRequest(toServiceMsg, uniPacket)) {
            return true;
        }
        int intValue = this.requestHandles.get(toServiceMsg.getServiceCmd()).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 7) {
                        if (intValue != 8) {
                            if (intValue != 15) {
                                if (intValue != 17) {
                                    switch (intValue) {
                                        case 11:
                                            return t(toServiceMsg, uniPacket);
                                        case 12:
                                            return x(toServiceMsg, uniPacket);
                                        case 13:
                                            return u(toServiceMsg, uniPacket);
                                        default:
                                            switch (intValue) {
                                                case 23:
                                                    return s(toServiceMsg, uniPacket);
                                                case 24:
                                                    return y(toServiceMsg, uniPacket);
                                                case 25:
                                                    return z(toServiceMsg, uniPacket);
                                                case 26:
                                                    return G(toServiceMsg, uniPacket);
                                                case 27:
                                                    return F(toServiceMsg, uniPacket);
                                                case 28:
                                                    return H(toServiceMsg, uniPacket);
                                                case 29:
                                                    return E(toServiceMsg, uniPacket);
                                                case 30:
                                                    return this.f286377f.encodeReqMsg(toServiceMsg, uniPacket);
                                                case 31:
                                                    return this.f286378h.encodeReqMsg(toServiceMsg, uniPacket);
                                                default:
                                                    return false;
                                            }
                                    }
                                }
                                return w(toServiceMsg, uniPacket);
                            }
                            return D(toServiceMsg, uniPacket);
                        }
                        return B(toServiceMsg, uniPacket);
                    }
                    return C(toServiceMsg, uniPacket);
                }
                return v(toServiceMsg, uniPacket);
            }
            ArrayList<Long> arrayList = new ArrayList<>();
            Iterator<String> it = toServiceMsg.extraData.getStringArrayList(SquareJSConst.Params.PARAMS_UIN_LIST).iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(Long.parseLong(it.next())));
            }
            b(toServiceMsg, arrayList, uniPacket);
            return true;
        }
        String string = toServiceMsg.extraData.getString("city");
        if (string == null) {
            string = "";
        }
        c(string, uniPacket);
        return true;
    }

    private void I(ToServiceMsg toServiceMsg) {
    }
}
