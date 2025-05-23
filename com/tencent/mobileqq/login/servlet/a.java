package com.tencent.mobileqq.login.servlet;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.login.verify.PuzzleVerifyInfo;
import com.tencent.mobileqq.login.verify.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import mqq.observer.BusinessObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class a implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void a(DevlockInfo devlockInfo, String str, int i3, Bundle bundle);

    public abstract void b(aj ajVar);

    public abstract void c(PuzzleVerifyInfo puzzleVerifyInfo, int i3, Bundle bundle);

    public abstract void d(String str, Bundle bundle);

    public abstract void e(aj ajVar);

    @Override // mqq.observer.BusinessObserver
    public final void onReceive(int i3, boolean z16, Bundle bundle) {
        ErrMsg errMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        if (1001 == i3 || 1035 == i3 || 1100 == i3) {
            int i16 = bundle.getInt(QzoneIPCModule.RESULT_CODE);
            int i17 = bundle.getInt("ret");
            boolean z17 = bundle.getBoolean("needPuzzleVerify", false);
            boolean z18 = bundle.getBoolean("needDevLockVerify", false);
            boolean z19 = bundle.getBoolean("needShowRemindDialog", false);
            ToServiceMsg toServiceMsg = (ToServiceMsg) bundle.getParcelable("toServiceMsg");
            FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("fromServiceMsg");
            QLog.i("AccountLoginObserver", 1, "onReceive login type=" + i3 + " isSuccess=" + z16 + " code=" + i16 + " ret=" + i17 + " needPuzzleVerify=" + z17 + " needDevLockVerify=" + z18 + " needShowRemindDialog=" + z19);
            if (z16) {
                d(bundle.getString("uin"), bundle);
                return;
            }
            Object obj = null;
            if (z17) {
                PuzzleVerifyInfo e16 = j.e(fromServiceMsg);
                if (e16 != null && !TextUtils.isEmpty(e16.D)) {
                    if (fromServiceMsg != null) {
                        obj = fromServiceMsg.getAttribute("ret");
                    }
                    if (obj instanceof Integer) {
                        i17 = ((Integer) obj).intValue();
                    }
                    c(e16, i17, j.f(toServiceMsg));
                    return;
                }
                QLog.w("AccountLoginObserver", 1, "onReceiveLoginAction needPuzzleVerify, but verifyUrl is null");
                aj ajVar = new aj();
                ajVar.f241864a = -1;
                b(ajVar);
                return;
            }
            if (z18) {
                DevlockInfo b16 = j.b(fromServiceMsg);
                String c16 = j.c(toServiceMsg, fromServiceMsg);
                if (fromServiceMsg != null) {
                    obj = fromServiceMsg.getAttribute("ret");
                }
                if (obj instanceof Integer) {
                    i17 = ((Integer) obj).intValue();
                }
                a(b16, c16, i17, j.d(toServiceMsg));
                return;
            }
            aj ajVar2 = new aj();
            ajVar2.f241864a = i17;
            ajVar2.f241865b = i16;
            ajVar2.f241866c = bundle.getString("businessFailMsg");
            ajVar2.f241867d = (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR);
            if (TextUtils.isEmpty(ajVar2.f241866c) && (errMsg = ajVar2.f241867d) != null) {
                ajVar2.f241866c = errMsg.getMessage();
            }
            ajVar2.f241868e = bundle.getString(OpenHippyInfo.EXTRA_KEY_ERROR_URL);
            ajVar2.f241869f = bundle.getByteArray("errorTlv");
            ajVar2.f241870g = bundle.getByteArray("LHSig");
            ajVar2.f241871h = bundle.getString("LHUin");
            if (z19) {
                e(ajVar2);
            } else {
                b(ajVar2);
            }
        }
    }
}
