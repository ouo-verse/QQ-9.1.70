package com.tenpay.sdk.net.gateway.data;

import com.tenpay.sdk.net.core.encrypt.EncryptResult;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u00c6\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/tenpay/sdk/net/gateway/data/GatewayEncryptResult;", "", "content", "", "isEncrypt", "", "ecdhResult", "Lcom/tenpay/sdk/net/core/encrypt/EncryptResult;", "transInputInfo", "Lcom/tenpay/sdk/net/gateway/data/TransInfoInput;", "([BZLcom/tenpay/sdk/net/core/encrypt/EncryptResult;Lcom/tenpay/sdk/net/gateway/data/TransInfoInput;)V", "getContent", "()[B", "getEcdhResult", "()Lcom/tenpay/sdk/net/core/encrypt/EncryptResult;", "()Z", "getTransInputInfo", "()Lcom/tenpay/sdk/net/gateway/data/TransInfoInput;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class GatewayEncryptResult {

    @NotNull
    private final byte[] content;

    @Nullable
    private final EncryptResult ecdhResult;
    private final boolean isEncrypt;

    @Nullable
    private final TransInfoInput transInputInfo;

    public GatewayEncryptResult(@NotNull byte[] content, boolean z16, @Nullable EncryptResult encryptResult, @Nullable TransInfoInput transInfoInput) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.isEncrypt = z16;
        this.ecdhResult = encryptResult;
        this.transInputInfo = transInfoInput;
    }

    public static /* synthetic */ GatewayEncryptResult copy$default(GatewayEncryptResult gatewayEncryptResult, byte[] bArr, boolean z16, EncryptResult encryptResult, TransInfoInput transInfoInput, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bArr = gatewayEncryptResult.content;
        }
        if ((i3 & 2) != 0) {
            z16 = gatewayEncryptResult.isEncrypt;
        }
        if ((i3 & 4) != 0) {
            encryptResult = gatewayEncryptResult.ecdhResult;
        }
        if ((i3 & 8) != 0) {
            transInfoInput = gatewayEncryptResult.transInputInfo;
        }
        return gatewayEncryptResult.copy(bArr, z16, encryptResult, transInfoInput);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final byte[] getContent() {
        return this.content;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsEncrypt() {
        return this.isEncrypt;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final EncryptResult getEcdhResult() {
        return this.ecdhResult;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final TransInfoInput getTransInputInfo() {
        return this.transInputInfo;
    }

    @NotNull
    public final GatewayEncryptResult copy(@NotNull byte[] content, boolean isEncrypt, @Nullable EncryptResult ecdhResult, @Nullable TransInfoInput transInputInfo) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new GatewayEncryptResult(content, isEncrypt, ecdhResult, transInputInfo);
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(GatewayEncryptResult.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tenpay.sdk.net.gateway.data.GatewayEncryptResult");
        GatewayEncryptResult gatewayEncryptResult = (GatewayEncryptResult) other;
        if (Arrays.equals(this.content, gatewayEncryptResult.content) && Intrinsics.areEqual(this.ecdhResult, gatewayEncryptResult.ecdhResult)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final byte[] getContent() {
        return this.content;
    }

    @Nullable
    public final EncryptResult getEcdhResult() {
        return this.ecdhResult;
    }

    @Nullable
    public final TransInfoInput getTransInputInfo() {
        return this.transInputInfo;
    }

    public int hashCode() {
        int i3;
        int hashCode = Arrays.hashCode(this.content) * 31;
        EncryptResult encryptResult = this.ecdhResult;
        if (encryptResult != null) {
            i3 = encryptResult.hashCode();
        } else {
            i3 = 0;
        }
        return hashCode + i3;
    }

    public final boolean isEncrypt() {
        return this.isEncrypt;
    }

    @NotNull
    public String toString() {
        return "GatewayEncryptResult(content=" + Arrays.toString(this.content) + ", isEncrypt=" + this.isEncrypt + ", ecdhResult=" + this.ecdhResult + ", transInputInfo=" + this.transInputInfo + ")";
    }

    public /* synthetic */ GatewayEncryptResult(byte[] bArr, boolean z16, EncryptResult encryptResult, TransInfoInput transInfoInput, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? null : encryptResult, (i3 & 8) != 0 ? null : transInfoInput);
    }
}
