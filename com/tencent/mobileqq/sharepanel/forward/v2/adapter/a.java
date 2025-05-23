package com.tencent.mobileqq.sharepanel.forward.v2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/v2/adapter/a;", "", "Landroid/view/View;", "b", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "data", "", "showDivider", "", "a", "Lwq2/a;", "Lwq2/a;", "binding", "Landroid/widget/LinearLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/widget/LinearLayout;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final wq2.a binding;

    public a(@NotNull LinearLayout parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parent);
            return;
        }
        wq2.a g16 = wq2.a.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        this.binding = g16;
    }

    public final void a(@NotNull SharePanelContactItem data, boolean showDivider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, data, Boolean.valueOf(showDivider));
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        ImageView imageView = this.binding.f446054b;
        com.tencent.mobileqq.sharepanel.multiSelect.util.a aVar = com.tencent.mobileqq.sharepanel.multiSelect.util.a.f287480a;
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setImageDrawable(aVar.b(context, data));
        this.binding.f446056d.setText(data.b());
        View view = this.binding.f446055c;
        if (!showDivider) {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    @NotNull
    public final View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ConstraintLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }
}
