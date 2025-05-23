package com.tencent.mobileqq.zplan.report.api;

import com.tencent.biz.qqcircle.comment.recpic.a;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj3.b;

@Service(process = {"all"})
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\nJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/report/api/IZPlanReportHelper;", "Lmqq/app/api/IRuntimeService;", "Lqj3/b;", "getZPlanTracer", "Lqj3/a;", "getZPlanMetric", "Lcom/tencent/mobileqq/zplan/report/api/IZPlanReportHelper$a;", "reportConfig", "", "setConfig", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface IZPlanReportHelper extends IRuntimeService {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/report/api/IZPlanReportHelper$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "appVersion", "", "b", "D", "()D", "fraction", "c", "Z", "()Z", "useMetric", "<init>", "(Ljava/lang/String;DZ)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.report.api.IZPlanReportHelper$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ZPlanReportConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String appVersion;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final double fraction;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean useMetric;

        public ZPlanReportConfig() {
            this(null, 0.0d, false, 7, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAppVersion() {
            return this.appVersion;
        }

        /* renamed from: b, reason: from getter */
        public final double getFraction() {
            return this.fraction;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getUseMetric() {
            return this.useMetric;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ZPlanReportConfig)) {
                return false;
            }
            ZPlanReportConfig zPlanReportConfig = (ZPlanReportConfig) other;
            if (Intrinsics.areEqual(this.appVersion, zPlanReportConfig.appVersion) && Double.compare(this.fraction, zPlanReportConfig.fraction) == 0 && this.useMetric == zPlanReportConfig.useMetric) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.appVersion.hashCode() * 31) + a.a(this.fraction)) * 31;
            boolean z16 = this.useMetric;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "ZPlanReportConfig(appVersion=" + this.appVersion + ", fraction=" + this.fraction + ", useMetric=" + this.useMetric + ')';
        }

        public ZPlanReportConfig(@NotNull String appVersion, double d16, boolean z16) {
            Intrinsics.checkNotNullParameter(appVersion, "appVersion");
            this.appVersion = appVersion;
            this.fraction = d16;
            this.useMetric = z16;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ ZPlanReportConfig(String str, double d16, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? 1.0d : d16, (i3 & 4) != 0 ? true : z16);
            if ((i3 & 1) != 0) {
                str = AppSetting.n();
                Intrinsics.checkNotNullExpressionValue(str, "getVersion()");
            }
        }
    }

    @NotNull
    qj3.a getZPlanMetric();

    @NotNull
    b getZPlanTracer();

    void setConfig(@NotNull ZPlanReportConfig reportConfig);
}
