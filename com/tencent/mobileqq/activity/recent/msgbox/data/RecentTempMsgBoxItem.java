package com.tencent.mobileqq.activity.recent.msgbox.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.businesshandler.b;
import com.tencent.mobileqq.activity.recent.msgbox.c;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.a;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqemoticon.api.ITextUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentTempMsgBoxItem extends RecentUserBaseData {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RecentTempMsgBoxItem";
    private RecentUser mData;
    public boolean mIsSetTop;

    public RecentTempMsgBoxItem(RecentUser recentUser) throws NullPointerException {
        super(recentUser);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentUser);
        } else {
            this.mData = recentUser;
        }
    }

    private void k(BaseQQAppInterface baseQQAppInterface, MsgSummary msgSummary, DraftSummaryInfo draftSummaryInfo) {
        if (draftSummaryInfo != null && !TextUtils.isEmpty(draftSummaryInfo.getSummary())) {
            this.mDisplayTime = draftSummaryInfo.getTime();
            msgSummary.bShowDraft = true;
            String summary = draftSummaryInfo.getSummary();
            String str = "";
            a tempChatPlugin = ((ITempChatPluginManager) baseQQAppInterface.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(getRecentUserType());
            if (tempChatPlugin != null) {
                str = tempChatPlugin.d(getRecentUserUin(), TempChatSource.SOURCE_FROM_MAG_TAB);
            } else {
                Integer num = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getSummaryTextMap().get(Integer.valueOf(getRecentUserType()));
                if (num != null) {
                    str = String.format(baseQQAppInterface.getApplication().getString(R.string.f2053355b), baseQQAppInterface.getApplication().getString(num.intValue()));
                }
            }
            msgSummary.mDraft = new QQText(str + summary, 3, 16);
        }
    }

    private StringBuilder l(BaseQQAppInterface baseQQAppInterface, Message message) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.mTitleName);
        sb5.append(",");
        int i3 = this.mUnreadNum;
        if (i3 != 0) {
            if (i3 == 1) {
                sb5.append(baseQQAppInterface.getApplication().getString(R.string.f230436z5));
            } else if (i3 == 2) {
                sb5.append(baseQQAppInterface.getApplication().getString(R.string.f230446z6));
            } else if (i3 > 0) {
                sb5.append(String.format(baseQQAppInterface.getApplication().getString(R.string.f230426z4), Integer.valueOf(this.mUnreadNum)));
            }
        }
        CharSequence charSequence = this.mMsgExtroInfo;
        if (charSequence != null) {
            sb5.append(charSequence);
            sb5.append(",");
        }
        Integer num = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getSummaryTextMap().get(Integer.valueOf(getRecentUserType()));
        if (num != null) {
            sb5.append(((ITextUtilsApi) QRoute.api(ITextUtilsApi.class)).emoticonToTextForTalkBack(this.mLastMsg.toString().replace(String.format(baseQQAppInterface.getApplication().getString(R.string.f2053355b), baseQQAppInterface.getApplication().getString(num.intValue())), "")));
            sb5.append(",");
        } else {
            sb5.append(((ITextUtilsApi) QRoute.api(ITextUtilsApi.class)).emoticonToTextForTalkBack(this.mLastMsg.toString()));
            sb5.append(",");
        }
        sb5.append(this.mShowTime);
        return sb5;
    }

    private void m(BaseQQAppInterface baseQQAppInterface, Context context, Message message) {
        if (message != null) {
            c callback = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getCallback();
            int c16 = callback.c(baseQQAppInterface, message.frienduin, message.istroop, this.mUnreadNum, message);
            int i3 = this.mUnreadNum + c16;
            this.mUnreadNum = i3;
            if (c16 > 0) {
                this.mMsgExtroInfo = callback.b(baseQQAppInterface, message.frienduin, message.istroop, i3, message);
                this.mExtraInfoColor = context.getResources().getColor(R.color.ag5);
            }
        }
    }

    private void n(BaseQQAppInterface baseQQAppInterface, Message message) {
        if (AppSetting.f99565y) {
            this.mContentDesc = l(baseQQAppInterface, message).toString();
        }
    }

    private void o(BaseQQAppInterface baseQQAppInterface, Message message, String str) {
        boolean z16;
        b bVar;
        if (message != null) {
            this.mDisplayTime = message.time;
            IConversationFacade iConversationFacade = (IConversationFacade) baseQQAppInterface.getRuntimeService(IConversationFacade.class, "");
            String str2 = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getBusinessStringMap().get(Integer.valueOf(getRecentUserType()));
            if (str2 != null && (bVar = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getBusinessHandlerMap().get(str2)) != null) {
                z16 = bVar.e(baseQQAppInterface, str);
            } else {
                z16 = true;
            }
            if (!z16) {
                this.mUnreadNum = 0;
            } else {
                this.mUnreadNum = iConversationFacade.getUnreadCount(message.frienduin, message.istroop);
            }
            message.nickName = null;
            return;
        }
        this.mDisplayTime = 0L;
        this.mUnreadNum = 0;
    }

    private void p() {
        boolean z16;
        int i3;
        if (this.mData.showUpTime != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsSetTop = z16;
        int i16 = this.mMenuFlag & (-241);
        this.mMenuFlag = i16;
        if (z16) {
            i3 = 32;
        } else {
            i3 = 16;
        }
        this.mMenuFlag = i3 | i16;
    }

    private void q(BaseQQAppInterface baseQQAppInterface, Context context, Message message, int i3, MsgSummary msgSummary) {
        b bVar;
        message.prefixOfNickname = "";
        a tempChatPlugin = ((ITempChatPluginManager) baseQQAppInterface.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(getRecentUserType());
        if (tempChatPlugin != null) {
            msgSummary.prefixOfContent = tempChatPlugin.d(getRecentUserUin(), TempChatSource.SOURCE_FROM_MAG_TAB);
        } else {
            Integer num = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getSummaryTextMap().get(Integer.valueOf(getRecentUserType()));
            if (num != null) {
                msgSummary.prefixOfContent = String.format(baseQQAppInterface.getApplication().getString(R.string.f2053355b), baseQQAppInterface.getApplication().getString(num.intValue()));
            }
        }
        String str = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getBusinessStringMap().get(Integer.valueOf(i3));
        if (str != null && (bVar = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getBusinessHandlerMap().get(str)) != null) {
            bVar.a(baseQQAppInterface, message, i3, msgSummary);
        }
        ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getCallback().a(context, baseQQAppInterface, message, i3, msgSummary, false, false);
    }

    private void r(BaseQQAppInterface baseQQAppInterface) {
        this.mTitleName = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getTitleName(baseQQAppInterface, this.mData);
    }

    private void s() {
        this.mUnreadFlag = 1;
    }

    @Override // com.tencent.mobileqq.activity.recent.data.RecentUserBaseData
    public RecentUser d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (RecentUser) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mData;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public void dealDraft(BaseQQAppInterface baseQQAppInterface, MsgSummary msgSummary) {
        IMessageFacade iMessageFacade;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) baseQQAppInterface, (Object) msgSummary);
            return;
        }
        if (msgSummary != null) {
            msgSummary.bShowDraft = false;
            msgSummary.mDraft = null;
            if (this.mDisplayTime <= getLastDraftTime() && (iMessageFacade = (IMessageFacade) baseQQAppInterface.getRuntimeService(IMessageFacade.class, "")) != null) {
                k(baseQQAppInterface, msgSummary, iMessageFacade.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType()));
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.data.RecentUserBaseData, com.tencent.mobileqq.activity.recent.RecentBaseData
    public long getLastDraftTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.mData.lastmsgdrafttime;
    }

    @Override // com.tencent.mobileqq.activity.recent.data.RecentUserBaseData, com.tencent.mobileqq.activity.recent.RecentBaseData
    public long getLastMsgTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.mData.lastmsgtime;
    }

    @Override // com.tencent.mobileqq.activity.recent.data.RecentUserBaseData, com.tencent.mobileqq.activity.recent.RecentBaseData
    public int getRecentUserType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mData.getType();
    }

    @Override // com.tencent.mobileqq.activity.recent.data.RecentUserBaseData, com.tencent.mobileqq.activity.recent.RecentBaseData
    public String getRecentUserUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mData.uin;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "RecentTempMsgBoxItem{mData=" + this.mData + '}';
    }

    @Override // com.tencent.mobileqq.activity.recent.data.RecentUserBaseData, com.tencent.mobileqq.activity.recent.RecentBaseData
    public void update(BaseQQAppInterface baseQQAppInterface, Context context) {
        Message message;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseQQAppInterface, (Object) context);
            return;
        }
        if (baseQQAppInterface != null && context != null) {
            String recentUserUin = getRecentUserUin();
            int recentUserType = getRecentUserType();
            IMessageFacade iMessageFacade = (IMessageFacade) baseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
            if (iMessageFacade != null) {
                message = iMessageFacade.getLastMessage(recentUserUin, recentUserType);
            } else {
                message = null;
            }
            Message message2 = message;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getLastMessage: ", message2);
            }
            r(baseQQAppInterface);
            o(baseQQAppInterface, message2, recentUserUin);
            m(baseQQAppInterface, context, message2);
            s();
            MsgSummary msgSummaryTemp = getMsgSummaryTemp();
            if (msgSummaryTemp == null) {
                return;
            }
            q(baseQQAppInterface, context, message2, recentUserType, msgSummaryTemp);
            dealStatus(baseQQAppInterface);
            dealDraft(baseQQAppInterface, msgSummaryTemp);
            extraUpdate(baseQQAppInterface, context, msgSummaryTemp);
            p();
            n(baseQQAppInterface, message2);
            Iterator<b> it = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getBusinessHandlerMap().values().iterator();
            while (it.hasNext()) {
                it.next().d(baseQQAppInterface, recentUserType, recentUserUin);
            }
        }
    }
}
