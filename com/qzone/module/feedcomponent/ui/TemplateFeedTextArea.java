package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TemplateFeedTextArea extends FeedTextArea {
    public TemplateFeedTextArea(int i3) {
        super(i3);
        this.textLayout.f50594c1 = 1;
    }

    public void disableFadeAnimation() {
        this.textLayout.f50594c1 = 0;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        return super.draw(canvas, paint);
    }

    public void setAnimationEnabled(boolean z16) {
        this.textLayout.setFadeAnimation(z16);
    }

    public void setAnimationListener(TextCellLayout.l lVar) {
        this.textLayout.L0 = lVar;
    }

    public void setAnimationProgress(int i3) {
        this.textLayout.setFadeAnimationProgress(i3);
    }
}
