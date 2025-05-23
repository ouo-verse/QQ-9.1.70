package com.tencent.mobileqq.guild.discovery.startpanel.childs;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"", "tabTypeValue", "Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    @NotNull
    public static final DiscoverTabType a(int i3) {
        DiscoverTabType discoverTabType = DiscoverTabType.ME;
        if (i3 != discoverTabType.getTabType()) {
            DiscoverTabType discoverTabType2 = DiscoverTabType.HOT;
            if (i3 != discoverTabType2.getTabType()) {
                DiscoverTabType discoverTabType3 = DiscoverTabType.RECOMMEND;
                if (i3 != discoverTabType3.getTabType()) {
                    return DiscoverTabType.DEFAULT;
                }
                return discoverTabType3;
            }
            return discoverTabType2;
        }
        return discoverTabType;
    }
}
