package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.events.QFSAdBannerChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.manager.QFSTopViewManager;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSAdFollowView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.util.GdtAntiSpamReportHelper;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ag extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener, Observer<e30.b>, QFSFollowView.c {
    private View I;
    private QCircleAvatarView J;
    private QFSAdFollowView K;
    private GdtAd L;
    private Size M;
    private e30.b N;
    private final GdtAntiSpamReportHelper P = new GdtAntiSpamReportHelper();

    private void g1(QFSAdBannerChangeEvent qFSAdBannerChangeEvent) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADCARD_THREE_STAGE, qFSAdBannerChangeEvent.getState());
        VideoReport.setElementParams(this.J, buildElementParams);
    }

    private void h1(View view) {
        QFSAdFollowView qFSAdFollowView = (QFSAdFollowView) view.findViewById(R.id.v9o);
        this.K = qFSAdFollowView;
        qFSAdFollowView.setContentDescription("\u70b9\u51fb\u5173\u6ce8");
        this.K.setFollowStateChangeListener(this);
        this.K.setOnClickListener(this);
    }

    private void k1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        QCircleAvatarView qCircleAvatarView = this.J;
        if (qCircleAvatarView == null) {
            QLog.d("QFSFeedChildAdAvatarPresenter", 1, "[updateAuthorAvatarView] author avatar view not be null.");
            return;
        }
        if (feedCloudMeta$StFeed == null) {
            feedCloudMeta$StUser = null;
        } else {
            feedCloudMeta$StUser = feedCloudMeta$StFeed.poster;
        }
        if (feedCloudMeta$StUser == null) {
            QLog.d("QFSFeedChildAdAvatarPresenter", 1, "[updateAuthorAvatarView] user info should not be null.");
        } else {
            qCircleAvatarView.setUser(feedCloudMeta$StUser, this.M);
            f0(this.J, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_PROFILE_PHOTO);
        }
    }

    private void l1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.K == null) {
            QLog.d("QFSFeedChildAdAvatarPresenter", 1, "[updateAuthorFollowView] author attention view not be null.");
            return;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StFeed.poster.get();
        if (TextUtils.isEmpty(feedCloudMeta$StUser.f398463id.get())) {
            feedCloudMeta$StUser.f398463id.set(String.valueOf(Integer.MIN_VALUE));
        }
        this.K.setUserData(feedCloudMeta$StUser, feedCloudMeta$StFeed);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        View findViewById = view.findViewById(R.id.f40491ei);
        this.I = findViewById;
        QCircleAvatarView qCircleAvatarView = (QCircleAvatarView) ((ViewStub) findViewById.findViewById(R.id.f33250vy)).inflate().findViewById(R.id.v9i);
        this.J = qCircleAvatarView;
        qCircleAvatarView.setOnClickListener(this);
        this.P.listenOnTouchEvent(this.J);
        this.J.setContentDescription("\u4f5c\u8005\u5934\u50cf");
        h1(this.I);
        this.M = com.tencent.biz.qqcircle.immersive.utils.n.a(view.getContext(), R.dimen.f159407d32);
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.c
    public void O(boolean z16, FeedCloudMeta$StUser feedCloudMeta$StUser) {
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.v(z16, feedCloudMeta$StUser));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSAdBannerChangeEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        try {
            if (feedCloudMeta$StFeed == null) {
                QLog.d("QFSFeedChildAdAvatarPresenter", 1, "[onBindData] data should not be null.");
                return;
            }
            U0(ae.b(this.E.g(), i3));
            FeedCloudMeta$StFeed c16 = u.c(this.E);
            this.L = new GdtAd(u.e(this.E));
            l1(feedCloudMeta$StFeed);
            k1(c16);
            this.N = new e30.b(feedCloudMeta$StFeed);
            w20.a.j().observerGlobalState(this.N, this);
        } catch (Throwable th5) {
            QLog.d("QFSFeedChildAdAvatarPresenter", 1, "[onBindData] failed, error is " + th5);
        }
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        if (bVar == null) {
            return;
        }
        l1(bVar.g());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        GdtAd gdtAd = this.L;
        if (gdtAd != null && gdtAd.isValid() && !QFSTopViewManager.h(this.L.info)) {
            i3 = 2;
        } else {
            i3 = Integer.MIN_VALUE;
        }
        com.tencent.biz.qqcircle.immersive.utils.j.f90213a.J(this.L, view, this.f85018i, r(), i3, this.P.getAdAntiSpamForClickParams(this.C));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        this.P.onDestroy();
        super.onDestroy();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        this.P.setExpoTime();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        this.P.resetExpoTime();
        super.onFeedUnSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSAdBannerChangeEvent) {
            g1((QFSAdBannerChangeEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdAvatarPresenter";
    }
}
