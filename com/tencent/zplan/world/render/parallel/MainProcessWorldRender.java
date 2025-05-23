package com.tencent.zplan.world.render.parallel;

import android.app.Activity;
import android.content.Context;
import android.view.Surface;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.IZPlanEnterSceneCallback;
import com.tencent.zplan.IZPlanWorldCallback;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.engine.service.EngineLifeCycleReporter;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.utils.ZPlanConstant;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.model.FirstFrameResult;
import com.tencent.zplan.world.model.ZPlanWorld;
import com.tencent.zplan.world.view.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 =2\u00020\u0001:\u0002\u0013>B\u0019\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u00109\u001a\u00020\u000e\u00a2\u0006\u0004\b;\u0010<J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J2\u0010\u0013\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J$\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J-\u0010 \u001a\u00020\b2#\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b\u0018\u00010\u001bH\u0014J\b\u0010!\u001a\u00020\bH\u0016J\u0018\u0010$\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0002H\u0016R\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010%R\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010%R!\u00103\u001a\b\u0012\u0004\u0012\u00020(0.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00107R\u0017\u00109\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b!\u0010%\u001a\u0004\b9\u0010:\u00a8\u0006?"}, d2 = {"Lcom/tencent/zplan/world/render/parallel/MainProcessWorldRender;", "Lcom/tencent/zplan/world/render/parallel/AbsZPlanWorldRender;", "", "sceneType", "", "sceneParams", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "listener", "", "D", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "context", "", "needEvent", TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, "useSurfaceView", "Landroid/view/View;", "b", "pause", "resume", "hasFocus", "a", "H", "destroy", "e", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "afterInit", "o", "u", "width", "height", "p", "Z", "setUsingSuccess", "setFocusStateSuccess", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "mainProcessEngineStatusUpdateListener", "r", "renderDestroy", "", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Lazy;", UserInfo.SEX_FEMALE, "()Ljava/util/List;", "zPlanEngineStatusUpdateListenerList", "Ljava/util/concurrent/locks/ReentrantLock;", "t", "E", "()Ljava/util/concurrent/locks/ReentrantLock;", "listenerLock", "isGame", "()Z", "<init>", "(Landroid/content/Context;Z)V", "v", "MainProcessEnterSceneCallback", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class MainProcessWorldRender extends AbsZPlanWorldRender {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean setUsingSuccess;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean setFocusStateSuccess;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private ZPlanEngineStatusUpdateListener mainProcessEngineStatusUpdateListener;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private volatile boolean renderDestroy;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final Lazy zPlanEngineStatusUpdateListenerList;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final Lazy listenerLock;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final boolean isGame;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/zplan/world/render/parallel/MainProcessWorldRender$MainProcessEnterSceneCallback;", "Lcom/tencent/zplan/IZPlanEnterSceneCallback$Stub;", "weakRender", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/zplan/world/render/parallel/MainProcessWorldRender;", "weakListener", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "sceneType", "", "(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;I)V", "onEnterSceneResult", "", "success", "", "onFirstFrame", "result", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class MainProcessEnterSceneCallback extends IZPlanEnterSceneCallback.Stub {
        private final int sceneType;
        private final WeakReference<IZPlanWorldStatusListener> weakListener;
        private final WeakReference<MainProcessWorldRender> weakRender;

        public MainProcessEnterSceneCallback(@NotNull WeakReference<MainProcessWorldRender> weakRender, @NotNull WeakReference<IZPlanWorldStatusListener> weakListener, int i3) {
            Intrinsics.checkNotNullParameter(weakRender, "weakRender");
            Intrinsics.checkNotNullParameter(weakListener, "weakListener");
            this.weakRender = weakRender;
            this.weakListener = weakListener;
            this.sceneType = i3;
        }

        @Override // com.tencent.zplan.IZPlanEnterSceneCallback
        public void onEnterSceneResult(boolean success) {
            MainProcessWorldRender mainProcessWorldRender;
            WeakReference<MainProcessWorldRender> weakReference = this.weakRender;
            IZPlanWorldStatusListener iZPlanWorldStatusListener = null;
            if (weakReference != null) {
                mainProcessWorldRender = weakReference.get();
            } else {
                mainProcessWorldRender = null;
            }
            WeakReference<IZPlanWorldStatusListener> weakReference2 = this.weakListener;
            if (weakReference2 != null) {
                iZPlanWorldStatusListener = weakReference2.get();
            }
            ZLog.f386189b.k("MainProcessWorldRender", "onEnterSceneResult success : " + success + ", listener: " + iZPlanWorldStatusListener + ", worldRender: " + mainProcessWorldRender);
            if (mainProcessWorldRender != null) {
                EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
                EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_enter_scene" + mainProcessWorldRender.getReportRenderHashCode(), "enter_scene", null, 4, null);
                EngineLifeCycleReporter.k(engineLifeCycleReporter, "main_process_render", "enter_scene_result", null, 4, null);
                if (success) {
                    mainProcessWorldRender.l().b(this.sceneType);
                }
            }
            if (iZPlanWorldStatusListener != null) {
                iZPlanWorldStatusListener.onEnterSceneResult(success);
            }
        }

        @Override // com.tencent.zplan.IZPlanEnterSceneCallback
        public void onFirstFrame(@NotNull FirstFrameResult result) {
            MainProcessWorldRender mainProcessWorldRender;
            IZPlanWorldStatusListener iZPlanWorldStatusListener;
            Intrinsics.checkNotNullParameter(result, "result");
            WeakReference<MainProcessWorldRender> weakReference = this.weakRender;
            if (weakReference != null) {
                mainProcessWorldRender = weakReference.get();
            } else {
                mainProcessWorldRender = null;
            }
            WeakReference<IZPlanWorldStatusListener> weakReference2 = this.weakListener;
            if (weakReference2 != null) {
                iZPlanWorldStatusListener = weakReference2.get();
            } else {
                iZPlanWorldStatusListener = null;
            }
            ZLog.f386189b.k("MainProcessWorldRender", "onFirstFrame result : " + result + ", listener: " + iZPlanWorldStatusListener + ", worldRender: " + mainProcessWorldRender);
            if (mainProcessWorldRender != null) {
                EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
                EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_enter_scene" + mainProcessWorldRender.getReportRenderHashCode(), "enter_scene_end", null, 4, null);
                EngineLifeCycleReporter.t(engineLifeCycleReporter, "zplan_enter_scene" + mainProcessWorldRender.getReportRenderHashCode(), false, 2, null);
                EngineLifeCycleReporter.k(engineLifeCycleReporter, "main_process_render", "enter_scnen_first_frame", null, 4, null);
                engineLifeCycleReporter.s("main_process_render", true);
                Boolean setFocusState = mainProcessWorldRender.getSetFocusState();
                if (setFocusState != null) {
                    mainProcessWorldRender.a(setFocusState.booleanValue());
                }
                mainProcessWorldRender.l().d(result.getCurType());
            }
            if (iZPlanWorldStatusListener != null) {
                iZPlanWorldStatusListener.onFirstFrame(result);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/world/render/parallel/MainProcessWorldRender$a", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", UploadQualityReportBuilder.STATE_CONNECT, "", "serviceConnected", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements ZPlanEngineStatusUpdateListener {
        a() {
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
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void hotPatchDownloadFailed(int i3, @NotNull String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            ZPlanEngineStatusUpdateListener.a.h(this, i3, errorMessage);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void serviceConnected(boolean connect) {
            ZPlanEngineStatusUpdateListener.a.i(this, connect);
            ZLog zLog = ZLog.f386189b;
            zLog.k("MainProcessWorldRender", "serviceConnected " + connect);
            if (connect) {
                if (!MainProcessWorldRender.this.setUsingSuccess && !MainProcessWorldRender.this.renderDestroy) {
                    zLog.k("MainProcessWorldRender", "MainProcessWorldRender setIsUsing true, serviceConnected");
                    MainProcessWorldRender.this.setUsingSuccess = ZPlanServiceHelper.I.Q0(true);
                }
                if (MainProcessWorldRender.this.getSetFocusState() != null && !MainProcessWorldRender.this.setFocusStateSuccess && !MainProcessWorldRender.this.renderDestroy) {
                    zLog.k("MainProcessWorldRender", "MainProcessWorldRender send N2L_SetFocusState, serviceConnected");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("bGetFocus", MainProcessWorldRender.this.getSetFocusState());
                    com.tencent.zplan.luabridge.a S = ZPlanServiceHelper.I.S();
                    if (S != null) {
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "state.toString()");
                        a.C10063a.c(S, "N2L_SetFocusState", jSONObject2, null, true, 4, null);
                    }
                    MainProcessWorldRender.this.setFocusStateSuccess = true;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"com/tencent/zplan/world/render/parallel/MainProcessWorldRender$queryEngineInitStatus$1$listener$1", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", "success", "", "engineInitFinish", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c implements ZPlanEngineStatusUpdateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1 f386386e;

        c(Function1 function1) {
            this.f386386e = function1;
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
        public void engineInitFinish(boolean success) {
            ZPlanEngineStatusUpdateListener.a.c(this, success);
            MainProcessWorldRender.this.s(success);
            ZLog.f386189b.k("MainProcessWorldRender", "queryEngineInitStatus engineInitFinish:" + success);
            this.f386386e.invoke(Boolean.valueOf(success));
            ZPlanServiceHelper.I.a1(this);
            ReentrantLock E = MainProcessWorldRender.this.E();
            E.lock();
            try {
                MainProcessWorldRender.this.F().remove(this);
            } finally {
                E.unlock();
            }
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
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void hotPatchDownloadFailed(int i3, @NotNull String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            ZPlanEngineStatusUpdateListener.a.h(this, i3, errorMessage);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void serviceConnected(boolean z16) {
            ZPlanEngineStatusUpdateListener.a.i(this, z16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainProcessWorldRender(@NotNull Context context, boolean z16) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.isGame = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<ZPlanEngineStatusUpdateListener>>() { // from class: com.tencent.zplan.world.render.parallel.MainProcessWorldRender$zPlanEngineStatusUpdateListenerList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<ZPlanEngineStatusUpdateListener> invoke() {
                return new ArrayList();
            }
        });
        this.zPlanEngineStatusUpdateListenerList = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ReentrantLock>() { // from class: com.tencent.zplan.world.render.parallel.MainProcessWorldRender$listenerLock$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ReentrantLock invoke() {
                return new ReentrantLock();
            }
        });
        this.listenerLock = lazy2;
        ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
        this.setUsingSuccess = zPlanServiceHelper.Q0(true);
        ZLog.f386189b.k("MainProcessWorldRender", "MainProcessWorldRender init setUsingSuccess: " + this.setUsingSuccess + ", setFocusStateSuccess: " + this.setFocusStateSuccess + ", setFocusState: " + getSetFocusState() + ", renderHashCode: " + getRenderHashCode());
        if (!this.setUsingSuccess || !this.setFocusStateSuccess) {
            a aVar = new a();
            this.mainProcessEngineStatusUpdateListener = aVar;
            Intrinsics.checkNotNull(aVar);
            zPlanServiceHelper.E0(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(int sceneType, String sceneParams, IZPlanWorldStatusListener listener) {
        int i3;
        Surface surface;
        EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
        EngineLifeCycleReporter.k(engineLifeCycleReporter, "main_process_render", "get_zplan_world_end", null, 4, null);
        ZLog.f386189b.k("MainProcessWorldRender", "doEntertAvatarScene sceneType : " + sceneType + ", sceneParams: " + sceneParams + ", listener: " + listener);
        u();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("enter_scene_type", String.valueOf(sceneType));
        engineLifeCycleReporter.j("main_process_render", "do_enter_scene", hashMap);
        ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
        zPlanServiceHelper.L(getWorldID(), sceneType, sceneParams, new MainProcessEnterSceneCallback(new WeakReference(this), new WeakReference(listener), sceneType));
        int worldID = getWorldID();
        com.tencent.zplan.world.view.c renderView = getRenderView();
        int i16 = 0;
        if (renderView != null) {
            i3 = renderView.getViewWidth();
        } else {
            i3 = 0;
        }
        com.tencent.zplan.world.view.c renderView2 = getRenderView();
        if (renderView2 != null) {
            i16 = renderView2.getViewHeight();
        }
        com.tencent.zplan.world.view.c renderView3 = getRenderView();
        if (renderView3 != null) {
            surface = renderView3.getSurface();
        } else {
            surface = null;
        }
        zPlanServiceHelper.M(worldID, i3, i16, surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReentrantLock E() {
        return (ReentrantLock) this.listenerLock.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ZPlanEngineStatusUpdateListener> F() {
        return (List) this.zPlanEngineStatusUpdateListenerList.getValue();
    }

    @Override // dy4.a
    public void H() {
        ZLog.f386189b.k("MainProcessWorldRender", "setViewportFull not support, worldID:" + getWorldID());
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender, dy4.a
    public void a(boolean hasFocus) {
        super.a(hasFocus);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bGetFocus", hasFocus);
        com.tencent.zplan.luabridge.a S = ZPlanServiceHelper.I.S();
        if (S != null) {
            ZLog.f386189b.k("MainProcessWorldRender", "MainProcessWorldRender send N2L_SetFocusState, setFocusState, " + new StackPrinter("setFocusState"));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "state.toString()");
            a.C10063a.c(S, "N2L_SetFocusState", jSONObject2, null, true, 4, null);
            this.setFocusStateSuccess = true;
            return;
        }
        this.setFocusStateSuccess = false;
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender, dy4.a
    @NotNull
    public View b(@Nullable Activity activity, @NotNull Context context, boolean needEvent, boolean opaque, boolean useSurfaceView) {
        Intrinsics.checkNotNullParameter(context, "context");
        ZLog.f386189b.k("MainProcessWorldRender" + ZPlanConstant.f386195f.b(), "getView , renderHashCode: " + getRenderHashCode());
        ZPlanServiceHelper.I.P0();
        return super.b(activity, context, needEvent, opaque, useSurfaceView);
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender, dy4.a
    public void destroy() {
        ZLog zLog = ZLog.f386189b;
        zLog.k("MainProcessWorldRender" + ZPlanConstant.f386195f.b(), "destroy, worldID:" + getWorldID() + ", renderHashCode: " + getRenderHashCode() + ", " + new StackPrinter("destroy"));
        this.renderDestroy = true;
        if (this.isGame) {
            zLog.k("MainProcessWorldRender", "destroy, main world, do nothing, mWorldID :" + getWorldID());
        } else {
            zLog.k("MainProcessWorldRender", "destroy renderHashCode: " + getRenderHashCode() + ", this: " + this);
            ZPlanServiceHelper.I.J(getRenderHashCode(), getWorldID());
        }
        ReentrantLock E = E();
        E.lock();
        try {
            Iterator<ZPlanEngineStatusUpdateListener> it = F().iterator();
            while (it.hasNext()) {
                ZPlanServiceHelper.I.a1(it.next());
            }
            F().clear();
            Unit unit = Unit.INSTANCE;
            E.unlock();
            ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener = this.mainProcessEngineStatusUpdateListener;
            if (zPlanEngineStatusUpdateListener != null) {
                ZPlanServiceHelper.I.a1(zPlanEngineStatusUpdateListener);
            }
            this.mainProcessEngineStatusUpdateListener = null;
            if (this.setUsingSuccess) {
                ZLog.f386189b.k("MainProcessWorldRender", "MainProcessWorldRender setIsUsing false");
                ZPlanServiceHelper.I.Q0(false);
            }
            super.destroy();
        } catch (Throwable th5) {
            E.unlock();
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender
    public void e(final int sceneType, @Nullable final String sceneParams, @Nullable final IZPlanWorldStatusListener listener) {
        int i3;
        EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
        EngineLifeCycleReporter.k(engineLifeCycleReporter, "main_process_render", "enter_scene", null, 4, null);
        EngineLifeCycleReporter.k(engineLifeCycleReporter, "main_process_render", "get_zplan_world", null, 4, null);
        int i16 = 0;
        if (this.isGame) {
            t(0);
        }
        if (getWorldID() == -1) {
            ZLog.f386189b.k("MainProcessWorldRender", "enterAvatarSceneAfterEngineInitDone renderHashCode: " + getRenderHashCode() + ", this: " + this);
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            int renderHashCode = getRenderHashCode();
            com.tencent.zplan.world.view.c renderView = getRenderView();
            if (renderView != null) {
                i3 = renderView.getViewWidth();
            } else {
                i3 = 0;
            }
            com.tencent.zplan.world.view.c renderView2 = getRenderView();
            if (renderView2 != null) {
                i16 = renderView2.getViewHeight();
            }
            zPlanServiceHelper.f0(renderHashCode, sceneType, i3, i16, new IZPlanWorldCallback.Stub() { // from class: com.tencent.zplan.world.render.parallel.MainProcessWorldRender$enterAvatarSceneAfterEngineInitDone$1
                @Override // com.tencent.zplan.IZPlanWorldCallback
                public void onGetZPlanWorld(@Nullable ZPlanWorld zplanWorld) {
                    ZLog.f386189b.k("MainProcessWorldRender", "onGetZPlanWorld zplanWorld: " + zplanWorld);
                    if (zplanWorld == null) {
                        IZPlanWorldStatusListener iZPlanWorldStatusListener = listener;
                        if (iZPlanWorldStatusListener != null) {
                            iZPlanWorldStatusListener.onEnterSceneResult(false);
                            return;
                        }
                        return;
                    }
                    MainProcessWorldRender.this.t(zplanWorld.getWorldID());
                    c renderView3 = MainProcessWorldRender.this.getRenderView();
                    if (renderView3 != null) {
                        renderView3.setWorldID(MainProcessWorldRender.this.getWorldID());
                    }
                    MainProcessWorldRender.this.D(sceneType, sceneParams, listener);
                }
            });
            return;
        }
        com.tencent.zplan.world.view.c renderView3 = getRenderView();
        if (renderView3 != null) {
            renderView3.setWorldID(getWorldID());
        }
        D(sceneType, sceneParams, listener);
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender
    protected void o(@Nullable Function1<? super Boolean, Unit> afterInit) {
        if (afterInit != null) {
            if (getEngineInitDone()) {
                ZLog.f386189b.k("MainProcessWorldRender", "queryEngineInitStatus engineInitDone");
                afterInit.invoke(Boolean.TRUE);
                return;
            }
            c cVar = new c(afterInit);
            ZPlanServiceHelper.I.E0(cVar);
            ReentrantLock E = E();
            E.lock();
            try {
                F().add(cVar);
            } finally {
                E.unlock();
            }
        }
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender
    public void p(int width, int height) {
        Surface surface;
        if (getWorldID() == -1) {
            return;
        }
        ZLog.f386189b.k("MainProcessWorldRender", "resizeWorldSize worldID:" + getWorldID() + ", width:" + width + ", height:" + height);
        ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
        zPlanServiceHelper.I0(getWorldID(), width, height);
        int worldID = getWorldID();
        com.tencent.zplan.world.view.c renderView = getRenderView();
        if (renderView != null) {
            surface = renderView.getSurface();
        } else {
            surface = null;
        }
        zPlanServiceHelper.M(worldID, width, height, surface);
    }

    @Override // dy4.a
    public void pause() {
        ZLog.f386189b.k("MainProcessWorldRender" + ZPlanConstant.f386195f.b(), "pause, worldID:" + getWorldID() + ", renderHashCode: " + getRenderHashCode() + ", " + new StackPrinter("pause"));
        ZPlanServiceHelper.I.y0(getWorldID());
    }

    @Override // dy4.a
    public void resume() {
        o(new Function1<Boolean, Unit>() { // from class: com.tencent.zplan.world.render.parallel.MainProcessWorldRender$resume$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    ZLog.f386189b.k("MainProcessWorldRender" + ZPlanConstant.f386195f.b(), "resume, worldID:" + MainProcessWorldRender.this.getWorldID() + ", renderHashCode: " + MainProcessWorldRender.this.getRenderHashCode() + ", " + new StackPrinter("resume"));
                    ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
                    zPlanServiceHelper.P0();
                    zPlanServiceHelper.N0(MainProcessWorldRender.this.getWorldID());
                    MainProcessWorldRender.this.u();
                }
            }
        });
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender
    public void u() {
        Surface surface;
        Surface surface2;
        int i3;
        ZLog zLog = ZLog.f386189b;
        zLog.k("MainProcessWorldRender", "setWorldTexture worldID:" + getWorldID());
        if (getWorldID() == -1) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setWorldTexture worldID:");
        sb5.append(getWorldID());
        sb5.append(", surface:");
        com.tencent.zplan.world.view.c renderView = getRenderView();
        if (renderView != null) {
            surface = renderView.getSurface();
        } else {
            surface = null;
        }
        sb5.append(surface);
        zLog.k("MainProcessWorldRender", sb5.toString());
        com.tencent.zplan.world.view.c renderView2 = getRenderView();
        if (renderView2 != null && (surface2 = renderView2.getSurface()) != null) {
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            int worldID = getWorldID();
            com.tencent.zplan.world.view.c renderView3 = getRenderView();
            int i16 = 0;
            if (renderView3 != null) {
                i3 = renderView3.getViewWidth();
            } else {
                i3 = 0;
            }
            com.tencent.zplan.world.view.c renderView4 = getRenderView();
            if (renderView4 != null) {
                i16 = renderView4.getViewHeight();
            }
            zPlanServiceHelper.M(worldID, i3, i16, surface2);
        }
    }
}
