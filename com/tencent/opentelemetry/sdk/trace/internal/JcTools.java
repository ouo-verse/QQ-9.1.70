package com.tencent.opentelemetry.sdk.trace.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JcTools {
    static IPatchRedirector $redirector_;

    JcTools() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static long capacity(Queue<?> queue) {
        return ((ArrayBlockingQueue) queue).remainingCapacity() + queue.size();
    }

    public static <T> Queue<T> newFixedSizeQueue(int i3) {
        return new ArrayBlockingQueue(i3);
    }
}
