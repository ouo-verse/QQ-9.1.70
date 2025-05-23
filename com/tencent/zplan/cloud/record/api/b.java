package com.tencent.zplan.cloud.record.api;

import dx4.CloudForecastResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H&J&\u0010\u0012\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/zplan/cloud/record/api/b;", "", "", "Ldx4/c;", "cloudForecastResultList", "", "b", "", "isCloudCache", "Ldx4/a;", "userRecordTaskList", "c", "Ldx4/b;", "cloudFailedResultList", "", "errorCode", "", "errorMessage", "a", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface b {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {
        public static void a(@NotNull b bVar, @NotNull List<CloudForecastResult> cloudForecastResultList) {
            Intrinsics.checkNotNullParameter(cloudForecastResultList, "cloudForecastResultList");
        }
    }

    void a(@NotNull List<dx4.b> cloudFailedResultList, int errorCode, @NotNull String errorMessage);

    void b(@NotNull List<CloudForecastResult> cloudForecastResultList);

    void c(boolean isCloudCache, @NotNull List<dx4.a> userRecordTaskList);
}
