package com.tencent.mobileqq.app;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.im.oidb.cmd0x6d1.cmd0x6d1$DealInviteReqBody;
import com.tencent.im.oidb.cmd0x6d1.cmd0x6d1$DealInviteRspBody;
import com.tencent.im.oidb.cmd0x6d1.cmd0x6d1$ReqBody;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.cs.cmd0x2323$BodyMsg;
import tencent.im.cs.cmd0x2323$ReqBody;
import tencent.im.cs.cmd0x2323$RspBody;
import tencent.im.cs.cmd0x3fb.cmd0x3fb$GrayMsg;
import tencent.im.cs.cmd0x3fb.cmd0x3fb$ReqBody;
import tencent.im.cs.cmd0x3fb.cmd0x3fb$RspBody;
import tencent.im.cs.cmd0x3fe.cmd0x3fe$LevelInfo;
import tencent.im.cs.cmd0x3fe.cmd0x3fe$LevelMsg;
import tencent.im.cs.cmd0x3fe.cmd0x3fe$Medal;
import tencent.im.cs.cmd0x3fe.cmd0x3fe$ReqBody;
import tencent.im.cs.cmd0x3fe.cmd0x3fe$RspBody;
import tencent.im.cs.cmd0x3fe.cmd0x3fe$UserInfo;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d$Cmd0xa8dExitPublicGroupReqBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d$Cmd0xa8dJoinPublicGroupReqBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d$Cmd0xa8dJoinPublicGroupRspBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d$ReqBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tencent.nearby.user.relation.UserFollowStatus$UserFollowStatusInfo;
import tencent.nearby.user.relation.UserFollowStatus$UserFollowStatusReq;
import tencent.nearby.user.relation.UserFollowStatus$UserFollowStatusRsp;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GVideoHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    protected static int f194718f;

    /* renamed from: h, reason: collision with root package name */
    protected static int f194719h;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.intervideo.groupvideo.b f194720d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f194721e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69752);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            f194718f = 1;
            f194719h = 2;
        }
    }

    GVideoHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f194721e = qQAppInterface;
        }
    }

    private void L2(String str, boolean z16, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg, oidb_0xa8d$RspBody oidb_0xa8d_rspbody) throws InvalidProtocolBufferMicroException {
        String str2;
        boolean z17;
        boolean z18;
        int i3;
        int i16;
        oidb_0xa8d_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
        if (oidb_0xa8d_rspbody.uint64_group_code.has()) {
            str2 = String.valueOf(oidb_0xa8d_rspbody.uint64_group_code.get());
        } else {
            str2 = str;
        }
        if (oidb_0xa8d_rspbody.uint32_req_type.has()) {
            if (oidb_0xa8d_rspbody.uint32_req_type.get() == f194718f) {
                z17 = true;
            } else {
                z17 = false;
            }
        } else {
            z17 = z16;
        }
        if (z17) {
            oidb_0xa8d$Cmd0xa8dJoinPublicGroupRspBody oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody = oidb_0xa8d_rspbody.msg_join_group.get();
            TroopInfo troopInfo = new TroopInfo(str2);
            StringBuilder sb5 = new StringBuilder();
            if (oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.uint32_GroupFlagEx.has()) {
                troopInfo.dwGroupFlagExt = oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.uint32_GroupFlagEx.get();
                z18 = TroopInfo.isVisitorSpeakEnabled(oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.uint32_GroupFlagEx.get());
                sb5.append(" dwGroupFlagExt: ");
                sb5.append(troopInfo.dwGroupFlagExt);
                sb5.append(" visitorSpeakEnabled: ");
                sb5.append(z18);
            } else {
                z18 = false;
            }
            if (oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.uint32_SpeakInterval.has()) {
                i3 = oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.uint32_SpeakInterval.get();
                sb5.append(" speakInterval: ");
                sb5.append(i3);
            } else {
                i3 = 0;
            }
            if (oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.uint32_StartSpeakInterval.has()) {
                i16 = oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.uint32_StartSpeakInterval.get();
                sb5.append(" startSpeakInterval: ");
                sb5.append(i16);
            } else {
                i16 = 0;
            }
            if (oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.uint32_GroupClassEx.has()) {
                troopInfo.dwGroupClassExt = oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.uint32_GroupClassEx.get();
                sb5.append(" dwGroupClassExt: ");
                sb5.append(troopInfo.dwGroupClassExt);
            }
            if (oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.uint32_GroupClass.has()) {
                int i17 = oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.uint32_GroupClass.get();
                troopInfo.extDBInfo.troopType = i17;
                ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateTroopType(str2, i17, "GVideoHandler");
                sb5.append(" trooptype: ");
                sb5.append(i17);
            }
            if (oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.uint32_MaxMember.has()) {
                troopInfo.wMemberMax = oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.uint32_MaxMember.get();
                sb5.append(" wMemberMax: ");
                sb5.append(troopInfo.wMemberMax);
            }
            if (oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.uint32_SpecialClass.has()) {
                int i18 = oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.uint32_SpecialClass.get();
                troopInfo.extDBInfo.specialClass = i18;
                sb5.append(" wSpecialClass: ");
                sb5.append(i18);
                ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateSpecialClass(troopInfo.troopuin, i18, "GVideoHandler");
            }
            if (oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.bytes_GroupName.has()) {
                troopInfo.troopname = oidb_0xa8d_cmd0xa8djoinpublicgrouprspbody.bytes_GroupName.get().toStringUtf8();
                sb5.append(" troopname: ");
                sb5.append(troopInfo.troopname);
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_TROOP_JOIN_OR_EXIT_OPEN_TROOP, 2, sb5.toString());
            }
            notifyUI(av.f195394h, true, new Object[]{str2, Integer.valueOf(R.string.drp), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3), Integer.valueOf(i16)});
        } else {
            notifyUI(av.f195394h, true, new Object[]{str2, Integer.valueOf(R.string.drm), Boolean.valueOf(z17)});
        }
        TroopManager troopManager = (TroopManager) this.f194721e.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null) {
            if (!z17) {
                str2 = null;
            }
            troopManager.j0(str2);
        }
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GVideoHandler", 2, "handleRequestGroupVideoStateList: isSuccess = " + z16);
        }
        if (z16) {
            cmd0x2323$RspBody cmd0x2323_rspbody = new cmd0x2323$RspBody();
            try {
                cmd0x2323_rspbody.mergeFrom((byte[]) obj);
                if (cmd0x2323_rspbody.ret.has() && cmd0x2323_rspbody.ret.get() == 0) {
                    List<cmd0x2323$BodyMsg> list = cmd0x2323_rspbody.body_msg.get();
                    ArrayList arrayList = new ArrayList();
                    for (cmd0x2323$BodyMsg cmd0x2323_bodymsg : list) {
                        com.tencent.mobileqq.intervideo.groupvideo.j jVar = new com.tencent.mobileqq.intervideo.groupvideo.j();
                        jVar.f238218a = cmd0x2323_bodymsg.group_code.get();
                        jVar.f238220c = cmd0x2323_bodymsg.action.get();
                        jVar.f238219b = cmd0x2323_bodymsg.user_num.get();
                        jVar.f238223f = cmd0x2323_bodymsg.video_user_list.get();
                        jVar.f238221d = cmd0x2323_bodymsg.stage_mode.get();
                        jVar.f238222e = cmd0x2323_bodymsg.game_id.get();
                        jVar.f238224g = cmd0x2323_bodymsg.live_extra_mode.get();
                        arrayList.add(jVar);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("GVideoHandler", 2, "handleRequestGroupVideoStateList: msgInfos size " + arrayList.size());
                    }
                    com.tencent.mobileqq.intervideo.groupvideo.b bVar = this.f194720d;
                    if (bVar != null) {
                        bVar.a(arrayList);
                    }
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("GVideoHandler", 2, "handleRequestGroupVideoStateList: InvalidProtocolBufferMicroException  = " + e16.toString());
                }
            }
        }
        this.f194720d = null;
    }

    public void D2(String str, long j3, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Long.valueOf(j3), str2, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GVideoHandler.troopgroup_vedio.invite", 2, " troopUin:" + str + ",inviterUin:" + j3 + ", inviteId:" + str2);
        }
        cmd0x6d1$ReqBody cmd0x6d1_reqbody = new cmd0x6d1$ReqBody();
        cmd0x6d1$DealInviteReqBody cmd0x6d1_dealinvitereqbody = new cmd0x6d1$DealInviteReqBody();
        try {
            cmd0x6d1_dealinvitereqbody.uint64_group_code.set(Long.parseLong(str));
            cmd0x6d1_dealinvitereqbody.str_id.set(str2);
            cmd0x6d1_dealinvitereqbody.uint64_uin.set(j3);
            cmd0x6d1_dealinvitereqbody.uint32_deal_result.set(i3);
            cmd0x6d1_reqbody.deal_invite_req_body.set(cmd0x6d1_dealinvitereqbody);
            cmd0x6d1_reqbody.uint32_app_type.set(2);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1745);
            oidb_sso_oidbssopkg.uint32_service_type.set(3);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0x6d1_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x6d1_3");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            sendPbReq(createToServiceMsg);
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("GVideoHandler", 2, " NumberFormatException, troopUin:" + str);
            }
        }
    }

    public void E2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        UserFollowStatus$UserFollowStatusReq userFollowStatus$UserFollowStatusReq = new UserFollowStatus$UserFollowStatusReq();
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Long.valueOf(Long.parseLong(str)));
            userFollowStatus$UserFollowStatusReq.uin.set(Long.parseLong(this.f194721e.getCurrentAccountUin()));
            userFollowStatus$UserFollowStatusReq.dst_uin_list.set(arrayList);
            ToServiceMsg createToServiceMsg = createToServiceMsg("NearbyExt.query_user_follow_status");
            createToServiceMsg.extraData.putString("distUin", str);
            createToServiceMsg.putWupBuffer(userFollowStatus$UserFollowStatusReq.toByteArray());
            sendPbReq(createToServiceMsg);
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("GVideoHandler", 2, "getFollowStatus:NumberFormatException" + e16.toString() + "|distUin:" + str);
            }
        }
    }

    public void F2(long[] jArr, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, jArr, Long.valueOf(j3));
            return;
        }
        cmd0x3fe$LevelMsg cmd0x3fe_levelmsg = new cmd0x3fe$LevelMsg();
        cmd0x3fe_levelmsg.uint32_subcmd.set(6);
        cmd0x3fe$ReqBody cmd0x3fe_reqbody = new cmd0x3fe$ReqBody();
        for (long j16 : jArr) {
            cmd0x3fe$UserInfo cmd0x3fe_userinfo = new cmd0x3fe$UserInfo();
            cmd0x3fe_userinfo.uint64_uin.set(j16);
            cmd0x3fe_reqbody.rpt_msg_user_info.add(cmd0x3fe_userinfo);
        }
        cmd0x3fe_reqbody.uint64_group_code.set(j3);
        cmd0x3fe_levelmsg.msg_level_req.set(cmd0x3fe_reqbody);
        ToServiceMsg createToServiceMsg = createToServiceMsg("qunVideoOnlineLevel.0x3fe_0");
        createToServiceMsg.putWupBuffer(cmd0x3fe_levelmsg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GVideoHandler.troopgroup_vedio.invite", 2, "receive cmd=OidbSvc.0x6d1, DealInviteRspBody, isSuccess:" + fromServiceMsg.isSuccess());
        }
        try {
            if (fromServiceMsg.isSuccess() && obj != null) {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                new cmd0x6d1$DealInviteRspBody().mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            }
        } catch (InvalidProtocolBufferMicroException unused) {
            if (QLog.isColorLevel()) {
                QLog.i("GVideoHandler", 2, "receive cmd=OidbSvc.0x6d1.DealInviteReqBody, InvalidProtocolBufferMicroException");
            }
        }
    }

    public void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            if (!fromServiceMsg.isSuccess()) {
                notifyUI(av.f195395i, false, new Object[]{toServiceMsg.extraData.getString("distUin"), Boolean.FALSE});
                return;
            }
            try {
                UserFollowStatus$UserFollowStatusRsp userFollowStatus$UserFollowStatusRsp = new UserFollowStatus$UserFollowStatusRsp();
                userFollowStatus$UserFollowStatusRsp.mergeFrom((byte[]) obj);
                if (userFollowStatus$UserFollowStatusRsp.follow_status_info_list.has()) {
                    for (UserFollowStatus$UserFollowStatusInfo userFollowStatus$UserFollowStatusInfo : userFollowStatus$UserFollowStatusRsp.follow_status_info_list.get()) {
                        if (userFollowStatus$UserFollowStatusInfo.dst_uin.get() == Long.parseLong(toServiceMsg.extraData.getString("distUin"))) {
                            String str = userFollowStatus$UserFollowStatusInfo.dst_uin.get() + "";
                            int i3 = userFollowStatus$UserFollowStatusInfo.follow_status.get();
                            int i16 = av.f195395i;
                            Object[] objArr = new Object[2];
                            objArr[0] = str;
                            if (i3 == 1) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            objArr[1] = Boolean.valueOf(z16);
                            notifyUI(i16, true, objArr);
                            if (QLog.isColorLevel()) {
                                QLog.d("GVideoHandlerQ.nearby.follow", 2, "handleGetFollowStatus, uin:" + str + "|followStatus:" + i3);
                                return;
                            }
                            return;
                        }
                    }
                }
                notifyUI(av.f195395i, false, new Object[]{toServiceMsg.extraData.getString("distUin"), Boolean.FALSE});
            } catch (InvalidProtocolBufferMicroException e16) {
                notifyUI(av.f195395i, false, new Object[]{toServiceMsg.extraData.getString("distUin"), Boolean.FALSE});
                if (QLog.isColorLevel()) {
                    QLog.i("GVideoHandlerQ.nearby.follow", 2, "handleGetFollowStatus,InvalidProtocolBufferMicroException: " + e16.toString());
                }
            }
        }
    }

    void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            cmd0x3fe$RspBody cmd0x3fe_rspbody = new cmd0x3fe$RspBody();
            if (obj == null) {
                return;
            }
            try {
                cmd0x3fe_rspbody.mergeFrom((byte[]) obj);
                if (!cmd0x3fe_rspbody.int32_ret.has() || cmd0x3fe_rspbody.int32_ret.get() != 0 || !cmd0x3fe_rspbody.uint32_subcmd.has()) {
                    return;
                }
                int i3 = cmd0x3fe_rspbody.uint32_subcmd.get();
                PBRepeatMessageField<cmd0x3fe$LevelInfo> pBRepeatMessageField = cmd0x3fe_rspbody.rpt_msg_level_info;
                Object[] objArr = new Object[pBRepeatMessageField.size()];
                int i16 = 0;
                while (i16 < pBRepeatMessageField.size()) {
                    cmd0x3fe$LevelInfo cmd0x3fe_levelinfo = pBRepeatMessageField.get(i16);
                    long j3 = cmd0x3fe_levelinfo.uint64_uin.get();
                    int i17 = cmd0x3fe_levelinfo.uint32_online_level.get();
                    int i18 = cmd0x3fe_levelinfo.uint32_show_level.get();
                    int i19 = cmd0x3fe_levelinfo.uint32_level_color.get();
                    int i26 = cmd0x3fe_levelinfo.uint32_score.get();
                    int i27 = cmd0x3fe_levelinfo.uint32_req_flag.get();
                    int i28 = cmd0x3fe_levelinfo.uint32_req_timer.get();
                    int i29 = cmd0x3fe_levelinfo.uint32_user_identity.get();
                    String str = cmd0x3fe_levelinfo.nickname.get();
                    ArrayList arrayList = new ArrayList();
                    List<cmd0x3fe$Medal> list = cmd0x3fe_levelinfo.rpt_medal_list.get();
                    if (list != null) {
                        Iterator<cmd0x3fe$Medal> it = list.iterator();
                        while (it.hasNext()) {
                            PBRepeatMessageField<cmd0x3fe$LevelInfo> pBRepeatMessageField2 = pBRepeatMessageField;
                            cmd0x3fe$Medal next = it.next();
                            arrayList.add(new RecvGVideoLevelInfo.Medal(next.uint32_id.get(), next.uint32_level.get(), next.uint32_type.get(), next.str_icon_url.get(), next.str_head_icon_url.get(), next.str_name.get()));
                            pBRepeatMessageField = pBRepeatMessageField2;
                            it = it;
                            i16 = i16;
                        }
                    }
                    int i36 = i16;
                    objArr[i36] = new RecvGVideoLevelInfo(j3, i17, i18, i19, i26, i27, i28, i3, i29, str, arrayList);
                    i16 = i36 + 1;
                    pBRepeatMessageField = pBRepeatMessageField;
                }
                try {
                    notifyUI(av.f195393f, true, objArr);
                } catch (Exception e16) {
                    e = e16;
                    if (QLog.isColorLevel()) {
                        QLog.e("GVideoHandler", 2, "handleGetGVideoLevelInfo error", e);
                    }
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
    }

    public void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        long j3 = toServiceMsg.extraData.getLong("timeSeq");
        String string = toServiceMsg.extraData.getString("troop_uin");
        if (QLog.isColorLevel()) {
            QLog.d("GVideoHandler", 2, "handleGetTroopHideWebConfig: isSuccess = " + isSuccess + " code:" + fromServiceMsg.getResultCode() + " sendTimeKey:" + j3 + " troopUin:" + string);
        }
        if (isSuccess) {
            cmd0x3fb$GrayMsg cmd0x3fb_graymsg = new cmd0x3fb$GrayMsg();
            try {
                cmd0x3fb_graymsg.mergeFrom((byte[]) obj);
                cmd0x3fb$RspBody cmd0x3fb_rspbody = cmd0x3fb_graymsg.msg_gray_rsp.get();
                ((IFactoryApi) QRoute.api(IFactoryApi.class)).monitorReport("2729126");
                if (cmd0x3fb_rspbody.int32_ret.has() && cmd0x3fb_rspbody.int32_ret.get() == 0) {
                    int i16 = cmd0x3fb_rspbody.int32_color.get();
                    String str = cmd0x3fb_rspbody.str_url.get();
                    int i17 = cmd0x3fb_rspbody.int32_gray_flag.get();
                    int i18 = cmd0x3fb_rspbody.int32_enter_glive_strategy.get();
                    String str2 = cmd0x3fb_rspbody.str_update_title.get();
                    String str3 = cmd0x3fb_rspbody.str_update_content.get();
                    int i19 = cmd0x3fb_rspbody.int32_pre_download_toggle.get();
                    notifyUI(av.f195392e, true, new Object[]{string, Integer.valueOf(i16), str, Integer.valueOf(i17), Integer.valueOf(i18), str2, str3, Integer.valueOf(i19), Integer.valueOf(fromServiceMsg.getResultCode()), Long.valueOf(j3)});
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "<---- handleGetTroopHideWebConfig,troopUin=" + string + " ,color=" + i16 + ", url=" + str + " flag:" + i17 + " ,strategy:" + i18 + " title:" + str2 + " content:" + str3 + " preDownloadToggle:" + i19);
                    }
                    ((IFactoryApi) QRoute.api(IFactoryApi.class)).monitorTrigger("2729127");
                    ReportController.o(this.f194721e, "dc00899", "Huayang_video", "", "group_video", "GetTroopHideWebConfig", 1, 0, "", AppSetting.f99551k, "", "");
                    return;
                }
                notifyUI(av.f195392e, false, new Object[]{string, 0, "", -1, -1, "", "", -1, -1, Long.valueOf(j3)});
                QQAppInterface qQAppInterface = this.f194721e;
                if (cmd0x3fb_rspbody.int32_ret.has()) {
                    i3 = cmd0x3fb_rspbody.int32_ret.get();
                } else {
                    i3 = -1;
                }
                ReportController.o(qQAppInterface, "dc00899", "Huayang_video", "", "group_video", "GetTroopHideWebConfig", 0, i3, "", AppSetting.f99551k, "", "");
                return;
            } catch (Exception e16) {
                notifyUI(av.f195392e, false, new Object[]{string, 0, "", -1, -1, "", "", -1, -1, Long.valueOf(j3)});
                if (QLog.isColorLevel()) {
                    QLog.e(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "GetTroopHideWebConfig exp:, " + e16.toString() + " ---->");
                }
                ReportController.o(this.f194721e, "dc00899", "Huayang_video", "", "group_video", "GetTroopHideWebConfig", 0, 0, e16.toString(), AppSetting.f99551k, "", "");
                return;
            }
        }
        notifyUI(av.f195392e, false, new Object[]{string, 0, "", -1, -1, "", "", -1, Integer.valueOf(fromServiceMsg.getResultCode()), Long.valueOf(j3)});
    }

    public void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String string = toServiceMsg.extraData.getString("troopUin");
        boolean z16 = toServiceMsg.extraData.getBoolean("isJoin");
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleJoinOrExitOpenTroop:");
            sb5.append(string);
            sb5.append(",");
            if (z16) {
                str = IHWTroopUtilsApi.HOMEWORK_TROOP_JOIN_SOURCE;
            } else {
                str = "exit";
            }
            sb5.append(str);
            sb5.append(",");
            sb5.append(fromServiceMsg.isSuccess());
            QLog.d(LogTag.TAG_TROOP_JOIN_OR_EXIT_OPEN_TROOP, 2, sb5.toString());
        }
        if (!fromServiceMsg.isSuccess()) {
            notifyUI(av.f195394h, false, new Object[]{string, Integer.valueOf(R.string.dro), Boolean.valueOf(z16)});
            return;
        }
        try {
            oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
            if (mergeFrom.uint32_result.has()) {
                i3 = mergeFrom.uint32_result.get();
            } else {
                i3 = -1;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_TROOP_JOIN_OR_EXIT_OPEN_TROOP, 2, "sso result:" + i3);
            }
            if (i3 != 0) {
                if (i3 != 197) {
                    notifyUI(av.f195394h, false, new Object[]{string, Integer.valueOf(R.string.dro), Boolean.valueOf(z16)});
                    return;
                } else {
                    notifyUI(av.f195394h, false, new Object[]{string, Integer.valueOf(R.string.drn), Boolean.valueOf(z16)});
                    return;
                }
            }
            try {
                L2(string, z16, mergeFrom, new oidb_0xa8d$RspBody());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_TROOP_JOIN_OR_EXIT_OPEN_TROOP, 2, "handleJoinOrExitOpenTroop:" + e16.toString());
                }
                notifyUI(av.f195394h, false, new Object[]{string, Integer.valueOf(R.string.dro), Boolean.valueOf(z16)});
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.e(LogTag.TAG_TROOP_JOIN_OR_EXIT_OPEN_TROOP, 2, "pkg.mergeFrom:" + e17.toString());
            }
            notifyUI(av.f195394h, false, new Object[]{string, Integer.valueOf(R.string.dro), Boolean.valueOf(z16)});
        }
    }

    public void N2(String str, boolean z16) {
        int i3;
        int i16;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Boolean.valueOf(z16));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = ((IBizTroopInfoService) this.f194721e.getRuntimeService(IBizTroopInfoService.class, "")).getCurrentOpenTroop();
            if (TextUtils.isEmpty(str)) {
                return;
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("joinOrExitOpenTroop:");
            sb5.append(str);
            sb5.append(", ");
            if (z16) {
                str2 = IHWTroopUtilsApi.HOMEWORK_TROOP_JOIN_SOURCE;
            } else {
                str2 = "exit";
            }
            sb5.append(str2);
            QLog.d(LogTag.TAG_TROOP_JOIN_OR_EXIT_OPEN_TROOP, 2, sb5.toString());
        }
        try {
            long parseLong = Long.parseLong(str);
            long parseLong2 = Long.parseLong(this.f194721e.getCurrentUin());
            oidb_0xa8d$ReqBody oidb_0xa8d_reqbody = new oidb_0xa8d$ReqBody();
            oidb_0xa8d_reqbody.uint64_group_code.set(parseLong);
            PBUInt32Field pBUInt32Field = oidb_0xa8d_reqbody.uint32_req_type;
            if (z16) {
                i3 = f194718f;
            } else {
                i3 = f194719h;
            }
            pBUInt32Field.set(i3);
            oidb_0xa8d_reqbody.uint32_req_client_type.set(1);
            if (z16) {
                oidb_0xa8d$Cmd0xa8dJoinPublicGroupReqBody oidb_0xa8d_cmd0xa8djoinpublicgroupreqbody = new oidb_0xa8d$Cmd0xa8dJoinPublicGroupReqBody();
                oidb_0xa8d_cmd0xa8djoinpublicgroupreqbody.uint64_visitor_uin.set(parseLong2);
                oidb_0xa8d_reqbody.msg_join_group.set(oidb_0xa8d_cmd0xa8djoinpublicgroupreqbody);
            } else {
                oidb_0xa8d$Cmd0xa8dExitPublicGroupReqBody oidb_0xa8d_cmd0xa8dexitpublicgroupreqbody = new oidb_0xa8d$Cmd0xa8dExitPublicGroupReqBody();
                oidb_0xa8d_cmd0xa8dexitpublicgroupreqbody.uint64_visitor_uin.set(parseLong2);
                oidb_0xa8d_reqbody.msg_exit_group.set(oidb_0xa8d_cmd0xa8dexitpublicgroupreqbody);
            }
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(JsonGrayBusiId.AIO_PUSH_GUIDE_GRAY_TIPS);
            PBUInt32Field pBUInt32Field2 = oidb_sso_oidbssopkg.uint32_service_type;
            if (z16) {
                i16 = f194718f;
            } else {
                i16 = f194719h;
            }
            pBUInt32Field2.set(i16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xa8d_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xa8d");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.extraData.putString("troopUin", str);
            createToServiceMsg.extraData.putBoolean("isJoin", z16);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(LogTag.TAG_TROOP_JOIN_OR_EXIT_OPEN_TROOP, 2, "joinOrExitOpenTroop:" + e16.toString());
            }
        }
    }

    public void O2(long j3, long j16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
            return;
        }
        cmd0x3fe$LevelMsg cmd0x3fe_levelmsg = new cmd0x3fe$LevelMsg();
        cmd0x3fe_levelmsg.uint32_subcmd.set(1);
        cmd0x3fe$ReqBody cmd0x3fe_reqbody = new cmd0x3fe$ReqBody();
        cmd0x3fe$UserInfo cmd0x3fe_userinfo = new cmd0x3fe$UserInfo();
        cmd0x3fe_userinfo.uint64_uin.set(j3);
        cmd0x3fe_userinfo.uint32_online_time.set(i3);
        cmd0x3fe_reqbody.rpt_msg_user_info.add(cmd0x3fe_userinfo);
        cmd0x3fe_reqbody.uint64_group_code.set(j16);
        cmd0x3fe_levelmsg.msg_level_req.set(cmd0x3fe_reqbody);
        ToServiceMsg createToServiceMsg = createToServiceMsg("qunVideoOnlineLevel.0x3fe_0");
        createToServiceMsg.putWupBuffer(cmd0x3fe_levelmsg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void P2(List<Long> list, com.tencent.mobileqq.intervideo.groupvideo.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list, (Object) bVar);
            return;
        }
        cmd0x2323$ReqBody cmd0x2323_reqbody = new cmd0x2323$ReqBody();
        cmd0x2323_reqbody.group_code_list.set(list);
        ToServiceMsg createToServiceMsg = createToServiceMsg("videohub_group_notify_read.cmd0x2323");
        createToServiceMsg.putWupBuffer(cmd0x2323_reqbody.toByteArray());
        sendPbReq(createToServiceMsg);
        this.f194720d = bVar;
        if (QLog.isColorLevel()) {
            QLog.d("GVideoHandler", 2, " requestGroupVideoState, groupUins size:" + list.size());
        }
    }

    public long Q2(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Long.valueOf(j3))).longValue();
        }
        cmd0x3fb$GrayMsg cmd0x3fb_graymsg = new cmd0x3fb$GrayMsg();
        cmd0x3fb_graymsg.uint32_subcmd.set(1);
        cmd0x3fb$ReqBody cmd0x3fb_reqbody = new cmd0x3fb$ReqBody();
        cmd0x3fb_reqbody.uint32_identity.set(i3);
        cmd0x3fb_reqbody.uint32_client_id.set(2);
        PBStringField pBStringField = cmd0x3fb_reqbody.str_version;
        String str = AppSetting.f99551k;
        pBStringField.set(str);
        cmd0x3fb_reqbody.uint64_to_guin.set(j3);
        cmd0x3fb_graymsg.msg_gray_req.set(cmd0x3fb_reqbody);
        ToServiceMsg createToServiceMsg = createToServiceMsg("qunVideoGray.0x3fb_0");
        createToServiceMsg.extraData.putString("troop_uin", j3 + "");
        createToServiceMsg.extraData.putLong("timeSeq", SystemClock.elapsedRealtime());
        createToServiceMsg.putWupBuffer(cmd0x3fb_graymsg.toByteArray());
        sendPbReq(createToServiceMsg);
        long j16 = createToServiceMsg.extraData.getLong("timeSeq");
        if (QLog.isColorLevel()) {
            QLog.d("GVideoHandler", 2, " requestVideoGrayWebConfig, identity:" + i3 + " client_id: 2 str_version:" + str + " to_guin:" + j3 + " timeKey:" + j16);
        }
        return j16;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("videohub_group_notify_read.cmd0x2323");
            this.allowCmdSet.add("qunVideoGray.0x3fb_0");
            this.allowCmdSet.add("qunVideoOnlineLevel.0x3fe_0");
            this.allowCmdSet.add("OidbSvc.0x6d1_3");
            this.allowCmdSet.add("OidbSvc.0xa8d");
            this.allowCmdSet.add("NearbyExt.query_user_follow_status");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return av.class;
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
                    QLog.d("GVideoHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if ("videohub_group_notify_read.cmd0x2323".equals(fromServiceMsg.getServiceCmd())) {
                M2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("qunVideoGray.0x3fb_0".equals(fromServiceMsg.getServiceCmd())) {
                J2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("qunVideoOnlineLevel.0x3fe_0".equals(fromServiceMsg.getServiceCmd())) {
                I2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("OidbSvc.0x6d1_3".equals(fromServiceMsg.getServiceCmd())) {
                G2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else if ("OidbSvc.0xa8d".equals(fromServiceMsg.getServiceCmd())) {
                K2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("NearbyExt.query_user_follow_status".equals(fromServiceMsg.getServiceCmd())) {
                    H2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("GVideoHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}
