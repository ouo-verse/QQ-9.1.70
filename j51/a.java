package j51;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lj51/a;", "", "Lokhttp3/OkHttpClient;", "a", "Lokhttp3/OkHttpClient;", "()Lokhttp3/OkHttpClient;", "sOkHttpClient", "<init>", "()V", "MiniBoxCommon_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final OkHttpClient sOkHttpClient;

    /* renamed from: b, reason: collision with root package name */
    public static final a f409276b = new a();

    static {
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = newBuilder.connectTimeout(10L, timeUnit).readTimeout(10L, timeUnit).writeTimeout(10L, timeUnit).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "OkHttpClient().newBuilde\u2026NDS)\n            .build()");
        sOkHttpClient = build;
    }

    a() {
    }

    @NotNull
    public final OkHttpClient a() {
        return sOkHttpClient;
    }
}
