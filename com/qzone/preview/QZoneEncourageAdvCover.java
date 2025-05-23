package com.qzone.preview;

import android.content.Context;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneEncourageAdvCover extends BaseVideoCover {
    public QZoneEncourageAdvCover(Context context, BaseVideo baseVideo) {
        super(context, baseVideo);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover, android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(i3, i16);
    }
}
