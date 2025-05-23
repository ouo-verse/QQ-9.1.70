package com.tencent.mobileqq.vashealth.honorstep;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u0006\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vashealth/honorstep/HttpRequest;", "", "", "d", "Lokhttp3/OkHttpClient;", "c", "b", "Lokhttp3/OkHttpClient;", "requestClient", "Lokhttp3/ConnectionPool;", "Lkotlin/Lazy;", "a", "()Lokhttp3/ConnectionPool;", "connectionPool", "Lokhttp3/Dispatcher;", "()Lokhttp3/Dispatcher;", "dispatcher", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class HttpRequest {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final HttpRequest f312280a = new HttpRequest();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile OkHttpClient requestClient;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy connectionPool;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy dispatcher;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConnectionPool>() { // from class: com.tencent.mobileqq.vashealth.honorstep.HttpRequest$connectionPool$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConnectionPool invoke() {
                return new ConnectionPool(10, 60L, TimeUnit.SECONDS);
            }
        });
        connectionPool = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Dispatcher>() { // from class: com.tencent.mobileqq.vashealth.honorstep.HttpRequest$dispatcher$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Dispatcher invoke() {
                return new Dispatcher();
            }
        });
        dispatcher = lazy2;
    }

    HttpRequest() {
    }

    private final ConnectionPool a() {
        return (ConnectionPool) connectionPool.getValue();
    }

    private final Dispatcher b() {
        return (Dispatcher) dispatcher.getValue();
    }

    private final void d() {
        List<? extends Protocol> listOf;
        b().setMaxRequests(64);
        b().setMaxRequestsPerHost(8);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
        OkHttpClient.Builder protocols = builder.protocols(listOf);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        requestClient = protocols.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).connectionPool(a()).dispatcher(b()).build();
    }

    @NotNull
    public final OkHttpClient c() {
        if (requestClient == null) {
            synchronized (this) {
                if (requestClient == null) {
                    f312280a.d();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        OkHttpClient okHttpClient = requestClient;
        Intrinsics.checkNotNull(okHttpClient);
        return okHttpClient;
    }
}
