package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class CountDownProgressBar extends View {
    static IPatchRedirector $redirector_;
    private final int MSG_STOP_TIMER;
    private final int MSG_STRAT_TIMER;
    private final int MSG_UPDATE_PROGRESS;
    private int edgeColor;
    private int edgeWidth;
    private int interColor;
    private OnCountDownLinstener linstener;
    private Handler mHander;
    private Paint mPaint;
    private int outLineColor;
    private int progress;
    private float progressMills;
    private int radio;
    private int ringColor;
    private int ringWidth;
    private float second;
    private int textColor;
    private int textNum;
    private int textSize;
    private long totalMills;
    private int updateMills;
    private long updateNumGap;

    /* loaded from: classes27.dex */
    public interface OnCountDownLinstener {
        void onCountDownStop();
    }

    /* loaded from: classes27.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CountDownProgressBar.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1) {
                    CountDownProgressBar.this.progressMills += CountDownProgressBar.this.updateMills;
                    if (CountDownProgressBar.this.progressMills > ((float) CountDownProgressBar.this.totalMills)) {
                        CountDownProgressBar countDownProgressBar = CountDownProgressBar.this;
                        countDownProgressBar.progress = (int) ((countDownProgressBar.progressMills / ((float) CountDownProgressBar.this.totalMills)) * 360.0f);
                        CountDownProgressBar.this.invalidate();
                        if (CountDownProgressBar.this.linstener != null) {
                            CountDownProgressBar.this.linstener.onCountDownStop();
                            return;
                        }
                        return;
                    }
                    CountDownProgressBar countDownProgressBar2 = CountDownProgressBar.this;
                    countDownProgressBar2.progress = (int) ((countDownProgressBar2.progressMills / ((float) CountDownProgressBar.this.totalMills)) * 360.0f);
                    if (CountDownProgressBar.this.second >= ((float) CountDownProgressBar.this.updateNumGap)) {
                        CountDownProgressBar.this.second = 0.0f;
                        CountDownProgressBar.this.textNum--;
                    } else {
                        CountDownProgressBar.this.second += CountDownProgressBar.this.updateMills;
                    }
                    CountDownProgressBar.this.invalidate();
                    CountDownProgressBar.this.mHander.sendEmptyMessageDelayed(1, CountDownProgressBar.this.updateMills);
                    return;
                }
                return;
            }
            CountDownProgressBar.this.progressMills += CountDownProgressBar.this.updateMills;
            CountDownProgressBar.this.mHander.sendEmptyMessageDelayed(1, CountDownProgressBar.this.updateMills);
        }
    }

    public CountDownProgressBar(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (getWidth() > getHeight()) {
            width = getHeight();
        } else {
            width = getWidth();
        }
        if (this.radio > width) {
            this.radio = width;
        }
        int i3 = this.radio - (this.edgeWidth / 2);
        int i16 = i3 - (this.ringWidth / 2);
        float f16 = width / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.interColor);
        canvas.drawCircle(f16, f16, this.radio, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(this.edgeWidth);
        this.mPaint.setColor(this.edgeColor);
        canvas.drawCircle(f16, f16, i3, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(this.ringWidth);
        this.mPaint.setColor(this.outLineColor);
        float f17 = i16;
        canvas.drawCircle(f16, f16, f17, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setTextSize(this.textSize);
        this.mPaint.setColor(this.textColor);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(Integer.toString(this.textNum), f16, f16 - ((this.mPaint.descent() + this.mPaint.ascent()) / 2.0f), this.mPaint);
        RectF rectF = new RectF();
        float f18 = f16 - f17;
        float f19 = f16 + f17;
        rectF.set(f18, f18, f19, f19);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.ringColor);
        canvas.drawArc(rectF, 270.0f, this.progress, false, this.mPaint);
    }

    public void setOnCountDownLinstener(OnCountDownLinstener onCountDownLinstener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) onCountDownLinstener);
        } else {
            this.linstener = onCountDownLinstener;
        }
    }

    public void setTotalMills(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
        this.totalMills = j3;
        this.updateNumGap = 1000L;
        this.textNum = (int) (j3 / 1000);
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mHander.removeMessages(2);
        this.mHander.removeMessages(1);
        this.progress = 0;
        this.updateMills = 0;
        this.progressMills = 0.0f;
        this.second = 0.0f;
        this.updateNumGap = 1000L;
        if (this.totalMills > 0) {
            this.progressMills = 0.0f;
            this.updateMills = 100;
            this.mHander.sendEmptyMessage(0);
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.mHander.removeMessages(2);
        this.mHander.removeMessages(1);
        this.progress = 0;
        this.updateMills = 0;
        this.progressMills = 0.0f;
        this.second = 0.0f;
        this.updateNumGap = 1000L;
        OnCountDownLinstener onCountDownLinstener = this.linstener;
        if (onCountDownLinstener != null) {
            onCountDownLinstener.onCountDownStop();
        }
    }

    public CountDownProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.second = 0.0f;
        this.updateNumGap = 1000L;
        this.MSG_STRAT_TIMER = 0;
        this.MSG_UPDATE_PROGRESS = 1;
        this.MSG_STOP_TIMER = 2;
        this.mHander = new a();
        this.mPaint = new Paint();
        this.outLineColor = context.getResources().getColor(R.color.a0s);
        this.interColor = context.getResources().getColor(R.color.a0p);
        this.ringColor = context.getResources().getColor(R.color.a0t);
        this.textColor = context.getResources().getColor(R.color.f156896el);
        this.edgeColor = context.getResources().getColor(R.color.a0q);
        float f16 = context.getResources().getDisplayMetrics().density;
        this.textSize = (int) ((21.0f * f16) + 0.5f);
        this.ringWidth = (int) ((2.0f * f16) + 0.5f);
        this.radio = (int) ((18.0f * f16) + 0.5f);
        this.progress = 0;
        this.edgeWidth = Math.max(1, (int) ((f16 * 0.5d) + 0.5d));
    }

    public void setTotalMills(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (i3 == 0) {
            i3 = 1;
        }
        this.totalMills = j3;
        this.textNum = i3;
        this.updateNumGap = j3 / i3;
    }
}
