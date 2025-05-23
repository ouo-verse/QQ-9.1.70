package com.tencent.biz.qqcircle.comment.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSCommentAreaTabItemInfo;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QFSThankLAPRequest;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.lang.ref.WeakReference;
import java.util.Map;
import qqcircle.QQCircleThank$ThankLAPRsp;

/* loaded from: classes4.dex */
public class QFSCommentAreaLikePushItemView extends QCircleBaseWidgetView<QFSCommentAreaTabItemInfo> {
    private ViewGroup C;
    private QFSFollowView D;
    private QFSCommentAreaTabItemInfo E;
    private ViewGroup F;
    private ViewGroup G;
    private AnimatorSet H;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f84015d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleAvatarView f84016e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f84017f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f84018h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f84019i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f84020m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<QQCircleThank$ThankLAPRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f84024a;

        b(boolean z16) {
            this.f84024a = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleThank$ThankLAPRsp qQCircleThank$ThankLAPRsp) {
            if (!z16 || j3 != 0) {
                QFSCommentAreaLikePushItemView.this.y0(this.f84024a, false);
                QFSCommentAreaLikePushItemView.this.E.setThanked(this.f84024a);
                QCircleToast.h(R.string.f19228473, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSCommentAreaLikePushItemView> f84026a;

        public c(QFSCommentAreaLikePushItemView qFSCommentAreaLikePushItemView) {
            this.f84026a = new WeakReference<>(qFSCommentAreaLikePushItemView);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            QFSCommentAreaLikePushItemView qFSCommentAreaLikePushItemView = this.f84026a.get();
            if (qFSCommentAreaLikePushItemView != null) {
                return qFSCommentAreaLikePushItemView.o0(TextUtils.equals(str, "clck"));
            }
            return new QCircleDTParamBuilder().buildElementParams();
        }
    }

    public QFSCommentAreaLikePushItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f84015d = (LinearLayout) findViewById(R.id.f352511c);
        this.f84016e = (QCircleAvatarView) findViewById(R.id.f352211_);
        this.f84017f = (TextView) findViewById(R.id.f352411b);
        this.f84018h = (TextView) findViewById(R.id.f352611d);
        this.f84019i = (LinearLayout) findViewById(R.id.f352711e);
        this.f84020m = (TextView) findViewById(R.id.f352811f);
        this.C = (ViewGroup) findViewById(R.id.f3627144);
        this.F = (ViewGroup) findViewById(R.id.f56862lr);
        this.G = (ViewGroup) findViewById(R.id.f55552i8);
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.widget.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSCommentAreaLikePushItemView.this.q0(view);
            }
        });
        QFSFollowView qFSFollowView = (QFSFollowView) findViewById(R.id.f352311a);
        this.D = qFSFollowView;
        qFSFollowView.setVisibility(8);
        this.G.setVisibility(8);
        this.F.setVisibility(8);
    }

    private void p0() {
        String str;
        int i3;
        if (this.E == null) {
            return;
        }
        if (fb0.a.b(getLogTag() + "_handleThanksButtonClick", 500L)) {
            return;
        }
        String feedId = this.E.getFeedId();
        if (this.E.getUser() != null) {
            str = this.E.getUser().f398463id.get();
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(feedId) && !TextUtils.isEmpty(str)) {
            boolean isThanked = this.E.isThanked();
            int i16 = 1;
            boolean z16 = !this.E.isThanked();
            y0(z16, true);
            this.E.setThanked(z16);
            if (this.E.isLikeTabItem()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            if (!z16) {
                i16 = 2;
            }
            VSNetworkHelper.getInstance().sendRequest(new QFSThankLAPRequest(feedId, str, i3, i16), new b(isThanked));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        p0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void r0() {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        String str;
        QFSCommentAreaTabItemInfo qFSCommentAreaTabItemInfo;
        QCircleAvatarView qCircleAvatarView;
        ViewGroup viewGroup;
        QFSCommentAreaTabItemInfo qFSCommentAreaTabItemInfo2 = this.E;
        if (qFSCommentAreaTabItemInfo2 != null) {
            if (qFSCommentAreaTabItemInfo2.getUser() != null) {
                feedCloudMeta$StUser = this.E.getUser();
            } else if (this.E.getStFeed() != null && this.E.getStFeed().poster != null) {
                feedCloudMeta$StUser = this.E.getStFeed().poster.get();
            }
            String str2 = "";
            if (feedCloudMeta$StUser != null) {
                str = "";
            } else {
                str = feedCloudMeta$StUser.f398463id.get();
            }
            qFSCommentAreaTabItemInfo = this.E;
            if (qFSCommentAreaTabItemInfo != null) {
                str2 = qFSCommentAreaTabItemInfo.getFeedId();
            }
            qCircleAvatarView = this.f84016e;
            if (qCircleAvatarView != null) {
                VideoReport.setElementId(qCircleAvatarView, "em_xsj_author_avatar");
                VideoReport.setElementExposePolicy(this.f84016e, ExposurePolicy.REPORT_ALL);
                VideoReport.setElementReuseIdentifier(this.f84016e, str2 + "_" + str);
                VideoReport.setElementParams(this.f84016e, o0(false));
            }
            viewGroup = this.C;
            if (viewGroup == null) {
                VideoReport.setElementId(viewGroup, QCircleDaTongConstant.ElementId.EM_XSJ_THANK_BUTTON);
                VideoReport.setElementExposePolicy(this.C, ExposurePolicy.REPORT_ALL);
                VideoReport.setElementReuseIdentifier(this.C, str2 + "_" + str);
                VideoReport.setEventDynamicParams(this.C, new c(this));
                return;
            }
            return;
        }
        feedCloudMeta$StUser = null;
        String str22 = "";
        if (feedCloudMeta$StUser != null) {
        }
        qFSCommentAreaTabItemInfo = this.E;
        if (qFSCommentAreaTabItemInfo != null) {
        }
        qCircleAvatarView = this.f84016e;
        if (qCircleAvatarView != null) {
        }
        viewGroup = this.C;
        if (viewGroup == null) {
        }
    }

    private void s0(View view, boolean z16) {
        int i3;
        if (view == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private void u0(QFSCommentAreaTabItemInfo qFSCommentAreaTabItemInfo) {
        if (qFSCommentAreaTabItemInfo != null && this.f84016e != null) {
            int a16 = cx.a(48.0f);
            this.f84016e.setUser(qFSCommentAreaTabItemInfo.getUser(), new Size(a16, a16));
        }
    }

    private void v0(QFSCommentAreaTabItemInfo qFSCommentAreaTabItemInfo) {
        if (qFSCommentAreaTabItemInfo != null && this.f84017f != null && qFSCommentAreaTabItemInfo.getUser() != null) {
            this.f84017f.setText(qFSCommentAreaTabItemInfo.getUser().nick.get());
        }
    }

    private void w0(QFSCommentAreaTabItemInfo qFSCommentAreaTabItemInfo) {
        LinearLayout linearLayout;
        if (qFSCommentAreaTabItemInfo != null && qFSCommentAreaTabItemInfo.getPushNum() != 0 && (linearLayout = this.f84019i) != null && this.f84020m != null) {
            s0(linearLayout, true);
            s0(this.f84018h, false);
            this.f84020m.setText(HippyTKDListViewAdapter.X + qFSCommentAreaTabItemInfo.getPushNum() + " ");
        }
    }

    private void x0(QFSCommentAreaTabItemInfo qFSCommentAreaTabItemInfo) {
        if (qFSCommentAreaTabItemInfo != null && !TextUtils.isEmpty(qFSCommentAreaTabItemInfo.getSubTitle())) {
            s0(this.f84018h, true);
            s0(this.f84019i, false);
            this.f84018h.setText(qFSCommentAreaTabItemInfo.getSubTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(boolean z16, boolean z17) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.F != null && this.G != null && (viewGroup = this.C) != null && viewGroup.getVisibility() != 8) {
            AnimatorSet animatorSet = this.H;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (z16) {
                viewGroup2 = this.G;
            } else {
                viewGroup2 = this.F;
            }
            if (z16) {
                viewGroup3 = this.F;
            } else {
                viewGroup3 = this.G;
            }
            if (!z17) {
                viewGroup2.setVisibility(0);
                viewGroup2.setAlpha(1.0f);
                viewGroup3.setVisibility(8);
                viewGroup3.setAlpha(0.0f);
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewGroup2, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(viewGroup3, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.H = animatorSet2;
            animatorSet2.setDuration(200L);
            this.H.setInterpolator(new AccelerateDecelerateInterpolator());
            this.H.playTogether(ofFloat, ofFloat2);
            this.H.addListener(new a(viewGroup2, viewGroup3));
            this.H.start();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g8x;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSCommentAreaLikePushItemView";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSCommentAreaTabItemInfo qFSCommentAreaTabItemInfo, int i3) {
        this.E = qFSCommentAreaTabItemInfo;
        u0(qFSCommentAreaTabItemInfo);
        v0(qFSCommentAreaTabItemInfo);
        x0(qFSCommentAreaTabItemInfo);
        w0(qFSCommentAreaTabItemInfo);
        r0();
    }

    protected Map<String, Object> o0(boolean z16) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        FeedCloudMeta$StUser feedCloudMeta$StUser2;
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        QFSCommentAreaTabItemInfo qFSCommentAreaTabItemInfo = this.E;
        if (qFSCommentAreaTabItemInfo == null) {
            return buildElementParams;
        }
        FeedCloudMeta$StFeed stFeed = qFSCommentAreaTabItemInfo.getStFeed();
        if (stFeed != null) {
            buildElementParams.put("xsj_feed_id", stFeed.f398449id.get());
            FeedCloudMeta$StUser feedCloudMeta$StUser3 = stFeed.poster;
            if (feedCloudMeta$StUser3 != null) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StUser3.f398463id.get());
            }
        }
        if (this.E.getUser() != null) {
            feedCloudMeta$StUser = this.E.getUser();
        } else if (stFeed != null && (feedCloudMeta$StUser2 = stFeed.poster) != null) {
            feedCloudMeta$StUser = feedCloudMeta$StUser2.get();
        } else {
            feedCloudMeta$StUser = null;
        }
        if (feedCloudMeta$StUser != null) {
            buildElementParams.put("xsj_target_qq", feedCloudMeta$StUser.f398463id.get());
        }
        if (this.E.isLikeTabItem()) {
            str = "\u8d5e\u8fc7";
        } else {
            str = "\u63a8\u8fc7";
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SUBTAB_NAME, str);
        int i3 = 3;
        if (z16) {
            if (this.E.isThanked()) {
                i3 = 1;
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_THANK_BUTTON_TYPE, Integer.valueOf(i3));
        } else {
            if (!this.E.isThanked()) {
                i3 = 1;
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_THANK_BUTTON_TYPE, Integer.valueOf(i3));
        }
        return buildElementParams;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f84021d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f84022e;

        a(View view, View view2) {
            this.f84021d = view;
            this.f84022e = view2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            View view = this.f84022e;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.f84022e;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view = this.f84021d;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.f84022e;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
