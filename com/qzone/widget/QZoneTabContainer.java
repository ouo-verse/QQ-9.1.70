package com.qzone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneTabContainer extends ViewGroup implements View.OnClickListener {
    int C;
    int D;
    boolean E;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f60486d;

    /* renamed from: e, reason: collision with root package name */
    int f60487e;

    /* renamed from: f, reason: collision with root package name */
    int f60488f;

    /* renamed from: h, reason: collision with root package name */
    int f60489h;

    /* renamed from: i, reason: collision with root package name */
    int f60490i;

    /* renamed from: m, reason: collision with root package name */
    int f60491m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
    }

    public QZoneTabContainer(Context context) {
        super(context);
        this.f60487e = -1;
        a(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        ImageView imageView = new ImageView(getContext());
        this.f60486d = imageView;
        imageView.setImageResource(R.drawable.gfy);
        addViewInLayout(this.f60486d, -1, generateDefaultLayoutParams());
        Resources resources = context.getResources();
        this.f60491m = (int) resources.getDimension(R.dimen.ayh);
        this.f60488f = resources.getInteger(R.integer.f167230ag);
        this.f60489h = resources.getInteger(R.integer.f167226ae);
        this.f60490i = resources.getColor(R.color.ahz);
        this.C = (int) resources.getDimension(R.dimen.f159013tw);
        this.D = (int) resources.getDimension(R.dimen.f159016tz);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.LayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int indexOfChild = indexOfChild(view);
        int i3 = this.f60487e;
        if (indexOfChild == i3) {
            d(indexOfChild);
        } else {
            b(i3, indexOfChild);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        measureChildren(i3, i16);
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i17 = paddingTop;
        for (int i18 = 0; i18 < childCount - 1; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                childAt.measure(ViewGroup.getChildMeasureSpec(i3, paddingLeft, layoutParams.width), ViewGroup.getChildMeasureSpec(i16, paddingTop, layoutParams.height));
                paddingLeft = paddingLeft + childAt.getMeasuredWidth() + this.f60491m;
                i17 = Math.max(i17, childAt.getMeasuredHeight() + paddingTop);
            }
        }
        int i19 = this.f60487e;
        if (i19 >= 0) {
            this.f60486d.measure(View.MeasureSpec.makeMeasureSpec(getChildAt(i19).getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.D, 1073741824));
        }
        setMeasuredDimension(paddingLeft - this.f60491m, i17);
    }

    public void setCurrentTab(int i3) {
        int i16 = this.f60487e;
        boolean z16 = i3 != i16;
        if (i3 < 0 || !z16) {
            return;
        }
        this.E = true;
        c(i16, i3, false);
    }

    private void b(int i3, int i16) {
        c(i3, i16, true);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.LayoutParams(getContext(), attributeSet);
    }

    private void c(int i3, int i16, boolean z16) {
        if (i3 >= 0) {
            TextView textView = (TextView) getChildAt(i3);
            textView.setTextSize(this.f60488f);
            textView.setTextColor(this.f60490i);
        }
        ((TextView) getChildAt(i16)).setTextSize(this.f60489h);
        this.f60487e = i16;
        this.E = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (z16 || this.E) {
            int childCount = getChildCount();
            if (childCount > 1) {
                int paddingLeft = getPaddingLeft();
                for (int i19 = 0; i19 < childCount - 1; i19++) {
                    View childAt = getChildAt(i19);
                    int measuredHeight = ((i18 - i16) - childAt.getMeasuredHeight()) / 2;
                    childAt.layout(paddingLeft, measuredHeight, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + measuredHeight);
                    paddingLeft = childAt.getRight() + this.f60491m;
                }
                if (this.f60487e >= 0 && z16) {
                    int i26 = i18 - i16;
                    int measuredHeight2 = i26 - this.f60486d.getMeasuredHeight();
                    ImageView imageView = this.f60486d;
                    imageView.layout(i3, measuredHeight2, imageView.getMeasuredWidth() + i3, i26);
                    this.f60486d.setTranslationX(getChildAt(this.f60487e).getLeft() - i3);
                }
            }
            this.E = false;
        }
    }

    public QZoneTabContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60487e = -1;
        a(context, attributeSet);
    }

    public QZoneTabContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60487e = -1;
        a(context, attributeSet);
    }

    private void d(int i3) {
    }

    public void setOnTabClickLisnter(a aVar) {
    }
}
