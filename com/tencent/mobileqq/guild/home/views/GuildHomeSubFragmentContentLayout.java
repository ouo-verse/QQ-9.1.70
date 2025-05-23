package com.tencent.mobileqq.guild.home.views;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.GuildQUIPageTabBar;
import com.tencent.mobileqq.guild.home.subhome.c;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.theme.SkinnableView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\u00020\u0003:\u00013B1\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u0012\u0012\b\b\u0002\u0010/\u001a\u00020\u0012\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0014\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010\u0013\u001a\u00020\u0012R\u001b\u0010\u0018\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010!\u001a\u00020\u001e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u001f\u0010 R\u001b\u0010$\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010%R!\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001a\u0010(\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/GuildHomeSubFragmentContentLayout;", "Landroid/widget/LinearLayout;", "", "Lcom/tencent/theme/SkinnableView;", "", "d", DomainData.DOMAIN_NAME, "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR, "setupBehavior", "onThemeChanged", "", "Lcom/tencent/mobileqq/guild/home/subhome/c$b;", "list", "setDataList", "", "f", "Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar;", "Lkotlin/Lazy;", "j", "()Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar;", "viewTab", "Landroidx/viewpager2/widget/ViewPager2;", "e", "i", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Landroid/view/ViewGroup;", "g", "()Landroid/view/ViewGroup;", "manageContainer", h.F, "()Landroid/view/View;", "managerGradientView", "Landroid/view/View;", "goToRealNameAuthContainer", "", "()Ljava/util/List;", "dataList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeSubFragmentContentLayout extends LinearLayout implements SkinnableView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewTab;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewPager2;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy manageContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy managerGradientView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View goToRealNameAuthContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dataList;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeSubFragmentContentLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(GuildHomeSubFragmentContentLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d();
    }

    private final void d() {
        n();
        findViewById(R.id.wpd).setBackgroundResource(R.drawable.qui_common_border_standard_bg);
    }

    private final List<c.GuildHomeSubTabData> e() {
        return (List) this.dataList.getValue();
    }

    private final View h() {
        Object value = this.managerGradientView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-managerGradientView>(...)");
        return (View) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(GuildHomeSubFragmentContentLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n();
    }

    private final void n() {
        h().setBackground(GuildUIUtils.j(ContextCompat.getColor(getContext(), R.color.ajr), ContextCompat.getColor(getContext(), R.color.qui_common_bg_bottom_light), GradientDrawable.Orientation.LEFT_RIGHT, 0));
    }

    public final int f() {
        return 0;
    }

    @NotNull
    public final ViewGroup g() {
        Object value = this.manageContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-manageContainer>(...)");
        return (ViewGroup) value;
    }

    @NotNull
    public final ViewPager2 i() {
        Object value = this.viewPager2.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewPager2>(...)");
        return (ViewPager2) value;
    }

    @NotNull
    public final GuildQUIPageTabBar j() {
        Object value = this.viewTab.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewTab>(...)");
        return (GuildQUIPageTabBar) value;
    }

    public final void k() {
        View view = this.goToRealNameAuthContainer;
        if (view == null) {
            return;
        }
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goToRealNameAuthContainer");
            view = null;
        }
        view.setVisibility(8);
    }

    @NotNull
    public final View m() {
        if (this.goToRealNameAuthContainer == null) {
            View findViewById = findViewById(R.id.wi7);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_home_real_name_vs)");
            View inflate = ((ViewStub) findViewById).inflate();
            Intrinsics.checkNotNullExpressionValue(inflate, "goToRealNameAuthContainerVS.inflate()");
            this.goToRealNameAuthContainer = inflate;
        }
        View view = this.goToRealNameAuthContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goToRealNameAuthContainer");
            view = null;
        }
        view.setVisibility(0);
        View view2 = this.goToRealNameAuthContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goToRealNameAuthContainer");
            return null;
        }
        return view2;
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.home.views.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeSubFragmentContentLayout.l(GuildHomeSubFragmentContentLayout.this);
            }
        }, 100L);
    }

    public final void setDataList(@NotNull List<c.GuildHomeSubTabData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        e().clear();
        e().addAll(list);
    }

    public void setupBehavior(@NotNull CoordinatorLayout.Behavior<GuildHomeSubFragmentContentLayout> behavior) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior(behavior);
            setLayoutParams(layoutParams);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeSubFragmentContentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeSubFragmentContentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildHomeSubFragmentContentLayout(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeSubFragmentContentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildQUIPageTabBar>() { // from class: com.tencent.mobileqq.guild.home.views.GuildHomeSubFragmentContentLayout$viewTab$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GuildQUIPageTabBar invoke() {
                GuildQUIPageTabBar guildQUIPageTabBar = (GuildQUIPageTabBar) GuildHomeSubFragmentContentLayout.this.findViewById(R.id.wi_);
                guildQUIPageTabBar.c(false);
                return guildQUIPageTabBar;
            }
        });
        this.viewTab = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ViewPager2>() { // from class: com.tencent.mobileqq.guild.home.views.GuildHomeSubFragmentContentLayout$viewPager2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewPager2 invoke() {
                return (ViewPager2) GuildHomeSubFragmentContentLayout.this.findViewById(R.id.wia);
            }
        });
        this.viewPager2 = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ViewGroup>() { // from class: com.tencent.mobileqq.guild.home.views.GuildHomeSubFragmentContentLayout$manageContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewGroup invoke() {
                return (ViewGroup) GuildHomeSubFragmentContentLayout.this.findViewById(R.id.f164749tp3);
            }
        });
        this.manageContainer = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.guild.home.views.GuildHomeSubFragmentContentLayout$managerGradientView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return GuildHomeSubFragmentContentLayout.this.findViewById(R.id.wpe);
            }
        });
        this.managerGradientView = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<List<c.GuildHomeSubTabData>>() { // from class: com.tencent.mobileqq.guild.home.views.GuildHomeSubFragmentContentLayout$dataList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<c.GuildHomeSubTabData> invoke() {
                return new ArrayList();
            }
        });
        this.dataList = lazy5;
        setOrientation(1);
        View.inflate(context, R.layout.f168106eu3, this);
        setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.home.views.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeSubFragmentContentLayout.c(GuildHomeSubFragmentContentLayout.this);
            }
        }, 100L);
    }
}
