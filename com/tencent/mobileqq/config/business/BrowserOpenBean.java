package com.tencent.mobileqq.config.business;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u00a2\u0006\u0004\b\u0011\u0010\u0012B\t\b\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/config/business/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/browser/b;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "topBrowsers", "blackListApps", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.config.business.d, reason: from toString */
/* loaded from: classes10.dex */
public final /* data */ class BrowserOpenBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<com.tencent.mobileqq.browser.b> topBrowsers;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> blackListApps;

    public BrowserOpenBean(@NotNull List<com.tencent.mobileqq.browser.b> topBrowsers, @NotNull List<String> blackListApps) {
        Intrinsics.checkNotNullParameter(topBrowsers, "topBrowsers");
        Intrinsics.checkNotNullParameter(blackListApps, "blackListApps");
        this.topBrowsers = topBrowsers;
        this.blackListApps = blackListApps;
    }

    @NotNull
    public final List<String> a() {
        return this.blackListApps;
    }

    @NotNull
    public final List<com.tencent.mobileqq.browser.b> b() {
        return this.topBrowsers;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BrowserOpenBean)) {
            return false;
        }
        BrowserOpenBean browserOpenBean = (BrowserOpenBean) other;
        if (Intrinsics.areEqual(this.topBrowsers, browserOpenBean.topBrowsers) && Intrinsics.areEqual(this.blackListApps, browserOpenBean.blackListApps)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.topBrowsers.hashCode() * 31) + this.blackListApps.hashCode();
    }

    @NotNull
    public String toString() {
        return "BrowserOpenBean(topBrowsers=" + this.topBrowsers + ", blackListApps=" + this.blackListApps + ")";
    }

    public /* synthetic */ BrowserOpenBean(List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? new ArrayList() : list2);
    }

    public BrowserOpenBean() {
        this(new ArrayList(), null, 2, 0 == true ? 1 : 0);
    }
}
