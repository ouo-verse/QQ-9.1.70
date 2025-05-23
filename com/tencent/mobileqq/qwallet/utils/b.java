package com.tencent.mobileqq.qwallet.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.DownloadParams;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.utils.eh;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/utils/b;", "", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "b", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "()Lcom/tencent/image/DownloadParams$DecodeHandler;", "FAST_BLUR_DECODER_50", "c", "a", "FAST_BLUR_DECODER_20", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f279250a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final DownloadParams.DecodeHandler FAST_BLUR_DECODER_50 = new a(50);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final DownloadParams.DecodeHandler FAST_BLUR_DECODER_20 = new a(20);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/utils/b$a;", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "Lcom/tencent/image/DownloadParams;", "downloadParams", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, TencentLocation.RUN_MODE, "", "a", "I", "mRadius", "<init>", "(I)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements DownloadParams.DecodeHandler {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int mRadius;

        public a(int i3) {
            this.mRadius = i3;
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        @NotNull
        public Bitmap run(@NotNull DownloadParams downloadParams, @NotNull Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i3 = downloadParams.reqHeight;
            if (width > 0 && height > 0 && i3 > 0) {
                int i16 = (width * i3) / height;
                if (i3 < height) {
                    height = i3;
                    width = i16;
                }
                try {
                    Bitmap newBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
                    new Canvas(newBitmap).drawBitmap(bitmap, (Rect) null, new Rect(0, 0, width, height), new Paint(7));
                    eh.a(newBitmap, this.mRadius);
                    Intrinsics.checkNotNullExpressionValue(newBitmap, "newBitmap");
                    return newBitmap;
                } catch (Exception | OutOfMemoryError unused) {
                }
            }
            return bitmap;
        }
    }

    b() {
    }

    @NotNull
    public final DownloadParams.DecodeHandler a() {
        return FAST_BLUR_DECODER_20;
    }

    @NotNull
    public final DownloadParams.DecodeHandler b() {
        return FAST_BLUR_DECODER_50;
    }
}
