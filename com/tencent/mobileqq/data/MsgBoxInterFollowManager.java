package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dating.h;
import com.tencent.mobileqq.dating.i;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import tencent.im.s2c.msgtype0x210.submsgtype0xd7.SubMsgType0xd7$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xfe.submsgtype0xfe$MsgBody;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MsgBoxInterFollowManager implements Manager {
    public QQAppInterface app;
    public int msgboxUnreadCount;

    public MsgBoxInterFollowManager(QQAppInterface qQAppInterface) {
        this.app = qQAppInterface;
        this.msgboxUnreadCount = ea.o0(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin());
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x010f, code lost:
    
        if (com.tencent.mobileqq.utils.ea.A0(r5.app.getApp(), r5.app.getCurrentAccountUin(), r3.senderuin) == 0) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addMessage(String str, int i3, int i16, long j3, int i17) {
        if (i17 != 1 && i17 != 2) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.msg_box.MsgBoxInterFollowManager", 2, "type=" + i17);
                return;
            }
            return;
        }
        final MessageForInteractAndFollow messageForInteractAndFollow = (MessageForInteractAndFollow) q.d(MessageRecord.MSG_TYPE_INTERACT_AND_FOLLOW);
        messageForInteractAndFollow.rawContext = str;
        messageForInteractAndFollow.context = i.d(str, 14);
        messageForInteractAndFollow.unReadCount = i16;
        messageForInteractAndFollow.msgBoxUnreadCount = i3;
        messageForInteractAndFollow.timeStamp = j3;
        messageForInteractAndFollow.msgseq = j3;
        messageForInteractAndFollow.type = i17;
        messageForInteractAndFollow.time = j3;
        messageForInteractAndFollow.shmsgseq = j3;
        messageForInteractAndFollow.msgUid = j3;
        messageForInteractAndFollow.selfuin = this.app.getCurrentAccountUin();
        messageForInteractAndFollow.istroop = 10002;
        messageForInteractAndFollow.senderuin = messageForInteractAndFollow.type == 1 ? AppConstants.MSG_BOX_INTERACT_UIN : AppConstants.MSG_BOX_FOLLOW_UIN;
        messageForInteractAndFollow.frienduin = AppConstants.LBS_HELLO_UIN;
        messageForInteractAndFollow.getBytes();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(20);
            sb5.append("msgBoxUnreadCount=");
            sb5.append(messageForInteractAndFollow.msgBoxUnreadCount);
            sb5.append(",unReadCount=");
            sb5.append(messageForInteractAndFollow.unReadCount);
            sb5.append(",context=");
            sb5.append((CharSequence) messageForInteractAndFollow.context);
            sb5.append("timeStamp=");
            sb5.append(messageForInteractAndFollow.timeStamp);
            sb5.append(",msgseq=");
            sb5.append(messageForInteractAndFollow.msgseq);
            sb5.append(",shmsgseq=");
            sb5.append(messageForInteractAndFollow.shmsgseq);
            sb5.append(",msgUid=");
            sb5.append(messageForInteractAndFollow.msgUid);
            sb5.append(",senderuin=");
            sb5.append(messageForInteractAndFollow.senderuin);
            QLog.i("Q.msg_box.MsgBoxInterFollowManager", 2, sb5.toString());
        }
        boolean z16 = false;
        if (messageForInteractAndFollow.unReadCount > 0) {
            if (ea.A0(this.app.getApp(), this.app.getCurrentAccountUin(), messageForInteractAndFollow.senderuin) == 1) {
                ea.r4(this.app.getApp(), this.app.getCurrentAccountUin(), messageForInteractAndFollow.senderuin, 0);
            }
        }
        z16 = true;
        if (z16) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.data.MsgBoxInterFollowManager.2
                @Override // java.lang.Runnable
                public void run() {
                    MsgBoxInterFollowManager.this.addMessage(messageForInteractAndFollow);
                }
            }, 8, null, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00e9, code lost:
    
        if (com.tencent.mobileqq.utils.ea.A0(r2.app.getApp(), r2.app.getCurrentAccountUin(), r0.senderuin) == 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addMomentMessage(String str, int i3, int i16, long j3) {
        final MessageForInteractAndFollow messageForInteractAndFollow = (MessageForInteractAndFollow) q.d(MessageRecord.MSG_TYPE_INTERACT_AND_FOLLOW);
        messageForInteractAndFollow.rawContext = str;
        messageForInteractAndFollow.context = i.d(str, 14);
        messageForInteractAndFollow.unReadCount = i16;
        messageForInteractAndFollow.msgBoxUnreadCount = i3;
        messageForInteractAndFollow.timeStamp = j3;
        messageForInteractAndFollow.msgseq = j3;
        messageForInteractAndFollow.type = 3;
        messageForInteractAndFollow.time = j3;
        messageForInteractAndFollow.shmsgseq = j3;
        messageForInteractAndFollow.msgUid = j3;
        messageForInteractAndFollow.selfuin = this.app.getCurrentAccountUin();
        messageForInteractAndFollow.istroop = 1001;
        messageForInteractAndFollow.senderuin = AppConstants.MSG_BOX_MYMOMMENT_UIN;
        messageForInteractAndFollow.frienduin = AppConstants.LBS_HELLO_UIN;
        messageForInteractAndFollow.getBytes();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(20);
            sb5.append("msgBoxUnreadCount=");
            sb5.append(messageForInteractAndFollow.msgBoxUnreadCount);
            sb5.append(",unReadCount=");
            sb5.append(messageForInteractAndFollow.unReadCount);
            sb5.append(",context=");
            sb5.append((CharSequence) messageForInteractAndFollow.context);
            sb5.append("timeStamp=");
            sb5.append(messageForInteractAndFollow.timeStamp);
            sb5.append(",msgseq=");
            sb5.append(messageForInteractAndFollow.msgseq);
            sb5.append(",shmsgseq=");
            sb5.append(messageForInteractAndFollow.shmsgseq);
            sb5.append(",msgUid=");
            sb5.append(messageForInteractAndFollow.msgUid);
            sb5.append(",senderuin=");
            sb5.append(messageForInteractAndFollow.senderuin);
            QLog.i("Q.msg_box.MsgBoxInterFollowManager", 2, sb5.toString());
        }
        boolean z16 = false;
        if (messageForInteractAndFollow.unReadCount > 0) {
            if (ea.A0(this.app.getApp(), this.app.getCurrentAccountUin(), messageForInteractAndFollow.senderuin) == 1) {
                ea.r4(this.app.getApp(), this.app.getCurrentAccountUin(), messageForInteractAndFollow.senderuin, 0);
            }
        }
        z16 = true;
        if (z16) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.data.MsgBoxInterFollowManager.1
                @Override // java.lang.Runnable
                public void run() {
                    MsgBoxInterFollowManager.this.addMessage(messageForInteractAndFollow);
                }
            }, 8, null, true);
        }
    }

    public void clearMsgBoxUnreadCount() {
        if (this.msgboxUnreadCount > 0) {
            this.msgboxUnreadCount = 0;
            h.b(this.app, 0, null);
            ea.i4(this.app.getApp(), this.app.getCurrentAccountUin(), 0);
        }
    }

    public void decode0xd7InteractAndFollowMsg(byte[] bArr) {
        SubMsgType0xd7$MsgBody subMsgType0xd7$MsgBody = new SubMsgType0xd7$MsgBody();
        try {
            subMsgType0xd7$MsgBody.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg_box.MsgBoxInterFollowManager", 2, "decode0xd7InteractAndFollowMsg decode failed:" + e16.toString(), e16);
            }
        }
        StringBuilder sb5 = new StringBuilder();
        if (subMsgType0xd7$MsgBody.msg_content.bytes_from_user.has()) {
            sb5.append(subMsgType0xd7$MsgBody.msg_content.bytes_from_user.get().toStringUtf8());
        }
        if (subMsgType0xd7$MsgBody.msg_content.bytes_buluo_word.has()) {
            sb5.append(i.a(i.e(subMsgType0xd7$MsgBody.msg_content.bytes_buluo_word.get().toStringUtf8())));
        } else if (subMsgType0xd7$MsgBody.msg_content.rich_fresh_word.has()) {
            sb5.append((CharSequence) i.b(subMsgType0xd7$MsgBody.msg_content.rich_fresh_word.get()));
        } else {
            sb5.append(subMsgType0xd7$MsgBody.msg_content.bytes_plain_text.get().toStringUtf8());
        }
        if (subMsgType0xd7$MsgBody.uint32_msgbox_unread_count.has()) {
            this.msgboxUnreadCount = subMsgType0xd7$MsgBody.uint32_msgbox_unread_count.get();
            ea.i4(this.app.getApp(), this.app.getCurrentAccountUin(), subMsgType0xd7$MsgBody.uint32_msgbox_unread_count.get());
        }
        addMessage(sb5.toString(), subMsgType0xd7$MsgBody.uint32_msgbox_unread_count.get(), subMsgType0xd7$MsgBody.uint32_unread_count.get(), subMsgType0xd7$MsgBody.uint64_timestamp.get(), subMsgType0xd7$MsgBody.uint32_type.get());
    }

    public void decode0xfeInteractAndFollowMsg(byte[] bArr) {
        submsgtype0xfe$MsgBody submsgtype0xfe_msgbody = new submsgtype0xfe$MsgBody();
        try {
            submsgtype0xfe_msgbody.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg_box.MsgBoxInterFollowManager", 2, "decode0xd7InteractAndFollowMsg decode failed:" + e16.toString(), e16);
            }
        }
        if (submsgtype0xfe_msgbody.uint32_box_unread_num.has()) {
            this.msgboxUnreadCount = submsgtype0xfe_msgbody.uint32_box_unread_num.get();
            ea.i4(this.app.getApp(), this.app.getCurrentAccountUin(), submsgtype0xfe_msgbody.uint32_box_unread_num.get());
        }
        addMomentMessage(submsgtype0xfe_msgbody.bytes_wording.get().toStringUtf8(), submsgtype0xfe_msgbody.uint32_box_unread_num.get(), submsgtype0xfe_msgbody.uint32_inner_unread_num.get(), submsgtype0xfe_msgbody.uint32_update_time.get());
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.msgboxUnreadCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMessage(MessageForInteractAndFollow messageForInteractAndFollow) {
        MessageRecord x16 = this.app.getMessageFacade().x1(messageForInteractAndFollow.senderuin, messageForInteractAndFollow.istroop);
        if (x16 != null) {
            this.app.getMessageFacade().T1(x16.senderuin, x16.istroop, x16.uniseq);
            this.app.getMessageFacade().c(messageForInteractAndFollow, this.app.getCurrentAccountUin());
        } else {
            this.app.getMessageFacade().c(messageForInteractAndFollow, this.app.getCurrentAccountUin());
        }
    }
}
