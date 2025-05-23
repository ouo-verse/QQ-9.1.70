package com.tencent.tavcut.core.utils;

import android.os.Handler;
import com.tencent.tav.RCHandlerThread;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0006\u001a\u00020\u0003R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0011\u0010\u0012R0\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0014j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/tavcut/core/utils/CutSessionThreadUtils;", "", "Lkotlin/Function0;", "", "runnable", "e", "d", "", "a", "Z", "threadInited", "Lcom/tencent/tav/RCHandlerThread;", "b", "Lkotlin/Lazy;", "()Lcom/tencent/tav/RCHandlerThread;", "cutSessionThread", "Landroid/os/Handler;", "c", "()Landroid/os/Handler;", "threadHandler", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "buffer", "<init>", "()V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class CutSessionThreadUtils {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean threadInited;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy cutSessionThread;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy threadHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Function0<Unit>> buffer;

    public CutSessionThreadUtils() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RCHandlerThread>() { // from class: com.tencent.tavcut.core.utils.CutSessionThreadUtils$cutSessionThread$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RCHandlerThread invoke() {
                RCHandlerThread rCHandlerThread = new RCHandlerThread("PlayerVideoThread-cutSession");
                rCHandlerThread.start();
                rCHandlerThread.reference();
                CutSessionThreadUtils.this.threadInited = true;
                return rCHandlerThread;
            }
        });
        this.cutSessionThread = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.tavcut.core.utils.CutSessionThreadUtils$threadHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(CutSessionThreadUtils.this.b().getLooper());
            }
        });
        this.threadHandler = lazy2;
        this.buffer = new ArrayList<>();
    }

    private final Handler c() {
        return (Handler) this.threadHandler.getValue();
    }

    @NotNull
    public final RCHandlerThread b() {
        return (RCHandlerThread) this.cutSessionThread.getValue();
    }

    public final void d() {
        if (this.threadInited) {
            c().removeCallbacksAndMessages(null);
            b().quitSafely();
        }
    }

    public final synchronized void e(@NotNull final Function0<Unit> runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        c().post(new Runnable() { // from class: com.tencent.tavcut.core.utils.CutSessionThreadUtils$sam$java_lang_Runnable$0
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                Intrinsics.checkExpressionValueIsNotNull(Function0.this.invoke(), "invoke(...)");
            }
        });
    }
}
