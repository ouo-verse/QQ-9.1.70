package com.tencent.mobileqq.qzoneplayer.cover.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.oskplayer.util.PlayerUtils;

/* compiled from: P */
/* loaded from: classes35.dex */
public class LoadingView extends View {
    Handler C;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f279333d;

    /* renamed from: e, reason: collision with root package name */
    protected int f279334e;

    /* renamed from: f, reason: collision with root package name */
    protected int f279335f;

    /* renamed from: h, reason: collision with root package name */
    protected int f279336h;

    /* renamed from: i, reason: collision with root package name */
    protected Rect f279337i;

    /* renamed from: m, reason: collision with root package name */
    protected Rect f279338m;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            LoadingView.this.invalidate();
            LoadingView.this.f279333d = false;
        }
    }

    public LoadingView(Context context) {
        this(context, null);
    }

    private void b() {
        if (this.f279336h == -1) {
            Bitmap bitmap = FeedVideoEnv.bitmapDst;
            if (bitmap != null) {
                this.f279336h = bitmap.getHeight();
            } else {
                this.f279336h = 0;
            }
        }
        if (this.f279335f == -1) {
            Bitmap bitmap2 = FeedVideoEnv.bitmapDst;
            if (bitmap2 != null) {
                this.f279335f = bitmap2.getWidth();
            } else {
                this.f279335f = 0;
            }
        }
    }

    protected void a(Canvas canvas) {
        b();
        if (FeedVideoEnv.bitmapDst != null && FeedVideoEnv.bitmapSrc != null) {
            canvas.drawBitmap(FeedVideoEnv.bitmapDst, getPaddingLeft(), getPaddingTop(), FeedVideoEnv.sPaint);
            this.f279337i.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + this.f279334e, getPaddingTop() + this.f279336h);
            this.f279338m.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + this.f279334e, getPaddingTop() + this.f279336h);
            canvas.drawBitmap(FeedVideoEnv.bitmapSrc, this.f279337i, this.f279338m, FeedVideoEnv.sPaint);
            return;
        }
        PlayerUtils.log(5, "LoadingView", "drawLoadingIcon: bitmap is null!!!");
    }

    public void c() {
        this.C.sendEmptyMessage(1);
    }

    public void d() {
        this.C.removeMessages(1);
        this.f279333d = true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.f279333d) {
            this.f279334e += 9;
        }
        int i3 = this.f279334e;
        if (i3 > this.f279335f) {
            i3 = 0;
        }
        this.f279334e = i3;
        a(canvas);
        if (this.f279333d) {
            return;
        }
        this.f279333d = true;
        this.C.removeMessages(1);
        this.C.sendEmptyMessageDelayed(1, 250L);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && View.MeasureSpec.getMode(i16) == Integer.MIN_VALUE) {
            setMeasuredDimension(FeedVideoEnv.bitmapDst.getWidth() + getPaddingLeft() + getPaddingRight(), FeedVideoEnv.bitmapDst.getHeight() + getPaddingTop() + getPaddingBottom());
            return;
        }
        if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE) {
            setMeasuredDimension(FeedVideoEnv.bitmapDst.getWidth() + getPaddingLeft() + getPaddingRight(), View.MeasureSpec.getSize(i16));
        } else if (View.MeasureSpec.getMode(i16) == Integer.MIN_VALUE) {
            setMeasuredDimension(View.MeasureSpec.getSize(i3), FeedVideoEnv.bitmapDst.getHeight() + getPaddingTop() + getPaddingBottom());
        } else {
            super.onMeasure(i3, i16);
        }
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f279335f = -1;
        this.f279336h = -1;
        this.f279337i = new Rect();
        this.f279338m = new Rect();
        this.C = new a(Looper.getMainLooper());
    }
}
