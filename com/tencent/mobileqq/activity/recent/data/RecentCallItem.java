package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentCallItem extends RecentBaseData {
    static IPatchRedirector $redirector_ = null;
    public static final int CALL_STATE_CALLIN = 1;
    public static final int CALL_STATE_CALLOUT = 2;
    private static final String TAG = "RecentCallItem";
    protected QCallRecent call;

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    public void b(QQAppInterface qQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQAppInterface, (Object) context);
            return;
        }
        if (qQAppInterface != null && context != null) {
            this.mTitleName = "123123123";
            this.mLastMsg = this.call.lastCallMsg;
            this.mStatus = 0;
            this.mOnlineStatus = 4;
            this.mAuthenIconId = 1;
            this.mShowTime = "0";
            this.mUnreadNum = 0;
            this.mMenuFlag = 12288;
            this.mCallingText = HardCodeUtil.qqStr(R.string.str);
            this.call.isVideo = 1;
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public long getLastDraftTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public long getLastMsgTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.call.lastCallTime;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public int getRecentUserType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.call.type;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public String getRecentUserUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.call.uin;
    }

    @Override // com.tencent.mobileqq.activity.recent.RecentBaseData
    public void update(BaseQQAppInterface baseQQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseQQAppInterface, (Object) context);
        } else if (baseQQAppInterface instanceof QQAppInterface) {
            b((QQAppInterface) baseQQAppInterface, context);
        }
    }
}
