package com.tencent.mobileqq.timiqqid.net;

import com.tencent.mobileqq.timiqqid.helper.YoloLog;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/timiqqid/net/LogInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "Ljava/nio/charset/Charset;", "kotlin.jvm.PlatformType", "a", "Ljava/nio/charset/Charset;", "UTF8", "<init>", "()V", "b", "timi-qqid-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class LogInterceptor implements Interceptor {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static String f293205c = "LogInterceptor";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Charset UTF8 = Charset.forName("UTF-8");

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        final Request request = chain.request();
        YoloLog.d(f293205c, new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.LogInterceptor$intercept$1
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "\n";
            }
        });
        YoloLog.d(f293205c, new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.LogInterceptor$intercept$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "----------Start----------------";
            }
        });
        YoloLog.d(f293205c, new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.LogInterceptor$intercept$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "| " + Request.this;
            }
        });
        YoloLog.d(f293205c, new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.LogInterceptor$intercept$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "| " + Request.this.headers();
            }
        });
        return chain.proceed(chain.request());
    }
}
