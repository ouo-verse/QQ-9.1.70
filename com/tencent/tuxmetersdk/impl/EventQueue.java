package com.tencent.tuxmetersdk.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.impl.event.TuxEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: P */
/* loaded from: classes27.dex */
public class EventQueue {
    static IPatchRedirector $redirector_;
    private final int max;
    private final Queue<TuxEvent> queue;

    public EventQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.max = 500;
            this.queue = new ArrayBlockingQueue(500);
        }
    }

    public void add(TuxEvent tuxEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tuxEvent);
        } else {
            while (!this.queue.offer(tuxEvent)) {
                this.queue.poll();
            }
        }
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.queue.clear();
        }
    }

    public List<TuxEvent> get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TuxEvent> it = this.queue.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        Collections.sort(arrayList, new Comparator<TuxEvent>() { // from class: com.tencent.tuxmetersdk.impl.EventQueue.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EventQueue.this);
                }
            }

            @Override // java.util.Comparator
            public int compare(TuxEvent tuxEvent, TuxEvent tuxEvent2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? tuxEvent.getEventTime().before(tuxEvent2.getEventTime()) ? -1 : 1 : ((Integer) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) tuxEvent, (Object) tuxEvent2)).intValue();
            }
        });
        return arrayList;
    }

    public int size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.queue.size();
    }
}
