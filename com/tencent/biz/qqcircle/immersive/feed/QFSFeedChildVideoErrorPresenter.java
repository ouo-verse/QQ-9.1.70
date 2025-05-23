package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedVideoErrorEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSPlayerErrorView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.JsonBinder;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class QFSFeedChildVideoErrorPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private ViewStub I;
    private QFSPlayerErrorView J;
    private boolean K = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class PlayerErrorViewReportAttachBean implements Serializable {
        private long mDownGrade;
        private int mErrorCode;
        private boolean mIsNetworkAvailable;
        private int mNetworkType;
        private String mTraceId;
        private String mVideoId;

        PlayerErrorViewReportAttachBean() {
        }

        public long getDownGrade() {
            return this.mDownGrade;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public int getNetworkType() {
            return this.mNetworkType;
        }

        public String getTraceId() {
            return this.mTraceId;
        }

        public String getVideoId() {
            return this.mVideoId;
        }

        public boolean isNetworkAvailable() {
            return this.mIsNetworkAvailable;
        }

        public void setDownGrade(long j3) {
            this.mDownGrade = j3;
        }

        public void setErrorCode(int i3) {
            this.mErrorCode = i3;
        }

        public void setNetworkAvailable(boolean z16) {
            this.mIsNetworkAvailable = z16;
        }

        public void setNetworkType(int i3) {
            this.mNetworkType = i3;
        }

        public void setTraceId(String str) {
            this.mTraceId = str;
        }

        public void setVideoId(String str) {
            this.mVideoId = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements QFSPlayerErrorView.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RFWPlayerOptions f85201a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f85202b;

        a(RFWPlayerOptions rFWPlayerOptions, int i3) {
            this.f85201a = rFWPlayerOptions;
            this.f85202b = i3;
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.QFSPlayerErrorView.a
        public void a() {
            QFSFeedChildVideoErrorPresenter.this.i1(this.f85201a, this.f85202b);
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.QFSPlayerErrorView.a
        public void b() {
            QFSFeedChildVideoErrorPresenter.this.j1(this.f85201a, this.f85202b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(RFWPlayerOptions rFWPlayerOptions, int i3) {
        n1("video_error_view_feedback", rFWPlayerOptions, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(RFWPlayerOptions rFWPlayerOptions, int i3) {
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.t(true));
        n1("video_error_view_replay", rFWPlayerOptions, i3);
    }

    private void k1(@NonNull com.tencent.biz.qqcircle.immersive.feed.event.ae aeVar) {
        this.K = aeVar.a();
        QLog.d("PEV-QFSFeedChildVideoErrorPresenter", 1, "[handlerScreenConfigChangeEvent] mIsVertical: " + this.K);
        QFSPlayerErrorView qFSPlayerErrorView = this.J;
        if (qFSPlayerErrorView != null) {
            qFSPlayerErrorView.G(this.K);
        }
    }

    private void l1(RFWPlayerOptions rFWPlayerOptions, int i3, int i16, int i17, String str) {
        if (this.I == null) {
            QLog.e("PEV-QFSFeedChildVideoErrorPresenter", 1, "[notifyPlayerErrorDisplay] current player error view stub should not be null.");
            return;
        }
        boolean E0 = E0();
        QLog.d("PEV-QFSFeedChildVideoErrorPresenter", 1, "[notifyPlayerErrorDisplay] module: " + i3 + " | errorType: " + i16 + " | errorCode: " + i17 + " | extraInfo: " + str + " | isFeedOnScreen: " + E0 + " | mIsVertical: " + this.K);
        if (this.K && !E0) {
            return;
        }
        if (this.J == null) {
            QFSPlayerErrorView qFSPlayerErrorView = (QFSPlayerErrorView) this.I.inflate();
            this.J = qFSPlayerErrorView;
            qFSPlayerErrorView.G(this.K);
        }
        QFSPlayerErrorView qFSPlayerErrorView2 = this.J;
        if (qFSPlayerErrorView2 == null) {
            QLog.e("PEV-QFSFeedChildVideoErrorPresenter", 1, "[notifyPlayerErrorDisplay] player error view should not be null.");
        } else {
            qFSPlayerErrorView2.i(rFWPlayerOptions, i3, i16, i17, str);
            this.J.setOnPlayerErrorReplayListener(new a(rFWPlayerOptions, i17));
        }
    }

    private void m1(long j3, long j16) {
        QFSPlayerErrorView qFSPlayerErrorView = this.J;
        if (qFSPlayerErrorView == null) {
            return;
        }
        qFSPlayerErrorView.j(j3, j16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void n1(String str, RFWPlayerOptions rFWPlayerOptions, int i3) {
        String str2;
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        if (rFWPlayerOptions == null) {
            QLog.e("PEV-QFSFeedChildVideoErrorPresenter", 1, "[reportErrorViewClick] options should not be null.");
            return;
        }
        if (this.E == null) {
            QLog.e("PEV-QFSFeedChildVideoErrorPresenter", 1, "[reportErrorViewClick] feed block data should not be null.");
            return;
        }
        String realPlayUrl = rFWPlayerOptions.getRealPlayUrl();
        T t16 = this.f85017h;
        String str3 = "";
        if (t16 == 0) {
            str2 = "";
        } else {
            str2 = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        }
        T t17 = this.f85017h;
        if (t17 == 0) {
            feedCloudMeta$StVideo = null;
        } else {
            feedCloudMeta$StVideo = ((FeedCloudMeta$StFeed) t17).video.get();
        }
        if (feedCloudMeta$StVideo != null) {
            str3 = feedCloudMeta$StVideo.fileId.get();
        }
        PlayerErrorViewReportAttachBean playerErrorViewReportAttachBean = new PlayerErrorViewReportAttachBean();
        playerErrorViewReportAttachBean.setVideoId(str3);
        playerErrorViewReportAttachBean.setErrorCode(i3);
        playerErrorViewReportAttachBean.setTraceId(com.tencent.biz.qqcircle.immersive.utils.ba.d((FeedCloudMeta$StFeed) this.f85017h));
        try {
            playerErrorViewReportAttachBean.setNetworkAvailable(HostNetworkUtils.isNetworkAvailable());
            playerErrorViewReportAttachBean.setNetworkType(NetworkUtil.getNetworkType(RFWApplication.getApplication()));
            playerErrorViewReportAttachBean.setDownGrade(RFWVideoUtils.getPredictSpeedWithOutDownGrade(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()));
        } catch (Throwable th5) {
            QLog.d("PEV-QFSFeedChildVideoErrorPresenter", 1, "[reportError] error: ", th5);
        }
        String json = JsonBinder.getInstance().toJson(playerErrorViewReportAttachBean);
        ArrayList arrayList = new ArrayList();
        arrayList.add(QCircleReportHelper.newEntry("video_url", realPlayUrl));
        arrayList.add(QCircleReportHelper.newEntry("feed_id", str2));
        arrayList.add(QCircleReportHelper.newEntry("attach_info", json));
        long obtainVideoPlayId = RFWVideoReporter.obtainVideoPlayId();
        QLog.d("PEV-QFSFeedChildVideoErrorPresenter", 1, "[reportErrorViewClick] eventId: " + str + " | errorCode: " + i3 + " | attachJson: " + json);
        RFWVideoReporter.getInstance().report(obtainVideoPlayId, str, gb0.b.m(this.E.o("KEY_RFW_VIDEO_FEED_POI", Integer.valueOf(this.f85018i))), arrayList);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.an) {
            com.tencent.biz.qqcircle.immersive.feed.event.an anVar = (com.tencent.biz.qqcircle.immersive.feed.event.an) hVar;
            m1(anVar.c(), anVar.e());
        } else if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.s) {
            com.tencent.biz.qqcircle.immersive.feed.event.s sVar = (com.tencent.biz.qqcircle.immersive.feed.event.s) hVar;
            l1(sVar.f(), sVar.e(), sVar.b(), sVar.a(), sVar.c());
            SimpleEventBus.getInstance().dispatchEvent(new QFSFeedVideoErrorEvent(sVar));
        } else if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ae) {
            k1((com.tencent.biz.qqcircle.immersive.feed.event.ae) hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = (ViewStub) view.findViewById(R.id.f25840bx);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null) {
            return;
        }
        rFWFeedSelectInfo.getPosition();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QFSPlayerErrorView qFSPlayerErrorView;
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getPosition() == this.f85018i && (qFSPlayerErrorView = this.J) != null) {
            qFSPlayerErrorView.v();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "PEV-QFSFeedChildVideoErrorPresenter";
    }
}
