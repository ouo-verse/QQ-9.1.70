package com.tencent.mobileqq.qrscan.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qrscan.ScannerResult;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IScanUtilApi extends QRouteApi {
    String buildQRScanReportParams(String str, String str2, String str3, String str4, String str5, int i3);

    Bitmap decodeBitmapFromFile(String str, int i3, int i16);

    Bitmap decodeBitmapFromYuv(byte[] bArr, int i3, int i16);

    int decodeQQCodeFromBmp(Bitmap bitmap, int i3, SparseArray<Object> sparseArray);

    ScannerResult decodeQQCodeFromBmp(Bitmap bitmap, int i3);

    int decodeQQCodeFromFile(Uri uri, Context context, int i3, SparseArray<Object> sparseArray);

    ScannerResult decodeQQCodeFromFile(Uri uri, Context context, int i3, boolean z16);

    ScannerResult decodeQRCodeFromBase64(String str);

    Pair<StringBuilder, StringBuilder> decodeQRCodeFromFile(Uri uri, Context context);

    boolean recognizeQQCodeWithoutAI();
}
