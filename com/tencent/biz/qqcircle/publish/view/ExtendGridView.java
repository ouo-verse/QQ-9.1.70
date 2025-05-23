package com.tencent.biz.qqcircle.publish.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.tencent.biz.richframework.ui.res.R$styleable;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.widget.GridView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ExtendGridView extends GridView {
    protected int C;

    /* renamed from: d, reason: collision with root package name */
    private int f91760d;

    /* renamed from: e, reason: collision with root package name */
    private int f91761e;

    /* renamed from: f, reason: collision with root package name */
    private int f91762f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f91763h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f91764i;

    /* renamed from: m, reason: collision with root package name */
    protected int f91765m;

    public ExtendGridView(Context context) {
        this(context, null);
    }

    private void R() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        this.f91765m = defaultDisplay.getWidth();
        this.C = defaultDisplay.getHeight();
    }

    private void init() {
        R();
    }

    @Override // com.tencent.widget.GridView
    public int getHorizontalSpacing() {
        return this.f91760d;
    }

    @Override // com.tencent.widget.GridView
    public int getNumColumns() {
        return this.f91762f;
    }

    @Override // com.tencent.widget.GridView
    public int getVerticalSpacing() {
        return this.f91761e;
    }

    @Override // android.view.View
    @TargetApi(8)
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        R();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.GridView, com.tencent.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        if (this.f91763h) {
            i16 = View.MeasureSpec.makeMeasureSpec(NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i16);
    }

    @Override // com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (this.f91764i && pointToPosition < 0) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.widget.GridView
    public void setHorizontalSpacing(int i3) {
        super.setHorizontalSpacing(i3);
        this.f91760d = i3;
    }

    @Override // com.tencent.widget.GridView
    public void setNumColumns(int i3) {
        super.setNumColumns(i3);
        this.f91762f = i3;
    }

    public void setPenetrateTouch(boolean z16) {
        this.f91764i = z16;
    }

    public void setStretchable(boolean z16) {
        if (this.f91763h != z16) {
            this.f91763h = z16;
            requestLayout();
        }
    }

    @Override // com.tencent.widget.GridView
    public void setVerticalSpacing(int i3) {
        super.setVerticalSpacing(i3);
        this.f91761e = i3;
    }

    public ExtendGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExtendGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.GridView);
        this.f91763h = obtainStyledAttributes.getBoolean(R$styleable.GridView_stretchable, false);
        this.f91764i = obtainStyledAttributes.getBoolean(R$styleable.GridView_penetrateTouch, false);
        obtainStyledAttributes.recycle();
        init();
    }
}
