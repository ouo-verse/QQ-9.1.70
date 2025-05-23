package com.tencent.mobileqq.guild.homev2.views;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.GuildQUIPageTabBar;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.theme.SkinnableView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\u00020\u0003B1\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010$\u001a\u00020\"\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0011\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/views/GuildHomeV2ContentLayout;", "Landroid/widget/LinearLayout;", "", "Lcom/tencent/theme/SkinnableView;", "", "d", "i", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR, "setupBehavior", "onThemeChanged", "Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar;", "Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar;", "g", "()Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar;", "viewTab", "Landroidx/viewpager2/widget/ViewPager2;", "e", "Landroidx/viewpager2/widget/ViewPager2;", "f", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "()Landroid/view/ViewGroup;", "manageContainer", "Landroid/view/View;", h.F, "Landroid/view/View;", "managerGradientView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2ContentLayout extends LinearLayout implements SkinnableView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildQUIPageTabBar viewTab;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewPager2 viewPager2;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup manageContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View managerGradientView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2ContentLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(GuildHomeV2ContentLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d();
    }

    private final void d() {
        i();
        findViewById(R.id.wpd).setBackgroundResource(R.drawable.qui_common_border_standard_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(GuildHomeV2ContentLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
    }

    private final void i() {
        this.managerGradientView.setBackground(GuildUIUtils.j(ContextCompat.getColor(getContext(), R.color.ajr), ContextCompat.getColor(getContext(), R.color.qui_common_bg_bottom_light), GradientDrawable.Orientation.LEFT_RIGHT, 0));
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final ViewGroup getManageContainer() {
        return this.manageContainer;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final ViewPager2 getViewPager2() {
        return this.viewPager2;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final GuildQUIPageTabBar getViewTab() {
        return this.viewTab;
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.homev2.views.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeV2ContentLayout.h(GuildHomeV2ContentLayout.this);
            }
        }, 100L);
    }

    public void setupBehavior(@NotNull CoordinatorLayout.Behavior<GuildHomeV2ContentLayout> behavior) {
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
    public GuildHomeV2ContentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2ContentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildHomeV2ContentLayout(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2ContentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(1);
        View.inflate(context, R.layout.f168106eu3, this);
        View findViewById = findViewById(R.id.wi_);
        GuildQUIPageTabBar guildQUIPageTabBar = (GuildQUIPageTabBar) findViewById;
        guildQUIPageTabBar.c(false);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<GuildQUIPag\u2026thScroll(false)\n        }");
        this.viewTab = guildQUIPageTabBar;
        View findViewById2 = findViewById(R.id.wia);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_homepage_viewpager)");
        this.viewPager2 = (ViewPager2) findViewById2;
        View findViewById3 = findViewById(R.id.f164749tp3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.category_manage_container)");
        this.manageContainer = (ViewGroup) findViewById3;
        View findViewById4 = findViewById(R.id.wpe);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.guild_manage_gradient)");
        this.managerGradientView = findViewById4;
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.homev2.views.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeV2ContentLayout.c(GuildHomeV2ContentLayout.this);
            }
        }, 100L);
    }
}
