package com.qzone.reborn.feedx.widget.eventtag;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.widget.QZoneAvatarLoopView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ar;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import ef.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StUser;
import qzone.QZoneTagFeedList$GetTagFeedListHeadRsp;
import qzone.QZoneTagFeedList$PopularityInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001=B\u0011\b\u0016\u0012\u0006\u00106\u001a\u000205\u00a2\u0006\u0004\b7\u00108B\u001b\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\b\u0010:\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\b7\u0010;J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0003J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0014J\u001a\u0010\u0014\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0005H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010%R\u0014\u00104\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010%\u00a8\u0006>"}, d2 = {"Lcom/qzone/reborn/feedx/widget/eventtag/QZoneFeedEventTagHeadView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lqzone/QZoneTagFeedList$GetTagFeedListHeadRsp;", "Landroid/view/View;", "view", "", "width", "height", "", "m0", "r0", "s0", "u0", "n0", "o0", "q0", "getLayoutId", NodeProps.ON_ATTACHED_TO_WINDOW, "objData", c.G, "p0", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "mFlCoverContainer", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "mLlContentView", h.F, "mLlCommentsArea", "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "i", "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "mIvLogoView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mTvTitleView", BdhLogUtil.LogTag.Tag_Conn, "mTvTitleFlagView", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "D", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "mTvTitleFlagRoundLayout", "Lcom/qzone/reborn/widget/QZoneAvatarLoopView;", "E", "Lcom/qzone/reborn/widget/QZoneAvatarLoopView;", "mAvatarLoopView", UserInfo.SEX_FEMALE, "mTvCommentReadView", "G", "mTvDescView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedEventTagHeadView extends QZoneBaseWidgetView<QZoneTagFeedList$GetTagFeedListHeadRsp> {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float I = d.a(Float.valueOf(4.0f));
    private static final int J = d.b(60);
    private static final int K = d.b(60);

    /* renamed from: C, reason: from kotlin metadata */
    private final TextView mTvTitleFlagView;

    /* renamed from: D, reason: from kotlin metadata */
    private final RoundCorneredFrameLayout mTvTitleFlagRoundLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private final QZoneAvatarLoopView mAvatarLoopView;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView mTvCommentReadView;

    /* renamed from: G, reason: from kotlin metadata */
    private final TextView mTvDescView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout mFlCoverContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout mLlContentView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout mLlCommentsArea;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final RFWRoundImageView mIvLogoView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final TextView mTvTitleView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/feedx/widget/eventtag/QZoneFeedEventTagHeadView$a;", "", "", "a", "", "AVATAR_BORDER_WIDTH", UserInfo.SEX_FEMALE, "COVER_BG_LARGE_RATIO", "COVER_BG_RATIO", "LOOP_ANIM_DELAY_TIME", "I", "LOOP_ANIM_DURATION_TIME", "MAX_AVATAR_COUNT", "", "TAG", "Ljava/lang/String;", "VISITOR_UNIT", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedx.widget.eventtag.QZoneFeedEventTagHeadView$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return (int) ((FontSettingManager.getFontLevel() > 18.0f ? 0.74666667f : 0.6666667f) * ar.l());
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedEventTagHeadView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.muo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_event_tag_head_container)");
        this.mFlCoverContainer = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.mui);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_event_tag_content)");
        this.mLlContentView = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.muv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_event_tag_logo)");
        this.mIvLogoView = (RFWRoundImageView) findViewById3;
        View findViewById4 = findViewById(R.id.mv8);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_event_tag_title)");
        this.mTvTitleView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.mv_);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qzone_event_tag_title_flag)");
        this.mTvTitleFlagView = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.mva);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.qzone_\u2026tag_title_flag_container)");
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById6;
        this.mTvTitleFlagRoundLayout = roundCorneredFrameLayout;
        View findViewById7 = findViewById(R.id.mu_);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.qzone_\u2026ent_tag_avatar_loop_view)");
        QZoneAvatarLoopView qZoneAvatarLoopView = (QZoneAvatarLoopView) findViewById7;
        this.mAvatarLoopView = qZoneAvatarLoopView;
        View findViewById8 = findViewById(R.id.mug);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.qzone_event_tag_comments_area)");
        this.mLlCommentsArea = (LinearLayout) findViewById8;
        View findViewById9 = findViewById(R.id.muh);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.qzone_\u2026t_tag_comments_read_info)");
        this.mTvCommentReadView = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.mun);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.qzone_event_tag_desc)");
        this.mTvDescView = (TextView) findViewById10;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        roundCorneredFrameLayout.setRadius(I);
        qZoneAvatarLoopView.setBorderWidth(ar.d(0.5f));
    }

    private final void m0(View view, int width, int height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = width;
            layoutParams.height = height;
            view.setLayoutParams(layoutParams);
        }
    }

    private final void n0() {
        PBRepeatMessageField<QZoneBaseMeta$StUser> pBRepeatMessageField;
        List<QZoneBaseMeta$StUser> list;
        PBRepeatMessageField<QZoneBaseMeta$StUser> pBRepeatMessageField2;
        QZoneTagFeedList$PopularityInfo qZoneTagFeedList$PopularityInfo = getData().popularity;
        if (bl.b((qZoneTagFeedList$PopularityInfo == null || (pBRepeatMessageField2 = qZoneTagFeedList$PopularityInfo.users) == null) ? null : pBRepeatMessageField2.get())) {
            this.mAvatarLoopView.setVisibility(8);
            RFWLog.i("QZoneFeedEventTagHeadView", RFWLog.USR, "[bindAvatarLoopView] popularity users = null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        QZoneTagFeedList$PopularityInfo qZoneTagFeedList$PopularityInfo2 = getData().popularity;
        if (qZoneTagFeedList$PopularityInfo2 != null && (pBRepeatMessageField = qZoneTagFeedList$PopularityInfo2.users) != null && (list = pBRepeatMessageField.get()) != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(d.k(((QZoneBaseMeta$StUser) it.next()).uin.get())));
            }
        }
        this.mLlCommentsArea.setVisibility(0);
        QZoneAvatarLoopView qZoneAvatarLoopView = this.mAvatarLoopView;
        qZoneAvatarLoopView.setNeedAvatarClick(false);
        qZoneAvatarLoopView.setMaxAvatarCount(3);
        qZoneAvatarLoopView.setLoopWhenAudiencePositionEqualsAudienceCount(true);
        qZoneAvatarLoopView.setLoopDelayMs(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID);
        qZoneAvatarLoopView.setLoopAnimationDuration(500);
        qZoneAvatarLoopView.setTranslationX(0.0f);
        qZoneAvatarLoopView.K(arrayList);
    }

    private final void o0() {
        PBRepeatField<String> pBRepeatField;
        QZoneTagFeedList$PopularityInfo qZoneTagFeedList$PopularityInfo = getData().popularity;
        if (bl.b((qZoneTagFeedList$PopularityInfo == null || (pBRepeatField = qZoneTagFeedList$PopularityInfo.disciption) == null) ? null : pBRepeatField.get())) {
            RFWLog.i("QZoneFeedEventTagHeadView", RFWLog.USR, "[bindCommentsCountView] popularity disciption is empty");
            return;
        }
        this.mLlCommentsArea.setVisibility(0);
        TextView textView = this.mTvCommentReadView;
        QZoneTagFeedList$PopularityInfo qZoneTagFeedList$PopularityInfo2 = getData().popularity;
        Intrinsics.checkNotNull(qZoneTagFeedList$PopularityInfo2);
        textView.setText(TextUtils.join("  |  ", qZoneTagFeedList$PopularityInfo2.disciption.get()));
    }

    private final void q0() {
        this.mTvDescView.setText(getData().tag_intro.get());
    }

    private final void r0() {
        if (TextUtils.isEmpty(getData().tag_image.get())) {
            this.mIvLogoView.setVisibility(8);
            RFWLog.i("QZoneFeedEventTagHeadView", RFWLog.USR, "[bindTagLogo] tag_image = null");
            return;
        }
        this.mIvLogoView.setVisibility(0);
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(getData().tag_image.get());
        e16.setTargetView(this.mIvLogoView);
        e16.setRequestWidth(this.mIvLogoView.getLayoutParams().width);
        e16.setRequestHeight(this.mIvLogoView.getLayoutParams().height);
        e16.setLoadingDrawable(getContext().getResources().getDrawable(R.drawable.at8));
        e16.setFailDrawable(getContext().getResources().getDrawable(R.drawable.at8));
        com.tencent.mobileqq.qzone.picload.c.a().h(e16);
    }

    private final void s0() {
        if (!TextUtils.isEmpty(getData().tag_name.get())) {
            this.mTvTitleView.setVisibility(0);
            this.mTvTitleView.setText("# " + getData().tag_name.get());
            return;
        }
        this.mTvTitleView.setVisibility(8);
    }

    private final void u0() {
        if (TextUtils.isEmpty(getData().corner_tag_type.get())) {
            this.mTvTitleFlagView.setVisibility(8);
            return;
        }
        this.mTvTitleFlagView.setVisibility(0);
        this.mTvTitleFlagView.setText(getData().corner_tag_type.get());
        try {
            if (!TextUtils.isEmpty(getData().corner_tag_text_color.get())) {
                this.mTvTitleFlagView.setTextColor(Color.parseColor(getData().corner_tag_text_color.get()));
            }
            if (!TextUtils.isEmpty(getData().corner_tag_background_color.get())) {
                this.mTvTitleFlagView.setBackgroundColor(Color.parseColor(getData().corner_tag_background_color.get()));
            } else {
                this.mTvTitleFlagView.setBackgroundColor(Color.parseColor("#FFF6E0"));
            }
        } catch (IllegalArgumentException e16) {
            QLog.e("QZoneFeedEventTagHeadView", 1, "bindTagTitleFlag parse color err: " + e16);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.a_6;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m0(this.mFlCoverContainer, -1, INSTANCE.a());
        m0(this.mIvLogoView, J, K);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void bindData(QZoneTagFeedList$GetTagFeedListHeadRsp objData, int pos) {
        this.mLlContentView.setVisibility(0);
        r0();
        s0();
        u0();
        n0();
        o0();
        q0();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedEventTagHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.muo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_event_tag_head_container)");
        this.mFlCoverContainer = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.mui);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_event_tag_content)");
        this.mLlContentView = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.muv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_event_tag_logo)");
        this.mIvLogoView = (RFWRoundImageView) findViewById3;
        View findViewById4 = findViewById(R.id.mv8);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_event_tag_title)");
        this.mTvTitleView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.mv_);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qzone_event_tag_title_flag)");
        this.mTvTitleFlagView = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.mva);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.qzone_\u2026tag_title_flag_container)");
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById6;
        this.mTvTitleFlagRoundLayout = roundCorneredFrameLayout;
        View findViewById7 = findViewById(R.id.mu_);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.qzone_\u2026ent_tag_avatar_loop_view)");
        QZoneAvatarLoopView qZoneAvatarLoopView = (QZoneAvatarLoopView) findViewById7;
        this.mAvatarLoopView = qZoneAvatarLoopView;
        View findViewById8 = findViewById(R.id.mug);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.qzone_event_tag_comments_area)");
        this.mLlCommentsArea = (LinearLayout) findViewById8;
        View findViewById9 = findViewById(R.id.muh);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.qzone_\u2026t_tag_comments_read_info)");
        this.mTvCommentReadView = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.mun);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.qzone_event_tag_desc)");
        this.mTvDescView = (TextView) findViewById10;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        roundCorneredFrameLayout.setRadius(I);
        qZoneAvatarLoopView.setBorderWidth(ar.d(0.5f));
    }
}
