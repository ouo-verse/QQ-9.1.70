package com.tencent.mobileqq.guild.setting.group;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\r\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "errorCode", "b", "Ljava/lang/String;", "getErrMsg", "()Ljava/lang/String;", "errMsg", "", "Lcom/tencent/mobileqq/guild/setting/group/GroupType;", "Lcom/tencent/mobileqq/guild/setting/group/f;", "c", "Ljava/util/Map;", "()Ljava/util/Map;", "groupTypeToGroupsMap", "<init>", "(ILjava/lang/String;Ljava/util/Map;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.group.g, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class BindableGroupsResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errorCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Map<GroupType, f> groupTypeToGroupsMap;

    public BindableGroupsResult(int i3, @NotNull String errMsg, @NotNull Map<GroupType, f> groupTypeToGroupsMap) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(groupTypeToGroupsMap, "groupTypeToGroupsMap");
        this.errorCode = i3;
        this.errMsg = errMsg;
        this.groupTypeToGroupsMap = groupTypeToGroupsMap;
    }

    /* renamed from: a, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final Map<GroupType, f> b() {
        return this.groupTypeToGroupsMap;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindableGroupsResult)) {
            return false;
        }
        BindableGroupsResult bindableGroupsResult = (BindableGroupsResult) other;
        if (this.errorCode == bindableGroupsResult.errorCode && Intrinsics.areEqual(this.errMsg, bindableGroupsResult.errMsg) && Intrinsics.areEqual(this.groupTypeToGroupsMap, bindableGroupsResult.groupTypeToGroupsMap)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.errorCode * 31) + this.errMsg.hashCode()) * 31) + this.groupTypeToGroupsMap.hashCode();
    }

    @NotNull
    public String toString() {
        return "BindableGroupsResult(errorCode=" + this.errorCode + ", errMsg=" + this.errMsg + ", groupTypeToGroupsMap=" + this.groupTypeToGroupsMap + ")";
    }

    public /* synthetic */ BindableGroupsResult(int i3, String str, Map map, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i16 & 4) != 0 ? MapsKt__MapsKt.emptyMap() : map);
    }
}
