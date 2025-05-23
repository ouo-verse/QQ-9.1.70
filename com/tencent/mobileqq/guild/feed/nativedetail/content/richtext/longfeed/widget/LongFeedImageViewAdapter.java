package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.api.impl.GuildFeedImagePreDecoder;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseSceneType;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 [2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001%B7\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010,\u001a\u00020*\u0012\u0006\u0010/\u001a\u00020-\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u00107\u001a\u00020\u000b\u0012\u0006\u00109\u001a\u00020\u000b\u00a2\u0006\u0004\bY\u0010ZJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u0014\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0006\u0010\u001f\u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020 J\b\u0010\"\u001a\u00020\u0017H\u0016J\u0016\u0010%\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060#H\u0016R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001a\u00107\u001a\u00020\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u00104\u001a\u0004\b5\u00106R\u001a\u00109\u001a\u00020\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u00104\u001a\u0004\b8\u00106R\u0016\u0010<\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R-\u0010F\u001a\u0014 B*\n\u0018\u00010@j\u0004\u0018\u0001`A0@j\u0002`A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010C\u001a\u0004\bD\u0010ER\"\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010IR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010C\u001a\u0004\bM\u0010NR\u001b\u0010S\u001a\u00020P8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010C\u001a\u0004\b\u0005\u0010RR\u0011\u0010W\u001a\u00020T8F\u00a2\u0006\u0006\u001a\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u00106\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/LongFeedImageViewAdapter;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/BaseLongFeedViewAdapter;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/h;", "Landroid/view/View;", "v", "", "B", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlin/Pair;", "", "y", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/h;", "viewSizeChangedNotifier", "c", "", "event", "", "data", "f", "view", "g", "", "l", "getWidth", "getHeight", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/BaseLongFeedViewAdapter$TYPE;", "k", "j", "onDestroyView", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/biz/richframework/animation/transition/TransitionBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "d", "Lkotlin/Function0;", "onLoaded", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "parseParam", "", UserInfo.SEX_FEMALE, "widthPercent", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "image", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;", "e", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;", "sceneType", "I", "u", "()I", "index", HippyTKDListViewAdapter.X, "paragraphIndex", tl.h.F, "Z", "hadImageLoaded", "i", "Lkotlin/jvm/functions/Function0;", "onImageLoadedListener", "Lqj1/i;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayableSupplier;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "t", "()Lqj1/i;", "feedMainDisplayableSupplier", "Lkotlin/Pair;", "mTargetSize", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/h;", "mViewSizeChangedNotifier", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "()Landroid/widget/ImageView;", "mImageView", "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "mContainer", "Landroid/content/Context;", "r", "()Landroid/content/Context;", "context", "mediaIndex", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;FLcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;II)V", "o", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class LongFeedImageViewAdapter extends BaseLongFeedViewAdapter implements com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h, h {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LongFeedParseParam parseParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float widthPercent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProStImage image;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LongFeedParseSceneType sceneType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int paragraphIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hadImageLoaded;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> onImageLoadedListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy feedMainDisplayableSupplier;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Pair<Integer, Integer> mTargetSize;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.h mViewSizeChangedNotifier;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mImageView;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/LongFeedImageViewAdapter$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GuildPicStateListener {
        b() {
            super(false);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@Nullable LoadState state, @Nullable Option option) {
            boolean z16;
            String str;
            Logger logger = Logger.f235387a;
            String str2 = null;
            if (QLog.isDebugVersion()) {
                Logger.a d16 = logger.d();
                if (option != null) {
                    str = option.getUrl();
                } else {
                    str = null;
                }
                d16.d("LongFeedImageViewAdapter", 1, "loadImage state:" + state + " url:" + str);
            }
            boolean z17 = false;
            if (state != null && state.isFinishError()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (option != null) {
                    str2 = option.getUrl();
                }
                QLog.e("LongFeedImageViewAdapter", 1, "[loadImage] error: " + state + ", picUrl: " + str2);
            }
            if (state != null && state.isFinishSuccess()) {
                z17 = true;
            }
            if (z17) {
                LongFeedImageViewAdapter.this.hadImageLoaded = true;
                Function0 function0 = LongFeedImageViewAdapter.this.onImageLoadedListener;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }
    }

    public LongFeedImageViewAdapter(@NotNull LongFeedParseParam parseParam, float f16, @NotNull GProStImage image, @NotNull LongFeedParseSceneType sceneType, int i3, int i16) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(parseParam, "parseParam");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        this.parseParam = parseParam;
        this.widthPercent = f16;
        this.image = image;
        this.sceneType = sceneType;
        this.index = i3;
        this.paragraphIndex = i16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<qj1.i>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedImageViewAdapter$feedMainDisplayableSupplier$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final qj1.i invoke() {
                LongFeedParseParam longFeedParseParam;
                RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
                longFeedParseParam = LongFeedImageViewAdapter.this.parseParam;
                return (qj1.i) g16.getIocInterface(qj1.i.class, longFeedParseParam.getTextViewContainer(), null);
            }
        });
        this.feedMainDisplayableSupplier = lazy;
        this.mTargetSize = y();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedImageViewAdapter$mImageView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                final ImageView imageView = new ImageView(LongFeedImageViewAdapter.this.r());
                final LongFeedImageViewAdapter longFeedImageViewAdapter = LongFeedImageViewAdapter.this;
                final long j3 = 200;
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedImageViewAdapter$mImageView$2$invoke$lambda$0$$inlined$setSingleClickListener$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View it) {
                        EventCollector.getInstance().onViewClickedBefore(it);
                        imageView.setClickable(false);
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        longFeedImageViewAdapter.B(it);
                        final View view = imageView;
                        view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedImageViewAdapter$mImageView$2$invoke$lambda$0$$inlined$setSingleClickListener$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                view.setClickable(true);
                            }
                        }, j3);
                        EventCollector.getInstance().onViewClicked(it);
                    }
                });
                return imageView;
            }
        });
        this.mImageView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<RoundCornerLayout>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedImageViewAdapter$mContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundCornerLayout invoke() {
                ImageView w3;
                RoundCornerLayout roundCornerLayout = new RoundCornerLayout(LongFeedImageViewAdapter.this.r());
                w3 = LongFeedImageViewAdapter.this.w();
                w3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                w3.setScaleType(ImageView.ScaleType.FIT_CENTER);
                roundCornerLayout.addView(w3);
                LayoutInflater.from(roundCornerLayout.getContext()).inflate(R.layout.eoh, (ViewGroup) roundCornerLayout, true);
                return roundCornerLayout;
            }
        });
        this.mContainer = lazy3;
    }

    private final void A() {
        this.mTargetSize = y();
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.h hVar = this.mViewSizeChangedNotifier;
        if (hVar != null) {
            hVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(View v3) {
        ImageView imageView;
        Object obj;
        GuildFeedPublishInfo guildFeedPublishInfo;
        qj1.h hVar;
        yl1.b.f(yl1.b.f450589a, v3, "em_sgrp_forum_full_screen", null, 4, null);
        j jVar = j.f221614a;
        if (v3 instanceof ImageView) {
            imageView = (ImageView) v3;
        } else {
            imageView = null;
        }
        qj1.i t16 = t();
        if (t16 != null && (hVar = t16.get()) != null) {
            obj = hVar.a();
        } else {
            obj = null;
        }
        GProStImage gProStImage = this.image;
        int businessType = this.parseParam.getBusinessType();
        rl1.a aVar = (rl1.a) RFWIocAbilityProvider.g().getIocInterface(rl1.a.class, v3, null);
        if (aVar != null) {
            guildFeedPublishInfo = aVar.e();
        } else {
            guildFeedPublishInfo = null;
        }
        jVar.b(imageView, obj, gProStImage, businessType, guildFeedPublishInfo);
    }

    private final void C() {
        Option loadingDrawable = Option.obtain().setTargetView(w()).setUrl(pl1.a.d(this.image)).setRequestWidth(getWidth()).setRequestHeight(getHeight()).setLoadingDrawable(com.tencent.mobileqq.guild.feed.api.impl.j.b(GuildFeedImagePreDecoder.INSTANCE, bm.a(this.image)));
        w().setImageDrawable(loadingDrawable.getLoadingDrawable());
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("LongFeedImageViewAdapter", 1, "loadImage start url:" + loadingDrawable.getUrl());
        }
        com.tencent.mobileqq.guild.picload.e.a().f(loadingDrawable, new b());
    }

    private final qj1.i t() {
        return (qj1.i) this.feedMainDisplayableSupplier.getValue();
    }

    private final RoundCornerLayout v() {
        return (RoundCornerLayout) this.mContainer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView w() {
        return (ImageView) this.mImageView.getValue();
    }

    private final Pair<Integer, Integer> y() {
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a;
        GProStImage gProStImage = this.image;
        return bVar.f(gProStImage.width, gProStImage.height, this.widthPercent, this.sceneType);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.h
    public void a(@NotNull Function0<Unit> onLoaded) {
        Intrinsics.checkNotNullParameter(onLoaded, "onLoaded");
        this.onImageLoadedListener = onLoaded;
        if (this.hadImageLoaded) {
            onLoaded.invoke();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h
    public int b() {
        return this.image.displayIndex;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    @NotNull
    public View c(@Nullable com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.h viewSizeChangedNotifier) {
        this.mViewSizeChangedNotifier = viewSizeChangedNotifier;
        C();
        View findViewById = v().findViewById(R.id.w9p);
        Boolean valueOf = Boolean.valueOf(this.image.isGif);
        findViewById.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, findViewById)) == null) {
            findViewById.setVisibility(8);
        }
        return v();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.h
    /* renamed from: d, reason: from getter */
    public boolean getHadImageLoaded() {
        return this.hadImageLoaded;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public void f(@Nullable String event, @Nullable Object data) {
        if (Intrinsics.areEqual(event, "EVENT_TYPE_CONFIGURATION_CHANGE")) {
            A();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public void g(@Nullable View view) {
        super.g(view);
        QLog.i("LongFeedImageViewAdapter", 4, "[onViewVisible:Image] url: " + pl1.a.d(this.image));
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public int getHeight() {
        return this.mTargetSize.getSecond().intValue();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public int getWidth() {
        return this.mTargetSize.getFirst().intValue();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter
    @NotNull
    public String j() {
        return com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a.g(this.image, getIndex(), getParagraphIndex());
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter
    @NotNull
    public BaseLongFeedViewAdapter.TYPE k() {
        return BaseLongFeedViewAdapter.TYPE.IMAGE;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter
    public boolean l() {
        if (this.widthPercent >= 100.0f) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Context r() {
        Context context = this.parseParam.getTextViewContainer().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parseParam.textViewContainer.context");
        return context;
    }

    public final int s() {
        return this.image.displayIndex;
    }

    /* renamed from: u, reason: from getter */
    public int getIndex() {
        return this.index;
    }

    /* renamed from: x, reason: from getter */
    public int getParagraphIndex() {
        return this.paragraphIndex;
    }

    @NotNull
    public final TransitionBean z() {
        TransitionBean transitionBean = new TransitionBean();
        String d16 = pl1.a.d(this.image);
        GProStImage gProStImage = this.image;
        transitionBean.setStImage(d16, gProStImage.width, gProStImage.height);
        transitionBean.setEnterViewRect(w());
        transitionBean.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return transitionBean;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public void onDestroyView() {
    }
}
