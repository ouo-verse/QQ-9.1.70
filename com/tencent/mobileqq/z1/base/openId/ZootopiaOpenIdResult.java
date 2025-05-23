package com.tencent.mobileqq.z1.base.openId;

import androidx.fragment.app.a;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "Ljava/io/Serializable;", "uin", "", "openId", CommonConstant.KEY_ACCESS_TOKEN, "payToken", "expiredTime", "", "recordTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getAccessToken", "()Ljava/lang/String;", "getExpiredTime", "()J", "getOpenId", "getPayToken", "getRecordTime", "getUin", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class ZootopiaOpenIdResult implements Serializable {

    @NotNull
    private final String accessToken;
    private final long expiredTime;

    @NotNull
    private final String openId;

    @NotNull
    private final String payToken;
    private final long recordTime;

    @NotNull
    private final String uin;

    public ZootopiaOpenIdResult(@NotNull String uin, @NotNull String openId, @NotNull String accessToken, @NotNull String payToken, long j3, long j16) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(payToken, "payToken");
        this.uin = uin;
        this.openId = openId;
        this.accessToken = accessToken;
        this.payToken = payToken;
        this.expiredTime = j3;
        this.recordTime = j16;
    }

    public static /* synthetic */ ZootopiaOpenIdResult copy$default(ZootopiaOpenIdResult zootopiaOpenIdResult, String str, String str2, String str3, String str4, long j3, long j16, int i3, Object obj) {
        String str5;
        String str6;
        String str7;
        String str8;
        long j17;
        long j18;
        if ((i3 & 1) != 0) {
            str5 = zootopiaOpenIdResult.uin;
        } else {
            str5 = str;
        }
        if ((i3 & 2) != 0) {
            str6 = zootopiaOpenIdResult.openId;
        } else {
            str6 = str2;
        }
        if ((i3 & 4) != 0) {
            str7 = zootopiaOpenIdResult.accessToken;
        } else {
            str7 = str3;
        }
        if ((i3 & 8) != 0) {
            str8 = zootopiaOpenIdResult.payToken;
        } else {
            str8 = str4;
        }
        if ((i3 & 16) != 0) {
            j17 = zootopiaOpenIdResult.expiredTime;
        } else {
            j17 = j3;
        }
        if ((i3 & 32) != 0) {
            j18 = zootopiaOpenIdResult.recordTime;
        } else {
            j18 = j16;
        }
        return zootopiaOpenIdResult.copy(str5, str6, str7, str8, j17, j18);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getPayToken() {
        return this.payToken;
    }

    /* renamed from: component5, reason: from getter */
    public final long getExpiredTime() {
        return this.expiredTime;
    }

    /* renamed from: component6, reason: from getter */
    public final long getRecordTime() {
        return this.recordTime;
    }

    @NotNull
    public final ZootopiaOpenIdResult copy(@NotNull String uin, @NotNull String openId, @NotNull String accessToken, @NotNull String payToken, long expiredTime, long recordTime) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(payToken, "payToken");
        return new ZootopiaOpenIdResult(uin, openId, accessToken, payToken, expiredTime, recordTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaOpenIdResult)) {
            return false;
        }
        ZootopiaOpenIdResult zootopiaOpenIdResult = (ZootopiaOpenIdResult) other;
        if (Intrinsics.areEqual(this.uin, zootopiaOpenIdResult.uin) && Intrinsics.areEqual(this.openId, zootopiaOpenIdResult.openId) && Intrinsics.areEqual(this.accessToken, zootopiaOpenIdResult.accessToken) && Intrinsics.areEqual(this.payToken, zootopiaOpenIdResult.payToken) && this.expiredTime == zootopiaOpenIdResult.expiredTime && this.recordTime == zootopiaOpenIdResult.recordTime) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    public final long getExpiredTime() {
        return this.expiredTime;
    }

    @NotNull
    public final String getOpenId() {
        return this.openId;
    }

    @NotNull
    public final String getPayToken() {
        return this.payToken;
    }

    public final long getRecordTime() {
        return this.recordTime;
    }

    @NotNull
    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        return (((((((((this.uin.hashCode() * 31) + this.openId.hashCode()) * 31) + this.accessToken.hashCode()) * 31) + this.payToken.hashCode()) * 31) + a.a(this.expiredTime)) * 31) + a.a(this.recordTime);
    }

    @NotNull
    public String toString() {
        return "ZootopiaOpenIdResult(uin=" + this.uin + ", openId=" + this.openId + ", accessToken=" + this.accessToken + ", payToken=" + this.payToken + ", expiredTime=" + this.expiredTime + ", recordTime=" + this.recordTime + ')';
    }
}
