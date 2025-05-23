package com.tencent.filament.zplan.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uk0.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0002\u0019\u001bB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+B\u0019\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b*\u0010.J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\nH\u0016J \u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J \u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0006\u0010\u0019\u001a\u00020\u0005J\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u00060"}, d2 = {"Lcom/tencent/filament/zplan/view/AVFilamentTextureView;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/filament/zplan/view/AVFilamentTextureView$b;", "textureParam", "", "setTextureParam", "Luk0/c;", "listener", "setFilamentRenderListener", "Landroid/view/View$OnTouchListener;", "setOnTouchListener", "Landroid/graphics/SurfaceTexture;", "surface", "", "width", "height", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "a", "Landroid/view/Surface;", "b", "d", "Luk0/c;", "filamentRenderListener", "e", "Landroid/view/Surface;", "curSurface", "f", "Landroid/view/View$OnTouchListener;", "onTouchListener", h.F, "Lcom/tencent/filament/zplan/view/AVFilamentTextureView$b;", "param", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/filament/zplan/view/AVFilamentTextureView$b;Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class AVFilamentTextureView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private c filamentRenderListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Surface curSurface;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View.OnTouchListener onTouchListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FilamentTextureParam param;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/filament/zplan/view/AVFilamentTextureView$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "isOpaque", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "enableTouch", "<init>", "(ZLjava/lang/Boolean;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.view.AVFilamentTextureView$b, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class FilamentTextureParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isOpaque;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Boolean enableTouch;

        public FilamentTextureParam() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Boolean getEnableTouch() {
            return this.enableTouch;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsOpaque() {
            return this.isOpaque;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof FilamentTextureParam) {
                    FilamentTextureParam filamentTextureParam = (FilamentTextureParam) other;
                    if (this.isOpaque != filamentTextureParam.isOpaque || !Intrinsics.areEqual(this.enableTouch, filamentTextureParam.enableTouch)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            int i3;
            boolean z16 = this.isOpaque;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            Boolean bool = this.enableTouch;
            if (bool != null) {
                i3 = bool.hashCode();
            } else {
                i3 = 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "FilamentTextureParam(isOpaque=" + this.isOpaque + ", enableTouch=" + this.enableTouch + ")";
        }

        public FilamentTextureParam(boolean z16, @Nullable Boolean bool) {
            this.isOpaque = z16;
            this.enableTouch = bool;
        }

        public /* synthetic */ FilamentTextureParam(boolean z16, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? Boolean.FALSE : bool);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AVFilamentTextureView(@NotNull FilamentTextureParam textureParam, @NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(textureParam, "textureParam");
        Intrinsics.checkNotNullParameter(context, "context");
        setSurfaceTextureListener(this);
        this.param = textureParam;
        if (textureParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        }
        setOpaque(textureParam.getIsOpaque());
    }

    public final void a() {
        FLog.INSTANCE.i("FilamentTextureView", "destroySurface, release surface");
        Surface surface = this.curSurface;
        if (surface != null) {
            surface.release();
        }
        this.curSurface = null;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Surface getCurSurface() {
        return this.curSurface;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        FLog.INSTANCE.i("FilamentTextureView", "onSurfaceTextureAvailable, surface: " + surface + ", w: " + width + ", h: " + height);
        Surface surface2 = new Surface(surface);
        this.curSurface = surface2;
        c cVar = this.filamentRenderListener;
        if (cVar != null) {
            Intrinsics.checkNotNull(surface2);
            cVar.b(surface2, width, height);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
        c cVar;
        Intrinsics.checkNotNullParameter(surface, "surface");
        FLog.INSTANCE.i("FilamentTextureView", "onSurfaceTextureDestroyed, surface: " + surface);
        Surface surface2 = this.curSurface;
        if (surface2 != null && (cVar = this.filamentRenderListener) != null) {
            cVar.onSurfaceDestroyed(surface2);
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        FLog.INSTANCE.i("FilamentTextureView", "onSurfaceTextureSizeChanged, surface: " + surface + ", w: " + width + ", h: " + height);
        Surface surface2 = new Surface(surface);
        this.curSurface = surface2;
        c cVar = this.filamentRenderListener;
        if (cVar != null) {
            Intrinsics.checkNotNull(surface2);
            cVar.a(surface2, width, height);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        FilamentTextureParam filamentTextureParam = this.param;
        if (filamentTextureParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        }
        if (Intrinsics.areEqual(filamentTextureParam.getEnableTouch(), Boolean.FALSE)) {
            return false;
        }
        View.OnTouchListener onTouchListener = this.onTouchListener;
        if (onTouchListener == null) {
            return true;
        }
        Intrinsics.checkNotNull(onTouchListener);
        return onTouchListener.onTouch(this, event);
    }

    public final void setFilamentRenderListener(@Nullable c listener) {
        FLog.INSTANCE.i("FilamentTextureView", "setFilamentRenderListener, listener: " + listener);
        this.filamentRenderListener = listener;
    }

    @Override // android.view.View
    public void setOnTouchListener(@Nullable View.OnTouchListener listener) {
        FLog.INSTANCE.i("FilamentTextureView", "setOnTouchListener, listener: " + this.onTouchListener);
        this.onTouchListener = listener;
    }

    public final void setTextureParam(@NotNull FilamentTextureParam textureParam) {
        Intrinsics.checkNotNullParameter(textureParam, "textureParam");
        this.param = textureParam;
        if (textureParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        }
        setOpaque(textureParam.getIsOpaque());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AVFilamentTextureView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        setSurfaceTextureListener(this);
        FilamentTextureParam filamentTextureParam = new FilamentTextureParam(false, null, 3, 0 == true ? 1 : 0);
        this.param = filamentTextureParam;
        setOpaque(filamentTextureParam.getIsOpaque());
    }
}
