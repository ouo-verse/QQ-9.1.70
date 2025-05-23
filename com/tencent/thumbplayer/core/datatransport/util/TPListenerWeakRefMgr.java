package com.tencent.thumbplayer.core.datatransport.util;

import com.tencent.thumbplayer.core.datatransport.util.TPListenerMgr;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes26.dex */
public class TPListenerWeakRefMgr<T> {
    private String mListenerName;
    private final ITPDataTransportLog mLogger = TPDataTransportLogFactory.getInstance().getLogger("TPListenerWeakRefMgr");
    private final ConcurrentHashMap<Integer, WeakReference<T>> mListenerMgr = new ConcurrentHashMap<>();

    /* loaded from: classes26.dex */
    public interface INotifyCallback<T> {
        void onNotify(int i3, T t16);
    }

    public TPListenerWeakRefMgr(String str) {
    }

    public void addTaskListener(int i3, T t16) {
        if (t16 != null && i3 > 0) {
            this.mLogger.i(this.mListenerName + ", taskId:" + i3 + ", add task listener");
            synchronized (this.mListenerMgr) {
                this.mListenerMgr.put(Integer.valueOf(i3), new WeakReference<>(t16));
            }
        }
    }

    public boolean containsListener(int i3) {
        boolean containsKey;
        synchronized (this.mListenerMgr) {
            containsKey = this.mListenerMgr.containsKey(Integer.valueOf(i3));
        }
        return containsKey;
    }

    public void removeTaskListener(int i3) {
        if (i3 <= 0) {
            return;
        }
        synchronized (this.mListenerMgr) {
            if (this.mListenerMgr.remove(Integer.valueOf(i3)) != null) {
                this.mLogger.i(this.mListenerName + "taskId:" + i3 + ", remove task listener");
            }
        }
    }

    public void startNotify(int i3, TPListenerMgr.INotifyCallback<T> iNotifyCallback) {
        if (i3 <= 0) {
            return;
        }
        synchronized (this.mListenerMgr) {
            T t16 = this.mListenerMgr.containsKey(Integer.valueOf(i3)) ? this.mListenerMgr.get(Integer.valueOf(i3)).get() : null;
            if (t16 == null) {
                this.mListenerMgr.remove(Integer.valueOf(i3));
                this.mLogger.e(this.mListenerName + "startNotify taskId:" + i3 + ", listener is null");
                return;
            }
            try {
                iNotifyCallback.onNotify(i3, t16);
            } catch (Throwable th5) {
                this.mLogger.e(this.mListenerName + "startNotify error:" + th5);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startNotify(TPListenerMgr.INotifyCallback<T> iNotifyCallback) {
        ConcurrentHashMap concurrentHashMap;
        synchronized (this.mListenerMgr) {
            concurrentHashMap = this.mListenerMgr.size() > 0 ? new ConcurrentHashMap(this.mListenerMgr) : null;
        }
        if (concurrentHashMap != null) {
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                try {
                    if (((WeakReference) entry.getValue()).get() != null) {
                        iNotifyCallback.onNotify(((Integer) entry.getKey()).intValue(), ((WeakReference) entry.getValue()).get());
                    }
                } catch (Throwable th5) {
                    this.mLogger.e(this.mListenerName + "startNotify all error:" + th5);
                }
            }
        }
    }
}
