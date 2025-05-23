package com.tencent.zplan.world.render.parallel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.epicgames.ue4.GameActivityBase;
import com.epicgames.ue4.GameActivityThunk;
import com.epicgames.ue4.UE4;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.engine.service.EngineLifeCycleReporter;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.activity.ZPlanActivity;
import com.tencent.zplan.world.manager.IZPlanWorldListener;
import com.tencent.zplan.world.manager.ZPlanWorldManager;
import com.tencent.zplan.world.model.FirstFrameResult;
import com.tencent.zplan.world.model.ZPlanWorld;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 52\u00020\u0001:\u0001\u0017B\u0019\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u00101\u001a\u00020\u000e\u00a2\u0006\u0004\b3\u00104J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J2\u0010\u0013\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J$\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J-\u0010 \u001a\u00020\b2#\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b\u0018\u00010\u001bH\u0014J\b\u0010!\u001a\u00020\bH\u0016J\u0018\u0010$\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0002H\u0016R!\u0010*\u001a\b\u0012\u0004\u0012\u00020&0%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010'\u001a\u0004\b(\u0010)R\u001b\u0010.\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010'\u001a\u0004\b,\u0010-R\u0017\u00101\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/zplan/world/render/parallel/ZPlanProcessWorldRender;", "Lcom/tencent/zplan/world/render/parallel/AbsZPlanWorldRender;", "", "sceneType", "", "sceneParams", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "listener", "", "y", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "context", "", "needEvent", TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, "useSurfaceView", "Landroid/view/View;", "b", "pause", "resume", "hasFocus", "a", "H", "destroy", "e", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "afterInit", "o", "u", "width", "height", "p", "", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "Lkotlin/Lazy;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/List;", "zPlanInitFinishListenerList", "Ljava/util/concurrent/locks/ReentrantLock;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/util/concurrent/locks/ReentrantLock;", "listenerLock", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Z", "isGame", "()Z", "<init>", "(Landroid/content/Context;Z)V", "r", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanProcessWorldRender extends AbsZPlanWorldRender {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Lazy zPlanInitFinishListenerList;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final Lazy listenerLock;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final boolean isGame;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/zplan/world/render/parallel/ZPlanProcessWorldRender$b", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "", "success", "", "onEnterSceneResult", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements IZPlanWorldStatusListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IZPlanWorldStatusListener f386404e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f386405f;

        b(IZPlanWorldStatusListener iZPlanWorldStatusListener, int i3) {
            this.f386404e = iZPlanWorldStatusListener;
            this.f386405f = i3;
        }

        @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
        public void onEnterSceneResult(boolean success) {
            EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_enter_scene" + ZPlanProcessWorldRender.this.getReportRenderHashCode(), "enter_scene", null, 4, null);
            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_process_render", "enter_scene_result", null, 4, null);
            IZPlanWorldStatusListener iZPlanWorldStatusListener = this.f386404e;
            if (iZPlanWorldStatusListener != null) {
                iZPlanWorldStatusListener.onEnterSceneResult(success);
            }
            if (success) {
                ZPlanProcessWorldRender.this.l().b(this.f386405f);
            }
        }

        @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
        public void onFirstFrame(@NotNull FirstFrameResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_enter_scene" + ZPlanProcessWorldRender.this.getReportRenderHashCode(), "enter_scene_end", null, 4, null);
            EngineLifeCycleReporter.t(engineLifeCycleReporter, "zplan_enter_scene" + ZPlanProcessWorldRender.this.getReportRenderHashCode(), false, 2, null);
            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_process_render", "enter_scnen_first_frame", null, 4, null);
            engineLifeCycleReporter.s("zplan_process_render", true);
            Boolean setFocusState = ZPlanProcessWorldRender.this.getSetFocusState();
            if (setFocusState != null) {
                ZPlanProcessWorldRender.this.a(setFocusState.booleanValue());
            }
            IZPlanWorldStatusListener iZPlanWorldStatusListener = this.f386404e;
            if (iZPlanWorldStatusListener != null) {
                iZPlanWorldStatusListener.onFirstFrame(result);
            }
            ZPlanProcessWorldRender.this.l().d(this.f386405f);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/world/render/parallel/ZPlanProcessWorldRender$c", "Lcom/tencent/zplan/world/manager/IZPlanWorldListener;", "Lcom/tencent/zplan/world/model/ZPlanWorld;", "zPlanWorld", "", "onGetZPlanWorld", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c implements IZPlanWorldListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IZPlanWorldStatusListener f386407b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f386408c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f386409d;

        c(IZPlanWorldStatusListener iZPlanWorldStatusListener, int i3, String str) {
            this.f386407b = iZPlanWorldStatusListener;
            this.f386408c = i3;
            this.f386409d = str;
        }

        @Override // com.tencent.zplan.world.manager.IZPlanWorldListener
        public void onGetZPlanWorld(@Nullable ZPlanWorld zPlanWorld) {
            if (zPlanWorld == null) {
                IZPlanWorldStatusListener iZPlanWorldStatusListener = this.f386407b;
                if (iZPlanWorldStatusListener != null) {
                    iZPlanWorldStatusListener.onEnterSceneResult(false);
                    return;
                }
                return;
            }
            ZPlanProcessWorldRender.this.t(zPlanWorld.getWorldID());
            zPlanWorld.setScene(this.f386408c);
            com.tencent.zplan.world.view.c renderView = ZPlanProcessWorldRender.this.getRenderView();
            if (renderView != null) {
                renderView.setWorldID(ZPlanProcessWorldRender.this.getWorldID());
            }
            ZPlanProcessWorldRender.this.y(this.f386408c, this.f386409d, this.f386407b);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"com/tencent/zplan/world/render/parallel/ZPlanProcessWorldRender$queryEngineInitStatus$1$listener$1", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "", "success", "", "onEngineInitFinish", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class d implements GameActivityThunk.CMShowEngineInitFinishListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1 f386411e;

        d(Function1 function1) {
            this.f386411e = function1;
        }

        @Override // com.epicgames.ue4.GameActivityThunk.CMShowEngineInitFinishListener
        public void onEngineInitFinish(boolean success) {
            ZPlanProcessWorldRender.this.s(success);
            Function1 function1 = this.f386411e;
            if (function1 != null) {
            }
            com.tencent.zplan.engine.service.c.INSTANCE.b(this);
            ReentrantLock z16 = ZPlanProcessWorldRender.this.z();
            z16.lock();
            try {
                ZPlanProcessWorldRender.this.A().remove(this);
            } finally {
                z16.unlock();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanProcessWorldRender(@NotNull Context context, boolean z16) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.isGame = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<GameActivityThunk.CMShowEngineInitFinishListener>>() { // from class: com.tencent.zplan.world.render.parallel.ZPlanProcessWorldRender$zPlanInitFinishListenerList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<GameActivityThunk.CMShowEngineInitFinishListener> invoke() {
                return new ArrayList();
            }
        });
        this.zPlanInitFinishListenerList = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ReentrantLock>() { // from class: com.tencent.zplan.world.render.parallel.ZPlanProcessWorldRender$listenerLock$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ReentrantLock invoke() {
                return new ReentrantLock();
            }
        });
        this.listenerLock = lazy2;
        ZPlanServiceHelper.I.R0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<GameActivityThunk.CMShowEngineInitFinishListener> A() {
        return (List) this.zPlanInitFinishListenerList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(int sceneType, String sceneParams, IZPlanWorldStatusListener listener) {
        int i3;
        Surface surface;
        EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
        EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_process_render", "get_zplan_world_end", null, 4, null);
        ZLog.f386189b.k("ZPlanProcessWorldRender", "doEntertAvatarScene sceneType : " + sceneType + ", sceneParams: " + sceneParams + ", listener: " + listener);
        u();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("enter_scene_type", String.valueOf(sceneType));
        engineLifeCycleReporter.j("zplan_process_render", "do_enter_scene", hashMap);
        ZPlanWorldManager zPlanWorldManager = ZPlanWorldManager.f386245m;
        zPlanWorldManager.C(getWorldID(), sceneType, sceneParams, new b(listener, sceneType));
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
        zPlanWorldManager.F(worldID, i3, i16, surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReentrantLock z() {
        return (ReentrantLock) this.listenerLock.getValue();
    }

    @Override // dy4.a
    public void H() {
        ZLog.f386189b.k("ZPlanProcessWorldRender", "setViewportFull not support, worldID:" + getWorldID());
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender, dy4.a
    public void a(boolean hasFocus) {
        super.a(hasFocus);
        ZLog.f386189b.k("ZPlanProcessWorldRender", "setFocusState hasFocus: " + hasFocus);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bGetFocus", hasFocus);
        ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "state.toString()");
        a.C10063a.c(zPlanLuaBridge, "N2L_SetFocusState", jSONObject2, null, true, 4, null);
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender, dy4.a
    @NotNull
    public View b(@Nullable Activity activity, @NotNull Context context, boolean needEvent, boolean opaque, boolean useSurfaceView) {
        Context context2;
        Intrinsics.checkNotNullParameter(context, "context");
        q(activity);
        r(context);
        if (activity != null) {
            context2 = activity;
        } else {
            context2 = context;
        }
        UE4.setContext(context2);
        UE4.setImmersiveMode(false);
        if (activity instanceof ZPlanActivity) {
            GameActivityBase.OnCreate(new Bundle(), ((ZPlanActivity) activity).getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String());
        }
        return super.b(activity, context, needEvent, opaque, useSurfaceView);
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender, dy4.a
    public void destroy() {
        ZLog zLog = ZLog.f386189b;
        zLog.k("ZPlanProcessWorldRender", "destroy, worldID:" + getWorldID() + TokenParser.SP + new StackPrinter("destroy"));
        if (this.isGame) {
            zLog.k("ZPlanProcessWorldRender", "destroy, main world, do nothing, mWorldID :" + getWorldID());
        } else {
            zLog.k("ZPlanProcessWorldRender", "destroy renderHashCode: " + getRenderHashCode() + ", this: " + this);
            ZPlanWorldManager.f386245m.U(getRenderHashCode(), getWorldID());
        }
        ReentrantLock z16 = z();
        z16.lock();
        try {
            Iterator<GameActivityThunk.CMShowEngineInitFinishListener> it = A().iterator();
            while (it.hasNext()) {
                com.tencent.zplan.engine.service.c.INSTANCE.b(it.next());
            }
            A().clear();
            Unit unit = Unit.INSTANCE;
            z16.unlock();
            Activity activity = getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
            if (activity != null) {
                if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                    UE4.forceClearContext();
                } else {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    activity.runOnUiThread(new Runnable() { // from class: com.tencent.zplan.world.render.parallel.ZPlanProcessWorldRender$destroy$2$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            UE4.forceClearContext();
                            countDownLatch.countDown();
                        }
                    });
                    countDownLatch.await();
                }
            }
            ZPlanServiceHelper.I.R0(false);
            super.destroy();
        } catch (Throwable th5) {
            z16.unlock();
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender
    public void e(int sceneType, @Nullable String sceneParams, @Nullable IZPlanWorldStatusListener listener) {
        int i3;
        EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
        EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_process_render", "enter_scene", null, 4, null);
        EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_process_render", "get_zplan_world", null, 4, null);
        int i16 = 0;
        if (this.isGame) {
            t(0);
        }
        if (getWorldID() == -1) {
            ZLog.f386189b.k("ZPlanProcessWorldRender", "enterAvatarSceneAfterEngineInitDone renderHashCode: " + getRenderHashCode() + ", this: " + this);
            ZPlanWorldManager zPlanWorldManager = ZPlanWorldManager.f386245m;
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
            zPlanWorldManager.H(renderHashCode, sceneType, i3, i16, new c(listener, sceneType, sceneParams));
            return;
        }
        y(sceneType, sceneParams, listener);
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender
    protected void o(@Nullable Function1<? super Boolean, Unit> afterInit) {
        if (getEngineInitDone()) {
            if (afterInit != null) {
                afterInit.invoke(Boolean.TRUE);
                return;
            }
            return;
        }
        d dVar = new d(afterInit);
        com.tencent.zplan.engine.service.c.INSTANCE.a(dVar);
        ReentrantLock z16 = z();
        z16.lock();
        try {
            A().add(dVar);
        } finally {
            z16.unlock();
        }
    }

    @Override // com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender
    public void p(int width, int height) {
        Surface surface;
        if (getWorldID() == -1) {
            return;
        }
        ZLog.f386189b.k("ZPlanProcessWorldRender", "resizeWorldSize worldID:" + getWorldID() + ", width:" + width + ", height:" + height);
        ZPlanWorldManager zPlanWorldManager = ZPlanWorldManager.f386245m;
        zPlanWorldManager.Y(getWorldID(), width, height);
        int worldID = getWorldID();
        com.tencent.zplan.world.view.c renderView = getRenderView();
        if (renderView != null) {
            surface = renderView.getSurface();
        } else {
            surface = null;
        }
        zPlanWorldManager.F(worldID, width, height, surface);
    }

    @Override // dy4.a
    public void pause() {
        ZLog.f386189b.k("ZPlanProcessWorldRender", "pause, worldID:" + getWorldID());
        ZPlanWorldManager.f386245m.V(getWorldID());
    }

    @Override // dy4.a
    public void resume() {
        o(new Function1<Boolean, Unit>() { // from class: com.tencent.zplan.world.render.parallel.ZPlanProcessWorldRender$resume$1
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
                    ZLog.f386189b.k("ZPlanProcessWorldRender", "resume, worldID:" + ZPlanProcessWorldRender.this.getWorldID());
                    Context context = ZPlanProcessWorldRender.this.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
                    if (context == null) {
                        context = ZPlanProcessWorldRender.this.getContext();
                    }
                    UE4.setContext(context);
                    ZPlanWorldManager.f386245m.W(ZPlanProcessWorldRender.this.getWorldID());
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
        zLog.k("ZPlanProcessWorldRender", "setWorldTexture worldID:" + getWorldID());
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
        zLog.k("ZPlanProcessWorldRender", sb5.toString());
        com.tencent.zplan.world.view.c renderView2 = getRenderView();
        if (renderView2 != null && (surface2 = renderView2.getSurface()) != null) {
            ZPlanWorldManager zPlanWorldManager = ZPlanWorldManager.f386245m;
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
            zPlanWorldManager.F(worldID, i3, i16, surface2);
        }
    }
}
