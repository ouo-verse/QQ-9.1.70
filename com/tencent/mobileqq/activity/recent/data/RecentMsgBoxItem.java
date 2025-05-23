package com.tencent.mobileqq.activity.recent.data;

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
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ac;
import com.tencent.nowsummarycard.NowSummaryCard$MiniCard;
import com.tencent.qphone.base.util.QLog;
import org.apache.httpcore.message.TokenParser;
import u92.e;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentMsgBoxItem extends RecentBaseData {
    static IPatchRedirector $redirector_;
    public MessageRecord mData;
    public int mFromFlag;
    public boolean mHasFlowerMsg;

    private String c(QQAppInterface qQAppInterface, Message message) {
        boolean z16;
        String j3;
        if (message != null && message.istroop == 1001) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && e.a(getRecentUserUin())) {
            j3 = ((NowSummaryCard$MiniCard) e.b(getRecentUserUin())).nick.get();
        } else {
            j3 = ac.j(qQAppInterface, getRecentUserUin());
        }
        if (TextUtils.isEmpty(j3) && !z16) {
            j3 = ac.g(qQAppInterface, getRecentUserUin(), false);
        }
        if (TextUtils.isEmpty(j3)) {
            return getRecentUserUin();
        }
        return j3;
    }

    public void a(QQAppInterface qQAppInterface, MsgSummary msgSummary) {
        DraftSummaryInfo draftSummaryInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) qQAppInterface, (Object) msgSummary);
            return;
        }
        if (msgSummary == null) {
            return;
        }
        msgSummary.bShowDraft = false;
        msgSummary.mDraft = null;
        QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
        if (messageFacade != null && (draftSummaryInfo = messageFacade.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType())) != null && !TextUtils.isEmpty(draftSummaryInfo.getSummary())) {
            long time = draftSummaryInfo.getTime();
            if (this.mDisplayTime > time) {
                return;
            }
            this.mDisplayTime = time;
            msgSummary.bShowDraft = true;
            msgSummary.mDraft = new QQText(draftSummaryInfo.getSummary(), 3, 16);
        }
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mData.senderuin;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(QQAppInterface qQAppInterface, Context context) {
        Message message;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQAppInterface, (Object) context);
            return;
        }
        if (qQAppInterface != null && context != null) {
            QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
            ConversationFacade conversationFacade = qQAppInterface.getConversationFacade();
            if (messageFacade != null) {
                message = messageFacade.getLastMessage(getRecentUserUin(), getRecentUserType());
                MessageRecord P = qQAppInterface.getMessageFacade().P(message.senderuin, message.istroop, message.uniseq);
                if (P != null) {
                    this.mData = P;
                }
            } else {
                message = null;
            }
            Message message2 = message;
            if (message2 != null) {
                this.mDisplayTime = message2.time;
                if (conversationFacade != null) {
                    this.mUnreadNum = conversationFacade.R(message2.frienduin, message2.istroop);
                } else {
                    this.mUnreadNum = 0;
                }
            } else {
                this.mUnreadNum = 0;
                this.mDisplayTime = 0L;
            }
            if (message2 != null && ao.B(message2)) {
                this.mUnreadFlag = 3;
            }
            MsgSummary msgSummaryTemp = getMsgSummaryTemp();
            this.mHasFlowerMsg = false;
            if (message2 != null) {
                if (f.e(qQAppInterface, message2.senderuin, message2.istroop)) {
                    this.mMsgExtroInfo = context.getResources().getString(R.string.bpq);
                    this.mExtraInfoColor = context.getResources().getColor(R.color.ag5);
                    if (conversationFacade != null) {
                        msgSummaryTemp.strContent = conversationFacade.E(getRecentUserUin(), 1001, context.getResources().getString(R.string.bpp), 0);
                    }
                    com.tencent.mobileqq.activity.recent.config.recent.a.b(this);
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.MSGBOX_ITEM, 2, "boxUin" + getRecentUserUin() + ",boxType" + getRecentUserType() + ",HasUnreadRedPacketMsg");
                    }
                } else if (f.d(qQAppInterface, message2.senderuin, message2.istroop)) {
                    this.mHasFlowerMsg = true;
                    this.mMsgExtroInfo = context.getResources().getString(R.string.f171125cd0);
                    this.mExtraInfoColor = context.getResources().getColor(R.color.ag5);
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.MSGBOX_ITEM, 2, "boxUin" + getRecentUserUin() + ",boxType" + getRecentUserType() + ",HasUnreadGiftMsg");
                    }
                    com.tencent.mobileqq.activity.recent.config.recent.a.b(this);
                } else {
                    this.mMsgExtroInfo = "";
                    i3 = 2;
                    buildMessageBody(message2, getRecentUserType(), qQAppInterface, context, msgSummaryTemp);
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.MSGBOX_ITEM, i3, "boxUin" + getRecentUserUin() + ",boxType" + getRecentUserType() + ",unreadNum:" + this.mUnreadNum);
                    }
                    this.mTitleName = c(qQAppInterface, message2);
                    this.mAuthenIconId = 0;
                    dealStatus(qQAppInterface);
                    a(qQAppInterface, msgSummaryTemp);
                    extraUpdate(qQAppInterface, context, msgSummaryTemp);
                    if (!AppSetting.f99565y) {
                        StringBuilder sb5 = new StringBuilder(24);
                        sb5.append(this.mTitleName);
                        int i16 = this.mUnreadNum;
                        if (i16 != 0) {
                            if (i16 == 1) {
                                sb5.append("\u6709\u4e00\u6761\u672a\u8bfb");
                            } else if (i16 == i3) {
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
                        return;
                    }
                    return;
                }
            }
            i3 = 2;
            if (QLog.isColorLevel()) {
            }
            this.mTitleName = c(qQAppInterface, message2);
            this.mAuthenIconId = 0;
            dealStatus(qQAppInterface);
            a(qQAppInterface, msgSummaryTemp);
            extraUpdate(qQAppInterface, context, msgSummaryTemp);
            if (!AppSetting.f99565y) {
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public void dealDraft(BaseQQAppInterface baseQQAppInterface, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) baseQQAppInterface, (Object) msgSummary);
        } else if (baseQQAppInterface instanceof QQAppInterface) {
            a((QQAppInterface) baseQQAppInterface, msgSummary);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public long getLastDraftTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public long getLastMsgTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.mData.time;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public int getRecentUserType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mData.istroop;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public String getRecentUserUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mData.senderuin;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public void update(BaseQQAppInterface baseQQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseQQAppInterface, (Object) context);
        } else if (baseQQAppInterface instanceof QQAppInterface) {
            d((QQAppInterface) baseQQAppInterface, context);
        }
    }
}
