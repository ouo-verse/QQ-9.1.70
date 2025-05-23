package com.tencent.mobileqq.qrscan.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.api.IQRScanReportApi;
import com.tencent.mobileqq.qrscan.minicode.MiniScanReport;
import com.tencent.mobileqq.qrscan.minicode.e;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QRScanReportApiImpl implements IQRScanReportApi {
    static IPatchRedirector $redirector_;

    public QRScanReportApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public void doFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            MiniScanReport.b();
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public boolean isBaseTestSwitchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return MiniScanReport.e();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public void markScanConsume(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            MiniScanReport.f(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public void markScanEnd(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            MiniScanReport.g(i3);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public void markScanStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            MiniScanReport.h();
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public void onAIOMiniCodeResultReport(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            MiniScanReport.i(z16, z17);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public void onAIOScanRecogTypeReport(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            MiniScanReport.j(i3);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public void onDetectFirstCost(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            MiniScanReport.k(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public void onDetectInitCost(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            MiniScanReport.l(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public void onDetectInitInternalCost(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            MiniScanReport.m(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public void onDetectSupportEasyReport(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            MiniScanReport.n(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public void onDetectSupportReport(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            MiniScanReport.o(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public void onSoCoverReport(boolean z16, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
        } else {
            MiniScanReport.p(z16, i3, str);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public long readLong(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3))).longValue();
        }
        return MiniScanReport.q(str, j3);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public void setSaveDetectImage(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            e.m(z16);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public void stopFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            MiniScanReport.b();
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanReportApi
    public void writeLong(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Long.valueOf(j3));
        } else {
            MiniScanReport.r(str, j3);
        }
    }
}
