package com.tencent.mobileqq.troop.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import java.lang.reflect.Field;

/* loaded from: classes19.dex */
public class PinnedHeaderIphoneTreeView extends PinnedHeaderExpandableListView {
    static IPatchRedirector $redirector_;
    public final Rect C;
    public boolean D;
    public boolean E;
    public View.OnTouchListener F;

    /* renamed from: d, reason: collision with root package name */
    View f302352d;

    /* renamed from: e, reason: collision with root package name */
    public View f302353e;

    /* renamed from: f, reason: collision with root package name */
    public View f302354f;

    /* renamed from: h, reason: collision with root package name */
    int f302355h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f302356i;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f302357m;

    /* loaded from: classes19.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PinnedHeaderIphoneTreeView.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 3) {
                        view.setPressed(false);
                        PinnedHeaderIphoneTreeView.this.invalidate();
                    }
                    return false;
                }
                if (view.isPressed()) {
                    view.setPressed(false);
                    PinnedHeaderIphoneTreeView pinnedHeaderIphoneTreeView = PinnedHeaderIphoneTreeView.this;
                    pinnedHeaderIphoneTreeView.collapseGroup(pinnedHeaderIphoneTreeView.f302355h);
                    PinnedHeaderIphoneTreeView pinnedHeaderIphoneTreeView2 = PinnedHeaderIphoneTreeView.this;
                    pinnedHeaderIphoneTreeView2.setSelectedGroup(pinnedHeaderIphoneTreeView2.f302355h);
                    PinnedHeaderIphoneTreeView.this.f302352d = null;
                }
                return true;
            }
            view.setPressed(true);
            PinnedHeaderIphoneTreeView.this.invalidate();
            return true;
        }
    }

    public PinnedHeaderIphoneTreeView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f302355h = -1;
        this.C = new Rect();
        this.F = new a();
        init();
    }

    private void init() {
        Drawable drawable = (Drawable) d0("mGroupIndicator");
        this.f302356i = drawable;
        setGroupIndicator(drawable);
    }

    public Object d0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.PinnedHeaderExpandableListView, com.tencent.widget.ExpandableListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        View childAt;
        View view;
        int i3;
        int intValue;
        int intValue2;
        int top;
        int bottom;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        if (getExpandableListAdapter() == null) {
            try {
                super.dispatchDraw(canvas);
                return;
            } catch (NullPointerException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("PinnedHeaderIphoneTreeView", 2, e16.getMessage());
                    return;
                }
                return;
            }
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
            int packedPositionGroup = com.tencent.widget.ExpandableListView.getPackedPositionGroup(expandableListPosition);
            com.tencent.widget.ExpandableListView.getPackedPositionType(expandableListPosition);
            this.f302353e = null;
            if (packedPositionGroup != -1 && isGroupExpanded(packedPositionGroup)) {
                if (this.f302352d == null || this.E || this.f302355h != packedPositionGroup) {
                    this.f302355h = packedPositionGroup;
                    View groupView = getExpandableListAdapter().getGroupView(packedPositionGroup, true, this.f302354f, this);
                    this.f302352d = groupView;
                    if (groupView != null) {
                        groupView.setSelected(childAt.isSelected());
                        this.f302352d.setOnTouchListener(this.F);
                    }
                }
                View view2 = this.f302352d;
                if (view2 != this.f302354f) {
                    this.f302354f = view2;
                }
                if (com.tencent.widget.ExpandableListView.getPackedPositionType(expandableListPosition) == 0) {
                    this.f302353e = childAt;
                }
                View view3 = this.f302352d;
                if (view3 != null) {
                    e0(view3, packedPositionGroup, 0, childAt.getWidth());
                    View view4 = this.f302352d;
                    view4.layout(0, 0, view4.getMeasuredWidth(), this.f302352d.getMeasuredHeight());
                }
            } else {
                this.f302352d = null;
            }
            try {
                super.dispatchDraw(canvas);
            } catch (NullPointerException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("PinnedHeaderIphoneTreeView", 2, e17.getMessage());
                }
            }
            if (this.f302352d != null) {
                if (com.tencent.widget.ExpandableListView.getPackedPositionType(getExpandableListPosition(firstVisiblePosition + 1)) == 0 && view != null && (top = view.getTop()) < (bottom = this.f302352d.getBottom())) {
                    i3 = top - bottom;
                    drawable = getDivider();
                } else {
                    i3 = 0;
                }
                canvas.translate(0.0f, i3);
                if (this.f302352d.isPressed()) {
                    Drawable selector = getSelector();
                    selector.setBounds(new Rect(selector.getBounds().left, this.f302352d.getTop(), selector.getBounds().right, this.f302352d.getBottom()));
                    getSelector().draw(canvas);
                }
                canvas.translate(getPaddingLeft(), 0.0f);
                this.f302352d.draw(canvas);
                canvas.translate(-getPaddingLeft(), 0.0f);
                Drawable drawable2 = this.f302357m;
                if (drawable2 != null) {
                    if (drawable2.isStateful()) {
                        this.f302357m.setState(new int[]{R.attr.state_expanded});
                    }
                    Integer num = (Integer) d0("mIndicatorLeft");
                    Integer num2 = (Integer) d0("mIndicatorRight");
                    Drawable drawable3 = this.f302357m;
                    if (num == null) {
                        intValue = 0;
                    } else {
                        intValue = num.intValue();
                    }
                    int top2 = this.f302352d.getTop();
                    if (num2 == null) {
                        intValue2 = 0;
                    } else {
                        intValue2 = num2.intValue();
                    }
                    drawable3.setBounds(intValue, top2, intValue2, this.f302352d.getBottom());
                    this.f302357m.draw(canvas);
                }
                if (drawable != null) {
                    drawable.setBounds(this.f302352d.getLeft(), this.f302352d.getBottom() - getDividerHeight(), this.f302352d.getRight(), this.f302352d.getBottom());
                    canvas.clipRect(this.f302352d.getLeft(), (this.f302352d.getBottom() - getDividerHeight()) + i3, this.f302352d.getRight(), this.f302352d.getBottom() + i3);
                }
                canvas.translate(0.0f, -i3);
            }
            this.E = false;
            this.D = false;
            return;
        }
        try {
            super.dispatchDraw(canvas);
        } catch (NullPointerException e18) {
            if (QLog.isColorLevel()) {
                QLog.d("PinnedHeaderIphoneTreeView", 2, e18.getMessage());
            }
        }
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        View view = this.f302352d;
        if (view != null) {
            view.getGlobalVisibleRect(this.C);
            if (this.C.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                boolean dispatchTouchEvent = this.f302352d.dispatchTouchEvent(motionEvent);
                if (dispatchTouchEvent) {
                    return dispatchTouchEvent;
                }
            } else {
                this.f302352d.setPressed(false);
                invalidate();
            }
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, canvas, view, Long.valueOf(j3))).booleanValue();
        }
        if (view == this.f302353e) {
            return true;
        }
        return super.drawChild(canvas, view, j3);
    }

    public void e0(View view, int i3, int i16, int i17) {
        int makeMeasureSpec;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2, 0);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i16, getPaddingLeft() + getPaddingRight(), i17);
        int i18 = ((ViewGroup.LayoutParams) layoutParams).height;
        if (i18 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        View childAt = super.getChildAt(i3);
        if (this.D) {
            if (this.f302352d != null && childAt == this.f302353e) {
                super.setGroupIndicator(null);
            } else {
                super.setGroupIndicator(this.f302356i);
            }
        }
        return childAt;
    }

    @Override // com.tencent.widget.AbsListView
    protected boolean isInFilterMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.requestLayout();
            this.E = true;
        }
    }

    @Override // com.tencent.widget.ExpandableListView
    public void setGroupIndicator(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
            return;
        }
        super.setGroupIndicator(drawable);
        this.f302356i = drawable;
        if (drawable != null && drawable != this.f302357m) {
            this.f302357m = drawable;
        }
    }

    public PinnedHeaderIphoneTreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302355h = -1;
        this.C = new Rect();
        this.F = new a();
        init();
    }

    public PinnedHeaderIphoneTreeView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f302355h = -1;
        this.C = new Rect();
        this.F = new a();
        init();
    }
}
