package com.tencent.tmassistantsdk.internal.logreport;

import com.tencent.tmassistantbase.network.INetworkChangedObserver;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.util.GlobalUtil;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    protected static e f380556b;

    /* renamed from: c, reason: collision with root package name */
    private static final Class<?>[] f380557c = {b.class};

    /* renamed from: a, reason: collision with root package name */
    private final INetworkChangedObserver f380558a;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements INetworkChangedObserver {

        /* compiled from: P */
        /* renamed from: com.tencent.tmassistantsdk.internal.logreport.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        class RunnableC9998a implements Runnable {
            RunnableC9998a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (GlobalUtil.isNetworkConncted() && GlobalUtil.getNetStatus().equalsIgnoreCase("wifi")) {
                    e.this.d();
                }
            }
        }

        a() {
        }

        @Override // com.tencent.tmassistantbase.network.INetworkChangedObserver
        public void onNetworkChanged() {
            for (Class cls : e.f380557c) {
                try {
                    if (cls.equals(b.class)) {
                        b.g().f();
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            com.tencent.tmassistantbase.util.e.a().post(new RunnableC9998a());
        }
    }

    e() {
        a aVar = new a();
        this.f380558a = aVar;
        NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(aVar);
        d();
    }

    public static synchronized e c() {
        e eVar;
        synchronized (e.class) {
            if (f380556b == null) {
                f380556b = new e();
            }
            eVar = f380556b;
        }
        return eVar;
    }

    public void b() {
        for (Class<?> cls : f380557c) {
            try {
                if (cls.equals(b.class)) {
                    b.g().b();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        NetworkMonitorReceiver.getInstance().removeNetworkChangedObserver(this.f380558a);
    }

    public void d() {
        for (Class<?> cls : f380557c) {
            try {
                if (cls.equals(b.class)) {
                    b.g().e();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }
}
