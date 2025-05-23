package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class GlowCountRecyclerView extends RecyclerView implements Handler.Callback {
    static IPatchRedirector $redirector_;
    int C;
    int D;
    int E;
    int F;
    Drawable G;
    Handler H;

    /* renamed from: d, reason: collision with root package name */
    int f259782d;

    /* renamed from: e, reason: collision with root package name */
    boolean f259783e;

    /* renamed from: f, reason: collision with root package name */
    Paint f259784f;

    /* renamed from: h, reason: collision with root package name */
    int f259785h;

    /* renamed from: i, reason: collision with root package name */
    String f259786i;

    /* renamed from: m, reason: collision with root package name */
    int f259787m;

    public GlowCountRecyclerView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            c();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void c() {
        float f16 = getResources().getDisplayMetrics().density;
        this.f259785h = (int) (8.0f * f16);
        Paint paint = new Paint(1);
        this.f259784f = paint;
        paint.setTextAlign(Paint.Align.CENTER);
        this.f259784f.setColor(-1);
        this.f259784f.setTextSize(14.0f * f16);
        this.E = (int) (f16 * 3.0f);
        this.G = getResources().getDrawable(R.drawable.afv);
    }

    private void d() {
        Rect rect = new Rect();
        Paint paint = this.f259784f;
        String str = this.f259786i;
        paint.getTextBounds(str, 0, str.length(), rect);
        this.C = rect.width();
        Paint.FontMetrics fontMetrics = this.f259784f.getFontMetrics();
        this.D = (int) ((fontMetrics.bottom - fontMetrics.top) + 0.5f);
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public void draw(Canvas canvas) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
            return;
        }
        super.draw(canvas);
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            i3 = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            i3 = ((StaggeredGridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPositions(null)[0];
        } else {
            i3 = -1;
        }
        if (e() && i3 == 0) {
            Drawable drawable = this.G;
            int i16 = this.C;
            int i17 = this.E;
            drawable.setBounds(0, 0, i16 + (i17 * 2), this.D + (i17 * 2));
            int paddingLeft = (int) (getPaddingLeft() + (getResources().getDisplayMetrics().density * 5.0f));
            Paint.FontMetrics fontMetrics = this.f259784f.getFontMetrics();
            int i18 = this.D;
            float measuredHeight = (int) ((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) - ((i18 + (r5 * 2)) * 0.5f));
            int i19 = (int) ((measuredHeight - fontMetrics.top) + this.E);
            canvas.save();
            canvas.translate(paddingLeft, measuredHeight);
            this.G.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.translate(paddingLeft + this.E, 0.0f);
            canvas.drawText(this.f259786i, this.C * 0.5f, i19, this.f259784f);
            canvas.restore();
        }
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (!this.f259783e && !this.H.hasMessages(0)) {
            return false;
        }
        return true;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.f259783e) {
            this.H.removeMessages(0);
            this.H.sendEmptyMessageDelayed(0, 750L);
            invalidate();
        }
        this.f259783e = false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 0) {
            invalidate();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            super.onDetachedFromWindow();
            this.H.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                    f();
                    this.f259782d = -1;
                }
            } else {
                f();
                this.f259782d = -1;
            }
        } else {
            this.f259782d = (int) motionEvent.getX();
        }
        return onInterceptTouchEvent;
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        f();
                        this.f259782d = -1;
                    }
                } else if (this.f259782d >= 0 && !this.f259783e) {
                    if (((int) (motionEvent.getX() - this.f259782d)) > this.f259785h) {
                        this.f259783e = true;
                    }
                    invalidate();
                }
            } else {
                f();
                this.f259782d = -1;
            }
        } else {
            this.f259782d = (int) motionEvent.getX();
        }
        return onTouchEvent;
    }

    public void setText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else if (!TextUtils.equals(str, this.f259786i)) {
            this.f259786i = str;
            d();
            invalidate();
        }
    }

    public void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else if (i3 != this.F) {
            this.F = i3;
            this.f259784f.setColor(i3);
            invalidate();
        }
    }

    public void setTextSizeDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        int i16 = (int) (i3 * getResources().getDisplayMetrics().density);
        if (i16 != this.f259787m) {
            this.f259787m = i16;
            this.f259784f.setTextSize(i16);
            d();
            invalidate();
        }
    }

    public GlowCountRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            c();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public GlowCountRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f259782d = -1;
        this.f259786i = "";
        this.F = -1;
        this.H = new Handler(this);
    }
}
