package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentItemImaxADData extends RecentItemChatMsgData {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RecentItemImaxADData";
    public String mHeaderUrl;

    public RecentItemImaxADData(RecentUser recentUser) throws NullPointerException {
        super(recentUser);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentUser);
        } else {
            this.mHeaderUrl = null;
            this.mUnreadFlag = 1;
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData
    public void I(QQAppInterface qQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) context);
            return;
        }
        if (qQAppInterface != null && context != null) {
            super.I(qQAppInterface, context);
            QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
            if (messageFacade != null) {
                RecentUser recentUser = this.mUser;
                Message lastMessage = messageFacade.getLastMessage(recentUser.uin, recentUser.getType());
                if (lastMessage != null) {
                    String extInfoFromExtStr = lastMessage.getExtInfoFromExtStr("recent_list_advertisement_message_name");
                    if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                        this.mTitleName = extInfoFromExtStr;
                    }
                    String extInfoFromExtStr2 = lastMessage.getExtInfoFromExtStr("recent_list_advertisement_uin_head_url");
                    if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
                        this.mHeaderUrl = extInfoFromExtStr2;
                    }
                }
            }
            if (this.mUnreadNum > 0) {
                this.mUnreadNum = 1;
            }
            if (AppSetting.f99565y) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.mTitleName);
                sb5.append(",");
                if (this.mMsgExtroInfo != null) {
                    sb5.append(((Object) this.mMsgExtroInfo) + ",");
                }
                sb5.append(this.mLastMsg);
                sb5.append(",");
                sb5.append(this.mShowTime);
                this.mContentDesc = sb5.toString();
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "mTitleName:" + this.mTitleName + ", mDisplayTime:" + this.mDisplayTime + ", mUnreadNum:" + this.mUnreadNum + ", mUnreadFlag:" + this.mUnreadFlag + ", mShowTime:" + this.mShowTime + ", mStatus:" + this.mStatus + ", mMsgExtroInfo:" + ((Object) this.mMsgExtroInfo) + ", mExtraInfoColor:" + this.mExtraInfoColor + ", mLastMsg:" + ((Object) this.mLastMsg));
            }
        }
    }
}
