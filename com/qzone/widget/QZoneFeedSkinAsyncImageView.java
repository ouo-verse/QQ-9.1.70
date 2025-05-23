package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedSkinAsyncImageView extends com.tencent.component.media.image.view.AsyncImageView {
    public QZoneFeedSkinAsyncImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeUtil.setColorFilterIfNeed(this, com.qzone.adapter.feedcomponent.i.H().p1());
    }

    public QZoneFeedSkinAsyncImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QZoneFeedSkinAsyncImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
