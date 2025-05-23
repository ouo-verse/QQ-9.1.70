package m1;

import android.graphics.Bitmap;
import com.google.android.renderscript.Range2d;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a,\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0000\u001a\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0002H\u0000\u00a8\u0006\u0013"}, d2 = {"", "function", "Landroid/graphics/Bitmap;", "inputBitmap", "", "alphaAllowed", "", "b", "kotlin.jvm.PlatformType", "a", "tag", "", "sizeX", "sizeY", "Lcom/google/android/renderscript/Range2d;", "restriction", "d", MimeHelper.IMAGE_SUBTYPE_BITMAP, "e", "renderscript-toolkit_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class b {
    public static final Bitmap a(@NotNull Bitmap inputBitmap) {
        Intrinsics.checkNotNullParameter(inputBitmap, "inputBitmap");
        return Bitmap.createBitmap(inputBitmap.getWidth(), inputBitmap.getHeight(), inputBitmap.getConfig());
    }

    public static final void b(@NotNull String function, @NotNull Bitmap inputBitmap, boolean z16) {
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(function, "function");
        Intrinsics.checkNotNullParameter(inputBitmap, "inputBitmap");
        boolean z19 = true;
        if (z16) {
            if (inputBitmap.getConfig() != Bitmap.Config.ARGB_8888 && inputBitmap.getConfig() != Bitmap.Config.ALPHA_8) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (!z18) {
                throw new IllegalArgumentException(("RenderScript Toolkit. " + function + " supports only ARGB_8888 and ALPHA_8 bitmaps. " + inputBitmap.getConfig() + " provided.").toString());
            }
        } else {
            if (inputBitmap.getConfig() == Bitmap.Config.ARGB_8888) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                throw new IllegalArgumentException(("RenderScript Toolkit. " + function + " supports only ARGB_8888. " + inputBitmap.getConfig() + " provided.").toString());
            }
        }
        if (inputBitmap.getWidth() * e(inputBitmap) != inputBitmap.getRowBytes()) {
            z19 = false;
        }
        if (z19) {
            return;
        }
        throw new IllegalArgumentException(("RenderScript Toolkit " + function + ". Only bitmaps with rowSize equal to the width * vectorSize are currently supported. Provided were rowBytes=" + inputBitmap.getRowBytes() + ", width={" + inputBitmap.getWidth() + ", and vectorSize=" + e(inputBitmap) + '.').toString());
    }

    public static /* synthetic */ void c(String str, Bitmap bitmap, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        b(str, bitmap, z16);
    }

    public static final void d(@NotNull String tag, int i3, int i16, @Nullable Range2d range2d) {
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (range2d == null) {
            return;
        }
        boolean z19 = true;
        if (range2d.getStartX() < i3 && range2d.getEndX() <= i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (range2d.getStartY() < i16 && range2d.getEndY() <= i16) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (range2d.getStartX() < range2d.getEndX()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    if (range2d.getStartY() >= range2d.getEndY()) {
                        z19 = false;
                    }
                    if (z19) {
                        return;
                    }
                    throw new IllegalArgumentException(("RenderScript Toolkit " + tag + ". Restriction startY should be less than endY. " + range2d.getStartY() + " and " + range2d.getEndY() + " were provided respectively.").toString());
                }
                throw new IllegalArgumentException(("RenderScript Toolkit " + tag + ". Restriction startX should be less than endX. " + range2d.getStartX() + " and " + range2d.getEndX() + " were provided respectively.").toString());
            }
            throw new IllegalArgumentException(("RenderScript Toolkit " + tag + ". sizeY should be greater than restriction.startY and greater or equal to restriction.endY. " + i16 + ", " + range2d.getStartY() + ", and " + range2d.getEndY() + " were provided respectively.").toString());
        }
        throw new IllegalArgumentException(("RenderScript Toolkit " + tag + ". sizeX should be greater than restriction.startX and greater or equal to restriction.endX. " + i3 + ", " + range2d.getStartX() + ", and " + range2d.getEndX() + " were provided respectively.").toString());
    }

    public static final int e(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Bitmap.Config config = bitmap.getConfig();
        if (config != null) {
            int i3 = a.f415963a[config.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return 1;
                }
            } else {
                return 4;
            }
        }
        throw new IllegalArgumentException("RenderScript Toolkit. Only ARGB_8888 and ALPHA_8 Bitmap are supported.");
    }
}
