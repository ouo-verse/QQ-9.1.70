package com.tencent.mobileqq.timiqqid.net;

import android.os.Handler;
import com.google.gson.Gson;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.timiqqid.helper.YoloLog;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/timiqqid/net/HttpRequester$requestGet$2", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "timi-qqid-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class HttpRequester$requestGet$2 implements Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Request f293202a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c<T> f293203b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpRequester$requestGet$2(Request request, c<T> cVar) {
        this.f293202a = request;
        this.f293203b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(c callback, IOException e16) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(e16, "$e");
        callback.onFail(-1, e16.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Response response, c callback, String body) {
        Class b16;
        Intrinsics.checkNotNullParameter(response, "$response");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(body, "$body");
        if (response.code() == 200) {
            b16 = HttpRequester.f293200a.b(callback);
            if (b16 == null) {
                YoloLog.e("HttpRequester", new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.HttpRequester$requestGet$2$onResponse$2$1
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        return "onResponse can not find dataClazz";
                    }
                });
                return;
            }
            try {
                if (Intrinsics.areEqual(b16, String.class)) {
                    callback.onSuccess(body);
                    return;
                }
                Object fromJson = new Gson().fromJson(body, (Class<Object>) b16);
                if (fromJson == null) {
                    YoloLog.e("HttpRequester", new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.HttpRequester$requestGet$2$onResponse$2$2
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            return "onResponse data is null";
                        }
                    });
                    callback.onFail(response.code(), body);
                    return;
                } else {
                    callback.onSuccess(fromJson);
                    return;
                }
            } catch (Exception e16) {
                YoloLog.e("HttpRequester", new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.HttpRequester$requestGet$2$onResponse$2$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        return "error:" + e16;
                    }
                });
                return;
            }
        }
        callback.onFail(response.code(), body);
    }

    @Override // okhttp3.Callback
    public void onFailure(@NotNull Call call, @NotNull final IOException e16) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e16, "e");
        final Request request = this.f293202a;
        YoloLog.d("HttpRequester", new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.HttpRequester$requestGet$2$onFailure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return Request.this.url() + " onFailure,exception:" + e16.getMessage();
            }
        });
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final c<T> cVar = this.f293203b;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.timiqqid.net.a
            @Override // java.lang.Runnable
            public final void run() {
                HttpRequester$requestGet$2.c(c.this, e16);
            }
        });
    }

    @Override // okhttp3.Callback
    public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
        final String string;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.body() == null) {
            string = "null";
        } else {
            ResponseBody body = response.body();
            Intrinsics.checkNotNull(body);
            string = body.string();
        }
        YoloLog.d("HttpRequester", new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.HttpRequester$requestGet$2$onResponse$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "onResponse,response:" + Response.this + ",\nbody:" + string;
            }
        });
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final c<T> cVar = this.f293203b;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.timiqqid.net.b
            @Override // java.lang.Runnable
            public final void run() {
                HttpRequester$requestGet$2.d(Response.this, cVar, string);
            }
        });
    }
}
