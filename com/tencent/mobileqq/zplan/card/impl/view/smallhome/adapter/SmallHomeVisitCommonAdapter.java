package com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.utils.t;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import fi3.l;
import fi3.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005'()*+B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b$\u0010%J \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u001b\u0010\r\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020 0\u0003j\b\u0012\u0004\u0012\u00020 `\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/SmallHomeVisitCommonAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ljava/util/ArrayList;", "Lpv4/d;", "Lkotlin/collections/ArrayList;", "dataList", "", "j0", "", "clearData", "", "data", "i0", "([Lpv4/d;)V", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemViewType", "getItemCount", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/SmallHomeVisitCommonAdapter$c;", "D", "Ljava/util/ArrayList;", VideoTemplateParser.ITEM_LIST, "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;)V", "E", "a", "b", "c", "ItemType", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SmallHomeVisitCommonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private final ZplanViewReportHelper reportHelper;

    /* renamed from: D, reason: from kotlin metadata */
    private final ArrayList<c> itemList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/SmallHomeVisitCommonAdapter$ItemType;", "", "(Ljava/lang/String;I)V", "TYPE_DATE", "TYPE_RECORD", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    private enum ItemType {
        TYPE_DATE,
        TYPE_RECORD
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/SmallHomeVisitCommonAdapter$b;", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/SmallHomeVisitCommonAdapter$c;", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/SmallHomeVisitCommonAdapter$ItemType;", "getItemType", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setDateText", "(Ljava/lang/String;)V", "dateText", "<init>", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String dateText;

        public b(String dateText) {
            Intrinsics.checkNotNullParameter(dateText, "dateText");
            this.dateText = dateText;
        }

        /* renamed from: a, reason: from getter */
        public final String getDateText() {
            return this.dateText;
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter.SmallHomeVisitCommonAdapter.c
        public ItemType getItemType() {
            return ItemType.TYPE_DATE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/SmallHomeVisitCommonAdapter$c;", "", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/SmallHomeVisitCommonAdapter$ItemType;", "getItemType", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface c {
        ItemType getItemType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/SmallHomeVisitCommonAdapter$d;", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/SmallHomeVisitCommonAdapter$c;", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/SmallHomeVisitCommonAdapter$ItemType;", "getItemType", "Lpv4/d;", "a", "Lpv4/d;", "()Lpv4/d;", "setRecord", "(Lpv4/d;)V", QQPermissionConstants.Permission.AUIDO_GROUP, "<init>", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private pv4.d record;

        public d(pv4.d record) {
            Intrinsics.checkNotNullParameter(record, "record");
            this.record = record;
        }

        /* renamed from: a, reason: from getter */
        public final pv4.d getRecord() {
            return this.record;
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter.SmallHomeVisitCommonAdapter.c
        public ItemType getItemType() {
            return ItemType.TYPE_RECORD;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class e<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((pv4.d) t17).f427582d), Long.valueOf(((pv4.d) t16).f427582d));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class f<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((pv4.d) t16).f427582d), Long.valueOf(((pv4.d) t17).f427582d));
            return compareValues;
        }
    }

    public SmallHomeVisitCommonAdapter(Context context, ZplanViewReportHelper reportHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reportHelper, "reportHelper");
        this.context = context;
        this.reportHelper = reportHelper;
        this.itemList = new ArrayList<>();
    }

    private final int j0(ArrayList<pv4.d> dataList) {
        Object obj;
        if (dataList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(dataList, new e());
        }
        HashMap hashMap = new HashMap();
        for (pv4.d dVar : dataList) {
            String d16 = t.f373300a.d(dVar.f427582d * 1000);
            ArrayList arrayList = (ArrayList) hashMap.get(d16);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(d16, arrayList);
            }
            arrayList.add(dVar);
        }
        Collection<ArrayList> values = hashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "groupMap.values");
        for (ArrayList it : values) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(it, new f());
            }
        }
        Set<String> keySet = hashMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "groupMap.keys");
        int i3 = 0;
        for (String date : keySet) {
            Iterator<T> it5 = this.itemList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it5.next();
                c cVar = (c) obj;
                if ((cVar instanceof b) && Intrinsics.areEqual(((b) cVar).getDateText(), date)) {
                    break;
                }
            }
            if (obj == null) {
                ArrayList<c> arrayList2 = this.itemList;
                Intrinsics.checkNotNullExpressionValue(date, "date");
                arrayList2.add(new b(date));
                i3++;
            }
            ArrayList arrayList3 = (ArrayList) hashMap.get(date);
            if (arrayList3 != null) {
                Intrinsics.checkNotNullExpressionValue(arrayList3, "groupMap[date]");
                Iterator it6 = arrayList3.iterator();
                while (it6.hasNext()) {
                    this.itemList.add(new d((pv4.d) it6.next()));
                    i3++;
                }
            }
        }
        return i3;
    }

    public final void clearData() {
        this.itemList.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.itemList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.itemList.get(position).getItemType().ordinal();
    }

    public final void i0(pv4.d[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList<pv4.d> arrayList = new ArrayList<>();
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, data);
        j0(arrayList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        c cVar = this.itemList.get(position);
        Intrinsics.checkNotNullExpressionValue(cVar, "itemList[position]");
        c cVar2 = cVar;
        if ((holder instanceof i) && (cVar2 instanceof b)) {
            ((i) holder).bindData(((b) cVar2).getDateText());
        } else if ((holder instanceof h) && (cVar2 instanceof d)) {
            ((h) holder).r(((d) cVar2).getRecord());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == ItemType.TYPE_RECORD.ordinal()) {
            l g16 = l.g(LayoutInflater.from(this.context), parent, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026, false\n                )");
            return new h(g16, this.reportHelper);
        }
        m g17 = m.g(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(g17, "inflate(\n               \u2026ontext)\n                )");
        return new i(g17);
    }
}
