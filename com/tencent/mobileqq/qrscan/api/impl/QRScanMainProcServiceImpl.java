package com.tencent.mobileqq.qrscan.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.VoiceScan;
import com.tencent.mobileqq.qrscan.api.IQRScanMainProcService;
import mqq.app.AppRuntime;

/* loaded from: classes17.dex */
public class QRScanMainProcServiceImpl implements IQRScanMainProcService {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "QRScanMainProcServiceImpl";
    private AppRuntime app;
    private Context mContext;
    private VoiceScan mVoiceScan;

    public QRScanMainProcServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void onScannerPause() {
        VoiceScan voiceScan = this.mVoiceScan;
        if (voiceScan != null) {
            voiceScan.j();
        }
    }

    private void onScannerResume() {
        VoiceScan voiceScan = this.mVoiceScan;
        if (voiceScan != null) {
            voiceScan.k();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.app = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        onScannerDestroy();
        this.app = null;
        this.mContext = null;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanMainProcService
    public void onScannerCreate(Context context, ScannerParams scannerParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) scannerParams);
            return;
        }
        this.mContext = context;
        if (scannerParams.f276519m && this.mVoiceScan == null) {
            this.mVoiceScan = new VoiceScan(this.mContext, (AppInterface) this.app);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanMainProcService
    public void onScannerDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        VoiceScan voiceScan = this.mVoiceScan;
        if (voiceScan != null) {
            voiceScan.i();
            this.mVoiceScan = null;
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanMainProcService
    public void onToolScannerActivityStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 4) {
                    onScannerDestroy();
                    return;
                }
                return;
            }
            onScannerPause();
            return;
        }
        onScannerResume();
    }
}
