package com.tencent.mobileqq.search.searchdetail.content.viewmodel;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00130\tj\b\u0012\u0004\u0012\u00020\u0013`\u000b\u0012\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00170\tj\b\u0012\u0004\u0012\u00020\u0017`\u000b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R2\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R2\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00130\tj\b\u0012\u0004\u0012\u00020\u0013`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R2\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00170\tj\b\u0012\u0004\u0012\u00020\u0017`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\f\u0010\u000f\"\u0004\b\u0018\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/m;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "setSortRules", "(Ljava/util/ArrayList;)V", "sortRules", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/n;", "c", "setTags", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/f;", "setPlaces", "places", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.viewmodel.b, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class ConditionInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ArrayList<SortRule> sortRules;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ArrayList<TroopLabel> tags;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ArrayList<Province> places;

    public ConditionInfo(@NotNull ArrayList<SortRule> sortRules, @NotNull ArrayList<TroopLabel> tags, @NotNull ArrayList<Province> places) {
        Intrinsics.checkNotNullParameter(sortRules, "sortRules");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(places, "places");
        this.sortRules = sortRules;
        this.tags = tags;
        this.places = places;
    }

    @NotNull
    public final ArrayList<Province> a() {
        return this.places;
    }

    @NotNull
    public final ArrayList<SortRule> b() {
        return this.sortRules;
    }

    @NotNull
    public final ArrayList<TroopLabel> c() {
        return this.tags;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConditionInfo)) {
            return false;
        }
        ConditionInfo conditionInfo = (ConditionInfo) other;
        if (Intrinsics.areEqual(this.sortRules, conditionInfo.sortRules) && Intrinsics.areEqual(this.tags, conditionInfo.tags) && Intrinsics.areEqual(this.places, conditionInfo.places)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.sortRules.hashCode() * 31) + this.tags.hashCode()) * 31) + this.places.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConditionInfo(sortRules=" + this.sortRules + ", tags=" + this.tags + ", places=" + this.places + ")";
    }
}
