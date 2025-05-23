package jh1;

import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u000f\u00a8\u0006!"}, d2 = {"Ljh1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "pageFrom", "Ljava/lang/String;", "()Ljava/lang/String;", "mainSource", "c", "subSource", "Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;", "d", "Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;", "()Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;", "tabType", "e", "Z", "()Z", "isStandalonePage", "f", "getAppChannel", "appChannel", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;ZLjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jh1.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ExtraData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int pageFrom;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String mainSource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String subSource;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final DiscoverTabType tabType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isStandalonePage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String appChannel;

    public ExtraData(int i3, @NotNull String mainSource, @NotNull String subSource, @NotNull DiscoverTabType tabType, boolean z16, @NotNull String appChannel) {
        Intrinsics.checkNotNullParameter(mainSource, "mainSource");
        Intrinsics.checkNotNullParameter(subSource, "subSource");
        Intrinsics.checkNotNullParameter(tabType, "tabType");
        Intrinsics.checkNotNullParameter(appChannel, "appChannel");
        this.pageFrom = i3;
        this.mainSource = mainSource;
        this.subSource = subSource;
        this.tabType = tabType;
        this.isStandalonePage = z16;
        this.appChannel = appChannel;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getMainSource() {
        return this.mainSource;
    }

    /* renamed from: b, reason: from getter */
    public final int getPageFrom() {
        return this.pageFrom;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getSubSource() {
        return this.subSource;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final DiscoverTabType getTabType() {
        return this.tabType;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsStandalonePage() {
        return this.isStandalonePage;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtraData)) {
            return false;
        }
        ExtraData extraData = (ExtraData) other;
        if (this.pageFrom == extraData.pageFrom && Intrinsics.areEqual(this.mainSource, extraData.mainSource) && Intrinsics.areEqual(this.subSource, extraData.subSource) && this.tabType == extraData.tabType && this.isStandalonePage == extraData.isStandalonePage && Intrinsics.areEqual(this.appChannel, extraData.appChannel)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.pageFrom * 31) + this.mainSource.hashCode()) * 31) + this.subSource.hashCode()) * 31) + this.tabType.hashCode()) * 31;
        boolean z16 = this.isStandalonePage;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.appChannel.hashCode();
    }

    @NotNull
    public String toString() {
        return "ExtraData(pageFrom=" + this.pageFrom + ", mainSource=" + this.mainSource + ", subSource=" + this.subSource + ", tabType=" + this.tabType + ", isStandalonePage=" + this.isStandalonePage + ", appChannel=" + this.appChannel + ")";
    }

    public /* synthetic */ ExtraData(int i3, String str, String str2, DiscoverTabType discoverTabType, boolean z16, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2, discoverTabType, (i16 & 16) != 0 ? false : z16, (i16 & 32) != 0 ? "" : str3);
    }
}
