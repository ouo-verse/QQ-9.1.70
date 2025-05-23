package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation$ParcelObject;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.slf4j.Marker;

/* compiled from: P */
@ParcelAnnotation$ParcelObject
/* loaded from: classes10.dex */
public abstract class RecentBaseData {
    static IPatchRedirector $redirector_ = null;
    public static final int C2C_PROCESSUNREADNUM = 99;
    public static final int MENU_FLAG_AV_A = 12288;
    public static final int MENU_FLAG_AV_C2C = 4096;
    public static final int MENU_FLAG_AV_DIS = 8192;
    public static final int MENU_FLAG_AV_V = 16384;
    public static final int MENU_FLAG_CANCEL_HIDE = 16777216;
    public static final int MENU_FLAG_DEFAULT = 0;
    public static final int MENU_FLAG_DEL = 1;
    public static final int MENU_FLAG_MASK_AV = 61440;
    public static final int MENU_FLAG_MASK_CANCEL_HIDE = 251658240;
    public static final int MENU_FLAG_MASK_DEL = 15;
    public static final int MENU_FLAG_MASK_READSTATE = 983040;
    public static final int MENU_FLAG_MASK_SETTOP = 240;
    public static final int MENU_FLAG_MASK_SUBSCRIBE = 3145728;
    public static final int MENU_FLAG_MASK_TMSGSETTING = 3840;
    public static final int MENU_FLAG_READSTATE_READ = 65536;
    public static final int MENU_FLAG_READSTATE_UNREAD = 131072;
    public static final int MENU_FLAG_SETTOP = 16;
    public static final int MENU_FLAG_SETTOP_CANCEL = 32;
    public static final int MENU_FLAG_SETTOP_JUSTSHOW = 48;
    public static final int MENU_FLAG_SUBSCRIBE = 1048576;
    public static final int MENU_FLAG_TMSGSETING = 256;
    public static final int MENU_FLAG_UNSUBSCRIBE = 2097152;
    public static final int STATUS_AUDIO_TALK = 1;
    public static final int STATUS_AVGAME = 10;
    public static final int STATUS_AV_OTHER_TER_CHATING = 5;
    public static final int STATUS_DEFAULT = 0;
    public static final int STATUS_DRAFT = 4;
    public static final int STATUS_LISTEN_TOGETHER = 6;
    public static final int STATUS_MULTITALK_JOUIN = 2;
    public static final int STATUS_MUTILTALK_NOTJOUIN = 3;
    public static final int STATUS_SHARE_LOCATION = 8;
    public static final int STATUS_SING_TOGETHER = 9;
    public static final int STATUS_STUDY_ROOM = 11;
    public static final int STATUS_WATCH_TOGETHER = 7;
    public static final int TROOP_PROCESSUNREADNUM = 999;
    public static final int UNREAD_MSG_FALG_NUM_VIP = 4;
    public static final int UNREAD_MSG_FLAG_NONE = 0;
    public static final int UNREAD_MSG_FLAG_NUM_BLUE = 3;
    public static final int UNREAD_MSG_FLAG_NUM_RED = 1;
    public static final int UNREAD_MSG_FLAG_RED_DOT = 2;
    public boolean fromRegisterProxy;
    public int mAuthenIconId;
    public String mBindId;
    public int mBindType;
    public String mCallingText;
    public String mContentDesc;
    public volatile long mDisplayTime;
    public CharSequence mExtraInfo;
    public int mExtraInfoColor;
    public int mExtraType;
    public boolean mIsGroupVideo;
    public boolean mIsGroupVideoNotify;
    public CharSequence mLastMsg;
    public int mMenuFlag;
    public CharSequence mMsgExtroInfo;
    public int mOnlineStatus;
    public String mPhoneNumber;
    public int mPosition;
    public String mShowTime;
    public int mStatus;
    public String mTitleName;
    public CharSequence mTitleNameCs;
    public int mUnreadFlag;
    public int mUnreadNum;
    public int mVipPendant;
    protected MsgSummary msgSummary;

    public RecentBaseData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsGroupVideo = false;
        this.mIsGroupVideoNotify = false;
        this.mVipPendant = 0;
        this.mUnreadFlag = 1;
        this.mMenuFlag = 0 | 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void buildMessageBody(Message message, int i3, BaseQQAppInterface baseQQAppInterface, Context context, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, message, Integer.valueOf(i3), baseQQAppInterface, context, msgSummary);
        } else {
            System.currentTimeMillis();
            com.tencent.mobileqq.imcore.proxy.msg.c.a(context, baseQQAppInterface, message, i3, msgSummary, false, false);
        }
    }

    public final void clearUnReadNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.mUnreadNum = 0;
        }
    }

    public void dealDraft(BaseQQAppInterface baseQQAppInterface, MsgSummary msgSummary) {
        IMessageFacade iMessageFacade;
        DraftSummaryInfo draftSummaryInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseQQAppInterface, (Object) msgSummary);
            return;
        }
        if (msgSummary == null) {
            return;
        }
        msgSummary.bShowDraft = false;
        msgSummary.mDraft = null;
        if (this.mDisplayTime <= getLastDraftTime() && (iMessageFacade = (IMessageFacade) baseQQAppInterface.getRuntimeService(IMessageFacade.class, "")) != null && (iMessageFacade.getQQMessageFacadeStub() instanceof QQMessageFacadeStub) && (draftSummaryInfo = ((QQMessageFacadeStub) iMessageFacade.getQQMessageFacadeStub()).getDraftSummaryInfo(getRecentUserUin(), getRecentUserType())) != null && !TextUtils.isEmpty(draftSummaryInfo.getSummary())) {
            this.mDisplayTime = draftSummaryInfo.getTime();
            msgSummary.bShowDraft = true;
            msgSummary.mDraft = com.tencent.mobileqq.imcore.proxy.msg.d.a(draftSummaryInfo.getSummary(), 3, 16);
        }
    }

    public void dealStatus(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public boolean equals(Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && (obj instanceof RecentBaseData)) {
            RecentBaseData recentBaseData = (RecentBaseData) obj;
            if (recentBaseData.getRecentUserType() == getRecentUserType() && TextUtils.equals(recentBaseData.getRecentUserUin(), getRecentUserUin())) {
                return true;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void extraUpdate(BaseQQAppInterface baseQQAppInterface, Context context, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            extraUpdate(baseQQAppInterface, context, msgSummary, false);
        } else {
            iPatchRedirector.redirect((short) 3, this, baseQQAppInterface, context, msgSummary);
        }
    }

    public long getFaceExtraFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return 5L;
    }

    public abstract long getLastDraftTime();

    public abstract long getLastMsgTime();

    public final MsgSummary getMsgSummaryTemp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (MsgSummary) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        MsgSummary msgSummary = this.msgSummary;
        if (msgSummary == null) {
            this.msgSummary = new MsgSummary();
        } else {
            msgSummary.e();
        }
        return this.msgSummary;
    }

    public abstract int getRecentUserType();

    public abstract String getRecentUserUin();

    public final String getTitleName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mTitleName;
    }

    public final int getUnreadNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mUnreadNum;
    }

    public boolean isUnreadMsgNumInTabNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return true;
    }

    public void makeContentDesc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (com.tencent.mobileqq.imcore.proxy.basic.b.a()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.mTitleName);
            sb5.append(",");
            int i3 = this.mUnreadNum;
            if (i3 != 0) {
                if (i3 == 1) {
                    sb5.append("\u6709\u4e00\u6761\u672a\u8bfb,");
                } else if (i3 == 2) {
                    sb5.append("\u6709\u4e24\u6761\u672a\u8bfb,");
                } else if (i3 > 0) {
                    sb5.append("\u6709");
                    sb5.append(this.mUnreadNum);
                    sb5.append("\u6761\u672a\u8bfb,");
                }
            }
            CharSequence charSequence = this.mMsgExtroInfo;
            if (charSequence != null) {
                sb5.append(charSequence);
                sb5.append(",");
            }
            this.mContentDesc = sb5.toString();
        }
    }

    public void printDataItem() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder(1024);
            String str2 = "null";
            if (TextUtils.isEmpty(this.mTitleName)) {
                str = "null";
            } else {
                str = "lenth=" + this.mTitleName.length();
            }
            if (!TextUtils.isEmpty(this.mLastMsg)) {
                str2 = "lenth=" + this.mLastMsg.length();
            }
            sb5.append("[");
            sb5.append("type:");
            sb5.append(getRecentUserType());
            sb5.append(", uin:");
            sb5.append(getRecentUserUin());
            sb5.append(", unreadNum:");
            sb5.append(this.mUnreadNum);
            sb5.append(", titleName:");
            sb5.append(str);
            sb5.append(", mMenuFlag:");
            sb5.append(this.mMenuFlag);
            sb5.append(", status:");
            sb5.append(this.mStatus);
            sb5.append(", authenIcon:");
            sb5.append(this.mAuthenIconId);
            sb5.append(", showTime:");
            sb5.append(this.mShowTime);
            sb5.append(", lastmsg:");
            sb5.append(str2);
            sb5.append(", extrainfo:");
            sb5.append(this.mExtraInfo);
            sb5.append(", lastmsgtime:");
            sb5.append(getLastMsgTime());
            sb5.append(", lastdrafttime:");
            sb5.append(getLastDraftTime());
            sb5.append(", vipPendant:");
            sb5.append(this.mVipPendant);
            sb5.append("]");
            QLog.i("Q.recent", 4, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processUnReadNum(int i3, int i16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mUnreadFlag == 3 && this.mUnreadNum > 0 && ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_QQ_MESSAGE_REMINDER_DND).isExperiment()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[");
            if (this.mUnreadNum > i16) {
                str = i16 + Marker.ANY_NON_NULL_MARKER;
            } else {
                str = this.mUnreadNum + BaseApplication.getContext().getResources().getString(R.string.hqp);
            }
            sb5.append(str);
            sb5.append("]");
            String sb6 = sb5.toString();
            this.mExtraInfoColor = i3;
            this.mMsgExtroInfo = sb6;
        }
    }

    public abstract void update(BaseQQAppInterface baseQQAppInterface, Context context);

    /* JADX INFO: Access modifiers changed from: protected */
    public void extraUpdate(BaseQQAppInterface baseQQAppInterface, Context context, MsgSummary msgSummary, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, baseQQAppInterface, context, msgSummary, Boolean.valueOf(z16));
            return;
        }
        if (TextUtils.isEmpty(this.mTitleName)) {
            this.mTitleName = getRecentUserUin();
        }
        if (msgSummary != null) {
            CharSequence d16 = msgSummary.d(context);
            this.mLastMsg = d16;
            if (d16 != null && d16.length() > 168) {
                try {
                    this.mLastMsg = d16.subSequence(0, 168);
                } catch (Exception e16) {
                    if (QLog.isDevelopLevel()) {
                        e16.printStackTrace();
                    }
                }
            }
        }
        if (this.mDisplayTime <= 0 || this.mDisplayTime == 9223372036854775806L) {
            return;
        }
        this.mShowTime = o.c().e(getRecentUserUin(), this.mDisplayTime, z16);
    }
}
