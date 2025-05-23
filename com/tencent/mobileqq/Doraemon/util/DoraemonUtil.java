package com.tencent.mobileqq.Doraemon.util;

import android.text.TextUtils;
import com.tencent.mobileqq.Doraemon.a;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DoraemonUtil {
    static IPatchRedirector $redirector_;

    public static int a(int i3) {
        switch (i3) {
            case 2:
                return 0;
            case 3:
                return 9;
            case 4:
                return 11;
            case 5:
                return 12;
            case 6:
                return 13;
            case 7:
                return 14;
            default:
                return 7;
        }
    }

    public static String b(int i3) {
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                return "android";
                            }
                            return PreDownloadConstants.DEPARTMENT_QQPAY;
                        }
                        return "limi";
                    }
                    return "mini_app";
                }
                return "mini_game";
            }
            return "ark";
        }
        return "web";
    }

    public static void c(a aVar, int i3, String str) {
        ThreadManager.getUIHandler().post(new Runnable(i3, str) { // from class: com.tencent.mobileqq.Doraemon.util.DoraemonUtil.2
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f154280e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f154281f;

            {
                this.f154280e = i3;
                this.f154281f = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, a.this, Integer.valueOf(i3), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    a.this.onFailure(this.f154280e, this.f154281f);
                    a.this.onComplete();
                }
            }
        });
    }

    public static void d(a aVar, int i3) {
        ThreadManager.getUIHandler().post(new Runnable(i3) { // from class: com.tencent.mobileqq.Doraemon.util.DoraemonUtil.4
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f154285e;

            {
                this.f154285e = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    a.this.onPermission(this.f154285e);
                }
            }
        });
    }

    public static void e(a aVar, JSONObject jSONObject) {
        ThreadManager.getUIHandler().post(new Runnable(jSONObject) { // from class: com.tencent.mobileqq.Doraemon.util.DoraemonUtil.1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ JSONObject f154278e;

            {
                this.f154278e = jSONObject;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) jSONObject);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    a.this.onSuccess(this.f154278e);
                    a.this.onComplete();
                }
            }
        });
    }

    public static void f(a aVar, JSONObject jSONObject) {
        ThreadManager.getUIHandler().post(new Runnable(jSONObject) { // from class: com.tencent.mobileqq.Doraemon.util.DoraemonUtil.3
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ JSONObject f154283e;

            {
                this.f154283e = jSONObject;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) jSONObject);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    a.this.onTrigger(this.f154283e);
                }
            }
        });
    }

    public static boolean g() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("DoraemonOpenAPI.util", 2, "url is empty");
            }
            return null;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            if (QLog.isColorLevel()) {
                QLog.d("DoraemonOpenAPI.util", 2, "scheme not match " + str);
            }
            return null;
        }
        int indexOf = str.indexOf(63);
        int indexOf2 = str.indexOf(35);
        if (indexOf == -1) {
            if (indexOf2 == -1) {
                indexOf = str.length();
            } else {
                indexOf = indexOf2;
            }
        } else if (indexOf2 != -1) {
            indexOf = Math.min(indexOf, indexOf2);
        }
        return str.substring(0, indexOf);
    }
}
