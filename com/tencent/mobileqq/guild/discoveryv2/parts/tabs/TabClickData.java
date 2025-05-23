package com.tencent.mobileqq.guild.discoveryv2.parts.tabs;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\n\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/a;", "", "", "a", "b", "", "c", "()Ljava/lang/Integer;", "", "toString", "hashCode", "other", "equals", "Z", "f", "()Z", "isGuildTabSelected", "d", "needRefreshTab", "Ljava/lang/Integer;", "e", "tabId", "<init>", "(ZZLjava/lang/Integer;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class TabClickData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isGuildTabSelected;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needRefreshTab;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Integer tabId;

    public TabClickData(boolean z16, boolean z17, @Nullable Integer num) {
        this.isGuildTabSelected = z16;
        this.needRefreshTab = z17;
        this.tabId = num;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getIsGuildTabSelected() {
        return this.isGuildTabSelected;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNeedRefreshTab() {
        return this.needRefreshTab;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Integer getTabId() {
        return this.tabId;
    }

    public final boolean d() {
        return this.needRefreshTab;
    }

    @Nullable
    public final Integer e() {
        return this.tabId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabClickData)) {
            return false;
        }
        TabClickData tabClickData = (TabClickData) other;
        if (this.isGuildTabSelected == tabClickData.isGuildTabSelected && this.needRefreshTab == tabClickData.needRefreshTab && Intrinsics.areEqual(this.tabId, tabClickData.tabId)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        return this.isGuildTabSelected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.isGuildTabSelected;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        boolean z17 = this.needRefreshTab;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i17 = (i16 + i3) * 31;
        Integer num = this.tabId;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return i17 + hashCode;
    }

    @NotNull
    public String toString() {
        return "TabClickData(isGuildTabSelected=" + this.isGuildTabSelected + ", needRefreshTab=" + this.needRefreshTab + ", tabId=" + this.tabId + ")";
    }
}
