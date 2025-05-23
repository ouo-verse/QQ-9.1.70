package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.util.AttributeSet;

/* compiled from: P */
/* loaded from: classes35.dex */
public class FullScreenFeedAutoVideoFull extends FeedAutoVideoFull {
    public FullScreenFeedAutoVideoFull(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull
    protected boolean B() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public boolean isAllOnScreen() {
        return true;
    }

    public FullScreenFeedAutoVideoFull(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FullScreenFeedAutoVideoFull(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
