package com.tencent.mobileqq.qwallet.utils;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0004J\u001c\u0010\f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\u000b\u001a\u00020\u0004H\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/utils/m;", "", "Landroid/content/Context;", "context", "", "attrId", "a", "dimenRes", "b", "", "colorStr", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "c", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f279290a = new m();

    m() {
    }

    @ColorInt
    public final int a(@NotNull Context context, int attrId) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(attrId, typedValue, true);
        return ContextCompat.getColor(context, typedValue.resourceId);
    }

    public final int b(@NotNull Context context, @DimenRes int dimenRes) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) context.getResources().getDimension(dimenRes);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @ColorInt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int c(@Nullable String colorStr, @ColorInt int defaultColor) {
        boolean z16;
        boolean isBlank;
        if (colorStr != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(colorStr);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return defaultColor;
                }
                try {
                    return Color.parseColor(colorStr);
                } catch (Exception unused) {
                    return defaultColor;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
