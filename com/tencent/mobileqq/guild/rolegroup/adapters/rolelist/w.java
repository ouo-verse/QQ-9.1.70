package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.RoleGroupListViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001%B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0012\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J&\u0010\u0010\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0007H\u0016R\u0016\u0010\u001b\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/w;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/ad;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "holder", "position", "", "k0", "", "payloads", "l0", "getItemViewType", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$ShowState;", "state", "n0", com.tencent.luggage.wxa.c8.c.G, "", "j0", "i0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$ShowState;", "initState", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/q;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/q;", "factory", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/p;", "eventHandler", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$ShowState;Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/p;)V", "D", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class w extends ListAdapter<r, ad> {

    @NotNull
    private static final a E = new a();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final q factory;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RoleGroupListViewModel.ShowState initState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/adapters/rolelist/w$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "p0", "p1", "", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends DiffUtil.ItemCallback<r> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull r p06, @NotNull r p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return Intrinsics.areEqual(p06, p16);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull r p06, @NotNull r p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            if (p06.getType() != p16.getType()) {
                return false;
            }
            return Intrinsics.areEqual(p06.getId(), p16.getId());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(@NotNull RoleGroupListViewModel.ShowState initState, @NotNull p eventHandler) {
        super(E);
        Intrinsics.checkNotNullParameter(initState, "initState");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.initState = initState;
        this.factory = new q(eventHandler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        q qVar = this.factory;
        r item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        return qVar.b(item);
    }

    public boolean i0(int pos) {
        if (j0(pos) && (j0(pos - 1) || j0(pos + 1))) {
            return true;
        }
        return false;
    }

    public boolean j0(int pos) {
        if (pos < 0 || pos >= getCurrentList().size()) {
            return false;
        }
        r item = getItem(pos);
        if (!(item instanceof RoleItem)) {
            return false;
        }
        return ((RoleItem) item).getRole().getRolePermission().getIsSortableInList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull ad holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull ad holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        r item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "item");
        holder.l(item, this.initState);
        holder.itemView.setTag(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public ad onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return this.factory.a(parent, viewType);
    }

    public final void n0(@NotNull RoleGroupListViewModel.ShowState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.initState == state) {
            return;
        }
        this.initState = state;
        notifyDataSetChanged();
    }
}
