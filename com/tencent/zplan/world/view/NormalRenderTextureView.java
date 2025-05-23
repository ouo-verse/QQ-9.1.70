package com.tencent.zplan.world.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
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
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\"B!\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010C\u001a\u00020\u0012\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u001a\u0010\"\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0012H\u0016J\u0012\u0010#\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010$\u001a\u00020\u0006H\u0016R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010,R\u0016\u00108\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010,R\u0018\u0010;\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010,R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b>\u0010,\u001a\u0004\b?\u0010@\u00a8\u0006G"}, d2 = {"Lcom/tencent/zplan/world/view/NormalRenderTextureView;", "Landroid/view/TextureView;", "Lcom/tencent/zplan/world/view/a;", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/view/MotionEvent;", "event", "", "d", "Lcom/tencent/zplan/world/view/d;", "listener", "setTextureViewListener", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "", "width", "height", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "Lcom/tencent/zplan/world/view/b;", "setOnTouchEventListener", "needEvent", "setNeedEvent", "onTouchEvent", "keyCode", "Landroid/view/KeyEvent;", "onKeyDown", "Landroid/view/View;", "getView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "bCreateView", "a", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/Surface;", "Landroid/view/Surface;", "surface", "e", "Landroid/graphics/SurfaceTexture;", "curTexture", "f", "Z", "isPause", h.F, "Lcom/tencent/zplan/world/view/d;", "textureViewListener", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "uiHandler", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isZPlanProcess", BdhLogUtil.LogTag.Tag_Conn, "isPeakProcess", "D", "Lcom/tencent/zplan/world/view/b;", "onTouchListener", "E", "needInputEvent", UserInfo.SEX_FEMALE, "getNeedEvent", "()Z", "Landroid/content/Context;", "context", TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, "<init>", "(Landroid/content/Context;ZZ)V", "G", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class NormalRenderTextureView extends TextureView implements a, TextureView.SurfaceTextureListener {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isPeakProcess;

    /* renamed from: D, reason: from kotlin metadata */
    private b onTouchListener;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean needInputEvent;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean needEvent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Surface surface;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SurfaceTexture curTexture;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isPause;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private d textureViewListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Handler uiHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isZPlanProcess;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalRenderTextureView(@NotNull Context context, boolean z16, boolean z17) {
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
        setOpaque(z17);
        setSurfaceTextureListener(this);
        ZLog.f386189b.k("NormalRenderTextureView", TokenParser.SP + this + ", mIsZPlanProcess : " + this.isZPlanProcess + ", isPeakProcess : " + this.isPeakProcess);
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
        zLog.k("NormalRenderTextureView", TokenParser.SP + this + ", onResume");
        this.isPause = false;
        if (this.isZPlanProcess) {
            Handler handler = this.uiHandler;
            if (handler != null) {
                final String str = "onResume";
                handler.post(new Runnable() { // from class: com.tencent.zplan.world.view.NormalRenderTextureView$onResume$$inlined$doOnUIThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Surface surface;
                        Surface surface2;
                        ZLog zLog2 = ZLog.f386189b;
                        zLog2.k("NormalRenderTextureView", "doOnUIThread before task, from: " + str);
                        Activity activity2 = activity;
                        if (activity2 != null) {
                            UE4.resumeEngine((Context) activity2, false);
                        }
                        surface = this.surface;
                        if (surface != null) {
                            zLog2.k("NormalRenderTextureView", TokenParser.SP + this + ", onResume, initWindow");
                            surface2 = this.surface;
                            UE4.initWindow(surface2);
                        }
                        com.tencent.zplan.engine.service.d dVar = com.tencent.zplan.engine.service.d.f385635c;
                        dVar.d();
                        dVar.e();
                        ZPlanLuaBridge.evaluateWaitList$default(ZPlanLuaBridge.INSTANCE, false, 1, null);
                        zLog2.k("NormalRenderTextureView", "doOnUIThread after task, from: " + str);
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
                zLog.k("NormalRenderTextureView", TokenParser.SP + this + ", onResume, initWindow");
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
            zLog.k("NormalRenderTextureView", TokenParser.SP + this + ", onResume, initWindow");
            Surface surface2 = this.surface;
            Intrinsics.checkNotNull(surface2);
            zPlanServiceHelper.U0(surface2);
        }
    }

    @Override // com.tencent.zplan.world.view.a
    public void onDestroy() {
        ZLog.f386189b.k("NormalRenderTextureView", "agindage onDestroy surface=" + this.surface + ",  " + this);
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
        ZLog.f386189b.k("NormalRenderTextureView", "onKeyDown keyCode: " + keyCode + ", event: " + event);
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
        ZLog.f386189b.k("NormalRenderTextureView", TokenParser.SP + this + ", onPause");
        this.isPause = true;
        if (this.isZPlanProcess) {
            Handler handler = this.uiHandler;
            if (handler != null) {
                final String str = MiniSDKConst.NOTIFY_EVENT_ONPAUSE;
                handler.post(new Runnable() { // from class: com.tencent.zplan.world.view.NormalRenderTextureView$onPause$$inlined$doOnUIThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZLog zLog = ZLog.f386189b;
                        zLog.k("NormalRenderTextureView", "doOnUIThread before task, from: " + str);
                        Activity activity2 = activity;
                        if (activity2 != null) {
                            UE4.clearWindow(true);
                            UE4.pauseEngine(activity2);
                        }
                        zLog.k("NormalRenderTextureView", "doOnUIThread after task, from: " + str);
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

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        this.surface = new Surface(surfaceTexture);
        this.curTexture = surfaceTexture;
        ZLog zLog = ZLog.f386189b;
        zLog.k("NormalRenderTextureView", TokenParser.SP + this + ", onSurfaceTextureAvailable : " + this.surface + ", width=" + width + ", height=" + height);
        if (this.isZPlanProcess) {
            Handler handler = this.uiHandler;
            if (handler != null) {
                final String str = "onSurfaceTextureAvailable";
                handler.post(new Runnable() { // from class: com.tencent.zplan.world.view.NormalRenderTextureView$onSurfaceTextureAvailable$$inlined$doOnUIThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Surface surface;
                        ZLog zLog2 = ZLog.f386189b;
                        zLog2.k("NormalRenderTextureView", "doOnUIThread before task, from: " + str);
                        surface = this.surface;
                        UE4.initWindow(surface);
                        zLog2.k("NormalRenderTextureView", "doOnUIThread after task, from: " + str);
                    }
                });
            }
        } else if (this.isPeakProcess) {
            zLog.k("NormalRenderTextureView", "setSuface : " + this.surface);
            ZPlanIPCHelper zPlanIPCHelper = ZPlanIPCHelper.f385519j;
            Surface surface = this.surface;
            Intrinsics.checkNotNull(surface);
            zPlanIPCHelper.E(surface);
        } else {
            zLog.k("NormalRenderTextureView", "agindage, setSuface : " + this.surface);
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            Surface surface2 = this.surface;
            Intrinsics.checkNotNull(surface2);
            zPlanServiceHelper.U0(surface2);
        }
        d dVar = this.textureViewListener;
        if (dVar != null) {
            dVar.b(this.surface, width, height);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        ZLog.f386189b.k("NormalRenderTextureView", TokenParser.SP + this + ", onSurfaceTextureDestroyed : " + surfaceTexture);
        if (Intrinsics.areEqual(surfaceTexture, this.curTexture)) {
            this.surface = null;
        }
        d dVar = this.textureViewListener;
        if (dVar != null) {
            dVar.onSurfaceDestroyed(new Surface(surfaceTexture));
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        this.surface = new Surface(surfaceTexture);
        this.curTexture = surfaceTexture;
        if (!this.isPause && getVisibility() == 0) {
            ZLog.f386189b.k("NormalRenderTextureView", TokenParser.SP + this + ", onSurfaceTextureSizeChanged : " + this.surface + ", width=" + width + ", height=" + height);
            if (this.isZPlanProcess) {
                Handler handler = this.uiHandler;
                if (handler != null) {
                    final String str = "onSurfaceTextureSizeChanged";
                    handler.post(new Runnable() { // from class: com.tencent.zplan.world.view.NormalRenderTextureView$onSurfaceTextureSizeChanged$$inlined$doOnUIThread$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            Surface surface;
                            ZLog zLog = ZLog.f386189b;
                            zLog.k("NormalRenderTextureView", "doOnUIThread before task, from: " + str);
                            surface = this.surface;
                            UE4.resizeWindow(surface);
                            zLog.k("NormalRenderTextureView", "doOnUIThread after task, from: " + str);
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
            d dVar = this.textureViewListener;
            if (dVar != null) {
                dVar.a(this.surface, width, height);
                return;
            }
            return;
        }
        ZLog.f386189b.k("NormalRenderTextureView", "onSurfaceTextureSizeChanged isPause: " + this.isPause + ", visibility: " + getVisibility() + ", return");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
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
        ZLog.f386189b.k("NormalRenderTextureView", "setNeedEvent : " + needEvent);
        this.needInputEvent = needEvent;
    }

    @Override // com.tencent.zplan.world.view.a
    public void setOnTouchEventListener(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onTouchListener = listener;
    }

    @Override // com.tencent.zplan.world.view.a
    public void setTextureViewListener(@Nullable d listener) {
        this.textureViewListener = listener;
    }

    public /* synthetic */ NormalRenderTextureView(Context context, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z16, (i3 & 4) != 0 ? true : z17);
    }

    @Override // com.tencent.zplan.world.view.a
    @NotNull
    public View getView() {
        return this;
    }
}
