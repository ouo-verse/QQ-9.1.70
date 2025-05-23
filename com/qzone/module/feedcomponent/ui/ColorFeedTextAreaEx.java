package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ColorFeedTextAreaEx extends FeedTextAreaEx {
    public ColorFeedTextAreaEx(int i3) {
        super(i3);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextAreaEx, com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        this.textLayout.setMeasuredLineLinkColor(this.textColorLink);
        return super.draw(canvas, paint);
    }
}
