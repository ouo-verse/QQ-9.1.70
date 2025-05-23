package com.tencent.mobileqq.z1.cloudmod.api;

import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pv4.b;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u001f\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J!\u0010\u0007\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;", "Ljava/io/Serializable;", "", "component1", "component2", VirtualAppProxy.KEY_GAME_ID, ZPlanPublishSource.FROM_SCHEME, "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "getScheme", "setScheme", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class ZPlanCloudGameInfo implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private String gameId;

    @Nullable
    private String scheme;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo$a;", "", "Lpv4/b;", "info", "Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;", "b", "", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.z1.cloudmod.api.ZPlanCloudGameInfo$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@Nullable ZPlanCloudGameInfo info) {
            String str;
            boolean z16;
            boolean z17;
            String str2 = null;
            if (info != null) {
                str = info.getGameId();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return false;
            }
            if (info != null) {
                str2 = info.getScheme();
            }
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

        @Nullable
        public final ZPlanCloudGameInfo b(@Nullable b info) {
            if (info == null) {
                return null;
            }
            return new ZPlanCloudGameInfo(info.f427575a, info.f427576b);
        }

        Companion() {
        }
    }

    public ZPlanCloudGameInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ZPlanCloudGameInfo copy$default(ZPlanCloudGameInfo zPlanCloudGameInfo, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = zPlanCloudGameInfo.gameId;
        }
        if ((i3 & 2) != 0) {
            str2 = zPlanCloudGameInfo.scheme;
        }
        return zPlanCloudGameInfo.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getGameId() {
        return this.gameId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    @NotNull
    public final ZPlanCloudGameInfo copy(@Nullable String gameId, @Nullable String scheme) {
        return new ZPlanCloudGameInfo(gameId, scheme);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanCloudGameInfo)) {
            return false;
        }
        ZPlanCloudGameInfo zPlanCloudGameInfo = (ZPlanCloudGameInfo) other;
        if (Intrinsics.areEqual(this.gameId, zPlanCloudGameInfo.gameId) && Intrinsics.areEqual(this.scheme, zPlanCloudGameInfo.scheme)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getGameId() {
        return this.gameId;
    }

    @Nullable
    public final String getScheme() {
        return this.scheme;
    }

    public int hashCode() {
        int hashCode;
        String str = this.gameId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.scheme;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i16 + i3;
    }

    public final void setGameId(@Nullable String str) {
        this.gameId = str;
    }

    public final void setScheme(@Nullable String str) {
        this.scheme = str;
    }

    @NotNull
    public String toString() {
        return "ZPlanCloudGameInfo(gameId=" + this.gameId + ", scheme=" + this.scheme + ')';
    }

    public ZPlanCloudGameInfo(@Nullable String str, @Nullable String str2) {
        this.gameId = str;
        this.scheme = str2;
    }

    public /* synthetic */ ZPlanCloudGameInfo(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2);
    }
}
