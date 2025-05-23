package com.tencent.mobileqq.wink.h5native;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J!\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishTeamInfo", "", "", "component1", "component2", "id", "activity_id", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishTeamInfo;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getActivity_id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$PublishTeamInfo, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class PublishTeamInfo {

    @Nullable
    private final String activity_id;

    @Nullable
    private final String id;

    public PublishTeamInfo(@Nullable String str, @Nullable String str2) {
        this.id = str;
        this.activity_id = str2;
    }

    public static /* synthetic */ PublishTeamInfo copy$default(PublishTeamInfo publishTeamInfo, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = publishTeamInfo.id;
        }
        if ((i3 & 2) != 0) {
            str2 = publishTeamInfo.activity_id;
        }
        return publishTeamInfo.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getActivity_id() {
        return this.activity_id;
    }

    @NotNull
    public final PublishTeamInfo copy(@Nullable String id5, @Nullable String activity_id) {
        return new PublishTeamInfo(id5, activity_id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublishTeamInfo)) {
            return false;
        }
        PublishTeamInfo publishTeamInfo = (PublishTeamInfo) other;
        if (Intrinsics.areEqual(this.id, publishTeamInfo.id) && Intrinsics.areEqual(this.activity_id, publishTeamInfo.activity_id)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getActivity_id() {
        return this.activity_id;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        int hashCode;
        String str = this.id;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.activity_id;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "PublishTeamInfo(id=" + this.id + ", activity_id=" + this.activity_id + ")";
    }
}
