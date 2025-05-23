package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f extends e {
    private float a(RecyclerView recyclerView, View view) {
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

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.e, com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.d
    public void clearView(View view) {
        Object tag = view.getTag(R.id.dr8);
        if (tag != null && (tag instanceof Float)) {
            ViewCompat.setElevation(view, ((Float) tag).floatValue());
        }
        view.setTag(R.id.dr8, null);
        super.clearView(view);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.e, com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.d
    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16) {
        if (z16 && view.getTag(R.id.dr8) == null) {
            Float valueOf = Float.valueOf(ViewCompat.getElevation(view));
            ViewCompat.setElevation(view, a(recyclerView, view) + 1.0f);
            view.setTag(R.id.dr8, valueOf);
        }
        super.onDraw(canvas, recyclerView, view, f16, f17, i3, z16);
    }
}
