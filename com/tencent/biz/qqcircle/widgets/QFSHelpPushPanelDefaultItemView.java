package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSHelpPushPanelItemInfo;

/* loaded from: classes5.dex */
public class QFSHelpPushPanelDefaultItemView extends QCircleBaseWidgetView<QFSHelpPushPanelItemInfo> {
    public QFSHelpPushPanelDefaultItemView(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSHelpPushPanelDefaultItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSHelpPushPanelItemInfo qFSHelpPushPanelItemInfo, int i3) {
    }
}
