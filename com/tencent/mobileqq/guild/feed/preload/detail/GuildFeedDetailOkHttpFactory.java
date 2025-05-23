package com.tencent.mobileqq.guild.feed.preload.detail;

import android.webkit.URLUtil;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ.\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u000e\u001a\u00020\nR\u001b\u0010\u0015\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0019\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/preload/detail/GuildFeedDetailOkHttpFactory;", "", "", "timeout", "", "enableHttp2", "Lokhttp3/OkHttpClient$Builder;", "c", "Lokhttp3/OkHttpClient;", "d", "", "url", "", "headers", "bodyJson", "Lokhttp3/Request;", "b", "Lokhttp3/ConnectionPool;", "Lkotlin/Lazy;", "e", "()Lokhttp3/ConnectionPool;", "connectionPool", "Lokhttp3/Dispatcher;", "f", "()Lokhttp3/Dispatcher;", "dispatcher", "g", "()Lokhttp3/OkHttpClient;", "requestClient", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedDetailOkHttpFactory {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildFeedDetailOkHttpFactory f222769a = new GuildFeedDetailOkHttpFactory();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy connectionPool;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy dispatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy requestClient;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConnectionPool>() { // from class: com.tencent.mobileqq.guild.feed.preload.detail.GuildFeedDetailOkHttpFactory$connectionPool$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConnectionPool invoke() {
                return new ConnectionPool(10, 60L, TimeUnit.SECONDS);
            }
        });
        connectionPool = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Dispatcher>() { // from class: com.tencent.mobileqq.guild.feed.preload.detail.GuildFeedDetailOkHttpFactory$dispatcher$2
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
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<OkHttpClient>() { // from class: com.tencent.mobileqq.guild.feed.preload.detail.GuildFeedDetailOkHttpFactory$requestClient$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final OkHttpClient invoke() {
                OkHttpClient.Builder c16;
                c16 = GuildFeedDetailOkHttpFactory.f222769a.c(60000L, true);
                return c16.build();
            }
        });
        requestClient = lazy3;
    }

    GuildFeedDetailOkHttpFactory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient.Builder c(long timeout, boolean enableHttp2) {
        List<? extends Protocol> listOf;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (!enableHttp2) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(Protocol.HTTP_1_1);
        } else {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
        }
        OkHttpClient.Builder protocols = builder.protocols(listOf);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return protocols.connectTimeout(timeout, timeUnit).readTimeout(timeout, timeUnit).writeTimeout(timeout, timeUnit).connectionPool(e()).dispatcher(f());
    }

    private final ConnectionPool e() {
        return (ConnectionPool) connectionPool.getValue();
    }

    private final Dispatcher f() {
        return (Dispatcher) dispatcher.getValue();
    }

    private final OkHttpClient g() {
        return (OkHttpClient) requestClient.getValue();
    }

    @Nullable
    public final Request b(@NotNull String url, @NotNull Map<String, String> headers, @NotNull String bodyJson) {
        boolean z16;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(bodyJson, "bodyJson");
        if (URLUtil.isNetworkUrl(url) && !headers.isEmpty()) {
            if (bodyJson.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Request.Builder url2 = new Request.Builder().url(url);
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    url2.addHeader(entry.getKey(), entry.getValue());
                }
                url2.method("POST", RequestBody.INSTANCE.create(MediaType.INSTANCE.parse("application/json"), bodyJson));
                return url2.build();
            }
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "buildRequest error, url: " + url;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GuildFeedDetailOkHttpFactory", 1, (String) it.next(), null);
        }
        return null;
    }

    @NotNull
    public final OkHttpClient d() {
        return g();
    }
}
