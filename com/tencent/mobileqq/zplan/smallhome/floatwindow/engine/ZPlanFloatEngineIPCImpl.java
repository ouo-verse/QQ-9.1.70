package com.tencent.mobileqq.zplan.smallhome.floatwindow.engine;

import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/engine/ZPlanFloatEngineIPCImpl;", "Lok3/b;", "", "keepEngine", "releaseKeeping", "resumeEngine", "Lok3/a;", "emptySurfaceHelper", "Lok3/a;", "Lcom/tencent/zplan/engine/c;", "startEngineListener", "Lcom/tencent/zplan/engine/c;", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "statusUpdateListener", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFloatEngineIPCImpl implements ok3.b {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String TAG = "ZPlanFloatEngineIPCImpl";
    private final ok3.a emptySurfaceHelper = new ok3.a();
    private final com.tencent.zplan.engine.c startEngineListener = new b();
    private final ZPlanEngineStatusUpdateListener statusUpdateListener = new c();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/engine/ZPlanFloatEngineIPCImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/smallhome/floatwindow/engine/ZPlanFloatEngineIPCImpl$b", "Lcom/tencent/zplan/engine/c;", "", "success", "", "startEngineState", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.zplan.engine.c {
        b() {
        }

        @Override // com.tencent.zplan.engine.c
        public void a(boolean success, int startEngineState) {
            QLog.i(ZPlanFloatEngineIPCImpl.TAG, 1, "onStartEngineResult success:" + success + ", startEngineState:" + startEngineState);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/smallhome/floatwindow/engine/ZPlanFloatEngineIPCImpl$c", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", "engineSuspended", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements ZPlanEngineStatusUpdateListener {
        c() {
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineDestroy() {
            ZPlanEngineStatusUpdateListener.a.a(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
        public void engineFirstFrame() {
            ZPlanEngineStatusUpdateListener.a.b(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInitFinish(boolean z16) {
            ZPlanEngineStatusUpdateListener.a.c(this, z16);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInversePurged() {
            ZPlanEngineStatusUpdateListener.a.d(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurged() {
            ZPlanEngineStatusUpdateListener.a.e(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurging() {
            ZPlanEngineStatusUpdateListener.a.f(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineSuspended() {
            ZPlanEngineStatusUpdateListener.a.g(this);
            boolean isCurrentProcessForeground = Foreground.isCurrentProcessForeground();
            QLog.i(ZPlanFloatEngineIPCImpl.TAG, 1, "engineSuspended isForeground = " + isCurrentProcessForeground);
            if (isCurrentProcessForeground) {
                ZPlanFloatEngineIPCImpl.this.resumeEngine();
                ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                zPlanServiceHelper.X0(context, new WeakReference<>(ZPlanFloatEngineIPCImpl.this.startEngineListener), "keep");
            }
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void hotPatchDownloadFailed(int i3, String str) {
            ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void serviceConnected(boolean z16) {
            ZPlanEngineStatusUpdateListener.a.i(this, z16);
        }
    }

    @Override // ok3.b
    public void resumeEngine() {
        ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
        boolean m06 = zPlanServiceHelper.m0();
        boolean k06 = zPlanServiceHelper.k0();
        QLog.i(TAG, 1, "resumeEngine isWindowInitDone\uff1a" + m06 + " isEnginePaused\uff1a" + k06);
        if (m06) {
            if (k06) {
                QLog.i(TAG, 1, "resumeEngine normal");
                ZPlanServiceHelper.M0(zPlanServiceHelper, null, 1, null);
                return;
            }
            return;
        }
        this.emptySurfaceHelper.b();
        QLog.i(TAG, 1, "resumeEngine with surface " + this.emptySurfaceHelper.getSurface());
        ZPlanServiceHelper.L0(zPlanServiceHelper, this.emptySurfaceHelper.getSurface(), null, 2, null);
    }

    @Override // ok3.b
    public void keepEngine() {
        QLog.i(TAG, 1, "keepEngine");
        ZPlanServiceHelper.I.E0(this.statusUpdateListener);
    }

    @Override // ok3.b
    public void releaseKeeping() {
        QLog.i(TAG, 1, "releaseEngine");
        ZPlanServiceHelper.I.a1(this.statusUpdateListener);
        this.emptySurfaceHelper.c();
    }
}
