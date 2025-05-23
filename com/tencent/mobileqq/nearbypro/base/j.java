package com.tencent.mobileqq.nearbypro.base;

import com.tencent.libra.IPicLoader;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.nearbypro.base.picloader.NearByProPicLoader;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0011\u0010\u0003\u001a\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002\"\u0011\u0010\u0007\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0011\u0010\u000b\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0011\u0010\u000f\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0011\u0010\u0013\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"#\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006 "}, d2 = {"Lga2/a;", "c", "()Lga2/a;", "NBPLog", "Lcom/tencent/mobileqq/nearbypro/base/g;", "g", "()Lcom/tencent/mobileqq/nearbypro/base/g;", "NBPThread", "Lcom/tencent/mobileqq/nearbypro/base/b;", "b", "()Lcom/tencent/mobileqq/nearbypro/base/b;", "NBPCommon", "Lcom/tencent/mobileqq/nearbypro/base/c;", "d", "()Lcom/tencent/mobileqq/nearbypro/base/c;", "NBPMMKV", "Lcom/tencent/mobileqq/nearbypro/base/a;", "a", "()Lcom/tencent/mobileqq/nearbypro/base/a;", "NBPAppSetting", "Lcom/tencent/mobileqq/nearbypro/base/d;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "e", "()Lcom/tencent/mobileqq/nearbypro/base/d;", "NBPNetworkHelper", "Lcom/tencent/mobileqq/nearbypro/base/f;", "Lcom/tencent/libra/request/Option;", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "Lcom/tencent/libra/IPicLoader;", "f", "()Lcom/tencent/mobileqq/nearbypro/base/f;", "NBPPicLoader", "qq_nearby_pro_base_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class j {
    @NotNull
    public static final a a() {
        return i.f253231a.a().getAppSetting();
    }

    @NotNull
    public static final b b() {
        return i.f253231a.a().getCommonUtils();
    }

    @NotNull
    public static final ga2.a c() {
        return ga2.a.f401619b;
    }

    @NotNull
    public static final c d() {
        return i.f253231a.a().getMmkv();
    }

    @NotNull
    public static final d<NearbyProBaseRequest> e() {
        return i.f253231a.a().e();
    }

    @NotNull
    public static final f<Option, IPicLoadStateListener, IPicLoader> f() {
        return NearByProPicLoader.f253241a;
    }

    @NotNull
    public static final g g() {
        return i.f253231a.a().getThreadPool();
    }
}
