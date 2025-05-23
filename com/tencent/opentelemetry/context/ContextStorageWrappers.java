package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ContextStorageWrappers {
    static IPatchRedirector $redirector_;
    private static final Logger log;
    private static final Object mutex;
    private static boolean storageInitialized;
    private static final List<Function<? super ContextStorage, ? extends ContextStorage>> wrappers;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16157);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        log = Logger.getLogger(ContextStorageWrappers.class.getName());
        wrappers = new ArrayList();
        mutex = new Object();
    }

    ContextStorageWrappers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addWrapper(Function<? super ContextStorage, ? extends ContextStorage> function) {
        synchronized (mutex) {
            if (storageInitialized) {
                log.log(Level.FINE, "ContextStorage has already been initialized, ignoring call to add wrapper.", new Throwable());
            } else {
                wrappers.add(function);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Function<? super ContextStorage, ? extends ContextStorage>> getWrappers() {
        List<Function<? super ContextStorage, ? extends ContextStorage>> list;
        synchronized (mutex) {
            list = wrappers;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setStorageInitialized() {
        synchronized (mutex) {
            storageInitialized = true;
        }
    }
}
