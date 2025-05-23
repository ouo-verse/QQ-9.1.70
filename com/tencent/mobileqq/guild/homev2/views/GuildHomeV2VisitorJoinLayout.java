package com.tencent.mobileqq.guild.homev2.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channel.joinchannel.q;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.bn;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001f\u0010 R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/views/GuildHomeV2VisitorJoinLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "d", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "getJumpGuildParam", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "setJumpGuildParam", "(Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;)V", "jumpGuildParam", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildResult;", "", "e", "Lkotlin/jvm/functions/Function1;", "getCallback", "()Lkotlin/jvm/functions/Function1;", IECSearchBar.METHOD_SET_CALLBACK, "(Lkotlin/jvm/functions/Function1;)V", "callback", "Lvp1/bn;", "f", "Lvp1/bn;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2VisitorJoinLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JumpGuildParam jumpGuildParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super IGProJoinGuildResult, Unit> callback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bn binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2VisitorJoinLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildHomeV2VisitorJoinLayout this$0, Context context, View view) {
        Unit unit;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (!QQGuildUIUtil.v()) {
            JumpGuildParam jumpGuildParam = this$0.jumpGuildParam;
            if (jumpGuildParam != null) {
                q.c(context, jumpGuildParam, false, 1, this$0.callback);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                QQToastUtil.showQQToast(1, R.string.f138610_1);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void setCallback(@Nullable Function1<? super IGProJoinGuildResult, Unit> function1) {
        this.callback = function1;
    }

    public final void setJumpGuildParam(@Nullable JumpGuildParam jumpGuildParam) {
        this.jumpGuildParam = jumpGuildParam;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2VisitorJoinLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2VisitorJoinLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildHomeV2VisitorJoinLayout(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2VisitorJoinLayout(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Map mapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        bn g16 = bn.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        g16.f442524b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.homev2.views.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildHomeV2VisitorJoinLayout.b(GuildHomeV2VisitorJoinLayout.this, context, view);
            }
        });
        QUIButton qUIButton = g16.f442524b;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_visitor_type", 1));
        ch.U0(qUIButton, "em_sgrp_bottom_join_channel", mapOf);
    }
}
