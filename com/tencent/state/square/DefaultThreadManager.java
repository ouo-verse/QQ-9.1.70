package com.tencent.state.square;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.image.URLDrawable;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\t0\u000bj\u0002`\fH\u0016J\"\u0010\r\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\t0\u000bj\u0002`\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\t0\u000bj\u0002`\fH\u0016J$\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\t0\u000bj\u0002`\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0013\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\t0\u000bj\u0002`\fH\u0016J\"\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\t0\u000bj\u0002`\fH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0012H\u0016J\u001a\u0010\u0016\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\t0\u000bj\u0002`\fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/DefaultThreadManager;", "Lcom/tencent/state/square/IThreadManager;", "()V", "subHandler", "Landroid/os/Handler;", "subHandlerThread", "Landroid/os/HandlerThread;", "uiHandler", "postOnFileThread", "", "task", "Lkotlin/Function0;", "Lcom/tencent/state/square/Task;", "postOnFileThreadDelay", "delay", "", "postOnSubThread", "postOnSubThreadDelay", "Ljava/lang/Runnable;", "postOnUi", "postOnUiDelayed", "removeTask", "removeTaskOnUI", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultThreadManager implements IThreadManager {
    private Handler subHandler;
    private HandlerThread subHandlerThread;
    private final Handler uiHandler = new Handler(Looper.getMainLooper());

    @Override // com.tencent.state.square.IThreadManager
    public void postOnFileThread(@NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(new SquareConfigKt$sam$java_lang_Runnable$0(task), null, true);
    }

    @Override // com.tencent.state.square.IThreadManager
    public void postOnFileThreadDelay(@NotNull Function0<Unit> task, long delay) {
        Intrinsics.checkNotNullParameter(task, "task");
    }

    @Override // com.tencent.state.square.IThreadManager
    public void postOnSubThread(@NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (this.subHandler == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("SubHandler");
            baseHandlerThread.start();
            Unit unit = Unit.INSTANCE;
            this.subHandlerThread = baseHandlerThread;
            this.subHandler = new Handler(baseHandlerThread.getLooper());
        }
        Handler handler = this.subHandler;
        if (handler != null) {
            handler.post(new SquareConfigKt$sam$java_lang_Runnable$0(task));
        }
    }

    @Override // com.tencent.state.square.IThreadManager
    @Nullable
    public Runnable postOnSubThreadDelay(@NotNull final Function0<Unit> task, long delay) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (this.subHandler == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("SubHandler");
            baseHandlerThread.start();
            Unit unit = Unit.INSTANCE;
            this.subHandlerThread = baseHandlerThread;
            this.subHandler = new Handler(baseHandlerThread.getLooper());
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.state.square.DefaultThreadManager$postOnSubThreadDelay$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        };
        Handler handler = this.subHandler;
        if (handler != null) {
            handler.postDelayed(runnable, delay);
        }
        return runnable;
    }

    @Override // com.tencent.state.square.IThreadManager
    public void postOnUi(@NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.uiHandler.post(new SquareConfigKt$sam$java_lang_Runnable$0(task));
    }

    @Override // com.tencent.state.square.IThreadManager
    public void postOnUiDelayed(long delay, @NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.uiHandler.postDelayed(new SquareConfigKt$sam$java_lang_Runnable$0(task), delay);
    }

    @Override // com.tencent.state.square.IThreadManager
    public void removeTask(@NotNull Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        Handler handler = this.subHandler;
        if (handler != null) {
            handler.removeCallbacks(task, null);
        }
    }

    @Override // com.tencent.state.square.IThreadManager
    public void removeTaskOnUI(@NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.uiHandler.removeCallbacks(new SquareConfigKt$sam$java_lang_Runnable$0(task));
    }
}
