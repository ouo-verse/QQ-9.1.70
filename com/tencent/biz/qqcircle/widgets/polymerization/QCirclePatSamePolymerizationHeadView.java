package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import qqcircle.QQCircleFeedBase$StFashionCopyPageData;

/* loaded from: classes5.dex */
public class QCirclePatSamePolymerizationHeadView extends QCircleBasePolymerizationHeadView {

    /* renamed from: d, reason: collision with root package name */
    private TextView f93752d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f93753e;

    /* renamed from: f, reason: collision with root package name */
    private QQCircleFeedBase$StFashionCopyPageData f93754f;

    public QCirclePatSamePolymerizationHeadView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f93752d = (TextView) findViewById(R.id.kbs);
        this.f93753e = (TextView) findViewById(R.id.f109826gv);
    }

    @Override // com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView, com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        if (!(obj instanceof QQCircleFeedBase$StFashionCopyPageData)) {
            return;
        }
        QQCircleFeedBase$StFashionCopyPageData qQCircleFeedBase$StFashionCopyPageData = (QQCircleFeedBase$StFashionCopyPageData) obj;
        this.f93754f = qQCircleFeedBase$StFashionCopyPageData;
        this.f93752d.setText(qQCircleFeedBase$StFashionCopyPageData.pageDesc.get());
        this.f93753e.setText(k0(this.f93754f.subTitleEntry.get()));
    }

    @Override // com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g4u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCirclePatSamePolymerizationHeadView";
    }
}
