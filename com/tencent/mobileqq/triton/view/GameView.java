package com.tencent.mobileqq.triton.view;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.tencent.mobileqq.triton.view.GameView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aJ\b\u0010\f\u001a\u00020\rH\u0016J-\u0010\u000e\u001a\u00020\r2#\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010H&J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/triton/view/GameView;", "", "displayDensity", "", "getDisplayDensity", "()F", "height", "", "getHeight", "()I", "width", "getWidth", "onSwapBuffer", "", "setGameOnTouchListener", "listener", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lkotlin/ParameterName;", "name", "event", "", "setSurfaceCallback", "surfaceCallback", "Lcom/tencent/mobileqq/triton/view/GameView$SurfaceCallback;", "Companion", "SurfaceCallback", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface GameView {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/triton/view/GameView$Companion;", "", "()V", "from", "Lcom/tencent/mobileqq/triton/view/GameView;", "surfaceView", "Landroid/view/SurfaceView;", "textureView", "Landroid/view/TextureView;", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        Companion() {
        }

        @NotNull
        public final GameView from(@NotNull final SurfaceView surfaceView) {
            Intrinsics.checkParameterIsNotNull(surfaceView, "surfaceView");
            return new GameView(surfaceView) { // from class: com.tencent.mobileqq.triton.view.GameView$Companion$from$1
                final /* synthetic */ SurfaceView $surfaceView;
                private int _format;
                private int _height;
                private int _width;
                private GameView.SurfaceCallback surfaceCallback;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$surfaceView = surfaceView;
                    surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.tencent.mobileqq.triton.view.GameView$Companion$from$1.1
                        @Override // android.view.SurfaceHolder.Callback
                        public void surfaceChanged(@NotNull SurfaceHolder holder, int format, int width, int height) {
                            Intrinsics.checkParameterIsNotNull(holder, "holder");
                            GameView$Companion$from$1.this._format = format;
                            GameView$Companion$from$1.this._width = width;
                            GameView$Companion$from$1.this._height = height;
                            GameView.SurfaceCallback surfaceCallback = GameView$Companion$from$1.this.surfaceCallback;
                            if (surfaceCallback != null) {
                                Surface surface = holder.getSurface();
                                Intrinsics.checkExpressionValueIsNotNull(surface, "holder.surface");
                                surfaceCallback.onSurfaceChanged(surface, format, width, height);
                            }
                        }

                        @Override // android.view.SurfaceHolder.Callback
                        public void surfaceCreated(@NotNull SurfaceHolder holder) {
                            Intrinsics.checkParameterIsNotNull(holder, "holder");
                            GameView$Companion$from$1 gameView$Companion$from$1 = GameView$Companion$from$1.this;
                            gameView$Companion$from$1._width = gameView$Companion$from$1.$surfaceView.getWidth();
                            GameView$Companion$from$1 gameView$Companion$from$12 = GameView$Companion$from$1.this;
                            gameView$Companion$from$12._height = gameView$Companion$from$12.$surfaceView.getHeight();
                            GameView.SurfaceCallback surfaceCallback = GameView$Companion$from$1.this.surfaceCallback;
                            if (surfaceCallback != null) {
                                Surface surface = holder.getSurface();
                                Intrinsics.checkExpressionValueIsNotNull(surface, "holder.surface");
                                surfaceCallback.onSurfaceCreated(surface);
                            }
                        }

                        @Override // android.view.SurfaceHolder.Callback
                        public void surfaceDestroyed(@NotNull SurfaceHolder holder) {
                            Intrinsics.checkParameterIsNotNull(holder, "holder");
                            GameView.SurfaceCallback surfaceCallback = GameView$Companion$from$1.this.surfaceCallback;
                            if (surfaceCallback != null) {
                                surfaceCallback.onSurfaceDestroyed();
                            }
                        }
                    });
                }

                @Override // com.tencent.mobileqq.triton.view.GameView
                public float getDisplayDensity() {
                    Resources resources = this.$surfaceView.getResources();
                    Intrinsics.checkExpressionValueIsNotNull(resources, "surfaceView.resources");
                    return resources.getDisplayMetrics().density;
                }

                @Override // com.tencent.mobileqq.triton.view.GameView
                /* renamed from: getHeight, reason: from getter */
                public int get_height() {
                    return this._height;
                }

                @Override // com.tencent.mobileqq.triton.view.GameView
                /* renamed from: getWidth, reason: from getter */
                public int get_width() {
                    return this._width;
                }

                @Override // com.tencent.mobileqq.triton.view.GameView
                public void onSwapBuffer() {
                    GameView.DefaultImpls.onSwapBuffer(this);
                }

                @Override // com.tencent.mobileqq.triton.view.GameView
                @SuppressLint({"ClickableViewAccessibility"})
                public void setGameOnTouchListener(@Nullable final Function1<? super MotionEvent, Boolean> listener) {
                    View.OnTouchListener onTouchListener;
                    SurfaceView surfaceView2 = this.$surfaceView;
                    if (listener != null) {
                        onTouchListener = new View.OnTouchListener() { // from class: com.tencent.mobileqq.triton.view.GameView$Companion$from$1$setGameOnTouchListener$1$1
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
                    surfaceView2.setOnTouchListener(onTouchListener);
                }

                @Override // com.tencent.mobileqq.triton.view.GameView
                public void setSurfaceCallback(@Nullable GameView.SurfaceCallback surfaceCallback) {
                    this.surfaceCallback = surfaceCallback;
                    if (surfaceCallback != null) {
                        SurfaceHolder holder = this.$surfaceView.getHolder();
                        Intrinsics.checkExpressionValueIsNotNull(holder, "surfaceView.holder");
                        Surface surface = holder.getSurface();
                        Intrinsics.checkExpressionValueIsNotNull(surface, "surfaceView.holder.surface");
                        if (surface.isValid()) {
                            if (this._format == 0) {
                                this._format = 1;
                                this._width = this.$surfaceView.getWidth();
                                this._height = this.$surfaceView.getHeight();
                            }
                            SurfaceHolder holder2 = this.$surfaceView.getHolder();
                            Intrinsics.checkExpressionValueIsNotNull(holder2, "surfaceView.holder");
                            Surface surface2 = holder2.getSurface();
                            Intrinsics.checkExpressionValueIsNotNull(surface2, "surfaceView.holder.surface");
                            surfaceCallback.onSurfaceCreated(surface2);
                            SurfaceHolder holder3 = this.$surfaceView.getHolder();
                            Intrinsics.checkExpressionValueIsNotNull(holder3, "surfaceView.holder");
                            Surface surface3 = holder3.getSurface();
                            Intrinsics.checkExpressionValueIsNotNull(surface3, "surfaceView.holder.surface");
                            surfaceCallback.onSurfaceChanged(surface3, this._format, this._width, this._height);
                        }
                    }
                }
            };
        }

        @NotNull
        public final GameView from(@NotNull TextureView textureView) {
            Intrinsics.checkParameterIsNotNull(textureView, "textureView");
            return new GameView$Companion$from$2(textureView);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/triton/view/GameView$SurfaceCallback;", "", "onSurfaceChanged", "", "surface", "Landroid/view/Surface;", "format", "", "width", "height", "onSurfaceCreated", "onSurfaceDestroyed", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public interface SurfaceCallback {
        void onSurfaceChanged(@NotNull Surface surface, int format, int width, int height);

        void onSurfaceCreated(@NotNull Surface surface);

        void onSurfaceDestroyed();
    }

    float getDisplayDensity();

    /* renamed from: getHeight */
    int get_height();

    /* renamed from: getWidth */
    int get_width();

    void onSwapBuffer();

    void setGameOnTouchListener(@Nullable Function1<? super MotionEvent, Boolean> listener);

    void setSurfaceCallback(@Nullable SurfaceCallback surfaceCallback);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class DefaultImpls {
        public static void onSwapBuffer(GameView gameView) {
        }
    }
}
