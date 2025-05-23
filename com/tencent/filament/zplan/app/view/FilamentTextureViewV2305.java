package com.tencent.filament.zplan.app.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.TextureView;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.view.controller.FilamentTouchController;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0002\u0007\u0006B\u0011\b\u0016\u0012\u0006\u0010$\u001a\u00020\u0003\u00a2\u0006\u0004\b%\u0010&B\u0019\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b%\u0010+J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006-"}, d2 = {"Lcom/tencent/filament/zplan/app/view/FilamentTextureViewV2305;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/filament/zplan/app/view/FilamentTextureViewV2305$b;", "param", "", "b", "a", "listener", "setSurfaceTextureListener", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "", "width", "height", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureUpdated", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "d", "Lcom/tencent/filament/zplan/app/view/FilamentTextureViewV2305$b;", "e", "Landroid/graphics/SurfaceTexture;", "filamentTargetTexture", "f", "Landroid/view/TextureView$SurfaceTextureListener;", "hookListener", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController;", h.F, "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController;", "touchController", "textureParam", "<init>", "(Lcom/tencent/filament/zplan/app/view/FilamentTextureViewV2305$b;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentTextureViewV2305 extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final FilamentTextureParamV2305 param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SurfaceTexture filamentTargetTexture;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextureView.SurfaceTextureListener hookListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FilamentTouchController touchController;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001f\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\n\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/filament/zplan/app/view/FilamentTextureViewV2305$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/content/Context;", "a", "Landroid/content/Context;", "b", "()Landroid/content/Context;", "context", "Z", "d", "()Z", "isOpaque", "c", "enableTouch", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "app", "<init>", "(Landroid/content/Context;ZZLjava/lang/ref/WeakReference;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.app.view.FilamentTextureViewV2305$b, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class FilamentTextureParamV2305 {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isOpaque;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean enableTouch;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final WeakReference<FilamentNativeAppV2305> app;

        public FilamentTextureParamV2305(@NotNull Context context, boolean z16, boolean z17, @Nullable WeakReference<FilamentNativeAppV2305> weakReference) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.isOpaque = z16;
            this.enableTouch = z17;
            this.app = weakReference;
        }

        @Nullable
        public final WeakReference<FilamentNativeAppV2305> a() {
            return this.app;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getEnableTouch() {
            return this.enableTouch;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsOpaque() {
            return this.isOpaque;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof FilamentTextureParamV2305) {
                    FilamentTextureParamV2305 filamentTextureParamV2305 = (FilamentTextureParamV2305) other;
                    if (!Intrinsics.areEqual(this.context, filamentTextureParamV2305.context) || this.isOpaque != filamentTextureParamV2305.isOpaque || this.enableTouch != filamentTextureParamV2305.enableTouch || !Intrinsics.areEqual(this.app, filamentTextureParamV2305.app)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3;
            Context context = this.context;
            int i16 = 0;
            if (context != null) {
                i3 = context.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            boolean z16 = this.isOpaque;
            int i18 = 1;
            int i19 = z16;
            if (z16 != 0) {
                i19 = 1;
            }
            int i26 = (i17 + i19) * 31;
            boolean z17 = this.enableTouch;
            if (!z17) {
                i18 = z17 ? 1 : 0;
            }
            int i27 = (i26 + i18) * 31;
            WeakReference<FilamentNativeAppV2305> weakReference = this.app;
            if (weakReference != null) {
                i16 = weakReference.hashCode();
            }
            return i27 + i16;
        }

        @NotNull
        public String toString() {
            return "FilamentTextureParamV2305(context=" + this.context + ", isOpaque=" + this.isOpaque + ", enableTouch=" + this.enableTouch + ", app=" + this.app + ")";
        }

        public /* synthetic */ FilamentTextureParamV2305(Context context, boolean z16, boolean z17, WeakReference weakReference, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? false : z17, (i3 & 8) != 0 ? null : weakReference);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/filament/zplan/app/view/FilamentTextureViewV2305$c", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController$b;", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "event", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class c implements FilamentTouchController.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FilamentTextureParamV2305 f105621a;

        c(FilamentTextureParamV2305 filamentTextureParamV2305) {
            this.f105621a = filamentTextureParamV2305;
        }

        @Override // com.tencent.filament.zplan.view.controller.FilamentTouchController.b
        public void q(@NotNull TouchEvent event) {
            FilamentNativeAppV2305 filamentNativeAppV2305;
            Intrinsics.checkNotNullParameter(event, "event");
            WeakReference<FilamentNativeAppV2305> a16 = this.f105621a.a();
            if (a16 != null && (filamentNativeAppV2305 = a16.get()) != null) {
                filamentNativeAppV2305.dispatchEvent(null, "onTouchEvent", new Gson().toJson(event));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentTextureViewV2305(@NotNull FilamentTextureParamV2305 textureParam) {
        super(textureParam.getContext());
        Intrinsics.checkNotNullParameter(textureParam, "textureParam");
        FLog.INSTANCE.i("FilamentTextureViewV2305", "init, " + this);
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.detachFromGLContext();
        setSurfaceTexture(surfaceTexture);
        Unit unit = Unit.INSTANCE;
        this.filamentTargetTexture = surfaceTexture;
        super.setSurfaceTextureListener(this);
        this.param = textureParam;
        b(textureParam);
    }

    private final void b(FilamentTextureParamV2305 param) {
        setOpaque(param.getIsOpaque());
        if (param.getEnableTouch()) {
            this.touchController = new FilamentTouchController(param.getContext(), new c(param));
        }
    }

    public final void a() {
        FLog.INSTANCE.i("FilamentTextureViewV2305", "release, filamentTargetTexture:" + this.filamentTargetTexture + ", " + this);
        SurfaceTexture surfaceTexture = this.filamentTargetTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        this.filamentTargetTexture = null;
        this.touchController = null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        FLog.INSTANCE.i("FilamentTextureViewV2305", "onSurfaceTextureAvailable(). surfaceTexture:" + surfaceTexture + ", width:" + width + ", height:" + height + ", " + this);
        SurfaceTexture surfaceTexture2 = this.filamentTargetTexture;
        if (surfaceTexture2 != null) {
            setSurfaceTexture(surfaceTexture2);
            TextureView.SurfaceTextureListener surfaceTextureListener = this.hookListener;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture2, width, height);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        FLog.INSTANCE.i("FilamentTextureViewV2305", "onSurfaceTextureDestroyed(). surfaceTexture: " + surfaceTexture + ", " + this);
        Intrinsics.areEqual(surfaceTexture, this.filamentTargetTexture);
        TextureView.SurfaceTextureListener surfaceTextureListener = this.hookListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        FLog.INSTANCE.i("FilamentTextureViewV2305", "onSurfaceTextureSizeChanged(). surfaceTexture:" + surfaceTexture + ", width:" + width + ", height:" + height + ", " + this);
        Intrinsics.areEqual(surfaceTexture, this.filamentTargetTexture);
        TextureView.SurfaceTextureListener surfaceTextureListener = this.hookListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, width, height);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        TextureView.SurfaceTextureListener surfaceTextureListener = this.hookListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureUpdated(surface);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        ScaleGestureDetector o16;
        GestureDetector m3;
        if (event == null || !this.param.getEnableTouch()) {
            return false;
        }
        FilamentTouchController filamentTouchController = this.touchController;
        if (filamentTouchController != null) {
            filamentTouchController.z(event);
        }
        if (event.getPointerCount() == 1) {
            FilamentTouchController filamentTouchController2 = this.touchController;
            if (filamentTouchController2 != null && (m3 = filamentTouchController2.m()) != null) {
                m3.onTouchEvent(event);
            }
        } else {
            FilamentTouchController filamentTouchController3 = this.touchController;
            if (filamentTouchController3 != null && (o16 = filamentTouchController3.o()) != null) {
                o16.onTouchEvent(event);
            }
        }
        return true;
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(@Nullable TextureView.SurfaceTextureListener listener) {
        this.hookListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentTextureViewV2305(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        FLog.INSTANCE.i("FilamentTextureViewV2305", "init, " + this);
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.detachFromGLContext();
        setSurfaceTexture(surfaceTexture);
        Unit unit = Unit.INSTANCE;
        this.filamentTargetTexture = surfaceTexture;
        super.setSurfaceTextureListener(this);
        FilamentTextureParamV2305 filamentTextureParamV2305 = new FilamentTextureParamV2305(context, false, false, null, 14, null);
        this.param = filamentTextureParamV2305;
        b(filamentTextureParamV2305);
    }
}
