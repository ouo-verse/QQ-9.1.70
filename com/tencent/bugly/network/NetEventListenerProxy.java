package com.tencent.bugly.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes5.dex */
class NetEventListenerProxy extends EventListener {
    ArrayList<EventListener> listeners = new ArrayList<>();

    public void addEventListener(@NonNull EventListener eventListener) {
        if (!this.listeners.contains(eventListener)) {
            this.listeners.add(eventListener);
        }
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().callEnd(call);
        }
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().callFailed(call, iOException);
        }
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().callStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol2) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().connectEnd(call, inetSocketAddress, proxy, protocol2);
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol2, IOException iOException) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().connectFailed(call, inetSocketAddress, proxy, protocol2, iOException);
        }
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().connectStart(call, inetSocketAddress, proxy);
        }
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().connectionAcquired(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().connectionReleased(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().dnsEnd(call, str, list);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().dnsStart(call, str);
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j3) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().requestBodyEnd(call, j3);
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().requestBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().requestHeadersEnd(call, request);
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().requestHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j3) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().responseBodyEnd(call, j3);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().responseBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().responseHeadersEnd(call, response);
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().responseHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, @Nullable Handshake handshake) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().secureConnectEnd(call, handshake);
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        Iterator<EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().secureConnectStart(call);
        }
    }
}
