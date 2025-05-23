package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendFeedsGuildData;
import com.tencent.mobileqq.guild.discoveryv2.content.view.DiscoveryV2RootView;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.RunKtKt;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001'\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00011B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0004H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendFeedsListSection;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendFeedsGuildData;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View;", "containerView", "", "B", UserInfo.SEX_FEMALE, "", "getViewStubLayoutId", "onInitView", "data", "", "position", "", "", "payload", "D", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "v", "", NodeProps.ON_LONG_CLICK, "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/e;", "f", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/e;", "contentAdapter", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/e;", tl.h.F, "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/e;", "newDepends", "Lzh1/a;", "i", "Lzh1/a;", "event", "com/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendFeedsListSection$c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendFeedsListSection$c;", "itemDecoration", "Lkotlin/Function0;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function0;", "registerIocOnce", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendFeedsListSection extends ar<RecommendFeedsGuildData> implements View.OnLongClickListener {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int E = QQGuildUIUtil.l(R.dimen.cdz) * 2;

    @NotNull
    private static final float[] F;

    @NotNull
    private static final int[] G;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.guild.discoveryv2.content.base.e contentAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.guild.discoveryv2.fragment.e newDepends;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private zh1.a event;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c itemDecoration = new c();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private Function0<Unit> registerIocOnce = RunKtKt.a(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendFeedsListSection$registerIocOnce$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            RecommendFeedsListSection.this.F();
        }
    });

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendFeedsListSection$a;", "", "", "MEDIA_LAYOUT_ROUND_CORNER", "[F", "a", "()[F", "", "TEXT_PADDING", "[I", "b", "()[I", "", "RECOMMEND_SPACE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendFeedsListSection$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final float[] a() {
            return RecommendFeedsListSection.F;
        }

        @NotNull
        public final int[] b() {
            return RecommendFeedsListSection.G;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendFeedsListSection$b", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "canScrollHorizontally", "canScrollVertically", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends LinearLayoutManager {
        b(Context context) {
            super(context, 0, false);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendFeedsListSection$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.set(0, 0, RecommendFeedsListSection.E, 0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendFeedsListSection$d", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/e;", "", "f", "", "getContentWidth", "d", "b", "a", tl.h.F, "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "c", "()Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "joinSourceDepends", "Lcom/tencent/mvi/base/route/j;", "getMessage", "()Lcom/tencent/mvi/base/route/j;", "message", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/c;", "g", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/c;", "playableManager", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "e", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "clickProcessor", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements com.tencent.mobileqq.guild.discoveryv2.fragment.e {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ com.tencent.mobileqq.guild.discoveryv2.fragment.e f217194a;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendFeedsListSection$d$a", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendAbsFeedData;", "data", "Landroid/view/View;", "v", "", "position", "", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class a extends com.tencent.mobileqq.guild.discoveryv2.content.recommend.d {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ RecommendFeedsListSection f217196b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(RecommendFeedsListSection recommendFeedsListSection, int i3) {
                super(i3);
                this.f217196b = recommendFeedsListSection;
            }

            @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.d
            public boolean d(@NotNull RecommendAbsFeedData data, @NotNull View v3, int position) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(v3, "v");
                com.tencent.mobileqq.guild.discoveryv2.content.recommend.d p16 = this.f217196b.p();
                Object mData = ((Section) this.f217196b).mData;
                Intrinsics.checkNotNullExpressionValue(mData, "mData");
                return p16.i((com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l) mData, v3, ((Section) this.f217196b).mPosition);
            }
        }

        d() {
            this.f217194a = RecommendFeedsListSection.this.q();
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        public int a() {
            return b();
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        public int b() {
            return RecommendFeedsListSection.this.q().b() - ((int) RecommendFeedsListSection.this.getRootView().getResources().getDimension(R.dimen.f158965ce0));
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        @NotNull
        /* renamed from: c */
        public com.tencent.mobileqq.guild.discoveryv2.fragment.d getJoinSourceDepends() {
            return this.f217194a.getJoinSourceDepends();
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        public int d() {
            return 0;
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        @NotNull
        /* renamed from: e */
        public com.tencent.mobileqq.guild.discoveryv2.content.recommend.d getClickProcessor() {
            return new a(RecommendFeedsListSection.this, RecommendFeedsListSection.this.q().getClickProcessor().getSource());
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        public boolean f() {
            return this.f217194a.f();
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        @NotNull
        public com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.c g() {
            return this.f217194a.g();
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        public int getContentWidth() {
            return this.f217194a.getContentWidth();
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        @NotNull
        public com.tencent.mvi.base.route.j getMessage() {
            return this.f217194a.getMessage();
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        public int h() {
            return (b() / 4) * 5;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendFeedsListSection$e", "Lzh1/a;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements zh1.a {
        e() {
        }
    }

    static {
        float dimension = MobileQQ.sMobileQQ.getResources().getDimension(R.dimen.f158966ce1);
        F = new float[]{dimension, dimension, dimension, dimension};
        G = new int[]{bi.b(5), bi.b(10), bi.b(5), bi.b(5)};
    }

    private final void B(View containerView) {
        View findViewById = containerView.findViewById(R.id.f165181v32);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026R.id.feed_item_card_list)");
        this.mRecyclerView = (RecyclerView) findViewById;
        com.tencent.mobileqq.guild.discoveryv2.content.base.e eVar = new com.tencent.mobileqq.guild.discoveryv2.content.base.e(new com.tencent.mobileqq.guild.discoveryv2.content.base.d(), xh1.a.f448007a);
        eVar.setHasStableIds(true);
        this.contentAdapter = eVar;
        final RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new b(containerView.getContext()));
        com.tencent.mobileqq.guild.discoveryv2.content.base.e eVar2 = this.contentAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
            eVar2 = null;
        }
        recyclerView.setAdapter(eVar2);
        recyclerView.setItemAnimator(null);
        recyclerView.addItemDecoration(this.itemDecoration);
        recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.r
            @Override // java.lang.Runnable
            public final void run() {
                RecommendFeedsListSection.C(RecommendFeedsListSection.this, recyclerView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(RecommendFeedsListSection this$0, RecyclerView this_apply) {
        RecyclerView.RecycledViewPool recycledViewPool;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        zh1.b bVar = (zh1.b) SectionIOCKt.getIocInterface(this$0, zh1.b.class);
        if (bVar != null) {
            recycledViewPool = bVar.getFeedsCardPool();
        } else {
            recycledViewPool = null;
        }
        if (recycledViewPool != null) {
            this_apply.setRecycledViewPool(recycledViewPool);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        this.newDepends = new d();
        this.event = new e();
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        RecyclerView recyclerView = this.mRecyclerView;
        com.tencent.mobileqq.guild.discoveryv2.fragment.e eVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        zh1.a aVar = this.event;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("event");
            aVar = null;
        }
        g16.registerIoc(recyclerView, aVar, zh1.a.class);
        RFWIocAbilityProvider g17 = RFWIocAbilityProvider.g();
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView2 = null;
        }
        com.tencent.mobileqq.guild.discoveryv2.fragment.e eVar2 = this.newDepends;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newDepends");
        } else {
            eVar = eVar2;
        }
        g17.registerIoc(recyclerView2, eVar, com.tencent.mobileqq.guild.discoveryv2.fragment.e.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull RecommendFeedsGuildData data, int position, @Nullable List<Object> payload) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(data, "data");
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        RecyclerView recyclerView = null;
        if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.setFullSpan(true);
        }
        View mRootView = this.mRootView;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        ViewGroup.LayoutParams layoutParams3 = mRootView.getLayoutParams();
        if (layoutParams3 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
            marginLayoutParams.bottomMargin = bi.b(6);
            mRootView.setLayoutParams(marginLayoutParams);
            View view = this.mRootView;
            view.setLayoutParams(view.getLayoutParams());
            this.registerIocOnce.invoke();
            com.tencent.mobileqq.guild.discoveryv2.content.base.e eVar = this.contentAdapter;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
                eVar = null;
            }
            eVar.setItems(null);
            com.tencent.mobileqq.guild.discoveryv2.content.base.e eVar2 = this.contentAdapter;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
                eVar2 = null;
            }
            eVar2.setItems(Util.toImmutableList(data.getRecommendFeeds()));
            if (QQGuildUIUtil.z()) {
                RecyclerView recyclerView2 = this.mRecyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                    recyclerView2 = null;
                }
                final int width = recyclerView2.getWidth();
                RecyclerView recyclerView3 = this.mRecyclerView;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                } else {
                    recyclerView = recyclerView3;
                }
                recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendFeedsListSection$onBindData$2$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tencent.mobileqq.guild.discoveryv2.content.base.e eVar3;
                        int i3 = width;
                        if (i3 != 0) {
                            RecyclerView recyclerView4 = this.mRecyclerView;
                            com.tencent.mobileqq.guild.discoveryv2.content.base.e eVar4 = null;
                            if (recyclerView4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                                recyclerView4 = null;
                            }
                            if (i3 != recyclerView4.getWidth()) {
                                eVar3 = this.contentAdapter;
                                if (eVar3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
                                } else {
                                    eVar4 = eVar3;
                                }
                                eVar4.notifyDataSetChanged();
                            }
                        }
                    }
                });
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.wfo};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        g16.unregisterSingleIoc(recyclerView, com.tencent.mobileqq.guild.discoveryv2.fragment.e.class);
        RFWIocAbilityProvider g17 = RFWIocAbilityProvider.g();
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        g17.unregisterSingleIoc(recyclerView2, zh1.a.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        DiscoveryV2RootView discoveryV2RootView = null;
        if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.setFullSpan(true);
        }
        View view = this.mRootView;
        view.setLayoutParams(view.getLayoutParams());
        View view2 = this.mRootView;
        if (view2 instanceof DiscoveryV2RootView) {
            discoveryV2RootView = (DiscoveryV2RootView) view2;
        }
        if (discoveryV2RootView != null) {
            discoveryV2RootView.setRadius(com.tencent.guild.aio.util.c.b(8));
        }
        B(containerView);
        this.mRootView.setOnLongClickListener(this);
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
}
