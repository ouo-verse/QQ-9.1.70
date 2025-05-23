package com.tencent.mobileqq.tvideo.account.qqconnect;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/tvideo/account/qqconnect/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "qqUin", "b", "openId", CommonConstant.KEY_ACCESS_TOKEN, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.tvideo.account.qqconnect.b, reason: from toString */
/* loaded from: classes19.dex */
public final /* data */ class TVideoQQConnectToken {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String qqUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String openId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String accessToken;

    public TVideoQQConnectToken(@NotNull String qqUin, @NotNull String openId, @NotNull String accessToken) {
        Intrinsics.checkNotNullParameter(qqUin, "qqUin");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        this.qqUin = qqUin;
        this.openId = openId;
        this.accessToken = accessToken;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getQqUin() {
        return this.qqUin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TVideoQQConnectToken)) {
            return false;
        }
        TVideoQQConnectToken tVideoQQConnectToken = (TVideoQQConnectToken) other;
        if (Intrinsics.areEqual(this.qqUin, tVideoQQConnectToken.qqUin) && Intrinsics.areEqual(this.openId, tVideoQQConnectToken.openId) && Intrinsics.areEqual(this.accessToken, tVideoQQConnectToken.accessToken)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.qqUin.hashCode() * 31) + this.openId.hashCode()) * 31) + this.accessToken.hashCode();
    }

    @NotNull
    public String toString() {
        return "TVideoQQConnectToken(qqUin=" + this.qqUin + ", openId=" + this.openId + ", accessToken=" + this.accessToken + ")";
    }
}
