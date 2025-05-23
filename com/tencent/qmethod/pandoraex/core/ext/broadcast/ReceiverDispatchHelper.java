package com.tencent.qmethod.pandoraex.core.ext.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qmethod.pandoraex.core.ext.netcap.k;
import com.tencent.qmethod.pandoraex.core.h;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.core.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import wr3.a;
import wr3.b;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReceiverDispatchHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, ConcurrentHashMap<a<BroadcastReceiver>, Handler>> f344037a;

    /* renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList<a<BroadcastReceiver>> f344038b;

    /* renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, BroadcastReceiver> f344039c;

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f344040d;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f344041e;

    /* renamed from: f, reason: collision with root package name */
    private static final Object f344042f;

    /* renamed from: g, reason: collision with root package name */
    private static b f344043g;

    /* renamed from: h, reason: collision with root package name */
    private static final Handler f344044h;

    /* renamed from: i, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Long> f344045i;

    /* renamed from: j, reason: collision with root package name */
    private static final ArrayList<Class<? extends BroadcastReceiver>> f344046j;

    /* renamed from: k, reason: collision with root package name */
    private static long f344047k;

    /* renamed from: l, reason: collision with root package name */
    private static final Runnable f344048l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class MonitorProxyReceiver extends BroadcastReceiver {
        MonitorProxyReceiver() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void a(final Context context, final Intent intent, Map<a<BroadcastReceiver>, Handler> map) {
            final BroadcastReceiver broadcastReceiver;
            for (Map.Entry entry : new HashSet(map.entrySet())) {
                if (entry != null && (broadcastReceiver = (BroadcastReceiver) ((a) entry.getKey()).get()) != null) {
                    synchronized (ReceiverDispatchHelper.f344042f) {
                        if (!ReceiverDispatchHelper.f344046j.isEmpty() && ReceiverDispatchHelper.f344046j.contains(broadcastReceiver.getClass())) {
                            o.a("ReceiverDispatchHelper", "Hit BlackList=" + broadcastReceiver);
                        } else {
                            o.a("ReceiverDispatchHelper", "Dispatch to:" + broadcastReceiver);
                            Handler handler = (Handler) entry.getValue();
                            if (handler != null && ReceiverDispatchHelper.f344044h != handler) {
                                handler.post(new Runnable() { // from class: com.tencent.qmethod.pandoraex.core.ext.broadcast.ReceiverDispatchHelper.MonitorProxyReceiver.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        k.f(intent);
                                        broadcastReceiver.onReceive(context, intent);
                                    }
                                });
                            } else {
                                o.a("ReceiverDispatchHelper", "execute at receiver thread");
                                k.f(intent);
                                broadcastReceiver.onReceive(context, intent);
                            }
                        }
                    }
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Map<a<BroadcastReceiver>, Handler> map;
            String action = intent.getAction();
            if (action != null && (map = (Map) ReceiverDispatchHelper.f344037a.get(action)) != null) {
                synchronized (ReceiverDispatchHelper.f344041e) {
                    a(context, intent, map);
                }
            }
        }
    }

    static {
        HashMap<String, ConcurrentHashMap<a<BroadcastReceiver>, Handler>> hashMap = new HashMap<>();
        f344037a = hashMap;
        f344038b = new CopyOnWriteArrayList<>();
        f344039c = new ConcurrentHashMap<>(16);
        f344040d = new AtomicBoolean(false);
        hashMap.put("android.intent.action.PACKAGE_ADDED", new ConcurrentHashMap<>());
        hashMap.put("android.intent.action.PACKAGE_INSTALL", new ConcurrentHashMap<>());
        hashMap.put("android.intent.action.PACKAGE_REMOVED", new ConcurrentHashMap<>());
        hashMap.put("android.intent.action.PACKAGE_REPLACED", new ConcurrentHashMap<>());
        f344041e = new Object();
        f344042f = new Object();
        f344043g = null;
        f344044h = new Handler(Looper.getMainLooper());
        f344045i = new ConcurrentHashMap<>();
        f344046j = new ArrayList<>();
        f344047k = 0L;
        f344048l = new Runnable() { // from class: com.tencent.qmethod.pandoraex.core.ext.broadcast.ReceiverDispatchHelper.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ReceiverDispatchHelper.f344041e) {
                    Iterator it = ReceiverDispatchHelper.f344037a.keySet().iterator();
                    while (it.hasNext()) {
                        ReceiverDispatchHelper.r((String) it.next());
                    }
                }
            }
        };
    }

    private static IntentFilter j(IntentFilter intentFilter) {
        Parcel obtain = Parcel.obtain();
        obtain.writeParcelable(intentFilter, 1);
        obtain.setDataPosition(0);
        IntentFilter intentFilter2 = (IntentFilter) obtain.readParcelable(intentFilter.getClass().getClassLoader());
        obtain.recycle();
        return intentFilter2;
    }

    private static void k() {
        b bVar = f344043g;
        if (bVar != null && bVar.b("func_receiver_monitor", f344037a)) {
            try {
                x.j(new Runnable() { // from class: com.tencent.qmethod.pandoraex.core.ext.broadcast.ReceiverDispatchHelper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!ReceiverDispatchHelper.f344040d.get()) {
                            synchronized (ReceiverDispatchHelper.f344041e) {
                                ReceiverDispatchHelper.f344043g.a("func_receiver_monitor", ReceiverDispatchHelper.f344037a, ReceiverDispatchHelper.f344045i);
                            }
                        }
                    }
                }, 1000L);
            } catch (Throwable th5) {
                o.d("ReceiverDispatchHelper", "report execute fail!", th5);
            }
        }
    }

    private static IntentFilter l(String str) {
        IntentFilter intentFilter = new IntentFilter(str);
        intentFilter.addDataScheme("package");
        return intentFilter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void m() {
        boolean z16;
        AtomicBoolean atomicBoolean = f344040d;
        if (atomicBoolean.get()) {
            synchronized (f344041e) {
                atomicBoolean.set(false);
                for (Map.Entry<String, ConcurrentHashMap<a<BroadcastReceiver>, Handler>> entry : f344037a.entrySet()) {
                    Iterator it = new HashSet(entry.getValue().keySet()).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            BroadcastReceiver broadcastReceiver = (BroadcastReceiver) ((a) it.next()).get();
                            if (broadcastReceiver != null && f344045i.containsKey(broadcastReceiver.getClass().getName())) {
                                o.a("ReceiverDispatchHelper", broadcastReceiver.getClass().getName() + " find in whiteList");
                                z16 = false;
                                break;
                            }
                        } else {
                            z16 = true;
                            break;
                        }
                    }
                    if (z16) {
                        r(entry.getKey());
                    }
                }
                if (f344047k > 0) {
                    h.a().postDelayed(f344048l, f344047k);
                }
                k();
            }
        }
    }

    public static void n() {
        AtomicBoolean atomicBoolean = f344040d;
        if (atomicBoolean.get()) {
            return;
        }
        h.a().removeCallbacks(f344048l);
        synchronized (f344041e) {
            atomicBoolean.set(true);
            for (Map.Entry<String, ConcurrentHashMap<a<BroadcastReceiver>, Handler>> entry : f344037a.entrySet()) {
                if (!entry.getValue().isEmpty()) {
                    o(entry.getKey());
                }
            }
        }
    }

    private static void o(String str) {
        if (!q.a().d()) {
            o.a("ReceiverDispatchHelper", "isAppOnForeground false" + str);
            return;
        }
        ConcurrentHashMap<String, BroadcastReceiver> concurrentHashMap = f344039c;
        if (concurrentHashMap.containsKey(str)) {
            o.a("ReceiverDispatchHelper", "already register proxy" + str);
            return;
        }
        MonitorProxyReceiver monitorProxyReceiver = new MonitorProxyReceiver();
        concurrentHashMap.put(str, monitorProxyReceiver);
        q.b().registerReceiver(monitorProxyReceiver, l(str));
        o.a("ReceiverDispatchHelper", "register proxy:" + str);
    }

    public static IntentFilter p(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Handler handler) {
        Handler handler2;
        if (q.b() != null && f344043g != null && intentFilter != null && broadcastReceiver != null) {
            IntentFilter j3 = j(intentFilter);
            if (j3 == null) {
                return intentFilter;
            }
            Iterator<String> actionsIterator = j3.actionsIterator();
            if (actionsIterator == null) {
                return intentFilter;
            }
            boolean z16 = false;
            while (actionsIterator.hasNext()) {
                String next = actionsIterator.next();
                HashMap<String, ConcurrentHashMap<a<BroadcastReceiver>, Handler>> hashMap = f344037a;
                if (hashMap.containsKey(next)) {
                    o.e("ReceiverDispatchHelper", "removeMonitorFilter " + next + ", " + broadcastReceiver.getClass().getName());
                    synchronized (f344041e) {
                        ConcurrentHashMap<a<BroadcastReceiver>, Handler> concurrentHashMap = hashMap.get(next);
                        a<BroadcastReceiver> aVar = new a<>(broadcastReceiver);
                        if (handler == null) {
                            handler2 = f344044h;
                        } else {
                            handler2 = handler;
                        }
                        concurrentHashMap.put(aVar, handler2);
                        o(next);
                    }
                    actionsIterator.remove();
                    z16 = true;
                }
            }
            if (z16 && j3.countActions() == 0) {
                f344038b.add(new a<>(broadcastReceiver));
            }
            if (z16) {
                return j3;
            }
            return intentFilter;
        }
        return intentFilter;
    }

    public static void q(b bVar) {
        f344043g = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(String str) {
        ConcurrentHashMap<String, BroadcastReceiver> concurrentHashMap = f344039c;
        if (!concurrentHashMap.containsKey(str)) {
            o.a("ReceiverDispatchHelper", "already unRegister proxy:" + str);
            return;
        }
        BroadcastReceiver remove = concurrentHashMap.remove(str);
        if (remove != null) {
            q.b().unregisterReceiver(remove);
        }
        o.a("ReceiverDispatchHelper", "unRegister proxy:" + str);
    }

    public static boolean s(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return true;
        }
        synchronized (f344041e) {
            for (Map.Entry<String, ConcurrentHashMap<a<BroadcastReceiver>, Handler>> entry : f344037a.entrySet()) {
                if (entry.getValue().remove(new a(broadcastReceiver)) != null) {
                    o.a("ReceiverDispatchHelper", "Remove receiver:" + broadcastReceiver.getClass());
                }
                if (entry.getValue().isEmpty()) {
                    r(entry.getKey());
                }
            }
            if (!f344038b.remove(new a(broadcastReceiver))) {
                return true;
            }
            return false;
        }
    }
}
