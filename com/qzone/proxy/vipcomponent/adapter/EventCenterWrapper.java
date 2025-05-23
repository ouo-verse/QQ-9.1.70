package com.qzone.proxy.vipcomponent.adapter;

import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.EventSource;
import com.qzone.common.event.IObserver;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class EventCenterWrapper {

    /* renamed from: a, reason: collision with root package name */
    static final Map<VipObserver, ObserverWrapper> f50998a = new HashMap();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class EventSourceWrapper {

        /* renamed from: a, reason: collision with root package name */
        EventSource f50999a;

        EventSourceWrapper(EventSource eventSource) {
            this.f50999a = eventSource;
        }

        public static EventSourceWrapper wrap(EventSource eventSource) {
            return new EventSourceWrapper(eventSource);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class ObserverWrapper implements IObserver.main, IObserver.background, IObserver.async, IObserver.post {

        /* renamed from: d, reason: collision with root package name */
        VipObserver f51000d;

        ObserverWrapper() {
        }

        @Override // com.qzone.common.event.IObserver.async
        public void onEventAsync(Event event) {
            this.f51000d.onEventAsync(event.what, event.source.getName(), event.params);
        }

        @Override // com.qzone.common.event.IObserver.background
        public void onEventBackgroundThread(Event event) {
            this.f51000d.onEventBackgroundThread(event.what, event.source.getName(), event.params);
        }

        @Override // com.qzone.common.event.IObserver.post
        public void onEventPostThread(Event event) {
            this.f51000d.onEventPostThread(event.what, event.source.getName(), event.params);
        }

        @Override // com.qzone.common.event.IObserver.main
        public void onEventUIThread(Event event) {
            this.f51000d.onEventMainThread(event.what, event.source.getName(), event.params);
        }
    }

    public static void addUIObserver(VipObserver vipObserver, String str, int... iArr) {
        Map<VipObserver, ObserverWrapper> map = f50998a;
        ObserverWrapper observerWrapper = map.get(vipObserver);
        if (observerWrapper == null) {
            observerWrapper = new ObserverWrapper();
            observerWrapper.f51000d = vipObserver;
            map.put(vipObserver, observerWrapper);
        }
        EventCenter.getInstance().addUIObserver(observerWrapper, str, iArr);
    }

    public static void post(EventSourceWrapper eventSourceWrapper, int i3, Object obj) {
        EventCenter.getInstance().post(eventSourceWrapper.f50999a, i3, obj);
    }

    public static void removeObserver(VipObserver vipObserver) {
        ObserverWrapper remove = f50998a.remove(vipObserver);
        if (remove != null) {
            EventCenter.getInstance().removeObserver(remove);
        }
    }
}
