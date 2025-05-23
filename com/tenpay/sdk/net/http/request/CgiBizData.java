package com.tenpay.sdk.net.http.request;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tH\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003Je\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020'H\u00d6\u0001J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0013\"\u0004\b\u0016\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000e\u00a8\u0006)"}, d2 = {"Lcom/tenpay/sdk/net/http/request/CgiBizData;", "", "uin", "", "isEncrypt", "", "isEcdhEncrypt", "psKey", WadlProxyConsts.EXTRA_DATA, "", "tokenId", "comeFrom", "(Ljava/lang/String;ZZLjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getComeFrom", "()Ljava/lang/String;", "setComeFrom", "(Ljava/lang/String;)V", "getExtraData", "()Ljava/util/Map;", "()Z", "setEcdhEncrypt", "(Z)V", "setEncrypt", "getPsKey", "setPsKey", "getTokenId", "setTokenId", "getUin", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class CgiBizData {

    @Nullable
    private String comeFrom;

    @NotNull
    private final Map<String, String> extraData;
    private boolean isEcdhEncrypt;
    private boolean isEncrypt;

    @Nullable
    private String psKey;

    @Nullable
    private String tokenId;

    @Nullable
    private final String uin;

    public CgiBizData(@Nullable String str, boolean z16, boolean z17, @Nullable String str2, @NotNull Map<String, String> extraData, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        this.uin = str;
        this.isEncrypt = z16;
        this.isEcdhEncrypt = z17;
        this.psKey = str2;
        this.extraData = extraData;
        this.tokenId = str3;
        this.comeFrom = str4;
    }

    public static /* synthetic */ CgiBizData copy$default(CgiBizData cgiBizData, String str, boolean z16, boolean z17, String str2, Map map, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = cgiBizData.uin;
        }
        if ((i3 & 2) != 0) {
            z16 = cgiBizData.isEncrypt;
        }
        boolean z18 = z16;
        if ((i3 & 4) != 0) {
            z17 = cgiBizData.isEcdhEncrypt;
        }
        boolean z19 = z17;
        if ((i3 & 8) != 0) {
            str2 = cgiBizData.psKey;
        }
        String str5 = str2;
        if ((i3 & 16) != 0) {
            map = cgiBizData.extraData;
        }
        Map map2 = map;
        if ((i3 & 32) != 0) {
            str3 = cgiBizData.tokenId;
        }
        String str6 = str3;
        if ((i3 & 64) != 0) {
            str4 = cgiBizData.comeFrom;
        }
        return cgiBizData.copy(str, z18, z19, str5, map2, str6, str4);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsEncrypt() {
        return this.isEncrypt;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsEcdhEncrypt() {
        return this.isEcdhEncrypt;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getPsKey() {
        return this.psKey;
    }

    @NotNull
    public final Map<String, String> component5() {
        return this.extraData;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getTokenId() {
        return this.tokenId;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getComeFrom() {
        return this.comeFrom;
    }

    @NotNull
    public final CgiBizData copy(@Nullable String uin, boolean isEncrypt, boolean isEcdhEncrypt, @Nullable String psKey, @NotNull Map<String, String> extraData, @Nullable String tokenId, @Nullable String comeFrom) {
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        return new CgiBizData(uin, isEncrypt, isEcdhEncrypt, psKey, extraData, tokenId, comeFrom);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CgiBizData)) {
            return false;
        }
        CgiBizData cgiBizData = (CgiBizData) other;
        if (Intrinsics.areEqual(this.uin, cgiBizData.uin) && this.isEncrypt == cgiBizData.isEncrypt && this.isEcdhEncrypt == cgiBizData.isEcdhEncrypt && Intrinsics.areEqual(this.psKey, cgiBizData.psKey) && Intrinsics.areEqual(this.extraData, cgiBizData.extraData) && Intrinsics.areEqual(this.tokenId, cgiBizData.tokenId) && Intrinsics.areEqual(this.comeFrom, cgiBizData.comeFrom)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getComeFrom() {
        return this.comeFrom;
    }

    @NotNull
    public final Map<String, String> getExtraData() {
        return this.extraData;
    }

    @Nullable
    public final String getPsKey() {
        return this.psKey;
    }

    @Nullable
    public final String getTokenId() {
        return this.tokenId;
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
        String str = this.uin;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        boolean z16 = this.isEncrypt;
        int i17 = 1;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        int i19 = (i16 + i18) * 31;
        boolean z17 = this.isEcdhEncrypt;
        if (!z17) {
            i17 = z17 ? 1 : 0;
        }
        int i26 = (i19 + i17) * 31;
        String str2 = this.psKey;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int hashCode4 = (((i26 + hashCode2) * 31) + this.extraData.hashCode()) * 31;
        String str3 = this.tokenId;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i27 = (hashCode4 + hashCode3) * 31;
        String str4 = this.comeFrom;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        return i27 + i3;
    }

    public final boolean isEcdhEncrypt() {
        return this.isEcdhEncrypt;
    }

    public final boolean isEncrypt() {
        return this.isEncrypt;
    }

    public final void setComeFrom(@Nullable String str) {
        this.comeFrom = str;
    }

    public final void setEcdhEncrypt(boolean z16) {
        this.isEcdhEncrypt = z16;
    }

    public final void setEncrypt(boolean z16) {
        this.isEncrypt = z16;
    }

    public final void setPsKey(@Nullable String str) {
        this.psKey = str;
    }

    public final void setTokenId(@Nullable String str) {
        this.tokenId = str;
    }

    @NotNull
    public String toString() {
        return "CgiBizData(uin=" + this.uin + ", isEncrypt=" + this.isEncrypt + ", isEcdhEncrypt=" + this.isEcdhEncrypt + ", psKey=" + this.psKey + ", extraData=" + this.extraData + ", tokenId=" + this.tokenId + ", comeFrom=" + this.comeFrom + ")";
    }

    public /* synthetic */ CgiBizData(String str, boolean z16, boolean z17, String str2, Map map, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? true : z16, (i3 & 4) != 0 ? false : z17, (i3 & 8) != 0 ? null : str2, map, (i3 & 32) != 0 ? "" : str3, (i3 & 64) != 0 ? "0" : str4);
    }
}
