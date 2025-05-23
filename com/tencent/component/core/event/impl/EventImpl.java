package com.tencent.component.core.event.impl;

import android.os.Handler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EventImpl {
    static EventImpl gInst = new EventImpl();
    ConcurrentHashMap<Integer, ConcurrentLinkedQueue<OnEvent>> listeners = new ConcurrentHashMap<>();
    Handler recvHandler;

    public static EventImpl getInstance() {
        return gInst;
    }

    ConcurrentLinkedQueue<OnEvent> getQByHashcode(int i3) {
        if (this.listeners.containsKey(Integer.valueOf(i3))) {
            return this.listeners.get(Integer.valueOf(i3));
        }
        return null;
    }

    public void post(Object obj) {
        if (obj != null) {
            post(getQByHashcode(obj.getClass().hashCode()), obj);
            return;
        }
        throw new RuntimeException("post obj is null!");
    }

    public void register(OnEvent onEvent) {
        if (onEvent != null) {
            Type type = onEvent.getClass().getGenericInterfaces()[0];
            if (type instanceof ParameterizedType) {
                int hashCode = ((ParameterizedType) type).getActualTypeArguments()[0].hashCode();
                ConcurrentLinkedQueue<OnEvent> qByHashcode = getQByHashcode(hashCode);
                if (qByHashcode == null) {
                    qByHashcode = new ConcurrentLinkedQueue<>();
                    this.listeners.put(Integer.valueOf(hashCode), qByHashcode);
                }
                if (!qByHashcode.contains(onEvent)) {
                    qByHashcode.add(onEvent);
                    return;
                }
                return;
            }
            return;
        }
        throw new RuntimeException("register event null!");
    }

    public boolean remove(OnEvent onEvent) {
        int hashCode;
        ConcurrentLinkedQueue<OnEvent> qByHashcode;
        if (onEvent != null) {
            Type type = onEvent.getClass().getGenericInterfaces()[0];
            if ((type instanceof ParameterizedType) && (qByHashcode = getQByHashcode((hashCode = ((ParameterizedType) type).getActualTypeArguments()[0].hashCode()))) != null) {
                try {
                    boolean remove = qByHashcode.remove(onEvent);
                    if (qByHashcode.isEmpty()) {
                        this.listeners.remove(Integer.valueOf(hashCode));
                    }
                    return remove;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        throw new RuntimeException("remove event null!");
    }

    public void setRecvHandler(Handler handler) {
        this.recvHandler = handler;
    }

    public void post(final Object obj, Handler handler) {
        if (obj != null) {
            ConcurrentLinkedQueue<OnEvent> qByHashcode = getQByHashcode(obj.getClass().hashCode());
            if (handler != null && qByHashcode != null) {
                Iterator<OnEvent> it = qByHashcode.iterator();
                while (it.hasNext()) {
                    final OnEvent next = it.next();
                    handler.post(new Runnable() { // from class: com.tencent.component.core.event.impl.EventImpl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            next.onRecv(obj);
                        }
                    });
                }
                return;
            }
            post(qByHashcode, obj);
            return;
        }
        throw new RuntimeException("post obj is null!");
    }

    void post(ConcurrentLinkedQueue<OnEvent> concurrentLinkedQueue, final Object obj) {
        if (concurrentLinkedQueue == null || this.recvHandler == null) {
            return;
        }
        Iterator<OnEvent> it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            final OnEvent next = it.next();
            this.recvHandler.post(new Runnable() { // from class: com.tencent.component.core.event.impl.EventImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    next.onRecv(obj);
                }
            });
        }
    }
}
