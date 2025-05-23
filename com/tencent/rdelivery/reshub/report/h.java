package com.tencent.rdelivery.reshub.report;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ \u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R0\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0012j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014R$\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0016j\b\u0012\u0004\u0012\u00020\b`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/rdelivery/reshub/report/h;", "", "Ljava/util/Properties;", "a", "", "time", "", "d", "", "progressStatus", "Lcom/tencent/rdelivery/reshub/report/a;", "errorInfo", "c", "", "success", "b", "J", "startTime", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "statusTimes", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "errStatusSet", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, Long> statusTimes = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final HashSet<Integer> errStatusSet = new HashSet<>();

    private final Properties a() {
        List<StageReportInfo> list;
        long j3;
        Properties properties = new Properties();
        list = i.f364576a;
        for (StageReportInfo stageReportInfo : list) {
            int startStatus = stageReportInfo.getStartStatus();
            int endStatus = stageReportInfo.getEndStatus();
            String reportKeyPrefix = stageReportInfo.getReportKeyPrefix();
            Long l3 = this.statusTimes.get(Integer.valueOf(startStatus));
            Long l16 = this.statusTimes.get(Integer.valueOf(endStatus));
            if (l3 != null) {
                int i3 = !this.errStatusSet.contains(Integer.valueOf(endStatus)) ? 1 : 0;
                if (l16 != null) {
                    j3 = l16.longValue() - l3.longValue();
                } else {
                    j3 = 0;
                }
                String str = reportKeyPrefix + "_result";
                properties.put(str, Integer.valueOf(i3));
                properties.put(reportKeyPrefix + "_cost", Long.valueOf(j3));
            }
        }
        jz3.d.a("RequestReportRecord", "generateStageReportParams " + properties);
        return properties;
    }

    @NotNull
    public final Properties b(boolean success, @NotNull a errorInfo, long time) {
        Intrinsics.checkParameterIsNotNull(errorInfo, "errorInfo");
        long j3 = time - this.startTime;
        Properties properties = new Properties();
        properties.put("rs_result", Integer.valueOf(success ? 1 : 0));
        properties.put("rs_err_code", Integer.valueOf(errorInfo.getErrorCode()));
        properties.put("rs_err_msg", c.a(errorInfo));
        properties.put("rs_cost", Long.valueOf(j3));
        properties.putAll(a());
        return properties;
    }

    public final void c(int progressStatus, @Nullable a errorInfo) {
        this.statusTimes.put(Integer.valueOf(progressStatus), Long.valueOf(d.a()));
        if (errorInfo != null && !errorInfo.d()) {
            this.errStatusSet.add(Integer.valueOf(progressStatus));
        }
    }

    public final void d(long time) {
        this.startTime = time;
    }
}
