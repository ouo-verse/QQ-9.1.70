package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class MainDispatcherLoader {
    private static final boolean FAST_SERVICE_LOADER_ENABLED;

    @NotNull
    public static final MainDispatcherLoader INSTANCE;

    @JvmField
    @NotNull
    public static final MainCoroutineDispatcher dispatcher;

    static {
        MainDispatcherLoader mainDispatcherLoader = new MainDispatcherLoader();
        INSTANCE = mainDispatcherLoader;
        FAST_SERVICE_LOADER_ENABLED = SystemPropsKt.systemProp("kotlinx.coroutines.fast.service.loader", true);
        dispatcher = mainDispatcherLoader.loadMainDispatcher();
    }

    MainDispatcherLoader() {
    }

    private final MainCoroutineDispatcher loadMainDispatcher() {
        Sequence asSequence;
        List<MainDispatcherFactory> list;
        Object next;
        try {
            if (!FAST_SERVICE_LOADER_ENABLED) {
                asSequence = SequencesKt__SequencesKt.asSequence(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator());
                list = SequencesKt___SequencesKt.toList(asSequence);
            } else {
                list = FastServiceLoader.INSTANCE.loadMainDispatcherFactory$kotlinx_coroutines_core();
            }
            Iterator<T> it = list.iterator();
            if (!it.hasNext()) {
                next = null;
            } else {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            if (mainDispatcherFactory == null) {
                return MainDispatchersKt.createMissingDispatcher$default(null, null, 3, null);
            }
            return MainDispatchersKt.tryCreateDispatcher(mainDispatcherFactory, list);
        } catch (Throwable th5) {
            return MainDispatchersKt.createMissingDispatcher$default(th5, null, 2, null);
        }
    }
}
