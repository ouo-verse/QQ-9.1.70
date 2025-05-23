package mz1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\t\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\"\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u001d\u0010\u000fR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016\u00a8\u0006$"}, d2 = {"Lmz1/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "c", "()J", "setIconId", "(J)V", "iconId", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setIconUri", "(Ljava/lang/String;)V", "iconUri", "setConfigName", "configName", "e", "setMagnet", "magnet", "setCategoryId", "categoryId", "f", "setScheduleChannelId", "scheduleChannelId", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: mz1.i, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class NavigatorItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long iconId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String iconUri;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String configName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String magnet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long categoryId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String scheduleChannelId;

    public NavigatorItem() {
        this(0L, null, null, null, 0L, null, 63, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getConfigName() {
        return this.configName;
    }

    /* renamed from: c, reason: from getter */
    public final long getIconId() {
        return this.iconId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getIconUri() {
        return this.iconUri;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getMagnet() {
        return this.magnet;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NavigatorItem)) {
            return false;
        }
        NavigatorItem navigatorItem = (NavigatorItem) other;
        if (this.iconId == navigatorItem.iconId && Intrinsics.areEqual(this.iconUri, navigatorItem.iconUri) && Intrinsics.areEqual(this.configName, navigatorItem.configName) && Intrinsics.areEqual(this.magnet, navigatorItem.magnet) && this.categoryId == navigatorItem.categoryId && Intrinsics.areEqual(this.scheduleChannelId, navigatorItem.scheduleChannelId)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getScheduleChannelId() {
        return this.scheduleChannelId;
    }

    public int hashCode() {
        return (((((((((androidx.fragment.app.a.a(this.iconId) * 31) + this.iconUri.hashCode()) * 31) + this.configName.hashCode()) * 31) + this.magnet.hashCode()) * 31) + androidx.fragment.app.a.a(this.categoryId)) * 31) + this.scheduleChannelId.hashCode();
    }

    @NotNull
    public String toString() {
        return "NavigatorItem(iconId=" + this.iconId + ", iconUri=" + this.iconUri + ", configName=" + this.configName + ", magnet=" + this.magnet + ", categoryId=" + this.categoryId + ", scheduleChannelId=" + this.scheduleChannelId + ")";
    }

    public NavigatorItem(long j3, @NotNull String iconUri, @NotNull String configName, @NotNull String magnet, long j16, @NotNull String scheduleChannelId) {
        Intrinsics.checkNotNullParameter(iconUri, "iconUri");
        Intrinsics.checkNotNullParameter(configName, "configName");
        Intrinsics.checkNotNullParameter(magnet, "magnet");
        Intrinsics.checkNotNullParameter(scheduleChannelId, "scheduleChannelId");
        this.iconId = j3;
        this.iconUri = iconUri;
        this.configName = configName;
        this.magnet = magnet;
        this.categoryId = j16;
        this.scheduleChannelId = scheduleChannelId;
    }

    public /* synthetic */ NavigatorItem(long j3, String str, String str2, String str3, long j16, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) == 0 ? j16 : 0L, (i3 & 32) == 0 ? str4 : "");
    }
}
