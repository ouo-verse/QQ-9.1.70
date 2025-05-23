package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentInteractAndFollowItem extends RecentMsgBoxItem {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "Q.msg_box.RecentInteractAndFollowItem";
    private int messageType;

    @Override // com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem
    public void d(QQAppInterface qQAppInterface, Context context) {
        MessageForInteractAndFollow messageForInteractAndFollow;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) context);
            return;
        }
        if (qQAppInterface != null && context != null) {
            QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
            MessageRecord messageRecord = this.mData;
            MessageRecord x16 = messageFacade.x1(messageRecord.senderuin, messageRecord.istroop);
            if (x16 instanceof MessageForInteractAndFollow) {
                messageForInteractAndFollow = (MessageForInteractAndFollow) x16;
            } else {
                messageForInteractAndFollow = null;
            }
            if (messageForInteractAndFollow == null) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "messageForInteractAndFollow == null");
                    return;
                }
                return;
            }
            messageForInteractAndFollow.parse();
            int i3 = messageForInteractAndFollow.type;
            this.messageType = i3;
            if (i3 == 1) {
                this.mTitleName = context.getString(R.string.ccy);
            } else if (i3 == 2) {
                this.mTitleName = context.getString(R.string.ccx);
            } else if (i3 == 3) {
                this.mTitleName = context.getString(R.string.ccz);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "RecentInteractAndFollowItem, type  =" + messageForInteractAndFollow.type);
                    return;
                }
                return;
            }
            this.mUnreadFlag = 3;
            this.mDisplayTime = messageForInteractAndFollow.timeStamp;
            ConversationFacade conversationFacade = qQAppInterface.getConversationFacade();
            if (conversationFacade != null) {
                this.mUnreadNum = conversationFacade.R(messageForInteractAndFollow.frienduin, messageForInteractAndFollow.istroop);
            } else {
                this.mUnreadNum = 0;
            }
            MsgSummary msgSummaryTemp = getMsgSummaryTemp();
            msgSummaryTemp.strContent = messageForInteractAndFollow.context;
            extraUpdate(qQAppInterface, context, msgSummaryTemp);
            if (AppSetting.f99565y) {
                StringBuilder sb5 = new StringBuilder(24);
                sb5.append(this.mTitleName);
                int i16 = this.mUnreadNum;
                if (i16 != 0) {
                    if (i16 == 1) {
                        sb5.append("\u6709\u4e00\u6761\u672a\u8bfb");
                    } else if (i16 == 2) {
                        sb5.append("\u6709\u4e24\u6761\u672a\u8bfb");
                    } else if (i16 > 0) {
                        sb5.append("\u6709");
                        sb5.append(this.mUnreadNum);
                        sb5.append("\u6761\u672a\u8bfb");
                    }
                }
                if (this.mMsgExtroInfo != null) {
                    sb5.append(((Object) this.mMsgExtroInfo) + ",");
                }
                sb5.append(this.mLastMsg);
                sb5.append(TokenParser.SP);
                sb5.append(this.mShowTime);
                this.mContentDesc = sb5.toString();
            }
        }
    }
}
