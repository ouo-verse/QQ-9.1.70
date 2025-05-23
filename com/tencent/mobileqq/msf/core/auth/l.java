package com.tencent.mobileqq.msf.core.auth;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class l {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f247493a = "WtLoginDeviceToken";

    /* renamed from: b, reason: collision with root package name */
    private static final String f247494b = "mobileQQ_device_token";

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length != 0) {
            BaseApplication.getContext().getSharedPreferences(f247494b, 0).edit().putString(str, util.buf_to_string(bArr)).commit();
            QLog.d(f247493a, 1, "MSF save device token success, uin=" + MsfSdkUtils.getShortUin(str));
            return;
        }
        QLog.d(f247493a, 1, "MSF save device token failed, uin=" + str + ",md5=" + bArr);
    }

    public static String a(String str) {
        return BaseApplication.getContext().getSharedPreferences(f247494b, 0).getString(str, null);
    }
}
