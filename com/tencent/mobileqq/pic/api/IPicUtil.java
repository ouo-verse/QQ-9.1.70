package com.tencent.mobileqq.pic.api;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.Avif2JpgResult;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPicUtil extends QRouteApi {
    String compressPic(Boolean bool, String str);

    boolean compressQuality(String str, Bitmap bitmap, int i3, String str2, CompressInfo compressInfo);

    Avif2JpgResult convertAvif2Jpg(String str, String str2, @Nullable String str3, @Nullable ThumbWidthHeightDP thumbWidthHeightDP, int i3);

    String generateCompatiblePic(String str);

    String generateThumbPic(String str);

    Bitmap getExifBitmap(String str, Bitmap bitmap);

    int getImageType(String str);

    ArrayList<Integer> getSliceInfos(String str) throws OutOfMemoryError;

    boolean isDynamicImg(int i3);

    boolean isLongPic(int i3, int i16);

    boolean isProgressiveJpeg(String str);
}
