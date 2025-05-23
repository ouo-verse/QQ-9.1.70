package com.tencent.mobileqq.vas.tianshu;

import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R.\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/tianshu/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "setInfoMap", "(Ljava/util/Map;)V", "infoMap", "Lcom/tencent/mobileqq/vas/tianshu/b;", "b", "Lcom/tencent/mobileqq/vas/tianshu/b;", "()Lcom/tencent/mobileqq/vas/tianshu/b;", "setReportInfo", "(Lcom/tencent/mobileqq/vas/tianshu/b;)V", CacheTable.TABLE_NAME, "<init>", "(Ljava/util/Map;Lcom/tencent/mobileqq/vas/tianshu/b;)V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.tianshu.a, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class ADInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private Map<String, String> infoMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ReportInfo reportInfo;

    public ADInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    public final Map<String, String> a() {
        return this.infoMap;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final ReportInfo getReportInfo() {
        return this.reportInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ADInfo)) {
            return false;
        }
        ADInfo aDInfo = (ADInfo) other;
        if (Intrinsics.areEqual(this.infoMap, aDInfo.infoMap) && Intrinsics.areEqual(this.reportInfo, aDInfo.reportInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.infoMap.hashCode() * 31) + this.reportInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "ADInfo(infoMap=" + this.infoMap + ", reportInfo=" + this.reportInfo + ")";
    }

    public ADInfo(@NotNull Map<String, String> infoMap, @NotNull ReportInfo reportInfo) {
        Intrinsics.checkNotNullParameter(infoMap, "infoMap");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        this.infoMap = infoMap;
        this.reportInfo = reportInfo;
    }

    public /* synthetic */ ADInfo(Map map, ReportInfo reportInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new LinkedHashMap() : map, (i3 & 2) != 0 ? new ReportInfo(null, null, null, null, 15, null) : reportInfo);
    }
}
