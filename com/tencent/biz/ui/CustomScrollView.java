package com.tencent.biz.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.OverScroller;

/* compiled from: P */
@TargetApi(9)
/* loaded from: classes5.dex */
public class CustomScrollView extends RelativeLayout implements TouchWebView.OnOverScrollHandler {

    /* renamed from: d, reason: collision with root package name */
    private OverScroller f96982d;

    /* renamed from: e, reason: collision with root package name */
    DisplayMetrics f96983e;

    /* renamed from: f, reason: collision with root package name */
    public MutableLiveData<Integer> f96984f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f96985h;

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f96984f = new MutableLiveData<>();
        this.f96985h = true;
        b(context, attributeSet);
    }

    public void a(boolean z16) {
        this.f96985h = z16;
    }

    protected void b(Context context, AttributeSet attributeSet) {
        setOverScrollMode(0);
        this.f96982d = new OverScroller(getContext());
        try {
            this.f96983e = new DisplayMetrics();
            ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.f96983e);
        } catch (Throwable unused) {
        }
    }

    protected boolean c() {
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        OverScroller overScroller = this.f96982d;
        if (overScroller != null && overScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f96982d.getCurrX();
            int currY = this.f96982d.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                overScrollBy(currX - scrollX, currY - scrollY, scrollX, scrollY, 0, 0, 0, 5000, false);
            }
            postInvalidate();
        }
    }

    public void d(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("CustomScrollView", 2, " springBack y:" + i3);
        }
        if (this.f96982d.springBack(getScrollX(), getScrollY(), 0, 0, -i3, 0)) {
            invalidate();
        }
    }

    @Override // com.tencent.biz.ui.TouchWebView.OnOverScrollHandler
    public void onBack() {
        if (QLog.isDevelopLevel()) {
            QLog.d("CustomScrollView", 2, "onBack:");
        }
        if (this.f96982d.springBack(getScrollX(), getScrollY(), 0, 0, 0, 0)) {
            invalidate();
        }
    }

    @Override // com.tencent.biz.ui.TouchWebView.OnOverScrollHandler
    public void onOverScroll(int i3) {
        if (this.f96985h) {
            if (getScrollY() + i3 > 0) {
                i3 = -getScrollY();
            }
            int i16 = i3;
            if (c()) {
                overScrollBy(0, i16, getScrollX(), getScrollY(), 0, 0, 0, 5000, true);
            }
        }
    }

    @Override // android.view.View
    protected void onOverScrolled(int i3, int i16, boolean z16, boolean z17) {
        this.f96984f.postValue(Integer.valueOf(i16));
        if (!this.f96982d.isFinished()) {
            super.scrollTo(i3, i16);
            if (z16 || z17) {
                this.f96982d.springBack(getScrollX(), getScrollY(), 0, 0, 0, 0);
            }
        } else {
            super.scrollTo(i3, i16);
        }
        awakenScrollBars();
    }

    public CustomScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f96984f = new MutableLiveData<>();
        this.f96985h = true;
        b(context, attributeSet);
    }
}
