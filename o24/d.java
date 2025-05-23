package o24;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import com.tencent.robot.aio.input.inputbar.blur.RobotInputBlurUIState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import o24.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u0001\u0017B\u000f\u0012\u0006\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\b0\u0010 J\b\u0010\b\u001a\u00020\u0007H\u0002J6\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fH\u0002J\u0016\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00130\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016R\"\u0010!\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010.\u00a8\u00061"}, d2 = {"Lo24/d;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "", "k", "", "show", "Landroid/view/View;", "bgView", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "bgList", "r", "", "Ljava/lang/Class;", "getObserverStates", "binding", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "state", "j", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "i", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "p", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "e", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "mBinding", "Landroid/content/Context;", "f", "Landroid/content/Context;", "mContext", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", h.F, "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "mBlurView", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "mOnLayoutChangeListener", "<init>", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.input.inputbar.viewbinding.a mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QQBlurViewWrapper mBlurView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnLayoutChangeListener mOnLayoutChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"o24/d$b", "Lcom/tencent/qui/quiblurview/f$b;", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements f.b {
        b() {
        }

        @Override // com.tencent.qui.quiblurview.f.b
        public boolean a() {
            QQBlurViewWrapper qQBlurViewWrapper = d.this.mBlurView;
            if (qQBlurViewWrapper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
                qQBlurViewWrapper = null;
            }
            return qQBlurViewWrapper.isDirty();
        }
    }

    public d(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        this.mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: o24.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                d.l(d.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o(a.C10881a.f421813d);
    }

    private final void k() {
        Context context;
        Context context2 = this.mContext;
        QQBlurViewWrapper qQBlurViewWrapper = null;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        } else {
            context = context2;
        }
        QQBlurViewWrapper qQBlurViewWrapper2 = new QQBlurViewWrapper(context, null, 0, 6, null);
        qQBlurViewWrapper2.setId(R.id.f768342q);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        layoutParams.leftToLeft = R.id.input;
        layoutParams.rightToRight = R.id.input;
        layoutParams.topToTop = R.id.input;
        layoutParams.bottomToBottom = R.id.input;
        qQBlurViewWrapper2.setLayoutParams(layoutParams);
        ab.d(qQBlurViewWrapper2, ViewUtils.dpToPx(8.0f));
        this.mBlurView = qQBlurViewWrapper2;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        ConstraintLayout root = aVar.getRoot();
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = this.mBinding;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar2 = null;
        }
        int indexOfChild = root.indexOfChild(aVar2.a());
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar3 = null;
        }
        ConstraintLayout root2 = aVar3.getRoot();
        QQBlurViewWrapper qQBlurViewWrapper3 = this.mBlurView;
        if (qQBlurViewWrapper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
        } else {
            qQBlurViewWrapper = qQBlurViewWrapper3;
        }
        root2.addView(qQBlurViewWrapper, indexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(d this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQBlurViewWrapper qQBlurViewWrapper = this$0.mBlurView;
        if (qQBlurViewWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
            qQBlurViewWrapper = null;
        }
        qQBlurViewWrapper.invalidate();
    }

    private final void r(boolean show, View bgView, ArrayList<Object> bgList) {
        QQBlurViewWrapper qQBlurViewWrapper = null;
        if (bgView != null) {
            QQBlurViewWrapper qQBlurViewWrapper2 = this.mBlurView;
            if (qQBlurViewWrapper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
                qQBlurViewWrapper2 = null;
            }
            com.tencent.qui.quiblurview.c cVar = com.tencent.qui.quiblurview.c.f363628c;
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            f.a aVar = new f.a(cVar.b(context), ViewUtils.dpToPx(25.0f), bgView, 0, null, Integer.valueOf(R.drawable.qui_common_transparent_bg));
            aVar.o(true);
            qQBlurViewWrapper2.a(aVar);
            f.d dVar = new f.d(null, new b(), 1, null);
            QQBlurViewWrapper qQBlurViewWrapper3 = this.mBlurView;
            if (qQBlurViewWrapper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
                qQBlurViewWrapper3 = null;
            }
            qQBlurViewWrapper3.setBlurSource(bgView, bgList, dVar);
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = this.mBinding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar2 = null;
            }
            aVar2.getRoot().addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        }
        if (show) {
            QQBlurViewWrapper qQBlurViewWrapper4 = this.mBlurView;
            if (qQBlurViewWrapper4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
                qQBlurViewWrapper4 = null;
            }
            qQBlurViewWrapper4.onResume();
            QQBlurViewWrapper qQBlurViewWrapper5 = this.mBlurView;
            if (qQBlurViewWrapper5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
            } else {
                qQBlurViewWrapper = qQBlurViewWrapper5;
            }
            qQBlurViewWrapper.setVisibility(0);
            return;
        }
        QQBlurViewWrapper qQBlurViewWrapper6 = this.mBlurView;
        if (qQBlurViewWrapper6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
            qQBlurViewWrapper6 = null;
        }
        qQBlurViewWrapper6.onPause();
        QQBlurViewWrapper qQBlurViewWrapper7 = this.mBlurView;
        if (qQBlurViewWrapper7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
        } else {
            qQBlurViewWrapper = qQBlurViewWrapper7;
        }
        qQBlurViewWrapper.setVisibility(8);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        QQBlurViewWrapper qQBlurViewWrapper = this.mBlurView;
        if (qQBlurViewWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
            qQBlurViewWrapper = null;
        }
        qQBlurViewWrapper.post(new Runnable() { // from class: o24.b
            @Override // java.lang.Runnable
            public final void run() {
                d.h(d.this);
            }
        });
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b bVar) {
        c.a.e(this, bVar);
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        c.a.a(this, inputUIState);
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
        listOf = CollectionsKt__CollectionsJVMKt.listOf(RobotInputBlurUIState.UpdateBlurState.class);
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: i, reason: from getter */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof RobotInputBlurUIState.UpdateBlurState) {
            RobotInputBlurUIState.UpdateBlurState updateBlurState = (RobotInputBlurUIState.UpdateBlurState) state;
            r(updateBlurState.getShow(), updateBlurState.getBgView(), updateBlurState.a());
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.inputbar.viewbinding.a binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mBinding = binding;
        Context context = binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        this.mContext = context;
        k();
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void o(@NotNull at.a aVar) {
        c.a.f(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        c.a.d(this);
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        aVar.getRoot().removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mHost = bVar;
    }
}
