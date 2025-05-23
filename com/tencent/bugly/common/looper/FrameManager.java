package com.tencent.bugly.common.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.ThreadUtil;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0005R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/bugly/common/looper/FrameManager;", "Landroid/view/Choreographer$FrameCallback;", "()V", "callbackList", "Ljava/util/HashSet;", "Lcom/tencent/bugly/common/looper/IFrame;", "Lkotlin/collections/HashSet;", "choreographer", "Lcom/tencent/bugly/common/looper/ChoreographerDelegate;", "isInit", "", "isStart", "checkAndStart", "", "checkAndStop", "doFrame", "frameTimeNanos", "", "init", "isInitSuccess", "register", "listener", "unRegister", "Companion", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public final class FrameManager implements Choreographer.FrameCallback {
    private static final String TAG = "RMonitor_looper_FrameManager";
    private final HashSet<IFrame> callbackList = new HashSet<>();
    private ChoreographerDelegate choreographer;
    private boolean isInit;
    private boolean isStart;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FrameManager frameManager = new FrameManager();
    private static final Handler handler = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/bugly/common/looper/FrameManager$Companion;", "", "()V", "TAG", "", "frameManager", "Lcom/tencent/bugly/common/looper/FrameManager;", "handler", "Landroid/os/Handler;", "clearForTest", "", "getFrameManagerForUnitTest", "init", "isInit", "", "isStart", "register", "listener", "Lcom/tencent/bugly/common/looper/IFrame;", "unRegister", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        public final void clearForTest() {
            if (ThreadUtil.isInMainThread()) {
                FrameManager.frameManager.callbackList.clear();
                FrameManager.frameManager.checkAndStop();
            } else {
                FrameManager.handler.post(new Runnable() { // from class: com.tencent.bugly.common.looper.FrameManager$Companion$clearForTest$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        FrameManager.frameManager.callbackList.clear();
                        FrameManager.frameManager.checkAndStop();
                    }
                });
            }
        }

        @NotNull
        public final FrameManager getFrameManagerForUnitTest() {
            return FrameManager.frameManager;
        }

        public final void init() {
            if (ThreadUtil.isInMainThread()) {
                FrameManager.frameManager.init();
            } else {
                FrameManager.handler.post(new Runnable() { // from class: com.tencent.bugly.common.looper.FrameManager$Companion$init$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        FrameManager.frameManager.init();
                    }
                });
            }
        }

        public final boolean isInit() {
            return FrameManager.frameManager.isInit;
        }

        public final boolean isStart() {
            return FrameManager.frameManager.isStart;
        }

        public final void register(@NotNull final IFrame listener) {
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            if (ThreadUtil.isInMainThread()) {
                FrameManager.frameManager.register(listener);
            } else {
                FrameManager.handler.post(new Runnable() { // from class: com.tencent.bugly.common.looper.FrameManager$Companion$register$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        FrameManager.frameManager.register(IFrame.this);
                    }
                });
            }
        }

        public final void unRegister(@NotNull final IFrame listener) {
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            if (ThreadUtil.isInMainThread()) {
                FrameManager.frameManager.unRegister(listener);
            } else {
                FrameManager.handler.post(new Runnable() { // from class: com.tencent.bugly.common.looper.FrameManager$Companion$unRegister$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        FrameManager.frameManager.unRegister(IFrame.this);
                    }
                });
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void checkAndStart() {
        if (!this.isStart && this.callbackList.size() != 0) {
            if (!this.isInit) {
                init();
            }
            ChoreographerDelegate choreographerDelegate = this.choreographer;
            if (choreographerDelegate != null) {
                this.isStart = true;
                choreographerDelegate.postFrameCallback(this);
                Logger.f365497g.d(TAG, "checkAndStart");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAndStop() {
        if (this.isStart && this.callbackList.size() <= 0) {
            this.isStart = false;
            ChoreographerDelegate choreographerDelegate = this.choreographer;
            if (choreographerDelegate != null) {
                choreographerDelegate.removeFrameCallback(this);
            }
            Logger.f365497g.d(TAG, "checkAndStop");
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long frameTimeNanos) {
        ChoreographerDelegate choreographerDelegate;
        for (IFrame iFrame : this.callbackList) {
            if (iFrame.isOpen()) {
                iFrame.doFrame(frameTimeNanos);
            }
        }
        if (this.isStart && (choreographerDelegate = this.choreographer) != null) {
            choreographerDelegate.postFrameCallback(this);
        }
    }

    public final void init() {
        if (this.isInit) {
            return;
        }
        if (AndroidVersion.INSTANCE.isOverJellyBean()) {
            try {
                this.choreographer = new ChoreographerDelegate();
                Logger.f365497g.i(TAG, "init choreographer success.");
            } catch (Throwable th5) {
                Logger.f365497g.b(TAG, "init choreographer error.", th5);
            }
        } else {
            Logger.f365497g.i(TAG, "init choreographer build version is low.");
        }
        this.isInit = true;
    }

    public final boolean isInitSuccess() {
        if (this.choreographer != null) {
            return true;
        }
        return false;
    }

    public final void register(@NotNull IFrame listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.callbackList.add(listener);
        checkAndStart();
    }

    public final void unRegister(@NotNull IFrame listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.callbackList.remove(listener);
        checkAndStop();
    }
}
