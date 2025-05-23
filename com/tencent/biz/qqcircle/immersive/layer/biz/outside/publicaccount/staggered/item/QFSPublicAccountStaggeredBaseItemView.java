package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.helpers.QCirclePublicAccountHelper;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.events.QFSPublicAccountStaggerItemRemoveEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerFragment;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerPositiveActionCollector;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.widget.QFSStaggerAuthorView;
import com.tencent.biz.qqcircle.immersive.utils.an;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountTechReporter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLiteBanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 e2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001fB\u001f\u0012\u0006\u0010b\u001a\u00020a\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00103\u001a\u000200\u00a2\u0006\u0004\bc\u0010dJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\b\u0010\u0019\u001a\u00020\u0018H&J\u001a\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0014J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0004J\u0018\u0010!\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\u0007H\u0014J\b\u0010#\u001a\u00020\u0007H\u0014J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0004H\u0016J$\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040'0&j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040'`(H\u0016J\b\u0010+\u001a\u00020*H\u0004R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00106\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001a\u0010<\u001a\u0002078\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001a\u0010B\u001a\u00020=8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u001a\u0010L\u001a\u00020G8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001a\u0010Q\u001a\u00020\u000f8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0014\u0010S\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u00109R\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR$\u0010`\u001a\u0004\u0018\u00010\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_\u00a8\u0006g"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredBaseItemView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Le30/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "E0", "", "position", "data", "D0", "M0", "O0", "Landroid/view/View;", "itemView", "G0", "F0", "H0", "K0", "y0", "Landroid/graphics/drawable/Drawable;", "A0", "", "u0", "objData", "bindData", com.tencent.luggage.wxa.c8.c.G, "B0", "I0", "reportedPosition", "reportedSpanIndex", "r0", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "L0", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "d", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", "e", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", "feedsOperator", "f", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredBaseItemView;", "rootContainer", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "v0", "()Landroid/widget/ImageView;", "feedCoverView", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "i", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "z0", "()Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "titleView", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "avatarView", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/widget/QFSStaggerAuthorView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/widget/QFSStaggerAuthorView;", "s0", "()Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/widget/QFSStaggerAuthorView;", "authorView", "D", "Landroid/view/View;", "w0", "()Landroid/view/View;", "interactArea", "E", "interactView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "interactNumText", "G", "Lfeedcloud/FeedCloudMeta$StFeed;", "H", "Ljava/lang/Integer;", "x0", "()Ljava/lang/Integer;", "setMPoi", "(Ljava/lang/Integer;)V", "mPoi", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;)V", "I", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public abstract class QFSPublicAccountStaggeredBaseItemView extends QCircleBaseWidgetView<e30.b> implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final QFSStaggerAuthorView authorView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View interactArea;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ImageView interactView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView interactNumText;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed feed;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Integer mPoi;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleInitBean initBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a feedsOperator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QFSPublicAccountStaggeredBaseItemView rootContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView feedCoverView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleAsyncTextView titleView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleAvatarView avatarView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPublicAccountStaggeredBaseItemView(@NotNull Context context, @NotNull QCircleInitBean initBean, @NotNull com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a feedsOperator) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Intrinsics.checkNotNullParameter(feedsOperator, "feedsOperator");
        this.initBean = initBean;
        this.feedsOperator = feedsOperator;
        this.rootContainer = this;
        View findViewById = findViewById(R.id.f164921bb4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.cover_image)");
        this.feedCoverView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f166992jq2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.title_text)");
        this.titleView = (QCircleAsyncTextView) findViewById2;
        View findViewById3 = findViewById(R.id.l_k);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.avatar_image)");
        this.avatarView = (QCircleAvatarView) findViewById3;
        View findViewById4 = findViewById(R.id.f164521sy3);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.author_view)");
        this.authorView = (QFSStaggerAuthorView) findViewById4;
        View findViewById5 = findViewById(R.id.xp9);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.interact_area)");
        this.interactArea = findViewById5;
        View findViewById6 = findViewById(R.id.xp_);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.interact_image)");
        this.interactView = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.xpa);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.interact_num_text)");
        this.interactNumText = (TextView) findViewById7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(QFSPublicAccountStaggeredBaseItemView this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I0(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void D0(int position, e30.b data) {
        FeedCloudMeta$StFeed g16 = data.g();
        if (g16 == null) {
            return;
        }
        this.interactArea.setTag(Integer.valueOf(position));
        if (g16.opMask2.get().contains(53)) {
            M0(g16, position);
        } else {
            O0(g16);
        }
    }

    private final void E0(FeedCloudMeta$StFeed feed) {
        int dpToPx = ImmersiveUtils.dpToPx(20.0f);
        this.avatarView.setAvatar(feed.poster, new Size(dpToPx, dpToPx));
        this.avatarView.i();
        this.authorView.setData(feed);
    }

    private final void F0(FeedCloudMeta$StFeed feed) {
        String uri = Uri.parse("mqqapi://qcircle/opendetail").buildUpon().appendQueryParameter("getfeedlist", "1").appendQueryParameter(QCircleScheme.AttrDetail.ENABLE_REFRESH, "1").appendQueryParameter("sourcetype", "15").appendQueryParameter("feedid", feed.f398449id.get()).appendQueryParameter("createtime", String.valueOf(feed.createTime.get())).appendQueryParameter("uin", feed.poster.f398463id.get()).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "parse(Q_CIRCLE_DETAIL_PA\u2026get()).build().toString()");
        QCircleSchemeLauncher.d(getContext(), uri);
    }

    private final void G0(FeedCloudMeta$StFeed feed, View itemView) {
        String str;
        String str2;
        PBStringField pBStringField;
        if (feed.busiTranparent.size() == 0) {
            F0(feed);
            return;
        }
        u40.a.c(feed);
        Context context = itemView.getContext();
        ImageView imageView = this.feedCoverView;
        Drawable A0 = A0();
        if (an.d(this.initBean)) {
            str = QCircleDaTongConstant.PageId.PG_XSJ_EXPLORE_TAB_PAGE;
        } else {
            str = "biz_public_account_from_staggered";
        }
        com.tencent.biz.qqcircle.launcher.c.u(context, com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.k(feed, imageView, A0, str, getCurrentPlayPosition(), this.initBean));
        QRouteApi api = QRoute.api(IQCirclePublicAccountTechReporter.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQCirclePublicAccountTechReporter::class.java)");
        IQCirclePublicAccountTechReporter iQCirclePublicAccountTechReporter = (IQCirclePublicAccountTechReporter) api;
        String str3 = feed.f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str3, "feed.id.get()");
        String str4 = feed.f398449id.get();
        FeedCloudMeta$StFeed feed2 = this.initBean.getFeed();
        if (feed2 != null && (pBStringField = feed2.f398449id) != null) {
            str2 = pBStringField.get();
        } else {
            str2 = null;
        }
        boolean areEqual = Intrinsics.areEqual(str4, str2);
        QCirclePublicAccountHelper qCirclePublicAccountHelper = new QCirclePublicAccountHelper();
        String str5 = feed.video.playUrl.get();
        Intrinsics.checkNotNullExpressionValue(str5, "feed.video.playUrl.get()");
        boolean needExchangeUrl = qCirclePublicAccountHelper.needExchangeUrl(str5);
        QCirclePublicAccountHelper qCirclePublicAccountHelper2 = new QCirclePublicAccountHelper();
        String str6 = feed.cover.picUrl.get();
        Intrinsics.checkNotNullExpressionValue(str6, "feed.cover.picUrl.get()");
        IQCirclePublicAccountTechReporter.DefaultImpls.onEnterPage$default(iQCirclePublicAccountTechReporter, str3, false, areEqual, needExchangeUrl, qCirclePublicAccountHelper2.getImageCacheStatusCode(str6), false, true, 34, null);
    }

    private final void H0(FeedCloudMeta$StFeed feed) {
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setForceFromNetwork(false);
        qCircleInitBean.setExtraTypeInfo(getQCircleExtraTypeInfo());
        qCircleInitBean.setFeed(feed);
        qCircleInitBean.setFromReportBean(new QCircleReportBean());
        com.tencent.biz.qqcircle.launcher.c.W(getContext(), qCircleInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(QFSPublicAccountStaggeredBaseItemView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.rootContainer.setAlpha(floatValue);
        this$0.rootContainer.setScaleX(floatValue);
        this$0.rootContainer.setScaleY(floatValue);
    }

    private final void K0(int position) {
        int i3 = position + 1;
        int y06 = y0() + 1;
        FeedCloudMeta$StFeed g16 = getData().g();
        Intrinsics.checkNotNullExpressionValue(g16, "data.sourceData");
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.g.g(i3, y06, g16, this.initBean);
        r0(i3, y06);
    }

    private final void M0(FeedCloudMeta$StFeed feed, final int position) {
        ImageView imageView = this.interactView;
        imageView.setImageDrawable(ResourcesCompat.getDrawable(imageView.getResources(), R.drawable.qvideo_skin_icon_general_hot_secondary, null));
        this.interactNumText.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(feed.visitorInfo.viewCount.get()));
        this.interactArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountStaggeredBaseItemView.N0(QFSPublicAccountStaggeredBaseItemView.this, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(QFSPublicAccountStaggeredBaseItemView this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I0(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void O0(FeedCloudMeta$StFeed feed) {
        ImageView imageView = this.interactView;
        imageView.setImageDrawable(ResourcesCompat.getDrawable(imageView.getResources(), R.drawable.qvideo_skin_icon_general_play_secondary, null));
        this.interactNumText.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(feed.visitorInfo.viewCount.get()));
        this.interactArea.setOnClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(QFSPublicAccountStaggeredBaseItemView this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I0(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q0(QFSPublicAccountStaggeredBaseItemView this$0, FeedCloudMeta$StFeed feed, int i3, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a aVar = this$0.feedsOperator;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        return aVar.a(feed, it, i3);
    }

    @Nullable
    public abstract Drawable A0();

    public void B0(final int pos, @NotNull e30.b data) {
        boolean z16;
        Intrinsics.checkNotNullParameter(data, "data");
        String str = data.g().content.get();
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.titleView.setVisibility(8);
            return;
        }
        this.titleView.setVisibility(0);
        this.titleView.setPreloadParserInfo(uc0.a.b(data.g()));
        this.titleView.setNeedSpecialAreaBold(false);
        this.titleView.setSpecialClickAreaColor(R.color.qvideo_skin_color_text_primary);
        this.titleView.setText(str);
        this.titleView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountStaggeredBaseItemView.C0(QFSPublicAccountStaggeredBaseItemView.this, pos, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I0(int position) {
        K0(position);
        if (getData() != null && getData().g() != null) {
            if (getData().g().type.get() == 2) {
                FeedCloudMeta$StFeed g16 = getData().g();
                Intrinsics.checkNotNullExpressionValue(g16, "data.sourceData");
                H0(g16);
                return;
            }
            RFWPlayerOptions obtain = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO());
            obtain.setStartOffset(getCurrentPlayPosition());
            RFWPlayerPreRenderHelper rFWPlayerPreRenderHelper = RFWPlayerPreRenderHelper.getInstance();
            RFWPlayerPreRenderBean rFWPlayerPreRenderBean = new RFWPlayerPreRenderBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), 10009);
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            rFWPlayerPreRenderHelper.playerRender(gb0.b.f(rFWPlayerPreRenderBean.setActivity((Activity) context).setSourceType(com.tencent.biz.qqcircle.immersive.manager.g.e().i(getReportBean())).setPreloadVideo(gb0.b.k(getData().g().video)).setPreloadOriginData(gb0.b.m(getData().o("KEY_RFW_VIDEO_FEED_POI", Integer.valueOf(position)))).setMultiLevel(true).setIsJumpTrigger(uq3.o.U0()).setPlayerOptions(obtain)));
            if (getData().g().type.get() == 4) {
                com.tencent.biz.qqcircle.launcher.c.g(getContext(), getData().g().live.schema.get());
            } else {
                FeedCloudMeta$StFeed g17 = getData().g();
                Intrinsics.checkNotNullExpressionValue(g17, "data.sourceData");
                G0(g17, this);
            }
            QCircleBaseFragment qCircleBaseFragment = getQCircleBaseFragment();
            if (qCircleBaseFragment instanceof QFSPublicAccountStaggerFragment) {
                final List<e30.b> feedList = ((QFSPublicAccountStaggerFragment) qCircleBaseFragment).getFeedList();
                QFSPublicAccountStaggerPositiveActionCollector qFSPublicAccountStaggerPositiveActionCollector = QFSPublicAccountStaggerPositiveActionCollector.f86891a;
                FeedCloudMeta$StFeed g18 = getData().g();
                Intrinsics.checkNotNullExpressionValue(g18, "data.sourceData");
                qFSPublicAccountStaggerPositiveActionCollector.c(g18, position, new Function0<List<? extends String>>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView$onItemClicked$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final List<? extends String> invoke() {
                        int collectionSizeOrDefault;
                        List<e30.b> list = feedList;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((e30.b) it.next()).g().f398449id.get());
                        }
                        return arrayList;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean L0() {
        Integer num;
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner;
        PBInt32Field pBInt32Field;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StLiteBanner = feedCloudMeta$StFeed.liteBanner) != null && (pBInt32Field = feedCloudMeta$StLiteBanner.business_type) != null) {
            num = Integer.valueOf(pBInt32Field.get());
        } else {
            num = null;
        }
        if ((num == null || num.intValue() != 7) && ((num == null || num.intValue() != 8) && (num == null || num.intValue() != 6))) {
            return false;
        }
        return true;
    }

    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSPublicAccountStaggerItemRemoveEvent.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        String str;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof QFSPublicAccountStaggerItemRemoveEvent) {
            String feedId = ((QFSPublicAccountStaggerItemRemoveEvent) event).getFeedId();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
            if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(feedId, str)) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.j
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        QFSPublicAccountStaggeredBaseItemView.J0(QFSPublicAccountStaggeredBaseItemView.this, valueAnimator);
                    }
                });
                ofFloat.start();
            }
        }
    }

    public void r0(int reportedPosition, int reportedSpanIndex) {
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.l lVar = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.l.f87082a;
        e30.b data = getData();
        Intrinsics.checkNotNullExpressionValue(data, "data");
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.l.i(lVar, reportedPosition, reportedSpanIndex, data, this.initBean, false, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: s0, reason: from getter */
    public final QFSStaggerAuthorView getAuthorView() {
        return this.authorView;
    }

    /* renamed from: u0 */
    public abstract long getCurrentPlayPosition();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: v0, reason: from getter */
    public final ImageView getFeedCoverView() {
        return this.feedCoverView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: w0, reason: from getter */
    public final View getInteractArea() {
        return this.interactArea;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: x0, reason: from getter */
    public final Integer getMPoi() {
        return this.mPoi;
    }

    public abstract int y0();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: z0, reason: from getter */
    public final QCircleAsyncTextView getTitleView() {
        return this.titleView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(@Nullable e30.b objData, final int position) {
        final FeedCloudMeta$StFeed g16;
        if (objData == null || (g16 = objData.g()) == null) {
            return;
        }
        this.feed = g16;
        this.mPoi = Integer.valueOf(position);
        B0(position, objData);
        E0(g16);
        e30.b data = getData();
        Intrinsics.checkNotNullExpressionValue(data, "data");
        D0(position, data);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountStaggeredBaseItemView.p0(QFSPublicAccountStaggeredBaseItemView.this, position, view);
            }
        });
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.l
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean q06;
                q06 = QFSPublicAccountStaggeredBaseItemView.q0(QFSPublicAccountStaggeredBaseItemView.this, g16, position, view);
                return q06;
            }
        });
        this.rootContainer.setAlpha(1.0f);
        this.rootContainer.setScaleX(1.0f);
        this.rootContainer.setScaleY(1.0f);
    }
}
