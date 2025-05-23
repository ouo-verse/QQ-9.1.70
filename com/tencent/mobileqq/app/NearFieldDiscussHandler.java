package com.tencent.mobileqq.app;

import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateGrayMsg;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qzone.remote.ServiceConst;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import tencent.im.nearfield_discuss.nearfield_discuss$BusiRespHead;
import tencent.im.nearfield_discuss.nearfield_discuss$LBSInfo;
import tencent.im.nearfield_discuss.nearfield_discuss$NotifyList;
import tencent.im.nearfield_discuss.nearfield_discuss$ReqExit;
import tencent.im.nearfield_discuss.nearfield_discuss$ReqGetList;
import tencent.im.nearfield_discuss.nearfield_discuss$ReqJoinDiscuss;
import tencent.im.nearfield_discuss.nearfield_discuss$RespGetList;
import tencent.im.nearfield_discuss.nearfield_discuss$RespJoinDiscuss;
import tencent.im.nearfield_discuss.nearfield_discuss$UserProfile;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes11.dex */
public class NearFieldDiscussHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    byte[] f194865d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f194866e;

    NearFieldDiscussHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f194866e = qQAppInterface;
        }
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        notifyUI(1020, false, new com.tencent.mobileqq.service.nearfield.a(toServiceMsg.extraData.getInt(ServiceConst.PARA_SESSION_ID)));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0160 A[Catch: Exception -> 0x01ab, TryCatch #1 {Exception -> 0x01ab, blocks: (B:48:0x00d8, B:35:0x0160, B:37:0x016d, B:39:0x0173, B:40:0x017b, B:42:0x01a1), top: B:47:0x00d8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        int i3;
        boolean z18;
        int i16;
        int i17 = 0;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NearFieldDiscussHandler", 2, "handleGetFaceToFaceDiscussInfo");
        }
        int i18 = toServiceMsg.extraData.getInt(ServiceConst.PARA_SESSION_ID, -1);
        int i19 = toServiceMsg.extraData.getInt("join_type", -1);
        int i26 = toServiceMsg.extraData.getInt("from", 0);
        String str = "";
        if (z16) {
            try {
                nearfield_discuss$RespJoinDiscuss nearfield_discuss_respjoindiscuss = new nearfield_discuss$RespJoinDiscuss();
                nearfield_discuss_respjoindiscuss.mergeFrom((byte[]) obj);
                i3 = nearfield_discuss_respjoindiscuss.msg_head.get().int32_reply_code.get();
                if (i3 == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                try {
                    StringBuilder sb5 = new StringBuilder();
                    try {
                        sb5.append("handleGetFaceToFaceDiscussInfo retCOde = ");
                        sb5.append(i3);
                        sb5.append(" joinType = ");
                        sb5.append(i19);
                        sb5.append(" sessionId = ");
                        sb5.append(i18);
                        QLog.i("NearFieldDiscussHandler", 1, sb5.toString());
                        if (z18) {
                            long P = Utils.P(nearfield_discuss_respjoindiscuss.uint32_discuss_id.get());
                            ((DiscussionHandler) this.f194866e.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).S2(P);
                            String valueOf = String.valueOf(P);
                            try {
                                boolean z19 = nearfield_discuss_respjoindiscuss.bool_is_creater.get();
                                i18 = nearfield_discuss_respjoindiscuss.uint32_session_id.get();
                                int i27 = nearfield_discuss_respjoindiscuss.uint32_join_type.get();
                                if (z19) {
                                    if (i27 == 2) {
                                        try {
                                            z17 = false;
                                        } catch (Exception e16) {
                                            e = e16;
                                            z17 = false;
                                        }
                                        try {
                                            ((ITroopCreateGrayMsg) this.f194866e.getRuntimeService(ITroopCreateGrayMsg.class, "")).addCreateNewTroopGrayTips(valueOf, false, toServiceMsg.extraData.getString("FACE_TO_FACE_ID"));
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("dt_eid", "ev_group_create");
                                            hashMap.put("eid", "ev_group_create");
                                            hashMap.put("group_id", valueOf);
                                            hashMap.put("group_owner_uin", this.f194866e.getCurrentAccountUin());
                                            hashMap.put("group_first_level", "0");
                                            hashMap.put("group_second_level", "0");
                                            hashMap.put("source", Integer.valueOf(i26));
                                            VideoReport.reportEvent("ev_group_create", hashMap);
                                            ReportController.o(this.f194866e, "dc00899", "Grp_create_new", "", "suc_create", "face_create", 0, 0, "" + valueOf, "" + i26, "", "");
                                        } catch (Exception e17) {
                                            e = e17;
                                            str = valueOf;
                                            i19 = i27;
                                            if (QLog.isColorLevel()) {
                                                QLog.d("NearFieldDiscussHandler", 2, "handleGetFaceToFaceDiscussInfo exp", e);
                                            }
                                            z18 = z17;
                                            i17 = i3;
                                            notifyUI(1020, z18, new com.tencent.mobileqq.service.nearfield.a(i18, str, i19, i17));
                                        }
                                    } else {
                                        i16 = 2;
                                        if (i27 == i16) {
                                            RecentUserProxy recentUserProxy = this.f194866e.getRecentUserProxy();
                                            if (recentUserProxy.findRecentUser(valueOf, 1) != null) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("NearFieldDiscussHandler", 2, "handleGetFaceToFaceDiscussInfo ru alreadyintab");
                                                }
                                            } else {
                                                RecentUser findRecentUserByUin = recentUserProxy.findRecentUserByUin(valueOf, 1);
                                                RecentUtil.K0(findRecentUserByUin, this.f194866e.getMessageFacade());
                                                findRecentUserByUin.uin = valueOf;
                                                findRecentUserByUin.lastmsgtime = com.tencent.mobileqq.service.message.e.K0();
                                                findRecentUserByUin.type = 1;
                                                recentUserProxy.saveRecentUser(findRecentUserByUin);
                                                MqqHandler handler = this.f194866e.getHandler(Conversation.class);
                                                if (handler != null) {
                                                    handler.sendMessage(handler.obtainMessage(1009));
                                                }
                                            }
                                        }
                                        str = valueOf;
                                        i19 = i27;
                                    }
                                }
                                i16 = 2;
                                if (i27 == i16) {
                                }
                                str = valueOf;
                                i19 = i27;
                            } catch (Exception e18) {
                                e = e18;
                                z17 = false;
                                str = valueOf;
                            }
                        }
                    } catch (Exception e19) {
                        e = e19;
                        z17 = false;
                    }
                } catch (Exception e26) {
                    e = e26;
                    z17 = false;
                }
            } catch (Exception e27) {
                e = e27;
                z17 = false;
                i3 = 0;
            }
            i17 = i3;
        } else {
            z18 = z16;
        }
        notifyUI(1020, z18, new com.tencent.mobileqq.service.nearfield.a(i18, str, i19, i17));
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int i3 = toServiceMsg.extraData.getInt("retryTime", 0);
        if (i3 < 1) {
            toServiceMsg.extraData.putInt("retryTime", i3 + 1);
            send(toServiceMsg);
            return;
        }
        G2(toServiceMsg, fromServiceMsg);
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        notifyUI(1021, false, null);
    }

    private void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("NearFieldDiscussHandler", 2, "handleNotifyPush");
        }
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = -1;
        if (z16) {
            try {
                nearfield_discuss$NotifyList nearfield_discuss_notifylist = new nearfield_discuss$NotifyList();
                try {
                    nearfield_discuss_notifylist.mergeFrom((byte[]) obj);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    z16 = false;
                }
                i3 = nearfield_discuss_notifylist.uint32_session_id.get();
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("NearFieldDiscussHandler", 2, "handleNotifyPush exp", e17);
                }
                z16 = false;
            }
        }
        notifyUI(1022, z16, new Object[]{Integer.valueOf(i3)});
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        String serviceCmd = fromServiceMsg.getServiceCmd();
        QLog.i("NearFieldDiscussHandler", 1, "<<---handleTimeOut serviceCmd:" + serviceCmd);
        if ("NearFieldDiscussSvr.ReqJoinDiscuss".equals(serviceCmd)) {
            I2(toServiceMsg, fromServiceMsg);
        } else if ("NearFieldDiscussSvr.ReqGetList".equals(serviceCmd)) {
            K2(toServiceMsg, fromServiceMsg);
        }
    }

    private void handleError(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        String serviceCmd = fromServiceMsg.getServiceCmd();
        QLog.i("NearFieldDiscussHandler", 1, "<<---handleError serviceCmd:" + serviceCmd);
        if ("NearFieldDiscussSvr.ReqJoinDiscuss".equals(serviceCmd)) {
            G2(toServiceMsg, fromServiceMsg);
        } else {
            "NearFieldDiscussSvr.ReqGetList".equals(serviceCmd);
        }
    }

    public void D2(String str, int i3, nearfield_discuss$LBSInfo nearfield_discuss_lbsinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), nearfield_discuss_lbsinfo);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("NearFieldDiscussSvr.ReqExit");
        nearfield_discuss$ReqExit nearfield_discuss_reqexit = new nearfield_discuss$ReqExit();
        if (nearfield_discuss_lbsinfo != null) {
            nearfield_discuss_reqexit.msg_lbs_info.set(nearfield_discuss_lbsinfo);
        }
        nearfield_discuss_reqexit.str_number.set(str);
        nearfield_discuss_reqexit.uint32_session_id.set(i3);
        createToServiceMsg.putWupBuffer(nearfield_discuss_reqexit.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    public void E2(String str, int i3, nearfield_discuss$LBSInfo nearfield_discuss_lbsinfo, boolean z16) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), nearfield_discuss_lbsinfo, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("NearFieldDiscussHandler", 2, "get list | sessionId = " + i3 + " | digits = " + str);
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("NearFieldDiscussSvr.ReqGetList");
        nearfield_discuss$ReqGetList nearfield_discuss_reqgetlist = new nearfield_discuss$ReqGetList();
        if (nearfield_discuss_lbsinfo != null) {
            nearfield_discuss_reqgetlist.msg_lbs_info.set(nearfield_discuss_lbsinfo);
        }
        nearfield_discuss_reqgetlist.str_number.set(str);
        nearfield_discuss_reqgetlist.uint32_session_id.set(i3);
        if (!z16 && (bArr = this.f194865d) != null) {
            nearfield_discuss_reqgetlist.bytes_cookie.set(ByteStringMicro.copyFrom(bArr));
        }
        createToServiceMsg.putWupBuffer(nearfield_discuss_reqgetlist.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    public void F2(String str, int i3, nearfield_discuss$LBSInfo nearfield_discuss_lbsinfo, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), nearfield_discuss_lbsinfo, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        QLog.i("NearFieldDiscussHandler", 1, "getNearFieldDiscussInfo hallId=" + str + " sessionId=" + i3 + " joinType:" + i16);
        nearfield_discuss$ReqJoinDiscuss nearfield_discuss_reqjoindiscuss = new nearfield_discuss$ReqJoinDiscuss();
        nearfield_discuss_reqjoindiscuss.str_number.set(str);
        if (nearfield_discuss_lbsinfo != null) {
            nearfield_discuss_reqjoindiscuss.msg_lbs_info.set(nearfield_discuss_lbsinfo);
        }
        nearfield_discuss_reqjoindiscuss.uint32_session_id.set(i3);
        nearfield_discuss_reqjoindiscuss.uint32_join_type.set(i16);
        ToServiceMsg createToServiceMsg = createToServiceMsg("NearFieldDiscussSvr.ReqJoinDiscuss");
        createToServiceMsg.extraData.putString("FACE_TO_FACE_ID", str);
        createToServiceMsg.extraData.putInt(ServiceConst.PARA_SESSION_ID, i3);
        createToServiceMsg.extraData.putInt("join_type", i16);
        createToServiceMsg.extraData.putInt("from", i17);
        createToServiceMsg.putWupBuffer(nearfield_discuss_reqjoindiscuss.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    protected void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("NearFieldDiscussHandler", 1, "handleGetFaceToFaceMemberListResp isSuccess:" + z16 + "  ResultCode:" + fromServiceMsg.getResultCode());
        List<nearfield_discuss$UserProfile> list = null;
        if (z16) {
            nearfield_discuss$RespGetList nearfield_discuss_respgetlist = new nearfield_discuss$RespGetList();
            try {
                nearfield_discuss_respgetlist.mergeFrom((byte[]) obj);
            } catch (Exception unused) {
                z16 = false;
                nearfield_discuss_respgetlist = null;
            }
            if (nearfield_discuss_respgetlist != null && z16) {
                if (nearfield_discuss_respgetlist.rpt_msg_user_list.has()) {
                    list = nearfield_discuss_respgetlist.rpt_msg_user_list.get();
                }
                if (nearfield_discuss_respgetlist.int32_update_interval.has()) {
                    i3 = nearfield_discuss_respgetlist.int32_update_interval.get();
                } else {
                    i3 = 60000;
                }
                if (nearfield_discuss_respgetlist.bytes_cookie.has()) {
                    this.f194865d = nearfield_discuss_respgetlist.bytes_cookie.get().toByteArray();
                }
                if (nearfield_discuss_respgetlist.uint32_session_id.has()) {
                    i16 = nearfield_discuss_respgetlist.uint32_session_id.get();
                } else {
                    i16 = 0;
                }
                nearfield_discuss$BusiRespHead nearfield_discuss_busiresphead = new nearfield_discuss$BusiRespHead();
                if (nearfield_discuss_respgetlist.msg_head.has()) {
                    nearfield_discuss_busiresphead.int32_reply_code.set(nearfield_discuss_respgetlist.msg_head.int32_reply_code.get());
                    nearfield_discuss_busiresphead.str_result.set(nearfield_discuss_respgetlist.msg_head.str_result.get());
                }
                if (nearfield_discuss_respgetlist.uint32_button_switch.has()) {
                    i17 = nearfield_discuss_respgetlist.uint32_button_switch.get();
                } else {
                    i17 = 0;
                }
                if (nearfield_discuss_respgetlist.uint32_has_created.has()) {
                    i18 = nearfield_discuss_respgetlist.uint32_has_created.get();
                } else {
                    i18 = 0;
                }
                if (nearfield_discuss_respgetlist.uint64_creator.has()) {
                    j3 = nearfield_discuss_respgetlist.uint64_creator.get();
                } else {
                    j3 = 0;
                }
                notifyUI(1021, z16, new Object[]{list, Integer.valueOf(i3), Integer.valueOf(i16), nearfield_discuss_busiresphead, Integer.valueOf(i17), Integer.valueOf(i18), Long.valueOf(j3)});
                return;
            }
        }
        notifyUI(1021, z16, null);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("NearFieldDiscussSvr.ReqJoinDiscuss");
            this.allowCmdSet.add("NearFieldDiscussSvr.ReqGetList");
            this.allowCmdSet.add("NearFieldDiscussSvr.ReqExit");
            this.allowCmdSet.add("NearFieldDiscussSvr.NotifyList");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getPushPBCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Set) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new HashSet<String>() { // from class: com.tencent.mobileqq.app.NearFieldDiscussHandler.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NearFieldDiscussHandler.this);
                } else {
                    add("NearFieldDiscussSvr.NotifyList");
                }
            }
        };
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return bw.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (msgCmdFilter(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("NearFieldDiscussHandler", 2, "cmdfilter error=" + serviceCmd);
                return;
            }
            return;
        }
        if (fromServiceMsg.getResultCode() == 1002) {
            M2(toServiceMsg, fromServiceMsg);
            return;
        }
        if (fromServiceMsg.getResultCode() != 1000) {
            handleError(toServiceMsg, fromServiceMsg);
            return;
        }
        if ("NearFieldDiscussSvr.ReqJoinDiscuss".equalsIgnoreCase(serviceCmd)) {
            H2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("NearFieldDiscussSvr.NotifyList".equalsIgnoreCase(serviceCmd)) {
            L2(toServiceMsg, fromServiceMsg, obj);
        } else if ("NearFieldDiscussSvr.ReqGetList".equalsIgnoreCase(serviceCmd)) {
            J2(toServiceMsg, fromServiceMsg, obj);
        } else {
            "NearFieldDiscussSvr.ReqExit".equalsIgnoreCase(serviceCmd);
        }
    }
}
