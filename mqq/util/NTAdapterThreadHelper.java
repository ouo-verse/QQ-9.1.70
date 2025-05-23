package mqq.util;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lmqq/util/NTAdapterThreadHelper;", "", "()V", "OBSERVER_THREAD", "Landroid/os/HandlerThread;", "OBSERVER_THREAD_HANDLER", "Landroid/os/Handler;", "TAG", "", "THREAD_NAME", JoinPoint.SYNCHRONIZATION_LOCK, "useSingleThread", "", "getUseSingleThread", "()Z", "useSingleThread$delegate", "Lkotlin/Lazy;", "execute", "", "runnable", "Ljava/lang/Runnable;", "mqq_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class NTAdapterThreadHelper {

    @Nullable
    private static HandlerThread OBSERVER_THREAD = null;

    @Nullable
    private static volatile Handler OBSERVER_THREAD_HANDLER = null;

    @NotNull
    private static final String TAG = "AppRuntimeObserverNotifyHelper";

    @NotNull
    private static final String THREAD_NAME = "nt_adapter_thread";

    /* renamed from: useSingleThread$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy useSingleThread;

    @NotNull
    public static final NTAdapterThreadHelper INSTANCE = new NTAdapterThreadHelper();

    @NotNull
    private static final Object lock = new Object();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: mqq.util.NTAdapterThreadHelper$useSingleThread$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean z16;
                try {
                    z16 = MqqConfigUtil.INSTANCE.getConfigFile("use_notify_single_thread").exists();
                } catch (Exception e16) {
                    QLog.e("AppRuntimeObserverNotifyHelper", 1, e16, new Object[0]);
                    z16 = false;
                }
                QLog.d("AppRuntimeObserverNotifyHelper", 1, "useSingleThread result: " + z16);
                return Boolean.valueOf(z16);
            }
        });
        useSingleThread = lazy;
    }

    NTAdapterThreadHelper() {
    }

    private final boolean getUseSingleThread() {
        return ((Boolean) useSingleThread.getValue()).booleanValue();
    }

    public final void execute(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (!getUseSingleThread()) {
            ThreadManagerV2.excute(runnable, 16, null, true);
            return;
        }
        if (OBSERVER_THREAD_HANDLER == null) {
            synchronized (lock) {
                if (OBSERVER_THREAD_HANDLER == null) {
                    HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread(THREAD_NAME, 0);
                    newFreeHandlerThread.start();
                    OBSERVER_THREAD = newFreeHandlerThread;
                    HandlerThread handlerThread = OBSERVER_THREAD;
                    Intrinsics.checkNotNull(handlerThread);
                    OBSERVER_THREAD_HANDLER = new Handler(handlerThread.getLooper());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        Handler handler = OBSERVER_THREAD_HANDLER;
        Intrinsics.checkNotNull(handler);
        handler.post(runnable);
    }
}
