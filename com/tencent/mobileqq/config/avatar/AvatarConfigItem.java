package com.tencent.mobileqq.config.avatar;

import com.tencent.state.square.detail.DetailMeFragmentConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R+\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/config/avatar/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getStatusId", "()I", DetailMeFragmentConfig.CURRENT_STATUS_ID, "Lcom/tencent/mobileqq/config/avatar/i;", "b", "Lcom/tencent/mobileqq/config/avatar/i;", "()Lcom/tencent/mobileqq/config/avatar/i;", "defaultData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "subConfigList", "<init>", "(ILcom/tencent/mobileqq/config/avatar/i;Ljava/util/ArrayList;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.config.avatar.b, reason: from toString */
/* loaded from: classes10.dex */
public final /* data */ class AvatarConfigItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int statusId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ConfigData defaultData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ArrayList<ConfigData> subConfigList;

    public AvatarConfigItem(int i3, @NotNull ConfigData defaultData, @Nullable ArrayList<ConfigData> arrayList) {
        Intrinsics.checkNotNullParameter(defaultData, "defaultData");
        this.statusId = i3;
        this.defaultData = defaultData;
        this.subConfigList = arrayList;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final ConfigData getDefaultData() {
        return this.defaultData;
    }

    @Nullable
    public final ArrayList<ConfigData> b() {
        return this.subConfigList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarConfigItem)) {
            return false;
        }
        AvatarConfigItem avatarConfigItem = (AvatarConfigItem) other;
        if (this.statusId == avatarConfigItem.statusId && Intrinsics.areEqual(this.defaultData, avatarConfigItem.defaultData) && Intrinsics.areEqual(this.subConfigList, avatarConfigItem.subConfigList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.statusId * 31) + this.defaultData.hashCode()) * 31;
        ArrayList<ConfigData> arrayList = this.subConfigList;
        if (arrayList == null) {
            hashCode = 0;
        } else {
            hashCode = arrayList.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "AvatarConfigItem(statusId=" + this.statusId + ", defaultData=" + this.defaultData + ", subConfigList=" + this.subConfigList + ")";
    }
}
