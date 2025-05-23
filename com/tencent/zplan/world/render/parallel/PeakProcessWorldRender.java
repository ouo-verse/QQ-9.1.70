package com.tencent.zplan.world.render.parallel;

import android.app.Activity;
import android.content.Context;
import android.view.Surface;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.IZPlanWorldCallback;
import com.tencent.zplan.c;
import com.tencent.zplan.engine.ZPlanIPCHelper;
import com.tencent.zplan.engine.b;
import com.tencent.zplan.engine.service.EngineLifeCycleReporter;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.model.FirstFrameResult;
import com.tencent.zplan.world.model.ZPlanWorld;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 42\u00020\u0001:\u0003\u001556B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u00101\u001a\u00020\u0010\u00a2\u0006\u0004\b2\u00103J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J2\u0010\u0015\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J-\u0010\u001d\u001a\u00020\b2#\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0018H\u0014J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\bH\u0016J$\u0010\"\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010#\u001a\u00020\bH\u0016J\u0018\u0010&\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0002H\u0016R\u0016\u0010(\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010'R\u0016\u0010)\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0017\u00101\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b.\u0010'\u001a\u0004\b/\u00100\u00a8\u00067"}, d2 = {"Lcom/tencent/zplan/world/render/parallel/PeakProcessWorldRender;", "Lcom/tencent/zplan/world/render/parallel/AbsZPlanWorldRender;", "", "sceneType", "", "sceneParams", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "listener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "context", "", "needEvent", TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, "useSurfaceView", "Landroid/view/View;", "b", "pause", "resume", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "afterInit", "o", "hasFocus", "a", "H", "destroy", "e", "u", "width", "height", "p", "Z", "setUsingSuccess", "renderDestroy", "Lcom/tencent/zplan/engine/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/zplan/engine/b;", "mainProcessEngineStatusUpdateListener", "r", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Z", "isGame", "<init>", "(Landroid/content/Context;Z)V", ReportConstant.COSTREPORT_PREFIX, "c", "d", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class PeakProcessWorldRender extends AbsZPlanWorldRender {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean setUsingSuccess;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private volatile boolean renderDestroy;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private b mainProcessEngineStatusUpdateListener;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final boolean isGame;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/world/render/parallel/PeakProcessWorldRender$a", "Lcom/tencent/zplan/engine/b;", "", UploadQualityReportBuilder.STATE_CONNECT, "", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements b {
        a() {
        }

        @Override // com.tencent.zplan.engine.b
        public void a(boolean connect) {
            ZLog zLog = ZLog.f386189b;
            zLog.k("PeakProcessWorldRender", "PeakProcessWorldRender serviceConnected " + connect);
            if (PeakProcessWorldRender.this.getIsGame() && !PeakProcessWorldRender.this.setUsingSuccess && connect && !PeakProcessWorldRender.this.renderDestroy) {
                zLog.k("PeakProcessWorldRender", "PeakProcessWorldRender setIsUsing true, serviceConnected");
                PeakProcessWorldRender.this.setUsingSuccess = ZPlanIPCHelper.f385519j.D(true);
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/zplan/world/render/parallel/PeakProcessWorldRender$c;", "Lcom/tencent/zplan/c$a;", "", AdMetricTag.EVENT_NAME, "params", "", "callbackId", "t0", "d", "I", "type", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/zplan/world/render/parallel/PeakProcessWorldRender;", "e", "Ljava/lang/ref/WeakReference;", "weakRender", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "f", "weakListener", "<init>", "(ILjava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c extends c.a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<PeakProcessWorldRender> weakRender;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<IZPlanWorldStatusListener> weakListener;

        public c(int i3, @NotNull WeakReference<PeakProcessWorldRender> weakRender, @NotNull WeakReference<IZPlanWorldStatusListener> weakListener) {
            Intrinsics.checkNotNullParameter(weakRender, "weakRender");
            Intrinsics.checkNotNullParameter(weakListener, "weakListener");
            this.type = i3;
            this.weakRender = weakRender;
            this.weakListener = weakListener;
        }

        @Override // com.tencent.zplan.c
        @NotNull
        public String t0(@Nullable String eventName, @Nullable String params, int callbackId) {
            Integer num;
            com.tencent.zplan.model.a l3;
            PeakProcessWorldRender peakProcessWorldRender = this.weakRender.get();
            IZPlanWorldStatusListener iZPlanWorldStatusListener = this.weakListener.get();
            EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("zplan_enter_scene");
            if (peakProcessWorldRender != null) {
                num = Integer.valueOf(peakProcessWorldRender.getRenderHashCode());
            } else {
                num = null;
            }
            sb5.append(num);
            EngineLifeCycleReporter.k(engineLifeCycleReporter, sb5.toString(), "enter_scene", null, 4, null);
            boolean optBoolean = new JSONObject(params).optBoolean("EnterLevel", false);
            if (iZPlanWorldStatusListener != null) {
                iZPlanWorldStatusListener.onEnterSceneResult(optBoolean);
            }
            if (optBoolean && peakProcessWorldRender != null && (l3 = peakProcessWorldRender.l()) != null) {
                l3.b(this.type);
            }
            ZLog.f386189b.k("PeakProcessWorldRender", "PeakProcessWorldRender registerEnterSceneResultEvent LuaCallback: " + eventName + TokenParser.SP + params);
            return "";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/zplan/world/render/parallel/PeakProcessWorldRender$d;", "Lcom/tencent/zplan/c$a;", "", AdMetricTag.EVENT_NAME, "params", "", "callbackId", "t0", "d", "I", "sceneType", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/zplan/world/render/parallel/PeakProcessWorldRender;", "e", "Ljava/lang/ref/WeakReference;", "weakRender", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "f", "weakListener", "<init>", "(ILjava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class d extends c.a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int sceneType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<PeakProcessWorldRender> weakRender;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<IZPlanWorldStatusListener> weakListener;

        public d(int i3, @NotNull WeakReference<PeakProcessWorldRender> weakRender, @NotNull WeakReference<IZPlanWorldStatusListener> weakListener) {
            Intrinsics.checkNotNullParameter(weakRender, "weakRender");
            Intrinsics.checkNotNullParameter(weakListener, "weakListener");
            this.sceneType = i3;
            this.weakRender = weakRender;
            this.weakListener = weakListener;
        }

        @Override // com.tencent.zplan.c
        @NotNull
        public String t0(@Nullable String eventName, @Nullable String params, int callbackId) {
            Integer num;
            Integer num2;
            com.tencent.zplan.model.a l3;
            Boolean setFocusState;
            PeakProcessWorldRender peakProcessWorldRender = this.weakRender.get();
            IZPlanWorldStatusListener iZPlanWorldStatusListener = this.weakListener.get();
            EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("zplan_enter_scene");
            if (peakProcessWorldRender != null) {
                num = Integer.valueOf(peakProcessWorldRender.getRenderHashCode());
            } else {
                num = null;
            }
            sb5.append(num);
            EngineLifeCycleReporter.k(engineLifeCycleReporter, sb5.toString(), "enter_scene_end", null, 4, null);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("zplan_enter_scene");
            if (peakProcessWorldRender != null) {
                num2 = Integer.valueOf(peakProcessWorldRender.getRenderHashCode());
            } else {
                num2 = null;
            }
            sb6.append(num2);
            EngineLifeCycleReporter.t(engineLifeCycleReporter, sb6.toString(), false, 2, null);
            if (peakProcessWorldRender != null && (setFocusState = peakProcessWorldRender.getSetFocusState()) != null) {
                peakProcessWorldRender.a(setFocusState.booleanValue());
            }
            ZLog.f386189b.k("PeakProcessWorldRender", "onLuaEvent eventName:" + eventName + ", params: " + params);
            if (iZPlanWorldStatusListener != null) {
                iZPlanWorldStatusListener.onFirstFrame(new FirstFrameResult(this.sceneType, null, 2, null));
            }
            if (peakProcessWorldRender != null && (l3 = peakProcessWorldRender.l()) != null) {
                l3.d(this.sceneType);
                return "";
            }
            return "";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PeakProcessWorldRender(@NotNull Context context, boolean z16) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isGame = z16;
        ZLog.f386189b.k("PeakProcessWorldRender", "PeakProcessWorldRender init setUsingSuccess: " + this.setUsingSuccess);
        if (!this.setUsingSuccess) {
            a aVar = new a();
            this.mainProcessEngineStatusUpdateListener = aVar;
            ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
            Intrinsics.checkNotNull(aVar);
            zPlanIPCHelper.w(aVar);
        }
    }

    private final void B(int sceneType, IZPlanWorldStatusListener listener) {
        ZPlanIPCHelper.f385519j.q("L2N_LightEnterLevel", new c(sceneType, new WeakReference(this), new WeakReference(listener)));
        ZLog.f386189b.k("PeakProcessWorldRender", "PeakProcessWorldRender registerEnterSceneResultEvent: " + listener);
    }

    private final void C(int sceneType, IZPlanWorldStatusListener listener) {
        ZPlanIPCHelper.f385519j.q("L2N_LightFirstFrame", new d(sceneType, new WeakReference(this), new WeakReference(listener)));
        ZLog.f386189b.k("PeakProcessWorldRender", "PeakProcessWorldRender registerFirstFrameEvent: " + listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(int sceneType, String sceneParams, IZPlanWorldStatusListener listener) {
        u();
        ZLog zLog = ZLog.f386189b;
        zLog.k("PeakProcessWorldRender", "PeakProcessWorldRender enterAvatarScene");
        B(sceneType, listener);
        C(sceneType, listener);
        zLog.k("PeakProcessWorldRender", "PeakProcessWorldRender enterAvatarScene: registerFirstFrameEvent done");
        JSONObject jSONObject = new JSONObject(sceneParams);
        if (jSONObject.has("MapName") && jSONObject.has("PakPath") && jSONObject.has("checkVersion")) {
            String optString = jSONObject.optString("PakPath", "");
            boolean optBoolean = jSONObject.optBoolean("checkVersion", false);
            ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
            zPlanIPCHelper.p(optString, optBoolean);
            zLog.k("PeakProcessWorldRender", "PeakProcessWorldRender enterAvatarScene: mount pak done");
            zPlanIPCHelper.t(jSONObject.optString("MapName", ""));
            zLog.k("PeakProcessWorldRender", "PeakProcessWorldRender enterAvatarScene: open level done");
            zLog.k("PeakProcessWorldRender", "PeakProcessWorldRender enterAvatarScene end");
            return;
        }
        zLog.k("PeakProcessWorldRender", "PeakProcessWorldRender enterAvatarScene: scene params is illegal!");
    }

    /* renamed from: A, reason: from getter */
    public final boolean getIsGame() {
        return this.isGame;
    }

    @Override // dy4.a
    public void H() {
        ZLog.f386189b.k("PeakProcessWorldRender", "setViewportFull not support, worldID:" + getWorldID());
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender, dy4.a
    public void a(boolean hasFocus) {
        super.a(hasFocus);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bGetFocus", hasFocus);
        ZLog.f386189b.k("PeakProcessWorldRender", "PeakProcessWorldRender send N2L_SetFocusState, setFocusState, " + new StackPrinter("setFocusState"));
        com.tencent.zplan.luabridge.a k3 = ZPlanIPCHelper.f385519j.k();
        if (k3 != null) {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "state.toString()");
            a.C10063a.c(k3, "N2L_SetFocusState", jSONObject2, null, true, 4, null);
        }
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender, dy4.a
    @NotNull
    public View b(@Nullable Activity activity, @NotNull Context context, boolean needEvent, boolean opaque, boolean useSurfaceView) {
        Intrinsics.checkNotNullParameter(context, "context");
        ZPlanIPCHelper.f385519j.C();
        return super.b(activity, context, needEvent, opaque, useSurfaceView);
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender, dy4.a
    public void destroy() {
        ZLog zLog = ZLog.f386189b;
        zLog.k("PeakProcessWorldRender", "PeakProcessWorldRender destroy, worldID:" + getWorldID());
        if (this.isGame) {
            this.renderDestroy = true;
            if (this.setUsingSuccess) {
                zLog.k("PeakProcessWorldRender", "PeakProcessWorldRender setIsUsing false");
                ZPlanIPCHelper.f385519j.D(false);
            }
            this.setUsingSuccess = false;
            zLog.k("PeakProcessWorldRender", "destroy, main world, do nothing, mWorldID :" + getWorldID());
        } else {
            ZPlanIPCHelper.f385519j.i(getRenderHashCode(), getWorldID());
        }
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender
    public void e(final int sceneType, @Nullable final String sceneParams, @Nullable final IZPlanWorldStatusListener listener) {
        int i3;
        int i16;
        int i17;
        Surface surface;
        ZLog.f386189b.k("PeakProcessWorldRender", "PeakProcessWorldRender worldID " + getWorldID() + " isGame " + this.isGame);
        int i18 = 0;
        if (this.isGame) {
            t(0);
            ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
            int worldID = getWorldID();
            com.tencent.zplan.world.view.c renderView = getRenderView();
            if (renderView != null) {
                i16 = renderView.getViewWidth();
            } else {
                i16 = 0;
            }
            com.tencent.zplan.world.view.c renderView2 = getRenderView();
            if (renderView2 != null) {
                i17 = renderView2.getViewHeight();
            } else {
                i17 = 0;
            }
            com.tencent.zplan.world.view.c renderView3 = getRenderView();
            if (renderView3 != null) {
                surface = renderView3.getSurface();
            } else {
                surface = null;
            }
            zPlanIPCHelper.j(worldID, i16, i17, surface);
        }
        if (getWorldID() == -1) {
            ZPlanIPCHelper zPlanIPCHelper2 = ZPlanIPCHelper.f385519j;
            int renderHashCode = getRenderHashCode();
            com.tencent.zplan.world.view.c renderView4 = getRenderView();
            if (renderView4 != null) {
                i3 = renderView4.getViewWidth();
            } else {
                i3 = 0;
            }
            com.tencent.zplan.world.view.c renderView5 = getRenderView();
            if (renderView5 != null) {
                i18 = renderView5.getViewHeight();
            }
            zPlanIPCHelper2.n(renderHashCode, sceneType, i3, i18, new IZPlanWorldCallback.Stub() { // from class: com.tencent.zplan.world.render.parallel.PeakProcessWorldRender$enterAvatarSceneAfterEngineInitDone$1
                @Override // com.tencent.zplan.IZPlanWorldCallback
                public void onGetZPlanWorld(@Nullable ZPlanWorld zplanWorld) {
                    int i19;
                    Surface surface2;
                    int i26 = 0;
                    if (zplanWorld == null) {
                        ZLog.f386189b.k("PeakProcessWorldRender", "PeakProcessWorldRender enterAvatarScene");
                        IZPlanWorldStatusListener iZPlanWorldStatusListener = listener;
                        if (iZPlanWorldStatusListener != null) {
                            iZPlanWorldStatusListener.onEnterSceneResult(false);
                            return;
                        }
                        return;
                    }
                    PeakProcessWorldRender.this.t(zplanWorld.getWorldID());
                    zplanWorld.setScene(sceneType);
                    com.tencent.zplan.world.view.c renderView6 = PeakProcessWorldRender.this.getRenderView();
                    if (renderView6 != null) {
                        renderView6.setWorldID(PeakProcessWorldRender.this.getWorldID());
                    }
                    ZLog.f386189b.k("PeakProcessWorldRender", "PeakProcessWorldRender onGetZPlanWorld " + PeakProcessWorldRender.this.getWorldID());
                    ZPlanIPCHelper zPlanIPCHelper3 = ZPlanIPCHelper.f385519j;
                    int worldID2 = PeakProcessWorldRender.this.getWorldID();
                    com.tencent.zplan.world.view.c renderView7 = PeakProcessWorldRender.this.getRenderView();
                    if (renderView7 != null) {
                        i19 = renderView7.getViewWidth();
                    } else {
                        i19 = 0;
                    }
                    com.tencent.zplan.world.view.c renderView8 = PeakProcessWorldRender.this.getRenderView();
                    if (renderView8 != null) {
                        i26 = renderView8.getViewHeight();
                    }
                    com.tencent.zplan.world.view.c renderView9 = PeakProcessWorldRender.this.getRenderView();
                    if (renderView9 != null) {
                        surface2 = renderView9.getSurface();
                    } else {
                        surface2 = null;
                    }
                    zPlanIPCHelper3.j(worldID2, i19, i26, surface2);
                    PeakProcessWorldRender.this.z(sceneType, sceneParams, listener);
                }
            });
            return;
        }
        z(sceneType, sceneParams, listener);
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender
    protected void o(@Nullable Function1<? super Boolean, Unit> afterInit) {
        ZLog.f386189b.k("PeakProcessWorldRender", "PeakProcessWorldRender don't support queryEngineInitStatus, enter avatar scene directly, worldID:" + getWorldID());
        if (afterInit != null) {
            afterInit.invoke(Boolean.TRUE);
        }
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender
    public void p(int width, int height) {
        Surface surface;
        if (getWorldID() == -1) {
            return;
        }
        ZLog.f386189b.k("PeakProcessWorldRender", "PeakProcessWorldRender resizeWorldSize worldID:" + getWorldID() + ", width:" + width + ", height:" + height);
        ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
        zPlanIPCHelper.y(getWorldID(), width, height);
        int worldID = getWorldID();
        com.tencent.zplan.world.view.c renderView = getRenderView();
        if (renderView != null) {
            surface = renderView.getSurface();
        } else {
            surface = null;
        }
        zPlanIPCHelper.j(worldID, width, height, surface);
    }

    @Override // dy4.a
    public void pause() {
        ZLog.f386189b.k("PeakProcessWorldRender", "PeakProcessWorldRender pause, worldID:" + getWorldID());
        ZPlanIPCHelper.f385519j.v(getWorldID());
    }

    @Override // dy4.a
    public void resume() {
        ZLog.f386189b.k("PeakProcessWorldRender", "PeakProcessWorldRender resume, worldID:" + getWorldID());
        ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
        zPlanIPCHelper.C();
        zPlanIPCHelper.B(getWorldID());
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender
    public void u() {
        Surface surface;
        Surface surface2;
        int i3;
        ZLog zLog = ZLog.f386189b;
        zLog.k("PeakProcessWorldRender", "PeakProcessWorldRender setWorldTexture worldID:" + getWorldID());
        if (getWorldID() == -1) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("PeakProcessWorldRender setWorldTexture worldID:");
        sb5.append(getWorldID());
        sb5.append(", surface:");
        com.tencent.zplan.world.view.c renderView = getRenderView();
        Surface surface3 = null;
        if (renderView != null) {
            surface = renderView.getSurface();
        } else {
            surface = null;
        }
        sb5.append(surface);
        zLog.k("PeakProcessWorldRender", sb5.toString());
        com.tencent.zplan.world.view.c renderView2 = getRenderView();
        if (renderView2 != null && (surface2 = renderView2.getSurface()) != null) {
            ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
            zPlanIPCHelper.F(getWorldID(), surface2);
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
            com.tencent.zplan.world.view.c renderView5 = getRenderView();
            if (renderView5 != null) {
                surface3 = renderView5.getSurface();
            }
            zPlanIPCHelper.j(worldID, i3, i16, surface3);
        }
    }
}
