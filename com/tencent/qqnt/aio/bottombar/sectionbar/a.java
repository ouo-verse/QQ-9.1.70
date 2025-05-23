package com.tencent.qqnt.aio.bottombar.sectionbar;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001f0\u001e\u00a2\u0006\u0004\b+\u0010,J/\u0010\n\u001a\u00020\b2%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003H\u0002J\u0006\u0010\f\u001a\u00020\u000bJE\u0010\u0011\u001a\u00020\b2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000e0#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R&\u0010*\u001a\u0012\u0012\u0004\u0012\u00020'0\rj\b\u0012\u0004\u0012\u00020'`\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSizeChange", "", "cb", "j0", "", "i0", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/b;", "Lkotlin/collections/ArrayList;", "modelList", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemCount", "getItemViewType", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "sectionAdapterMap", "Ljava/util/SortedMap;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/SortedMap;", "dataMap", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/a;", "D", "Ljava/util/ArrayList;", "dataList", "<init>", "(Ljava/util/Map;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private SortedMap<com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b, com.tencent.qqnt.aio.bottombar.sectionbar.model.b> dataMap;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.a> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b> sectionAdapterMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.aio.bottombar.sectionbar.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final class C9470a<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public C9470a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b) t17).b()), Integer.valueOf(((com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b) t16).b()));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/bottombar/sectionbar/a$b", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b extends DiffUtil.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.a> f349801a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.a> f349802b;

        b(ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.a> arrayList, ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.a> arrayList2) {
            this.f349801a = arrayList;
            this.f349802b = arrayList2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) arrayList, (Object) arrayList2);
            }
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition))).booleanValue();
            }
            if (Intrinsics.areEqual(this.f349801a.get(oldItemPosition).b(), this.f349802b.get(newItemPosition).b()) && Intrinsics.areEqual(this.f349801a.get(oldItemPosition).d(), this.f349802b.get(newItemPosition).d())) {
                Object a16 = this.f349801a.get(oldItemPosition).a();
                if (a16 != null) {
                    i3 = a16.hashCode();
                } else {
                    i3 = 0;
                }
                Object a17 = this.f349802b.get(newItemPosition).a();
                if (a17 != null) {
                    i16 = a17.hashCode();
                } else {
                    i16 = 0;
                }
                if (i3 == i16) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition))).booleanValue();
            }
            if (this.f349801a.get(oldItemPosition).c() == this.f349802b.get(newItemPosition).c()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f349802b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f349801a.size();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Map<Integer, ? extends com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b> sectionAdapterMap) {
        SortedMap<com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b, com.tencent.qqnt.aio.bottombar.sectionbar.model.b> sortedMapOf;
        Intrinsics.checkNotNullParameter(sectionAdapterMap, "sectionAdapterMap");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sectionAdapterMap);
            return;
        }
        this.sectionAdapterMap = sectionAdapterMap;
        sortedMapOf = MapsKt__MapsJVMKt.sortedMapOf(new C9470a(), new Pair[0]);
        this.dataMap = sortedMapOf;
        this.dataList = new ArrayList<>();
    }

    private final void j0(Function1<? super Boolean, Unit> cb5) {
        ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.a> arrayList = new ArrayList<>();
        Iterator<Map.Entry<com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b, com.tencent.qqnt.aio.bottombar.sectionbar.model.b>> it = this.dataMap.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<T> it5 = it.next().getValue().a().iterator();
            while (it5.hasNext()) {
                arrayList.add((com.tencent.qqnt.aio.bottombar.sectionbar.model.a) it5.next());
            }
        }
        ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.a> arrayList2 = this.dataList;
        this.dataList = arrayList;
        boolean z16 = false;
        DiffUtil.calculateDiff(new b(arrayList2, arrayList), false).dispatchUpdatesTo(this);
        if (cb5 != null) {
            if (arrayList.size() != arrayList2.size()) {
                z16 = true;
            }
            cb5.invoke(Boolean.valueOf(z16));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, position)).intValue();
        }
        return this.dataList.get(position).c();
    }

    public final int i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.dataList.size();
    }

    public final void k0(@NotNull ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.b> modelList, @Nullable Function1<? super Boolean, Unit> cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) modelList, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(modelList, "modelList");
        if (modelList.isEmpty()) {
            return;
        }
        for (com.tencent.qqnt.aio.bottombar.sectionbar.model.b bVar : modelList) {
            if (!this.sectionAdapterMap.containsKey(Integer.valueOf(bVar.b()))) {
                return;
            }
            if (bVar.a().size() == 0) {
                this.dataMap.remove(this.sectionAdapterMap.get(Integer.valueOf(bVar.b())));
            } else {
                this.dataMap.put(this.sectionAdapterMap.get(Integer.valueOf(bVar.b())), bVar);
            }
        }
        j0(cb5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b bVar = this.sectionAdapterMap.get(Integer.valueOf(getItemViewType(position)));
        if (bVar != null) {
            com.tencent.qqnt.aio.bottombar.sectionbar.model.a aVar = this.dataList.get(position);
            Intrinsics.checkNotNullExpressionValue(aVar, "dataList[position]");
            bVar.f(holder, aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b bVar = this.sectionAdapterMap.get(Integer.valueOf(viewType));
        if (bVar == null || (g16 = bVar.g(parent)) == null) {
            return new com.tencent.qqnt.aio.bottombar.sectionbar.viewholder.a(parent);
        }
        return g16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b bVar = this.sectionAdapterMap.get(Integer.valueOf(holder.getItemViewType()));
        if (bVar != null) {
            bVar.e(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b bVar = this.sectionAdapterMap.get(Integer.valueOf(holder.getItemViewType()));
        if (bVar != null) {
            bVar.h(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b bVar = this.sectionAdapterMap.get(Integer.valueOf(holder.getItemViewType()));
        if (bVar != null) {
            bVar.i(holder);
        }
    }
}
