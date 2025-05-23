package com.tencent.mobileqq.qrscan.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.api.IQRCodeApi;
import com.tencent.mobileqq.qrscan.l;
import com.tencent.mobileqq.qrscan.qrcode.a;
import common.config.service.QzoneConfig;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QRCodeApiImpl implements IQRCodeApi {
    static IPatchRedirector $redirector_;

    public QRCodeApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public int getOneResult(StringBuilder sb5, StringBuilder sb6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) sb5, (Object) sb6)).intValue();
        }
        return a.a(sb5, sb6);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public int getOneResultForCamera(StringBuilder sb5, StringBuilder sb6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) sb5, (Object) sb6)).intValue();
        }
        return a.b(sb5, sb6);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public ArrayList<QBarResult> getResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ArrayList) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return a.d();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public ArrayList<QBarResult> getResultForCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ArrayList) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return a.e();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public l.a getSupportReader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (l.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (isWxCodeSupported()) {
            return l.f276671d;
        }
        return l.f276670c;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public String getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return a.g();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public int init(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2)).intValue();
        }
        return a.i(i3, str, str2);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public int initForCamera(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2)).intValue();
        }
        return a.j(i3, str, str2);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public boolean isValidScanImageSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        return a.t(i3, i16);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public boolean isWxCodeSupported() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.ENABLE_SCAN_WX_CODE, 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public void preDownloadQbarSo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            a.u();
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public int release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return a.k();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public int releaseForCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return a.l();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public int scanImage(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return a.n(bArr, i3, i16);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public int scanImageForCamera(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return a.o(bArr, i3, i16);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public int setReaders(l.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar)).intValue();
        }
        return a.q(aVar);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRCodeApi
    public int setReadersForCamera(l.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar)).intValue();
        }
        return a.r(aVar);
    }
}
