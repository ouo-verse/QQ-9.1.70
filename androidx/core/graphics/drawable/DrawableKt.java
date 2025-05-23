package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a2\u0010\b\u001a\u00020\t*\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00042\b\b\u0003\u0010\u000b\u001a\u00020\u00042\b\b\u0003\u0010\f\u001a\u00020\u00042\b\b\u0003\u0010\r\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"toBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "width", "", "height", DownloadInfo.spKey_Config, "Landroid/graphics/Bitmap$Config;", "updateBounds", "", "left", "top", "right", "bottom", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class DrawableKt {
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:
    
        if (r0.getConfig() == r9) goto L7;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Bitmap toBitmap(@NotNull Drawable toBitmap, @Px int i3, @Px int i16, @Nullable Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(toBitmap, "$this$toBitmap");
        if (toBitmap instanceof BitmapDrawable) {
            if (config != null) {
                Bitmap bitmap = ((BitmapDrawable) toBitmap).getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) toBitmap;
            if (i3 == bitmapDrawable.getIntrinsicWidth() && i16 == bitmapDrawable.getIntrinsicHeight()) {
                Bitmap bitmap2 = bitmapDrawable.getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap2, "bitmap");
                return bitmap2;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i3, i16, true);
            Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "Bitmap.createScaledBitma\u2026map, width, height, true)");
            return createScaledBitmap;
        }
        Rect bounds = toBitmap.getBounds();
        int i17 = bounds.left;
        int i18 = bounds.top;
        int i19 = bounds.right;
        int i26 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmap3 = Bitmap.createBitmap(i3, i16, config);
        toBitmap.setBounds(0, 0, i3, i16);
        toBitmap.draw(new Canvas(bitmap3));
        toBitmap.setBounds(i17, i18, i19, i26);
        Intrinsics.checkNotNullExpressionValue(bitmap3, "bitmap");
        return bitmap3;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i3, int i16, Bitmap.Config config, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = drawable.getIntrinsicWidth();
        }
        if ((i17 & 2) != 0) {
            i16 = drawable.getIntrinsicHeight();
        }
        if ((i17 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i3, i16, config);
    }

    public static final void updateBounds(@NotNull Drawable updateBounds, @Px int i3, @Px int i16, @Px int i17, @Px int i18) {
        Intrinsics.checkNotNullParameter(updateBounds, "$this$updateBounds");
        updateBounds.setBounds(i3, i16, i17, i18);
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 1) != 0) {
            i3 = drawable.getBounds().left;
        }
        if ((i19 & 2) != 0) {
            i16 = drawable.getBounds().top;
        }
        if ((i19 & 4) != 0) {
            i17 = drawable.getBounds().right;
        }
        if ((i19 & 8) != 0) {
            i18 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i3, i16, i17, i18);
    }
}
