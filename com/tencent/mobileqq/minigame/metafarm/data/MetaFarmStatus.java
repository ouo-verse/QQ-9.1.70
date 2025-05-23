package com.tencent.mobileqq.minigame.metafarm.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/minigame/metafarm/data/MetaFarmStatus;", "Ljava/io/Serializable;", "id", "", "iconUrl", "", "desc", "(ILjava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getIconUrl", "getId", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final /* data */ class MetaFarmStatus implements Serializable {

    @Nullable
    private final String desc;

    @Nullable
    private final String iconUrl;
    private final int id;

    public MetaFarmStatus(int i3, @Nullable String str, @Nullable String str2) {
        this.id = i3;
        this.iconUrl = str;
        this.desc = str2;
    }

    public static /* synthetic */ MetaFarmStatus copy$default(MetaFarmStatus metaFarmStatus, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = metaFarmStatus.id;
        }
        if ((i16 & 2) != 0) {
            str = metaFarmStatus.iconUrl;
        }
        if ((i16 & 4) != 0) {
            str2 = metaFarmStatus.desc;
        }
        return metaFarmStatus.copy(i3, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final MetaFarmStatus copy(int id5, @Nullable String iconUrl, @Nullable String desc) {
        return new MetaFarmStatus(id5, iconUrl, desc);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaFarmStatus)) {
            return false;
        }
        MetaFarmStatus metaFarmStatus = (MetaFarmStatus) other;
        if (this.id == metaFarmStatus.id && Intrinsics.areEqual(this.iconUrl, metaFarmStatus.iconUrl) && Intrinsics.areEqual(this.desc, metaFarmStatus.desc)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.id * 31;
        String str = this.iconUrl;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        String str2 = this.desc;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "MetaFarmStatus(id=" + this.id + ", iconUrl=" + this.iconUrl + ", desc=" + this.desc + ')';
    }

    public /* synthetic */ MetaFarmStatus(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? null : str2);
    }
}
