package com.tencent.mobileqq.guild.channel.managev2;

import android.view.View;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingUIState;
import com.tencent.mvi.mvvm.BaseVB;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00102\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0016\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\f0\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/a;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/mobileqq/guild/channel/managev2/b;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingUIState;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "Landroid/view/View;", "v", "", "isAccessible", "", "b1", "", "Ljava/lang/Class;", "getObserverStates", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class a extends BaseVB<b, ChannelSettingUIState, ChannelSettingMviContext> {
    /* JADX INFO: Access modifiers changed from: protected */
    public void b1(@NotNull View v3, boolean isAccessible) {
        float f16;
        Intrinsics.checkNotNullParameter(v3, "v");
        if (isAccessible) {
            f16 = 1.0f;
        } else {
            f16 = 0.5f;
        }
        v3.setAlpha(f16);
        v3.setClickable(isAccessible);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends ChannelSettingUIState>> getObserverStates() {
        List<Class<? extends ChannelSettingUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{ChannelSettingUIState.SettingItemDescUIState.class, ChannelSettingUIState.SettingItemEnableUIState.class, ChannelSettingUIState.SettingItemOpenSwitchUIState.class, ChannelSettingUIState.SettingItemMsgNotifyUIState.class});
        return listOf;
    }
}
