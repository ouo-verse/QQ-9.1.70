package com.tencent.mobileqq.guild.message.eventflow.api.impl;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import bu1.a;
import bu1.b;
import bu1.d;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.al;
import com.tencent.imcore.message.f;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildAioNavigateBarService;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMsgUtilsApi;
import com.tencent.mobileqq.guild.message.GuildEventFlowObserver;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService;
import com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService;
import com.tencent.mobileqq.guild.message.msgtype.MessageForGuildRevokeGrayTip;
import com.tencent.mobileqq.guild.message.unread.DecreaseMsgSeqInfo;
import com.tencent.mobileqq.guild.message.x;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import su1.c;
import tencent.im.group_pro_proto.common.common$Event;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.synclogic.synclogic$ChannelMsgRsp;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildEventFlowServiceImpl implements IGuildEventFlowService {
    private static final String TAG = "GuildEventFlowServiceImpl";
    private AppRuntime appRuntime;
    private Object revokeGrayTipLock = new Object();
    private ConcurrentHashMap<String, d> channelLogicMaps = new ConcurrentHashMap<>();

    /* JADX WARN: Removed duplicated region for block: B:30:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x019b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void addGreyTipsForDeletedMsg(MessageRecord messageRecord, common$Event common_event) {
        boolean z16;
        boolean z17;
        boolean z18;
        String qqStr;
        String str;
        boolean z19;
        String str2;
        boolean z26;
        if (common_event.op_info.has() && common_event.op_info.operator_tinyid.has() && common_event.op_info.operator_tinyid.get() != 0) {
            if (common_event.op_info.operator_role.get() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            String valueOf = String.valueOf(common_event.op_info.operator_tinyid.get());
            String selfTinyId = ((IGPSService) this.appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
            if (!TextUtils.isEmpty(selfTinyId) && selfTinyId.equals(valueOf)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!TextUtils.isEmpty(selfTinyId) && selfTinyId.equals(messageRecord.senderuin)) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z17) {
                if (z18) {
                    qqStr = HardCodeUtil.qqStr(R.string.f153221bi);
                    if (messageRecord.msgtype == -1000 && !TextUtils.isEmpty(messageRecord.f203106msg)) {
                        String str3 = messageRecord.f203106msg;
                        str = messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.GUILD_AT_INFO_LIST);
                        z19 = false;
                        str2 = str3;
                        z26 = true;
                        QLog.i(TAG, 1, "addGreyTipsForDeletedMsg. cbannelId: " + messageRecord.frienduin + ", isSelfRevoked: " + z17 + ", isSelfSentMsg: " + z18 + ", canReEdit: " + z26 + ", deletedMsg: " + messageRecord.shmsgseq + ", deletedMsg.msgtype: " + messageRecord.msgtype + ", deletedMsg.senderUin: " + messageRecord.senderuin + ", deletedMsg.msg empty: " + TextUtils.isEmpty(messageRecord.f203106msg) + ", isOperatorAdmin: " + z16 + ", event.op_info.operator_role.has: " + common_event.op_info.operator_role.has() + ", operatorTid: " + common_event.op_info.operator_tinyid.get() + ", needUpdateNick: " + z19 + ", wording: " + qqStr);
                        final MessageForGuildRevokeGrayTip messageForGuildRevokeGrayTip = new MessageForGuildRevokeGrayTip();
                        messageForGuildRevokeGrayTip.init(messageRecord, qqStr, z26, str2, str, valueOf, z19);
                        messageForGuildRevokeGrayTip.time = System.currentTimeMillis() / 1000;
                        if (c.c(messageRecord)) {
                            c.e(messageForGuildRevokeGrayTip, true);
                        }
                        synchronized (this.revokeGrayTipLock) {
                            f y16 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.appRuntime).F(10014).y(10014);
                            String str4 = messageRecord.frienduin;
                            int i3 = messageRecord.istroop;
                            long j3 = messageRecord.shmsgseq;
                            List<MessageRecord> d06 = y16.d0(str4, i3, j3, j3, new int[]{MessageRecord.MSG_TYPE_GUILD_REVOKE_GRAY_TIP});
                            for (MessageRecord messageRecord2 : d06) {
                                if (messageRecord2 instanceof MessageForGuildRevokeGrayTip) {
                                    if (!messageRecord2.isValid) {
                                        y16.t0(messageRecord2, true);
                                    }
                                    QLog.e(TAG, 1, "addGreyTipsForDeletedMsg. another MessageForGuildRevokeGrayTip has been created: " + messageRecord2.toString() + ", mrListSize: " + d06.size());
                                    return;
                                }
                            }
                            if (((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isGuest(messageRecord.frienduin)) {
                                QLog.i(TAG, 1, "addGreyTipsForDeletedMsg. GUEST! gray MR: " + messageForGuildRevokeGrayTip.toString());
                                List<MessageRecord> arrayList = new ArrayList<>();
                                arrayList.add(messageForGuildRevokeGrayTip);
                                y16.g(String.valueOf(messageRecord.frienduin), 10014, messageForGuildRevokeGrayTip.uniseq, arrayList);
                            } else {
                                boolean needToAddRevokeGrayTipToAio = needToAddRevokeGrayTipToAio(y16, messageForGuildRevokeGrayTip);
                                QLog.i(TAG, 1, "addGreyTipsForDeletedMsg. needToAddAio: " + needToAddRevokeGrayTipToAio + ", gray MR: " + messageForGuildRevokeGrayTip.toString());
                                y16.c(messageForGuildRevokeGrayTip.frienduin, messageForGuildRevokeGrayTip.istroop, messageForGuildRevokeGrayTip, new al(), true, true, needToAddRevokeGrayTipToAio);
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.eventflow.api.impl.GuildEventFlowServiceImpl.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ((IMessageFacade) GuildEventFlowServiceImpl.this.appRuntime.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(messageForGuildRevokeGrayTip);
                                    }
                                });
                            }
                            return;
                        }
                    }
                    str = "";
                    z19 = false;
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.f153231bj);
                    str = "";
                    z19 = true;
                }
            } else if (z18) {
                qqStr = HardCodeUtil.qqStr(R.string.f153161bc);
                str = "";
                z19 = false;
            } else {
                if (z16 && !valueOf.equals(messageRecord.senderuin)) {
                    qqStr = HardCodeUtil.qqStr(R.string.f153171bd);
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.f153251bl);
                }
                str = "";
                z19 = true;
            }
            str2 = "";
            z26 = false;
            QLog.i(TAG, 1, "addGreyTipsForDeletedMsg. cbannelId: " + messageRecord.frienduin + ", isSelfRevoked: " + z17 + ", isSelfSentMsg: " + z18 + ", canReEdit: " + z26 + ", deletedMsg: " + messageRecord.shmsgseq + ", deletedMsg.msgtype: " + messageRecord.msgtype + ", deletedMsg.senderUin: " + messageRecord.senderuin + ", deletedMsg.msg empty: " + TextUtils.isEmpty(messageRecord.f203106msg) + ", isOperatorAdmin: " + z16 + ", event.op_info.operator_role.has: " + common_event.op_info.operator_role.has() + ", operatorTid: " + common_event.op_info.operator_tinyid.get() + ", needUpdateNick: " + z19 + ", wording: " + qqStr);
            final MessageForGuildRevokeGrayTip messageForGuildRevokeGrayTip2 = new MessageForGuildRevokeGrayTip();
            messageForGuildRevokeGrayTip2.init(messageRecord, qqStr, z26, str2, str, valueOf, z19);
            messageForGuildRevokeGrayTip2.time = System.currentTimeMillis() / 1000;
            if (c.c(messageRecord)) {
            }
            synchronized (this.revokeGrayTipLock) {
            }
        } else {
            QLog.e(TAG, 1, "addGreyTipsForDeletedMsg FAIL. op_info.has: " + common_event.op_info.has() + ", operator_tinyid.has:" + common_event.op_info.operator_tinyid.has() + ", operator_tinyid: " + common_event.op_info.operator_tinyid.get() + ", deletedMr.shmsgseq: " + messageRecord.shmsgseq + ", channelId: " + messageRecord.frienduin);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        if (r0.version.get() >= r1.version.get()) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private common$Event getLastDeleteOrCancelRevokeEvent(List<common$Event> list) {
        Iterator<common$Event> it = list.iterator();
        common$Event common_event = null;
        while (it.hasNext()) {
            common$Event next = it.next();
            long j3 = next.type.get();
            if (j3 == 6 || j3 == 1 || j3 == 2) {
                common_event = next;
            }
        }
        return common_event;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    private void handleDeleteEvent(@Nullable MessageRecord messageRecord, common$Event common_event, String str, String str2, long j3) {
        char c16;
        ?? r56;
        String str3;
        f fVar;
        IGuildMessageBoxDataService iGuildMessageBoxDataService = (IGuildMessageBoxDataService) this.appRuntime.getRuntimeService(IGuildMessageBoxDataService.class, "");
        ChannelMsgEvent channelMsgEvent = new ChannelMsgEvent();
        channelMsgEvent.channelId = str2;
        channelMsgEvent.eventType = 1L;
        channelMsgEvent.msgSeq = j3;
        iGuildMessageBoxDataService.removeChannelMsgBoxReadEvent(channelMsgEvent);
        channelMsgEvent.eventType = 100L;
        iGuildMessageBoxDataService.removeChannelMsgBoxReadEvent(channelMsgEvent);
        IGuildMsgSeqTimeService iGuildMsgSeqTimeService = (IGuildMsgSeqTimeService) this.appRuntime.getRuntimeService(IGuildMsgSeqTimeService.class, "");
        DecreaseMsgSeqInfo decreaseMsgSeqInfo = new DecreaseMsgSeqInfo();
        decreaseMsgSeqInfo.msgSeq = j3;
        if (messageRecord != null) {
            if (((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isAtAllMsg(messageRecord)) {
                decreaseMsgSeqInfo.msgType = DecreaseMsgSeqInfo.MSGTYPE_ATALL;
            }
            if (shouldAddRevokeGrayTip(this.appRuntime, messageRecord, common_event)) {
                addGreyTipsForDeletedMsg(messageRecord, common_event);
            }
            if (messageRecord.msgtype != -2006) {
                ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.appRuntime).F(10014).y(10014).u(messageRecord, false);
                ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).deleteGuildFileManagerEntity(this.appRuntime, messageRecord);
                str3 = str;
                c16 = 0;
                r56 = 1;
                iGuildMsgSeqTimeService.addDecreaseMsgSeq(str3, str2, decreaseMsgSeqInfo);
                ((IGuildLastMsgService) this.appRuntime.getRuntimeService(IGuildLastMsgService.class, "")).onMsgRevoke(str2, j3);
                BusinessHandler businessHandler = ((AppInterface) this.appRuntime).getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildMessageEventHandlerName());
                int i3 = GuildEventFlowObserver.E;
                Object[] objArr = new Object[2];
                objArr[c16] = str2;
                objArr[r56] = messageRecord;
                businessHandler.notifyUI(i3, r56, objArr);
                ((IGuildAioNavigateBarService) this.appRuntime.getRuntimeService(IGuildAioNavigateBarService.class, "")).removeGuildMsgNavigateInfo(str2, j3);
            }
            if (common_event.type.get() == 1) {
                f y16 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.appRuntime).F(10014).y(10014);
                f fVar2 = y16;
                c16 = 0;
                for (MessageRecord messageRecord2 : y16.d0(str2, 10014, j3, j3, new int[]{MessageRecord.MSG_TYPE_GUILD_REVOKE_GRAY_TIP})) {
                    if (messageRecord2 instanceof MessageForGuildRevokeGrayTip) {
                        fVar = fVar2;
                        fVar.s0(messageRecord2.frienduin, messageRecord2.istroop, messageRecord2.uniseq);
                        QLog.d(TAG, 1, "deleteGrayTips shmsgseq = " + messageRecord2.shmsgseq + " uniseq = " + messageRecord2.uniseq);
                    } else {
                        fVar = fVar2;
                    }
                    fVar2 = fVar;
                }
                r56 = 1;
                str3 = str;
                iGuildMsgSeqTimeService.addDecreaseMsgSeq(str3, str2, decreaseMsgSeqInfo);
                ((IGuildLastMsgService) this.appRuntime.getRuntimeService(IGuildLastMsgService.class, "")).onMsgRevoke(str2, j3);
                BusinessHandler businessHandler2 = ((AppInterface) this.appRuntime).getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildMessageEventHandlerName());
                int i36 = GuildEventFlowObserver.E;
                Object[] objArr2 = new Object[2];
                objArr2[c16] = str2;
                objArr2[r56] = messageRecord;
                businessHandler2.notifyUI(i36, r56, objArr2);
                ((IGuildAioNavigateBarService) this.appRuntime.getRuntimeService(IGuildAioNavigateBarService.class, "")).removeGuildMsgNavigateInfo(str2, j3);
            }
        }
        c16 = 0;
        r56 = 1;
        str3 = str;
        iGuildMsgSeqTimeService.addDecreaseMsgSeq(str3, str2, decreaseMsgSeqInfo);
        ((IGuildLastMsgService) this.appRuntime.getRuntimeService(IGuildLastMsgService.class, "")).onMsgRevoke(str2, j3);
        BusinessHandler businessHandler22 = ((AppInterface) this.appRuntime).getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildMessageEventHandlerName());
        int i362 = GuildEventFlowObserver.E;
        Object[] objArr22 = new Object[2];
        objArr22[c16] = str2;
        objArr22[r56] = messageRecord;
        businessHandler22.notifyUI(i362, r56, objArr22);
        ((IGuildAioNavigateBarService) this.appRuntime.getRuntimeService(IGuildAioNavigateBarService.class, "")).removeGuildMsgNavigateInfo(str2, j3);
    }

    private boolean needToAddRevokeGrayTipToAio(f fVar, MessageRecord messageRecord) {
        int size;
        List<MessageRecord> l3 = fVar.l(messageRecord.frienduin, messageRecord.istroop);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("needToAddRevokeGrayTipToAio. aioSize: ");
        if (l3 == null) {
            size = 0;
        } else {
            size = l3.size();
        }
        sb5.append(size);
        QLog.i(TAG, 1, sb5.toString());
        if (l3 == null || l3.size() <= 0) {
            return false;
        }
        long j3 = l3.get(0).shmsgseq;
        QLog.i(TAG, 1, "needToAddRevokeGrayTipToAio. aio firstSeq: " + j3 + ", grayTipSeq: " + messageRecord.shmsgseq);
        if (messageRecord.shmsgseq < j3) {
            return false;
        }
        return true;
    }

    private boolean shouldAddRevokeGrayTip(AppRuntime appRuntime, MessageRecord messageRecord, common$Event common_event) {
        boolean z16;
        boolean z17 = false;
        if (common_event.type.get() == 1) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!((IGuildFeedMsgUtilsApi) QRoute.api(IGuildFeedMsgUtilsApi.class)).isFeedChannel(appRuntime, messageRecord.frienduin)) {
            z17 = z16;
        }
        QLog.i(TAG, 1, "shouldAddRevokeGrayTip: " + z17 + ", shmsgseq: " + messageRecord.shmsgseq + ", channelId: " + messageRecord.frienduin);
        return z17;
    }

    @Override // com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService
    public boolean isGuildRoamMessageEventFlowProcessorNull() {
        if (((x) ((IGuildMsgFactory) this.appRuntime.getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(5)) == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService
    public boolean needUpdateMsgContent(MessageRecord messageRecord, MessageRecord messageRecord2) {
        a.b d16;
        a.b f16;
        a eventFlow = ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getEventFlow(messageRecord2);
        if (eventFlow == null || (d16 = eventFlow.d()) == null || !a.g(d16.f29146a)) {
            return false;
        }
        a eventFlow2 = ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getEventFlow(messageRecord);
        long j3 = 0;
        if (eventFlow2 != null && (f16 = eventFlow2.f(d16.f29146a)) != null) {
            j3 = f16.f29147b;
        }
        if (j3 >= d16.f29148c) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService
    public void onChatMessageExposure(String str, String str2, ArrayList<b> arrayList) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && arrayList != null && !arrayList.isEmpty()) {
            if (!this.channelLogicMaps.containsKey(str2)) {
                this.channelLogicMaps.put(str2, new d((AppInterface) this.appRuntime, str, str2));
            }
            this.channelLogicMaps.get(str2).d(arrayList);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.appRuntime = appRuntime;
    }

    @Override // com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService
    public void onPullRoamMsgEventFlowRsp(boolean z16, ToServiceMsg toServiceMsg, synclogic$ChannelMsgRsp synclogic_channelmsgrsp, ArrayList<common$Msg> arrayList) {
        String string = toServiceMsg.extraData.getString("channelId");
        if (this.channelLogicMaps.containsKey(string)) {
            this.channelLogicMaps.get(string).e(z16, toServiceMsg, synclogic_channelmsgrsp, arrayList);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService
    public boolean processEvent(@Nullable MessageRecord messageRecord, common$Event common_event, String str, String str2, long j3) {
        String str3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("processEvent. channelId: ");
        sb5.append(str2);
        sb5.append(" guildId: ");
        sb5.append(str);
        sb5.append(" shmsgseq: ");
        sb5.append(j3);
        sb5.append(" eventType: ");
        sb5.append(common_event.type.get());
        sb5.append(", findMr: ");
        if (messageRecord != null) {
            str3 = messageRecord.toString();
        } else {
            str3 = "null";
        }
        sb5.append(str3);
        QLog.i(TAG, 1, sb5.toString());
        if (common_event.type.get() != 1 && common_event.type.get() != 2) {
            return false;
        }
        handleDeleteEvent(messageRecord, common_event, str, str2, j3);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService
    public void processEvents(@Nullable MessageRecord messageRecord, List<common$Event> list, String str, String str2, long j3) {
        String messageRecord2;
        common$Event lastDeleteOrCancelRevokeEvent = getLastDeleteOrCancelRevokeEvent(list);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("processEvents. channelId: ");
        sb5.append(str2);
        sb5.append(" guildId: ");
        sb5.append(str);
        sb5.append(" shmsgseq: ");
        sb5.append(j3);
        sb5.append(" events size: ");
        sb5.append(list.size());
        sb5.append(", findMr: ");
        String str3 = "";
        if (messageRecord == null) {
            messageRecord2 = "";
        } else {
            messageRecord2 = messageRecord.toString();
        }
        sb5.append(messageRecord2);
        sb5.append(", lastEvent: ");
        if (lastDeleteOrCancelRevokeEvent != null) {
            str3 = "type=" + lastDeleteOrCancelRevokeEvent.type.get() + MttLoader.QQBROWSER_PARAMS_VERSION + lastDeleteOrCancelRevokeEvent.version.get();
        }
        sb5.append(str3);
        QLog.i(TAG, 1, sb5.toString());
        if (lastDeleteOrCancelRevokeEvent != null) {
            processEvent(messageRecord, lastDeleteOrCancelRevokeEvent, str, str2, j3);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService
    public boolean processUpdateEvent(f fVar, MessageRecord messageRecord, MessageRecord messageRecord2) {
        if (!needUpdateMsgContent(messageRecord, messageRecord2)) {
            return false;
        }
        QLog.d(TAG, 1, "updateMsg channelId: " + messageRecord2.frienduin + ", shmsgseq:" + messageRecord2.shmsgseq + ", msgtype:" + messageRecord2.msgtype + ", extStr" + messageRecord2.extStr);
        fVar.s0(messageRecord.frienduin, 10014, messageRecord.uniseq);
        messageRecord2.updateMsgAnimation = true;
        fVar.c(messageRecord2.frienduin, messageRecord2.istroop, messageRecord2, new al(), true, true, true);
        String str = messageRecord2.frienduin;
        int i3 = messageRecord2.istroop;
        long j3 = messageRecord2.shmsgseq;
        for (MessageRecord messageRecord3 : fVar.d0(str, i3, j3, j3, new int[]{MessageRecord.MSG_TYPE_GUILD_REVOKE_GRAY_TIP})) {
            if (messageRecord3 instanceof MessageForGuildRevokeGrayTip) {
                fVar.s0(messageRecord3.frienduin, messageRecord3.istroop, messageRecord3.uniseq);
            }
        }
        if (messageRecord.msgtype == -2006) {
            IGuildMsgSeqTimeService iGuildMsgSeqTimeService = (IGuildMsgSeqTimeService) this.appRuntime.getRuntimeService(IGuildMsgSeqTimeService.class, "");
            DecreaseMsgSeqInfo decreaseMsgSeqInfo = new DecreaseMsgSeqInfo();
            decreaseMsgSeqInfo.msgSeq = messageRecord2.shmsgseq;
            iGuildMsgSeqTimeService.delDecreaseMsgSeq(messageRecord2.frienduin, decreaseMsgSeqInfo);
        }
        ((IGuildLastMsgService) this.appRuntime.getRuntimeService(IGuildLastMsgService.class, "")).onMsgUpdate(messageRecord2.frienduin, messageRecord2.shmsgseq);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService
    public void updateEventFlowContent(MessageRecord messageRecord, MessageRecord messageRecord2) {
        ((x) ((IGuildMsgFactory) this.appRuntime.getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(5)).K(messageRecord, messageRecord2);
    }

    @Override // com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService
    public boolean updateReplyMsgCommentForSourceMsg(MessageRecord messageRecord, MessageRecord messageRecord2, boolean z16, boolean z17) {
        return ((x) ((IGuildMsgFactory) this.appRuntime.getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(5)).L(messageRecord, messageRecord2, z16, z17);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
