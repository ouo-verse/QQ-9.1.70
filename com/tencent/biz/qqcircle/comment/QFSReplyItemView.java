package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSReplyItemInfo;
import com.tencent.biz.qqcircle.comment.effect.QFSCommentKeywordHighlightViewController;
import com.tencent.biz.qqcircle.comment.widget.QFSCommentGestureDetectLayout;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.utils.cm;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QFSCommentPraiseLayout;
import com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QFSVipNickNameAndIconView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSReplyItemView extends QCircleBaseWidgetView<QFSReplyItemInfo> implements View.OnClickListener, View.OnLongClickListener, SimpleEventReceiver, QFSCommentPraiseLayout.j {

    /* renamed from: j0, reason: collision with root package name */
    private static final List<Integer> f83242j0 = Arrays.asList(Integer.valueOf(R.id.yn8));

    /* renamed from: k0, reason: collision with root package name */
    private static int f83243k0 = ViewUtils.dpToPx(103.0f);
    private QFSVipNickNameAndIconView C;
    private QFSExpandableAsyncTextView D;
    private QFSReplyItemInfo E;
    private FeedCloudMeta$StFeed F;
    private FeedCloudMeta$StComment G;
    private FeedCloudMeta$StReply H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private Drawable L;
    private QFSCommentPraiseLayout M;
    private QCircleAvatarView N;
    private TextView P;
    private TextView Q;
    private TextView R;
    private QFSCommentGestureDetectLayout S;
    private ImageView T;
    private ImageView U;
    private ImageView V;
    private Size W;

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.comment.wrapper.i f83244a0;

    /* renamed from: b0, reason: collision with root package name */
    private final com.tencent.biz.qqcircle.comment.wrapper.j f83245b0;

    /* renamed from: c0, reason: collision with root package name */
    private QFSCommentKeywordHighlightViewController f83246c0;

    /* renamed from: d, reason: collision with root package name */
    private int f83247d;

    /* renamed from: d0, reason: collision with root package name */
    private LinearLayout f83248d0;

    /* renamed from: e, reason: collision with root package name */
    private int f83249e;

    /* renamed from: e0, reason: collision with root package name */
    private final LinearLayout f83250e0;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.qqcircle.widgets.comment.c f83251f;

    /* renamed from: f0, reason: collision with root package name */
    private FrameLayout f83252f0;

    /* renamed from: g0, reason: collision with root package name */
    private View f83253g0;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f83254h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f83255h0;

    /* renamed from: i, reason: collision with root package name */
    private QFSVipNickNameAndIconView f83256i;

    /* renamed from: i0, reason: collision with root package name */
    private int f83257i0;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f83258m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSCommentKeywordHighlightViewController.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSReplyItemInfo f83260a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f83261b;

        a(QFSReplyItemInfo qFSReplyItemInfo, int i3) {
            this.f83260a = qFSReplyItemInfo;
            this.f83261b = i3;
        }

        @Override // com.tencent.biz.qqcircle.comment.effect.QFSCommentKeywordHighlightViewController.c
        public void onComplete() {
            QFSReplyItemView.this.u0(this.f83260a, this.f83261b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSReplyItemView> f83263a;

        public b(QFSReplyItemView qFSReplyItemView) {
            this.f83263a = new WeakReference<>(qFSReplyItemView);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            String str2;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            QFSReplyItemView qFSReplyItemView = this.f83263a.get();
            if (qFSReplyItemView != null) {
                if (qFSReplyItemView.H != null) {
                    str2 = qFSReplyItemView.H.f398460id.get();
                } else {
                    str2 = "";
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, str2);
            }
            return buildElementParams;
        }
    }

    public QFSReplyItemView(@NonNull Context context) {
        super(context);
        this.f83255h0 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_set_middle_cmt_expand_btn", true);
        this.S = (QFSCommentGestureDetectLayout) findViewById(R.id.f73103sn);
        this.f83256i = (QFSVipNickNameAndIconView) findViewById(R.id.i7u);
        this.T = (ImageView) findViewById(R.id.yce);
        this.U = (ImageView) findViewById(R.id.f3702165);
        this.D = (QFSExpandableAsyncTextView) findViewById(R.id.i7s);
        this.R = (TextView) findViewById(R.id.mdq);
        QFSCommentPraiseLayout qFSCommentPraiseLayout = (QFSCommentPraiseLayout) findViewById(R.id.f26700e9);
        this.M = qFSCommentPraiseLayout;
        qFSCommentPraiseLayout.setDisLikeAnimListener(this);
        this.M.setVisibility(8);
        this.N = (QCircleAvatarView) findViewById(R.id.a2o);
        this.P = (TextView) findViewById(R.id.f110706j9);
        this.Q = (TextView) findViewById(R.id.xrx);
        this.V = (ImageView) findViewById(R.id.f520129n);
        this.f83258m = (ImageView) findViewById(R.id.f494422p);
        this.C = (QFSVipNickNameAndIconView) findViewById(R.id.f520329p);
        this.f83244a0 = new com.tencent.biz.qqcircle.comment.wrapper.i(this);
        this.f83245b0 = new com.tencent.biz.qqcircle.comment.wrapper.j(this);
        this.f83248d0 = (LinearLayout) findViewById(R.id.f519729j);
        this.f83250e0 = (LinearLayout) findViewById(R.id.f520029m);
        this.f83252f0 = (FrameLayout) findViewById(R.id.f519929l);
        this.f83246c0 = new QFSCommentKeywordHighlightViewController(this);
        this.W = com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.d4w);
        this.f83257i0 = cx.j(DisplayUtil.getInstantScreenWidth(getContext()));
        q0();
        this.S.setEnableDoubleClick(false);
    }

    private void A0(SimpleBaseEvent simpleBaseEvent) {
        FeedCloudMeta$StReply feedCloudMeta$StReply;
        ExposurePolicy exposurePolicy;
        if ((simpleBaseEvent instanceof QCircleCommentUpdateEvent) && this.H != null) {
            QCircleCommentUpdateEvent qCircleCommentUpdateEvent = (QCircleCommentUpdateEvent) simpleBaseEvent;
            if (qCircleCommentUpdateEvent.eventStatus != 5 || (feedCloudMeta$StReply = qCircleCommentUpdateEvent.reply) == null || !TextUtils.equals(feedCloudMeta$StReply.f398460id.get(), this.H.f398460id.get())) {
                return;
            }
            this.f83250e0.setVisibility(0);
            VideoReport.setElementReuseIdentifier(this.S, this.H.f398460id.get());
            QFSCommentGestureDetectLayout qFSCommentGestureDetectLayout = this.S;
            if (E0()) {
                exposurePolicy = ExposurePolicy.REPORT_NONE;
            } else {
                exposurePolicy = ExposurePolicy.REPORT_ALL;
            }
            VideoReport.setElementExposePolicy(qFSCommentGestureDetectLayout, exposurePolicy);
        }
    }

    private void B0(QFSReplyItemInfo qFSReplyItemInfo) {
        if (!qFSReplyItemInfo.mNeedTopAnimation) {
            return;
        }
        QFSCommentHelper.x0(this.S);
        qFSReplyItemInfo.mNeedTopAnimation = false;
    }

    private void C0() {
        LinearLayout s16;
        if (this.f83253g0 == null && this.f83252f0 != null && (s16 = af.s(getContext())) != null && (this.f83252f0 instanceof FrameLayout)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ViewUtils.dip2px(20.0f));
            layoutParams.gravity = 16;
            this.f83252f0.addView(s16, layoutParams);
            this.f83253g0 = s16;
        }
    }

    private void D0(QFSReplyItemInfo qFSReplyItemInfo) {
        com.tencent.biz.qqcircle.comment.wrapper.j jVar = this.f83245b0;
        if (jVar == null) {
            return;
        }
        jVar.e(qFSReplyItemInfo, this.F);
        ImageFilterView i3 = this.f83245b0.i();
        if (i3 == null) {
            return;
        }
        i3.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.biz.qqcircle.comment.ag
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean H0;
                H0 = QFSReplyItemView.this.H0(view);
                return H0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E0() {
        FeedCloudMeta$StReply feedCloudMeta$StReply = this.H;
        if (feedCloudMeta$StReply != null && feedCloudMeta$StReply.f398460id.get().startsWith("fake")) {
            return true;
        }
        return false;
    }

    private boolean F0() {
        boolean z16;
        FeedCloudMeta$StReply feedCloudMeta$StReply = this.H;
        if (feedCloudMeta$StReply == null) {
            return false;
        }
        boolean V = QFSCommentHelper.V(feedCloudMeta$StReply.typeFlag2.get(), 4);
        if (this.H.likeInfo.ownerStatus.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("QFSReplyItemView", 4, "[isNeedShowCollapse] isHot|isOwnerPraise: |" + V + "|" + z16);
        if (V || z16) {
            return false;
        }
        return true;
    }

    private boolean G0() {
        QFSReplyItemInfo qFSReplyItemInfo = this.E;
        if (qFSReplyItemInfo != null && qFSReplyItemInfo.isFolded()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean H0(View view) {
        boolean a16 = ud2.a.f438849a.a();
        com.tencent.biz.qqcircle.widgets.comment.c cVar = this.f83251f;
        if (cVar != null && a16) {
            cVar.onLongClick(view, 24, this.f83249e, new Object[]{this.G, this.H});
            return true;
        }
        QLog.d("QFSReplyItemView", 1, "[initPicView] listener=" + this.f83251f + ", canFavEmoji: " + a16);
        return false;
    }

    private void I0() {
        if (this.K == null) {
            Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(getContext(), R.drawable.qvideo_skin_comment_tag_top);
            this.K = drawable;
            drawable.setBounds(ImmersiveUtils.dpToPx(4.0f), 0, ImmersiveUtils.dpToPx(34.0f), ImmersiveUtils.dpToPx(16.0f));
        }
    }

    private void J0() {
        if (this.I == null) {
            Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(getContext(), R.drawable.qvideo_skin_comment_tag_author);
            this.I = drawable;
            drawable.setBounds(ImmersiveUtils.dpToPx(4.0f), 0, ImmersiveUtils.dpToPx(34.0f), ImmersiveUtils.dpToPx(16.0f));
        }
    }

    private void K0() {
        if (this.J == null) {
            Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(getContext(), R.drawable.qvideo_skin_comment_tag_authorlike);
            this.J = drawable;
            drawable.setBounds(ImmersiveUtils.dpToPx(4.0f), 0, ImmersiveUtils.dpToPx(55.5f), ImmersiveUtils.dpToPx(16.0f));
        }
    }

    private void L0() {
        if (this.L == null) {
            Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(getContext(), R.drawable.qvideo_skin_icon_general_play_solid_light);
            this.L = drawable;
            drawable.setBounds(ImmersiveUtils.dpToPx(4.0f), 0, ImmersiveUtils.dpToPx(12.0f), ImmersiveUtils.dpToPx(9.0f));
        }
    }

    private void M0() {
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView = this.D;
        if (qFSExpandableAsyncTextView != null && qFSExpandableAsyncTextView.getLayoutParams() != null) {
            this.D.getLayoutParams().height = -2;
            QFSReplyItemInfo qFSReplyItemInfo = this.E;
            if (qFSReplyItemInfo != null) {
                this.D.setExpanded(qFSReplyItemInfo.mDefaultExpanded);
            }
            boolean F0 = F0();
            this.D.setShowCollapse(F0);
            if (!F0) {
                this.D.setExpanded(true);
            }
            if (this.f83255h0) {
                this.D.setLastLineWidthRatio(0.5f);
            }
            this.D.setExactWidth(x0());
        }
    }

    private void N0(boolean z16) {
        if (z16) {
            C0();
            View view = this.f83253g0;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.f83253g0;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private void O0() {
        boolean z16;
        if (this.H != null && this.f83250e0 != null) {
            QFSReplyItemInfo qFSReplyItemInfo = this.E;
            int i3 = 0;
            if (qFSReplyItemInfo != null && qFSReplyItemInfo.isFolded()) {
                z16 = true;
            } else {
                z16 = false;
            }
            LinearLayout linearLayout = this.f83250e0;
            if (QFSCommentHelper.c0(this.H.f398460id.get()) || z16) {
                i3 = 8;
            }
            linearLayout.setVisibility(i3);
            N0(z16);
        }
    }

    private void P0(FeedCloudMeta$StReply feedCloudMeta$StReply) {
        if (this.F != null && feedCloudMeta$StReply != null && this.D != null) {
            M0();
            this.D.setSpecialClickAreaColor(R.color.qui_common_text_link);
            this.D.setExpandTextColor(R.color.qui_common_text_secondary_light);
            this.D.setCollapseTextColor(R.color.qui_common_text_secondary_light);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) feedCloudMeta$StReply.content.get().trim());
            int i3 = 0;
            if (feedCloudMeta$StReply.typeFlag.get() == 1) {
                I0();
                QCircleAsyncTextView.e(spannableStringBuilder, spannableStringBuilder.length(), this.K);
                this.D.showEllipseEndImageSpan(true);
            } else if (feedCloudMeta$StReply.likeInfo.ownerStatus.get() == 1) {
                K0();
                QCircleAsyncTextView.e(spannableStringBuilder, spannableStringBuilder.length(), this.J);
                this.D.showEllipseEndImageSpan(true);
            } else {
                this.D.showEllipseEndImageSpan(false);
            }
            this.D.setText(spannableStringBuilder);
            this.D.setClickable(false);
            this.D.setLongClickable(false);
            if (TextUtils.isEmpty(spannableStringBuilder)) {
                this.D.setVisibility(8);
            } else {
                this.D.setVisibility(0);
            }
            LinearLayout linearLayout = this.f83248d0;
            if (linearLayout != null) {
                if (G0()) {
                    i3 = 8;
                }
                linearLayout.setVisibility(i3);
            }
        }
    }

    private void Q0() {
        FeedCloudMeta$StReply feedCloudMeta$StReply = this.H;
        if (feedCloudMeta$StReply != null && this.F != null && this.f83256i != null && this.T != null && this.f83258m != null) {
            if (!feedCloudMeta$StReply.postUser.f398463id.get().equals(this.F.poster.f398463id.get())) {
                cm.d(getContext(), this.T, this.H.postUser.get());
                cm.c(this.U, this.H.postUser.get());
                this.f83258m.setVisibility(8);
            } else {
                J0();
                this.f83258m.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_comment_tag_author));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(cx.a(28.0f), cx.a(16.0f));
                layoutParams.leftMargin = cx.a(4.0f);
                layoutParams.gravity = 16;
                this.f83258m.setLayoutParams(layoutParams);
                this.f83258m.setVisibility(0);
                this.T.setVisibility(8);
                ImageView imageView = this.U;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            }
            this.f83256i.x0(12);
            this.C.setVisibility(8);
            FeedCloudMeta$StUser feedCloudMeta$StUser = this.H.targetUser;
            if (feedCloudMeta$StUser != null && !TextUtils.isEmpty(feedCloudMeta$StUser.f398463id.get())) {
                L0();
                this.f83258m.setImageDrawable(QFSQUIUtilsKt.f(getContext(), R.drawable.qvideo_skin_icon_general_play_solid_light, R.color.qui_common_icon_tertiary));
                this.f83258m.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_icon_general_play_solid_light));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cx.a(8.0f), cx.a(9.0f));
                layoutParams2.leftMargin = cx.a(4.0f);
                layoutParams2.rightMargin = cx.a(4.0f);
                layoutParams2.gravity = 16;
                this.f83258m.setLayoutParams(layoutParams2);
                this.f83258m.setVisibility(0);
                this.C.setUser(this.H.targetUser);
                this.C.setReportData(new QFSVipNickNameAndIconView.b().g(this.F).j(this.H).h(88));
                this.C.w0(" " + this.H.targetUser.nick.get());
                this.C.setVisibility(0);
                this.f83256i.x0(4);
            }
            this.f83256i.setUser(this.H.postUser);
            this.f83256i.setReportData(new QFSVipNickNameAndIconView.b().g(this.F).j(this.H).h(88));
            this.f83256i.w0(this.H.postUser.nick.get());
        }
    }

    private void S0(FeedCloudMeta$StReply feedCloudMeta$StReply) {
        if (feedCloudMeta$StReply == null) {
            QLog.d("QFSReplyItemView", 1, "streply is null");
            return;
        }
        String str = feedCloudMeta$StReply.expressionInfo.expressionURL.get();
        if (TextUtils.isEmpty(str)) {
            this.V.setVisibility(8);
            return;
        }
        int i3 = feedCloudMeta$StReply.expressionInfo.width.get();
        int i16 = feedCloudMeta$StReply.expressionInfo.height.get();
        if (i3 > 0 && i16 > 0) {
            int dpToPx = ViewUtils.dpToPx(117.0f);
            if (i3 >= i16) {
                i16 = (int) (((dpToPx * 1.0f) / i3) * i16);
                i3 = dpToPx;
            } else {
                i3 = (int) (((dpToPx * 1.0f) / i16) * i3);
                i16 = dpToPx;
            }
            ViewGroup.LayoutParams layoutParams = this.V.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i16;
            this.V.setLayoutParams(layoutParams);
        }
        QLog.d("QFSReplyItemView", 1, "[updateReplyEmoji] " + str + ", emojiSize: " + i3 + HippyTKDListViewAdapter.X + i16);
        this.V.setVisibility(0);
        Option obtain = Option.obtain();
        obtain.setTargetView(this.V).setUrl(str).setRequestWidth(i3).setRequestHeight(i16);
        QCircleFeedPicLoader.g().loadImage(obtain);
        feedCloudMeta$StReply.expressionInfo.expression_src.get();
    }

    private void q0() {
        if (this.S == null || this.W == null || this.f83257i0 > 300 || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_cmt_list_ui_fix_in_small_screen", true)) {
            return;
        }
        QLog.d("QFSReplyItemView", 4, "[adjustReplyItemLeftPadding] screenWidthDpi: " + this.f83257i0);
        int paddingLeft = this.S.getPaddingLeft();
        int paddingRight = this.S.getPaddingRight();
        int paddingBottom = this.S.getPaddingBottom();
        this.S.setPadding((paddingLeft - this.W.getWidth()) - DisplayUtil.dip2px(getContext(), 8.0f), this.S.getPaddingTop(), paddingRight, paddingBottom);
    }

    private void r0(final View view) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.QFSReplyItemView.5
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                int i16;
                ExposurePolicy exposurePolicy;
                String str;
                try {
                    if (QFSReplyItemView.this.H == null) {
                        return;
                    }
                    Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                    buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                    int i17 = 0;
                    if (QFSReplyItemView.this.H.typeFlag2.get() == 4) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_IF_BURN, Integer.valueOf(i3));
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CURRENT_LIKE_NUM, Integer.valueOf(QFSReplyItemView.this.H.likeInfo.count.get()));
                    buildElementParams.put("xsj_target_qq", QFSReplyItemView.this.H.postUser.f398463id.get());
                    if (QFSReplyItemView.this.F != null && QFSReplyItemView.this.F.poster != null) {
                        buildElementParams.put("xsj_feed_id", QFSReplyItemView.this.F.f398449id.get());
                        if (QFSReplyItemView.this.F.poster != null) {
                            str = QFSReplyItemView.this.F.poster.f398463id.get();
                        } else {
                            str = "";
                        }
                        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str);
                    }
                    buildElementParams.put("xsj_index", Integer.valueOf(QFSReplyItemView.this.f83249e + 1));
                    if (QFSReplyItemView.this.H.postUser.label.get() == 1) {
                        i16 = 1;
                    } else {
                        i16 = 0;
                    }
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_IF_GENGWANG, Integer.valueOf(i16));
                    if (QFSReplyItemView.this.H.postUser.is_e_da_xia.get()) {
                        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_USR_LOGO, QCircleDaTongConstant.ElementParamValue.XSJ_QQ_HERO);
                    }
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_REPLY, 1);
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_TYPE, QFSCommentReportHelper.p(QFSReplyItemView.this.H));
                    if (QFSReplyItemView.this.H.expressionInfo.expression_src.get() == 10002) {
                        i17 = 1;
                    }
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_COMMENT_ASSOCIATE_EMOJI, Integer.valueOf(i17));
                    VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_COMMENT);
                    VideoReport.setElementReuseIdentifier(view, QFSReplyItemView.this.H.f398460id.get());
                    VideoReport.setElementParams(view, buildElementParams);
                    VideoReport.setEventDynamicParams(view, new b(QFSReplyItemView.this));
                    View view2 = view;
                    if (QFSReplyItemView.this.E0()) {
                        exposurePolicy = ExposurePolicy.REPORT_NONE;
                    } else {
                        exposurePolicy = ExposurePolicy.REPORT_ALL;
                    }
                    VideoReport.setElementExposePolicy(view2, exposurePolicy);
                } catch (Exception e16) {
                    QLog.e("QFSReplyItemView", 1, e16.getMessage(), e16);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(QFSReplyItemInfo qFSReplyItemInfo, int i3) {
        P0(this.H);
        S0(this.H);
        com.tencent.biz.qqcircle.comment.wrapper.i iVar = this.f83244a0;
        if (iVar != null) {
            iVar.j(qFSReplyItemInfo, this.F, i3);
            this.f83244a0.S(this.G);
        }
        D0(qFSReplyItemInfo);
        B0(qFSReplyItemInfo);
        QFSCommentHelper.v(this.H.f398460id.get(), this.N, 200L);
    }

    private boolean v0() {
        QFSReplyItemInfo qFSReplyItemInfo = this.E;
        if (qFSReplyItemInfo != null && !qFSReplyItemInfo.isFolded()) {
            return true;
        }
        return false;
    }

    private void w0() {
        int i3;
        String str;
        if (this.F != null && this.H != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_feed_id", this.F.f398449id.get());
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            if (this.H.typeFlag2.get() == 4) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_IF_BURN, Integer.valueOf(i3));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, this.H.f398460id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CURRENT_AUTHOR_UIN, this.H.postUser.f398463id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_REPLY, 1);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f83249e));
            VideoReport.setElementId(this.N, "em_xsj_author_avatar");
            VideoReport.setElementReuseIdentifier(this.N, "em_xsj_author_avatar_" + this.H.hashCode());
            if (!TextUtils.isEmpty(this.H.postUser.iconDecorate.comment_url.get())) {
                str = "1";
            } else {
                str = "0";
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PENDANT_STATE, str);
            VideoReport.setElementParams(this.N, buildElementParams);
        }
    }

    private int x0() {
        ViewGroup viewGroup = this.f83254h;
        if (viewGroup != null && viewGroup.getWidth() > f83243k0) {
            return this.f83254h.getWidth() - f83243k0;
        }
        QLog.e("QFSReplyItemView", 1, "[getContentExactWidth] mHostRecyclerView width = 0.");
        return 0;
    }

    private void z0(SimpleBaseEvent simpleBaseEvent) {
        if (!(simpleBaseEvent instanceof QCirclePanelStateEvent) || ((QCirclePanelStateEvent) simpleBaseEvent).isShowing()) {
            return;
        }
        VideoReport.clearElementExposure(this.S, true);
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSCommentPraiseLayout.j
    public void g() {
        if (!G0()) {
            QLog.e(getLogTag(), 1, "[onFoldAnim] current is expand status");
            return;
        }
        if (this.f83248d0 != null && this.f83250e0 != null && this.f83253g0 != null) {
            int contentHeight = this.E.getContentHeight();
            if (contentHeight <= 0) {
                QLog.e(getLogTag(), 1, "[onExpandAnim] mContentHeight <= 0");
                return;
            }
            QLog.d(getLogTag(), 1, "[onExpandAnim] contentHeight:" + contentHeight);
            af.L(this.f83248d0, this.f83250e0, this.f83253g0, contentHeight);
            this.E.setFolded(false);
            return;
        }
        QLog.e(getLogTag(), 1, "[onExpandAnim] view is null");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleCommentPraiseUpdateEvent.class);
        arrayList.add(QCircleCommentUpdateEvent.class);
        arrayList.add(QCirclePanelStateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gqb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSReplyItemView";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.tencent.biz.qqcircle.comment.wrapper.i iVar = this.f83244a0;
        if (iVar != null) {
            iVar.E();
        }
        this.f83246c0.m();
        SimpleEventBus.getInstance().registerReceiver(this);
        r0(this.S);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.tencent.biz.qqcircle.comment.wrapper.i iVar = this.f83244a0;
        if (iVar != null) {
            iVar.F();
        }
        this.f83246c0.n();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        int id5 = view.getId();
        boolean z16 = false;
        if (id5 == R.id.i7s || id5 == R.id.f73103sn) {
            if (this.f83251f != null && v0()) {
                this.f83251f.onLongClick(view, 8, this.f83247d, new Object[]{this.G, this.H});
            }
            z16 = true;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        z0(simpleBaseEvent);
        A0(simpleBaseEvent);
        if ((simpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent) && (feedCloudMeta$StFeed = this.F) != null && this.G != null && this.H != null) {
            QCircleCommentPraiseUpdateEvent qCircleCommentPraiseUpdateEvent = (QCircleCommentPraiseUpdateEvent) simpleBaseEvent;
            if (TextUtils.equals(qCircleCommentPraiseUpdateEvent.mFeedId, feedCloudMeta$StFeed.f398449id.get()) && qCircleCommentPraiseUpdateEvent.mType == 2 && TextUtils.equals(qCircleCommentPraiseUpdateEvent.mCommentId, this.G.f398447id.get()) && TextUtils.equals(qCircleCommentPraiseUpdateEvent.mReplyId, this.H.f398460id.get())) {
                if (QCirclePluginUtil.isOwner(this.F.poster.get())) {
                    this.H.likeInfo.ownerStatus.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
                }
                this.H.likeInfo.status.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
                this.H.likeInfo.count.set(qCircleCommentPraiseUpdateEvent.mPraisedNum);
                P0(this.H);
            }
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSReplyItemInfo qFSReplyItemInfo, int i3) {
        QFSReplyItemView qFSReplyItemView;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.F;
        if (feedCloudMeta$StFeed != null && this.G != null && qFSReplyItemInfo != null && qFSReplyItemInfo.reply != null) {
            boolean isOwner = QCirclePluginUtil.isOwner(feedCloudMeta$StFeed.poster.get());
            QFSCommentGestureDetectLayout qFSCommentGestureDetectLayout = this.S;
            if (isOwner) {
                qFSReplyItemView = this;
            } else {
                qFSReplyItemView = null;
            }
            qFSCommentGestureDetectLayout.setOnLongClickListener(qFSReplyItemView);
            this.E = qFSReplyItemInfo;
            this.f83249e = i3;
            this.H = qFSReplyItemInfo.reply;
            O0();
            this.N.setUser(this.H.postUser, this.W);
            this.P.setText(com.tencent.biz.qqcircle.widgets.comment.b.d(this.H.createTime.get() * 1000));
            QFSCommentHelper.H0(this.Q, bh.d(this.H.storeExtInfo.get(), "qzone-user-area"));
            Q0();
            if (this.f83246c0.h(qFSReplyItemInfo, f83242j0)) {
                QLog.d("QFSReplyItemView", 1, "bindData return: showCommentKeywordHighlightView");
                this.f83246c0.p(new a(qFSReplyItemInfo, i3));
            } else {
                u0(qFSReplyItemInfo, i3);
                w0();
            }
        }
    }

    public void setHostRecyclerView(ViewGroup viewGroup) {
        this.f83254h = viewGroup;
    }

    public void setOnCommentElementClickListener(com.tencent.biz.qqcircle.widgets.comment.c cVar) {
        this.f83251f = cVar;
    }

    public void setPreData(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, int i3) {
        this.F = feedCloudMeta$StFeed;
        this.G = feedCloudMeta$StComment;
        this.f83247d = i3;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSCommentPraiseLayout.j
    public void w() {
        if (G0()) {
            QLog.e(getLogTag(), 1, "[onFoldAnim] current is fold status");
            return;
        }
        C0();
        LinearLayout linearLayout = this.f83248d0;
        if (linearLayout != null && this.f83250e0 != null && this.f83253g0 != null) {
            int height = linearLayout.getHeight();
            QLog.d(getLogTag(), 1, "[onFoldAnim] contentHeight:" + height);
            af.M(this.f83248d0, this.f83250e0, this.f83253g0, height);
            this.E.setContentHeight(height);
            this.E.setFolded(true);
            return;
        }
        QLog.e(getLogTag(), 1, "[onFoldAnim] view is null");
    }

    public FeedCloudMeta$StReply y0() {
        return this.H;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(QCircleReportBean qCircleReportBean) {
        super.setReportBean(qCircleReportBean);
        QFSCommentPraiseLayout qFSCommentPraiseLayout = this.M;
        if (qFSCommentPraiseLayout != null) {
            qFSCommentPraiseLayout.setReportBean(qCircleReportBean);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
