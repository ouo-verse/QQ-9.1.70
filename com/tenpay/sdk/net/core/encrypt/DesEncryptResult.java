package com.tenpay.sdk.net.core.encrypt;

import com.tenpay.sdk.net.core.encrypt.EncryptResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\u0016\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u001c"}, d2 = {"Lcom/tenpay/sdk/net/core/encrypt/DesEncryptResult;", "Lcom/tenpay/sdk/net/core/encrypt/EncryptResult;", "encryptContent", "", "msgNo", "encryptStatisticInfo", "Lcom/tenpay/sdk/net/core/encrypt/EncryptResult$EncryptStatisticInfo;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tenpay/sdk/net/core/encrypt/EncryptResult$EncryptStatisticInfo;)V", "getEncryptContent", "()Ljava/lang/String;", "getEncryptStatisticInfo", "()Lcom/tenpay/sdk/net/core/encrypt/EncryptResult$EncryptStatisticInfo;", "getMsgNo", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getEncryptText", "getStatistic", "hashCode", "", "toParamMap", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class DesEncryptResult implements EncryptResult {

    @Nullable
    private final String encryptContent;

    @NotNull
    private final EncryptResult.EncryptStatisticInfo encryptStatisticInfo;

    @Nullable
    private final String msgNo;

    public DesEncryptResult(@Nullable String str, @Nullable String str2, @NotNull EncryptResult.EncryptStatisticInfo encryptStatisticInfo) {
        Intrinsics.checkNotNullParameter(encryptStatisticInfo, "encryptStatisticInfo");
        this.encryptContent = str;
        this.msgNo = str2;
        this.encryptStatisticInfo = encryptStatisticInfo;
    }

    public static /* synthetic */ DesEncryptResult copy$default(DesEncryptResult desEncryptResult, String str, String str2, EncryptResult.EncryptStatisticInfo encryptStatisticInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = desEncryptResult.encryptContent;
        }
        if ((i3 & 2) != 0) {
            str2 = desEncryptResult.msgNo;
        }
        if ((i3 & 4) != 0) {
            encryptStatisticInfo = desEncryptResult.encryptStatisticInfo;
        }
        return desEncryptResult.copy(str, str2, encryptStatisticInfo);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getEncryptContent() {
        return this.encryptContent;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getMsgNo() {
        return this.msgNo;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final EncryptResult.EncryptStatisticInfo getEncryptStatisticInfo() {
        return this.encryptStatisticInfo;
    }

    @NotNull
    public final DesEncryptResult copy(@Nullable String encryptContent, @Nullable String msgNo, @NotNull EncryptResult.EncryptStatisticInfo encryptStatisticInfo) {
        Intrinsics.checkNotNullParameter(encryptStatisticInfo, "encryptStatisticInfo");
        return new DesEncryptResult(encryptContent, msgNo, encryptStatisticInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DesEncryptResult)) {
            return false;
        }
        DesEncryptResult desEncryptResult = (DesEncryptResult) other;
        if (Intrinsics.areEqual(this.encryptContent, desEncryptResult.encryptContent) && Intrinsics.areEqual(this.msgNo, desEncryptResult.msgNo) && Intrinsics.areEqual(this.encryptStatisticInfo, desEncryptResult.encryptStatisticInfo)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getEncryptContent() {
        return this.encryptContent;
    }

    @NotNull
    public final EncryptResult.EncryptStatisticInfo getEncryptStatisticInfo() {
        return this.encryptStatisticInfo;
    }

    @Override // com.tenpay.sdk.net.core.encrypt.EncryptResult
    @Nullable
    /* renamed from: getEncryptText */
    public String getParamString() {
        return this.encryptContent;
    }

    @Nullable
    public final String getMsgNo() {
        return this.msgNo;
    }

    @Override // com.tenpay.sdk.net.core.encrypt.EncryptResult
    @NotNull
    public EncryptResult.EncryptStatisticInfo getStatistic() {
        return this.encryptStatisticInfo;
    }

    public int hashCode() {
        int hashCode;
        String str = this.encryptContent;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.msgNo;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((i16 + i3) * 31) + this.encryptStatisticInfo.hashCode();
    }

    @Override // com.tenpay.sdk.net.core.encrypt.EncryptResult
    @NotNull
    public Map<String, String> toParamMap() {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("msgno", this.msgNo));
        return mapOf;
    }

    @NotNull
    public String toString() {
        return "DesEncryptResult(encryptContent=" + this.encryptContent + ", msgNo=" + this.msgNo + ", encryptStatisticInfo=" + this.encryptStatisticInfo + ")";
    }
}
