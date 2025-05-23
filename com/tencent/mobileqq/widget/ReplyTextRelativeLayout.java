package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ReplyTextRelativeLayout extends RelativeLayout {
    public ReplyTextRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int childCount = getChildCount();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8 && childAt.getId() == R.id.f165947lo3) {
                int i26 = (i17 - i3) - 0;
                childAt.layout(i26 - childAt.getMeasuredWidth(), 0, i26, childAt.getMeasuredHeight() + 0);
            }
        }
    }

    public ReplyTextRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ReplyTextRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
