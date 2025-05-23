package com.tencent.mobileqq.guild.feed.search.sections;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.adapter.n;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedListImageExKt;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.o;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.LongFeedVideoView;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.feed.util.m;
import com.tencent.mobileqq.guild.feed.widget.GuildRoundBubbleImageView;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pn1.SearchDataExt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 X2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001YB\u0007\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0003J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0014J*\u0010!\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0014J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\"H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\u0010\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020\tH\u0016R\u0016\u0010\u001b\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010AR2\u0010I\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020E0Dj\b\u0012\u0004\u0012\u00020E`F0C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010S\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bT\u0010R\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/search/sections/f;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lpn1/a;", "Lcom/tencent/biz/richframework/animation/transition/TransitionHelper$TransitionBeanCreator;", "", BdhLogUtil.LogTag.Tag_Conn, "B", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "", "position", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "stVideo", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "cover", "t", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/guild/feed/widget/GuildRoundBubbleImageView;", "v", "", "url", "y", "u", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", NodeProps.VISIBLE, "onVisibleChanged", "attached", "onAttachedChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "currentPos", "Lcom/tencent/biz/richframework/animation/transition/TransitionBean;", "generateTransitionBean", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "e", "Landroid/view/View;", "gifLabel", "f", "Lcom/tencent/mobileqq/guild/feed/widget/GuildRoundBubbleImageView;", "contentBgIv", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/LongFeedVideoView;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/LongFeedVideoView;", "playView", "Lxj1/f;", "i", "Lxj1/f;", "videoControllerIoc", "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "mediaContainer", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "textContainer", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/feed/adapter/n;", "Lkotlin/collections/ArrayList;", "D", "Lkotlin/Pair;", "mMixedMediaDataPair", "E", "I", "mTransitionBeanCreatorKey", "Lcom/tencent/mobileqq/guild/feed/search/sections/SearchGuildLongFeedTextOnlyComponents;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/search/sections/SearchGuildLongFeedTextOnlyComponents;", "textOnlyComponents", HippyTKDListViewAdapter.X, "()I", "containerWidth", "w", "containerHeight", "<init>", "()V", "G", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f extends Section<pn1.a> implements TransitionHelper.TransitionBeanCreator {
    private static final float H = com.tencent.guild.aio.util.c.b(8);

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup textContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private Pair<String, ? extends ArrayList<n>> mMixedMediaDataPair;

    /* renamed from: E, reason: from kotlin metadata */
    private int mTransitionBeanCreatorKey;

    /* renamed from: F, reason: from kotlin metadata */
    private SearchGuildLongFeedTextOnlyComponents textOnlyComponents;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout containerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View gifLabel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildRoundBubbleImageView contentBgIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LongFeedVideoView playView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private xj1.f videoControllerIoc;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RoundCornerLayout mediaContainer;

    private final void A(GProStFeed stFeed) {
        int i3;
        if (this.contentBgIv == null) {
            this.contentBgIv = v();
        }
        RoundCornerLayout roundCornerLayout = this.mediaContainer;
        View view = null;
        if (roundCornerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
            roundCornerLayout = null;
        }
        roundCornerLayout.removeAllViews();
        GuildRoundBubbleImageView guildRoundBubbleImageView = this.contentBgIv;
        if (guildRoundBubbleImageView != null) {
            ViewExtKt.a(guildRoundBubbleImageView);
        }
        RoundCornerLayout roundCornerLayout2 = this.mediaContainer;
        if (roundCornerLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
            roundCornerLayout2 = null;
        }
        roundCornerLayout2.addView(this.contentBgIv);
        com.tencent.mobileqq.guild.feed.util.n b16 = m.b(stFeed);
        View view2 = this.gifLabel;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifLabel");
        } else {
            view = view2;
        }
        if (b16.getType() == 1) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        if (!TextUtils.isEmpty(b16.getUrl())) {
            y(b16.getUrl());
        } else if (!TextUtils.isEmpty(stFeed.defaultBackgroundImg)) {
            y(stFeed.defaultBackgroundImg);
        }
    }

    @RequiresApi(api = 22)
    private final void B() {
        GuildRoundBubbleImageView guildRoundBubbleImageView = this.contentBgIv;
        if (guildRoundBubbleImageView != null) {
            guildRoundBubbleImageView.setAccessibilityTraversalBefore(R.id.wbi);
        }
        GuildRoundBubbleImageView guildRoundBubbleImageView2 = this.contentBgIv;
        if (guildRoundBubbleImageView2 != null) {
            guildRoundBubbleImageView2.setContentDescription(QQGuildUIUtil.r(R.string.f14867108));
        }
    }

    private final void C() {
        Logger logger = Logger.f235387a;
        RelativeLayout relativeLayout = null;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            RelativeLayout relativeLayout2 = this.containerView;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                relativeLayout2 = null;
            }
            int measuredWidth = relativeLayout2.getMeasuredWidth();
            RelativeLayout relativeLayout3 = this.containerView;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                relativeLayout3 = null;
            }
            d16.d("GuildFeedSquareLongContentSection", 1, "updateContainerSize from " + measuredWidth + HippyTKDListViewAdapter.X + relativeLayout3.getMeasuredHeight() + " to " + x() + HippyTKDListViewAdapter.X + w());
        }
        RelativeLayout relativeLayout4 = this.containerView;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        } else {
            relativeLayout = relativeLayout4;
        }
        o.a(relativeLayout, (int) (x() * 0.54f), (int) (w() * 0.54f));
    }

    private final void s(GProStFeed stFeed, int position) {
        C();
        if (bm.r(stFeed)) {
            GProStVideo gProStVideo = stFeed.videos.get(0);
            Intrinsics.checkNotNullExpressionValue(gProStVideo, "stFeed.videos.get(0)");
            GProStImage gProStImage = stFeed.cover;
            Intrinsics.checkNotNullExpressionValue(gProStImage, "stFeed.cover");
            t(gProStVideo, gProStImage, position);
            return;
        }
        A(stFeed);
    }

    private final void t(GProStVideo stVideo, GProStImage cover, int position) {
        this.videoControllerIoc = (xj1.f) SectionIOCKt.getIocInterface(this, xj1.f.class);
        View view = this.gifLabel;
        RoundCornerLayout roundCornerLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifLabel");
            view = null;
        }
        view.setVisibility(8);
        boolean z16 = true;
        if (this.playView == null) {
            RoundCornerLayout roundCornerLayout2 = this.mediaContainer;
            if (roundCornerLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
                roundCornerLayout2 = null;
            }
            roundCornerLayout2.removeAllViews();
            RoundCornerLayout roundCornerLayout3 = this.mediaContainer;
            if (roundCornerLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
                roundCornerLayout3 = null;
            }
            Context context = roundCornerLayout3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mediaContainer.context");
            this.playView = new LongFeedVideoView(context);
        } else {
            RoundCornerLayout roundCornerLayout4 = this.mediaContainer;
            if (roundCornerLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
                roundCornerLayout4 = null;
            }
            if (roundCornerLayout4.indexOfChild(this.playView) != -1) {
                z16 = false;
            } else {
                RoundCornerLayout roundCornerLayout5 = this.mediaContainer;
                if (roundCornerLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
                    roundCornerLayout5 = null;
                }
                roundCornerLayout5.removeAllViews();
                LongFeedVideoView longFeedVideoView = this.playView;
                if (longFeedVideoView != null) {
                    ViewExtKt.a(longFeedVideoView);
                }
            }
        }
        LongFeedVideoView longFeedVideoView2 = this.playView;
        if (longFeedVideoView2 != null) {
            Pair<Integer, Integer> d16 = GuildFeedMediaSizeUtils.f219296d.d();
            longFeedVideoView2.setCoverSize(TuplesKt.to(Integer.valueOf((int) (d16.getFirst().floatValue() * 0.54f)), Integer.valueOf((int) (d16.getSecond().floatValue() * 0.54f))));
        }
        LongFeedVideoView longFeedVideoView3 = this.playView;
        if (longFeedVideoView3 != null) {
            longFeedVideoView3.setData(stVideo, position);
        }
        LongFeedVideoView longFeedVideoView4 = this.playView;
        if (longFeedVideoView4 != null) {
            longFeedVideoView4.B0(stVideo, cover);
        }
        if (z16) {
            RoundCornerLayout roundCornerLayout6 = this.mediaContainer;
            if (roundCornerLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
            } else {
                roundCornerLayout = roundCornerLayout6;
            }
            roundCornerLayout.addView(this.playView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        GProStFeed getRawFeedData = ((pn1.a) this.mData).getGetRawFeedData();
        Pair<String, ? extends ArrayList<n>> pair = this.mMixedMediaDataPair;
        if (pair != null) {
            if (pair == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataPair");
                pair = null;
            }
            if (Intrinsics.areEqual(pair.getFirst(), getRawFeedData.idd)) {
                return;
            }
        }
        this.mMixedMediaDataPair = new Pair<>(getRawFeedData.idd, n.m(((pn1.a) this.mData).getGetRawFeedData()));
    }

    private final GuildRoundBubbleImageView v() {
        RoundCornerLayout roundCornerLayout = this.mediaContainer;
        if (roundCornerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
            roundCornerLayout = null;
        }
        Context context = roundCornerLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mediaContainer.context");
        GuildRoundBubbleImageView guildRoundBubbleImageView = new GuildRoundBubbleImageView(context);
        guildRoundBubbleImageView.setId(R.id.waq);
        guildRoundBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int e16 = (int) cw.e(0.3f);
        guildRoundBubbleImageView.setPadding(e16, e16, e16, 0);
        guildRoundBubbleImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        float f16 = H;
        guildRoundBubbleImageView.setRadii(new float[]{f16, f16, f16, f16, f16, f16, f16, f16});
        return guildRoundBubbleImageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int w() {
        return GuildFeedMediaSizeUtils.f219296d.d().getSecond().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int x() {
        return (int) GuildFeedMediaSizeUtils.f219296d.c();
    }

    private final void y(String url) {
        GuildRoundBubbleImageView guildRoundBubbleImageView = this.contentBgIv;
        if (guildRoundBubbleImageView == null) {
            return;
        }
        GuildFeedListImageExKt.g(guildRoundBubbleImageView, url, TuplesKt.to(Integer.valueOf(x()), Integer.valueOf(w())), null, GuildFeedListImageExKt.c(guildRoundBubbleImageView), null, false, false, false, null, 500, null);
    }

    @Override // com.tencent.biz.richframework.animation.transition.TransitionHelper.TransitionBeanCreator
    @NotNull
    public TransitionBean generateTransitionBean(int currentPos) {
        TransitionBean transitionBean = new TransitionBean();
        transitionBean.setEnterViewRect(this.contentBgIv);
        u();
        Pair<String, ? extends ArrayList<n>> pair = this.mMixedMediaDataPair;
        Pair<String, ? extends ArrayList<n>> pair2 = null;
        if (pair == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataPair");
            pair = null;
        }
        GProStImage gProStImage = pair.getSecond().get(0).d().cover;
        if (gProStImage != null) {
            Pair<String, ? extends ArrayList<n>> pair3 = this.mMixedMediaDataPair;
            if (pair3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataPair");
            } else {
                pair2 = pair3;
            }
            n nVar = pair2.getSecond().get(currentPos);
            Intrinsics.checkNotNullExpressionValue(nVar, "mMixedMediaDataPair.second[currentPos]");
            transitionBean.setStImage(bm.f(nVar), gProStImage.width, gProStImage.height);
        }
        return transitionBean;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.wat};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        LongFeedVideoView longFeedVideoView;
        QLog.i("GuildFeedSquareLongContentSection", 1, "onAttachedChanged attached=" + attached + " mPosition=" + this.mPosition);
        if (!attached && (longFeedVideoView = this.playView) != null) {
            longFeedVideoView.a();
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        LongFeedVideoView longFeedVideoView = this.playView;
        if (longFeedVideoView != null) {
            longFeedVideoView.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.war);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026m_long_content_container)");
        this.containerView = (RelativeLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.wav);
        RoundCornerLayout roundCornerLayout = (RoundCornerLayout) findViewById2;
        float f16 = H;
        roundCornerLayout.setRadius(f16, f16, f16, f16);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026VIEW_RADIUS_DP)\n        }");
        this.mediaContainer = roundCornerLayout;
        View findViewById3 = containerView.findViewById(R.id.wau);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026g_content_text_container)");
        this.textContainer = (ViewGroup) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.w9p);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026.id.guild_feed_gif_label)");
        this.gifLabel = findViewById4;
        int x16 = x();
        ViewGroup viewGroup = this.textContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textContainer");
            viewGroup = null;
        }
        this.textOnlyComponents = new SearchGuildLongFeedTextOnlyComponents(x16, viewGroup);
        this.mTransitionBeanCreatorKey = TransitionHelper.g().registerTransitionBeanCreator(this);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        yj1.e a16;
        yj1.e a17;
        super.onVisibleChanged(visible);
        QLog.i("GuildFeedSquareLongContentSection", 1, "onVisibleChanged visible=" + visible + " mPosition=" + this.mPosition);
        if (visible && this.playView != null) {
            xj1.f fVar = this.videoControllerIoc;
            if (fVar != null && (a17 = fVar.a()) != null) {
                int i3 = this.mPosition;
                View mRootView = this.mRootView;
                Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
                LongFeedVideoView longFeedVideoView = this.playView;
                Intrinsics.checkNotNull(longFeedVideoView);
                a17.a(i3, mRootView, longFeedVideoView);
                return;
            }
            return;
        }
        xj1.f fVar2 = this.videoControllerIoc;
        if (fVar2 != null && (a16 = fVar2.a()) != null) {
            a16.e(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable pn1.a data, int position, @Nullable List<Object> payload) {
        List<String> list;
        Collection<String> a16;
        if (data == null) {
            return;
        }
        GProStFeed getRawFeedData = data.getGetRawFeedData();
        if (GuildLongFeedContentComponents.INSTANCE.c(getRawFeedData)) {
            RelativeLayout relativeLayout = this.containerView;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                relativeLayout = null;
            }
            relativeLayout.setVisibility(8);
        } else {
            RelativeLayout relativeLayout2 = this.containerView;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                relativeLayout2 = null;
            }
            relativeLayout2.setVisibility(0);
            RelativeLayout relativeLayout3 = this.containerView;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                relativeLayout3 = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(cw.d(8));
            int c16 = (int) cw.c(0.3f);
            RelativeLayout relativeLayout4 = this.containerView;
            if (relativeLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                relativeLayout4 = null;
            }
            gradientDrawable.setStroke(c16, relativeLayout4.getResources().getColor(R.color.qui_common_border_standard));
            relativeLayout3.setBackground(gradientDrawable);
        }
        SearchGuildLongFeedTextOnlyComponents searchGuildLongFeedTextOnlyComponents = this.textOnlyComponents;
        if (searchGuildLongFeedTextOnlyComponents == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textOnlyComponents");
            searchGuildLongFeedTextOnlyComponents = null;
        }
        SearchDataExt ext = data.getExt();
        if (ext != null && (a16 = ext.a()) != null) {
            list = CollectionsKt___CollectionsKt.toList(a16);
        } else {
            list = null;
        }
        searchGuildLongFeedTextOnlyComponents.c(getRawFeedData, list, null);
        s(getRawFeedData, position);
        B();
    }
}
