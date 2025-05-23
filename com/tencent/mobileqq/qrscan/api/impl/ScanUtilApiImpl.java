package com.tencent.mobileqq.qrscan.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.qrscan.utils.d;
import com.tencent.mobileqq.qrscan.utils.e;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ScanUtilApiImpl implements IScanUtilApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ScanUtilApiImpl";
    private Boolean recognizeQQCodeWithoutAI;

    public ScanUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.recognizeQQCodeWithoutAI = null;
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanUtilApi
    public String buildQRScanReportParams(String str, String str2, String str3, String str4, String str5, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, this, str, str2, str3, str4, str5, Integer.valueOf(i3));
        }
        return d.b(str, str2, str3, str4, str5, i3);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanUtilApi
    public Bitmap decodeBitmapFromFile(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bitmap) iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return e.e(str, i3, i16);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanUtilApi
    public Bitmap decodeBitmapFromYuv(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return e.d(bArr, i3, i16);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanUtilApi
    public int decodeQQCodeFromBmp(Bitmap bitmap, int i3, SparseArray<Object> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? d.d(bitmap, i3, sparseArray) : ((Integer) iPatchRedirector.redirect((short) 4, this, bitmap, Integer.valueOf(i3), sparseArray)).intValue();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanUtilApi
    public int decodeQQCodeFromFile(Uri uri, Context context, int i3, SparseArray<Object> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? d.f(uri, context, i3, sparseArray) : ((Integer) iPatchRedirector.redirect((short) 3, this, uri, context, Integer.valueOf(i3), sparseArray)).intValue();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanUtilApi
    public ScannerResult decodeQRCodeFromBase64(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ScannerResult) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return d.i(str);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanUtilApi
    public Pair<StringBuilder, StringBuilder> decodeQRCodeFromFile(Uri uri, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uri, (Object) context);
        }
        return d.j(uri, context);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanUtilApi
    public boolean recognizeQQCodeWithoutAI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.recognizeQQCodeWithoutAI == null) {
            this.recognizeQQCodeWithoutAI = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("9135_recognize_qqcode_without_ai", false));
            QLog.i(TAG, 1, "recognizeQQCodeWithoutAI=" + this.recognizeQQCodeWithoutAI);
        }
        return this.recognizeQQCodeWithoutAI.booleanValue();
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanUtilApi
    public ScannerResult decodeQQCodeFromBmp(Bitmap bitmap, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? d.e(bitmap, i3) : (ScannerResult) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitmap, i3);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanUtilApi
    public ScannerResult decodeQQCodeFromFile(Uri uri, Context context, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? d.h(uri, context, i3, z16) : (ScannerResult) iPatchRedirector.redirect((short) 6, this, uri, context, Integer.valueOf(i3), Boolean.valueOf(z16));
    }
}
