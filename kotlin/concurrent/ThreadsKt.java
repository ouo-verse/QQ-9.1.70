package kotlin.concurrent;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a3\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\fH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0014"}, d2 = {MosaicConstants$JsProperty.PROP_THREAD, "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lkotlin/Function0;", "", "getOrSet", "T", "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "ThreadsKt")
/* loaded from: classes28.dex */
public final class ThreadsKt {
    @InlineOnly
    private static final <T> T getOrSet(ThreadLocal<T> threadLocal, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(threadLocal, "<this>");
        Intrinsics.checkNotNullParameter(function0, "default");
        T t16 = threadLocal.get();
        if (t16 == null) {
            T invoke = function0.invoke();
            threadLocal.set(invoke);
            return invoke;
        }
        return t16;
    }

    @NotNull
    public static final Thread thread(boolean z16, boolean z17, @Nullable ClassLoader classLoader, @Nullable String str, int i3, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        BaseThread baseThread = new BaseThread() { // from class: kotlin.concurrent.ThreadsKt$thread$thread$1
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                block.invoke();
            }
        };
        if (z17) {
            baseThread.setDaemon(true);
        }
        if (i3 > 0) {
            baseThread.setPriority(i3);
        }
        if (str != null) {
            baseThread.setName(str);
        }
        if (classLoader != null) {
            baseThread.setContextClassLoader(classLoader);
        }
        if (z16) {
            baseThread.start();
        }
        return baseThread;
    }

    public static /* synthetic */ Thread thread$default(boolean z16, boolean z17, ClassLoader classLoader, String str, int i3, Function0 function0, int i16, Object obj) {
        ClassLoader classLoader2;
        String str2;
        if ((i16 & 1) != 0) {
            z16 = true;
        }
        boolean z18 = z16;
        if ((i16 & 2) != 0) {
            z17 = false;
        }
        boolean z19 = z17;
        if ((i16 & 4) != 0) {
            classLoader2 = null;
        } else {
            classLoader2 = classLoader;
        }
        if ((i16 & 8) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i16 & 16) != 0) {
            i3 = -1;
        }
        return thread(z18, z19, classLoader2, str2, i3, function0);
    }
}
