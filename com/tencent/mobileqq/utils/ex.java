package com.tencent.mobileqq.utils;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0007\u001a\u00020\u0000*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0017\u0010\u000b\u001a\u0004\u0018\u00010\b*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0015\u0010\u000f\u001a\u00020\f*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0015\u0010\u0013\u001a\u00020\u0000*\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"", "Landroid/graphics/drawable/Drawable;", "c", "(I)Landroid/graphics/drawable/Drawable;", "drawable", "a", "(I)I", "color", "Landroid/content/res/ColorStateList;", "b", "(I)Landroid/content/res/ColorStateList;", "colorStateList", "", "e", "(I)Ljava/lang/String;", HippyControllerProps.STRING, "", "d", "(Ljava/lang/Number;)I", "px", "drawer-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ex {
    public static final int a(int i3) {
        return ContextCompat.getColor(MobileQQ.sMobileQQ.getBaseContext(), i3);
    }

    @Nullable
    public static final ColorStateList b(int i3) {
        return ContextCompat.getColorStateList(MobileQQ.sMobileQQ.getBaseContext(), i3);
    }

    @Nullable
    public static final Drawable c(int i3) {
        return ResourcesCompat.getDrawable(MobileQQ.sMobileQQ.getBaseContext().getResources(), i3, null);
    }

    public static final int d(@NotNull Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return ScreenUtil.dip2px(number.floatValue());
    }

    @NotNull
    public static final String e(int i3) {
        String qqStr = HardCodeUtil.qqStr(i3);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(this)");
        return qqStr;
    }
}
