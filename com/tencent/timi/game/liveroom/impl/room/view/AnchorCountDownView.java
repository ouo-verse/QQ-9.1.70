package com.tencent.timi.game.liveroom.impl.room.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorCountDownView;", "Landroid/widget/FrameLayout;", "", NodeProps.ON_ATTACHED_TO_WINDOW, "g", "", "d", "Ljava/lang/String;", "tag", "Lorg/libpag/PAGComposition;", "e", "Lorg/libpag/PAGComposition;", "composition", "Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorCountDownView$a;", "f", "Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorCountDownView$a;", "()Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorCountDownView$a;", "setCountDownTimerListener", "(Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorCountDownView$a;)V", "countDownTimerListener", "Lnr2/h;", tl.h.F, "Lnr2/h;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AnchorCountDownView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PAGComposition composition;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a countDownTimerListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final nr2.h binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorCountDownView$a;", "", "", "b", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void a();

        void b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/view/AnchorCountDownView$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<ViewPropertyAnimator> f378658d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AnchorCountDownView f378659e;

        b(Ref.ObjectRef<ViewPropertyAnimator> objectRef, AnchorCountDownView anchorCountDownView) {
            this.f378658d = objectRef;
            this.f378659e = anchorCountDownView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            super.onAnimationEnd(animation);
            this.f378658d.element.setListener(null);
            this.f378659e.binding.f421062b.g();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorCountDownView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AnchorCountDownView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e(this$0.tag, 1, "AnchorCountDownView countdown");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final AnchorCountDownView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.binding.f421062b.getIsPAGViewAdded()) {
            PAGFile Load = PagViewMonitor.Load(BaseApplication.getContext().getResources().getAssets(), "pag/tg_anchor_count_down.pag");
            Intrinsics.checkNotNullExpressionValue(Load, "Load(\n                  \u2026wn.pag\"\n                )");
            Matrix totalMatrix = Load.getTotalMatrix();
            float width = (this$0.binding.f421062b.getWidth() * 1.0f) / Load.width();
            Intrinsics.checkNotNull(totalMatrix);
            totalMatrix.setScale(width, width);
            Load.setMatrix(totalMatrix);
            PAGComposition Make = PAGComposition.Make(this$0.binding.f421062b.getWidth(), this$0.binding.f421062b.getHeight());
            this$0.composition = Make;
            if (Make != null) {
                Make.addLayer(Load);
                this$0.binding.f421062b.setComposition(Make);
                this$0.binding.f421062b.setRepeatCount(1);
                this$0.binding.f421062b.setProgress(0.0d);
            }
            this$0.binding.f421062b.post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.view.c
                @Override // java.lang.Runnable
                public final void run() {
                    AnchorCountDownView.i(AnchorCountDownView.this);
                }
            });
            this$0.binding.f421062b.b(new c());
            return;
        }
        QLog.e(this$0.tag, 1, "pag not ready \uff0cskip countdown");
        a aVar = this$0.countDownTimerListener;
        if (aVar != null) {
            aVar.a();
        }
        a aVar2 = this$0.countDownTimerListener;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, android.view.ViewPropertyAnimator] */
    public static final void i(AnchorCountDownView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? alpha = this$0.animate().alpha(1.0f);
        objectRef.element = alpha;
        alpha.setDuration(200L);
        ((ViewPropertyAnimator) objectRef.element).setListener(new b(objectRef, this$0));
        ((ViewPropertyAnimator) objectRef.element).start();
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final a getCountDownTimerListener() {
        return this.countDownTimerListener;
    }

    public final void g() {
        post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.view.b
            @Override // java.lang.Runnable
            public final void run() {
                AnchorCountDownView.h(AnchorCountDownView.this);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public final void setCountDownTimerListener(@Nullable a aVar) {
        this.countDownTimerListener = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorCountDownView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AnchorCountDownView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorCountDownView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.tag = "AnchorCountDownView";
        nr2.h g16 = nr2.h.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        setAlpha(0.0f);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorCountDownView.d(AnchorCountDownView.this, view);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/view/AnchorCountDownView$c", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements PAGView.PAGViewListener {
        c() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(@Nullable PAGView p06) {
            a countDownTimerListener = AnchorCountDownView.this.getCountDownTimerListener();
            if (countDownTimerListener != null) {
                countDownTimerListener.b();
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(@Nullable PAGView p06) {
            a countDownTimerListener = AnchorCountDownView.this.getCountDownTimerListener();
            if (countDownTimerListener != null) {
                countDownTimerListener.a();
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(@Nullable PAGView p06) {
        }
    }
}
