package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.o;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import java.util.Locale;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentItemNoticeData extends AbsRecentUserBusinessBaseData {
    static IPatchRedirector $redirector_;
    public String from;
    public Intent intent;
    public long time;
    public int type;
    public long uin;
    public String url;
    public String wording;

    public RecentItemNoticeData(RecentUser recentUser) throws NullPointerException {
        super(recentUser);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentUser);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.data.AbsRecentUserBusinessBaseData
    public void o(QQAppInterface qQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQAppInterface, (Object) context);
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

    public void p(int i3, long j3, String str, String str2, String str3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), str, str2, str3, Long.valueOf(j16));
            return;
        }
        this.type = i3;
        this.uin = j3;
        this.wording = str;
        this.url = str2;
        this.from = str3;
        this.time = j16;
        this.mDisplayTime = j16;
        this.mTitleName = String.format(Locale.getDefault(), "%s:%s", str3, str);
        this.mShowTime = o.c().e(getRecentUserUin(), this.mDisplayTime, true);
    }

    public boolean q(int i3, long j3, String str, String str2, String str3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3), str, str2, str3, Long.valueOf(j16))).booleanValue();
        }
        if (this.type == i3 && this.uin == j3 && this.time == j16 && Utils.p(this.wording, str) && Utils.p(this.url, str2) && Utils.p(this.from, str3)) {
            return true;
        }
        return false;
    }

    public void r(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        } else {
            this.intent = intent;
        }
    }
}
