package com.tencent.mobileqq.webview;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends ProtoUtils.TroopProtocolObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static int f313815d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26818);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f313815d = 1;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void b(int i3, byte[] bArr, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), bArr, bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DownLoadReportObserver", 2, "success errorCode : " + i3 + " data : " + Arrays.toString(bArr) + " bundle : " + bundle);
        }
    }

    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
    public void onResult(int i3, byte[] bArr, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
            return;
        }
        if (i3 == 0) {
            b(i3, bArr, bundle);
            return;
        }
        QLog.d("DownLoadReportObserver", 1, "wrong errorCode : " + i3 + " data : " + Arrays.toString(bArr) + " bundle : " + bundle);
    }
}
