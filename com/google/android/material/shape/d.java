package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ViewUtils;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static j1.d a(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return b();
            }
            return new a();
        }
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static j1.d b() {
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static b c() {
        return new b();
    }

    public static void d(@NonNull View view, float f16) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) background).X(f16);
        }
    }

    public static void e(@NonNull View view) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            f(view, (MaterialShapeDrawable) background);
        }
    }

    public static void f(@NonNull View view, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        if (materialShapeDrawable.P()) {
            materialShapeDrawable.c0(ViewUtils.h(view));
        }
    }
}
