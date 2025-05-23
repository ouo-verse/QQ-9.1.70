package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;

/* compiled from: P */
/* loaded from: classes11.dex */
public class de extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public de(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        try {
            return o();
        } catch (Exception e16) {
            QLog.e("QzoneFriendFeedsV1AndV2Action", 1, "doAction error: " + e16.getMessage());
            i("QzoneFriendFeedsV1AndV2Action");
            return false;
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f307436a == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("refer", QZoneHelper.QZoneAppConstants.REFER_SCHEME_ACTIVE_FEED);
        QzonePluginProxyActivity.setActivityNameToIntent(intent, QZoneHelper.FRIEND_FEED);
        intent.addFlags(805306368);
        QZoneHelper.forwardToFriendFeed((Activity) this.f307437b, this.f307436a.getCurrentAccountUin(), intent, Uri.parse(this.f307438c).getQueryParameter("push_trans_channel"), -1);
        LpReportInfo_dc02880.report(this.f307438c);
        return true;
    }
}
