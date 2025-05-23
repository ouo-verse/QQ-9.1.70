package com.tencent.mobileqq.guild.channel.managev2.container;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingUIState;
import com.tencent.mobileqq.guild.channel.managev2.item.arrowform.n;
import com.tencent.mobileqq.guild.channel.managev2.item.arrowform.o;
import com.tencent.mobileqq.guild.channel.managev2.item.arrowform.q;
import com.tencent.mobileqq.guild.channel.managev2.item.arrowform.r;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\t\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/container/b;", "Lcom/tencent/mobileqq/guild/channel/managev2/container/f;", "Landroid/view/View;", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "initializeChildVB", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/mobileqq/guild/channel/managev2/b;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingUIState;", "createVM", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends f {
    @Override // com.tencent.mobileqq.guild.channel.managev2.container.f, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: createVM */
    public BaseVM<com.tencent.mobileqq.guild.channel.managev2.b, ChannelSettingUIState, ChannelSettingMviContext> getViewModel() {
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, ChannelSettingMviContext>> initializeChildVB(@NotNull View hostView) {
        List<BaseVB<? extends ol3.b, ? extends MviUIState, ChannelSettingMviContext>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        com.tencent.mobileqq.guild.channel.managev2.item.arrowform.c cVar = new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.c();
        QUIListItemBackgroundType qUIListItemBackgroundType = QUIListItemBackgroundType.TopRound;
        q qVar = new q();
        QUIListItemBackgroundType qUIListItemBackgroundType2 = QUIListItemBackgroundType.BottomRound;
        com.tencent.mobileqq.guild.channel.managev2.item.arrowform.b bVar = new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.b();
        QUIListItemBackgroundType qUIListItemBackgroundType3 = QUIListItemBackgroundType.NoneRound;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.guild.channel.managev2.a[]{new zf1.b(), new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.g(cVar, R.string.f142140ik, qUIListItemBackgroundType, null, 8, null), new zf1.a(), new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.g(qVar, R.string.f142070id, qUIListItemBackgroundType2, null, 8, null), new zf1.b(), new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.g(new n(), R.string.f141930i0, qUIListItemBackgroundType, null, 8, null), new zf1.a(), new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.g(bVar, R.string.f141550gz, qUIListItemBackgroundType3, null, 8, null), new zf1.a(), new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.g(new r(), R.string.f155031ge, qUIListItemBackgroundType3, null, 8, null), new zf1.a(), new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.g(new o(), R.string.f155021gd, qUIListItemBackgroundType2, Integer.valueOf(R.string.f139940cm)), new yf1.e(), new zf1.b(), new com.tencent.mobileqq.guild.channel.managev2.item.delete.b(R.string.f142090if)});
        return listOf;
    }
}
