package com.tencent.mobileqq.guild.discoveryv2.net;

import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003BD\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f\u0012\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0010\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J=\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\t0\b2\u0006\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bR\"\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR3\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00108\u0002X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/net/NetworkCacheManager;", "Req", "Rsp", "", "req", "", "useCache", "updateCache", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/guild/discoveryv2/net/h;", "c", "(Ljava/lang/Object;ZZ)Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/guild/discoveryv2/net/b;", "a", "Lcom/tencent/mobileqq/guild/discoveryv2/net/b;", QQPermissionConstants.Permission.STORAGE_GROUP, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "b", "Lkotlin/jvm/functions/Function2;", "networkRequestFunction", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/net/b;Lkotlin/jvm/functions/Function2;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class NetworkCacheManager<Req, Rsp> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final b<Req, Rsp> storage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<Req, Continuation<? super Rsp>, Object> networkRequestFunction;

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkCacheManager(@Nullable b<Req, Rsp> bVar, @NotNull Function2<? super Req, ? super Continuation<? super Rsp>, ? extends Object> networkRequestFunction) {
        Intrinsics.checkNotNullParameter(networkRequestFunction, "networkRequestFunction");
        this.storage = bVar;
        this.networkRequestFunction = networkRequestFunction;
    }

    @NotNull
    public final Flow<NetTransaction<Req, ? extends Rsp>> c(Req req, boolean useCache, boolean updateCache) {
        return FlowKt.flow(new NetworkCacheManager$fetch$1(useCache, req, updateCache, this, null));
    }
}
