package com.tencent.mobileqq.guild.feed.feedsquare.part.remake;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a@\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006*$\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0001`\u0003\u001a2\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0001*$\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0001`\u0003\u00a8\u0006\n"}, d2 = {"Ldo1/a;", "", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/IFeedCollectionViewState;", "Ljava/util/ArrayList;", "Lij1/g;", "Lkotlin/collections/ArrayList;", "a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "b", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {
    @Nullable
    public static final ArrayList<ij1.g> a(@NotNull do1.a<? extends List<?>, Boolean> aVar) {
        int i3;
        com.tencent.mobileqq.guild.feed.feedsquare.data.h hVar;
        ij1.g gVar;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        List<?> a16 = aVar.a();
        if (a16 == null) {
            return null;
        }
        List<?> list = a16;
        List<?> a17 = aVar.a();
        if (a17 != null) {
            i3 = a17.size();
        } else {
            i3 = 0;
        }
        ArrayList<ij1.g> arrayList = new ArrayList<>(i3);
        for (Object obj : list) {
            if (obj instanceof com.tencent.mobileqq.guild.feed.feedsquare.data.h) {
                hVar = (com.tencent.mobileqq.guild.feed.feedsquare.data.h) obj;
            } else {
                hVar = null;
            }
            if (hVar != null) {
                gVar = hVar.getBlockData();
            } else {
                gVar = null;
            }
            if (gVar != null) {
                arrayList.add(gVar);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> b(@NotNull do1.a<? extends List<?>, Boolean> aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Collection a16 = aVar.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedItemData>");
        return (List) a16;
    }
}
