package com.tenpay.sdk.net.core.encrypt;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tenpay.sdk.net.core.encrypt.EncryptResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u000fH\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\nH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010'\u001a\u00020\rH\u00c6\u0003J{\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u00c6\u0001J\u0013\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010+H\u00d6\u0003J\n\u0010,\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\t\u0010.\u001a\u00020\nH\u00d6\u0001J\u0016\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000300H\u0016J\t\u00101\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012\u00a8\u00062"}, d2 = {"Lcom/tenpay/sdk/net/core/encrypt/EcdhEncryptResult;", "Lcom/tenpay/sdk/net/core/encrypt/EncryptResult;", "encryptContent", "", "ecdhTag", "publicKey", "secretKey", "msgNo", "iv", TagName.ENCRYPT_TYPE, "", "uin", "isUseCache", "", "encryptStatisticInfo", "Lcom/tenpay/sdk/net/core/encrypt/EncryptResult$EncryptStatisticInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLcom/tenpay/sdk/net/core/encrypt/EncryptResult$EncryptStatisticInfo;)V", "getEcdhTag", "()Ljava/lang/String;", "getEncryptContent", "getEncryptStatisticInfo", "()Lcom/tenpay/sdk/net/core/encrypt/EncryptResult$EncryptStatisticInfo;", "getEncryptType", "()I", "()Z", "getIv", "getMsgNo", "getPublicKey", "getSecretKey", "getUin", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "getEncryptText", "getStatistic", "hashCode", "toParamMap", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class EcdhEncryptResult implements EncryptResult {

    @Nullable
    private final String ecdhTag;

    @Nullable
    private final String encryptContent;

    @NotNull
    private final EncryptResult.EncryptStatisticInfo encryptStatisticInfo;
    private final int encryptType;
    private final boolean isUseCache;

    @Nullable
    private final String iv;

    @Nullable
    private final String msgNo;

    @Nullable
    private final String publicKey;

    @Nullable
    private final String secretKey;

    @Nullable
    private final String uin;

    public EcdhEncryptResult(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, int i3, @Nullable String str7, boolean z16, @NotNull EncryptResult.EncryptStatisticInfo encryptStatisticInfo) {
        Intrinsics.checkNotNullParameter(encryptStatisticInfo, "encryptStatisticInfo");
        this.encryptContent = str;
        this.ecdhTag = str2;
        this.publicKey = str3;
        this.secretKey = str4;
        this.msgNo = str5;
        this.iv = str6;
        this.encryptType = i3;
        this.uin = str7;
        this.isUseCache = z16;
        this.encryptStatisticInfo = encryptStatisticInfo;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getEncryptContent() {
        return this.encryptContent;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final EncryptResult.EncryptStatisticInfo getEncryptStatisticInfo() {
        return this.encryptStatisticInfo;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getEcdhTag() {
        return this.ecdhTag;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getPublicKey() {
        return this.publicKey;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getSecretKey() {
        return this.secretKey;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getMsgNo() {
        return this.msgNo;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getIv() {
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
    public final EcdhEncryptResult copy(@Nullable String encryptContent, @Nullable String ecdhTag, @Nullable String publicKey, @Nullable String secretKey, @Nullable String msgNo, @Nullable String iv5, int encryptType, @Nullable String uin, boolean isUseCache, @NotNull EncryptResult.EncryptStatisticInfo encryptStatisticInfo) {
        Intrinsics.checkNotNullParameter(encryptStatisticInfo, "encryptStatisticInfo");
        return new EcdhEncryptResult(encryptContent, ecdhTag, publicKey, secretKey, msgNo, iv5, encryptType, uin, isUseCache, encryptStatisticInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EcdhEncryptResult)) {
            return false;
        }
        EcdhEncryptResult ecdhEncryptResult = (EcdhEncryptResult) other;
        if (Intrinsics.areEqual(this.encryptContent, ecdhEncryptResult.encryptContent) && Intrinsics.areEqual(this.ecdhTag, ecdhEncryptResult.ecdhTag) && Intrinsics.areEqual(this.publicKey, ecdhEncryptResult.publicKey) && Intrinsics.areEqual(this.secretKey, ecdhEncryptResult.secretKey) && Intrinsics.areEqual(this.msgNo, ecdhEncryptResult.msgNo) && Intrinsics.areEqual(this.iv, ecdhEncryptResult.iv) && this.encryptType == ecdhEncryptResult.encryptType && Intrinsics.areEqual(this.uin, ecdhEncryptResult.uin) && this.isUseCache == ecdhEncryptResult.isUseCache && Intrinsics.areEqual(this.encryptStatisticInfo, ecdhEncryptResult.encryptStatisticInfo)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getEcdhTag() {
        return this.ecdhTag;
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

    public final int getEncryptType() {
        return this.encryptType;
    }

    @Nullable
    public final String getIv() {
        return this.iv;
    }

    @Nullable
    public final String getMsgNo() {
        return this.msgNo;
    }

    @Nullable
    public final String getPublicKey() {
        return this.publicKey;
    }

    @Nullable
    public final String getSecretKey() {
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
        String str = this.encryptContent;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.ecdhTag;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.publicKey;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.secretKey;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str5 = this.msgNo;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str6 = this.iv;
        if (str6 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str6.hashCode();
        }
        int i27 = (((i26 + hashCode6) * 31) + this.encryptType) * 31;
        String str7 = this.uin;
        if (str7 != null) {
            i3 = str7.hashCode();
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
        Map<String, String> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("msgno", this.msgNo), TuplesKt.to("tag", this.ecdhTag), TuplesKt.to("e_type", String.valueOf(this.encryptType)), TuplesKt.to("uin", this.uin));
        if (!this.isUseCache) {
            mutableMapOf.put("public_key", this.publicKey);
        }
        return mutableMapOf;
    }

    @NotNull
    public String toString() {
        return "EcdhEncryptResult(encryptContent=" + this.encryptContent + ", ecdhTag=" + this.ecdhTag + ", publicKey=" + this.publicKey + ", secretKey=" + this.secretKey + ", msgNo=" + this.msgNo + ", iv=" + this.iv + ", encryptType=" + this.encryptType + ", uin=" + this.uin + ", isUseCache=" + this.isUseCache + ", encryptStatisticInfo=" + this.encryptStatisticInfo + ")";
    }
}
