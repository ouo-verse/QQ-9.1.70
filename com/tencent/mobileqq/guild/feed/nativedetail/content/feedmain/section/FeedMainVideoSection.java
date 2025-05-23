package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.LongFeedVideoView;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.event.FeedContentScrollEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.FeedMainVideoSection;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b*\u0001I\u0018\u0000 -2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001OB\u0007\u00a2\u0006\u0004\bM\u0010NJ\u0014\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J4\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J4\u0010\u001b\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\u0012\u0010 \u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\u0012\u0010&\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010*\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030(0'j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030(`)H\u0016R\"\u00101\u001a\u00020\u001e8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010A\u001a\u00020:8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001e\u0010H\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/FeedMainVideoSection;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/e;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lqj1/l;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/IMediaDisplayable;", "firstPic", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "width", "height", "Lkotlin/Pair;", "B", "containerW", "containerH", UserInfo.SEX_FEMALE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "data", "", "position", "", "", "payloads", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$c;", "payload", "t", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", NodeProps.VISIBLE, "onVisibleChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "()Landroid/view/View;", "H", "(Landroid/view/View;)V", "videoContainer", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/LongFeedVideoView;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/LongFeedVideoView;", "G", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/LongFeedVideoView;", "K", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/LongFeedVideoView;)V", "videoView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "D", "()Landroid/widget/ImageView;", "J", "(Landroid/widget/ImageView;)V", "videoCover", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", tl.h.F, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "stVideo", "i", "Lqj1/l;", "videoData", "com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/FeedMainVideoSection$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/FeedMainVideoSection$b;", "mConfigurationListener", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedMainVideoSection extends e implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public View videoContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public LongFeedVideoView videoView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public ImageView videoCover;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GProStVideo stVideo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private qj1.l videoData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mConfigurationListener = new b();

    private final void A() {
        boolean z16;
        Rect rect = new Rect();
        if (G().getGlobalVisibleRect(rect) && rect.height() > 0 && rect.width() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            G().play();
        } else {
            G().pause();
        }
    }

    private final Pair<Float, Float> B(float width, float height) {
        float coerceIn;
        float i3 = GuildSplitViewUtils.f235370a.i(true, C().getContext()) - (ViewUtils.dpToPx(16.0f) * 2);
        float f16 = (4 * i3) / 3;
        float f17 = i3 / 2;
        if (width > 0.0f && height > 0.0f) {
            coerceIn = RangesKt___RangesKt.coerceIn((height * i3) / width, f17, f16);
            return TuplesKt.to(Float.valueOf(i3), Float.valueOf(coerceIn));
        }
        QLog.e("FeedMainVideoSection", 1, "getMeasureSize: width or height is invalid");
        return TuplesKt.to(Float.valueOf(i3), Float.valueOf(f16));
    }

    private final Pair<Float, Float> F(float containerW, float containerH, float width, float height) {
        float f16 = width / height;
        if (f16 > containerW / containerH) {
            return TuplesKt.to(Float.valueOf(containerW), Float.valueOf(containerW / f16));
        }
        return TuplesKt.to(Float.valueOf(f16 * containerH), Float.valueOf(containerH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(qj1.l firstPic) {
        float width = firstPic.getWidth();
        float height = firstPic.getHeight();
        Pair<Float, Float> B = B(width, height);
        float floatValue = B.component1().floatValue();
        float floatValue2 = B.component2().floatValue();
        View C = C();
        ViewGroup.LayoutParams layoutParams = C.getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.height = (int) floatValue2;
            layoutParams2.width = (int) floatValue;
            layoutParams2.gravity = 17;
            C.setLayoutParams(layoutParams2);
            Pair<Float, Float> F = F(floatValue, floatValue2, width, height);
            float floatValue3 = F.component1().floatValue();
            float floatValue4 = F.component2().floatValue();
            View F0 = G().F0();
            ViewGroup.LayoutParams layoutParams3 = F0.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.width = (int) floatValue3;
                layoutParams3.height = (int) floatValue4;
                F0.setLayoutParams(layoutParams3);
                QLog.i("FeedMainVideoSection", 1, "adjustView src:" + width + "-" + height + " container:" + floatValue + "-" + floatValue2 + " view:" + floatValue3 + "-" + floatValue4);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    @NotNull
    public final View C() {
        View view = this.videoContainer;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
        return null;
    }

    @NotNull
    public final ImageView D() {
        ImageView imageView = this.videoCover;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
        return null;
    }

    @NotNull
    public final LongFeedVideoView G() {
        LongFeedVideoView longFeedVideoView = this.videoView;
        if (longFeedVideoView != null) {
            return longFeedVideoView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
        return null;
    }

    public final void H(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.videoContainer = view;
    }

    public final void J(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.videoCover = imageView;
    }

    public final void K(@NotNull LongFeedVideoView longFeedVideoView) {
        Intrinsics.checkNotNullParameter(longFeedVideoView, "<set-?>");
        this.videoView = longFeedVideoView;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(FeedContentScrollEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.v1e};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        C().getContext().unregisterComponentCallbacks(this.mConfigurationListener);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        if (this.videoView != null) {
            G().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        View stubView = getStubView(R.id.v1e);
        Intrinsics.checkNotNullExpressionValue(stubView, "getStubView(R.id.feed_content_main_video_stub)");
        H(stubView);
        View findViewById = C().findViewById(R.id.f165184v35);
        Intrinsics.checkNotNullExpressionValue(findViewById, "videoContainer.findViewB\u2026.feed_nativedetail_video)");
        K((LongFeedVideoView) findViewById);
        View findViewById2 = G().findViewById(R.id.wbk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "videoView.findViewById(R\u2026ld_feed_item_video_cover)");
        J((ImageView) findViewById2);
        G().setRadius(ShortFeedPicLineSection.INSTANCE.c());
        G().z0(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.FeedMainVideoSection$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                GProStVideo gProStVideo;
                Object obj;
                Integer businessType;
                Intrinsics.checkNotNullParameter(it, "it");
                gProStVideo = FeedMainVideoSection.this.stVideo;
                if (gProStVideo != null) {
                    FeedMainVideoSection feedMainVideoSection = FeedMainVideoSection.this;
                    com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.j jVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.j.f221614a;
                    ImageView D = feedMainVideoSection.D();
                    obj = ((Section) feedMainVideoSection).mData;
                    Object a16 = ((FeedDetailMainData) obj).getFeedDetail().a();
                    rl1.a p16 = feedMainVideoSection.p();
                    int intValue = (p16 == null || (businessType = p16.getBusinessType()) == null) ? 0 : businessType.intValue();
                    rl1.a p17 = feedMainVideoSection.p();
                    Integer a17 = p17 != null ? p17.a() : null;
                    rl1.a aVar = (rl1.a) SectionIOCKt.getIocInterface(feedMainVideoSection, rl1.a.class);
                    GuildFeedPublishInfo e16 = aVar != null ? aVar.e() : null;
                    rl1.a p18 = feedMainVideoSection.p();
                    jVar.c(D, a16, gProStVideo, intValue, a17, e16, p18 != null ? p18.getTopicId() : null);
                    LongFeedVideoView G = feedMainVideoSection.G();
                    VideoReport.setElementId(G, "em_sgrp_forum_full_screen");
                    VideoReport.setElementClickPolicy(G, ClickPolicy.REPORT_NONE);
                    VideoReport.reportEvent("clck", G, null);
                }
            }
        });
        G().setShowMuteIcon(true);
        C().getContext().registerComponentCallbacks(this.mConfigurationListener);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        FeedContentScrollEvent feedContentScrollEvent;
        if (event instanceof FeedContentScrollEvent) {
            feedContentScrollEvent = (FeedContentScrollEvent) event;
        } else {
            feedContentScrollEvent = null;
        }
        if (feedContentScrollEvent == null) {
            return;
        }
        FeedContentScrollEvent feedContentScrollEvent2 = (FeedContentScrollEvent) event;
        if (feedContentScrollEvent2.mHashCode != 0) {
            View rootView = getRootView();
            boolean z16 = false;
            if (rootView != null && feedContentScrollEvent2.mHashCode == rootView.hashCode()) {
                z16 = true;
            }
            if (z16) {
                if (this.videoView == null) {
                    QLog.e("FeedMainVideoSection", 1, "videoView not init");
                } else if (feedContentScrollEvent2.getNewState() == 0 && this.mData != 0 && this.videoData != null) {
                    A();
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        super.onVisibleChanged(visible);
        if (this.videoView == null) {
            QLog.e("FeedMainVideoSection", 1, "videoView not init");
        } else if (visible) {
            G().play();
        } else {
            G().pause();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    protected void t(@Nullable FeedDetailMainData data, int position, @Nullable List<Object> payloads, @Nullable FeedDetailMainData.c.C7755c payload) {
        String str;
        Object obj;
        GProStVideo gProStVideo;
        String str2;
        boolean z16;
        if (data == null) {
            return;
        }
        Iterator<T> it = data.getFeedDetail().c().iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((qj1.l) obj).getType() == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        qj1.l lVar = (qj1.l) obj;
        if (lVar == null) {
            C().setVisibility(8);
            QLog.i("FeedMainVideoSection", 1, "no video, video GONE");
            return;
        }
        C().setVisibility(0);
        Object raw = lVar.getRaw();
        if (raw instanceof GProStVideo) {
            gProStVideo = (GProStVideo) raw;
        } else {
            gProStVideo = null;
        }
        if (gProStVideo == null) {
            return;
        }
        LongFeedVideoView G = G();
        GProStImage gProStImage = gProStVideo.cover;
        Intrinsics.checkNotNullExpressionValue(gProStImage, "gProStVideo.cover");
        G.B0(gProStVideo, gProStImage);
        GProStVideo gProStVideo2 = this.stVideo;
        if (gProStVideo2 != null) {
            if (gProStVideo2 != null) {
                str2 = gProStVideo2.fileId;
            } else {
                str2 = null;
            }
            if (!Intrinsics.areEqual(str2, gProStVideo.fileId)) {
                GProStVideo gProStVideo3 = this.stVideo;
                if (gProStVideo3 != null) {
                    str = gProStVideo3.fileId;
                }
                QLog.i("FeedMainVideoSection", 1, "video data changed old:" + str + " new:" + gProStVideo.fileId);
                G().a();
                G().play();
            }
        }
        this.stVideo = gProStVideo;
        z(lVar);
        this.videoData = lVar;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/FeedMainVideoSection$b", "Landroid/content/ComponentCallbacks;", "Landroid/content/res/Configuration;", "newConfig", "", "onConfigurationChanged", "onLowMemory", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ComponentCallbacks {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(FeedMainVideoSection this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.videoData != null) {
                qj1.l lVar = this$0.videoData;
                Intrinsics.checkNotNull(lVar);
                this$0.z(lVar);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(@NotNull Configuration newConfig) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            FeedMainVideoSection feedMainVideoSection = FeedMainVideoSection.this;
            if (feedMainVideoSection.videoContainer != null && feedMainVideoSection.videoData != null) {
                if (AppSetting.t(FeedMainVideoSection.this.C().getContext())) {
                    View C = FeedMainVideoSection.this.C();
                    final FeedMainVideoSection feedMainVideoSection2 = FeedMainVideoSection.this;
                    C.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            FeedMainVideoSection.b.b(FeedMainVideoSection.this);
                        }
                    }, 10L);
                } else {
                    FeedMainVideoSection feedMainVideoSection3 = FeedMainVideoSection.this;
                    qj1.l lVar = feedMainVideoSection3.videoData;
                    Intrinsics.checkNotNull(lVar);
                    feedMainVideoSection3.z(lVar);
                }
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }
}
