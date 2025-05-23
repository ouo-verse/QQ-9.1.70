package com.qzone.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.mobileqq.R;
import com.tencent.widget.GridView;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ExtendGridView extends GridView {
    protected int C;

    /* renamed from: d, reason: collision with root package name */
    private int f60354d;

    /* renamed from: e, reason: collision with root package name */
    private int f60355e;

    /* renamed from: f, reason: collision with root package name */
    private int f60356f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f60357h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f60358i;

    /* renamed from: m, reason: collision with root package name */
    protected int f60359m;

    public ExtendGridView(Context context) {
        this(context, null);
    }

    private void U() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        this.f60359m = defaultDisplay.getWidth();
        this.C = defaultDisplay.getHeight();
    }

    private void init() {
        U();
    }

    public int R() {
        int measuredWidth;
        if (getWidth() > 0) {
            measuredWidth = getWidth();
        } else {
            measuredWidth = getMeasuredWidth();
        }
        if (measuredWidth <= 0) {
            measuredWidth = this.f60359m;
        }
        int horizontalSpacing = getHorizontalSpacing();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int numColumns = getNumColumns();
        int i3 = ((measuredWidth - paddingLeft) - ((numColumns - 1) * horizontalSpacing)) / numColumns;
        if (i3 < 0) {
            return -2;
        }
        return i3;
    }

    public int S() {
        return (pl.a.f426446a.o(getContext()) - fd.a.f398305d) / 3;
    }

    public boolean T() {
        return this.f60357h;
    }

    @Override // com.tencent.widget.GridView
    public int getHorizontalSpacing() {
        return this.f60354d;
    }

    @Override // com.tencent.widget.GridView
    public int getNumColumns() {
        return this.f60356f;
    }

    @Override // com.tencent.widget.GridView
    public int getVerticalSpacing() {
        return this.f60355e;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        U();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.GridView, com.tencent.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        if (this.f60357h) {
            i16 = View.MeasureSpec.makeMeasureSpec(NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i16);
    }

    @Override // com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (!this.f60358i || pointToPosition >= 0) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.tencent.widget.GridView
    public void setHorizontalSpacing(int i3) {
        super.setHorizontalSpacing(i3);
        this.f60354d = i3;
    }

    @Override // com.tencent.widget.GridView
    public void setNumColumns(int i3) {
        super.setNumColumns(i3);
        this.f60356f = i3;
    }

    public void setPenetrateTouch(boolean z16) {
        this.f60358i = z16;
    }

    public void setStretchable(boolean z16) {
        if (this.f60357h != z16) {
            this.f60357h = z16;
            requestLayout();
        }
    }

    @Override // com.tencent.widget.GridView
    public void setVerticalSpacing(int i3) {
        super.setVerticalSpacing(i3);
        this.f60355e = i3;
    }

    public ExtendGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExtendGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridView);
        this.f60357h = obtainStyledAttributes.getBoolean(1, false);
        this.f60358i = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        init();
    }
}
