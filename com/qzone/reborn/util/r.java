package com.qzone.reborn.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.qzone.util.ar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003R\u0015\u0010\t\u001a\u00020\u0003*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\t\u001a\u00020\u000b*\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/util/r;", "", "Landroid/view/View;", "", "expendSize", "", "b", "e", "(I)I", "dp", "", "", "d", "(Ljava/lang/Number;)F", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f59560a = new r();

    r() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View this_expendTouchArea, int i3, View parentView) {
        Intrinsics.checkNotNullParameter(this_expendTouchArea, "$this_expendTouchArea");
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        Rect rect = new Rect();
        this_expendTouchArea.getHitRect(rect);
        rect.top -= i3;
        rect.bottom += i3;
        rect.left -= i3;
        rect.right += i3;
        parentView.setTouchDelegate(new TouchDelegate(rect, this_expendTouchArea));
    }

    public final void b(final View view, final int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        final View view2 = (View) parent;
        view2.post(new Runnable() { // from class: com.qzone.reborn.util.q
            @Override // java.lang.Runnable
            public final void run() {
                r.c(view, i3, view2);
            }
        });
    }

    public final float d(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return ar.e(number.floatValue());
    }

    public final int e(int i3) {
        return ar.e(i3);
    }
}
