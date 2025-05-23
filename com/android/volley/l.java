package com.android.volley;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.volley.Request;
import com.android.volley.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class l implements Request.a {

    /* renamed from: b, reason: collision with root package name */
    private final i f31351b;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final CacheDispatcher f31353d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final BlockingQueue<Request<?>> f31354e;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, List<Request<?>>> f31350a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final RequestQueue f31352c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(@NonNull CacheDispatcher cacheDispatcher, @NonNull BlockingQueue<Request<?>> blockingQueue, i iVar) {
        this.f31351b = iVar;
        this.f31353d = cacheDispatcher;
        this.f31354e = blockingQueue;
    }

    @Override // com.android.volley.Request.a
    public void a(Request<?> request, h<?> hVar) {
        List<Request<?>> remove;
        c.a aVar = hVar.f31338b;
        if (aVar != null && !aVar.a()) {
            String cacheKey = request.getCacheKey();
            synchronized (this) {
                remove = this.f31350a.remove(cacheKey);
            }
            if (remove != null) {
                if (k.f31342b) {
                    k.e("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                }
                Iterator<Request<?>> it = remove.iterator();
                while (it.hasNext()) {
                    this.f31351b.b(it.next(), hVar);
                }
                return;
            }
            return;
        }
        b(request);
    }

    @Override // com.android.volley.Request.a
    public synchronized void b(Request<?> request) {
        BlockingQueue<Request<?>> blockingQueue;
        String cacheKey = request.getCacheKey();
        List<Request<?>> remove = this.f31350a.remove(cacheKey);
        if (remove != null && !remove.isEmpty()) {
            if (k.f31342b) {
                k.e("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
            }
            Request<?> remove2 = remove.remove(0);
            this.f31350a.put(cacheKey, remove);
            remove2.setNetworkRequestCompleteListener(this);
            RequestQueue requestQueue = this.f31352c;
            if (requestQueue != null) {
                requestQueue.h(remove2);
            } else if (this.f31353d != null && (blockingQueue = this.f31354e) != null) {
                try {
                    blockingQueue.put(remove2);
                } catch (InterruptedException e16) {
                    k.c("Couldn't add request to queue. %s", e16.toString());
                    Thread.currentThread().interrupt();
                    this.f31353d.quit();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean c(Request<?> request) {
        String cacheKey = request.getCacheKey();
        if (this.f31350a.containsKey(cacheKey)) {
            List<Request<?>> list = this.f31350a.get(cacheKey);
            if (list == null) {
                list = new ArrayList<>();
            }
            request.addMarker("waiting-for-response");
            list.add(request);
            this.f31350a.put(cacheKey, list);
            if (k.f31342b) {
                k.b("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
            }
            return true;
        }
        this.f31350a.put(cacheKey, null);
        request.setNetworkRequestCompleteListener(this);
        if (k.f31342b) {
            k.b("new request, sending to network %s", cacheKey);
        }
        return false;
    }
}
