package com.tencent.mobileqq.sharepanel.multiSelect.adapter;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.sharepanel.multiSelect.util.JumpUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/adapter/j;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "data", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lwq2/c;", "E", "Lwq2/c;", "binding", "<init>", "(Lwq2/c;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class j extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final wq2.c binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull wq2.c binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) binding);
        } else {
            this.binding = binding;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(SharePanelContactItem data, View view) {
        Context context;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        if (!data.g() && (context = view.getContext()) != null) {
            JumpUtil.f287479a.a(context, data.e(), data.f(), data.b());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void m(@NotNull final SharePanelContactItem data, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data, position);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.binding.f446064c.setAvatarSize(ViewUtils.dpToPx(40.0f));
        this.binding.f446064c.b(data);
        this.binding.f446065d.setText(data.b());
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.adapter.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.n(SharePanelContactItem.this, view);
            }
        });
        if (data.g()) {
            this.binding.f446063b.setVisibility(4);
            this.binding.getRoot().setBackgroundColor(0);
        } else {
            this.binding.f446063b.setVisibility(0);
            this.binding.getRoot().setBackground(this.binding.getRoot().getContext().getResources().getDrawable(R.drawable.lkc, null));
        }
    }
}
