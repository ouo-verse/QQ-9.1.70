package com.tencent.mobileqq.guild.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.discoveryv2.content.part.ContentPart;
import com.tencent.mobileqq.guild.discoveryv2.content.preload.loadmore.PreloadMoreStrategyPart;
import com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshPart;
import com.tencent.mobileqq.guild.discoveryv2.fragment.MVPFeedsDepends;
import com.tencent.mobileqq.guild.discoveryv2.fragment.d;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.picload.GuildFeedPicLoader;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.theme.QuiBitmapResourceObtainColorHelper;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import oh1.DrawableType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J&\u0010\u000f\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0013\u001a\u00020\u0007H\u0014J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/GuildFeedMyFeedsFragmentV2;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "Landroid/view/View$OnClickListener;", "", "Hh", "Lh", "Kh", "", "Gh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Landroid/view/View;", "contentView", "onViewCreatedBeforePartInit", "getContentLayoutId", "view", NodeProps.ON_CLICK, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onBackEvent", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/e;", "T", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/e;", "depends", "Lcom/tencent/mobileqq/guild/theme/d;", "U", "Lcom/tencent/mobileqq/guild/theme/d;", "mThemeChangedCallback", "V", "I", "mMyFeedsType", "<init>", "()V", "W", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedMyFeedsFragmentV2 extends QQGuildTokenTitleBarFragment implements View.OnClickListener {

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.discoveryv2.fragment.e depends;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.theme.d mThemeChangedCallback = new com.tencent.mobileqq.guild.theme.d() { // from class: com.tencent.mobileqq.guild.feed.c
        @Override // com.tencent.mobileqq.guild.theme.d
        public final void onThemeChanged() {
            GuildFeedMyFeedsFragmentV2.Jh(GuildFeedMyFeedsFragmentV2.this);
        }
    };

    /* renamed from: V, reason: from kotlin metadata */
    private int mMyFeedsType = 1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J6\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/GuildFeedMyFeedsFragmentV2$a;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "extra", "", "a", "", "guildId", "userId", "from", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.GuildFeedMyFeedsFragmentV2$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull Bundle extra) {
            Intrinsics.checkNotNullParameter(extra, "extra");
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtras(extra);
            qw1.b.r(intent, com.tencent.mobileqq.guild.util.report.b.a(""));
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildFeedMyFeedsFragmentV2.class, null, 8, null);
        }

        public final void b(@Nullable Context context, @NotNull String guildId, @Nullable String userId, @Nullable String from, @Nullable Bundle extra) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (extra == null) {
                extra = new Bundle();
            }
            QLog.d("GuildFeedMyLikesFragmentV2", 1, "showPostFeedByGuildId " + guildId);
            extra.putString("feed_my_post_guild_id", guildId);
            extra.putString("feed_my_post_user_tiny_id", userId);
            a(context, extra);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0005\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/feed/GuildFeedMyFeedsFragmentV2$b", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/MVPFeedsDepends;", "", "getContentWidth", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "c", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "e", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "clickProcessor", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "d", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "()Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "joinSourceDepends", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends MVPFeedsDepends {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.discoveryv2.content.recommend.d clickProcessor;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.discoveryv2.fragment.d joinSourceDepends;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Lkotlin/Pair;", "", "a", "(ILjava/lang/Object;)Lkotlin/Pair;"}, k = 3, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        static final class a implements com.tencent.mobileqq.guild.discoveryv2.fragment.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ GuildFeedMyFeedsFragmentV2 f217914a;

            a(GuildFeedMyFeedsFragmentV2 guildFeedMyFeedsFragmentV2) {
                this.f217914a = guildFeedMyFeedsFragmentV2;
            }

            @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.d
            @NotNull
            public final Pair<String, String> a(int i3, @Nullable Object obj) {
                JumpGuildParam.JoinInfoParam joinInfoParam;
                String str;
                Bundle arguments = this.f217914a.getArguments();
                String str2 = null;
                if (arguments != null) {
                    joinInfoParam = (JumpGuildParam.JoinInfoParam) arguments.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
                } else {
                    joinInfoParam = null;
                }
                QLog.d("GuildFeedMyLikesFragmentV2", 1, "JoinInfoParam=" + joinInfoParam);
                if (joinInfoParam != null) {
                    str = joinInfoParam.getMainSource();
                } else {
                    str = null;
                }
                String str3 = "";
                if (str == null) {
                    str = "";
                }
                if (joinInfoParam != null) {
                    str2 = joinInfoParam.getSubSource();
                }
                if (str2 != null) {
                    str3 = str2;
                }
                return TuplesKt.to(str, str3);
            }

            @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.d
            @NotNull
            public Pair<String, String> b(int i3) {
                return d.a.a(this, i3);
            }
        }

        b(GuildFeedMyFeedsFragmentV2 guildFeedMyFeedsFragmentV2) {
            this.clickProcessor = new com.tencent.mobileqq.guild.discoveryv2.content.recommend.d(guildFeedMyFeedsFragmentV2.Gh());
            this.joinSourceDepends = new a(guildFeedMyFeedsFragmentV2);
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        @NotNull
        /* renamed from: c, reason: from getter */
        public com.tencent.mobileqq.guild.discoveryv2.fragment.d getJoinSourceDepends() {
            return this.joinSourceDepends;
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        @NotNull
        /* renamed from: e, reason: from getter */
        public com.tencent.mobileqq.guild.discoveryv2.content.recommend.d getClickProcessor() {
            return this.clickProcessor;
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.MVPFeedsDepends, com.tencent.mobileqq.guild.discoveryv2.fragment.e
        public int getContentWidth() {
            return GuildSplitViewUtils.j(GuildSplitViewUtils.f235370a, true, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Gh() {
        if (this.mMyFeedsType == 2) {
            return 4;
        }
        return 3;
    }

    private final void Hh() {
        Bundle arguments = getArguments();
        int i3 = 1;
        if (arguments != null) {
            i3 = arguments.getInt("feed_my_feeds_type", 1);
        }
        this.mMyFeedsType = i3;
        this.depends = new b(this);
        this.C.setOnClickListener(this);
        this.C.setFocusable(false);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        LiveData<Integer> g16 = QuiBitmapResourceObtainColorHelper.g(requireContext, R.drawable.qui_common_bg_bottom_standard_bg);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.feed.GuildFeedMyFeedsFragmentV2$initViewsAndData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Integer num) {
                if (num != null) {
                    GuildFeedMyFeedsFragmentV2.this.N.setBackgroundColor(kotlin.g.a(num.intValue(), 80));
                }
            }
        };
        g16.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedMyFeedsFragmentV2.Ih(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(GuildFeedMyFeedsFragmentV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Lh();
    }

    private final void Kh() {
        Map mapOf;
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_mine_forum_scene");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_pg_type", Integer.valueOf(this.mMyFeedsType)));
        VideoReport.setPageParams(this.P, new PageParams((Map<String, ?>) mapOf));
    }

    private final void Lh() {
        DrawableType drawableType = new DrawableType(R.drawable.guild_audio_top_back_left_btn, Integer.valueOf(R.color.qui_common_icon_primary));
        TextView leftView = this.C;
        Intrinsics.checkNotNullExpressionValue(leftView, "leftView");
        drawableType.a(leftView);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        int i3;
        IPerformanceReportTask iPerformanceReportTask;
        int i16;
        List<Part> mutableListOf;
        IPerformanceReportTask d16;
        String str;
        Bundle arguments = getArguments();
        if (arguments != null) {
            i3 = arguments.getInt("feed_my_feeds_type", 1);
        } else {
            i3 = 1;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (d16 = qw1.b.d(arguments2, null, 1, null)) != null) {
            if (i3 != 1) {
                if (i3 != 2) {
                    str = "guild_unknown_event_code";
                } else {
                    str = "guild_my_like";
                }
            } else {
                str = "guild_my_post";
            }
            iPerformanceReportTask = d16.setEventCode(str);
        } else {
            iPerformanceReportTask = null;
        }
        Part[] partArr = new Part[8];
        TextView centerView = this.E;
        Intrinsics.checkNotNullExpressionValue(centerView, "centerView");
        partArr[0] = new e(centerView, this.mMyFeedsType);
        if (Gh() == 4) {
            i16 = R.string.f1507015p;
        } else {
            i16 = R.string.f1507115q;
        }
        partArr[1] = new com.tencent.mobileqq.guild.discoveryv2.tips.e(i16);
        partArr[2] = new com.tencent.mobileqq.guild.discoveryv2.content.part.c();
        partArr[3] = new ContentPart(com.tencent.mobileqq.guild.discoveryv2.fragment.g.a(), iPerformanceReportTask);
        partArr[4] = new RefreshPart(com.tencent.mobileqq.guild.discoveryv2.fragment.g.a());
        partArr[5] = new PreloadMoreStrategyPart();
        partArr[6] = new j(getArguments(), Gh());
        partArr[7] = new com.tencent.mobileqq.guild.discoveryv2.content.part.e(0, 1, null);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        Hh();
        Lh();
        Kh();
        GuildThemeManager.g(this.mThemeChangedCallback);
        GuildSplitViewUtils.f235370a.B(this.N);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f2w;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.C && !o.c("fastClickGuard")) {
            onBackEvent();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        GuildThemeManager.j(this.mThemeChangedCallback);
        GuildFeedPicLoader.f231079a.f();
        fi1.b.f398763a.d();
        PartFragmentIOCKt.unregisterIoc(this, com.tencent.mobileqq.guild.discoveryv2.fragment.e.class);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QUIImmersiveHelper.s(getActivity(), true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        com.tencent.mobileqq.guild.discoveryv2.fragment.e eVar = this.depends;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("depends");
            eVar = null;
        }
        PartFragmentIOCKt.registerIoc(this, eVar, com.tencent.mobileqq.guild.discoveryv2.fragment.e.class);
    }
}
