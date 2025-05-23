package com.tencent.mobileqq.guild.channel.managev2.container;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.channel.managev2.item.arrowform.q;
import com.tencent.mobileqq.guild.channel.managev2.item.arrowform.r;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\t\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/container/d;", "Lcom/tencent/mobileqq/guild/channel/managev2/container/f;", "Landroid/view/View;", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "initializeChildVB", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d extends f {
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, ChannelSettingMviContext>> initializeChildVB(@NotNull View hostView) {
        List<BaseVB<? extends ol3.b, ? extends MviUIState, ChannelSettingMviContext>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        com.tencent.mobileqq.guild.channel.managev2.item.arrowform.c cVar = new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.c();
        QUIListItemBackgroundType qUIListItemBackgroundType = QUIListItemBackgroundType.TopRound;
        q qVar = new q();
        QUIListItemBackgroundType qUIListItemBackgroundType2 = QUIListItemBackgroundType.BottomRound;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.guild.channel.managev2.a[]{new zf1.b(), new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.g(cVar, R.string.f141170fy, qUIListItemBackgroundType, null, 8, null), new zf1.a(), new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.g(qVar, R.string.f141140fv, qUIListItemBackgroundType2, null, 8, null), new zf1.b(), new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.g(new r(), R.string.f155031ge, qUIListItemBackgroundType, null, 8, null), new zf1.a(), new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.g(new com.tencent.mobileqq.guild.channel.managev2.item.arrowform.e(), R.string.f154991ga, qUIListItemBackgroundType2, null, 8, null), new zf1.b(), new zf1.b(), new com.tencent.mobileqq.guild.channel.managev2.item.delete.b(R.string.f141150fw)});
        return listOf;
    }
}
