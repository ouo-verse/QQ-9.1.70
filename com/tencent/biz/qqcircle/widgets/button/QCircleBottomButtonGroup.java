package com.tencent.biz.qqcircle.widgets.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.cx;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleBottomButtonGroup extends LinearLayout {
    public QCircleBottomButtonGroup(Context context) {
        this(context, null);
    }

    private List<View> a() {
        int childCount = getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        View view;
        List<View> a16 = a();
        if (a16.size() == 2) {
            int a17 = cx.a(157.0f);
            for (int i17 = 0; i17 < a16.size(); i17++) {
                View view2 = a16.get(i17);
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    layoutParams.width = a17;
                    view2.setLayoutParams(layoutParams);
                }
            }
        } else if (a16.size() == 1 && (view = a16.get(0)) != null) {
            int a18 = cx.a(188.0f);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            layoutParams2.width = a18;
            view.setLayoutParams(layoutParams2);
        }
        super.onMeasure(i3, i16);
    }

    public QCircleBottomButtonGroup(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
