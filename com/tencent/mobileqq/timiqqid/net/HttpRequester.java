package com.tencent.mobileqq.timiqqid.net;

import com.tencent.mobileqq.timiqqid.helper.YoloLog;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J*\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/timiqqid/net/HttpRequester;", "", "T", "Lcom/tencent/mobileqq/timiqqid/net/c;", "listener", "Ljava/lang/Class;", "b", "", "url", "cookie", "callback", "", "d", "Lokhttp3/OkHttpClient;", "c", "Lokhttp3/OkHttpClient;", "client", "<init>", "()V", "timi-qqid-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class HttpRequester {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final HttpRequester f293200a = new HttpRequester();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final OkHttpClient client = new OkHttpClient.Builder().callTimeout(10, TimeUnit.SECONDS).addNetworkInterceptor(new LogInterceptor()).build();

    HttpRequester() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Class<T> b(final c<T> listener) {
        try {
            YoloLog.d("HttpRequester", new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.HttpRequester$findSuccessMethodType$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    if (listener == null) {
                        return "listener is null";
                    }
                    return "listener is " + listener.getClass().getName();
                }
            });
        } catch (IllegalAccessException e16) {
            YoloLog.e("HttpRequester", new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.HttpRequester$findSuccessMethodType$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "error while obtain rsp " + e16 + TokenParser.SP;
                }
            });
        } catch (InstantiationException e17) {
            YoloLog.e("HttpRequester", new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.HttpRequester$findSuccessMethodType$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "error while obtain rsp " + e17;
                }
            });
        } catch (Throwable th5) {
            YoloLog.e("HttpRequester", new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.HttpRequester$findSuccessMethodType$6
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "error while obtain rsp " + th5;
                }
            });
        }
        if (listener == null) {
            return null;
        }
        for (final Method method : listener.getClass().getMethods()) {
            YoloLog.d("HttpRequester", new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.HttpRequester$findSuccessMethodType$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "methodName:" + method.getName();
                }
            });
            final Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                if (genericParameterTypes.length == 1 && Intrinsics.areEqual(method.getReturnType(), Void.TYPE) && genericParameterTypes[0] != Object.class) {
                    YoloLog.d("HttpRequester", new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.HttpRequester$findSuccessMethodType$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            return "findClass:" + parameterTypes[0];
                        }
                    });
                    Class<T> cls = (Class<T>) parameterTypes[0];
                    Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of com.tencent.mobileqq.timiqqid.net.HttpRequester.findSuccessMethodType>");
                    return cls;
                }
            }
        }
        YoloLog.d("HttpRequester", new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.HttpRequester$findSuccessMethodType$7
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "nothing match,just return null";
            }
        });
        return null;
    }

    @NotNull
    public final OkHttpClient c() {
        return client;
    }

    public final <T> void d(@NotNull final String url, @NotNull String cookie, @NotNull c<T> callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OkHttpClient c16 = c();
        Request build = new Request.Builder().headers(new Headers.Builder().add(cookie).build()).get().url(url).build();
        Call newCall = c16.newCall(build);
        YoloLog.d("HttpRequester", new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.HttpRequester$requestGet$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "start request : " + url;
            }
        });
        newCall.enqueue(new HttpRequester$requestGet$2(build, callback));
    }
}
