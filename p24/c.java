package p24;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.aio.input.inputbar.edittext.RobotInputEditTextExtUIState;
import com.tencent.robot.aio.input.styleconfig.InputStyleType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 42$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u00015B\u000f\u0012\u0006\u0010$\u001a\u00020\u0004\u00a2\u0006\u0004\b3\u0010#J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0016\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001c0\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016R\"\u0010$\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010'R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010+R\u0016\u0010.\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00066"}, d2 = {"Lp24/c;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState$PttRecordModeChangedState;", "state", "", "j", "Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState$FullScreenModeChangedState;", "g", "r", "", DomainData.DOMAIN_NAME, "Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState$InputStyleChangedState;", h.F, "Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState$PostInputEditTextRunnable;", "i", "Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState$UpdateBackgroundColor;", "l", "binding", "o", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", "", "Ljava/lang/Class;", "getObserverStates", "k", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "f", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "p", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "", "e", "Z", "mIsPttRecordMode", "mIsFullScreenMode", "Lcom/tencent/robot/aio/input/styleconfig/InputStyleType;", "Lcom/tencent/robot/aio/input/styleconfig/InputStyleType;", "mInputStyleType", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "mBinding", "Landroid/animation/ValueAnimator;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/animation/ValueAnimator;", "mBgAnimator", "<init>", BdhLogUtil.LogTag.Tag_Conn, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPttRecordMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFullScreenMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private InputStyleType mInputStyleType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.input.inputbar.viewbinding.a mBinding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator mBgAnimator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"p24/c$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            if (animation != null) {
                animation.removeAllListeners();
            }
        }
    }

    public c(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        this.mInputStyleType = InputStyleType.STYLE_DEFAULT;
    }

    private final void g(RobotInputEditTextExtUIState.FullScreenModeChangedState state) {
        if (this.mIsFullScreenMode == state.getIsFullScreenMode()) {
            return;
        }
        boolean isFullScreenMode = state.getIsFullScreenMode();
        this.mIsFullScreenMode = isFullScreenMode;
        QLog.i("RobotInputEditTextExtVBDelegate", 1, "handleFullScreenModeChanged " + isFullScreenMode);
        r();
    }

    private final void h(RobotInputEditTextExtUIState.InputStyleChangedState state) {
        ConstraintLayout.LayoutParams layoutParams;
        ConstraintLayout.LayoutParams layoutParams2;
        if (this.mInputStyleType == state.getInputStyleConfig().getInputStyleType()) {
            return;
        }
        this.mInputStyleType = state.getInputStyleConfig().getInputStyleType();
        QLog.i("RobotInputEditTextExtVBDelegate", 1, "handleInputStyleChangedState " + this.mIsFullScreenMode);
        ConstraintLayout.LayoutParams layoutParams3 = null;
        if (com.tencent.robot.aio.input.styleconfig.c.a(this.mInputStyleType)) {
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar = null;
            }
            AIOEditText a16 = aVar.a();
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = this.mBinding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar2 = null;
            }
            ViewGroup.LayoutParams layoutParams4 = aVar2.a().getLayoutParams();
            if (layoutParams4 instanceof ConstraintLayout.LayoutParams) {
                layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams4;
            } else {
                layoutParams2 = null;
            }
            if (layoutParams2 != null) {
                layoutParams2.rightToLeft = R.id.f766842b;
                layoutParams2.leftToLeft = 0;
                layoutParams2.leftToRight = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = ViewUtils.dpToPx(56.0f);
                layoutParams3 = layoutParams2;
            }
            a16.setLayoutParams(layoutParams3);
            return;
        }
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar3 = null;
        }
        AIOEditText a17 = aVar3.a();
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar4 = this.mBinding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar4 = null;
        }
        ViewGroup.LayoutParams layoutParams5 = aVar4.a().getLayoutParams();
        if (layoutParams5 instanceof ConstraintLayout.LayoutParams) {
            layoutParams = (ConstraintLayout.LayoutParams) layoutParams5;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.rightToLeft = R.id.send_btn;
            layoutParams.leftToLeft = 0;
            layoutParams.leftToRight = -1;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = ViewUtils.dpToPx(16.0f);
            layoutParams3 = layoutParams;
        }
        a17.setLayoutParams(layoutParams3);
    }

    private final void i(RobotInputEditTextExtUIState.PostInputEditTextRunnable state) {
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        aVar.a().post(state.getRunnable());
    }

    private final void j(RobotInputEditTextExtUIState.PttRecordModeChangedState state) {
        if (this.mIsPttRecordMode == state.getIsPttRecordMode()) {
            return;
        }
        boolean isPttRecordMode = state.getIsPttRecordMode();
        this.mIsPttRecordMode = isPttRecordMode;
        QLog.i("RobotInputEditTextExtVBDelegate", 1, "handlePttRecordModeStateChanged " + isPttRecordMode);
        r();
    }

    private final void l(RobotInputEditTextExtUIState.UpdateBackgroundColor state) {
        if (this.mIsFullScreenMode) {
            return;
        }
        ValueAnimator valueAnimator = this.mBgAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        final Drawable background = aVar.getRoot().getBackground();
        if (background != null && (background instanceof ColorDrawable)) {
            if (state.getNeedAnim()) {
                ValueAnimator ofArgb = ValueAnimator.ofArgb(((ColorDrawable) background).getColor(), state.getColor());
                ofArgb.setDuration(250L);
                ofArgb.addListener(new b());
                ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: p24.b
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        c.m(background, valueAnimator2);
                    }
                });
                ofArgb.start();
                this.mBgAnimator = ofArgb;
                return;
            }
            ((ColorDrawable) background).setColor(state.getColor());
            return;
        }
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar2 = aVar3;
        }
        aVar2.getRoot().setBackground(new ColorDrawable(state.getColor()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Drawable drawable, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        ((ColorDrawable) drawable).setColor(((Integer) animatedValue).intValue());
    }

    private final int n() {
        return ViewUtils.dpToPx(36.0f);
    }

    private final void r() {
        if (this.mIsFullScreenMode) {
            return;
        }
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = null;
        if (this.mIsPttRecordMode) {
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = this.mBinding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar2 = null;
            }
            ViewGroup.LayoutParams layoutParams = aVar2.a().getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = n();
            }
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar3 = this.mBinding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar3 = null;
            }
            aVar3.a().setVisibility(4);
        } else {
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar4 = this.mBinding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar4 = null;
            }
            ViewGroup.LayoutParams layoutParams2 = aVar4.a().getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = -2;
            }
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar5 = this.mBinding;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar5 = null;
            }
            aVar5.a().setVisibility(0);
        }
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar6 = this.mBinding;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar = aVar6;
        }
        ConstraintLayout root = aVar.getRoot();
        root.setPaddingRelative(root.getPaddingStart(), ViewUtils.dip2px(10.0f), root.getPaddingEnd(), ViewUtils.dip2px(16.0f));
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        c.a.b(this);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        c.a.e(this, reuseParam);
        this.mIsFullScreenMode = false;
        this.mIsPttRecordMode = false;
        r();
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        c.a.a(this, inputUIState);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: f, reason: from getter */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d dVar) {
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    @NotNull
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{RobotInputEditTextExtUIState.PttRecordModeChangedState.class, RobotInputEditTextExtUIState.FullScreenModeChangedState.class, RobotInputEditTextExtUIState.InputStyleChangedState.class, RobotInputEditTextExtUIState.PostInputEditTextRunnable.class, RobotInputEditTextExtUIState.UpdateBackgroundColor.class});
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof RobotInputEditTextExtUIState.PttRecordModeChangedState) {
            j((RobotInputEditTextExtUIState.PttRecordModeChangedState) state);
            return;
        }
        if (state instanceof RobotInputEditTextExtUIState.FullScreenModeChangedState) {
            g((RobotInputEditTextExtUIState.FullScreenModeChangedState) state);
            return;
        }
        if (state instanceof RobotInputEditTextExtUIState.InputStyleChangedState) {
            h((RobotInputEditTextExtUIState.InputStyleChangedState) state);
        } else if (state instanceof RobotInputEditTextExtUIState.PostInputEditTextRunnable) {
            i((RobotInputEditTextExtUIState.PostInputEditTextRunnable) state);
        } else if (state instanceof RobotInputEditTextExtUIState.UpdateBackgroundColor) {
            l((RobotInputEditTextExtUIState.UpdateBackgroundColor) state);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.inputbar.viewbinding.a binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mBinding = binding;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = null;
        if (binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            binding = null;
        }
        ConstraintLayout root = binding.getRoot();
        root.setPaddingRelative(root.getPaddingStart(), ViewUtils.dip2px(10.0f), root.getPaddingEnd(), ViewUtils.dip2px(16.0f));
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = this.mBinding;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar = aVar2;
        }
        aVar.a().setMinimumHeight(ViewUtils.dpToPx(36.0f));
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        c.a.d(this);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mHost = bVar;
    }
}
