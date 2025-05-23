package com.tencent.mobileqq.guild.api;

import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.section.Section;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H'J\u001c\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\n\u001a\u00020\tH&J\"\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\r2\u0006\u0010\n\u001a\u00020\tH\u0016J^\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u000f2H\u0010\u0015\u001aD\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012%\u0012#\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\r\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00028\u00000\u0010H\u0016J$\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\u0017j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002`\u0018H\u0016J5\u0010 \u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001a2#\b\u0002\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00020\u001cH\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/api/FeedListDelegateSectionFactory;", "", "", "b", "Lcom/tencent/mobileqq/guild/api/FeedListSectionType;", "sectionType", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "a", "Lcom/tencent/mobileqq/guild/api/FeedListDelegateType;", "delegateType", "", "e", "", "c", "Delegate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "sectionList", "delegateBuilder", "f", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "viewPool", "Lkotlin/Function1;", "delegate", "delegateToViewType", "", "g", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public interface FeedListDelegateSectionFactory {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class DefaultImpls {
        public static void a(@NotNull FeedListDelegateSectionFactory feedListDelegateSectionFactory, @NotNull RecyclerView.RecycledViewPool viewPool, @NotNull Function1<? super FeedListDelegateType, Integer> delegateToViewType) {
            Intrinsics.checkNotNullParameter(viewPool, "viewPool");
            Intrinsics.checkNotNullParameter(delegateToViewType, "delegateToViewType");
            for (Map.Entry<FeedListDelegateType, Integer> entry : feedListDelegateSectionFactory.d().entrySet()) {
                FeedListDelegateType key = entry.getKey();
                viewPool.setMaxRecycledViews(delegateToViewType.invoke(key).intValue(), entry.getValue().intValue());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(FeedListDelegateSectionFactory feedListDelegateSectionFactory, RecyclerView.RecycledViewPool recycledViewPool, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    function1 = new Function1<FeedListDelegateType, Integer>() { // from class: com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory$addFeedListViewTypeConfig$1
                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Integer invoke(@NotNull FeedListDelegateType it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return Integer.valueOf(it.getLayoutType());
                        }
                    };
                }
                feedListDelegateSectionFactory.g(recycledViewPool, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addFeedListViewTypeConfig");
        }

        @NotNull
        public static <Delegate> List<Delegate> c(@NotNull FeedListDelegateSectionFactory feedListDelegateSectionFactory, @NotNull Function2<? super FeedListDelegateType, ? super List<? extends Class<? extends Section<?>>>, ? extends Delegate> delegateBuilder) {
            Intrinsics.checkNotNullParameter(delegateBuilder, "delegateBuilder");
            FeedListDelegateType[] values = FeedListDelegateType.values();
            ArrayList arrayList = new ArrayList(values.length);
            for (FeedListDelegateType feedListDelegateType : values) {
                arrayList.add(delegateBuilder.invoke(feedListDelegateType, feedListDelegateSectionFactory.c(feedListDelegateType)));
            }
            return arrayList;
        }

        @NotNull
        public static List<Class<? extends Section<?>>> d(@NotNull FeedListDelegateSectionFactory feedListDelegateSectionFactory, @NotNull FeedListDelegateType delegateType) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(delegateType, "delegateType");
            List<FeedListSectionType> e16 = feedListDelegateSectionFactory.e(delegateType);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(e16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = e16.iterator();
            while (it.hasNext()) {
                arrayList.add(feedListDelegateSectionFactory.a((FeedListSectionType) it.next()));
            }
            return arrayList;
        }

        @NotNull
        public static HashMap<FeedListDelegateType, Integer> e(@NotNull FeedListDelegateSectionFactory feedListDelegateSectionFactory) {
            HashMap<FeedListDelegateType, Integer> hashMapOf;
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(FeedListDelegateType.PlainText, 8), TuplesKt.to(FeedListDelegateType.SimpleFeed, 8), TuplesKt.to(FeedListDelegateType.LongFeed, 2), TuplesKt.to(FeedListDelegateType.SingleImage, 5), TuplesKt.to(FeedListDelegateType.SingleVideo, 5), TuplesKt.to(FeedListDelegateType.ThirdVideo, 1), TuplesKt.to(FeedListDelegateType.SmallWorldVideo, 1), TuplesKt.to(FeedListDelegateType.ThirdPartyShareLink, 2));
            return hashMapOf;
        }
    }

    @NotNull
    Class<? extends Section<?>> a(@NotNull FeedListSectionType sectionType);

    @LayoutRes
    int b();

    @NotNull
    List<Class<? extends Section<?>>> c(@NotNull FeedListDelegateType delegateType);

    @NotNull
    HashMap<FeedListDelegateType, Integer> d();

    @NotNull
    List<FeedListSectionType> e(@NotNull FeedListDelegateType delegateType);

    @NotNull
    <Delegate> List<Delegate> f(@NotNull Function2<? super FeedListDelegateType, ? super List<? extends Class<? extends Section<?>>>, ? extends Delegate> delegateBuilder);

    void g(@NotNull RecyclerView.RecycledViewPool viewPool, @NotNull Function1<? super FeedListDelegateType, Integer> delegateToViewType);
}
