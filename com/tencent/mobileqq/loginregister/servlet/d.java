package com.tencent.mobileqq.loginregister.servlet;

import android.os.Bundle;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class d implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final List<Integer> f242896d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32384);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f242896d = Arrays.asList(1003, 1004, 1020, 1005, 1022, 2217);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(int i3, boolean z16, Bundle bundle) {
        if (i3 != 1020) {
            if (i3 != 1022) {
                if (i3 != 2217) {
                    switch (i3) {
                        case 1003:
                            c(z16, bundle.getInt("code", -1), bundle.getByteArray("promptInfo"), bundle.getByteArray(DeviceType.DeviceCategory.MOBILE), bundle.getString("inviteCode"));
                            return;
                        case 1004:
                            f(z16, bundle.getInt("code", -1), bundle.getString("bind_qq_uin"), bundle.getString("bind_qq_nick"), bundle.getString("bind_qq_face_url"), bundle.getByteArray("promptInfo"), bundle.getString("phone_protect_uins_url"));
                            return;
                        case 1005:
                            if (bundle.getBoolean("reg_Lianghao", false)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("wtLogin_LiangHao", 2, "onRegisterCommitPassRespWithLhSig");
                                }
                                e(z16, bundle.getInt("code", -1), bundle.getString("uin"), bundle.getByteArray("promptInfo"), bundle.getByteArray("promptInfo_error"), bundle.getByteArray("lhsig"));
                                return;
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d("wtLogin_LiangHao", 2, "onRegisterCommitPassResp");
                                }
                                d(z16, bundle.getInt("code", -1), bundle.getString("uin"), bundle.getByteArray("promptInfo"), bundle.getByteArray("promptInfo_error"), bundle.getByteArray(MsfConstants.ATTRIBUTE_RESP_REGISTER_SUPER_SIG));
                                return;
                            }
                        default:
                            return;
                    }
                }
                a(z16, bundle.getInt("code", -1), bundle.getByteArray("promptInfo"), bundle.getString("protect_uins_url"), bundle.getByteArray(DeviceType.DeviceCategory.MOBILE));
                return;
            }
            g(z16, bundle.getInt("code", -1), bundle.getByteArray("promptInfo"), bundle.getInt("next_chk_time"), bundle.getInt("total_time_over"), bundle.getString("uin"), bundle.getString("nick"), bundle.getString("faceUrl"), bundle.getString(HippyReporter.EXTRA_KEY_REPORT_ERRMSG), bundle.getString("phone_protect_uins_url"));
            return;
        }
        h(z16, bundle.getInt("code", -1), bundle.getByteArray("promptInfo"), bundle.getInt("next_chk_time"), bundle.getInt("total_time_over"));
    }

    public void a(boolean z16, int i3, byte[] bArr, String str, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3), bArr, str, bArr2);
        }
    }

    public void c(boolean z16, int i3, byte[] bArr, byte[] bArr2, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), bArr, bArr2, str);
        }
    }

    public void d(boolean z16, int i3, String str, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, bArr, bArr2, bArr3);
        }
    }

    public void e(boolean z16, int i3, String str, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, bArr, bArr2, bArr3);
        }
    }

    public void f(boolean z16, int i3, String str, String str2, String str3, byte[] bArr, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2, str3, bArr, str4);
        }
    }

    public void g(boolean z16, int i3, byte[] bArr, int i16, int i17, String str, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), bArr, Integer.valueOf(i16), Integer.valueOf(i17), str, str2, str3, str4, str5);
        }
    }

    public void h(boolean z16, int i3, byte[] bArr, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), bArr, Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
        } else if (f242896d.contains(Integer.valueOf(i3))) {
            b(i3, z16, bundle);
        }
    }
}
