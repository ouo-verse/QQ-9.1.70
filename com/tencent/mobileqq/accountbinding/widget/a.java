package com.tencent.mobileqq.accountbinding.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/accountbinding/widget/a;", "Lcom/tencent/mobileqq/widget/listitem/w;", "Landroid/view/View;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "H", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/accountbinding/data/b;", "info", "", "J", "Landroid/view/View$OnClickListener;", "k", "Landroid/view/View$OnClickListener;", "clickListener", "Lcom/tencent/mobileqq/accountbinding/widget/b;", "l", "Lcom/tencent/mobileqq/accountbinding/widget/b;", "viewHolder", "<init>", "(Landroid/view/View$OnClickListener;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class a extends w<View> {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener clickListener;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b viewHolder;

    public a(@NotNull View.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) clickListener);
        } else {
            this.clickListener = clickListener;
        }
    }

    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    public String C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "\u5fae\u4fe1";
    }

    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    protected View H(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dpw, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        b bVar = new b(view);
        bVar.a().setOnClickListener(this.clickListener);
        this.viewHolder = bVar;
        return view;
    }

    @UiThread
    public final void J(@NotNull com.tencent.mobileqq.accountbinding.data.b info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        b bVar = this.viewHolder;
        if (bVar != null) {
            bVar.d(info);
        }
    }
}
