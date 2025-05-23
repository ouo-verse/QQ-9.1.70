package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StImage;
import qqcircle.QQCircleFeedBase$StSchoolPageData;

/* loaded from: classes5.dex */
public class QCircleSchoolPolymerizationHeadView extends QCircleBasePolymerizationHeadView {

    /* renamed from: d, reason: collision with root package name */
    private QQCircleFeedBase$StSchoolPageData f93761d;

    /* renamed from: e, reason: collision with root package name */
    private RFWRoundImageView f93762e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f93763f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f93764h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f93765i;

    public QCircleSchoolPolymerizationHeadView(@NonNull Context context, @NonNull QCirclePolymerizationBean qCirclePolymerizationBean) {
        super(context);
        l0(qCirclePolymerizationBean);
    }

    private void l0(QCirclePolymerizationBean qCirclePolymerizationBean) {
        String str;
        this.f93762e = (RFWRoundImageView) findViewById(R.id.duw);
        TextView textView = (TextView) findViewById(R.id.kbs);
        this.f93763f = textView;
        if (qCirclePolymerizationBean != null) {
            str = qCirclePolymerizationBean.getPolymerizationName();
        } else {
            str = " ";
        }
        textView.setText(str);
        this.f93764h = (TextView) findViewById(R.id.f109826gv);
        this.f93765i = (TextView) findViewById(R.id.f107316a3);
    }

    private void m0() {
        FeedCloudMeta$StImage feedCloudMeta$StImage = this.f93761d.coverInfo;
        if (feedCloudMeta$StImage != null && feedCloudMeta$StImage.picUrl != null) {
            ViewGroup.LayoutParams layoutParams = this.f93762e.getLayoutParams();
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(this.f93761d.coverInfo.picUrl.get()).setRequestHeight(layoutParams.height).setRequestWidth(layoutParams.width).setTargetView(this.f93762e));
        }
    }

    @Override // com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView, com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        if (!(obj instanceof QQCircleFeedBase$StSchoolPageData)) {
            QLog.d("QCircleSchoolPolymerizationHeadView", 1, "objData is not StSchool.");
            return;
        }
        QQCircleFeedBase$StSchoolPageData qQCircleFeedBase$StSchoolPageData = (QQCircleFeedBase$StSchoolPageData) obj;
        this.f93761d = qQCircleFeedBase$StSchoolPageData;
        this.f93763f.setText(qQCircleFeedBase$StSchoolPageData.schoolName.get());
        if (!TextUtils.isEmpty(this.f93761d.pageCopywritingDesc.get())) {
            this.f93765i.setVisibility(0);
            this.f93765i.setText(this.f93761d.pageCopywritingDesc.get());
        } else {
            this.f93765i.setVisibility(8);
        }
        this.f93764h.setText(k0(this.f93761d.subsidiaryFieldDesc.get()));
        m0();
    }

    @Override // com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g5n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleSchoolPolymerizationHeadView";
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }
}
