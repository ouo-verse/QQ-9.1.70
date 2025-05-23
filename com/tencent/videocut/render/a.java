package com.tencent.videocut.render;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.videocut.model.MediaModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0011\b&\u0018\u0000 0*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u00011B\u0007\u00a2\u0006\u0004\b=\u0010>J$\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\n\u001a\u00020\tH&J\u0017\u0010\f\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0012\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0004J\u0016\u0010\u0013\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0014J\u001f\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020 2\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b#\u0010\"J\b\u0010$\u001a\u00020 H\u0016J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\tH\u0016J\u0017\u0010'\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u0004\u0018\u00010\u00192\u0006\u0010)\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b*\u0010+J\u0012\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010)\u001a\u00020\u000eH\u0016J\u001c\u00100\u001a\u00020\u00072\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020,0.H\u0016R(\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R&\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020,0.8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/videocut/render/a;", "T", "V", "Lcom/tencent/videocut/render/m;", "", "newList", "oldList", "", "r", "Lcom/tencent/videocut/model/MediaModel;", "model", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/Object;)Ljava/lang/Object;", "", "j", "(Ljava/lang/Object;)Ljava/lang/String;", "items", DomainData.DOMAIN_NAME, "p", "newItem", "oldItem", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Object;Ljava/lang/Object;)V", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "from", "to", "o", "(Ljava/lang/Object;II)V", com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "", "l", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "k", "e", "mediaModel", "d", "u", "(Lcom/tencent/videocut/model/MediaModel;)V", "modelId", tl.h.F, "(Ljava/lang/String;)Ljava/lang/Integer;", "Lorg/light/lightAssetKit/Entity;", "g", "", "entityMap", "c", "a", "Ljava/util/List;", "f", "()Ljava/util/List;", "t", "(Ljava/util/List;)V", "currentList", "b", "Ljava/util/Map;", "i", "()Ljava/util/Map;", "entitys", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public abstract class a<T, V> implements m<T, V> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends T> currentList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Entity> entitys;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/videocut/render/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.videocut.render.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/videocut/render/a$b", "Landroidx/recyclerview/widget/ListUpdateCallback;", "", "position", "count", "", "onInserted", "onRemoved", "fromPosition", "toPosition", "onMoved", "", "payload", "onChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes27.dex */
    public static final class b implements ListUpdateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<T> f384119d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<T> f384120e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList<T> f384121f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ a<T, V> f384122h;

        b(List<? extends T> list, List<? extends T> list2, ArrayList<T> arrayList, a<T, V> aVar) {
            this.f384119d = list;
            this.f384120e = list2;
            this.f384121f = arrayList;
            this.f384122h = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, list, list2, arrayList, aVar);
            }
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int position, int count, @Nullable Object payload) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(position), Integer.valueOf(count), payload);
                return;
            }
            if (payload != null) {
                List<T> list = this.f384120e;
                ArrayList<T> arrayList = this.f384121f;
                a<T, V> aVar = this.f384122h;
                if (payload instanceof Pair) {
                    Pair pair = (Pair) payload;
                    if ((pair.getFirst() instanceof Integer) && (pair.getSecond() instanceof Integer)) {
                        Object second = pair.getSecond();
                        Intrinsics.checkNotNull(second, "null cannot be cast to non-null type kotlin.Int");
                        int intValue = ((Integer) second).intValue();
                        Object first = pair.getFirst();
                        Intrinsics.checkNotNull(first, "null cannot be cast to non-null type kotlin.Int");
                        int intValue2 = ((Integer) first).intValue();
                        if (intValue >= 0 && intValue < list.size() && intValue2 >= 0 && intValue2 < arrayList.size()) {
                            aVar.m(list.get(intValue), arrayList.get(intValue2));
                        }
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int position, int count) {
            Iterable withIndex;
            T t16;
            int i3;
            int i16;
            IntRange until;
            int collectionSizeOrDefault;
            int coerceAtMost;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), Integer.valueOf(count));
                return;
            }
            if (position == 0) {
                i16 = 0;
            } else {
                T t17 = this.f384119d.get(position - 1);
                withIndex = CollectionsKt___CollectionsKt.withIndex(this.f384120e);
                a<T, V> aVar = this.f384122h;
                Iterator<T> it = withIndex.iterator();
                while (true) {
                    if (it.hasNext()) {
                        t16 = it.next();
                        if (aVar.l(((IndexedValue) t16).getValue(), t17)) {
                            break;
                        }
                    } else {
                        t16 = (T) null;
                        break;
                    }
                }
                IndexedValue indexedValue = t16;
                if (indexedValue != null) {
                    i3 = indexedValue.getIndex();
                } else {
                    i3 = -1;
                }
                i16 = i3 + 1;
            }
            until = RangesKt___RangesKt.until(0, count);
            List<T> list = this.f384120e;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<Integer> it5 = until.iterator();
            while (it5.hasNext()) {
                arrayList.add(list.get(((IntIterator) it5).nextInt() + i16));
            }
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i16, this.f384121f.size());
            this.f384121f.addAll(coerceAtMost, arrayList);
            this.f384122h.n(arrayList);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int fromPosition, int toPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(fromPosition), Integer.valueOf(toPosition));
            } else if (fromPosition >= 0 && fromPosition < this.f384119d.size()) {
                this.f384122h.o(this.f384119d.get(fromPosition), fromPosition, toPosition);
            }
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int position, int count) {
            IntRange until;
            int collectionSizeOrDefault;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), Integer.valueOf(count));
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<T> arrayList2 = this.f384121f;
            until = RangesKt___RangesKt.until(0, count);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt() + position;
                if (nextInt < arrayList2.size()) {
                    arrayList.add(arrayList2.get(nextInt));
                }
                arrayList3.add(Unit.INSTANCE);
            }
            this.f384122h.p(arrayList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/videocut/render/a$c", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "", "getChangePayload", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes27.dex */
    public static final class c extends DiffUtil.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<T> f384123a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<T> f384124b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a<T, V> f384125c;

        /* JADX WARN: Multi-variable type inference failed */
        c(List<? extends T> list, List<? extends T> list2, a<T, V> aVar) {
            this.f384123a = list;
            this.f384124b = list2;
            this.f384125c = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, list, list2, aVar);
            }
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition))).booleanValue();
            }
            return this.f384125c.k(this.f384123a.get(oldItemPosition), this.f384124b.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition))).booleanValue();
            }
            return this.f384125c.l(this.f384123a.get(oldItemPosition), this.f384124b.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        @NotNull
        public Object getChangePayload(int oldItemPosition, int newItemPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return iPatchRedirector.redirect((short) 6, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition));
            }
            return new Pair(Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f384124b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f384123a.size();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59547);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        List<? extends T> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.currentList = emptyList;
            this.entitys = new LinkedHashMap();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void r(List<? extends T> newList, List<? extends T> oldList) {
        if (Intrinsics.areEqual(newList, oldList)) {
            return;
        }
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new c(oldList, newList, this), e());
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(callback, detectMoves())");
        calculateDiff.dispatchUpdatesTo(new b(oldList, newList, new ArrayList(oldList), this));
    }

    @Override // com.tencent.videocut.render.m
    public void c(@NotNull Map<Integer, Entity> entityMap) {
        Entity entity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) entityMap);
            return;
        }
        Intrinsics.checkNotNullParameter(entityMap, "entityMap");
        for (Map.Entry<String, Entity> entry : this.entitys.entrySet()) {
            String key = entry.getKey();
            Entity value = entry.getValue();
            if (entityMap.containsKey(Integer.valueOf(value.getId())) && (entity = entityMap.get(Integer.valueOf(value.getId()))) != null) {
                this.entitys.put(key, entity);
            }
        }
    }

    @Override // com.tencent.videocut.render.i
    public void d(@NotNull MediaModel mediaModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) mediaModel);
        } else {
            Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
            u(mediaModel);
        }
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<T> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.currentList;
    }

    @Nullable
    public Entity g(@NotNull String modelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Entity) iPatchRedirector.redirect((short) 16, (Object) this, (Object) modelId);
        }
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        return this.entitys.get(modelId);
    }

    @Nullable
    public Integer h(@NotNull String modelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) modelId);
        }
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Entity entity = this.entitys.get(modelId);
        if (entity != null) {
            return Integer.valueOf(entity.getId());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Map<String, Entity> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.entitys;
    }

    @NotNull
    public abstract String j(T model);

    public boolean k(T newModel, T oldModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) newModel, (Object) oldModel)).booleanValue();
        }
        return Intrinsics.areEqual(newModel, oldModel);
    }

    public boolean l(T newModel, T oldModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) newModel, (Object) oldModel)).booleanValue();
        }
        return Intrinsics.areEqual(j(newModel), j(oldModel));
    }

    public void m(T newItem, T oldItem) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) newItem, (Object) oldItem);
            return;
        }
        String j3 = j(newItem);
        Entity entity = this.entitys.get(j3);
        if (entity != null) {
            a(entity, oldItem, newItem);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            w53.b.c("AbsListRender", "error no entity found: id = " + j3 + ", entities = " + this.entitys);
        }
    }

    protected final void n(@NotNull List<? extends T> items) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) items);
            return;
        }
        Intrinsics.checkNotNullParameter(items, "items");
        for (T t16 : items) {
            Entity b16 = b(q(t16));
            if (b16 != null) {
                this.entitys.put(j(t16), b16);
            }
        }
    }

    public void o(T item, int from, int to5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, item, Integer.valueOf(from), Integer.valueOf(to5));
        }
    }

    protected void p(@NotNull List<? extends T> items) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) items);
            return;
        }
        Intrinsics.checkNotNullParameter(items, "items");
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            String j3 = j(it.next());
            Entity entity = this.entitys.get(j3);
            if (entity != null) {
                removeEntity(entity);
            }
            this.entitys.remove(j3);
        }
    }

    public abstract V q(T model);

    @NotNull
    public abstract List<T> s(@NotNull MediaModel model);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t(@NotNull List<? extends T> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.currentList = list;
        }
    }

    public final void u(@NotNull MediaModel mediaModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) mediaModel);
            return;
        }
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        List<? extends T> s16 = s(mediaModel);
        r(s16, this.currentList);
        this.currentList = s16;
    }
}
