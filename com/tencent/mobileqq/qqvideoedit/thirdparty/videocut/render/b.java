package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0007\u00a2\u0006\u0004\b4\u00105J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002J\u0016\u0010\b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002J$\u0010\u000b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\r\u001a\u00020\fH&J\u0017\u0010\u000f\u001a\u00028\u00012\u0006\u0010\r\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020 2\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b#\u0010\"J\b\u0010$\u001a\u00020 H\u0016J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\fH\u0016J\u0019\u0010(\u001a\u0004\u0018\u00018\u00002\u0006\u0010'\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b(\u0010)J\u0019\u0010+\u001a\u0004\u0018\u00010\u00192\u0006\u0010*\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b+\u0010,R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0019008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/b;", "T", "V", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/r;", "", "items", "", DomainData.DOMAIN_NAME, "p", "newList", "oldList", "r", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "model", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/Object;)Ljava/lang/Object;", "", "j", "(Ljava/lang/Object;)Ljava/lang/String;", "newItem", "oldItem", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Object;Ljava/lang/Object;)V", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "from", "to", "o", "(Ljava/lang/Object;II)V", com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "", "l", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "k", tl.h.F, "mediaModel", "c", TemplateParser.KEY_ENTITY_ID, "d", "(I)Ljava/lang/Object;", "modelId", "i", "(Ljava/lang/String;)Ljava/lang/Integer;", "a", "Ljava/util/List;", "currentList", "", "b", "Ljava/util/Map;", "entityIds", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class b<T, V> implements r<V> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends T> currentList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Integer> entityIds;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/b$a", "Landroidx/recyclerview/widget/ListUpdateCallback;", "", "position", "count", "", "onInserted", "onRemoved", "fromPosition", "toPosition", "onMoved", "", "payload", "onChanged", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements ListUpdateCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b<T, V> f276118d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<T> f276119e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<T> f276120f;

        /* JADX WARN: Multi-variable type inference failed */
        a(b<T, V> bVar, List<? extends T> list, List<? extends T> list2) {
            this.f276118d = bVar;
            this.f276119e = list;
            this.f276120f = list2;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int position, int count, @Nullable Object payload) {
            if (payload != null) {
                b<T, V> bVar = this.f276118d;
                List<T> list = this.f276119e;
                List<T> list2 = this.f276120f;
                if (payload instanceof Pair) {
                    Pair pair = (Pair) payload;
                    if ((pair.getFirst() instanceof Integer) && (pair.getSecond() instanceof Integer)) {
                        Object second = pair.getSecond();
                        Intrinsics.checkNotNull(second, "null cannot be cast to non-null type kotlin.Int");
                        T t16 = list.get(((Integer) second).intValue());
                        Object first = pair.getFirst();
                        Intrinsics.checkNotNull(first, "null cannot be cast to non-null type kotlin.Int");
                        bVar.m(t16, list2.get(((Integer) first).intValue()));
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int position, int count) {
            IntRange until;
            int collectionSizeOrDefault;
            until = RangesKt___RangesKt.until(0, count);
            List<T> list = this.f276119e;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                arrayList.add(list.get(((IntIterator) it).nextInt() + position));
            }
            this.f276118d.n(arrayList);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int fromPosition, int toPosition) {
            this.f276118d.o(this.f276120f.get(fromPosition), fromPosition, toPosition);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int position, int count) {
            IntRange until;
            int collectionSizeOrDefault;
            until = RangesKt___RangesKt.until(0, count);
            List<T> list = this.f276120f;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                arrayList.add(list.get(((IntIterator) it).nextInt() + position));
            }
            this.f276118d.p(arrayList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/b$b", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "", "getChangePayload", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C8439b extends DiffUtil.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<T> f276121a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<T> f276122b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b<T, V> f276123c;

        /* JADX WARN: Multi-variable type inference failed */
        C8439b(List<? extends T> list, List<? extends T> list2, b<T, V> bVar) {
            this.f276121a = list;
            this.f276122b = list2;
            this.f276123c = bVar;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return this.f276123c.k(this.f276121a.get(oldItemPosition), this.f276122b.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return this.f276123c.l(this.f276121a.get(oldItemPosition), this.f276122b.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        @NotNull
        public Object getChangePayload(int oldItemPosition, int newItemPosition) {
            return new Pair(Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.f276122b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.f276121a.size();
        }
    }

    public b() {
        List<? extends T> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.currentList = emptyList;
        this.entityIds = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(List<? extends T> items) {
        for (T t16 : items) {
            this.entityIds.put(j(t16), Integer.valueOf(b(q(t16))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(List<? extends T> items) {
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            String j3 = j(it.next());
            Integer num = this.entityIds.get(j3);
            if (num != null) {
                num.intValue();
                a(num.intValue());
            }
            this.entityIds.remove(j3);
        }
    }

    private final void r(List<? extends T> newList, List<? extends T> oldList) {
        if (Intrinsics.areEqual(newList, oldList)) {
            return;
        }
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new C8439b(oldList, newList, this), h());
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(callback, detectMoves())");
        calculateDiff.dispatchUpdatesTo(new a(this, newList, oldList));
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.j
    public void c(@NotNull MediaModel mediaModel) {
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        List<? extends T> s16 = s(mediaModel);
        r(s16, this.currentList);
        this.currentList = s16;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    @Nullable
    public T d(int entityId) {
        Object firstOrNull;
        boolean z16;
        Map<String, Integer> map = this.entityIds;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() == entityId) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(linkedHashMap.keySet());
        String str = (String) firstOrNull;
        if (str == null) {
            return null;
        }
        for (T t16 : this.currentList) {
            if (Intrinsics.areEqual(j(t16), str)) {
                return t16;
            }
        }
        return null;
    }

    public boolean h() {
        return false;
    }

    @Nullable
    public Integer i(@NotNull String modelId) {
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        return this.entityIds.get(modelId);
    }

    @NotNull
    public abstract String j(T model);

    public boolean k(T newModel, T oldModel) {
        return Intrinsics.areEqual(newModel, oldModel);
    }

    public boolean l(T newModel, T oldModel) {
        return Intrinsics.areEqual(j(newModel), j(oldModel));
    }

    public void m(T newItem, T oldItem) {
        Integer num = this.entityIds.get(j(newItem));
        if (num != null) {
            e(num.intValue(), q(oldItem), q(newItem));
            return;
        }
        throw new IllegalStateException("couldn't find target entityId");
    }

    public abstract V q(T model);

    @NotNull
    public abstract List<T> s(@NotNull MediaModel model);

    public void o(T item, int from, int to5) {
    }
}
