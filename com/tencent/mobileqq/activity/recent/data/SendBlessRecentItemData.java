package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.mobileqq.activity.recent.o;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SendBlessRecentItemData extends AbsRecentUserBusinessBaseData {
    static IPatchRedirector $redirector_;

    public SendBlessRecentItemData(RecentUser recentUser) throws NullPointerException {
        super(recentUser);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentUser);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0133  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r14v3 */
    @Override // com.tencent.mobileqq.activity.recent.data.AbsRecentUserBusinessBaseData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o(QQAppInterface qQAppInterface, Context context) {
        boolean z16;
        ?? r142;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) context);
            return;
        }
        super.o(qQAppInterface, context);
        BlessManager blessManager = (BlessManager) qQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER);
        BlessTask X = blessManager.X();
        if (!blessManager.y0()) {
            this.mTitleName = context.getResources().getString(R.string.f170625wa);
            if (X != null) {
                this.mTitleName = X.starWord;
            }
            this.mLastMsg = blessManager.G();
            this.mMsgExtroInfo = "";
            if (QLog.isColorLevel()) {
                QLog.d("SendBlessRecentItemData", 2, "not isVideoNeedToPlay");
            }
        } else if (X != null) {
            this.mTitleName = X.starWord;
            this.mLastMsg = X.starBless;
            this.mMsgExtroInfo = X.f180571ex2;
            if (X.f180572ex3 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SendBlessRecentItemData", 2, "useHint: " + z16);
            }
            if (z16 && !TextUtils.isEmpty(blessManager.G())) {
                this.mLastMsg = blessManager.G();
                this.mMsgExtroInfo = "";
            } else if (!TextUtils.isEmpty(this.mMsgExtroInfo)) {
                this.mMsgExtroInfo = "[" + ((Object) this.mMsgExtroInfo) + "] ";
                this.mExtraInfoColor = context.getResources().getColor(R.color.ag5);
            }
            r142 = 1;
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X800632B", "0X800632B", 0, 0, "", "", "", "");
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X800618A", "0X800618A", 0, 0, "", "", "", "");
            if (blessManager.c0() < 0) {
                if (blessManager.c0() == 0) {
                    i3 = 2;
                } else {
                    i3 = r142;
                }
                this.mUnreadFlag = i3;
                this.mUnreadNum = r142;
            } else {
                this.mUnreadNum = 0;
            }
            this.mDisplayTime = this.mUser.lastmsgtime;
            if (this.mDisplayTime > 0) {
                this.mShowTime = o.c().e(getRecentUserUin(), this.mDisplayTime, r142);
            }
            blessManager.q();
            if (!AppSetting.f99565y) {
                StringBuilder sb5 = new StringBuilder(24);
                sb5.append(this.mTitleName);
                if (this.mUnreadNum == r142) {
                    sb5.append("\u6709\u4e00\u6761\u672a\u8bfb");
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
        r142 = 1;
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X800618A", "0X800618A", 0, 0, "", "", "", "");
        if (blessManager.c0() < 0) {
        }
        this.mDisplayTime = this.mUser.lastmsgtime;
        if (this.mDisplayTime > 0) {
        }
        blessManager.q();
        if (!AppSetting.f99565y) {
        }
    }
}
