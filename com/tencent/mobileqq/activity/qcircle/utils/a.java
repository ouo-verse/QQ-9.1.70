package com.tencent.mobileqq.activity.qcircle.utils;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Landroid/widget/RelativeLayout;", "Landroid/view/View;", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    @Nullable
    public static final View a(@NotNull RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<this>");
        View findViewById = relativeLayout.findViewById(R.id.f32300td);
        if (findViewById == null) {
            View findViewById2 = relativeLayout.findViewById(R.id.f32280tb);
            if (findViewById2 == null) {
                return relativeLayout.findViewById(R.id.f32290tc);
            }
            return findViewById2;
        }
        return findViewById;
    }
}
