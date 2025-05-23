package com.tencent.qqmini.minigame.task;

import android.content.Context;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.qqmini.minigame.api.MiniEnginePackage;
import com.tencent.qqmini.minigame.api.TritonPlatformManager;
import com.tencent.qqmini.minigame.manager.EnginePackageCreator;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0006\u0010\n\u001a\u00020\tJ\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqmini/minigame/task/TritonEngineLoader;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqmini/minigame/task/c;", "callback", "", "j", "k", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "e", "Lcom/tencent/mobileqq/triton/TritonPlatform;", h.F, "Lcom/tencent/qqmini/minigame/api/MiniEnginePackage;", "g", "", "i", "", "f", "a", "Lcom/tencent/qqmini/minigame/api/MiniEnginePackage;", "enginePackage", "b", "Lcom/tencent/mobileqq/triton/TritonPlatform;", "tritonPlatform", "c", "J", WinkDengtaReportConstant.Params.REPORT_PARMA_LOAD_TIME, "<init>", "()V", "d", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class TritonEngineLoader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private MiniEnginePackage enginePackage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private TritonPlatform tritonPlatform;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile long loadTime;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r14v3, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v8, types: [com.tencent.mobileqq.triton.TritonPlatform, T] */
    public final void j(Context context, final c callback) {
        final long currentTimeMillis = System.currentTimeMillis();
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1014, "1");
        final MiniEnginePackage a16 = EnginePackageCreator.INSTANCE.a();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = null;
        try {
            objectRef.element = TritonPlatformManager.getTritonPlatform(context, a16);
        } catch (TritonInitException e16) {
            QMLog.e("TritonEngineLoader", "load failed, TritonInitException=", e16);
            objectRef2.element = "get triton platform throw t:" + e16.getMessage();
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.task.TritonEngineLoader$load$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                if (((TritonPlatform) objectRef.element) == null) {
                    callback.onTritonLoadFail("platform is null, " + ((String) objectRef2.element));
                    return;
                }
                TritonEngineLoader.this.enginePackage = a16;
                TritonEngineLoader.this.tritonPlatform = (TritonPlatform) objectRef.element;
                TritonEngineLoader.this.loadTime = System.currentTimeMillis() - currentTimeMillis;
                callback.onTritonLoadSuccess(a16, (TritonPlatform) objectRef.element);
            }
        });
        QMLog.w("TritonEngineLoader", "[initTTEngine] cost time=" + (System.currentTimeMillis() - currentTimeMillis));
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1015, "1");
    }

    @NotNull
    public final TaskExecutionStatics e() {
        TaskExecutionStatics.Status status;
        List emptyList;
        if (this.tritonPlatform != null) {
            status = TaskExecutionStatics.Status.SUCCESS;
        } else {
            status = TaskExecutionStatics.Status.FAIL;
        }
        long j3 = this.loadTime;
        long j16 = this.loadTime;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return new TaskExecutionStatics("TritonEngineLoader", j3, j16, status, "", emptyList, 0L, 64, null);
    }

    /* renamed from: f, reason: from getter */
    public final long getLoadTime() {
        return this.loadTime;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final MiniEnginePackage getEnginePackage() {
        return this.enginePackage;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final TritonPlatform getTritonPlatform() {
        return this.tritonPlatform;
    }

    public final boolean i() {
        if (this.enginePackage != null && this.tritonPlatform != null) {
            return true;
        }
        return false;
    }

    @MainThread
    public final void k(@NotNull final Context context, @NotNull final c callback) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        if (this.enginePackage != null && this.tritonPlatform != null) {
            QMLog.i("TritonEngineLoader", "loadEngine: has load, success directly.");
            MiniEnginePackage miniEnginePackage = this.enginePackage;
            if (miniEnginePackage == null) {
                Intrinsics.throwNpe();
            }
            TritonPlatform tritonPlatform = this.tritonPlatform;
            if (tritonPlatform == null) {
                Intrinsics.throwNpe();
            }
            callback.onTritonLoadSuccess(miniEnginePackage, tritonPlatform);
            return;
        }
        ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.minigame.task.TritonEngineLoader$loadEngine$1
            @Override // java.lang.Runnable
            public final void run() {
                TritonEngineLoader.this.j(context, callback);
            }
        });
    }
}
