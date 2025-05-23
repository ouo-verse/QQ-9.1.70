package com.tencent.mobileqq.guild.setting.group;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\t\u0010\fR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0018R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "errorCode", "Ljava/lang/String;", "getErrMsg", "()Ljava/lang/String;", "errMsg", "c", "bindGroupLimit", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindingGroup;", "d", "Ljava/util/List;", "()Ljava/util/List;", "groups", "", "", "e", "remainGroupCodes", "<init>", "(ILjava/lang/String;ILjava/util/List;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int errorCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String errMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int bindGroupLimit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<IGProBindingGroup> groups;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Long> remainGroupCodes;

    public h(int i3, @NotNull String errMsg, int i16, @NotNull List<IGProBindingGroup> groups, @NotNull List<Long> remainGroupCodes) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(groups, "groups");
        Intrinsics.checkNotNullParameter(remainGroupCodes, "remainGroupCodes");
        this.errorCode = i3;
        this.errMsg = errMsg;
        this.bindGroupLimit = i16;
        this.groups = groups;
        this.remainGroupCodes = remainGroupCodes;
    }

    /* renamed from: a, reason: from getter */
    public final int getBindGroupLimit() {
        return this.bindGroupLimit;
    }

    /* renamed from: b, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final List<IGProBindingGroup> c() {
        return this.groups;
    }

    @NotNull
    public final List<Long> d() {
        return this.remainGroupCodes;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof h)) {
            return false;
        }
        h hVar = (h) other;
        if (this.errorCode == hVar.errorCode && Intrinsics.areEqual(this.errMsg, hVar.errMsg) && this.bindGroupLimit == hVar.bindGroupLimit && Intrinsics.areEqual(this.groups, hVar.groups) && Intrinsics.areEqual(this.remainGroupCodes, hVar.remainGroupCodes)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.errorCode * 31) + this.errMsg.hashCode()) * 31) + this.bindGroupLimit) * 31) + this.groups.hashCode()) * 31) + this.remainGroupCodes.hashCode();
    }

    @NotNull
    public String toString() {
        int collectionSizeOrDefault;
        int i3 = this.errorCode;
        String str = this.errMsg;
        int i16 = this.bindGroupLimit;
        List<IGProBindingGroup> list = this.groups;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (IGProBindingGroup iGProBindingGroup : list) {
            arrayList.add(iGProBindingGroup.getGroupCode() + "-" + iGProBindingGroup.getGroupFlag());
        }
        return "BoundGroupsResult(errorCode=" + i3 + ", errMsg='" + str + "', bindGroupLimit=" + i16 + ", groups=" + arrayList + ", remainGroupCodes=" + this.remainGroupCodes + ")";
    }

    public /* synthetic */ h(int i3, String str, int i16, List list, List list2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i17 & 4) != 0 ? 0 : i16, (i17 & 8) != 0 ? new ArrayList() : list, (i17 & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
    }
}
