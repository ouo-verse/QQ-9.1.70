package com.tencent.icgame.game.live.impl.danmuku.selector;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.icgame.game.live.impl.danmuku.selector.DanmakuSelectorPagView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ$\u0010\b\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0007J\b\u0010\u000b\u001a\u00020\u0007H\u0014R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/icgame/game/live/impl/danmuku/selector/DanmakuSelectorPagView;", "Lorg/libpag/PAGView;", "", "assetFileName", "", "width", "height", "", "j", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, NodeProps.ON_DETACHED_FROM_WINDOW, "Ljava/util/concurrent/atomic/AtomicBoolean;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/atomic/AtomicBoolean;", "paused", "D", "assetLoaded", "Ljava/lang/Runnable;", "E", "Ljava/lang/Runnable;", "playRunnable", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class DanmakuSelectorPagView extends PAGView {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean paused;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean assetLoaded;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Runnable playRunnable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DanmakuSelectorPagView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final void j(PAGView pAGView, String str, int i3, int i16) {
        Matrix matrix;
        if (this.assetLoaded.get()) {
            return;
        }
        PAGComposition Make = PAGComposition.Make(i3, i16);
        PAGFile Load = PagViewMonitor.Load(pAGView.getContext().getResources().getAssets(), "pag/" + str);
        if (Load != null) {
            matrix = Load.getTotalMatrix();
        } else {
            matrix = null;
        }
        float d16 = uu0.a.d(39) / Load.width();
        if (matrix != null) {
            matrix.setScale(d16, d16);
        }
        Load.setMatrix(matrix);
        if (Make != null) {
            Make.addLayer(Load);
        }
        pAGView.setComposition(Make);
        pAGView.setRepeatCount(1);
        pAGView.addListener(new a(pAGView, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(DanmakuSelectorPagView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.paused.get()) {
            this$0.setProgress(0.0d);
            this$0.play();
        }
    }

    public final void l(@NotNull String assetFileName) {
        Intrinsics.checkNotNullParameter(assetFileName, "assetFileName");
        this.paused.set(false);
        removeCallbacks(this.playRunnable);
        j(this, assetFileName, getWidth(), getHeight());
        if (!isPlaying()) {
            play();
        }
    }

    public final void m() {
        stop();
        this.assetLoaded.set(false);
        this.paused.set(true);
        removeCallbacks(this.playRunnable);
        PAGComposition composition = getComposition();
        if (composition != null) {
            composition.removeAllLayers();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.libpag.PAGView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.playRunnable);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DanmakuSelectorPagView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ DanmakuSelectorPagView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DanmakuSelectorPagView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.paused = new AtomicBoolean(false);
        this.assetLoaded = new AtomicBoolean(false);
        this.playRunnable = new Runnable() { // from class: jv0.a
            @Override // java.lang.Runnable
            public final void run() {
                DanmakuSelectorPagView.k(DanmakuSelectorPagView.this);
            }
        };
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/icgame/game/live/impl/danmuku/selector/DanmakuSelectorPagView$a", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements PAGView.PAGViewListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PAGView f115099d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ DanmakuSelectorPagView f115100e;

        a(PAGView pAGView, DanmakuSelectorPagView danmakuSelectorPagView) {
            this.f115099d = pAGView;
            this.f115100e = danmakuSelectorPagView;
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(@Nullable PAGView p06) {
            this.f115099d.post(this.f115100e.playRunnable);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(@Nullable PAGView p06) {
            this.f115099d.post(this.f115100e.playRunnable);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(@Nullable PAGView p06) {
        }
    }
}
