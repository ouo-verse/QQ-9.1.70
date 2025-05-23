package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.LongFeedVideoView;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseSceneType;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedVideoPlayManager;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001XB7\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010$\u001a\u00020\"\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00100\u001a\u00020\t\u0012\u0006\u00101\u001a\u00020\t\u00a2\u0006\u0004\bU\u0010VJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0012\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u00100\u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010-\u001a\u0004\b.\u0010/R\u001a\u00101\u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b\u0004\u0010/R\"\u00103\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u00108\u001a\u0004\b9\u0010:R\u001b\u0010?\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u00108\u001a\u0004\b=\u0010>R\u001b\u0010C\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u00108\u001a\u0004\bA\u0010BR#\u0010I\u001a\n E*\u0004\u0018\u00010D0D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u00108\u001a\u0004\bG\u0010HR-\u0010O\u001a\u0014 E*\n\u0018\u00010Jj\u0004\u0018\u0001`K0Jj\u0002`K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u00108\u001a\u0004\bM\u0010NR\u001c\u0010S\u001a\n E*\u0004\u0018\u00010P0P8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010/\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/LongFeedVideoViewAdapter;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/BaseLongFeedViewAdapter;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/h;", "Landroid/view/View;", "v", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lkotlin/Pair;", "", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/h;", "viewSizeChangedNotifier", "c", "", "event", "", "data", "f", "", "l", "getWidth", "getHeight", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/BaseLongFeedViewAdapter$TYPE;", "k", "j", "view", "g", tl.h.F, "onDestroyView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "parseParam", "", UserInfo.SEX_FEMALE, "widthPercent", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "d", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", QCircleScheme.AttrDetail.VIDEO_INFO, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;", "e", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;", "sceneType", "I", ReportConstant.COSTREPORT_PREFIX, "()I", "index", "paragraphIndex", "Lkotlin/Pair;", "mTargetSize", "i", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/h;", "mViewSizeChangedNotifier", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/LongFeedVideoView;", "Lkotlin/Lazy;", "u", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/LongFeedVideoView;", "mPlayView", "Landroid/widget/ImageView;", "y", "()Landroid/widget/ImageView;", "videoCover", "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "t", "()Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "mContainer", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/f;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/f;", "playManager", "Lqj1/i;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayableSupplier;", DomainData.DOMAIN_NAME, "r", "()Lqj1/i;", "feedMainDisplayableSupplier", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/content/Context;", "context", "mediaIndex", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;FLcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;II)V", "o", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class LongFeedVideoViewAdapter extends BaseLongFeedViewAdapter implements com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LongFeedParseParam parseParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float widthPercent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProStVideo videoInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LongFeedParseSceneType sceneType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int paragraphIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Pair<Integer, Integer> mTargetSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.h mViewSizeChangedNotifier;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mPlayView;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy videoCover;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy playManager;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy feedMainDisplayableSupplier;

    public LongFeedVideoViewAdapter(@NotNull LongFeedParseParam parseParam, float f16, @NotNull GProStVideo videoInfo, @NotNull LongFeedParseSceneType sceneType, int i3, int i16) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(parseParam, "parseParam");
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        this.parseParam = parseParam;
        this.widthPercent = f16;
        this.videoInfo = videoInfo;
        this.sceneType = sceneType;
        this.index = i3;
        this.paragraphIndex = i16;
        this.mTargetSize = x();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LongFeedVideoView>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedVideoViewAdapter$mPlayView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LongFeedVideoView invoke() {
                Context context;
                context = LongFeedVideoViewAdapter.this.q();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                LongFeedVideoView longFeedVideoView = new LongFeedVideoView(context);
                LongFeedVideoViewAdapter longFeedVideoViewAdapter = LongFeedVideoViewAdapter.this;
                longFeedVideoView.setShowMuteIcon(true);
                longFeedVideoView.z0(new LongFeedVideoViewAdapter$mPlayView$2$1$1(longFeedVideoViewAdapter));
                return longFeedVideoView;
            }
        });
        this.mPlayView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedVideoViewAdapter$videoCover$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                LongFeedVideoView u16;
                u16 = LongFeedVideoViewAdapter.this.u();
                return (ImageView) u16.findViewById(R.id.wbk);
            }
        });
        this.videoCover = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<RoundCornerLayout>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedVideoViewAdapter$mContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundCornerLayout invoke() {
                Context q16;
                LongFeedVideoView u16;
                q16 = LongFeedVideoViewAdapter.this.q();
                final RoundCornerLayout roundCornerLayout = new RoundCornerLayout(q16);
                final LongFeedVideoViewAdapter longFeedVideoViewAdapter = LongFeedVideoViewAdapter.this;
                u16 = longFeedVideoViewAdapter.u();
                u16.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                roundCornerLayout.addView(u16);
                float d16 = cw.d(6);
                roundCornerLayout.setRadius(d16, d16, d16, d16);
                final long j3 = 200;
                roundCornerLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedVideoViewAdapter$mContainer$2$invoke$lambda$1$$inlined$setSingleClickListener$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View it) {
                        EventCollector.getInstance().onViewClickedBefore(it);
                        roundCornerLayout.setClickable(false);
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        longFeedVideoViewAdapter.A(it);
                        final View view = roundCornerLayout;
                        view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedVideoViewAdapter$mContainer$2$invoke$lambda$1$$inlined$setSingleClickListener$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                view.setClickable(true);
                            }
                        }, j3);
                        EventCollector.getInstance().onViewClicked(it);
                    }
                });
                return roundCornerLayout;
            }
        });
        this.mContainer = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.f>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedVideoViewAdapter$playManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.f invoke() {
                LongFeedParseParam longFeedParseParam;
                RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
                longFeedParseParam = LongFeedVideoViewAdapter.this.parseParam;
                return (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.f) g16.getIocInterface(com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.f.class, longFeedParseParam.getTextViewContainer(), null);
            }
        });
        this.playManager = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<qj1.i>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedVideoViewAdapter$feedMainDisplayableSupplier$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final qj1.i invoke() {
                LongFeedParseParam longFeedParseParam;
                RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
                longFeedParseParam = LongFeedVideoViewAdapter.this.parseParam;
                return (qj1.i) g16.getIocInterface(qj1.i.class, longFeedParseParam.getTextViewContainer(), null);
            }
        });
        this.feedMainDisplayableSupplier = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(View v3) {
        Object obj;
        yl1.b.f(yl1.b.f450589a, v3, "em_sgrp_forum_full_screen", null, 4, null);
        j jVar = j.f221614a;
        ImageView y16 = y();
        qj1.h hVar = r().get();
        if (hVar != null) {
            obj = hVar.a();
        } else {
            obj = null;
        }
        jVar.c(y16, obj, this.videoInfo, this.parseParam.getBusinessType(), this.parseParam.getImmersiveSource(), this.parseParam.getFeedPublishInfo(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context q() {
        return this.parseParam.getTextViewContainer().getContext();
    }

    private final qj1.i r() {
        return (qj1.i) this.feedMainDisplayableSupplier.getValue();
    }

    private final RoundCornerLayout t() {
        return (RoundCornerLayout) this.mContainer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LongFeedVideoView u() {
        return (LongFeedVideoView) this.mPlayView.getValue();
    }

    private final com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.f w() {
        return (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.f) this.playManager.getValue();
    }

    private final Pair<Integer, Integer> x() {
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a;
        GProStVideo gProStVideo = this.videoInfo;
        return bVar.f(gProStVideo.width, gProStVideo.height, this.widthPercent, this.sceneType);
    }

    private final ImageView y() {
        Object value = this.videoCover.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-videoCover>(...)");
        return (ImageView) value;
    }

    private final void z() {
        this.mTargetSize = x();
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.h hVar = this.mViewSizeChangedNotifier;
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h
    public int b() {
        return this.videoInfo.displayIndex;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    @NotNull
    public View c(@Nullable com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.h viewSizeChangedNotifier) {
        this.mViewSizeChangedNotifier = viewSizeChangedNotifier;
        LongFeedVideoView u16 = u();
        GProStVideo gProStVideo = this.videoInfo;
        GProStImage gProStImage = gProStVideo.cover;
        Intrinsics.checkNotNullExpressionValue(gProStImage, "videoInfo.cover");
        u16.B0(gProStVideo, gProStImage);
        LongFeedVideoView u17 = u();
        Pair<Integer, Integer> x16 = x();
        u17.setCoverSize(new android.util.Pair<>(x16.getFirst(), x16.getSecond()));
        return t();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public void f(@Nullable String event, @Nullable Object data) {
        if (Intrinsics.areEqual(event, "EVENT_TYPE_CONFIGURATION_CHANGE")) {
            z();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public void g(@Nullable View view) {
        LongFeedVideoPlayManager longFeedVideoPlayManager;
        super.g(view);
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.f w3 = w();
        if (w3 != null && (longFeedVideoPlayManager = w3.get()) != null) {
            longFeedVideoPlayManager.e(this.videoInfo.displayIndex, u());
        }
        QLog.i("LongFeedVideoViewAdapter", 4, "[onViewVisible:Video] url: " + this.videoInfo.cover);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public int getHeight() {
        return this.mTargetSize.getSecond().intValue();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public int getWidth() {
        return this.mTargetSize.getFirst().intValue();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public void h(@Nullable View view) {
        LongFeedVideoPlayManager longFeedVideoPlayManager;
        super.h(view);
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.f w3 = w();
        if (w3 != null && (longFeedVideoPlayManager = w3.get()) != null) {
            longFeedVideoPlayManager.m(this.videoInfo.displayIndex, u());
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter
    @NotNull
    public String j() {
        return com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a.j(this.videoInfo, getIndex(), getParagraphIndex());
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter
    @NotNull
    public BaseLongFeedViewAdapter.TYPE k() {
        return BaseLongFeedViewAdapter.TYPE.VIDEO;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter
    public boolean l() {
        if (this.widthPercent >= 100.0f) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public void onDestroyView() {
        u().a();
    }

    /* renamed from: s, reason: from getter */
    public int getIndex() {
        return this.index;
    }

    /* renamed from: v, reason: from getter */
    public int getParagraphIndex() {
        return this.paragraphIndex;
    }
}
