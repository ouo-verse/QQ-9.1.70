package com.tencent.biz.qqcircle.comment.wrapper;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSCommentExtendInfo;
import com.tencent.biz.qqcircle.comment.af;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.QFSRoundProgressView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StFeedAbstract;
import feedcloud.FeedCloudMeta$StUser;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSCommentBaseFeedView<T> {

    /* renamed from: a, reason: collision with root package name */
    protected View f84072a;

    /* renamed from: b, reason: collision with root package name */
    protected T f84073b;

    /* renamed from: c, reason: collision with root package name */
    protected int f84074c;

    /* renamed from: d, reason: collision with root package name */
    protected FeedCloudMeta$StFeed f84075d;

    /* renamed from: e, reason: collision with root package name */
    protected long f84076e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f84077f;

    /* renamed from: g, reason: collision with root package name */
    protected ViewStub f84078g;

    /* renamed from: h, reason: collision with root package name */
    protected RoundCorneredFrameLayout f84079h;

    /* renamed from: i, reason: collision with root package name */
    protected QFSRoundProgressView f84080i;

    /* renamed from: j, reason: collision with root package name */
    private int f84081j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f84082k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f84083l = 90;

    /* renamed from: m, reason: collision with root package name */
    private final QFSCommentBaseFeedView<T>.FakeProgressRunnable f84084m = new FakeProgressRunnable();

    /* renamed from: n, reason: collision with root package name */
    protected View f84085n;

    /* renamed from: o, reason: collision with root package name */
    protected ImageView f84086o;

    /* renamed from: p, reason: collision with root package name */
    protected ImageView f84087p;

    /* renamed from: q, reason: collision with root package name */
    protected LinearLayout f84088q;

    /* renamed from: r, reason: collision with root package name */
    protected TextView f84089r;

    /* renamed from: s, reason: collision with root package name */
    protected View.OnClickListener f84090s;

    /* renamed from: t, reason: collision with root package name */
    protected com.tencent.biz.qqcircle.widgets.a f84091t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class FakeProgressRunnable implements Runnable {
        FakeProgressRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSCommentBaseFeedView.this.f84082k++;
            QFSCommentBaseFeedView qFSCommentBaseFeedView = QFSCommentBaseFeedView.this;
            int l3 = qFSCommentBaseFeedView.l(qFSCommentBaseFeedView.f84082k, QFSCommentBaseFeedView.this.f84081j);
            QFSCommentBaseFeedView.this.L(l3);
            if (l3 <= QFSCommentBaseFeedView.this.f84083l) {
                RFWThreadManager.getUIHandler().postDelayed(this, 200L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends com.tencent.biz.qqcircle.widgets.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onProgressChanged(@NotNull TaskInfo taskInfo) {
            if (QLog.isColorLevel()) {
                QLog.d("QFSCommentBaseFeedView", 2, "onProgressChanged: taskid:" + taskInfo.getTaskId() + " missionID:" + taskInfo.getMissionId() + " state:" + taskInfo.getState() + " progress:" + taskInfo.getUploadProgress() + " exportprogress:" + taskInfo.getExportProgress());
            }
            if (QFSCommentBaseFeedView.this.f84076e == taskInfo.getTaskId()) {
                QFSCommentBaseFeedView.this.x(taskInfo);
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onTaskStateChanged(@NotNull TaskInfo taskInfo) {
            if (QLog.isColorLevel()) {
                QLog.d("QFSCommentBaseFeedView", 2, "onTaskStateChanged: taskid:" + taskInfo.getTaskId() + " missionID:" + taskInfo.getMissionId() + " state:" + taskInfo.getState() + " progress:" + taskInfo.getUploadProgress() + " exportprogress:" + taskInfo.getExportProgress());
            }
            if (QFSCommentBaseFeedView.this.f84076e != taskInfo.getTaskId()) {
                if (QLog.isColorLevel()) {
                    QLog.e(QFSCommentBaseFeedView.this.v(), 2, "[onTaskStateChanged] taskId not equal, mTaskId = " + QFSCommentBaseFeedView.this.f84076e + ", taskInfo.taskId = " + taskInfo.getTaskId());
                    return;
                }
                return;
            }
            if (taskInfo.isFinish() || taskInfo.isCancelled()) {
                QFSCommentBaseFeedView.this.y(taskInfo);
            } else if (taskInfo.isActive()) {
                QFSCommentBaseFeedView.this.z(taskInfo);
            }
        }
    }

    public QFSCommentBaseFeedView(@NonNull View view) {
        this.f84072a = view;
        this.f84078g = (ViewStub) view.findViewById(R.id.f3517115);
    }

    private void B(T t16) {
        String P = QFSCommentHelper.L().P(s(t16));
        if (TextUtils.isEmpty(P)) {
            return;
        }
        try {
            this.f84076e = Long.parseLong(P);
        } catch (Exception e16) {
            QLog.e("QFSCommentBaseFeedView", 1, "taskId parse fail e:" + e16.toString());
        }
        if (QLog.isColorLevel()) {
            QLog.d(v(), 2, "[initPublishTaskId] publishTaskId = " + P);
        }
    }

    private FeedCloudMeta$StFeed D(FeedCloudMeta$StFeedAbstract feedCloudMeta$StFeedAbstract) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        if (feedCloudMeta$StFeedAbstract == null) {
            return feedCloudMeta$StFeed;
        }
        feedCloudMeta$StFeed.f398449id.set(feedCloudMeta$StFeedAbstract.f398450id.get());
        feedCloudMeta$StFeed.createTime.set(feedCloudMeta$StFeedAbstract.createTime.get());
        if (feedCloudMeta$StFeedAbstract.poster.has()) {
            feedCloudMeta$StFeed.poster.set(feedCloudMeta$StFeedAbstract.poster.get());
        }
        return feedCloudMeta$StFeed;
    }

    private void G() {
        if (this.f84091t == null) {
            this.f84091t = new a();
        }
        QCirclePublishCallbackHelper.f93064a.i(this.f84091t, true);
    }

    private void I(@NonNull FeedCloudMeta$StFeedAbstract feedCloudMeta$StFeedAbstract) {
        if (this.f84080i == null) {
            return;
        }
        K(this.f84077f, feedCloudMeta$StFeedAbstract.type.get());
        this.f84080i.setNeedProgress(this.f84077f);
    }

    private void J(@NonNull FeedCloudMeta$StFeedAbstract feedCloudMeta$StFeedAbstract) {
        if (this.f84080i == null) {
            QLog.e(v(), 1, "[setCover] mProgressView == null");
            return;
        }
        String str = feedCloudMeta$StFeedAbstract.pic.picUrl.get();
        QLog.d(v(), 1, "[setCover] coverUrl = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.biz.qqcircle.utils.j.a(this.f84080i, str, 117.0f, 156.0f);
    }

    private void K(boolean z16, int i3) {
        ImageView imageView = this.f84086o;
        if (imageView != null && this.f84087p != null) {
            imageView.setVisibility(8);
            this.f84087p.setVisibility(8);
            if (z16) {
                return;
            }
            if (i3 == 2) {
                this.f84087p.setVisibility(0);
            } else if (i3 == 3) {
                this.f84086o.setVisibility(0);
            }
        }
    }

    private void N(@NonNull FeedCloudMeta$StFeedAbstract feedCloudMeta$StFeedAbstract) {
        if (this.f84088q != null && this.f84085n != null) {
            long j3 = feedCloudMeta$StFeedAbstract.countInfo.visitor.get();
            if (j3 <= 0) {
                this.f84088q.setVisibility(8);
                this.f84085n.setVisibility(8);
            } else {
                this.f84088q.setVisibility(0);
                this.f84085n.setVisibility(0);
            }
            this.f84089r.setText(r.f(j3));
        }
    }

    private void O() {
        com.tencent.biz.qqcircle.widgets.a aVar = this.f84091t;
        if (aVar != null) {
            QCirclePublishCallbackHelper.f93064a.v(aVar);
        }
    }

    private void k(T t16) {
        String str;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        if (this.f84079h == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f84075d;
        String str2 = "";
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TARGET_FEED_ID, str);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_UI_MODULE, "video");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.f84075d;
        if (feedCloudMeta$StFeed2 != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed2.poster) != null) {
            str2 = feedCloudMeta$StUser.f398463id.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str2);
        VideoReport.setElementId(this.f84079h, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_VIDEO_STYLE);
        VideoReport.setElementReuseIdentifier(this.f84079h, s(t16));
        VideoReport.setElementParams(this.f84079h, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l(int i3, int i16) {
        double pow = (1.0d - Math.pow(0.8d, (i3 * 1.0f) / 45.0f)) * (this.f84083l / 100.0f);
        int ceil = (int) Math.ceil((100.0d * pow) + (i16 * (1.0d - pow)));
        if (ceil > 100) {
            return 100;
        }
        return ceil;
    }

    private void n(@NotNull TaskInfo taskInfo) {
        QFSCommentHelper.L().s0(s(this.f84073b));
        Bundle transParams = taskInfo.getTransParams();
        if (transParams == null) {
            QLog.e(v(), 1, "[deletePublishFeedDraft] transBundle == null");
            return;
        }
        String string = transParams.getString(QCircleScheme.AttrQQPublish.COMMENT_DRAFT_ID, "");
        QLog.d(v(), 1, "[deletePublishFeedDraft] draftId = " + string);
        QFSCommentHelper.L().t();
    }

    private QFSCommentExtendInfo r(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, String str2) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.poster != null) {
            QFSCommentExtendInfo qFSCommentExtendInfo = new QFSCommentExtendInfo(str, str2);
            qFSCommentExtendInfo.mFeedId = feedCloudMeta$StFeed.f398449id.get();
            qFSCommentExtendInfo.mCreateTime = feedCloudMeta$StFeed.createTime.get();
            qFSCommentExtendInfo.mPostUin = feedCloudMeta$StFeed.poster.f398463id.get();
            return qFSCommentExtendInfo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(@NotNull TaskInfo taskInfo) {
        int uploadProgress = taskInfo.getUploadProgress();
        RFWThreadManager.getUIHandler().removeCallbacks(this.f84084m);
        if (!taskInfo.isFinish() && !taskInfo.isCancelled()) {
            if (uploadProgress > this.f84081j) {
                this.f84081j = uploadProgress;
                L(l(this.f84082k, uploadProgress));
                M(P(taskInfo));
                return;
            }
            return;
        }
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(@NotNull TaskInfo taskInfo) {
        QLog.d(v(), 1, "[handlePublishFeedStatus] status = " + taskInfo.getState());
        o();
        H();
        if (taskInfo.isFinish() && taskInfo.isSuccess()) {
            A();
            return;
        }
        QCircleToast.k(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f189153ym), 0, false);
        m();
        n(taskInfo);
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(@NotNull TaskInfo taskInfo) {
        M(P(taskInfo));
        int max = Math.max(taskInfo.getUploadProgress(), this.f84080i.q());
        this.f84081j = max;
        L(max);
        if (taskInfo.getExportProgress() < 100 && taskInfo.getUploadProgress() <= 0 && !taskInfo.isNetworkWaiting()) {
            RFWThreadManager.getUIHandler().postDelayed(this.f84084m, 200L);
        } else {
            RFWThreadManager.getUIHandler().removeCallbacks(this.f84084m);
        }
    }

    protected void A() {
        int i3;
        QFSRoundProgressView qFSRoundProgressView = this.f84080i;
        if (qFSRoundProgressView != null) {
            qFSRoundProgressView.r();
        }
        if (q() == null) {
            i3 = 0;
        } else {
            i3 = q().type.get();
        }
        K(false, i3);
    }

    protected void C() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.f84079h;
        if (roundCorneredFrameLayout != null) {
            roundCorneredFrameLayout.setVisibility(0);
            QLog.e(v(), 1, "[initView] has init");
            return;
        }
        ViewStub viewStub = this.f84078g;
        if (viewStub == null) {
            QLog.e(v(), 1, "[initView] mAbstractVieStub == null");
            return;
        }
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = (RoundCorneredFrameLayout) viewStub.inflate();
        this.f84079h = roundCorneredFrameLayout2;
        roundCorneredFrameLayout2.setRadius(cx.a(4.0f));
        this.f84079h.setOnClickListener(t());
        this.f84080i = (QFSRoundProgressView) this.f84079h.findViewById(R.id.f363814e);
        this.f84085n = this.f84079h.findViewById(R.id.f46741ve);
        this.f84086o = (ImageView) this.f84079h.findViewById(R.id.f41531hb);
        this.f84087p = (ImageView) this.f84079h.findViewById(R.id.f41521ha);
        this.f84088q = (LinearLayout) this.f84079h.findViewById(R.id.f57352n3);
        this.f84089r = (TextView) this.f84079h.findViewById(R.id.f57362n4);
    }

    public void E() {
        G();
    }

    public void F() {
        O();
    }

    protected void H() {
        this.f84081j = 0;
    }

    protected void L(int i3) {
        QFSRoundProgressView qFSRoundProgressView = this.f84080i;
        if (qFSRoundProgressView != null) {
            qFSRoundProgressView.setProgress(i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d(v(), 2, "progress = " + i3);
        }
    }

    protected void M(String str) {
        if (this.f84080i != null && !TextUtils.isEmpty(str)) {
            this.f84080i.setShowTips(str);
            this.f84080i.requestLayout();
        }
    }

    protected String P(TaskInfo taskInfo) {
        if (taskInfo.isNetworkWaiting()) {
            QLog.d("QFSCommentBaseFeedView", 1, "handleTaskStateChange, network waiting ");
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f193924ai);
        }
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f189143yl);
    }

    protected void i(@NonNull FeedCloudMeta$StFeedAbstract feedCloudMeta$StFeedAbstract) {
        J(feedCloudMeta$StFeedAbstract);
        N(feedCloudMeta$StFeedAbstract);
        I(feedCloudMeta$StFeedAbstract);
    }

    public void j(T t16, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        this.f84073b = t16;
        this.f84074c = i3;
        this.f84075d = feedCloudMeta$StFeed;
        String s16 = s(t16);
        if (TextUtils.isEmpty(s16)) {
            this.f84077f = true;
        } else {
            this.f84077f = QFSCommentHelper.c0(s16);
        }
        B(t16);
        FeedCloudMeta$StFeedAbstract q16 = q();
        if (q16 != null) {
            C();
            i(q16);
        } else {
            RoundCorneredFrameLayout roundCorneredFrameLayout = this.f84079h;
            if (roundCorneredFrameLayout != null) {
                roundCorneredFrameLayout.setVisibility(8);
            }
            k(t16);
        }
    }

    protected abstract void m();

    public void o() {
        QLog.d("QFSCommentBaseFeedView", 1, "destroy");
        RFWThreadManager.getUIHandler().removeCallbacks(this.f84084m);
    }

    protected void p() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f84075d;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        af.m(feedCloudMeta$StFeed.f398449id.get(), false, this instanceof com.tencent.biz.qqcircle.comment.wrapper.a, s(this.f84073b));
    }

    protected abstract FeedCloudMeta$StFeedAbstract q();

    protected abstract String s(T t16);

    protected abstract View.OnClickListener t();

    /* JADX INFO: Access modifiers changed from: protected */
    public QCircleLayerBean u(FeedCloudMeta$StFeedAbstract feedCloudMeta$StFeedAbstract, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, String str2) {
        if (feedCloudMeta$StFeedAbstract != null) {
            try {
                QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
                qCircleLayerBean.setFeed(D(feedCloudMeta$StFeedAbstract));
                QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
                qCircleExtraTypeInfo.sourceType = 81;
                QFSCommentExtendInfo r16 = r(feedCloudMeta$StFeed, str, str2);
                if (r16 != null) {
                    qCircleLayerBean.setCommentExtentInfo(r16);
                }
                qCircleLayerBean.setExtraTypeInfo(qCircleExtraTypeInfo);
                qCircleLayerBean.setGetFeedList(true);
                return qCircleLayerBean;
            } catch (Exception e16) {
                QLog.e(v(), 1, "jumpDetailPageError:" + e16.getMessage());
                e16.printStackTrace();
                return null;
            }
        }
        return null;
    }

    protected abstract String v();

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        QCircleToast.k(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f189163yn), 0, false);
    }
}
