package com.tencent.qqnt.forwardaio.reserve1.blur;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.reserve1.blur.TopBlurUIState;
import com.tencent.mobileqq.aio.reserve1.blur.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.forwardaio.reserve1.blur.b;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w71.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/forwardaio/reserve1/blur/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/reserve1/blur/c;", "Lcom/tencent/mobileqq/aio/reserve1/blur/TopBlurUIState;", "Lcom/tencent/qqnt/forwardaio/reserve1/blur/b$b;", "", "height", "", "f1", "Lcom/tencent/mobileqq/aio/reserve1/blur/TopBlurUIState$ShowBlurView;", "state", "b1", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "Lcom/tencent/aio/base/mvvm/b;", "c1", "d1", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "a", "Lw71/s;", "d", "Lw71/s;", "mTitleBinding", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends com.tencent.aio.base.mvvm.a<c, TopBlurUIState> implements b.InterfaceC9623b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private s mTitleBinding;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b1(TopBlurUIState.ShowBlurView state) {
        boolean z16;
        s sVar = this.mTitleBinding;
        s sVar2 = null;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            sVar = null;
        }
        QQBlurViewWrapper root = sVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mTitleBinding.root");
        s sVar3 = this.mTitleBinding;
        if (sVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
        } else {
            sVar2 = sVar3;
        }
        sVar2.getRoot().getLayoutParams().height = state.a();
        root.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 24) {
            z16 = true;
        } else {
            z16 = false;
        }
        f.a aVar = new f.a(z16, 64.0f, null, getMContext().getColor(R.color.qui_common_bg_nav_aio), new ColorDrawable(getMContext().getColor(R.color.qui_common_bg_nav_aio)), Integer.valueOf(R.drawable.c1j));
        aVar.o(true);
        root.a(aVar);
    }

    private final void e1() {
        boolean z16;
        s sVar = this.mTitleBinding;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            sVar = null;
        }
        QQBlurViewWrapper root = sVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mTitleBinding.root");
        if (Build.VERSION.SDK_INT >= 24) {
            z16 = true;
        } else {
            z16 = false;
        }
        f.a aVar = new f.a(z16, 64.0f, null, getMContext().getColor(R.color.qui_common_bg_nav_aio), new ColorDrawable(getMContext().getColor(R.color.qui_common_bg_nav_aio)), Integer.valueOf(R.drawable.c1j));
        aVar.o(true);
        root.a(aVar);
    }

    private final void f1(int height) {
        s sVar = this.mTitleBinding;
        s sVar2 = null;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            sVar = null;
        }
        sVar.getRoot().getLayoutParams().height = height;
        s sVar3 = this.mTitleBinding;
        if (sVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            sVar3 = null;
        }
        QQBlurViewWrapper root = sVar3.getRoot();
        s sVar4 = this.mTitleBinding;
        if (sVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
        } else {
            sVar2 = sVar4;
        }
        root.setLayoutParams(sVar2.getRoot().getLayoutParams());
    }

    @Override // com.tencent.qqnt.forwardaio.reserve1.blur.b.InterfaceC9623b
    @NotNull
    public QQBlurViewWrapper a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QQBlurViewWrapper) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        s sVar = this.mTitleBinding;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            sVar = null;
        }
        QQBlurViewWrapper root = sVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mTitleBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.bindViewAndData();
            sendIntent(c.a.f193232d);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<c, TopBlurUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new b(this);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull TopBlurUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof TopBlurUIState.HideBlurView) {
            s sVar = this.mTitleBinding;
            if (sVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                sVar = null;
            }
            sVar.getRoot().setVisibility(8);
            return;
        }
        if (state instanceof TopBlurUIState.ShowBlurView) {
            b1((TopBlurUIState.ShowBlurView) state);
        } else if (state instanceof TopBlurUIState.UpdateBlurHeight) {
            f1(((TopBlurUIState.UpdateBlurHeight) state).a());
        } else if (state instanceof TopBlurUIState.PostThemeChange) {
            e1();
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        s g16 = s.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, createViewParams.parent, false)");
        this.mTitleBinding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            g16 = null;
        }
        QQBlurViewWrapper root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mTitleBinding.root");
        return root;
    }
}
