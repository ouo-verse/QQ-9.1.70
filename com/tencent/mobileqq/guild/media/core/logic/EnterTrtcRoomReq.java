package com.tencent.mobileqq.guild.media.core.logic;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007\u0012\b\b\u0002\u0010 \u001a\u00020\u0007\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0017\u0010\u000bR\u0017\u0010\u001f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b\r\u0010\u001eR\u0017\u0010 \u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001d\u001a\u0004\b\u0010\u0010\u001eR\u0017\u0010\"\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b!\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "appScene", "b", "g", "sdkAppId", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "privateMapKey", "f", "roomId", "e", tl.h.F, "userId", "i", "userSign", "role", "Z", "()Z", "autoReceiveAV", "enableTRTCPublish", "j", "isMicInactive", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.core.logic.l, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class EnterTrtcRoomReq {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int appScene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int sdkAppId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String privateMapKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String userId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String userSign;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int role;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean autoReceiveAV;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enableTRTCPublish;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isMicInactive;

    public EnterTrtcRoomReq(int i3, int i16, @NotNull String privateMapKey, @NotNull String roomId, @NotNull String userId, @NotNull String userSign, int i17, boolean z16, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(privateMapKey, "privateMapKey");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userSign, "userSign");
        this.appScene = i3;
        this.sdkAppId = i16;
        this.privateMapKey = privateMapKey;
        this.roomId = roomId;
        this.userId = userId;
        this.userSign = userSign;
        this.role = i17;
        this.autoReceiveAV = z16;
        this.enableTRTCPublish = z17;
        this.isMicInactive = z18;
    }

    /* renamed from: a, reason: from getter */
    public final int getAppScene() {
        return this.appScene;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getAutoReceiveAV() {
        return this.autoReceiveAV;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getEnableTRTCPublish() {
        return this.enableTRTCPublish;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getPrivateMapKey() {
        return this.privateMapKey;
    }

    /* renamed from: e, reason: from getter */
    public final int getRole() {
        return this.role;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterTrtcRoomReq)) {
            return false;
        }
        EnterTrtcRoomReq enterTrtcRoomReq = (EnterTrtcRoomReq) other;
        if (this.appScene == enterTrtcRoomReq.appScene && this.sdkAppId == enterTrtcRoomReq.sdkAppId && Intrinsics.areEqual(this.privateMapKey, enterTrtcRoomReq.privateMapKey) && Intrinsics.areEqual(this.roomId, enterTrtcRoomReq.roomId) && Intrinsics.areEqual(this.userId, enterTrtcRoomReq.userId) && Intrinsics.areEqual(this.userSign, enterTrtcRoomReq.userSign) && this.role == enterTrtcRoomReq.role && this.autoReceiveAV == enterTrtcRoomReq.autoReceiveAV && this.enableTRTCPublish == enterTrtcRoomReq.enableTRTCPublish && this.isMicInactive == enterTrtcRoomReq.isMicInactive) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* renamed from: g, reason: from getter */
    public final int getSdkAppId() {
        return this.sdkAppId;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((this.appScene * 31) + this.sdkAppId) * 31) + this.privateMapKey.hashCode()) * 31) + this.roomId.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.userSign.hashCode()) * 31) + this.role) * 31;
        boolean z16 = this.autoReceiveAV;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.enableTRTCPublish;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z18 = this.isMicInactive;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        return i19 + i3;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getUserSign() {
        return this.userSign;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsMicInactive() {
        return this.isMicInactive;
    }

    @NotNull
    public String toString() {
        return "EnterTrtcRoomReq(appScene=" + this.appScene + ", sdkAppId=" + this.sdkAppId + ", roomId='" + this.roomId + "', userId='" + this.userId + "', role=" + this.role + ", autoReceiveAV=" + this.autoReceiveAV + ", enableTRTCPublish=" + this.enableTRTCPublish + ", isMicInactive=" + this.isMicInactive + ")";
    }

    public /* synthetic */ EnterTrtcRoomReq(int i3, int i16, String str, String str2, String str3, String str4, int i17, boolean z16, boolean z17, boolean z18, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, str, str2, str3, str4, i17, (i18 & 128) != 0 ? true : z16, (i18 & 256) != 0 ? false : z17, (i18 & 512) != 0 ? false : z18);
    }
}
