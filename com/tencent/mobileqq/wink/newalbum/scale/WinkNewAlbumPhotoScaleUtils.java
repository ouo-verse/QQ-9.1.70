package com.tencent.mobileqq.wink.newalbum.scale;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LibraPicLoader;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u000fR#\u0010\u0016\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0016\u0010!\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/scale/WinkNewAlbumPhotoScaleUtils;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "image", "", "thumbnailSize", "Landroid/graphics/Bitmap;", "e", "d", "", "imagePath", "newWidth", "newHeight", "b", "a", "", "f", "Landroid/content/ContentResolver;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "c", "()Landroid/content/ContentResolver;", "contentResolver", "I", "getThumbByLibraCacheCount", "", "J", "getThumbByLibraCacheCost", "getThumbByContentResolverCount", "getThumbByContentResolverCost", "g", "getBitmapWithSizeCount", h.F, "getBitmapWithSizeCost", "", "i", "Z", "useThumbScale", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNewAlbumPhotoScaleUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkNewAlbumPhotoScaleUtils f324337a = new WinkNewAlbumPhotoScaleUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy contentResolver;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int getThumbByLibraCacheCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long getThumbByLibraCacheCost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int getThumbByContentResolverCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long getThumbByContentResolverCost;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int getBitmapWithSizeCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long getBitmapWithSizeCost;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static boolean useThumbScale;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ContentResolver>() { // from class: com.tencent.mobileqq.wink.newalbum.scale.WinkNewAlbumPhotoScaleUtils$contentResolver$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ContentResolver invoke() {
                return BaseApplication.context.getContentResolver();
            }
        });
        contentResolver = lazy;
        useThumbScale = true;
    }

    WinkNewAlbumPhotoScaleUtils() {
    }

    private final Bitmap b(String imagePath, int newWidth, int newHeight) {
        int i3;
        if (imagePath == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imagePath, options);
        int i16 = options.outHeight;
        int i17 = options.outWidth;
        if (i16 >= 224 && i17 >= 224) {
            if (QLog.isDevelopLevel()) {
                w53.b.a("WinkNewAlbumPhotoScaleUtils", "getBitmapWithSize imageWidth:" + i17 + ", imageHeight:" + i16 + ", path:" + imagePath);
            }
            if (i16 <= newHeight && i17 <= newWidth) {
                i3 = 1;
            } else {
                int i18 = i16 / 2;
                int i19 = i17 / 2;
                i3 = 1;
                while (i18 / i3 >= newHeight && i19 / i3 >= newWidth) {
                    i3 *= 2;
                }
            }
            options.inSampleSize = i3;
            options.inJustDecodeBounds = false;
            try {
                return Bitmap.createScaledBitmap(BitmapFactory.decodeFile(imagePath, options), newWidth, newHeight, true);
            } catch (Exception e16) {
                QLog.d("WinkNewAlbumPhotoScaleUtils", 1, e16, new Object[0]);
                return null;
            }
        }
        w53.b.f("WinkNewAlbumPhotoScaleUtils", "getBitmapWithSize error, imageHeight:" + i16 + ", imageWidth:" + i17);
        return null;
    }

    private final ContentResolver c() {
        return (ContentResolver) contentResolver.getValue();
    }

    private final Bitmap d(LocalMediaInfo image, int thumbnailSize) {
        if (!useThumbScale) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(c(), image._id, 1, null);
        if (thumbnail != null && thumbnail.getWidth() >= 224 && thumbnail.getHeight() >= 224) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(thumbnail, thumbnailSize, thumbnailSize, true);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            getThumbByContentResolverCount++;
            getThumbByContentResolverCost += currentTimeMillis2;
            if (QLog.isDevelopLevel()) {
                w53.b.a("WinkNewAlbumPhotoScaleUtils", "[getThumbByContentResolver] thumb width:" + thumbnail.getWidth() + ", height:" + thumbnail.getHeight() + ", oriwidth:" + image.mediaWidth + ", oriheight:" + image.mediaHeight + ", path:" + image.path + ", cost=" + currentTimeMillis2);
            }
            return createScaledBitmap;
        }
        if (thumbnail == null) {
            w53.b.f("WinkNewAlbumPhotoScaleUtils", "getThumbByContentResolver thumbnail == null, path:" + image.path);
        } else {
            w53.b.f("WinkNewAlbumPhotoScaleUtils", "getThumbByContentResolver width:" + thumbnail.getWidth() + " height:" + thumbnail.getHeight() + " path:" + image.path);
        }
        return null;
    }

    private final Bitmap e(LocalMediaInfo image, int thumbnailSize) {
        LibraPicLoader libraPicLoader;
        String str;
        Bitmap b16;
        if (!useThumbScale) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        IPicLoader d16 = QQPicLoader.f201806a.d();
        if (d16 instanceof LibraPicLoader) {
            libraPicLoader = (LibraPicLoader) d16;
        } else {
            libraPicLoader = null;
        }
        if (libraPicLoader != null) {
            Option obtain = Option.obtain();
            obtain.setLocalPath(image.path);
            str = libraPicLoader.getLocalSmallBitmapPath(obtain, 300);
        } else {
            str = null;
        }
        if (str == null || (b16 = b(str, thumbnailSize, thumbnailSize)) == null) {
            return null;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        getThumbByLibraCacheCount++;
        getThumbByLibraCacheCost += currentTimeMillis2;
        w53.b.a("WinkNewAlbumPhotoScaleUtils", "[getThumbByLibraCache] cost=" + currentTimeMillis2);
        return b16;
    }

    @Nullable
    public final Bitmap a(@NotNull LocalMediaInfo image, int thumbnailSize) {
        Intrinsics.checkNotNullParameter(image, "image");
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap e16 = e(image, thumbnailSize);
        if (e16 == null && (e16 = d(image, thumbnailSize)) == null) {
            e16 = b(image.path, thumbnailSize, thumbnailSize);
            getBitmapWithSizeCount++;
            getBitmapWithSizeCost += System.currentTimeMillis() - currentTimeMillis;
        }
        w53.b.a("WinkNewAlbumPhotoScaleUtils", "[decodeThumbnail] cost=" + (System.currentTimeMillis() - currentTimeMillis));
        return e16;
    }

    public final void f() {
        int i3 = getThumbByLibraCacheCount;
        if (i3 > 0) {
            w53.b.f("WinkNewAlbumPhotoScaleUtils", "getThumbByLibraCacheCount:" + i3 + ", avgcost:" + (getThumbByLibraCacheCost / i3));
        }
        int i16 = getThumbByContentResolverCount;
        if (i16 > 0) {
            w53.b.f("WinkNewAlbumPhotoScaleUtils", "getThumbByContentResolverCount:" + i16 + ", avgcost:" + (getThumbByContentResolverCost / i16));
        }
        int i17 = getBitmapWithSizeCount;
        if (i17 > 0) {
            w53.b.f("WinkNewAlbumPhotoScaleUtils", "getBitmapWithSizeCount:" + i17 + ", avgcost:" + (getBitmapWithSizeCost / i17));
        }
    }
}
