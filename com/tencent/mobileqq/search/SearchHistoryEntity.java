package com.tencent.mobileqq.search;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/search/x;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "id", "Ljava/lang/String;", "()Ljava/lang/String;", CommonConstant.KEY_DISPLAY_NAME, "c", "I", "()I", "type", "d", "getExtraInfo", "extraInfo", "<init>", "(JLjava/lang/String;ILjava/lang/String;)V", "qqsearch-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.x, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class SearchHistoryEntity {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String displayName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String extraInfo;

    public SearchHistoryEntity(long j3, @NotNull String displayName, int i3, @NotNull String extraInfo) {
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.id = j3;
        this.displayName = displayName;
        this.type = i3;
        this.extraInfo = extraInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: b, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchHistoryEntity)) {
            return false;
        }
        SearchHistoryEntity searchHistoryEntity = (SearchHistoryEntity) other;
        if (this.id == searchHistoryEntity.id && Intrinsics.areEqual(this.displayName, searchHistoryEntity.displayName) && this.type == searchHistoryEntity.type && Intrinsics.areEqual(this.extraInfo, searchHistoryEntity.extraInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((androidx.fragment.app.a.a(this.id) * 31) + this.displayName.hashCode()) * 31) + this.type) * 31) + this.extraInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "SearchHistoryEntity(id=" + this.id + ", displayName=" + this.displayName + ", type=" + this.type + ", extraInfo=" + this.extraInfo + ')';
    }
}
