package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.TintTypedArray;
import com.tencent.mobileqq.R;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f33883a = {R.attr.a88};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f33884b = {R.attr.a8c};

    public static void a(@NonNull Context context) {
        e(context, f33883a, "Theme.AppCompat");
    }

    private static void b(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w0.a.Ca, i3, i16);
        boolean z16 = obtainStyledAttributes.getBoolean(w0.a.Ea, false);
        obtainStyledAttributes.recycle();
        if (z16) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.amu, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    public static void c(@NonNull Context context) {
        e(context, f33884b, "Theme.MaterialComponents");
    }

    private static void d(@NonNull Context context, AttributeSet attributeSet, @NonNull @StyleableRes int[] iArr, @AttrRes int i3, @StyleRes int i16, @Nullable @StyleableRes int... iArr2) {
        boolean z16;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w0.a.Ca, i3, i16);
        boolean z17 = false;
        if (!obtainStyledAttributes.getBoolean(w0.a.Fa, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 != null && iArr2.length != 0) {
            z16 = f(context, attributeSet, iArr, i3, i16, iArr2);
        } else {
            if (obtainStyledAttributes.getResourceId(w0.a.Da, -1) != -1) {
                z17 = true;
            }
            z16 = z17;
        }
        obtainStyledAttributes.recycle();
        if (z16) {
        } else {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void e(@NonNull Context context, @NonNull int[] iArr, String str) {
        if (g(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    private static boolean f(@NonNull Context context, AttributeSet attributeSet, @NonNull @StyleableRes int[] iArr, @AttrRes int i3, @StyleRes int i16, @NonNull @StyleableRes int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, i16);
        for (int i17 : iArr2) {
            if (obtainStyledAttributes.getResourceId(i17, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    private static boolean g(@NonNull Context context, @NonNull int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (!obtainStyledAttributes.hasValue(i3)) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    @NonNull
    public static TypedArray h(@NonNull Context context, AttributeSet attributeSet, @NonNull @StyleableRes int[] iArr, @AttrRes int i3, @StyleRes int i16, @StyleableRes int... iArr2) {
        b(context, attributeSet, i3, i16);
        d(context, attributeSet, iArr, i3, i16, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i3, i16);
    }

    public static TintTypedArray i(@NonNull Context context, AttributeSet attributeSet, @NonNull @StyleableRes int[] iArr, @AttrRes int i3, @StyleRes int i16, @StyleableRes int... iArr2) {
        b(context, attributeSet, i3, i16);
        d(context, attributeSet, iArr, i3, i16, iArr2);
        return TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i3, i16);
    }
}
