package com.tencent.mobileqq.guild.util;

import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002\"\u0015\u0010\u0005\u001a\u00020\u0000*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0002\"\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\u0005\u001a\u00020\u0000*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\b\"\u0015\u0010\u000b\u001a\u00020\u0000*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\b\"\u0015\u0010\u000f\u001a\u00020\f*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0015\u0010\u0011\u001a\u00020\u0000*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\b\"\u0015\u0010\u0011\u001a\u00020\u0000*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0002\"(\u0010\u0019\u001a\u00020\u0000*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00008F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"", "a", "(F)F", "dp", "e", "px", "", "b", "(I)F", "f", "g", "sp", "", tl.h.F, "(I)Ljava/lang/String;", HippyControllerProps.STRING, "d", "dp2px", "c", "Landroid/widget/TextView;", "value", "getLineSpacingPx", "(Landroid/widget/TextView;)F", "i", "(Landroid/widget/TextView;F)V", "lineSpacingPx", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class cw {
    public static final float a(float f16) {
        return TypedValue.applyDimension(1, f16, Resources.getSystem().getDisplayMetrics());
    }

    public static final float b(int i3) {
        return TypedValue.applyDimension(1, i3, Resources.getSystem().getDisplayMetrics());
    }

    public static final float c(float f16) {
        return ViewUtils.dpToPx(f16);
    }

    public static final float d(int i3) {
        return ViewUtils.dpToPx(i3);
    }

    public static final float e(float f16) {
        return TypedValue.applyDimension(0, f16, Resources.getSystem().getDisplayMetrics());
    }

    public static final float f(int i3) {
        return TypedValue.applyDimension(0, i3, Resources.getSystem().getDisplayMetrics());
    }

    public static final float g(int i3) {
        return TypedValue.applyDimension(2, i3, Resources.getSystem().getDisplayMetrics());
    }

    @NotNull
    public static final String h(int i3) {
        String string = BaseApplication.getContext().getResources().getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().resources.getString(this)");
        return string;
    }

    public static final void i(@NotNull TextView textView, float f16) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (((int) f16) != fontMetricsInt) {
            textView.setLineSpacing(f16 - fontMetricsInt, 1.0f);
        }
    }
}
