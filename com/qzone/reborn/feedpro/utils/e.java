package com.qzone.reborn.feedpro.utils;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/e;", "", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedList", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f54320a = new e();

    e() {
    }

    public final void a(List<CommonFeed> feedList) {
        Iterable withIndex;
        List reversed;
        int i3;
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        withIndex = CollectionsKt___CollectionsKt.withIndex(feedList);
        reversed = CollectionsKt___CollectionsKt.reversed(withIndex);
        Iterator it = reversed.iterator();
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            IndexedValue indexedValue = (IndexedValue) it.next();
            i3 = indexedValue.getIndex();
            if (CommonFeedExtKt.isAdFeed((CommonFeed) indexedValue.component2())) {
                break;
            }
        }
        if (i3 != -1) {
            pz2.b.f428093a.g(i3 - feedList.size());
        }
    }
}
