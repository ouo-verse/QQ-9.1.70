package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model.QFSPublicAccountStaggeredItemCommentHelper;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerFragment;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedTagView;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.cv;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$RecomReasonV2;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StLiteBanner;
import feedcloud.FeedCloudMeta$StRecomInfo;
import feedcloud.FeedCloudMeta$StUser;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 }2\u00020\u0001:\u0001~B\u001f\u0012\u0006\u0010x\u001a\u00020w\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010z\u001a\u00020y\u00a2\u0006\u0004\b{\u0010|J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\rH\u0014J\b\u0010%\u001a\u00020\u0016H\u0016J\u001a\u0010)\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020\u0016H\u0014J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020&H\u0016J\b\u0010-\u001a\u00020\u0016H\u0016J\n\u0010/\u001a\u0004\u0018\u00010.H\u0016J\b\u00101\u001a\u000200H\u0016J\u0018\u00104\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u0016H\u0016R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010;\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010V\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010BR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010FR\u0018\u0010`\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010FR\u0018\u0010b\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010BR\u0018\u0010d\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010BR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010j\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010FR\u0014\u0010l\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010RR\u0016\u0010o\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010q\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010nR\u001b\u0010v\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredNormalItemView;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredBaseItemView;", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "f1", "h1", "g1", "i1", "j1", ICustomDataEditor.STRING_PARAM_1, "t1", "u1", "", "recommendText", "V0", "b1", "c1", "Lfeedcloud/FeedCloudMeta$StLiteBanner;", "liteBanner", "m1", ICustomDataEditor.NUMBER_PARAM_1, "", "userSize", "Y0", "d1", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/model/a;", "model", "o1", "q1", "Landroid/widget/ImageView;", "commentBurningIcon", "l1", ICustomDataEditor.STRING_ARRAY_PARAM_1, "", "k1", "getLogTag", "getLayoutId", "Le30/b;", "objData", "position", "bindData", com.tencent.luggage.wxa.c8.c.G, "data", "B0", "y0", "Landroid/graphics/drawable/Drawable;", "A0", "", "u0", "reportedPosition", "reportedSpanIndex", "r0", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "J", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "K", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredNormalItemView;", "rootContainer", "Landroid/widget/RelativeLayout;", "L", "Landroid/widget/RelativeLayout;", "feedCoverContainer", "Landroid/view/View;", "M", "Landroid/view/View;", "photoTagIcon", "Landroid/widget/TextView;", "N", "Landroid/widget/TextView;", "feedDurationText", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/QFSMixFeedTagView;", "P", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/QFSMixFeedTagView;", "tagView", "Landroid/widget/LinearLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/LinearLayout;", "mBannerLayout", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "mBannerText", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/ImageView;", "mBannerIcon", "T", "mExpLiteBannerWrapper", "Lcom/tencent/biz/qqcircle/richframework/widget/SquareImageView;", "U", "Lcom/tencent/biz/qqcircle/richframework/widget/SquareImageView;", "mExpLiteBannerIcon", "V", "mExpLiteBannerTitle", "W", "mExpLiteBannerContent", "a0", "mExpLiteBannerSplit", "b0", "mExpLongRecommendWrapper", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarListView;", "c0", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarListView;", "mExpLongRecomAvatarView", "d0", "mExpLongRecomContentText", "e0", "mExpShortRecomContentText", "f0", "I", "curItemTagType", "g0", "curPosition", "h0", "Lkotlin/Lazy;", "Z0", "()Ljava/lang/String;", "hotCommentIconUrl", "Landroid/content/Context;", "context", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", "feedsOperator", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;)V", "i0", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountStaggeredNormalItemView extends QFSPublicAccountStaggeredBaseItemView {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final QCircleInitBean initBean;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final QFSPublicAccountStaggeredNormalItemView rootContainer;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final RelativeLayout feedCoverContainer;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final View photoTagIcon;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final TextView feedDurationText;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final QFSMixFeedTagView tagView;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout mBannerLayout;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final QCircleAsyncTextView mBannerText;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final ImageView mBannerIcon;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private View mExpLiteBannerWrapper;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private SquareImageView mExpLiteBannerIcon;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private TextView mExpLiteBannerTitle;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private TextView mExpLiteBannerContent;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mExpLiteBannerSplit;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mExpLongRecommendWrapper;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleAvatarListView mExpLongRecomAvatarView;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mExpLongRecomContentText;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleAsyncTextView mExpShortRecomContentText;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private int curItemTagType;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private int curPosition;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy hotCommentIconUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPublicAccountStaggeredNormalItemView(@NotNull Context context, @NotNull QCircleInitBean initBean, @NotNull com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a feedsOperator) {
        super(context, initBean, feedsOperator);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Intrinsics.checkNotNullParameter(feedsOperator, "feedsOperator");
        this.initBean = initBean;
        this.rootContainer = this;
        View findViewById = findViewById(R.id.u_x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.cover_image_container)");
        this.feedCoverContainer = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.xef);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.icon_photo_tag)");
        this.photoTagIcon = findViewById2;
        View findViewById3 = findViewById(R.id.uoy);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.duration_time)");
        this.feedDurationText = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f47301wx);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qfs_mix_feed_tag_view)");
        this.tagView = (QFSMixFeedTagView) findViewById4;
        View findViewById5 = findViewById(R.id.f54622fp);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qfs_stagger_banner_layout)");
        this.mBannerLayout = (LinearLayout) findViewById5;
        View findViewById6 = findViewById(R.id.f54642fr);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.qfs_stagger_banner_text)");
        this.mBannerText = (QCircleAsyncTextView) findViewById6;
        View findViewById7 = findViewById(R.id.f54612fo);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.qfs_stagger_banner_icon)");
        this.mBannerIcon = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.f71533oe);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.recommend_text_before_title)");
        this.mExpShortRecomContentText = (QCircleAsyncTextView) findViewById8;
        this.curItemTagType = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredNormalItemView$hotCommentIconUrl$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_public_account_hot_comment_icon", "https://qq-video.cdn-go.cn/android/latest/defaultmode/9110/official_account/qvideo_official_account_icon_hotcommet.png");
            }
        });
        this.hotCommentIconUrl = lazy;
    }

    private final void V0(String recommendText, FeedCloudMeta$StFeed feed) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(feed.content.get());
        SpannableString spannableString = new SpannableString(" " + recommendText + " ");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(0);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(11, true);
        spannableString.setSpan(foregroundColorSpan, 0, spannableString.length(), 33);
        spannableString.setSpan(absoluteSizeSpan, 0, spannableString.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append((CharSequence) spannableString);
        spannableStringBuilder2.append((CharSequence) "  ");
        spannableStringBuilder2.append((CharSequence) spannableStringBuilder);
        getTitleView().setVisibility(0);
        getTitleView().setPreloadParserInfo(uc0.a.b(feed));
        getTitleView().setNeedSpecialAreaBold(false);
        getTitleView().setSpecialClickAreaColor(R.color.qvideo_skin_color_text_primary);
        getTitleView().setText(spannableStringBuilder2);
        getTitleView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountStaggeredNormalItemView.W0(QFSPublicAccountStaggeredNormalItemView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(QFSPublicAccountStaggeredNormalItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I0(this$0.curPosition);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(QFSPublicAccountStaggeredNormalItemView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.rootContainer.setPivotY(0.0f);
        this$0.rootContainer.setAlpha(floatValue);
        this$0.rootContainer.setScaleX(floatValue);
        this$0.rootContainer.setScaleY(floatValue);
    }

    private final int Y0(int userSize) {
        int a16;
        int a17 = cx.a(12.0f);
        if (userSize == 0) {
            a16 = 0;
        } else {
            a16 = ((int) ((userSize - 1) * r1 * 0.625d)) + cx.a(16.0f);
        }
        return ((com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.INSTANCE.a() - (a17 * 2)) - a16) - cx.a(4.0f);
    }

    private final String Z0() {
        return (String) this.hotCommentIconUrl.getValue();
    }

    private final void a1() {
        QLog.d("QFSPublicAccountStaggeredItemView", 1, "handleClickCommentArea");
        QCircleInitBean.QCircleActionBean actionBean = this.initBean.getActionBean();
        QCircleInitBean qCircleInitBean = this.initBean;
        QCircleInitBean.QCircleActionBean qCircleActionBean = new QCircleInitBean.QCircleActionBean();
        qCircleActionBean.mShowCommentPanel = true;
        qCircleInitBean.setActionBean(qCircleActionBean);
        I0(this.curPosition);
        this.initBean.setActionBean(actionBean);
    }

    private final void b1() {
        if (this.mExpLiteBannerWrapper != null) {
            return;
        }
        View findViewById = findViewById(R.id.f498323r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_pu\u2026ount_lite_banner_wrapper)");
        View inflate = ((ViewStub) findViewById).inflate();
        this.mExpLiteBannerWrapper = inflate;
        if (inflate != null) {
            this.mExpLiteBannerIcon = (SquareImageView) inflate.findViewById(R.id.f498023o);
            this.mExpLiteBannerTitle = (TextView) inflate.findViewById(R.id.f498223q);
            this.mExpLiteBannerContent = (TextView) inflate.findViewById(R.id.f497923n);
            this.mExpLiteBannerSplit = inflate.findViewById(R.id.f498123p);
        }
    }

    private final void c1() {
        if (this.mExpLongRecommendWrapper != null) {
            return;
        }
        View findViewById = findViewById(R.id.f500224_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_pu\u2026recommend_reason_wrapper)");
        View inflate = ((ViewStub) findViewById).inflate();
        this.mExpLongRecommendWrapper = inflate;
        if (inflate != null) {
            this.mExpLongRecomAvatarView = (QCircleAvatarListView) inflate.findViewById(R.id.f5000248);
            this.mExpLongRecomContentText = (TextView) inflate.findViewById(R.id.f5001249);
        }
    }

    private final void d1(FeedCloudMeta$StFeed feed) {
        if (!QFSPublicAccountStaggeredItemCommentHelper.f86870a.d()) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.t__);
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model.a aVar = new com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model.a(feed);
        if (!aVar.e() && !aVar.f()) {
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
        } else {
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QFSPublicAccountStaggeredNormalItemView.e1(QFSPublicAccountStaggeredNormalItemView.this, view);
                    }
                });
            }
            o1(aVar);
            q1(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(QFSPublicAccountStaggeredNormalItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void f1(FeedCloudMeta$StFeed feed) {
        Pair<Integer, Integer> b16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.b(feed);
        int a16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.INSTANCE.a();
        int intValue = (b16.getSecond().intValue() * a16) / b16.getFirst().intValue();
        RelativeLayout relativeLayout = this.feedCoverContainer;
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.height = intValue;
        relativeLayout.setLayoutParams(layoutParams);
        Option failedDrawableId = Option.obtain().setUrl(feed.cover.picUrl.get()).setTargetView(getFeedCoverView()).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setRequestWidth(a16).setRequestHeight(intValue).setLoadingDrawableColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_tag_selected)).setFailedDrawableId(R.drawable.ojc);
        failedDrawableId.setCacheKey(new LibraRequestKey.Builder(new LibraDownloadKey(QCircleFeedPicLoader.g().getPicLocalPath(failedDrawableId))).build());
        failedDrawableId.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        q50.b.e().q(failedDrawableId, false);
        QCircleFeedPicLoader.g().loadImage(failedDrawableId);
    }

    private final void g1(FeedCloudMeta$StFeed feed) {
        boolean z16;
        String c16;
        int i3 = 8;
        this.feedDurationText.setVisibility(8);
        if (feed.type.get() == 3) {
            long j3 = feed.video.duration.get();
            if (60000 <= j3 && j3 < 86400001) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (feed.video.duration.get() > 3600000) {
                    c16 = cv.b(feed.video.duration.get());
                } else {
                    c16 = cv.c(feed.video.duration.get());
                }
                if (TextUtils.isEmpty(c16)) {
                    return;
                }
                this.feedDurationText.setText(c16);
                TextView textView = this.feedDurationText;
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101454", true)) {
                    i3 = 0;
                }
                textView.setVisibility(i3);
            }
        }
    }

    private final void h1(FeedCloudMeta$StFeed feed) {
        if (feed.type.get() == 2) {
            this.photoTagIcon.setVisibility(0);
        } else {
            this.photoTagIcon.setVisibility(8);
        }
    }

    private final void i1(FeedCloudMeta$StFeed feed) {
        boolean z16;
        List<FeedCloudMeta$StUser> list;
        FeedCloudMeta$RecomReasonV2 feedCloudMeta$RecomReasonV2;
        PBRepeatMessageField<FeedCloudMeta$StUser> pBRepeatMessageField;
        String str = feed.live.liveStatusCornerPendent.button_url.get();
        Intrinsics.checkNotNullExpressionValue(str, "feed.live.liveStatusCornerPendent.button_url.get()");
        boolean z17 = true;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.tagView.setVisibility(8);
            this.mBannerLayout.setVisibility(0);
            this.mBannerIcon.setVisibility(0);
            this.mBannerText.setText(feed.live.liveStatusCornerPendent.text.get());
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestWidth(this.mBannerIcon.getLayoutParams().width).setRequestHeight(this.mBannerIcon.getLayoutParams().height).setUrl(feed.live.liveStatusCornerPendent.button_url.get()).setTargetView(this.mBannerIcon));
            return;
        }
        if (L0()) {
            this.mBannerLayout.setVisibility(8);
            QFSMixFeedTagView qFSMixFeedTagView = this.tagView;
            FeedCloudMeta$StFeed g16 = getData().g();
            Intrinsics.checkNotNullExpressionValue(g16, "data.sourceData");
            qFSMixFeedTagView.b(g16);
            return;
        }
        this.tagView.setVisibility(8);
        String recommendItem = feed.recomInfo.recomReasonV2.recomReason.get();
        Intrinsics.checkNotNullExpressionValue(recommendItem, "recommendItem");
        if (recommendItem.length() != 0) {
            z17 = false;
        }
        if (z17) {
            this.mBannerLayout.setVisibility(8);
            return;
        }
        this.mBannerLayout.setVisibility(0);
        this.mBannerIcon.setVisibility(8);
        FeedCloudMeta$StRecomInfo feedCloudMeta$StRecomInfo = feed.recomInfo;
        String str2 = null;
        if (feedCloudMeta$StRecomInfo != null && (feedCloudMeta$RecomReasonV2 = feedCloudMeta$StRecomInfo.recomReasonV2) != null && (pBRepeatMessageField = feedCloudMeta$RecomReasonV2.recomUserInfo) != null) {
            list = pBRepeatMessageField.get();
        } else {
            list = null;
        }
        if (list != null) {
            str2 = com.tencent.biz.qqcircle.utils.o.b(list, list.size());
        }
        if (str2 == null) {
            str2 = "";
        }
        TextPaint paint = this.mBannerText.getPaint();
        int a16 = (com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.INSTANCE.a() - cx.a(6.0f)) - cx.a(60.0f);
        QCircleAsyncTextView qCircleAsyncTextView = this.mBannerText;
        h50.b bVar = h50.b.f404331a;
        Intrinsics.checkNotNullExpressionValue(paint, "paint");
        qCircleAsyncTextView.setText(bVar.a(str2, recommendItem, paint, a16));
    }

    private final void j1(FeedCloudMeta$StFeed feed) {
        View view = this.mExpLiteBannerWrapper;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mExpLongRecommendWrapper;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model.b bVar = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model.b.f86876a;
        if (bVar.d(this.curItemTagType)) {
            s1(feed);
        } else if (bVar.e(this.curItemTagType)) {
            t1(feed);
        }
    }

    private final boolean k1() {
        return QFSPublicAccountStaggerFragment.INSTANCE.d();
    }

    private final void l1(ImageView commentBurningIcon) {
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(Z0()).setTargetView(commentBurningIcon).setFromPreLoad(false).setPredecode(true).setRequestWidth(commentBurningIcon.getWidth()).setRequestHeight(commentBurningIcon.getHeight()).setFailedDrawableId(R.drawable.ojc));
    }

    private final void m1(FeedCloudMeta$StLiteBanner liteBanner) {
        String str;
        boolean z16;
        List emptyList;
        boolean z17;
        String str2;
        boolean z18;
        boolean z19;
        PBStringField pBStringField;
        FeedCloudMeta$StImage feedCloudMeta$StImage;
        PBStringField pBStringField2;
        String str3 = null;
        if (liteBanner != null && (feedCloudMeta$StImage = liteBanner.icon) != null && (pBStringField2 = feedCloudMeta$StImage.picUrl) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        String str4 = "";
        if (str == null) {
            str = "";
        }
        if (liteBanner != null && (pBStringField = liteBanner.title) != null) {
            str3 = pBStringField.get();
        }
        if (str3 == null) {
            str3 = "";
        }
        int i3 = 0;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (str3.length() == 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                return;
            }
        }
        View view = this.mExpLiteBannerWrapper;
        if (view != null) {
            view.setVisibility(0);
        }
        SquareImageView squareImageView = this.mExpLiteBannerIcon;
        if (squareImageView != null) {
            if (!TextUtils.isEmpty(str)) {
                squareImageView.setVisibility(0);
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestWidth(squareImageView.getLayoutParams().width).setRequestHeight(squareImageView.getLayoutParams().height).setUrl(str).setTargetView(squareImageView).setSupportRecycler(true));
            } else {
                squareImageView.setVisibility(8);
            }
        }
        List<String> split = new Regex("\u00b7").split(str3, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        TextView textView = this.mExpLiteBannerTitle;
        if (textView != null) {
            if (strArr.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!(!z17)) {
                str2 = "";
            } else {
                str2 = strArr[0];
            }
            textView.setText(str2);
        }
        TextView textView2 = this.mExpLiteBannerContent;
        if (textView2 != null) {
            if (strArr.length > 1) {
                str4 = strArr[1];
            }
            textView2.setText(str4);
        }
        View view2 = this.mExpLiteBannerSplit;
        if (view2 != null) {
            if (strArr.length <= 1) {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
        TextView textView3 = this.mExpLiteBannerContent;
        if (textView3 != null) {
            textView3.requestLayout();
        }
    }

    private final void n1(FeedCloudMeta$StFeed feed) {
        List<FeedCloudMeta$StUser> list;
        String str;
        boolean z16;
        FeedCloudMeta$RecomReasonV2 feedCloudMeta$RecomReasonV2;
        PBStringField pBStringField;
        FeedCloudMeta$RecomReasonV2 feedCloudMeta$RecomReasonV22;
        PBRepeatMessageField<FeedCloudMeta$StUser> pBRepeatMessageField;
        FeedCloudMeta$StRecomInfo feedCloudMeta$StRecomInfo = feed.recomInfo;
        String str2 = null;
        if (feedCloudMeta$StRecomInfo != null && (feedCloudMeta$RecomReasonV22 = feedCloudMeta$StRecomInfo.recomReasonV2) != null && (pBRepeatMessageField = feedCloudMeta$RecomReasonV22.recomUserInfo) != null) {
            list = pBRepeatMessageField.get();
        } else {
            list = null;
        }
        FeedCloudMeta$StRecomInfo feedCloudMeta$StRecomInfo2 = feed.recomInfo;
        if (feedCloudMeta$StRecomInfo2 != null && (feedCloudMeta$RecomReasonV2 = feedCloudMeta$StRecomInfo2.recomReasonV2) != null && (pBStringField = feedCloudMeta$RecomReasonV2.recomReason) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        List<FeedCloudMeta$StUser> list2 = list;
        boolean z17 = true;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (str.length() != 0) {
                z17 = false;
            }
            if (z17) {
                return;
            }
        }
        View view = this.mExpLongRecommendWrapper;
        if (view != null) {
            view.setVisibility(0);
        }
        List<String> c16 = com.tencent.biz.qqcircle.utils.o.c(list, 3);
        if (list != null) {
            str2 = com.tencent.biz.qqcircle.utils.o.b(list, list.size());
        }
        if (str2 != null) {
            str3 = str2;
        }
        QCircleAvatarListView qCircleAvatarListView = this.mExpLongRecomAvatarView;
        if (qCircleAvatarListView != null) {
            qCircleAvatarListView.setData(c16);
        }
        TextView textView = this.mExpLongRecomContentText;
        if (textView != null) {
            h50.b bVar = h50.b.f404331a;
            TextPaint paint = textView.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "it.paint");
            textView.setText(bVar.a(str3, str, paint, Y0(c16.size())));
        }
    }

    private final void o1(com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model.a model) {
        View findViewById = findViewById(R.id.u1h);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.comment_burning_layout)");
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById;
        if (model.e()) {
            constraintLayout.setVisibility(0);
            View findViewById2 = findViewById(R.id.u1g);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.comment_burning_icon)");
            QCircleAsyncTextView qCircleAsyncTextView = (QCircleAsyncTextView) findViewById(R.id.u1i);
            qCircleAsyncTextView.setSpecialClickAreaColor(R.color.qui_common_text_primary);
            qCircleAsyncTextView.setNeedSpecialAreaBold(true);
            qCircleAsyncTextView.setMaxLines(1);
            qCircleAsyncTextView.setEllipsize(TextUtils.TruncateAt.END);
            qCircleAsyncTextView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSPublicAccountStaggeredNormalItemView.p1(QFSPublicAccountStaggeredNormalItemView.this, view);
                }
            });
            l1((ImageView) findViewById2);
            qCircleAsyncTextView.setText(model.b());
            return;
        }
        constraintLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(QFSPublicAccountStaggeredNormalItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q1(com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model.a model) {
        View findViewById = findViewById(R.id.u2b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.comment_replay_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        if (model.f()) {
            linearLayout.setVisibility(0);
            QCircleAsyncTextView qCircleAsyncTextView = (QCircleAsyncTextView) findViewById(R.id.u2c);
            qCircleAsyncTextView.setSpecialClickAreaColor(R.color.qui_common_text_primary);
            qCircleAsyncTextView.setNeedSpecialAreaBold(true);
            qCircleAsyncTextView.setMaxLines(1);
            qCircleAsyncTextView.setEllipsize(TextUtils.TruncateAt.END);
            qCircleAsyncTextView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSPublicAccountStaggeredNormalItemView.r1(QFSPublicAccountStaggeredNormalItemView.this, view);
                }
            });
            qCircleAsyncTextView.setText(model.c());
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(QFSPublicAccountStaggeredNormalItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void s1(FeedCloudMeta$StFeed feed) {
        b1();
        m1(feed.liteBanner);
    }

    private final void t1(FeedCloudMeta$StFeed feed) {
        c1();
        n1(feed);
    }

    private final void u1(FeedCloudMeta$StFeed feed) {
        String str;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        int i16;
        int i17;
        int i18;
        FeedCloudMeta$RecomReasonV2 feedCloudMeta$RecomReasonV2;
        PBStringField pBStringField;
        FeedCloudMeta$StRecomInfo feedCloudMeta$StRecomInfo = feed.recomInfo;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
        if (feedCloudMeta$StRecomInfo != null && (feedCloudMeta$RecomReasonV2 = feedCloudMeta$StRecomInfo.recomReasonV2) != null && (pBStringField = feedCloudMeta$RecomReasonV2.recomReason) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        QCircleAsyncTextView qCircleAsyncTextView = this.mExpShortRecomContentText;
        ViewGroup.LayoutParams layoutParams = qCircleAsyncTextView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            i3 = marginLayoutParams.leftMargin;
        } else {
            i3 = 0;
        }
        int paddingLeft = i3 + qCircleAsyncTextView.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams2 = qCircleAsyncTextView.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        }
        if (marginLayoutParams2 != null) {
            i16 = marginLayoutParams2.rightMargin;
        } else {
            i16 = 0;
        }
        int a16 = (com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.INSTANCE.a() - paddingLeft) - (i16 + qCircleAsyncTextView.getPaddingRight());
        h50.b bVar = h50.b.f404331a;
        TextPaint paint = qCircleAsyncTextView.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "it.paint");
        SpannableStringBuilder a17 = bVar.a("", str, paint, a16);
        String spannableStringBuilder = a17.toString();
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "recommendText.toString()");
        V0(spannableStringBuilder, feed);
        if (Intrinsics.areEqual("\u70ed\u70b9", str)) {
            this.mExpShortRecomContentText.setTextColor(Color.parseColor("#FF5967"));
            if (QQTheme.isDefaultTheme()) {
                i18 = R.drawable.l9e;
            } else {
                i18 = R.drawable.l9f;
            }
            this.mExpShortRecomContentText.setBackground(getContext().getDrawable(i18));
        } else {
            this.mExpShortRecomContentText.setTextColor(Color.parseColor("#0099FF"));
            if (QQTheme.isDefaultTheme()) {
                i17 = R.drawable.l9c;
            } else {
                i17 = R.drawable.l9d;
            }
            this.mExpShortRecomContentText.setBackground(getContext().getDrawable(i17));
        }
        this.mExpShortRecomContentText.setVisibility(0);
        this.mExpShortRecomContentText.setText(a17);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView
    @Nullable
    public Drawable A0() {
        return getFeedCoverView().getDrawable();
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView
    public void B0(int pos, @NotNull e30.b data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (k1()) {
            if (com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model.b.f86876a.g(this.curItemTagType)) {
                FeedCloudMeta$StFeed g16 = data.g();
                Intrinsics.checkNotNullExpressionValue(g16, "data.sourceData");
                u1(g16);
                return;
            } else {
                this.mExpShortRecomContentText.setVisibility(8);
                super.B0(pos, data);
                return;
            }
        }
        super.B0(pos, data);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gob;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSPublicAccountStaggeredItemView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView
    public void r0(int reportedPosition, int reportedSpanIndex) {
        QCircleInitBean.QCircleActionBean actionBean = this.initBean.getActionBean();
        boolean z16 = false;
        if (actionBean != null && actionBean.mShowCommentPanel) {
            z16 = true;
        }
        if (z16) {
            com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.l lVar = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.l.f87082a;
            e30.b data = getData();
            Intrinsics.checkNotNullExpressionValue(data, "data");
            lVar.n(reportedPosition, reportedSpanIndex, data, this.initBean, true);
            return;
        }
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.l lVar2 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.l.f87082a;
        e30.b data2 = getData();
        Intrinsics.checkNotNullExpressionValue(data2, "data");
        lVar2.h(reportedPosition, reportedSpanIndex, data2, this.initBean, true);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView
    /* renamed from: u0 */
    public long getCurrentPlayPosition() {
        return 0L;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView
    public int y0() {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            return layoutParams.getSpanIndex();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(@Nullable e30.b objData, int position) {
        this.curItemTagType = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model.b.f86876a.a(objData != null ? objData.g() : null);
        super.bindData(objData, position);
        FeedCloudMeta$StFeed g16 = objData != null ? objData.g() : null;
        if (g16 == null) {
            return;
        }
        this.curPosition = position;
        f1(g16);
        h1(g16);
        g1(g16);
        if (k1()) {
            this.mBannerLayout.setVisibility(8);
            j1(g16);
        } else {
            i1(g16);
        }
        d1(g16);
        o oVar = o.f86859a;
        String str = g16.f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str, "feed.id.get()");
        if (oVar.a(str)) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.p
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    QFSPublicAccountStaggeredNormalItemView.X0(QFSPublicAccountStaggeredNormalItemView.this, valueAnimator);
                }
            });
            ofFloat.start();
        }
    }
}
