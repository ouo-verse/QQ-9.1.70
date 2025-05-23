package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QFSCommentReplyAdapter;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.beans.QFSReplyItemInfo;
import com.tencent.biz.qqcircle.comment.QFSCommentDefaultItemView;
import com.tencent.biz.qqcircle.comment.effect.QFSCommentKeywordHighlightViewController;
import com.tencent.biz.qqcircle.comment.widget.QFSCommentGestureDetectLayout;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QCircleResetCommentBlockEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSAvatarApertureFeedExposeEvent;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.utils.cm;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QFSCommentPraiseLayout;
import com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QFSVipNickNameAndIconView;
import com.tencent.biz.qqcircle.widgets.comment.QFSFastReplyPanelLayout;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qcircle.api.global.QCircleUserLabelConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.text.rich.parser.RichTextSearchKeywordParser;
import com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$ExpressionInfo;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$goodsInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentDefaultItemView extends QFSCommentBaseItemView implements View.OnLongClickListener, SimpleEventReceiver, com.tencent.biz.qqcircle.comment.animation.a, QFSCommentPraiseLayout.j {

    /* renamed from: p0, reason: collision with root package name */
    private static final List<Integer> f83171p0 = Arrays.asList(Integer.valueOf(R.id.a39));

    /* renamed from: q0, reason: collision with root package name */
    private static int f83172q0 = ViewUtils.dpToPx(30.0f);

    /* renamed from: r0, reason: collision with root package name */
    private static int f83173r0 = ViewUtils.dpToPx(32.0f);

    /* renamed from: s0, reason: collision with root package name */
    private static int f83174s0 = ViewUtils.dpToPx(52.0f);

    /* renamed from: t0, reason: collision with root package name */
    private static int f83175t0 = ViewUtils.dpToPx(75.0f);

    /* renamed from: u0, reason: collision with root package name */
    private static String f83176u0;
    private int G;
    private ViewGroup H;
    private QFSCommentGestureDetectLayout I;
    private QFSVipNickNameAndIconView J;
    private ImageView K;
    private ImageView L;
    private ImageView M;
    private QFSExpandableAsyncTextView N;
    private FeedCloudMeta$StFeed P;
    private QFSCommentItemInfo Q;
    private FeedCloudMeta$StComment R;
    private TextView S;
    private QFSCommentPraiseLayout T;
    private LinearLayout U;
    private RecyclerView V;
    private QFSFastReplyPanelLayout W;

    /* renamed from: a0, reason: collision with root package name */
    private QFSCommentReplyAdapter f83177a0;

    /* renamed from: b0, reason: collision with root package name */
    private ImageView f83178b0;

    /* renamed from: c0, reason: collision with root package name */
    private ImageView f83179c0;

    /* renamed from: d0, reason: collision with root package name */
    private ImageView f83180d0;

    /* renamed from: e0, reason: collision with root package name */
    private LinearLayout f83181e0;

    /* renamed from: f0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.comment.wrapper.a f83182f0;

    /* renamed from: g0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.comment.wrapper.c f83183g0;

    /* renamed from: h0, reason: collision with root package name */
    private LinearLayout f83184h0;

    /* renamed from: i0, reason: collision with root package name */
    private LinearLayout f83185i0;

    /* renamed from: j0, reason: collision with root package name */
    private FrameLayout f83186j0;

    /* renamed from: k0, reason: collision with root package name */
    private LinearLayout f83187k0;

    /* renamed from: l0, reason: collision with root package name */
    private QFSCommentKeywordHighlightViewController f83188l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f83189m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f83190n0;

    /* renamed from: o0, reason: collision with root package name */
    private r20.a f83191o0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.comment.QFSCommentDefaultItemView$8, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f() {
            uq3.k.a().j("qfs_key_has_show_comment_panel_edaxia_tips", true);
        }

        @Override // java.lang.Runnable
        public void run() {
            mc0.a.d(QFSCommentDefaultItemView.this.getContext(), ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_daxia_guide_long_press_comment_tips", com.tencent.biz.qqcircle.utils.h.a(R.string.f189083yf))).setPosition(0).setAlignment(0).setAnchor(QFSCommentDefaultItemView.this.f83181e0).setDismissInterval(4000L).addStatusCallback(new RFWSmartPopupWindow.IStatusCallback() { // from class: com.tencent.biz.qqcircle.comment.k
                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public /* synthetic */ void onClick(View view) {
                    a04.d.a(this, view);
                }

                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public /* synthetic */ void onDismiss() {
                    a04.d.b(this);
                }

                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public final void onShow() {
                    QFSCommentDefaultItemView.AnonymousClass8.f();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSCommentKeywordHighlightViewController.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSCommentItemInfo f83192a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f83193b;

        a(QFSCommentItemInfo qFSCommentItemInfo, int i3) {
            this.f83192a = qFSCommentItemInfo;
            this.f83193b = i3;
        }

        @Override // com.tencent.biz.qqcircle.comment.effect.QFSCommentKeywordHighlightViewController.c
        public void onComplete() {
            QFSCommentDefaultItemView.this.G0(this.f83192a, this.f83193b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements OnPromiseRejected {
        b() {
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
        public void onFail(String str) {
            QLog.e(QFSCommentDefaultItemView.this.getLogTag(), 1, new RuntimeException("[getCommentPartIoc]  error = " + str), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements OnPromiseResolved<r20.a> {
        c() {
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onDone(r20.a aVar) {
            if (aVar != null) {
                QFSCommentDefaultItemView.this.q1(aVar.getCommentInfo());
                QFSCommentDefaultItemView.this.f83191o0 = aVar;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class d implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSCommentDefaultItemView> f83197a;

        public d(QFSCommentDefaultItemView qFSCommentDefaultItemView) {
            this.f83197a = new WeakReference<>(qFSCommentDefaultItemView);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            String str2;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            QFSCommentDefaultItemView qFSCommentDefaultItemView = this.f83197a.get();
            if (qFSCommentDefaultItemView != null) {
                if (qFSCommentDefaultItemView.R != null) {
                    str2 = qFSCommentDefaultItemView.R.f398447id.get();
                } else {
                    str2 = "";
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, str2);
                String N0 = qFSCommentDefaultItemView.N0();
                if (!TextUtils.isEmpty(N0)) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_LOGO, N0);
                }
            }
            return buildElementParams;
        }
    }

    public QFSCommentDefaultItemView(@NonNull Context context) {
        super(context);
        this.f83189m0 = true;
        this.f83190n0 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_set_middle_cmt_expand_btn", true);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(QFSCommentItemInfo qFSCommentItemInfo, int i3) {
        v1(this.R);
        w1();
        a1(qFSCommentItemInfo);
        Y0(qFSCommentItemInfo);
        c1(this.R.expressionInfo);
        com.tencent.biz.qqcircle.comment.wrapper.a aVar = this.f83182f0;
        if (aVar != null) {
            aVar.j(qFSCommentItemInfo, this.P, i3);
        }
        e1(qFSCommentItemInfo);
        s1();
        H0(this.I, this.Q, i3);
        QFSCommentHelper.v(this.R.f398447id.get(), this.f83163d, 0L);
    }

    private boolean I0() {
        QFSCommentItemInfo qFSCommentItemInfo;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.P;
        if (feedCloudMeta$StFeed != null && QCirclePluginUtil.isOwner(feedCloudMeta$StFeed.poster.get()) && (qFSCommentItemInfo = this.Q) != null && !qFSCommentItemInfo.isFolded()) {
            return true;
        }
        return false;
    }

    private boolean J0(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        r20.a aVar;
        if (this.G != 0 || feedCloudMeta$StComment == null || !QFSCommentHelper.V(feedCloudMeta$StComment.typeFlag2.get(), 4) || (aVar = (r20.a) RFWIocAbilityProvider.g().getIocInterface(r20.a.class, this, null)) == null || aVar.getCommentInfo() == null || !TextUtils.equals(aVar.getCommentInfo().mHotCommentId, feedCloudMeta$StComment.f398447id.get())) {
            return false;
        }
        return true;
    }

    private void K0() {
        String str;
        QFSCommentItemInfo qFSCommentItemInfo = this.Q;
        if (qFSCommentItemInfo == null) {
            return;
        }
        Map<String, Object> O0 = O0(qFSCommentItemInfo);
        VideoReport.setElementId(this.f83163d, "em_xsj_author_avatar");
        VideoReport.setElementReuseIdentifier(this.f83163d, "em_xsj_author_avatar_" + this.Q.hashCode());
        if (!TextUtils.isEmpty(this.R.postUser.iconDecorate.comment_url.get())) {
            str = "1";
        } else {
            str = "0";
        }
        O0.put(QCircleDaTongConstant.ElementParamKey.XSJ_PENDANT_STATE, str);
        O0.put("xsj_tab_name", "\u8bc4\u8bba");
        VideoReport.setElementParams(this.f83163d, O0);
    }

    private int M0() {
        ViewGroup viewGroup = this.H;
        if (viewGroup != null && viewGroup.getWidth() > f83175t0) {
            return this.H.getWidth() - f83175t0;
        }
        QLog.e("QCircleCommentItemView", 1, "[getContentExactWidth] mHostRecyclerView width = 0.");
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String N0() {
        StringBuilder sb5 = new StringBuilder();
        if (this.R.typeFlag.get() == 1) {
            sb5.append(QCircleDaTongConstant.ElementParamValue.AUTHOR_TOP);
        }
        if (this.R.likeInfo.ownerStatus.get() == 1) {
            if (sb5.length() > 0) {
                sb5.append(",");
            }
            sb5.append(QCircleDaTongConstant.ElementParamValue.AUTHOR_LIKE);
        }
        return sb5.toString();
    }

    @NonNull
    private Map<String, Object> O0(QFSCommentItemInfo qFSCommentItemInfo) {
        int i3;
        int i16;
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        int i17 = 0;
        if (qFSCommentItemInfo.comment.typeFlag2.get() == 4) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_IF_BURN, Integer.valueOf(i3));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CURRENT_LIKE_NUM, Integer.valueOf(qFSCommentItemInfo.comment.likeInfo.count.get()));
        buildElementParams.put("xsj_target_qq", qFSCommentItemInfo.comment.postUser.f398463id.get());
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.P;
        if (feedCloudMeta$StFeed != null) {
            buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
            FeedCloudMeta$StUser feedCloudMeta$StUser = this.P.poster;
            if (feedCloudMeta$StUser != null) {
                str = feedCloudMeta$StUser.f398463id.get();
            } else {
                str = "";
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str);
        }
        buildElementParams.put("xsj_index", Integer.valueOf(this.G + 1));
        if (qFSCommentItemInfo.comment.postUser.label.get() == 1) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_IF_GENGWANG, Integer.valueOf(i16));
        if (qFSCommentItemInfo.comment.postUser.is_e_da_xia.get()) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_USR_LOGO, QCircleDaTongConstant.ElementParamValue.XSJ_QQ_HERO);
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_REPLY, 0);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.G));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_TYPE, QFSCommentReportHelper.o(qFSCommentItemInfo.comment.get()));
        buildElementParams.put("xsj_query_text", RichTextSearchKeywordParser.generateAllSearchKeyword(qFSCommentItemInfo.comment.content.get()));
        if (qFSCommentItemInfo.comment.expressionInfo.expression_src.get() == 10002) {
            i17 = 1;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_COMMENT_ASSOCIATE_EMOJI, Integer.valueOf(i17));
        FeedCloudMeta$goodsInfo feedCloudMeta$goodsInfo = qFSCommentItemInfo.comment.goodsInfo;
        if (feedCloudMeta$goodsInfo.has()) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_BUSINESS_RECALL_CHANNEL, Integer.valueOf(feedCloudMeta$goodsInfo.goodsType.get()));
            buildElementParams.put("xsj_business_ad_id", feedCloudMeta$goodsInfo.goodsID.get());
        }
        return buildElementParams;
    }

    private Drawable P0() {
        Drawable drawable = getResources().getDrawable(R.drawable.f162035nq0);
        drawable.setBounds(ImmersiveUtils.dpToPx(2.5f), ImmersiveUtils.dpToPx(0.0f), ImmersiveUtils.dpToPx(33.75f), ImmersiveUtils.dpToPx(18.0f));
        return drawable;
    }

    private Drawable Q0() {
        Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(getContext(), R.drawable.qvideo_skin_icon_comment_top);
        drawable.setBounds(ImmersiveUtils.dpToPx(4.0f), 0, ImmersiveUtils.dpToPx(34.0f), ImmersiveUtils.dpToPx(16.0f));
        return drawable;
    }

    private Drawable S0() {
        Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(getContext(), R.drawable.qvideo_skin_comment_tag_authorlike);
        drawable.setBounds(ImmersiveUtils.dpToPx(4.0f), 0, ImmersiveUtils.dpToPx(55.5f), ImmersiveUtils.dpToPx(16.0f));
        return drawable;
    }

    private Drawable U0() {
        Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(getContext(), R.drawable.qvideo_skin_comment_tag_top);
        drawable.setBounds(ImmersiveUtils.dpToPx(4.0f), 0, ImmersiveUtils.dpToPx(34.0f), ImmersiveUtils.dpToPx(16.0f));
        return drawable;
    }

    private void V0(SimpleBaseEvent simpleBaseEvent) {
        if (!(simpleBaseEvent instanceof QFSAvatarApertureFeedExposeEvent)) {
            return;
        }
        QFSAvatarApertureFeedExposeEvent qFSAvatarApertureFeedExposeEvent = (QFSAvatarApertureFeedExposeEvent) simpleBaseEvent;
        if (this.R != null && !TextUtils.equals(qFSAvatarApertureFeedExposeEvent.getUin(), this.R.postUser.f398463id.get())) {
            return;
        }
        o0(qFSAvatarApertureFeedExposeEvent.getFeed());
    }

    private void W0(SimpleBaseEvent simpleBaseEvent) {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        ExposurePolicy exposurePolicy;
        if ((simpleBaseEvent instanceof QCircleCommentUpdateEvent) && this.R != null) {
            QCircleCommentUpdateEvent qCircleCommentUpdateEvent = (QCircleCommentUpdateEvent) simpleBaseEvent;
            if (qCircleCommentUpdateEvent.eventStatus == 5) {
                x1();
            }
            if (qCircleCommentUpdateEvent.eventStatus != 3 || (feedCloudMeta$StComment = qCircleCommentUpdateEvent.comment) == null || !TextUtils.equals(feedCloudMeta$StComment.f398447id.get(), this.R.f398447id.get())) {
                return;
            }
            this.f83185i0.setVisibility(0);
            VideoReport.setElementReuseIdentifier(this.I, this.R.f398447id.get());
            QFSCommentGestureDetectLayout qFSCommentGestureDetectLayout = this.I;
            if (g1()) {
                exposurePolicy = ExposurePolicy.REPORT_NONE;
            } else {
                exposurePolicy = ExposurePolicy.REPORT_ALL;
            }
            VideoReport.setElementExposePolicy(qFSCommentGestureDetectLayout, exposurePolicy);
        }
    }

    private void X0(SimpleBaseEvent simpleBaseEvent) {
        if (!(simpleBaseEvent instanceof QCirclePanelStateEvent) || ((QCirclePanelStateEvent) simpleBaseEvent).isShowing()) {
            return;
        }
        VideoReport.clearElementExposure(this.I, true);
    }

    private void Y0(QFSCommentItemInfo qFSCommentItemInfo) {
        if (qFSCommentItemInfo.mNeedDoCommentPraise) {
            qFSCommentItemInfo.mNeedDoCommentPraise = false;
            postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.i
                @Override // java.lang.Runnable
                public final void run() {
                    QFSCommentDefaultItemView.this.k1();
                }
            }, 500L);
        }
    }

    private void Z0(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleResetCommentBlockEvent) {
            f83176u0 = "";
        }
    }

    private void a1(QFSCommentItemInfo qFSCommentItemInfo) {
        if (!qFSCommentItemInfo.mNeedTopAnimation) {
            return;
        }
        QFSCommentHelper.x0(this.I);
        qFSCommentItemInfo.mNeedTopAnimation = false;
    }

    private void d1() {
        LinearLayout s16;
        if (this.f83187k0 == null && this.f83186j0 != null && (s16 = af.s(getContext())) != null && (this.f83186j0 instanceof FrameLayout)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ViewUtils.dip2px(20.0f));
            layoutParams.gravity = 16;
            this.f83186j0.addView(s16, layoutParams);
            this.f83187k0 = s16;
        }
    }

    private boolean f1() {
        QFSCommentItemInfo qFSCommentItemInfo = this.Q;
        if (qFSCommentItemInfo != null && qFSCommentItemInfo.isFolded()) {
            return true;
        }
        return false;
    }

    private boolean g1() {
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.R;
        if (feedCloudMeta$StComment != null && feedCloudMeta$StComment.f398447id.get().startsWith("fake")) {
            return true;
        }
        return false;
    }

    private boolean h1() {
        QFSFastReplyPanelLayout qFSFastReplyPanelLayout = this.W;
        if (qFSFastReplyPanelLayout == null || qFSFastReplyPanelLayout.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private boolean i1() {
        boolean z16;
        boolean z17;
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.R;
        if (feedCloudMeta$StComment == null) {
            return false;
        }
        if (feedCloudMeta$StComment.typeFlag.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean V = QFSCommentHelper.V(this.R.typeFlag2.get(), 4);
        if (this.R.likeInfo.ownerStatus.get() == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.i("QCircleCommentItemView", 4, "[isNeedShowCollapse] isTop|isHot|isOwnerPraise: " + z16 + "|" + V + "|" + z17);
        if (z16 || V || z17) {
            return false;
        }
        return true;
    }

    private void initView() {
        this.I = (QFSCommentGestureDetectLayout) findViewById(R.id.b3r);
        this.U = (LinearLayout) findViewById(R.id.f73103sn);
        this.J = (QFSVipNickNameAndIconView) findViewById(R.id.fxo);
        this.K = (ImageView) findViewById(R.id.f494222n);
        this.L = (ImageView) findViewById(R.id.yce);
        this.M = (ImageView) findViewById(R.id.f3702165);
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView = (QFSExpandableAsyncTextView) findViewById(R.id.fxm);
        this.N = qFSExpandableAsyncTextView;
        qFSExpandableAsyncTextView.setSpecialClickAreaColor(R.color.qui_common_text_link);
        this.N.setExpandTextColor(R.color.qui_common_text_secondary_light);
        this.N.setCollapseTextColor(R.color.qui_common_text_secondary_light);
        TextView textView = (TextView) findViewById(R.id.mdq);
        this.S = textView;
        textView.setVisibility(8);
        QFSCommentPraiseLayout qFSCommentPraiseLayout = (QFSCommentPraiseLayout) findViewById(R.id.f26700e9);
        this.T = qFSCommentPraiseLayout;
        qFSCommentPraiseLayout.setDisLikeAnimListener(this);
        this.T.setVisibility(8);
        this.V = (RecyclerView) findViewById(R.id.f73223sz);
        this.f83178b0 = (ImageView) findViewById(R.id.f165940y54);
        this.f83181e0 = (LinearLayout) findViewById(R.id.u1p);
        this.f83180d0 = (ImageView) findViewById(R.id.f87184to);
        this.f83184h0 = (LinearLayout) findViewById(R.id.f353411l);
        this.f83185i0 = (LinearLayout) findViewById(R.id.f353211j);
        this.f83186j0 = (FrameLayout) findViewById(R.id.f353011h);
        this.f83182f0 = new com.tencent.biz.qqcircle.comment.wrapper.a(this);
        this.f83183g0 = new com.tencent.biz.qqcircle.comment.wrapper.c(this);
        this.f83188l0 = new QFSCommentKeywordHighlightViewController(this);
        this.I.setEnableDoubleClick(false);
    }

    private boolean j1() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.P;
        if (feedCloudMeta$StFeed != null && TextUtils.equals(f83176u0, feedCloudMeta$StFeed.f398449id.get())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k1() {
        this.T.R(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean l1(View view) {
        boolean a16 = ud2.a.f438849a.a();
        com.tencent.biz.qqcircle.widgets.comment.c cVar = this.D;
        if (cVar != null && a16) {
            cVar.onLongClick(view, 23, this.G, this.R);
            return true;
        }
        QLog.d("QCircleCommentItemView", 1, "[initPicView] listener=" + this.D + ", canFavEmoji: " + a16);
        return false;
    }

    private String m1(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("\\")) {
            return str.replaceAll("^\\s+|\\s+$", "");
        }
        return str;
    }

    private void o1() {
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView = this.N;
        if (qFSExpandableAsyncTextView != null && qFSExpandableAsyncTextView.getLayoutParams() != null) {
            this.N.getLayoutParams().height = -2;
            QFSCommentItemInfo qFSCommentItemInfo = this.Q;
            if (qFSCommentItemInfo != null) {
                this.N.setExpanded(qFSCommentItemInfo.mDefaultExpanded);
            }
            boolean i16 = i1();
            this.N.setShowCollapse(i16);
            if (!i16) {
                this.N.setExpanded(true);
            }
            if (this.f83190n0) {
                this.N.setLastLineWidthRatio(0.5f);
            }
            this.N.setExactWidth(M0());
        }
    }

    private void p1(boolean z16) {
        if (z16) {
            d1();
            LinearLayout linearLayout = this.f83187k0;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = this.f83187k0;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(QFSCommentInfo qFSCommentInfo) {
        if (qFSCommentInfo != null && qFSCommentInfo.mActionBean != null) {
            if (!QCircleUserLabelConfig.INSTANCE.getIsEDaxia()) {
                QLog.e(getLogTag(), 1, "showDaxiaCommentTips not e da xia");
                return;
            }
            if (uq3.k.a().c("qfs_key_has_show_comment_panel_edaxia_tips", false)) {
                QLog.e(getLogTag(), 1, "showDaxiaCommentTips have show");
                return;
            }
            LinearLayout linearLayout = this.f83181e0;
            if (linearLayout == null) {
                return;
            }
            linearLayout.post(new AnonymousClass8());
        }
    }

    private void r1() {
        QFSFastReplyPanelLayout qFSFastReplyPanelLayout = this.W;
        if (qFSFastReplyPanelLayout != null) {
            qFSFastReplyPanelLayout.h(this.P, this.R);
            this.U.setVisibility(0);
            QLog.d("QCircleCommentItemView", 1, "[showFastReplyPanel] has inflate view stub. ");
            return;
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.f373316z);
        if (viewStub == null) {
            QLog.e("QCircleCommentItemView", 1, "[showFastReplyPanel] can't find view stub. ");
            return;
        }
        View inflate = viewStub.inflate();
        if (!(inflate instanceof QFSFastReplyPanelLayout)) {
            QLog.e("QCircleCommentItemView", 1, "[showFastReplyPanel] container is not QFSFastReplyPanelLayout. ");
            return;
        }
        QFSFastReplyPanelLayout qFSFastReplyPanelLayout2 = (QFSFastReplyPanelLayout) inflate;
        this.W = qFSFastReplyPanelLayout2;
        qFSFastReplyPanelLayout2.e(this);
        QLog.d("QCircleCommentItemView", 1, "[showFastReplyPanel] showFastReplyPanel ");
        this.W.h(this.P, this.R);
        this.U.setVisibility(0);
    }

    private void s1() {
        if (this.G != 0) {
            return;
        }
        r20.a aVar = this.f83191o0;
        if (aVar != null) {
            q1(aVar.getCommentInfo());
        } else {
            RFWIocAbilityProvider.g().getIoc(r20.a.class).originView(this).done(new c()).fail(new b()).run();
        }
    }

    private void t1() {
        int i3;
        if (this.R != null && this.f83185i0 != null) {
            boolean f16 = f1();
            LinearLayout linearLayout = this.f83185i0;
            if (!QFSCommentHelper.c0(this.R.f398447id.get()) && !f16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            linearLayout.setVisibility(i3);
            p1(f16);
        }
    }

    private void u1(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        Drawable drawable;
        boolean z16;
        if (feedCloudMeta$StComment != null && feedCloudMeta$StComment.content.get() != null) {
            o1();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(m1(feedCloudMeta$StComment.content.get()));
            int i3 = 0;
            if (J0(feedCloudMeta$StComment)) {
                QLog.d("QCircleCommentItemView", 1, "canShowHotCommentFirst is true");
                drawable = P0();
                this.f83180d0.getLayoutParams().width = f83173r0;
                n1(9, 1);
            } else if (feedCloudMeta$StComment.typeFlag.get() == 1) {
                if (QFSCommentHelper.L().b0()) {
                    drawable = Q0();
                } else {
                    drawable = U0();
                }
                this.f83180d0.getLayoutParams().width = f83172q0;
            } else if (QFSCommentHelper.V(feedCloudMeta$StComment.typeFlag2.get(), 4)) {
                drawable = P0();
                this.f83180d0.getLayoutParams().width = f83173r0;
                n1(9, 1);
            } else if (feedCloudMeta$StComment.likeInfo.ownerStatus.get() == 1) {
                drawable = S0();
                this.f83180d0.getLayoutParams().width = f83174s0;
            } else {
                this.N.showEllipseEndImageSpan(false);
                drawable = null;
            }
            if (drawable != null) {
                QCircleAsyncTextView.e(spannableStringBuilder, spannableStringBuilder.length(), drawable);
                this.N.showEllipseEndImageSpan(true);
            }
            this.N.setText(spannableStringBuilder);
            this.N.setClickable(false);
            this.N.setLongClickable(false);
            if (TextUtils.isEmpty(spannableStringBuilder)) {
                Object[] objArr = new Object[1];
                if (("empty content + " + drawable) == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                objArr[0] = Boolean.valueOf(z16);
                QLog.d("QCircleCommentItemView", 1, objArr);
                this.N.setVisibility(8);
                if (drawable != null) {
                    this.f83180d0.setVisibility(0);
                    this.f83180d0.setImageDrawable(drawable);
                } else {
                    this.f83180d0.setVisibility(8);
                }
            } else {
                this.N.setVisibility(0);
                this.f83180d0.setVisibility(8);
            }
            LinearLayout linearLayout = this.f83184h0;
            if (linearLayout != null) {
                if (f1()) {
                    i3 = 8;
                }
                linearLayout.setVisibility(i3);
            }
        }
    }

    private void v1(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (QFSCommentHelper.V(feedCloudMeta$StComment.typeFlag2.get(), 8)) {
            this.f83178b0.setVisibility(0);
        } else {
            this.f83178b0.setVisibility(4);
        }
    }

    private void w1() {
        QFSVipNickNameAndIconView qFSVipNickNameAndIconView;
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.R;
        if (feedCloudMeta$StComment != null && this.P != null && (qFSVipNickNameAndIconView = this.J) != null && this.L != null) {
            qFSVipNickNameAndIconView.setUser(feedCloudMeta$StComment.postUser);
            this.J.setReportData(new QFSVipNickNameAndIconView.b().f(this.R).g(this.P).h(88));
            if (!this.R.postUser.f398463id.get().equals(this.P.poster.f398463id.get())) {
                this.J.w0(this.R.postUser.nick.get());
                cm.d(getContext(), this.L, this.R.postUser.get());
                cm.c(this.M, this.R.postUser.get());
                this.K.setVisibility(8);
                return;
            }
            this.K.setVisibility(0);
            this.J.w0(this.R.postUser.nick.get());
            this.L.setVisibility(8);
            ImageView imageView = this.M;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    private void x1() {
        if (!j1() || af.x()) {
            b1();
        }
        if (af.y(this.R)) {
            if (!h1()) {
                r1();
            }
        } else if (h1()) {
            b1();
        }
        List<QFSReplyItemInfo> list = this.Q.replyItemList;
        if (list != null && list.size() != 0 && this.f83189m0) {
            this.U.setVisibility(0);
            this.V.setVisibility(0);
            if (this.f83177a0 == null) {
                QFSCommentReplyAdapter qFSCommentReplyAdapter = new QFSCommentReplyAdapter();
                this.f83177a0 = qFSCommentReplyAdapter;
                qFSCommentReplyAdapter.setReportBean(getReportBean());
                this.V.setAdapter(this.f83177a0);
            }
            this.f83177a0.r0(this.P, this.R, this.Q.replyItemList, this.G);
            this.f83177a0.s0(this.D);
            this.f83177a0.m0();
            return;
        }
        this.V.setVisibility(8);
    }

    public void H0(View view, QFSCommentItemInfo qFSCommentItemInfo, int i3) {
        ExposurePolicy exposurePolicy;
        try {
            Map<String, Object> O0 = O0(qFSCommentItemInfo);
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_COMMENT);
            VideoReport.setElementReuseIdentifier(view, qFSCommentItemInfo.comment.f398447id.get());
            if (this.R.goodsInfo.has()) {
                VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_COMMENT_GOODS_LINK);
            }
            if (g1()) {
                exposurePolicy = ExposurePolicy.REPORT_NONE;
            } else {
                exposurePolicy = ExposurePolicy.REPORT_ALL;
            }
            VideoReport.setElementExposePolicy(view, exposurePolicy);
            VideoReport.setElementParams(view, O0);
            VideoReport.setEventDynamicParams(view, new d(this));
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("QCircleCommentItemView", 1, e16.getMessage());
        }
    }

    public FeedCloudMeta$StComment L0() {
        return this.R;
    }

    public RecyclerView T0() {
        return this.V;
    }

    public void b1() {
        QFSFastReplyPanelLayout qFSFastReplyPanelLayout = this.W;
        if (qFSFastReplyPanelLayout == null) {
            return;
        }
        qFSFastReplyPanelLayout.d(this.R);
        af.J("");
        af.I(false);
    }

    public void c1(FeedCloudMeta$ExpressionInfo feedCloudMeta$ExpressionInfo) {
        String str = feedCloudMeta$ExpressionInfo.expressionURL.get();
        this.f83179c0 = (ImageView) findViewById(R.id.f370916b);
        if (TextUtils.isEmpty(str)) {
            this.f83179c0.setVisibility(8);
            return;
        }
        this.f83179c0.setVisibility(0);
        int i3 = feedCloudMeta$ExpressionInfo.width.get();
        int i16 = feedCloudMeta$ExpressionInfo.height.get();
        if (i3 > 0 && i16 > 0) {
            int dpToPx = ViewUtils.dpToPx(117.0f);
            if (i3 >= i16) {
                i16 = (int) (((dpToPx * 1.0f) / i3) * i16);
                i3 = dpToPx;
            } else {
                i3 = (int) (((dpToPx * 1.0f) / i16) * i3);
                i16 = dpToPx;
            }
            ViewGroup.LayoutParams layoutParams = this.f83179c0.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i16;
            this.f83179c0.setLayoutParams(layoutParams);
        }
        QLog.d("QCircleCommentItemView", 1, "[initEmojiView] emojiUrl=" + str + ", emojiSize: " + i3 + HippyTKDListViewAdapter.X + i16);
        Option obtain = Option.obtain();
        obtain.setTargetView(this.f83179c0).setUrl(str).setRequestWidth(i3).setRequestHeight(i16);
        QCircleFeedPicLoader.g().loadImage(obtain);
        feedCloudMeta$ExpressionInfo.expression_src.get();
    }

    public void e1(QFSCommentItemInfo qFSCommentItemInfo) {
        com.tencent.biz.qqcircle.comment.wrapper.c cVar = this.f83183g0;
        if (cVar == null) {
            return;
        }
        cVar.e(qFSCommentItemInfo, this.P);
        ImageFilterView i3 = this.f83183g0.i();
        if (i3 == null) {
            return;
        }
        i3.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.biz.qqcircle.comment.j
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean l16;
                l16 = QFSCommentDefaultItemView.this.l1(view);
                return l16;
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSCommentPraiseLayout.j
    public void g() {
        if (!f1()) {
            QLog.e(getLogTag(), 1, "[onExpandAnim] current is expand status");
            return;
        }
        if (this.f83184h0 != null && this.f83185i0 != null && this.f83187k0 != null) {
            int contentHeight = this.Q.getContentHeight();
            if (contentHeight <= 0) {
                QLog.e(getLogTag(), 1, "[onExpandAnim] mContentHeight <= 0");
                return;
            }
            QLog.d(getLogTag(), 1, "[onExpandAnim] contentHeight:" + contentHeight);
            af.L(this.f83184h0, this.f83185i0, this.f83187k0, contentHeight);
            this.Q.setFolded(false);
            return;
        }
        QLog.e(getLogTag(), 1, "[onExpandAnim] view is null");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleCommentPraiseUpdateEvent.class);
        arrayList.add(QCircleResetCommentBlockEvent.class);
        arrayList.add(QCircleCommentUpdateEvent.class);
        arrayList.add(QFSAvatarApertureFeedExposeEvent.class);
        arrayList.add(QCirclePanelStateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g9r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.comment.QFSCommentBaseItemView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleCommentItemView";
    }

    @Override // com.tencent.biz.qqcircle.comment.animation.a
    @NonNull
    public RecyclerView i() {
        return this.V;
    }

    @Override // com.tencent.biz.qqcircle.comment.QFSCommentBaseItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(QFSCommentItemInfo qFSCommentItemInfo, int i3) {
        QFSCommentDefaultItemView qFSCommentDefaultItemView;
        super.bindData(qFSCommentItemInfo, i3);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.P;
        if (feedCloudMeta$StFeed != null && qFSCommentItemInfo != null && qFSCommentItemInfo.comment != null) {
            boolean isOwner = QCirclePluginUtil.isOwner(feedCloudMeta$StFeed.poster.get());
            QFSCommentGestureDetectLayout qFSCommentGestureDetectLayout = this.I;
            if (isOwner) {
                qFSCommentDefaultItemView = this;
            } else {
                qFSCommentDefaultItemView = null;
            }
            qFSCommentGestureDetectLayout.setOnLongClickListener(qFSCommentDefaultItemView);
            this.G = i3;
            this.Q = qFSCommentItemInfo;
            this.R = qFSCommentItemInfo.comment;
            t1();
            w0(this.R.postUser);
            K0();
            x0(this.R.createTime.get());
            QFSCommentHelper.H0(this.f83168m, bh.d(this.R.storeExtInfo.get(), "qzone-user-area"));
            x1();
            u1(this.R);
            f83176u0 = this.P.f398449id.get();
            if (this.f83188l0.h(qFSCommentItemInfo, f83171p0)) {
                QLog.d("QCircleCommentItemView", 1, "bindData return: showCommentKeywordHighlightView ");
                this.f83188l0.p(new a(qFSCommentItemInfo, i3));
            } else {
                G0(qFSCommentItemInfo, i3);
            }
        }
    }

    public void n1(int i3, int i16) {
        QCircleExtraTypeInfo qCircleExtraTypeInfo;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        int i17;
        PBBytesField pBBytesField;
        byte[] bArr = null;
        if (getExtraTypeInfo() instanceof QCircleExtraTypeInfo) {
            qCircleExtraTypeInfo = (QCircleExtraTypeInfo) getExtraTypeInfo();
            feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed;
        } else {
            qCircleExtraTypeInfo = null;
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed != null && (pBBytesField = feedCloudMeta$StFeed.busiReport) != null && pBBytesField.has() && feedCloudMeta$StFeed.busiReport.get() != null) {
            bArr = feedCloudMeta$StFeed.busiReport.get().toByteArray();
        }
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        QCircleLpReportDc05501.DataBuilder toUin = ua0.c.a(feedCloudMeta$StFeed).setActionType(i3).setSubActionType(i16).setToUin(feedCloudMeta$StFeed.poster.f398463id.get());
        if (qCircleExtraTypeInfo != null) {
            i17 = qCircleExtraTypeInfo.mDataPosition;
        } else {
            i17 = -1;
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i17).setPageId(getPageId())).setReportInfo(bArr));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.tencent.biz.qqcircle.comment.wrapper.a aVar = this.f83182f0;
        if (aVar != null) {
            aVar.E();
        }
        this.f83188l0.m();
        SimpleEventBus.getInstance().registerReceiver(this);
        RFWIocAbilityProvider.g().registerIoc(this.V, this, com.tencent.biz.qqcircle.comment.animation.a.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.tencent.biz.qqcircle.comment.wrapper.a aVar = this.f83182f0;
        if (aVar != null) {
            aVar.F();
        }
        this.f83188l0.n();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        RFWIocAbilityProvider.g().unregisterSingleIoc(this.V, com.tencent.biz.qqcircle.comment.animation.a.class);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.fxm && id5 != R.id.b3r) {
            z16 = false;
        } else {
            if (this.D != null && I0()) {
                this.D.onLongClick(view, 5, this.G, this.R);
            }
            z16 = true;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        Z0(simpleBaseEvent);
        W0(simpleBaseEvent);
        V0(simpleBaseEvent);
        X0(simpleBaseEvent);
        if ((simpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent) && (feedCloudMeta$StFeed = this.P) != null && this.R != null) {
            QCircleCommentPraiseUpdateEvent qCircleCommentPraiseUpdateEvent = (QCircleCommentPraiseUpdateEvent) simpleBaseEvent;
            if (TextUtils.equals(qCircleCommentPraiseUpdateEvent.mFeedId, feedCloudMeta$StFeed.f398449id.get()) && qCircleCommentPraiseUpdateEvent.mType == 1 && TextUtils.equals(qCircleCommentPraiseUpdateEvent.mCommentId, this.R.f398447id.get())) {
                if (QCirclePluginUtil.isOwner(this.P.poster.get())) {
                    this.R.likeInfo.ownerStatus.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
                }
                this.R.likeInfo.status.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
                this.R.likeInfo.count.set(qCircleCommentPraiseUpdateEvent.mPraisedNum);
                u1(this.R);
            }
        }
    }

    public void setEnableReplyList(boolean z16) {
        this.f83189m0 = z16;
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.P = feedCloudMeta$StFeed;
    }

    public void setHostRecyclerView(ViewGroup viewGroup) {
        this.H = viewGroup;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSCommentPraiseLayout.j
    public void w() {
        if (f1()) {
            QLog.e(getLogTag(), 1, "[onFoldAnim] current is fold status");
            return;
        }
        d1();
        if (this.f83184h0 != null && this.f83185i0 != null && this.f83187k0 != null) {
            b1();
            int height = this.f83184h0.getHeight();
            QLog.d(getLogTag(), 1, "[onFoldAnim] contentHeight:" + height);
            af.M(this.f83184h0, this.f83185i0, this.f83187k0, height);
            this.Q.setContentHeight(height);
            this.Q.setFolded(true);
            return;
        }
        QLog.e(getLogTag(), 1, "[onFoldAnim] view is null");
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(QCircleReportBean qCircleReportBean) {
        super.setReportBean(qCircleReportBean);
        QFSCommentPraiseLayout qFSCommentPraiseLayout = this.T;
        if (qFSCommentPraiseLayout != null) {
            qFSCommentPraiseLayout.setReportBean(qCircleReportBean);
        }
    }

    @Override // com.tencent.biz.qqcircle.comment.QFSCommentBaseItemView, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
