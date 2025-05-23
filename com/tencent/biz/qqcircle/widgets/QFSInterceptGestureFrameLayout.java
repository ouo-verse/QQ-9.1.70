package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSInterceptGestureFrameLayout extends FrameLayout {
    private boolean C;
    private boolean D;
    private View E;
    private int F;
    private a G;

    /* renamed from: d, reason: collision with root package name */
    private float f93281d;

    /* renamed from: e, reason: collision with root package name */
    private float f93282e;

    /* renamed from: f, reason: collision with root package name */
    private float f93283f;

    /* renamed from: h, reason: collision with root package name */
    private float f93284h;

    /* renamed from: i, reason: collision with root package name */
    private MotionEvent f93285i;

    /* renamed from: m, reason: collision with root package name */
    private QFSPageTurnContainer f93286m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();

        void c();

        void onClose();
    }

    public QFSInterceptGestureFrameLayout(@NonNull Context context) {
        super(context);
        this.D = false;
    }

    private void a(MotionEvent motionEvent) {
        if (this.f93286m == null) {
            return;
        }
        motionEvent.setSource(0);
        this.f93286m.dispatchTouchEvent(motionEvent);
    }

    private void b(float f16, float f17) {
        a aVar;
        if (cx.j(f16) <= 50 && cx.j(f17) <= 100 && (aVar = this.G) != null) {
            aVar.c();
        }
    }

    private void c() {
        QFSPageTurnContainer qFSPageTurnContainer = this.f93286m;
        if (qFSPageTurnContainer == null) {
            QLog.e("QFSInterceptGestureFrameLayout", 1, "mTargetFeedView is null.");
            return;
        }
        if (qFSPageTurnContainer.B().getAdapter() instanceof BaseListViewAdapter) {
            RecyclerView recyclerView = ((BaseListViewAdapter) this.f93286m.B().getAdapter()).getRecyclerView();
            int currentItem = this.f93286m.B().getCurrentItem() + 1;
            recyclerView.smoothScrollToPosition(currentItem);
            QLog.d("QFSInterceptGestureFrameLayout", 1, "[scrollToNextVideo] smooth scroll to next video.position: " + currentItem);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View view = this.E;
        if (view != null) {
            this.f93286m = (QFSPageTurnContainer) view.findViewById(this.F);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.f93283f = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    this.f93284h = rawY;
                    float f16 = this.f93282e;
                    if (rawY < f16 && Math.abs(rawY - f16) > cx.a(10.0f) && Math.abs(this.f93283f - this.f93281d) < Math.abs(this.f93284h - this.f93282e)) {
                        if (!this.D) {
                            MotionEvent obtain = MotionEvent.obtain(motionEvent);
                            this.f93285i = obtain;
                            obtain.setAction(0);
                            this.f93285i.setLocation(this.f93281d, this.f93282e);
                            a(this.f93285i);
                            this.D = true;
                        }
                        a(motionEvent);
                        this.C = true;
                    }
                }
            } else {
                a aVar = this.G;
                if (aVar != null) {
                    aVar.a();
                }
                float f17 = this.f93284h;
                float f18 = this.f93282e;
                if (f17 < f18 && Math.abs(f17 - f18) > cx.a(20.0f) && this.C && Math.abs(this.f93283f - this.f93281d) < Math.abs(this.f93284h - this.f93282e)) {
                    a aVar2 = this.G;
                    if (aVar2 != null) {
                        aVar2.onClose();
                    }
                    c();
                    QLog.d("QFSInterceptGestureFrameLayout", 1, "action up, position: posX: " + this.f93283f + " , posY: " + this.f93284h);
                }
                this.D = false;
                a(motionEvent);
            }
        } else {
            a aVar3 = this.G;
            if (aVar3 != null) {
                aVar3.b();
            }
            this.f93281d = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            this.f93282e = rawY2;
            b(this.f93281d, rawY2);
            QLog.d("QFSInterceptGestureFrameLayout", 1, "action down, position: posX: " + this.f93281d + " , posY: " + this.f93282e);
        }
        return true;
    }

    public void setLayoutStateListener(a aVar) {
        this.G = aVar;
    }

    public void setTargetView(View view, int i3) {
        this.E = view;
        this.F = i3;
    }

    public QFSInterceptGestureFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSInterceptGestureFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = false;
    }
}
