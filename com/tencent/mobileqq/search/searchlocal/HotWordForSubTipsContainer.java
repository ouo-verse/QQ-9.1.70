package com.tencent.mobileqq.search.searchlocal;

import android.content.Context;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.kandian.biz.search.ReadInJoySearchTipsContainer;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.al;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class HotWordForSubTipsContainer extends ReadInJoySearchTipsContainer {

    /* renamed from: f, reason: collision with root package name */
    private int f284825f;

    public HotWordForSubTipsContainer(Context context) {
        super(context);
        this.f284825f = 5;
    }

    private void c(String str, int i3, int i16, int i17, String str2) {
        if (str != null && TextUtils.isEmpty(str.trim())) {
            return;
        }
        Button button = new Button(getContext());
        if (i3 != 0) {
            button.setBackgroundResource(i3);
        }
        GradientDrawable gradientDrawable = (GradientDrawable) ((DrawableContainer.DrawableContainerState) ((StateListDrawable) button.getBackground()).getConstantState()).getChildren()[1];
        if (i17 == 0) {
            i17 = -3355444;
        }
        gradientDrawable.setStroke(1, i17);
        button.setPadding(ViewUtils.dip2px(12.0f), ViewUtils.dip2px(3.0f), ViewUtils.dip2px(12.0f), ViewUtils.dip2px(4.0f));
        button.setText(str);
        button.setTextSize(14.0f);
        button.setSingleLine();
        if (i16 == 0) {
            i16 = -16777216;
        }
        button.setTextColor(i16);
        button.setOnClickListener(this);
        button.setTag(str);
        if (!TextUtils.isEmpty(str2)) {
            button.setContentDescription(str2);
        }
        super.addView(button);
    }

    @Override // com.tencent.mobileqq.kandian.biz.search.ReadInJoySearchTipsContainer
    protected int a(int i3) {
        int a16 = (int) al.a(getContext(), 12.0f);
        int a17 = (int) al.a(getContext(), 10.0f);
        int a18 = (int) al.a(getContext(), 10.0f);
        int a19 = (int) al.a(getContext(), 10.0f);
        int a26 = (int) al.a(getContext(), 15.0f);
        int a27 = (int) al.a(getContext(), 15.0f);
        int childCount = getChildCount();
        int i16 = a26;
        int i17 = 1;
        int i18 = a17;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i19 == 0) {
                a17 += measuredHeight;
            }
            if (i16 + measuredWidth > i3 - a27) {
                i17++;
                int i26 = this.f284825f;
                if (i26 > 0 && i17 > i26) {
                    break;
                }
                i18 += measuredHeight + a16;
                i16 = a26;
                a17 = measuredHeight + i18;
            }
            i16 += measuredWidth + a19;
        }
        return a17 + a18;
    }

    public void d(List<BusinessGroupWord.c> list, int i3, int i16, int i17) {
        removeAllViews();
        Iterator<BusinessGroupWord.c> it = list.iterator();
        while (it.hasNext()) {
            c(it.next().f283447b, i3, i16, i17, null);
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.search.ReadInJoySearchTipsContainer, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int a16 = (int) al.a(getContext(), 12.0f);
        int a17 = (int) al.a(getContext(), 10.0f);
        int a18 = (int) al.a(getContext(), 10.0f);
        int a19 = (int) al.a(getContext(), 15.0f);
        int a26 = (int) al.a(getContext(), 15.0f);
        int i19 = i17 - i3;
        int childCount = getChildCount();
        int i26 = 1;
        int i27 = 0;
        int i28 = a19;
        while (i27 < childCount) {
            View childAt = getChildAt(i27);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i28 + measuredWidth > i19 - a26) {
                a17 += measuredHeight + a16;
                i26++;
                int i29 = this.f284825f;
                if (i29 > 0 && i26 > i29) {
                    return;
                } else {
                    i28 = a19;
                }
            }
            childAt.layout(i28, a17, measuredWidth + i28, measuredHeight + a17);
            i27++;
            i28 = a18 + measuredWidth + i28;
        }
    }

    public HotWordForSubTipsContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f284825f = 5;
    }
}
