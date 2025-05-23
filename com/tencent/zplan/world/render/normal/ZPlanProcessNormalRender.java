package com.tencent.zplan.world.render.normal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import com.epicgames.ue4.GameActivityBase;
import com.epicgames.ue4.UE4;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.engine.service.EngineLifeCycleReporter;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.luabridge.plugins.FirstFramePlugin;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.activity.ZPlanActivity;
import com.tencent.zplan.world.model.FirstFrameResult;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ2\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J$\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/zplan/world/render/normal/ZPlanProcessNormalRender;", "Lcom/tencent/zplan/world/render/normal/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "context", "", "needEvent", TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, "useSurfaceView", "Landroid/view/View;", "b", "", "resume", "destroy", "", "sceneType", "", "sceneParams", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "listener", "c", "hasFocus", "a", "H", "Lcom/tencent/zplan/luabridge/plugins/FirstFramePlugin$b;", "i", "Lcom/tencent/zplan/luabridge/plugins/FirstFramePlugin$b;", "zPlanProcessFirstFrameListener", "<init>", "(Landroid/content/Context;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanProcessNormalRender extends com.tencent.zplan.world.render.normal.a {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FirstFramePlugin.b zPlanProcessFirstFrameListener;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/zplan/world/render/normal/ZPlanProcessNormalRender$a", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "", "success", "", "onEnterSceneResult", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements IZPlanWorldStatusListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IZPlanWorldStatusListener f386331e;

        a(IZPlanWorldStatusListener iZPlanWorldStatusListener) {
            this.f386331e = iZPlanWorldStatusListener;
        }

        @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
        public void onEnterSceneResult(boolean success) {
            IZPlanWorldStatusListener.a.a(this, success);
            EngineLifeCycleReporter.k(EngineLifeCycleReporter.f385573f, "zplan_enter_scene" + ZPlanProcessNormalRender.this.getRenderHashCode(), "enter_scene", null, 4, null);
            IZPlanWorldStatusListener iZPlanWorldStatusListener = this.f386331e;
            if (iZPlanWorldStatusListener != null) {
                iZPlanWorldStatusListener.onEnterSceneResult(true);
            }
        }

        @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
        public void onFirstFrame(@NotNull FirstFrameResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            IZPlanWorldStatusListener.a.b(this, result);
            ZLog.f386189b.k("AbsZPlanNormalRender", "onFirstFrame : " + result);
            EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_enter_scene" + ZPlanProcessNormalRender.this.getRenderHashCode(), "enter_scene_end", null, 4, null);
            EngineLifeCycleReporter.t(engineLifeCycleReporter, "zplan_enter_scene" + ZPlanProcessNormalRender.this.getRenderHashCode(), false, 2, null);
            Boolean setFocusState = ZPlanProcessNormalRender.this.getSetFocusState();
            if (setFocusState != null) {
                ZPlanProcessNormalRender.this.a(setFocusState.booleanValue());
            }
            IZPlanWorldStatusListener iZPlanWorldStatusListener = this.f386331e;
            if (iZPlanWorldStatusListener != null) {
                iZPlanWorldStatusListener.onFirstFrame(result);
            }
            ZPlanProcessNormalRender.this.i().d(result.getCurType());
        }
    }

    public ZPlanProcessNormalRender(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        UE4.setContext(context);
        ZPlanServiceHelper.I.R0(true);
    }

    @Override // dy4.a
    public void H() {
        ZLog.f386189b.k("AbsZPlanNormalRender", "setViewportFull");
        UE4.setViewportFull();
    }

    @Override // com.tencent.zplan.world.render.normal.a, dy4.a
    public void a(boolean hasFocus) {
        ZLog.f386189b.k("AbsZPlanNormalRender", "setFocusState hasFocus: " + hasFocus);
        super.a(hasFocus);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bGetFocus", hasFocus);
        ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "state.toString()");
        a.C10063a.c(zPlanLuaBridge, "N2L_SetFocusState", jSONObject2, null, true, 4, null);
    }

    @Override // com.tencent.zplan.world.render.normal.a, dy4.a
    @NotNull
    public View b(@Nullable Activity activity, @NotNull Context context, boolean needEvent, boolean opaque, boolean useSurfaceView) {
        Context context2;
        Intrinsics.checkNotNullParameter(context, "context");
        k(activity);
        l(context);
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

    @Override // com.tencent.zplan.world.render.normal.a, dy4.a
    public void c(int sceneType, @Nullable String sceneParams, @Nullable IZPlanWorldStatusListener listener) {
        super.c(sceneType, sceneParams, listener);
        com.tencent.zplan.world.manager.a.f386318c.c(sceneType, sceneParams, new a(listener));
        i().b(sceneType);
    }

    @Override // com.tencent.zplan.world.render.normal.a, dy4.a
    public void destroy() {
        this.zPlanProcessFirstFrameListener = null;
        ZPlanServiceHelper.I.R0(false);
        Activity activity = getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
        if (activity != null) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                UE4.forceClearContext();
            } else {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.zplan.world.render.normal.ZPlanProcessNormalRender$destroy$1$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        UE4.forceClearContext();
                        countDownLatch.countDown();
                    }
                });
                countDownLatch.await();
            }
        }
        super.destroy();
    }

    @Override // com.tencent.zplan.world.render.normal.a, dy4.a
    public void resume() {
        Context context = getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
        if (context == null) {
            context = getContext();
        }
        UE4.setContext(context);
        super.resume();
    }
}
