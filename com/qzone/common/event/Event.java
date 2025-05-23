package com.qzone.common.event;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneEventApi;

/* compiled from: P */
/* loaded from: classes39.dex */
public class Event {
    private static final int MAX_POOL_SIZE = 50;
    private static Event sPool;
    private static int sPoolSize;
    private static final Object sPoolSync = new Object();
    private int mRefrenceTimes = 0;
    Event next;
    public Object params;
    public EventSource source;
    public int what;

    Event() {
    }

    static Event obtain() {
        return new Event();
    }

    public void recycle() {
        int i3 = this.mRefrenceTimes - 1;
        this.mRefrenceTimes = i3;
        if (i3 <= 0) {
            clearForRecycle();
            synchronized (sPoolSync) {
                int i16 = sPoolSize;
                if (i16 < 50) {
                    this.next = sPool;
                    sPool = this;
                    sPoolSize = i16 + 1;
                }
            }
        }
    }

    public void retain() {
        this.mRefrenceTimes++;
    }

    public String toString() {
        return "Event [what=" + this.what + ", source=" + this.source + ", params=" + this.params + "]";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Event obtain(EventSource eventSource, int i3, Object obj) {
        Event obtain = obtain();
        obtain.what = i3;
        obtain.source = eventSource;
        obtain.params = obj;
        obtain.mRefrenceTimes++;
        return obtain;
    }

    void clearForRecycle() {
        this.what = 0;
        this.source = null;
        this.params = null;
        this.mRefrenceTimes = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Event obtain(IQzoneEventApi.ExoticEventInterface exoticEventInterface) {
        Event obtain = obtain();
        obtain.what = exoticEventInterface.getWhat();
        obtain.source = new EventSource(exoticEventInterface.getSourceName(), QRoute.api(IQzoneEventApi.class));
        obtain.params = exoticEventInterface.getParam();
        obtain.mRefrenceTimes++;
        return obtain;
    }
}
