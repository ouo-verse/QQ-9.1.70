package com.tencent.biz.qqcircle.immersive.views.pymk;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;

/* loaded from: classes4.dex */
public class QFSListPYMKTipsView extends QCircleBaseWidgetView {

    /* renamed from: d, reason: collision with root package name */
    private final TextView f91027d;

    public QFSListPYMKTipsView(Context context) {
        super(context);
        this.f91027d = (TextView) findViewById(R.id.f512427k);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(Object obj, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f91027d.getLayoutParams();
        layoutParams.width = cx.g();
        this.f91027d.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gpp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSListPYMKTipsView";
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }
}
