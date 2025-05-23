package com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter;

import androidx.recyclerview.widget.RecyclerView;
import fi3.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/i;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "dateString", "", "bindData", "Lfi3/m;", "E", "Lfi3/m;", "getViewBinding", "()Lfi3/m;", "setViewBinding", "(Lfi3/m;)V", "viewBinding", "<init>", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class i extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private m viewBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(m viewBinding) {
        super(viewBinding.getRoot());
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        this.viewBinding = viewBinding;
    }

    public final void bindData(String dateString) {
        Intrinsics.checkNotNullParameter(dateString, "dateString");
        this.viewBinding.getRoot().setText(dateString);
    }
}
