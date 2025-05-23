package com.tencent.robot.widget.bottomdialog.behavior;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.robot.widget.bottomdialog.behavior.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0001(\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u001a\u0010\u0011\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001cR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010/R\u0014\u00103\u001a\u00020$8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00106\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R$\u00109\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00048V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\r\u00105\"\u0004\b\u0013\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/behavior/DialogBehaviorUIOperator;", "Lcom/tencent/robot/widget/bottomdialog/behavior/c;", "", "j", "", "y", "type", "scrollTo", "time", "c", "e", "d", "Landroid/view/View;", "a", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Lcom/tencent/robot/widget/bottomdialog/behavior/c$b;", "b", "Lcom/tencent/robot/widget/bottomdialog/behavior/c$b;", "mScrollListener", "Lcom/tencent/robot/widget/bottomdialog/behavior/d;", "Lcom/tencent/robot/widget/bottomdialog/behavior/d;", "mViewportProvider", "I", "mOldScrollY", "", "[I", "mValueDispatched", "Landroidx/lifecycle/MutableLiveData;", "f", "Landroidx/lifecycle/MutableLiveData;", "mScrollY", "g", "mTranslationY", "Landroid/graphics/Rect;", h.F, "Landroid/graphics/Rect;", "mTempRect", "com/tencent/robot/widget/bottomdialog/behavior/DialogBehaviorUIOperator$mViewFlinger$1", "i", "Lcom/tencent/robot/widget/bottomdialog/behavior/DialogBehaviorUIOperator$mViewFlinger$1;", "mViewFlinger", "Landroid/animation/ValueAnimator;", "Lkotlin/Lazy;", "k", "()Landroid/animation/ValueAnimator;", "mTranslationAnimator", "getViewport", "()Landroid/graphics/Rect;", "viewport", "getScrollY", "()I", "scrollY", "value", "(I)V", "translationY", "<init>", "(Landroid/view/View;Lcom/tencent/robot/widget/bottomdialog/behavior/c$b;Lcom/tencent/robot/widget/bottomdialog/behavior/d;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class DialogBehaviorUIOperator implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final c.b mScrollListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mViewportProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mOldScrollY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] mValueDispatched;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<int[]> mScrollY;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int mTranslationY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect mTempRect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DialogBehaviorUIOperator$mViewFlinger$1 mViewFlinger;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTranslationAnimator;

    public DialogBehaviorUIOperator(@NotNull View view, @Nullable c.b bVar, @NotNull d mViewportProvider) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mViewportProvider, "mViewportProvider");
        this.view = view;
        this.mScrollListener = bVar;
        this.mViewportProvider = mViewportProvider;
        this.mValueDispatched = new int[]{0, 1};
        MutableLiveData<int[]> mutableLiveData = new MutableLiveData<>();
        final Function1<int[], Unit> function1 = new Function1<int[], Unit>() { // from class: com.tencent.robot.widget.bottomdialog.behavior.DialogBehaviorUIOperator$mScrollY$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(int[] iArr) {
                invoke2(iArr);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(int[] iArr) {
                c.b bVar2;
                int i3;
                if (iArr == null) {
                    return;
                }
                bVar2 = DialogBehaviorUIOperator.this.mScrollListener;
                if (bVar2 != null) {
                    View view2 = DialogBehaviorUIOperator.this.getView();
                    int i16 = iArr[1];
                    int i17 = iArr[0];
                    i3 = DialogBehaviorUIOperator.this.mOldScrollY;
                    bVar2.a(view2, i16, 0, i17, 0, i3);
                }
                DialogBehaviorUIOperator.this.mOldScrollY = iArr[0];
            }
        };
        mutableLiveData.observeForever(new Observer() { // from class: com.tencent.robot.widget.bottomdialog.behavior.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DialogBehaviorUIOperator.l(Function1.this, obj);
            }
        });
        this.mScrollY = mutableLiveData;
        this.mTempRect = new Rect();
        this.mViewFlinger = new DialogBehaviorUIOperator$mViewFlinger$1(this);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new DialogBehaviorUIOperator$mTranslationAnimator$2(this));
        this.mTranslationAnimator = lazy;
    }

    private final void j() {
        getView().setTranslationY((-getScrollY()) + getMTranslationY());
    }

    private final ValueAnimator k() {
        return (ValueAnimator) this.mTranslationAnimator.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.robot.widget.bottomdialog.behavior.c
    /* renamed from: a, reason: from getter */
    public int getMTranslationY() {
        return this.mTranslationY;
    }

    @Override // com.tencent.robot.widget.bottomdialog.behavior.c
    public void b(int i3) {
        this.mTranslationY = i3;
        if (this.mViewFlinger.getMScroller().isFinished()) {
            j();
        }
    }

    @Override // com.tencent.robot.widget.bottomdialog.behavior.c
    public void c(int y16, int time) {
        this.mViewFlinger.getMScroller().startScroll(0, getScrollY(), 0, y16 - getScrollY(), time);
        this.mViewFlinger.f();
    }

    @Override // com.tencent.robot.widget.bottomdialog.behavior.c
    public void d() {
        this.mViewFlinger.getMScroller().abortAnimation();
    }

    @Override // com.tencent.robot.widget.bottomdialog.behavior.c
    public void e(int y16, int time) {
        ValueAnimator k3 = k();
        if (k3.isRunning() || k3.isStarted()) {
            k3.cancel();
        }
        k3.setDuration(time);
        k3.setIntValues(getMTranslationY(), y16);
        k3.start();
    }

    @Override // com.tencent.robot.widget.bottomdialog.behavior.c
    public int getScrollY() {
        int[] value = this.mScrollY.getValue();
        if (value == null) {
            return 0;
        }
        return value[0];
    }

    @Override // com.tencent.robot.widget.bottomdialog.behavior.c
    @NotNull
    public View getView() {
        return this.view;
    }

    @Override // com.tencent.robot.widget.bottomdialog.behavior.d
    @NotNull
    public Rect getViewport() {
        this.mTempRect.set(this.mViewportProvider.getViewport());
        return this.mTempRect;
    }

    @Override // com.tencent.robot.widget.bottomdialog.behavior.c
    public void scrollBy(int i3, int i16) {
        c.a.a(this, i3, i16);
    }

    @Override // com.tencent.robot.widget.bottomdialog.behavior.c
    public void scrollTo(int y16, int type) {
        MutableLiveData<int[]> mutableLiveData = this.mScrollY;
        int[] iArr = this.mValueDispatched;
        iArr[0] = y16;
        iArr[1] = type;
        mutableLiveData.setValue(iArr);
        j();
    }
}
