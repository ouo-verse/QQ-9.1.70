package com.tencent.mobileqq.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes20.dex */
public class IphoneTreeView extends ExpandableListView {
    private final Rect C;
    private boolean D;
    private boolean E;
    private View.OnTouchListener F;

    /* renamed from: d, reason: collision with root package name */
    View f315759d;

    /* renamed from: e, reason: collision with root package name */
    private View f315760e;

    /* renamed from: f, reason: collision with root package name */
    private View f315761f;

    /* renamed from: h, reason: collision with root package name */
    int f315762h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f315763i;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f315764m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 3) {
                        view.setPressed(false);
                        IphoneTreeView.this.invalidate();
                    }
                    return false;
                }
                if (view.isPressed()) {
                    view.setPressed(false);
                    IphoneTreeView iphoneTreeView = IphoneTreeView.this;
                    iphoneTreeView.collapseGroup(iphoneTreeView.f315762h);
                    IphoneTreeView iphoneTreeView2 = IphoneTreeView.this;
                    iphoneTreeView2.setSelectedGroup(iphoneTreeView2.f315762h);
                    IphoneTreeView.this.f315759d = null;
                }
                return true;
            }
            view.setPressed(true);
            IphoneTreeView.this.invalidate();
            return true;
        }
    }

    public IphoneTreeView(Context context) {
        super(context);
        this.f315762h = -1;
        this.C = new Rect();
        this.F = new a();
        b();
    }

    private Object a(String str) {
        try {
            Field declaredField = ExpandableListView.class.getDeclaredField(str);
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            return declaredField.get(this);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private void b() {
        Drawable drawable = (Drawable) a("mGroupIndicator");
        this.f315763i = drawable;
        setGroupIndicator(drawable);
    }

    private void c(View view, int i3, int i16, int i17) {
        int makeMeasureSpec;
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2, 0);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i16, getPaddingLeft() + getPaddingRight(), i17);
        int i18 = layoutParams.height;
        if (i18 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    @Override // android.widget.ExpandableListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        View view;
        int i3;
        int intValue;
        int intValue2;
        int top;
        int bottom;
        int i16;
        if (getExpandableListAdapter() == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int childCount = getChildCount();
        if (childCount != 0) {
            Drawable drawable = null;
            if (childCount != 1) {
                childAt = getChildAt(0);
                view = getChildAt(1);
            } else {
                childAt = getChildAt(0);
                view = null;
            }
            this.D = true;
            int firstVisiblePosition = getFirstVisiblePosition();
            int i17 = 0;
            while (true) {
                if (i17 >= childCount) {
                    break;
                }
                View childAt2 = getChildAt(i17);
                if (childAt2.getBottom() > 0 && (i16 = i17 + 1) < childCount) {
                    view = getChildAt(i16);
                    firstVisiblePosition += i17;
                    childAt = childAt2;
                    break;
                }
                i17++;
            }
            long expandableListPosition = getExpandableListPosition(firstVisiblePosition);
            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
            ExpandableListView.getPackedPositionType(expandableListPosition);
            this.f315760e = null;
            if (packedPositionGroup != -1 && isGroupExpanded(packedPositionGroup)) {
                if (this.f315759d == null || this.E || this.f315762h != packedPositionGroup) {
                    this.f315762h = packedPositionGroup;
                    View groupView = getExpandableListAdapter().getGroupView(packedPositionGroup, true, this.f315761f, this);
                    this.f315759d = groupView;
                    groupView.setSelected(childAt.isSelected());
                    this.f315759d.setOnTouchListener(this.F);
                }
                View view2 = this.f315759d;
                if (view2 != this.f315761f) {
                    this.f315761f = view2;
                }
                if (ExpandableListView.getPackedPositionType(expandableListPosition) == 0) {
                    this.f315760e = childAt;
                }
                c(this.f315759d, packedPositionGroup, 0, childAt.getWidth());
                View view3 = this.f315759d;
                view3.layout(0, 0, view3.getMeasuredWidth(), this.f315759d.getMeasuredHeight());
            } else {
                this.f315759d = null;
            }
            super.dispatchDraw(canvas);
            if (this.f315759d != null) {
                if (ExpandableListView.getPackedPositionType(getExpandableListPosition(firstVisiblePosition + 1)) == 0 && view != null && (top = view.getTop()) < (bottom = this.f315759d.getBottom())) {
                    i3 = top - bottom;
                    drawable = getDivider();
                } else {
                    i3 = 0;
                }
                canvas.translate(0.0f, i3);
                if (this.f315759d.isPressed()) {
                    Drawable selector = getSelector();
                    selector.setBounds(new Rect(selector.getBounds().left, this.f315759d.getTop(), selector.getBounds().right, this.f315759d.getBottom()));
                    getSelector().draw(canvas);
                }
                canvas.translate(getPaddingLeft(), 0.0f);
                this.f315759d.draw(canvas);
                canvas.translate(-getPaddingLeft(), 0.0f);
                if (this.f315764m.isStateful()) {
                    this.f315764m.setState(new int[]{R.attr.state_expanded});
                }
                Integer num = (Integer) a("mIndicatorLeft");
                Integer num2 = (Integer) a("mIndicatorRight");
                Drawable drawable2 = this.f315764m;
                if (num == null) {
                    intValue = 0;
                } else {
                    intValue = num.intValue();
                }
                int top2 = this.f315759d.getTop();
                if (num2 == null) {
                    intValue2 = 0;
                } else {
                    intValue2 = num2.intValue();
                }
                drawable2.setBounds(intValue, top2, intValue2, this.f315759d.getBottom());
                this.f315764m.draw(canvas);
                if (drawable != null) {
                    drawable.setBounds(this.f315759d.getLeft(), this.f315759d.getBottom() - getDividerHeight(), this.f315759d.getRight(), this.f315759d.getBottom());
                    canvas.clipRect(this.f315759d.getLeft(), (this.f315759d.getBottom() - getDividerHeight()) + i3, this.f315759d.getRight(), this.f315759d.getBottom() + i3);
                }
                canvas.translate(0.0f, -i3);
            }
            this.E = false;
            this.D = false;
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View view = this.f315759d;
        if (view != null) {
            view.getGlobalVisibleRect(this.C);
            if (this.C.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                boolean dispatchTouchEvent = this.f315759d.dispatchTouchEvent(motionEvent);
                if (dispatchTouchEvent) {
                    return dispatchTouchEvent;
                }
            } else {
                this.f315759d.setPressed(false);
                invalidate();
            }
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // android.widget.ListView, android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        if (view != this.f315760e) {
            return super.drawChild(canvas, view, j3);
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int i3) {
        View childAt = super.getChildAt(i3);
        if (this.D) {
            if (this.f315759d != null && childAt == this.f315760e) {
                super.setGroupIndicator(null);
            } else {
                super.setGroupIndicator(this.f315763i);
            }
        }
        return childAt;
    }

    @Override // android.widget.AbsListView
    protected boolean isInFilterMode() {
        return true;
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        this.E = true;
    }

    @Override // android.widget.ExpandableListView
    public void setGroupIndicator(Drawable drawable) {
        super.setGroupIndicator(drawable);
        this.f315763i = drawable;
        if (drawable != null && drawable != this.f315764m) {
            this.f315764m = drawable;
        }
    }

    public IphoneTreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315762h = -1;
        this.C = new Rect();
        this.F = new a();
        b();
    }

    public IphoneTreeView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315762h = -1;
        this.C = new Rect();
        this.F = new a();
        b();
    }
}
