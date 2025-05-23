package h54;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lh54/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "appId", "b", "e", "originId", "c", "d", "frontTitle", "frontIconUrl", "frontPath", "f", "aioPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: h54.a, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotShareToWXConfigData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String appId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String originId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String frontTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String frontIconUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String frontPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String aioPath;

    public RobotShareToWXConfigData() {
        this(null, null, null, null, null, null, 63, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAioPath() {
        return this.aioPath;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getFrontIconUrl() {
        return this.frontIconUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getFrontPath() {
        return this.frontPath;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getFrontTitle() {
        return this.frontTitle;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getOriginId() {
        return this.originId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotShareToWXConfigData)) {
            return false;
        }
        RobotShareToWXConfigData robotShareToWXConfigData = (RobotShareToWXConfigData) other;
        if (Intrinsics.areEqual(this.appId, robotShareToWXConfigData.appId) && Intrinsics.areEqual(this.originId, robotShareToWXConfigData.originId) && Intrinsics.areEqual(this.frontTitle, robotShareToWXConfigData.frontTitle) && Intrinsics.areEqual(this.frontIconUrl, robotShareToWXConfigData.frontIconUrl) && Intrinsics.areEqual(this.frontPath, robotShareToWXConfigData.frontPath) && Intrinsics.areEqual(this.aioPath, robotShareToWXConfigData.aioPath)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.appId.hashCode() * 31) + this.originId.hashCode()) * 31) + this.frontTitle.hashCode()) * 31) + this.frontIconUrl.hashCode()) * 31) + this.frontPath.hashCode()) * 31) + this.aioPath.hashCode();
    }

    @NotNull
    public String toString() {
        return "RobotShareToWXConfigData(appId=" + this.appId + ", originId=" + this.originId + ", frontTitle=" + this.frontTitle + ", frontIconUrl=" + this.frontIconUrl + ", frontPath=" + this.frontPath + ", aioPath=" + this.aioPath + ")";
    }

    public RobotShareToWXConfigData(@NotNull String appId, @NotNull String originId, @NotNull String frontTitle, @NotNull String frontIconUrl, @NotNull String frontPath, @NotNull String aioPath) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(originId, "originId");
        Intrinsics.checkNotNullParameter(frontTitle, "frontTitle");
        Intrinsics.checkNotNullParameter(frontIconUrl, "frontIconUrl");
        Intrinsics.checkNotNullParameter(frontPath, "frontPath");
        Intrinsics.checkNotNullParameter(aioPath, "aioPath");
        this.appId = appId;
        this.originId = originId;
        this.frontTitle = frontTitle;
        this.frontIconUrl = frontIconUrl;
        this.frontPath = frontPath;
        this.aioPath = aioPath;
    }

    public /* synthetic */ RobotShareToWXConfigData(String str, String str2, String str3, String str4, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6);
    }
}
