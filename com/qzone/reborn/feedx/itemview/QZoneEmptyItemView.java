package com.qzone.reborn.feedx.itemview;

import android.content.Context;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneEmptyItemView extends QZoneBaseFeedItemView {
    public QZoneEmptyItemView(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected String getLogTag() {
        return "QZoneEmptyItemView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends vg.a>> s0() {
        return null;
    }
}
