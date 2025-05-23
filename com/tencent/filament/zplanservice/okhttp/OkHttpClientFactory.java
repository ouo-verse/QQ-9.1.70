package com.tencent.filament.zplanservice.okhttp;

import dl0.g;
import fl0.a;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\rR\u001b\u0010\u0012\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/filament/zplanservice/okhttp/OkHttpClientFactory;", "", "", "timeout", "Lokhttp3/OkHttpClient$Builder;", "b", "Lokhttp3/ConnectionPool;", "a", "Lkotlin/Lazy;", "c", "()Lokhttp3/ConnectionPool;", "connectionPool", "", "Z", "enableHttp2", "Lokhttp3/Dispatcher;", "d", "()Lokhttp3/Dispatcher;", "dispatcher", "Lokhttp3/OkHttpClient;", "getRequestClient", "()Lokhttp3/OkHttpClient;", "requestClient", "e", "getUploadClient", "uploadClient", "f", "downloadClient", "<init>", "()V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class OkHttpClientFactory {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy connectionPool;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final boolean enableHttp2;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy dispatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy requestClient;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy uploadClient;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy downloadClient;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final OkHttpClientFactory f106417g = new OkHttpClientFactory();

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConnectionPool>() { // from class: com.tencent.filament.zplanservice.okhttp.OkHttpClientFactory$connectionPool$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConnectionPool invoke() {
                return new ConnectionPool(10, 60L, TimeUnit.SECONDS);
            }
        });
        connectionPool = lazy;
        g gVar = (g) a.f399763a.a(g.class);
        boolean z16 = false;
        if (gVar != null) {
            z16 = gVar.isSwitchOn("filament_okhttp_enable_http2", false);
        }
        enableHttp2 = z16;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Dispatcher>() { // from class: com.tencent.filament.zplanservice.okhttp.OkHttpClientFactory$dispatcher$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Dispatcher invoke() {
                Dispatcher dispatcher2 = new Dispatcher();
                dispatcher2.setMaxRequests(64);
                dispatcher2.setMaxRequestsPerHost(8);
                return dispatcher2;
            }
        });
        dispatcher = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<OkHttpClient>() { // from class: com.tencent.filament.zplanservice.okhttp.OkHttpClientFactory$requestClient$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final OkHttpClient invoke() {
                OkHttpClient.Builder b16;
                b16 = OkHttpClientFactory.f106417g.b(60000);
                return b16.build();
            }
        });
        requestClient = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<OkHttpClient>() { // from class: com.tencent.filament.zplanservice.okhttp.OkHttpClientFactory$uploadClient$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final OkHttpClient invoke() {
                OkHttpClient.Builder b16;
                b16 = OkHttpClientFactory.f106417g.b(60000);
                return b16.build();
            }
        });
        uploadClient = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<OkHttpClient>() { // from class: com.tencent.filament.zplanservice.okhttp.OkHttpClientFactory$downloadClient$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final OkHttpClient invoke() {
                OkHttpClient.Builder b16;
                b16 = OkHttpClientFactory.f106417g.b(60000);
                return b16.build();
            }
        });
        downloadClient = lazy5;
    }

    OkHttpClientFactory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient.Builder b(int timeout) {
        List<? extends Protocol> listOf;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (!enableHttp2) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(Protocol.HTTP_1_1);
        } else {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
        }
        OkHttpClient.Builder protocols = builder.protocols(listOf);
        long j3 = timeout;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return protocols.connectTimeout(j3, timeUnit).readTimeout(j3, timeUnit).writeTimeout(j3, timeUnit).connectionPool(c()).dispatcher(d());
    }

    private final ConnectionPool c() {
        return (ConnectionPool) connectionPool.getValue();
    }

    private final Dispatcher d() {
        return (Dispatcher) dispatcher.getValue();
    }

    @NotNull
    public final OkHttpClient e() {
        return (OkHttpClient) downloadClient.getValue();
    }
}
