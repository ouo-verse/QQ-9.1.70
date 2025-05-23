package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class ItemTouchUIUtilImpl implements ItemTouchUIUtil {
    static final ItemTouchUIUtil INSTANCE = new ItemTouchUIUtilImpl();

    ItemTouchUIUtilImpl() {
    }

    private static float findMaxElevation(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f16 = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            if (childAt != view) {
                float elevation = ViewCompat.getElevation(childAt);
                if (elevation > f16) {
                    f16 = elevation;
                }
            }
        }
        return f16;
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void clearView(View view) {
        Object tag = view.getTag(R.id.dr8);
        if (tag instanceof Float) {
            ViewCompat.setElevation(view, ((Float) tag).floatValue());
        }
        view.setTag(R.id.dr8, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16) {
        if (z16 && view.getTag(R.id.dr8) == null) {
            Float valueOf = Float.valueOf(ViewCompat.getElevation(view));
            ViewCompat.setElevation(view, findMaxElevation(recyclerView, view) + 1.0f);
            view.setTag(R.id.dr8, valueOf);
        }
        view.setTranslationX(f16);
        view.setTranslationY(f17);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onSelected(View view) {
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16) {
    }
}
