package com.tencent.zplan.world.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.epicgames.ue4.GameActivity;
import com.epicgames.ue4.UE4;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.zplan.common.utils.f;
import com.tencent.zplan.engine.ZPlanIPCHelper;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.utils.ZLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001!B!\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010A\u001a\u00020\u0017\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u001cH\u0016J\u001a\u0010!\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u0017H\u0016J\u0012\u0010\"\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\u0012\u0010%\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010$H\u0016R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010-R\u0016\u00106\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010-R\u0018\u00109\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010-R\u0017\u0010\u0018\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b<\u0010-\u001a\u0004\b=\u0010>\u00a8\u0006E"}, d2 = {"Lcom/tencent/zplan/world/view/NormalRenderSurfaceView;", "Landroid/view/SurfaceView;", "Lcom/tencent/zplan/world/view/a;", "Landroid/view/SurfaceHolder$Callback2;", "Landroid/view/MotionEvent;", "event", "", "d", "Landroid/view/SurfaceHolder;", "holder", "surfaceCreated", "", "format", "width", "height", "surfaceChanged", "surfaceDestroyed", "surfaceRedrawNeeded", "Landroid/view/View;", "getView", "Lcom/tencent/zplan/world/view/b;", "listener", "setOnTouchEventListener", "", "needEvent", "setNeedEvent", "onTouchEvent", "keyCode", "Landroid/view/KeyEvent;", "onKeyDown", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "bCreateView", "a", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/zplan/world/view/d;", "setTextureViewListener", "Lcom/tencent/zplan/world/view/d;", "surfaceViewListener", "Landroid/view/Surface;", "e", "Landroid/view/Surface;", "surface", "f", "Z", "isPause", "Landroid/os/Handler;", h.F, "Landroid/os/Handler;", "uiHandler", "i", "isZPlanProcess", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isPeakProcess", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/zplan/world/view/b;", "onTouchListener", "D", "needInputEvent", "E", "getNeedEvent", "()Z", "Landroid/content/Context;", "context", TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, "<init>", "(Landroid/content/Context;ZZ)V", UserInfo.SEX_FEMALE, "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class NormalRenderSurfaceView extends SurfaceView implements a, SurfaceHolder.Callback2 {

    /* renamed from: C, reason: from kotlin metadata */
    private b onTouchListener;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean needInputEvent;

    /* renamed from: E, reason: from kotlin metadata */
    private final boolean needEvent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private d surfaceViewListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Surface surface;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isPause;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Handler uiHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isZPlanProcess;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isPeakProcess;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalRenderSurfaceView(@NotNull Context context, boolean z16, boolean z17) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.needEvent = z16;
        this.needInputEvent = true;
        f fVar = f.f385292a;
        boolean e16 = fVar.e(context, ":zplan");
        this.isZPlanProcess = e16;
        if (e16) {
            this.uiHandler = new Handler(Looper.getMainLooper());
        }
        this.isPeakProcess = fVar.e(context, ":peak");
        getHolder().addCallback(this);
        ZLog.f386189b.k("NormalRenderSurfaceView", TokenParser.SP + this + ", mIsZPlanProcess : " + this.isZPlanProcess + ", isPeakProcess : " + this.isPeakProcess);
        this.needInputEvent = z16;
    }

    private final void d(MotionEvent event) {
        int action = event.getAction() & 255;
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override // com.tencent.zplan.world.view.a
    public void a(@Nullable final Activity activity, boolean bCreateView) {
        ZLog zLog = ZLog.f386189b;
        zLog.k("NormalRenderSurfaceView", TokenParser.SP + this + ", onResume");
        this.isPause = false;
        if (this.isZPlanProcess) {
            Handler handler = this.uiHandler;
            if (handler != null) {
                final String str = "onResume";
                handler.post(new Runnable() { // from class: com.tencent.zplan.world.view.NormalRenderSurfaceView$onResume$$inlined$doOnUIThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Surface surface;
                        Surface surface2;
                        ZLog zLog2 = ZLog.f386189b;
                        zLog2.k("NormalRenderSurfaceView", "doOnUIThread before task, from: " + str);
                        Activity activity2 = activity;
                        if (activity2 != null) {
                            UE4.resumeEngine((Context) activity2, false);
                        }
                        surface = this.surface;
                        if (surface != null) {
                            zLog2.k("NormalRenderSurfaceView", TokenParser.SP + this + ", onResume, initWindow");
                            surface2 = this.surface;
                            UE4.initWindow(surface2);
                        }
                        com.tencent.zplan.engine.service.d dVar = com.tencent.zplan.engine.service.d.f385635c;
                        dVar.d();
                        dVar.e();
                        ZPlanLuaBridge.evaluateWaitList$default(ZPlanLuaBridge.INSTANCE, false, 1, null);
                        zLog2.k("NormalRenderSurfaceView", "doOnUIThread after task, from: " + str);
                    }
                });
                return;
            }
            return;
        }
        if (this.isPeakProcess) {
            ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
            ZPlanIPCHelper.A(zPlanIPCHelper, this.surface, null, 2, null);
            if (this.surface != null) {
                zLog.k("NormalRenderSurfaceView", TokenParser.SP + this + ", onResume, initWindow");
                Surface surface = this.surface;
                Intrinsics.checkNotNull(surface);
                zPlanIPCHelper.E(surface);
                return;
            }
            return;
        }
        ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
        ZPlanServiceHelper.L0(zPlanServiceHelper, this.surface, null, 2, null);
        if (this.surface != null) {
            zLog.k("NormalRenderSurfaceView", TokenParser.SP + this + ", onResume, initWindow");
            Surface surface2 = this.surface;
            Intrinsics.checkNotNull(surface2);
            zPlanServiceHelper.U0(surface2);
        }
    }

    @Override // com.tencent.zplan.world.view.a
    public void onDestroy() {
        ZLog.f386189b.k("NormalRenderSurfaceView", "agindage onDestroy surface=" + this.surface + ",  " + this);
        this.isPause = true;
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
        }
        this.surface = null;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ZLog.f386189b.k("NormalRenderSurfaceView", "onKeyDown keyCode: " + keyCode + ", event: " + event);
        if (this.isZPlanProcess) {
            UE4.inputEvent(event);
            GameActivity.Get().onKeyDown(keyCode, event);
        } else if (this.isPeakProcess) {
            ZPlanIPCHelper.f385519j.r(keyCode, event);
        } else {
            ZPlanServiceHelper.I.s0(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // com.tencent.zplan.world.view.a
    public void onPause(@Nullable final Activity activity) {
        ZLog.f386189b.k("NormalRenderSurfaceView", TokenParser.SP + this + ", onPause");
        this.isPause = true;
        if (this.isZPlanProcess) {
            Handler handler = this.uiHandler;
            if (handler != null) {
                final String str = MiniSDKConst.NOTIFY_EVENT_ONPAUSE;
                handler.post(new Runnable() { // from class: com.tencent.zplan.world.view.NormalRenderSurfaceView$onPause$$inlined$doOnUIThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZLog zLog = ZLog.f386189b;
                        zLog.k("NormalRenderSurfaceView", "doOnUIThread before task, from: " + str);
                        Activity activity2 = activity;
                        if (activity2 != null) {
                            UE4.clearWindow(true);
                            UE4.pauseEngine(activity2);
                        }
                        zLog.k("NormalRenderSurfaceView", "doOnUIThread after task, from: " + str);
                    }
                });
                return;
            }
            return;
        }
        if (this.isPeakProcess) {
            ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
            zPlanIPCHelper.h(this.surface);
            zPlanIPCHelper.u();
        } else {
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            zPlanServiceHelper.I(this.surface);
            zPlanServiceHelper.x0();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        b bVar = this.onTouchListener;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            return bVar.onTouchEvent(event);
        }
        if (this.needInputEvent) {
            if (this.isZPlanProcess) {
                UE4.inputEvent(event);
            } else if (this.isPeakProcess) {
                ZPlanIPCHelper.f385519j.s(event);
            } else {
                ZPlanServiceHelper.I.w0(event);
            }
            d(event);
            return true;
        }
        return super.onTouchEvent(event);
    }

    public void setNeedEvent(boolean needEvent) {
        ZLog.f386189b.k("NormalRenderSurfaceView", "setNeedEvent : " + needEvent);
        this.needInputEvent = needEvent;
    }

    @Override // com.tencent.zplan.world.view.a
    public void setOnTouchEventListener(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onTouchListener = listener;
    }

    @Override // com.tencent.zplan.world.view.a
    public void setTextureViewListener(@Nullable d listener) {
        this.surfaceViewListener = listener;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(@NotNull SurfaceHolder holder, int format, int width, int height) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.surface = holder.getSurface();
        ZLog zLog = ZLog.f386189b;
        zLog.k("NormalRenderSurfaceView", TokenParser.SP + this + ", surfaceChanged : " + this.surface + ", width=" + width + ", height=" + height);
        if (this.isPause) {
            zLog.k("NormalRenderSurfaceView", "surfaceChanged isPause, return");
            return;
        }
        if (this.isZPlanProcess) {
            Handler handler = this.uiHandler;
            if (handler != null) {
                final String str = "surfaceChanged";
                handler.post(new Runnable() { // from class: com.tencent.zplan.world.view.NormalRenderSurfaceView$surfaceChanged$$inlined$doOnUIThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Surface surface;
                        ZLog zLog2 = ZLog.f386189b;
                        zLog2.k("NormalRenderSurfaceView", "doOnUIThread before task, from: " + str);
                        surface = this.surface;
                        UE4.resizeWindow(surface);
                        zLog2.k("NormalRenderSurfaceView", "doOnUIThread after task, from: " + str);
                    }
                });
            }
        } else if (this.isPeakProcess) {
            ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
            Surface surface = this.surface;
            Intrinsics.checkNotNull(surface);
            zPlanIPCHelper.x(surface);
        } else {
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            Surface surface2 = this.surface;
            Intrinsics.checkNotNull(surface2);
            zPlanServiceHelper.H0(surface2);
        }
        d dVar = this.surfaceViewListener;
        if (dVar != null) {
            dVar.a(this.surface, width, height);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(@NotNull SurfaceHolder holder) {
        Handler handler;
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.surface = holder.getSurface();
        ZLog zLog = ZLog.f386189b;
        zLog.k("NormalRenderSurfaceView", TokenParser.SP + this + ", surfaceCreated : " + this.surface + ", width=" + getWidth() + ", height=" + getHeight());
        if (this.isZPlanProcess) {
            final Surface surface = this.surface;
            if (surface != null && (handler = this.uiHandler) != null) {
                final String str = "surfaceCreated";
                handler.post(new Runnable() { // from class: com.tencent.zplan.world.view.NormalRenderSurfaceView$$special$$inlined$doOnUIThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZLog zLog2 = ZLog.f386189b;
                        zLog2.k("NormalRenderSurfaceView", "doOnUIThread before task, from: " + str);
                        UE4.initWindow(surface);
                        zLog2.k("NormalRenderSurfaceView", "doOnUIThread after task, from: " + str);
                    }
                });
            }
        } else if (this.isPeakProcess) {
            zLog.k("NormalRenderSurfaceView", "setSuface : " + this.surface);
            ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
            Surface surface2 = this.surface;
            Intrinsics.checkNotNull(surface2);
            zPlanIPCHelper.E(surface2);
        } else {
            Surface surface3 = this.surface;
            if (surface3 != null) {
                zLog.k("NormalRenderSurfaceView", "agindage, setSuface : " + surface3);
                ZPlanServiceHelper.I.U0(surface3);
            }
        }
        d dVar = this.surfaceViewListener;
        if (dVar != null) {
            dVar.b(this.surface, getWidth(), getHeight());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(@NotNull SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.surface = holder.getSurface();
        ZLog.f386189b.k("NormalRenderSurfaceView", TokenParser.SP + this + ", surfaceDestroyed : " + this.surface);
        d dVar = this.surfaceViewListener;
        if (dVar != null) {
            dVar.onSurfaceDestroyed(this.surface);
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(@NotNull SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public /* synthetic */ NormalRenderSurfaceView(Context context, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z16, (i3 & 4) != 0 ? true : z17);
    }

    @Override // com.tencent.zplan.world.view.a
    @NotNull
    public View getView() {
        return this;
    }
}
