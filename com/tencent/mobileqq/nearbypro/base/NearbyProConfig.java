package com.tencent.mobileqq.nearbypro.base;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BE\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u0012\u0006\u0010$\u001a\u00020 \u0012\u0006\u0010(\u001a\u00020%\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000)\u00a2\u0006\u0004\b.\u0010/J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0011\u0010\u001eR\u0017\u0010$\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001c\u0010#R\u0017\u0010(\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b\u000b\u0010'R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b!\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/k;", "NetReq", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/nearbypro/base/ILog;", "a", "Lcom/tencent/mobileqq/nearbypro/base/ILog;", "c", "()Lcom/tencent/mobileqq/nearbypro/base/ILog;", "log", "Lcom/tencent/mobileqq/nearbypro/base/g;", "b", "Lcom/tencent/mobileqq/nearbypro/base/g;", "f", "()Lcom/tencent/mobileqq/nearbypro/base/g;", "threadPool", "Lcom/tencent/mobileqq/nearbypro/base/e;", "Lcom/tencent/mobileqq/nearbypro/base/e;", "getPageRouter", "()Lcom/tencent/mobileqq/nearbypro/base/e;", "pageRouter", "Lcom/tencent/mobileqq/nearbypro/base/b;", "d", "Lcom/tencent/mobileqq/nearbypro/base/b;", "()Lcom/tencent/mobileqq/nearbypro/base/b;", "commonUtils", "Lcom/tencent/mobileqq/nearbypro/base/c;", "e", "Lcom/tencent/mobileqq/nearbypro/base/c;", "()Lcom/tencent/mobileqq/nearbypro/base/c;", "mmkv", "Lcom/tencent/mobileqq/nearbypro/base/a;", "Lcom/tencent/mobileqq/nearbypro/base/a;", "()Lcom/tencent/mobileqq/nearbypro/base/a;", "appSetting", "Lcom/tencent/mobileqq/nearbypro/base/d;", "g", "Lcom/tencent/mobileqq/nearbypro/base/d;", "()Lcom/tencent/mobileqq/nearbypro/base/d;", "networkHelper", "<init>", "(Lcom/tencent/mobileqq/nearbypro/base/ILog;Lcom/tencent/mobileqq/nearbypro/base/g;Lcom/tencent/mobileqq/nearbypro/base/e;Lcom/tencent/mobileqq/nearbypro/base/b;Lcom/tencent/mobileqq/nearbypro/base/c;Lcom/tencent/mobileqq/nearbypro/base/a;Lcom/tencent/mobileqq/nearbypro/base/d;)V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.base.k, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class NearbyProConfig<NetReq> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ILog log;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final g threadPool;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final e pageRouter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final b commonUtils;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final c mmkv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final a appSetting;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final d<NetReq> networkHelper;

    public NearbyProConfig(@NotNull ILog log, @NotNull g threadPool, @NotNull e pageRouter, @NotNull b commonUtils, @NotNull c mmkv, @NotNull a appSetting, @NotNull d<NetReq> networkHelper) {
        Intrinsics.checkNotNullParameter(log, "log");
        Intrinsics.checkNotNullParameter(threadPool, "threadPool");
        Intrinsics.checkNotNullParameter(pageRouter, "pageRouter");
        Intrinsics.checkNotNullParameter(commonUtils, "commonUtils");
        Intrinsics.checkNotNullParameter(mmkv, "mmkv");
        Intrinsics.checkNotNullParameter(appSetting, "appSetting");
        Intrinsics.checkNotNullParameter(networkHelper, "networkHelper");
        this.log = log;
        this.threadPool = threadPool;
        this.pageRouter = pageRouter;
        this.commonUtils = commonUtils;
        this.mmkv = mmkv;
        this.appSetting = appSetting;
        this.networkHelper = networkHelper;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final a getAppSetting() {
        return this.appSetting;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final b getCommonUtils() {
        return this.commonUtils;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final ILog getLog() {
        return this.log;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final c getMmkv() {
        return this.mmkv;
    }

    @NotNull
    public final d<NetReq> e() {
        return this.networkHelper;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NearbyProConfig)) {
            return false;
        }
        NearbyProConfig nearbyProConfig = (NearbyProConfig) other;
        if (Intrinsics.areEqual(this.log, nearbyProConfig.log) && Intrinsics.areEqual(this.threadPool, nearbyProConfig.threadPool) && Intrinsics.areEqual(this.pageRouter, nearbyProConfig.pageRouter) && Intrinsics.areEqual(this.commonUtils, nearbyProConfig.commonUtils) && Intrinsics.areEqual(this.mmkv, nearbyProConfig.mmkv) && Intrinsics.areEqual(this.appSetting, nearbyProConfig.appSetting) && Intrinsics.areEqual(this.networkHelper, nearbyProConfig.networkHelper)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final g getThreadPool() {
        return this.threadPool;
    }

    public int hashCode() {
        return (((((((((((this.log.hashCode() * 31) + this.threadPool.hashCode()) * 31) + this.pageRouter.hashCode()) * 31) + this.commonUtils.hashCode()) * 31) + this.mmkv.hashCode()) * 31) + this.appSetting.hashCode()) * 31) + this.networkHelper.hashCode();
    }

    @NotNull
    public String toString() {
        return "NearbyProConfig(log=" + this.log + ", threadPool=" + this.threadPool + ", pageRouter=" + this.pageRouter + ", commonUtils=" + this.commonUtils + ", mmkv=" + this.mmkv + ", appSetting=" + this.appSetting + ", networkHelper=" + this.networkHelper + ")";
    }
}
