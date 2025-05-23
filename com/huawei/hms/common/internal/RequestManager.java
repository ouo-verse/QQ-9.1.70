package com.huawei.hms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes2.dex */
public class RequestManager implements Handler.Callback {
    public static final int NOTIFY_CONNECT_FAILED = 10012;
    public static final int NOTIFY_CONNECT_SUCCESS = 10011;
    public static final int NOTIFY_CONNECT_SUSPENDED = 10013;

    /* renamed from: b, reason: collision with root package name */
    private static volatile RequestManager f36873b;

    /* renamed from: c, reason: collision with root package name */
    private static Handler f36874c;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f36872a = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static Queue<HuaweiApi.RequestHandler> f36875d = new ConcurrentLinkedQueue();

    /* renamed from: e, reason: collision with root package name */
    private static Map<String, HuaweiApi.RequestHandler> f36876e = new LinkedHashMap();

    RequestManager(Looper looper) {
        f36874c = new Handler(looper, this);
    }

    public static void addRequestToQueue(HuaweiApi.RequestHandler requestHandler) {
        f36875d.add(requestHandler);
    }

    public static void addToConnectedReqMap(final String str, final HuaweiApi.RequestHandler requestHandler) {
        if (f36874c == null) {
            return;
        }
        HMSLog.i("RequestManager", "addToConnectedReqMap");
        f36874c.post(new Runnable() { // from class: com.huawei.hms.common.internal.RequestManager.1
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.f36876e.put(str, requestHandler);
            }
        });
    }

    private void b() {
        while (!f36875d.isEmpty()) {
            HuaweiApi.RequestHandler poll = f36875d.poll();
            if (poll != null) {
                Object client = poll.getClient();
                if (client instanceof BaseHmsClient) {
                    BaseHmsClient baseHmsClient = (BaseHmsClient) client;
                    baseHmsClient.setService(IAIDLInvoke.Stub.asInterface(baseHmsClient.getAdapter().getServiceBinder()));
                    poll.onConnected();
                }
            }
        }
    }

    private void c() {
        HMSLog.i("RequestManager", "NOTIFY_CONNECT_SUSPENDED.");
        while (!f36875d.isEmpty()) {
            f36875d.poll().onConnectionSuspended(1);
        }
        d();
    }

    private void d() {
        HMSLog.i("RequestManager", "notifyRunningRequestConnectSuspend, connectedReqMap.size(): " + f36876e.size());
        Iterator<Map.Entry<String, HuaweiApi.RequestHandler>> it = f36876e.entrySet().iterator();
        while (it.hasNext()) {
            try {
                it.next().getValue().onConnectionSuspended(1);
            } catch (RuntimeException e16) {
                HMSLog.e("RequestManager", "NOTIFY_CONNECT_SUSPENDED Exception: " + e16.getMessage());
            }
            it.remove();
        }
    }

    public static Handler getHandler() {
        return f36874c;
    }

    public static RequestManager getInstance() {
        synchronized (f36872a) {
            if (f36873b == null) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("RequestManager");
                baseHandlerThread.start();
                f36873b = new RequestManager(baseHandlerThread.getLooper());
            }
        }
        return f36873b;
    }

    public static void removeReqByTransId(final String str) {
        if (f36874c == null) {
            return;
        }
        HMSLog.i("RequestManager", "removeReqByTransId");
        f36874c.post(new Runnable() { // from class: com.huawei.hms.common.internal.RequestManager.2
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.f36876e.remove(str);
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        HMSLog.i("RequestManager", "RequestManager handleMessage.");
        switch (message.what) {
            case 10011:
                b();
                return true;
            case 10012:
                a(message);
                return true;
            case 10013:
                c();
                return true;
            default:
                HMSLog.i("RequestManager", "handleMessage unknown msg:" + message.what);
                return false;
        }
    }

    private void a(Message message) {
        HMSLog.i("RequestManager", "NOTIFY_CONNECT_FAILED.");
        try {
            BaseHmsClient.ConnectionResultWrapper connectionResultWrapper = (BaseHmsClient.ConnectionResultWrapper) message.obj;
            HuaweiApi.RequestHandler request = connectionResultWrapper.getRequest();
            f36875d.remove(request);
            request.onConnectionFailed(connectionResultWrapper.getConnectionResult());
        } catch (RuntimeException e16) {
            HMSLog.e("RequestManager", "<handleConnectFailed> handle Failed" + e16.getMessage());
        }
    }
}
