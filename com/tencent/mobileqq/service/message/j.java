package com.tencent.mobileqq.service.message;

import android.util.Log;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.utils.ds;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f286284a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74941);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f286284a = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a(AppRuntime appRuntime, int i3) {
        try {
            if (!((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("message_report_sample")) {
                return true;
            }
            if (ds.d(1, i3) == 1) {
                return true;
            }
            return false;
        } catch (Exception e16) {
            QLog.i("MessageErrorReport", 1, "needReport", e16);
            return true;
        }
    }

    protected void b(int i3, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) hashMap);
        }
    }

    public void c(int i3, byte[] bArr, int i16, String str, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, Integer.valueOf(i16), str, Integer.valueOf(i17));
            return;
        }
        if (bArr == null || bArr.length <= 0 || i3 == -2006) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QQBrowserActivity.KEY_MSG_TYPE, String.valueOf(i3));
        hashMap.put(AppConstants.Key.COLUMN_EXT_LONG, String.valueOf(i16));
        hashMap.put(AppConstants.Key.COLUMN_MSG_DATA, String.valueOf(bArr.length));
        hashMap.put(AppConstants.Key.COLUMN_EXT_STR, str);
        hashMap.put("isTroop", String.valueOf(i17));
        b(1, hashMap);
        QLog.i("MessageErrorReport", 1, "printInfoWhenCreateError msg == null,msgType=" + i3 + ",extLong=" + i16 + ",extStr=" + str + ",isTroop=" + i17 + ",trace=" + Log.getStackTraceString(new Throwable()) + ",msgData=" + bArr.length);
    }
}
