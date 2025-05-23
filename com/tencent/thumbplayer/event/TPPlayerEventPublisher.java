package com.tencent.thumbplayer.event;

import com.tencent.thumbplayer.event.TPPlayerEventInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes26.dex */
public class TPPlayerEventPublisher {
    private static final String TAG = "TPPlayerEventPublisher";
    private final List<WeakReference<ITPPlayerEventReceiver>> mReceiverList = new ArrayList();

    public synchronized void addEventReceiver(ITPPlayerEventReceiver iTPPlayerEventReceiver) {
        if (iTPPlayerEventReceiver == null) {
            return;
        }
        Iterator<WeakReference<ITPPlayerEventReceiver>> it = this.mReceiverList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == iTPPlayerEventReceiver) {
                return;
            }
        }
        this.mReceiverList.add(new WeakReference<>(iTPPlayerEventReceiver));
    }

    public synchronized void clearEventReceivers() {
        List<WeakReference<ITPPlayerEventReceiver>> list = this.mReceiverList;
        if (list != null) {
            list.clear();
        }
    }

    public synchronized void publishEvent(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        Iterator<WeakReference<ITPPlayerEventReceiver>> it = this.mReceiverList.iterator();
        while (it.hasNext()) {
            ITPPlayerEventReceiver iTPPlayerEventReceiver = it.next().get();
            if (iTPPlayerEventReceiver != null) {
                iTPPlayerEventReceiver.onEvent(baseEventInfo);
            }
        }
    }

    public synchronized void removeEventReceiver(ITPPlayerEventReceiver iTPPlayerEventReceiver) {
        if (iTPPlayerEventReceiver == null) {
            return;
        }
        Iterator<WeakReference<ITPPlayerEventReceiver>> it = this.mReceiverList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == iTPPlayerEventReceiver) {
                it.remove();
            }
        }
    }
}
