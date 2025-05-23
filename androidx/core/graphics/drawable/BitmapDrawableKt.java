package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.ams.dsdk.core.DKConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u00a8\u0006\u0005"}, d2 = {"toDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "Landroid/graphics/Bitmap;", DKConfiguration.Directory.RESOURCES, "Landroid/content/res/Resources;", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class BitmapDrawableKt {
    @NotNull
    public static final BitmapDrawable toDrawable(@NotNull Bitmap toDrawable, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(toDrawable, "$this$toDrawable");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new BitmapDrawable(resources, toDrawable);
    }
}
