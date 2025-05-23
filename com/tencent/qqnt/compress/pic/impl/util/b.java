package com.tencent.qqnt.compress.pic.impl.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bJ3\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/compress/pic/impl/util/b;", "", "Ljava/io/File;", "imageFile", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap$CompressFormat;", "format", "", CustomImageProps.QUALITY, "c", "", "destination", "", "d", "(Landroid/graphics/Bitmap;Ljava/lang/String;Landroid/graphics/Bitmap$CompressFormat;I)V", "a", "originalBitmap", "b", "<init>", "()V", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f355760a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39561);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f355760a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Bitmap a(@NotNull Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap);
        }
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(bitmap.widt\u2026 Bitmap.Config.ARGB_8888)");
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        Unit unit = Unit.INSTANCE;
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void b(@NotNull Bitmap originalBitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) originalBitmap);
            return;
        }
        Intrinsics.checkNotNullParameter(originalBitmap, "originalBitmap");
        Drawable drawable = BaseApplication.context.getResources().getDrawable(R.drawable.oah, null);
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        int width = (originalBitmap.getWidth() - (bitmap.getWidth() / 2)) - 7;
        int height = (originalBitmap.getHeight() - (bitmap.getHeight() / 2)) - 7;
        if (width > 0 && height > 0) {
            new Canvas(originalBitmap).drawBitmap(bitmap, (Rect) null, new Rect(width, height, (bitmap.getWidth() / 2) + width, (bitmap.getHeight() / 2) + height), new Paint(2));
        }
    }

    @NotNull
    public final File c(@NotNull File imageFile, @NotNull Bitmap bitmap, @NotNull Bitmap.CompressFormat format, int quality) {
        String substringBeforeLast$default;
        String destination;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, imageFile, bitmap, format, Integer.valueOf(quality));
        }
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(format, "format");
        if (format == c.a(imageFile)) {
            destination = imageFile.getAbsolutePath();
        } else {
            String absolutePath = imageFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "imageFile.absolutePath");
            substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(absolutePath, '.', (String) null, 2, (Object) null);
            destination = substringBeforeLast$default + "." + c.b(format);
        }
        imageFile.delete();
        Intrinsics.checkNotNullExpressionValue(destination, "destination");
        d(bitmap, destination, format, quality);
        return new File(destination);
    }

    public final void d(@NotNull Bitmap bitmap, @NotNull String destination, @NotNull Bitmap.CompressFormat format, int quality) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bitmap, destination, format, Integer.valueOf(quality));
            return;
        }
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(format, "format");
        File parentFile = new File(destination).getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(destination);
        try {
            bitmap.compress(format, quality, fileOutputStream);
            fileOutputStream.flush();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }
}
