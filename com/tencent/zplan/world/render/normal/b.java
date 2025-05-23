package com.tencent.zplan.world.render.normal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.c;
import com.tencent.zplan.engine.ZPlanIPCHelper;
import com.tencent.zplan.engine.service.EngineLifeCycleReporter;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.model.FirstFrameResult;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0003\u0012\u001a)B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b&\u0010'J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J2\u0010\u0012\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J$\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u001d\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/zplan/world/render/normal/b;", "Lcom/tencent/zplan/world/render/normal/a;", "", "sceneType", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "listener", "", "r", ReportConstant.COSTREPORT_PREFIX, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "context", "", "needEvent", TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, "useSurfaceView", "Landroid/view/View;", "b", "resume", "destroy", "hasFocus", "a", "H", "", "sceneParams", "c", "i", "Z", "setUsingSuccess", "j", "renderDestroy", "k", "setFocusStateSuccess", "Lcom/tencent/zplan/engine/b;", "l", "Lcom/tencent/zplan/engine/b;", "mainProcessEngineStatusUpdateListener", "<init>", "(Landroid/content/Context;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class b extends com.tencent.zplan.world.render.normal.a {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean setUsingSuccess;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private volatile boolean renderDestroy;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean setFocusStateSuccess;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private com.tencent.zplan.engine.b mainProcessEngineStatusUpdateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/world/render/normal/b$a", "Lcom/tencent/zplan/engine/b;", "", UploadQualityReportBuilder.STATE_CONNECT, "", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements com.tencent.zplan.engine.b {
        a() {
        }

        @Override // com.tencent.zplan.engine.b
        public void a(boolean connect) {
            ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
            zPlanIPCHelper.C();
            ZLog zLog = ZLog.f386189b;
            zLog.k("PeakProcessNormalRender", "PeakProcessNormalRender serviceConnected " + connect);
            if (!b.this.setUsingSuccess && connect && !b.this.renderDestroy) {
                zLog.k("PeakProcessNormalRender", "PeakProcessNormalRender setIsUsing true, serviceConnected");
                b.this.setUsingSuccess = zPlanIPCHelper.D(true);
            }
            if (b.this.getSetFocusState() != null && !b.this.setFocusStateSuccess && connect && !b.this.renderDestroy) {
                zLog.k("PeakProcessNormalRender", "PeakProcessNormalRender send N2L_SetFocusState, serviceConnected");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bGetFocus", b.this.getSetFocusState());
                com.tencent.zplan.luabridge.a k3 = zPlanIPCHelper.k();
                if (k3 != null) {
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "state.toString()");
                    a.C10063a.c(k3, "N2L_SetFocusState", jSONObject2, null, true, 4, null);
                }
                b.this.setFocusStateSuccess = true;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/zplan/world/render/normal/b$c;", "Lcom/tencent/zplan/c$a;", "", AdMetricTag.EVENT_NAME, "params", "", "callbackId", "t0", "d", "I", "type", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/zplan/world/render/normal/b;", "e", "Ljava/lang/ref/WeakReference;", "weakRender", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "f", "weakListener", "<init>", "(ILjava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c extends c.a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<b> weakRender;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<IZPlanWorldStatusListener> weakListener;

        public c(int i3, @NotNull WeakReference<b> weakRender, @NotNull WeakReference<IZPlanWorldStatusListener> weakListener) {
            Intrinsics.checkNotNullParameter(weakRender, "weakRender");
            Intrinsics.checkNotNullParameter(weakListener, "weakListener");
            this.type = i3;
            this.weakRender = weakRender;
            this.weakListener = weakListener;
        }

        @Override // com.tencent.zplan.c
        @NotNull
        public String t0(@Nullable String eventName, @Nullable String params, int callbackId) {
            String str;
            com.tencent.zplan.model.a i3;
            b bVar = this.weakRender.get();
            IZPlanWorldStatusListener iZPlanWorldStatusListener = this.weakListener.get();
            EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("zplan_enter_scene");
            if (bVar != null) {
                str = bVar.getRenderHashCode();
            } else {
                str = null;
            }
            sb5.append(str);
            EngineLifeCycleReporter.k(engineLifeCycleReporter, sb5.toString(), "enter_scene", null, 4, null);
            boolean optBoolean = new JSONObject(params).optBoolean("EnterLevel", false);
            if (iZPlanWorldStatusListener != null) {
                iZPlanWorldStatusListener.onEnterSceneResult(optBoolean);
            }
            if (optBoolean && bVar != null && (i3 = bVar.i()) != null) {
                i3.b(this.type);
            }
            ZLog.f386189b.k("PeakProcessNormalRender", "PeakProcessNormalRender registerEnterSceneResultEvent LuaCallback: " + eventName + TokenParser.SP + params);
            return "";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/zplan/world/render/normal/b$d;", "Lcom/tencent/zplan/c$a;", "", AdMetricTag.EVENT_NAME, "params", "", "callbackId", "t0", "d", "I", "sceneType", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/zplan/world/render/normal/b;", "e", "Ljava/lang/ref/WeakReference;", "weakRender", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "f", "weakListener", "<init>", "(ILjava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class d extends c.a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int sceneType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<b> weakRender;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<IZPlanWorldStatusListener> weakListener;

        public d(int i3, @NotNull WeakReference<b> weakRender, @NotNull WeakReference<IZPlanWorldStatusListener> weakListener) {
            Intrinsics.checkNotNullParameter(weakRender, "weakRender");
            Intrinsics.checkNotNullParameter(weakListener, "weakListener");
            this.sceneType = i3;
            this.weakRender = weakRender;
            this.weakListener = weakListener;
        }

        @Override // com.tencent.zplan.c
        @NotNull
        public String t0(@Nullable String eventName, @Nullable String params, int callbackId) {
            String str;
            String str2;
            com.tencent.zplan.model.a i3;
            Boolean setFocusState;
            b bVar = this.weakRender.get();
            IZPlanWorldStatusListener iZPlanWorldStatusListener = this.weakListener.get();
            EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("zplan_enter_scene");
            if (bVar != null) {
                str = bVar.getRenderHashCode();
            } else {
                str = null;
            }
            sb5.append(str);
            EngineLifeCycleReporter.k(engineLifeCycleReporter, sb5.toString(), "enter_scene_end", null, 4, null);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("zplan_enter_scene");
            if (bVar != null) {
                str2 = bVar.getRenderHashCode();
            } else {
                str2 = null;
            }
            sb6.append(str2);
            EngineLifeCycleReporter.t(engineLifeCycleReporter, sb6.toString(), false, 2, null);
            if (bVar != null && (setFocusState = bVar.getSetFocusState()) != null) {
                bVar.a(setFocusState.booleanValue());
            }
            ZLog.f386189b.k("PeakProcessNormalRender", "onLuaEvent eventName:" + eventName + ", params: " + params);
            if (iZPlanWorldStatusListener != null) {
                iZPlanWorldStatusListener.onFirstFrame(new FirstFrameResult(this.sceneType, null, 2, null));
            }
            if (bVar != null && (i3 = bVar.i()) != null) {
                i3.d(this.sceneType);
                return "";
            }
            return "";
        }
    }

    public b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
        zPlanIPCHelper.C();
        this.setUsingSuccess = zPlanIPCHelper.D(true);
        ZLog.f386189b.k("PeakProcessNormalRender", "PeakProcessNormalRender init setUsingSuccess: " + this.setUsingSuccess + ", setFocusStateSuccess: " + this.setFocusStateSuccess + ", setFocusState: " + getSetFocusState());
        if (!this.setUsingSuccess || !this.setFocusStateSuccess) {
            a aVar = new a();
            this.mainProcessEngineStatusUpdateListener = aVar;
            Intrinsics.checkNotNull(aVar);
            zPlanIPCHelper.w(aVar);
        }
    }

    private final void r(int sceneType, IZPlanWorldStatusListener listener) {
        ZPlanIPCHelper.f385519j.q("L2N_LightEnterLevel", new c(sceneType, new WeakReference(this), new WeakReference(listener)));
        ZLog.f386189b.k("PeakProcessNormalRender", "PeakProcessNormalRender registerEnterSceneResultEvent: " + listener);
    }

    private final void s(int sceneType, IZPlanWorldStatusListener listener) {
        ZPlanIPCHelper.f385519j.q("L2N_LightFirstFrame", new d(sceneType, new WeakReference(this), new WeakReference(listener)));
        ZLog.f386189b.k("PeakProcessNormalRender", "PeakProcessNormalRender registerFirstFrameEvent: " + listener);
    }

    @Override // dy4.a
    public void H() {
        ZLog.f386189b.k("PeakProcessNormalRender", "setViewportFull not support");
    }

    @Override // com.tencent.zplan.world.render.normal.a, dy4.a
    public void a(boolean hasFocus) {
        super.a(hasFocus);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bGetFocus", hasFocus);
        com.tencent.zplan.luabridge.a k3 = ZPlanIPCHelper.f385519j.k();
        if (k3 != null) {
            ZLog.f386189b.k("PeakProcessNormalRender", "PeakProcessNormalRender send N2L_SetFocusState, setFocusState, " + new StackPrinter("setFocusState"));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "state.toString()");
            a.C10063a.c(k3, "N2L_SetFocusState", jSONObject2, null, true, 4, null);
            this.setFocusStateSuccess = true;
            return;
        }
        this.setFocusStateSuccess = false;
    }

    @Override // com.tencent.zplan.world.render.normal.a, dy4.a
    @NotNull
    public View b(@Nullable Activity activity, @NotNull Context context, boolean needEvent, boolean opaque, boolean useSurfaceView) {
        Intrinsics.checkNotNullParameter(context, "context");
        ZPlanIPCHelper.f385519j.C();
        return super.b(activity, context, needEvent, opaque, useSurfaceView);
    }

    @Override // com.tencent.zplan.world.render.normal.a, dy4.a
    public void c(int sceneType, @Nullable String sceneParams, @Nullable IZPlanWorldStatusListener listener) {
        super.c(sceneType, sceneParams, listener);
        ZLog zLog = ZLog.f386189b;
        zLog.k("PeakProcessNormalRender", "PeakProcessNormalRender enterAvatarScene");
        JSONObject jSONObject = new JSONObject(sceneParams);
        if (jSONObject.has("MapName") && jSONObject.has("PakPath") && jSONObject.has("checkVersion")) {
            r(sceneType, listener);
            s(sceneType, listener);
            zLog.k("PeakProcessNormalRender", "PeakProcessNormalRender enterAvatarScene: registerFirstFrameEvent done");
            String optString = jSONObject.optString("PakPath", "");
            boolean optBoolean = jSONObject.optBoolean("checkVersion", false);
            ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
            zPlanIPCHelper.p(optString, optBoolean);
            zLog.k("PeakProcessNormalRender", "PeakProcessNormalRender enterAvatarScene: mount pak done");
            zPlanIPCHelper.t(jSONObject.optString("MapName", ""));
            zLog.k("PeakProcessNormalRender", "PeakProcessNormalRender enterAvatarScene: open level done");
            return;
        }
        zLog.k("PeakProcessNormalRender", "PeakProcessNormalRender enterAvatarScene: scene params is illegal!!!");
    }

    @Override // com.tencent.zplan.world.render.normal.a, dy4.a
    public void destroy() {
        this.renderDestroy = true;
        com.tencent.zplan.engine.b bVar = this.mainProcessEngineStatusUpdateListener;
        if (bVar != null) {
            ZPlanIPCHelper.f385519j.G(bVar);
        }
        this.mainProcessEngineStatusUpdateListener = null;
        if (this.setUsingSuccess) {
            ZLog.f386189b.k("PeakProcessNormalRender", "PeakProcessNormalRender setIsUsing false");
            ZPlanIPCHelper.f385519j.D(false);
        }
        this.setUsingSuccess = false;
        super.destroy();
    }

    @Override // com.tencent.zplan.world.render.normal.a, dy4.a
    public void resume() {
        ZPlanIPCHelper.f385519j.C();
        super.resume();
    }
}
