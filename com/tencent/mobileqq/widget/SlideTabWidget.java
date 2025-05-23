package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabWidget;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SlideTabWidget extends TabWidget {
    private static int E = (int) ((BaseApplication.getContext().getResources().getDisplayMetrics().density * 3.0f) + 0.5f);
    private boolean C;
    private Handler D;

    /* renamed from: d, reason: collision with root package name */
    private int f316295d;

    /* renamed from: e, reason: collision with root package name */
    private int f316296e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f316297f;

    /* renamed from: h, reason: collision with root package name */
    private float f316298h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f316299i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f316300m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.widget.SlideTabWidget$2, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ SlideTabWidget this$0;

        @Override // java.lang.Runnable
        public void run() {
            SlideTabWidget.c(this.this$0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                SlideTabWidget.this.f316298h = 0.0f;
                SlideTabWidget.this.f316298h = (float) (r10.f316298h + 0.1d);
                SlideTabWidget.this.invalidate();
                sendMessageDelayed(SlideTabWidget.this.D.obtainMessage(1), 10L);
                return;
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    SlideTabWidget.this.f316298h = 1.0f;
                    SlideTabWidget slideTabWidget = SlideTabWidget.this;
                    slideTabWidget.f316296e = slideTabWidget.f316295d;
                    return;
                }
                return;
            }
            if (SlideTabWidget.this.f316298h < 1.0f) {
                SlideTabWidget.this.f316298h = (float) (r10.f316298h + 0.1d);
                if (SlideTabWidget.this.f316298h >= 1.0f) {
                    SlideTabWidget.this.f316300m = false;
                }
                SlideTabWidget.this.invalidate();
                sendMessageDelayed(SlideTabWidget.this.D.obtainMessage(1), 10L);
                return;
            }
            sendMessageDelayed(SlideTabWidget.this.D.obtainMessage(2), 10L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
    }

    public SlideTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316295d = -1;
        this.f316296e = -1;
        this.f316297f = false;
        this.f316300m = false;
        this.C = false;
        this.D = new a();
        Paint paint = new Paint();
        this.f316299i = paint;
        paint.setColor(getResources().getColor(R.color.skin_blue));
    }

    static /* bridge */ /* synthetic */ b c(SlideTabWidget slideTabWidget) {
        slideTabWidget.getClass();
        return null;
    }

    @Override // android.widget.TabWidget, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        View childTabViewAt;
        View childAt;
        super.dispatchDraw(canvas);
        if ((!this.f316300m || (this.f316298h < 1.0f && this.f316296e != this.f316295d)) && (childTabViewAt = getChildTabViewAt(this.f316296e)) != null) {
            int left = childTabViewAt.getLeft();
            int right = childTabViewAt.getRight();
            if (this.f316298h > 0.0f && (childAt = getChildAt(this.f316295d)) != null) {
                left = (int) (childTabViewAt.getLeft() + (this.f316298h * (childAt.getLeft() - childTabViewAt.getLeft())));
                right = (int) (childTabViewAt.getRight() + (this.f316298h * (childAt.getRight() - childTabViewAt.getRight())));
            }
            canvas.drawRect(left, getHeight() - E, right, getHeight(), this.f316299i);
        }
    }

    @Override // android.widget.TabWidget
    public void setCurrentTab(int i3) {
        if (i3 >= 0 && i3 <= getTabCount() && i3 != this.f316296e) {
            this.C = true;
            this.f316295d = i3;
            if (this.f316297f) {
                this.f316300m = true;
                this.D.sendEmptyMessage(0);
            } else {
                this.f316296e = i3;
            }
            super.setCurrentTab(i3);
        }
    }

    public void setSlideAnimaPlay(boolean z16) {
        this.f316297f = z16;
    }

    public SlideTabWidget(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316295d = -1;
        this.f316296e = -1;
        this.f316297f = false;
        this.f316300m = false;
        this.C = false;
        this.D = new a();
        Paint paint = new Paint();
        this.f316299i = paint;
        paint.setColor(getResources().getColor(R.color.skin_blue));
    }

    public void setOnTabSlideCompleteListener(b bVar) {
    }
}
