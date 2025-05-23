package com.tencent.mobileqq.guild.widget.adapterdelegates;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\b\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/adapterdelegates/m;", "Landroidx/viewbinding/ViewBinding;", "VB", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "E", "Landroidx/viewbinding/ViewBinding;", "l", "()Landroidx/viewbinding/ViewBinding;", "binding", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class m<VB extends ViewBinding> extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final VB binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull VB binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    @NotNull
    public final VB l() {
        return this.binding;
    }
}
