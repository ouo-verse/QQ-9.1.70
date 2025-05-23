package com.tencent.mobileqq.aio.background;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/background/f;", "", "", "watermarkText", "", "textSize", "width", "height", "Landroid/graphics/Bitmap;", "a", "b", "I", "horizontalPadding", "c", "verticalPadding", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f188221a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int horizontalPadding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int verticalPadding;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34970);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f188221a = new f();
        horizontalPadding = l.b(100);
        verticalPadding = l.b(180);
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Bitmap a(@NotNull String watermarkText, int textSize, int width, int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, watermarkText, Integer.valueOf(textSize), Integer.valueOf(width), Integer.valueOf(height));
        }
        Intrinsics.checkNotNullParameter(watermarkText, "watermarkText");
        Bitmap waterBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(waterBitmap);
        Paint paint = new Paint();
        paint.setColor(ResourcesCompat.getColor(BaseApplication.context.getResources(), R.color.qui_common_text_primary, null));
        paint.setAlpha(16);
        paint.setTextSize(l.b(textSize));
        paint.setAntiAlias(true);
        Rect rect = new Rect();
        paint.getTextBounds(watermarkText, 0, watermarkText.length(), rect);
        int width2 = rect.width();
        int height2 = rect.height();
        canvas.save();
        canvas.rotate(-30.0f, width / 2, height / 2);
        for (int i3 = 100; i3 + height2 < height; i3 += verticalPadding + height2) {
            for (int i16 = 0; i16 < width; i16 += horizontalPadding + width2) {
                canvas.drawText(watermarkText, i16, i3, paint);
            }
        }
        canvas.restore();
        Intrinsics.checkNotNullExpressionValue(waterBitmap, "waterBitmap");
        return waterBitmap;
    }
}
