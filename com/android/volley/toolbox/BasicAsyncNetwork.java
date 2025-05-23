package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.RequestTask;
import com.android.volley.VolleyError;
import com.android.volley.b;
import com.android.volley.toolbox.j;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class BasicAsyncNetwork extends com.android.volley.b {

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class InvokeRetryPolicyTask<T> extends RequestTask<T> {

        /* renamed from: e, reason: collision with root package name */
        final Request<T> f31355e;

        /* renamed from: f, reason: collision with root package name */
        final j.b f31356f;

        /* renamed from: h, reason: collision with root package name */
        final b.a f31357h;
        final /* synthetic */ BasicAsyncNetwork this$0;

        @Override // java.lang.Runnable
        public void run() {
            try {
                j.a(this.f31355e, this.f31356f);
                throw null;
            } catch (VolleyError e16) {
                this.f31357h.a(e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class ResponseParsingTask<T> extends RequestTask<T> {
        List<com.android.volley.e> C;
        int D;

        /* renamed from: e, reason: collision with root package name */
        InputStream f31358e;

        /* renamed from: f, reason: collision with root package name */
        f f31359f;

        /* renamed from: h, reason: collision with root package name */
        Request<T> f31360h;

        /* renamed from: i, reason: collision with root package name */
        b.a f31361i;

        /* renamed from: m, reason: collision with root package name */
        long f31362m;
        final /* synthetic */ BasicAsyncNetwork this$0;

        @Override // java.lang.Runnable
        public void run() {
            try {
                BasicAsyncNetwork.d(null, this.f31362m, this.D, this.f31359f, this.f31360h, this.f31361i, this.C, j.c(this.f31358e, this.f31359f.b(), BasicAsyncNetwork.c(null)));
            } catch (IOException e16) {
                BasicAsyncNetwork.b(null, this.f31360h, this.f31361i, e16, this.f31362m, this.f31359f, null);
            }
        }
    }

    static /* synthetic */ void b(BasicAsyncNetwork basicAsyncNetwork, Request request, b.a aVar, IOException iOException, long j3, f fVar, byte[] bArr) {
        throw null;
    }

    static /* synthetic */ c c(BasicAsyncNetwork basicAsyncNetwork) {
        throw null;
    }

    static /* synthetic */ void d(BasicAsyncNetwork basicAsyncNetwork, long j3, int i3, f fVar, Request request, b.a aVar, List list, byte[] bArr) {
        throw null;
    }
}
