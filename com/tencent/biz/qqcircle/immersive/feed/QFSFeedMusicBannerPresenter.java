package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSFlowAggregationInitBean;
import com.tencent.biz.qqcircle.immersive.events.QFSUnShowFreeFlowViewEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.QCircleMarqueeTextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSFeedMusicBannerPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private View I;
    private QCircleMarqueeTextView J;

    private void h1(final int i3, final int i16, final QCircleExtraTypeInfo qCircleExtraTypeInfo) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedMusicBannerPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed;
                QCircleExtraTypeInfo qCircleExtraTypeInfo2 = qCircleExtraTypeInfo;
                if (qCircleExtraTypeInfo2 != null && (feedCloudMeta$StFeed = qCircleExtraTypeInfo2.mFeed) != null) {
                    QFSFeedMusicBannerPresenter.this.r1(i3, i16, qCircleExtraTypeInfo, "", String.valueOf(feedCloudMeta$StFeed.musicInfo.scene.get()), String.valueOf(qCircleExtraTypeInfo.mFeed.musicInfo.ID.get()));
                }
            }
        });
    }

    private void i1() {
        if (this.I != null) {
            return;
        }
        View inflate = ((ViewStub) this.C.findViewById(R.id.f40771f_)).inflate();
        this.I = inflate;
        inflate.setOnClickListener(this);
        this.J = (QCircleMarqueeTextView) this.I.findViewById(R.id.f40781fa);
    }

    private void j1(View view, String str, Map<String, Object> map) {
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null && view != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(view, str);
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_MUSIC_TYPE, Integer.valueOf(this.E.g().musicInfo.scene.get()));
            if (map != null && map.size() > 0) {
                hashMap.putAll(map);
            }
            VideoReport.setElementReuseIdentifier(view, str + this.E.g().f398449id.get());
            VideoReport.setElementParams(view, hashMap);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
    }

    private int k1() {
        QCircleReportBean reportBean = getReportBean();
        if (reportBean == null) {
            return 0;
        }
        return reportBean.getFromPageId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String l1() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return "null";
        }
        return ((FeedCloudMeta$StFeed) t16).f398449id.get();
    }

    private void m1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        i1();
        View view = this.I;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        this.J.setText(feedCloudMeta$StFeed.musicInfo.musicName.get());
        this.J.setContentDescription(feedCloudMeta$StFeed.musicInfo.musicName.get());
    }

    private void n1() {
        QCircleMarqueeTextView qCircleMarqueeTextView = this.J;
        if (qCircleMarqueeTextView != null) {
            qCircleMarqueeTextView.e();
        }
    }

    private void o1() {
        View view = this.I;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        this.J.setText("");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void p1(View view) {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return;
        }
        if (((FeedCloudMeta$StFeed) t16).musicInfo.status.get() == 1) {
            QCircleToast.u(view.getContext().getString(R.string.f183963kl), 0, true);
            return;
        }
        QFSFlowAggregationInitBean qFSFlowAggregationInitBean = new QFSFlowAggregationInitBean();
        qFSFlowAggregationInitBean.setFeedMusic(((FeedCloudMeta$StFeed) this.f85017h).musicInfo.get());
        qFSFlowAggregationInitBean.setAggregationType(43);
        com.tencent.biz.qqcircle.launcher.c.H(view.getContext(), qFSFlowAggregationInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1(int i3, int i16, QCircleExtraTypeInfo qCircleExtraTypeInfo, String str, String str2, String str3) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (qCircleExtraTypeInfo != null && (feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed) != null) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed));
            dataBuilder.setActionType(i3).setSubActionType(i16).setToUin(qCircleExtraTypeInfo.mFeed.poster.f398463id.get()).setPosition(qCircleExtraTypeInfo.mDataPosition).setPlayScene(qCircleExtraTypeInfo.mPlayScene).setExt1(str).setExt4(str2).setExt5(str3).setPageId(y0()).setfpageid(k1()).setFirstFeedId(w20.a.j().h());
            QCircleLpReportDc05507.report(dataBuilder);
        } else {
            QLog.e("QCircleReportHelper_QFSFeedMusicBannerPresenter", 1, "extraTypeInfo is null or lost feed,actionType:" + i3 + ",subActionType:" + i16);
        }
    }

    private boolean s1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (getReportBean().getFromPageId() != 80000 && !TextUtils.isEmpty(feedCloudMeta$StFeed.musicInfo.musicName.get()) && feedCloudMeta$StFeed.musicInfo.show_mask.get().contains(1)) {
            return true;
        }
        return false;
    }

    private void t1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QLog.d("QFSFeedMusicBannerPresenter", 1, "updateFeedMusicView:isButtonDisplayed = " + feedCloudMeta$StFeed.musicInfo.sameMusicGuideButton.isButtonDisplayed.get() + ", music name = " + com.tencent.biz.qqcircle.immersive.utils.ac.f90062a.a(feedCloudMeta$StFeed.musicInfo.musicName.get()) + ", data = " + l1());
        if (!s1(feedCloudMeta$StFeed)) {
            o1();
            return;
        }
        m1(feedCloudMeta$StFeed);
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_material_type", "music");
        j1(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA_MUSIC_BAR, hashMap);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.aj) {
            n1();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f40771f_) {
            p1(view);
            SimpleEventBus.getInstance().dispatchEvent(new QFSUnShowFreeFlowViewEvent());
            h1(700, 2, r());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        View view;
        super.onFeedSelected(rFWFeedSelectInfo);
        QLog.d("QFSFeedMusicBannerPresenter", 1, "[onFeedSelected] feed id =" + l1());
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i || (view = this.I) == null) {
            return;
        }
        if (view.getVisibility() == 0) {
            h1(700, 1, r());
        }
        QCircleMarqueeTextView qCircleMarqueeTextView = this.J;
        if (qCircleMarqueeTextView != null) {
            qCircleMarqueeTextView.e();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QCircleMarqueeTextView qCircleMarqueeTextView;
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getPosition() == this.f85018i && (qCircleMarqueeTextView = this.J) != null) {
            qCircleMarqueeTextView.f();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSFeedMusicBannerPresenter", 1, "[onBindData] data should not be null.");
        } else {
            t1(feedCloudMeta$StFeed);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedMusicBannerPresenter";
    }
}
