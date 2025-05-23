package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bx extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public bx(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private HashMap<String, String> F(HashMap<String, String> hashMap) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_schema_add_client_info", true)) {
            return hashMap;
        }
        Intent G = G();
        if (G != null && hashMap != null) {
            HashMap<String, String> hashMap2 = new HashMap<>(hashMap);
            String stringExtra = G.getStringExtra("KEY_PUSH_IS_FROM");
            if (!TextUtils.isEmpty(stringExtra)) {
                hashMap2.put("KEY_PUSH_IS_FROM", stringExtra);
            }
            return hashMap2;
        }
        return hashMap;
    }

    private Intent G() {
        Context context = this.f307437b;
        if (!(context instanceof Activity)) {
            return null;
        }
        return ((Activity) context).getIntent();
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            if (this.f307441f != null) {
                if (!TextUtils.isEmpty(this.f307443h)) {
                    this.f307441f.put("frompage", this.f307443h);
                }
                if (QCircleScheme.Q_CIRCLE_ACTION_OPEN_QQPUBLISH.equals(this.f307440e)) {
                    ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkBySchema(this.f307437b, this.f307440e, this.f307441f, null);
                } else {
                    com.tencent.mobileqq.activity.qcircle.utils.c.g().enterBySchemeAction(this.f307437b, this.f307440e, F(this.f307441f));
                }
            } else {
                QLog.e("QCircleAction", 1, "doAction attr is empty");
            }
            return true;
        } catch (Exception e16) {
            QLog.e("QCircleAction", 1, "doAction error: " + e16.getMessage());
            i("QCircleAction");
            return false;
        }
    }
}
