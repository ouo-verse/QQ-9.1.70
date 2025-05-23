package com.heytap.databaseengine.apiv2.auth;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/heytap/databaseengine/apiv2/auth/AuthResult;", "", "errorCode", "", "openId", "", "authCode", "ssoid", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthCode", "()Ljava/lang/String;", "getErrorCode", "()I", "getOpenId", "getSsoid", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "heytap_health_sdk_v2.1.5_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AuthResult {

    @NotNull
    private final String authCode;
    private final int errorCode;

    @NotNull
    private final String openId;

    @Nullable
    private final String ssoid;

    public AuthResult(int i3, @NotNull String openId, @NotNull String authCode, @Nullable String str) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(authCode, "authCode");
        this.errorCode = i3;
        this.openId = openId;
        this.authCode = authCode;
        this.ssoid = str;
    }

    public static /* synthetic */ AuthResult copy$default(AuthResult authResult, int i3, String str, String str2, String str3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = authResult.errorCode;
        }
        if ((i16 & 2) != 0) {
            str = authResult.openId;
        }
        if ((i16 & 4) != 0) {
            str2 = authResult.authCode;
        }
        if ((i16 & 8) != 0) {
            str3 = authResult.ssoid;
        }
        return authResult.copy(i3, str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getAuthCode() {
        return this.authCode;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getSsoid() {
        return this.ssoid;
    }

    @NotNull
    public final AuthResult copy(int errorCode, @NotNull String openId, @NotNull String authCode, @Nullable String ssoid) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(authCode, "authCode");
        return new AuthResult(errorCode, openId, authCode, ssoid);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthResult)) {
            return false;
        }
        AuthResult authResult = (AuthResult) other;
        if (this.errorCode == authResult.errorCode && Intrinsics.areEqual(this.openId, authResult.openId) && Intrinsics.areEqual(this.authCode, authResult.authCode) && Intrinsics.areEqual(this.ssoid, authResult.ssoid)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAuthCode() {
        return this.authCode;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final String getOpenId() {
        return this.openId;
    }

    @Nullable
    public final String getSsoid() {
        return this.ssoid;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.errorCode * 31) + this.openId.hashCode()) * 31) + this.authCode.hashCode()) * 31;
        String str = this.ssoid;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "AuthResult(errorCode=" + this.errorCode + ", openId='" + this.openId + "', authCode=" + this.authCode + ", ssoid='" + this.ssoid + "')";
    }
}
