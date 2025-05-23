package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel;
import com.tencent.biz.qqcircle.widgets.button.QCircleAggregationPublishButtonExp;
import com.tencent.biz.qqcircle.widgets.button.QCirclePolymerizationBottomButton;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudCommon$Entry;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StPublisherButton;

/* compiled from: P */
/* loaded from: classes4.dex */
public class s extends b {

    /* renamed from: d, reason: collision with root package name */
    private QCirclePolymerizationBottomButton f83117d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleAggregationPublishButtonExp f83118e;

    /* renamed from: f, reason: collision with root package name */
    private QCirclePolymerizationViewModel f83119f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Observer<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
            if (uIStateData == null) {
                return;
            }
            int state = uIStateData.getState();
            if ((state != 2 && state != 3) || uIStateData.getData() == null) {
                return;
            }
            s.this.E9(uIStateData.getData().activityPublisherButton);
        }
    }

    private void A9(View view, QQCircleFeedBase$StPublisherButton qQCircleFeedBase$StPublisherButton) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        List<FeedCloudCommon$Entry> list = qQCircleFeedBase$StPublisherButton.extInfo.get();
        FeedCloudCommon$Entry a16 = com.tencent.biz.qqcircle.utils.aj.a(list, "button_id");
        if (a16 == null) {
            QLog.e("QCirclePolymerizationBottomButtonPart", 1, "bindReportData error buttonId is null");
            return;
        }
        com.tencent.biz.qqcircle.utils.aj.d(list, buildElementParams, new String[]{"xsj_operation_activity_id"});
        VideoReport.setElementId(view, a16.value.get());
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void B9(QQCircleFeedBase$StPublisherButton qQCircleFeedBase$StPublisherButton) {
        String str = qQCircleFeedBase$StPublisherButton.jumpUrl.get();
        QLog.d("QCirclePolymerizationBottomButtonPart", 1, "user click mBtnPublish jump to :" + str);
        QCircleSchemeLauncher.f(getContext(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C9(QQCircleFeedBase$StPublisherButton qQCircleFeedBase$StPublisherButton, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        B9(qQCircleFeedBase$StPublisherButton);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D9(QQCircleFeedBase$StPublisherButton qQCircleFeedBase$StPublisherButton, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        B9(qQCircleFeedBase$StPublisherButton);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void initViewModel() {
        if (this.f83119f == null) {
            this.f83119f = (QCirclePolymerizationViewModel) getViewModel(QCirclePolymerizationViewModel.class);
        }
        this.f83119f.P.observe(getHostFragment(), new a());
    }

    public void E9(final QQCircleFeedBase$StPublisherButton qQCircleFeedBase$StPublisherButton) {
        if (this.f83117d == null) {
            return;
        }
        if (o83.c.f422215a.a()) {
            if (qQCircleFeedBase$StPublisherButton.title.has()) {
                this.f83118e.setVisibility(0);
                this.f83118e.setData(qQCircleFeedBase$StPublisherButton);
                A9(this.f83118e, qQCircleFeedBase$StPublisherButton);
                this.f83118e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.bizparts.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        s.this.C9(qQCircleFeedBase$StPublisherButton, view);
                    }
                });
            } else {
                this.f83118e.setVisibility(8);
            }
        } else if (qQCircleFeedBase$StPublisherButton.title.has()) {
            this.f83117d.setVisibility(0);
            this.f83117d.setData(qQCircleFeedBase$StPublisherButton);
            A9(this.f83117d, qQCircleFeedBase$StPublisherButton);
            this.f83117d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.bizparts.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    s.this.D9(qQCircleFeedBase$StPublisherButton, view);
                }
            });
        } else {
            this.f83117d.setVisibility(8);
        }
        if (qQCircleFeedBase$StPublisherButton.title.has()) {
            com.tencent.biz.qqcircle.utils.k.j("exp_qq_shoot_same_video_new_link_new");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCirclePolymerizationBottomButtonPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f83117d = (QCirclePolymerizationBottomButton) view.findViewById(R.id.ypz);
        this.f83118e = (QCircleAggregationPublishButtonExp) view.findViewById(R.id.f166104yq0);
        initViewModel();
    }
}
