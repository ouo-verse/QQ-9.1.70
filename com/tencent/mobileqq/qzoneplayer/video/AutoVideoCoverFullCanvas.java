package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes35.dex */
public class AutoVideoCoverFullCanvas extends BaseVideoCover {

    /* renamed from: d, reason: collision with root package name */
    private long f279561d;

    /* renamed from: e, reason: collision with root package name */
    private String f279562e;

    public AutoVideoCoverFullCanvas(Context context, BaseVideo baseVideo) {
        super(context, baseVideo);
        this.f279561d = 0L;
        this.f279562e = null;
        this.playIcon = FeedVideoEnv.playerResources.getDrawable(1107);
    }

    public void a() {
        ViewGroup.LayoutParams layoutParams = this.mParent.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
        }
        if (layoutParams != null) {
            layoutParams2.width = layoutParams.width;
            layoutParams2.height = layoutParams.height;
        }
        setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void drawPlayIcon(Canvas canvas) {
        int i3 = FeedVideoEnv.dp60;
        Drawable drawable = this.playIcon;
        int i16 = this.mCoverWidth;
        int i17 = this.mCoverHeight;
        drawable.setBounds((i16 - i3) / 2, (i17 - i3) / 2, (i16 + i3) / 2, (i17 + i3) / 2);
        this.playIcon.draw(canvas);
        if (this.f279562e != null) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#FFFFFF"));
            paint.setTextSize(getResources().getDisplayMetrics().scaledDensity * 9.0f);
            Rect rect = new Rect();
            String str = this.f279562e;
            paint.getTextBounds(str, 0, str.length(), rect);
            canvas.drawText(this.f279562e, ((this.mCoverWidth / 2) - (rect.width() / 2)) - TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), (((this.mCoverHeight + i3) / 2) - TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics())) - TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), paint);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover, android.view.View
    protected void onMeasure(int i3, int i16) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.width == -2 && layoutParams.height == -2) {
            int i17 = this.picWidth;
            this.mCoverWidth = i17;
            int i18 = this.picHeight;
            this.mCoverHeight = i18;
            setMeasuredDimension(i17, i18);
            return;
        }
        this.mCoverWidth = View.getDefaultSize(this.picWidth, i3);
        this.mCoverHeight = View.getDefaultSize(this.picHeight, i16);
        setMeasuredDimension(View.getDefaultSize(this.picWidth, i3), View.getDefaultSize(this.picHeight, i16));
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void reCaculateSize(int i3, int i16) {
        int maxWidth = getMaxWidth();
        this.picWidth = maxWidth;
        this.picHeight = (int) ((maxWidth / i3) * i16);
    }

    public void setVideoTotalTraffic(long j3) {
        this.f279561d = j3;
        this.f279562e = String.format("%.2fM", Float.valueOf(((float) j3) / 1024.0f));
    }
}
