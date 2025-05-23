package com.tencent.zplan.world.render.normal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.IZPlanEnterSceneCallback;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.engine.service.EngineLifeCycleReporter;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.model.FirstFrameResult;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b$\u0010%J2\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J$\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/zplan/world/render/normal/MainProcessNormalRender;", "Lcom/tencent/zplan/world/render/normal/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "context", "", "needEvent", TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, "useSurfaceView", "Landroid/view/View;", "b", "", "resume", "destroy", "", "sceneType", "", "sceneParams", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "listener", "c", "hasFocus", "a", "H", "i", "Z", "setUsingSuccess", "j", "renderDestroy", "k", "setFocusStateSuccess", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "l", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "mainProcessEngineStatusUpdateListener", "<init>", "(Landroid/content/Context;)V", "MainProcessEnterSceneCallback", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class MainProcessNormalRender extends com.tencent.zplan.world.render.normal.a {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean setUsingSuccess;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private volatile boolean renderDestroy;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean setFocusStateSuccess;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private ZPlanEngineStatusUpdateListener mainProcessEngineStatusUpdateListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/zplan/world/render/normal/MainProcessNormalRender$MainProcessEnterSceneCallback;", "Lcom/tencent/zplan/IZPlanEnterSceneCallback$Stub;", "weakRender", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/zplan/world/render/normal/MainProcessNormalRender;", "weakListener", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "onEnterSceneResult", "", "success", "", "onFirstFrame", "result", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class MainProcessEnterSceneCallback extends IZPlanEnterSceneCallback.Stub {
        private final WeakReference<IZPlanWorldStatusListener> weakListener;
        private final WeakReference<MainProcessNormalRender> weakRender;

        public MainProcessEnterSceneCallback(@NotNull WeakReference<MainProcessNormalRender> weakRender, @NotNull WeakReference<IZPlanWorldStatusListener> weakListener) {
            Intrinsics.checkNotNullParameter(weakRender, "weakRender");
            Intrinsics.checkNotNullParameter(weakListener, "weakListener");
            this.weakRender = weakRender;
            this.weakListener = weakListener;
        }

        @Override // com.tencent.zplan.IZPlanEnterSceneCallback
        public void onEnterSceneResult(boolean success) {
            IZPlanWorldStatusListener iZPlanWorldStatusListener;
            WeakReference<IZPlanWorldStatusListener> weakReference = this.weakListener;
            String str = null;
            if (weakReference != null) {
                iZPlanWorldStatusListener = weakReference.get();
            } else {
                iZPlanWorldStatusListener = null;
            }
            ZLog.f386189b.k("AbsZPlanNormalRender", "onEnterSceneResult success : " + success + ", listener: " + iZPlanWorldStatusListener);
            EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("zplan_enter_scene");
            MainProcessNormalRender mainProcessNormalRender = this.weakRender.get();
            if (mainProcessNormalRender != null) {
                str = mainProcessNormalRender.getRenderHashCode();
            }
            sb5.append(str);
            EngineLifeCycleReporter.k(engineLifeCycleReporter, sb5.toString(), "enter_scene", null, 4, null);
            if (iZPlanWorldStatusListener != null) {
                iZPlanWorldStatusListener.onEnterSceneResult(success);
            }
        }

        @Override // com.tencent.zplan.IZPlanEnterSceneCallback
        public void onFirstFrame(@NotNull FirstFrameResult result) {
            MainProcessNormalRender mainProcessNormalRender;
            IZPlanWorldStatusListener iZPlanWorldStatusListener;
            Intrinsics.checkNotNullParameter(result, "result");
            WeakReference<MainProcessNormalRender> weakReference = this.weakRender;
            if (weakReference != null) {
                mainProcessNormalRender = weakReference.get();
            } else {
                mainProcessNormalRender = null;
            }
            WeakReference<IZPlanWorldStatusListener> weakReference2 = this.weakListener;
            if (weakReference2 != null) {
                iZPlanWorldStatusListener = weakReference2.get();
            } else {
                iZPlanWorldStatusListener = null;
            }
            ZLog.f386189b.k("AbsZPlanNormalRender", "onFirstFrame result : " + result + ", listener: " + iZPlanWorldStatusListener + ", normalRender: " + mainProcessNormalRender);
            if (mainProcessNormalRender != null) {
                EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
                EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_enter_scene" + mainProcessNormalRender.getRenderHashCode(), "enter_scene_end", null, 4, null);
                EngineLifeCycleReporter.t(engineLifeCycleReporter, "zplan_enter_scene" + mainProcessNormalRender.getRenderHashCode(), false, 2, null);
                Boolean setFocusState = mainProcessNormalRender.getSetFocusState();
                if (setFocusState != null) {
                    mainProcessNormalRender.a(setFocusState.booleanValue());
                }
                mainProcessNormalRender.i().d(result.getCurType());
            }
            if (iZPlanWorldStatusListener != null) {
                iZPlanWorldStatusListener.onFirstFrame(result);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/world/render/normal/MainProcessNormalRender$a", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", UploadQualityReportBuilder.STATE_CONNECT, "", "serviceConnected", "zplan_debug"}, k = 1, mv = {1, 4, 2})
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
            zLog.k("AbsZPlanNormalRender", "serviceConnected " + connect);
            if (connect) {
                if (!MainProcessNormalRender.this.setUsingSuccess && !MainProcessNormalRender.this.renderDestroy) {
                    zLog.k("AbsZPlanNormalRender", "MainProcessWorldRender setIsUsing true, serviceConnected");
                    MainProcessNormalRender.this.setUsingSuccess = ZPlanServiceHelper.I.Q0(true);
                }
                if (MainProcessNormalRender.this.getSetFocusState() != null && !MainProcessNormalRender.this.setFocusStateSuccess && !MainProcessNormalRender.this.renderDestroy) {
                    zLog.k("AbsZPlanNormalRender", "MainProcessWorldRender send N2L_SetFocusState, serviceConnected");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("bGetFocus", MainProcessNormalRender.this.getSetFocusState());
                    com.tencent.zplan.luabridge.a S = ZPlanServiceHelper.I.S();
                    if (S != null) {
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "state.toString()");
                        a.C10063a.c(S, "N2L_SetFocusState", jSONObject2, null, true, 4, null);
                    }
                    MainProcessNormalRender.this.setFocusStateSuccess = true;
                }
            }
        }
    }

    public MainProcessNormalRender(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
        zPlanServiceHelper.P0();
        this.setUsingSuccess = zPlanServiceHelper.Q0(true);
        ZLog.f386189b.k("AbsZPlanNormalRender", "MainProcessNormalRender init setUsingSuccess: " + this.setUsingSuccess + ", setFocusStateSuccess: " + this.setFocusStateSuccess + ", setFocusState: " + getSetFocusState());
        if (!this.setUsingSuccess || !this.setFocusStateSuccess) {
            a aVar = new a();
            this.mainProcessEngineStatusUpdateListener = aVar;
            Intrinsics.checkNotNull(aVar);
            zPlanServiceHelper.E0(aVar);
        }
    }

    @Override // dy4.a
    public void H() {
        ZLog.f386189b.k("AbsZPlanNormalRender", "setViewportFull ,renderHashCode: " + getRenderHashCode());
        ZPlanServiceHelper.I.V0();
    }

    @Override // com.tencent.zplan.world.render.normal.a, dy4.a
    public void a(boolean hasFocus) {
        super.a(hasFocus);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bGetFocus", hasFocus);
        com.tencent.zplan.luabridge.a S = ZPlanServiceHelper.I.S();
        if (S != null) {
            ZLog.f386189b.k("AbsZPlanNormalRender", "MainProcessNormalRender send N2L_SetFocusState, setFocusState, " + new StackPrinter("setFocusState"));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "state.toString()");
            a.C10063a.c(S, "N2L_SetFocusState", jSONObject2, null, true, 4, null);
            this.setFocusStateSuccess = true;
            return;
        }
        this.setFocusStateSuccess = false;
    }

    @Override // com.tencent.zplan.world.render.normal.a, dy4.a
    @NotNull
    public View b(@Nullable Activity activity, @NotNull Context context, boolean needEvent, boolean opaque, boolean useSurfaceView) {
        Intrinsics.checkNotNullParameter(context, "context");
        ZLog.f386189b.k("AbsZPlanNormalRender", "getView , renderHashCode: " + getRenderHashCode());
        ZPlanServiceHelper.I.P0();
        return super.b(activity, context, needEvent, opaque, useSurfaceView);
    }

    @Override // com.tencent.zplan.world.render.normal.a, dy4.a
    public void c(int sceneType, @Nullable String sceneParams, @Nullable IZPlanWorldStatusListener listener) {
        ZLog.f386189b.k("AbsZPlanNormalRender", "desenterAvatarScenetroy ,renderHashCode: " + getRenderHashCode());
        super.c(sceneType, sceneParams, listener);
        ZPlanServiceHelper.I.K(sceneType, e(sceneType, sceneParams).toString(), new MainProcessEnterSceneCallback(new WeakReference(this), new WeakReference(listener)));
        i().b(sceneType);
    }

    @Override // com.tencent.zplan.world.render.normal.a, dy4.a
    public void destroy() {
        ZLog zLog = ZLog.f386189b;
        zLog.k("AbsZPlanNormalRender", "destroy ,renderHashCode: " + getRenderHashCode());
        this.renderDestroy = true;
        ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener = this.mainProcessEngineStatusUpdateListener;
        if (zPlanEngineStatusUpdateListener != null) {
            ZPlanServiceHelper.I.a1(zPlanEngineStatusUpdateListener);
        }
        this.mainProcessEngineStatusUpdateListener = null;
        if (this.setUsingSuccess) {
            zLog.k("AbsZPlanNormalRender", "MainProcessNormalRender setIsUsing false");
            ZPlanServiceHelper.I.Q0(false);
        }
        this.setUsingSuccess = false;
        super.destroy();
    }

    @Override // com.tencent.zplan.world.render.normal.a, dy4.a
    public void resume() {
        ZLog.f386189b.k("AbsZPlanNormalRender", "resume ,renderHashCode: " + getRenderHashCode());
        ZPlanServiceHelper.I.P0();
        super.resume();
    }
}
