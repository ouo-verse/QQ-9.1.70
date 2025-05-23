package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSDefaultItemView<T> extends QCircleBaseWidgetView<T> {
    public QFSDefaultItemView(@NonNull Context context) {
        this(context, 0);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSDefaultItemView";
    }

    public QFSDefaultItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(T t16, int i3) {
    }
}
