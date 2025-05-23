package com.tencent.mobileqq.guild.profile.profilecard.joined;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.config.r;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.profile.profilecard.joined.detail.j;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.cu;
import wh2.em;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/joined/GuildProfileJoinedMultipleItem;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/config/r;", "guildStateIconInfo", "", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendChannelInfo;", "data", "f", "d", "Lvp1/cu;", "Lvp1/cu;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileJoinedMultipleItem extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cu binding;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/profile/profilecard/joined/GuildProfileJoinedMultipleItem$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(new Rect(0, 0, QQGuildUIUtil.f(16.0f), QQGuildUIUtil.f(16.0f)), QQGuildUIUtil.f(8.0f));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildProfileJoinedMultipleItem(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c(r guildStateIconInfo) {
        this.binding.f442808g.setOutlineProvider(new b());
        this.binding.f442808g.setClipToOutline(true);
        if (guildStateIconInfo.d() <= 0) {
            this.binding.f442808g.setVisibility(8);
            return;
        }
        this.binding.f442803b.setBottomRightHole();
        this.binding.f442808g.setVisibility(0);
        this.binding.f442808g.setImageResource(guildStateIconInfo.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(GuildProfileJoinedMultipleItem this$0, IGProRecommendChannelInfo data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.f(data);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void f(IGProRecommendChannelInfo data) {
        ArrayList<String> arrayListOf;
        JumpGuildParam jumpGuildParam = new JumpGuildParam(String.valueOf(data.getGuildId()), "", data.getJoinGuildSig(), j.a(), j.b());
        jumpGuildParam.setReportSourceInfo(new GuildAppReportSourceInfo("channel_profile_card", ""));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GuildJumpUtil.n(context, jumpGuildParam);
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(String.valueOf(data.getGuildId()));
        iGPSService.reportUserViewGuild(arrayListOf, j.a(), j.b(), 2, new em() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.c
            @Override // wh2.em
            public final void onResult(int i3, String str) {
                GuildProfileJoinedMultipleItem.g(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3, String str) {
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "reportUserViewGuild failed result: " + i3 + ", errMsg: " + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.profile.GuildProfileJoinedMultipleItem", 1, (String) it.next(), null);
            }
        }
    }

    public final void d(@NotNull final IGProRecommendChannelInfo data) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(data, "data");
        this.binding.f442807f.setText(data.getGuildName());
        v vVar = v.f235697a;
        String guildIcon = data.getGuildIcon();
        Intrinsics.checkNotNullExpressionValue(guildIcon, "data.guildIcon");
        ImageView imageView = this.binding.f442806e;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.guildCover");
        vVar.j(guildIcon, imageView, new Function1<Option, Unit>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.GuildProfileJoinedMultipleItem$bindData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Option option) {
                invoke2(option);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Option loadImage) {
                Intrinsics.checkNotNullParameter(loadImage, "$this$loadImage");
                loadImage.setFailedDrawableColor(GuildProfileJoinedMultipleItem.this.getContext().getResources().getColor(R.color.guild_color_ebebeb_313138));
                loadImage.setLoadingDrawableColor(GuildProfileJoinedMultipleItem.this.getContext().getResources().getColor(R.color.guild_color_ebebeb_313138));
                loadImage.setFailedDrawable(GuildProfileJoinedMultipleItem.this.getContext().getDrawable(R.drawable.guild_logo_icon));
            }
        });
        r guildStateIconInfo = ds1.a.e(String.valueOf(data.getGuildId()));
        Intrinsics.checkNotNullExpressionValue(guildStateIconInfo, "guildStateIconInfo");
        c(guildStateIconInfo);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_channel_id", String.valueOf(data.getChannelId())));
        View mContainer = this.binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        com.tencent.mobileqq.guild.component.token.c.e(mContainer, null, 2, null);
        VideoReport.setElementId(this.binding.getMContainer(), "em_sgrp_head");
        VideoReport.setElementParams(this.binding.getMContainer(), mapOf);
        this.binding.getMContainer().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildProfileJoinedMultipleItem.e(GuildProfileJoinedMultipleItem.this, data, view);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildProfileJoinedMultipleItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildProfileJoinedMultipleItem(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildProfileJoinedMultipleItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        cu f16 = cu.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
    }
}
