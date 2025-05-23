package com.tencent.mobileqq.redtouch;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public ResultReceiver f280291c;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b c(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        Class<?> cls = a.f280289a.get(bundle.getInt("redpoint.fromReceiverIPCCode", -1));
        if (cls != null) {
            if (QLog.isColorLevel()) {
                QLog.d("BaseReq getReq", 2, "class name is " + cls.getName());
            }
            try {
                b bVar = (b) cls.newInstance();
                bVar.a(bundle);
                return bVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.redtouch.a
    public void a(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        } else {
            super.a(bundle);
            this.f280291c = (ResultReceiver) bundle.getParcelable("redpoint.fromReceiverKey");
        }
    }

    public final boolean b(Bundle bundle) {
        ResultReceiver resultReceiver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle)).booleanValue();
        }
        if (bundle != null && (resultReceiver = this.f280291c) != null) {
            resultReceiver.send(0, bundle);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseReq doCallback", 2, "bundle == null or fromReceiver == null");
        }
        return false;
    }

    public abstract void d(QQAppInterface qQAppInterface, Bundle bundle);
}
