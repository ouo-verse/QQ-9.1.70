package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.en;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentItemVoteData extends AbsRecentUserBusinessBaseData {
    static IPatchRedirector $redirector_;
    public long time;

    public RecentItemVoteData(RecentUser recentUser) throws NullPointerException {
        super(recentUser);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentUser);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.data.AbsRecentUserBusinessBaseData
    public void o(QQAppInterface qQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface, (Object) context);
            return;
        }
        super.o(qQAppInterface, context);
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

    public void p(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3));
            return;
        }
        this.mTitleName = str;
        this.time = j3;
        this.mShowTime = en.p(j3, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
    }
}
