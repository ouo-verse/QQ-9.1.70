package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanHideVideoCover extends BaseVideoCover {
    boolean hideCover;

    public CanHideVideoCover(Context context, BaseVideo baseVideo) {
        super(context, baseVideo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover
    public void drawPlayIcon(Canvas canvas) {
        if (this.hideCover) {
            return;
        }
        super.drawPlayIcon(canvas);
    }

    public void setCoverHide(boolean z16) {
        this.hideCover = z16;
    }

    public CanHideVideoCover(Context context, AttributeSet attributeSet, BaseVideo baseVideo) {
        super(context, attributeSet, baseVideo);
    }

    public CanHideVideoCover(Context context, AttributeSet attributeSet, int i3, BaseVideo baseVideo) {
        super(context, attributeSet, i3, baseVideo);
        this.playIcon = FeedVideoEnv.playerResources.getDrawable(1094);
    }
}
