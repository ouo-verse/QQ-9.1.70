package n30;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.biz.qqcircle.beans.QFSFeedCommentInfo;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.qqcircle.widgets.QFSRichImageView;
import com.tencent.biz.qqcircle.widgets.bc;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StLike;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudWrite$StDoLikeRsp;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    private static final int K = 2131245165;
    protected View C;
    private View D;
    private View E;
    private TextView F;
    private QFSRichImageView G;
    private boolean H = true;
    private QCircleReportBean I;
    private View.OnClickListener J;

    /* renamed from: d, reason: collision with root package name */
    private final int f418102d;

    /* renamed from: e, reason: collision with root package name */
    private FeedCloudMeta$StNotice f418103e;

    /* renamed from: f, reason: collision with root package name */
    private FeedCloudMeta$StLike f418104f;

    /* renamed from: h, reason: collision with root package name */
    private final ViewStub f418105h;

    /* renamed from: i, reason: collision with root package name */
    protected View f418106i;

    /* renamed from: m, reason: collision with root package name */
    protected View f418107m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: n30.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C10819a implements QFSPagAnimView.c {
        C10819a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationCancel(QFSPagAnimView qFSPagAnimView) {
            bc.a(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public void onAnimationEnd(QFSPagAnimView qFSPagAnimView) {
            QLog.e(a.this.l(), 1, "onAnimationEnd");
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationRepeat(QFSPagAnimView qFSPagAnimView) {
            bc.c(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public void onAnimationStart(QFSPagAnimView qFSPagAnimView) {
            QLog.e(a.this.l(), 1, "onAnimationStart");
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationUpdate(QFSPagAnimView qFSPagAnimView) {
            bc.e(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public void onPagPlayError(QFSPagAnimView qFSPagAnimView, String str) {
            QLog.e(a.this.l(), 1, "onPagPlayError error:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends d {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f418110c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i3, int i16, int i17) {
            super(i3, i16);
            this.f418110c = i17;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoLikeRsp feedCloudWrite$StDoLikeRsp) {
            if (!z16 || j3 != 0) {
                QLog.d("QFSMsgNewOpeWrap", 4, "like rsp failed, retCode: " + j3 + ", errMsg: " + str);
                a.this.C(this.f418110c, false);
                a.this.B(this.f418110c);
                if (cj.a(j3)) {
                    QCircleToast.l(QCircleToast.f91645e, str, 0, true, false);
                }
            }
            a.this.H = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static abstract class d implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoLikeRsp> {

        /* renamed from: a, reason: collision with root package name */
        public final int f418112a;

        /* renamed from: b, reason: collision with root package name */
        public final int f418113b;

        d(int i3, int i16) {
            this.f418112a = i3;
            this.f418113b = i16;
        }
    }

    public a(View view, int i3) {
        this.f418102d = i3;
        this.f418105h = (ViewStub) view.findViewById(R.id.f33050ve);
    }

    private void A(int i3) {
        View view = this.f418106i;
        if (view == null) {
            return;
        }
        view.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i3) {
        FeedCloudMeta$StLike k3 = k();
        if (k3 == null) {
            QLog.e(l(), 1, "updateLikeInfo likeInfo is null");
            return;
        }
        QLog.d(l(), 1, "updateLikeInfo newLikeStatus = " + i3);
        k3.status.set(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i3, boolean z16) {
        QFSRichImageView qFSRichImageView;
        int i16;
        boolean z17 = true;
        if (this.F != null && (qFSRichImageView = this.G) != null) {
            if (i3 != 1) {
                z17 = false;
            }
            qFSRichImageView.setSelected(z17, z16);
            TextView textView = this.F;
            if (i3 == 0) {
                i16 = R.string.f1909843k;
            } else {
                i16 = R.string.f1917745p;
            }
            textView.setText(h.a(i16));
            return;
        }
        QLog.e(l(), 1, "updateLikeStatus view == null");
    }

    private void D() {
        FeedCloudMeta$StLike k3 = k();
        if (k3 == null) {
            return;
        }
        C(k3.status.get(), false);
    }

    private QFSCommentInputWindowConfig g() {
        Activity activity;
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
        View view = this.f418107m;
        if (view != null) {
            activity = (Activity) view.getContext();
        } else {
            activity = null;
        }
        qFSCommentInputWindowConfig.activity = activity;
        qFSCommentInputWindowConfig.commentInfo = j();
        qFSCommentInputWindowConfig.isFromContentPage = false;
        qFSCommentInputWindowConfig.isAllowAiComment = false;
        qFSCommentInputWindowConfig.inputListener = new b();
        qFSCommentInputWindowConfig.reportBean = this.I;
        return qFSCommentInputWindowConfig;
    }

    private QCircleDoLikeRequest h(int i3, FeedCloudMeta$StLike feedCloudMeta$StLike) {
        FeedCloudMeta$StNotice feedCloudMeta$StNotice = this.f418103e;
        if (feedCloudMeta$StNotice != null && this.G != null) {
            FeedCloudMeta$StComment feedCloudMeta$StComment = feedCloudMeta$StNotice.operation.comment.get();
            return new QCircleDoLikeRequest(this.f418103e.feed.get(), i3, feedCloudMeta$StLike, feedCloudMeta$StComment, n(feedCloudMeta$StComment), false, QCirclePluginUtil.getQCircleInitBean(this.G.getContext()));
        }
        QLog.e(l(), 1, "createDoLikeRequest mStNotice or likeIcon is null");
        return null;
    }

    private FeedCloudMeta$StReply i(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment == null) {
            QLog.e(l(), 1, "getCurReply comment is null");
            return null;
        }
        List<FeedCloudMeta$StReply> list = feedCloudMeta$StComment.vecReply.get();
        if (RFSafeListUtils.isEmpty(list)) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    private QFSFeedCommentInfo j() {
        FeedCloudMeta$StNotice feedCloudMeta$StNotice = this.f418103e;
        if (feedCloudMeta$StNotice == null) {
            QLog.e(l(), 1, "getFeedCommentInfo stNotice is null");
            return null;
        }
        FeedCloudMeta$StComment feedCloudMeta$StComment = feedCloudMeta$StNotice.operation.comment.get();
        if (feedCloudMeta$StComment == null) {
            QLog.e(l(), 1, "getFeedCommentInfo stComment is null");
            return null;
        }
        QFSFeedCommentInfo qFSFeedCommentInfo = new QFSFeedCommentInfo(this.f418103e.feed.get(), feedCloudMeta$StComment);
        FeedCloudMeta$StReply n3 = n(feedCloudMeta$StComment);
        if (n3 != null) {
            qFSFeedCommentInfo.mReply = n3;
        }
        return qFSFeedCommentInfo;
    }

    private FeedCloudMeta$StLike k() {
        FeedCloudMeta$StNotice feedCloudMeta$StNotice = this.f418103e;
        if (feedCloudMeta$StNotice == null) {
            QLog.e(l(), 1, "getLikeInfo stNotice is null");
            return null;
        }
        FeedCloudMeta$StLike feedCloudMeta$StLike = this.f418104f;
        if (feedCloudMeta$StLike != null) {
            return feedCloudMeta$StLike;
        }
        FeedCloudMeta$StComment feedCloudMeta$StComment = feedCloudMeta$StNotice.operation.comment.get();
        if (s()) {
            FeedCloudMeta$StLike feedCloudMeta$StLike2 = feedCloudMeta$StComment.likeInfo.get();
            this.f418104f = feedCloudMeta$StLike2;
            return feedCloudMeta$StLike2;
        }
        if (!t()) {
            return null;
        }
        FeedCloudMeta$StReply i3 = i(feedCloudMeta$StComment);
        if (i3 == null) {
            QLog.e(l(), 1, "getLikeInfo replyType reply is empty");
            return null;
        }
        FeedCloudMeta$StLike feedCloudMeta$StLike3 = i3.likeInfo.get();
        this.f418104f = feedCloudMeta$StLike3;
        return feedCloudMeta$StLike3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l() {
        return "QFSMsgNewOpeWrap";
    }

    private int m(FeedCloudMeta$StLike feedCloudMeta$StLike) {
        if (s()) {
            if (feedCloudMeta$StLike.status.get() == 0) {
                return 3;
            }
            return 4;
        }
        if (t()) {
            if (feedCloudMeta$StLike.status.get() == 0) {
                return 5;
            }
            return 6;
        }
        return 0;
    }

    private FeedCloudMeta$StReply n(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (t()) {
            return i(feedCloudMeta$StComment);
        }
        return null;
    }

    private void o() {
        String str;
        int i3 = 0;
        if (!this.H) {
            QCircleToast.l(QCircleToast.f91644d, h.a(R.string.ksw), 0, true, false);
            return;
        }
        if (!HostNetworkUtils.isNetworkAvailable()) {
            QCircleToast.l(QCircleToast.f91645e, h.a(R.string.f181603e8), 0, true, false);
            return;
        }
        if (r()) {
            QLog.e(l(), 1, "handleLikeClick comment deleted");
            QCircleToast.l(QCircleToast.f91645e, h.a(R.string.f1917145j), 0, true, false);
            return;
        }
        this.H = false;
        FeedCloudMeta$StLike k3 = k();
        if (k3 != null && this.G != null) {
            int m3 = m(k3);
            int i16 = k3.status.get();
            FeedCloudMeta$StNotice feedCloudMeta$StNotice = this.f418103e;
            if (feedCloudMeta$StNotice == null) {
                str = "";
            } else {
                str = feedCloudMeta$StNotice.operation.comment.f398447id.get();
            }
            if (k3.status.get() != 1) {
                i3 = 1;
            }
            QLog.d(l(), 1, "handleLikeClick viewType = " + this.f418102d + ", newLikeType = " + m3 + ", curLikeStatus = " + i16 + ", newLikeStatus = " + i3 + ", commentId = " + str);
            C(i3, true);
            B(i3);
            QCircleDoLikeRequest h16 = h(m3, k3);
            if (h16 == null) {
                return;
            }
            VSNetworkHelper.getInstance().sendRequest(this.G.getContext(), h16, new c(i16, i3, i16));
            u(i3);
            w(i3);
            return;
        }
        QLog.e(l(), 1, "handleLikeClick likeInfo is null");
    }

    private void p() {
        View view;
        String str;
        if (r()) {
            QLog.e(l(), 1, "handleReplyClick comment deleted");
            QCircleToast.l(QCircleToast.f91645e, h.a(R.string.f1917145j), 0, true, false);
            return;
        }
        QFSFeedCommentInfo j3 = j();
        if (j3 != null && (view = this.f418107m) != null && (view.getContext() instanceof Activity)) {
            FeedCloudMeta$StComment feedCloudMeta$StComment = j3.mComment;
            if (feedCloudMeta$StComment == null) {
                str = "";
            } else {
                str = feedCloudMeta$StComment.f398447id.get();
            }
            QLog.d(l(), 1, "handleReplyClick commentId = " + str);
            QFSCommentHelper.L().w0(g());
            return;
        }
        QLog.e(l(), 1, "handleReplyClick, info or mLlReplyContainer is null or context is not activity");
    }

    private void q() {
        ViewStub viewStub;
        if (this.f418106i == null && (viewStub = this.f418105h) != null) {
            View inflate = viewStub.inflate();
            this.f418106i = inflate;
            if (inflate != null) {
                this.f418107m = inflate.findViewById(R.id.f46941vy);
                this.C = this.f418106i.findViewById(R.id.f46891vt);
                this.D = this.f418106i.findViewById(R.id.f46931vx);
                this.E = this.f418106i.findViewById(R.id.f46881vs);
                this.F = (TextView) this.f418106i.findViewById(R.id.f46991w3);
                QFSRichImageView qFSRichImageView = (QFSRichImageView) this.f418106i.findViewById(R.id.f46951vz);
                this.G = qFSRichImageView;
                qFSRichImageView.setImageViewMargin(DisplayUtil.dip2px(qFSRichImageView.getContext(), 8.0f));
                QFSRichImageView.b bVar = new QFSRichImageView.b();
                bVar.f93412a = QCircleSkinHelper.getInstance().getUrl("qvideo_skin_msgpage_animation_thumb_v2");
                bVar.f93413b = QCircleSkinHelper.getInstance().getUrl("qvideo_msgpage_interactive_thumb_selected_v2");
                bVar.f93416e = QFSQUIUtilsKt.f(this.G.getContext(), K, R.color.qui_common_icon_primary);
                this.G.setResInfo(bVar);
                this.G.setRepeatTimes(1);
                this.G.setPagAnimListener(new C10819a());
                m30.a.d(this.f418107m);
                m30.a.d(this.C);
                this.D.setOnClickListener(this);
                this.E.setOnClickListener(this);
            }
        }
    }

    private boolean r() {
        FeedCloudMeta$StNotice feedCloudMeta$StNotice = this.f418103e;
        if (feedCloudMeta$StNotice == null || !feedCloudMeta$StNotice.opMask.get().contains(5) || !this.f418103e.opMask.get().contains(1)) {
            return false;
        }
        return true;
    }

    private boolean s() {
        int i3 = this.f418102d;
        if (i3 == 1 || i3 == 10) {
            return true;
        }
        return false;
    }

    private boolean t() {
        int i3 = this.f418102d;
        if (i3 != 2 && i3 != 11) {
            return false;
        }
        return true;
    }

    private void u(int i3) {
        String str;
        QFSRichImageView qFSRichImageView = this.G;
        if (qFSRichImageView == null) {
            QLog.e(l(), 1, "reportDtLikeClick view is null");
            return;
        }
        VideoReport.setElementId(qFSRichImageView, QCircleDaTongConstant.ElementId.EM_XSJ_LIKE_CMT_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        q.r().l(this.f418103e, buildElementParams);
        if (i3 == 1) {
            str = "like";
        } else {
            str = "cancel";
        }
        buildElementParams.put("xsj_action_type", str);
        VideoReport.reportEvent("dt_clck", this.G, buildElementParams);
    }

    private void v(FeedCloudMeta$StNotice feedCloudMeta$StNotice, String str, int i3) {
        String str2;
        String str3;
        View view = this.C;
        if (view == null) {
            QLog.e(l(), 1, "reportDtLikeExposure view is null");
            return;
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_LIKE_CMT_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        q.r().l(feedCloudMeta$StNotice, buildElementParams);
        if (i3 == 1) {
            str2 = "like";
        } else {
            str2 = "cancel";
        }
        buildElementParams.put("xsj_action_type", str2);
        VideoReport.setElementParams(this.C, buildElementParams);
        if (feedCloudMeta$StNotice != null) {
            str3 = feedCloudMeta$StNotice.feedId.get() + "_" + feedCloudMeta$StNotice.createTime.get();
        } else {
            str3 = "";
        }
        VideoReport.setElementReuseIdentifier(this.C, str3);
        VideoReport.setElementClickPolicy(this.C, ClickPolicy.REPORT_NONE);
    }

    private void w(int i3) {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        String str;
        String str2;
        String str3;
        String str4;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StNotice feedCloudMeta$StNotice = this.f418103e;
        if (feedCloudMeta$StNotice == null) {
            feedCloudMeta$StComment = null;
        } else {
            feedCloudMeta$StComment = feedCloudMeta$StNotice.operation.comment.get();
        }
        FeedCloudMeta$StReply i16 = i(feedCloudMeta$StComment);
        String str5 = "";
        if (feedCloudMeta$StComment == null) {
            str = "";
        } else {
            str = feedCloudMeta$StComment.f398447id.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_ID, str);
        if (s()) {
            str2 = "cmt";
        } else {
            str2 = "reply";
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SUB_ACTION_TYPE, str2);
        if (i16 == null) {
            str3 = "";
        } else {
            str3 = i16.f398460id.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REPLY_ID, str3);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMTPANEL_SOURCE, 12);
        if (i3 == 1) {
            str4 = "like";
        } else {
            str4 = "cancel";
        }
        buildElementParams.put("xsj_action_type", str4);
        FeedCloudMeta$StNotice feedCloudMeta$StNotice2 = this.f418103e;
        if (feedCloudMeta$StNotice2 != null) {
            str5 = feedCloudMeta$StNotice2.operation.opUser.f398463id.get();
        }
        buildElementParams.put("xsj_target_qq", str5);
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_CMTREPLY_LIKE_ACTION, buildElementParams);
    }

    private void x(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        String str;
        View view = this.f418107m;
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_FAST_REPLY_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        q.r().l(feedCloudMeta$StNotice, buildElementParams);
        VideoReport.setElementParams(this.f418107m, buildElementParams);
        if (feedCloudMeta$StNotice != null) {
            str = feedCloudMeta$StNotice.feedId.get() + "_" + feedCloudMeta$StNotice.createTime.get();
        } else {
            str = "";
        }
        VideoReport.setElementReuseIdentifier(this.f418107m, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(o20.d dVar) {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        String str;
        String str2;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StNotice feedCloudMeta$StNotice = this.f418103e;
        if (feedCloudMeta$StNotice == null) {
            feedCloudMeta$StComment = null;
        } else {
            feedCloudMeta$StComment = feedCloudMeta$StNotice.operation.comment.get();
        }
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL);
        String str3 = "";
        if (feedCloudMeta$StComment == null) {
            str = "";
        } else {
            str = feedCloudMeta$StComment.f398447id.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_ID, str);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMTPANEL_SOURCE, 12);
        buildElementParams.put("xsj_action_type", "reply");
        FeedCloudMeta$StNotice feedCloudMeta$StNotice2 = this.f418103e;
        if (feedCloudMeta$StNotice2 != null) {
            str3 = feedCloudMeta$StNotice2.operation.opUser.f398463id.get();
        }
        buildElementParams.put("xsj_target_qq", str3);
        QCircleReportBean qCircleReportBean = this.I;
        if (qCircleReportBean != null) {
            buildElementParams.put("xsj_custom_pgid", qCircleReportBean.getDtPageId());
        }
        if (dVar != null) {
            if (dVar.f421803k) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_QUICK_REPLY, str2);
        }
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_REPLY_ACTION, buildElementParams);
    }

    public void E(QCircleCommentPraiseUpdateEvent qCircleCommentPraiseUpdateEvent) {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        if (qCircleCommentPraiseUpdateEvent == null) {
            QLog.e(l(), 1, "updatePraise event is null");
            return;
        }
        FeedCloudMeta$StNotice feedCloudMeta$StNotice = this.f418103e;
        if (feedCloudMeta$StNotice == null) {
            feedCloudMeta$StComment = null;
        } else {
            feedCloudMeta$StComment = feedCloudMeta$StNotice.operation.comment.get();
        }
        FeedCloudMeta$StReply i3 = i(feedCloudMeta$StComment);
        if (feedCloudMeta$StComment == null) {
            QLog.e(l(), 1, "updatePraise stComment is null");
            return;
        }
        if (qCircleCommentPraiseUpdateEvent.mType == 1 && TextUtils.equals(feedCloudMeta$StComment.f398447id.get(), qCircleCommentPraiseUpdateEvent.mCommentId)) {
            QLog.d(l(), 1, "updatePraise_comment curStatus = " + feedCloudMeta$StComment.likeInfo.status.get() + ", newStatus = " + qCircleCommentPraiseUpdateEvent.mPraisedStatus);
            feedCloudMeta$StComment.likeInfo.status.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
            C(qCircleCommentPraiseUpdateEvent.mPraisedStatus, false);
            return;
        }
        if (qCircleCommentPraiseUpdateEvent.mType == 2 && i3 != null && TextUtils.equals(i3.f398460id.get(), qCircleCommentPraiseUpdateEvent.mReplyId)) {
            QLog.d(l(), 1, "updatePraise_reply curStatus = " + i3.likeInfo.status.get() + ", newStatus = " + qCircleCommentPraiseUpdateEvent.mPraisedStatus);
            i3.likeInfo.status.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
            C(qCircleCommentPraiseUpdateEvent.mPraisedStatus, false);
        }
    }

    public void f(FeedCloudMeta$StNotice feedCloudMeta$StNotice, boolean z16, QCircleReportBean qCircleReportBean) {
        this.f418103e = feedCloudMeta$StNotice;
        this.f418104f = null;
        this.I = qCircleReportBean;
        if (z16) {
            q();
            A(0);
            D();
        } else {
            A(8);
        }
        x(feedCloudMeta$StNotice);
        FeedCloudMeta$StLike k3 = k();
        if (k3 != null) {
            v(feedCloudMeta$StNotice, "dt_imp", k3.status.get());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == null) {
            QLog.e(l(), 1, "onClick v is null");
        } else {
            View.OnClickListener onClickListener = this.J;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            if (R.id.f46931vx == view.getId()) {
                p();
            } else if (R.id.f46881vs == view.getId()) {
                o();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void z(View.OnClickListener onClickListener) {
        this.J = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements QFSCommentHelper.b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentHelper.b
        public void b(FeedCloudMeta$StReply feedCloudMeta$StReply, o20.d dVar) {
            a.this.y(dVar);
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentHelper.b
        public void a(int i3) {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentHelper.b
        public void c(FeedCloudMeta$StComment feedCloudMeta$StComment, o20.d dVar) {
        }
    }
}
