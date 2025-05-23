package com.tencent.mobileqq.vas;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasManager<V> implements Manager {
    private final ArrayList<ListenerHolder<V>> mListenerHolderList = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface CompleteListener<E> {
        void onComplete(E e16, Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class ListenerHolder<E> {
        public CompleteListener<E> listener;
        public Object params;
        public String scid;

        public ListenerHolder(CompleteListener<E> completeListener, Object obj, String str) {
            this.listener = completeListener;
            this.params = obj;
            this.scid = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class WeakListener<E> extends WeakReference<CompleteListener<E>> implements CompleteListener<E> {
        public WeakListener(CompleteListener<E> completeListener) {
            super(completeListener);
        }

        @Override // com.tencent.mobileqq.vas.VasManager.CompleteListener
        public void onComplete(E e16, Object obj) {
            CompleteListener<E> completeListener = get();
            if (completeListener != null) {
                completeListener.onComplete(e16, obj);
            }
        }
    }

    public static <E> CompleteListener<E> weakWrap(CompleteListener<E> completeListener) {
        return new WeakListener(completeListener);
    }

    public void complete(String str, V v3) {
        if (str == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.mListenerHolderList) {
            for (int size = this.mListenerHolderList.size() - 1; size >= 0; size--) {
                ListenerHolder<V> listenerHolder = this.mListenerHolderList.get(size);
                if (str.equals(listenerHolder.scid)) {
                    this.mListenerHolderList.remove(size);
                    arrayList.add(listenerHolder);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ListenerHolder listenerHolder2 = (ListenerHolder) it.next();
            listenerHolder2.listener.onComplete(v3, listenerHolder2.params);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        synchronized (this.mListenerHolderList) {
            this.mListenerHolderList.clear();
        }
    }

    public void registerListener(String str, CompleteListener<V> completeListener, Object obj) {
        if (completeListener != null) {
            ListenerHolder<V> listenerHolder = new ListenerHolder<>(completeListener, obj, str);
            synchronized (this.mListenerHolderList) {
                this.mListenerHolderList.add(listenerHolder);
            }
        }
    }
}
