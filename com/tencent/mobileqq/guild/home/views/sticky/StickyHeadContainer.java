package com.tencent.mobileqq.guild.home.views.sticky;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes13.dex */
public class StickyHeadContainer extends ViewGroup {
    private int C;
    private b D;

    /* renamed from: d, reason: collision with root package name */
    private int f225681d;

    /* renamed from: e, reason: collision with root package name */
    private int f225682e;

    /* renamed from: f, reason: collision with root package name */
    private int f225683f;

    /* renamed from: h, reason: collision with root package name */
    private int f225684h;

    /* renamed from: i, reason: collision with root package name */
    private int f225685i;

    /* renamed from: m, reason: collision with root package name */
    private int f225686m;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface b {
        void a(int i3);
    }

    public StickyHeadContainer(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a() {
        return getChildAt(0).getHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i3) {
        b bVar = this.D;
        if (bVar != null && this.f225683f != i3) {
            bVar.a(i3);
        }
        this.f225683f = i3;
    }

    public void c() {
        this.f225683f = Integer.MIN_VALUE;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        View childAt = getChildAt(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.f225684h = paddingLeft + marginLayoutParams.leftMargin;
        this.f225685i = childAt.getMeasuredWidth() + this.f225684h;
        this.f225686m = paddingTop + marginLayoutParams.topMargin + this.f225681d;
        int measuredHeight = childAt.getMeasuredHeight();
        int i19 = this.f225686m;
        int i26 = measuredHeight + i19;
        this.C = i26;
        childAt.layout(this.f225684h, i19, this.f225685i, i26);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            measureChildWithMargins(childAt, i3, 0, i16, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
            int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
            setMeasuredDimension(View.resolveSize(Math.max(paddingLeft, getSuggestedMinimumWidth()), i3), View.resolveSize(Math.max(paddingTop, getSuggestedMinimumHeight()), i16));
            return;
        }
        throw new IllegalArgumentException("\u53ea\u5141\u8bb8\u5bb9\u5668\u6dfb\u52a01\u4e2a\u5b50View\uff01");
    }

    public void setDataCallback(b bVar) {
        this.D = bVar;
    }

    public StickyHeadContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public StickyHeadContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f225682e = Integer.MIN_VALUE;
        this.f225683f = Integer.MIN_VALUE;
        setOnClickListener(new a());
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
