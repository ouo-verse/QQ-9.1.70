package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.mobileqq.richstatus.RichStatus;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TimeDelArea extends FeedTextArea {
    public int color;
    private Runnable countDownRunnable;
    public Paint mCriclePaint;
    private long mFeedDelTime;
    public Paint mLinePaint;
    private Handler mMainHandler;
    public int radiu;
    private static final long CIRCLETIME = com.qzone.adapter.feedcomponent.i.H().S("QZoneSetting", "QzoneMoodDeleteTime", 86400);
    private static final long REFRESHTIME = com.qzone.adapter.feedcomponent.i.H().S("QZoneSetting", "QzoneMoodDeleteRefreshTime", 1);
    private static final String TIMEFORMAT = com.qzone.adapter.feedcomponent.i.H().T("QZoneSetting", "QzoneMoodDeleteTimeFormat", "hh:mm:ss \u540e\u6d88\u5931&hh:mm:ss \u540e\u6d88\u5931&hh:mm:ss \u540e\u6d88\u5931");
    static final int DEFAULT_SPACE = (int) (FeedGlobalEnv.g().getDensity() * 5.0f);
    static final int ICON_WIDTH = (int) (FeedGlobalEnv.g().getDensity() * 12.0f);

    /* JADX INFO: Access modifiers changed from: private */
    public void doCountDownCircle() {
        this.mMainHandler.removeCallbacks(this.countDownRunnable);
        if (this.mFeedDelTime - (com.qzone.adapter.feedcomponent.i.H().B0() / 1000) <= 0) {
            return;
        }
        this.mMainHandler.postDelayed(this.countDownRunnable, REFRESHTIME * 1000);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        int i3;
        long B0 = this.mFeedDelTime - (com.qzone.adapter.feedcomponent.i.H().B0() / 1000);
        if (B0 > 0) {
            long j3 = CIRCLETIME;
            i3 = B0 >= j3 ? 25 : (int) Math.ceil((B0 * 24.0d) / j3);
        } else {
            i3 = 0;
        }
        this.radiu = ICON_WIDTH / 2;
        int i16 = getmFontHeight();
        int i17 = this.radiu;
        int i18 = AreaConst.f48746dp1;
        float f16 = ((i16 - (i17 * 2)) / 2) + i18;
        float f17 = i18;
        RectF rectF = new RectF(f17, f16, (i17 * 2) + f17, (i17 * 2) + f16);
        this.mLinePaint.setStrokeWidth(com.qzone.proxy.feedcomponent.util.g.a(1.0f));
        float f18 = 360.0f - (i3 * 14.4f);
        Path path = new Path();
        path.addArc(rectF, 0.0f, 360.0f);
        this.mLinePaint.setColor(this.color);
        canvas.drawPath(path, this.mLinePaint);
        this.mCriclePaint.setColor(this.color);
        canvas.drawArc(rectF, -90.0f, f18, true, this.mCriclePaint);
        canvas.translate(r1 + DEFAULT_SPACE, 0.0f);
        super.draw(canvas, paint);
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
        setData(com.qzone.proxy.feedcomponent.util.c.c(this.mFeedDelTime - (com.qzone.adapter.feedcomponent.i.H().B0() / 1000), TIMEFORMAT), 0);
        super.measure(-2, i16);
        this.mWidth = this.mWidth + DEFAULT_SPACE + ICON_WIDTH;
        this.mHeight = Math.max(this.mHeight, com.qzone.adapter.feedcomponent.b.f41860g);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.SubArea
    public boolean onTouchEvent(MotionEvent motionEvent, SubAreaShell subAreaShell, boolean z16) {
        motionEvent.offsetLocation(DEFAULT_SPACE + ICON_WIDTH, 0.0f);
        return super.onTouchEvent(motionEvent, subAreaShell, z16);
    }

    public void recycle() {
        this.mMainHandler.removeCallbacks(this.countDownRunnable);
    }

    public void setFeedDelTime(long j3) {
        this.mFeedDelTime = j3;
        doCountDownCircle();
    }

    public TimeDelArea() {
        super(13);
        this.color = RichStatus.ACTION_COLOR_PRESSED;
        this.radiu = 10;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.countDownRunnable = new Runnable() { // from class: com.qzone.module.feedcomponent.ui.TimeDelArea.1
            @Override // java.lang.Runnable
            public void run() {
                TimeDelArea.this.measure(-2, 0);
                View attachedView = TimeDelArea.this.getAttachedView();
                if (attachedView != null) {
                    attachedView.invalidate();
                }
                TimeDelArea.this.doCountDownCircle();
            }
        };
        Paint paint = new Paint();
        this.mCriclePaint = paint;
        paint.setAntiAlias(true);
        this.mCriclePaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.mLinePaint = paint2;
        paint2.setAntiAlias(true);
        this.mLinePaint.setStyle(Paint.Style.STROKE);
    }
}
