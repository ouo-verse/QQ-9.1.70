package com.qzone.component.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BannerAutoVideoCover extends BaseVideoCover {
    public BannerAutoVideoCover(Context context, BaseVideo baseVideo) {
        super(context, baseVideo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void drawCover(Canvas canvas) {
        synchronized (this) {
            Drawable drawable = this.singleDrawable;
            if (drawable != null && canvas != null) {
                if (drawable.getIntrinsicWidth() > this.singleDrawable.getIntrinsicHeight()) {
                    int intrinsicWidth = (this.singleDrawable.getIntrinsicWidth() * getHeight()) / this.singleDrawable.getIntrinsicHeight();
                    this.singleDrawable.setBounds((-(intrinsicWidth - getWidth())) / 2, 0, getWidth() + ((intrinsicWidth - getWidth()) / 2), getHeight());
                } else {
                    int intrinsicHeight = (this.singleDrawable.getIntrinsicHeight() * getWidth()) / this.singleDrawable.getIntrinsicWidth();
                    this.singleDrawable.setBounds(0, (-(intrinsicHeight - getHeight())) / 2, getWidth(), getHeight() + ((intrinsicHeight - getHeight()) / 2));
                }
                this.singleDrawable.draw(canvas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void drawPlayIcon(Canvas canvas) {
        QZLog.i("BannerAutoVideoCover", "drawPlayIcon override don't draw playIcon");
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover, android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(View.getDefaultSize(getMaxWidth(), i3), View.getDefaultSize(getMaxWidth(), i16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void reCaculateSize(int i3, int i16) {
        int maxWidth = getMaxWidth();
        this.picWidth = maxWidth;
        this.picHeight = maxWidth;
        this.mCoverWidth = maxWidth;
        this.mCoverHeight = maxWidth;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void setCoverWarnType(Canvas canvas, BaseVideoCover.CoverWarnType coverWarnType) {
        QZLog.i("BannerAutoVideoCover", "setCoverWarnType override don't show warning");
    }
}
