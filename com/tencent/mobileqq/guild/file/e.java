package com.tencent.mobileqq.guild.file;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;

/* compiled from: P */
/* loaded from: classes33.dex */
public class e {

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final e f224402a = new e();
    }

    private boolean a(QQAppInterface qQAppInterface, String str, msg_comm$MsgHead msg_comm_msghead) {
        msg_comm_msghead.msg_seq.get();
        long j3 = msg_comm_msghead.msg_uid.get();
        List<MessageRecord> msgList = ((IMessageFacade) qQAppInterface.getRuntimeService(IMessageFacade.class, "")).getMsgList(str, 10014);
        if (msgList == null) {
            return false;
        }
        for (MessageRecord messageRecord : msgList) {
            if (messageRecord != null && messageRecord.msgUid == j3 && qQAppInterface.getFileManagerDataCenter().E(messageRecord.uniseq, str, 10014) != null) {
                return true;
            }
        }
        return false;
    }

    private boolean b(QQAppInterface qQAppInterface, String str, msg_comm$MsgHead msg_comm_msghead, com.tencent.mobileqq.guild.file.a aVar) {
        long j3 = msg_comm_msghead.msg_seq.get();
        long j16 = msg_comm_msghead.msg_uid.get();
        for (MessageRecord messageRecord : ((st1.h) qQAppInterface.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName())).n2()) {
            if (messageRecord != null && messageRecord.msgUid == j16) {
                FileManagerEntity E = qQAppInterface.getFileManagerDataCenter().E(messageRecord.uniseq, str, 10014);
                if (E != null) {
                    E.msgSeq = j3;
                    E.lastTime = aVar.f224379m;
                    qQAppInterface.getFileManagerDataCenter().f0(E);
                    return true;
                }
            }
        }
        return false;
    }

    public static e c() {
        return a.f224402a;
    }

    private FileManagerEntity e(QQAppInterface qQAppInterface, MessageForFile messageForFile, com.tencent.mobileqq.guild.file.a aVar, msg_comm$MsgHead msg_comm_msghead, String str) {
        String str2;
        long j3 = msg_comm_msghead.msg_seq.get();
        long j16 = msg_comm_msghead.msg_uid.get();
        long j17 = msg_comm_msghead.msg_time.get();
        String str3 = "";
        String selfTinyId = ((IGPSService) qQAppInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        qQAppInterface.getFileManagerProxy().x(fileManagerEntity);
        fileManagerEntity.uniseq = messageForFile.uniseq;
        fileManagerEntity.guildId = aVar.f224367a;
        fileManagerEntity.channelId = aVar.f224368b;
        fileManagerEntity.Uuid = aVar.f224377k;
        fileManagerEntity.nSessionId = FileManagerUtil.genSessionId().longValue();
        fileManagerEntity.selfUin = qQAppInterface.getAccount();
        fileManagerEntity.status = -1;
        fileManagerEntity.fileSize = aVar.f224376j;
        fileManagerEntity.srvTime = j17 * 1000;
        String str4 = aVar.f224375i;
        fileManagerEntity.fileName = str4;
        fileManagerEntity.nFileType = FileManagerUtil.getFileType(str4);
        fileManagerEntity.setCloudType(12);
        fileManagerEntity.msgSeq = j3;
        fileManagerEntity.msgUid = j16;
        fileManagerEntity.peerType = 10014;
        fileManagerEntity.peerUin = aVar.f224368b;
        fileManagerEntity.lastTime = aVar.f224379m;
        fileManagerEntity.bSend = !TextUtils.isEmpty(str) && str.equals(selfTinyId);
        fileManagerEntity.nOpType = 53;
        fileManagerEntity.imgWidth = aVar.f224380n;
        fileManagerEntity.imgHeight = aVar.f224381o;
        IGPSService iGPSService = (IGPSService) qQAppInterface.getRuntimeService(IGPSService.class, "");
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(aVar.f224367a);
        if (guildInfo == null) {
            str2 = "";
        } else {
            str2 = guildInfo.getGuildName();
        }
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(aVar.f224368b);
        if (channelInfo != null) {
            str3 = channelInfo.getChannelName();
        }
        fileManagerEntity.peerNick = str2;
        fileManagerEntity.guildName = str2;
        fileManagerEntity.channelName = str3;
        qQAppInterface.getFileManagerDataCenter().t(fileManagerEntity);
        return fileManagerEntity;
    }

    private void f(QQAppInterface qQAppInterface, MessageForFile messageForFile, com.tencent.mobileqq.guild.file.a aVar, FileManagerEntity fileManagerEntity) {
        messageForFile.init(qQAppInterface.getCurrentAccountUin(), aVar.f224368b, ((IGPSService) qQAppInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId(), "", fileManagerEntity.srvTime, -2005, 10014, fileManagerEntity.msgSeq);
        messageForFile.f203106msg = TransfileUtile.makeTransFileProtocolData(aVar.f224375i, aVar.f224376j, 0, true);
        messageForFile.msgUid = fileManagerEntity.msgUid;
        messageForFile.fileName = fileManagerEntity.fileName;
        messageForFile.fileSize = fileManagerEntity.fileSize;
        messageForFile.filePath = "";
    }

    public void d(QQAppInterface qQAppInterface, MessageForFile messageForFile, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.guild.file.a aVar, com.tencent.mobileqq.service.message.a aVar2) {
        if (messageForFile != null && msg_comm_msg != null && aVar != null) {
            msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
            if (b(qQAppInterface, aVar.f224368b, msg_comm_msghead, aVar) || a(qQAppInterface, aVar.f224368b, msg_comm_msghead)) {
                return;
            }
            f(qQAppInterface, messageForFile, aVar, e(qQAppInterface, messageForFile, aVar, msg_comm_msghead, String.valueOf(aVar2.f286149d)));
            return;
        }
        QLog.e("GuildFilePBDecoderHelper", 1, "handleGuildFileMsg args error !");
    }
}
