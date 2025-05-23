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

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentFilterMsgBoxDataItem extends RecentUserBaseData {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RecentItemFilterMsgBoxData";
    private RecentUser mData;
    public boolean mIsSetTop;

    public RecentFilterMsgBoxDataItem(RecentUser recentUser) throws NullPointerException {
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

    private void l(BaseQQAppInterface baseQQAppInterface, Context context, Message message) {
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

    private void m(BaseQQAppInterface baseQQAppInterface, Message message) {
        if (AppSetting.f99565y) {
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
            sb5.append(((ITextUtilsApi) QRoute.api(ITextUtilsApi.class)).emoticonToTextForTalkBack(this.mLastMsg.toString()));
            sb5.append(",");
            sb5.append(this.mShowTime);
            this.mContentDesc = sb5.toString();
        }
    }

    private void n(Message message) {
        if (message != null && message.getTime() != 0) {
            this.mDisplayTime = message.getTime();
            if (this.mDisplayTime == 0) {
                this.mDisplayTime = this.mData.opTime;
                return;
            }
            return;
        }
        this.mDisplayTime = this.mData.opTime;
    }

    private void o() {
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

    private void p(BaseQQAppInterface baseQQAppInterface, Context context, Message message) {
        int recentUserType = getRecentUserType();
        MsgSummary msgSummaryTemp = getMsgSummaryTemp();
        if (msgSummaryTemp == null) {
            return;
        }
        Integer num = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getSummaryTextMap().get(Integer.valueOf(getRecentUserType()));
        if (num != null) {
            msgSummaryTemp.prefixOfContent = String.format(baseQQAppInterface.getApplication().getString(R.string.f2053355b), baseQQAppInterface.getApplication().getString(num.intValue()));
        }
        ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getCallback().a(context, baseQQAppInterface, message, recentUserType, msgSummaryTemp, false, false);
        extraUpdate(baseQQAppInterface, context, msgSummaryTemp);
    }

    private void q(BaseQQAppInterface baseQQAppInterface) {
        this.mTitleName = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getTitleName(baseQQAppInterface, this.mData);
    }

    private void r() {
        this.mUnreadFlag = 3;
    }

    private void s(BaseQQAppInterface baseQQAppInterface, Message message) {
        if (message != null) {
            IConversationFacade iConversationFacade = (IConversationFacade) baseQQAppInterface.getRuntimeService(IConversationFacade.class, "");
            if (iConversationFacade != null) {
                this.mUnreadNum = iConversationFacade.getUnreadCount(message.frienduin, message.istroop);
                return;
            } else {
                this.mUnreadNum = 0;
                return;
            }
        }
        this.mUnreadNum = 0;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) baseQQAppInterface, (Object) msgSummary);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.recent.data.RecentUserBaseData, com.tencent.mobileqq.activity.recent.RecentBaseData
    public void extraUpdate(BaseQQAppInterface baseQQAppInterface, Context context, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, baseQQAppInterface, context, msgSummary);
            return;
        }
        dealStatus(baseQQAppInterface);
        dealDraft(baseQQAppInterface, msgSummary);
        super.extraUpdate(baseQQAppInterface, context, msgSummary);
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

    @Override // com.tencent.mobileqq.activity.recent.data.RecentUserBaseData, com.tencent.mobileqq.activity.recent.RecentBaseData
    public void update(BaseQQAppInterface baseQQAppInterface, Context context) {
        Message message;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseQQAppInterface, (Object) context);
            return;
        }
        String recentUserUin = getRecentUserUin();
        int recentUserType = getRecentUserType();
        IMessageFacade iMessageFacade = (IMessageFacade) baseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
        if (iMessageFacade != null) {
            message = iMessageFacade.getLastMessage(recentUserUin, recentUserType);
        } else {
            message = null;
        }
        s(baseQQAppInterface, message);
        l(baseQQAppInterface, context, message);
        r();
        q(baseQQAppInterface);
        o();
        n(message);
        p(baseQQAppInterface, context, message);
        m(baseQQAppInterface, message);
    }
}
