package com.tencent.qqnt.forwardaio.title;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.forwardaio.title.ForwardShareAIOTitleUIState;
import com.tencent.qqnt.forwardaio.title.h;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w71.ab;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/forwardaio/title/ForwardShareAIOTitleVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/forwardaio/title/h;", "Lcom/tencent/qqnt/forwardaio/title/ForwardShareAIOTitleUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "", "bindViewAndData", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "state", "d1", "Lw71/ab;", "d", "Lkotlin/Lazy;", "c1", "()Lw71/ab;", "mBinding", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ForwardShareAIOTitleVB extends com.tencent.aio.base.mvvm.a<h, ForwardShareAIOTitleUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBinding;

    public ForwardShareAIOTitleVB() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<ab>() { // from class: com.tencent.qqnt.forwardaio.title.ForwardShareAIOTitleVB$mBinding$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardShareAIOTitleVB.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ab invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? ab.g(LayoutInflater.from(ForwardShareAIOTitleVB.this.getMContext())) : (ab) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mBinding = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ab c1() {
        return (ab) this.mBinding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(ForwardShareAIOTitleVB this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.sendIntent(new h.b(it));
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            sendIntent(h.a.f356773d);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<h, ForwardShareAIOTitleUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BaseVM) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new j();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull ForwardShareAIOTitleUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof ForwardShareAIOTitleUIState.UpdateTitle) {
            c1().f444720d.setText(((ForwardShareAIOTitleUIState.UpdateTitle) state).a());
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
        c1().f444718b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.forwardaio.title.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForwardShareAIOTitleVB.e1(ForwardShareAIOTitleVB.this, view);
            }
        });
        RelativeLayout root = c1().getRoot();
        root.setLayoutParams(new ViewGroup.LayoutParams(-1, root.getContext().getResources().getDimensionPixelSize(R.dimen.bzh)));
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root.apply {\n  \u2026)\n            )\n        }");
        return root;
    }
}
