package com.tencent.mobileqq.leba.zplan.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import b72.a;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes15.dex */
public class PullToZoomHeaderListView extends FPSXListView {
    private boolean C;
    private a D;

    /* renamed from: i, reason: collision with root package name */
    private int f240842i;

    /* renamed from: m, reason: collision with root package name */
    private int f240843m;

    public PullToZoomHeaderListView(Context context) {
        this(context, null);
    }

    private void init() {
        this.f240842i = (int) (getResources().getDisplayMetrics().density * 200.0f);
        if (QLog.isColorLevel()) {
            QLog.d("PullToZoomHeaderListView", 2, String.format("init mMaxOverScrollY=%s", Integer.valueOf(this.f240842i)));
        }
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.D == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked() & 255;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2 && Math.abs(((int) motionEvent.getY()) - this.f240843m) > 5.0f) {
                    boolean a16 = this.D.a(motionEvent);
                    this.C = a16;
                    if (a16) {
                        return true;
                    }
                }
            } else if (this.C) {
                this.C = false;
                return true;
            }
        } else {
            this.C = false;
            this.f240843m = (int) motionEvent.getY();
            this.D.handleZPlanEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.D == null) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked() & 255;
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                boolean handleZPlanEvent = this.D.handleZPlanEvent(motionEvent);
                this.C = handleZPlanEvent;
                if (handleZPlanEvent) {
                    return true;
                }
            }
        } else {
            this.D.handleZPlanEvent(motionEvent);
            if (this.C) {
                this.C = false;
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, android.view.View
    public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        return super.overScrollBy(i3, i16, i17, i18, i19, i26, i27, this.f240842i, z16);
    }

    public void setHandleEvent(a aVar) {
        this.D = aVar;
    }

    public PullToZoomHeaderListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PullToZoomHeaderListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }
}
