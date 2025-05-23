package com.tencent.mobileqq.profilecard.vas;

import androidx.fragment.app.a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0006H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\tH\u00c6\u0003J\t\u0010+\u001a\u00020\u0006H\u00c6\u0003J\t\u0010,\u001a\u00020\u0006H\u00c6\u0003J\t\u0010-\u001a\u00020\u0006H\u00c6\u0003J\t\u0010.\u001a\u00020\u0006H\u00c6\u0003J\u0087\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u00020\tH\u00d6\u0001J\t\u00104\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "", "lCurrentStyleId", "", "lCurrentBgId", "backgroundUrl", "", "backgroundColor", "dynamicCardFlag", "", "strZipUrl", "strActiveUrl", "strDrawerCardUrl", "strWzryHeroUrl", "wzryHonorInfo", "", "strExtInfo", "strCurrentBgUrl", "(JJLjava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()J", "getBackgroundUrl", "()Ljava/lang/String;", "getDynamicCardFlag", "()I", "getLCurrentBgId", "getLCurrentStyleId", "getStrActiveUrl", "getStrCurrentBgUrl", "getStrDrawerCardUrl", "getStrExtInfo", "getStrWzryHeroUrl", "getStrZipUrl", "getWzryHonorInfo", "()[B", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final /* data */ class VasCardData {
    private final long backgroundColor;

    @NotNull
    private final String backgroundUrl;
    private final int dynamicCardFlag;
    private final long lCurrentBgId;
    private final long lCurrentStyleId;

    @NotNull
    private final String strActiveUrl;

    @Nullable
    private final String strCurrentBgUrl;

    @NotNull
    private final String strDrawerCardUrl;

    @Nullable
    private final String strExtInfo;

    @NotNull
    private final String strWzryHeroUrl;

    @NotNull
    private final String strZipUrl;

    @Nullable
    private final byte[] wzryHonorInfo;

    public VasCardData() {
        this(0L, 0L, null, 0L, 0, null, null, null, null, null, null, null, 4095, null);
    }

    /* renamed from: component1, reason: from getter */
    public final long getLCurrentStyleId() {
        return this.lCurrentStyleId;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final byte[] getWzryHonorInfo() {
        return this.wzryHonorInfo;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getStrExtInfo() {
        return this.strExtInfo;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getStrCurrentBgUrl() {
        return this.strCurrentBgUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final long getLCurrentBgId() {
        return this.lCurrentBgId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final long getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: component5, reason: from getter */
    public final int getDynamicCardFlag() {
        return this.dynamicCardFlag;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getStrZipUrl() {
        return this.strZipUrl;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getStrActiveUrl() {
        return this.strActiveUrl;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getStrDrawerCardUrl() {
        return this.strDrawerCardUrl;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getStrWzryHeroUrl() {
        return this.strWzryHeroUrl;
    }

    @NotNull
    public final VasCardData copy(long lCurrentStyleId, long lCurrentBgId, @NotNull String backgroundUrl, long backgroundColor, int dynamicCardFlag, @NotNull String strZipUrl, @NotNull String strActiveUrl, @NotNull String strDrawerCardUrl, @NotNull String strWzryHeroUrl, @Nullable byte[] wzryHonorInfo, @Nullable String strExtInfo, @Nullable String strCurrentBgUrl) {
        Intrinsics.checkNotNullParameter(backgroundUrl, "backgroundUrl");
        Intrinsics.checkNotNullParameter(strZipUrl, "strZipUrl");
        Intrinsics.checkNotNullParameter(strActiveUrl, "strActiveUrl");
        Intrinsics.checkNotNullParameter(strDrawerCardUrl, "strDrawerCardUrl");
        Intrinsics.checkNotNullParameter(strWzryHeroUrl, "strWzryHeroUrl");
        return new VasCardData(lCurrentStyleId, lCurrentBgId, backgroundUrl, backgroundColor, dynamicCardFlag, strZipUrl, strActiveUrl, strDrawerCardUrl, strWzryHeroUrl, wzryHonorInfo, strExtInfo, strCurrentBgUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasCardData)) {
            return false;
        }
        VasCardData vasCardData = (VasCardData) other;
        if (this.lCurrentStyleId == vasCardData.lCurrentStyleId && this.lCurrentBgId == vasCardData.lCurrentBgId && Intrinsics.areEqual(this.backgroundUrl, vasCardData.backgroundUrl) && this.backgroundColor == vasCardData.backgroundColor && this.dynamicCardFlag == vasCardData.dynamicCardFlag && Intrinsics.areEqual(this.strZipUrl, vasCardData.strZipUrl) && Intrinsics.areEqual(this.strActiveUrl, vasCardData.strActiveUrl) && Intrinsics.areEqual(this.strDrawerCardUrl, vasCardData.strDrawerCardUrl) && Intrinsics.areEqual(this.strWzryHeroUrl, vasCardData.strWzryHeroUrl) && Intrinsics.areEqual(this.wzryHonorInfo, vasCardData.wzryHonorInfo) && Intrinsics.areEqual(this.strExtInfo, vasCardData.strExtInfo) && Intrinsics.areEqual(this.strCurrentBgUrl, vasCardData.strCurrentBgUrl)) {
            return true;
        }
        return false;
    }

    public final long getBackgroundColor() {
        return this.backgroundColor;
    }

    @NotNull
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public final int getDynamicCardFlag() {
        return this.dynamicCardFlag;
    }

    public final long getLCurrentBgId() {
        return this.lCurrentBgId;
    }

    public final long getLCurrentStyleId() {
        return this.lCurrentStyleId;
    }

    @NotNull
    public final String getStrActiveUrl() {
        return this.strActiveUrl;
    }

    @Nullable
    public final String getStrCurrentBgUrl() {
        return this.strCurrentBgUrl;
    }

    @NotNull
    public final String getStrDrawerCardUrl() {
        return this.strDrawerCardUrl;
    }

    @Nullable
    public final String getStrExtInfo() {
        return this.strExtInfo;
    }

    @NotNull
    public final String getStrWzryHeroUrl() {
        return this.strWzryHeroUrl;
    }

    @NotNull
    public final String getStrZipUrl() {
        return this.strZipUrl;
    }

    @Nullable
    public final byte[] getWzryHonorInfo() {
        return this.wzryHonorInfo;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int a16 = ((((((((((((((((a.a(this.lCurrentStyleId) * 31) + a.a(this.lCurrentBgId)) * 31) + this.backgroundUrl.hashCode()) * 31) + a.a(this.backgroundColor)) * 31) + this.dynamicCardFlag) * 31) + this.strZipUrl.hashCode()) * 31) + this.strActiveUrl.hashCode()) * 31) + this.strDrawerCardUrl.hashCode()) * 31) + this.strWzryHeroUrl.hashCode()) * 31;
        byte[] bArr = this.wzryHonorInfo;
        int i3 = 0;
        if (bArr == null) {
            hashCode = 0;
        } else {
            hashCode = Arrays.hashCode(bArr);
        }
        int i16 = (a16 + hashCode) * 31;
        String str = this.strExtInfo;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str2 = this.strCurrentBgUrl;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "VasCardData(lCurrentStyleId=" + this.lCurrentStyleId + ", lCurrentBgId=" + this.lCurrentBgId + ", backgroundUrl=" + this.backgroundUrl + ", backgroundColor=" + this.backgroundColor + ", dynamicCardFlag=" + this.dynamicCardFlag + ", strZipUrl=" + this.strZipUrl + ", strActiveUrl=" + this.strActiveUrl + ", strDrawerCardUrl=" + this.strDrawerCardUrl + ", strWzryHeroUrl=" + this.strWzryHeroUrl + ", wzryHonorInfo=" + Arrays.toString(this.wzryHonorInfo) + ", strExtInfo=" + this.strExtInfo + ", strCurrentBgUrl=" + this.strCurrentBgUrl + ")";
    }

    public VasCardData(long j3, long j16, @NotNull String backgroundUrl, long j17, int i3, @NotNull String strZipUrl, @NotNull String strActiveUrl, @NotNull String strDrawerCardUrl, @NotNull String strWzryHeroUrl, @Nullable byte[] bArr, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(backgroundUrl, "backgroundUrl");
        Intrinsics.checkNotNullParameter(strZipUrl, "strZipUrl");
        Intrinsics.checkNotNullParameter(strActiveUrl, "strActiveUrl");
        Intrinsics.checkNotNullParameter(strDrawerCardUrl, "strDrawerCardUrl");
        Intrinsics.checkNotNullParameter(strWzryHeroUrl, "strWzryHeroUrl");
        this.lCurrentStyleId = j3;
        this.lCurrentBgId = j16;
        this.backgroundUrl = backgroundUrl;
        this.backgroundColor = j17;
        this.dynamicCardFlag = i3;
        this.strZipUrl = strZipUrl;
        this.strActiveUrl = strActiveUrl;
        this.strDrawerCardUrl = strDrawerCardUrl;
        this.strWzryHeroUrl = strWzryHeroUrl;
        this.wzryHonorInfo = bArr;
        this.strExtInfo = str;
        this.strCurrentBgUrl = str2;
    }

    public /* synthetic */ VasCardData(long j3, long j16, String str, long j17, int i3, String str2, String str3, String str4, String str5, byte[] bArr, String str6, String str7, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1L : j3, (i16 & 2) == 0 ? j16 : -1L, (i16 & 4) != 0 ? "" : str, (i16 & 8) != 0 ? 0L : j17, (i16 & 16) != 0 ? 0 : i3, (i16 & 32) != 0 ? "" : str2, (i16 & 64) != 0 ? "" : str3, (i16 & 128) != 0 ? "" : str4, (i16 & 256) == 0 ? str5 : "", (i16 & 512) != 0 ? null : bArr, (i16 & 1024) != 0 ? null : str6, (i16 & 2048) == 0 ? str7 : null);
    }
}
