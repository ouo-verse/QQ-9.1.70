package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentItemSubAccount extends RecentUserBaseData {
    static IPatchRedirector $redirector_;
    public String showSubUin;

    public RecentItemSubAccount(RecentUser recentUser) throws NullPointerException {
        super(recentUser);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentUser);
        } else {
            this.mUnreadFlag = 1;
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.data.RecentUserBaseData, com.tencent.mobileqq.activity.recent.RecentBaseData
    public void update(BaseQQAppInterface baseQQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface, (Object) context);
            return;
        }
        if (baseQQAppInterface != null && context != null) {
            super.update(baseQQAppInterface, context);
            MsgSummary msgSummaryTemp = getMsgSummaryTemp();
            if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(this.mUser.uin)) {
                this.mTitleName = context.getString(R.string.f173172hr1);
            } else {
                String buddyNickName = ((IContactUtils) QRoute.api(IContactUtils.class)).getBuddyNickName(baseQQAppInterface, this.mUser.uin, true);
                this.mTitleName = buddyNickName;
                if (TextUtils.isEmpty(buddyNickName)) {
                    this.mTitleName = this.mUser.uin;
                }
                this.mTitleName = context.getString(R.string.hrx) + "\uff08" + this.mTitleName + "\uff09";
            }
            this.mUnreadNum = 0;
            ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).setRecentItemSubAccountContentAndUnread(baseQQAppInterface, context, this, msgSummaryTemp);
            if (!TextUtils.isEmpty(msgSummaryTemp.strContent)) {
                msgSummaryTemp.mEmojiFlag = 1;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "RecentItemSubAccount.update mUser.uin=" + this.mUser.uin + " mUser.type=" + this.mUser.getType() + " mUnreadNum=" + this.mUnreadNum + " mUnreadFlag=" + this.mUnreadFlag);
            }
            if (!TextUtils.isEmpty(this.mMsgExtroInfo)) {
                this.mExtraInfoColor = context.getResources().getColor(R.color.ag5);
                com.tencent.mobileqq.activity.recent.config.recent.a.b(this);
            } else {
                this.mMsgExtroInfo = "";
                this.mExtraInfoColor = 0;
            }
            this.mShowTime = "";
            this.mDisplayTime = getLastMsgTime();
            dealStatus(baseQQAppInterface);
            extraUpdate(baseQQAppInterface, context, msgSummaryTemp);
            if (AppSetting.f99565y) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.mTitleName);
                sb5.append(",");
                int i3 = this.mUnreadNum;
                if (i3 != 0) {
                    if (i3 == 1) {
                        sb5.append("\u6709\u4e00\u6761\u672a\u8bfb");
                    } else if (i3 == 2) {
                        sb5.append("\u6709\u4e24\u6761\u672a\u8bfb");
                    } else if (i3 > 0) {
                        sb5.append("\u6709");
                        sb5.append(this.mUnreadNum);
                        sb5.append("\u6761\u672a\u8bfb,");
                    }
                }
                if (this.mMsgExtroInfo != null) {
                    sb5.append(((Object) this.mMsgExtroInfo) + ",");
                }
                sb5.append(this.mLastMsg);
                sb5.append(",");
                sb5.append(this.mShowTime);
                this.mContentDesc = sb5.toString();
            }
        }
    }
}
