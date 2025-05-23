package com.tencent.mobileqq.pic.api;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface ICompressOperator extends QRouteApi {
    public static final int TYPE_AIO_FILEPIC = 1;
    public static final int TYPE_AIO_IMAGE = 0;
    public static final int TYPE_FILEPIC_750 = 2;

    Bitmap clip(Bitmap bitmap, ThumbWidthHeightDP thumbWidthHeightDP);

    boolean compressAIOThumbnail(String str, String str2, boolean z16, String str3, int i3) throws Exception;

    boolean compressAIOThumbnailWithTrubo(String str, String str2, boolean z16, String str3, int i3) throws Exception;

    boolean decodeJpegByTrubo();

    int[] getCompressConfigFromServer(AppInterface appInterface);

    Bitmap getGifTagBitmap();

    String getSendPhotoPath(String str, int i3);

    boolean start(CompressInfo compressInfo);

    boolean startThumbnail(CompressInfo compressInfo);

    int transformQuality(int i3);
}
