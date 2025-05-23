package com.tencent.timi.game.ui.pag;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.timi.game.initer.impl.LibraryInitManager;
import hi4.c;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGView;
import tl.h;

@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001&\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00106\u001a\u00020\r\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020$H\u0016R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\"\u00101\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010-\u001a\u0004\b*\u0010.\"\u0004\b/\u00100\u00a8\u00069"}, d2 = {"Lcom/tencent/timi/game/ui/pag/TimiGamePAGView;", "Landroid/widget/FrameLayout;", "", "", "c", NodeProps.ON_DETACHED_FROM_WINDOW, "", "f", "g", h.F, "Landroid/view/TextureView$SurfaceTextureListener;", "listener", "setSurfaceTextureListener", "", "value", "setRepeatCount", "Lorg/libpag/PAGView$PAGViewListener;", "b", "", "path", "setPath", "Lorg/libpag/PAGComposition;", "d", "newComposition", "setComposition", "enable", "setVideoEnable", "setCacheEnable", "", "setCacheScale", "setMaxFrameRate", "mode", "setScaleMode", "Landroid/graphics/Matrix;", "matrix", "setMatrix", "", HippyQQPagView.FunctionName.SET_PROGRESS, "com/tencent/timi/game/ui/pag/TimiGamePAGView$a", "Lcom/tencent/timi/game/ui/pag/TimiGamePAGView$a;", "mPAGLibraryLoadedListener", "Lorg/libpag/PAGView;", "e", "Lorg/libpag/PAGView;", "pagView", "Z", "()Z", "setPAGViewAdded", "(Z)V", "isPAGViewAdded", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TimiGamePAGView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mPAGLibraryLoadedListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PAGView pagView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isPAGViewAdded;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/timi/game/ui/pag/TimiGamePAGView$a", "Lhi4/c;", "", "onLoaded", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements c {
        a() {
        }

        @Override // hi4.c
        public void onLoaded() {
            TimiGamePAGView.this.c();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiGamePAGView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        if (this.isPAGViewAdded || getContext() == null) {
            return;
        }
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.isPAGViewAdded = true;
        PAGView pAGView = new PAGView(getContext());
        this.pagView = pAGView;
        addView(pAGView, new FrameLayout.LayoutParams(-1, -1));
    }

    public void b(@NotNull PAGView.PAGViewListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.addListener(listener);
        }
    }

    @Nullable
    public PAGComposition d() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            return pAGView.getComposition();
        }
        return null;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsPAGViewAdded() {
        return this.isPAGViewAdded;
    }

    public boolean f() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            return pAGView.isPlaying();
        }
        return false;
    }

    public void g() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.play();
        }
    }

    public void h() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.stop();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LibraryInitManager.f377186a.i(this.mPAGLibraryLoadedListener);
    }

    public void setCacheEnable(boolean value) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setCacheEnabled(value);
        }
    }

    public void setCacheScale(float value) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setCacheScale(value);
        }
    }

    public void setComposition(@NotNull PAGComposition newComposition) {
        Intrinsics.checkNotNullParameter(newComposition, "newComposition");
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setComposition(newComposition);
        }
    }

    public void setMatrix(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setMatrix(matrix);
        }
    }

    public void setMaxFrameRate(float value) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setMaxFrameRate(value);
        }
    }

    public final void setPAGViewAdded(boolean z16) {
        this.isPAGViewAdded = z16;
    }

    public void setPath(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setPath(path);
        }
    }

    public void setProgress(double value) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setProgress(value);
        }
    }

    public void setRepeatCount(int value) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setRepeatCount(value);
        }
    }

    public void setScaleMode(int mode) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setScaleMode(mode);
        }
    }

    public void setSurfaceTextureListener(@NotNull TextureView.SurfaceTextureListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setSurfaceTextureListener(listener);
        }
    }

    public void setVideoEnable(boolean enable) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setVideoEnabled(enable);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiGamePAGView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ TimiGamePAGView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiGamePAGView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        a aVar = new a();
        this.mPAGLibraryLoadedListener = aVar;
        LibraryInitManager libraryInitManager = LibraryInitManager.f377186a;
        if (libraryInitManager.c()) {
            c();
        } else {
            libraryInitManager.h(aVar);
        }
    }
}
