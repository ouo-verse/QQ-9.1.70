package com.tencent.timi.game.liveroom.impl.room.view.rank.base;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.view.rank.RankViewModel;
import com.tencent.timi.game.liveroom.impl.room.view.rank.SelfRankInfoView;
import d55.j;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 T2\u00020\u0001:\u0001UB\u0011\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u00a2\u0006\u0004\bM\u0010NB\u001b\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u0012\b\u0010P\u001a\u0004\u0018\u00010O\u00a2\u0006\u0004\bM\u0010QB#\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u0012\b\u0010P\u001a\u0004\u0018\u00010O\u0012\u0006\u0010R\u001a\u00020\u0013\u00a2\u0006\u0004\bM\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J6\u0010\u0015\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0007J\u0010\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001f\u001a\u00020\u0002J\u0006\u0010 \u001a\u00020\u0002R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00108\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00101R\u0016\u0010;\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u001b\u0010B\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006V"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/RankView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "K0", "M0", "G0", "J0", "", "isShowHelper", "L0", "O0", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/RankViewModel;", "viewModel", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "roomId", "anchorId", "isAnchor", "", "roomType", "F0", "Ld55/j;", "data", "N0", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/SelfRankInfoView$b;", "openGiftPanelListener", "setOpenGiftPanelListener", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/SelfRankInfoView$c;", "selfRankViewClickListener", "setSelfRankViewClickListener", "H0", "I0", "d", "Landroid/app/Activity;", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/c;", "e", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/c;", "baseRankViewModel", "Lcom/tencent/mobileqq/widget/TabLayoutCompat;", "f", "Lcom/tencent/mobileqq/widget/TabLayoutCompat;", "titleTab", "Lcom/tencent/mobileqq/widget/ViewPagerCompat;", tl.h.F, "Lcom/tencent/mobileqq/widget/ViewPagerCompat;", "tabViewPager", "Landroid/view/View;", "i", "Landroid/view/View;", "rankHelpView", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/FrameLayout;", "rankHelpContainer", BdhLogUtil.LogTag.Tag_Conn, "backBtn", "D", "Z", "isPreload", "E", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/RankWebView;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "E0", "()Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/RankWebView;", "rankWebView", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/BaseRankViewAdapter;", "G", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/BaseRankViewAdapter;", "tabViewAdapter", "Landroid/view/ViewGroup;", "H", "Landroid/view/ViewGroup;", "preParentView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "I", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class RankView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final View backBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isPreload;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isShowHelper;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy rankWebView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private BaseRankViewAdapter tabViewAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ViewGroup preParentView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Activity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c baseRankViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TabLayoutCompat titleTab;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewPagerCompat tabViewPager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View rankHelpView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout rankHelpContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankView(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RankWebView>() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.base.RankView$rankWebView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RankWebView invoke() {
                return new RankWebView(RankView.this.getContext());
            }
        });
        this.rankWebView = lazy;
        View.inflate(getContext(), R.layout.huf, this);
        View findViewById = findViewById(R.id.f98145ma);
        TabLayoutCompat tabLayoutCompat = (TabLayoutCompat) findViewById;
        tabLayoutCompat.setTabMode(0);
        tabLayoutCompat.setTabGravity(0);
        tabLayoutCompat.setSelectedTabIndicatorHeight(x.c(tabLayoutCompat.getContext(), 2.0f));
        tabLayoutCompat.setSelectedTabIndicatorColor(-16777216);
        tabLayoutCompat.setSelectedTabIndicatorPaddingLeft(x.c(tabLayoutCompat.getContext(), 15.0f));
        tabLayoutCompat.setSelectedTabIndicatorPaddingRight(x.c(tabLayoutCompat.getContext(), 15.0f));
        tabLayoutCompat.setTabTextColors(-7829368, -16777216);
        tabLayoutCompat.setTabTextSize(x.j(tabLayoutCompat.getContext(), 16.0f));
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<TabLayoutCo\u2026(context, 16F))\n        }");
        this.titleTab = tabLayoutCompat;
        View findViewById2 = findViewById(R.id.f916255o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tabViewPager)");
        ViewPagerCompat viewPagerCompat = (ViewPagerCompat) findViewById2;
        this.tabViewPager = viewPagerCompat;
        View findViewById3 = findViewById(R.id.f70143kn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<View>(R.id.rankHelpView)");
        this.rankHelpView = findViewById3;
        View findViewById4 = findViewById(R.id.f70133km);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<FrameLayout>(R.id.rankHelpContainer)");
        FrameLayout frameLayout = (FrameLayout) findViewById4;
        this.rankHelpContainer = frameLayout;
        View findViewById5 = findViewById(R.id.t2c);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.backBtn)");
        this.backBtn = findViewById5;
        frameLayout.setVisibility(8);
        viewPagerCompat.addOnPageChangeListener(new a());
        this.titleTab.setupWithViewPager(viewPagerCompat, false);
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.base.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankView.B0(RankView.this, view);
            }
        });
        findViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.base.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankView.C0(RankView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(RankView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(RankView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L0(false);
        this$0.isShowHelper = false;
        this$0.G0();
        ViewParent parent = this$0.E0().getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this$0.E0());
        }
        ViewGroup viewGroup = this$0.preParentView;
        if (viewGroup != null) {
            viewGroup.addView(this$0.E0());
        }
        this$0.preParentView = null;
        this$0.K0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final RankWebView E0() {
        return (RankWebView) this.rankWebView.getValue();
    }

    private final void G0() {
        c cVar = this.baseRankViewModel;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            if (cVar.k() != null) {
                c cVar2 = this.baseRankViewModel;
                Intrinsics.checkNotNull(cVar2);
                d55.h[] k3 = cVar2.k();
                Intrinsics.checkNotNull(k3);
                if (k3.length > 1 && !this.isShowHelper) {
                    this.rankHelpView.setVisibility(0);
                    return;
                }
            }
        }
        this.rankHelpView.setVisibility(8);
    }

    private final void J0() {
        c cVar;
        int i3;
        String name;
        if (this.isPreload || (cVar = this.baseRankViewModel) == null || TextUtils.isEmpty(cVar.m())) {
            return;
        }
        d55.h[] k3 = cVar.k();
        if (k3 != null) {
            i3 = k3.length;
        } else {
            i3 = 0;
        }
        if (i3 > 1) {
            d55.h[] k16 = cVar.k();
            Intrinsics.checkNotNull(k16);
            name = k16[1].f393081b;
        } else {
            name = "rankRule";
        }
        c cVar2 = this.baseRankViewModel;
        if (cVar2 != null) {
            RankWebView E0 = E0();
            Intrinsics.checkNotNullExpressionValue(name, "name");
            cVar2.r(E0, name);
        }
        this.isPreload = true;
        QLog.i("RankView", 1, "preloadRankWebView: name:" + name);
    }

    private final void K0() {
        d55.h[] k3;
        boolean z16;
        c cVar;
        int currentItem = this.tabViewPager.getCurrentItem();
        c cVar2 = this.baseRankViewModel;
        if (cVar2 != null && (k3 = cVar2.k()) != null) {
            if (k3.length > currentItem) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                k3 = null;
            }
            if (k3 != null) {
                d55.h hVar = k3[currentItem];
                if (!Intrinsics.areEqual(hVar.f393081b, BaseRankViewAdapter.INSTANCE.a()) && (cVar = this.baseRankViewModel) != null) {
                    RankWebView E0 = E0();
                    String str = hVar.f393081b;
                    Intrinsics.checkNotNullExpressionValue(str, "rankItem.rankName");
                    cVar.r(E0, str);
                }
            }
        }
    }

    private final void L0(boolean isShowHelper) {
        View findViewById = findViewById(R.id.t2c);
        TextView textView = (TextView) findViewById(R.id.f70153ko);
        View findViewById2 = findViewById(R.id.f70133km);
        View findViewById3 = findViewById(R.id.f98145ma);
        View findViewById4 = findViewById(R.id.f98875o_);
        View findViewById5 = findViewById(R.id.f916255o);
        if (isShowHelper) {
            findViewById.setVisibility(0);
            textView.setVisibility(0);
            findViewById2.setVisibility(0);
            findViewById3.setVisibility(8);
            findViewById4.setVisibility(8);
            findViewById5.setVisibility(8);
        } else {
            findViewById.setVisibility(8);
            textView.setVisibility(8);
            findViewById2.setVisibility(8);
            findViewById3.setVisibility(0);
            findViewById4.setVisibility(0);
            findViewById5.setVisibility(0);
        }
        String string = getContext().getString(R.string.f199764qa);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.qq_live_instructions)");
        textView.setText(ht3.a.d("rank_list_instructions", string));
    }

    private final void M0() {
        this.isShowHelper = true;
        ViewParent parent = E0().getParent();
        if (parent != null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.removeView(E0());
            this.preParentView = viewGroup;
        }
        L0(true);
        this.rankHelpView.setVisibility(8);
        this.rankHelpContainer.removeAllViews();
        this.rankHelpContainer.addView(E0());
        c cVar = this.baseRankViewModel;
        if (cVar != null) {
            cVar.r(E0(), "rankRule");
        }
    }

    private final void O0() {
        d55.h[] k3;
        boolean z16;
        this.titleTab.G();
        c cVar = this.baseRankViewModel;
        if (cVar != null && (k3 = cVar.k()) != null) {
            int length = k3.length;
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                d55.h hVar = k3[i3];
                int i17 = i16 + 1;
                TabLayoutCompat.f E = this.titleTab.E();
                E.o(Integer.valueOf(i16));
                E.p(hVar.f393081b);
                int c16 = x.c(getContext(), 10.0f);
                E.e().setPadding(c16, 0, c16, 0);
                Intrinsics.checkNotNullExpressionValue(E, "titleTab.newTab().apply \u2026padding, 0)\n            }");
                TabLayoutCompat tabLayoutCompat = this.titleTab;
                if (i16 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                tabLayoutCompat.i(E, i16, z16);
                E.e().setLayoutParams(new LinearLayout.LayoutParams(x.c(getContext(), 100.0f), x.c(getContext(), 60.0f)));
                i3++;
                i16 = i17;
            }
        }
    }

    public final void F0(@NotNull RankViewModel viewModel, @NotNull Activity activity, long roomId, long anchorId, boolean isAnchor, int roomType) {
        c cVar;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        if (roomType == 2) {
            cVar = new e();
        } else {
            cVar = new c();
        }
        ViewPagerCompat viewPagerCompat = this.tabViewPager;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        BaseRankViewAdapter baseRankViewAdapter = new BaseRankViewAdapter(context, E0());
        this.tabViewAdapter = baseRankViewAdapter;
        viewPagerCompat.setAdapter(baseRankViewAdapter);
        cVar.o(viewModel, roomId, anchorId, isAnchor, roomType);
        BaseRankViewAdapter baseRankViewAdapter2 = this.tabViewAdapter;
        if (baseRankViewAdapter2 != null) {
            baseRankViewAdapter2.m(activity, cVar);
        }
        this.baseRankViewModel = cVar;
        E0().t(activity, com.tencent.mobileqq.qqlive.utils.g.a());
        G0();
        J0();
    }

    public final void H0() {
        O0();
        BaseRankViewAdapter baseRankViewAdapter = this.tabViewAdapter;
        if (baseRankViewAdapter != null) {
            baseRankViewAdapter.o();
        }
    }

    public final void I0() {
        BaseRankViewAdapter baseRankViewAdapter = this.tabViewAdapter;
        if (baseRankViewAdapter != null) {
            baseRankViewAdapter.k();
        }
        E0().destroy();
    }

    public final void N0(@NotNull j data, boolean isAnchor) {
        Intrinsics.checkNotNullParameter(data, "data");
        BaseRankViewAdapter baseRankViewAdapter = this.tabViewAdapter;
        if (baseRankViewAdapter != null) {
            baseRankViewAdapter.r(data, isAnchor);
        }
    }

    public final void setOpenGiftPanelListener(@Nullable SelfRankInfoView.b openGiftPanelListener) {
        BaseRankViewAdapter baseRankViewAdapter = this.tabViewAdapter;
        if (baseRankViewAdapter != null) {
            baseRankViewAdapter.p(openGiftPanelListener);
        }
    }

    public final void setSelfRankViewClickListener(@Nullable SelfRankInfoView.c selfRankViewClickListener) {
        BaseRankViewAdapter baseRankViewAdapter = this.tabViewAdapter;
        if (baseRankViewAdapter != null) {
            baseRankViewAdapter.q(selfRankViewClickListener);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/view/rank/base/RankView$a", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            QLog.i("RankView", 1, "onPageSelected: position:" + position);
            BaseRankViewAdapter baseRankViewAdapter = RankView.this.tabViewAdapter;
            if (baseRankViewAdapter != null) {
                baseRankViewAdapter.onPageSelected(position);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RankWebView>() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.base.RankView$rankWebView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RankWebView invoke() {
                return new RankWebView(RankView.this.getContext());
            }
        });
        this.rankWebView = lazy;
        View.inflate(getContext(), R.layout.huf, this);
        View findViewById = findViewById(R.id.f98145ma);
        TabLayoutCompat tabLayoutCompat = (TabLayoutCompat) findViewById;
        tabLayoutCompat.setTabMode(0);
        tabLayoutCompat.setTabGravity(0);
        tabLayoutCompat.setSelectedTabIndicatorHeight(x.c(tabLayoutCompat.getContext(), 2.0f));
        tabLayoutCompat.setSelectedTabIndicatorColor(-16777216);
        tabLayoutCompat.setSelectedTabIndicatorPaddingLeft(x.c(tabLayoutCompat.getContext(), 15.0f));
        tabLayoutCompat.setSelectedTabIndicatorPaddingRight(x.c(tabLayoutCompat.getContext(), 15.0f));
        tabLayoutCompat.setTabTextColors(-7829368, -16777216);
        tabLayoutCompat.setTabTextSize(x.j(tabLayoutCompat.getContext(), 16.0f));
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<TabLayoutCo\u2026(context, 16F))\n        }");
        this.titleTab = tabLayoutCompat;
        View findViewById2 = findViewById(R.id.f916255o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tabViewPager)");
        ViewPagerCompat viewPagerCompat = (ViewPagerCompat) findViewById2;
        this.tabViewPager = viewPagerCompat;
        View findViewById3 = findViewById(R.id.f70143kn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<View>(R.id.rankHelpView)");
        this.rankHelpView = findViewById3;
        View findViewById4 = findViewById(R.id.f70133km);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<FrameLayout>(R.id.rankHelpContainer)");
        FrameLayout frameLayout = (FrameLayout) findViewById4;
        this.rankHelpContainer = frameLayout;
        View findViewById5 = findViewById(R.id.t2c);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.backBtn)");
        this.backBtn = findViewById5;
        frameLayout.setVisibility(8);
        viewPagerCompat.addOnPageChangeListener(new a());
        this.titleTab.setupWithViewPager(viewPagerCompat, false);
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.base.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankView.B0(RankView.this, view);
            }
        });
        findViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.base.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankView.C0(RankView.this, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RankWebView>() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.base.RankView$rankWebView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RankWebView invoke() {
                return new RankWebView(RankView.this.getContext());
            }
        });
        this.rankWebView = lazy;
        View.inflate(getContext(), R.layout.huf, this);
        View findViewById = findViewById(R.id.f98145ma);
        TabLayoutCompat tabLayoutCompat = (TabLayoutCompat) findViewById;
        tabLayoutCompat.setTabMode(0);
        tabLayoutCompat.setTabGravity(0);
        tabLayoutCompat.setSelectedTabIndicatorHeight(x.c(tabLayoutCompat.getContext(), 2.0f));
        tabLayoutCompat.setSelectedTabIndicatorColor(-16777216);
        tabLayoutCompat.setSelectedTabIndicatorPaddingLeft(x.c(tabLayoutCompat.getContext(), 15.0f));
        tabLayoutCompat.setSelectedTabIndicatorPaddingRight(x.c(tabLayoutCompat.getContext(), 15.0f));
        tabLayoutCompat.setTabTextColors(-7829368, -16777216);
        tabLayoutCompat.setTabTextSize(x.j(tabLayoutCompat.getContext(), 16.0f));
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<TabLayoutCo\u2026(context, 16F))\n        }");
        this.titleTab = tabLayoutCompat;
        View findViewById2 = findViewById(R.id.f916255o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tabViewPager)");
        ViewPagerCompat viewPagerCompat = (ViewPagerCompat) findViewById2;
        this.tabViewPager = viewPagerCompat;
        View findViewById3 = findViewById(R.id.f70143kn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<View>(R.id.rankHelpView)");
        this.rankHelpView = findViewById3;
        View findViewById4 = findViewById(R.id.f70133km);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<FrameLayout>(R.id.rankHelpContainer)");
        FrameLayout frameLayout = (FrameLayout) findViewById4;
        this.rankHelpContainer = frameLayout;
        View findViewById5 = findViewById(R.id.t2c);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.backBtn)");
        this.backBtn = findViewById5;
        frameLayout.setVisibility(8);
        viewPagerCompat.addOnPageChangeListener(new a());
        this.titleTab.setupWithViewPager(viewPagerCompat, false);
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.base.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankView.B0(RankView.this, view);
            }
        });
        findViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.base.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankView.C0(RankView.this, view);
            }
        });
    }
}
