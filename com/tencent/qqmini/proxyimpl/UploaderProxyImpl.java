package com.tencent.qqmini.proxyimpl;

import android.net.http.Headers;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.minigame.utils.thread.TTHandleThread;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@ProxyService(proxy = UploaderProxy.class)
/* loaded from: classes34.dex */
public class UploaderProxyImpl extends UploaderProxy {

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, Call> f347574a = new ConcurrentHashMap<>();

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy
    public void abort(String str) {
        Call call = this.f347574a.get(str);
        if (call != null) {
            call.cancel();
        }
        this.f347574a.remove(str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy
    public boolean upload(final String str, final Map<String, String> map, final String str2, final String str3, final String str4, final Map<String, String> map2, int i3, final UploaderProxy.UploadListener uploadListener) {
        TTHandleThread.getInstance().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.UploaderProxyImpl.1

            /* renamed from: com.tencent.qqmini.proxyimpl.UploaderProxyImpl$1$a */
            /* loaded from: classes34.dex */
            class a implements Callback {

                /* renamed from: a, reason: collision with root package name */
                private volatile boolean f347581a = false;

                a() {
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    QLog.e("UploaderProxyImpl", 1, "httpConnect err url:" + str, iOException);
                    if ("Canceled".equals(iOException.getLocalizedMessage())) {
                        uploadListener.onUploadFailed(-5, "download error:cancel");
                    } else {
                        uploadListener.onUploadFailed(z.d(iOException, -1), "request error:network");
                    }
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    UploaderProxyImpl.this.f347574a.remove(str);
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    if (this.f347581a) {
                        return;
                    }
                    int code = response.code();
                    Map<String, List<String>> multimap = response.headers().toMultimap();
                    uploadListener.onUploadHeadersReceived(code, multimap);
                    uploadListener.onUploadSucceed(code, response.body().bytes(), multimap);
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    UploaderProxyImpl.this.f347574a.remove(str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                OkHttpClient uploadClient = MiniOkHttpClientFactory.getUploadClient();
                Request.Builder builder = new Request.Builder();
                builder.tag(uploadClient).url(str).addHeader(HttpHeader.RSP.CHARSET, "utf-8").addHeader(Headers.CONN_DIRECTIVE, "keep-alive");
                Map map3 = map;
                if (map3 != null) {
                    for (String str5 : map3.keySet()) {
                        builder.addHeader(str5, (String) map.get(str5));
                    }
                }
                builder.method("POST", z.a(str2, map2, str3, str4, uploadListener));
                Call newCall = uploadClient.newCall(builder.build());
                newCall.enqueue(new a());
                UploaderProxyImpl.this.f347574a.put(str, newCall);
            }
        });
        return true;
    }
}
