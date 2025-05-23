package com.qzone.reborn.feedx.widget.picmixvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxSingleVideoWidgetView extends QZoneVideoItemWidgetView {
    public QZoneFeedxSingleVideoWidgetView(Context context) {
        this(context, null);
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.chq;
    }

    public QZoneFeedxSingleVideoWidgetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QZoneFeedxSingleVideoWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.f15538f);
        }
    }
}
