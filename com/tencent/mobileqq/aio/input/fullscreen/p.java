package com.tencent.mobileqq.aio.input.fullscreen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.Utils;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J,\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J$\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/input/fullscreen/p;", "", "", "imagePath", "Landroid/graphics/BitmapFactory$Options;", "options", "", "retryCount", "maxRetry", "Landroid/graphics/Bitmap;", "c", "picPath", "Landroid/net/Uri;", "originUri", "", "isRwa", "Lcom/tencent/mobileqq/aio/input/fullscreen/a;", "a", "Landroid/graphics/drawable/Drawable;", "b", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f189662a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55510);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f189662a = new p();
        }
    }

    p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Bitmap c(String imagePath, BitmapFactory.Options options, int retryCount, int maxRetry) {
        Bitmap bitmap;
        try {
            bitmap = SafeBitmapFactory.safeDecode(imagePath, options);
        } catch (OutOfMemoryError unused) {
            if (QLog.isColorLevel()) {
                QLog.i("PicOrcUtils", 2, "retry:" + retryCount + ", sampleSize:" + options.inSampleSize);
            }
            bitmap = null;
        }
        if (bitmap == null && retryCount < maxRetry) {
            options.inSampleSize *= 2;
            return c(imagePath, options, retryCount + 1, maxRetry);
        }
        return bitmap;
    }

    @Nullable
    public final a a(@Nullable String picPath, @Nullable Uri originUri, boolean isRwa) {
        Drawable b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, this, picPath, originUri, Boolean.valueOf(isRwa));
        }
        if (picPath == null || picPath.length() == 0) {
            z16 = true;
        }
        if (z16 || !c81.a.g(picPath) || (b16 = b(picPath)) == null) {
            return null;
        }
        return new a(b16, picPath, originUri, isRwa);
    }

    @Nullable
    public final Drawable b(@NotNull String picPath) {
        float f16;
        float f17;
        float f18;
        float f19;
        float coerceAtLeast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) picPath);
        }
        Intrinsics.checkNotNullParameter(picPath, "picPath");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(picPath, options);
        ThumbWidthHeightDP thumbWidthHeightDP = CommonImgThumbHelper.getThumbWidthHeightDP(false);
        int i3 = thumbWidthHeightDP.mMinWidth;
        int i16 = thumbWidthHeightDP.mMinHeight;
        int i17 = thumbWidthHeightDP.mMaxWidth;
        int i18 = thumbWidthHeightDP.mMaxHeight;
        int i19 = options.outWidth;
        int i26 = options.outHeight;
        if (i19 > 0 && i26 > 0) {
            if (i19 >= i3 && i26 >= i16) {
                if (i19 < i17 && i26 < i18) {
                    i3 = i19;
                    i16 = i26;
                } else {
                    if (i19 > i26) {
                        f16 = i17;
                        f17 = i19;
                    } else {
                        f16 = i18;
                        f17 = i26;
                    }
                    float f26 = f16 / f17;
                    if (i19 > i26) {
                        f18 = i16;
                        f19 = i26;
                    } else {
                        f18 = i3;
                        f19 = i19;
                    }
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(f26, f18 / f19);
                    i3 = (int) ((i19 * coerceAtLeast) + 0.5f);
                    i16 = (int) ((i26 * coerceAtLeast) + 0.5f);
                }
            } else if (i19 < i26) {
                i16 = RangesKt___RangesKt.coerceAtMost((int) ((i26 * (i3 / i19)) + 0.5f), i18);
            } else {
                i3 = RangesKt___RangesKt.coerceAtMost((int) ((i19 * (i16 / i26)) + 0.5f), i17);
            }
        } else {
            i3 = 99;
            i16 = 99;
        }
        float f27 = BaseApplication.context.getResources().getDisplayMetrics().densityDpi / 160.0f;
        int i27 = (int) ((i3 * f27) + 0.5f);
        int i28 = (int) ((i16 * f27) + 0.5f);
        options.inSampleSize = Utils.calculateInSampleSize(options, i27, i28);
        options.inJustDecodeBounds = false;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(BaseApplication.context.getResources(), ThumbnailUtils.extractThumbnail(c(picPath, options, 1, 4), i27, i28, 2));
        bitmapDrawable.setBounds(0, 0, i27, i28);
        return bitmapDrawable;
    }
}
