package com.tencent.mobileqq.wink.newalbum.processor.holiday;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000e\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/processor/holiday/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getDate", "()Ljava/lang/String;", "date", "b", "festivalName", "", "c", "Ljava/util/List;", "()Ljava/util/List;", "ids", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.newalbum.processor.holiday.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class Festival {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String date;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String festivalName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> ids;

    public Festival(@NotNull String date, @NotNull String festivalName, @NotNull List<String> ids) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(festivalName, "festivalName");
        Intrinsics.checkNotNullParameter(ids, "ids");
        this.date = date;
        this.festivalName = festivalName;
        this.ids = ids;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getFestivalName() {
        return this.festivalName;
    }

    @NotNull
    public final List<String> b() {
        return this.ids;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Festival)) {
            return false;
        }
        Festival festival = (Festival) other;
        if (Intrinsics.areEqual(this.date, festival.date) && Intrinsics.areEqual(this.festivalName, festival.festivalName) && Intrinsics.areEqual(this.ids, festival.ids)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.date.hashCode() * 31) + this.festivalName.hashCode()) * 31) + this.ids.hashCode();
    }

    @NotNull
    public String toString() {
        return "Festival(date=" + this.date + ", festivalName=" + this.festivalName + ", ids=" + this.ids + ")";
    }
}
