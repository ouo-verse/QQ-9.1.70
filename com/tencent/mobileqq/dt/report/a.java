package com.tencent.mobileqq.dt.report;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends ax {
    static IPatchRedirector $redirector_;

    public a(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        String str;
        long parseLong;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        String f16 = f("gray_tip_id");
        if (f16 != null) {
            String f17 = f("uid");
            String f18 = f("chat_type");
            if (f18.equals("2")) {
                str = "10089";
            } else {
                str = "10005";
            }
            String f19 = f("gray_tip_time");
            if (!TextUtils.isEmpty(f19)) {
                try {
                    parseLong = Long.parseLong(f19);
                } catch (NumberFormatException unused) {
                    QLog.i("JumpAction", 1, "gray_tip_time parse error " + f19);
                }
                String f26 = f("src");
                String f27 = f("token");
                com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
                bVar.k(String.valueOf(com.tencent.nt.adapter.session.c.c(Integer.valueOf(f18).intValue())));
                bVar.i(str);
                Bundle bundle = new Bundle();
                bundle.putString("gray_tip_id", f16);
                bundle.putLong("gray_tip_time", parseLong);
                bundle.putString("uid", f17);
                bundle.putString("src", f26);
                bundle.putString("gray_tip_token", f27);
                bVar.p(bundle);
                ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(this.f307437b, bVar);
            }
            parseLong = 0;
            String f262 = f("src");
            String f272 = f("token");
            com.tencent.mobileqq.dt.api.b bVar2 = new com.tencent.mobileqq.dt.api.b();
            bVar2.k(String.valueOf(com.tencent.nt.adapter.session.c.c(Integer.valueOf(f18).intValue())));
            bVar2.i(str);
            Bundle bundle2 = new Bundle();
            bundle2.putString("gray_tip_id", f16);
            bundle2.putLong("gray_tip_time", parseLong);
            bundle2.putString("uid", f17);
            bundle2.putString("src", f262);
            bundle2.putString("gray_tip_token", f272);
            bVar2.p(bundle2);
            ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(this.f307437b, bVar2);
        }
        return true;
    }
}
