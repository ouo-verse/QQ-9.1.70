package ey4;

import android.os.Handler;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Ley4/a;", "", "Landroid/os/Handler;", "a", "Landroid/os/Looper;", "b", "Landroid/os/Handler;", "subHandler", "uiHandler", "c", "Landroid/os/Looper;", "subLooper", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static Handler subHandler;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Handler uiHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Looper subLooper;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f397437d = new a();

    static {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("zplan_world");
        baseHandlerThread.start();
        Looper looper = baseHandlerThread.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "subThread.looper");
        subLooper = looper;
        subHandler = new Handler(subLooper);
        uiHandler = new Handler(Looper.getMainLooper());
    }

    a() {
    }

    @NotNull
    public final Handler a() {
        return subHandler;
    }

    @NotNull
    public final Looper b() {
        return subLooper;
    }
}
