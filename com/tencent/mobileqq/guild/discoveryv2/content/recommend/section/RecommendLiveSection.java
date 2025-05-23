package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.RecommendReportHelperKt;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendLiveData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b;
import com.tencent.mobileqq.guild.discoveryv2.util.ExtKt;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.livemanager.player.GuildLivePlayerTag;
import com.tencent.mobileqq.guild.live.livemanager.player.j;
import com.tencent.mobileqq.guild.live.livemanager.player.l;
import com.tencent.mobileqq.guild.main.adapterdelegates.LottieAnimationViewEx;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u000e*\u0001=\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u001bB\u0007\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J(\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000eJ\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010\u001eR\u0016\u0010+\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010\"R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001a\u0010D\u001a\u0002038\u0016X\u0096D\u00a2\u0006\f\n\u0004\bA\u00105\u001a\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010E\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendLiveSection;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendLiveData;", "Lcom/tencent/guild/aio/util/ex/c;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/b;", "", HippyTKDListViewAdapter.X, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "v", NodeProps.VISIBLE, "w", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onVisibleChanged", NodeProps.ON_LONG_CLICK, NodeProps.ON_CLICK, DomainData.DOMAIN_NAME, "a", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mBg", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mDesc", "Lcom/tencent/mobileqq/guild/main/adapterdelegates/LottieAnimationViewEx;", tl.h.F, "Lcom/tencent/mobileqq/guild/main/adapterdelegates/LottieAnimationViewEx;", "mIconLottie", "i", "mIconBg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mStatus", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", "mContainer", "D", "Landroid/view/View;", "mVideoView", "", "E", "Ljava/lang/String;", "mVideoUrl", "Lcom/tencent/mobileqq/guild/live/livemanager/player/h;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "u", "()Lcom/tencent/mobileqq/guild/live/livemanager/player/h;", "playerMgr", "com/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendLiveSection$b", "G", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendLiveSection$b;", "playerInfoListener", "H", "getType", "()Ljava/lang/String;", "type", "()I", "playPriority", "<init>", "()V", "I", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendLiveSection extends ar<RecommendLiveData> implements com.tencent.guild.aio.util.ex.c, com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b {
    private static final int J = Color.parseColor("#FFB682");
    private static final int K = Color.parseColor("#FF9B58");

    @NotNull
    private static final GuildLivePlayerTag L = GuildLivePlayerTag.DISCOVER_CARD;

    /* renamed from: C, reason: from kotlin metadata */
    private FrameLayout mContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View mVideoView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String mVideoUrl = "";

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy playerMgr;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b playerInfoListener;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final String type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mBg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mDesc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationViewEx mIconLottie;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mIconBg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendLiveSection$b", "Lcom/tencent/mobileqq/guild/live/livemanager/player/j;", "", "onFirstFrameCome", "onCurrentLoopEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements com.tencent.mobileqq.guild.live.livemanager.player.j {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
        public void onCurrentLoopEnd() {
            QLog.d("RecommendLiveSection", 1, "onCurrentLoopEnd ");
            TextView textView = RecommendLiveSection.this.mStatus;
            LottieAnimationViewEx lottieAnimationViewEx = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStatus");
                textView = null;
            }
            textView.setText("\u76f4\u64ad\u5df2\u7ed3\u675f");
            LottieAnimationViewEx lottieAnimationViewEx2 = RecommendLiveSection.this.mIconLottie;
            if (lottieAnimationViewEx2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
            } else {
                lottieAnimationViewEx = lottieAnimationViewEx2;
            }
            lottieAnimationViewEx.pauseAnimation();
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
        public void onError() {
            j.a.b(this);
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
        public void onFirstFrameCome() {
            RecommendLiveSection.this.w(4);
            QLog.d("RecommendLiveSection", 1, " onFirstFrameCome ");
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
        public void onVideoSizeChanged(int i3, int i16) {
            j.a.c(this, i3, i16);
        }
    }

    public RecommendLiveSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.live.livemanager.player.h>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendLiveSection$playerMgr$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.live.livemanager.player.h invoke() {
                return new com.tencent.mobileqq.guild.live.livemanager.player.h();
            }
        });
        this.playerMgr = lazy;
        this.playerInfoListener = new b();
        this.type = "Live";
    }

    private final com.tencent.mobileqq.guild.live.livemanager.player.h u() {
        return (com.tencent.mobileqq.guild.live.livemanager.player.h) this.playerMgr.getValue();
    }

    private final boolean x() {
        ViewParent viewParent;
        ViewParent viewParent2;
        String str = this.mVideoUrl;
        if (TextUtils.isEmpty(str)) {
            QLog.i("RecommendLiveSection", 1, "startPlayer url is empty");
            return false;
        }
        com.tencent.mobileqq.guild.live.livemanager.player.h u16 = u();
        GuildLivePlayerTag guildLivePlayerTag = L;
        this.mVideoView = l.a.a(u16, str, guildLivePlayerTag, 2, true, false, 16, null);
        u().d(guildLivePlayerTag, this.playerInfoListener);
        FrameLayout frameLayout = this.mContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            frameLayout = null;
        }
        if (frameLayout.indexOfChild(this.mVideoView) > -1) {
            QLog.i("RecommendLiveSection", 1, "the same url and player video view, ignore");
            return true;
        }
        View view = this.mVideoView;
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            View view2 = this.mVideoView;
            if (view2 != null) {
                viewParent2 = view2.getParent();
            } else {
                viewParent2 = null;
            }
            Intrinsics.checkNotNull(viewParent2, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) viewParent2).removeView(this.mVideoView);
        }
        FrameLayout frameLayout3 = this.mContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        } else {
            frameLayout2 = frameLayout3;
        }
        frameLayout2.addView(this.mVideoView, 0, new FrameLayout.LayoutParams(-1, -1));
        return true;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b
    public boolean a() {
        QLog.i("RecommendLiveSection", 1, "tryPause");
        u().r(L);
        w(0);
        VideoReport.unbindVideoPlayerInfo(getRootView());
        return true;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b
    @NotNull
    public String getType() {
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b
    public int i() {
        return this.mPosition;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b
    public void l() {
        b.a.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b
    public boolean n() {
        Long l3;
        Long l16;
        Long l17;
        Map<String, ?> mapOf;
        FrameLayout frameLayout = this.mContainer;
        Long l18 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            frameLayout = null;
        }
        if (ExtKt.c(frameLayout) <= 0.5d) {
            a();
            return false;
        }
        QLog.i("RecommendLiveSection", 1, "tryPlay");
        boolean x16 = x();
        if (x16) {
            View rootView = getRootView();
            VideoEntity.Builder builder = new VideoEntity.Builder();
            RecommendLiveData recommendLiveData = (RecommendLiveData) this.mData;
            if (recommendLiveData != null) {
                l3 = Long.valueOf(recommendLiveData.getRoomId());
            } else {
                l3 = null;
            }
            VideoEntity.Builder videoView = builder.setContentId(String.valueOf(l3)).setContentType(2).setPage((Object) ci1.a.c()).setVideoView(getRootView());
            Pair[] pairArr = new Pair[6];
            T mData = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            pairArr[0] = TuplesKt.to("sgrp_eid", RecommendReportHelperKt.b((com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l) mData));
            pairArr[1] = TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, ((RecommendLiveData) this.mData).getRecommendExtData().getTraceId());
            pairArr[2] = TuplesKt.to("sgrp_rank", Integer.valueOf(this.mPosition));
            RecommendLiveData recommendLiveData2 = (RecommendLiveData) this.mData;
            if (recommendLiveData2 != null) {
                l16 = Long.valueOf(recommendLiveData2.getRoomId());
            } else {
                l16 = null;
            }
            pairArr[3] = TuplesKt.to("sgrp_video_id", String.valueOf(l16));
            RecommendLiveData recommendLiveData3 = (RecommendLiveData) this.mData;
            if (recommendLiveData3 != null) {
                l17 = Long.valueOf(recommendLiveData3.getGuildId());
            } else {
                l17 = null;
            }
            pairArr[4] = TuplesKt.to("sgrp_channel_id", l17);
            RecommendLiveData recommendLiveData4 = (RecommendLiveData) this.mData;
            if (recommendLiveData4 != null) {
                l18 = Long.valueOf(recommendLiveData4.getChannelId());
            }
            pairArr[5] = TuplesKt.to("sgrp_sub_channel_id", l18);
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            VideoReport.bindVideoPlayerInfo(rootView, videoView.addCustomParams(mapOf).build());
        }
        return x16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        Pair<String, String> b16 = r().b(((RecommendLiveData) this.mData).getItemType());
        String component1 = b16.component1();
        String component2 = b16.component2();
        String valueOf = String.valueOf(((RecommendLiveData) this.mData).getGuildId());
        String valueOf2 = String.valueOf(((RecommendLiveData) this.mData).getChannelId());
        byte[] joinSig = ((RecommendLiveData) this.mData).getJoinSig();
        Intrinsics.checkNotNullExpressionValue(joinSig, "mData.joinSig");
        JumpGuildParam jumpGuildParam = new JumpGuildParam(valueOf, valueOf2, new String(joinSig, Charsets.UTF_8), component1, component2);
        Context context = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        GuildJumpUtil.n(context, jumpGuildParam);
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        FrameLayout frameLayout = null;
        this.mVideoView = null;
        FrameLayout frameLayout2 = this.mContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.removeAllViews();
        u().b(L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.f71363ny);
            Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.recommend_live_bg)");
            this.mBg = (ImageView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.w5s);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026d_discovery_v2_feed_text)");
            this.mDesc = (TextView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.wvq);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026ild_recommend_right_icon)");
            this.mIconLottie = (LottieAnimationViewEx) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.f71373nz);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026d.recommend_live_bg_icon)");
            this.mIconBg = (ImageView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.w2a);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026.id.guild_channel_status)");
            this.mStatus = (TextView) findViewById5;
            View findViewById6 = containerView.findViewById(R.id.f165218li0);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewById(R.id.fl_container)");
            this.mContainer = (FrameLayout) findViewById6;
            View rootView = getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            ViewExtKt.b(rootView, this);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@NotNull View v3) {
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.d p16 = p();
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        boolean i3 = p16.i((com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l) mData, v3, this.mPosition);
        EventCollector.getInstance().onViewLongClicked(v3);
        return i3;
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        LottieAnimationViewEx lottieAnimationViewEx = null;
        if (!visible) {
            w(0);
            q().g().b(this);
            LottieAnimationViewEx lottieAnimationViewEx2 = this.mIconLottie;
            if (lottieAnimationViewEx2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
            } else {
                lottieAnimationViewEx = lottieAnimationViewEx2;
            }
            lottieAnimationViewEx.pauseAnimation();
            return;
        }
        q().g().a(this);
        LottieAnimationViewEx lottieAnimationViewEx3 = this.mIconLottie;
        if (lottieAnimationViewEx3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
        } else {
            lottieAnimationViewEx = lottieAnimationViewEx3;
        }
        lottieAnimationViewEx.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull RecommendLiveData data, int position, @Nullable List<Object> payload) {
        ImageView imageView;
        ImageView imageView2;
        Intrinsics.checkNotNullParameter(data, "data");
        boolean z16 = true;
        QLog.d("RecommendLiveSection", 1, "RecommendLiveSection data.liveTitle: " + data.getLiveTitle() + " data.channelId: " + data.getChannelId() + " data.guildId: " + data.getGuildId() + " data.roomId: " + data.getRoomId() + data.getStreamInfo() + " cover" + data.getCover());
        String flvUrl = data.getStreamInfo().getFlvUrl();
        Intrinsics.checkNotNullExpressionValue(flvUrl, "data.streamInfo.flvUrl");
        this.mVideoUrl = flvUrl;
        String cover = data.getCover();
        Intrinsics.checkNotNullExpressionValue(cover, "data.cover");
        if (cover.length() <= 0) {
            z16 = false;
        }
        TextView textView = null;
        if (z16) {
            com.tencent.mobileqq.guild.discoveryv2.util.d dVar = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
            ImageView imageView3 = this.mBg;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBg");
                imageView2 = null;
            } else {
                imageView2 = imageView3;
            }
            com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, imageView2, data.getCover(), 0, 0, false, 28, null);
        } else {
            ImageView imageView4 = this.mBg;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBg");
                imageView4 = null;
            }
            imageView4.setBackground(GuildUIUtils.f235378a.k(J, K, 255));
            ImageView imageView5 = this.mIconBg;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconBg");
                imageView5 = null;
            }
            imageView5.setVisibility(0);
            com.tencent.mobileqq.guild.discoveryv2.util.d dVar2 = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
            ImageView imageView6 = this.mIconBg;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconBg");
                imageView = null;
            } else {
                imageView = imageView6;
            }
            com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar2, imageView, "https://downv6.qq.com/innovate/guild_mvp_live_bg_icon.png", 0, 0, false, 28, null);
        }
        LottieAnimationViewEx lottieAnimationViewEx = this.mIconLottie;
        if (lottieAnimationViewEx == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
            lottieAnimationViewEx = null;
        }
        lottieAnimationViewEx.setVisibility(0);
        LottieAnimationViewEx lottieAnimationViewEx2 = this.mIconLottie;
        if (lottieAnimationViewEx2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
            lottieAnimationViewEx2 = null;
        }
        lottieAnimationViewEx2.setAnimation(getRootView().getContext().getString(R.string.f152801ad));
        LottieAnimationViewEx lottieAnimationViewEx3 = this.mIconLottie;
        if (lottieAnimationViewEx3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
            lottieAnimationViewEx3 = null;
        }
        lottieAnimationViewEx3.playAnimation();
        TextView textView2 = this.mDesc;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDesc");
            textView2 = null;
        }
        textView2.setVisibility(0);
        TextView textView3 = this.mDesc;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDesc");
            textView3 = null;
        }
        textView3.setText(data.getLiveTitle());
        TextView textView4 = this.mStatus;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStatus");
        } else {
            textView = textView4;
        }
        textView.setText(getRootView().getContext().getString(R.string.f142030i_));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w(int visible) {
        String cover;
        boolean z16;
        RecommendLiveData recommendLiveData = (RecommendLiveData) this.mData;
        boolean z17 = false;
        if (recommendLiveData != null && (cover = recommendLiveData.getCover()) != null) {
            if (cover.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        ImageView imageView = null;
        if (z17) {
            ImageView imageView2 = this.mBg;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBg");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(visible);
            return;
        }
        ImageView imageView3 = this.mIconBg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIconBg");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(visible);
    }
}
