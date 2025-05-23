package com.tencent.sqshow.zootopia.friendsdressup;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0000H\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\n\u001a\u00020\t*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0000\u001a\u001e\u0010\u000b\u001a\u00020\t*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0000\u001a\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0000\u00a8\u0006\u0011"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/View;", "d", "", "c", "(Landroidx/recyclerview/widget/RecyclerView;)Ljava/lang/Integer;", "", "value", "maxScan", "", "e", "g", "", "tag", "msg", "b", "a", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {
    public static final void a(String tag, String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isColorLevel()) {
            QLog.d(tag, 1, msg2);
        }
    }

    public static final void b(String tag, String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d(tag, 1, msg2);
    }

    public static final Integer c(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        View d16 = d(recyclerView);
        if (d16 == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return null;
        }
        return Integer.valueOf(layoutManager.getPosition(d16));
    }

    public static final View d(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        return recyclerView.findChildViewUnder(recyclerView.getWidth() / 2.0f, recyclerView.getHeight() / 2.0f);
    }

    public static final void e(View view, float f16, float f17) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        float scaleX = view.getScaleX() + f16;
        if (scaleX <= f17) {
            f17 = scaleX;
        }
        if (f17 < 1.0f) {
            f17 = 1.0f;
        }
        view.setScaleX(f17);
        view.setScaleY(f17);
    }

    public static final void g(View view, float f16, float f17) {
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

    public static /* synthetic */ void f(View view, float f16, float f17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f17 = 1.4561403f;
        }
        e(view, f16, f17);
    }

    public static /* synthetic */ void h(View view, float f16, float f17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f17 = 1.4561403f;
        }
        g(view, f16, f17);
    }
}
