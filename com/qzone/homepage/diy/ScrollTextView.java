package com.qzone.homepage.diy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ScrollTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private int f47515d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f47516e;

    /* renamed from: f, reason: collision with root package name */
    private Timer f47517f;

    /* renamed from: h, reason: collision with root package name */
    private TimerTask f47518h;

    /* renamed from: i, reason: collision with root package name */
    private int f47519i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f47520m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class MyTimerTask extends TimerTask {
        MyTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (ScrollTextView.this.f47516e.right < ScrollTextView.this.getWidth() || ScrollTextView.this.f47520m) {
                return;
            }
            if (ScrollTextView.this.f47515d == 0) {
                if (ScrollTextView.this.f47519i < 0) {
                    ScrollTextView scrollTextView = ScrollTextView.this;
                    scrollTextView.f47515d = scrollTextView.f47516e.right;
                } else {
                    ScrollTextView scrollTextView2 = ScrollTextView.this;
                    scrollTextView2.f47515d = -scrollTextView2.f47516e.right;
                }
            }
            if (ScrollTextView.this.f47515d < (-ScrollTextView.this.f47516e.right)) {
                ScrollTextView scrollTextView3 = ScrollTextView.this;
                scrollTextView3.f47515d = scrollTextView3.f47516e.right;
            } else if (ScrollTextView.this.f47515d > ScrollTextView.this.f47516e.right) {
                ScrollTextView scrollTextView4 = ScrollTextView.this;
                scrollTextView4.f47515d = -scrollTextView4.f47516e.right;
            }
            ScrollTextView.this.f47515d += ScrollTextView.this.f47519i;
            ScrollTextView.this.postInvalidate();
        }
    }

    public ScrollTextView(Context context) {
        super(context);
        this.f47515d = 0;
        this.f47519i = -5;
        this.f47520m = false;
        f();
    }

    private void f() {
        this.f47516e = new Rect();
        this.f47517f = new BaseTimer();
        MyTimerTask myTimerTask = new MyTimerTask();
        this.f47518h = myTimerTask;
        this.f47517f.schedule(myTimerTask, 0L, 41L);
    }

    public void g() {
        TimerTask timerTask = this.f47518h;
        if (timerTask != null) {
            timerTask.cancel();
            this.f47518h = null;
        }
        Timer timer = this.f47517f;
        if (timer != null) {
            timer.cancel();
            this.f47517f.purge();
            this.f47517f = null;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        TimerTask timerTask = this.f47518h;
        if (timerTask != null) {
            timerTask.cancel();
            this.f47518h = null;
        }
        Timer timer = this.f47517f;
        if (timer != null) {
            timer.cancel();
            this.f47517f = null;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.getTextBounds(charSequence, 0, charSequence.length(), this.f47516e);
        float descent = (((-paint.ascent()) + paint.descent()) / 2.0f) - paint.descent();
        if (this.f47516e.right < getWidth()) {
            canvas.drawText(charSequence, 0.0f, (getHeight() / 2) + descent, paint);
        } else {
            canvas.drawText(charSequence, this.f47515d, (getHeight() / 2) + descent, paint);
        }
    }

    public void setSpeed(int i3) {
        this.f47519i = i3;
    }

    public void h() {
        this.f47520m = true;
    }

    public void i() {
        this.f47520m = false;
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47515d = 0;
        this.f47519i = -5;
        this.f47520m = false;
        f();
    }

    public ScrollTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f47515d = 0;
        this.f47519i = -5;
        this.f47520m = false;
        f();
    }
}
