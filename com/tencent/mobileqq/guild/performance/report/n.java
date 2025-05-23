package com.tencent.mobileqq.guild.performance.report;

import com.tencent.mobileqq.guild.common.upload.GuildCgiUploader;
import com.tencent.mobileqq.guild.performance.report.r;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J \u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/n;", "", "", "filePath", "bizType", "", "b", "Lcom/tencent/mobileqq/guild/common/upload/GuildCgiUploader$b;", "result", "a", "", "", "Ljava/util/Map;", "startTimeMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f231033a = new n();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, Long> startTimeMap = new LinkedHashMap();

    n() {
    }

    @JvmStatic
    public static final void a(@NotNull String bizType, @NotNull String filePath, @NotNull GuildCgiUploader.b result) {
        long j3;
        long j16;
        long j17;
        String str;
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(result, "result");
        r.a aVar = new r.a();
        aVar.f231044a = bizType;
        aVar.f231045b = filePath;
        aVar.f231055l = filePath;
        aVar.f231051h = String.valueOf(result.f215490a);
        aVar.f231054k = filePath;
        aVar.f231052i = result.f215491b;
        aVar.f231047d = "";
        Long l3 = startTimeMap.get(filePath);
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            j16 = System.currentTimeMillis() - j3;
        } else {
            j16 = 0;
        }
        aVar.f231048e = "0";
        aVar.f231049f = String.valueOf(j3);
        aVar.f231050g = String.valueOf(j16);
        File file = new File(filePath);
        if (file.exists()) {
            j17 = file.length();
        } else {
            j17 = 0;
        }
        if (j16 > 0) {
            str = ((j17 / j16) * 1000) + "B/s";
        } else {
            str = "0B/s";
        }
        aVar.f231046c = String.valueOf(j17);
        aVar.f231056m = str;
        r.d(GuildTelemetryTask.UPLOAD_PIC, aVar);
        startTimeMap.remove(filePath);
    }

    @JvmStatic
    public static final void b(@NotNull String filePath, @Nullable String bizType) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        startTimeMap.put(filePath, Long.valueOf(System.currentTimeMillis()));
    }
}
