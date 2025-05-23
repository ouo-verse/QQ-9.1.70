package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.b;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c<Listener extends b<Event>, Event> {

    /* renamed from: a, reason: collision with root package name */
    private final WeakHashMap<Object, ListenerMgr<Listener>> f304097a = new WeakHashMap<>();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements ListenerMgr.a<Listener> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f304098a;

        a(Object obj) {
            this.f304098a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNotify(Listener listener) {
            if (listener != 0) {
                listener.onEvent(this.f304098a);
            }
        }
    }

    public void a(Object obj, Event event) {
        if (obj != null && event != null) {
            synchronized (this.f304097a) {
                ListenerMgr<Listener> listenerMgr = this.f304097a.get(obj);
                if (listenerMgr != null) {
                    listenerMgr.b(new a(event));
                }
            }
        }
    }

    public void b(Object obj, Listener listener) {
        if (obj != null && listener != null) {
            synchronized (this.f304097a) {
                ListenerMgr<Listener> listenerMgr = this.f304097a.get(obj);
                if (listenerMgr != null) {
                    listenerMgr.a(listener);
                } else {
                    ListenerMgr<Listener> listenerMgr2 = new ListenerMgr<>();
                    listenerMgr2.a(listener);
                    this.f304097a.put(obj, listenerMgr2);
                }
            }
        }
    }

    public void c(Object obj, Listener listener) {
        if (obj != null && listener != null) {
            synchronized (this.f304097a) {
                ListenerMgr<Listener> listenerMgr = this.f304097a.get(obj);
                if (listenerMgr != null) {
                    listenerMgr.c(listener);
                }
            }
        }
    }
}
