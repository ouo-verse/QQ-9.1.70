package com.tencent.mobileqq.guild.media.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.presenter.MediaChannelFragmentTitleBarPresenter;
import com.tencent.mobileqq.guild.widget.GuildAIOTitleBar;
import com.tencent.mobileqq.guild.widget.IconType;
import com.tencent.mobileqq.guild.widget.TitleBarTheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001\nB\u001d\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMediaChannelFragmentTitleBar;", "Landroid/widget/FrameLayout;", "", "d", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "a", "b", "c", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentTitleBarPresenter;", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelFragmentTitleBarPresenter;", "mPresenter", "e", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mChannelInfo", "f", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "Lcom/tencent/mobileqq/guild/widget/GuildAIOTitleBar;", tl.h.F, "Lcom/tencent/mobileqq/guild/widget/GuildAIOTitleBar;", "mTitleBar", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaChannelFragmentTitleBar extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MediaChannelFragmentTitleBarPresenter mPresenter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private IGProChannelInfo mChannelInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IGProGuildInfo mGuildInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildAIOTitleBar mTitleBar;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaChannelFragmentTitleBar(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void d() {
        HashMap hashMap = new HashMap();
        IGProChannelInfo iGProChannelInfo = this.mChannelInfo;
        if (iGProChannelInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
            iGProChannelInfo = null;
        }
        hashMap.put("sgrp_subchannel_type", Integer.valueOf(iGProChannelInfo.getType()));
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.mTitleBar.D0(), "em_sgrp_channelvistor_add", hashMap);
    }

    public final void a(@NotNull Fragment fragment, @NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        this.mGuildInfo = guildInfo;
        this.mChannelInfo = channelInfo;
        this.mTitleBar.setTheme(TitleBarTheme.TITLE_BAR_STYLE_02);
        if (Intrinsics.areEqual(MediaChannelCore.INSTANCE.a().o0().getStartParams().getSourceType(), "functional_qq_little_world_feed")) {
            this.mTitleBar.setLeftIconType(IconType.BACK);
        } else {
            this.mTitleBar.setLeftIconType(IconType.SCALE);
        }
        this.mTitleBar.setNotDisturbVisibility(false);
        IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
        IGProChannelInfo iGProChannelInfo = null;
        if (iGProGuildInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
            iGProGuildInfo = null;
        }
        String guildID = iGProGuildInfo.getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID, "mGuildInfo.guildID");
        IGProChannelInfo iGProChannelInfo2 = this.mChannelInfo;
        if (iGProChannelInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
        } else {
            iGProChannelInfo = iGProChannelInfo2;
        }
        String channelUin = iGProChannelInfo.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "mChannelInfo.channelUin");
        this.mPresenter = new MediaChannelFragmentTitleBarPresenter(fragment, guildID, channelUin, this.mTitleBar);
        d();
    }

    public final void b() {
        MediaChannelFragmentTitleBarPresenter mediaChannelFragmentTitleBarPresenter = this.mPresenter;
        if (mediaChannelFragmentTitleBarPresenter != null) {
            mediaChannelFragmentTitleBarPresenter.z();
        }
        this.mPresenter = null;
    }

    public final void c() {
        MediaChannelFragmentTitleBarPresenter mediaChannelFragmentTitleBarPresenter = this.mPresenter;
        if (mediaChannelFragmentTitleBarPresenter != null) {
            mediaChannelFragmentTitleBarPresenter.B();
        }
    }

    public /* synthetic */ GuildMediaChannelFragmentTitleBar(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaChannelFragmentTitleBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        GuildAIOTitleBar guildAIOTitleBar = new GuildAIOTitleBar(context);
        this.mTitleBar = guildAIOTitleBar;
        addView(guildAIOTitleBar);
    }
}
