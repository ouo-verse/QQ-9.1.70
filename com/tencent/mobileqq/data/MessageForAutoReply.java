package com.tencent.mobileqq.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fts.v2.entity.notColumn;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForAutoReply extends MessageForText {
    public static final String ROOT_TAG = "[AutoReply] ";
    private static final String TAG = "[AutoReply] MessageForAutoReply";

    @notColumn
    public boolean needShowTail = false;

    @notColumn
    public boolean needClickAction = true;

    public MessageForAutoReply() {
        this.msgtype = -10000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageForText, com.tencent.mobileqq.data.RecommendCommonMessage, com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        super.doParse();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            boolean a16 = com.tencent.mobileqq.relationx.onewayfriend.a.a((QQAppInterface) runtime, this.istroop, this.frienduin);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[message] doParse: invoked. ", " oneWayFriend: ", Boolean.valueOf(a16), " istroop: ", Integer.valueOf(this.istroop), " frienduin: ", this.frienduin, " senderuin: ", this.senderuin);
            }
            if (this.istroop == 0 && !a16) {
                this.needShowTail = true;
            } else {
                this.needShowTail = false;
                this.charStr = this.f203106msg;
            }
        }
    }
}
