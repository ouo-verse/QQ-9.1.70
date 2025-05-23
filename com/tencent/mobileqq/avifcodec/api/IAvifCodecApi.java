package com.tencent.mobileqq.avifcodec.api;

import android.graphics.Bitmap;
import android.graphics.YuvImage;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.avifcodec.decoder.b;
import com.tencent.mobileqq.avifcodec.util.AvifImageHeaderParser$AvifImageType;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IAvifCodecApi extends QRouteApi {
    @Nullable
    Bitmap getBitmapFromAvifImage(String str);

    @Nullable
    b getDecodeOptions(String str);

    AvifImageHeaderParser$AvifImageType getType(InputStream inputStream);

    AvifImageHeaderParser$AvifImageType getType(String str);

    AvifImageHeaderParser$AvifImageType getType(ByteBuffer byteBuffer);

    @Nullable
    YuvImage getYuvImageFromAvifImage(String str);

    boolean saveAvifImageAsJPG(String str, String str2, @IntRange(from = 0, to = 100) int i3);
}
