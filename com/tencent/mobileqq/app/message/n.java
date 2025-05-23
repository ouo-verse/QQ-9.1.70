package com.tencent.mobileqq.app.message;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import msf.msgcomm.msg_comm$Msg;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf$DelDecideInfo;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf$DelMsgInfo;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf$DelUnDecideInfo;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf$ReqBody;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf$RspBody;
import tencent.mobileim.structmsg.structmsg$FlagInfo;
import tencent.mobileim.structmsg.structmsg$ReqNextSystemMsg;
import tencent.mobileim.structmsg.structmsg$ReqSystemMsgAction;
import tencent.mobileim.structmsg.structmsg$ReqSystemMsgNew;
import tencent.mobileim.structmsg.structmsg$ReqSystemMsgRead;
import tencent.mobileim.structmsg.structmsg$RspNextSystemMsg;
import tencent.mobileim.structmsg.structmsg$RspSystemMsgAction;
import tencent.mobileim.structmsg.structmsg$RspSystemMsgNew;
import tencent.mobileim.structmsg.structmsg$RspSystemMsgRead;
import tencent.mobileim.structmsg.structmsg$StructMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsgActionInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class n extends BaseMessageProcessor {
    static IPatchRedirector $redirector_;
    private final ConcurrentHashMap<String, Long> A;
    private ArrayList<Integer> B;

    /* renamed from: v, reason: collision with root package name */
    private int f196257v;

    /* renamed from: w, reason: collision with root package name */
    private int f196258w;

    /* renamed from: x, reason: collision with root package name */
    private final int f196259x;

    /* renamed from: y, reason: collision with root package name */
    private final int f196260y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f196261z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements ProtoReqManagerImpl.IProtoRespBack {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f196262d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f196263e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ structmsg$SystemMsgActionInfo f196264f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ structmsg$StructMsg f196265h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f196266i;

        a(int i3, int i16, structmsg$SystemMsgActionInfo structmsg_systemmsgactioninfo, structmsg$StructMsg structmsg_structmsg, long j3) {
            this.f196262d = i3;
            this.f196263e = i16;
            this.f196264f = structmsg_systemmsgactioninfo;
            this.f196265h = structmsg_structmsg;
            this.f196266i = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, n.this, Integer.valueOf(i3), Integer.valueOf(i16), structmsg_systemmsgactioninfo, structmsg_structmsg, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
        public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
            boolean z16;
            int i3;
            structmsg$StructMsg structmsg_structmsg;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) protoResp, (Object) protoReq);
                return;
            }
            ToServiceMsg toServiceMsg = (ToServiceMsg) protoReq.busiData;
            boolean z17 = false;
            if (protoResp.resp.getResultCode() != 1000) {
                n.this.l(4012, false, toServiceMsg);
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.SYSTEM_MSG, 2, "sendFriendSystemMsgReadedReportResp exception code:" + protoResp.resp.getResultCode());
                    return;
                }
                return;
            }
            try {
                byte[] wupBuffer = protoResp.resp.getWupBuffer();
                structmsg$RspSystemMsgAction structmsg_rspsystemmsgaction = new structmsg$RspSystemMsgAction();
                structmsg_rspsystemmsgaction.mergeFrom(wupBuffer);
                int i16 = structmsg_rspsystemmsgaction.head.result.get();
                String str = "";
                if (i16 == 0) {
                    z16 = true;
                } else {
                    String str2 = structmsg_rspsystemmsgaction.head.msg_fail.get();
                    if (str2 == null) {
                        str2 = "";
                    }
                    toServiceMsg.extraData.putString("system_msg_action_resp_error_key", str2);
                    z16 = false;
                }
                String str3 = structmsg_rspsystemmsgaction.msg_detail.get();
                if (str3 != null) {
                    str = str3;
                }
                if (structmsg_rspsystemmsgaction.remark_result.has()) {
                    i3 = structmsg_rspsystemmsgaction.remark_result.get();
                } else {
                    i3 = -1;
                }
                toServiceMsg.extraData.putString("system_msg_action_resp_key", str);
                toServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", structmsg_rspsystemmsgaction.head.result.get());
                toServiceMsg.extraData.putInt("system_msg_action_resp_type_key", structmsg_rspsystemmsgaction.type.get());
                toServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", structmsg_rspsystemmsgaction.msg_invalid_decided.get());
                toServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i3);
                boolean z18 = toServiceMsg.extraData.getBoolean("isUncommonlyUsedFrd");
                if (z16 && this.f196262d == 0) {
                    FriendListHandler friendListHandler = (FriendListHandler) ((BaseMessageProcessor) n.this).f116342a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                    int i17 = this.f196263e;
                    if (i17 != 3016 && i17 != 2016) {
                        if (this.f196264f.group_id.has()) {
                            friendListHandler.addFriendToFriendList(String.valueOf(this.f196266i), this.f196264f.group_id.get(), this.f196263e, this.f196265h.f436065msg.msg_additional.get(), false, z18, -1L);
                        }
                    }
                    if (this.f196264f.group_id.has() && (structmsg_structmsg = this.f196265h) != null && structmsg_structmsg.f436065msg.msg_source.has()) {
                        friendListHandler.addFriendToFriendList(String.valueOf(this.f196266i), this.f196264f.group_id.get(), this.f196263e, this.f196265h.f436065msg.msg_source.get(), false, z18, -1L);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.SYSTEM_MSG, 2, "sendFriendSystemMsgActionResp result:" + i16 + " msg:" + str);
                }
                z17 = z16;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.SYSTEM_MSG, 2, "sendFriendSystemMsgReadedReportResp exception", e16);
                }
            }
            n.this.l(4011, z17, toServiceMsg);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements BaseMessageProcessor.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f196268a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f196269b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ structmsg$ReqSystemMsgRead f196270c;

        b(long j3, long j16, structmsg$ReqSystemMsgRead structmsg_reqsystemmsgread) {
            this.f196268a = j3;
            this.f196269b = j16;
            this.f196270c = structmsg_reqsystemmsgread;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, n.this, Long.valueOf(j3), Long.valueOf(j16), structmsg_reqsystemmsgread);
            }
        }

        @Override // com.tencent.imcore.message.BaseMessageProcessor.c
        public ToServiceMsg a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ToServiceMsg) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ToServiceMsg createToServiceMsg = ((BaseMessageProcessor) n.this).f116343b.createToServiceMsg("ProfileService.Pb.ReqSystemMsgRead");
            createToServiceMsg.extraData.putLong("latestFriendSeq", this.f196268a);
            createToServiceMsg.extraData.putLong("latestGroupSeq", this.f196269b);
            createToServiceMsg.putWupBuffer(this.f196270c.toByteArray());
            createToServiceMsg.setEnableFastResend(true);
            return createToServiceMsg;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c implements ProtoReqManagerImpl.IProtoRespBack {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f196272d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f196273e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f196274f;

        c(long j3, long j16, long j17) {
            this.f196272d = j3;
            this.f196273e = j16;
            this.f196274f = j17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, n.this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            }
        }

        @Override // com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
        public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) protoResp, (Object) protoReq);
                return;
            }
            try {
                byte[] wupBuffer = protoResp.resp.getWupBuffer();
                structmsg$RspSystemMsgRead structmsg_rspsystemmsgread = new structmsg$RspSystemMsgRead();
                structmsg_rspsystemmsgread.mergeFrom(wupBuffer);
                int i3 = structmsg_rspsystemmsgread.head.result.get();
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.SYSTEM_MSG, 2, "sendFriendSystemMsgReadedReportResp reqSeq=" + this.f196272d + ";resultCode=" + i3 + ";latestFriendSeq=" + this.f196273e + ";latestGroupSeq=" + this.f196274f);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.SYSTEM_MSG, 2, "sendFriendSystemMsgReadedReportResp exception", e16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d implements ProtoReqManagerImpl.IProtoRespBack {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) n.this);
            }
        }

        @Override // com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
        public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
            boolean z16;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) protoResp, (Object) protoReq);
                return;
            }
            if (protoResp.resp.getResultCode() != 1000) {
                n.this.l(4006, false, null);
                return;
            }
            try {
                String account = ((BaseMessageProcessor) n.this).f116342a.getAccount();
                structmsg$RspNextSystemMsg structmsg_rspnextsystemmsg = new structmsg$RspNextSystemMsg();
                structmsg_rspnextsystemmsg.mergeFrom(protoResp.resp.getWupBuffer());
                if (structmsg_rspnextsystemmsg.head.result.get() != 0) {
                    n.this.l(4006, false, null);
                }
                ArrayList<MessageRecord> arrayList = new ArrayList<>();
                List<structmsg$StructMsg> list = structmsg_rspnextsystemmsg.msgs.get();
                n.this.p0(list);
                int size = list.size();
                if (QLog.isColorLevel()) {
                    QLog.e(LogTag.SYSTEM_MSG, 2, "<---sendGetNextFriendSystemMsg Resp : decode pb size = " + size);
                }
                int i3 = 0;
                while (i3 < size) {
                    MessageRecord d16 = q.d(MessageRecord.MSG_TYPE_SYSTEM_STRUCT_MSG);
                    d16.msgtype = MessageRecord.MSG_TYPE_SYSTEM_STRUCT_MSG;
                    d16.selfuin = account;
                    d16.frienduin = AppConstants.FRIEND_SYSTEM_MSG_UIN;
                    StringBuilder sb5 = new StringBuilder();
                    structmsg$RspNextSystemMsg structmsg_rspnextsystemmsg2 = structmsg_rspnextsystemmsg;
                    sb5.append(list.get(i3).req_uin.get());
                    sb5.append("");
                    d16.senderuin = sb5.toString();
                    d16.istroop = 0;
                    d16.time = list.get(i3).msg_time.get();
                    d16.isread = true;
                    MessageForSystemMsg messageForSystemMsg = (MessageForSystemMsg) d16;
                    structmsg$StructMsg structmsg_structmsg = list.get(i3).get();
                    messageForSystemMsg.structMsg = structmsg_structmsg;
                    d16.msgData = structmsg_structmsg.toByteArray();
                    messageForSystemMsg.parse();
                    arrayList.add(messageForSystemMsg);
                    i3++;
                    structmsg_rspnextsystemmsg = structmsg_rspnextsystemmsg2;
                }
                structmsg$RspNextSystemMsg structmsg_rspnextsystemmsg3 = structmsg_rspnextsystemmsg;
                if (arrayList.size() > 0) {
                    int size2 = arrayList.size();
                    long j3 = arrayList.get(0).time;
                    long j16 = arrayList.get(size2 - 1).time;
                    Iterator<ChatMessage> it = ((IMessageFacade) ((BaseMessageProcessor) n.this).f116342a.getRuntimeService(IMessageFacade.class, "")).getAIOList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, ((INewFriendApi) QRoute.api(INewFriendApi.class)).getOldestSysMsgTime(((BaseMessageProcessor) n.this).f116342a)).iterator();
                    while (it.hasNext()) {
                        ChatMessage next = it.next();
                        long j17 = next.time;
                        if (j17 >= j16 && j17 <= j3) {
                            ((IMessageFacade) ((BaseMessageProcessor) n.this).f116342a.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, next.uniseq, false);
                            it.remove();
                        } else if (next instanceof MessageForSystemMsg) {
                            MessageForSystemMsg messageForSystemMsg2 = (MessageForSystemMsg) next;
                            if (messageForSystemMsg2.structMsg == null) {
                                messageForSystemMsg2.parse();
                            }
                            String str = messageForSystemMsg2.senderuin;
                            if (messageForSystemMsg2.structMsg.f436065msg.sub_type.get() == 13 && com.tencent.qqnt.contact.friends.b.f355778a.c(str, "SystemMessageProcessor")) {
                                ((IMessageFacade) ((BaseMessageProcessor) n.this).f116342a.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, next.uniseq, false);
                                it.remove();
                            }
                        }
                    }
                    ((INewFriendApi) QRoute.api(INewFriendApi.class)).setOldestSysMsgTime(((BaseMessageProcessor) n.this).f116342a, j16);
                    if (arrayList.size() < 20) {
                        ((INewFriendApi) QRoute.api(INewFriendApi.class)).setHasNoMoreMsg(true, ((BaseMessageProcessor) n.this).f116342a);
                    }
                    long j18 = structmsg_rspnextsystemmsg3.following_friend_seq.get();
                    if (j18 <= 0) {
                        j18 = ((com.tencent.mobileqq.service.message.e) ((BaseMessageProcessor) n.this).f116342a.getMsgCache()).a1("following_friend_seq_47");
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e(LogTag.SYSTEM_MSG, 2, "<---sendGetNextFriendSystemMsg : decode pb following_friend_seq" + j18);
                    }
                    ((com.tencent.mobileqq.service.message.e) ((BaseMessageProcessor) n.this).f116342a.getMsgCache()).O("following_friend_seq_47", j18);
                    IMessageFacade iMessageFacade = (IMessageFacade) ((BaseMessageProcessor) n.this).f116342a.getRuntimeService(IMessageFacade.class, "");
                    String valueOf = String.valueOf(account);
                    if (BaseMessageHandlerUtils.hasRecvAndUnreadMsg(arrayList) && ((BaseMessageProcessor) n.this).f116342a.isBackgroundStop) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    iMessageFacade.addMessage(arrayList, valueOf, z17);
                    n.this.n("handleGetSystemMsgResp", true, arrayList.size(), false, false);
                    z16 = true;
                } else {
                    z16 = true;
                    ((INewFriendApi) QRoute.api(INewFriendApi.class)).setHasNoMoreMsg(true, ((BaseMessageProcessor) n.this).f116342a);
                }
                n.this.l(4005, z16, null);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.SYSTEM_MSG, 2, "clearFriendSystemMsgResp exception", e16);
                }
                n.this.l(4006, false, null);
            }
        }
    }

    public n(QQAppInterface qQAppInterface, MessageHandler messageHandler) {
        super(qQAppInterface, messageHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) messageHandler);
            return;
        }
        this.f196259x = 2;
        this.f196260y = 2;
        this.f196261z = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105864", false);
        this.A = new ConcurrentHashMap<>();
        this.B = null;
    }

    private String P() {
        List<MessageRecord> msgList = ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).getMsgList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
        if (msgList != null && msgList.size() > 0) {
            if (msgList.size() <= 0) {
                return "";
            }
            MessageForSystemMsg messageForSystemMsg = (MessageForSystemMsg) msgList.get(msgList.size() - 1);
            messageForSystemMsg.parse();
            return messageForSystemMsg.structMsg.f436065msg.req_uin_nick.get() + " " + messageForSystemMsg.structMsg.f436065msg.msg_describe.get();
        }
        if (!QLog.isColorLevel()) {
            return "";
        }
        QLog.d("SystemMessageProcessor", 2, "mLocalDataList is null !");
        return "";
    }

    private String Q(int i3, structmsg$ReqSystemMsgNew structmsg_reqsystemmsgnew, int i16) {
        if (i3 == 2 || structmsg_reqsystemmsgnew == null || !structmsg_reqsystemmsgnew.uint32_req_msg_type.has() || !structmsg_reqsystemmsgnew.latest_friend_seq.has() || !structmsg_reqsystemmsgnew.latest_group_seq.has()) {
            return "";
        }
        return i3 + "-" + structmsg_reqsystemmsgnew.uint32_req_msg_type.get() + "-" + structmsg_reqsystemmsgnew.latest_friend_seq.get() + "-" + structmsg_reqsystemmsgnew.latest_group_seq.get() + "-" + i16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void S(FromServiceMsg fromServiceMsg, FriendsManager friendsManager, List<structmsg$StructMsg> list, int i3, int i16, INewFriendService iNewFriendService, String str, long j3) {
        String uin;
        boolean z16;
        boolean z17;
        int i17;
        List<structmsg$StructMsg> list2 = list;
        int i18 = i3;
        ArrayList<MessageRecord> arrayList = new ArrayList<>(i18);
        if (fromServiceMsg.getUin() == null) {
            uin = this.f116342a.getAccount();
        } else {
            uin = fromServiceMsg.getUin();
        }
        String str2 = uin;
        int i19 = 0;
        if (i16 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i26 = 0;
        while (i26 < i18) {
            MessageRecord d16 = q.d(MessageRecord.MSG_TYPE_FRIEND_SYSTEM_STRUCT_MSG);
            d16.msgtype = MessageRecord.MSG_TYPE_FRIEND_SYSTEM_STRUCT_MSG;
            d16.selfuin = str2;
            d16.frienduin = AppConstants.FRIEND_SYSTEM_MSG_UIN;
            d16.senderuin = list2.get(i26).req_uin.get() + "";
            d16.istroop = i19;
            d16.time = list2.get(i26).msg_time.get();
            if (list2.get(i26).uint32_unread_flag.get() == 0) {
                z17 = 1;
            } else {
                z17 = i19;
            }
            d16.isread = z17;
            MessageForSystemMsg messageForSystemMsg = (MessageForSystemMsg) d16;
            structmsg$StructMsg structmsg_structmsg = list2.get(i26).get();
            messageForSystemMsg.structMsg = structmsg_structmsg;
            int i27 = structmsg_structmsg.msg_type.get();
            int i28 = messageForSystemMsg.structMsg.f436065msg.sub_type.get();
            if (QLog.isColorLevel()) {
                QLog.e(LogTag.SYSTEM_MSG, 2, "<---handleGetFriendSystemMsgResp|i = " + i26 + ", isRead = " + d16.isread + ", time = " + d16.time + ", uin = " + d16.senderuin);
            }
            if (i26 == 0) {
                d16.extStr = str;
                if (i28 == 13) {
                    i17 = 1;
                    z16 = false;
                    if (i27 != i17 && !com.tencent.mobileqq.systemmsg.a.f(i28)) {
                        if (QLog.isColorLevel()) {
                            QLog.e(LogTag.SYSTEM_MSG, 2, "<---handleGetFriendSystemMsgResp : decode pb filtered");
                        }
                    } else {
                        d16.msgData = messageForSystemMsg.structMsg.toByteArray();
                        ((ChatMessage) d16).parse();
                        arrayList.add(messageForSystemMsg);
                    }
                    i26++;
                    list2 = list;
                    i18 = i3;
                    i19 = 0;
                }
            }
            i17 = 1;
            if (i27 != i17) {
            }
            d16.msgData = messageForSystemMsg.structMsg.toByteArray();
            ((ChatMessage) d16).parse();
            arrayList.add(messageForSystemMsg);
            i26++;
            list2 = list;
            i18 = i3;
            i19 = 0;
        }
        if (arrayList.size() > 0) {
            e0(friendsManager, i16, iNewFriendService, arrayList, str2, z16);
        } else {
            iNewFriendService.loadNewFriendMsg(true);
        }
        iNewFriendService.refreshNotificationWithFriendSystemMessage(new com.tencent.mobileqq.newfriend.msg.c(str, j3));
    }

    private void U(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        toServiceMsg.getServiceCmd();
        long j3 = toServiceMsg.extraData.getLong("latestFriendSeq");
        long j16 = toServiceMsg.extraData.getLong("latestGroupSeq");
        long j17 = toServiceMsg.extraData.getLong("msgSeq");
        long j18 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        toServiceMsg.extraData.getInt("retryIndex");
        int i3 = toServiceMsg.extraData.getInt("type");
        this.f116343b.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        SendMessageHandler handlerFromQueue = this.f116343b.getHandlerFromQueue(j17);
        if (handlerFromQueue != null) {
            if (fromServiceMsg.getResultCode() == 2901 && this.f116343b.retrySendMessage(handlerFromQueue, "msf")) {
                return;
            }
            if (480000 == j18 || handlerFromQueue.c()) {
                if (QLog.isColorLevel()) {
                    QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgReadedReportError type=" + i3 + ";reqSeq=" + j17 + ";latestFriendSeq=" + j3 + ";latestGroupSeq=" + j16);
                }
                this.f116343b.removeSendMessageHandler(j17);
            }
        }
    }

    private void X() {
        synchronized (n.class) {
            if (this.B == null) {
                this.B = new ArrayList<>(20);
            }
        }
    }

    private boolean Y(int i3, long j3) {
        if (i3 != 0 && j3 == 0) {
            return true;
        }
        return false;
    }

    private boolean Z(int i3, int i16, int i17) {
        if (i16 == 0 && i3 == 0 && i17 == 2) {
            return true;
        }
        return false;
    }

    private String a0(String str) {
        if (TextUtils.isEmpty(str)) {
            return P();
        }
        return str;
    }

    private String b0(structmsg$RspSystemMsgNew structmsg_rspsystemmsgnew) {
        if (structmsg_rspsystemmsgnew.msg_display.has()) {
            return structmsg_rspsystemmsgnew.msg_display.get();
        }
        return "";
    }

    private boolean c0(String str) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102642", true) || TextUtils.isEmpty(str)) {
            return false;
        }
        Long l3 = this.A.get(str);
        if (l3 == null) {
            this.A.put(str, Long.valueOf(SystemClock.uptimeMillis()));
            return false;
        }
        if (SystemClock.uptimeMillis() - l3.longValue() < com.tencent.mobileqq.troop.config.b.f294691a.e("102642", "filterTimeMills", 3000L)) {
            return true;
        }
        return false;
    }

    @Nullable
    private structmsg$RspSystemMsgNew d0(byte[] bArr, structmsg$RspSystemMsgNew structmsg_rspsystemmsgnew) {
        structmsg$RspSystemMsgNew structmsg_rspsystemmsgnew2;
        if (structmsg_rspsystemmsgnew == null) {
            structmsg$RspSystemMsgNew structmsg_rspsystemmsgnew3 = null;
            try {
                structmsg_rspsystemmsgnew2 = new structmsg$RspSystemMsgNew();
            } catch (Exception e16) {
                e = e16;
            }
            try {
                structmsg_rspsystemmsgnew2.mergeFrom(bArr);
                return structmsg_rspsystemmsgnew2;
            } catch (Exception e17) {
                e = e17;
                structmsg_rspsystemmsgnew3 = structmsg_rspsystemmsgnew2;
                if (QLog.isColorLevel()) {
                    QLog.e(LogTag.SYSTEM_MSG, 2, "<---handleGetFriendSystemMsgResp : decode pb error:", e);
                    return structmsg_rspsystemmsgnew3;
                }
                return structmsg_rspsystemmsgnew3;
            }
        }
        return structmsg_rspsystemmsgnew;
    }

    private void e0(FriendsManager friendsManager, int i3, INewFriendService iNewFriendService, ArrayList<MessageRecord> arrayList, String str, boolean z16) {
        int size = arrayList.size();
        long j3 = arrayList.get(size - 1).time;
        boolean z17 = false;
        List<ChatMessage> aIOList = ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).getAIOList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, ((INewFriendApi) QRoute.api(INewFriendApi.class)).getOldestSysMsgTime(this.f116342a));
        j0(friendsManager, arrayList, size, j3, aIOList, aIOList.iterator());
        if (aIOList.size() == 0) {
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).setOldestSysMsgTime(this.f116342a, j3);
        } else if (arrayList.size() < 20) {
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).setHasNoMoreMsg(true, this.f116342a);
        }
        QLog.i("SystemMessageProcessor", 2, "shelfSwitch = " + this.f196261z);
        if (!this.f196261z) {
            IMessageFacade iMessageFacade = (IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "");
            String valueOf = String.valueOf(str);
            if (BaseMessageHandlerUtils.hasRecvAndUnreadMsg(arrayList) && this.f116342a.isBackgroundStop) {
                z17 = true;
            }
            iMessageFacade.addMessage(arrayList, valueOf, z17);
        } else {
            QLog.i("SystemMessageProcessor", 2, "IMessageFacade addMessage shelf");
        }
        iNewFriendService.loadNewFriendMsg(true);
        o0(arrayList);
        n("handleGetSystemMsgResp", true, i3, z16, false);
    }

    private void f0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, structmsg$RspSystemMsgNew structmsg_rspsystemmsgnew) {
        boolean z16;
        Class cls;
        long j3;
        boolean z17;
        structmsg$RspSystemMsgNew d06 = d0((byte[]) obj, structmsg_rspsystemmsgnew);
        if (d06 != null && d06.head.result.get() == 0) {
            FriendsManager friendsManager = (FriendsManager) this.f116342a.getManager(QQManagerFactory.FRIENDS_MANAGER);
            List<structmsg$StructMsg> list = d06.friendmsgs.get();
            p0(list);
            int size = list.size();
            int i3 = d06.unread_friend_count.get();
            int i16 = d06.uint32_un_read_count3.get();
            if (d06.uint32_over.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).setSysMsgOverValue(this.f116342a, z16);
            INewFriendService iNewFriendService = (INewFriendService) this.f116342a.getRuntimeService(INewFriendService.class, "");
            int unreadSystemMessageCount = iNewFriendService.getUnreadSystemMessageCount();
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).setUnReadFriendSystemMsgNum(this.f116342a, i3);
            int i17 = toServiceMsg.extraData.getInt("getSystemMsgSender");
            if (!QLog.isColorLevel()) {
                cls = INewFriendApi.class;
            } else {
                StringBuilder sb5 = new StringBuilder();
                cls = INewFriendApi.class;
                sb5.append("processFriendSystemMsg-->requestFrom:");
                sb5.append(i17);
                QLog.d("SystemMessageProcessor", 2, sb5.toString());
                StringBuilder sb6 = new StringBuilder(128);
                sb6.append("<---handleGetFriendSystemMsgResp : decode pb MsgsSize = ");
                sb6.append(size);
                sb6.append(" latest_friend_seq");
                sb6.append(d06.latest_friend_seq.get());
                sb6.append(" latest_group_seq");
                sb6.append(d06.latest_group_seq.get());
                sb6.append(" following_friend_seq");
                sb6.append(d06.following_friend_seq.get());
                sb6.append(" following_group_seq");
                sb6.append(d06.following_group_seq.get());
                sb6.append(" unreadCount");
                sb6.append(i3);
                sb6.append(" localunreadCount");
                sb6.append(unreadSystemMessageCount);
                sb6.append(" isSysMsgOver");
                sb6.append(z16);
                sb6.append(" unreadCountForSuspicious");
                sb6.append(i16);
                QLog.d(LogTag.SYSTEM_MSG, 2, sb6.toString());
            }
            if (Z(size, i3, i17)) {
                ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).clearHistory(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
                iNewFriendService.reloadNewFriendMsg();
                l(4014, true, null);
                return;
            }
            String b06 = b0(d06);
            if (list.size() > 0) {
                j3 = list.get(0).msg_time.get();
                g0(toServiceMsg, d06, list);
            } else {
                j3 = 0;
            }
            this.f196257v = 0;
            long a16 = ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).a1("last_friend_seq_47");
            long j16 = d06.latest_friend_seq.get();
            if (a16 == j16) {
                i0(i3, iNewFriendService, unreadSystemMessageCount, b06, j3);
                return;
            }
            if (i3 == 0 && size == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).O("last_friend_seq_47", d06.latest_friend_seq.get());
            ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).O("following_friend_seq_47", d06.following_friend_seq.get());
            ((INewFriendApi) QRoute.api(cls)).setHasNoMoreMsg(false, this.f116342a);
            if (!z17) {
                S(fromServiceMsg, friendsManager, list, size, i3, iNewFriendService, b06, j3);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.e(LogTag.SYSTEM_MSG, 2, "<---handleGetFriendSystemMsgResp : clear local data. sentSeq:" + a16 + " respSeq:" + j16);
                }
                ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).clearHistory(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
                iNewFriendService.reloadNewFriendMsg();
            }
            l(4005, true, null);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("SystemMessageProcessor", 2, "rspSystemMsg.head.result.get()" + d06.head.result.get());
        }
        this.f116343b.handleError(toServiceMsg, fromServiceMsg);
    }

    private void g0(ToServiceMsg toServiceMsg, structmsg$RspSystemMsgNew structmsg_rspsystemmsgnew, List<structmsg$StructMsg> list) {
        structmsg$SystemMsg structmsg_systemmsg = list.get(0).f436065msg;
        if (structmsg_systemmsg != null && structmsg_systemmsg.has()) {
            if (structmsg_systemmsg.bytes_game_nick.has() && list.get(0).req_uin.has()) {
                String stringUtf8 = structmsg_systemmsg.bytes_game_nick.get().toStringUtf8();
                KplHelper.saveGameNickWithUin(this.f116342a, String.valueOf(list.get(0).req_uin.get()), stringUtf8);
            }
            if (structmsg_systemmsg.bytes_game_msg.has()) {
                KplHelper.saveKplVerifyMsg(this.f116342a, structmsg_systemmsg.bytes_game_msg.get().toStringUtf8());
            }
            if (structmsg_rspsystemmsgnew.bytes_game_nick.has()) {
                KplHelper.saveGameNickWithUin(this.f116342a, toServiceMsg.getUin(), structmsg_rspsystemmsgnew.bytes_game_nick.get());
            }
        }
    }

    private void h0(ArrayList<MessageRecord> arrayList, long j3, Iterator<ChatMessage> it) {
        while (it.hasNext()) {
            ChatMessage next = it.next();
            if (next.time >= j3) {
                ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, next.uniseq, false);
                it.remove();
            } else if (next instanceof MessageForSystemMsg) {
                MessageForSystemMsg messageForSystemMsg = (MessageForSystemMsg) next;
                if (messageForSystemMsg.structMsg == null) {
                    messageForSystemMsg.parse();
                }
                String str = messageForSystemMsg.senderuin;
                int i3 = messageForSystemMsg.structMsg.f436065msg.sub_type.get();
                if (i3 == 13 && com.tencent.qqnt.contact.friends.b.f355778a.c(str, "SystemMessageProcessor")) {
                    ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, next.uniseq, false);
                    it.remove();
                } else if (i3 == 1 || i3 == 13) {
                    Iterator<MessageRecord> it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        MessageRecord next2 = it5.next();
                        if (next2 instanceof MessageForSystemMsg) {
                            int i16 = ((MessageForSystemMsg) next2).structMsg.f436065msg.sub_type.get();
                            String str2 = next2.senderuin;
                            if (i16 == i3 && str2 != null && str2.equals(str)) {
                                ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, next.uniseq, false);
                                it.remove();
                            }
                        }
                    }
                }
            }
        }
    }

    private void i0(int i3, INewFriendService iNewFriendService, int i16, String str, long j3) {
        if (Y(i3, j3)) {
            if (QLog.isColorLevel()) {
                QLog.d("SystemMessageProcessor", 2, "sentSeq == respSeq | unreadCount = " + i3 + " | newFriendLastMsgTime = 0");
                return;
            }
            return;
        }
        String a06 = a0(str);
        if (i16 != i3 && i3 == 0) {
            ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).setReaded(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, true, true);
        }
        iNewFriendService.refreshNotificationWithFriendSystemMessage(new com.tencent.mobileqq.newfriend.msg.c(a06, j3));
    }

    private void j0(FriendsManager friendsManager, ArrayList<MessageRecord> arrayList, int i3, long j3, List<ChatMessage> list, Iterator<ChatMessage> it) {
        if (i3 < 20) {
            while (it.hasNext()) {
                ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, it.next().uniseq, false);
                it.remove();
            }
            return;
        }
        h0(arrayList, j3, it);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        structmsg$RspSystemMsgNew structmsg_rspsystemmsgnew;
        Exception e16;
        StringBuilder sb5;
        n0(toServiceMsg);
        if (fromServiceMsg.getUin() == null) {
            this.f116342a.getAccount();
        } else {
            fromServiceMsg.getUin();
        }
        try {
            structmsg_rspsystemmsgnew = new structmsg$RspSystemMsgNew();
            try {
                structmsg_rspsystemmsgnew.mergeFrom((byte[]) obj);
            } catch (Exception e17) {
                e16 = e17;
                if (QLog.isColorLevel()) {
                    QLog.e("SystemMessageProcessor", 2, "<---handleGetSystemMsgRespNew : decode pb error:", e16);
                }
                sb5 = new StringBuilder();
                if (structmsg_rspsystemmsgnew == null) {
                }
                sb5.append("processSystemMsg error " + structmsg_rspsystemmsgnew.head.result.get());
                if (QLog.isColorLevel()) {
                }
                this.f116343b.handleError(toServiceMsg, fromServiceMsg);
            }
        } catch (Exception e18) {
            structmsg_rspsystemmsgnew = null;
            e16 = e18;
        }
        sb5 = new StringBuilder();
        if (structmsg_rspsystemmsgnew == null && structmsg_rspsystemmsgnew.head.result.get() == 0) {
            if (QLog.isColorLevel()) {
                QLog.e("SystemMessageProcessor", 2, "SystemMessageProcessor: listsize");
            }
            f0(toServiceMsg, fromServiceMsg, obj, structmsg_rspsystemmsgnew);
            return;
        }
        sb5.append("processSystemMsg error " + structmsg_rspsystemmsgnew.head.result.get());
        if (QLog.isColorLevel()) {
            QLog.e("SystemMessageProcessor", 2, sb5.toString());
        }
        this.f116343b.handleError(toServiceMsg, fromServiceMsg);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        structmsg$RspSystemMsgAction structmsg_rspsystemmsgaction;
        int i3;
        if (fromServiceMsg.getUin() == null) {
            this.f116342a.getAccount();
        } else {
            fromServiceMsg.getUin();
        }
        structmsg$RspSystemMsgAction structmsg_rspsystemmsgaction2 = null;
        try {
            structmsg_rspsystemmsgaction = new structmsg$RspSystemMsgAction();
        } catch (Exception e16) {
            e = e16;
        }
        try {
            structmsg_rspsystemmsgaction.mergeFrom((byte[]) obj);
        } catch (Exception e17) {
            e = e17;
            structmsg_rspsystemmsgaction2 = structmsg_rspsystemmsgaction;
            if (QLog.isColorLevel()) {
                QLog.e("SystemMessageProcessor", 2, "<---handleSendSystemMsgAction : decode pb:", e);
            }
            structmsg_rspsystemmsgaction = structmsg_rspsystemmsgaction2;
            boolean z16 = false;
            if (structmsg_rspsystemmsgaction != null) {
            }
            l(4011, z16, toServiceMsg);
        }
        boolean z162 = false;
        if (structmsg_rspsystemmsgaction != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgAction result id=" + structmsg_rspsystemmsgaction.head.result.get());
            }
            String str = "";
            if (structmsg_rspsystemmsgaction.head.result.get() == 0) {
                z162 = true;
            } else {
                String str2 = structmsg_rspsystemmsgaction.head.msg_fail.get();
                if (str2 == null) {
                    str2 = "";
                }
                toServiceMsg.extraData.putString("system_msg_action_resp_error_key", str2);
            }
            String str3 = structmsg_rspsystemmsgaction.msg_detail.get();
            if (str3 != null) {
                str = str3;
            }
            if (structmsg_rspsystemmsgaction.remark_result.has()) {
                i3 = structmsg_rspsystemmsgaction.remark_result.get();
            } else {
                i3 = -1;
            }
            toServiceMsg.extraData.putString("system_msg_action_resp_key", str);
            toServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", structmsg_rspsystemmsgaction.head.result.get());
            toServiceMsg.extraData.putInt("system_msg_action_resp_type_key", structmsg_rspsystemmsgaction.type.get());
            toServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", structmsg_rspsystemmsgaction.msg_invalid_decided.get());
            toServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i3);
        }
        l(4011, z162, toServiceMsg);
    }

    private void m0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        toServiceMsg.getServiceCmd();
        long j3 = toServiceMsg.extraData.getLong("latestFriendSeq");
        long j16 = toServiceMsg.extraData.getLong("latestGroupSeq");
        long j17 = toServiceMsg.extraData.getLong("msgSeq");
        toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        toServiceMsg.extraData.getInt("retryIndex");
        int i3 = toServiceMsg.extraData.getInt("type");
        this.f116343b.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        if (this.f116343b.getHandlerFromQueue(j17) != null && obj != null) {
            structmsg$RspSystemMsgRead structmsg_rspsystemmsgread = new structmsg$RspSystemMsgRead();
            try {
                structmsg_rspsystemmsgread.mergeFrom((byte[]) obj);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("SystemMessageProcessor", 2, "<---handleSendSystemMsgReadedReport :type = " + i3 + " decode pb:", e16);
                }
            }
            int i16 = structmsg_rspsystemmsgread.head.result.get();
            if (i16 == 0) {
                this.f116343b.removeSendMessageHandler(j17);
            }
            if (QLog.isColorLevel()) {
                QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgReadedReport type =" + i3 + ";reqSeq=" + j17 + ";resultCode=" + i16 + ";latestFriendSeq=" + j3 + ";latestGroupSeq=" + j16);
            }
        }
    }

    private void n0(ToServiceMsg toServiceMsg) {
        String string = toServiceMsg.extraData.getString("request_unique_key");
        if (QLog.isDebugVersion()) {
            QLog.d("SystemMessageProcessor", 4, "[removeRequestKeyWhenFinish] key:" + string + ", mapHas:" + this.A.containsKey(string));
        }
        if (!TextUtils.isEmpty(string)) {
            this.A.remove(string);
        }
    }

    private void o0(List<MessageRecord> list) {
        String str;
        String str2 = "";
        RecentUserProxy recentUserCache = ((IRecentUserProxyService) this.f116342a.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        RecentUser findRecentUserByUin = recentUserCache.findRecentUserByUin(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
        findRecentUserByUin.msgType = 26;
        findRecentUserByUin.displayName = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getNewFriendTag();
        MessageForSystemMsg messageForSystemMsg = (MessageForSystemMsg) list.get(0);
        messageForSystemMsg.parse();
        if (!TextUtils.isEmpty(messageForSystemMsg.extStr)) {
            str = messageForSystemMsg.extStr;
        } else {
            str = messageForSystemMsg.structMsg.f436065msg.req_uin_nick.get() + " " + messageForSystemMsg.structMsg.f436065msg.msg_describe.get();
        }
        findRecentUserByUin.lastmsgtime = messageForSystemMsg.time;
        findRecentUserByUin.msgData = str.getBytes();
        findRecentUserByUin.f203116msg = str;
        findRecentUserByUin.reParse();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("mDataList.size() ");
            sb5.append(list.size());
            sb5.append(" | msg = ");
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
            }
            sb5.append(str2);
            QLog.d("SystemMessageProcessor", 2, sb5.toString());
        }
        recentUserCache.saveRecentUser(findRecentUserByUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(List<structmsg$StructMsg> list) {
        String str;
        if (list != null && !list.isEmpty()) {
            IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
            for (structmsg$StructMsg structmsg_structmsg : list) {
                String valueOf = String.valueOf(structmsg_structmsg.req_uin.get());
                if (structmsg_structmsg.f436065msg.has() && structmsg_structmsg.f436065msg.uid.has()) {
                    str = structmsg_structmsg.f436065msg.uid.get();
                } else {
                    str = "";
                }
                iRelationNTUinAndUidApi.saveUidByUin(valueOf, str);
            }
            return;
        }
        QLog.e("SystemMessageProcessor", 1, "saveUinAndUidInfo is error! friendMsgs is invalid!");
    }

    public void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w(LogTag.SYSTEM_MSG, 2, "clearAllSystemMsg");
        }
        Oidb_0x5cf$ReqBody oidb_0x5cf$ReqBody = new Oidb_0x5cf$ReqBody();
        oidb_0x5cf$ReqBody.uint32_version.set(1);
        oidb_0x5cf$ReqBody.uint32_type.set(10);
        oidb_0x5cf$ReqBody.uint64_touin.set(this.f116342a.getLongAccountUin());
        this.f116343b.sendPbReq(this.f116343b.makeOIDBPkg("OidbSvc.0x5cf_1", 1487, 0, oidb_0x5cf$ReqBody.toByteArray()));
    }

    public void R(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w(LogTag.SYSTEM_MSG, 2, "handleDelAllSysMsg");
        }
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new Oidb_0x5cf$RspBody());
        if (parseOIDBPkg == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.w(LogTag.SYSTEM_MSG, 2, "handleDelAllSysMsg. " + parseOIDBPkg);
        }
        if (z16) {
            ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).clearHistory(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
            ((INewFriendService) this.f116342a.getRuntimeService(INewFriendService.class, "")).reloadNewFriendMsg();
        }
        m(MessageHandlerConstants.NOTIFY_TYPE_DELETE_ALL_SYSTEMMSG, z16, new Object[]{Integer.valueOf(parseOIDBPkg)});
    }

    public void T(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new Oidb_0x5cf$RspBody());
            if (parseOIDBPkg == 0) {
                ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(toServiceMsg.extraData.getString("frienduin"), toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_IS_TROOP), toServiceMsg.extraData.getLong("uniseq"), false);
                if (QLog.isColorLevel()) {
                    QLog.w(LogTag.SYSTEM_MSG, 2, "<---handleGetDelSingleSysMsg Success!");
                }
                m(4014, true, toServiceMsg);
                return;
            }
            if (parseOIDBPkg == 1) {
                m(4014, true, toServiceMsg);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w(LogTag.SYSTEM_MSG, 2, "<---handleGetDelSingleSysMsg Error!");
            }
            m(4015, false, toServiceMsg);
            return;
        }
        m(4015, false, null);
    }

    public void V(long j3, long j16, int i3, int i16, long j17, int i17) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j17), Integer.valueOf(i17));
            return;
        }
        String valueOf = String.valueOf(j16);
        FriendsManager friendsManager = (FriendsManager) this.f116342a.getManager(QQManagerFactory.FRIENDS_MANAGER);
        FriendListHandler friendListHandler = (FriendListHandler) this.f116342a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (i3 != 188 && i3 != 189) {
            if (i3 == 190) {
                friendsManager.y0(valueOf, false);
                return;
            }
            return;
        }
        X();
        if (this.B.contains(Integer.valueOf(i17))) {
            return;
        }
        this.B.add(Integer.valueOf(i17));
        if (j3 == j16) {
            z16 = true;
        } else {
            z16 = false;
        }
        friendListHandler.addFriendToFriendList(valueOf, 0, BuddySource.DEFAULT, null, z16, false, j17);
    }

    public void W(long j3, long j16, short s16, int i3, msg_comm$Msg msg_comm_msg, int i16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Long.valueOf(j3), Long.valueOf(j16), Short.valueOf(s16), Integer.valueOf(i3), msg_comm_msg, Integer.valueOf(i16));
            return;
        }
        String valueOf = String.valueOf(j16);
        FriendsManager friendsManager = (FriendsManager) this.f116342a.getManager(QQManagerFactory.FRIENDS_MANAGER);
        FriendListHandler friendListHandler = (FriendListHandler) this.f116342a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (s16 != 188 && s16 != 189) {
            if (s16 == 190) {
                friendsManager.y0(valueOf, false);
                return;
            }
            return;
        }
        X();
        if (this.B.contains(Integer.valueOf(i16))) {
            return;
        }
        this.B.add(Integer.valueOf(i16));
        SystemMsg decode = SystemMsg.decode(this.f116342a, HexUtil.bytes2HexStr(msg_comm_msg.msg_body.get().msg_content.get().toByteArray()), valueOf, i3);
        if (decode != null) {
            str = decode.strGameName;
        } else {
            str = "";
        }
        friendListHandler.addFriendToFriendList(valueOf, 0, BuddySource.DEFAULT, str, true, false, msg_comm_msg.msg_head.msg_time.get());
        com.tencent.mobileqq.activity.contact.newfriend.b.b(this.f116342a, j3, j16, s16, msg_comm_msg, i16);
    }

    public void q0(structmsg$StructMsg structmsg_structmsg, String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, structmsg_structmsg, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        Oidb_0x5cf$ReqBody oidb_0x5cf$ReqBody = new Oidb_0x5cf$ReqBody();
        Oidb_0x5cf$DelMsgInfo oidb_0x5cf$DelMsgInfo = new Oidb_0x5cf$DelMsgInfo();
        oidb_0x5cf$ReqBody.uint32_version.set(1);
        oidb_0x5cf$ReqBody.uint32_type.set(9);
        oidb_0x5cf$ReqBody.uint64_touin.set(Long.parseLong(this.f116342a.getAccount()));
        oidb_0x5cf$ReqBody.fixed32_sequence.set((int) structmsg_structmsg.msg_seq.get());
        oidb_0x5cf$DelMsgInfo.uint32_platform.set(2);
        if (structmsg_structmsg.f436065msg.sub_type.get() < 2) {
            Oidb_0x5cf$DelUnDecideInfo oidb_0x5cf$DelUnDecideInfo = new Oidb_0x5cf$DelUnDecideInfo();
            oidb_0x5cf$DelUnDecideInfo.uint64_uin.set(structmsg_structmsg.req_uin.get());
            oidb_0x5cf$DelMsgInfo.rpt_msg_undecide_info.add(oidb_0x5cf$DelUnDecideInfo);
        } else {
            Oidb_0x5cf$DelDecideInfo oidb_0x5cf$DelDecideInfo = new Oidb_0x5cf$DelDecideInfo();
            oidb_0x5cf$DelDecideInfo.uint64_uin.set(structmsg_structmsg.req_uin.get());
            oidb_0x5cf$DelDecideInfo.uint32_time.set((int) structmsg_structmsg.msg_time.get());
            oidb_0x5cf$DelDecideInfo.uint32_req_type.set(structmsg_structmsg.f436065msg.sub_type.get());
            oidb_0x5cf$DelMsgInfo.rpt_msg_decide_info.add(oidb_0x5cf$DelDecideInfo);
        }
        oidb_0x5cf$ReqBody.msg_del_msg_info.set(oidb_0x5cf$DelMsgInfo);
        ToServiceMsg makeOIDBPkg = this.f116343b.makeOIDBPkg("OidbSvc.0x5cf_0", 1487, 0, oidb_0x5cf$ReqBody.toByteArray());
        makeOIDBPkg.extraData.putString("frienduin", str);
        makeOIDBPkg.extraData.putInt(AppConstants.Key.COLUMN_IS_TROOP, i3);
        makeOIDBPkg.extraData.putLong("uniseq", j3);
        this.f116343b.sendPbReq(makeOIDBPkg);
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void r(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
            return;
        }
        if (i3 != 6001) {
            if (i3 != 6002) {
                if (i3 != 6006) {
                    if (i3 != 6008) {
                        if (i3 == 6009) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SystemMessageProcessor", 2, "handleGetDelAllSysMsg Error!");
                            }
                            m(MessageHandlerConstants.NOTIFY_TYPE_DELETE_ALL_SYSTEMMSG, false, new Object[]{Integer.valueOf(fromServiceMsg.getResultCode())});
                            return;
                        }
                        return;
                    }
                    m(4015, false, toServiceMsg);
                    return;
                }
                U(toServiceMsg, fromServiceMsg);
                return;
            }
            this.f196257v = 0;
            n0(toServiceMsg);
            return;
        }
        this.f196258w = 0;
    }

    public void r0(int i3, long j3, long j16, int i16, int i17, int i18, int i19, structmsg$SystemMsgActionInfo structmsg_systemmsgactioninfo, int i26, structmsg$StructMsg structmsg_structmsg, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), structmsg_systemmsgactioninfo, Integer.valueOf(i26), structmsg_structmsg, Boolean.valueOf(z16));
            return;
        }
        long j17 = i3 + j3;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.SYSTEM_MSG, 2, "sendFriendSystemMsgAction logStr=" + j17);
        }
        structmsg$ReqSystemMsgAction structmsg_reqsystemmsgaction = new structmsg$ReqSystemMsgAction();
        structmsg_reqsystemmsgaction.msg_type.set(i3);
        structmsg_reqsystemmsgaction.msg_seq.set(j3);
        structmsg_reqsystemmsgaction.req_uin.set(j16);
        structmsg_reqsystemmsgaction.sub_type.set(i16);
        structmsg_reqsystemmsgaction.src_id.set(i17);
        structmsg_reqsystemmsgaction.sub_src_id.set(i18);
        structmsg_reqsystemmsgaction.group_msg_type.set(i19);
        structmsg_reqsystemmsgaction.action_info.set(structmsg_systemmsgactioninfo);
        ProtoReqManagerImpl.ProtoReq protoReq = new ProtoReqManagerImpl.ProtoReq();
        protoReq.setEasyRetryMode();
        protoReq.ssoCmd = "ProfileService.Pb.ReqSystemMsgAction.Friend";
        protoReq.reqBody = structmsg_reqsystemmsgaction.toByteArray();
        ToServiceMsg createToServiceMsg = this.f116343b.createToServiceMsg("ProfileService.Pb.ReqSystemMsgAction.Friend");
        createToServiceMsg.addAttribute(BaseConstants.Attribute_TAG_LOGSTR, String.valueOf(j17));
        createToServiceMsg.extraData.putInt("system_msg_action_type", i26);
        createToServiceMsg.extraData.putBoolean("isUncommonlyUsedFrd", z16);
        protoReq.busiData = createToServiceMsg;
        protoReq.callback = new a(i26, i17, structmsg_systemmsgactioninfo, structmsg_structmsg, j16);
        ((IProtoReqManager) this.f116342a.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(protoReq);
    }

    public void s0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        int i3 = MobileQQServiceBase.seq;
        MobileQQServiceBase.seq = i3 + 1;
        long j3 = i3;
        System.currentTimeMillis();
        long a16 = ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).a1("last_friend_seq_47");
        long a17 = ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).a1("last_group_seq");
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.SYSTEM_MSG, 2, "sendSystemMsgReadedReport reqSeq=" + j3 + ";latestFriendSeq=" + a16 + ";latestGroupSeq=" + a17);
        }
        structmsg$ReqSystemMsgRead structmsg_reqsystemmsgread = new structmsg$ReqSystemMsgRead();
        structmsg_reqsystemmsgread.latest_friend_seq.set(a16);
        structmsg_reqsystemmsgread.checktype.set(2);
        ProtoReqManagerImpl.ProtoReq protoReq = new ProtoReqManagerImpl.ProtoReq();
        protoReq.ssoCmd = "ProfileService.Pb.ReqSystemMsgRead.Friend";
        protoReq.reqBody = structmsg_reqsystemmsgread.toByteArray();
        protoReq.callback = new c(j3, a16, a17);
        ((IProtoReqManager) this.f116342a.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(protoReq);
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void t(int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) objArr);
            return;
        }
        if (i3 != 6001) {
            if (i3 != 6002) {
                switch (i3) {
                    case 6006:
                        if (objArr != null && objArr.length == 3) {
                            m0((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
                            return;
                        } else {
                            f(getClass().getName(), i3);
                            return;
                        }
                    case 6007:
                        if (objArr != null && objArr.length == 3) {
                            l0((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
                            return;
                        } else {
                            f(getClass().getName(), i3);
                            return;
                        }
                    case 6008:
                        if (objArr != null && objArr.length == 3) {
                            T((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
                            return;
                        } else {
                            m(4015, false, null);
                            f(getClass().getName(), i3);
                            return;
                        }
                    case 6009:
                        R((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
                        return;
                    default:
                        return;
                }
            }
            if (objArr != null && objArr.length == 3) {
                k0((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
                return;
            } else {
                f(getClass().getName(), i3);
                return;
            }
        }
        if (objArr != null && objArr.length == 3) {
            f0((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2], null);
        } else {
            f(getClass().getName(), i3);
        }
    }

    public void t0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            w0(i3, 2, true);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void u(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
            return;
        }
        if (i3 != 6001) {
            if (i3 != 6002) {
                switch (i3) {
                    case 6006:
                        U(toServiceMsg, fromServiceMsg);
                        return;
                    case 6007:
                        if (QLog.isColorLevel()) {
                            QLog.d("SystemMessageProcessor", 2, "onSendSystemMsgActionError");
                        }
                        m(4012, false, toServiceMsg);
                        return;
                    case 6008:
                        if (QLog.isColorLevel()) {
                            QLog.d("SystemMessageProcessor", 2, "handleGetDelSingleSysMsg Error!");
                        }
                        m(4015, false, toServiceMsg);
                        return;
                    case 6009:
                        if (QLog.isColorLevel()) {
                            QLog.d("SystemMessageProcessor", 2, "handleGetDelAllSysMsg timeout!");
                        }
                        m(MessageHandlerConstants.NOTIFY_TYPE_DELETE_ALL_SYSTEMMSG, false, new Object[]{Integer.valueOf(fromServiceMsg.getResultCode())});
                        return;
                    default:
                        return;
                }
            }
            n0(toServiceMsg);
            int i16 = this.f196257v;
            if (i16 < 2) {
                this.f196257v = i16 + 1;
                v0(4);
                return;
            } else {
                this.f196257v = 0;
                return;
            }
        }
        int i17 = this.f196258w;
        if (i17 < 2) {
            this.f196258w = i17 + 1;
            v0(2);
        } else {
            this.f196258w = 0;
        }
    }

    public void u0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        this.f116343b.createToServiceMsg("ProfileService.Pb.ReqNextSystemMsg.Friend");
        if (QLog.isColorLevel()) {
            QLog.w(LogTag.SYSTEM_MSG, 2, "<---sendGetNextFriendSystemMsgfollowing_friend_seq = " + ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).a1("following_friend_seq_47"));
        }
        structmsg$ReqNextSystemMsg structmsg_reqnextsystemmsg = new structmsg$ReqNextSystemMsg();
        structmsg_reqnextsystemmsg.uint32_need_uid.set(1);
        structmsg_reqnextsystemmsg.msg_num.set(20);
        structmsg_reqnextsystemmsg.following_friend_seq.set(((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).a1("following_friend_seq_47"));
        structmsg_reqnextsystemmsg.checktype.set(2);
        structmsg_reqnextsystemmsg.version.set(1000);
        structmsg_reqnextsystemmsg.friend_msg_type_flag.set(1L);
        structmsg$FlagInfo structmsg_flaginfo = new structmsg$FlagInfo();
        structmsg_flaginfo.FrdMsg_GetBusiCard.set(1);
        structmsg_flaginfo.FrdMsg_Discuss2ManyChat.set(1);
        structmsg_flaginfo.FrdMsg_NeedWaitingMsg.set(1);
        structmsg_reqnextsystemmsg.flag.set(structmsg_flaginfo);
        ProtoReqManagerImpl.ProtoReq protoReq = new ProtoReqManagerImpl.ProtoReq();
        protoReq.setEasyRetryMode();
        protoReq.ssoCmd = "ProfileService.Pb.ReqNextSystemMsg.Friend";
        protoReq.reqBody = structmsg_reqnextsystemmsg.toByteArray();
        protoReq.callback = new d();
        ((IProtoReqManager) this.f116342a.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(protoReq);
    }

    public void v0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            w0(i3, 0, false);
        }
    }

    public void w0(int i3, int i16, boolean z16) {
        String str;
        structmsg$FlagInfo structmsg_flaginfo;
        long a16;
        long a17;
        long a18;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        if (i3 != 2) {
            str = "ProfileService.Pb.ReqSystemMsgNew";
            if (i3 != 4) {
                structmsg_flaginfo = null;
                i17 = 0;
            } else {
                structmsg_flaginfo = new structmsg$FlagInfo();
                structmsg_flaginfo.GrpMsg_Kick_Admin.set(1);
                structmsg_flaginfo.GrpMsg_HiddenGrp.set(1);
                structmsg_flaginfo.GrpMsg_WordingDown.set(1);
                structmsg_flaginfo.GrpMsg_GetOfficialAccount.set(1);
                structmsg_flaginfo.GrpMsg_GetPayInGroup.set(1);
                structmsg_flaginfo.FrdMsg_Discuss2ManyChat.set(1);
                structmsg_flaginfo.FrdMsg_GetBusiCard.set(1);
                structmsg_flaginfo.FrdMsg_NeedWaitingMsg.set(1);
                structmsg_flaginfo.GrpMsg_NotAllowJoinGrp_InviteNotFrd.set(1);
                structmsg_flaginfo.FrdMsg_uint32_need_all_unread_msg.set(1);
                structmsg_flaginfo.GrpMsg_get_transfer_group_msg_flag.set(1);
                structmsg_flaginfo.GrpMsg_NeedAutoAdminWording.set(1);
                structmsg_flaginfo.GrpMsg_get_quit_pay_group_msg_flag.set(1);
                structmsg_flaginfo.GrpMsg_support_invite_auto_join.set(1);
                structmsg_flaginfo.GrpMsg_mask_invite_auto_join.set(1);
                structmsg_flaginfo.GrpMsg_GetDisbandedByAdmin.set(1);
                structmsg_flaginfo.GrpMsg_GetC2cInviteJoinGroup.set(1);
            }
        } else {
            structmsg$FlagInfo structmsg_flaginfo2 = new structmsg$FlagInfo();
            structmsg_flaginfo2.FrdMsg_GetBusiCard.set(1);
            structmsg_flaginfo2.FrdMsg_Discuss2ManyChat.set(1);
            structmsg_flaginfo2.FrdMsg_NeedWaitingMsg.set(1);
            structmsg_flaginfo2.FrdMsg_uint32_need_all_unread_msg.set(1);
            structmsg_flaginfo2.GrpMsg_GetC2cInviteJoinGroup.set(1);
            str = "ProfileService.Pb.ReqSystemMsgNew.Friend";
            structmsg_flaginfo = structmsg_flaginfo2;
            i17 = 2;
        }
        if (QLog.isColorLevel()) {
            QLog.w(LogTag.SYSTEM_MSG, 2, "<---sendGetSystemMsg type=" + i3 + ", requestFrom:" + i16 + " latest_friend_seq = " + ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).a1("last_friend_seq_47") + " latest_group_seq = " + ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).a1("last_group_seq") + " last_group_suspicious_seq = " + ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).a1("last_group_suspicious_seq"));
        }
        ToServiceMsg createToServiceMsg = this.f116343b.createToServiceMsg(str);
        structmsg$ReqSystemMsgNew structmsg_reqsystemmsgnew = new structmsg$ReqSystemMsgNew();
        structmsg_reqsystemmsgnew.uint32_need_uid.set(1);
        structmsg_reqsystemmsgnew.msg_num.set(20);
        structmsg_reqsystemmsgnew.checktype.set(i17);
        PBUInt64Field pBUInt64Field = structmsg_reqsystemmsgnew.latest_friend_seq;
        if (z16) {
            a16 = 0;
        } else {
            a16 = ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).a1("last_friend_seq_47");
        }
        pBUInt64Field.set(a16);
        if (i16 == 3) {
            PBUInt64Field pBUInt64Field2 = structmsg_reqsystemmsgnew.latest_group_seq;
            if (z16) {
                a18 = 0;
            } else {
                a18 = ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).a1("last_group_suspicious_seq");
            }
            pBUInt64Field2.set(a18);
        } else {
            PBUInt64Field pBUInt64Field3 = structmsg_reqsystemmsgnew.latest_group_seq;
            if (z16) {
                a17 = 0;
            } else {
                a17 = ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).a1("last_group_seq");
            }
            pBUInt64Field3.set(a17);
        }
        if (structmsg_flaginfo != null) {
            structmsg_reqsystemmsgnew.flag.set(structmsg_flaginfo);
        }
        structmsg_reqsystemmsgnew.is_get_frd_ribbon.set(false);
        structmsg_reqsystemmsgnew.version.set(1000);
        structmsg_reqsystemmsgnew.is_get_grp_ribbon.set(false);
        structmsg_reqsystemmsgnew.friend_msg_type_flag.set(1L);
        if (i16 == 3) {
            structmsg_reqsystemmsgnew.uint32_req_msg_type.set(2);
        } else {
            structmsg_reqsystemmsgnew.uint32_req_msg_type.set(1);
        }
        createToServiceMsg.extraData.putInt("getSystemMsgSender", i16);
        createToServiceMsg.putWupBuffer(structmsg_reqsystemmsgnew.toByteArray());
        String Q = Q(i3, structmsg_reqsystemmsgnew, i16);
        if (!c0(Q)) {
            createToServiceMsg.extraData.putString("request_unique_key", Q);
            this.f116343b.sendPbReq(createToServiceMsg);
            if (QLog.isColorLevel()) {
                QLog.i("SystemMessageProcessor", 2, "[sendGetSystemMsg] start request");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SystemMessageProcessor", 2, "[sendGetSystemMsg] filter repeat request");
        }
    }

    public void x0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        long a16 = ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).a1("last_friend_seq_47");
        long a17 = ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).a1("last_group_seq");
        structmsg$ReqSystemMsgRead structmsg_reqsystemmsgread = new structmsg$ReqSystemMsgRead();
        structmsg_reqsystemmsgread.latest_friend_seq.set(a16);
        structmsg_reqsystemmsgread.latest_group_seq.set(a17);
        if (QLog.isColorLevel()) {
            QLog.d("SystemMessageProcessor", 2, "sendSystemMsgReadedReport latestFriendSeq=" + a16 + ";latestGroupSeq=" + a17);
        }
        s(true, true, false, 0L, new b(a16, a17, structmsg_reqsystemmsgread));
    }
}
