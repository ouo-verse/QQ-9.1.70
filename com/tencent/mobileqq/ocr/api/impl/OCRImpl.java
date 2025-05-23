package com.tencent.mobileqq.ocr.api.impl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.RectF;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.ocr.d;
import com.tencent.mobileqq.ocr.e;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OCRImpl implements IOCR {
    static IPatchRedirector $redirector_;

    public OCRImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCR
    public boolean checkImageFormat(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        return e.a(str);
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCR
    public boolean compressImage(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        return e.b(str, str2);
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCR
    public String getCachePath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        return e.d(str);
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCR
    public String getImagePath(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16));
        }
        return e.g(str, z16);
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCR
    public String getImageUtilOCRPATH() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return e.f254755a;
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCR
    public void report(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, i3);
        } else {
            d.n(str, i3);
        }
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCR
    public Bitmap safeDecode(String str, BitmapFactory.Options options, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Bitmap) iPatchRedirector.redirect((short) 14, this, str, options, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return com.tencent.mobileqq.gallery.picocr.d.d(str, options, i3, i16);
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCR
    public String savePreviewImage(byte[] bArr, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? e.l(bArr, i3, i16, i17, i18) : (String) iPatchRedirector.redirect((short) 4, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCR
    public void startOCRTextSearchActivity(QBaseActivity qBaseActivity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) str);
        } else {
            OCRTextSearchActivity.Q2(qBaseActivity, str);
        }
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCR
    public void startOcrPerformFragment(Activity activity, String str, int i3, int i16, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Boolean.valueOf(z16));
        } else {
            OCRPerformFragment.gi(activity, str, i3, i16, str2, z16);
        }
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCR
    public int takeDistance(Point point, Point point2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) point, (Object) point2)).intValue();
        }
        return d.s(point, point2);
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCR
    public String savePreviewImage(byte[] bArr, int i3, int i16, int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? e.m(bArr, i3, i16, i17, i18, i19) : (String) iPatchRedirector.redirect((short) 5, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCR
    public String savePreviewImage(byte[] bArr, int i3, int i16, int i17, int i18, int i19, RectF rectF, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? e.n(bArr, i3, i16, i17, i18, i19, rectF, z16) : (String) iPatchRedirector.redirect((short) 6, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), rectF, Boolean.valueOf(z16));
    }
}
