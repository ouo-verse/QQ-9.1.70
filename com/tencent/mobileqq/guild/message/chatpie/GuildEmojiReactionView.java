package com.tencent.mobileqq.guild.message.chatpie;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildEmojiReactionView extends LinearLayout {
    private final int C;
    private float D;
    private float E;
    private float F;
    private final int[] G;
    private int H;
    private a I;
    private boolean J;

    /* renamed from: d, reason: collision with root package name */
    private boolean f230333d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f230334e;

    /* renamed from: f, reason: collision with root package name */
    private int f230335f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f230336h;

    /* renamed from: i, reason: collision with root package name */
    private View f230337i;

    /* renamed from: m, reason: collision with root package name */
    private final Scroller f230338m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void a();

        void b(float f16);

        void c();

        void d();
    }

    public GuildEmojiReactionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = new int[2];
        this.J = false;
        this.f230338m = new Scroller(getContext());
        this.C = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private float a(float f16) {
        if (((int) (getScrollY() + f16)) < 0) {
            return f16;
        }
        return -getScrollY();
    }

    private boolean b(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        float y17 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return true;
                    }
                } else {
                    float f16 = this.F;
                    float f17 = this.E;
                    if (f16 <= f17) {
                        if (y17 < f17) {
                            this.I.b(f16 - y17);
                        } else {
                            this.I.b(f16 - f17);
                            scrollBy(0, (int) a(this.E - y17));
                        }
                    } else if (y17 > f17) {
                        scrollBy(0, (int) a(f16 - y17));
                    } else {
                        scrollBy(0, (int) a(f16 - this.D));
                        this.I.b(this.E - y17);
                    }
                    this.F = y17;
                    return true;
                }
            }
            float f18 = this.E;
            float f19 = f18 - y17;
            int i3 = this.C;
            if (f19 >= i3) {
                c(motionEvent);
            } else if (f18 - y17 > 0.0f && f18 - y17 < i3) {
                this.I.a();
            } else if ((-getScrollY()) < g()) {
                k(0);
            } else {
                this.f230334e = true;
                k(-this.f230335f);
            }
            this.f230333d = false;
            return true;
        }
        this.F = motionEvent.getY();
        this.D = x16;
        this.E = y16;
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    private void c(MotionEvent motionEvent) {
        if (this.f230336h != null && this.E <= r3.getTop()) {
            this.J = true;
        }
        this.I.c();
        this.H = 1;
    }

    private boolean d(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        float abs = Math.abs(x16 - this.D);
        float abs2 = Math.abs(y16 - this.E);
        float y17 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    float a16 = a(this.F - y17);
                    if (this.f230333d) {
                        scrollBy(0, (int) a16);
                    } else if (this.H == 0) {
                        if (h(abs, abs2, y16)) {
                            c(motionEvent);
                        } else {
                            super.dispatchTouchEvent(motionEvent);
                        }
                    }
                    this.F = y17;
                    return true;
                }
            }
            this.f230333d = false;
            super.dispatchTouchEvent(motionEvent);
            if ((-getScrollY()) < g()) {
                k(0);
            } else {
                this.f230334e = true;
                k(-this.f230335f);
            }
            return true;
        }
        this.F = motionEvent.getY();
        this.D = x16;
        this.E = y16;
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    private boolean e() {
        if (getChildCount() < 2 || getChildAt(1) == null) {
            return false;
        }
        return true;
    }

    private float g() {
        return this.f230335f / 3.0f;
    }

    private boolean h(float f16, float f17, float f18) {
        if (f17 > this.C && f18 < this.E && f17 > f16) {
            return true;
        }
        return false;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        if (this.f230333d) {
            return true;
        }
        if (j(view, motionEvent)) {
            this.f230333d = true;
            return true;
        }
        return false;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int rawY = (int) motionEvent.getRawY();
        int rawX = (int) motionEvent.getRawX();
        view.getLocationOnScreen(this.G);
        int[] iArr = this.G;
        int i3 = iArr[0];
        int i16 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i3;
        int measuredHeight = view.getMeasuredHeight() + i16;
        if (rawY < i16 || rawY > measuredHeight || rawX < i3 || rawX > measuredWidth) {
            return false;
        }
        return true;
    }

    private void k(int i3) {
        this.f230338m.startScroll(0, getScrollY(), 0, i3 - getScrollY());
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f230338m.computeScrollOffset()) {
            scrollTo(this.f230338m.getCurrX(), this.f230338m.getCurrY());
            invalidate();
        } else if (this.f230334e) {
            this.f230334e = false;
            this.I.d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View view = this.f230337i;
        if (view == null) {
            view = getChildAt(0);
        }
        boolean i3 = i(view, motionEvent);
        if (i3 && this.H == 0) {
            return b(motionEvent);
        }
        if (i3) {
            return d(motionEvent);
        }
        if (this.H == 0) {
            return d(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean f() {
        boolean z16 = this.J;
        this.J = false;
        return z16;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (e()) {
            View childAt = getChildAt(1);
            float min = Math.min(0.95f, Math.max(0.1f, (childAt.getMeasuredHeight() + 0.5f) / getMeasuredHeight()));
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, 0);
            }
            layoutParams.height = Math.round(min * ViewUtils.dpToPx(configuration.screenHeightDp));
            childAt.setLayoutParams(layoutParams);
        }
    }

    public void setAtPanelTouchListener(a aVar) {
        this.I = aVar;
    }

    public void setContentHeight(int i3) {
        this.f230335f = i3;
    }

    public void setTitleBar(RelativeLayout relativeLayout) {
        this.f230336h = relativeLayout;
    }
}
