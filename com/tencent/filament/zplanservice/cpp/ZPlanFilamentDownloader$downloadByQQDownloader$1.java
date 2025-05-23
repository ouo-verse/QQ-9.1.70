package com.tencent.filament.zplanservice.cpp;

import com.google.gson.Gson;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.filament.zplanservice.util.log.FLog;
import dl0.j;
import gl0.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0007\u0018\u00010\u0006H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/filament/zplanservice/cpp/ZPlanFilamentDownloader$downloadByQQDownloader$1", "Lgl0/a;", "", "filePath", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "", "rspHeader", "", "a", "errorMsg", "b", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanFilamentDownloader$downloadByQQDownloader$1 implements a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f106377a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f106378b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f106379c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZPlanFilamentDownloader$downloadByQQDownloader$1(long j3, long j16, String str) {
        this.f106377a = j3;
        this.f106378b = j16;
        this.f106379c = str;
    }

    @Override // gl0.a
    public void a(@Nullable final String filePath, final int statusCode, @Nullable Map<String, ? extends List<String>> rspHeader) {
        final LinkedHashMap linkedHashMap;
        j jVar;
        int mapCapacity;
        Object firstOrNull;
        long currentTimeMillis = System.currentTimeMillis();
        FLog.INSTANCE.i(ZPlanFilamentDownloader.TAG, "download onResponse, callback: " + this.f106377a + ",request cost:  " + (currentTimeMillis - this.f106378b));
        if (rspHeader != null) {
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(rspHeader.size());
            linkedHashMap = new LinkedHashMap(mapCapacity);
            Iterator<T> it = rspHeader.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) entry.getValue());
                String str = (String) firstOrNull;
                if (str == null) {
                    str = "";
                }
                linkedHashMap.put(key, str);
            }
        } else {
            linkedHashMap = null;
        }
        FLog.INSTANCE.i(ZPlanFilamentDownloader.TAG, "onDownloadSuccess url:" + this.f106379c + " filePath: " + filePath + ", statusCode: " + statusCode + ", header: " + new Gson().toJson(linkedHashMap));
        ZPlanFilamentDownloader zPlanFilamentDownloader = ZPlanFilamentDownloader.INSTANCE;
        jVar = ZPlanFilamentDownloader.threadPoolProxy;
        if (jVar != null) {
            j.a.a(jVar, new Runnable() { // from class: com.tencent.filament.zplanservice.cpp.ZPlanFilamentDownloader$downloadByQQDownloader$1$onDownloadSuccess$1
                @Override // java.lang.Runnable
                public final void run() {
                    String str2;
                    boolean z16;
                    try {
                        str2 = new Gson().toJson(linkedHashMap);
                    } catch (Exception e16) {
                        FLog.INSTANCE.e(ZPlanFilamentDownloader.TAG, "header json toString error. " + e16);
                        str2 = "";
                    }
                    String str3 = str2;
                    if (str3 != null && str3.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        ZPlanFilamentDownloader.INSTANCE.onDownloadResponse(ZPlanFilamentDownloader$downloadByQQDownloader$1.this.f106377a, null, -2, null, "header to string fail");
                    } else {
                        ZPlanFilamentDownloader.onDownloadResponse$default(ZPlanFilamentDownloader.INSTANCE, ZPlanFilamentDownloader$downloadByQQDownloader$1.this.f106377a, filePath, statusCode, str3, null, 16, null);
                    }
                }
            }, 0L, 2, null);
        }
    }

    @Override // gl0.a
    public void b(@NotNull final String errorMsg) {
        j jVar;
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        FLog.INSTANCE.i(ZPlanFilamentDownloader.TAG, "onDownloadFail url:" + this.f106379c + ", errorMsg:" + errorMsg);
        ZPlanFilamentDownloader zPlanFilamentDownloader = ZPlanFilamentDownloader.INSTANCE;
        jVar = ZPlanFilamentDownloader.threadPoolProxy;
        if (jVar != null) {
            j.a.a(jVar, new Runnable() { // from class: com.tencent.filament.zplanservice.cpp.ZPlanFilamentDownloader$downloadByQQDownloader$1$onDownloadFail$1
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanFilamentDownloader.INSTANCE.onDownloadResponse(ZPlanFilamentDownloader$downloadByQQDownloader$1.this.f106377a, null, -1, null, errorMsg);
                }
            }, 0L, 2, null);
        }
    }
}
