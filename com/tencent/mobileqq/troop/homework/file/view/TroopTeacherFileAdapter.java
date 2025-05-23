package com.tencent.mobileqq.troop.homework.file.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.homework.file.vm.TroopTeacherFileVM;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0006%&'()*B!\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\"\u0010#J\u001c\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH\u0016J&\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileAdapter$e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/mobileqq/troop/data/n;", "data", "", "isEnd", "", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "", "payloads", "getItemViewType", "Landroidx/recyclerview/widget/RecyclerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/troop/homework/file/vm/TroopTeacherFileVM;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/homework/file/vm/TroopTeacherFileVM;", "viewModel", "Landroid/app/Activity;", "D", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mobileqq/troop/homework/file/vm/TroopTeacherFileVM;Landroid/app/Activity;)V", "E", "ChangePayload", "a", "b", "c", "d", "e", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopTeacherFileAdapter extends ListAdapter<ItemData, RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private final TroopTeacherFileVM viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private final Activity activity;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final RecyclerView recyclerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileAdapter$ChangePayload;", "", "(Ljava/lang/String;I)V", "CHANGE_PAYLOAD_FILE_COVER", "CHANGE_PAYLOAD_FILE_DOWNLOAD_STATUS", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum ChangePayload {
        CHANGE_PAYLOAD_FILE_COVER,
        CHANGE_PAYLOAD_FILE_DOWNLOAD_STATUS
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileAdapter$b;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileAdapter$e;", "Lcom/tencent/mobileqq/troop/data/n;", "oldFileInfo", "newFileInfo", "", "d", "oldItem", "newItem", "b", "a", "", "c", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends DiffUtil.ItemCallback<ItemData> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final RecyclerView recyclerView;

        public b(RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            this.recyclerView = recyclerView;
        }

        private final boolean d(n oldFileInfo, n newFileInfo) {
            String str = oldFileInfo.f294937w;
            if (!(str == null || str.length() == 0)) {
                return false;
            }
            String str2 = newFileInfo.f294937w;
            return !(str2 == null || str2.length() == 0);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(ItemData oldItem, ItemData newItem) {
            int i3;
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.getViewType() == 2) {
                return true;
            }
            n troopFileInfo = oldItem.getTroopFileInfo();
            n troopFileInfo2 = newItem.getTroopFileInfo();
            return troopFileInfo == null || troopFileInfo2 == null || !((i3 = troopFileInfo2.f294930p) == 8 || troopFileInfo.f294930p != i3 || d(troopFileInfo, troopFileInfo2));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(ItemData oldItem, ItemData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.getViewType() == newItem.getViewType()) {
                return oldItem.getViewType() == 2 || Intrinsics.areEqual(oldItem.getTroopFileInfo(), newItem.getTroopFileInfo());
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(ItemData oldItem, ItemData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            ArrayList arrayList = new ArrayList();
            n troopFileInfo = oldItem.getTroopFileInfo();
            n troopFileInfo2 = newItem.getTroopFileInfo();
            if (troopFileInfo != null && troopFileInfo2 != null && d(troopFileInfo, troopFileInfo2)) {
                arrayList.add(ChangePayload.CHANGE_PAYLOAD_FILE_COVER);
            }
            arrayList.add(ChangePayload.CHANGE_PAYLOAD_FILE_DOWNLOAD_STATUS);
            return arrayList;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileAdapter$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/troop/data/n;", "troopFileInfo", "", "", "payloads", "", "l", "Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileItemView;", "E", "Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileItemView;", "getView", "()Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileItemView;", "view", "<init>", "(Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileItemView;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final TroopTeacherFileItemView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TroopTeacherFileItemView view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        public final void l(n troopFileInfo, List<? extends Object> payloads) {
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            if (troopFileInfo != null) {
                this.view.p(troopFileInfo, payloads);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileAdapter$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTeacherFileAdapter(RecyclerView recyclerView, TroopTeacherFileVM viewModel, Activity activity) {
        super(new b(recyclerView));
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.recyclerView = recyclerView;
        this.viewModel = viewModel;
        this.activity = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return getCurrentList().get(position).getViewType();
    }

    public final void i0(List<n> data, boolean isEnd) {
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList arrayList = new ArrayList();
        Iterator<n> it = data.iterator();
        while (it.hasNext()) {
            arrayList.add(new ItemData(1, it.next()));
        }
        if (!isEnd) {
            arrayList.add(new ItemData(2, null));
        }
        submitList(arrayList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            TroopTeacherFileVM troopTeacherFileVM = this.viewModel;
            Activity activity = this.activity;
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return new c(new TroopTeacherFileItemView(troopTeacherFileVM, activity, context, null, 0, 24, null));
        }
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        frameLayout.addView(LoadingUtil.getLoadingDialogTipsRight(parent.getContext(), false));
        return new d(frameLayout);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (holder instanceof c) {
            ((c) holder).l(getCurrentList().get(position).getTroopFileInfo(), payloads);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileAdapter$e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "viewType", "Lcom/tencent/mobileqq/troop/data/n;", "Lcom/tencent/mobileqq/troop/data/n;", "()Lcom/tencent/mobileqq/troop/data/n;", "troopFileInfo", "<init>", "(ILcom/tencent/mobileqq/troop/data/n;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.file.view.TroopTeacherFileAdapter$e, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class ItemData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int viewType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final n troopFileInfo;

        public ItemData(int i3, n nVar) {
            this.viewType = i3;
            this.troopFileInfo = nVar;
        }

        /* renamed from: a, reason: from getter */
        public final n getTroopFileInfo() {
            return this.troopFileInfo;
        }

        /* renamed from: b, reason: from getter */
        public final int getViewType() {
            return this.viewType;
        }

        public int hashCode() {
            int i3 = this.viewType * 31;
            n nVar = this.troopFileInfo;
            return i3 + (nVar == null ? 0 : nVar.hashCode());
        }

        public String toString() {
            return "ItemData(viewType=" + this.viewType + ", troopFileInfo=" + this.troopFileInfo + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemData)) {
                return false;
            }
            ItemData itemData = (ItemData) other;
            return this.viewType == itemData.viewType && Intrinsics.areEqual(this.troopFileInfo, itemData.troopFileInfo);
        }
    }
}
