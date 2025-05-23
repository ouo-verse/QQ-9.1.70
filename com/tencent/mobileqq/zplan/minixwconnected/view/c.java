package com.tencent.mobileqq.zplan.minixwconnected.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "", "drawableResId", "colorId", "Landroid/graphics/drawable/Drawable;", "a", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {
    public static final Drawable a(Context context, int i3, int i16) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable o16 = ie0.a.f().o(context, i3, i16, 1001);
        QLog.i("MiniHomeConnectIconLayout_getIconDrawable", 1, "resId: " + i3 + ", colorId: " + i16 + ", drawable: " + o16);
        return o16;
    }

    public static /* synthetic */ Drawable b(Context context, int i3, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = R.color.qui_common_icon_nav_secondary;
        }
        return a(context, i3, i16);
    }
}
