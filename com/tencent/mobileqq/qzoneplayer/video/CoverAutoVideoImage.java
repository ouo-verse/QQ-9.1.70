package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.oskplayer.util.PlayerUtils;

/* compiled from: P */
/* loaded from: classes35.dex */
public class CoverAutoVideoImage extends BaseVideoCover {
    public CoverAutoVideoImage(Context context, BaseVideo baseVideo) {
        super(context, baseVideo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void drawPlayIcon(Canvas canvas) {
        Drawable drawable = this.playIcon;
        if (drawable == null) {
            PlayerUtils.log(5, BaseVideoCover.LOG_TAG, "Error! play icon is null");
            return;
        }
        int i3 = this.mCoverWidth;
        int i16 = (i3 - FeedVideoEnv.READY_ICON_WIDTH) / 2;
        int i17 = this.mCoverHeight;
        drawable.setBounds(i16, (i17 - FeedVideoEnv.READY_ICON_HEIGHT) / 2, (i3 + FeedVideoEnv.READY_ICON_WIDTH) / 2, (i17 + FeedVideoEnv.READY_ICON_HEIGHT) / 2);
        this.playIcon.draw(canvas);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover, android.view.View
    protected void onMeasure(int i3, int i16) {
        this.mCoverWidth = ViewUtils.getScreenWidth();
        int finalCoverHeight = CoverEnv.getFinalCoverHeight();
        this.mCoverHeight = finalCoverHeight;
        setMeasuredDimension(this.mCoverWidth, finalCoverHeight);
    }
}
