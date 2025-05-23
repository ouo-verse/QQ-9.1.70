package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.widget.HorizontalListView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class OverScrollCallbackHorizontalListView extends HorizontalListView {

    /* renamed from: d, reason: collision with root package name */
    private float f315907d;

    /* renamed from: e, reason: collision with root package name */
    private float f315908e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f315909f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f315910h;

    /* renamed from: i, reason: collision with root package name */
    private a f315911i;

    /* renamed from: m, reason: collision with root package name */
    private int f315912m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(OverScrollCallbackHorizontalListView overScrollCallbackHorizontalListView);
    }

    public OverScrollCallbackHorizontalListView(Context context) {
        super(context);
        this.f315912m = 0;
        i(context);
    }

    private void i(Context context) {
        this.f315912m = BaseAIOUtils.f(50.0f, getResources());
        setOverScrollMode(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (action == 0) {
            this.f315907d = x16;
            this.f315908e = y16;
            getParent().requestDisallowInterceptTouchEvent(true);
            this.f315909f = true;
            this.f315910h = true;
            return super.dispatchTouchEvent(motionEvent);
        }
        if (action == 2) {
            float f16 = x16 - this.f315907d;
            float f17 = y16 - this.f315908e;
            if (this.f315909f && Math.abs(f17) * 5.0f > Math.abs(f16) * 4.0f && Math.abs(f17) > com.tencent.mobileqq.util.x.c(getContext(), 5.0f)) {
                getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (action == 3 || action == 1) {
            this.f315909f = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.HorizontalListView, android.view.View
    public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        if (this.f315910h && i17 > this.f315912m) {
            this.f315910h = false;
            a aVar = this.f315911i;
            if (aVar != null && this.f315909f) {
                aVar.a(this);
            }
        }
        return super.overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z16);
    }

    public void setListener(a aVar) {
        this.f315911i = aVar;
    }

    public OverScrollCallbackHorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315912m = 0;
        i(context);
    }
}
