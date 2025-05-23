package com.tencent.tav.decoder.decodecache;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes26.dex */
class RequestStatus {
    private volatile AtomicBoolean finish = new AtomicBoolean(false);

    public boolean getFinish() {
        return this.finish.get();
    }

    public void setFinish(boolean z16) {
        this.finish.set(z16);
    }
}
