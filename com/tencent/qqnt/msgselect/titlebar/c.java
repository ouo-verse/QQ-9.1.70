package com.tencent.qqnt.msgselect.titlebar;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.msgselect.titlebar.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/msgselect/titlebar/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/msgselect/titlebar/b;", "", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "v", "", NodeProps.ON_CLICK, "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c extends com.tencent.aio.base.mvvm.a<b, Object> implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<b, Object, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseVM) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            sendIntent(b.a.f359759d);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View inflate = LayoutInflater.from(getMContext()).inflate(R.layout.hzr, createViewParams.b(), false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        View findViewById = linearLayout.findViewById(R.id.ivTitleBtnLeft);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        TextView textView = (TextView) linearLayout.findViewById(R.id.ivTitleBtnLeftButton);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setOnClickListener(this);
            textView.setBackgroundResource(0);
            textView.setPadding(0, 0, 0, 0);
            textView.setText(getMContext().getText(R.string.f170256ys3));
            textView.setTextColor(linearLayout.getResources().getColorStateList(R.color.qui_common_text_nav_secondary_selector));
        }
        View findViewById2 = linearLayout.findViewById(R.id.jo9);
        if (findViewById2 != null) {
            findViewById2.setBackgroundResource(R.drawable.qui_bg_nav_secondary);
        }
        return linearLayout;
    }
}
