package com.tencent.biz.qqcircle.widgets.textview;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleTopHintTextView extends QCircleBaseWidgetView {

    /* renamed from: d, reason: collision with root package name */
    TextView f93910d;

    public QCircleTopHintTextView(@NonNull Context context) {
        super(context);
        this.f93910d = (TextView) findViewById(R.id.f99885r0);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        if (obj != null && (obj instanceof String)) {
            this.f93910d.setText((String) obj);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g69;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleTopHintTextView";
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }
}
