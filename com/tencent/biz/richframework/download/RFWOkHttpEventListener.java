package com.tencent.biz.richframework.download;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public interface RFWOkHttpEventListener {
    void callEnd(Call call);

    void callFailed(Call call, IOException iOException);

    void callStart(Call call);

    void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol2);

    void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol2, IOException iOException);

    void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy);

    void connectionAcquired(Call call, Connection connection);

    void connectionReleased(Call call, Connection connection);

    void dnsEnd(Call call, String str, List<InetAddress> list);

    void dnsStart(Call call, String str);

    void requestBodyEnd(Call call, long j3);

    void requestBodyStart(Call call);

    void requestHeadersEnd(Call call, Request request);

    void requestHeadersStart(Call call);

    void responseBodyEnd(Call call, long j3);

    void responseBodyStart(Call call);

    void responseHeadersEnd(Call call, Response response);

    void responseHeadersStart(Call call);

    void secureConnectEnd(Call call, @Nullable Handshake handshake);

    void secureConnectStart(Call call);
}
