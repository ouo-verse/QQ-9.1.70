package com.tencent.state.square.avatar.filament;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/square/avatar/filament/FilamentPlayRawData;", "", "moodConfig", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "hostAvatarInfo", "Lorg/json/JSONObject;", "guestAvatarInfo", "(Lcom/tencent/state/square/avatar/filament/MoodConfig;Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "getGuestAvatarInfo", "()Lorg/json/JSONObject;", "getHostAvatarInfo", "getMoodConfig", "()Lcom/tencent/state/square/avatar/filament/MoodConfig;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
final /* data */ class FilamentPlayRawData {
    private final JSONObject guestAvatarInfo;
    private final JSONObject hostAvatarInfo;
    private final MoodConfig moodConfig;

    public FilamentPlayRawData(MoodConfig moodConfig, JSONObject hostAvatarInfo, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(moodConfig, "moodConfig");
        Intrinsics.checkNotNullParameter(hostAvatarInfo, "hostAvatarInfo");
        this.moodConfig = moodConfig;
        this.hostAvatarInfo = hostAvatarInfo;
        this.guestAvatarInfo = jSONObject;
    }

    /* renamed from: component1, reason: from getter */
    public final MoodConfig getMoodConfig() {
        return this.moodConfig;
    }

    /* renamed from: component2, reason: from getter */
    public final JSONObject getHostAvatarInfo() {
        return this.hostAvatarInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final JSONObject getGuestAvatarInfo() {
        return this.guestAvatarInfo;
    }

    public final FilamentPlayRawData copy(MoodConfig moodConfig, JSONObject hostAvatarInfo, JSONObject guestAvatarInfo) {
        Intrinsics.checkNotNullParameter(moodConfig, "moodConfig");
        Intrinsics.checkNotNullParameter(hostAvatarInfo, "hostAvatarInfo");
        return new FilamentPlayRawData(moodConfig, hostAvatarInfo, guestAvatarInfo);
    }

    public final JSONObject getGuestAvatarInfo() {
        return this.guestAvatarInfo;
    }

    public final JSONObject getHostAvatarInfo() {
        return this.hostAvatarInfo;
    }

    public final MoodConfig getMoodConfig() {
        return this.moodConfig;
    }

    public int hashCode() {
        MoodConfig moodConfig = this.moodConfig;
        int hashCode = (moodConfig != null ? moodConfig.hashCode() : 0) * 31;
        JSONObject jSONObject = this.hostAvatarInfo;
        int hashCode2 = (hashCode + (jSONObject != null ? jSONObject.hashCode() : 0)) * 31;
        JSONObject jSONObject2 = this.guestAvatarInfo;
        return hashCode2 + (jSONObject2 != null ? jSONObject2.hashCode() : 0);
    }

    public String toString() {
        return "FilamentPlayRawData(moodConfig=" + this.moodConfig + ", hostAvatarInfo=" + this.hostAvatarInfo + ", guestAvatarInfo=" + this.guestAvatarInfo + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilamentPlayRawData)) {
            return false;
        }
        FilamentPlayRawData filamentPlayRawData = (FilamentPlayRawData) other;
        return Intrinsics.areEqual(this.moodConfig, filamentPlayRawData.moodConfig) && Intrinsics.areEqual(this.hostAvatarInfo, filamentPlayRawData.hostAvatarInfo) && Intrinsics.areEqual(this.guestAvatarInfo, filamentPlayRawData.guestAvatarInfo);
    }

    public static /* synthetic */ FilamentPlayRawData copy$default(FilamentPlayRawData filamentPlayRawData, MoodConfig moodConfig, JSONObject jSONObject, JSONObject jSONObject2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            moodConfig = filamentPlayRawData.moodConfig;
        }
        if ((i3 & 2) != 0) {
            jSONObject = filamentPlayRawData.hostAvatarInfo;
        }
        if ((i3 & 4) != 0) {
            jSONObject2 = filamentPlayRawData.guestAvatarInfo;
        }
        return filamentPlayRawData.copy(moodConfig, jSONObject, jSONObject2);
    }
}
