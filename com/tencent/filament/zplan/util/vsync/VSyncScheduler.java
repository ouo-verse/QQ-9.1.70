package com.tencent.filament.zplan.util.vsync;

import android.view.Choreographer;
import androidx.annotation.MainThread;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u0001\u000bB\u001f\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010)\u001a\u00020\u0004\u0012\u0006\u0010-\u001a\u00020*\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\u0006H\u0007R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/filament/zplan/util/vsync/VSyncScheduler;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "fps", "", DomainData.DOMAIN_NAME, "o", "p", "Ljava/util/concurrent/atomic/AtomicInteger;", "a", "Ljava/util/concurrent/atomic/AtomicInteger;", "pendingVSyncCount", "Lcom/tencent/filament/zplan/util/vsync/a;", "b", "Lcom/tencent/filament/zplan/util/vsync/a;", "fpsStabilizer", "", "c", "Z", "requestResetFrameDuration", "d", "J", "lastFrameTimeNanos", "e", "totalDrawTimeNanos", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "callbackMainLoop", "Landroid/view/Choreographer$FrameCallback;", "g", "Landroid/view/Choreographer$FrameCallback;", "vSyncCallback", "Lcom/tencent/filament/zplan/util/vsync/b;", h.F, "Lcom/tencent/filament/zplan/util/vsync/b;", "vSyncListener", "i", UserInfo.SEX_FEMALE, "targetFps", "Ljava/util/concurrent/Executor;", "j", "Ljava/util/concurrent/Executor;", "scheduleExecutor", "<init>", "(Lcom/tencent/filament/zplan/util/vsync/b;FLjava/util/concurrent/Executor;)V", "k", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class VSyncScheduler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger pendingVSyncCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final a fpsStabilizer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile boolean requestResetFrameDuration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long lastFrameTimeNanos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long totalDrawTimeNanos;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Runnable callbackMainLoop;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Choreographer.FrameCallback vSyncCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.filament.zplan.util.vsync.b vSyncListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float targetFps;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Executor scheduleExecutor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/filament/zplan/util/vsync/VSyncScheduler$b", "Landroid/view/Choreographer$FrameCallback;", "", "frameTimeNanos", "", "doFrame", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class b implements Choreographer.FrameCallback {
        b() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            if (VSyncScheduler.this.pendingVSyncCount.get() < 1) {
                VSyncScheduler.this.pendingVSyncCount.incrementAndGet();
                VSyncScheduler.this.scheduleExecutor.execute(VSyncScheduler.this.callbackMainLoop);
            }
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public VSyncScheduler(@NotNull com.tencent.filament.zplan.util.vsync.b vSyncListener, float f16, @NotNull Executor scheduleExecutor) {
        Intrinsics.checkNotNullParameter(vSyncListener, "vSyncListener");
        Intrinsics.checkNotNullParameter(scheduleExecutor, "scheduleExecutor");
        this.vSyncListener = vSyncListener;
        this.targetFps = f16;
        this.scheduleExecutor = scheduleExecutor;
        this.pendingVSyncCount = new AtomicInteger();
        a aVar = new a();
        this.fpsStabilizer = aVar;
        this.callbackMainLoop = new Runnable() { // from class: com.tencent.filament.zplan.util.vsync.VSyncScheduler$callbackMainLoop$1
            /* JADX WARN: Code restructure failed: missing block: B:7:0x002d, code lost:
            
                if (r4 != false) goto L10;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                long j3;
                long j16;
                long j17;
                long j18;
                a aVar2;
                long j19;
                b bVar;
                long j26;
                long j27;
                boolean z16;
                VSyncScheduler.this.pendingVSyncCount.decrementAndGet();
                long nanoTime = System.nanoTime();
                j3 = VSyncScheduler.this.lastFrameTimeNanos;
                if (j3 != 0) {
                    j16 = VSyncScheduler.this.lastFrameTimeNanos;
                    j17 = nanoTime - j16;
                } else {
                    j17 = 0;
                }
                if (j17 >= 0) {
                    z16 = VSyncScheduler.this.requestResetFrameDuration;
                }
                VSyncScheduler.this.requestResetFrameDuration = false;
                j17 = VSyncScheduler.this.m();
                VSyncScheduler.this.lastFrameTimeNanos = nanoTime;
                VSyncScheduler vSyncScheduler = VSyncScheduler.this;
                j18 = vSyncScheduler.totalDrawTimeNanos;
                vSyncScheduler.totalDrawTimeNanos = j18 + j17;
                aVar2 = VSyncScheduler.this.fpsStabilizer;
                j19 = VSyncScheduler.this.totalDrawTimeNanos;
                if (aVar2.b(j19)) {
                    bVar = VSyncScheduler.this.vSyncListener;
                    j26 = VSyncScheduler.this.totalDrawTimeNanos;
                    j27 = VSyncScheduler.this.lastFrameTimeNanos;
                    bVar.d(j26, j27);
                }
            }
        };
        this.vSyncCallback = new b();
        aVar.a(this.targetFps);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long m() {
        if (this.targetFps > 0) {
            return ((float) TimeUnit.SECONDS.toNanos(1L)) / r0;
        }
        return TimeUnit.SECONDS.toNanos(1L) / 60;
    }

    public final void n(float fps) {
        this.targetFps = fps;
        this.fpsStabilizer.a(fps);
    }

    @MainThread
    public final void o() {
        FLog.INSTANCE.i("VSyncScheduler", "startScheduleVSync");
        Choreographer.getInstance().postFrameCallback(this.vSyncCallback);
    }

    @MainThread
    public final void p() {
        FLog.INSTANCE.i("VSyncScheduler", "stopScheduleVSync");
        Choreographer.getInstance().removeFrameCallback(this.vSyncCallback);
        this.requestResetFrameDuration = true;
    }
}
