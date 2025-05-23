package com.tencent.qmethod.monitor.config.bean;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qmethod/monitor/config/bean/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qmethod/monitor/config/bean/ConstitutionSceneReportType;", "a", "Lcom/tencent/qmethod/monitor/config/bean/ConstitutionSceneReportType;", "b", "()Lcom/tencent/qmethod/monitor/config/bean/ConstitutionSceneReportType;", "c", "(Lcom/tencent/qmethod/monitor/config/bean/ConstitutionSceneReportType;)V", AdMetricTag.Report.TYPE, "Ljava/lang/String;", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/String;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.qmethod.monitor.config.bean.b, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class ConstitutionSceneConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConstitutionSceneReportType reportType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    public ConstitutionSceneConfig(@NotNull String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        this.name = name;
        this.reportType = ConstitutionSceneReportType.NORMAL;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final ConstitutionSceneReportType getReportType() {
        return this.reportType;
    }

    public final void c(@NotNull ConstitutionSceneReportType constitutionSceneReportType) {
        Intrinsics.checkParameterIsNotNull(constitutionSceneReportType, "<set-?>");
        this.reportType = constitutionSceneReportType;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof ConstitutionSceneConfig) || !Intrinsics.areEqual(this.name, ((ConstitutionSceneConfig) other).name)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public int hashCode() {
        String str = this.name;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "ConstitutionSceneConfig(name=" + this.name + ")";
    }
}
