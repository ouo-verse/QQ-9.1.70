package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ \u0010\u0006\u001a\u00020\u0005*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/FeedSquareViewModeUtils;", "", "", "Lij1/g;", "newFeeds", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedSquareViewModeUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FeedSquareViewModeUtils f219276a = new FeedSquareViewModeUtils();

    FeedSquareViewModeUtils() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003d, code lost:
    
        if (r6 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@Nullable List<ij1.g> list, @NotNull List<ij1.g> newFeeds) {
        final Set emptySet;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(newFeeds, "newFeeds");
        int size = newFeeds.size();
        long currentTimeMillis = System.currentTimeMillis();
        if (list != null) {
            List<ij1.g> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((ij1.g) it.next()).b().idd);
            }
            emptySet = CollectionsKt___CollectionsKt.toHashSet(arrayList);
        }
        emptySet = SetsKt__SetsKt.emptySet();
        CollectionsKt__MutableCollectionsKt.removeAll((List) newFeeds, (Function1) new Function1<ij1.g, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.FeedSquareViewModeUtils$deduplicateFeeds$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull ij1.g it5) {
                Intrinsics.checkNotNullParameter(it5, "it");
                return Boolean.valueOf(emptySet.contains(it5.b().idd));
            }
        });
        QLog.d("FeedSquareViewModeUtils", 1, "[FeedsLoad] [dedup] removed " + (size - newFeeds.size()) + " duplicated feeds, takes " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }
}
