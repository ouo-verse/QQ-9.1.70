package com.tencent.mobileqq.guild.performance.report;

import android.os.SystemClock;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 \u00112\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\b\u001a\u00020\u00022&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0016J8\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00052&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0004J\b\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/b;", "Lcom/tencent/mobileqq/guild/performance/report/z;", "", "c", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "a", "event", "extraInfo", "e", "g", "f", "endTask", "<init>", "()V", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class b implements z {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static ConcurrentHashMap<String, String> f230983e = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static ConcurrentHashMap<String, Long> f230984f = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, HashMap<String, String>> f230985h = new ConcurrentHashMap<>();

    @Override // com.tencent.mobileqq.guild.performance.report.z
    public void a(@Nullable HashMap<String, String> params) {
        boolean z16;
        String d16 = d();
        boolean z17 = true;
        if (!f230983e.containsKey(d16)) {
            Logger logger = Logger.f235387a;
            String b16 = b();
            Logger.b bVar = new Logger.b();
            String str = "updateTagAttributes, taskName=" + d16 + ", not call start ";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(b16, 1, (String) it.next(), null);
            }
            return;
        }
        if (params != null && !params.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        ConcurrentHashMap<String, HashMap<String, String>> concurrentHashMap = f230985h;
        HashMap<String, String> hashMap = concurrentHashMap.get(d16);
        if (hashMap != null && !hashMap.isEmpty()) {
            z17 = false;
        }
        if (z17) {
            concurrentHashMap.put(d16, params);
        } else {
            hashMap.putAll(params);
        }
    }

    @Override // com.tencent.mobileqq.guild.performance.report.z
    public void c() {
        String d16 = d();
        if (f230983e.containsKey(d16)) {
            return;
        }
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        String taskKey = iQQOpenTelemetryReportApi.startOpenTelemetryTask(d16);
        long uptimeMillis = SystemClock.uptimeMillis();
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(taskKey, "start");
        ConcurrentHashMap<String, String> concurrentHashMap = f230983e;
        Intrinsics.checkNotNullExpressionValue(taskKey, "taskKey");
        concurrentHashMap.put(d16, taskKey);
        f230984f.put(d16, Long.valueOf(uptimeMillis));
        Logger logger = Logger.f235387a;
        String b16 = b();
        if (QLog.isColorLevel()) {
            logger.d().d(b16, 2, "startTask, taskName=" + d16 + ", taskKey=" + taskKey + " ");
        }
    }

    @Override // com.tencent.mobileqq.guild.performance.report.z
    public void e(@NotNull String event, @Nullable HashMap<String, String> extraInfo) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(event, "event");
        String str = f230983e.get(d());
        boolean z16 = true;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (isBlank) {
                Logger logger = Logger.f235387a;
                String b16 = b();
                if (QLog.isColorLevel()) {
                    logger.d().d(b16, 2, "addTaskEvent (" + event + ") but taskKey is empty. return");
                    return;
                }
                return;
            }
            QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
            IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
            HashMap hashMap = new HashMap();
            if (extraInfo != null && !extraInfo.isEmpty()) {
                z16 = false;
            }
            if (!z16) {
                hashMap.putAll(extraInfo);
            }
            hashMap.put("timestamp_from_start_on", g());
            iQQOpenTelemetryReportApi.reportOpenTelemetryTask(str, event, hashMap);
            Logger logger2 = Logger.f235387a;
            String b17 = b();
            if (QLog.isColorLevel()) {
                logger2.d().d(b17, 2, "addTaskEvent eventName: " + event + ", params: " + hashMap);
                return;
            }
            return;
        }
        Logger logger3 = Logger.f235387a;
        String b18 = b();
        Logger.b bVar = new Logger.b();
        String str2 = "\"addTaskEvent (" + event + ") but taskNameKeyMap not contain taskName";
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(b18, 1, (String) it.next(), null);
        }
    }

    @Override // com.tencent.mobileqq.guild.performance.report.z
    public void endTask() {
        boolean isBlank;
        String d16 = d();
        String f16 = f();
        boolean z16 = true;
        if (f16 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(f16);
            if (isBlank) {
                Logger logger = Logger.f235387a;
                String b16 = b();
                if (QLog.isColorLevel()) {
                    logger.d().d(b16, 2, "endTask but taskKey is empty. return");
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("timestamp_from_start_on", g());
            QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
            IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
            HashMap<String, String> remove = f230985h.remove(d16);
            f230984f.remove(d16);
            if (remove != null && !remove.isEmpty()) {
                z16 = false;
            }
            if (!z16) {
                iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(f16, remove);
            }
            iQQOpenTelemetryReportApi.reportOpenTelemetryTask(f16, "end", hashMap);
            iQQOpenTelemetryReportApi.endOpenTelemetryTask(f16);
            Logger logger2 = Logger.f235387a;
            String b17 = b();
            if (QLog.isColorLevel()) {
                logger2.d().d(b17, 2, "endTask, taskName=" + d16 + ", taskKey=" + f16);
            }
            f230983e.remove(d16);
            return;
        }
        Logger logger3 = Logger.f235387a;
        String b18 = b();
        Logger.b bVar = new Logger.b();
        String str = "endTask but taskNameKeyMap not contain taskName = (" + d16 + ")";
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(b18, 1, (String) it.next(), null);
        }
    }

    @Nullable
    protected final String f() {
        return f230983e.get(d());
    }

    @NotNull
    protected final String g() {
        long uptimeMillis = SystemClock.uptimeMillis();
        Long l3 = f230984f.get(d());
        Intrinsics.checkNotNull(l3);
        return String.valueOf(uptimeMillis - l3.longValue());
    }
}
