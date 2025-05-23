package com.tencent.biz.qqcircle.widgets.feed;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import e30.b;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleDefaultFeedItemView extends QCircleBaseWidgetView<b> {
    private static final String TAG = "QCircleDefaultFeedItemView";

    public QCircleDefaultFeedItemView(@NonNull Context context) {
        this(context, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(b bVar, int i3) {
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return TAG;
    }

    public QCircleDefaultFeedItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }
}
