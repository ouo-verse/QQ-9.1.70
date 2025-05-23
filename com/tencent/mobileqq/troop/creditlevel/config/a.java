package com.tencent.mobileqq.troop.creditlevel.config;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f294760a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f294760a = false;
        }
    }

    public static a b(String str) {
        a aVar = new a();
        if (QLog.isColorLevel()) {
            QLog.d("TroopCreditLevelEntryConfig", 2, "content : " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        boolean z16 = false;
        try {
            if (new JSONObject(str).optInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, 0) != 0) {
                z16 = true;
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        aVar.f294760a = z16;
        return aVar;
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f294760a;
    }
}
