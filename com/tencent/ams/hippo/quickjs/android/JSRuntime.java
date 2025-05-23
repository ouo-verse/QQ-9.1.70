package com.tencent.ams.hippo.quickjs.android;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Closeable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class JSRuntime implements Closeable {
    static IPatchRedirector $redirector_;
    private long pointer;
    private final QuickJS quickJS;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface InterruptHandler {
        boolean onInterrupt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSRuntime(long j3, QuickJS quickJS) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), quickJS);
        } else {
            this.pointer = j3;
            this.quickJS = quickJS;
        }
    }

    private void checkClosed() {
        if (this.pointer != 0) {
        } else {
            throw new IllegalStateException("The JSRuntime is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        long j3 = this.pointer;
        if (j3 != 0) {
            this.pointer = 0L;
            QuickJS.destroyRuntime(j3);
        }
    }

    public synchronized JSContext createJSContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (JSContext) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        checkClosed();
        long createContext = QuickJS.createContext(this.pointer);
        if (createContext != 0) {
            return new JSContext(createContext, this.quickJS, this);
        }
        throw new IllegalStateException("Cannot create JSContext instance");
    }

    public synchronized void setInterruptHandler(@Nullable InterruptHandler interruptHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) interruptHandler);
        } else {
            checkClosed();
            QuickJS.setRuntimeInterruptHandler(this.pointer, interruptHandler);
        }
    }

    public synchronized void setMallocLimit(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        checkClosed();
        if (i3 != 0 && i3 >= -1) {
            QuickJS.setRuntimeMallocLimit(this.pointer, i3);
            return;
        }
        throw new IllegalArgumentException("Only positive number and -1 are accepted as malloc limit");
    }
}
