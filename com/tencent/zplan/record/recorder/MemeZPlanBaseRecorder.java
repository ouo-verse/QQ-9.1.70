package com.tencent.zplan.record.recorder;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.IZPlanRecordCallback;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.engine.c;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.ERROR_ENGINE_PAUSED;
import com.tencent.zplan.meme.action.ERROR_TIME_OUT;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import com.tencent.zplan.meme.d;
import com.tencent.zplan.meme.model.MemeRecordParams;
import com.tencent.zplan.meme.recorder.a;
import com.tencent.zplan.model.ZPlanRecordFrameData;
import com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.utils.ZLog;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 *2\u00020\u0001:\u0002+,B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020#8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/zplan/record/recorder/MemeZPlanBaseRecorder;", "Lcom/tencent/zplan/meme/recorder/a;", "", "destroyEngine", "initSurface", "releaseSurface", "", "recordKey", "Lcom/tencent/zplan/record/recorder/MemeZPlanBaseRecorder$BaseRecordContext;", "recordContext", "setRecordContext", "getRecordContextWithCheck", "removeRecordContext$zplan_debug", "(Ljava/lang/String;)V", "removeRecordContext", "Lcom/tencent/zplan/meme/action/MemeAction;", "action", "stopAction", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "recordContexts", "Ljava/util/Map;", "", "hasSetUsing", "Z", "getHasSetUsing", "()Z", "setHasSetUsing", "(Z)V", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "Landroid/view/Surface;", "surface", "Landroid/view/Surface;", "Lcom/tencent/zplan/IZPlanRecordCallback$Stub;", "zPlanRecordCallback", "Lcom/tencent/zplan/IZPlanRecordCallback$Stub;", "getZPlanRecordCallback", "()Lcom/tencent/zplan/IZPlanRecordCallback$Stub;", "<init>", "()V", "Companion", "BaseRecordContext", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public abstract class MemeZPlanBaseRecorder implements a {
    private static final String TAG = "[zplan][MemePlayer-SDK][MemeZPlanBaseRecorder]";

    @NotNull
    private static final Lazy enableResumeEngineOnSuspended$delegate;
    private volatile boolean hasSetUsing;
    private volatile Surface surface;
    private volatile SurfaceTexture surfaceTexture;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long timeout = Meme.f385754h.k().getTimeout();
    private final Map<String, BaseRecordContext> recordContexts = new LinkedHashMap();

    @NotNull
    private final IZPlanRecordCallback.Stub zPlanRecordCallback = new IZPlanRecordCallback.Stub() { // from class: com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder$zPlanRecordCallback$1
        @Override // com.tencent.zplan.IZPlanRecordCallback
        public void onEncodeEnd(@NotNull String recordKey, int portraitId, @NotNull Bundle data) {
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            Intrinsics.checkNotNullParameter(data, "data");
            MemeZPlanBaseRecorder.BaseRecordContext recordContextWithCheck = MemeZPlanBaseRecorder.this.getRecordContextWithCheck(recordKey);
            if (recordContextWithCheck != null) {
                recordContextWithCheck.d(portraitId, data);
            }
        }

        @Override // com.tencent.zplan.IZPlanRecordCallback
        public void onEncodeStart(@NotNull String recordKey, int portraitId) {
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            MemeZPlanBaseRecorder.BaseRecordContext recordContextWithCheck = MemeZPlanBaseRecorder.this.getRecordContextWithCheck(recordKey);
            if (recordContextWithCheck != null) {
                recordContextWithCheck.e(portraitId);
            }
        }

        @Override // com.tencent.zplan.IZPlanRecordCallback
        public void onRecordCoverDone(@NotNull String recordKey, int portraitId, @NotNull Bundle data) {
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            Intrinsics.checkNotNullParameter(data, "data");
            MemeZPlanBaseRecorder.BaseRecordContext recordContextWithCheck = MemeZPlanBaseRecorder.this.getRecordContextWithCheck(recordKey);
            if (recordContextWithCheck != null) {
                ZLog.f386189b.k("[zplan][MemePlayer-SDK][MemeZPlanBaseRecorder]", "onRecordCoverDone, recordKey:" + recordKey + ", portraitId:" + portraitId + " data:" + data);
                recordContextWithCheck.f(recordKey, portraitId, data);
            }
        }

        @Override // com.tencent.zplan.IZPlanRecordCallback
        public void onRecordDone(@NotNull String recordKey, int portraitId, @NotNull Bundle data) {
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            Intrinsics.checkNotNullParameter(data, "data");
            MemeZPlanBaseRecorder.BaseRecordContext recordContextWithCheck = MemeZPlanBaseRecorder.this.getRecordContextWithCheck(recordKey);
            if (recordContextWithCheck != null) {
                ZLog.f386189b.k("[zplan][MemePlayer-SDK][MemeZPlanBaseRecorder]", "onRecordDone, recordKey:" + recordKey + ", portraitId:" + portraitId);
                recordContextWithCheck.g(recordKey, portraitId, data);
            }
        }

        @Override // com.tencent.zplan.IZPlanRecordCallback
        public void onRecordFrameEnd(@NotNull String recordKey, int portraitId, @NotNull Bundle data) {
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            Intrinsics.checkNotNullParameter(data, "data");
            MemeZPlanBaseRecorder.BaseRecordContext recordContextWithCheck = MemeZPlanBaseRecorder.this.getRecordContextWithCheck(recordKey);
            if (recordContextWithCheck != null) {
                recordContextWithCheck.h(portraitId, data);
            }
        }

        @Override // com.tencent.zplan.IZPlanRecordCallback
        public void onRecordFrameStart(@NotNull String recordKey, int portraitId, @NotNull Bundle data) {
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            Intrinsics.checkNotNullParameter(data, "data");
            MemeZPlanBaseRecorder.BaseRecordContext recordContextWithCheck = MemeZPlanBaseRecorder.this.getRecordContextWithCheck(recordKey);
            if (recordContextWithCheck != null) {
                recordContextWithCheck.i(recordKey, portraitId, data);
            }
        }

        @Override // com.tencent.zplan.IZPlanRecordCallback
        public void onRecordSingleFrame(@NotNull String recordKey, int portraitId, @Nullable ZPlanRecordFrameData frameData) {
            MemeZPlanBaseRecorder.BaseRecordContext recordContextWithCheck;
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            if (frameData != null && (recordContextWithCheck = MemeZPlanBaseRecorder.this.getRecordContextWithCheck(recordKey)) != null) {
                recordContextWithCheck.j(frameData);
            }
        }
    };

    @Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001/\b&\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010?\u001a\u00020;\u0012\u0006\u0010D\u001a\u00020@\u0012\u0006\u0010I\u001a\u00020E\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0004J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0004J\b\u0010\u000b\u001a\u00020\u0002H&J\b\u0010\r\u001a\u00020\fH&J \u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0015H&J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&J \u0010\u001a\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&J \u0010\u001b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH&J\b\u0010\u001f\u001a\u00020\u0002H\u0016R\u001a\u0010%\u001a\u00020 8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\"\u0010.\u001a\u00020&8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010(\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u00100R\u0018\u00104\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u00103R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u00105\u001a\u0004\b6\u00107R\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u00108\u001a\u0004\b9\u0010:R\u001a\u0010?\u001a\u00020;8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010<\u001a\u0004\b=\u0010>R\u001a\u0010D\u001a\u00020@8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010A\u001a\u0004\bB\u0010CR\u001a\u0010I\u001a\u00020E8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010F\u001a\u0004\bG\u0010H\u00a8\u0006L"}, d2 = {"Lcom/tencent/zplan/record/recorder/MemeZPlanBaseRecorder$BaseRecordContext;", "", "", "w", "y", HippyTKDListViewAdapter.X, "v", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "action", "Ljava/lang/Runnable;", "u", "c", "Lcom/tencent/zplan/meme/model/MemeRecordParams;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "recordKey", "", "portraitId", "Landroid/os/Bundle;", "data", "i", "Lcom/tencent/zplan/model/ZPlanRecordFrameData;", "j", h.F, "e", "d", "g", "f", "Lcom/tencent/zplan/meme/action/ActionStatus;", "errorStatus", "k", "l", "Llx4/f;", "a", "Llx4/f;", "t", "()Llx4/f;", "threadPool", "", "b", "Z", "hasStartOnZPlanProcess", "o", "()Z", "setForceStopped$zplan_debug", "(Z)V", "forceStopped", "com/tencent/zplan/record/recorder/MemeZPlanBaseRecorder$BaseRecordContext$engineStatusListener$1", "Lcom/tencent/zplan/record/recorder/MemeZPlanBaseRecorder$BaseRecordContext$engineStatusListener$1;", "engineStatusListener", "Lcom/tencent/zplan/engine/c;", "Lcom/tencent/zplan/engine/c;", "startEngineListener", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", DomainData.DOMAIN_NAME, "()Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "Ljava/lang/String;", "r", "()Ljava/lang/String;", "Lcom/tencent/zplan/meme/d;", "Lcom/tencent/zplan/meme/d;", "p", "()Lcom/tencent/zplan/meme/d;", "listener", "Lcom/tencent/zplan/IZPlanRecordCallback;", "Lcom/tencent/zplan/IZPlanRecordCallback;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/zplan/IZPlanRecordCallback;", "recordCallback", "Lcom/tencent/zplan/record/recorder/MemeZPlanBaseRecorder;", "Lcom/tencent/zplan/record/recorder/MemeZPlanBaseRecorder;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/zplan/record/recorder/MemeZPlanBaseRecorder;", "recorder", "<init>", "(Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;Ljava/lang/String;Lcom/tencent/zplan/meme/d;Lcom/tencent/zplan/IZPlanRecordCallback;Lcom/tencent/zplan/record/recorder/MemeZPlanBaseRecorder;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static abstract class BaseRecordContext {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final f threadPool;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private volatile boolean hasStartOnZPlanProcess;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private volatile boolean forceStopped;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final MemeZPlanBaseRecorder$BaseRecordContext$engineStatusListener$1 engineStatusListener;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private c startEngineListener;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MemeZPlanBaseAction action;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String recordKey;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d listener;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final IZPlanRecordCallback recordCallback;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MemeZPlanBaseRecorder recorder;

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/zplan/record/recorder/MemeZPlanBaseRecorder$BaseRecordContext$a", "Lcom/tencent/zplan/engine/c;", "", "success", "", "startEngineState", "", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static final class a implements c {
            a() {
            }

            @Override // com.tencent.zplan.engine.c
            public void a(boolean success, int startEngineState) {
                ZLog.f386189b.k(MemeZPlanBaseRecorder.TAG, "onStartEngineResult success:" + success + ", startEngineState:" + startEngineState);
            }
        }

        public BaseRecordContext(@NotNull MemeZPlanBaseAction action, @NotNull String recordKey, @NotNull d listener, @NotNull IZPlanRecordCallback recordCallback, @NotNull MemeZPlanBaseRecorder recorder) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(recordCallback, "recordCallback");
            Intrinsics.checkNotNullParameter(recorder, "recorder");
            this.action = action;
            this.recordKey = recordKey;
            this.listener = listener;
            this.recordCallback = recordCallback;
            this.recorder = recorder;
            Object a16 = mx4.a.f417748a.a(f.class);
            Intrinsics.checkNotNull(a16);
            this.threadPool = (f) a16;
            this.engineStatusListener = new MemeZPlanBaseRecorder$BaseRecordContext$engineStatusListener$1(this);
            this.startEngineListener = new a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void w() {
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            boolean m06 = zPlanServiceHelper.m0();
            boolean k06 = zPlanServiceHelper.k0();
            ZLog zLog = ZLog.f386189b;
            zLog.k(MemeZPlanBaseRecorder.TAG, "resumeEngine isEnginePaused:" + k06 + ", isWindowInitDone:" + m06);
            if (!m06) {
                getRecorder().initSurface();
                zLog.k(MemeZPlanBaseRecorder.TAG, "resumeEngine with " + getRecorder().surface + " on engine window not init done");
                ZPlanServiceHelper.L0(zPlanServiceHelper, getRecorder().surface, null, 2, null);
                return;
            }
            if (k06) {
                zLog.k(MemeZPlanBaseRecorder.TAG, "resumeEngine on engine paused");
                ZPlanServiceHelper.M0(zPlanServiceHelper, null, 1, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void y() {
            if (!this.hasStartOnZPlanProcess && !this.forceStopped) {
                this.hasStartOnZPlanProcess = true;
                ZLog.f386189b.k(MemeZPlanBaseRecorder.TAG, "startOnZPlanProcess " + getAction().getDesc());
                ZPlanServiceHelper.I.C0(m(), getRecordCallback());
                c();
                return;
            }
            ZLog.f386189b.o(MemeZPlanBaseRecorder.TAG, getAction().getDesc() + " already startOnZPlanProcess or forceStopped, skip!!");
        }

        public abstract void c();

        public abstract void d(int portraitId, @NotNull Bundle data);

        public abstract void e(int portraitId);

        public abstract void f(@NotNull String recordKey, int portraitId, @NotNull Bundle data);

        public abstract void g(@NotNull String recordKey, int portraitId, @NotNull Bundle data);

        public abstract void h(int portraitId, @NotNull Bundle data);

        public abstract void i(@NotNull String recordKey, int portraitId, @NotNull Bundle data);

        public abstract void j(@NotNull ZPlanRecordFrameData data);

        public abstract void k(@NotNull ActionStatus errorStatus);

        public void l() {
            com.tencent.zplan.luabridge.a S;
            this.forceStopped = true;
            if (this.hasStartOnZPlanProcess && (S = ZPlanServiceHelper.I.S()) != null) {
                a.C10063a.a(S, "N2L_ForceStopRecord", null, false, 6, null);
            }
        }

        @NotNull
        public abstract MemeRecordParams m();

        @NotNull
        /* renamed from: n, reason: from getter */
        public MemeZPlanBaseAction getAction() {
            return this.action;
        }

        /* renamed from: o, reason: from getter */
        public final boolean getForceStopped() {
            return this.forceStopped;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public d getListener() {
            return this.listener;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public IZPlanRecordCallback getRecordCallback() {
            return this.recordCallback;
        }

        @NotNull
        /* renamed from: r, reason: from getter */
        public String getRecordKey() {
            return this.recordKey;
        }

        @NotNull
        /* renamed from: s, reason: from getter */
        public MemeZPlanBaseRecorder getRecorder() {
            return this.recorder;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NotNull
        /* renamed from: t, reason: from getter */
        public final f getThreadPool() {
            return this.threadPool;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NotNull
        public final Runnable u(@NotNull final MemeZPlanBaseAction action) {
            Intrinsics.checkNotNullParameter(action, "action");
            return new Runnable() { // from class: com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder$BaseRecordContext$getTimeoutRunner$1
                @Override // java.lang.Runnable
                public final void run() {
                    if (MemeZPlanBaseRecorder.BaseRecordContext.this.getForceStopped()) {
                        return;
                    }
                    boolean k06 = ZPlanServiceHelper.I.k0();
                    ZLog.f386189b.f("[zplan][MemePlayer-SDK][MemeZPlanBaseRecorder]", action.getDesc() + " timeout(" + MemeZPlanBaseRecorder.INSTANCE.b() + "ms)!! callback timeout, enginePaused:" + k06);
                    if (k06) {
                        MemeZPlanBaseRecorder.BaseRecordContext.this.k(ERROR_ENGINE_PAUSED.INSTANCE);
                    } else {
                        MemeZPlanBaseRecorder.BaseRecordContext.this.k(ERROR_TIME_OUT.INSTANCE);
                    }
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void v() {
            ZPlanServiceHelper.I.a1(this.engineStatusListener);
            this.startEngineListener = null;
        }

        public void x() {
            Context context;
            if (!getRecorder().getHasSetUsing()) {
                getRecorder().setHasSetUsing(ZPlanServiceHelper.I.Q0(true));
                ZLog.f386189b.k(MemeZPlanBaseRecorder.TAG, "[start] setZPlanSceneStatus to " + getRecorder().getHasSetUsing());
            }
            w();
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            zPlanServiceHelper.E0(this.engineStatusListener);
            lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
            if (aVar != null) {
                context = aVar.getContext();
            } else {
                context = null;
            }
            Intrinsics.checkNotNull(context);
            zPlanServiceHelper.X0(context, new WeakReference<>(this.startEngineListener), "meme");
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/zplan/record/recorder/MemeZPlanBaseRecorder$a;", "", "", "timeout", "J", "b", "()J", "", "enableResumeEngineOnSuspended$delegate", "Lkotlin/Lazy;", "a", "()Z", "enableResumeEngineOnSuspended", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean a() {
            return ((Boolean) MemeZPlanBaseRecorder.enableResumeEngineOnSuspended$delegate.getValue()).booleanValue();
        }

        public final long b() {
            return MemeZPlanBaseRecorder.timeout;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder$Companion$enableResumeEngineOnSuspended$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                Object a16 = mx4.a.f417748a.a(zx4.d.class);
                Intrinsics.checkNotNull(a16);
                return ((zx4.d) a16).g();
            }
        });
        enableResumeEngineOnSuspended$delegate = lazy;
    }

    private final void destroyEngine() {
        Context context;
        ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
        if (zPlanServiceHelper.Q()) {
            return;
        }
        ZLog.f386189b.k(TAG, "stopZPlanEngine");
        lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
        if (aVar != null && (context = aVar.getContext()) != null) {
            zPlanServiceHelper.Y0(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void initSurface() {
        if (this.surfaceTexture == null) {
            this.surfaceTexture = new SurfaceTexture(0);
            this.surface = new Surface(this.surfaceTexture);
        }
    }

    private final synchronized void releaseSurface() {
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
        }
        this.surfaceTexture = null;
        this.surface = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getHasSetUsing() {
        return this.hasSetUsing;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final BaseRecordContext getRecordContextWithCheck(@NotNull String recordKey) {
        BaseRecordContext baseRecordContext;
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        synchronized (this.recordContexts) {
            baseRecordContext = this.recordContexts.get(recordKey);
        }
        if (baseRecordContext == null) {
            return null;
        }
        if (baseRecordContext.getForceStopped()) {
            ZLog.f386189b.p(TAG, recordKey, new StackPrinter("getRecordContextWithCheck forceStopped!"));
            return null;
        }
        return baseRecordContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final IZPlanRecordCallback.Stub getZPlanRecordCallback() {
        return this.zPlanRecordCallback;
    }

    @Override // com.tencent.zplan.meme.recorder.a
    public void onDestroy() {
        ZLog zLog = ZLog.f386189b;
        zLog.k(TAG, "onDestroy, hasSetUsing:" + this.hasSetUsing);
        if (this.hasSetUsing) {
            zLog.f(TAG, "setZPlanSceneStatus false");
            ZPlanServiceHelper.I.Q0(false);
        }
        destroyEngine();
        releaseSurface();
        this.hasSetUsing = false;
    }

    public final void removeRecordContext$zplan_debug(@NotNull String recordKey) {
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        synchronized (this.recordContexts) {
            this.recordContexts.remove(recordKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setHasSetUsing(boolean z16) {
        this.hasSetUsing = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setRecordContext(@NotNull String recordKey, @NotNull BaseRecordContext recordContext) {
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        Intrinsics.checkNotNullParameter(recordContext, "recordContext");
        synchronized (this.recordContexts) {
            this.recordContexts.put(recordKey, recordContext);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void stopAction(@NotNull MemeAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        ZLog.f386189b.k(TAG, "stopAction, action:" + action.getDesc());
        BaseRecordContext recordContextWithCheck = getRecordContextWithCheck(action.getKey());
        if (recordContextWithCheck != null) {
            recordContextWithCheck.l();
        }
    }
}
