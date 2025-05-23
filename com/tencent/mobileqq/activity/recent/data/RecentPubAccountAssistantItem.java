package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ap;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes10.dex */
public class RecentPubAccountAssistantItem extends RecentBaseData {
    static IPatchRedirector $redirector_;
    private PubAccountAssistantData mData;

    private void a() {
        if (AppSetting.f99565y) {
            StringBuilder sb5 = new StringBuilder(24);
            sb5.append(this.mTitleName);
            int i3 = this.mUnreadNum;
            if (i3 != 0) {
                if (i3 == 1) {
                    sb5.append("\u6709\u4e00\u6761\u672a\u8bfb");
                } else if (i3 == 2) {
                    sb5.append("\u6709\u4e24\u6761\u672a\u8bfb");
                } else if (i3 > 0) {
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

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public long getLastDraftTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.mData.mLastDraftTime;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public long getLastMsgTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.mData.mLastMsgTime;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public int getRecentUserType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mData.mType;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public String getRecentUserUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mData.mUin;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public boolean isUnreadMsgNumInTabNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public void update(BaseQQAppInterface baseQQAppInterface, Context context) {
        QQAppInterface qQAppInterface;
        Message message;
        String str;
        ArrayList<PAMessage.Item> arrayList;
        PublicAccountInfo publicAccountInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) baseQQAppInterface, (Object) context);
            return;
        }
        if ((baseQQAppInterface instanceof QQAppInterface) && (qQAppInterface = (QQAppInterface) baseQQAppInterface) != null && context != null) {
            String recentUserUin = getRecentUserUin();
            int recentUserType = getRecentUserType();
            QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
            String str2 = null;
            if (messageFacade != null) {
                message = messageFacade.getLastMessage(recentUserUin, recentUserType);
            } else {
                message = null;
            }
            if (message != null) {
                this.mDisplayTime = message.time;
                ConversationFacade conversationFacade = qQAppInterface.getConversationFacade();
                if (conversationFacade != null) {
                    this.mUnreadNum = conversationFacade.R(message.frienduin, message.istroop);
                } else {
                    this.mUnreadNum = 0;
                }
            } else {
                this.mDisplayTime = 0L;
                this.mUnreadNum = 0;
            }
            IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
            if (iPublicAccountDataManager != null && (publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfo(recentUserUin)) != null) {
                str2 = publicAccountInfo.name;
                str = publicAccountInfo.summary;
            } else {
                str = null;
            }
            if (str2 != null) {
                recentUserUin = str2;
            }
            this.mTitleName = recentUserUin;
            MsgSummary msgSummaryTemp = getMsgSummaryTemp();
            if (message != null) {
                int i3 = message.msgtype;
                if (i3 != -3006 && i3 != -5004) {
                    buildMessageBody(message, recentUserType, qQAppInterface, context, msgSummaryTemp);
                } else {
                    msgSummaryTemp.strContent = "";
                    PAMessage b16 = ap.b(message);
                    if (b16 != null && (arrayList = b16.items) != null && arrayList.size() != 0) {
                        String str3 = b16.items.get(0).title;
                        if (b16.items.get(0).cover == null && b16.items.get(0).digestList != null) {
                            str3 = str3 + "\uff1a" + b16.items.get(0).digestList.get(0);
                        }
                        msgSummaryTemp.strContent = str3;
                    } else {
                        buildMessageBody(message, recentUserType, qQAppInterface, context, msgSummaryTemp);
                    }
                }
            }
            if (TextUtils.isEmpty(msgSummaryTemp.strContent) && TextUtils.isEmpty(msgSummaryTemp.suffix)) {
                if (str == null) {
                    str = "";
                }
                msgSummaryTemp.strContent = str;
            }
            dealStatus(qQAppInterface);
            dealDraft(qQAppInterface, msgSummaryTemp);
            extraUpdate(qQAppInterface, context, msgSummaryTemp);
            a();
        }
    }
}
