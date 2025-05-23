package com.tencent.mobileqq.guild.discoveryv2.categoryfeatured.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.GuildRecommendGuildCardDelegate;
import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh1.NavCategoryFeaturedItemData;
import vp1.ap;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/categoryfeatured/view/CategoryFeaturedItem;", "Landroid/widget/LinearLayout;", "Lvh1/d;", "data", "", "setData", "Lvp1/ap;", "d", "Lvp1/ap;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class CategoryFeaturedItem extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ap binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CategoryFeaturedItem(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CategoryFeaturedItem this$0, NavCategoryFeaturedItemData data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        if (!o.c("fastClickGuard")) {
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            GuildJumpUtil.n(context, GuildRecommendGuildCardDelegate.INSTANCE.f(DiscoverTabType.DEFAULT, 9, data.getGuildId(), "", data.getJoinGuildSig(), "discover", "discover_category_selected"));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void setData(@NotNull final NavCategoryFeaturedItemData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        v vVar = v.f235697a;
        String guildAvatarUrl = data.getGuildAvatarUrl();
        RoundImageView roundImageView = this.binding.f442271b;
        Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.guildIcon");
        vVar.j(guildAvatarUrl, roundImageView, new Function1<Option, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.categoryfeatured.view.CategoryFeaturedItem$setData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Option option) {
                invoke2(option);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Option loadImage) {
                Intrinsics.checkNotNullParameter(loadImage, "$this$loadImage");
                loadImage.setFailedDrawableColor(0);
                loadImage.setLoadingDrawableColor(0);
            }
        });
        this.binding.f442272c.setText(data.getGuildName());
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.categoryfeatured.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryFeaturedItem.b(CategoryFeaturedItem.this, data, view);
            }
        });
        vh1.b.INSTANCE.b(this, 5, data.getGuildId());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CategoryFeaturedItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CategoryFeaturedItem(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CategoryFeaturedItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(1);
        ap f16 = ap.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        setClipChildren(false);
        setClipToPadding(false);
        View a16 = vh1.b.INSTANCE.a(this, R.id.w1e);
        if (a16 != null) {
            VideoReport.setLogicParent(this, a16);
        }
    }
}
