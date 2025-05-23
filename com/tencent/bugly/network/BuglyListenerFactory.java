package com.tencent.bugly.network;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import okhttp3.Call;
import okhttp3.EventListener;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BuglyListenerFactory implements EventListener.Factory, ICallEnd {
    private static final String TAG = "RMonitor_net_quality";
    private static BuglyListenerFactory instance;
    private CopyOnWriteArraySet<EventListener.Factory> factorySet = new CopyOnWriteArraySet<>();

    public static BuglyListenerFactory getInstance() {
        if (instance == null) {
            synchronized (NetEventListenerProxy.class) {
                if (instance == null) {
                    instance = new BuglyListenerFactory();
                }
            }
        }
        return instance;
    }

    public void addFactory(EventListener.Factory factory) {
        if (factory == null) {
            return;
        }
        this.factorySet.add(factory);
    }

    @Override // okhttp3.EventListener.Factory
    public EventListener create(Call call) {
        NetEventListenerProxy netEventListenerProxy = new NetEventListenerProxy();
        Iterator<EventListener.Factory> it = this.factorySet.iterator();
        while (it.hasNext()) {
            EventListener create = it.next().create(call);
            if (create != null) {
                netEventListenerProxy.addEventListener(create);
            }
        }
        return netEventListenerProxy;
    }

    @Override // com.tencent.bugly.network.ICallEnd
    public void onCallEnd(Call call, boolean z16, IOException iOException) {
        Iterator<EventListener.Factory> it = this.factorySet.iterator();
        while (it.hasNext()) {
            EventListener.Factory next = it.next();
            if (next instanceof ICallEnd) {
                ((ICallEnd) next).onCallEnd(call, z16, iOException);
            }
        }
    }

    public void removeFactory(EventListener.Factory factory) {
        if (factory == null) {
            return;
        }
        this.factorySet.remove(factory);
    }
}
