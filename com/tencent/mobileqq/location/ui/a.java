package com.tencent.mobileqq.location.ui;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.theme.SkinnableBitmapDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0005"}, d2 = {"Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "d", "a", "qq-location-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    @NotNull
    public static final Drawable a(@NotNull Context context, @NotNull Drawable d16) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(d16, "d");
        boolean z16 = d16 instanceof SkinnableBitmapDrawable;
        if (!z16 && !(d16 instanceof BitmapDrawable)) {
            return d16;
        }
        if (z16) {
            bitmap = ((SkinnableBitmapDrawable) d16).getBitmap();
        } else if (d16 instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) d16).getBitmap();
        } else {
            bitmap = null;
        }
        Intrinsics.checkNotNull(bitmap);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap);
        Resources resources = context.getResources();
        if (resources != null) {
            if (createBitmap == null) {
                createBitmap = bitmap;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmap);
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(resources, createBitmap);
            bitmapDrawable2.setAlpha(127);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_pressed, R.attr.state_enabled}, bitmapDrawable2);
            stateListDrawable.addState(new int[]{R.attr.state_focused}, bitmapDrawable);
            stateListDrawable.addState(new int[0], bitmapDrawable);
            return stateListDrawable;
        }
        return d16;
    }
}
