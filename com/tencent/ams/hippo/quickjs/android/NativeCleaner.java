package com.tencent.ams.hippo.quickjs.android;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
abstract class NativeCleaner<T> {
    static IPatchRedirector $redirector_;
    private final Set<NativeReference<T>> phantomReferences;
    private final ReferenceQueue<T> referenceQueue;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class NativeReference<T> extends PhantomReference<T> {
        static IPatchRedirector $redirector_;
        private final long pointer;

        /* synthetic */ NativeReference(Object obj, long j3, ReferenceQueue referenceQueue, AnonymousClass1 anonymousClass1) {
            this(obj, j3, referenceQueue);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, obj, Long.valueOf(j3), referenceQueue, anonymousClass1);
        }

        NativeReference(T t16, long j3, ReferenceQueue<? super T> referenceQueue) {
            super(t16, referenceQueue);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.pointer = j3;
            } else {
                iPatchRedirector.redirect((short) 1, this, t16, Long.valueOf(j3), referenceQueue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeCleaner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.phantomReferences = new HashSet();
            this.referenceQueue = new ReferenceQueue<>();
        }
    }

    public void clean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        while (true) {
            NativeReference nativeReference = (NativeReference) this.referenceQueue.poll();
            if (nativeReference != null) {
                if (this.phantomReferences.contains(nativeReference)) {
                    onRemove(nativeReference.pointer);
                    this.phantomReferences.remove(nativeReference);
                }
            } else {
                return;
            }
        }
    }

    public void forceClean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Iterator<NativeReference<T>> it = this.phantomReferences.iterator();
        while (it.hasNext()) {
            onRemove(((NativeReference) it.next()).pointer);
        }
        this.phantomReferences.clear();
    }

    public abstract void onRemove(long j3);

    public void register(T t16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, t16, Long.valueOf(j3));
        } else {
            this.phantomReferences.add(new NativeReference<>(t16, j3, this.referenceQueue, null));
        }
    }

    public int size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.phantomReferences.size();
    }
}
