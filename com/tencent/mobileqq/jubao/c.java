package com.tencent.mobileqq.jubao;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dt.api.JubaoMsgData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.s;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static JubaoMsgData a(@NonNull AIOMsgItem aIOMsgItem) {
        MsgRecord msgRecord = aIOMsgItem.getMsgRecord();
        JubaoMsgData jubaoMsgData = new JubaoMsgData();
        int chatType = msgRecord.getChatType();
        jubaoMsgData.msgID = msgRecord.getMsgId();
        if (chatType != 2 && chatType != 3) {
            int g16 = s.g(msgRecord.getMsgRandom());
            jubaoMsgData.msgSeq = ((short) msgRecord.getMsgSeq()) & 65535;
            jubaoMsgData.msgTime = (int) msgRecord.getMsgTime();
            jubaoMsgData.msgRandom = g16;
        } else {
            jubaoMsgData.msgSeq = (int) msgRecord.getMsgSeq();
        }
        return jubaoMsgData;
    }

    public static JubaoMsgData b(@NonNull MessageRecord messageRecord) {
        JubaoMsgData jubaoMsgData = new JubaoMsgData();
        jubaoMsgData.msgID = messageRecord.uniseq;
        int i3 = messageRecord.istroop;
        if (i3 != 1 && i3 != 3000) {
            if (i3 == 10014) {
                jubaoMsgData.msgSeq = (int) messageRecord.shmsgseq;
                if (!TextUtils.isEmpty(messageRecord.frienduin)) {
                    jubaoMsgData.channelUin = NewReportPlugin.j(messageRecord.frienduin, NewReportPlugin.p(1));
                }
            } else {
                int g16 = s.g(messageRecord.msgUid);
                jubaoMsgData.msgSeq = ((short) messageRecord.shmsgseq) & 65535;
                jubaoMsgData.msgTime = (int) messageRecord.time;
                jubaoMsgData.msgRandom = g16;
            }
        } else {
            jubaoMsgData.msgSeq = (int) messageRecord.shmsgseq;
        }
        return jubaoMsgData;
    }
}
