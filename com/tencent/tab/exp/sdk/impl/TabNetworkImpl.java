package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import com.tencent.tab.exp.sdk.export.injector.network.TabMetricsNetInfo;
import com.tencent.tab.exp.sdk.export.injector.network.b;
import gd4.b;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class TabNetworkImpl implements com.tencent.tab.exp.sdk.export.injector.network.a {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final jd4.a f374058a;

    /* renamed from: c, reason: collision with root package name */
    private final Map<Call, ed4.b> f374060c = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final OkHttpClient f374059b = new OkHttpClient.Builder().build();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class OkHttpBytesSoftTask extends TabSoftTask<TabNetworkImpl> {

        /* renamed from: e, reason: collision with root package name */
        @NonNull
        private final Call f374061e;

        @Override // java.lang.Runnable
        public void run() {
            TabNetworkImpl e16 = e();
            if (e16 == null) {
                return;
            }
            TabMetricsNetInfo tabMetricsNetInfo = new TabMetricsNetInfo();
            Response response = null;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                response = this.f374061e.execute();
                tabMetricsNetInfo.l((float) (System.currentTimeMillis() - currentTimeMillis));
                tabMetricsNetInfo.k(TabMetricsNetInfo.RecordType.RECORD_SUCCESS);
            } catch (SocketTimeoutException unused) {
                tabMetricsNetInfo.k(TabMetricsNetInfo.RecordType.RECORD_TIMEOUT);
            } catch (Exception unused2) {
                tabMetricsNetInfo.k(TabMetricsNetInfo.RecordType.RECORD_FAILED);
            }
            ed4.b bVar = (ed4.b) e16.f374060c.remove(this.f374061e);
            if (bVar != null) {
                bVar.a(TabNetworkImpl.j(response), TabNetworkImpl.i(response), TabNetworkImpl.h(response, tabMetricsNetInfo));
            }
        }

        OkHttpBytesSoftTask(TabNetworkImpl tabNetworkImpl, @NonNull Call call) {
            super(tabNetworkImpl);
            this.f374061e = call;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TabNetworkImpl(@NonNull jd4.a aVar) {
        this.f374058a = aVar;
    }

    private static int f(Response response) {
        if (response == null) {
            return -1;
        }
        return response.code();
    }

    private static boolean g(Response response) {
        if (f(response) == 200) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TabMetricsNetInfo h(Response response, TabMetricsNetInfo tabMetricsNetInfo) {
        if (response == null) {
            return null;
        }
        tabMetricsNetInfo.h(response.request().url().encodedPath());
        tabMetricsNetInfo.m(f(response));
        if (g(response)) {
            tabMetricsNetInfo.k(TabMetricsNetInfo.RecordType.RECORD_SUCCESS);
        } else {
            tabMetricsNetInfo.k(TabMetricsNetInfo.RecordType.RECORD_FAILED);
        }
        tabMetricsNetInfo.n((float) (response.receivedResponseAtMillis() - response.sentRequestAtMillis()));
        return tabMetricsNetInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static gd4.b i(Response response) {
        byte[] bArr = null;
        if (response == null) {
            return null;
        }
        try {
            bArr = response.body().bytes();
        } catch (Exception unused) {
        }
        return new b.C10371b().a(bArr).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.tencent.tab.exp.sdk.export.injector.network.b j(Response response) {
        if (g(response)) {
            return new b.C9878b().h(1).i("\u8bf7\u6c42\u6210\u529f").e();
        }
        return new b.C9878b().h(-1).i("\u8bf7\u6c42\u5931\u8d25").f(f(response)).g("unknown").e();
    }

    @Override // com.tencent.tab.exp.sdk.export.injector.network.a
    public long a(fd4.b bVar, ed4.b bVar2) {
        if (bVar == null) {
            return -1L;
        }
        String d16 = x.d(bVar.e(), "");
        byte[] bArr = (byte[]) x.e(bVar.c(), new byte[0]);
        int c16 = x.c(bVar.b(), 15);
        int c17 = x.c(bVar.d(), 15);
        int c18 = x.c(bVar.f(), 15);
        Request build = new Request.Builder().url(d16).post(RequestBody.create(MediaType.parse("application/proto"), bArr)).build();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Call newCall = this.f374059b.newBuilder().connectTimeout(c16, timeUnit).readTimeout(c17, timeUnit).writeTimeout(c18, timeUnit).build().newCall(build);
        this.f374060c.put(newCall, bVar2);
        this.f374058a.execWorkTask(new OkHttpBytesSoftTask(newCall));
        return -1L;
    }
}
