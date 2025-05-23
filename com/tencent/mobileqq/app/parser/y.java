package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.recent.gamemsgbox.ForwardAccountCheckFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class y extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: protected */
    public y(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
    }

    public static boolean F(BaseQQAppInterface baseQQAppInterface, Activity activity, Intent intent) {
        if (baseQQAppInterface != null && intent != null) {
            if (intent.getBooleanExtra("param_from_forward_account", false)) {
                com.tencent.mobileqq.utils.bi.c(baseQQAppInterface, activity, intent.getStringExtra("param_original_source")).b();
                return true;
            }
            String stringExtra = intent.getStringExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT_ORIGINAL);
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = intent.getStringExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT);
            }
            if (TextUtils.isEmpty(stringExtra) || !stringExtra.startsWith("mqqforward://forward")) {
                return false;
            }
            com.tencent.mobileqq.utils.ax c16 = com.tencent.mobileqq.utils.bi.c(baseQQAppInterface, activity, stringExtra);
            c16.B(intent.getStringExtra("pkg_name"));
            c16.b();
            return true;
        }
        QLog.e("ForwardAccountCheckAction", 1, "handleForwardAccountCheckAction, app is null");
        return false;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardAccountCheckAction", 2, "source:", this.f307438c);
        }
        if (!"url".equals(this.f307440e)) {
            return false;
        }
        long Z = ForwardUtils.Z(this.f307441f.get("appid"));
        String str = this.f307441f.get("openid");
        String str2 = this.f307441f.get("package_id");
        Intent intent = new Intent();
        intent.putExtra("openid", str);
        intent.putExtra("package_id", str2);
        intent.putExtra("appid", Z);
        intent.putExtra("source", this.f307438c);
        QPublicFragmentActivity.b.b(this.f307437b, intent, QPublicTransFragmentActivity.class, ForwardAccountCheckFragment.class);
        return true;
    }
}
