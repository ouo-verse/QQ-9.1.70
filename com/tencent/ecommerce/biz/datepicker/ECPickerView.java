package com.tencent.ecommerce.biz.datepicker;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes31.dex */
public class ECPickerView extends View {
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private float H;
    private float I;
    private List<String> J;
    private int K;
    private boolean L;
    private boolean M;
    private OnSelectListener N;
    private ObjectAnimator P;
    private boolean Q;
    private Timer R;
    private TimerTask S;
    private Handler T;

    /* renamed from: d, reason: collision with root package name */
    private Context f102007d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f102008e;

    /* renamed from: f, reason: collision with root package name */
    private int f102009f;

    /* renamed from: h, reason: collision with root package name */
    private int f102010h;

    /* renamed from: i, reason: collision with root package name */
    private float f102011i;

    /* renamed from: m, reason: collision with root package name */
    private float f102012m;

    /* loaded from: classes31.dex */
    public interface OnSelectListener {
        void onSelect(View view, String str);
    }

    /* loaded from: classes31.dex */
    private static class ScrollTimerTask extends TimerTask {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<Handler> f102013d;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Handler handler = this.f102013d.get();
            if (handler == null) {
                return;
            }
            handler.sendEmptyMessage(0);
        }

        ScrollTimerTask(Handler handler) {
            this.f102013d = new WeakReference<>(handler);
        }
    }

    /* loaded from: classes31.dex */
    private static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<ECPickerView> f102014a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ECPickerView eCPickerView = this.f102014a.get();
            if (eCPickerView == null) {
                return;
            }
            eCPickerView.e();
        }

        b(ECPickerView eCPickerView) {
            this.f102014a = new WeakReference<>(eCPickerView);
        }
    }

    public ECPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J = new ArrayList();
        this.L = true;
        this.M = true;
        this.Q = true;
        this.R = new Timer();
        this.T = new b();
        this.f102007d = context;
        d();
    }

    private void b() {
        TimerTask timerTask = this.S;
        if (timerTask != null) {
            timerTask.cancel();
            this.S = null;
        }
        Timer timer = this.R;
        if (timer != null) {
            timer.purge();
        }
    }

    private void c(Canvas canvas, int i3, float f16, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        float pow = 1.0f - ((float) Math.pow(f16 / this.C, 2.0d));
        if (pow < 0.0f) {
            pow = 0.0f;
        }
        this.f102008e.setTextSize(this.D + (this.E * pow));
        this.f102008e.setColor(i3);
        this.f102008e.setAlpha(((int) (pow * 135.0f)) + 120);
        Paint.FontMetrics fontMetrics = this.f102008e.getFontMetrics();
        canvas.drawText(str, this.f102011i, (this.f102012m + f16) - ((fontMetrics.top + fontMetrics.bottom) / 2.0f), this.f102008e);
    }

    private void d() {
        Paint paint = new Paint(1);
        this.f102008e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f102008e.setTextAlign(Paint.Align.CENTER);
        ECSkin eCSkin = ECSkin.INSTANCE;
        this.f102009f = eCSkin.getColor(R.color.f6942x);
        this.f102010h = eCSkin.getColor(R.color.f6962z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (Math.abs(this.H) < 10.0f) {
            this.H = 0.0f;
            if (this.S != null) {
                b();
                if (this.N != null && this.K < this.J.size()) {
                    this.N.onSelect(this, this.J.get(this.K));
                }
            }
        } else {
            float f16 = this.H;
            if (f16 > 0.0f) {
                this.H = f16 - 10.0f;
            } else {
                this.H = f16 + 10.0f;
            }
        }
        invalidate();
    }

    private void f() {
        if (!this.M || this.J.isEmpty()) {
            return;
        }
        String str = this.J.get(0);
        this.J.remove(0);
        this.J.add(str);
    }

    private void g() {
        if (!this.M || this.J.isEmpty()) {
            return;
        }
        String str = this.J.get(r0.size() - 1);
        this.J.remove(r1.size() - 1);
        this.J.add(0, str);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.L && super.dispatchTouchEvent(motionEvent);
    }

    public void h() {
        if (this.Q) {
            if (this.P == null) {
                this.P = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat(c.f123400v, 1.0f, 0.0f, 1.0f), PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.3f, 1.0f), PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.3f, 1.0f)).setDuration(200L);
            }
            if (this.P.isRunning()) {
                return;
            }
            this.P.start();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.K >= this.J.size()) {
            return;
        }
        c(canvas, this.f102009f, this.H, this.J.get(this.K));
        for (int i3 = 1; i3 <= Math.min(this.K, 2); i3++) {
            c(canvas, this.f102010h, this.H - (i3 * this.F), this.J.get(this.K - i3));
        }
        int size = this.J.size() - this.K;
        for (int i16 = 1; i16 < Math.min(size, 3); i16++) {
            c(canvas, this.f102010h, this.H + (i16 * this.F), this.J.get(this.K + i16));
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.f102011i = getMeasuredWidth() / 2.0f;
        float measuredHeight = getMeasuredHeight();
        this.f102012m = measuredHeight / 2.0f;
        this.C = measuredHeight / 4.0f;
        float f16 = measuredHeight / 8.0f;
        float f17 = f16 / 2.2f;
        this.D = f17;
        this.E = f16 - f17;
        float f18 = f17 * 4.0f;
        this.F = f18;
        this.G = f18 / 2.0f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            b();
            this.I = motionEvent.getY();
        } else if (actionMasked != 1) {
            if (actionMasked == 2) {
                float y16 = motionEvent.getY();
                float f16 = this.H + (y16 - this.I);
                this.H = f16;
                float f17 = this.G;
                if (f16 > f17) {
                    if (!this.M) {
                        int i3 = this.K;
                        if (i3 == 0) {
                            this.I = y16;
                            invalidate();
                        } else {
                            this.K = i3 - 1;
                        }
                    } else {
                        g();
                    }
                    this.H -= this.F;
                    this.I = y16;
                    invalidate();
                } else {
                    if (f16 < (-f17)) {
                        if (!this.M) {
                            if (this.K == this.J.size() - 1) {
                                this.I = y16;
                                invalidate();
                            } else {
                                this.K++;
                            }
                        } else {
                            f();
                        }
                        this.H += this.F;
                    }
                    this.I = y16;
                    invalidate();
                }
            }
        } else if (Math.abs(this.H) < 0.01d) {
            this.H = 0.0f;
        } else {
            b();
            ScrollTimerTask scrollTimerTask = new ScrollTimerTask(this.T);
            this.S = scrollTimerTask;
            this.R.schedule(scrollTimerTask, 0L, 10L);
        }
        return true;
    }

    public void setCanScroll(boolean z16) {
        this.L = z16;
    }

    public void setCanScrollLoop(boolean z16) {
        this.M = z16;
    }

    public void setCanShowAnim(boolean z16) {
        this.Q = z16;
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.N = onSelectListener;
    }

    public void setSelected(int i3) {
        if (i3 >= this.J.size()) {
            return;
        }
        this.K = i3;
        if (this.M) {
            int size = (this.J.size() / 2) - this.K;
            int i16 = 0;
            if (size < 0) {
                while (i16 < (-size)) {
                    f();
                    this.K--;
                    i16++;
                }
            } else if (size > 0) {
                while (i16 < size) {
                    g();
                    this.K++;
                    i16++;
                }
            }
        }
        invalidate();
    }

    public void setDataList(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.J = list;
        this.K = 0;
        invalidate();
    }
}
