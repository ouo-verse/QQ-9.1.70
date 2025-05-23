package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.b0;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class z implements Handler.Callback {

    /* renamed from: c, reason: collision with root package name */
    public static final z f36460c = new z();

    /* renamed from: a, reason: collision with root package name */
    public final Handler f36461a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<w, a> f36462b = new ConcurrentHashMap(5, 0.75f, 1);

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b implements i0 {

        /* renamed from: a, reason: collision with root package name */
        public f1<?> f36469a;

        public b(f1<?> f1Var) {
            this.f36469a = f1Var;
        }
    }

    public z() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("HonorApiManager");
        baseHandlerThread.start();
        this.f36461a = new Handler(baseHandlerThread.getLooper(), this);
    }

    public <TResult> a1<TResult> a(f1<TResult> f1Var) {
        n0<TResult> n0Var = new n0<>();
        f1Var.f36379a = n0Var;
        Log.i("HonorApiManager", "sendRequest start");
        Handler handler = this.f36461a;
        handler.sendMessage(handler.obtainMessage(1, f1Var));
        return n0Var.f36413a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVar;
        int i3 = message.what;
        boolean z16 = false;
        if (i3 == 1) {
            f1<?> f1Var = (f1) message.obj;
            w wVar = f1Var.f36382d;
            a aVar2 = this.f36462b.get(wVar);
            if (aVar2 == null) {
                Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                aVar2 = new a(wVar);
                this.f36462b.put(wVar, aVar2);
            }
            synchronized (aVar2) {
                com.hihonor.push.sdk.b.a(z.this.f36461a);
                if (((d0) aVar2.f36465c).a()) {
                    aVar2.a(f1Var);
                } else {
                    aVar2.f36463a.add(f1Var);
                    HonorPushErrorEnum honorPushErrorEnum = aVar2.f36466d;
                    if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                        aVar2.a(aVar2.f36466d);
                    } else {
                        synchronized (aVar2) {
                            com.hihonor.push.sdk.b.a(z.this.f36461a);
                            if (((d0) aVar2.f36465c).a()) {
                                Log.i("HonorApiManager", "client is connected");
                            } else {
                                if (((d0) aVar2.f36465c).f36364a.get() == 5) {
                                    z16 = true;
                                }
                                if (z16) {
                                    Log.i("HonorApiManager", "client is isConnecting");
                                } else {
                                    d0 d0Var = (d0) aVar2.f36465c;
                                    d0Var.getClass();
                                    Log.i("PushConnectionClient", " ==== PUSHSDK VERSION 70061302 ====");
                                    int i16 = d0Var.f36364a.get();
                                    Log.i("PushConnectionClient", "enter connect, connection Status: " + i16);
                                    if (i16 != 3 && i16 != 5 && i16 != 4) {
                                        l lVar = l.f36402e;
                                        int b16 = com.hihonor.push.sdk.b.b(lVar.a());
                                        if (b16 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                            d0Var.f36364a.set(5);
                                            RemoteServiceBean a16 = com.hihonor.push.sdk.b.a(lVar.a());
                                            Log.i("PushConnectionClient", "enter bindCoreService.");
                                            f0 f0Var = new f0(a16);
                                            d0Var.f36367d = f0Var;
                                            f0Var.f36376b = new c0(d0Var);
                                            if (!a16.checkServiceInfo()) {
                                                Objects.toString(f0Var.f36375a);
                                                f0Var.a(8002004);
                                            } else {
                                                Intent intent = new Intent();
                                                String packageName = f0Var.f36375a.getPackageName();
                                                String packageAction = f0Var.f36375a.getPackageAction();
                                                String packageServiceName = f0Var.f36375a.getPackageServiceName();
                                                if (!TextUtils.isEmpty(packageServiceName)) {
                                                    intent.setComponent(new ComponentName(packageName, packageServiceName));
                                                } else {
                                                    intent.setAction(packageAction);
                                                    intent.setPackage(packageName);
                                                }
                                                synchronized (f0.f36374e) {
                                                    if (lVar.a().bindService(intent, f0Var, 1)) {
                                                        Handler handler = f0Var.f36377c;
                                                        if (handler != null) {
                                                            handler.removeMessages(1001);
                                                        } else {
                                                            f0Var.f36377c = new Handler(Looper.getMainLooper(), new e0(f0Var));
                                                        }
                                                        f0Var.f36377c.sendEmptyMessageDelayed(1001, 10000L);
                                                    } else {
                                                        f0Var.f36378d = true;
                                                        f0Var.a(8002001);
                                                    }
                                                }
                                            }
                                        } else {
                                            d0Var.a(b16);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
        if (i3 != 2) {
            return false;
        }
        f1 f1Var2 = (f1) message.obj;
        w wVar2 = f1Var2.f36382d;
        if (wVar2 != null && this.f36462b.containsKey(wVar2) && (aVar = this.f36462b.get(wVar2)) != null) {
            synchronized (aVar) {
                aVar.f36464b.remove(f1Var2);
                if (aVar.f36463a.peek() == null || aVar.f36464b.peek() == null) {
                    aVar.a();
                    z.this.f36462b.remove(aVar.f36467e);
                }
            }
        }
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements b0.a {

        /* renamed from: a, reason: collision with root package name */
        public final Queue<f1<?>> f36463a = new LinkedList();

        /* renamed from: b, reason: collision with root package name */
        public final Queue<f1<?>> f36464b = new LinkedList();

        /* renamed from: c, reason: collision with root package name */
        public final b0 f36465c = new d0(this);

        /* renamed from: d, reason: collision with root package name */
        public HonorPushErrorEnum f36466d = null;

        /* renamed from: e, reason: collision with root package name */
        public final w f36467e;

        public a(w wVar) {
            this.f36467e = wVar;
        }

        public final synchronized void a(HonorPushErrorEnum honorPushErrorEnum) {
            Log.i("HonorApiManager", "onConnectionFailed");
            com.hihonor.push.sdk.b.a(z.this.f36461a);
            Iterator<f1<?>> it = this.f36463a.iterator();
            while (it.hasNext()) {
                it.next().b(honorPushErrorEnum.toApiException(), null);
            }
            this.f36463a.clear();
            this.f36466d = honorPushErrorEnum;
            a();
            z.this.f36462b.remove(this.f36467e);
        }

        public final synchronized void b() {
            Log.i("HonorApiManager", "onConnected");
            com.hihonor.push.sdk.b.a(z.this.f36461a);
            this.f36466d = null;
            Iterator<f1<?>> it = this.f36463a.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            this.f36463a.clear();
        }

        public final synchronized void a(f1<?> f1Var) {
            Type type;
            this.f36464b.add(f1Var);
            b0 b0Var = this.f36465c;
            b bVar = new b(f1Var);
            f1Var.getClass();
            Object obj = null;
            try {
                Type genericSuperclass = f1Var.getClass().getGenericSuperclass();
                Class cls = (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) == null) ? null : (Class) type;
                if (cls != null && !cls.isPrimitive()) {
                    obj = cls.newInstance();
                }
            } catch (Exception e16) {
                c.a("In newResponseInstance, instancing exception." + e16.getMessage());
            }
            h0 h0Var = new h0(obj, bVar);
            Log.i("IpcTransport", "start transport parse. " + f1Var.f36380b);
            IPushInvoke iPushInvoke = ((d0) b0Var).f36365b;
            String str = f1Var.f36380b;
            RequestHeader requestHeader = f1Var.f36383e;
            IMessageEntity iMessageEntity = f1Var.f36381c;
            Bundle bundle = new Bundle();
            Bundle bundle2 = new Bundle();
            MessageCodec.formMessageEntity(requestHeader, bundle);
            MessageCodec.formMessageEntity(iMessageEntity, bundle2);
            DataBuffer dataBuffer = new DataBuffer(str, bundle, bundle2);
            if (iPushInvoke != null) {
                try {
                    iPushInvoke.call(dataBuffer, h0Var);
                } catch (Exception e17) {
                    e17.toString();
                }
            }
            Log.i("IpcTransport", "end transport parse.");
        }

        public void a() {
            com.hihonor.push.sdk.b.a(z.this.f36461a);
            d0 d0Var = (d0) this.f36465c;
            int i3 = d0Var.f36364a.get();
            Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i3);
            if (i3 != 3) {
                if (i3 != 5) {
                    return;
                }
                d0Var.f36364a.set(4);
            } else {
                f0 f0Var = d0Var.f36367d;
                if (f0Var != null) {
                    f0Var.b();
                }
                d0Var.f36364a.set(1);
            }
        }
    }
}
