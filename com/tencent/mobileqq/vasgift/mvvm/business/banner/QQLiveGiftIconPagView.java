package com.tencent.mobileqq.vasgift.mvvm.business.banner;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0005H\u0014R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/QQLiveGiftIconPagView;", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "Lorg/libpag/PAGView;", "", "pagFile", "", DomainData.DOMAIN_NAME, "o", "p", NodeProps.ON_DETACHED_FROM_WINDOW, "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "played", "e", "loaded", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "hideRunnable", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QQLiveGiftIconPagView extends VasPagView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean played;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean loaded;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable hideRunnable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQLiveGiftIconPagView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(QQLiveGiftIconPagView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setVisibility(8);
        this$0.played.set(false);
        this$0.api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.QQLiveGiftIconPagView$hideRunnable$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                invoke2(pAGView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PAGView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.stop();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(PAGView pAGView, String str) {
        Matrix matrix;
        if (this.loaded.get()) {
            return;
        }
        PAGComposition Make = PAGComposition.Make(pAGView.getWidth(), pAGView.getHeight());
        PAGFile Load = PagViewMonitor.Load(str);
        if (Load != null) {
            matrix = Load.getTotalMatrix();
        } else {
            matrix = null;
        }
        if (Load.width() != 0 && Load.height() != 0) {
            float o16 = Utils.o(50.0f, BaseApplication.getContext().getResources()) / Load.width();
            float o17 = Utils.o(42.0f, BaseApplication.getContext().getResources()) / Load.height();
            if (matrix != null) {
                matrix.setScale(o16, o17);
            }
        } else if (matrix != null) {
            matrix.setScale(1.0f, 1.0f);
        }
        Load.setMatrix(matrix);
        if (Make != null) {
            Make.addLayer(Load);
        }
        pAGView.setComposition(Make);
        pAGView.setRepeatCount(-1);
        pAGView.addListener(new a(pAGView, this));
    }

    public final void o(@NotNull final String pagFile) {
        Intrinsics.checkNotNullParameter(pagFile, "pagFile");
        api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.QQLiveGiftIconPagView$startPlay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                invoke2(pAGView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PAGView it) {
                AtomicBoolean atomicBoolean;
                Intrinsics.checkNotNullParameter(it, "it");
                QQLiveGiftIconPagView qQLiveGiftIconPagView = QQLiveGiftIconPagView.this;
                qQLiveGiftIconPagView.removeCallbacks(qQLiveGiftIconPagView.hideRunnable);
                QQLiveGiftIconPagView.this.n(it, pagFile);
                if (it.isPlaying()) {
                    return;
                }
                QQLiveGiftIconPagView.this.setVisibility(0);
                atomicBoolean = QQLiveGiftIconPagView.this.played;
                atomicBoolean.set(true);
                it.play();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.hideRunnable);
    }

    public final void p() {
        api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.QQLiveGiftIconPagView$stopPlay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                invoke2(pAGView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PAGView it) {
                AtomicBoolean atomicBoolean;
                AtomicBoolean atomicBoolean2;
                Intrinsics.checkNotNullParameter(it, "it");
                atomicBoolean = QQLiveGiftIconPagView.this.played;
                if (atomicBoolean.get()) {
                    it.stop();
                }
                atomicBoolean2 = QQLiveGiftIconPagView.this.loaded;
                atomicBoolean2.set(false);
                QQLiveGiftIconPagView qQLiveGiftIconPagView = QQLiveGiftIconPagView.this;
                qQLiveGiftIconPagView.removeCallbacks(qQLiveGiftIconPagView.hideRunnable);
                PAGComposition composition = it.getComposition();
                if (composition != null) {
                    composition.removeAllLayers();
                }
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQLiveGiftIconPagView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ QQLiveGiftIconPagView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQLiveGiftIconPagView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.played = new AtomicBoolean(false);
        this.loaded = new AtomicBoolean(false);
        api().build();
        this.hideRunnable = new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.q
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveGiftIconPagView.m(QQLiveGiftIconPagView.this);
            }
        };
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vasgift/mvvm/business/banner/QQLiveGiftIconPagView$a", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements PAGView.PAGViewListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PAGView f311790d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQLiveGiftIconPagView f311791e;

        a(PAGView pAGView, QQLiveGiftIconPagView qQLiveGiftIconPagView) {
            this.f311790d = pAGView;
            this.f311791e = qQLiveGiftIconPagView;
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(@Nullable PAGView p06) {
            this.f311790d.post(this.f311791e.hideRunnable);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(@Nullable PAGView p06) {
            this.f311790d.post(this.f311791e.hideRunnable);
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
