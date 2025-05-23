package com.tencent.component.network.module.common.dns;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AtomicRequestId {
    private static final int initValue = 100;
    private static final int maxValue = 65535;
    private static AtomicRequestId reqId;
    private static AtomicInteger reqIdentity = new AtomicInteger(100);

    public static synchronized AtomicRequestId getInstance() {
        AtomicRequestId atomicRequestId;
        synchronized (AtomicRequestId.class) {
            if (reqId == null) {
                reqId = new AtomicRequestId();
            }
            atomicRequestId = reqId;
        }
        return atomicRequestId;
    }

    public synchronized int getId() {
        int andIncrement;
        andIncrement = reqIdentity.getAndIncrement();
        if (andIncrement >= 65535) {
            AtomicInteger atomicInteger = new AtomicInteger(100);
            reqIdentity = atomicInteger;
            andIncrement = atomicInteger.getAndIncrement();
        }
        return andIncrement;
    }
}
