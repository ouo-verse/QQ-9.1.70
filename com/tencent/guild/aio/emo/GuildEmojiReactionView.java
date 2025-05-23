package com.tencent.guild.aio.emo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GuildEmojiReactionView extends LinearLayout {
    private final int C;
    private float D;
    private float E;
    private float F;
    private final int[] G;
    private int H;
    private boolean I;

    /* renamed from: d, reason: collision with root package name */
    private boolean f110352d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f110353e;

    /* renamed from: f, reason: collision with root package name */
    private int f110354f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f110355h;

    /* renamed from: i, reason: collision with root package name */
    private View f110356i;

    /* renamed from: m, reason: collision with root package name */
    private final Scroller f110357m;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
    }

    public GuildEmojiReactionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = new int[2];
        this.I = false;
        this.f110357m = new Scroller(getContext());
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
                            throw null;
                        }
                        throw null;
                    }
                    if (y17 > f17) {
                        scrollBy(0, (int) a(f16 - y17));
                        this.F = y17;
                        return true;
                    }
                    scrollBy(0, (int) a(f16 - this.D));
                    throw null;
                }
            }
            float f18 = this.E;
            float f19 = f18 - y17;
            int i3 = this.C;
            if (f19 >= i3) {
                c(motionEvent);
            } else {
                if (f18 - y17 > 0.0f && f18 - y17 < i3) {
                    throw null;
                }
                if ((-getScrollY()) < e()) {
                    i(0);
                } else {
                    this.f110353e = true;
                    i(-this.f110354f);
                }
            }
            this.f110352d = false;
            return true;
        }
        this.F = motionEvent.getY();
        this.D = x16;
        this.E = y16;
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    private void c(MotionEvent motionEvent) {
        if (this.f110355h != null && this.E <= r2.getTop()) {
            this.I = true;
        }
        throw null;
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
                    if (this.f110352d) {
                        scrollBy(0, (int) a16);
                    } else if (this.H == 0) {
                        if (f(abs, abs2, y16)) {
                            c(motionEvent);
                        } else {
                            super.dispatchTouchEvent(motionEvent);
                        }
                    }
                    this.F = y17;
                    return true;
                }
            }
            this.f110352d = false;
            super.dispatchTouchEvent(motionEvent);
            if ((-getScrollY()) < e()) {
                i(0);
            } else {
                this.f110353e = true;
                i(-this.f110354f);
            }
            return true;
        }
        this.F = motionEvent.getY();
        this.D = x16;
        this.E = y16;
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    private float e() {
        return this.f110354f / 3.0f;
    }

    private boolean f(float f16, float f17, float f18) {
        if (f17 > this.C && f18 < this.E && f17 > f16) {
            return true;
        }
        return false;
    }

    private boolean g(View view, MotionEvent motionEvent) {
        if (this.f110352d) {
            return true;
        }
        if (h(view, motionEvent)) {
            this.f110352d = true;
            return true;
        }
        return false;
    }

    private boolean h(View view, MotionEvent motionEvent) {
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

    private void i(int i3) {
        this.f110357m.startScroll(0, getScrollY(), 0, i3 - getScrollY());
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f110357m.computeScrollOffset()) {
            scrollTo(this.f110357m.getCurrX(), this.f110357m.getCurrY());
            invalidate();
        } else {
            if (!this.f110353e) {
                return;
            }
            this.f110353e = false;
            throw null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View view = this.f110356i;
        if (view == null) {
            view = getChildAt(0);
        }
        boolean g16 = g(view, motionEvent);
        if (g16 && this.H == 0) {
            return b(motionEvent);
        }
        if (g16) {
            return d(motionEvent);
        }
        if (this.H == 0) {
            return d(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setContentHeight(int i3) {
        this.f110354f = i3;
    }

    public void setTitleBar(RelativeLayout relativeLayout) {
        this.f110355h = relativeLayout;
    }

    public void setAtPanelTouchListener(a aVar) {
    }
}
