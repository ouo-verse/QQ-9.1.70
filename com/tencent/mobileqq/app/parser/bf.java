package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.fragment.RealNameVerifiedFragment;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bf extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public bf(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F(String str) {
        ((INearbyReportHelper) QRoute.api(INearbyReportHelper.class)).reportNearbyVerifyDone();
        Intent intent = new Intent();
        intent.putExtra("scene", str);
        QPublicFragmentActivity.start(this.f307437b, intent, RealNameVerifiedFragment.class);
        Context context = this.f307437b;
        if (context instanceof Activity) {
            ((Activity) context).finish();
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        QLog.d("NearbyOpenPageAction", 2, "doAction , thread:" + Thread.currentThread().getName());
        try {
            if (!"verified".equals(this.f307441f.get("page"))) {
                return false;
            }
            return F("scene_nearby_certification");
        } catch (Exception e16) {
            QLog.e("NearbyOpenPageAction", 1, "doAction error: " + e16.getMessage());
            i("NearbyOpenPageAction");
            return false;
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            super.i(str);
        }
    }
}
