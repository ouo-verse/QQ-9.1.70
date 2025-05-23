package com.tencent.mobileqq.aio.msglist.holder.component;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0004J\b\u0010\b\u001a\u00020\u0006H\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/e;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "", "q1", "p1", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "inflatedContainer", "", "f", "Z", "inflated", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class e extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup inflatedContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean inflated;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(e this$0, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inflated = true;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        this$0.inflatedContainer = (ViewGroup) view;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public final View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View f16 = f1();
        if (f16 instanceof ViewStub) {
            ((ViewStub) f16).setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.d
                @Override // android.view.ViewStub.OnInflateListener
                public final void onInflate(ViewStub viewStub, View view) {
                    e.o1(e.this, viewStub, view);
                }
            });
            return f16;
        }
        throw new Exception("lazy Component must be viewStub");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ViewGroup viewGroup = this.inflatedContainer;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!this.inflated) {
            View f16 = f1();
            Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type android.view.ViewStub");
            ((ViewStub) f16).inflate();
        }
        ViewGroup viewGroup = this.inflatedContainer;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            viewGroup.addView(c1());
            k1(viewGroup);
        }
    }
}
