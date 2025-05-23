package com.tencent.mobileqq.zplan.aigc.data;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R6\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\f\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/zplan/aigc/data/b;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "d", "(Ljava/util/ArrayList;)V", "list", "Ljava/lang/String;", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "eTag", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aigc.data.g, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class FeedListCache {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private ArrayList<b> list;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String eTag;

    public FeedListCache() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final String getETag() {
        return this.eTag;
    }

    public final ArrayList<b> b() {
        return this.list;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eTag = str;
    }

    public final void d(ArrayList<b> arrayList) {
        this.list = arrayList;
    }

    public int hashCode() {
        ArrayList<b> arrayList = this.list;
        return ((arrayList == null ? 0 : arrayList.hashCode()) * 31) + this.eTag.hashCode();
    }

    public String toString() {
        return "FeedListCache(list=" + this.list + ", eTag=" + this.eTag + ")";
    }

    public FeedListCache(ArrayList<b> arrayList, String eTag) {
        Intrinsics.checkNotNullParameter(eTag, "eTag");
        this.list = arrayList;
        this.eTag = eTag;
    }

    public /* synthetic */ FeedListCache(ArrayList arrayList, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : arrayList, (i3 & 2) != 0 ? "" : str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedListCache)) {
            return false;
        }
        FeedListCache feedListCache = (FeedListCache) other;
        return Intrinsics.areEqual(this.list, feedListCache.list) && Intrinsics.areEqual(this.eTag, feedListCache.eTag);
    }
}
