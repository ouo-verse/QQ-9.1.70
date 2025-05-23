package com.tencent.zplan.world;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TextureView;
import com.epicgames.ue4.UE4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001)J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J \u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J \u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010 \u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006*"}, d2 = {"Lcom/tencent/zplan/world/OffscreenWorldRenderView;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "", "worldID", "", "setOffscreenWorldID", "Landroid/graphics/SurfaceTexture;", "surface", "width", "height", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "listener", "setTextureListener", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "d", "Landroid/view/TextureView$SurfaceTextureListener;", "getMTextureListener", "()Landroid/view/TextureView$SurfaceTextureListener;", "setMTextureListener", "(Landroid/view/TextureView$SurfaceTextureListener;)V", "mTextureListener", "e", "Z", "getNeedEvent", "()Z", "needEvent", "Lcom/tencent/zplan/world/a;", "mOffscreenRender", "Lcom/tencent/zplan/world/a;", "getMOffscreenRender", "()Lcom/tencent/zplan/world/a;", "setMOffscreenRender", "(Lcom/tencent/zplan/world/a;)V", "f", "a", "render_library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes27.dex */
public final class OffscreenWorldRenderView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextureView.SurfaceTextureListener mTextureListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean needEvent;

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
        Intrinsics.checkParameterIsNotNull(surface, "surface");
        Log.d("OffscreenRenderView", "onSurfaceTextureAvailable ");
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureAvailable(surface, width, height);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
        Intrinsics.checkParameterIsNotNull(surface, "surface");
        Log.d("OffscreenRenderView", "onSurfaceTextureDestroyed ");
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mTextureListener;
        if (surfaceTextureListener != null) {
            if (surfaceTextureListener == null) {
                Intrinsics.throwNpe();
            }
            return surfaceTextureListener.onSurfaceTextureDestroyed(surface);
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
        Intrinsics.checkParameterIsNotNull(surface, "surface");
        Log.d("OffscreenRenderView", "onSurfaceTextureSizeChanged ");
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureSizeChanged(surface, width, height);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
        Intrinsics.checkParameterIsNotNull(surface, "surface");
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (this.needEvent) {
            UE4.inputEvent(event);
            return true;
        }
        return super.onTouchEvent(event);
    }

    public final void setMTextureListener(@Nullable TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.mTextureListener = surfaceTextureListener;
    }

    public final void setTextureListener(@NotNull TextureView.SurfaceTextureListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.mTextureListener = listener;
    }

    public final void setMOffscreenRender(@Nullable a aVar) {
    }

    public final void setOffscreenWorldID(int worldID) {
    }
}
