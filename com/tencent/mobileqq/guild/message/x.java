package com.tencent.mobileqq.guild.message;

import android.content.ContentValues;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.synclogic.synclogic$ChannelMsgRsp;

/* compiled from: P */
/* loaded from: classes14.dex */
public class x extends com.tencent.mobileqq.guild.message.base.q {

    /* renamed from: c, reason: collision with root package name */
    private static com.tencent.mobileqq.guild.message.base.i f230882c;

    public x(AppInterface appInterface) {
        super(appInterface);
    }

    private ArrayList<Long> E(long j3, ArrayList<Pair<Long, ArrayList<Long>>> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<Pair<Long, ArrayList<Long>>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<Long, ArrayList<Long>> next = it.next();
                if (j3 == next.first.longValue()) {
                    return next.second;
                }
            }
        }
        return null;
    }

    private void F(ToServiceMsg toServiceMsg, synclogic$ChannelMsgRsp synclogic_channelmsgrsp, ArrayList<common$Msg> arrayList, String str) {
        int size;
        x xVar;
        com.tencent.imcore.message.f fVar;
        x xVar2 = this;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("processRoamEventFlow: size:");
        if (arrayList == null) {
            size = 0;
        } else {
            size = arrayList.size();
        }
        sb5.append(size);
        QLog.i("BaseGuildMessageProcessor.GuildRoamMessageEventFlowProcessor", 1, sb5.toString());
        if (synclogic_channelmsgrsp == null) {
            QLog.e("BaseGuildMessageProcessor.GuildRoamMessageEventFlowProcessor", 1, "channelMsgRsp is null!");
            return;
        }
        int i3 = 10014;
        com.tencent.imcore.message.f y16 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) xVar2.f230314a).F(10014).y(10014);
        String string = toServiceMsg.extraData.getString("channelId");
        xVar2.N(string, toServiceMsg, synclogic_channelmsgrsp);
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<common$Msg> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.addAll(e(it.next(), str, new com.tencent.mobileqq.troop.data.c(), synclogic_channelmsgrsp.get_msg_time.get()));
            }
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                MessageRecord messageRecord = (MessageRecord) it5.next();
                MessageRecord f06 = y16.f0(messageRecord.frienduin, i3, messageRecord.shmsgseq);
                if (f06 != null) {
                    QLog.i("BaseGuildMessageProcessor.GuildRoamMessageEventFlowProcessor", 1, "updateDB: channelId: " + string + ", shmsgseq: " + f06.shmsgseq + ", findMr.msgtype:" + f06.msgtype + ", findMr.extStr: " + f06.extStr + ", mr.msgtype: " + messageRecord.msgtype + ", mr.extStr: " + messageRecord.extStr + " get_msg_time:" + synclogic_channelmsgrsp.get_msg_time.get());
                    xVar = this;
                    fVar = y16;
                    if (!((IGuildEventFlowService) ((BaseQQAppInterface) xVar.f230314a).getRuntimeService(IGuildEventFlowService.class)).processUpdateEvent(fVar, f06, messageRecord)) {
                        xVar.K(f06, messageRecord);
                        QLog.i("BaseGuildMessageProcessor.GuildRoamMessageEventFlowProcessor", 1, "after updateBusinessFields: channelId: " + string + ", shmsgseq: " + f06.shmsgseq + ", findMr.extStr: " + f06.extStr);
                        xVar.J(f06);
                        ((IMessageFacade) xVar.f230314a.getRuntimeService(IMessageFacade.class, "")).cancelNotificationWhenRevokeMessage(f06);
                    }
                } else {
                    xVar = xVar2;
                    fVar = y16;
                    ArrayList<Pair<Long, ArrayList<Long>>> arrayList3 = new ArrayList<>();
                    Bundle bundle = toServiceMsg.extraData.getBundle("context");
                    if (bundle != null) {
                        Serializable serializable = bundle.getSerializable("msgevent_comment_list");
                        if (serializable instanceof ArrayList) {
                            arrayList3 = (ArrayList) serializable;
                        }
                    }
                    ArrayList<Long> E = xVar.E(messageRecord.shmsgseq, arrayList3);
                    if (E != null && E.size() > 0) {
                        QLog.i("BaseGuildMessageProcessor.GuildRoamMessageEventFlowProcessor", 1, "processCommentEvent self: channelId: " + string + " can not find in db savetodb mr:" + messageRecord.toString());
                        fVar.d(new ArrayList(Arrays.asList(messageRecord)), null);
                    }
                }
                y16 = fVar;
                i3 = 10014;
                xVar2 = xVar;
            }
            xVar2.f230314a.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildMessageEventHandlerName()).notifyUI(GuildEventFlowObserver.f230089i, true, new Object[]{string, toServiceMsg, synclogic_channelmsgrsp, arrayList2});
            return;
        }
        QLog.i("BaseGuildMessageProcessor.GuildRoamMessageEventFlowProcessor", 1, "msgs is empty!");
    }

    private void G(MessageRecord messageRecord) {
        com.tencent.imcore.message.f y16 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230314a).F(10014).y(10014);
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
        y16.F0(messageRecord.frienduin, 10014, messageRecord.uniseq, contentValues);
    }

    public static void H(com.tencent.mobileqq.guild.message.base.r rVar) {
        if (rVar instanceof com.tencent.mobileqq.guild.message.base.i) {
            f230882c = (com.tencent.mobileqq.guild.message.base.i) rVar;
        }
    }

    private void J(MessageRecord messageRecord) {
        com.tencent.imcore.message.f y16 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230314a).F(10014).y(10014);
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
        contentValues.put(AppConstants.Key.COLUMN_MSG_TYPE, Integer.valueOf(messageRecord.msgtype));
        y16.F0(messageRecord.frienduin, 10014, messageRecord.uniseq, contentValues);
    }

    private void M(MessageRecord messageRecord, MessageRecord messageRecord2) {
        if (messageRecord != null && messageRecord2 != null) {
            messageRecord.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_SELF_COMMENT_INFO, messageRecord2.getExtInfoFromExtStr(IGuildMessageUtilsApi.MSG_SELF_COMMENT_INFO));
        }
    }

    public void I(MessageRecord messageRecord, MessageRecord messageRecord2) {
        messageRecord.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_ENOJ_REACTION, messageRecord2.getExtInfoFromExtStr(IGuildMessageUtilsApi.MSG_ENOJ_REACTION));
        M(messageRecord, messageRecord2);
    }

    public void K(MessageRecord messageRecord, MessageRecord messageRecord2) {
        if (messageRecord != null && messageRecord2 != null) {
            messageRecord.msgtype = messageRecord2.msgtype;
            IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
            bu1.a eventFlow = iGuildMessageUtilsApi.getEventFlow(messageRecord2);
            if (eventFlow != null) {
                iGuildMessageUtilsApi.saveEventFlowToMsg(messageRecord, eventFlow);
            }
            I(messageRecord, messageRecord2);
        }
    }

    public boolean L(MessageRecord messageRecord, MessageRecord messageRecord2, boolean z16, boolean z17) {
        boolean updateReplyMsgCommentForSourceMsg = ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).updateReplyMsgCommentForSourceMsg(messageRecord, messageRecord2, z16, z17);
        if (updateReplyMsgCommentForSourceMsg) {
            G(messageRecord);
        }
        return updateReplyMsgCommentForSourceMsg;
    }

    public void N(String str, ToServiceMsg toServiceMsg, synclogic$ChannelMsgRsp synclogic_channelmsgrsp) {
        com.tencent.imcore.message.f y16 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230314a).F(10014).y(10014);
        IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
        long j3 = toServiceMsg.extraData.getLong("lEndSeq");
        for (long j16 = toServiceMsg.extraData.getLong("lBeginSeq"); j16 <= j3; j16++) {
            MessageRecord f06 = y16.f0(str, 10014, j16);
            if (f06 != null) {
                QLog.i("BaseGuildMessageProcessor.GuildRoamMessageEventFlowProcessor", 1, "saveSyncTimeToMsg: channelId: " + str + ", shmsgseq: " + f06.shmsgseq + ", get_msg_time:" + synclogic_channelmsgrsp.get_msg_time.get() + ", findMr.extStr: " + f06.extStr);
                iGuildMessageUtilsApi.saveSyncTimeToMsg(f06, synclogic_channelmsgrsp.get_msg_time.get());
                G(f06);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.base.s
    public void a(Object... objArr) {
        if (objArr != null && objArr.length == 4) {
            ArrayList<common$Msg> arrayList = new ArrayList<>();
            w((ArrayList) objArr[2], arrayList);
            F((ToServiceMsg) objArr[0], (synclogic$ChannelMsgRsp) objArr[1], arrayList, (String) objArr[3]);
            return;
        }
        n(getClass().getName());
    }
}
