package k1;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ContextThemeWrapper;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f411380a = {R.attr.theme, com.tencent.mobileqq.R.attr.bgw};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f411381b = {com.tencent.mobileqq.R.attr.av9};

    @StyleRes
    private static int a(@NonNull Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f411380a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        if (resourceId == 0) {
            return resourceId2;
        }
        return resourceId;
    }

    @StyleRes
    private static int b(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f411381b, i3, i16);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    @NonNull
    public static Context c(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        boolean z16;
        int b16 = b(context, attributeSet, i3, i16);
        if ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).getThemeResId() == b16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (b16 != 0 && !z16) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, b16);
            int a16 = a(context, attributeSet);
            if (a16 != 0) {
                contextThemeWrapper.getTheme().applyStyle(a16, true);
            }
            return contextThemeWrapper;
        }
        return context;
    }
}
