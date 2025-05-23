package com.qzone.reborn.feedx.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneLoadMoreUpView extends QZoneBaseWidgetView<BusinessFeedData> {

    /* renamed from: e, reason: collision with root package name */
    private ProgressBar f55947e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f55948f;

    public QZoneLoadMoreUpView(Context context) {
        super(context);
        o0();
    }

    private void o0() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.n6p);
        this.f55947e = progressBar;
        progressBar.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.n6q);
        this.f55948f = textView;
        textView.setText(R.string.wbx);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cfu;
    }

    public void n0() {
        this.f55947e.setVisibility(8);
        this.f55948f.setText(R.string.wbx);
    }

    public void p0() {
        this.f55947e.setVisibility(0);
        this.f55948f.setText(R.string.f221456av);
    }

    public QZoneLoadMoreUpView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        o0();
    }

    public QZoneLoadMoreUpView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        o0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(BusinessFeedData businessFeedData, int i3) {
    }
}
