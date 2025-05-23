package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSMessageBoxHistoryDividerView extends QCircleBaseWidgetView<f30.b> {
    public QFSMessageBoxHistoryDividerView(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gjg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMessageBoxHistoryDividerView";
    }

    public QFSMessageBoxHistoryDividerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(f30.b bVar, int i3) {
    }
}
