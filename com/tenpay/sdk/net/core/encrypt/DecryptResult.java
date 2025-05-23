package com.tenpay.sdk.net.core.encrypt;

import androidx.fragment.app.a;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tenpay.sdk.net.core.encrypt.PayEncryptUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/tenpay/sdk/net/core/encrypt/DecryptResult;", "", TagName.ENCRYPT_TYPE, "Lcom/tenpay/sdk/net/core/encrypt/PayEncryptUtils$EncryptType;", "errorCode", "", "decodedPlain", "", "decodeCostTime", "", "(Lcom/tenpay/sdk/net/core/encrypt/PayEncryptUtils$EncryptType;ILjava/lang/String;J)V", "getDecodeCostTime", "()J", "getDecodedPlain", "()Ljava/lang/String;", "getEncryptType", "()Lcom/tenpay/sdk/net/core/encrypt/PayEncryptUtils$EncryptType;", "getErrorCode", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class DecryptResult {
    private final long decodeCostTime;

    @Nullable
    private final String decodedPlain;

    @NotNull
    private final PayEncryptUtils.EncryptType encryptType;
    private final int errorCode;

    public DecryptResult(@NotNull PayEncryptUtils.EncryptType encryptType, int i3, @Nullable String str, long j3) {
        Intrinsics.checkNotNullParameter(encryptType, "encryptType");
        this.encryptType = encryptType;
        this.errorCode = i3;
        this.decodedPlain = str;
        this.decodeCostTime = j3;
    }

    public static /* synthetic */ DecryptResult copy$default(DecryptResult decryptResult, PayEncryptUtils.EncryptType encryptType, int i3, String str, long j3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            encryptType = decryptResult.encryptType;
        }
        if ((i16 & 2) != 0) {
            i3 = decryptResult.errorCode;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            str = decryptResult.decodedPlain;
        }
        String str2 = str;
        if ((i16 & 8) != 0) {
            j3 = decryptResult.decodeCostTime;
        }
        return decryptResult.copy(encryptType, i17, str2, j3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final PayEncryptUtils.EncryptType getEncryptType() {
        return this.encryptType;
    }

    /* renamed from: component2, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getDecodedPlain() {
        return this.decodedPlain;
    }

    /* renamed from: component4, reason: from getter */
    public final long getDecodeCostTime() {
        return this.decodeCostTime;
    }

    @NotNull
    public final DecryptResult copy(@NotNull PayEncryptUtils.EncryptType encryptType, int errorCode, @Nullable String decodedPlain, long decodeCostTime) {
        Intrinsics.checkNotNullParameter(encryptType, "encryptType");
        return new DecryptResult(encryptType, errorCode, decodedPlain, decodeCostTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DecryptResult)) {
            return false;
        }
        DecryptResult decryptResult = (DecryptResult) other;
        if (this.encryptType == decryptResult.encryptType && this.errorCode == decryptResult.errorCode && Intrinsics.areEqual(this.decodedPlain, decryptResult.decodedPlain) && this.decodeCostTime == decryptResult.decodeCostTime) {
            return true;
        }
        return false;
    }

    public final long getDecodeCostTime() {
        return this.decodeCostTime;
    }

    @Nullable
    public final String getDecodedPlain() {
        return this.decodedPlain;
    }

    @NotNull
    public final PayEncryptUtils.EncryptType getEncryptType() {
        return this.encryptType;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.encryptType.hashCode() * 31) + this.errorCode) * 31;
        String str = this.decodedPlain;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + a.a(this.decodeCostTime);
    }

    @NotNull
    public String toString() {
        return "DecryptResult(encryptType=" + this.encryptType + ", errorCode=" + this.errorCode + ", decodedPlain=" + this.decodedPlain + ", decodeCostTime=" + this.decodeCostTime + ")";
    }
}
