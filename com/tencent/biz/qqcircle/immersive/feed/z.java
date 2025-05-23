package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class z extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private TextView I;

    private void h1(String str) {
        VideoReport.setElementId(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_REMINDER_BANNER);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REMINDER_CONTENT, str);
        VideoReport.setElementParams(this.I, buildElementParams);
    }

    private void i1(String str) {
        if (this.I == null) {
            ViewStub viewStub = (ViewStub) this.C.findViewById(R.id.f57542nl);
            if (viewStub == null) {
                QLog.d("QFSFeedChildDescWarningPresenter", 1, "viewStub == null, return");
                return;
            }
            this.I = (TextView) viewStub.inflate();
        }
        this.I.setText(str);
        this.I.setVisibility(0);
        h1(str);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        String str = feedCloudMeta$StFeed.contentLabel.get();
        if (TextUtils.isEmpty(str)) {
            TextView textView = this.I;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        i1(str);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildDescWarningPresenter";
    }
}
