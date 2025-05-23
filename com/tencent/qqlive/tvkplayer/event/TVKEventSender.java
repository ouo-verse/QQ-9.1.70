package com.tencent.qqlive.tvkplayer.event;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKEventSender {
    private final ConcurrentLinkedQueue<ITVKEventObserver> mRegisteredObserverQueue = new ConcurrentLinkedQueue<>();

    public synchronized void registerObserver(ITVKEventObserver iTVKEventObserver) {
        if (iTVKEventObserver != null) {
            if (!this.mRegisteredObserverQueue.contains(iTVKEventObserver)) {
                this.mRegisteredObserverQueue.add(iTVKEventObserver);
            }
        }
    }

    public void sendEvent(int i3, int i16, int i17, String str, Object obj) {
        Iterator<ITVKEventObserver> it = this.mRegisteredObserverQueue.iterator();
        while (it.hasNext()) {
            it.next().onEvent(i3, i16, i17, str, obj);
        }
    }

    public synchronized void unregisterObserver(ITVKEventObserver iTVKEventObserver) {
        this.mRegisteredObserverQueue.remove(iTVKEventObserver);
    }
}
