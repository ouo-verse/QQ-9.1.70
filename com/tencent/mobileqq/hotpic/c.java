package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bH\u0016R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/hotpic/c;", "Lcom/tencent/qqnt/pluspanel/ui/b;", "Landroid/content/Context;", "context", "Landroid/view/View;", "c", "", "b", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/aio/api/runtime/a;", "a", "Lcom/tencent/mobileqq/hotpic/NTHotPicMainPanel;", "Lcom/tencent/mobileqq/hotpic/NTHotPicMainPanel;", "mHotPicPanel", "Landroid/content/Context;", "mContext", "Lcom/tencent/mobileqq/hotpic/o;", "Lcom/tencent/mobileqq/hotpic/o;", "mViewModel", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class c implements com.tencent.qqnt.pluspanel.ui.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private NTHotPicMainPanel mHotPicPanel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private o mViewModel;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.pluspanel.ui.b
    @NotNull
    public BaseVM<ol3.b, MviUIState, com.tencent.aio.api.runtime.a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BaseVM) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        NTHotPicMainPanel nTHotPicMainPanel = this.mHotPicPanel;
        Context context = null;
        if (nTHotPicMainPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHotPicPanel");
            nTHotPicMainPanel = null;
        }
        Context context2 = this.mContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context = context2;
        }
        o oVar = new o(nTHotPicMainPanel, context);
        this.mViewModel = oVar;
        return oVar;
    }

    @Override // com.tencent.qqnt.pluspanel.ui.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.pluspanel.ui.b
    @NotNull
    public View c(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        View inflate = View.inflate(context, R.layout.fpx, null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.mobileqq.hotpic.NTHotPicMainPanel");
        NTHotPicMainPanel nTHotPicMainPanel = (NTHotPicMainPanel) inflate;
        this.mHotPicPanel = nTHotPicMainPanel;
        if (nTHotPicMainPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHotPicPanel");
            return null;
        }
        return nTHotPicMainPanel;
    }
}
