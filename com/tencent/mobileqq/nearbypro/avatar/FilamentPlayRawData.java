package com.tencent.mobileqq.nearbypro.avatar;

import com.tencent.state.square.avatar.filament.MoodConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/avatar/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "a", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "c", "()Lcom/tencent/state/square/avatar/filament/MoodConfig;", "moodConfig", "Lorg/json/JSONObject;", "b", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "hostAvatarInfo", "guestAvatarInfo", "<init>", "(Lcom/tencent/state/square/avatar/filament/MoodConfig;Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.avatar.d, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class FilamentPlayRawData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MoodConfig moodConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final JSONObject hostAvatarInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final JSONObject guestAvatarInfo;

    public FilamentPlayRawData(@NotNull MoodConfig moodConfig, @NotNull JSONObject hostAvatarInfo, @Nullable JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(moodConfig, "moodConfig");
        Intrinsics.checkNotNullParameter(hostAvatarInfo, "hostAvatarInfo");
        this.moodConfig = moodConfig;
        this.hostAvatarInfo = hostAvatarInfo;
        this.guestAvatarInfo = jSONObject;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final JSONObject getGuestAvatarInfo() {
        return this.guestAvatarInfo;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final JSONObject getHostAvatarInfo() {
        return this.hostAvatarInfo;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final MoodConfig getMoodConfig() {
        return this.moodConfig;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilamentPlayRawData)) {
            return false;
        }
        FilamentPlayRawData filamentPlayRawData = (FilamentPlayRawData) other;
        if (Intrinsics.areEqual(this.moodConfig, filamentPlayRawData.moodConfig) && Intrinsics.areEqual(this.hostAvatarInfo, filamentPlayRawData.hostAvatarInfo) && Intrinsics.areEqual(this.guestAvatarInfo, filamentPlayRawData.guestAvatarInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.moodConfig.hashCode() * 31) + this.hostAvatarInfo.hashCode()) * 31;
        JSONObject jSONObject = this.guestAvatarInfo;
        if (jSONObject == null) {
            hashCode = 0;
        } else {
            hashCode = jSONObject.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "FilamentPlayRawData(moodConfig=" + this.moodConfig + ", hostAvatarInfo=" + this.hostAvatarInfo + ", guestAvatarInfo=" + this.guestAvatarInfo + ")";
    }
}
