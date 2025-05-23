package com.tencent.mobileqq.kandian.base.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J6\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J3\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/image/f;", "", "", "path", "", "dstWidth", "dstHeight", "Landroid/graphics/Bitmap$Config;", DownloadInfo.spKey_Config, "Landroid/graphics/Bitmap;", "reuseBitmap", "b", "Landroid/graphics/BitmapFactory$Options;", "c", "", "hObj", "index", MimeHelper.IMAGE_SUBTYPE_BITMAP, "delayTime", "a", "(JILandroid/graphics/Bitmap;Ljava/lang/Integer;)Ljava/lang/Integer;", "Lcom/tencent/sharpP/SharpPDecoder;", "Lcom/tencent/sharpP/SharpPDecoder;", "mDecoder", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    private static final String f239037c = "RIJSharpPDecoder";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private SharpPDecoder mDecoder;

    public final Integer a(long hObj, int index, Bitmap bitmap, Integer delayTime) {
        SharpPDecoder sharpPDecoder = this.mDecoder;
        if (sharpPDecoder != null) {
            return Integer.valueOf(sharpPDecoder.DecodeImageToBitmap2(hObj, index, bitmap, delayTime));
        }
        return null;
    }

    public final Bitmap b(String path, int dstWidth, int dstHeight, Bitmap.Config config, Bitmap reuseBitmap) {
        Intrinsics.checkNotNullParameter(config, "config");
        SharpPDecoder sharpPDecoder = new SharpPDecoder();
        this.mDecoder = sharpPDecoder;
        SharpPDecoder.SharpPFeature sharpPFeature = new SharpPDecoder.SharpPFeature();
        SharpPDecoder sharpPDecoder2 = this.mDecoder;
        Integer valueOf = sharpPDecoder2 != null ? Integer.valueOf(sharpPDecoder2.ParseHeader2(path, sharpPFeature)) : null;
        if (valueOf == null || valueOf.intValue() != 0) {
            return null;
        }
        SharpPDecoder sharpPDecoder3 = this.mDecoder;
        Long valueOf2 = sharpPDecoder3 != null ? Long.valueOf(sharpPDecoder3.CreateDecoder2(path)) : null;
        if ((valueOf2 == null || valueOf2.longValue() != 0) && valueOf2 != null) {
            if (reuseBitmap == null) {
                reuseBitmap = Bitmap.createBitmap(dstWidth, dstHeight, config);
            }
            int i3 = sharpPFeature.layerNum;
            int i16 = 0;
            for (int i17 = 0; i17 < i3; i17++) {
                Integer a16 = a(valueOf2.longValue(), i17, reuseBitmap, 0);
                if (a16 == null || a16.intValue() != 0) {
                    QLog.d(f239037c, 1, "decodeSharpP error:layerNo=" + i17 + ",status=" + a16);
                    i16++;
                }
            }
            SharpPDecoder sharpPDecoder4 = this.mDecoder;
            if (sharpPDecoder4 != null) {
                sharpPDecoder4.CloseDecoder2(valueOf2.longValue());
            }
            if (i16 == sharpPFeature.layerNum) {
                return null;
            }
            return reuseBitmap;
        }
        QLog.d(f239037c, 1, "decodeSharpPInNative error:hDec=0 or null");
        return null;
    }

    public final BitmapFactory.Options c(String path) {
        this.mDecoder = new SharpPDecoder();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = -1;
        options.outHeight = -1;
        SharpPDecoder sharpPDecoder = this.mDecoder;
        if (sharpPDecoder != null) {
            SharpPDecoder.SharpPFeature sharpPFeature = new SharpPDecoder.SharpPFeature();
            SharpPDecoder sharpPDecoder2 = this.mDecoder;
            Integer valueOf = sharpPDecoder2 != null ? Integer.valueOf(sharpPDecoder2.ParseHeader2(path, sharpPFeature)) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                options.outWidth = sharpPFeature.width;
                options.outHeight = sharpPFeature.height;
            }
        }
        return options;
    }
}
