package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/data/FilamentCoverResource;", "", "coverUrl", "", "recordDressKeys", "Lcom/tencent/state/square/data/DressKeys;", "actionMd5", "(Ljava/lang/String;Lcom/tencent/state/square/data/DressKeys;Ljava/lang/String;)V", "getActionMd5", "()Ljava/lang/String;", "getCoverUrl", "getRecordDressKeys", "()Lcom/tencent/state/square/data/DressKeys;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class FilamentCoverResource {

    @NotNull
    private final String actionMd5;

    @NotNull
    private final String coverUrl;

    @NotNull
    private final DressKeys recordDressKeys;

    public FilamentCoverResource(@NotNull String coverUrl, @NotNull DressKeys recordDressKeys, @NotNull String actionMd5) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(recordDressKeys, "recordDressKeys");
        Intrinsics.checkNotNullParameter(actionMd5, "actionMd5");
        this.coverUrl = coverUrl;
        this.recordDressKeys = recordDressKeys;
        this.actionMd5 = actionMd5;
    }

    public static /* synthetic */ FilamentCoverResource copy$default(FilamentCoverResource filamentCoverResource, String str, DressKeys dressKeys, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = filamentCoverResource.coverUrl;
        }
        if ((i3 & 2) != 0) {
            dressKeys = filamentCoverResource.recordDressKeys;
        }
        if ((i3 & 4) != 0) {
            str2 = filamentCoverResource.actionMd5;
        }
        return filamentCoverResource.copy(str, dressKeys, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final DressKeys getRecordDressKeys() {
        return this.recordDressKeys;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getActionMd5() {
        return this.actionMd5;
    }

    @NotNull
    public final FilamentCoverResource copy(@NotNull String coverUrl, @NotNull DressKeys recordDressKeys, @NotNull String actionMd5) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(recordDressKeys, "recordDressKeys");
        Intrinsics.checkNotNullParameter(actionMd5, "actionMd5");
        return new FilamentCoverResource(coverUrl, recordDressKeys, actionMd5);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FilamentCoverResource) {
                FilamentCoverResource filamentCoverResource = (FilamentCoverResource) other;
                if (!Intrinsics.areEqual(this.coverUrl, filamentCoverResource.coverUrl) || !Intrinsics.areEqual(this.recordDressKeys, filamentCoverResource.recordDressKeys) || !Intrinsics.areEqual(this.actionMd5, filamentCoverResource.actionMd5)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getActionMd5() {
        return this.actionMd5;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    public final DressKeys getRecordDressKeys() {
        return this.recordDressKeys;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.coverUrl;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        DressKeys dressKeys = this.recordDressKeys;
        if (dressKeys != null) {
            i16 = dressKeys.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str2 = this.actionMd5;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "FilamentCoverResource(coverUrl='" + this.coverUrl + "', recordDressKeys=" + this.recordDressKeys + ", actionMd5='" + this.actionMd5 + "')";
    }
}
