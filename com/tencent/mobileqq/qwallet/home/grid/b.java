package com.tencent.mobileqq.qwallet.home.grid;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00192\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u001a\u001bB\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0005H\u0016R\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/grid/b;", "Landroidx/recyclerview/widget/ListAdapter;", "", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "Lcom/tencent/mobileqq/qwallet/home/grid/b$c;", "", "page", "", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "k0", "holder", "position", "j0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "spanCount", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "twoLineTitleMode", "<init>", "(IZ)V", "D", "b", "c", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b extends ListAdapter<List<? extends QWalletHomePage$AppInfo>, c> {

    @NotNull
    private static final a E = new a();

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean twoLineTitleMode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int spanCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J$\u0010\b\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qwallet/home/grid/b$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "oldItem", "newItem", "", "b", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends DiffUtil.ItemCallback<List<? extends QWalletHomePage$AppInfo>> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull List<QWalletHomePage$AppInfo> oldItem, @NotNull List<QWalletHomePage$AppInfo> newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.size() != newItem.size()) {
                return false;
            }
            int i3 = 0;
            for (Object obj : oldItem) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (!c4.a.j((QWalletHomePage$AppInfo) obj, newItem.get(i3))) {
                    return false;
                }
                i3 = i16;
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull List<QWalletHomePage$AppInfo> oldItem, @NotNull List<QWalletHomePage$AppInfo> newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem == newItem) {
                return true;
            }
            if (oldItem.size() != newItem.size()) {
                return false;
            }
            int i3 = 0;
            for (Object obj : oldItem) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (!c4.a.n((QWalletHomePage$AppInfo) obj, newItem.get(i3))) {
                    return false;
                }
                i3 = i16;
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/grid/b$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "list", "", "l", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "view", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final RecyclerView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull RecyclerView view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        public final void l(@NotNull List<QWalletHomePage$AppInfo> list) {
            GridAppRvAdapter gridAppRvAdapter;
            Intrinsics.checkNotNullParameter(list, "list");
            RecyclerView.Adapter adapter = this.view.getAdapter();
            if (adapter instanceof GridAppRvAdapter) {
                gridAppRvAdapter = (GridAppRvAdapter) adapter;
            } else {
                gridAppRvAdapter = null;
            }
            if (gridAppRvAdapter != null) {
                gridAppRvAdapter.submitList(list);
            }
        }
    }

    public b(int i3, boolean z16) {
        super(E);
        this.spanCount = i3;
        this.twoLineTitleMode = z16;
    }

    public final void i0(int page) {
        List<? extends QWalletHomePage$AppInfo> item = getItem(page);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(page)");
        for (QWalletHomePage$AppInfo qWalletHomePage$AppInfo : item) {
            if (c4.a.u(qWalletHomePage$AppInfo)) {
                c4.a.y(qWalletHomePage$AppInfo, "index.tuijian.show", String.valueOf(page + 1), 0, 4, null);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull c holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Collection item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        holder.l((List) item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        RecyclerView recyclerView = new RecyclerView(parent.getContext());
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        recyclerView.setClipChildren(false);
        recyclerView.setAdapter(new GridAppRvAdapter(this.twoLineTitleMode, false, 2, null));
        recyclerView.setLayoutManager(new GridLayoutManager(parent.getContext(), this.spanCount));
        return new c(recyclerView);
    }
}
