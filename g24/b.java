package g24;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import com.tencent.robot.aio.bottombar.viewholder.BlurSource;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import hn2.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010'\u001a\u00020$\u0012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u000e\u00a2\u0006\u0004\b2\u00103J4\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J=\u0010\u0015\u001a\u00020\u00132\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eH\u0002J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0003J;\u0010 \u001a\u00020\u00132\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eJ\u000e\u0010#\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020!R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R&\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00030+j\b\u0012\u0004\u0012\u00020\u0003`,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00064"}, d2 = {"Lg24/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/robot/aio/bottombar/model/a;", "model", "", "position", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "j0", "", VideoTemplateParser.ITEM_LIST, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSizeChange", "", "cb", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "viewHolder", "onBindViewHolder", "getItemCount", "getItemViewType", "itemData", "p0", "m0", "Lcom/tencent/robot/aio/bottombar/viewholder/a;", "blurSource", "o0", "Lcom/tencent/aio/api/runtime/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "aioContext", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "onItemClick", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "dataList", "E", "Lcom/tencent/robot/aio/bottombar/viewholder/a;", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlin/jvm/functions/Function1;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function1<RobotBottomBarItemModel, Unit> onItemClick;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ArrayList<RobotBottomBarItemModel> dataList;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private BlurSource blurSource;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"g24/b$a", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends DiffUtil.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<RobotBottomBarItemModel> f401130a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<RobotBottomBarItemModel> f401131b;

        a(ArrayList<RobotBottomBarItemModel> arrayList, ArrayList<RobotBottomBarItemModel> arrayList2) {
            this.f401130a = arrayList;
            this.f401131b = arrayList2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            int i3;
            int i16;
            if (!Intrinsics.areEqual(this.f401130a.get(oldItemPosition).getIconUrl(), this.f401131b.get(newItemPosition).getIconUrl()) || this.f401130a.get(oldItemPosition).getIconResId() != this.f401131b.get(newItemPosition).getIconResId() || !Intrinsics.areEqual(this.f401130a.get(oldItemPosition).getTitle(), this.f401131b.get(newItemPosition).getTitle())) {
                return false;
            }
            Object data = this.f401130a.get(oldItemPosition).getData();
            if (data != null) {
                i3 = data.hashCode();
            } else {
                i3 = 0;
            }
            Object data2 = this.f401131b.get(newItemPosition).getData();
            if (data2 != null) {
                i16 = data2.hashCode();
            } else {
                i16 = 0;
            }
            if (i3 != i16 || this.f401130a.get(oldItemPosition).getIsChecked() != this.f401131b.get(newItemPosition).getIsChecked()) {
                return false;
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics.areEqual(this.f401130a.get(oldItemPosition).getItemID(), this.f401131b.get(newItemPosition).getItemID());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.f401131b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.f401130a.size();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Function1<? super RobotBottomBarItemModel, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.aioContext = aioContext;
        this.onItemClick = onItemClick;
        this.dataList = new ArrayList<>();
    }

    private final HashMap<String, Object> j0(RobotBottomBarItemModel model, int position) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("capsule_id", model.getItemID());
        hashMap.put("capsule_name", model.getTitle());
        hashMap.put("capsule_num", Integer.valueOf(position));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(b this$0, RobotBottomBarItemModel model, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(model, "$model");
        com.tencent.mobileqq.aio.utils.b.l("em_bas_aicustom_capsules", this$0.j0(model, i3));
        this$0.onItemClick.invoke(model);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l0(List<RobotBottomBarItemModel> itemList, Function1<? super Boolean, Unit> cb5) {
        ArrayList<RobotBottomBarItemModel> arrayList = new ArrayList<>();
        arrayList.addAll(itemList);
        ArrayList<RobotBottomBarItemModel> arrayList2 = this.dataList;
        this.dataList = arrayList;
        boolean z16 = false;
        DiffUtil.calculateDiff(new a(arrayList2, arrayList), false).dispatchUpdatesTo(this);
        if (cb5 != null) {
            if (arrayList.size() != arrayList2.size()) {
                z16 = true;
            }
            cb5.invoke(Boolean.valueOf(z16));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void n0(b bVar, List list, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        bVar.m0(list, function1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.dataList.get(position).getSectionType();
    }

    public final void m0(@NotNull List<RobotBottomBarItemModel> itemList, @Nullable Function1<? super Boolean, Unit> cb5) {
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        l0(itemList, cb5);
    }

    public final void o0(@NotNull BlurSource blurSource) {
        Intrinsics.checkNotNullParameter(blurSource, "blurSource");
        this.blurSource = blurSource;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, final int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        RobotBottomBarItemModel robotBottomBarItemModel = this.dataList.get(position);
        Intrinsics.checkNotNullExpressionValue(robotBottomBarItemModel, "dataList[position]");
        final RobotBottomBarItemModel robotBottomBarItemModel2 = robotBottomBarItemModel;
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            cVar.s(robotBottomBarItemModel2);
            cVar.m(robotBottomBarItemModel2, this.blurSource);
        }
        com.tencent.mobileqq.aio.utils.b.q("em_bas_aicustom_capsules", j0(robotBottomBarItemModel2, position));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: g24.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.k0(b.this, robotBottomBarItemModel2, position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        k g16 = k.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        return new c(g16);
    }

    public final void p0(@NotNull RobotBottomBarItemModel itemData) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        Iterator<RobotBottomBarItemModel> it = this.dataList.iterator();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getItemID(), itemData.getItemID())) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        Integer valueOf = Integer.valueOf(i3);
        if (valueOf.intValue() >= 0) {
            z16 = true;
        }
        if (!z16) {
            valueOf = null;
        }
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            this.dataList.set(intValue, itemData);
            notifyItemChanged(intValue);
        }
    }
}
