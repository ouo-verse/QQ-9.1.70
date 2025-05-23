package com.tencent.mobileqq.matchfriend.reborn.register.part;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0000H\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\n\u001a\u00020\t*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\f\u001a\u00020\t*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u00a8\u0006\r"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/View;", "b", "", "a", "(Landroidx/recyclerview/widget/RecyclerView;)Ljava/lang/Integer;", "", "value", "maxScan", "", "d", "param", "c", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {
    public static final Integer a(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        View b16 = b(recyclerView);
        if (b16 == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return null;
        }
        return Integer.valueOf(layoutManager.getPosition(b16));
    }

    public static final View b(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        return recyclerView.findChildViewUnder(recyclerView.getWidth() / 2.0f, recyclerView.getHeight() / 2.0f);
    }

    public static final void c(View view, float f16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (f16 < 0.0f) {
            f16 = 0.0f;
        }
        if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        view.setAlpha(f16);
    }

    public static final void d(View view, float f16, float f17) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (f16 > f17) {
            f16 = f17;
        }
        if (f16 < 1.0f) {
            f16 = 1.0f;
        }
        view.setScaleX(f16);
        view.setScaleY(f16);
    }

    public static /* synthetic */ void e(View view, float f16, float f17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f17 = 1.3833333f;
        }
        d(view, f16, f17);
    }
}
