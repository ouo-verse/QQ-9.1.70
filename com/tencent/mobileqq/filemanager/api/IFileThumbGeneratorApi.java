package com.tencent.mobileqq.filemanager.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFileThumbGeneratorApi extends QRouteApi {
    String generateThumb(String str, String str2, int i3);

    Bitmap generateViewThumbBitmap(String str, int i3);
}
