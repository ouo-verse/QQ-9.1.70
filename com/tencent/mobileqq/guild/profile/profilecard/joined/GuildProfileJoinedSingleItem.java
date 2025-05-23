package com.tencent.mobileqq.guild.profile.profilecard.joined;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.profile.profilecard.joined.detail.j;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildState;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vp1.cv;
import wh2.em;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\b\u001a\u00020\u0004H\u0014J\b\u0010\t\u001a\u00020\u0004H\u0014R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR#\u0010\u0013\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/joined/GuildProfileJoinedSingleItem;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendChannelInfo;", "data", "", "e", "g", "c", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lvp1/cv;", "d", "Lvp1/cv;", "binding", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "f", "()Landroid/graphics/drawable/Drawable;", "onlineCircleDrawable", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendChannelInfo;", "mData", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileJoinedSingleItem extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    private static final int f231447i = bi.a(5.3f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cv binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy onlineCircleDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProRecommendChannelInfo mData;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildProfileJoinedSingleItem(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(GuildProfileJoinedSingleItem this$0, IGProRecommendChannelInfo data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.g(data);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x01b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e(IGProRecommendChannelInfo data) {
        Object firstOrNull;
        boolean z16;
        Object obj;
        String str;
        boolean z17;
        Object obj2;
        int i3;
        Object obj3;
        String str2;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        ArrayList<IGProRecommendGuildState> stateList = data.getStateList();
        Intrinsics.checkNotNullExpressionValue(stateList, "data.stateList");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) stateList);
        Object obj4 = (IGProRecommendGuildState) firstOrNull;
        if (obj4 == null) {
            obj4 = -1;
        }
        boolean z28 = true;
        int i16 = 4;
        if (!Intrinsics.areEqual(obj4, (Object) 1)) {
            if (Intrinsics.areEqual(obj4, (Object) 4)) {
                i16 = 0;
            } else if (Intrinsics.areEqual(obj4, (Object) 8)) {
                i16 = 5;
            } else if (Intrinsics.areEqual(obj4, (Object) 9)) {
                i16 = 6;
            } else {
                this.binding.f442811c.setVisibility(8);
                i16 = -1;
            }
        }
        if (i16 != -1) {
            this.binding.f442811c.setVisibility(0);
            this.binding.f442811c.setType(i16);
            z16 = false;
        } else {
            z16 = true;
        }
        ArrayList<IGProRecommendLabel> tagList = data.getTagList();
        Intrinsics.checkNotNullExpressionValue(tagList, "data.tagList");
        Iterator<T> it = tagList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((IGProRecommendLabel) obj).getLabelType() == 9) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                if (z27) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        IGProRecommendLabel iGProRecommendLabel = (IGProRecommendLabel) obj;
        if (iGProRecommendLabel != null) {
            str = iGProRecommendLabel.getLabelName();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17 && str.length() <= 6) {
            this.binding.f442814f.setText(str);
            this.binding.f442814f.setVisibility(8);
            z16 = false;
        } else {
            this.binding.f442814f.setVisibility(8);
        }
        if (!z16) {
            return;
        }
        ArrayList<IGProRecommendLabel> tagList2 = data.getTagList();
        Intrinsics.checkNotNullExpressionValue(tagList2, "data.tagList");
        Iterator<T> it5 = tagList2.iterator();
        while (true) {
            if (it5.hasNext()) {
                obj2 = it5.next();
                if (((IGProRecommendLabel) obj2).getLabelType() == 2) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (z26) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        IGProRecommendLabel iGProRecommendLabel2 = (IGProRecommendLabel) obj2;
        if (iGProRecommendLabel2 != null) {
            i3 = iGProRecommendLabel2.getLabelValue();
        } else {
            i3 = 0;
        }
        ArrayList<IGProRecommendLabel> tagList3 = data.getTagList();
        Intrinsics.checkNotNullExpressionValue(tagList3, "data.tagList");
        Iterator<T> it6 = tagList3.iterator();
        while (true) {
            if (it6.hasNext()) {
                obj3 = it6.next();
                if (((IGProRecommendLabel) obj3).getLabelType() == 3) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19) {
                    break;
                }
            } else {
                obj3 = null;
                break;
            }
        }
        IGProRecommendLabel iGProRecommendLabel3 = (IGProRecommendLabel) obj3;
        if (iGProRecommendLabel3 != null) {
            str2 = iGProRecommendLabel3.getLabelName();
        } else {
            str2 = null;
        }
        this.binding.f442814f.setVisibility(8);
        this.binding.f442814f.setCompoundDrawables(null, null, null, null);
        if (i3 > 0) {
            this.binding.f442814f.setVisibility(0);
            this.binding.f442814f.setText(i3 + "\u4e2a\u597d\u53cb\u52a0\u5165");
        } else {
            if (str2 != null && str2.length() != 0) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (!z18) {
                this.binding.f442814f.setVisibility(0);
                this.binding.f442814f.setCompoundDrawablePadding(f231447i);
                f().setBounds(0, 0, f().getIntrinsicWidth(), f().getIntrinsicHeight());
                this.binding.f442814f.setCompoundDrawables(f(), null, null, null);
                this.binding.f442814f.setText(str2);
            } else {
                this.binding.f442814f.setVisibility(8);
                this.binding.f442814f.setCompoundDrawables(null, null, null, null);
                if (z16) {
                    String guildProfile = data.getGuildProfile();
                    if (guildProfile != null && guildProfile.length() != 0) {
                        z28 = false;
                    }
                    if (!z28) {
                        this.binding.f442813e.setText(data.getGuildProfile());
                        this.binding.f442813e.setVisibility(0);
                        return;
                    }
                }
                this.binding.f442813e.setVisibility(8);
            }
        }
        z16 = false;
        if (z16) {
        }
        this.binding.f442813e.setVisibility(8);
    }

    private final Drawable f() {
        return (Drawable) this.onlineCircleDrawable.getValue();
    }

    private final void g(IGProRecommendChannelInfo data) {
        ArrayList<String> arrayListOf;
        JumpGuildParam jumpGuildParam = new JumpGuildParam(String.valueOf(data.getGuildId()), "", data.getJoinGuildSig(), j.a(), j.b());
        jumpGuildParam.setReportSourceInfo(new GuildAppReportSourceInfo("channel_profile_card", ""));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GuildJumpUtil.n(context, jumpGuildParam);
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(String.valueOf(data.getGuildId()));
        iGPSService.reportUserViewGuild(arrayListOf, j.a(), j.b(), 2, new em() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.e
            @Override // wh2.em
            public final void onResult(int i3, String str) {
                GuildProfileJoinedSingleItem.h(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i3, String str) {
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "reportUserViewGuild failed result: " + i3 + ", errMsg: " + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.profile.GuildProfileJoinedSingleItem", 1, (String) it.next(), null);
            }
        }
    }

    public final void c(@NotNull final IGProRecommendChannelInfo data) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(data, "data");
        this.mData = data;
        this.binding.f442816h.setText(data.getGuildName());
        v vVar = v.f235697a;
        String guildIcon = data.getGuildIcon();
        Intrinsics.checkNotNullExpressionValue(guildIcon, "data.guildIcon");
        RoundImageView roundImageView = this.binding.f442812d;
        Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.guildJoinedCover");
        vVar.j(guildIcon, roundImageView, new Function1<Option, Unit>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.GuildProfileJoinedSingleItem$bindData$1
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
                loadImage.setFailedDrawableColor(GuildProfileJoinedSingleItem.this.getContext().getResources().getColor(R.color.guild_color_ebebeb_313138));
                loadImage.setLoadingDrawableColor(GuildProfileJoinedSingleItem.this.getContext().getResources().getColor(R.color.guild_color_ebebeb_313138));
                loadImage.setFailedDrawable(GuildProfileJoinedSingleItem.this.getContext().getDrawable(R.drawable.guild_logo_icon));
            }
        });
        e(data);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_channel_id", String.valueOf(data.getChannelId())));
        View mContainer = this.binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        com.tencent.mobileqq.guild.component.token.c.e(mContainer, null, 2, null);
        VideoReport.setElementId(this.binding.getMContainer(), "em_sgrp_head");
        VideoReport.setElementParams(this.binding.getMContainer(), mapOf);
        this.binding.getMContainer().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildProfileJoinedSingleItem.d(GuildProfileJoinedSingleItem.this, data, view);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Long l3;
        Map mapOf;
        super.onAttachedToWindow();
        this.binding.f442811c.f();
        IGProRecommendChannelInfo iGProRecommendChannelInfo = this.mData;
        if (iGProRecommendChannelInfo != null) {
            l3 = Long.valueOf(iGProRecommendChannelInfo.getChannelId());
        } else {
            l3 = null;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_channel_id", String.valueOf(l3)));
        VideoReport.reportEvent("dt_imp", this.binding.getMContainer(), mapOf);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.binding.f442811c.e();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildProfileJoinedSingleItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildProfileJoinedSingleItem(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildProfileJoinedSingleItem(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        cv f16 = cv.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.GuildProfileJoinedSingleItem$onlineCircleDrawable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                return context.getResources().getDrawable(R.drawable.guild_recommend_circle_0cce6d_6dp);
            }
        });
        this.onlineCircleDrawable = lazy;
    }
}
