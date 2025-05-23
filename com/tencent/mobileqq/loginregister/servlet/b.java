package com.tencent.mobileqq.loginregister.servlet;

import android.os.Bundle;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tenpay.sdk.util.UinConfigManager;
import cooperation.qzone.QzoneIPCModule;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.Constants;
import mqq.observer.BusinessObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class b implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final List<Integer> f242895d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32357);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f242895d = Arrays.asList(Integer.valueOf(Constants.Action.ACTION_VERIFY_PASSWD), Integer.valueOf(Constants.Action.ACTION_VERIFY_PASSWD_SUBMIT_IMAGECODE), Integer.valueOf(Constants.Action.ACTION_VERIFY_PASSWD_REFRESH_IMAGECODE), 1007, 1030, 1032);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d(int i3, boolean z16, Bundle bundle) {
        if (i3 != 1007) {
            if (i3 != 1030) {
                if (i3 != 1032) {
                    switch (i3) {
                        case Constants.Action.ACTION_VERIFY_PASSWD /* 2205 */:
                            e(bundle.getString("uin"), z16, bundle.getString("errorMsg"), bundle.getInt(QzoneIPCModule.RESULT_CODE), bundle.getInt("ret"), bundle.getString(UinConfigManager.KEY_ADS), bundle.getByteArray("image"));
                            return;
                        case Constants.Action.ACTION_VERIFY_PASSWD_SUBMIT_IMAGECODE /* 2206 */:
                            String string = bundle.getString("uin");
                            int i16 = bundle.getInt(QzoneIPCModule.RESULT_CODE);
                            String string2 = bundle.getString("userAccount");
                            f(string, z16, bundle.getString("errorMsg"), i16, string2, bundle.getByteArray("userInput"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR), bundle.getByteArray("image"));
                            return;
                        case Constants.Action.ACTION_VERIFY_PASSWD_REFRESH_IMAGECODE /* 2207 */:
                            g(bundle.getString("uin"), z16, bundle.getString("errorMsg"), bundle.getInt(QzoneIPCModule.RESULT_CODE), bundle.getString("userAccount"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR), bundle.getByteArray("pictureData"));
                            return;
                        default:
                            return;
                    }
                }
                a(z16, (HashMap) bundle.getSerializable("map"));
                return;
            }
            c(bundle.getString("key"));
            return;
        }
        b(z16);
    }

    public void a(boolean z16, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), hashMap);
        }
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
    }

    public void e(String str, boolean z16, String str2, int i3, int i16, String str3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), str2, Integer.valueOf(i3), Integer.valueOf(i16), str3, bArr);
        }
    }

    public void f(String str, boolean z16, String str2, int i3, String str3, byte[] bArr, int i16, ErrMsg errMsg, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16), str2, Integer.valueOf(i3), str3, bArr, Integer.valueOf(i16), errMsg, bArr2);
        }
    }

    public void g(String str, boolean z16, String str2, int i3, String str3, int i16, ErrMsg errMsg, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16), str2, Integer.valueOf(i3), str3, Integer.valueOf(i16), errMsg, bArr);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
        } else if (f242895d.contains(Integer.valueOf(i3))) {
            d(i3, z16, bundle);
        }
    }
}
