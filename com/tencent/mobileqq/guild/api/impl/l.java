package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.FeedListSectionType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0082\u0002\u001a!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0082\u0002\u00a8\u0006\u0005"}, d2 = {"", "Lcom/tencent/mobileqq/guild/api/FeedListSectionType;", "sectionType", "c", "d", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class l {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List<FeedListSectionType> c(List<FeedListSectionType> list, FeedListSectionType feedListSectionType) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        list.remove(feedListSectionType);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<FeedListSectionType> d(List<FeedListSectionType> list, FeedListSectionType feedListSectionType) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        list.add(feedListSectionType);
        return list;
    }
}
