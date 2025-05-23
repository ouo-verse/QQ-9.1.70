package com.tencent.mobileqq.guild.recently;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.tencent.mobileqq.guild.discoveryv2.widget.a;
import com.tencent.mobileqq.guild.picload.GuildFeedPicLoader;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.theme.QuiBitmapResourceObtainColorHelper;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import oh1.DrawableType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001!\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J&\u0010\u0013\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u001c\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0017\u001a\u00020\bH\u0014J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u001fH\u0016R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/recently/GuildRecentlyViewedFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "Landroid/view/View$OnClickListener;", "", "Ih", "Ph", "Nh", "Lh", "", "type", "Mh", "Rh", "Oh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Landroid/view/View;", "contentView", "onViewCreatedBeforePartInit", "getContentLayoutId", "view", NodeProps.ON_CLICK, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onBackEvent", "com/tencent/mobileqq/guild/recently/GuildRecentlyViewedFragment$b", "T", "Lcom/tencent/mobileqq/guild/recently/GuildRecentlyViewedFragment$b;", "depends", "Lcom/tencent/mobileqq/guild/theme/d;", "U", "Lcom/tencent/mobileqq/guild/theme/d;", "mThemeChangedCallback", "Lcom/tencent/mobileqq/guild/recently/g;", "V", "Lcom/tencent/mobileqq/guild/recently/g;", "mContentDataPart", "<init>", "()V", "W", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRecentlyViewedFragment extends QQGuildTokenTitleBarFragment implements View.OnClickListener {

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final b depends = new b();

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.theme.d mThemeChangedCallback = new com.tencent.mobileqq.guild.theme.d() { // from class: com.tencent.mobileqq.guild.recently.b
        @Override // com.tencent.mobileqq.guild.theme.d
        public final void onThemeChanged() {
            GuildRecentlyViewedFragment.Kh(GuildRecentlyViewedFragment.this);
        }
    };

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final g mContentDataPart = new g();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/recently/GuildRecentlyViewedFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "extra", "", "a", "", "PAGE_ID", "Ljava/lang/String;", "", "PANEL_BTN_TYPE_CANCEL", "I", "PANEL_BTN_TYPE_CLEAR", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.recently.GuildRecentlyViewedFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull Bundle extra) {
            Intrinsics.checkNotNullParameter(extra, "extra");
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtras(extra);
            qw1.b.r(intent, com.tencent.mobileqq.guild.util.report.b.a("guild_my_look"));
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildRecentlyViewedFragment.class, null, 8, null);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0005\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/recently/GuildRecentlyViewedFragment$b", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/MVPFeedsDepends;", "", "getContentWidth", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "c", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "e", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "clickProcessor", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "d", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "()Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "joinSourceDepends", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends MVPFeedsDepends {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.discoveryv2.content.recommend.d clickProcessor = new com.tencent.mobileqq.guild.discoveryv2.content.recommend.d(5);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.discoveryv2.fragment.d joinSourceDepends = a.f231970a;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Lkotlin/Pair;", "", "a", "(ILjava/lang/Object;)Lkotlin/Pair;"}, k = 3, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        static final class a implements com.tencent.mobileqq.guild.discoveryv2.fragment.d {

            /* renamed from: a, reason: collision with root package name */
            public static final a f231970a = new a();

            a() {
            }

            @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.d
            @NotNull
            public final Pair<String, String> a(int i3, @Nullable Object obj) {
                return TuplesKt.to("mine", "mine_like");
            }

            @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.d
            @NotNull
            public Pair<String, String> b(int i3) {
                return d.a.a(this, i3);
            }
        }

        b() {
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

    private final void Ih() {
        this.C.setOnClickListener(this);
        this.C.setFocusable(false);
        TextView centerView = this.E;
        Intrinsics.checkNotNullExpressionValue(centerView, "centerView");
        oh1.a.a(centerView, R.color.qui_common_text_primary);
        this.E.setText(R.string.f152751a9);
        Ph();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        LiveData<Integer> g16 = QuiBitmapResourceObtainColorHelper.g(requireContext, R.drawable.qui_common_bg_bottom_standard_bg);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.recently.GuildRecentlyViewedFragment$initViewsAndData$1
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
                    GuildRecentlyViewedFragment.this.N.setBackgroundColor(kotlin.g.a(num.intValue(), 80));
                }
            }
        };
        g16.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.recently.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRecentlyViewedFragment.Jh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(GuildRecentlyViewedFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Rh();
    }

    private final void Lh() {
        HashMap hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("dt_pgid", "pg_sgrp_recent_view"), TuplesKt.to("dt_eid", "em_sgrp_more_action"));
        VideoReport.reportEvent("clck", hashMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh(int type) {
        HashMap hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("dt_pgid", "pg_sgrp_recent_view"), TuplesKt.to("dt_eid", "em_sgrp_more_action_panel"), TuplesKt.to("sgrp_btn_type", Integer.valueOf(type)));
        VideoReport.reportEvent("clck", hashMapOf);
    }

    private final void Nh() {
        HashMap hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("dt_pgid", "pg_sgrp_recent_view"), TuplesKt.to("dt_eid", "em_sgrp_more_action_panel"));
        VideoReport.reportEvent("imp", hashMapOf);
    }

    private final void Oh() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_recent_view");
        VideoReport.setPageParams(this.P, null);
    }

    private final void Ph() {
        ImageView rightViewImg = this.G;
        Intrinsics.checkNotNullExpressionValue(rightViewImg, "rightViewImg");
        rightViewImg.setVisibility(0);
        this.G.setImageResource(R.drawable.qui_more_light);
        this.G.setEnabled(true);
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.recently.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildRecentlyViewedFragment.Qh(GuildRecentlyViewedFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(GuildRecentlyViewedFragment this$0, View view) {
        List<a.C7731a> listOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Lh();
        com.tencent.mobileqq.guild.discoveryv2.widget.a aVar = new com.tencent.mobileqq.guild.discoveryv2.widget.a();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new a.C7731a("\u6e05\u7a7a\u6d4f\u89c8\u8bb0\u5f55", new GuildRecentlyViewedFragment$setRightView$1$actionSheet$1$1(this$0)));
        aVar.d(listOf);
        aVar.c(new a.C7731a("\u53d6\u6d88", new GuildRecentlyViewedFragment$setRightView$1$actionSheet$1$2(this$0)));
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        aVar.a(requireContext).show();
        this$0.Nh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Rh() {
        Integer valueOf = Integer.valueOf(R.color.qui_common_icon_primary);
        DrawableType drawableType = new DrawableType(R.drawable.guild_audio_top_back_left_btn, valueOf);
        TextView leftView = this.C;
        Intrinsics.checkNotNullExpressionValue(leftView, "leftView");
        drawableType.a(leftView);
        DrawableType drawableType2 = new DrawableType(R.drawable.qui_more_light, valueOf);
        ImageView rightViewImg = this.G;
        Intrinsics.checkNotNullExpressionValue(rightViewImg, "rightViewImg");
        drawableType2.a(rightViewImg);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        IPerformanceReportTask iPerformanceReportTask;
        List<Part> mutableListOf;
        Part[] partArr = new Part[8];
        int i3 = 0;
        partArr[0] = new h();
        int i16 = 1;
        partArr[1] = new com.tencent.mobileqq.guild.discoveryv2.tips.g();
        partArr[2] = new com.tencent.mobileqq.guild.discoveryv2.content.part.c();
        com.tencent.mobileqq.guild.discoveryv2.fragment.f a16 = com.tencent.mobileqq.guild.discoveryv2.fragment.g.a();
        Bundle arguments = getArguments();
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (arguments != null) {
            iPerformanceReportTask = qw1.b.d(arguments, null, 1, null);
        } else {
            iPerformanceReportTask = null;
        }
        partArr[3] = new ContentPart(a16, iPerformanceReportTask);
        partArr[4] = new RefreshPart(com.tencent.mobileqq.guild.discoveryv2.fragment.g.a());
        partArr[5] = new PreloadMoreStrategyPart();
        partArr[6] = this.mContentDataPart;
        partArr[7] = new com.tencent.mobileqq.guild.discoveryv2.content.part.e(i3, i16, defaultConstructorMarker);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        Ih();
        Rh();
        Oh();
        GuildThemeManager.g(this.mThemeChangedCallback);
        GuildSplitViewUtils.f235370a.B(this.N);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f3w;
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
        PartFragmentIOCKt.registerIoc(this, this.depends, com.tencent.mobileqq.guild.discoveryv2.fragment.e.class);
    }
}
