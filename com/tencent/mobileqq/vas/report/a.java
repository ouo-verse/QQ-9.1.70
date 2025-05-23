package com.tencent.mobileqq.vas.report;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x23.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/report/a;", "", "Lx23/d;", DownloadInfo.spKey_Config, "Lx23/c;", "a", "", "uuid", "b", "", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "reportChainMap", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f310626a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, x23.c> reportChainMap = new ConcurrentHashMap<>();

    a() {
    }

    @NotNull
    public final x23.c a(@NotNull d config) {
        Intrinsics.checkNotNullParameter(config, "config");
        c cVar = new c(config.getServiceName(), config.getSetKey(), config.getVersion(), config.getReportImpl(), config.interceptor(), config.connectChain(), config.sample(), config.getTimeOut());
        cVar.i(config.getLogProxy());
        reportChainMap.put(cVar.getCom.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy.JSON_KEY_SET_KEY java.lang.String(), cVar);
        return cVar;
    }

    @Nullable
    public final x23.c b(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return reportChainMap.get(uuid);
    }

    public final void c(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        reportChainMap.remove(uuid);
    }
}
