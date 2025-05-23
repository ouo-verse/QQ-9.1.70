package com.tencent.mobileqq.nearbypro.base;

import com.tencent.mobileqq.nearbypro.base.ILog;
import com.tencent.mobileqq.nearbypro.base.config.NearbyProThreadPoolImpl;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/i;", "", "Lcom/tencent/mobileqq/nearbypro/base/k;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "b", "Lcom/tencent/mobileqq/nearbypro/base/k;", "a", "()Lcom/tencent/mobileqq/nearbypro/base/k;", DownloadInfo.spKey_Config, "<init>", "()V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f253231a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final NearbyProConfig<NearbyProBaseRequest> config;

    static {
        com.tencent.mobileqq.nearbypro.base.config.b bVar = new com.tencent.mobileqq.nearbypro.base.config.b();
        com.tencent.mobileqq.nearbypro.base.config.c cVar = new com.tencent.mobileqq.nearbypro.base.config.c();
        NearbyProThreadPoolImpl nearbyProThreadPoolImpl = new NearbyProThreadPoolImpl();
        com.tencent.mobileqq.nearbypro.base.config.e eVar = new com.tencent.mobileqq.nearbypro.base.config.e();
        ha2.a aVar = new ha2.a(bVar.a());
        com.tencent.mobileqq.nearbypro.base.config.a aVar2 = new com.tencent.mobileqq.nearbypro.base.config.a();
        NearbyProConfig<NearbyProBaseRequest> nearbyProConfig = new NearbyProConfig<>(cVar, nearbyProThreadPoolImpl, eVar, bVar, aVar, aVar2, new com.tencent.mobileqq.nearbypro.base.config.d());
        cVar.b("NearbyProBase", ILog.Level.INFO, "NearbyProBase config init " + aVar2);
        config = nearbyProConfig;
    }

    i() {
    }

    @NotNull
    public final NearbyProConfig<NearbyProBaseRequest> a() {
        return config;
    }
}
