package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cm extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public cm(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private void F() {
        if (!TabDataHelper.isAutoEnable()) {
            com.tencent.mobileqq.activity.framebusiness.controllerinject.n.g();
            return;
        }
        String f16 = f("enableTabID");
        QLog.i("QQSettingJumpAction", 1, "enableTabIDStr: " + f16);
        if (!TextUtils.isEmpty(f16) && TextUtils.isDigitsOnly(f16)) {
            com.tencent.mobileqq.activity.framebusiness.controllerinject.n.h(Integer.parseInt(f16));
        } else {
            com.tencent.mobileqq.activity.framebusiness.controllerinject.n.g();
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if ("general".equals(this.f307440e)) {
            Intent intent = new Intent(this.f307437b, (Class<?>) GeneralSettingActivity.class);
            intent.addFlags(603979776);
            this.f307437b.startActivity(intent);
            return true;
        }
        if ("deviceLock".equals(this.f307440e)) {
            Intent intent2 = new Intent();
            intent2.putExtra("from", this.f307441f.get("from"));
            intent2.setFlags(67108864);
            RouteUtils.startActivity(this.f307437b, intent2, RouterConstants.UI_ROUTE_AUTH_DEV_ACTIVITY);
            return true;
        }
        if ("phone".equals(this.f307440e)) {
            Intent intent3 = new Intent(this.f307437b, (Class<?>) PhoneUnityBindInfoActivity.class);
            intent3.putExtra("from", PhoneUnityBindInfoActivity.FROM_SCHEMA);
            intent3.setFlags(67108864);
            this.f307437b.startActivity(intent3);
            return true;
        }
        if ("bottomtab".equals(this.f307440e)) {
            F();
            return true;
        }
        if ("childrenmode".equals(this.f307440e)) {
            if (com.tencent.mobileqq.studymode.p.a() && (this.f307437b instanceof Activity)) {
                Intent intent4 = new Intent();
                intent4.putExtra("fromtype", f("fromtype"));
                com.tencent.mobileqq.studymode.p.b().h((Activity) this.f307437b, intent4);
                return true;
            }
            return true;
        }
        if ("passwordchecking".equals(this.f307440e)) {
            if (com.tencent.mobileqq.studymode.p.a() && (this.f307437b instanceof Activity)) {
                Intent intent5 = new Intent();
                intent5.putExtra("sceneidentifier", f("sceneidentifier"));
                com.tencent.mobileqq.studymode.p.b().i((Activity) this.f307437b, intent5);
                return true;
            }
            return true;
        }
        if ("font".equals(this.f307440e)) {
            Intent intent6 = new Intent(this.f307437b, (Class<?>) FontSettingActivity.class);
            if (!TextUtils.isEmpty(this.f307441f.get("source"))) {
                intent6.putExtra("source", this.f307441f.get("source"));
            }
            this.f307437b.startActivity(intent6);
            return true;
        }
        if ("openPushNotify".equals(this.f307440e)) {
            com.tencent.mobileqq.app.msgnotify.a.f196345a.o(this.f307437b);
            return true;
        }
        return false;
    }
}
