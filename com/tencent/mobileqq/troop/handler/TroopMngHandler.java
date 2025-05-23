package com.tencent.mobileqq.troop.handler;

import KQQ.GroupMngRes;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.api.config.ag;
import com.tencent.mobileqq.troop.api.handler.h;
import com.tencent.mobileqq.troop.api.observer.b;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xcca.cmd0xcca$ReqBody;
import tencent.im.oidb.cmd0xcca.cmd0xcca$RspBody;
import tencent.im.oidb.cmd0xe72.oidb_0xe72$ReqBody;
import tencent.im.oidb.cmd0xe72.oidb_0xe72$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopMngHandler extends TroopBaseHandler implements h {
    static IPatchRedirector $redirector_;

    public TroopMngHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            ag.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void F2(ToServiceMsg toServiceMsg, GroupMngRes groupMngRes) {
        Integer num;
        TroopInfo findTroopInfo;
        boolean z16;
        byte[] bArr = groupMngRes.vecBody;
        TroopInfo troopInfo = new TroopInfo("");
        Integer num2 = null;
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            troopInfo.troopcode = String.valueOf(wrap.getInt() & 4294967295L);
            troopInfo.setTroopUin(String.valueOf(wrap.getInt() & 4294967295L));
            troopInfo.strLocation = groupMngRes.sGroupLocation;
            troopInfo.troopAuthenticateInfo = groupMngRes.sAuthGrpInfo;
            troopInfo.joinTroopQuestion = groupMngRes.sJoinQuestion;
            troopInfo.joinTroopAnswer = groupMngRes.sJoinAnswer;
            num = null;
            while (wrap.remaining() > 0) {
                try {
                    int i3 = wrap.get() & 255;
                    wrap.remaining();
                    switch (i3) {
                        case 1:
                            wrap.get();
                            troopInfo.extDBInfo.troopType = wrap.get() & 255;
                            num2 = Integer.valueOf(troopInfo.extDBInfo.troopType);
                            break;
                        case 2:
                            wrap.get();
                            troopInfo.troopCreateTime = wrap.getInt() & 4294967295L;
                            break;
                        case 3:
                            wrap.get();
                            troopInfo.dwGroupFlag = wrap.getInt() & 4294967295L;
                            break;
                        case 4:
                            wrap.get();
                            troopInfo.troopowneruin = String.valueOf(wrap.getInt() & 4294967295L);
                            break;
                        case 5:
                            wrap.get();
                            troopInfo.cGroupOption = (short) (wrap.get() & 255);
                            break;
                        case 6:
                        case 10:
                        case 15:
                        case 17:
                        default:
                            int i16 = wrap.get() & 255;
                            wrap.get(new byte[i16], 0, i16);
                            break;
                        case 7:
                            wrap.get();
                            troopInfo.dwGroupClassExt = wrap.getInt() & 4294967295L;
                            break;
                        case 8:
                            wrap.get();
                            troopInfo.wMemberMax = wrap.getShort() & 65535;
                            break;
                        case 9:
                            wrap.get();
                            troopInfo.extDBInfo.specialClass = 65535 & wrap.getShort();
                            num = Integer.valueOf(troopInfo.extDBInfo.specialClass);
                            break;
                        case 11:
                            wrap.get();
                            break;
                        case 12:
                            wrap.get();
                            troopInfo.dwGroupFlagExt = wrap.getInt() & 4294967295L;
                            break;
                        case 13:
                            int i17 = wrap.get() & 255;
                            byte[] bArr2 = new byte[i17];
                            wrap.get(bArr2, 0, i17);
                            troopInfo.troopname = PkgTools.utf8Byte2String(bArr2, 0, i17);
                            break;
                        case 14:
                            wrap.get();
                            troopInfo.troopface = (short) (wrap.getShort() & 65535);
                            break;
                        case 16:
                            int i18 = wrap.get() & 255;
                            byte[] bArr3 = new byte[i18];
                            wrap.get(bArr3, 0, i18);
                            troopInfo.fingertroopmemo = PkgTools.utf8Byte2String(bArr3, 0, i18);
                            break;
                        case 18:
                            wrap.get();
                            troopInfo.wMemberNum = wrap.getShort() & 65535;
                            break;
                    }
                } catch (BufferUnderflowException e16) {
                    e = e16;
                    e.printStackTrace();
                    if (num2 == null) {
                    }
                    ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).updateTroopTypeAndSpecialClass(troopInfo.troopuin, num2, num, "TroopMngHandler");
                    findTroopInfo = ((ITroopInfoService) this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(troopInfo.troopuin);
                    if (findTroopInfo == null) {
                    }
                    notifyUI(b.f294308f, true, new Object[]{Byte.valueOf(groupMngRes.result), troopInfo, Boolean.valueOf(z16)});
                }
            }
        } catch (BufferUnderflowException e17) {
            e = e17;
            num = null;
        }
        if (num2 == null || num != null) {
            ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).updateTroopTypeAndSpecialClass(troopInfo.troopuin, num2, num, "TroopMngHandler");
        }
        findTroopInfo = ((ITroopInfoService) this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(troopInfo.troopuin);
        if (findTroopInfo == null) {
            TroopExtDBInfo troopExtDBInfo = findTroopInfo.extDBInfo;
            TroopExtDBInfo troopExtDBInfo2 = troopInfo.extDBInfo;
            troopExtDBInfo.troopType = troopExtDBInfo2.troopType;
            findTroopInfo.troopCreateTime = troopInfo.troopCreateTime;
            findTroopInfo.dwGroupFlag = troopInfo.dwGroupFlag;
            findTroopInfo.troopowneruin = troopInfo.troopowneruin;
            findTroopInfo.cGroupOption = troopInfo.cGroupOption;
            findTroopInfo.dwGroupClassExt = troopInfo.dwGroupClassExt;
            findTroopInfo.wMemberMax = troopInfo.wMemberMax;
            troopExtDBInfo.specialClass = troopExtDBInfo2.specialClass;
            findTroopInfo.troopface = troopInfo.troopface;
            findTroopInfo.fingertroopmemo = troopInfo.fingertroopmemo;
            findTroopInfo.wMemberNum = troopInfo.wMemberNum;
            findTroopInfo.strLocation = troopInfo.strLocation;
            findTroopInfo.dwGroupFlagExt = troopInfo.dwGroupFlagExt;
            findTroopInfo.troopAuthenticateInfo = troopInfo.troopAuthenticateInfo;
            findTroopInfo.joinTroopQuestion = troopInfo.joinTroopQuestion;
            z16 = true;
        } else {
            ITroopSystemMsgUtilApi iTroopSystemMsgUtilApi = (ITroopSystemMsgUtilApi) QRoute.api(ITroopSystemMsgUtilApi.class);
            iTroopSystemMsgUtilApi.saveTroopNameToSP(this.appRuntime.getApp(), troopInfo.troopuin, troopInfo.troopname);
            iTroopSystemMsgUtilApi.saveTroopFlagExToSP(this.appRuntime.getApp(), troopInfo.troopuin, troopInfo.dwGroupFlagExt);
            iTroopSystemMsgUtilApi.saveTroopQuestionToSP(this.appRuntime.getApp(), troopInfo.troopuin, troopInfo.joinTroopQuestion);
            z16 = false;
        }
        notifyUI(b.f294308f, true, new Object[]{Byte.valueOf(groupMngRes.result), troopInfo, Boolean.valueOf(z16)});
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        int i16;
        int i17;
        if (toServiceMsg != null && fromServiceMsg != null) {
            cmd0xcca$RspBody cmd0xcca_rspbody = new cmd0xcca$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xcca_rspbody);
            if (QLog.isColorLevel()) {
                QLog.i("TroopMngHandler", 2, "handleGetGroupInviteStatus result code is: " + parseOIDBPkg);
            }
            if (parseOIDBPkg == 0) {
                ArrayList arrayList = new ArrayList();
                if (cmd0xcca_rspbody.uint32_group_members_num.has()) {
                    i3 = cmd0xcca_rspbody.uint32_group_members_num.get();
                } else {
                    i3 = 0;
                }
                if (cmd0xcca_rspbody.uint32_group_friends_num.has()) {
                    i16 = cmd0xcca_rspbody.uint32_group_friends_num.get();
                } else {
                    i16 = 0;
                }
                if (cmd0xcca_rspbody.friends_uins.has()) {
                    for (int i18 = 0; i18 < cmd0xcca_rspbody.friends_uins.size(); i18++) {
                        arrayList.add(String.valueOf(cmd0xcca_rspbody.friends_uins.get(i18)));
                    }
                }
                if (cmd0xcca_rspbody.uint32_status.has()) {
                    i17 = cmd0xcca_rspbody.uint32_status.get();
                } else {
                    i17 = 0;
                }
                notifyUI(b.F, true, new Object[]{Integer.valueOf(parseOIDBPkg), Integer.valueOf(i3), Integer.valueOf(i16), arrayList, Integer.valueOf(i17)});
                return;
            }
            notifyUI(b.F, false, new Object[]{Integer.valueOf(parseOIDBPkg), 0, 0, null, 0});
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopMngHandler", 2, "handleGetGroupInviteStatus req or resp is null.");
        }
    }

    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int i3 = toServiceMsg.extraData.getInt(ProfileContants.CMD_GROUPMNGER_PARAM_REQTYPE);
        String string = toServiceMsg.extraData.getString("troop_uin");
        if (fromServiceMsg.isSuccess()) {
            GroupMngRes groupMngRes = (GroupMngRes) decodePacket(fromServiceMsg.getWupBuffer(), "GroupMngRes", new GroupMngRes());
            if (groupMngRes == null) {
                notifyUI(b.f294307e, false, new Object[]{Integer.valueOf(i3), (byte) -1});
                ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).doTroopCmdReport(toServiceMsg, fromServiceMsg.getResultCode(), 0);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopMngHandler", 2, "handleGroupManager: groupreqType = " + i3 + ", troopCode = " + string + ", res.isSucc=" + fromServiceMsg.isSuccess() + ", resp.ret=" + ((int) groupMngRes.result));
            }
            ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).doTroopCmdReport(toServiceMsg, fromServiceMsg.getResultCode(), groupMngRes.result);
            if (i3 != 0) {
                notifyUI(b.f294307e, false, new Object[]{Integer.valueOf(i3), (byte) -1});
                return;
            } else {
                I2(toServiceMsg, fromServiceMsg, groupMngRes);
                return;
            }
        }
        notifyUI(b.f294307e, false, new Object[]{Integer.valueOf(i3), (byte) -1});
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).doTroopCmdReport(toServiceMsg, fromServiceMsg.getResultCode(), 0);
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, GroupMngRes groupMngRes) {
        if (fromServiceMsg.isSuccess() && groupMngRes.result == 0) {
            F2(toServiceMsg, groupMngRes);
        } else {
            notifyUI(b.f294308f, fromServiceMsg.isSuccess(), new Object[]{Byte.valueOf(groupMngRes.result), null, Boolean.FALSE});
        }
    }

    public void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            String str = (String) toServiceMsg.getAttribute("troopUin", "");
            String str2 = (String) toServiceMsg.getAttribute("userUin", "");
            String str3 = (String) toServiceMsg.getAttribute("authKey", "");
            oidb_0xe72$RspBody oidb_0xe72_rspbody = new oidb_0xe72$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xe72_rspbody);
            int i3 = oidb_0xe72_rspbody.uint32_no_verify.get();
            int i16 = oidb_0xe72_rspbody.uint32_high_risk_group.get();
            if (parseOIDBPkg == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!TextUtils.isEmpty(str3)) {
                notifyUI(b.E, z16, new Object[]{Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i16)});
                return;
            } else {
                notifyUI(b.E, z16, new Object[]{str, Integer.valueOf(i16)});
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMngHandler", 2, "handleQueryJoinTroopCanNoVierfy resp == null || res == null");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.h
    public void M0(String str, String str2, long j3) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, str2, Long.valueOf(j3));
            return;
        }
        cmd0xcca$ReqBody cmd0xcca_reqbody = new cmd0xcca$ReqBody();
        try {
            cmd0xcca_reqbody.uint64_uin.set(Long.valueOf(str2).longValue());
            cmd0xcca_reqbody.uint64_grp_code.set(Long.valueOf(str).longValue());
            cmd0xcca_reqbody.uint64_msg_seq.set(j3);
            AppInterface appInterface = this.appRuntime;
            if (appInterface != null && !TextUtils.equals(appInterface.getCurrentUin(), str2)) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopMngHandler", 2, "getGroupInviteStatus service_type:" + i3 + " invitedUin:" + str2 + " troopCode:" + str + "  msgSeq:" + j3);
            }
            sendPbReq(makeOIDBPkg("OidbSvc.cmd0xcca", 3274, i3, cmd0xcca_reqbody.toByteArray()));
        } catch (NumberFormatException e16) {
            QLog.i("troop_ext", 1, "getGroupInviteStatus exception: " + e16.getMessage() + " invitedUin : " + str2 + " troopCode: " + str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.h
    public void P1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_GROUPMNGREQ);
        createToServiceMsg.extraData.putInt(ProfileContants.CMD_GROUPMNGER_PARAM_REQTYPE, 0);
        createToServiceMsg.extraData.putString("troop_uin", str);
        createToServiceMsg.extraData.putString("uin", this.appRuntime.getCurrentAccountUin());
        createToServiceMsg.extraData.putInt(ProfileContants.CMD_PARAM_STAT_OPTION, i3);
        createToServiceMsg.extraData.putByte("cIfGetAuthInfo", (byte) 1);
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).configTroopCmdReportObj(createToServiceMsg, str, "TroopMngHandler-search");
        send(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.troop.api.handler.h
    public void S0(boolean z16, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
        } else {
            QLog.d("TroopMngHandler", 1, "[notifyJoinGroupResult] isSuccess:", Boolean.valueOf(z16), ", result:", Integer.valueOf(i3), ", troopCode:", str);
            notifyUI(b.f294307e, z16, new Object[]{1, Integer.valueOf(i3), str});
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.h
    public void T(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            P1(str, 0);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.h
    public void a(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            notifyUI(i3, z16, obj);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.h
    public void a1(boolean z16, boolean z17, int i3, String str, String str2) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), str, str2);
            return;
        }
        QLog.i("TroopMngHandler", 1, "[notifyTroopQuitOrDestroy] isDes:" + z16 + ",isSus:" + z17 + ",res:" + i3 + ",tUin:" + str + ",from:" + str2);
        if (z16) {
            i16 = 9;
        } else {
            i16 = 2;
        }
        if (z17 && i3 == 0) {
            notifyUI(b.f294307e, true, new Object[]{Integer.valueOf(i16), Integer.valueOf(i3), str});
        } else {
            notifyUI(b.f294307e, false, new Object[]{Integer.valueOf(i16), Integer.valueOf(i3)});
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.h
    public void g0(long j3, String str, String str2, int i3, String str3, String str4) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), str, str2, Integer.valueOf(i3), str3, str4);
            return;
        }
        QLog.i("TroopMngHandler", 1, "[notifyTransferGroup] troopUin:" + j3 + ",result:" + i3 + ",from:" + str4);
        int i16 = b.f294309h;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        notifyUI(i16, z16, new Object[]{Long.valueOf(j3), str, str2, Integer.valueOf(i3), str3});
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(ProfileContants.CMD_GROUPMNGREQ);
            this.allowCmdSet.add("oidbSvc.0xe72");
            this.allowCmdSet.add("OidbSvc.cmd0xcca");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopMngHandler";
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMngHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMngHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if (ProfileContants.CMD_GROUPMNGREQ.equals(fromServiceMsg.getServiceCmd())) {
                H2(toServiceMsg, fromServiceMsg);
                return;
            } else if ("oidbSvc.0xe72".equals(fromServiceMsg.getServiceCmd())) {
                J2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("OidbSvc.cmd0xcca".equals(fromServiceMsg.getServiceCmd())) {
                    G2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMngHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.h
    public void v(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            notifyUI(b.f294311m, true, "https://qun.qq.com/joinedrecommend/index.html");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.h
    public void v0(long j3, long j16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), Long.valueOf(j16), str);
            return;
        }
        oidb_0xe72$ReqBody oidb_0xe72_reqbody = new oidb_0xe72$ReqBody();
        oidb_0xe72_reqbody.uint64_grp_code.set(j3);
        oidb_0xe72_reqbody.uint64_uin.set(j16);
        if (!TextUtils.isEmpty(str)) {
            oidb_0xe72_reqbody.bytes_join_group_auth.set(ByteStringMicro.copyFromUtf8(str));
        }
        oidb_0xe72_reqbody.uint32_edu_support_no_verify.set(1);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("oidbSvc.0xe72", 3698, 0, oidb_0xe72_reqbody.toByteArray(), 30000L);
        makeOIDBPkg.addAttribute("troopUin", String.valueOf(j3));
        makeOIDBPkg.addAttribute("userUin", String.valueOf(j16));
        makeOIDBPkg.addAttribute("authKey", str);
        sendPbReq(makeOIDBPkg);
    }
}
