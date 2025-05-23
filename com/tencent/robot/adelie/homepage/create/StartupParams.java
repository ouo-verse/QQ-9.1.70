package com.tencent.robot.adelie.homepage.create;

import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/ao;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "mainSource", "b", "getPageData", ISchemeApi.KEY_PAGE_DATA, "d", "tplInfo", "activityId", "e", "activityName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.homepage.create.ao, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class StartupParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String mainSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String pageData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tplInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String activityId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String activityName;

    public StartupParams() {
        this(null, null, null, null, null, 31, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getActivityName() {
        return this.activityName;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMainSource() {
        return this.mainSource;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTplInfo() {
        return this.tplInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartupParams)) {
            return false;
        }
        StartupParams startupParams = (StartupParams) other;
        if (Intrinsics.areEqual(this.mainSource, startupParams.mainSource) && Intrinsics.areEqual(this.pageData, startupParams.pageData) && Intrinsics.areEqual(this.tplInfo, startupParams.tplInfo) && Intrinsics.areEqual(this.activityId, startupParams.activityId) && Intrinsics.areEqual(this.activityName, startupParams.activityName)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.mainSource.hashCode() * 31;
        String str = this.pageData;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((((((hashCode2 + hashCode) * 31) + this.tplInfo.hashCode()) * 31) + this.activityId.hashCode()) * 31) + this.activityName.hashCode();
    }

    @NotNull
    public String toString() {
        return "StartupParams(mainSource=" + this.mainSource + ", pageData=" + this.pageData + ", tplInfo=" + this.tplInfo + ", activityId=" + this.activityId + ", activityName=" + this.activityName + ")";
    }

    public StartupParams(@NotNull String mainSource, @Nullable String str, @NotNull String tplInfo, @NotNull String activityId, @NotNull String activityName) {
        Intrinsics.checkNotNullParameter(mainSource, "mainSource");
        Intrinsics.checkNotNullParameter(tplInfo, "tplInfo");
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        this.mainSource = mainSource;
        this.pageData = str;
        this.tplInfo = tplInfo;
        this.activityId = activityId;
        this.activityName = activityName;
    }

    public /* synthetic */ StartupParams(String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5);
    }
}
