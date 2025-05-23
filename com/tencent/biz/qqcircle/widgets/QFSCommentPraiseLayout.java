package com.tencent.biz.qqcircle.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSInteractActionEvent;
import com.tencent.biz.qqcircle.events.QFSPushRanCommentUpdateEvent;
import com.tencent.biz.qqcircle.manager.diffres.beans.QFSQQVipLikeResPackage;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.qqcircle.requests.QFSPushRanCommentRequest;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLike;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudWrite$StDoLikeRsp;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import trpcprotocol.feedcloud.comment.SubmitCommentForRanCommentReviewRsp;
import trpcprotocol.feedcloud.comment.SubmitTouchType;

/* loaded from: classes5.dex */
public class QFSCommentPraiseLayout extends LinearLayout implements SimpleEventReceiver, View.OnClickListener, com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> {
    private static final Map<String, Integer> K = new HashMap();
    private static final int L = R.drawable.qvideo_skin_icon_general_thumb;
    private static final int M = R.drawable.qvideo_skin_icon_general_thumb;
    private static final int N = R.drawable.or5;
    private static final int P = R.drawable.or6;
    private static final int Q = R.drawable.qvideo_skin_icon_general_thumb_reverse;
    private static final int R = R.drawable.qvideo_skin_icon_general_thumb_reverse;
    private static final int S = R.drawable.qvideo_skin_icon_general_thumb_reverse_solid;
    private QFSCommentPushRanView C;
    private FeedCloudMeta$StFeed D;
    private FeedCloudMeta$StComment E;
    private FeedCloudMeta$StReply F;
    private boolean G;
    private i H;
    private j I;
    private QCircleReportBean J;

    /* renamed from: d, reason: collision with root package name */
    private int f93177d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f93178e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f93179f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f93180h;

    /* renamed from: i, reason: collision with root package name */
    private LottieAnimationView f93181i;

    /* renamed from: m, reason: collision with root package name */
    private LottieAnimationView f93182m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends View.AccessibilityDelegate {
        a() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(QFSCommentPraiseLayout.this.P());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends View.AccessibilityDelegate {
        b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(QFSCommentPraiseLayout.this.N());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f93185d;

        c(boolean z16) {
            this.f93185d = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSCommentPraiseLayout.this.f93182m.setImageDrawable(QFSCommentPraiseLayout.this.z(true));
            if (this.f93185d && QFSCommentPraiseLayout.this.I != null) {
                QFSCommentPraiseLayout.this.I.w();
            }
            QFSCommentPraiseLayout.this.f93182m.removeAnimatorListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSCommentPraiseLayout.this.S(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e extends h {
        e(boolean z16, int i3, int i16, int i17, int i18, boolean z17, int i19, int i26) {
            super(z16, i3, i16, i17, i18, z17, i19, i26);
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoLikeRsp feedCloudWrite$StDoLikeRsp) {
            if (z16 && j3 == 0) {
                QFSCommentPraiseLayout.this.W(this.f93199h);
                if (this.f93192a) {
                    QFSCommentPraiseLayout.this.c0(this.f93194c, this.f93196e, feedCloudWrite$StDoLikeRsp);
                }
            } else {
                QLog.d("QFSCommentPraiseLayout", 4, "updateDislikeViewAndSendRequest failed, retCode: " + j3 + ", errMsg: " + str);
                QFSCommentPraiseLayout.this.X(this.f93198g, true);
                if (this.f93192a) {
                    QFSCommentPraiseLayout.this.e0(this.f93193b, this.f93195d);
                }
                cj.b(false, j3, str);
            }
            QFSCommentPraiseLayout.this.f93179f = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f extends h {
        f(boolean z16, int i3, int i16, int i17, int i18, boolean z17, int i19, int i26) {
            super(z16, i3, i16, i17, i18, z17, i19, i26);
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoLikeRsp feedCloudWrite$StDoLikeRsp) {
            if (z16 && j3 == 0) {
                QFSCommentPraiseLayout.this.c0(this.f93194c, this.f93196e, feedCloudWrite$StDoLikeRsp);
                if (this.f93197f) {
                    QFSCommentPraiseLayout.this.W(this.f93199h);
                }
            } else {
                QLog.d("QFSCommentPraiseLayout", 4, "updateLikeViewAndSendRequest failed, retCode: " + j3 + ", errMsg: " + str);
                QFSCommentPraiseLayout.this.e0(this.f93193b, (long) this.f93195d);
                if (this.f93197f) {
                    QFSCommentPraiseLayout.this.X(this.f93198g, true);
                }
                QFSCommentPraiseLayout.this.l0(this.f93193b);
                cj.b(false, j3, str);
            }
            QFSCommentPraiseLayout.this.f93178e = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class g implements VSDispatchObserver.OnVSRspCallBack<SubmitCommentForRanCommentReviewRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f93190a;

        g(boolean z16) {
            this.f93190a = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, SubmitCommentForRanCommentReviewRsp submitCommentForRanCommentReviewRsp) {
            if (!z16 || j3 != 0 || submitCommentForRanCommentReviewRsp == null) {
                QFSCommentPraiseLayout.this.j0(true, false, this.f93190a);
                cj.d(false, j3, str, 0, QCircleToast.f91644d, false);
                return;
            }
            if (submitCommentForRanCommentReviewRsp.left_times < 0) {
                QFSCommentPraiseLayout.this.j0(true, false, this.f93190a);
                QFSCommentPraiseLayout.this.T(submitCommentForRanCommentReviewRsp.total_times);
            } else {
                QFSCommentPraiseLayout.this.i0();
                QFSCommentPraiseLayout.this.U(submitCommentForRanCommentReviewRsp);
            }
            if (submitCommentForRanCommentReviewRsp.left_times <= 0) {
                QFSCommentHelper.L().I0(true, submitCommentForRanCommentReviewRsp.total_times);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class h implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoLikeRsp> {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f93192a;

        /* renamed from: b, reason: collision with root package name */
        public final int f93193b;

        /* renamed from: c, reason: collision with root package name */
        public final int f93194c;

        /* renamed from: d, reason: collision with root package name */
        public final int f93195d;

        /* renamed from: e, reason: collision with root package name */
        public final int f93196e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f93197f;

        /* renamed from: g, reason: collision with root package name */
        public final int f93198g;

        /* renamed from: h, reason: collision with root package name */
        public final int f93199h;

        h(boolean z16, int i3, int i16, int i17, int i18, boolean z17, int i19, int i26) {
            this.f93192a = z16;
            this.f93193b = i3;
            this.f93194c = i16;
            this.f93195d = i17;
            this.f93196e = i18;
            this.f93197f = z17;
            this.f93198g = i19;
            this.f93199h = i26;
        }
    }

    /* loaded from: classes5.dex */
    public interface i {
        void onClick(int i3);
    }

    /* loaded from: classes5.dex */
    public interface j {
        void g();

        void w();
    }

    public QFSCommentPraiseLayout(Context context) {
        super(context);
        this.f93178e = true;
        this.f93179f = true;
        L();
    }

    @NonNull
    private Map<String, Object> A() {
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.D;
        if (feedCloudMeta$StFeed != null) {
            buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
            FeedCloudMeta$StUser feedCloudMeta$StUser = this.D.poster;
            if (feedCloudMeta$StUser != null) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StUser.f398463id.get());
            }
            int i3 = this.f93177d;
            String str2 = "";
            if (i3 == 1) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_REPLY, 0);
                FeedCloudMeta$StComment feedCloudMeta$StComment = this.E;
                if (feedCloudMeta$StComment != null) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, feedCloudMeta$StComment.f398447id.get());
                    FeedCloudMeta$StUser feedCloudMeta$StUser2 = this.E.postUser;
                    if (feedCloudMeta$StUser2 != null) {
                        str2 = feedCloudMeta$StUser2.f398463id.get();
                    }
                    buildElementParams.put("xsj_target_qq", str2);
                }
            } else if (i3 == 2) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_REPLY, 1);
                FeedCloudMeta$StReply feedCloudMeta$StReply = this.F;
                if (feedCloudMeta$StReply != null) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, feedCloudMeta$StReply.f398460id.get());
                    FeedCloudMeta$StUser feedCloudMeta$StUser3 = this.F.postUser;
                    if (feedCloudMeta$StUser3 != null) {
                        str2 = feedCloudMeta$StUser3.f398463id.get();
                    }
                    buildElementParams.put("xsj_target_qq", str2);
                }
            }
        }
        QCircleReportBean reportBean = getReportBean();
        if (reportBean != null) {
            str = reportBean.getDtPageId();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            buildElementParams.put("xsj_custom_pgid", str);
        }
        return buildElementParams;
    }

    private Drawable B(boolean z16) {
        if (O()) {
            if (z16) {
                return E(P);
            }
            return F(M);
        }
        if (z16) {
            return E(N);
        }
        return F(M);
    }

    private int C() {
        FeedCloudMeta$StReply feedCloudMeta$StReply;
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        int i3 = this.f93177d;
        if (i3 == 1 && (feedCloudMeta$StComment = this.E) != null) {
            return feedCloudMeta$StComment.likeInfo.count.get();
        }
        if (i3 == 2 && (feedCloudMeta$StReply = this.F) != null) {
            return feedCloudMeta$StReply.likeInfo.count.get();
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:
    
        if (r6 == 1) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
    
        if (r6 == 1) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:?, code lost:
    
        return r5 + r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int D(int i3, int i16) {
        int i17 = this.f93177d;
        int i18 = -1;
        if (i17 != 1 || this.E == null) {
            if (i17 != 2 || this.F == null) {
                return 0;
            }
        }
    }

    private Drawable E(@DrawableRes int i3) {
        return QCircleSkinHelper.getInstance().getDrawable(getContext(), i3);
    }

    private Drawable F(@DrawableRes int i3) {
        return QFSQUIUtilsKt.f(getContext(), i3, R.color.qui_common_text_secondary);
    }

    private void H(QFSPushRanCommentUpdateEvent qFSPushRanCommentUpdateEvent) {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        if (qFSPushRanCommentUpdateEvent.getType() == 1 && qFSPushRanCommentUpdateEvent.getIsPushRan() && (feedCloudMeta$StComment = this.E) != null && TextUtils.equals(feedCloudMeta$StComment.f398447id.get(), qFSPushRanCommentUpdateEvent.getCommentId())) {
            k0(false, false, SubmitTouchType.SHARE_PANNEL.getValue());
        }
    }

    private void J() {
        QFSCommentPushRanView qFSCommentPushRanView = this.C;
        if (qFSCommentPushRanView == null) {
            return;
        }
        qFSCommentPushRanView.setVisibility(8);
        this.f93182m.setVisibility(0);
    }

    private void K() {
        if (this.C != null) {
            return;
        }
        QFSCommentPushRanView qFSCommentPushRanView = new QFSCommentPushRanView(getContext());
        this.C = qFSCommentPushRanView;
        qFSCommentPushRanView.setId(R.id.f361013n);
        this.C.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, cx.a(28.0f));
        layoutParams.setMargins(cx.a(8.0f), 0, 0, 0);
        addView(this.C, layoutParams);
    }

    private void L() {
        View.inflate(getContext(), R.layout.g9n, this);
        setOrientation(0);
        setGravity(16);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.f165944dw3);
        this.f93181i = lottieAnimationView;
        lottieAnimationView.setOnClickListener(this);
        this.f93181i.setContentDescription(com.tencent.biz.qqcircle.utils.h.a(R.string.f187813v0));
        this.f93181i.setAccessibilityDelegate(new a());
        TextView textView = (TextView) findViewById(R.id.k98);
        this.f93180h = textView;
        textView.setOnClickListener(this);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById(R.id.f165923y25);
        this.f93182m = lottieAnimationView2;
        lottieAnimationView2.setOnClickListener(this);
        this.f93182m.setContentDescription(com.tencent.biz.qqcircle.utils.h.a(R.string.f187803uz));
        this.f93182m.setAccessibilityDelegate(new b());
        setVisibility(8);
    }

    private boolean M() {
        return QCircleReportBean.isContentDetailPage(QCircleReportBean.getPageId("QFSCommentPraiseLayout", this.J));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N() {
        FeedCloudMeta$StReply feedCloudMeta$StReply;
        int i3 = this.f93177d;
        if (i3 == 1) {
            FeedCloudMeta$StComment feedCloudMeta$StComment = this.E;
            if (feedCloudMeta$StComment == null || feedCloudMeta$StComment.likeInfo.negativeLikeStatus.get() != 1) {
                return false;
            }
            return true;
        }
        if (i3 != 2 || (feedCloudMeta$StReply = this.F) == null || feedCloudMeta$StReply.likeInfo.negativeLikeStatus.get() != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P() {
        FeedCloudMeta$StReply feedCloudMeta$StReply;
        int i3 = this.f93177d;
        if (i3 == 1) {
            FeedCloudMeta$StComment feedCloudMeta$StComment = this.E;
            if (feedCloudMeta$StComment == null || feedCloudMeta$StComment.likeInfo.status.get() != 1) {
                return false;
            }
            return true;
        }
        if (i3 != 2 || (feedCloudMeta$StReply = this.F) == null || feedCloudMeta$StReply.likeInfo.status.get() != 1) {
            return false;
        }
        return true;
    }

    private void Q() {
        FeedCloudMeta$StReply feedCloudMeta$StReply;
        int i3;
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        if (this.D == null) {
            return;
        }
        if (!this.f93179f) {
            QLog.d("QFSCommentPraiseLayout", 1, "onDislikeIconClick, do dislike has not callback ");
            return;
        }
        int i16 = 0;
        this.f93179f = false;
        FeedCloudMeta$StLike feedCloudMeta$StLike = new FeedCloudMeta$StLike();
        int i17 = this.f93177d;
        if (i17 == 1 && (feedCloudMeta$StComment = this.E) != null) {
            feedCloudMeta$StLike = feedCloudMeta$StComment.likeInfo.get();
            int i18 = feedCloudMeta$StLike.negativeLikeStatus.get();
            if (i18 == 0) {
                i3 = 7;
            } else {
                i3 = 8;
            }
            r(i18);
        } else {
            if (i17 == 2 && (feedCloudMeta$StReply = this.F) != null) {
                feedCloudMeta$StLike = feedCloudMeta$StReply.likeInfo.get();
                int i19 = feedCloudMeta$StLike.negativeLikeStatus.get();
                if (i19 == 0) {
                    i3 = 9;
                } else {
                    i3 = 10;
                }
                r(i19);
            }
            Z(i16, feedCloudMeta$StLike);
            if (i16 == 7 && i16 != 9) {
                if (i16 == 8 || i16 == 10) {
                    w(QCircleDaTongConstant.ElementParamValue.CANCEL_DISLIKE);
                    return;
                }
                return;
            }
            s();
            w(QCircleDaTongConstant.ElementParamValue.DISLIKE);
        }
        i16 = i3;
        Z(i16, feedCloudMeta$StLike);
        if (i16 == 7) {
        }
        s();
        w(QCircleDaTongConstant.ElementParamValue.DISLIKE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(boolean z16) {
        String str;
        com.tencent.biz.qqcircle.helpers.w a16 = com.tencent.biz.qqcircle.helpers.w.a();
        if (O()) {
            str = QFSQQVipLikeResPackage.QQ_VIP_COMMENT_HOT_COMMENT_PNG;
        } else {
            str = QFSQQVipLikeResPackage.QQ_VIP_COMMENT_LIKE_PNG;
        }
        String b16 = a16.b(str);
        if (z16 && !TextUtils.isEmpty(b16) && com.tencent.biz.qqcircle.helpers.w.a().g()) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(b16).setTargetView(this.f93181i).setRequestWidth(this.f93181i.getWidth()).setRequestHeight(this.f93181i.getHeight()).setLoadingDrawableColor(0));
        } else {
            this.f93181i.setImageDrawable(B(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i3) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        QCircleToast.l(QCircleToast.f91644d, context.getString(R.string.f189183yp, Integer.valueOf(i3)), 0, true, false);
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(SubmitCommentForRanCommentReviewRsp submitCommentForRanCommentReviewRsp) {
        Context context;
        if (submitCommentForRanCommentReviewRsp == null || (context = getContext()) == null) {
            return;
        }
        QCircleToast.l(QCircleToast.f91646f, context.getString(R.string.f189193yq, Integer.valueOf(submitCommentForRanCommentReviewRsp.left_times)), 0, true, false);
    }

    private void V() {
        K();
        QFSCommentPushRanView qFSCommentPushRanView = this.C;
        if (qFSCommentPushRanView == null) {
            return;
        }
        qFSCommentPushRanView.setVisibility(0);
        this.f93182m.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i3) {
        FeedCloudMeta$StReply feedCloudMeta$StReply;
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        int i16 = this.f93177d;
        if (i16 == 1 && (feedCloudMeta$StComment = this.E) != null) {
            feedCloudMeta$StComment.likeInfo.negativeLikeStatus.set(i3);
        } else if (i16 == 2 && (feedCloudMeta$StReply = this.F) != null) {
            feedCloudMeta$StReply.likeInfo.negativeLikeStatus.set(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i3, boolean z16) {
        Y(i3, false, z16);
    }

    private void Y(int i3, boolean z16, boolean z17) {
        j jVar;
        j jVar2;
        if (i3 == 0) {
            this.f93182m.cancelAnimation();
            this.f93182m.setImageDrawable(z(false));
            if (z17 && (jVar2 = this.I) != null) {
                jVar2.g();
                return;
            }
            return;
        }
        if (i3 == 1) {
            if (z16) {
                this.f93182m.setAnimationFromUrl("https://qq-video.cdn-go.cn/android/latest/defaultmode/9065/animation_lottie/qvideo_skin_comment_dislike_lo.json");
                this.f93182m.addAnimatorListener(new c(z17));
                this.f93182m.playAnimation();
            } else {
                this.f93182m.cancelAnimation();
                this.f93182m.setImageDrawable(z(true));
                if (z17 && (jVar = this.I) != null) {
                    jVar.w();
                }
            }
        }
    }

    private void Z(int i3, FeedCloudMeta$StLike feedCloudMeta$StLike) {
        int i16;
        boolean z16;
        int i17;
        int i18;
        if (feedCloudMeta$StLike == null) {
            return;
        }
        int i19 = feedCloudMeta$StLike.negativeLikeStatus.get();
        if (i19 == 0) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        Y(i16, true, true);
        int i26 = feedCloudMeta$StLike.status.get();
        int C = C();
        if (i16 == 1 && i26 == 1) {
            int D = D(C, 0);
            e0(0, D);
            i17 = 0;
            z16 = true;
            i18 = D;
        } else {
            z16 = false;
            i17 = -1;
            i18 = -1;
        }
        VSNetworkHelper.getInstance().sendRequest(getContext(), t(i3, feedCloudMeta$StLike), new e(z16, i26, i17, C, i18, false, i19, i16));
    }

    private void a0(int i3, long j3) {
        if (i3 == 1) {
            this.f93180h.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_primary));
        } else if (i3 == 0) {
            this.f93180h.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_secondary));
        }
        if (this.G) {
            if (j3 == 0) {
                this.f93180h.setVisibility(8);
                return;
            } else {
                this.f93180h.setVisibility(0);
                this.f93180h.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(j3));
                return;
            }
        }
        this.f93180h.setVisibility(8);
    }

    private void b0(int i3, boolean z16) {
        String str;
        String str2;
        if (i3 == 1) {
            if (z16) {
                this.f93181i.addAnimatorListener(new d());
                com.tencent.biz.qqcircle.helpers.w a16 = com.tencent.biz.qqcircle.helpers.w.a();
                if (O()) {
                    str = QFSQQVipLikeResPackage.QQ_VIP_COMMENT_HOT_COMMENT_LOTTIE;
                } else {
                    str = QFSQQVipLikeResPackage.QQ_VIP_COMMENT_LIKE_LOTTIE;
                }
                String b16 = a16.b(str);
                if (com.tencent.biz.qqcircle.helpers.w.a().g() && !TextUtils.isEmpty(b16)) {
                    try {
                        this.f93181i.setAnimation(new FileInputStream(b16), b16);
                        this.f93181i.playAnimation();
                        return;
                    } catch (FileNotFoundException e16) {
                        QLog.e("QFSCommentPraiseLayout", 1, "start vip hot comment anim error," + e16);
                        return;
                    }
                }
                if (O()) {
                    str2 = "https://qq-video.cdn-go.cn/android/latest/defaultmode/9065/animation_lottie/qvideo_comment_like_hotcomment_lo.json";
                } else {
                    str2 = "https://qq-video.cdn-go.cn/android/latest/defaultmode/9065/animation_lottie/qvideo_comment_like_lo.json";
                }
                this.f93181i.setAnimationFromUrl(str2);
                this.f93181i.playAnimation();
                return;
            }
            this.f93181i.cancelAnimation();
            S(true);
            return;
        }
        if (i3 == 0) {
            this.f93181i.cancelAnimation();
            S(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(int i3, int i16, FeedCloudWrite$StDoLikeRsp feedCloudWrite$StDoLikeRsp) {
        String str;
        FeedCloudMeta$StReply feedCloudMeta$StReply;
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        FeedCloudMeta$StComment feedCloudMeta$StComment2 = this.E;
        String str2 = "";
        if (feedCloudMeta$StComment2 == null) {
            str = "";
        } else {
            str = feedCloudMeta$StComment2.f398447id.get();
        }
        FeedCloudMeta$StReply feedCloudMeta$StReply2 = this.F;
        if (feedCloudMeta$StReply2 != null) {
            str2 = feedCloudMeta$StReply2.f398460id.get();
        }
        String str3 = str2;
        int i17 = this.f93177d;
        if (i17 == 1 && (feedCloudMeta$StComment = this.E) != null) {
            feedCloudMeta$StComment.likeInfo.status.set(i3);
            this.E.likeInfo.count.set(i16);
        } else if (i17 == 2 && (feedCloudMeta$StReply = this.F) != null) {
            feedCloudMeta$StReply.likeInfo.status.set(i3);
            this.F.likeInfo.count.set(i16);
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentPraiseUpdateEvent(this.f93177d, i3, this.D.f398449id.get(), str, str3, i16, hashCode()));
        SimpleEventBus.getInstance().dispatchEvent(new QFSInteractActionEvent(this.D.f398449id.get(), 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(int i3, long j3) {
        f0(i3, j3, false);
    }

    private void f0(int i3, long j3, boolean z16) {
        b0(i3, z16);
        a0(i3, j3);
    }

    private void g0(int i3, FeedCloudMeta$StLike feedCloudMeta$StLike, boolean z16) {
        int i16;
        int i17;
        boolean z17;
        if (feedCloudMeta$StLike == null) {
            return;
        }
        int i18 = feedCloudMeta$StLike.status.get();
        if (i18 == 0) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        int C = C();
        int D = D(C, i16);
        f0(i16, D, z16);
        l0(i16);
        int i19 = feedCloudMeta$StLike.negativeLikeStatus.get();
        if (i16 == 1 && i19 == 1) {
            X(0, true);
            w(QCircleDaTongConstant.ElementParamValue.AUTO_CANCEL_DISLIKE);
            i17 = 0;
            z17 = true;
        } else {
            i17 = -1;
            z17 = false;
        }
        VSNetworkHelper.getInstance().sendRequest(getContext(), t(i3, feedCloudMeta$StLike), new f(false, i18, i16, C, D, z17, i19, i17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.E;
        if (feedCloudMeta$StComment != null) {
            feedCloudMeta$StComment.hasSubmitRanComment.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(boolean z16, boolean z17, boolean z18) {
        if (z16) {
            V();
        } else {
            J();
        }
        QFSCommentPushRanView qFSCommentPushRanView = this.C;
        if (qFSCommentPushRanView != null) {
            qFSCommentPushRanView.c(z17, z18);
        }
    }

    private void k0(boolean z16, boolean z17, int i3) {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        if (this.f93177d == 1 && (feedCloudMeta$StComment = this.E) != null && this.D != null) {
            if (feedCloudMeta$StComment.hasSubmitRanComment.get()) {
                QCircleToast.l(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f189223yt), 0, true, false);
                return;
            }
            if (QFSCommentHelper.L().d0()) {
                T(QFSCommentHelper.L().Q());
                return;
            }
            if (z16) {
                v();
            }
            j0(true, true, z17);
            VSNetworkHelper.getInstance().sendRequest(getContext(), new QFSPushRanCommentRequest(this.D.f398449id.get(), this.E.f398447id.get(), i3), new g(z17));
            return;
        }
        QLog.e("QFSCommentPraiseLayout", 1, "[updatePushRanViewAndSendRequest] data error, type:" + this.f93177d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(int i3) {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        boolean z16 = true;
        if (this.f93177d != 1 || (feedCloudMeta$StComment = this.E) == null || !feedCloudMeta$StComment.show_submit_ran_comment_btn.get() || this.E.hasSubmitRanComment.get()) {
            return;
        }
        if (i3 != 1) {
            z16 = false;
        }
        j0(z16, false, false);
    }

    private void r(int i3) {
        if (i3 != 0) {
            return;
        }
        String str = this.D.f398449id.get();
        Map<String, Integer> map = K;
        Integer num = map.get(str);
        if (num == null) {
            map.put(str, 1);
        } else if (num.intValue() >= 2) {
            map.put(str, 0);
            QCircleToast.l(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f212095ml), 0, true, false);
        } else {
            map.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    private void s() {
        if (com.tencent.biz.qqcircle.f.v().K()) {
            QCircleToast.l(QCircleToast.f91646f, com.tencent.biz.qqcircle.utils.h.a(R.string.f212615o0), 0, true, false);
            com.tencent.biz.qqcircle.f.v().c0(false);
        }
    }

    private QCircleDoLikeRequest t(int i3, FeedCloudMeta$StLike feedCloudMeta$StLike) {
        return new QCircleDoLikeRequest(this.D, i3, feedCloudMeta$StLike, this.E, this.F, M(), QCirclePluginUtil.getQCircleInitBean(getContext()));
    }

    private void u(int i3) {
        i iVar = this.H;
        if (iVar != null) {
            iVar.onClick(i3);
        }
    }

    private void v() {
        QFSCommentPushRanView qFSCommentPushRanView = this.C;
        if (qFSCommentPushRanView == null) {
            return;
        }
        VideoReport.setElementId(qFSCommentPushRanView, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_COMMENT_HOTCOMMENT);
        VideoReport.setElementExposePolicy(this.C, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.C, ClickPolicy.REPORT_NONE);
        Map<String, Object> A = A();
        A.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_COMMENT_HOTCOMMENT);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", this.C, A);
    }

    private void w(String str) {
        LottieAnimationView lottieAnimationView = this.f93182m;
        if (lottieAnimationView == null) {
            return;
        }
        VideoReport.setElementId(lottieAnimationView, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_COMMENT_DISLIKE);
        VideoReport.setElementExposePolicy(this.f93182m, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.f93182m, ClickPolicy.REPORT_NONE);
        Map<String, Object> A = A();
        A.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_COMMENT_DISLIKE);
        A.put(QCircleDaTongConstant.ElementParamKey.XSJ_DISLIKE_TYPE, str);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", this.f93182m, A);
    }

    private void x() {
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_HOTCOMMENT_TOAST);
        QCircleReportBean reportBean = getReportBean();
        if (reportBean != null) {
            str = reportBean.getDtPageId();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            buildElementParams.put("xsj_custom_pgid", str);
        }
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    private boolean y() {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        if (this.f93177d != 1 || (feedCloudMeta$StComment = this.E) == null || !feedCloudMeta$StComment.show_submit_ran_comment_btn.get()) {
            return false;
        }
        if (this.E.likeInfo.status.get() == 1) {
            return true;
        }
        return this.E.hasSubmitRanComment.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable z(boolean z16) {
        if (z16) {
            return E(S);
        }
        return F(R);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.a
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public QCircleReportBean getReportBean() {
        return QCircleReportBean.getReportBean("QFSCommentPraiseLayout", this.J);
    }

    public void I() {
        this.f93182m.setVisibility(8);
    }

    public boolean O() {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        if (this.f93177d == 1 && (feedCloudMeta$StComment = this.E) != null) {
            return QFSCommentHelper.V(feedCloudMeta$StComment.typeFlag2.get(), 4);
        }
        return false;
    }

    public void R(boolean z16, boolean z17) {
        FeedCloudMeta$StReply feedCloudMeta$StReply;
        int i3;
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        if (this.D == null) {
            return;
        }
        int i16 = 0;
        if (!this.f93178e) {
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.ksw), 0);
            return;
        }
        this.f93178e = false;
        FeedCloudMeta$StLike feedCloudMeta$StLike = new FeedCloudMeta$StLike();
        int i17 = this.f93177d;
        if (i17 == 1 && (feedCloudMeta$StComment = this.E) != null) {
            feedCloudMeta$StLike = feedCloudMeta$StComment.likeInfo.get();
            i16 = feedCloudMeta$StLike.status.get() == 0 ? 3 : 4;
        } else if (i17 == 2 && (feedCloudMeta$StReply = this.F) != null) {
            feedCloudMeta$StLike = feedCloudMeta$StReply.likeInfo.get();
            i16 = feedCloudMeta$StLike.status.get() == 0 ? 5 : 6;
        }
        if (z17) {
            if (feedCloudMeta$StLike.status.get() == 0) {
                i3 = 14;
            } else {
                i3 = 15;
            }
            u(i3);
        }
        g0(i16, feedCloudMeta$StLike, z16);
    }

    public void d0() {
        FeedCloudMeta$StReply feedCloudMeta$StReply;
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        if (this.f93177d == 1 && (feedCloudMeta$StComment = this.E) != null && feedCloudMeta$StComment.likeInfo.status.get() == 1) {
            QLog.d("QFSCommentPraiseLayout", 1, "[updateLikeStatusDirectly] comment already like");
        } else if (this.f93177d == 2 && (feedCloudMeta$StReply = this.F) != null && feedCloudMeta$StReply.likeInfo.status.get() == 1) {
            QLog.d("QFSCommentPraiseLayout", 1, "[updateLikeStatusDirectly] reply already like");
        } else {
            R(false, true);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleCommentPraiseUpdateEvent.class);
        arrayList.add(QFSPushRanCommentUpdateEvent.class);
        return arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("commentLikeLayout")) {
            if (R.id.f165944dw3 != view.getId() && R.id.k98 != view.getId()) {
                if (R.id.f165923y25 == view.getId()) {
                    Q();
                } else if (R.id.f361013n == view.getId()) {
                    k0(true, true, SubmitTouchType.AFTER_LIKE.getValue());
                }
            } else {
                R(true, true);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        FeedCloudMeta$StComment feedCloudMeta$StComment2;
        if (simpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent) {
            QCircleCommentPraiseUpdateEvent qCircleCommentPraiseUpdateEvent = (QCircleCommentPraiseUpdateEvent) simpleBaseEvent;
            if (hashCode() != qCircleCommentPraiseUpdateEvent.mSender && (feedCloudMeta$StFeed = this.D) != null && TextUtils.equals(qCircleCommentPraiseUpdateEvent.mFeedId, feedCloudMeta$StFeed.f398449id.get())) {
                if (this.f93177d == 1 && qCircleCommentPraiseUpdateEvent.mType == 1 && (feedCloudMeta$StComment2 = this.E) != null && TextUtils.equals(feedCloudMeta$StComment2.f398447id.get(), qCircleCommentPraiseUpdateEvent.mCommentId)) {
                    this.E.likeInfo.status.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
                    this.E.likeInfo.count.set(qCircleCommentPraiseUpdateEvent.mPraisedNum);
                    e0(qCircleCommentPraiseUpdateEvent.mPraisedStatus, qCircleCommentPraiseUpdateEvent.mPraisedNum);
                    return;
                } else {
                    if (this.f93177d == 2 && qCircleCommentPraiseUpdateEvent.mType == 2 && (feedCloudMeta$StComment = this.E) != null && this.F != null && TextUtils.equals(feedCloudMeta$StComment.f398447id.get(), qCircleCommentPraiseUpdateEvent.mCommentId) && TextUtils.equals(this.F.f398460id.get(), qCircleCommentPraiseUpdateEvent.mReplyId)) {
                        this.F.likeInfo.status.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
                        this.F.likeInfo.count.set(qCircleCommentPraiseUpdateEvent.mPraisedNum);
                        e0(qCircleCommentPraiseUpdateEvent.mPraisedStatus, qCircleCommentPraiseUpdateEvent.mPraisedNum);
                        return;
                    }
                    return;
                }
            }
        }
        if (simpleBaseEvent instanceof QFSPushRanCommentUpdateEvent) {
            H((QFSPushRanCommentUpdateEvent) simpleBaseEvent);
        }
    }

    public void setData(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        setData(i3, feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply, false);
    }

    public void setDisLikeAnimListener(j jVar) {
        this.I = jVar;
    }

    public void setOnClickHookListener(i iVar) {
        this.H = iVar;
    }

    public void setData(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, boolean z16) {
        setVisibility(8);
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        this.f93177d = i3;
        this.D = feedCloudMeta$StFeed;
        this.E = feedCloudMeta$StComment;
        this.F = feedCloudMeta$StReply;
        this.G = z16;
        if (i3 == 1) {
            if (feedCloudMeta$StComment != null) {
                e0(feedCloudMeta$StComment.likeInfo.status.get(), this.E.likeInfo.count.get());
                X(this.E.likeInfo.negativeLikeStatus.get(), false);
                j0(y(), this.E.hasSubmitRanComment.get(), false);
                setVisibility(0);
                return;
            }
            return;
        }
        if (i3 != 2 || feedCloudMeta$StReply == null) {
            return;
        }
        e0(feedCloudMeta$StReply.likeInfo.status.get(), this.F.likeInfo.count.get());
        X(this.F.likeInfo.negativeLikeStatus.get(), false);
        j0(false, false, false);
        setVisibility(0);
    }

    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.J = QCircleReportBean.setReportBean("QFSCommentPraiseLayout", qCircleReportBean);
    }

    public QFSCommentPraiseLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f93178e = true;
        this.f93179f = true;
        L();
    }

    public QFSCommentPraiseLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93178e = true;
        this.f93179f = true;
        L();
    }
}
