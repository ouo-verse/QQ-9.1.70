package com.tenpay.sdk.net.core.encrypt;

import androidx.fragment.app.a;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tenpay.sdk.net.core.encrypt.PayEncryptUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tenpay/sdk/net/core/encrypt/DecryptBytesResult;", "", TagName.ENCRYPT_TYPE, "Lcom/tenpay/sdk/net/core/encrypt/PayEncryptUtils$EncryptType;", "errorCode", "", "decodedPlain", "", "decodeCostTime", "", "(Lcom/tenpay/sdk/net/core/encrypt/PayEncryptUtils$EncryptType;I[BJ)V", "getDecodeCostTime", "()J", "getDecodedPlain", "()[B", "getEncryptType", "()Lcom/tenpay/sdk/net/core/encrypt/PayEncryptUtils$EncryptType;", "getErrorCode", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class DecryptBytesResult {
    private final long decodeCostTime;

    @Nullable
    private final byte[] decodedPlain;

    @NotNull
    private final PayEncryptUtils.EncryptType encryptType;
    private final int errorCode;

    public DecryptBytesResult(@NotNull PayEncryptUtils.EncryptType encryptType, int i3, @Nullable byte[] bArr, long j3) {
        Intrinsics.checkNotNullParameter(encryptType, "encryptType");
        this.encryptType = encryptType;
        this.errorCode = i3;
        this.decodedPlain = bArr;
        this.decodeCostTime = j3;
    }

    public static /* synthetic */ DecryptBytesResult copy$default(DecryptBytesResult decryptBytesResult, PayEncryptUtils.EncryptType encryptType, int i3, byte[] bArr, long j3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            encryptType = decryptBytesResult.encryptType;
        }
        if ((i16 & 2) != 0) {
            i3 = decryptBytesResult.errorCode;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            bArr = decryptBytesResult.decodedPlain;
        }
        byte[] bArr2 = bArr;
        if ((i16 & 8) != 0) {
            j3 = decryptBytesResult.decodeCostTime;
        }
        return decryptBytesResult.copy(encryptType, i17, bArr2, j3);
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
    public final byte[] getDecodedPlain() {
        return this.decodedPlain;
    }

    /* renamed from: component4, reason: from getter */
    public final long getDecodeCostTime() {
        return this.decodeCostTime;
    }

    @NotNull
    public final DecryptBytesResult copy(@NotNull PayEncryptUtils.EncryptType encryptType, int errorCode, @Nullable byte[] decodedPlain, long decodeCostTime) {
        Intrinsics.checkNotNullParameter(encryptType, "encryptType");
        return new DecryptBytesResult(encryptType, errorCode, decodedPlain, decodeCostTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DecryptBytesResult)) {
            return false;
        }
        DecryptBytesResult decryptBytesResult = (DecryptBytesResult) other;
        if (this.encryptType == decryptBytesResult.encryptType && this.errorCode == decryptBytesResult.errorCode && Intrinsics.areEqual(this.decodedPlain, decryptBytesResult.decodedPlain) && this.decodeCostTime == decryptBytesResult.decodeCostTime) {
            return true;
        }
        return false;
    }

    public final long getDecodeCostTime() {
        return this.decodeCostTime;
    }

    @Nullable
    public final byte[] getDecodedPlain() {
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
        byte[] bArr = this.decodedPlain;
        if (bArr == null) {
            hashCode = 0;
        } else {
            hashCode = Arrays.hashCode(bArr);
        }
        return ((hashCode2 + hashCode) * 31) + a.a(this.decodeCostTime);
    }

    @NotNull
    public String toString() {
        return "DecryptBytesResult(encryptType=" + this.encryptType + ", errorCode=" + this.errorCode + ", decodedPlain=" + Arrays.toString(this.decodedPlain) + ", decodeCostTime=" + this.decodeCostTime + ")";
    }
}
