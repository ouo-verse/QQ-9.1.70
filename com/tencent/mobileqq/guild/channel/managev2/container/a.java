package com.tencent.mobileqq.guild.channel.managev2.container;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.channel.managev2.item.arrowform.q;
import com.tencent.mobileqq.guild.channel.managev2.item.arrowform.r;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J,\u0010\t\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/container/a;", "Lcom/tencent/mobileqq/guild/channel/managev2/container/f;", "Landroid/view/View;", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "initializeChildVB", "", "e", "Z", "isSupportTextChannelAbility", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends f {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isSupportTextChannelAbility;

    public a(@NotNull IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        this.isSupportTextChannelAbility = ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).isSupportTextChannleAbility((int) channelInfo.getApplicationId());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, ChannelSettingMviContext>> initializeChildVB(@NotNull View hostView) {
        List<BaseVB<? extends ol3.b, ? extends MviUIState, ChannelSettingMviContext>> mutableListOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new zf1.b(), new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.g(new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.c(), R.string.f141740hh, QUIListItemBackgroundType.TopRound, null, 8, null), new zf1.a(), new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.g(new q(), R.string.f141040fl, QUIListItemBackgroundType.BottomRound, null, 8, null), new zf1.b(), new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.g(new r(), R.string.f155031ge, null, null, 12, null));
        if (this.isSupportTextChannelAbility) {
            mutableListOf.add(new zf1.b());
        }
        mutableListOf.add(new zf1.b());
        mutableListOf.add(new com.tencent.mobileqq.guild.channel.managev2.item.delete.b(0, 1, null));
        return mutableListOf;
    }
}
