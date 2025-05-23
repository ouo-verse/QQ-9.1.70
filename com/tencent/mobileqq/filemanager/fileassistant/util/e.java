package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.q;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private DataLineMsgRecord f208067a;

    /* renamed from: b, reason: collision with root package name */
    private QQAppInterface f208068b;

    /* renamed from: c, reason: collision with root package name */
    private String f208069c;

    public e(QQAppInterface qQAppInterface) {
        this.f208068b = qQAppInterface;
        if (TextUtils.isEmpty(this.f208069c)) {
            this.f208069c = AppConstants.DATALINE_NEW_VERSION_UIN;
        }
    }

    private int a() {
        int i3 = this.f208067a.msgtype;
        if (i3 == -2009 || i3 == -2000 || i3 == -2005 || i3 == -2009) {
            return -2005;
        }
        return -1000;
    }

    private MessageForDLFile c() {
        MessageForDLFile messageForDLFile = (MessageForDLFile) q.d(-3017);
        DataLineMsgRecord dataLineMsgRecord = this.f208067a;
        long j3 = dataLineMsgRecord.sessionid;
        messageForDLFile.uniseq = j3;
        messageForDLFile.msgseq = dataLineMsgRecord.msgseq;
        messageForDLFile.shmsgseq = dataLineMsgRecord.shmsgseq;
        messageForDLFile.fileName = dataLineMsgRecord.filename;
        messageForDLFile.fileSize = dataLineMsgRecord.filesize;
        messageForDLFile.associatedId = j3;
        messageForDLFile.deviceType = DataLineMsgRecord.getDevTypeBySeId(j3);
        messageForDLFile.serial();
        QLog.i("DatalineMsgTransformer", 1, "transformForTextMessage: msg[" + messageForDLFile.associatedId + "] time[" + messageForDLFile.time + "]");
        return messageForDLFile;
    }

    private MessageForText d() {
        MessageForText messageForText = (MessageForText) q.d(-1000);
        DataLineMsgRecord dataLineMsgRecord = this.f208067a;
        messageForText.f203106msg = dataLineMsgRecord.f203106msg;
        messageForText.msgtype = -1000;
        messageForText.issend = dataLineMsgRecord.issend;
        messageForText.isread = true;
        messageForText.time = dataLineMsgRecord.time;
        if (dataLineMsgRecord.msgtype != -1000) {
            messageForText.f203106msg = "";
        }
        QLog.i("DatalineMsgTransformer", 1, "transformForTextMessage: msg[" + messageForText.f203106msg + "] time[" + messageForText.time + "]");
        return messageForText;
    }

    public void b(DataLineMsgRecord dataLineMsgRecord) {
        this.f208067a = dataLineMsgRecord;
    }

    public ChatMessage e() {
        ChatMessage d16 = d();
        if (-2005 == a()) {
            d16 = c();
        }
        d16.selfuin = this.f208068b.getCurrentAccountUin();
        String str = this.f208069c;
        d16.frienduin = str;
        d16.senderuin = str;
        d16.msgUid = FileManagerUtil.genMsgUid();
        d16.shmsgseq = FileManagerUtil.genMsgSeq();
        int i3 = this.f208067a.dataline_type;
        int i16 = 65793;
        if (i3 != 0 && i3 == 1) {
            i16 = Friends.TERM_TYPE_MOBILE_IPAD;
        }
        h.x(d16, i16);
        d16.saveExtInfoToExtStr("dataline_old_msg", "1");
        return d16;
    }
}
