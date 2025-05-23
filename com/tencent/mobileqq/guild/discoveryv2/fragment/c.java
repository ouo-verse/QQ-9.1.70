package com.tencent.mobileqq.guild.discoveryv2.fragment;

import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J*\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fj\u0002`\rH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/fragment/c;", "", "", "height", "", "setTabHeight", "gg", "", "isSwitchAccount", "md", "onPostThemeChanged", "isGuildTabSelected", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/RefreshResult;", "bubbleRefresh", "q6", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface c {
    void gg();

    void md(boolean isSwitchAccount);

    void onPostThemeChanged(int height);

    void q6(boolean isGuildTabSelected, @NotNull Pair<Boolean, Integer> bubbleRefresh);

    void setTabHeight(int height);
}
