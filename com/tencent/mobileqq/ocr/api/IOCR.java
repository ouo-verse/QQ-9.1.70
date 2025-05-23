package com.tencent.mobileqq.ocr.api;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.RectF;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IOCR extends QRouteApi {
    boolean checkImageFormat(String str);

    boolean compressImage(String str, String str2);

    String getCachePath(String str);

    String getImagePath(String str, boolean z16);

    String getImageUtilOCRPATH();

    void report(String str, int i3);

    Bitmap safeDecode(String str, BitmapFactory.Options options, int i3, int i16);

    String savePreviewImage(byte[] bArr, int i3, int i16, int i17, int i18);

    String savePreviewImage(byte[] bArr, int i3, int i16, int i17, int i18, int i19);

    String savePreviewImage(byte[] bArr, int i3, int i16, int i17, int i18, int i19, RectF rectF, boolean z16);

    void startOCRTextSearchActivity(QBaseActivity qBaseActivity, String str);

    void startOcrPerformFragment(Activity activity, String str, int i3, int i16, String str2, boolean z16);

    int takeDistance(Point point, Point point2);
}
