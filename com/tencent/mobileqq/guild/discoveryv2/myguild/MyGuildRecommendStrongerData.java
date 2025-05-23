package com.tencent.mobileqq.guild.discoveryv2.myguild;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\n\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/ai;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;", "a", "Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;", "c", "()Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;", "tabType", "b", "I", "()I", "pageFrom", "getJoinGuildFlag", "d", "(I)V", "joinGuildFlag", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/aa;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/aa;", "()Lcom/tencent/mobileqq/guild/discoveryv2/myguild/aa;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;IILcom/tencent/mobileqq/guild/discoveryv2/myguild/aa;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.discoveryv2.myguild.ai, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class MyGuildRecommendStrongerData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final DiscoverTabType tabType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int pageFrom;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int joinGuildFlag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MyGuildRecommendData item;

    public MyGuildRecommendStrongerData(@NotNull DiscoverTabType tabType, int i3, int i16, @NotNull MyGuildRecommendData item) {
        Intrinsics.checkNotNullParameter(tabType, "tabType");
        Intrinsics.checkNotNullParameter(item, "item");
        this.tabType = tabType;
        this.pageFrom = i3;
        this.joinGuildFlag = i16;
        this.item = item;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final MyGuildRecommendData getItem() {
        return this.item;
    }

    /* renamed from: b, reason: from getter */
    public final int getPageFrom() {
        return this.pageFrom;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final DiscoverTabType getTabType() {
        return this.tabType;
    }

    public final void d(int i3) {
        this.joinGuildFlag = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyGuildRecommendStrongerData)) {
            return false;
        }
        MyGuildRecommendStrongerData myGuildRecommendStrongerData = (MyGuildRecommendStrongerData) other;
        if (this.tabType == myGuildRecommendStrongerData.tabType && this.pageFrom == myGuildRecommendStrongerData.pageFrom && this.joinGuildFlag == myGuildRecommendStrongerData.joinGuildFlag && Intrinsics.areEqual(this.item, myGuildRecommendStrongerData.item)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.tabType.hashCode() * 31) + this.pageFrom) * 31) + this.joinGuildFlag) * 31) + this.item.hashCode();
    }

    @NotNull
    public String toString() {
        return "MyGuildRecommendStrongerData(tabType=" + this.tabType + ", pageFrom=" + this.pageFrom + ", joinGuildFlag=" + this.joinGuildFlag + ", item=" + this.item + ")";
    }
}
