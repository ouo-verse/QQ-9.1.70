package com.tencent.qqlive.superplayer.tools.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.superplayer.thirdparties.httpclient.HttpDataSource;
import com.tencent.qqlive.superplayer.thirdparties.httpclient.Request;
import com.tencent.qqlive.superplayer.thirdparties.httpclient.j;
import com.tencent.qqlive.superplayer.thirdparties.httpclient.k;
import com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements ITVKHttpProcessor, Handler.Callback {
    private static volatile b C = null;

    /* renamed from: h, reason: collision with root package name */
    private static volatile int f345478h = 2;

    /* renamed from: i, reason: collision with root package name */
    private static volatile boolean f345479i = true;

    /* renamed from: m, reason: collision with root package name */
    private static volatile int f345480m = 30;

    /* renamed from: d, reason: collision with root package name */
    private final HttpDataSource.b f345481d;

    /* renamed from: e, reason: collision with root package name */
    private final j f345482e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f345483f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Request.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ITVKHttpProcessor.b f345484a;

        a(ITVKHttpProcessor.b bVar) {
            this.f345484a = bVar;
        }

        @Override // com.tencent.qqlive.superplayer.thirdparties.httpclient.Request.a
        public void a(Request request, k kVar) {
            this.f345484a.onSuccess(new ITVKHttpProcessor.a(kVar.f345467b, kVar.f345466a));
            if (!b.f345479i) {
                b.this.h();
            }
        }

        @Override // com.tencent.qqlive.superplayer.thirdparties.httpclient.Request.a
        public void b(Request request, IOException iOException) {
            if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = (HttpDataSource.InvalidResponseCodeException) iOException;
                iOException = new ITVKHttpProcessor.InvalidResponseCodeException(invalidResponseCodeException.responseCode, invalidResponseCodeException.responseMessage);
            }
            this.f345484a.onFailure(iOException);
            if (!b.f345479i) {
                b.this.h();
            }
        }
    }

    b(HttpDataSource.b bVar) {
        if (bVar == null) {
            this.f345481d = new com.tencent.qqlive.superplayer.thirdparties.httpclient.g("qqlive");
        } else {
            this.f345481d = bVar;
        }
        this.f345483f = new Handler(Looper.getMainLooper(), this);
        j jVar = new j(new com.tencent.qqlive.superplayer.thirdparties.httpclient.c(this.f345481d), f345478h);
        this.f345482e = jVar;
        if (f345479i) {
            jVar.g();
        }
    }

    public static b e() {
        return g(null);
    }

    private void f(int i3, String str, Map<String, String> map, byte[] bArr, int i16, ITVKHttpProcessor.b bVar) {
        Request request = new Request(i3, str, map, bArr, i16, new a(bVar));
        if (!f345479i) {
            this.f345482e.d();
        }
        this.f345482e.a(request);
    }

    public static b g(HttpDataSource.b bVar) {
        if (C == null) {
            synchronized (b.class) {
                if (C == null) {
                    C = new b(bVar);
                }
            }
        }
        return C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f345483f.removeMessages(1);
        this.f345483f.sendEmptyMessageDelayed(1, f345480m * 1000);
    }

    public static void i(int i3, boolean z16, int i16) {
        f345478h = i3;
        f345479i = z16;
        f345480m = i16;
    }

    @Override // com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor
    public void a(@NonNull String str, @Nullable Map<String, String> map, @NonNull byte[] bArr, int i3, @NonNull ITVKHttpProcessor.b bVar) {
        f(2, str, map, bArr, i3, bVar);
    }

    @Override // com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor
    public void b(@NonNull String str, @Nullable Map<String, String> map, int i3, @NonNull ITVKHttpProcessor.b bVar) {
        f(1, str, map, null, i3, bVar);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1 && !f345479i && this.f345482e.f() == 0) {
            this.f345482e.e();
            return false;
        }
        return false;
    }
}
