package com.tencent.mobileqq.guild.live.danmu.dispatch;

import com.tencent.mobileqq.guild.live.danmu.item.GLiveDanmuPriority;
import com.tencent.mobileqq.guild.live.viewmodel.GLiveDanmuLogicVM;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u0015\u0018\u0018\u0000 #2\u00020\u0001:\u0002\r$B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\u0004\b!\u0010\"J\u001e\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004J&\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0006R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR&\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/live/danmu/dispatch/GuildLiveDanmuStore;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/live/danmu/item/a;", "Lkotlin/collections/ArrayList;", VideoTemplateParser.ITEM_LIST, "", "c", "Lcom/tencent/mobileqq/guild/live/danmu/item/GLiveDanmuPriority;", "priority", "", "pullSize", "b", "a", "Lcom/tencent/mobileqq/guild/live/viewmodel/GLiveDanmuLogicVM;", "Lcom/tencent/mobileqq/guild/live/viewmodel/GLiveDanmuLogicVM;", "logicVM", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/LinkedList;", "Ljava/util/concurrent/ConcurrentHashMap;", "priorityMsgMap", "com/tencent/mobileqq/guild/live/danmu/dispatch/GuildLiveDanmuStore$b", "Lcom/tencent/mobileqq/guild/live/danmu/dispatch/GuildLiveDanmuStore$b;", "highPriorityStrategy", "com/tencent/mobileqq/guild/live/danmu/dispatch/GuildLiveDanmuStore$c", "d", "Lcom/tencent/mobileqq/guild/live/danmu/dispatch/GuildLiveDanmuStore$c;", "normalAndLowPriorityStrategy", "", "Lcom/tencent/mobileqq/guild/live/danmu/dispatch/GuildLiveDanmuStore$IDanmuItemSaveStrategy;", "e", "Ljava/util/Map;", "priorityStrategyMap", "<init>", "(Lcom/tencent/mobileqq/guild/live/viewmodel/GLiveDanmuLogicVM;)V", "f", "IDanmuItemSaveStrategy", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLiveDanmuStore {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GLiveDanmuLogicVM logicVM;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<GLiveDanmuPriority, LinkedList<com.tencent.mobileqq.guild.live.danmu.item.a>> priorityMsgMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b highPriorityStrategy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c normalAndLowPriorityStrategy;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<GLiveDanmuPriority, IDanmuItemSaveStrategy> priorityStrategyMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J&\u0010\u000b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/live/danmu/dispatch/GuildLiveDanmuStore$IDanmuItemSaveStrategy;", "", "", "c", "Ljava/util/LinkedList;", "Lcom/tencent/mobileqq/guild/live/danmu/item/a;", "linkList", "", "b", "", "newDanmuItemList", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface IDanmuItemSaveStrategy {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes14.dex */
        public static final class DefaultImpls {

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes14.dex */
            public static final class a<T> implements Comparator {
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t16, T t17) {
                    int compareValues;
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.mobileqq.guild.live.danmu.item.a) t16).e()), Long.valueOf(((com.tencent.mobileqq.guild.live.danmu.item.a) t17).e()));
                    return compareValues;
                }
            }

            public static void a(@NotNull IDanmuItemSaveStrategy iDanmuItemSaveStrategy, @Nullable List<? extends com.tencent.mobileqq.guild.live.danmu.item.a> list, @NotNull LinkedList<com.tencent.mobileqq.guild.live.danmu.item.a> linkList) {
                boolean z16;
                List sortedWith;
                String joinToString$default;
                String joinToString$default2;
                Intrinsics.checkNotNullParameter(linkList, "linkList");
                List<? extends com.tencent.mobileqq.guild.live.danmu.item.a> list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new a());
                    if (linkList.size() > iDanmuItemSaveStrategy.c()) {
                        List list3 = sortedWith;
                        Iterator it = list3.iterator();
                        while (it.hasNext()) {
                            linkList.addFirst((com.tencent.mobileqq.guild.live.danmu.item.a) it.next());
                        }
                        Logger logger = Logger.f235387a;
                        if (QLog.isDebugVersion()) {
                            Logger.a d16 = logger.d();
                            joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(list3, null, null, null, 0, null, new Function1<com.tencent.mobileqq.guild.live.danmu.item.a, CharSequence>() { // from class: com.tencent.mobileqq.guild.live.danmu.dispatch.GuildLiveDanmuStore$IDanmuItemSaveStrategy$addItem$2$1
                                @Override // kotlin.jvm.functions.Function1
                                @NotNull
                                public final CharSequence invoke(@NotNull com.tencent.mobileqq.guild.live.danmu.item.a it5) {
                                    Intrinsics.checkNotNullParameter(it5, "it");
                                    return "viewType(" + it5.b() + "), msgSeq(" + it5.e() + ")";
                                }
                            }, 31, null);
                            d16.d("QGL.GuildLiveDanmuStore", 1, "[addItem] to head: " + joinToString$default2);
                        }
                        iDanmuItemSaveStrategy.b(linkList);
                        return;
                    }
                    List list4 = sortedWith;
                    Iterator it5 = list4.iterator();
                    while (it5.hasNext()) {
                        linkList.add((com.tencent.mobileqq.guild.live.danmu.item.a) it5.next());
                    }
                    Logger logger2 = Logger.f235387a;
                    if (QLog.isDebugVersion()) {
                        Logger.a d17 = logger2.d();
                        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list4, null, null, null, 0, null, new Function1<com.tencent.mobileqq.guild.live.danmu.item.a, CharSequence>() { // from class: com.tencent.mobileqq.guild.live.danmu.dispatch.GuildLiveDanmuStore$IDanmuItemSaveStrategy$addItem$4$1
                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final CharSequence invoke(@NotNull com.tencent.mobileqq.guild.live.danmu.item.a it6) {
                                Intrinsics.checkNotNullParameter(it6, "it");
                                return "viewType(" + it6.b() + "), msgSeq(" + it6.e() + ")";
                            }
                        }, 31, null);
                        d17.d("QGL.GuildLiveDanmuStore", 1, "[addItem] to jail: " + joinToString$default);
                    }
                }
            }
        }

        void a(@Nullable List<? extends com.tencent.mobileqq.guild.live.danmu.item.a> newDanmuItemList, @NotNull LinkedList<com.tencent.mobileqq.guild.live.danmu.item.a> linkList);

        void b(@NotNull LinkedList<com.tencent.mobileqq.guild.live.danmu.item.a> linkList);

        int c();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/live/danmu/dispatch/GuildLiveDanmuStore$b", "Lcom/tencent/mobileqq/guild/live/danmu/dispatch/GuildLiveDanmuStore$IDanmuItemSaveStrategy;", "", "c", "Ljava/util/LinkedList;", "Lcom/tencent/mobileqq/guild/live/danmu/item/a;", "linkList", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements IDanmuItemSaveStrategy {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.live.danmu.dispatch.GuildLiveDanmuStore.IDanmuItemSaveStrategy
        public void a(@Nullable List<? extends com.tencent.mobileqq.guild.live.danmu.item.a> list, @NotNull LinkedList<com.tencent.mobileqq.guild.live.danmu.item.a> linkedList) {
            IDanmuItemSaveStrategy.DefaultImpls.a(this, list, linkedList);
        }

        @Override // com.tencent.mobileqq.guild.live.danmu.dispatch.GuildLiveDanmuStore.IDanmuItemSaveStrategy
        public void b(@NotNull LinkedList<com.tencent.mobileqq.guild.live.danmu.item.a> linkList) {
            Intrinsics.checkNotNullParameter(linkList, "linkList");
        }

        @Override // com.tencent.mobileqq.guild.live.danmu.dispatch.GuildLiveDanmuStore.IDanmuItemSaveStrategy
        public int c() {
            return 75;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/live/danmu/dispatch/GuildLiveDanmuStore$c", "Lcom/tencent/mobileqq/guild/live/danmu/dispatch/GuildLiveDanmuStore$IDanmuItemSaveStrategy;", "", "c", "Ljava/util/LinkedList;", "Lcom/tencent/mobileqq/guild/live/danmu/item/a;", "linkList", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements IDanmuItemSaveStrategy {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.live.danmu.dispatch.GuildLiveDanmuStore.IDanmuItemSaveStrategy
        public void a(@Nullable List<? extends com.tencent.mobileqq.guild.live.danmu.item.a> list, @NotNull LinkedList<com.tencent.mobileqq.guild.live.danmu.item.a> linkedList) {
            IDanmuItemSaveStrategy.DefaultImpls.a(this, list, linkedList);
        }

        @Override // com.tencent.mobileqq.guild.live.danmu.dispatch.GuildLiveDanmuStore.IDanmuItemSaveStrategy
        public void b(@NotNull LinkedList<com.tencent.mobileqq.guild.live.danmu.item.a> linkList) {
            Intrinsics.checkNotNullParameter(linkList, "linkList");
            int size = linkList.size();
            ListIterator<com.tencent.mobileqq.guild.live.danmu.item.a> listIterator = linkList.listIterator();
            Intrinsics.checkNotNullExpressionValue(listIterator, "linkList.listIterator()");
            while (listIterator.hasPrevious()) {
                com.tencent.mobileqq.guild.live.danmu.item.a previous = listIterator.previous();
                Intrinsics.checkNotNullExpressionValue(previous, "iterator.previous()");
                com.tencent.mobileqq.guild.live.danmu.item.a aVar = previous;
                Logger logger = Logger.f235387a;
                if (QLog.isDebugVersion()) {
                    logger.d().d("QGL.GuildLiveDanmuStore", 1, "[trim] remove old item " + aVar.e());
                }
                listIterator.remove();
                size--;
                if (size < c()) {
                    return;
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.live.danmu.dispatch.GuildLiveDanmuStore.IDanmuItemSaveStrategy
        public int c() {
            return 75;
        }
    }

    public GuildLiveDanmuStore(@NotNull GLiveDanmuLogicVM logicVM) {
        Map<GLiveDanmuPriority, IDanmuItemSaveStrategy> mapOf;
        Intrinsics.checkNotNullParameter(logicVM, "logicVM");
        this.logicVM = logicVM;
        this.priorityMsgMap = new ConcurrentHashMap<>();
        b bVar = new b();
        this.highPriorityStrategy = bVar;
        c cVar = new c();
        this.normalAndLowPriorityStrategy = cVar;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(GLiveDanmuPriority.HIGH, bVar), TuplesKt.to(GLiveDanmuPriority.NORMAL, cVar), TuplesKt.to(GLiveDanmuPriority.LOW, cVar));
        this.priorityStrategyMap = mapOf;
    }

    public final void a() {
        Logger.f235387a.d().d("QGL.GuildLiveDanmuStore", 1, "[destroy] ");
        this.priorityMsgMap.clear();
    }

    @NotNull
    public final ArrayList<com.tencent.mobileqq.guild.live.danmu.item.a> b(@NotNull GLiveDanmuPriority priority, int pullSize) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        ArrayList<com.tencent.mobileqq.guild.live.danmu.item.a> arrayList = new ArrayList<>();
        if (pullSize <= 0) {
            return arrayList;
        }
        LinkedList<com.tencent.mobileqq.guild.live.danmu.item.a> linkedList = this.priorityMsgMap.get(priority);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        if (linkedList.isEmpty()) {
            return arrayList;
        }
        Iterator<com.tencent.mobileqq.guild.live.danmu.item.a> it = linkedList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "linkList.iterator()");
        while (it.hasNext()) {
            arrayList.add(it.next());
            it.remove();
            if (arrayList.size() == pullSize) {
                break;
            }
        }
        return arrayList;
    }

    public final void c(@NotNull ArrayList<com.tencent.mobileqq.guild.live.danmu.item.a> itemList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        for (Map.Entry<GLiveDanmuPriority, IDanmuItemSaveStrategy> entry : this.priorityStrategyMap.entrySet()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : itemList) {
                if (((com.tencent.mobileqq.guild.live.danmu.item.a) obj).getPriority() == entry.getKey()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
            LinkedList<com.tencent.mobileqq.guild.live.danmu.item.a> linkedList = this.priorityMsgMap.get(entry.getKey());
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
            Intrinsics.checkNotNullExpressionValue(linkedList, "priorityMsgMap[mapEntry.\u2026GuildLiveBaseDanmuItem>()");
            entry.getValue().a(arrayList, linkedList);
            this.priorityMsgMap.put(entry.getKey(), linkedList);
        }
    }
}
