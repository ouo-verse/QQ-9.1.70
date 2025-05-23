package com.tencent.mobileqq.guild.discoveryv2.content.navigation.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildNewRecommendFragment;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.cy;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh1.NavFeaturedGroupItemData;
import vh1.b;
import vp1.aq;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/navigation/view/NavFeaturedGroupItem;", "Landroid/widget/LinearLayout;", "Lvh1/f;", "data", "", "setData", "Lvp1/aq;", "d", "Lvp1/aq;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class NavFeaturedGroupItem extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private aq binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NavFeaturedGroupItem(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(NavFeaturedGroupItem this$0, NavFeaturedGroupItemData data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        if (!o.c("fastClickGuard")) {
            ArrayList<cy> arrayList = new ArrayList<>();
            int i3 = 0;
            for (Object obj : data.b()) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                IGProRecommendItem iGProRecommendItem = (IGProRecommendItem) obj;
                cy cyVar = new cy();
                cyVar.h(iGProRecommendItem.getChannelInfo().getGuildId());
                cyVar.i(0L);
                cyVar.j(String.valueOf(iGProRecommendItem.getChannelInfo().getGuildId()));
                cyVar.g(0L);
                cyVar.k(8);
                cyVar.l("");
                arrayList.add(cyVar);
                i3 = i16;
            }
            GuildNewRecommendFragment.Companion companion = GuildNewRecommendFragment.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            companion.c(context, 9, data.getConfId(), "discover", "discover_category_recommend_fix", arrayList);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void setData(@NotNull final NavFeaturedGroupItemData data) {
        RoundImageView roundImageView;
        Intrinsics.checkNotNullParameter(data, "data");
        int size = data.c().size();
        if (size > 4) {
            size = 4;
        }
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        roundImageView = this.binding.f442277e;
                    } else {
                        roundImageView = this.binding.f442276d;
                    }
                } else {
                    roundImageView = this.binding.f442275c;
                }
            } else {
                roundImageView = this.binding.f442274b;
            }
            Intrinsics.checkNotNullExpressionValue(roundImageView, "when (i) {\n             \u2026.guildIcon4\n            }");
            v.f235697a.j(data.c().get(i3), roundImageView, new Function1<Option, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.navigation.view.NavFeaturedGroupItem$setData$1
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
        }
        this.binding.f442279g.setText(data.getTitle());
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.navigation.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NavFeaturedGroupItem.b(NavFeaturedGroupItem.this, data, view);
            }
        });
        b.Companion.c(vh1.b.INSTANCE, this, 4, null, 4, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NavFeaturedGroupItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ NavFeaturedGroupItem(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NavFeaturedGroupItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(1);
        aq f16 = aq.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        f16.f442278f.setBackgroundDrawable(getResources().getDrawable(R.drawable.guild_group_item_bg));
        View a16 = vh1.b.INSTANCE.a(this, R.id.w1e);
        if (a16 != null) {
            VideoReport.setLogicParent(this, a16);
        }
    }
}
