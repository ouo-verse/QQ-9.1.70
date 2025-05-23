package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* compiled from: P */
@ProxyService(proxy = RequestProxy.class)
/* loaded from: classes34.dex */
public class bd extends RequestProxy {

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, Call> f347849a = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f347850a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f347851b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RequestProxy.RequestListener f347852c;

        a(String str, RequestProxy.RequestListener requestListener) {
            this.f347851b = str;
            this.f347852c = requestListener;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            QLog.e("RequestProxyImpl", 1, "httpConnect err url:" + this.f347851b, iOException);
            if ("Canceled".equals(iOException.getLocalizedMessage())) {
                this.f347850a = true;
                this.f347852c.onRequestFailed(-5, "request error:cancel");
            } else {
                this.f347852c.onRequestFailed(z.d(iOException, -1), "request error:network");
            }
            bd.this.f347849a.remove(this.f347851b);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            byte[] bArr;
            if (this.f347850a) {
                return;
            }
            int code = response.code();
            Map<String, List<String>> multimap = response.headers().toMultimap();
            this.f347852c.onRequestHeadersReceived(code, multimap);
            try {
                bArr = response.body().bytes();
            } catch (IOException e16) {
                e16.printStackTrace();
                bArr = null;
            }
            this.f347852c.onRequestSucceed(code, bArr, multimap);
            bd.this.f347849a.remove(this.f347851b);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy
    public void abort(String str) {
        Call call = this.f347849a.get(str);
        if (call != null) {
            call.cancel();
        }
        this.f347849a.remove(str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy
    public boolean request(String str, byte[] bArr, Map<String, String> map, String str2, int i3, RequestProxy.RequestListener requestListener) {
        Call newCall = MiniOkHttpClientFactory.getRequestClientWithSpecialTimeout(i3).newCall(z.b(str, map, str2.toUpperCase(), null, bArr));
        newCall.enqueue(new a(str, requestListener));
        this.f347849a.put(str, newCall);
        return true;
    }
}
