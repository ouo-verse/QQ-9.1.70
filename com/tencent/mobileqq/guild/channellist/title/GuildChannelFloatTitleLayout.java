package com.tencent.mobileqq.guild.channellist.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.guild.channellist.title.GuildChannelFloatTitleLayout;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import kotlin.Metadata;
import kotlin.g;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.w;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0002 !B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/title/GuildChannelFloatTitleLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/guild/channellist/title/GuildChannelFloatTitleLayout$b;", "guildTitleCallback", "", "setListener", "", NodeProps.VISIBLE, "setSettingVisible", "", c.f123400v, "setTitleAlpha", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lvp1/w;", "d", "Lvp1/w;", "binding", "", "e", "I", CustomAnimation.KeyPath.MASK_COLOR, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildChannelFloatTitleLayout extends FrameLayout implements View.OnClickListener {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private w binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int maskColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/title/GuildChannelFloatTitleLayout$a;", "", "", "b", "", "TAG", "Ljava/lang/String;", "", "TITLE_CONTAINER_HEIGHT_DP", "I", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channellist.title.GuildChannelFloatTitleLayout$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return Intrinsics.areEqual(DeviceInfoMonitor.getModel(), "vivo X6S A");
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/title/GuildChannelFloatTitleLayout$b;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelFloatTitleLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (QQGuildUIUtil.v()) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.NewHome.GuildHomeFloatTitleLayout", 1, "onClick isFastDoubleClick");
            }
        } else {
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("Guild.NewHome.GuildHomeFloatTitleLayout", 1, "onClick v:" + v3);
            }
            if (!Intrinsics.areEqual(v3, this.binding.f443133f) && !Intrinsics.areEqual(v3, this.binding.f443131d)) {
                logger2.d().w("Guild.NewHome.GuildHomeFloatTitleLayout", 1, "onClick unExpectedView:" + v3);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setListener(@NotNull b guildTitleCallback) {
        Intrinsics.checkNotNullParameter(guildTitleCallback, "guildTitleCallback");
    }

    public final void setSettingVisible(boolean visible) {
        int i3;
        ImageView imageView = this.binding.f443131d;
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public final void setTitleAlpha(float alpha) {
        boolean z16;
        if (alpha == 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.binding.f443129b.setVisibility(0);
        } else {
            this.binding.f443129b.setVisibility(8);
        }
        ImageView imageView = this.binding.f443130c;
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        int i3 = this.maskColor;
        imageView.setImageDrawable(guildUIUtils.i(i3, g.a(i3, 85), (int) (255 * alpha)));
        this.binding.f443132e.setAlpha(alpha);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelFloatTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildChannelFloatTitleLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelFloatTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        w f16 = w.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        f16.f443133f.setOnClickListener(this);
        this.binding.f443131d.setOnClickListener(this);
        this.binding.getMRv().setOnClickListener(new View.OnClickListener() { // from class: fg1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildChannelFloatTitleLayout.b(view);
            }
        });
        if (INSTANCE.b()) {
            setLayerType(1, null);
        }
        ImageView imageView = this.binding.f443131d;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.settingIcon");
        bt.d(imageView, "em_sgrp_config", null, null, null, EndExposurePolicy.REPORT_NONE, 28, null);
    }
}
