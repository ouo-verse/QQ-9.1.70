package com.tencent.mobileqq.matchchat;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RecentMatchChatListItem extends RecentBaseData {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "expand.RecentMatchChatListItem";
    public int age;
    public int career;
    public int charmLevel;

    /* renamed from: common, reason: collision with root package name */
    public String f243786common;
    public int constellation;
    public int gender;
    public boolean mExtendFriendOnline;
    public boolean mHasFlowerMsg;
    public MessageRecord messageRecord;
    public int vip;

    public RecentMatchChatListItem(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) messageRecord);
            return;
        }
        this.vip = -1;
        this.age = -1;
        this.gender = -1;
        this.career = -1;
        this.constellation = -1;
        this.mHasFlowerMsg = false;
        if (messageRecord != null) {
            this.messageRecord = messageRecord;
            return;
        }
        throw new NullPointerException("RecentMatchChatListItem data is null");
    }

    public void a(QQAppInterface qQAppInterface, MsgSummary msgSummary) {
        DraftSummaryInfo draftSummaryInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) qQAppInterface, (Object) msgSummary);
            return;
        }
        if (msgSummary != null) {
            msgSummary.bShowDraft = false;
            msgSummary.mDraft = null;
        }
        QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
        if (messageFacade != null && (draftSummaryInfo = messageFacade.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType())) != null && !TextUtils.isEmpty(draftSummaryInfo.getSummary())) {
            long time = draftSummaryInfo.getTime();
            if (this.mDisplayTime > time) {
                return;
            }
            this.mDisplayTime = time;
            if (msgSummary != null) {
                msgSummary.bShowDraft = true;
                msgSummary.mDraft = new QQText(draftSummaryInfo.getSummary(), 3, 16);
            }
        }
    }

    public MsgSummary b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MsgSummary) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.msgSummary;
    }

    public void c(QQAppInterface qQAppInterface, Context context) {
        Message message;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) qQAppInterface, (Object) context);
            return;
        }
        QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
        ConversationFacade conversationFacade = qQAppInterface.getConversationFacade();
        if (messageFacade != null) {
            message = messageFacade.getLastMessage(getRecentUserUin(), getRecentUserType());
        } else {
            message = null;
        }
        this.mExtraInfoColor = 0;
        this.mMsgExtroInfo = null;
        if (message != null) {
            this.mDisplayTime = message.time;
            if (conversationFacade != null) {
                this.mUnreadNum = conversationFacade.R(message.frienduin, message.istroop);
            } else {
                this.mUnreadNum = 0;
            }
            if (ao.B(message)) {
                this.mUnreadFlag = 3;
            }
        } else {
            this.mUnreadNum = 0;
            this.mDisplayTime = 0L;
        }
        MsgSummary msgSummaryTemp = super.getMsgSummaryTemp();
        super.buildMessageBody(message, getRecentUserType(), qQAppInterface, context, msgSummaryTemp);
        this.mHasFlowerMsg = false;
        this.mTitleName = ac.g(qQAppInterface, getRecentUserUin(), true);
        this.mAuthenIconId = 0;
        super.dealStatus(qQAppInterface);
        a(qQAppInterface, msgSummaryTemp);
        super.extraUpdate(qQAppInterface, context, msgSummaryTemp);
        if (AppSetting.f99565y) {
            StringBuilder sb5 = new StringBuilder(24);
            sb5.append(this.mTitleName);
            int i3 = this.mUnreadNum;
            if (i3 == 1) {
                sb5.append(context.getResources().getString(R.string.iyf));
            } else if (i3 == 2) {
                sb5.append(context.getResources().getString(R.string.iyg));
            } else if (i3 > 0) {
                sb5.append(context.getResources().getString(R.string.iye, Integer.valueOf(this.mUnreadNum)));
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

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public void dealDraft(BaseQQAppInterface baseQQAppInterface, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) baseQQAppInterface, (Object) msgSummary);
        } else if (baseQQAppInterface instanceof QQAppInterface) {
            a((QQAppInterface) baseQQAppInterface, msgSummary);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public long getLastDraftTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public long getLastMsgTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.messageRecord.time;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public int getRecentUserType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.messageRecord.istroop;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public String getRecentUserUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.messageRecord.senderuin;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public void update(BaseQQAppInterface baseQQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) baseQQAppInterface, (Object) context);
            return;
        }
        if (baseQQAppInterface instanceof QQAppInterface) {
            c((QQAppInterface) baseQQAppInterface, context);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "msg update");
        }
    }
}
