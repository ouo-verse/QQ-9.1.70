package com.tencent.component.utils.notification;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@Deprecated
/* loaded from: classes5.dex */
public class NotificationCenter {
    private static final String TAG = "NotificationCenter";
    private Map subscribersByTopic = new HashMap();
    private Map subscribersByClass = new HashMap();
    private final Object listenerLock = new Object();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class CenterInstance {
        private static NotificationCenter _instanceCenter = new NotificationCenter();

        CenterInstance() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class PublishRunnable implements Runnable {
        Object theEvent;
        Object theEventObject;
        List theSubscribers;
        String theTopic;

        public PublishRunnable(Object obj, String str, Object obj2, List list) {
            this.theEvent = obj;
            this.theTopic = str;
            this.theEventObject = obj2;
            this.theSubscribers = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            NotificationCenter.this.publish(this.theEvent, this.theTopic, this.theEventObject, this.theSubscribers);
        }
    }

    NotificationCenter() {
    }

    private List createCopyOfContentsRemoveWeakRefs(Collection collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof ProxySubscriber) {
                ProxySubscriber proxySubscriber = (ProxySubscriber) next;
                if (proxySubscriber.getProxiedSubscriber() == null) {
                    removeProxySubscriber(proxySubscriber, it);
                } else {
                    arrayList.add(proxySubscriber);
                }
            } else if (next instanceof WeakReference) {
                Object obj = ((WeakReference) next).get();
                if (obj == null) {
                    it.remove();
                } else {
                    arrayList.add(obj);
                }
            } else {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static NotificationCenter defaultCenter() {
        return CenterInstance._instanceCenter;
    }

    private boolean removeFromSetResolveWeakReferences(Map map, Object obj, Object obj2) {
        List list = (List) map.get(obj);
        if (list == null) {
            return false;
        }
        if (list.remove(obj2)) {
            boolean z16 = obj2 instanceof WeakReference;
            if (obj2 instanceof ProxySubscriber) {
                ((ProxySubscriber) obj2).proxyUnsubscribed();
            }
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof ProxySubscriber) {
                ProxySubscriber proxySubscriber = (ProxySubscriber) next;
                Object proxiedSubscriber = proxySubscriber.getProxiedSubscriber();
                if (proxiedSubscriber == obj2) {
                    removeProxySubscriber(proxySubscriber, it);
                    return true;
                }
                next = proxiedSubscriber;
            }
            if (next instanceof WeakReference) {
                Object obj3 = ((WeakReference) next).get();
                if (obj3 == null) {
                    it.remove();
                    return true;
                }
                if (obj3 == obj2) {
                    it.remove();
                    return true;
                }
                if (obj3 instanceof ProxySubscriber) {
                    ProxySubscriber proxySubscriber2 = (ProxySubscriber) obj3;
                    if (proxySubscriber2.getProxiedSubscriber() == obj2) {
                        removeProxySubscriber(proxySubscriber2, it);
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    private void unsubscribeAllInMap(Map map) {
        synchronized (this.listenerLock) {
            for (Object obj : map.keySet()) {
                List list = (List) map.get(obj);
                while (!list.isEmpty()) {
                    unsubscribe(obj, map, list.get(0));
                }
            }
        }
    }

    public void clearAllSubscribers() {
        synchronized (this.listenerLock) {
            unsubscribeAllInMap(this.subscribersByTopic);
            unsubscribeAllInMap(this.subscribersByClass);
        }
    }

    protected Object getRealSubscriberAndCleanStaleSubscriberIfNecessary(Iterator it, Object obj) {
        if ((obj instanceof WeakReference) && (obj = ((WeakReference) obj).get()) == null) {
            it.remove();
        }
        if (obj instanceof ProxySubscriber) {
            return ((ProxySubscriber) obj).getProxiedSubscriber();
        }
        return obj;
    }

    public <T> List<T> getSubscribers(Class<T> cls) {
        List<T> subscribersToClass;
        synchronized (this.listenerLock) {
            subscribersToClass = getSubscribersToClass(cls);
        }
        return subscribersToClass;
    }

    public <T> List<T> getSubscribersToClass(Class<T> cls) {
        Map map = this.subscribersByClass;
        ArrayList arrayList = null;
        for (Class cls2 : map.keySet()) {
            if (cls2.isAssignableFrom(cls)) {
                Collection collection = (Collection) map.get(cls2);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(createCopyOfContentsRemoveWeakRefs(collection));
            }
        }
        return arrayList;
    }

    public <T> List<T> getSubscribersToTopic(String str) {
        List<T> subscribers;
        synchronized (this.listenerLock) {
            subscribers = getSubscribers(str, this.subscribersByTopic);
        }
        return subscribers;
    }

    public void publish(Object obj) {
        if (obj != null) {
            this.mHandler.post(new PublishRunnable(obj, null, null, getSubscribers(obj.getClass())));
            return;
        }
        throw new IllegalArgumentException("Cannot publish null event.");
    }

    protected void removeProxySubscriber(ProxySubscriber proxySubscriber, Iterator it) {
        it.remove();
        proxySubscriber.proxyUnsubscribed();
    }

    protected boolean subscribe(Object obj, Map<Object, Object> map, Object obj2) {
        Object obj3;
        boolean z16;
        boolean z17;
        if (obj != null) {
            if (obj2 != null) {
                boolean z18 = obj2 instanceof WeakReference;
                if (z18) {
                    obj3 = ((WeakReference) obj2).get();
                } else {
                    obj3 = obj2;
                }
                boolean z19 = true;
                if (obj2 instanceof ProxySubscriber) {
                    ProxySubscriber proxySubscriber = (ProxySubscriber) obj2;
                    if (proxySubscriber.getReferenceStrength() == ReferenceStrength.WEAK) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        obj3 = proxySubscriber.getProxiedSubscriber();
                    }
                } else {
                    z16 = false;
                }
                if (z18 && z16) {
                    throw new IllegalArgumentException("ProxySubscribers should always be subscribed strongly.");
                }
                if (obj3 == null) {
                    return false;
                }
                synchronized (this.listenerLock) {
                    List list = (List) map.get(obj);
                    if (list == null) {
                        list = new ArrayList();
                        map.put(obj, list);
                        z17 = false;
                    } else {
                        Iterator it = list.iterator();
                        z17 = false;
                        while (it.hasNext()) {
                            if (obj3.equals(getRealSubscriberAndCleanStaleSubscriberIfNecessary(it, it.next()))) {
                                it.remove();
                                z17 = true;
                            }
                        }
                    }
                    list.add(obj3);
                    if (z17) {
                        z19 = false;
                    }
                }
                return z19;
            }
            throw new IllegalArgumentException("Can't subscribe null subscriber to " + obj);
        }
        throw new IllegalArgumentException("Can't subscribe to null.");
    }

    public boolean subscribeStrongly(Class cls, Subscriber subscriber) {
        if (subscriber != null) {
            return subscribe(cls, this.subscribersByClass, subscriber);
        }
        throw new IllegalArgumentException("Subscriber cannot be null.");
    }

    public boolean subscriber(Class cls, Subscriber subscriber) {
        if (cls == null) {
            throw new IllegalArgumentException("Event class must not be null");
        }
        if (subscriber != null) {
            return subscribe(cls, this.subscribersByClass, new WeakReference(subscriber));
        }
        throw new IllegalArgumentException("Event subscriber must not be null");
    }

    protected boolean unsubscribe(Object obj, Map map, Object obj2) {
        boolean removeFromSetResolveWeakReferences;
        if (obj == null) {
            throw new IllegalArgumentException("Can't unsubscribe to null.");
        }
        if (obj2 != null) {
            synchronized (this.listenerLock) {
                removeFromSetResolveWeakReferences = removeFromSetResolveWeakReferences(map, obj, obj2);
            }
            return removeFromSetResolveWeakReferences;
        }
        throw new IllegalArgumentException("Can't unsubscribe null subscriber to " + obj);
    }

    public void publish(String str, Object obj) {
        this.mHandler.post(new PublishRunnable(null, str, obj, getSubscribersToTopic(str)));
    }

    private List getSubscribers(Object obj, Map map) {
        return createCopyOfContentsRemoveWeakRefs((List) map.get(obj));
    }

    protected void publish(Object obj, String str, Object obj2, List list) {
        if (obj == null && str == null) {
            throw new IllegalArgumentException("Can't publish to null topic/event.");
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            Object obj3 = list.get(i3);
            if (obj != null) {
                Subscriber subscriber = (Subscriber) obj3;
                System.currentTimeMillis();
                try {
                    subscriber.onEvent(obj);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            } else {
                try {
                    ((TopicSubscriber) obj3).onEvent(str, obj2);
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
        }
    }

    public boolean subscriber(String str, TopicSubscriber topicSubscriber) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Topic must not be null or empty");
        }
        if (topicSubscriber != null) {
            return subscribe(str, this.subscribersByTopic, new WeakReference(topicSubscriber));
        }
        throw new IllegalArgumentException("Event subscriber must not be null");
    }

    public boolean unsubscribe(Class cls, Subscriber subscriber) {
        return unsubscribe(cls, this.subscribersByClass, subscriber);
    }

    public boolean unsubscribe(String str, TopicSubscriber topicSubscriber) {
        return unsubscribe(str, this.subscribersByTopic, topicSubscriber);
    }
}
