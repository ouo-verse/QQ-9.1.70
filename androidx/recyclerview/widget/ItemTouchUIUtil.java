package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;

/* compiled from: P */
/* loaded from: classes.dex */
public interface ItemTouchUIUtil {
    void clearView(View view);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16);

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16);

    void onSelected(View view);
}
