package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LazyStorage {
    static IPatchRedirector $redirector_ = null;
    private static final String CONTEXT_STORAGE_PROVIDER_PROPERTY = "com.tencent.opentelemetry.context.contextStorageProvider";
    private static final String ENABLE_STRICT_CONTEXT_PROVIDER_PROPERTY = "com.tencent.opentelemetry.context.enableStrictContext";
    private static final String ENFORCE_DEFAULT_STORAGE_VALUE = "default";
    private static final Logger logger;
    private static final ContextStorage storage;

    static {
        Object apply;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16111);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        logger = Logger.getLogger(LazyStorage.class.getName());
        AtomicReference atomicReference = new AtomicReference();
        ContextStorage createStorage = createStorage(atomicReference);
        if (Boolean.getBoolean(ENABLE_STRICT_CONTEXT_PROVIDER_PROPERTY)) {
            createStorage = StrictContextStorage.create(createStorage);
        }
        Iterator<Function<? super ContextStorage, ? extends ContextStorage>> it = ContextStorageWrappers.getWrappers().iterator();
        while (it.hasNext()) {
            apply = it.next().apply(createStorage);
            createStorage = (ContextStorage) apply;
        }
        storage = createStorage;
        ContextStorageWrappers.setStorageInitialized();
        Throwable th5 = (Throwable) atomicReference.get();
        if (th5 != null) {
            logger.log(Level.WARNING, "ContextStorageProvider initialized failed. Using default", th5);
        }
    }

    LazyStorage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static ContextStorage createStorage(AtomicReference<Throwable> atomicReference) {
        String property = System.getProperty(CONTEXT_STORAGE_PROVIDER_PROPERTY, "");
        if ("default".equals(property)) {
            return g.b();
        }
        ArrayList<ContextStorageProvider> arrayList = new ArrayList();
        Iterator it = ServiceLoader.load(ContextStorageProvider.class).iterator();
        while (it.hasNext()) {
            ContextStorageProvider contextStorageProvider = (ContextStorageProvider) it.next();
            if (contextStorageProvider.getClass().getName().equals("com.tencent.opentelemetry.sdk.testing.context.SettableContextStorageProvider")) {
                return contextStorageProvider.get();
            }
            arrayList.add(contextStorageProvider);
        }
        if (arrayList.isEmpty()) {
            return g.b();
        }
        if (property.isEmpty()) {
            if (arrayList.size() == 1) {
                return ((ContextStorageProvider) arrayList.get(0)).get();
            }
            atomicReference.set(new IllegalStateException("Found multiple ContextStorageProvider. Set the com.tencent.opentelemetry.context.ContextStorageProvider property to the fully qualified class name of the provider to use. Falling back to default ContextStorage. Found providers: " + arrayList));
            return g.b();
        }
        for (ContextStorageProvider contextStorageProvider2 : arrayList) {
            if (contextStorageProvider2.getClass().getName().equals(property)) {
                return contextStorageProvider2.get();
            }
        }
        atomicReference.set(new IllegalStateException("com.tencent.opentelemetry.context.ContextStorageProvider property set but no matching class could be found, requested: " + property + " but found providers: " + arrayList));
        return g.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ContextStorage get() {
        return storage;
    }
}
