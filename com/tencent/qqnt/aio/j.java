package com.tencent.qqnt.aio;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0002\u00a8\u0006\u0007"}, d2 = {"Landroid/view/View;", "", "isScaleAIO", "b", "c", "d", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class j {
    @NotNull
    public static final View b(@NotNull View view, boolean z16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (d()) {
            return c(view, z16);
        }
        return view;
    }

    private static final View c(View view, boolean z16) {
        View a16 = a(view);
        if (z16) {
            a16.setBackground(new ColorDrawable(0));
        } else {
            a16.setBackgroundResource(R.drawable.qui_common_bg_primary_bg);
        }
        return a16;
    }

    private static final boolean d() {
        if (Build.VERSION.SDK_INT != 29) {
            return false;
        }
        return true;
    }

    private static final View a(View view) {
        return view;
    }
}
