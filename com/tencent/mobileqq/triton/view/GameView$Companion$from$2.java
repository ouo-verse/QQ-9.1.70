package com.tencent.mobileqq.triton.view;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.tencent.mobileqq.triton.view.GameView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000K\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\u0010\u001a\u00020\u00112#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013H\u0017J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u001c"}, d2 = {"com/tencent/mobileqq/triton/view/GameView$Companion$from$2", "Lcom/tencent/mobileqq/triton/view/GameView;", "_surface", "Landroid/view/Surface;", "_surfaceTexture", "Landroid/graphics/SurfaceTexture;", "displayDensity", "", "getDisplayDensity", "()F", "height", "", "getHeight", "()I", "width", "getWidth", "setGameOnTouchListener", "", "listener", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lkotlin/ParameterName;", "name", "event", "", "setSurfaceCallback", "surfaceCallback", "Lcom/tencent/mobileqq/triton/view/GameView$SurfaceCallback;", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class GameView$Companion$from$2 implements GameView {
    final /* synthetic */ TextureView $textureView;
    private Surface _surface;
    private volatile SurfaceTexture _surfaceTexture;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GameView$Companion$from$2(TextureView textureView) {
        this.$textureView = textureView;
    }

    @Override // com.tencent.mobileqq.triton.view.GameView
    public float getDisplayDensity() {
        Resources resources = this.$textureView.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "textureView.resources");
        return resources.getDisplayMetrics().density;
    }

    @Override // com.tencent.mobileqq.triton.view.GameView
    /* renamed from: getHeight */
    public int get_height() {
        return this.$textureView.getMeasuredHeight();
    }

    @Override // com.tencent.mobileqq.triton.view.GameView
    /* renamed from: getWidth */
    public int get_width() {
        return this.$textureView.getMeasuredWidth();
    }

    @Override // com.tencent.mobileqq.triton.view.GameView
    public void onSwapBuffer() {
        GameView.DefaultImpls.onSwapBuffer(this);
    }

    @Override // com.tencent.mobileqq.triton.view.GameView
    @SuppressLint({"ClickableViewAccessibility"})
    public void setGameOnTouchListener(@Nullable final Function1<? super MotionEvent, Boolean> listener) {
        View.OnTouchListener onTouchListener;
        TextureView textureView = this.$textureView;
        if (listener != null) {
            onTouchListener = new View.OnTouchListener() { // from class: com.tencent.mobileqq.triton.view.GameView$Companion$from$2$setGameOnTouchListener$1$1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent event) {
                    Function1 function1 = Function1.this;
                    Intrinsics.checkExpressionValueIsNotNull(event, "event");
                    return ((Boolean) function1.invoke(event)).booleanValue();
                }
            };
        } else {
            onTouchListener = null;
        }
        textureView.setOnTouchListener(onTouchListener);
    }

    @Override // com.tencent.mobileqq.triton.view.GameView
    public void setSurfaceCallback(@Nullable final GameView.SurfaceCallback surfaceCallback) {
        if (surfaceCallback != null) {
            TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.tencent.mobileqq.triton.view.GameView$Companion$from$2$setSurfaceCallback$surfaceTextureListener$1
                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
                    SurfaceTexture surfaceTexture;
                    Surface surface2;
                    Intrinsics.checkParameterIsNotNull(surface, "surface");
                    GameView$Companion$from$2.this._surfaceTexture = surface;
                    GameView$Companion$from$2 gameView$Companion$from$2 = GameView$Companion$from$2.this;
                    surfaceTexture = GameView$Companion$from$2.this._surfaceTexture;
                    gameView$Companion$from$2._surface = new Surface(surfaceTexture);
                    GameView.SurfaceCallback surfaceCallback2 = surfaceCallback;
                    surface2 = GameView$Companion$from$2.this._surface;
                    if (surface2 == null) {
                        Intrinsics.throwNpe();
                    }
                    surfaceCallback2.onSurfaceCreated(surface2);
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
                    Intrinsics.checkParameterIsNotNull(surface, "surface");
                    GameView$Companion$from$2.this._surfaceTexture = null;
                    GameView$Companion$from$2.this._surface = null;
                    surfaceCallback.onSurfaceDestroyed();
                    return true;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
                    Surface surface2;
                    Intrinsics.checkParameterIsNotNull(surface, "surface");
                    GameView.SurfaceCallback surfaceCallback2 = surfaceCallback;
                    surface2 = GameView$Companion$from$2.this._surface;
                    if (surface2 == null) {
                        Intrinsics.throwNpe();
                    }
                    surfaceCallback2.onSurfaceChanged(surface2, 1, width, height);
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
                    Intrinsics.checkParameterIsNotNull(surface, "surface");
                }
            };
            this.$textureView.setSurfaceTextureListener(surfaceTextureListener);
            if (this.$textureView.isAvailable()) {
                SurfaceTexture surfaceTexture = this.$textureView.getSurfaceTexture();
                if (surfaceTexture == null) {
                    Intrinsics.throwNpe();
                }
                surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, this.$textureView.getWidth(), this.$textureView.getHeight());
                SurfaceTexture surfaceTexture2 = this.$textureView.getSurfaceTexture();
                if (surfaceTexture2 == null) {
                    Intrinsics.throwNpe();
                }
                surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture2, this.$textureView.getWidth(), this.$textureView.getHeight());
                return;
            }
            return;
        }
        this.$textureView.setSurfaceTextureListener(null);
    }
}
