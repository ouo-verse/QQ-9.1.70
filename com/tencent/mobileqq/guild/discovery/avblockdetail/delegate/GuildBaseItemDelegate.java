package com.tencent.mobileqq.guild.discovery.avblockdetail.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.discovery.avblockdetail.delegate.GuildBaseItemDelegate.a;
import com.tencent.mobileqq.guild.discovery.avblockdetail.model.a;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00010\u0005:\u0001\u0014B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0007\u001a\u00020\u0006H'J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/avblockdetail/delegate/GuildBaseItemDelegate;", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/a;", "T", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/delegate/GuildBaseItemDelegate$a;", "VH", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "", "o", "Landroid/view/ViewGroup;", "viewGroup", "Landroid/view/View;", "p", "Landroidx/lifecycle/LifecycleOwner;", "d", "Landroidx/lifecycle/LifecycleOwner;", "getViewLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class GuildBaseItemDelegate<T extends com.tencent.mobileqq.guild.discovery.avblockdetail.model.a, VH extends a> extends AbsListItemAdapterDelegate<T, com.tencent.mobileqq.guild.discovery.avblockdetail.model.a, VH> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/avblockdetail/delegate/GuildBaseItemDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static abstract class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    public GuildBaseItemDelegate(@NotNull LifecycleOwner viewLifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        this.viewLifecycleOwner = viewLifecycleOwner;
    }

    @LayoutRes
    public abstract int o();

    @NotNull
    public final View p(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(o(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(viewGroup.context).\u2026utId(), viewGroup, false)");
        return inflate;
    }
}
