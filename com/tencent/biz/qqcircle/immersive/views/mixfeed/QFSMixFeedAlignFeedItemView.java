package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedAlignFeedItemView extends QFSMixFeedAlignBaseItemView {
    private FrameLayout I;
    private ImageView J;
    private LinearLayout K;
    private TextView L;
    private QFSMixFeedTagView M;

    public QFSMixFeedAlignFeedItemView(@NonNull Context context) {
        super(context);
    }

    private void B0(e30.b bVar) {
        FeedCloudMeta$StFeed g16 = bVar.g();
        if (!g16.poiInfo.has()) {
            QLog.d("QFSMixFeedAlignFeedItemView", 1, "[initPoiUI] the feed does not have the location poiInfo.");
            return;
        }
        String str = g16.poiInfo.distanceText.get();
        if (TextUtils.isEmpty(str)) {
            this.K.setVisibility(8);
            QLog.d("QFSMixFeedAlignFeedItemView", 1, "[initPoiUI] poiInfo.distanceText is null.");
        } else {
            this.K.setVisibility(0);
            this.L.setText(str);
        }
    }

    private boolean C0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.D;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StFeed.liteBanner.business_type.get() == 7 || this.D.liteBanner.business_type.get() == 8 || this.D.liteBanner.business_type.get() == 6)) {
            return true;
        }
        return false;
    }

    private void D0() {
        FrameLayout frameLayout;
        if (this.D != null && (frameLayout = this.I) != null && this.M != null) {
            frameLayout.setVisibility(8);
            if (!C0()) {
                this.M.setVisibility(8);
            } else {
                this.M.b(this.D);
            }
        }
    }

    private void E0() {
        if (this.D != null && getData() != null) {
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = (QQCircleFeedBase$StFeedBusiReqData) getData().b("DITTO_FEED_BUSI_REQ_DATA");
            FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(this.D.f398449id.get());
            if (f16 != null && qQCircleFeedBase$StFeedBusiReqData != null) {
                qQCircleFeedBase$StFeedBusiReqData.pushList.set(f16);
                this.D.busiData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedBusiReqData.toByteArray()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedAlignBaseItemView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMixFeedAlignFeedItemView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedAlignBaseItemView
    protected Map<String, Object> n0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QFSMixFeedTagView qFSMixFeedTagView;
        if (C0() && (feedCloudMeta$StFeed = this.D) != null && (qFSMixFeedTagView = this.M) != null) {
            return qFSMixFeedTagView.a(feedCloudMeta$StFeed);
        }
        return null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedAlignBaseItemView
    protected void q0(View view) {
        if (view == null) {
            return;
        }
        this.I = (FrameLayout) view.findViewById(R.id.v88);
        this.M = (QFSMixFeedTagView) view.findViewById(R.id.f47301wx);
        this.J = (ImageView) view.findViewById(R.id.y6u);
        this.K = (LinearLayout) view.findViewById(R.id.f46551uw);
        this.L = (TextView) view.findViewById(R.id.f46541uv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedAlignBaseItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(e30.b bVar, int i3) {
        super.bindData(bVar, i3);
        B0(bVar);
        E0();
        D0();
        this.J.setVisibility(s0() ? 0 : 8);
    }
}
