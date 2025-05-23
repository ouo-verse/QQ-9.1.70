package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StImage;
import qqcircle.QQCircleFeedBase$StGpsPageData;

/* loaded from: classes5.dex */
public class QCircleLbsPolymerizationHeadView extends QCircleBasePolymerizationHeadView {

    /* renamed from: d, reason: collision with root package name */
    private SquareImageView f93748d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f93749e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f93750f;

    /* renamed from: h, reason: collision with root package name */
    private QQCircleFeedBase$StGpsPageData f93751h;

    public QCircleLbsPolymerizationHeadView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f93748d = (SquareImageView) findViewById(R.id.duw);
        this.f93749e = (TextView) findViewById(R.id.kbs);
        this.f93750f = (TextView) findViewById(R.id.f109826gv);
    }

    private void l0() {
        FeedCloudMeta$StImage feedCloudMeta$StImage = this.f93751h.coverInfo;
        if (feedCloudMeta$StImage != null && feedCloudMeta$StImage.picUrl != null) {
            Option targetView = Option.obtain().setUrl(this.f93751h.coverInfo.picUrl.get()).setFailDrawable(getContext().getResources().getDrawable(R.drawable.ono)).setLoadingDrawable(getContext().getResources().getDrawable(R.drawable.ono)).setTargetView(this.f93748d);
            QCircleFeedPicLoader.setViewWidthHeight(targetView, this.f93748d);
            QCircleFeedPicLoader.g().loadImage(targetView);
        }
    }

    @Override // com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView, com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        if (!(obj instanceof QQCircleFeedBase$StGpsPageData)) {
            return;
        }
        QQCircleFeedBase$StGpsPageData qQCircleFeedBase$StGpsPageData = (QQCircleFeedBase$StGpsPageData) obj;
        this.f93751h = qQCircleFeedBase$StGpsPageData;
        this.f93749e.setText(qQCircleFeedBase$StGpsPageData.poiName.get());
        this.f93750f.setText(k0(this.f93751h.subsidiaryFieldDesc.get()));
        l0();
    }

    @Override // com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g3u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleLbsPolymerizationHeadView";
    }
}
