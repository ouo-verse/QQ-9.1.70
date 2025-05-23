package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes20.dex */
public class CustomedTabWidget extends LinearLayout {
    private Drawable C;
    private Paint D;
    float E;
    private float F;
    int G;
    boolean H;
    private int I;

    /* renamed from: d, reason: collision with root package name */
    c f315609d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f315610e;

    /* renamed from: f, reason: collision with root package name */
    Rect f315611f;

    /* renamed from: h, reason: collision with root package name */
    Rect f315612h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f315613i;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f315614m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CustomedTabWidget customedTabWidget = CustomedTabWidget.this;
            customedTabWidget.setCurrentTab(customedTabWidget.indexOfChild(view));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int i3 = 0;
                while (true) {
                    if (i3 >= CustomedTabWidget.this.getChildCount()) {
                        break;
                    }
                    if (CustomedTabWidget.this.getChildAt(i3) == view) {
                        CustomedTabWidget customedTabWidget = CustomedTabWidget.this;
                        customedTabWidget.G = i3;
                        customedTabWidget.H = true;
                        customedTabWidget.invalidate();
                        break;
                    }
                    i3++;
                }
            } else if (motionEvent.getAction() == 1) {
                CustomedTabWidget customedTabWidget2 = CustomedTabWidget.this;
                customedTabWidget2.H = false;
                customedTabWidget2.invalidate();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<CustomedTabWidget> f315617a;

        public c(CustomedTabWidget customedTabWidget) {
            this.f315617a = new WeakReference<>(customedTabWidget);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Rect rect;
            float f16;
            CustomedTabWidget customedTabWidget = this.f315617a.get();
            if (customedTabWidget == null) {
                return;
            }
            float f17 = customedTabWidget.E;
            if (f17 < 0.0f) {
                Rect rect2 = customedTabWidget.f315612h;
                customedTabWidget.invalidate((int) (rect2.left + f17), rect2.top, rect2.right, rect2.bottom);
            } else {
                Rect rect3 = customedTabWidget.f315612h;
                customedTabWidget.invalidate(rect3.left, rect3.top, (int) (rect3.right + f17), rect3.bottom);
            }
            synchronized (customedTabWidget.f315609d) {
                rect = customedTabWidget.f315612h;
                float f18 = rect.left;
                f16 = customedTabWidget.E;
                rect.left = (int) (f18 + f16);
                rect.right = (int) (rect.right + f16);
            }
            Rect rect4 = customedTabWidget.f315611f;
            int i3 = rect4.left;
            if ((i3 - r2) / f16 >= 1.0f) {
                sendEmptyMessage(0);
            } else {
                rect.set(i3, rect4.top, rect4.right, rect4.bottom);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface d {
    }

    public CustomedTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315611f = new Rect();
        this.f315612h = new Rect();
        this.D = new Paint();
        this.H = false;
        this.I = 0;
        ImageView imageView = (ImageView) View.inflate(context, R.layout.byy, null);
        this.f315610e = imageView;
        this.f315613i = imageView.getBackground();
        this.f315614m = context.getResources().getDrawable(R.drawable.skin_slidetab_slider_current);
        this.C = context.getResources().getDrawable(R.drawable.skin_slidetab_slider);
        this.F = context.getResources().getDisplayMetrics().density;
        this.f315609d = new c(this);
    }

    private void a(View view) {
        view.setOnClickListener(new a());
        view.setOnTouchListener(new b());
        if (getChildCount() == 1) {
            view.setSelected(true);
        }
    }

    private void b(int i3) {
        int i16 = this.I;
        if (i3 == i16) {
            return;
        }
        getChildAt(i16).setSelected(false);
        this.I = i3;
        getChildAt(i3).setSelected(true);
        getChildAt(this.I).getHitRect(this.f315611f);
        Rect rect = this.f315611f;
        int i17 = rect.left;
        Rect rect2 = this.f315612h;
        if (i17 != rect2.left || rect.right != rect2.right) {
            this.E = (i17 - r3) / 4;
            this.f315609d.sendEmptyMessage(0);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        a(view);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.C.setBounds(0, getHeight() - 6, getWidth(), getHeight());
        this.C.draw(canvas);
        int width = getWidth() / getChildCount();
        int centerX = this.f315612h.centerX() - (width / 2);
        Drawable drawable = this.f315614m;
        int i3 = this.f315612h.bottom;
        drawable.setBounds(centerX, i3 - ((int) (this.F * 4.0f)), width + centerX, i3);
        this.f315614m.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        getChildAt(this.I).getHitRect(this.f315611f);
        Rect rect = this.f315612h;
        Rect rect2 = this.f315611f;
        rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        setCurrentTab(this.I);
    }

    public void setCurrentTab(int i3) {
        if (i3 >= 0 && i3 < getChildCount()) {
            b(i3);
        }
    }

    public void setOnSwitchTabListener(d dVar) {
        this.f315609d.removeMessages(0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        super.addView(view, i3);
        a(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, int i16) {
        super.addView(view, i3, i16);
        a(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        a(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        a(view);
    }
}
