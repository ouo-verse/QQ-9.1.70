package com.tencent.mobileqq.onlinestatus.utils;

import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.BatteryDrawable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"Landroid/graphics/drawable/Drawable;", "drawable", "a", "qqonlinestatus-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class j {
    @Nullable
    public static final Drawable a(@Nullable Drawable drawable) {
        Drawable newDrawable;
        Drawable mutate;
        if (drawable == null) {
            return null;
        }
        try {
            if (drawable instanceof SkinnableBitmapDrawable) {
                mutate = ((SkinnableBitmapDrawable) drawable).mutate2();
            } else if (drawable instanceof BatteryDrawable) {
                mutate = ((BatteryDrawable) drawable).customMute();
            } else {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState == null || (newDrawable = constantState.newDrawable()) == null) {
                    return null;
                }
                mutate = newDrawable.mutate();
            }
            return mutate;
        } catch (Throwable th5) {
            QLog.e("ImageUtils", 1, th5, new Object[0]);
            return null;
        }
    }
}
