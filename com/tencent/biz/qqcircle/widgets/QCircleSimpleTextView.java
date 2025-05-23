package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleSimpleTextView extends QCircleBaseWidgetView {

    /* renamed from: d, reason: collision with root package name */
    TextView f93150d;

    public QCircleSimpleTextView(@NonNull Context context) {
        super(context);
        this.f93150d = (TextView) findViewById(R.id.jfb);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        if (obj != null && (obj instanceof String)) {
            this.f93150d.setText((String) obj);
        } else {
            this.f93150d.setText(R.string.f183693jv);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g5u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleSimpleTextView";
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }
}
