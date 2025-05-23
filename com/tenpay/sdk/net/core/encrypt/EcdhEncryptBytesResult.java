package com.tenpay.sdk.net.core.encrypt;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tenpay.sdk.net.core.encrypt.EncryptResult;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0010H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010'\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010)\u001a\u00020\u000eH\u00c6\u0003J{\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u00c6\u0001J\u0013\u0010+\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010-H\u00d6\u0003J\n\u0010.\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010/\u001a\u00020\u0010H\u0016J\t\u00100\u001a\u00020\u000bH\u00d6\u0001J\u0016\u00101\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b02H\u0016J\t\u00103\u001a\u00020\bH\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001c\u00a8\u00064"}, d2 = {"Lcom/tenpay/sdk/net/core/encrypt/EcdhEncryptBytesResult;", "Lcom/tenpay/sdk/net/core/encrypt/EncryptResult;", "encryptContent", "", "ecdhTag", "publicKey", "secretKey", "msgNo", "", "iv", TagName.ENCRYPT_TYPE, "", "uin", "isUseCache", "", "encryptStatisticInfo", "Lcom/tenpay/sdk/net/core/encrypt/EncryptResult$EncryptStatisticInfo;", "([B[B[B[BLjava/lang/String;[BILjava/lang/String;ZLcom/tenpay/sdk/net/core/encrypt/EncryptResult$EncryptStatisticInfo;)V", "getEcdhTag", "()[B", "getEncryptContent", "getEncryptStatisticInfo", "()Lcom/tenpay/sdk/net/core/encrypt/EncryptResult$EncryptStatisticInfo;", "getEncryptType", "()I", "()Z", "getIv", "getMsgNo", "()Ljava/lang/String;", "getPublicKey", "getSecretKey", "getUin", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "getEncryptText", "getStatistic", "hashCode", "toParamMap", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class EcdhEncryptBytesResult implements EncryptResult {

    @Nullable
    private final byte[] ecdhTag;

    @Nullable
    private final byte[] encryptContent;

    @NotNull
    private final EncryptResult.EncryptStatisticInfo encryptStatisticInfo;
    private final int encryptType;
    private final boolean isUseCache;

    @Nullable
    private final byte[] iv;

    @Nullable
    private final String msgNo;

    @Nullable
    private final byte[] publicKey;

    @Nullable
    private final byte[] secretKey;

    @Nullable
    private final String uin;

    public EcdhEncryptBytesResult(@Nullable byte[] bArr, @Nullable byte[] bArr2, @Nullable byte[] bArr3, @Nullable byte[] bArr4, @Nullable String str, @Nullable byte[] bArr5, int i3, @Nullable String str2, boolean z16, @NotNull EncryptResult.EncryptStatisticInfo encryptStatisticInfo) {
        Intrinsics.checkNotNullParameter(encryptStatisticInfo, "encryptStatisticInfo");
        this.encryptContent = bArr;
        this.ecdhTag = bArr2;
        this.publicKey = bArr3;
        this.secretKey = bArr4;
        this.msgNo = str;
        this.iv = bArr5;
        this.encryptType = i3;
        this.uin = str2;
        this.isUseCache = z16;
        this.encryptStatisticInfo = encryptStatisticInfo;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final byte[] getEncryptContent() {
        return this.encryptContent;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final EncryptResult.EncryptStatisticInfo getEncryptStatisticInfo() {
        return this.encryptStatisticInfo;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final byte[] getEcdhTag() {
        return this.ecdhTag;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final byte[] getPublicKey() {
        return this.publicKey;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final byte[] getSecretKey() {
        return this.secretKey;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getMsgNo() {
        return this.msgNo;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final byte[] getIv() {
        return this.iv;
    }

    /* renamed from: component7, reason: from getter */
    public final int getEncryptType() {
        return this.encryptType;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsUseCache() {
        return this.isUseCache;
    }

    @NotNull
    public final EcdhEncryptBytesResult copy(@Nullable byte[] encryptContent, @Nullable byte[] ecdhTag, @Nullable byte[] publicKey, @Nullable byte[] secretKey, @Nullable String msgNo, @Nullable byte[] iv5, int encryptType, @Nullable String uin, boolean isUseCache, @NotNull EncryptResult.EncryptStatisticInfo encryptStatisticInfo) {
        Intrinsics.checkNotNullParameter(encryptStatisticInfo, "encryptStatisticInfo");
        return new EcdhEncryptBytesResult(encryptContent, ecdhTag, publicKey, secretKey, msgNo, iv5, encryptType, uin, isUseCache, encryptStatisticInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EcdhEncryptBytesResult)) {
            return false;
        }
        EcdhEncryptBytesResult ecdhEncryptBytesResult = (EcdhEncryptBytesResult) other;
        if (Intrinsics.areEqual(this.encryptContent, ecdhEncryptBytesResult.encryptContent) && Intrinsics.areEqual(this.ecdhTag, ecdhEncryptBytesResult.ecdhTag) && Intrinsics.areEqual(this.publicKey, ecdhEncryptBytesResult.publicKey) && Intrinsics.areEqual(this.secretKey, ecdhEncryptBytesResult.secretKey) && Intrinsics.areEqual(this.msgNo, ecdhEncryptBytesResult.msgNo) && Intrinsics.areEqual(this.iv, ecdhEncryptBytesResult.iv) && this.encryptType == ecdhEncryptBytesResult.encryptType && Intrinsics.areEqual(this.uin, ecdhEncryptBytesResult.uin) && this.isUseCache == ecdhEncryptBytesResult.isUseCache && Intrinsics.areEqual(this.encryptStatisticInfo, ecdhEncryptBytesResult.encryptStatisticInfo)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final byte[] getEcdhTag() {
        return this.ecdhTag;
    }

    @Nullable
    public final byte[] getEncryptContent() {
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
        byte[] bArr = this.encryptContent;
        if (bArr != null) {
            return new String(bArr, Charsets.UTF_8);
        }
        return null;
    }

    public final int getEncryptType() {
        return this.encryptType;
    }

    @Nullable
    public final byte[] getIv() {
        return this.iv;
    }

    @Nullable
    public final String getMsgNo() {
        return this.msgNo;
    }

    @Nullable
    public final byte[] getPublicKey() {
        return this.publicKey;
    }

    @Nullable
    public final byte[] getSecretKey() {
        return this.secretKey;
    }

    @Override // com.tenpay.sdk.net.core.encrypt.EncryptResult
    @NotNull
    public EncryptResult.EncryptStatisticInfo getStatistic() {
        return this.encryptStatisticInfo;
    }

    @Nullable
    public final String getUin() {
        return this.uin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        byte[] bArr = this.encryptContent;
        int i3 = 0;
        if (bArr == null) {
            hashCode = 0;
        } else {
            hashCode = Arrays.hashCode(bArr);
        }
        int i16 = hashCode * 31;
        byte[] bArr2 = this.ecdhTag;
        if (bArr2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = Arrays.hashCode(bArr2);
        }
        int i17 = (i16 + hashCode2) * 31;
        byte[] bArr3 = this.publicKey;
        if (bArr3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = Arrays.hashCode(bArr3);
        }
        int i18 = (i17 + hashCode3) * 31;
        byte[] bArr4 = this.secretKey;
        if (bArr4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = Arrays.hashCode(bArr4);
        }
        int i19 = (i18 + hashCode4) * 31;
        String str = this.msgNo;
        if (str == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        byte[] bArr5 = this.iv;
        if (bArr5 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = Arrays.hashCode(bArr5);
        }
        int i27 = (((i26 + hashCode6) * 31) + this.encryptType) * 31;
        String str2 = this.uin;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        int i28 = (i27 + i3) * 31;
        boolean z16 = this.isUseCache;
        int i29 = z16;
        if (z16 != 0) {
            i29 = 1;
        }
        return ((i28 + i29) * 31) + this.encryptStatisticInfo.hashCode();
    }

    public final boolean isUseCache() {
        return this.isUseCache;
    }

    @Override // com.tenpay.sdk.net.core.encrypt.EncryptResult
    @NotNull
    public Map<String, String> toParamMap() {
        String str;
        Map<String, String> mutableMapOf;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("msgno", this.msgNo);
        byte[] bArr = this.ecdhTag;
        String str2 = null;
        if (bArr != null) {
            str = new String(bArr, Charsets.UTF_8);
        } else {
            str = null;
        }
        pairArr[1] = TuplesKt.to("tag", str);
        pairArr[2] = TuplesKt.to("e_type", String.valueOf(this.encryptType));
        pairArr[3] = TuplesKt.to("uin", this.uin);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (!this.isUseCache) {
            byte[] bArr2 = this.publicKey;
            if (bArr2 != null) {
                str2 = new String(bArr2, Charsets.UTF_8);
            }
            mutableMapOf.put("public_key", str2);
        }
        return mutableMapOf;
    }

    @NotNull
    public String toString() {
        return "EcdhEncryptBytesResult(encryptContent=" + Arrays.toString(this.encryptContent) + ", ecdhTag=" + Arrays.toString(this.ecdhTag) + ", publicKey=" + Arrays.toString(this.publicKey) + ", secretKey=" + Arrays.toString(this.secretKey) + ", msgNo=" + this.msgNo + ", iv=" + Arrays.toString(this.iv) + ", encryptType=" + this.encryptType + ", uin=" + this.uin + ", isUseCache=" + this.isUseCache + ", encryptStatisticInfo=" + this.encryptStatisticInfo + ")";
    }
}
