package com.tencent.mobileqq.profilecard.data;

import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\u0014J\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010.\u001a\u00020\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\u00ad\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u00d6\u0003J\t\u0010;\u001a\u00020\u0003H\u00d6\u0001J\t\u0010<\u001a\u00020\tH\u00d6\u0001R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/profilecard/data/ProfileMetaFarmBean;", "Lcom/tencent/mobileqq/profilecard/entity/IProfileBusinessInfo;", "gender", "", "uid", "", "farmLevel", "status", "farmLevelIconUrl", "", "statusIcon", "statusDesc", "cropStatus", "animalStatus", "fishStatus", "machineStatus", "cropIconUrl", "animalIconUrl", "fishIconUrl", "machineIconUrl", "(IJIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnimalIconUrl", "()Ljava/lang/String;", "getAnimalStatus", "()I", "getCropIconUrl", "getCropStatus", "getFarmLevel", "getFarmLevelIconUrl", "getFishIconUrl", "getFishStatus", "getGender", "getMachineIconUrl", "getMachineStatus", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "getStatusDesc", "getStatusIcon", "getUid", "()J", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class ProfileMetaFarmBean implements IProfileBusinessInfo {
    private final String animalIconUrl;
    private final int animalStatus;
    private final String cropIconUrl;
    private final int cropStatus;
    private final int farmLevel;
    private final String farmLevelIconUrl;
    private final String fishIconUrl;
    private final int fishStatus;
    private final int gender;
    private final String machineIconUrl;
    private final int machineStatus;
    private final int status;
    private final String statusDesc;
    private final String statusIcon;
    private final long uid;

    public ProfileMetaFarmBean(int i3, long j3, int i16, int i17, String str, String str2, String str3, int i18, int i19, int i26, int i27, String str4, String str5, String str6, String str7) {
        this.gender = i3;
        this.uid = j3;
        this.farmLevel = i16;
        this.status = i17;
        this.farmLevelIconUrl = str;
        this.statusIcon = str2;
        this.statusDesc = str3;
        this.cropStatus = i18;
        this.animalStatus = i19;
        this.fishStatus = i26;
        this.machineStatus = i27;
        this.cropIconUrl = str4;
        this.animalIconUrl = str5;
        this.fishIconUrl = str6;
        this.machineIconUrl = str7;
    }

    /* renamed from: component1, reason: from getter */
    public final int getGender() {
        return this.gender;
    }

    /* renamed from: component10, reason: from getter */
    public final int getFishStatus() {
        return this.fishStatus;
    }

    /* renamed from: component11, reason: from getter */
    public final int getMachineStatus() {
        return this.machineStatus;
    }

    /* renamed from: component12, reason: from getter */
    public final String getCropIconUrl() {
        return this.cropIconUrl;
    }

    /* renamed from: component13, reason: from getter */
    public final String getAnimalIconUrl() {
        return this.animalIconUrl;
    }

    /* renamed from: component14, reason: from getter */
    public final String getFishIconUrl() {
        return this.fishIconUrl;
    }

    /* renamed from: component15, reason: from getter */
    public final String getMachineIconUrl() {
        return this.machineIconUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final long getUid() {
        return this.uid;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFarmLevel() {
        return this.farmLevel;
    }

    /* renamed from: component4, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFarmLevelIconUrl() {
        return this.farmLevelIconUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final String getStatusIcon() {
        return this.statusIcon;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStatusDesc() {
        return this.statusDesc;
    }

    /* renamed from: component8, reason: from getter */
    public final int getCropStatus() {
        return this.cropStatus;
    }

    /* renamed from: component9, reason: from getter */
    public final int getAnimalStatus() {
        return this.animalStatus;
    }

    public final ProfileMetaFarmBean copy(int gender, long uid, int farmLevel, int status, String farmLevelIconUrl, String statusIcon, String statusDesc, int cropStatus, int animalStatus, int fishStatus, int machineStatus, String cropIconUrl, String animalIconUrl, String fishIconUrl, String machineIconUrl) {
        return new ProfileMetaFarmBean(gender, uid, farmLevel, status, farmLevelIconUrl, statusIcon, statusDesc, cropStatus, animalStatus, fishStatus, machineStatus, cropIconUrl, animalIconUrl, fishIconUrl, machineIconUrl);
    }

    public final String getAnimalIconUrl() {
        return this.animalIconUrl;
    }

    public final int getAnimalStatus() {
        return this.animalStatus;
    }

    public final String getCropIconUrl() {
        return this.cropIconUrl;
    }

    public final int getCropStatus() {
        return this.cropStatus;
    }

    public final int getFarmLevel() {
        return this.farmLevel;
    }

    public final String getFarmLevelIconUrl() {
        return this.farmLevelIconUrl;
    }

    public final String getFishIconUrl() {
        return this.fishIconUrl;
    }

    public final int getFishStatus() {
        return this.fishStatus;
    }

    public final int getGender() {
        return this.gender;
    }

    public final String getMachineIconUrl() {
        return this.machineIconUrl;
    }

    public final int getMachineStatus() {
        return this.machineStatus;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getStatusDesc() {
        return this.statusDesc;
    }

    public final String getStatusIcon() {
        return this.statusIcon;
    }

    public final long getUid() {
        return this.uid;
    }

    public int hashCode() {
        int a16 = ((((((this.gender * 31) + a.a(this.uid)) * 31) + this.farmLevel) * 31) + this.status) * 31;
        String str = this.farmLevelIconUrl;
        int hashCode = (a16 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.statusIcon;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.statusDesc;
        int hashCode3 = (((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.cropStatus) * 31) + this.animalStatus) * 31) + this.fishStatus) * 31) + this.machineStatus) * 31;
        String str4 = this.cropIconUrl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.animalIconUrl;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.fishIconUrl;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.machineIconUrl;
        return hashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "ProfileMetaFarmBean(gender=" + this.gender + ", uid=" + this.uid + ", farmLevel=" + this.farmLevel + ", status=" + this.status + ", farmLevelIconUrl=" + this.farmLevelIconUrl + ", statusIcon=" + this.statusIcon + ", statusDesc=" + this.statusDesc + ", cropStatus=" + this.cropStatus + ", animalStatus=" + this.animalStatus + ", fishStatus=" + this.fishStatus + ", machineStatus=" + this.machineStatus + ", cropIconUrl=" + this.cropIconUrl + ", animalIconUrl=" + this.animalIconUrl + ", fishIconUrl=" + this.fishIconUrl + ", machineIconUrl=" + this.machineIconUrl + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfileMetaFarmBean)) {
            return false;
        }
        ProfileMetaFarmBean profileMetaFarmBean = (ProfileMetaFarmBean) other;
        return this.gender == profileMetaFarmBean.gender && this.uid == profileMetaFarmBean.uid && this.farmLevel == profileMetaFarmBean.farmLevel && this.status == profileMetaFarmBean.status && Intrinsics.areEqual(this.farmLevelIconUrl, profileMetaFarmBean.farmLevelIconUrl) && Intrinsics.areEqual(this.statusIcon, profileMetaFarmBean.statusIcon) && Intrinsics.areEqual(this.statusDesc, profileMetaFarmBean.statusDesc) && this.cropStatus == profileMetaFarmBean.cropStatus && this.animalStatus == profileMetaFarmBean.animalStatus && this.fishStatus == profileMetaFarmBean.fishStatus && this.machineStatus == profileMetaFarmBean.machineStatus && Intrinsics.areEqual(this.cropIconUrl, profileMetaFarmBean.cropIconUrl) && Intrinsics.areEqual(this.animalIconUrl, profileMetaFarmBean.animalIconUrl) && Intrinsics.areEqual(this.fishIconUrl, profileMetaFarmBean.fishIconUrl) && Intrinsics.areEqual(this.machineIconUrl, profileMetaFarmBean.machineIconUrl);
    }

    public /* synthetic */ ProfileMetaFarmBean(int i3, long j3, int i16, int i17, String str, String str2, String str3, int i18, int i19, int i26, int i27, String str4, String str5, String str6, String str7, int i28, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, j3, i16, i17, (i28 & 16) != 0 ? "" : str, (i28 & 32) != 0 ? "" : str2, (i28 & 64) != 0 ? "" : str3, i18, i19, i26, i27, (i28 & 2048) != 0 ? "" : str4, (i28 & 4096) != 0 ? "" : str5, (i28 & 8192) != 0 ? "" : str6, (i28 & 16384) != 0 ? "" : str7);
    }
}
