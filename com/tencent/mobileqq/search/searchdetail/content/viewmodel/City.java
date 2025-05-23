package com.tencent.mobileqq.search.searchdetail.content.viewmodel;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0010\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "text", "", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/d;", "b", "Ljava/util/List;", "()Ljava/util/List;", "districtList", "I", "()I", "id", "<init>", "(Ljava/lang/String;Ljava/util/List;I)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.viewmodel.a, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class City {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<District> districtList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    public City(@NotNull String text, @NotNull List<District> districtList, int i3) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(districtList, "districtList");
        this.text = text;
        this.districtList = districtList;
        this.id = i3;
    }

    @NotNull
    public final List<District> a() {
        return this.districtList;
    }

    /* renamed from: b, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof City)) {
            return false;
        }
        City city = (City) other;
        if (Intrinsics.areEqual(this.text, city.text) && Intrinsics.areEqual(this.districtList, city.districtList) && this.id == city.id) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + this.districtList.hashCode()) * 31) + this.id;
    }

    @NotNull
    public String toString() {
        return "City(text=" + this.text + ", districtList=" + this.districtList + ", id=" + this.id + ")";
    }

    public /* synthetic */ City(String str, List list, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i16 & 4) != 0 ? 0 : i3);
    }
}
