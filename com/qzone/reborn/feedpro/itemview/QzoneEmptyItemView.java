package com.qzone.reborn.feedpro.itemview;

import android.content.Context;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QzoneEmptyItemView extends QzoneBaseFeedProItemView {
    public QzoneEmptyItemView(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView
    protected String getLogTag() {
        return "QzoneEmptyItemView";
    }

    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView
    protected List<Class<? extends ne.a>> r0() {
        return Collections.emptyList();
    }
}
