package com.tencent.mobileqq.olympic;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.ocr.activity.ScanBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ScannerResultReceiver extends ResultReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ScanBaseActivity f255099d;

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i3, Bundle bundle) {
        ScanBaseActivity scanBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bundle);
            return;
        }
        com.tencent.mobileqq.olympic.utils.a.e("ScannerResultReceiver", "mResultReceiver.onReceiveResult, resultCode=", Integer.valueOf(i3), this);
        if (i3 == 0 && (scanBaseActivity = this.f255099d) != null && scanBaseActivity.f254632g0) {
            scanBaseActivity.G2();
        }
    }
}
