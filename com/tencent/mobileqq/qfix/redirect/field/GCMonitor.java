package com.tencent.mobileqq.qfix.redirect.field;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes16.dex */
public class GCMonitor {

    /* renamed from: a, reason: collision with root package name */
    final ReferenceQueue<Object> f261886a = new ReferenceQueue<>();

    /* renamed from: b, reason: collision with root package name */
    final Set<GCReference> f261887b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    volatile boolean f261888c;

    /* renamed from: d, reason: collision with root package name */
    private final GCMonitorListener f261889d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface GCMonitorListener {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class GCReference extends WeakReference<Object> {
        public GCReference(Object obj) {
            super(obj);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof GCReference) || ((GCReference) obj).get() != get()) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            Object obj = get();
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public GCReference(Object obj, ReferenceQueue<? super Object> referenceQueue) {
            super(obj, referenceQueue);
        }
    }

    public GCMonitor(GCMonitorListener gCMonitorListener) {
        this.f261889d = gCMonitorListener;
    }

    static /* synthetic */ void a(GCMonitor gCMonitor) {
        while (true) {
            try {
                Reference<? extends Object> remove = gCMonitor.f261886a.remove();
                synchronized (gCMonitor) {
                    if (remove != null) {
                        gCMonitor.f261887b.remove(remove);
                        LogUtils.a();
                        GCMonitorListener gCMonitorListener = gCMonitor.f261889d;
                        if (gCMonitorListener != null) {
                            gCMonitorListener.a();
                        }
                    }
                }
            } catch (InterruptedException e16) {
                LogUtils.a("Redirect.GCMonitor", "waitAndCheckReference fail.", e16);
            }
        }
    }
}
