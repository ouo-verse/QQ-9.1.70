package h1;

import android.R;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f404037a = true;

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f404038b = {R.attr.state_pressed};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f404039c = {R.attr.state_hovered, R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f404040d = {R.attr.state_focused};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f404041e = {R.attr.state_hovered};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f404042f = {R.attr.state_selected, R.attr.state_pressed};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f404043g = {R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f404044h = {R.attr.state_selected, R.attr.state_focused};

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f404045i = {R.attr.state_selected, R.attr.state_hovered};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f404046j = {R.attr.state_selected};

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f404047k = {R.attr.state_enabled, R.attr.state_pressed};

    /* renamed from: l, reason: collision with root package name */
    @VisibleForTesting
    static final String f404048l = b.class.getSimpleName();

    b() {
    }

    @NonNull
    public static ColorStateList a(@Nullable ColorStateList colorStateList) {
        if (f404037a) {
            return new ColorStateList(new int[][]{f404046j, StateSet.NOTHING}, new int[]{c(colorStateList, f404042f), c(colorStateList, f404038b)});
        }
        int[] iArr = f404042f;
        int[] iArr2 = f404043g;
        int[] iArr3 = f404044h;
        int[] iArr4 = f404045i;
        int[] iArr5 = f404038b;
        int[] iArr6 = f404039c;
        int[] iArr7 = f404040d;
        int[] iArr8 = f404041e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f404046j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{c(colorStateList, iArr), c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), 0, c(colorStateList, iArr5), c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), 0});
    }

    @ColorInt
    @TargetApi(21)
    private static int b(@ColorInt int i3) {
        return ColorUtils.setAlphaComponent(i3, Math.min(Color.alpha(i3) * 2, 255));
    }

    @ColorInt
    private static int c(@Nullable ColorStateList colorStateList, int[] iArr) {
        int i3;
        if (colorStateList != null) {
            i3 = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        } else {
            i3 = 0;
        }
        if (f404037a) {
            return b(i3);
        }
        return i3;
    }

    @NonNull
    public static ColorStateList d(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f404047k, 0)) != 0) {
                Log.w(f404048l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }
            return colorStateList;
        }
        return ColorStateList.valueOf(0);
    }

    public static boolean e(@NonNull int[] iArr) {
        boolean z16 = false;
        boolean z17 = false;
        for (int i3 : iArr) {
            if (i3 == 16842910) {
                z16 = true;
            } else if (i3 == 16842908 || i3 == 16842919 || i3 == 16843623) {
                z17 = true;
            }
        }
        if (!z16 || !z17) {
            return false;
        }
        return true;
    }
}
