package com.tencent.zplan.world.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.epicgames.ue4.GameActivity;
import com.epicgames.ue4.UE4;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.zplan.engine.ZPlanIPCHelper;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.world.render.parallel.AbsZPlanWorldRender;
import com.tencent.zplan.world.view.c;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u000eB1\u0012\u0006\u0010B\u001a\u00020A\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010:\u001a\u00020\u001d\u0012\u0006\u0010<\u001a\u00020\u001d\u0012\u0006\u0010@\u001a\u00020=\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J(\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\"H\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0018\u0010-\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010'R\u0018\u00101\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0014\u0010:\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00106R\u0014\u0010<\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00106R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006F"}, d2 = {"Lcom/tencent/zplan/world/view/WorldRenderSurfaceView;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback2;", "Lcom/tencent/zplan/world/view/c;", "Landroid/view/MotionEvent;", "event", "", "c", "", "worldID", "setWorldID", "Lcom/tencent/zplan/world/view/d;", "listener", "setRenderListener", "a", "b", "Landroid/view/View;", "getView", "Landroid/view/SurfaceHolder;", "holder", "surfaceCreated", "format", "width", "height", "surfaceChanged", "surfaceDestroyed", "surfaceRedrawNeeded", "Lcom/tencent/zplan/world/view/b;", "setOnTouchEventListener", "", "needEvent", "setNeedEvent", "onTouchEvent", "keyCode", "Landroid/view/KeyEvent;", "onKeyDown", "Landroid/view/Surface;", "getSurface", "d", "I", "viewWidth", "e", "viewHeight", "f", "Landroid/view/Surface;", "viewSurface", h.F, "i", "Lcom/tencent/zplan/world/view/d;", "zPlanSurfaceTextureListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/zplan/world/view/b;", "onTouchListener", BdhLogUtil.LogTag.Tag_Conn, "Z", "needInputEvent", "D", "E", "inZPlanProcess", UserInfo.SEX_FEMALE, "isPeakProcess", "Lcom/tencent/zplan/world/render/parallel/AbsZPlanWorldRender;", "G", "Lcom/tencent/zplan/world/render/parallel/AbsZPlanWorldRender;", "zPlanWorldRender", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;ZZZLcom/tencent/zplan/world/render/parallel/AbsZPlanWorldRender;)V", "H", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class WorldRenderSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, c {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean needInputEvent;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean needEvent;

    /* renamed from: E, reason: from kotlin metadata */
    private final boolean inZPlanProcess;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean isPeakProcess;

    /* renamed from: G, reason: from kotlin metadata */
    private final AbsZPlanWorldRender zPlanWorldRender;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int viewWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int viewHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Surface viewSurface;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int worldID;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private d zPlanSurfaceTextureListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private b onTouchListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorldRenderSurfaceView(@NotNull Context context, boolean z16, boolean z17, boolean z18, @NotNull AbsZPlanWorldRender zPlanWorldRender) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(zPlanWorldRender, "zPlanWorldRender");
        this.needEvent = z16;
        this.inZPlanProcess = z17;
        this.isPeakProcess = z18;
        this.zPlanWorldRender = zPlanWorldRender;
        this.viewWidth = -1;
        this.viewHeight = -1;
        this.worldID = -1;
        this.needInputEvent = true;
        getHolder().addCallback(this);
        this.needInputEvent = z16;
    }

    private final void c(MotionEvent event) {
        int action = event.getAction() & 255;
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override // com.tencent.zplan.world.view.c
    /* renamed from: a, reason: from getter */
    public int getViewWidth() {
        return this.viewWidth;
    }

    @Override // com.tencent.zplan.world.view.c
    /* renamed from: b, reason: from getter */
    public int getViewHeight() {
        return this.viewHeight;
    }

    @Override // com.tencent.zplan.world.view.c
    @Nullable
    public Surface getSurface() {
        ZLog.f386189b.k("WorldRenderSurfaceView", "getSurface, viewSurface: " + this.viewSurface + ", renderHashCode: " + this.zPlanWorldRender.getRenderHashCode());
        return this.viewSurface;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ZLog.f386189b.k("WorldRenderSurfaceView", "onKeyDown keyCode: " + keyCode + ", event: " + event);
        if (this.inZPlanProcess) {
            UE4.inputEvent(event);
            GameActivity.Get().onKeyDown(keyCode, event);
        } else if (this.isPeakProcess) {
            ZPlanIPCHelper.f385519j.r(keyCode, event);
        } else {
            ZPlanServiceHelper.I.s0(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        b bVar = this.onTouchListener;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            return bVar.onTouchEvent(event);
        }
        if (!this.needInputEvent) {
            return super.onTouchEvent(event);
        }
        if (this.inZPlanProcess) {
            UE4.inputEvent(event);
        } else if (this.isPeakProcess) {
            ZPlanIPCHelper.f385519j.s(event);
        } else {
            ZPlanServiceHelper.I.w0(event);
        }
        c(event);
        return true;
    }

    public void setNeedEvent(boolean needEvent) {
        ZLog.f386189b.k("WorldRenderSurfaceView", "setNeedEvent : " + needEvent);
        this.needInputEvent = needEvent;
    }

    @Override // com.tencent.zplan.world.view.c
    public void setOnTouchEventListener(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onTouchListener = listener;
    }

    @Override // com.tencent.zplan.world.view.c
    public void setRenderListener(@Nullable d listener) {
        this.zPlanSurfaceTextureListener = listener;
    }

    @Override // com.tencent.zplan.world.view.c
    public void setWorldID(int worldID) {
        ZLog.f386189b.k("WorldRenderSurfaceView", "setWorldID : " + worldID + ", render: " + this.zPlanWorldRender.getRenderHashCode());
        this.worldID = worldID;
    }

    @Deprecated(message = "\u529f\u80fd\u6682\u672a\u5f00\u542f\uff0c\u540e\u7eed\u4f7f\u7528")
    public void setZPlanWorldOffscreenRender(@NotNull com.tencent.zplan.world.render.offscreen.a offscreenRender) {
        Intrinsics.checkNotNullParameter(offscreenRender, "offscreenRender");
        c.a.a(this, offscreenRender);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(@NotNull SurfaceHolder holder, int format, int width, int height) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.viewSurface = holder.getSurface();
        ZLog.f386189b.k("WorldRenderSurfaceView", "surfaceChanged, renderHashCode: " + this.zPlanWorldRender.getRenderHashCode() + ", width: " + width + ", height: " + height + ", worldID:" + this.worldID + ", viewSurface: " + this.viewSurface);
        this.viewWidth = width;
        this.viewHeight = height;
        this.zPlanWorldRender.u();
        this.zPlanWorldRender.p(width, height);
        d dVar = this.zPlanSurfaceTextureListener;
        if (dVar != null) {
            dVar.a(this.viewSurface, width, height);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(@NotNull SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.viewSurface = holder.getSurface();
        ZLog.f386189b.k("WorldRenderSurfaceView", "surfaceCreated, worldID:" + this.worldID + ", renderHashCode: " + this.zPlanWorldRender.getRenderHashCode() + ", width: " + getWidth() + ", height: " + getHeight() + ", viewSurface: " + this.viewSurface);
        this.viewWidth = getWidth();
        this.viewHeight = getHeight();
        this.zPlanWorldRender.u();
        this.zPlanWorldRender.p(getWidth(), getHeight());
        d dVar = this.zPlanSurfaceTextureListener;
        if (dVar != null) {
            dVar.b(this.viewSurface, getWidth(), getHeight());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(@NotNull SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ZLog.f386189b.k("WorldRenderSurfaceView", "surfaceDestroyed, renderHashCode: " + this.zPlanWorldRender.getRenderHashCode() + ", worldID:" + this.worldID);
        d dVar = this.zPlanSurfaceTextureListener;
        if (dVar != null) {
            dVar.onSurfaceDestroyed(holder.getSurface());
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(@NotNull SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // com.tencent.zplan.world.view.c
    @NotNull
    public View getView() {
        return this;
    }
}
