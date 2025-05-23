package com.tencent.filament.zplan.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.filament.zplan.data.RenderSize;
import com.tencent.filament.zplan.view.controller.GYFZPlanController;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uk0.d;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001>B\u0019\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00106\u001a\u000205\u00a2\u0006\u0004\b7\u00108B+\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00109\u001a\u00020*\u0012\u0006\u0010:\u001a\u00020\u000e\u0012\b\u0010;\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b7\u0010<J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J \u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J \u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u0005R\u0018\u0010!\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/\u00a8\u0006?"}, d2 = {"Lcom/tencent/filament/zplan/view/GYFZPlanTextureView;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/view/View$OnTouchListener;", "listener", "", "setOnTouchListener", "Landroid/graphics/SurfaceTexture;", "surface", "", "width", "height", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController;", "controller", "setController", "Ljava/util/concurrent/CountDownLatch;", "countDownLatch", "e", "d", "Luk0/d;", "setFilamentRenderListener", "autoInit", "setAutoInitFilament", "f", "Luk0/d;", "filamentRenderListener", "Landroid/view/Surface;", "Landroid/view/Surface;", "curSurface", "Landroid/view/View$OnTouchListener;", "onTouchListener", h.F, "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController;", "filamentController", "Lcom/tencent/filament/zplan/data/RenderSize;", "i", "Lcom/tencent/filament/zplan/data/RenderSize;", "renderSize", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isAutoInitFilament", BdhLogUtil.LogTag.Tag_Conn, "isEnableDelayed", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "size", "isOpaque", "enableTouch", "(Landroid/content/Context;Lcom/tencent/filament/zplan/data/RenderSize;ZLjava/lang/Boolean;)V", "D", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class GYFZPlanTextureView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isEnableDelayed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private d filamentRenderListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Surface curSurface;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View.OnTouchListener onTouchListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GYFZPlanController filamentController;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RenderSize renderSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isAutoInitFilament;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/filament/zplan/view/GYFZPlanTextureView$b", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$d;", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class b implements GYFZPlanController.d {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f106280b;

        b(CountDownLatch countDownLatch) {
            this.f106280b = countDownLatch;
        }

        @Override // com.tencent.filament.zplan.view.controller.GYFZPlanController.d
        public void a() {
            d dVar;
            GYFZPlanTextureView.this.f();
            this.f106280b.countDown();
            if (GYFZPlanTextureView.this.isEnableDelayed && GYFZPlanTextureView.this.curSurface != null && (dVar = GYFZPlanTextureView.this.filamentRenderListener) != null) {
                Surface surface = GYFZPlanTextureView.this.curSurface;
                Intrinsics.checkNotNull(surface);
                dVar.b(surface);
            }
            FLog.INSTANCE.i("FilamentTextureView", "onViewerDestroy, isEnableDelayed " + GYFZPlanTextureView.this.isEnableDelayed);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GYFZPlanTextureView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.renderSize = new RenderSize(0, 0);
        this.isAutoInitFilament = true;
        this.isEnableDelayed = FilamentFeatureUtil.f106409g.i();
        setSurfaceTextureListener(this);
        FLog.INSTANCE.i("FilamentTextureView", "constructor, listener constructor1:");
    }

    public final void d() {
        d dVar;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        e(countDownLatch);
        if (!this.isEnableDelayed) {
            countDownLatch.await(200L, TimeUnit.MILLISECONDS);
            Surface surface = this.curSurface;
            if (surface != null && (dVar = this.filamentRenderListener) != null) {
                Intrinsics.checkNotNull(surface);
                dVar.b(surface);
            }
        }
        FLog.INSTANCE.i("FilamentTextureView", "onSurfaceTextureDestroyed, surface end, isEnableDelayed " + this.isEnableDelayed);
    }

    public final void e(@NotNull CountDownLatch countDownLatch) {
        Intrinsics.checkNotNullParameter(countDownLatch, "countDownLatch");
        GYFZPlanController gYFZPlanController = this.filamentController;
        if (gYFZPlanController != null) {
            gYFZPlanController.y(new b(countDownLatch));
        }
    }

    public final void f() {
        FLog.INSTANCE.i("FilamentTextureView", "destroySurface, release surface");
        Surface surface = this.curSurface;
        if (surface != null) {
            surface.release();
        }
        this.curSurface = null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        FLog.INSTANCE.i("FilamentTextureView", "onSurfaceTextureAvailable, surface: " + surface + ", w: " + width + ", h: " + height);
        this.curSurface = new Surface(surface);
        this.renderSize = new RenderSize(width, height);
        GYFZPlanController gYFZPlanController = this.filamentController;
        if (gYFZPlanController != null) {
            Surface surface2 = this.curSurface;
            Intrinsics.checkNotNull(surface2);
            gYFZPlanController.d0(surface2, this.renderSize.getWidth(), this.renderSize.getHeight());
        }
        d dVar = this.filamentRenderListener;
        if (dVar != null) {
            Surface surface3 = this.curSurface;
            Intrinsics.checkNotNull(surface3);
            dVar.a(surface3, this.renderSize.getWidth(), this.renderSize.getHeight());
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        FLog.INSTANCE.i("FilamentTextureView", "onSurfaceTextureDestroyed, surface: " + surface);
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        FLog.INSTANCE.i("FilamentTextureView", "onSurfaceTextureSizeChanged, surface: " + surface + ", w: " + width + ", h: " + height);
        this.curSurface = new Surface(surface);
        this.renderSize = new RenderSize(width, height);
        GYFZPlanController gYFZPlanController = this.filamentController;
        if (gYFZPlanController != null) {
            Surface surface2 = this.curSurface;
            Intrinsics.checkNotNull(surface2);
            gYFZPlanController.d0(surface2, this.renderSize.getWidth(), this.renderSize.getHeight());
        }
        d dVar = this.filamentRenderListener;
        if (dVar != null) {
            Surface surface3 = this.curSurface;
            Intrinsics.checkNotNull(surface3);
            dVar.onSurfaceChanged(surface3);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        d dVar = this.filamentRenderListener;
        if (dVar != null) {
            dVar.onSurfaceChanged(new Surface(surface));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        boolean z16;
        View.OnTouchListener onTouchListener = this.onTouchListener;
        if (onTouchListener != null) {
            z16 = onTouchListener.onTouch(this, event);
        } else {
            z16 = false;
        }
        if (!z16) {
            super.onTouchEvent(event);
        }
        return z16;
    }

    public final void setAutoInitFilament(boolean autoInit) {
        this.isAutoInitFilament = autoInit;
    }

    public final void setController(@NotNull GYFZPlanController controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.filamentController = controller;
    }

    public final void setFilamentRenderListener(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        FLog.INSTANCE.i("FilamentTextureView", "setFilamentRenderListener listener: " + listener);
        this.filamentRenderListener = listener;
    }

    @Override // android.view.View
    public void setOnTouchListener(@Nullable View.OnTouchListener listener) {
        FLog.INSTANCE.i("FilamentTextureView", "setOnTouchListener, listener: " + this.onTouchListener);
        this.onTouchListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GYFZPlanTextureView(@NotNull Context context, @NotNull RenderSize size, boolean z16, @Nullable Boolean bool) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(size, "size");
        this.renderSize = new RenderSize(0, 0);
        this.isAutoInitFilament = true;
        this.isEnableDelayed = FilamentFeatureUtil.f106409g.i();
        setSurfaceTextureListener(this);
        FLog.INSTANCE.i("FilamentTextureView", "constructor, listener constructor2:");
        this.renderSize = size;
        setOpaque(z16);
    }
}
