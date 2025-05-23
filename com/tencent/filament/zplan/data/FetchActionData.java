package com.tencent.filament.zplan.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J\r\u0010\u0015\u001a\u00020\u0012H\u0000\u00a2\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\u0012H\u0000\u00a2\u0006\u0002\b\u0018J\t\u0010\u0019\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/filament/zplan/data/FetchActionData;", "", "actionId", "", "actionFacePath", "", "actionBodyPath", "(ILjava/lang/String;Ljava/lang/String;)V", "getActionBodyPath", "()Ljava/lang/String;", "getActionFacePath", "getActionId", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "isActionIdValid", "isActionIdValid$zplan_android_release", "isActionPathValid", "isActionPathValid$zplan_android_release", "toString", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class FetchActionData {

    @Nullable
    private final String actionBodyPath;

    @Nullable
    private final String actionFacePath;
    private final int actionId;

    public FetchActionData() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ FetchActionData copy$default(FetchActionData fetchActionData, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = fetchActionData.actionId;
        }
        if ((i16 & 2) != 0) {
            str = fetchActionData.actionFacePath;
        }
        if ((i16 & 4) != 0) {
            str2 = fetchActionData.actionBodyPath;
        }
        return fetchActionData.copy(i3, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getActionFacePath() {
        return this.actionFacePath;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getActionBodyPath() {
        return this.actionBodyPath;
    }

    @NotNull
    public final FetchActionData copy(int actionId, @Nullable String actionFacePath, @Nullable String actionBodyPath) {
        return new FetchActionData(actionId, actionFacePath, actionBodyPath);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FetchActionData) {
                FetchActionData fetchActionData = (FetchActionData) other;
                if (this.actionId != fetchActionData.actionId || !Intrinsics.areEqual(this.actionFacePath, fetchActionData.actionFacePath) || !Intrinsics.areEqual(this.actionBodyPath, fetchActionData.actionBodyPath)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getActionBodyPath() {
        return this.actionBodyPath;
    }

    @Nullable
    public final String getActionFacePath() {
        return this.actionFacePath;
    }

    public final int getActionId() {
        return this.actionId;
    }

    public int hashCode() {
        int i3;
        int i16 = this.actionId * 31;
        String str = this.actionFacePath;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (i16 + i3) * 31;
        String str2 = this.actionBodyPath;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        return i18 + i17;
    }

    public final boolean isActionIdValid$zplan_android_release() {
        if (this.actionId > 0) {
            return true;
        }
        return false;
    }

    public final boolean isActionPathValid$zplan_android_release() {
        boolean z16;
        boolean z17;
        String str = this.actionBodyPath;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        String str2 = this.actionFacePath;
        if (str2 != null && str2.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            return false;
        }
        return true;
    }

    @NotNull
    public String toString() {
        return "FetchActionData(actionId=" + this.actionId + ", actionFacePath=" + this.actionFacePath + ", actionBodyPath=" + this.actionBodyPath + ")";
    }

    public FetchActionData(int i3, @Nullable String str, @Nullable String str2) {
        this.actionId = i3;
        this.actionFacePath = str;
        this.actionBodyPath = str2;
    }

    public /* synthetic */ FetchActionData(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? null : str2);
    }
}
