package com.tencent.biz.qqcircle.immersive.feed;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.winkpublish.model.params.FeedParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.Map;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemInfo;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ay extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private FrameLayout I;
    private TextView J;
    private QQCircleDitto$StItemInfo K;
    private FeedCloudMeta$StFeed L;

    private void g1(Map<String, Object> map, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && map != null) {
            QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
            try {
                qQCircleFeedBase$StReportInfoForClient.mergeFrom(feedCloudMeta$StFeed.reportInfoForClient.get().toByteArray());
                if (!TextUtils.isEmpty(qQCircleFeedBase$StReportInfoForClient.datongJsonData.get())) {
                    map.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleFeedBase$StReportInfoForClient.datongJsonData.get());
                }
            } catch (InvalidProtocolBufferMicroException unused) {
                QLog.w("QFSFeedChildPublishControlPresenter", 1, "dtPutTransferInfo, transferInfo error");
            }
        }
    }

    private void h1() {
        if (this.L == null) {
            QLog.e("QFSFeedChildPublishControlPresenter", 1, "handleOnClickDynamicButton  mFeed == null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_publish_use_hd_upload", true);
        bundle.putString("publish_source_type", "layer_publish_template");
        HashMap hashMap = new HashMap();
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : this.L.extInfo.get()) {
            hashMap.put(feedCloudCommon$Entry.key.get(), feedCloudCommon$Entry.value.get());
        }
        FeedParams feedParams = new FeedParams("", this.L.content.get(), false, true, false, this.L.feedExtraInfo.publisherSchema.get(), "", "", true, null, null, null, null, null, null, null, 0, null, hashMap, new HashMap(), false, "", null, "", null, null, null);
        ja0.a aVar = ja0.a.f409680a;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.L;
        aVar.e(feedCloudMeta$StFeed.video, feedCloudMeta$StFeed.cover, feedParams, bundle);
    }

    private void j1() {
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.K;
        if (qQCircleDitto$StItemInfo == null) {
            return;
        }
        this.J.setText(qQCircleDitto$StItemInfo.buttonInfo.name.get());
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.putAll(ua0.c.e(this.L));
        g1(buildElementParams, this.L);
        VideoReport.setElementId(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_ONE_CLCK_PUBLISH_BUTTON);
        VideoReport.setElementParams(this.I, buildElementParams);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = (FrameLayout) view.findViewById(R.id.f40221ds);
        this.J = (TextView) view.findViewById(R.id.f40231dt);
        this.I.setOnClickListener(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSFeedChildPublishControlPresenter", 1, "onBindData  data == null");
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = (QQCircleDitto$StCircleDittoDataNew) this.E.b("DITTO_FEED_PUBLISH_TEMPLATE");
        if (qQCircleDitto$StCircleDittoDataNew != null && qQCircleDitto$StCircleDittoDataNew.itemContainter.get() != null && qQCircleDitto$StCircleDittoDataNew.itemContainter.items.size() > 0 && qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get(0).feeds.size() > 0) {
            this.K = qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get(0);
            this.L = qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get(0).feeds.get(0);
            j1();
            return;
        }
        QLog.e("QFSFeedChildPublishControlPresenter", 1, "onBindData  dittoData error");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f40221ds) {
            h1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildPublishControlPresenter";
    }
}
