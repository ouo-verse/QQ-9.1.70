package com.tencent.mobileqq.zplan.minihome;

import com.google.gson.annotations.SerializedName;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.common.utils.GsonUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B/\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/ao;", "", "", "isNightTheme", "", "default", "a", "toString", "", "hashCode", "other", "equals", "hash", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "coverUrl", "getCoverUrl", "darkCoverUrl", "getDarkCoverUrl", "roomDescJson", "c", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class ao {

    @SerializedName("coverUrl")
    @NotNull
    private final String coverUrl;

    @SerializedName("darkCoverUrl")
    @NotNull
    private final String darkCoverUrl;

    @SerializedName("hash")
    @NotNull
    private final String hash;

    @SerializedName("roomDescJson")
    @NotNull
    private final String roomDescJson;

    public ao() {
        this(null, null, null, null, 15, null);
    }

    @Nullable
    public final String a(boolean isNightTheme, @Nullable String r36) {
        String str;
        boolean z16;
        if (isNightTheme) {
            str = this.darkCoverUrl;
        } else {
            str = this.coverUrl;
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return str;
        }
        return r36;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getHash() {
        return this.hash;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getRoomDescJson() {
        return this.roomDescJson;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ao)) {
            return false;
        }
        ao aoVar = (ao) other;
        if (Intrinsics.areEqual(this.hash, aoVar.hash) && Intrinsics.areEqual(this.coverUrl, aoVar.coverUrl) && Intrinsics.areEqual(this.darkCoverUrl, aoVar.darkCoverUrl) && Intrinsics.areEqual(this.roomDescJson, aoVar.roomDescJson)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.hash.hashCode() * 31) + this.coverUrl.hashCode()) * 31) + this.darkCoverUrl.hashCode()) * 31) + this.roomDescJson.hashCode();
    }

    @NotNull
    public String toString() {
        try {
            String json = GsonUtil.f385283b.a().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "{\n            GsonUtil.gson.toJson(this)\n        }");
            return json;
        } catch (Throwable th5) {
            QLog.e("MiniHomeInfo", 1, "toString exception", th5);
            return "";
        }
    }

    public ao(@NotNull String hash, @NotNull String coverUrl, @NotNull String darkCoverUrl, @NotNull String roomDescJson) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(darkCoverUrl, "darkCoverUrl");
        Intrinsics.checkNotNullParameter(roomDescJson, "roomDescJson");
        this.hash = hash;
        this.coverUrl = coverUrl;
        this.darkCoverUrl = darkCoverUrl;
        this.roomDescJson = roomDescJson;
    }

    public /* synthetic */ ao(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4);
    }
}
