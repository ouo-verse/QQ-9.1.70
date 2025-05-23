package com.tencent.mobileqq.widget.qus;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUSDragFloatingScreenView extends FrameLayout {
    private LinearLayout C;
    private boolean D;
    private int E;
    private int F;
    private float G;
    private int H;
    private byte I;

    /* renamed from: d, reason: collision with root package name */
    private int f317240d;

    /* renamed from: e, reason: collision with root package name */
    private int f317241e;

    /* renamed from: f, reason: collision with root package name */
    private int f317242f;

    /* renamed from: h, reason: collision with root package name */
    private float f317243h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f317244i;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f317245m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes20.dex */
    public @interface QUSDragFloatShowMode {
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QLog.isColorLevel()) {
                QLog.d("QUSDragFloatingScreenView", 2, "on empty click");
            }
            QUSDragFloatingScreenView.a(QUSDragFloatingScreenView.this);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QUSDragFloatingScreenView(@NonNull Context context) {
        this(context, null);
    }

    static /* bridge */ /* synthetic */ b a(QUSDragFloatingScreenView qUSDragFloatingScreenView) {
        qUSDragFloatingScreenView.getClass();
        return null;
    }

    private void b(int i3) {
        LinearLayout linearLayout = this.C;
        ObjectAnimator.ofFloat(linearLayout, "y", linearLayout.getY(), i3).setDuration(250L).start();
        this.D = false;
        c(false);
    }

    private void c(boolean z16) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(z16);
        }
    }

    private int d(int i3) {
        return (int) ((i3 * this.f317243h) + 0.5f);
    }

    private int e() {
        int i3 = this.f317240d;
        return Math.max(i3, Math.min(i3, this.f317242f - this.f317241e));
    }

    private void f(MotionEvent motionEvent) {
        float rawY = motionEvent.getRawY();
        k(rawY);
        float f16 = rawY - this.G;
        float y16 = this.C.getY();
        float f17 = y16 + f16;
        int i3 = this.f317241e;
        if (f17 < i3) {
            this.C.offsetTopAndBottom((int) (i3 - y16));
        } else {
            int i16 = this.f317242f;
            int i17 = this.f317240d;
            if (f17 > i16 - i17) {
                this.C.offsetTopAndBottom((int) ((i16 - i17) - y16));
            } else {
                this.C.offsetTopAndBottom((int) f16);
            }
        }
        this.G = motionEvent.getRawY();
    }

    private void g() {
        float y16 = this.C.getY();
        if (y16 < this.f317242f - e()) {
            int i3 = this.F;
            if (i3 <= 1) {
                if (y16 >= (this.f317242f - e()) / 2.0f && this.I != 2) {
                    h();
                    return;
                } else {
                    j();
                    return;
                }
            }
            if (i3 == 2) {
                if (y16 <= (this.f317242f - e()) / 2.0f && this.I != 1) {
                    j();
                    return;
                } else {
                    h();
                    return;
                }
            }
            return;
        }
        int i16 = this.F;
        if (i16 >= 1) {
            if (y16 < (this.f317242f - this.f317240d) - ((e() - this.f317240d) / 2) && this.I != 1) {
                h();
                return;
            } else {
                i();
                return;
            }
        }
        if (i16 == 0) {
            if (y16 > (this.f317242f - this.f317240d) - ((e() - this.f317240d) / 2) && this.I != 2) {
                i();
            } else {
                h();
            }
        }
    }

    private void k(float f16) {
        float f17 = f16 - this.G;
        if (Math.abs(f17) > this.H) {
            if (f17 > 0.0f) {
                this.I = (byte) 1;
            } else if (f17 < 0.0f) {
                this.I = (byte) 2;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QUSDragFloatingScreenView", 2, "swipeDirectionJudge : mSlideStartDir -> " + ((int) this.I));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("QUSDragFloatingScreenView", 2, "dispatchTouchEvent : " + motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.D) {
                    f(motionEvent);
                    return true;
                }
            } else if (this.D) {
                g();
            }
        } else {
            this.G = motionEvent.getRawY();
            Rect rect = new Rect();
            this.f317245m.getGlobalVisibleRect(rect);
            if (!rect.isEmpty() && rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.D = z16;
            if (z16) {
                c(true);
            }
            if (QLog.isColorLevel()) {
                QLog.d("QUSDragFloatingScreenView", 2, "mConsumeTouchEvent : " + this.D);
            }
        }
        if (this.D) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void h() {
        if (QLog.isColorLevel()) {
            QLog.d("QUSDragFloatingScreenView", 2, "showDefaultHeight");
        }
        if (this.f317242f - e() > this.f317241e) {
            this.F = 1;
            this.f317244i.setImageResource(R.drawable.hzk);
            b(this.f317242f - e());
        }
    }

    public void i() {
        if (QLog.isColorLevel()) {
            QLog.d("QUSDragFloatingScreenView", 2, "showMinHeight");
        }
        this.F = 0;
        this.f317244i.setImageResource(R.drawable.hzk);
        b(this.f317242f - this.f317240d);
    }

    public void j() {
        if (QLog.isColorLevel()) {
            QLog.d("QUSDragFloatingScreenView", 2, "showTotal");
        }
        this.F = 2;
        this.f317244i.setImageResource(R.drawable.hzl);
        b(this.f317241e);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f317242f <= 0) {
            int measuredHeight = getMeasuredHeight();
            this.f317242f = measuredHeight;
            if (this.E == 0) {
                i19 = e();
            } else {
                i19 = 0;
            }
            int i26 = measuredHeight - i19;
            for (int i27 = 0; i27 < getChildCount(); i27++) {
                View childAt = getChildAt(i27);
                childAt.layout(0, i26, childAt.getMeasuredWidth(), childAt.getMeasuredHeight() + i26);
                childAt.setTag("QUSDragFloatingScreenView");
            }
        }
    }

    public void setQUSDragFloatController(b bVar) {
        int i3;
        if (bVar != null) {
            View createContentView = bVar.createContentView();
            if (createContentView != null) {
                if (createContentView.getParent() != null) {
                    ((ViewGroup) createContentView.getParent()).removeView(createContentView);
                }
                this.C.addView(createContentView);
            }
            int showMode = bVar.showMode();
            this.E = showMode;
            int i16 = 0;
            if (showMode == 0) {
                i3 = Math.max(this.f317240d, bVar.minHeight());
            } else {
                i3 = 0;
            }
            this.f317240d = i3;
            if (this.E == 0) {
                i16 = 1;
            }
            this.F = i16;
        }
    }

    public QUSDragFloatingScreenView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QUSDragFloatingScreenView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = false;
        this.E = 0;
        this.I = (byte) 0;
        this.f317243h = getContext().getResources().getDisplayMetrics().density;
        this.f317240d = d(36);
        this.f317241e = d(60);
        this.H = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.C = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = d(60);
        this.C.setLayoutParams(layoutParams);
        this.C.setBackgroundResource(R.drawable.b4k);
        this.C.setOrientation(1);
        addView(this.C);
        int d16 = d(36);
        this.f317245m = new FrameLayout(getContext());
        this.f317245m.setLayoutParams(new LinearLayout.LayoutParams(-1, d16));
        this.C.addView(this.f317245m);
        this.f317244i = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d16, d16);
        layoutParams2.gravity = 17;
        this.f317244i.setImageResource(R.drawable.hzk);
        this.f317244i.setLayoutParams(layoutParams2);
        this.f317245m.addView(this.f317244i);
        setOnClickListener(new a());
    }
}
