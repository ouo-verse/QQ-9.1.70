package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

/* loaded from: classes35.dex */
public class WindowPlayVideoCover extends BaseVideoCover {

    /* renamed from: d, reason: collision with root package name */
    public boolean f279951d;

    public WindowPlayVideoCover(Context context, BaseVideo baseVideo) {
        super(context, baseVideo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void drawPlayIcon(Canvas canvas) {
        if (this.f279951d) {
            return;
        }
        super.drawPlayIcon(canvas);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    protected int getCornerRadius() {
        return FeedVideoEnv.f279795dp3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public int getMaxWidth() {
        int i3 = this.mMaxWidth;
        return i3 <= 0 ? FeedVideoEnv.SCREEN_WIDTH / 2 : i3;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    protected boolean needRoundCorner() {
        return true;
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
}
