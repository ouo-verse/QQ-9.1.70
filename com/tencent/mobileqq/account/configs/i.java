package com.tencent.mobileqq.account.configs;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0014J&\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/account/configs/i;", "Lcom/tencent/mobileqq/widget/listitem/w;", "Lcom/tencent/mobileqq/account/configs/SubAccountView;", "view", "Lcom/tencent/mobileqq/widget/listitem/Group$c;", "outMargin", "", "J", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "L", "", "position", "", "", "payloads", "K", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/account/viewmodel/c;", "k", "Lcom/tencent/mobileqq/account/viewmodel/c;", "vm", "Landroidx/lifecycle/LifecycleOwner;", "l", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/listitem/x;", "singleLineConfig", "<init>", "(Lcom/tencent/mobileqq/account/viewmodel/c;Landroidx/lifecycle/LifecycleOwner;)V", "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class i extends w<SubAccountView> {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.account.viewmodel.c vm;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final LifecycleOwner owner;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final x<x.b.C8996b, x.c.g> singleLineConfig;

    public i(@Nullable com.tencent.mobileqq.account.viewmodel.c cVar, @Nullable LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) lifecycleOwner);
            return;
        }
        this.vm = cVar;
        this.owner = lifecycleOwner;
        String string = BaseApplication.getContext().getString(R.string.hrx);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(c\u2026tring.subaccount_bind_qq)");
        this.singleLineConfig = new x<>(new x.b.C8996b(string, R.drawable.qui_qqrelevance), new x.c.g("", true, false, 4, null));
    }

    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    public String C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.singleLineConfig.K().getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void D(@NotNull SubAccountView view, @NotNull Group.c outMargin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) outMargin);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outMargin, "outMargin");
        int dpToPx = ViewUtils.dpToPx(12.0f);
        outMargin.c(outMargin.getLeft() + view.getResources().getDimensionPixelSize(R.dimen.dac) + dpToPx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void F(@NotNull SubAccountView view, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        view.e(this.singleLineConfig.K(), this.singleLineConfig.O());
        VideoReport.setElementId(view, "em_bas_associated_qq_number");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public SubAccountView H(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SubAccountView) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        com.tencent.mobileqq.account.viewmodel.c cVar = this.vm;
        LifecycleOwner lifecycleOwner = this.owner;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        SubAccountView subAccountView = new SubAccountView(cVar, lifecycleOwner, context, null, 0, 24, null);
        subAccountView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return subAccountView;
    }
}
