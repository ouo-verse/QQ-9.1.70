package com.tencent.qimei.ab;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Queue<Integer> a(int i3, int i16) {
        PriorityQueue priorityQueue = new PriorityQueue();
        Random random = new Random(d.class.hashCode());
        for (int i17 = 0; i17 < i3; i17++) {
            priorityQueue.offer(Integer.valueOf(random.nextInt(5) + i16));
        }
        return priorityQueue;
    }

    public static boolean a(long j3, long j16) {
        return j3 == 0 || System.currentTimeMillis() - j3 >= ((j16 * 60) * 60) * 1000;
    }

    public static boolean a(long j3, long j16, TimeUnit timeUnit) {
        return j3 == 0 || System.currentTimeMillis() - j3 >= timeUnit.toMillis(j16);
    }
}
