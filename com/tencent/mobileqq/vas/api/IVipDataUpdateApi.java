package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0002\b\tJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVipDataUpdateApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "requestAvatarPendantInfoChanged", "", "uin", "", "callback", "Lcom/tencent/mobileqq/vas/api/IVipDataUpdateApi$RequestResultCallback;", "AvatarPendantInfo", "RequestResultCallback", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVipDataUpdateApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVipDataUpdateApi$AvatarPendantInfo;", "", "avatarId", "", "pendantId", "", "pendantDiyId", "(IJI)V", "getAvatarId", "()I", "getPendantDiyId", "getPendantId", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final /* data */ class AvatarPendantInfo {
        private final int avatarId;
        private final int pendantDiyId;
        private final long pendantId;

        public AvatarPendantInfo(int i3, long j3, int i16) {
            this.avatarId = i3;
            this.pendantId = j3;
            this.pendantDiyId = i16;
        }

        public static /* synthetic */ AvatarPendantInfo copy$default(AvatarPendantInfo avatarPendantInfo, int i3, long j3, int i16, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                i3 = avatarPendantInfo.avatarId;
            }
            if ((i17 & 2) != 0) {
                j3 = avatarPendantInfo.pendantId;
            }
            if ((i17 & 4) != 0) {
                i16 = avatarPendantInfo.pendantDiyId;
            }
            return avatarPendantInfo.copy(i3, j3, i16);
        }

        /* renamed from: component1, reason: from getter */
        public final int getAvatarId() {
            return this.avatarId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getPendantId() {
            return this.pendantId;
        }

        /* renamed from: component3, reason: from getter */
        public final int getPendantDiyId() {
            return this.pendantDiyId;
        }

        @NotNull
        public final AvatarPendantInfo copy(int avatarId, long pendantId, int pendantDiyId) {
            return new AvatarPendantInfo(avatarId, pendantId, pendantDiyId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvatarPendantInfo)) {
                return false;
            }
            AvatarPendantInfo avatarPendantInfo = (AvatarPendantInfo) other;
            if (this.avatarId == avatarPendantInfo.avatarId && this.pendantId == avatarPendantInfo.pendantId && this.pendantDiyId == avatarPendantInfo.pendantDiyId) {
                return true;
            }
            return false;
        }

        public final int getAvatarId() {
            return this.avatarId;
        }

        public final int getPendantDiyId() {
            return this.pendantDiyId;
        }

        public final long getPendantId() {
            return this.pendantId;
        }

        public int hashCode() {
            return (((this.avatarId * 31) + androidx.fragment.app.a.a(this.pendantId)) * 31) + this.pendantDiyId;
        }

        @NotNull
        public String toString() {
            return "AvatarPendantInfo(avatarId=" + this.avatarId + ", pendantId=" + this.pendantId + ", pendantDiyId=" + this.pendantDiyId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVipDataUpdateApi$RequestResultCallback;", "", "callback", "", "info", "Lcom/tencent/mobileqq/vas/api/IVipDataUpdateApi$AvatarPendantInfo;", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public interface RequestResultCallback {
        void callback(@NotNull AvatarPendantInfo info);
    }

    void requestAvatarPendantInfoChanged(@NotNull String uin, @NotNull RequestResultCallback callback);
}
