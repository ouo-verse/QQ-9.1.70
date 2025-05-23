package com.tencent.mobileqq.webview.view;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.x;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\"\u0015\u0010\u0007\u001a\u00020\u0000*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0015\u0010\t\u001a\u00020\u0000*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u0017\u0010\r\u001a\u0004\u0018\u00010\n*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0015\u0010\u0010\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0015\u0010\u0012\u001a\u00020\u0000*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006\"\u0015\u0010\u0015\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"", "", "colorName", "Landroid/content/res/ColorStateList;", h.F, "e", "(I)I", "px", "d", "idpx", "Landroid/graphics/drawable/Drawable;", "c", "(I)Landroid/graphics/drawable/Drawable;", "drawable", "f", "(I)Ljava/lang/String;", HippyControllerProps.STRING, "a", "color", "b", "(I)Landroid/content/res/ColorStateList;", NodeProps.COLORS, "g", "text", "webview_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {
    public static final int a(int i3) {
        return BaseApplication.getContext().getResources().getColor(i3);
    }

    @NotNull
    public static final ColorStateList b(int i3) {
        ColorStateList colorStateList = BaseApplication.getContext().getResources().getColorStateList(i3);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "getContext().resources.getColorStateList(this)");
        return colorStateList;
    }

    @Nullable
    public static final Drawable c(int i3) {
        Object m476constructorimpl;
        Object obj = null;
        if (i3 == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(BaseApplication.getContext().getResources().getDrawable(i3));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (!Result.m482isFailureimpl(m476constructorimpl)) {
            obj = m476constructorimpl;
        }
        return (Drawable) obj;
    }

    public static final int d(int i3) {
        return BaseApplication.getContext().getResources().getDimensionPixelOffset(i3);
    }

    public static final int e(int i3) {
        return ViewUtils.dip2px(i3);
    }

    @NotNull
    public static final String f(int i3) {
        String string = BaseApplication.getContext().getResources().getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().resources.getString(this)");
        return string;
    }

    @NotNull
    public static final String g(int i3) {
        String string = BaseApplication.getContext().getResources().getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().resources.getString(this)");
        return string;
    }

    @NotNull
    public static final ColorStateList h(int i3, @NotNull String colorName) {
        Intrinsics.checkNotNullParameter(colorName, "colorName");
        ColorStateList colorStateList = BaseApplication.getContext().getResources().getColorStateList(i3);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "getContext().resources.getColorStateList(this)");
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(colorStateList.getClass()), Reflection.getOrCreateKotlinClass(ColorStateList.class))) {
            int a16 = ((x) aa.k(x.class)).a(colorName);
            if (QLog.isColorLevel()) {
                QLog.d("web.ViewExt", 2, "tokenColors hook failed [" + colorName + "] fallback to 0x[" + Util.toHexString(a16) + "]");
            }
            ColorStateList valueOf = ColorStateList.valueOf(a16);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(color)");
            return valueOf;
        }
        return colorStateList;
    }
}
